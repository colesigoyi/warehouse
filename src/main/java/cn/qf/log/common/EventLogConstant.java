package cn.qf.log.common;

/**
 * @ program: warehouse
 * @ author:  TaoXueFeng
 * @ create: 2019-09-24 20:46
 * @ desc:
 **/

public class EventLogConstant {
    /**
     * 事件的枚举类型
     */
    public static enum EventEnum{
        LAUNCH(1,"launch event","e_l"),
        PAGEVIEW(2,"page view event","e_pv"),
        CHARGE_REQUEST(3,"charge request","e_crt"),
        CHARGE_SUCCESS(4,"charge success","e_cs"),
        CHARGE_REFUND(5,"charge refund","e_cr"),
        EVENT(5,"event","e_e");
        public final int id;
        public final String name;
        public final String alias;//事件的别名，需要和日志中的事件key一样
        EventEnum(int id, String name, String alias) {
            this.id = id;
            this.name = name;
            this.alias = alias;
        }
        /**
         *根据alias的别名返回与之对应的枚举
        */
        public static EventEnum valueOfAlias(String alias){
            for (EventEnum event:values()) {
                if(alias.equals(event.alias)){
                    return event;
                }
            }
            return null;
        }
    } /**
     * hbase表相关
    */
    public static final String LOG_HBASE_NAME = "event_logs";
    public static final String LOG_FAMILY_NAME = "info";
    /*** 日志相关的列
     */
    public static final String LOG_COLUMN_NAME_IP = "ip";
    public static final String LOG_COLUMN_NAME_SEPARTOR = "\\^A";
    public static final String LOG_COLUMN_NAME_SERVER_TIME = "s_time";
    public static final String LOG_COLUMN_NAME_EVENT_NAME = "en";
    public static final String LOG_COLUMN_NAME_VERSION = "ver";
    public static final String LOG_COLUMN_NAME_UUID = "u_ud";
    public static final String LOG_COLUMN_NAME_MEMBER_ID = "u_mid";
    public static final String LOG_COLUMN_NAME_SESSION_ID ="u_sd";
    public static final String LOG_COLUMN_NAME_CLIENT_TIME = "c_time";
    public static final String LOG_COLUMN_NAME_LANGUAGE = "l";
    public static final String LOG_COLUMN_NAME_USER_AGENT = "b_iev";
    public static final String LOG_COLUMN_NAME_RESOLUTION= "b_rst";
    public static final String LOG_COLUMN_NAME_CURRENT_URL = "p_url";
    public static final String LOG_COLUMN_NAME_PREFFER_URL = "p_ref";
    public static final String LOG_COLUMN_NAME_TITLE = "tt";
    public static final String LOG_COLUMN_NAME_PLATFORM_NAME = "pl";
    /**
     * 订单相关
     */
    public static final String LOG_COLUMN_NAME_ORDER_ID = "oid";
    public static final String LOG_COLUMN_NAME_ORDER_NAME = "on";
    public static final String LOG_COLUMN_NAME_CURRENCY_TYPE = "cut";
    public static final String LOG_COLUMN_NAME_CURRENCY_AMOUNT = "cua";
    public static final String LOG_COLUMN_NAME_PAYMENT_TYPE = "pt";
    /**
     * userAgent相关
     */
    public static final String LOG_COLUMN_NAME_BROWSER_NAME = "browserName";
    public static final String LOG_COLUMN_NAME_BROWSER_VERSION = "browserVersion";
    public static final String LOG_COLUMN_NAME_OS_NAME = "osName";
    public static final String LOG_COLUMN_NAME_OS_VERSION = "osVersion";
    /**
     * 地域相关
     */
    public static final String LOG_COLUMN_NAME_COUNTRY = "country";
    public static final String LOG_COLUMN_NAME_PROVINCE = "province";
    public static final String LOG_COLUMN_NAME_CITY = "city";
}