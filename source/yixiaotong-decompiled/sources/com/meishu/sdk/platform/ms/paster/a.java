package com.meishu.sdk.platform.ms.paster;

import android.view.View;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.meishu_ad.nativ.f;

/* JADX INFO: compiled from: MeishuPasterAdWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.nativ.b f5179a;
    public final /* synthetic */ d.a b;

    public a(d.a aVar, com.meishu.sdk.meishu_ad.nativ.b bVar) {
        this.b = aVar;
        this.f5179a = bVar;
    }

    @Override // com.meishu.sdk.core.safe.o
    public void safeOnClick(View view) {
        d dVar = d.this;
        if (dVar.d) {
            T t = dVar.f5177a;
            if (t != 0 && ((f) t).getCbc() == 0 && d.this.f.getInteractionListener() != null) {
                d.this.f.getInteractionListener().onAdClicked();
            }
            this.f5179a.setInteractionListener(d.this.f.getInteractionListener());
            this.f5179a.a().setClkActType(1);
            com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) this.f5179a, true);
        }
    }
}
