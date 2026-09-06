package com.meishu.sdk.core.webview.jsbridge.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GetDeviceInfoResBean implements Serializable {
    private static final long serialVersionUID = 1;
    private AdConfig ad_config;
    private int shakable;
    private int top_bar_height;
    private int twistable;

    public static class AdConfig implements Serializable {
        private static final long serialVersionUID = 1;
        private int padding_bottom;
        private int padding_left;
        private int padding_right;
    }

    public static GetDeviceInfoResBean make(int i, boolean z, boolean z2, AdConfig adConfig) {
        GetDeviceInfoResBean getDeviceInfoResBean = new GetDeviceInfoResBean();
        getDeviceInfoResBean.top_bar_height = i;
        getDeviceInfoResBean.ad_config = adConfig;
        getDeviceInfoResBean.shakable = z ? 1 : 0;
        getDeviceInfoResBean.twistable = z2 ? 1 : 0;
        return getDeviceInfoResBean;
    }

    public static AdConfig makeAdConfig(int i, int i2, int i3) {
        AdConfig adConfig = new AdConfig();
        adConfig.padding_left = i;
        adConfig.padding_right = i2;
        adConfig.padding_bottom = i3;
        return adConfig;
    }
}
