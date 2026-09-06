package com.hihonor.adsdk.interstitial.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.g;
import com.hihonor.adsdk.base.g.j.d.h;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.common.b.b;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.interstitial.R;
import com.hihonor.adsdk.interstitial.e;
import com.huawei.openalliance.ad.constant.ba;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a {
    private static final String g = "BaseAdapter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected BaseAd f3528a;
    protected Activity b;
    protected RelativeLayout c;
    protected FrameLayout d;
    private final int e = 0;
    private int f;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        if (!e.h(this.f3528a)) {
            b.hnadsc(g, "handleLandscapeAdaptNavigationBar screen is not landscape", new Object[0]);
            return;
        }
        Context context = HnAds.get().getContext();
        if (context == null) {
            b.hnadsc(g, "handleLandscapeAdaptNavigationBar context is null", new Object[0]);
            return;
        }
        if (j.hnadsl() && !j.hnadsj()) {
            b.hnadsc(g, "handleLandscapeAdaptNavigationBar device is foldingScreenFull and is not FlipFoldable", new Object[0]);
            a(0);
        } else {
            if (j.hnadsf(context)) {
                b.hnadsc(g, "handleLandscapeAdaptNavigationBar device is isPad", new Object[0]);
                return;
            }
            int iHnadsc = u.hnadsc();
            boolean zHnadsj = u.hnadsj();
            b.hnadsc(g, "handleLandscapeAdaptNavigationBar navigationBarHeight = %s, isNavigationBarShow = %s", Integer.valueOf(iHnadsc), Boolean.valueOf(zHnadsj));
            if (zHnadsj) {
                a(iHnadsc);
            } else {
                a(0);
            }
        }
    }

    public int a() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }

    protected void c() {
        b.hnadsc(g, "handleLandscapeAdaptNavigationBar", new Object[0]);
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout == null) {
            b.hnadsc(g, "handleLandscapeAdaptNavigationBar adRootView is null", new Object[0]);
        } else {
            relativeLayout.post(new Runnable() { // from class: com.hihonor.adsdk.interstitial.adapter.a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.d();
                }
            });
        }
    }

    public void e() {
        b.hnadsc(g, "pause", new Object[0]);
    }

    public void f() {
        b.hnadsc(g, "refreshView", new Object[0]);
    }

    public void g() {
        this.f3528a = null;
        this.b = null;
    }

    public void h() {
        b.hnadsc(g, ba.ag, new Object[0]);
    }

    public void b() {
        b.hnadsc(g, "handleAdClose", new Object[0]);
        if (Objects.isNull(this.f3528a)) {
            b.hnadsc(g, "handleAdClose mBaseAd is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.f3528a);
        BaseAd baseAd = this.f3528a;
        new h(baseAd, baseAd.getAdUnitId(), aVarHnadsa).hnadse();
        new g(this.f3528a.getAdUnitId(), aVarHnadsa, "close").hnadse();
        if (Objects.nonNull(this.b)) {
            this.b.finish();
        }
    }

    public void a(BaseAd baseAd, Activity activity) {
        this.f3528a = baseAd;
        this.b = activity;
        if (Objects.isNull(activity)) {
            b.hnadsc(g, "init mContext is null", new Object[0]);
        } else {
            this.c = (RelativeLayout) this.b.findViewById(R.id.interstitial_ad_view);
            this.d = (FrameLayout) this.b.findViewById(R.id.media_container_layout);
        }
    }

    private void a(int i) {
        b.hnadsc(g, "setAdRootViewWidth rightMarginValue = %d", Integer.valueOf(i));
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout == null) {
            b.hnadsc(g, "setAdRootViewWidth adRootView is null", new Object[0]);
        } else if (relativeLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            b.hnadsc(g, "setAdRootViewWidth adRootView getLayoutParams is instanceof FrameLayout.LayoutParams", new Object[0]);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.rightMargin = i;
            this.c.setLayoutParams(layoutParams);
        }
    }

    protected void a(View view, int i, int i2) {
        b.hnadsc(g, "setViewWidthAndHeight", new Object[0]);
        if (Objects.isNull(view)) {
            b.hnadse(g, "setViewWidthAndHeight target view is null!", new Object[0]);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }
}
