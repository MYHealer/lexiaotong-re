package com.meishu.sdk.meishu_ad.nativ;

import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;

/* JADX INFO: compiled from: NativeAdDataImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends com.meishu.sdk.core.safe.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f5044a;
    public final /* synthetic */ com.meishu.sdk.platform.ms.recycler.d b;
    public final /* synthetic */ d c;

    public c(d dVar, ViewGroup viewGroup, com.meishu.sdk.platform.ms.recycler.d dVar2) {
        this.c = dVar;
        this.f5044a = viewGroup;
        this.b = dVar2;
    }

    @Override // com.meishu.sdk.core.safe.o
    public void safeOnClick(View view) {
        f fVar = this.c.i;
        if (fVar == null || !fVar.B) {
            LogUtil.dev("NativeAdDataImpl", "is`not FeedAdExposure");
            return;
        }
        if (this.f5044a != null) {
            for (int i = 0; i < this.c.i.getClickUrl().length; i++) {
                try {
                    int width = this.f5044a.getWidth();
                    int height = this.f5044a.getHeight();
                    if (width > 0 && height > 0) {
                        this.c.i.getClickUrl()[i] = h0.a(this.c.i.getClickUrl()[i], width, height);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        com.meishu.sdk.platform.ms.recycler.d dVar = this.b;
        dVar.getClass();
        try {
            if (dVar.f5186a != null && dVar.b.a().getCbc() == 0) {
                dVar.f5186a.onAdClicked();
            }
            dVar.b.a().setClkActType(1);
            com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) dVar.b, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
