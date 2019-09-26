package cn.qf.log.etl;

/**
 * @ program: warehouse
 * @ author:  TaoXueFeng
 * @ create: 2019-09-24 19:48
 * @ desc:
 **/

import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.mortbay.servlet.UserAgentFilter;

import java.io.IOException;
import java.net.URLDecoder;


/**
 * 清洗UserAgent
 */

public class UserAgentUtils {
    //创建UASparser对象
    private static UASparser uaSparser = null;
    private static final Logger logger = Logger.getLogger(UserAgentUtils.class);

    static {
        try {
            uaSparser = new UASparser(OnlineUpdater.getVendoredInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将字符串的useragent转换为对象
     * 解析出浏览器和操作系统
     */
    public UserAgentInfo getUserAgentInfo(String useragent) {
        UserAgentInfo info = null;
        //判断非空
        if (null != useragent && StringUtils.isNotEmpty(useragent.trim())) {
            //使用工具解析useragent
            useragent = URLDecoder.decode(useragent);
            cz.mallat.uasparser.UserAgentInfo oinfo = null;
            try {
                oinfo = uaSparser.parse(useragent);
                //将oinfo封装到info中
                if (oinfo != null) {
                    info = new UserAgentInfo();
                    info.setBrowserName(oinfo.getUaName());
                    info.setBrowserVersion(oinfo.getBrowserVersionInfo());
                    info.setOsName(oinfo.getOsFamily());
                    info.setOsVersion(oinfo.getOsName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return info;
    }

    public static void main(String[] args) {
        System.out.println(new UserAgentUtils().getUserAgentInfo("Mozilla/5.0 (Windows NT 10.0; " +
                "WOW64; rv:64.0) Gecko/20100101 Firefox/64.0"));
    }

    /**
     * 封装UserAgent对象信息
     */
    public static class UserAgentInfo {
        private String browserName;
        private String browserVersion;
        private String osName;
        private String osVersion;

        public String getBrowserName() {
            return browserName;
        }

        public void setBrowserName(String browserName) {
            this.browserName = browserName;
        }

        public String getBrowserVersion() {
            return browserVersion;
        }

        public void setBrowserVersion(String browserVersion) {
            this.browserVersion = browserVersion;
        }

        public String getOsName() {
            return osName;
        }

        public void setOsName(String osName) {
            this.osName = osName;
        }
        public String getOsVersion() {
            return osVersion;
        }
        public void setOsVersion(String osVersion) {
            this.osVersion = osVersion;
        } @
                Override
        public String toString() {
            return browserName + " " + browserVersion +" " + osName + " " + osVersion;
        }
    }
}