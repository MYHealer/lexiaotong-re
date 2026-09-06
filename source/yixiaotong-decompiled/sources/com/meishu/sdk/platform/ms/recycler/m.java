package com.meishu.sdk.platform.ms.recycler;

import android.view.ViewGroup;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.view.FeedAdOverlayManager;

/* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class m implements FeedAdOverlayManager.OnOverlayTriggerAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f5224a;
    public final /* synthetic */ l b;

    public m(l lVar, ViewGroup viewGroup) {
        this.b = lVar;
        this.f5224a = viewGroup;
    }

    @Override // com.meishu.sdk.core.view.FeedAdOverlayManager.OnOverlayTriggerAction
    public void onOverlayAttached() {
        try {
            o1.a(this.b.b.a().getEventUrl(), 29, 0, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.view.FeedAdOverlayManager.OnOverlayTriggerAction
    public void onTrigger(boolean z, boolean z2, float f, float f2, long j, float f3, float f4, int i) {
        RecylcerAdInteractionListener recylcerAdInteractionListener;
        l lVar = this.b;
        if (lVar.e) {
            if (!z2) {
                try {
                    o1.a(lVar.b.a().getEventUrl(), 30, 0, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            h0.a(this.b.b, this.f5224a);
            if (z) {
                this.b.a(this.f5224a, f, f2, j, f3, f4, i, true);
                return;
            }
            try {
                if (this.b.b.a().getCbc() == 0 && (recylcerAdInteractionListener = this.b.d) != null) {
                    recylcerAdInteractionListener.onAdClicked();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            s.a(this.b.b, f, f2, j, f3, f4);
            this.b.b.a().setClkActType(1);
            com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) this.b.b, true);
        }
    }
}
