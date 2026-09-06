package com.hihonor.dlinstall.clone;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class WishInfo implements Serializable {
    public int errorCode;
    public String msg;
    public List<WishVo> wishApkNameList;

    public WishInfo(int i, String str, List<WishVo> list) {
        this.errorCode = i;
        this.msg = str;
        this.wishApkNameList = list;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public List<WishVo> getWishApkNameList() {
        return this.wishApkNameList;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setWishApkNameList(List<WishVo> list) {
        this.wishApkNameList = list;
    }

    public String toString() {
        return "WishInfo{errorCode=" + this.errorCode + "msg=" + this.msg + '}';
    }
}
