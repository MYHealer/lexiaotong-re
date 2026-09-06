package com.hihonor.dlinstall.clone;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class WishVo implements Serializable {
    private int code;
    private String wishApkName;

    public WishVo(String str, int i) {
        this.wishApkName = str;
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    public String getWishApkName() {
        return this.wishApkName;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setWishApkName(String str) {
        this.wishApkName = str;
    }
}
