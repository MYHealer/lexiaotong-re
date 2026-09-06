package com.adprof.sdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ak implements xg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jk f1034a;

    public ak(jk jkVar) {
        this.f1034a = jkVar;
    }

    @Override // com.adprof.sdk.xg
    public View a(int i) {
        return this.f1034a.findViewById(i);
    }

    @Override // com.adprof.sdk.xg
    public View a(Context context, int i, ViewGroup viewGroup) {
        return FrameLayout.inflate(context, i, null);
    }

    @Override // com.adprof.sdk.xg
    public TextView a() {
        return ((yj) this.f1034a).f876e;
    }

    @Override // com.adprof.sdk.xg
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo575a() {
    }

    @Override // com.adprof.sdk.xg
    public void b() {
        this.f1034a.b("7");
    }
}
