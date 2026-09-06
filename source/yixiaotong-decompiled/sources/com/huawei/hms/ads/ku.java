package com.huawei.hms.ads;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public enum ku {
    BACK(com.alipay.sdk.widget.j.j),
    FORWARD("forward"),
    SAVE_PAGE("savePage"),
    REFRESH(com.alipay.sdk.widget.j.l),
    ADD_TO("addTo"),
    FIND_IN_PAGE("findInPage"),
    TRANSLATE("translate"),
    OPEN_IN_BROWSER("openInBrowser"),
    NONE("none");

    private String L;

    ku(String str) {
        this.L = str;
    }

    public String Code() {
        return this.L;
    }
}
