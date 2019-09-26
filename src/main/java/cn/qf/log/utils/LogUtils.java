package cn.qf.log.utils;

import cn.qf.log.ip.IPSeeker;
import cn.qf.log.pojo.Address;
import cn.qf.log.pojo.WebInfo;
import com.alibaba.fastjson.JSONObject;
import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ program: warehouse
 * @ author:  TaoXueFeng
 * @ create: 2019-09-24 15:25
 * @ desc:
 **/

public class LogUtils {

    /**
     * 通过ip获取地址
     */
    public Address getAddress(String ip) {
        //获取解析ip对象
        IPSeeker ipSeeker = IPSeeker.getInstance();
        //获取公用地址
        String addr = ipSeeker.getCountry(ip);
        //判断是国内ip
        Address address = new Address();
        String country = "中国";
        int index = 0;
        if (addr.equals("局域网")) {
            address.setCountry(country);
            address.setProvince("浙江省");
            address.setCity("杭州市");
        } else if ((index = addr.indexOf("省")) > 0) {
            address.setCountry(country);
            String province = addr.substring(0, index + 1);
            String city = addr.substring(index + 1);
            address.setProvince(province);
            address.setCity(city);
        } else {
            String province = addr.substring(0, 2);
            System.out.println(province);
            if ("北京".equals(province) || "上海".equals(province) || "天津".equals(province) || "重庆".equals(province)) {
                address.setCountry(country);
                address.setProvince(province + "市");
                address.setCity(addr.substring(addr.indexOf("市") + 1));
            } else if ("内蒙".equals(province)) {
                address.setCountry(country);
                address.setProvince(province + "古自治区");
                address.setCity(addr.substring(addr.indexOf("古") + 1));
            } else if ("宁夏".equals(province) || "广西".equals(province) || "西藏".equals(province) || "新疆".equals(province)) {
                address.setCountry(country);
                address.setProvince(province + "自治区");
                address.setCity(addr.substring(2));
            } else if ("香港".equals(province) || "澳门".equals(province)) {
                address.setCountry(country);
                address.setProvince(province + "特别行政区");
                address.setCity(addr.substring(2));
            } else {
                address.setCountry(addr);
                address.setProvince("");
                address.setCity("");
            }
        }
        return address;

    }
    //@Test
    //public void test() {
    //    Address address = getAddress("183.167.255.255");
    //    System.out.println(address);
    //}

    /**
     * 如何使用java代码想服务器发送请求
     */

    public static Address parseaIP4Taobao(String ip){

        try {
            //创建HttpClient对象
            HttpClient httpClient = new HttpClient();
            //创建GetMethod对象
            GetMethod getMethod = new GetMethod();
            //设置请求头/url等
            getMethod.setURI(new URI(
                    "http://ip.taobao.com/service/getIpInfo.php?ip=" + ip,
                    true,"utf-8"));
            //执行请求,获取一个请求的状态码
            int statuscode = httpClient.executeMethod(getMethod);
            //获取响应体
            byte[] responseBody = getMethod.getResponseBody();
            //System.out.println(new String(responseBody));
            //将相应的json字符串封装成json对象
            JSONObject jsonObject = JSONObject.parseObject(new String(responseBody));
            //获取data数据
            JSONObject dataObject = jsonObject.getJSONObject("data");
            //封装到address对象
            Address address = new Address();
            address.setCountry(dataObject.getString("country"));
            address.setProvince(dataObject.getString("region"));
            address.setCity(dataObject.getString("city"));
            return address;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) throws Exception {
        System.out.println(LogUtils.parseaIP4Taobao("170.120.0.1").toString());
    }
    static String info =
            "10.211.55.2\t" +
            "1569409634.270\t" +
            "10.211.55.42\t" +
            "/index.html?" +
            "en=e_pv&" +
            "p_url=http%3A%2F%2Flocalhost%3A8080%2Fdemo.jsp&" +
            "p_ref=http%3A%2F%2Flocalhost%3A8080%2Fdemo.jsp&" +
            "tt=%E6%B5%8B%E8%AF%95%E9%A1%B5%E9%9D%A21&ver=1&" +
            "pl=website&" +
            "sdk=js&" +
            "u_ud=9772CC0D-9E1F-40A1-B233-88CE5BC4CF71&" +
            "u_mid=aidon&" +
            "u_sd=FBDCA27D-D5D0-4211-9FF9-BC3EDE3E1CAE&" +
            "c_time=1569409633622&" +
            "l=zh-CN&" +
            "b_iev=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_14_6)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F76.0.3809.87%20Safari%2F537.36&" +
            "b_rst=1680*1050\t" +
            "19\t" +
            "09\t" +
            "25";
    public static WebInfo getInfo(String str1, String str2, String str3, String str4) {
        WebInfo webInfo = new WebInfo();
        //String testInfo = str;
        //String[] splitInfo = str.split("\t");
        String dateInfo = str2;
        String info = str4;
        //System.out.println(dataFormatTool(dateInfo));
        webInfo = splitInfo(info,webInfo);
        webInfo.setDate(dataFormatTool(dateInfo));
        return webInfo;

    }
    public static WebInfo splitInfo(String info, WebInfo webInfo) {
        try {
            String[] split = info.split("\\?");
            String[] strings = split[1].split("&");
            String en = decoderTool(strings[0]);
            String p_url = decoderTool(strings[1]);
            String p_ref = decoderTool(strings[2]);
            String tt = decoderTool(strings[3]);
            String ver = decoderTool(strings[4]);
            String pl = decoderTool(strings[5]);
            String sdk = decoderTool(strings[6]);
            String u_ud = decoderTool(strings[7]);
            String u_mid = decoderTool(strings[8]);
            String u_sd = decoderTool(strings[9]);
            String c_time = decoderTool(strings[10]);
            String l = decoderTool(strings[11]);
            String b_iev = decoderTool(strings[12]);
            UASparser uaSparser = new UASparser(OnlineUpdater.getVendoredInputStream());
            UserAgentInfo parseAgentInfo = uaSparser.parse(b_iev);

            String b_rst = decoderTool(strings[13]);

            webInfo.setEn(en);
            webInfo.setP_url(p_url);
            webInfo.setP_ref(p_ref);
            webInfo.setTt(tt);
            webInfo.setPl(pl);
            webInfo.setSdk(sdk);
            webInfo.setU_ud(u_ud);
            webInfo.setU_mid(u_mid);
            webInfo.setU_sd(u_sd);
            webInfo.setC_time(c_time);
            webInfo.setL(l);
            webInfo.setB_rst(b_rst);
            webInfo.setDeviceType(parseAgentInfo.getDeviceType());
            webInfo.setOsName(parseAgentInfo.getOsName());
            webInfo.setUaFamily(parseAgentInfo.getUaFamily());
            webInfo.setBrowserVersionInfo(parseAgentInfo.getBrowserVersionInfo());
            webInfo.setUaName(parseAgentInfo.getUaName());
            webInfo.setType(parseAgentInfo.getType());
            return webInfo;
            //String string = webInfo.toString();
            //System.out.println(string);

            //System.out.println(en);
            //System.out.println(p_url);
            //System.out.println(p_ref);
            //System.out.println(tt);
            //System.out.println(pl);
            //System.out.println(sdk);
            //System.out.println(u_ud);
            //System.out.println(u_mid);
            //System.out.println(u_sd);
            //System.out.println(c_time);
            //System.out.println(l);
            //System.out.println(b_rst);

            //System.out.println("设备类型："+parseAgentInfo.getDeviceType());//
            //System.out.println("操作系统："+parseAgentInfo.getOsName());//
            //System.out.println("浏览器名称："+parseAgentInfo.getUaFamily());//
            //System.out.println("浏览器版本："+parseAgentInfo.getBrowserVersionInfo());//
            //System.out.println("浏览器:"+parseAgentInfo.getUaName());
            //System.out.println("类型："+parseAgentInfo.getType());



        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String decoderTool(String str) {
        try {
            str = str.split("=")[1];
            str = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
    public static String dataFormatTool(String dateStr){
        String[] split = dateStr.split("\\.");
        String s1 = split[0] + split[1];
        long dateInfo = Long.valueOf(s1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(dateInfo);
        String time = simpleDateFormat.format(date);
        return time;
    }
}
