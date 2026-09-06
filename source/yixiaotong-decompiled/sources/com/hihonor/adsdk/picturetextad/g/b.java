package com.hihonor.adsdk.picturetextad.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.picturetextad.h.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class b<VH extends com.hihonor.adsdk.picturetextad.h.d> extends com.hihonor.adsdk.base.widget.a.c<VH> {
    public b(BaseAd baseAd) {
        super(baseAd);
    }

    protected abstract int a();

    protected abstract VH a(View view);

    @Override // com.hihonor.adsdk.base.widget.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void hnadsa(VH vh) {
        com.hihonor.adsdk.common.b.b.hnadsc(d(), "onBindDataToHolder", new Object[0]);
        vh.a(this.hnadsa);
    }

    protected abstract int b();

    protected View b(Context context) {
        try {
            return LayoutInflater.from(context).inflate(c(), (ViewGroup) null);
        } catch (Throwable th) {
            com.hihonor.adsdk.common.b.b.hnadsb(d(), "onCreateView exception:" + th.getMessage(), new Object[0]);
            return null;
        }
    }

    protected int c() {
        int iA = com.hihonor.adsdk.picturetextad.i.a.a(this.hnadsa);
        if (iA == -1) {
            return com.hihonor.adsdk.base.j.c.hnadsb(this.hnadsa) ? a() : b();
        }
        return iA;
    }

    protected String d() {
        return getClass().getSimpleName();
    }

    @Override // com.hihonor.adsdk.base.widget.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public VH hnadsa(Context context) {
        View viewB = b(context);
        if (viewB == null) {
            return null;
        }
        return (VH) a(viewB);
    }
}
