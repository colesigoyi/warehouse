package cn.qf.log.pojo;

/**
 * @ program: warehouse
 * @ author:  TaoXueFeng
 * @ create: 2019-09-25 20:44
 * @ desc:
 **/

public class WebInfo {
    //private String date;
    private String en;
    private String p_url;
    private String p_ref;
    private String tt;
    private String ver;
    private String pl;
    private String sdk;
    private String u_ud;
    private String u_mid;
    private String u_sd;
    private String c_time;
    private String l;
    //private String b_iev;
    private String b_rst;
    private String deviceType;
    private String osName;
    private String uaFamily;
    private String browserVersionInfo;
    private String uaName;
    private String type;

    public WebInfo() {
    }

    public WebInfo(String en, String p_url, String p_ref, String tt, String pl, String sdk,
                   String u_ud, String u_mid, String u_sd, String c_time, String l, String b_iev,
                   String b_rst, String deviceType, String osName, String uaFamily, String browserVersionInfo,
                   String uaName, String type,String ver) {
        this.en = en;
        this.p_url = p_url;
        this.p_ref = p_ref;
        this.tt = tt;
        this.pl = pl;
        this.sdk = sdk;
        this.u_ud = u_ud;
        this.u_mid = u_mid;
        this.u_sd = u_sd;
        this.c_time = c_time;
        this.l = l;
        //this.b_iev = b_iev;
        this.b_rst = b_rst;
        this.deviceType = deviceType;
        this.osName = osName;
        this.uaFamily = uaFamily;
        this.browserVersionInfo = browserVersionInfo;
        this.uaName = uaName;
        this.type = type;
        this.ver = ver;
        //this.date = date;
    }

    @Override
    public String toString() {
        return  en + '\t' +
                 p_url + '\t' +
                 p_ref + '\t' +
                 tt + '\t' +
                ver + '\t' +
                 pl + '\t' +
                 sdk + '\t' +
                 u_ud + '\t' +
                 u_mid + '\t' +
                 u_sd + '\t' +
                 c_time + '\t' +
                 l + '\t' +
                 b_rst + '\t' +
                 deviceType + '\t' +
                 osName + '\t' +
                 uaFamily + '\t' +
                 browserVersionInfo + '\t' +
                 uaName + '\t' +
                 type;
    }

    //public String getDate() {
    //    return date;
    //}
    //
    //public void setDate(String date) {
    //    this.date = date;
    //}


    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getP_url() {
        return p_url;
    }

    public void setP_url(String p_url) {
        this.p_url = p_url;
    }

    public String getP_ref() {
        return p_ref;
    }

    public void setP_ref(String p_ref) {
        this.p_ref = p_ref;
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public String getSdk() {
        return sdk;
    }

    public void setSdk(String sdk) {
        this.sdk = sdk;
    }

    public String getU_ud() {
        return u_ud;
    }

    public void setU_ud(String u_ud) {
        this.u_ud = u_ud;
    }

    public String getU_mid() {
        return u_mid;
    }

    public void setU_mid(String u_mid) {
        this.u_mid = u_mid;
    }

    public String getU_sd() {
        return u_sd;
    }

    public void setU_sd(String u_sd) {
        this.u_sd = u_sd;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }



    public String getB_rst() {
        return b_rst;
    }

    public void setB_rst(String b_rst) {
        this.b_rst = b_rst;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getUaFamily() {
        return uaFamily;
    }

    public void setUaFamily(String uaFamily) {
        this.uaFamily = uaFamily;
    }

    public String getBrowserVersionInfo() {
        return browserVersionInfo;
    }

    public void setBrowserVersionInfo(String browserVersionInfo) {
        this.browserVersionInfo = browserVersionInfo;
    }

    public String getUaName() {
        return uaName;
    }

    public void setUaName(String uaName) {
        this.uaName = uaName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
