package com.huawei.hms.ads;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class App implements Serializable {
    private static final long serialVersionUID = 30421300;
    private Integer brand;
    private String name;
    private String pkgname;
    private String version;

    public App() {
    }

    public App(String str, String str2, String str3) {
        this.name = str2;
        this.pkgname = str;
        this.version = str3;
    }

    public App(String str, String str2, String str3, Integer num) {
        this.version = str;
        this.name = str2;
        this.pkgname = str3;
        this.brand = num;
    }

    public Integer getBrand() {
        return this.brand;
    }

    public String getName__() {
        return this.name;
    }

    public String getPkgname__() {
        return this.pkgname;
    }

    public String getVersion__() {
        return this.version;
    }

    public void setBrand(Integer num) {
        this.brand = num;
    }

    public void setName__(String str) {
        this.name = str;
    }

    public void setPkgname__(String str) {
        this.pkgname = str;
    }

    public void setVersion__(String str) {
        this.version = str;
    }
}
