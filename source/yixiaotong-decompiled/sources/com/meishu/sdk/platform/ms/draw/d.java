package com.meishu.sdk.platform.ms.draw;

import android.view.View;
import com.meishu.sdk.core.safe.o;

/* JADX INFO: compiled from: MeishuDrawAdWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.nativ.b f5166a;
    public final /* synthetic */ f.a b;

    public d(f.a aVar, com.meishu.sdk.meishu_ad.nativ.b bVar) {
        this.b = aVar;
        this.f5166a = bVar;
    }

    @Override // com.meishu.sdk.core.safe.o
    public void safeOnClick(View view) {
        g gVar = f.this.f5168a;
        if (gVar.c) {
            T t = gVar.f5177a;
            if (t != 0 && ((com.meishu.sdk.meishu_ad.nativ.f) t).getCbc() == 0 && f.this.f5168a.e.getInteractionListener() != null) {
                f.this.f5168a.e.getInteractionListener().onAdClicked();
            }
            this.f5166a.setInteractionListener(f.this.f5168a.e.getInteractionListener());
            this.f5166a.a().setClkActType(2);
            com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) this.f5166a, true);
        }
    }
}
