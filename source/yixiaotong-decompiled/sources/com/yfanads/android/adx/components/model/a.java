package com.yfanads.android.adx.components.model;

import android.view.ViewGroup;

/* JADX INFO: compiled from: ActionModel.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f9576a;
    public final int b;
    public final com.yfanads.android.adx.service.a c;
    public final boolean d;
    public final float e;
    public final boolean f;
    public com.yfanads.android.adx.interact.a.InterfaceC1172a g;
    public com.yfanads.android.adx.components.base.b h;

    public a(ViewGroup viewGroup, int i, com.yfanads.android.adx.service.a aVar, boolean z, float f, boolean z2, com.yfanads.android.adx.interact.a.InterfaceC1172a interfaceC1172a) {
        this.f9576a = viewGroup;
        this.b = i;
        this.c = aVar;
        this.d = z;
        this.e = f;
        this.g = interfaceC1172a;
        this.f = z2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        ViewGroup viewGroup = this.f9576a;
        return sb.append(viewGroup != null ? Integer.valueOf(viewGroup.hashCode()) : "null").append("|t_").append(this.c).append("|sd_").append(this.d).append("|at_").append(this.b).append("|vp_").append(this.e).append("|").append(this.f9576a != null ? "lister" : "null").toString();
    }
}
