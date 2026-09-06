package com.meishu.sdk.core.loader.loadbean;

import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import com.cdo.oaps.ad.OapsKey;
import com.meishu.sdk.core.domain.SdkAdInfo;

/* JADX INFO: compiled from: SmallGroupBean.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SdkAdInfo f4815a;
    public Object b;
    public int e;
    public boolean g;
    public boolean h;
    public int c = 1;
    public int d = 0;
    public int f = -1;

    public String toString() {
        return com.meishu.sdk.activity.a.a("SmallGroupBean{platform =").append(this.g ? "MS" : this.f4815a.getSdk()).append(", state=").append(this.c).append(", timeoutState=").append(this.d).append(", firstScore=").append(this.e).append(", secondScore=").append(a()).append(", isMs=").append(this.g).append(", isCache=").append(this.h).append(", hashCode=").append(hashCode()).append('}').toString();
    }

    public int a() {
        if (!this.g) {
            if ("bidding".equals(this.f4815a.getOtype())) {
                return this.f;
            }
            if (AmmeterWalletDetailActivity.EXTRA_ORDER.equals(this.f4815a.getOtype())) {
                return (this.e + 100000) - this.f4815a.getScore();
            }
            if (OapsKey.KEY_PRICE.equals(this.f4815a.getOtype())) {
                return this.f4815a.getCodPrice() + this.e;
            }
        }
        return this.f;
    }
}
