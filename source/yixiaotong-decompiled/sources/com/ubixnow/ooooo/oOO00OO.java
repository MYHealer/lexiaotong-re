package com.ubixnow.ooooo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOO00OO {
    public String code;
    public String msg;
    public Object object;
    public String platFormCode;
    public String platFormMsg;

    public oOO00OO(String str, String str2) {
        this.platFormCode = "";
        this.platFormMsg = "";
        this.code = str;
        this.msg = str2;
    }

    public oOO00OO(String str, String str2, String str3, String str4) {
        this.code = str;
        this.msg = str2;
        this.platFormCode = str3;
        this.platFormMsg = str4;
    }

    public oOO00OO setInfo(Object obj) {
        this.object = obj;
        return this;
    }

    public String toString() {
        return "code:[ " + this.code + " ]  msg:[ " + this.msg + " ] platFormCode: [" + this.platFormCode + "  ] platFormMsg: [" + this.platFormMsg + " ]";
    }
}
