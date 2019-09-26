package cn.qf.log.pojo;

/**
 * @ program: warehouse
 * @ author:  TaoXueFeng
 * @ create: 2019-09-24 15:25
 * @ desc:
 **/

public class Address {
    private String country;
    private String province;
    private String city;

    public Address() {}

    public Address(String country, String province, String city) {
        this.country = country;
        this.province = province;
        this.city = city;
    }

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
    }

    @Override
    public String toString() {
        return country + ' ' + province + ' ' + city;
    }
}