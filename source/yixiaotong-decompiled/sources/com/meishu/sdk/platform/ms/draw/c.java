package com.meishu.sdk.platform.ms.draw;

import android.view.View;
import com.meishu.sdk.core.safe.o;

/* JADX INFO: compiled from: MeishuDrawAdWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.a f5165a;

    public c(f.a aVar) {
        this.f5165a = aVar;
    }

    @Override // com.meishu.sdk.core.safe.o
    public void safeOnClick(View view) {
        if (f.this.f5168a.e.getInteractionListener() != null) {
            f.this.f5168a.e.getInteractionListener().onAdClosed();
        }
    }
}
