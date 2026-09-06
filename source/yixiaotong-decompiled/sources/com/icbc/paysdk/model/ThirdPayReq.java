package com.icbc.paysdk.model;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ThirdPayReq {
    String interfaceName = "";
    String interfaceVersion = "";
    String tranData = "";
    String merSignMsg = "";
    String merCert = "";
    String clientType = "";

    public String getClientType() {
        return this.clientType;
    }

    public String getInterfaceName() {
        return this.interfaceName;
    }

    public String getInterfaceVersion() {
        return this.interfaceVersion;
    }

    public String getMerCert() {
        return this.merCert;
    }

    public String getMerSignMsg() {
        return this.merSignMsg;
    }

    public String getTranData() {
        return this.tranData;
    }

    public void setClientType(String str) {
        this.clientType = str;
    }

    public void setInterfaceName(String str) {
        this.interfaceName = str;
    }

    public void setInterfaceVersion(String str) {
        this.interfaceVersion = str;
    }

    public void setMerCert(String str) {
        this.merCert = str;
    }

    public void setMerSignMsg(String str) {
        this.merSignMsg = str;
    }

    public void setTranData(String str) {
        this.tranData = str;
    }
}
