package com.adprof.sdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class yc implements xg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hd f1537a;

    public yc(hd hdVar) {
        this.f1537a = hdVar;
    }

    @Override // com.adprof.sdk.xg
    public View a(int i) {
        return this.f1537a.findViewById(i);
    }

    @Override // com.adprof.sdk.xg
    public View a(Context context, int i, ViewGroup viewGroup) {
        return FrameLayout.inflate(context, i, null);
    }

    @Override // com.adprof.sdk.xg
    public TextView a() {
        return ((vc) this.f1537a).f783e;
    }

    @Override // com.adprof.sdk.xg
    /* JADX INFO: renamed from: a */
    public void mo575a() {
    }

    @Override // com.adprof.sdk.xg
    public void b() {
        this.f1537a.b("7");
    }
}
