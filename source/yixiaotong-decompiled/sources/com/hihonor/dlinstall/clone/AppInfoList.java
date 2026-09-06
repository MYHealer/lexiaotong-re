package com.hihonor.dlinstall.clone;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AppInfoList implements Serializable {
    public List<AppInfo> appInfoList;
    public int errorCode;
    public String msg;

    public AppInfoList(int i, String str, List<AppInfo> list) {
        this.errorCode = i;
        this.msg = str;
        this.appInfoList = list;
    }

    public List<AppInfo> getAppInfoList() {
        return this.appInfoList;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setAppInfoList(List<AppInfo> list) {
        this.appInfoList = list;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "AppInfoList{errorCode=" + this.errorCode + ", msg='" + this.msg + "', appInfoList=" + this.appInfoList + '}';
    }
}
