package com.bytedance.sdk.openadsdk;

import com.byazt.zqa.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@c(c = {0, 80, 81, 82, 2481})
public class TTLocation implements LocationProvider {
    private double c;
    private double tt;

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.tt;
    }

    public void setLatitude(double d) {
        this.c = d;
    }

    public void setLongitude(double d) {
        this.tt = d;
    }

    public TTLocation(double d, double d2) {
        this.c = d;
        this.tt = d2;
    }
}
