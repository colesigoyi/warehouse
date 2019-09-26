package cn.qf.log.etl.udf;


import cn.qf.log.utils.LogUtils;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.junit.Test;

import java.io.IOException;

/**
 * @ program: warehouse
 * @ author:  TaoXueFeng
 * @ create: 2019-09-24 16:06
 * @ desc:
 **/

public class GetInfoUDF extends UDF {
    public String evaluate(String info) throws IOException {
        return LogUtils.getInfo(info).toString();
    }


    //@Test
    //public void test() {
    //    String info4 = "/index.html?" +
    //                    "en=e_pv&" +
    //                    "p_url=http%3A%2F%2Flocalhost%3A8080%2Fdemo.jsp&" +
    //                    "p_ref=http%3A%2F%2Flocalhost%3A8080%2Fdemo.jsp&" +
    //                    "tt=%E6%B5%8B%E8%AF%95%E9%A1%B5%E9%9D%A21&" +
    //                    "ver=1&" +
    //                    "pl=website&" +
    //                    "sdk=js&" +
    //                    "u_ud=9772CC0D-9E1F-40A1-B233-88CE5BC4CF71&" +
    //                    "u_mid=aidon&" +
    //                    "u_sd=FBDCA27D-D5D0-4211-9FF9-BC3EDE3E1CAE&" +
    //                    "c_time=1569409633622&" +
    //                    "l=zh-CN&" +
    //                    "b_iev=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_14_6)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F76.0.3809.87%20Safari%2F537.36&" +
    //                    "b_rst=1680*1050";
    //    try {
    //        System.out.println(evaluate(info4));
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}
}

