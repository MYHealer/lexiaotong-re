package com.hihonor.adsdk.banner.api;

import android.content.Context;
import com.hihonor.adsdk.base.api.BaseAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends com.hihonor.adsdk.base.widget.a.c<e> {
    private static final String c = "BannerAdapter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3499a;
    private int b;

    public b(BaseAd baseAd) {
        super(baseAd);
    }

    @Override // com.hihonor.adsdk.base.widget.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e hnadsa(Context context) {
        return d.a(this.hnadsa);
    }

    public void a(int i, int i2) {
        this.f3499a = i;
        this.b = i2;
    }

    @Override // com.hihonor.adsdk.base.widget.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void hnadsa(e eVar) {
        eVar.a(this.f3499a, this.b);
        eVar.a(this.hnadsa);
    }
}
