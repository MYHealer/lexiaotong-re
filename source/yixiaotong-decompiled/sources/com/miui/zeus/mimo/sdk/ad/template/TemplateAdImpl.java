package com.miui.zeus.mimo.sdk.ad.template;

import android.os.Handler;
import android.view.ViewGroup;
import com.miui.zeus.mimo.sdk.ADParams;
import com.miui.zeus.mimo.sdk.TemplateAd;
import com.miui.zeus.mimo.sdk.a7;
import com.miui.zeus.mimo.sdk.base.BaseAdImpl;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.i3;
import com.miui.zeus.mimo.sdk.m4;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class TemplateAdImpl extends BaseAdImpl implements i3 {
    public static final String x = null;
    public TemplateAd.TemplateAdInteractionListener m;
    public TemplateAd.TemplateAdLoadListener n;
    public TemplateUIController o;
    public ViewGroup p;
    public int q;
    public long r;
    public int s;
    public boolean t = true;
    public Handler u;
    public a v;
    public long w;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{113, this});
        }
    }

    static {
        NCall.IV(new Object[]{63});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void a(long j) {
        NCall.IV(new Object[]{64, this, Long.valueOf(j)});
    }

    public void a(ViewGroup viewGroup, TemplateAd.TemplateAdInteractionListener templateAdInteractionListener) {
        NCall.IV(new Object[]{65, this, viewGroup, templateAdInteractionListener});
    }

    public void a(ADParams aDParams, TemplateAd.TemplateAdLoadListener templateAdLoadListener) {
        NCall.IV(new Object[]{66, this, aDParams, templateAdLoadListener});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void a(MimoAdInfo mimoAdInfo) {
        NCall.IV(new Object[]{67, this, mimoAdInfo});
    }

    public void a(MimoAdError mimoAdError, m4 m4Var) {
        NCall.IV(new Object[]{68, this, mimoAdError, m4Var});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void a(boolean z) {
        NCall.IV(new Object[]{69, this, Boolean.valueOf(z)});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public int b(MimoAdInfo mimoAdInfo) {
        return NCall.II(new Object[]{70, this, mimoAdInfo});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void b() {
        NCall.IV(new Object[]{71, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void b(a7 a7Var) {
        NCall.IV(new Object[]{72, this, a7Var});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public boolean c() {
        return NCall.IZ(new Object[]{73, this});
    }

    public final boolean c(MimoAdInfo mimoAdInfo) {
        return NCall.IZ(new Object[]{74, this, mimoAdInfo});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public boolean d() {
        return NCall.IZ(new Object[]{75, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void f() {
        NCall.IV(new Object[]{76, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void g() {
        NCall.IV(new Object[]{77, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void h() {
        NCall.IV(new Object[]{78, this});
    }

    @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
    public void onAdClick() {
        NCall.IV(new Object[]{79, this});
    }

    @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
    public void onAdDismissed() {
        NCall.IV(new Object[]{80, this});
    }

    @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
    public void onAdRenderFailed(int i, String str) {
        NCall.IV(new Object[]{81, this, Integer.valueOf(i), str});
    }

    @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
    public void onAdShow() {
        NCall.IV(new Object[]{82, this});
    }
}
