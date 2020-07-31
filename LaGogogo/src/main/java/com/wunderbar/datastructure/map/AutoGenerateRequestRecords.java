package com.wunderbar.datastructure.map;/**
 *
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.corba.se.impl.orb.PrefixParserAction;
import com.sun.org.apache.xpath.internal.objects.XObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author katze
 * @date 2020/7/31 15:37
 * @description 请求服务接口报文
 */
public class AutoGenerateRequestRecords {

    public static void main(String[] args) {

    }


    public static void getPolicyList(){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        Map<String,String> headMap =new HashMap<String,String>();
        Map<String,String> bodyMap =new HashMap<String,String>();

        headMap.put("requestId",uuid);
        headMap.put("transTime",sdf.format(new Date()));
        headMap.put("methodCode","queryPolicyList");
        headMap.put("format","json");
        headMap.put("signType","MD5");
        headMap.put("asyn","0");

        bodyMap.put("identifyType","01");
        bodyMap.put("identifyNumber","");
        bodyMap.put("idRole","applicant");
        bodyMap.put("validFlag","");
        bodyMap.put("pageNo","");
        bodyMap.put("pageSize","");

        Map<String,Map> resMap =new HashMap<>();
        resMap.put("head",headMap);
        resMap.put("body",bodyMap);

        Map<String, Object> totalMap =new HashMap<>();
        totalMap.put("request",resMap);

        String requestjson = JSON.toJSONString(totalMap);
        JSONObject param1 =JSON.parseObject(requestjson);

        String aa ="";
        if (param1.get("request") instanceof Map){
            Map tmpMap = (Map) param1.get("request");
            aa=JSON.toJSONString(tmpMap, SerializerFeature.MapSortField);
        }else if(param1.get("request") instanceof String){
            aa = (String) param1.get("request");

        }

        String signature = "";
        totalMap.put("signature",signature);
        String json =JSON.toJSONString(totalMap);
        System.out.println("policyList入参报文"+json);



    }
}
