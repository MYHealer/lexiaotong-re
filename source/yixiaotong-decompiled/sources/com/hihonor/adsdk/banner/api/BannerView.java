package com.hihonor.adsdk.banner.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.widget.base.BaseAdView;
import com.hihonor.adsdk.common.f.a0;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BannerView extends BaseAdView<BaseAd> {
    private static final String i = "BannerView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Timer f3496a;
    private b b;
    private boolean c;
    private boolean d;
    private long e;
    private int f;
    private int g;
    private final ViewTreeObserver.OnScrollChangedListener h;

    static /* synthetic */ class a {
    }

    private class b extends TimerTask {
        private b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (((BaseAdView) BannerView.this).mViewMonitor.hnadsd()) {
                com.hihonor.adsdk.common.b.b.hnadsc(BannerView.i, "倒计时结束，可见，立即刷新", new Object[0]);
                BannerView bannerView = BannerView.this;
                bannerView.a(((BaseAdView) bannerView).mAd);
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(BannerView.i, "倒计时结束，不可见，等到可见再刷新", new Object[0]);
                BannerView.this.c = true;
            }
            BannerView.this.d();
        }

        /* synthetic */ b(BannerView bannerView, a aVar) {
            this();
        }
    }

    public BannerView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        com.hihonor.adsdk.common.b.b.hnadsc(i, "stopTimer", new Object[0]);
        Timer timer = this.f3496a;
        if (timer != null) {
            timer.cancel();
            this.f3496a = null;
        }
        b bVar = this.b;
        if (bVar != null) {
            bVar.cancel();
            this.b = null;
        }
    }

    public void a(int i2, int i3) {
        this.f = i2;
        this.g = i3;
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView
    public void bindAd(BaseAd baseAd) throws IllegalArgumentException {
        super.bindAd(baseAd);
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(i, "bindAd,ad is null,return", new Object[0]);
            return;
        }
        com.hihonor.adsdk.banner.api.b bVar = new com.hihonor.adsdk.banner.api.b(baseAd);
        bVar.a(this.f, this.g);
        setAdapter(bVar);
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView
    protected void initView() {
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.hihonor.adsdk.common.b.b.hnadsc(i, "onAttachedToWindow", new Object[0]);
        getViewTreeObserver().addOnScrollChangedListener(this.h);
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.hihonor.adsdk.common.b.b.hnadsc(i, "onDetachedFromWindow", new Object[0]);
        d();
        getViewTreeObserver().removeOnScrollChangedListener(this.h);
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView
    protected void onImpression() {
        super.onImpression();
        com.hihonor.adsdk.common.b.b.hnadsc(i, "onImpression", new Object[0]);
        c();
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.hihonor.adsdk.common.b.b.hnadsc(i, "onWindowFocusChanged：" + z, new Object[0]);
        if (z) {
            c();
        }
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView, com.hihonor.adsdk.base.widget.base.IAdView
    public void release() {
        super.release();
        com.hihonor.adsdk.common.b.b.hnadsc(i, "release", new Object[0]);
        d();
        a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.banner.api.BannerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b();
            }
        });
    }

    public void setIntervalTime(long j) {
        this.e = j;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        getViewTreeObserver().removeOnScrollChangedListener(this.h);
    }

    public BannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = false;
        this.h = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.hihonor.adsdk.banner.api.BannerView$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.f$0.a();
            }
        };
    }

    public synchronized void c() {
        if (this.c) {
            com.hihonor.adsdk.common.b.b.hnadsc(i, "立即刷新", new Object[0]);
            a(this.mAd);
            this.c = false;
        } else {
            Ad ad = this.mAd;
            if (ad != 0 && ad.isCarousel()) {
                com.hihonor.adsdk.common.b.b.hnadsc(i, "支持轮播", new Object[0]);
                Timer timer = this.f3496a;
                if (timer != null && this.b != null) {
                    com.hihonor.adsdk.common.b.b.hnadse(i, "计时器未结束，无需重复计时", new Object[0]);
                    return;
                }
                if (this.e <= 0) {
                    com.hihonor.adsdk.common.b.b.hnadse(i, "端侧未设置轮播间隔，停止轮播", new Object[0]);
                    return;
                }
                if (timer == null) {
                    this.f3496a = new Timer();
                }
                if (this.b == null) {
                    this.b = new b(this, null);
                }
                this.f3496a.schedule(this.b, this.e);
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(i, "不支持轮播", new Object[0]);
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseAd baseAd) {
        com.hihonor.adsdk.common.b.b.hnadsc(i, "startRefresh", new Object[0]);
        if (baseAd != null) {
            c.a().c(baseAd.getAdUnitId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        boolean zHnadsd = this.mViewMonitor.hnadsd();
        com.hihonor.adsdk.common.b.b.hnadsc(i, "#TestScroll#isValidVisibleArea：" + zHnadsd, new Object[0]);
        if (!this.d && zHnadsd) {
            com.hihonor.adsdk.common.b.b.hnadsc(i, "从不可见到可见状态", new Object[0]);
            c();
        }
        this.d = zHnadsd;
    }
}
