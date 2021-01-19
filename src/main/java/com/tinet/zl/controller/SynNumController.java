package com.tinet.zl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tinet.zl.entity.ApiResult;
import com.tinet.zl.entity.CtiLinkEnterpriseSetting;
import com.tinet.zl.service.SynNumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zhang lei
 * @Describe: All things are difficult before they are easy.
 * @CreatTime: 2021-01-18-14-39
 */
@RestController
@RequestMapping(value = "/syn")
@Api(value = "号码同步接口",description = "号码同步接口")
@Slf4j
public class SynNumController {
    @Autowired
    private SynNumService synNumService;
    @Autowired
    private RestTemplate restTemplate;


    /**
     * @ApiParam("中继群组名称,可不填")
     * @ApiParam("呼叫中心ID")
     * @ApiParam("主机ip加端口或者域名")
     * @param ip "中继群组名称,可不填"
     * @param enterpriseId
     * @param name
     * @return
     */
    @GetMapping(value = "/synNum",produces = "text/html;charset=UTF-8")
    @ApiOperation("boss号码没有问题,console少号码")
    public String synNumber(@ApiParam("主机ip加端口或者域名") @RequestParam(value = "ip")  String ip ,
                             @ApiParam("呼叫中心ID") @RequestParam(value = "enterpriseId") String enterpriseId,
                             @ApiParam(value = "中继群组名称,可不填",name = "name",defaultValue = "clid_trunk_group") @RequestParam(value = "name", required = true, defaultValue = "") String name){
        try {
            log.info("synNumber号码同步 参数:ip=[{}],enterpriseId=[{}],name=[{}]",ip,enterpriseId,name );
            String  result =synNumService.bossToConsoleNums(ip,enterpriseId,name);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("synNumber号码同步 exception: 【{}】",e);
            return "error";
        }
    }

    @GetMapping(value = "/test")
    @ApiOperation("boss号码没有问题,console少号码")
    public String test(){
        try {
            log.info("synNumber号码同步 参数:ip=[{}],enterpriseId=[{}],name=[{}]");
            String  result ="synNumService.bossToConsoleNums(ip,enterpriseId,name)";
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("synNumber号码同步 exception: 【{}】",e);
            return "error";
        }
    }


    @GetMapping(value = "/update/setting",produces = "text/html;charset=UTF-8")
    @ApiOperation("跟新enterpeiseSetting代码")
    public String update(@ApiParam("主机ip加端口或者域名") @RequestParam(value = "ip")  String ip ,
                         @ApiParam("enterpeiseSetting配置") @RequestParam(value = "setting")  String setting){
        try {
            log.info("synNumber号码同步 参数:ip=[{}],setting[{}]",ip,setting);
            String url =  "http://"+ip+"/interface/v1/enterpriseSetting/update";
            log.info("更新enterpriseSetting/update url:{}",url);

            CtiLinkEnterpriseSetting ctiLinkEnterpriseSetting = JSON.parseObject(setting, CtiLinkEnterpriseSetting.class);

            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, ctiLinkEnterpriseSetting, String.class);
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
        } catch (Exception e) {
            e.printStackTrace();
            log.error("synNumber号码同步 exception: 【{}】",e);
            return "error";
        }
    }
}
