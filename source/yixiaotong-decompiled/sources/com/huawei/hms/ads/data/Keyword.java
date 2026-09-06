package com.huawei.hms.ads.data;

import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.annotations.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class Keyword {

    @c(Code = OapsKey.KEY_KEYWORD)
    private String keyword;
    private Integer type;

    public Keyword() {
    }

    public Keyword(Integer num, String str) {
        this.type = num;
        this.keyword = str;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public Integer getType() {
        return this.type;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public void setType(Integer num) {
        this.type = num;
    }
}
