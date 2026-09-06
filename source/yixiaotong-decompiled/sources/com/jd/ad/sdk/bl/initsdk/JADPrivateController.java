package com.jd.ad.sdk.bl.initsdk;

import com.jd.ad.sdk.dl.baseinfo.JADLocation;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class JADPrivateController {
    public String getIP() {
        return "";
    }

    public JADLocation getLocation() {
        return new JADLocation(-1.0d, -1.0d, -1.0d);
    }

    public abstract String getOaid();

    public boolean isCanUseIP() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }
}
