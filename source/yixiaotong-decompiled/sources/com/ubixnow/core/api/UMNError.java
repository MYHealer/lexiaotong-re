package com.ubixnow.core.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNError {
    public String code;
    public String msg;
    public String platFormCode;
    public String platFormMsg;

    public UMNError(String str, String str2) {
        this.platFormCode = "";
        this.platFormMsg = "";
        this.code = str;
        this.msg = str2;
    }

    public UMNError(String str, String str2, String str3, String str4) {
        this.code = str;
        this.msg = str2;
        this.platFormCode = str3;
        this.platFormMsg = str4;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.msg;
    }

    public String toString() {
        return "code:[ " + this.code + " ]  msg:[ " + this.msg + " ] platFormCode: [" + this.platFormCode + "  ] platFormMsg: [" + this.platFormMsg + " ]";
    }
}
