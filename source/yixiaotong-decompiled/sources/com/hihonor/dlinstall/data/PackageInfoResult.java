package com.hihonor.dlinstall.data;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class PackageInfoResult implements Serializable {
    private static final long serialVersionUID = 1;
    private String callerAppName;
    private int callerAppVer;

    public String getCallerAppName() {
        return this.callerAppName;
    }

    public int getCallerAppVer() {
        return this.callerAppVer;
    }

    public void setCallerAppName(String str) {
        this.callerAppName = str;
    }

    public void setCallerAppVer(int i) {
        this.callerAppVer = i;
    }

    public String toString() {
        return "PackageInfoResult{callerAppName=" + this.callerAppName + ", callerAppVer=" + this.callerAppVer + '}';
    }
}
