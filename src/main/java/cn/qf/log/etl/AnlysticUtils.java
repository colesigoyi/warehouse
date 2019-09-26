package cn.qf.log.etl;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.hive.com.esotericsoftware.minlog.Log;


/**
 * @ program: warehouse
 * @ author:  TaoXueFeng
 * @ create: 2019-09-24 20:52
 * @ desc:
 **/

public class AnlysticUtils {
    /**
            * 淘宝解析ip
* @param url :http://ip.taobao.com/service/getIpInfo.php?ip=171.120.0.1
            * @param charset "utf‐8"
            */
    public static RegionInfo parserIp4Taobao(String url, String charset) throws Exception {
        RegionInfo info = new RegionInfo();
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        Log logger = null;
        if (null == url || !url.startsWith("http")) {
            logger.warn("请求地址格式不对");
        } // 设置请求的编码方式
        if (null != charset) {
            method.addRequestHeader("Content‐Type", "application/x‐www‐form‐urlencoded; charset=" + charset);
        } else {
            method.addRequestHeader("Content‐Type", "application/x‐www‐form‐urlencoded; charset=" + "utf-8");
        }
        int statusCode = client.executeMethod(method);
        if (statusCode != HttpStatus.SC_OK) {// 打印服务器返回的状态
            logger.warn("Method failed: " + method.getStatusLine());
        }

// 返回响应消息
        byte[] responseBody = method.getResponseBodyAsString().getBytes(method.getResponseCharSet());
// 在返回响应消息使用编码(utf‐8或gb2312)
        String response = new String(responseBody, "utf-8");
        JSONObject jo = JSONObject.parseObject(response);
        JSONObject j = (JSONObject)jo.get("data");
// 释放连接
        method.releaseConnection();
//设置省市
        info.setCountry(j.get("country").toString());
        info.setProvince(j.get("region").toString());
        info.setCity(j.get("city").toString()+"市");
        return info;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(AnlysticUtils.parserIp4Taobao("" +
                "http://ip.taobao.com/service/getIpInfo.php?ip=171.120.0.1", "utf‐8"));
    }
    public static class RegionInfo {
        // 默认值
        private static final String DEFAULT_VALUE = "unknow";
        // 国家省市默认值
        private String country = DEFAULT_VALUE;
        private String province = DEFAULT_VALUE;
        private String city = DEFAULT_VALUE;
        public String getCountry() {
            return country;
        }
        public void setCountry(String country) {
            this.country = country;
        }
        public String getProvince() {
            return province;
        }
        public void setProvince(String province) {
            this.province = province;
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        } @
                Override
        public String toString() {
            return country + " " + province + " " + city;
        }
    }
}