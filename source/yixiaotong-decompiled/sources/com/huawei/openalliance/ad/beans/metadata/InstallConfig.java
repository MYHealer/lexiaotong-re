package com.huawei.openalliance.ad.beans.metadata;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class InstallConfig implements Serializable {
    private static final long serialVersionUID = 546555599564481045L;
    private String appBtnInstallWay;
    private String contentBtnInstallWay;
    private String creativeInstallWay;

    public String Code() {
        return this.creativeInstallWay;
    }

    public void Code(String str) {
        this.creativeInstallWay = str;
    }

    public String I() {
        return this.contentBtnInstallWay;
    }

    public void I(String str) {
        this.contentBtnInstallWay = str;
    }

    public String V() {
        return this.appBtnInstallWay;
    }

    public void V(String str) {
        this.appBtnInstallWay = str;
    }
}
