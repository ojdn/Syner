package com.tinet.zl.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tinet.zl.entity.ApiResult;
import com.tinet.zl.entity.ClidTrunk;
import com.tinet.zl.entity.CtiLinkEnterpriseHotline;
import com.tinet.zl.entity.CtiLinkEnterpriseSetting;
import com.tinet.zl.service.SynNumService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.*;

/**
 * @Author: zhang lei
 * @Describe: All things are difficult before they are easy.
 * @CreatTime: 2021-01-18-15-14
 */
@Service
@Slf4j
public class SynNumServiceimpl implements SynNumService {
    public static final String http = "http://";
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public String bossToConsoleNums(String ip, String enterpriseId, String name) {
        //调用enterpriseHotline/list,获取正确的号码集合
        String url = http+ip+"/interface/v1/enterpriseHotline/list";
        //设置参数
        Map<String,String> map = new HashMap<>();
        map.put("enterpriseId",enterpriseId);
        log.info("获取enterpriseHotline/list url:{} 参数:{}",url,JSON.toJSONString(map));
        ResponseEntity<String > result = restTemplate.postForEntity(url, map, String.class);
//        log.info("result {}",result);
        if(StringUtils.isBlank(result.getBody())){
            return "获取/interface/v1/enterpriseHotline/list接口数据为空";
        }
        ApiResult apiResult = JSONObject.parseObject(result.getBody(), ApiResult.class);

        if (apiResult.getData() == null){
            return "获取/interface/v1/enterpriseHotline/list接口data为空";
        }
//        log.info("data:{}",apiResult.getData());
        List<CtiLinkEnterpriseHotline> hotlines = JSON.parseArray(apiResult.getData().toString(),CtiLinkEnterpriseHotline.class) ;
//        log.info("hotlines:{}",hotlines);


        //调用/enterpriseSetting/get,获取console不全的号码集合
        String url1 = http+ip+"/interface/v1/enterpriseSetting/get";
        CtiLinkEnterpriseSetting setting = new CtiLinkEnterpriseSetting();
        setting.setEnterpriseId(Integer.parseInt(enterpriseId));
        setting.setName(name);
        log.info("获取enterpriseSetting/get url:{} 参数:{}",url1,JSON.toJSONString(setting));
        ResponseEntity<String> cild = restTemplate.postForEntity(url1, setting, String.class);
        if(StringUtils.isBlank(cild.getBody())){
            return "获取/interface/v1/enterpriseSetting/get接口数据为空";
        }
        ApiResult apiResult1 = JSONObject.parseObject(cild.getBody(), ApiResult.class);
        if(apiResult.getData() == null){
            return "获取/interface/v1/enterpriseSetting/get接口data为空";
        }
        CtiLinkEnterpriseSetting enterpriseSetting = JSONObject.parseObject(apiResult1.getData().toString(),CtiLinkEnterpriseSetting.class);
        if(StringUtils.isBlank(enterpriseSetting.getProperty())){
            return "获取/interface/v1/enterpriseSetting/get接口property数据为空";
        }
        List<ClidTrunk> lists = JSONObject.parseArray(enterpriseSetting.getProperty(), ClidTrunk.class);
//        log.info("lists = {}", JSON.toJSONString(lists));


        //过滤出console没有的号码集合添加到console
        Map<String ,ClidTrunk> trunkMap = new HashMap<>();
        for (ClidTrunk clidTrunk : lists) {
            //type=1,2直线热线clid号码都要加上区号
            if(trunkMap.containsKey(clidTrunk.getClid())){
                //去重,入过存在相同的号码,不管type或者其他属性是否不同都跳过当前循环
                continue;
            }
            trunkMap.put(clidTrunk.getClid(),clidTrunk);
        }
        String key = null;
        boolean b = false;
        List<ClidTrunk> clidTrunks = new ArrayList<>();
        //遍历多的集合,收集少的集合到map,取出多余的数据到clidTruck放到list里更新enterpriseSetting
        for (CtiLinkEnterpriseHotline hotline : hotlines) {
            if(hotline.getType() == 1 || hotline.getType() == 2){
                //热线和直线都加上区号
                key = hotline.getAreaCode()+hotline.getNumberTrunk();
            }else{
                key = hotline.getNumberTrunk();
            }
            if (!trunkMap.containsKey(key)){
                ClidTrunk trunk = new ClidTrunk();
                trunk.setAreaCode(hotline.getAreaCode());
                trunk.setActive(1);
                trunk.setIsAxbA(0);
                trunk.setType(hotline.getType());
                trunk.setCreateTime(new Date());
                trunk.setHotline(key);
                trunk.setTrunkGroup(hotline.getTrunkGroup());
                trunk.setTrunkGroupKey(hotline.getTrunkGroupKey());
                clidTrunks.add(trunk);
            }
        }
        if (CollectionUtils.isEmpty(clidTrunks)) {
            return "hotline和setting数据一致";
        }
        lists.addAll(clidTrunks);
        enterpriseSetting.setProperty(JSON.toJSONString(lists));
        //更新enterpriseSetting  /interface/v1/enterpriseSetting/update
        String url2 = http+ip+"/interface/v1/enterpriseSetting/update";
        log.info("更新enterpriseSetting/update url:{}",url2);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url2, enterpriseSetting, String.class);
        ApiResult apiResult2 = JSONObject.parseObject(responseEntity.getBody(), ApiResult.class);
        if(apiResult2 != null){
            if (apiResult2.getResult() == 0) {
                return "success";
            }else {
                log.info("更新enterpriseSetting/update 失败.  result: {},description:{}", apiResult2.getResult(), apiResult2.getDescription());
                return "false";
            }
        }else {
            log.error("更新enterpriseSetting/update 失败 result null");
            return "失败，请稍后重试";
        }
    }
}
