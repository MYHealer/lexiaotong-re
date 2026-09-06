package com.meishu.sdk.core.webview.jsbridge.bean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OpenWebViewPageParam extends UUIDParam {
    public static final int USE_BROWSER = 1;
    private static final long serialVersionUID = 1;
    private int open_type;
    private String url;

    public int getOpen_type() {
        return this.open_type;
    }

    public String getUrl() {
        return this.url;
    }
}
