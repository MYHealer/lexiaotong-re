package com.meishu.sdk.core.webview.jsbridge.bean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ClickTempParam extends UUIDParam {
    private static final long serialVersionUID = 1;
    private int act_type;
    private float down_x;
    private float down_y;
    private long msec;
    private int open_browser;
    private long up_msec;
    private float up_x;
    private float up_y;

    public int getAct_type() {
        return this.act_type;
    }

    public float getDown_x() {
        return this.down_x;
    }

    public float getDown_y() {
        return this.down_y;
    }

    public long getMsec() {
        return this.msec;
    }

    public boolean getOpen_browser() {
        return this.open_browser == 1;
    }

    public long getUp_msec() {
        return this.up_msec;
    }

    public float getUp_x() {
        return this.up_x;
    }

    public float getUp_y() {
        return this.up_y;
    }
}
