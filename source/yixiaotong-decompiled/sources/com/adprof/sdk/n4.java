package com.adprof.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdRequest;
import com.adprof.sdk.api.BannerAdListener;
import com.adprof.sdk.api.BannerSize;
import com.huawei.openalliance.ad.constant.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class n4 extends p5 implements q1.a {
    public static long b = 10000;
    public static final boolean g = pk.f594a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FrameLayout f498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BannerAdListener f499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g5 f500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public q f501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List f503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set f504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f505a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f506b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Handler f507b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Runnable f508b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f509b;
    public boolean c;
    public final boolean d;
    public boolean e;
    public boolean f;

    public n4(AdRequest adRequest, BannerAdListener bannerAdListener, boolean z, boolean z2) {
        super(adRequest);
        this.f497a = new Handler(Looper.getMainLooper());
        this.f1318a = 0;
        this.f505a = false;
        this.f509b = true;
        this.f503a = new ArrayList();
        this.f506b = 0;
        this.f507b = new Handler(Looper.getMainLooper());
        this.c = true;
        this.f504a = new HashSet();
        this.f502a = new d4(this);
        this.f508b = new f4(this);
        this.f = true;
        FrameLayout frameLayout = this.f498a;
        this.f496a = frameLayout != null ? frameLayout.getContext() : AdprofSdk.getInstance().getContext();
        this.f499a = bannerAdListener;
        this.d = z;
        this.e = z2;
        ((p5) this).f549a = new wd(adRequest, 3);
        pk.a("BannerAdManager init closeButton: " + z + " devAutoRefreshEnabled =  " + z2);
    }

    public static boolean a(n4 n4Var) {
        FrameLayout frameLayout = n4Var.f498a;
        return (frameLayout == null || frameLayout.getParent() == null) ? false : true;
    }

    public final ViewGroup.LayoutParams a(BannerSize bannerSize) {
        int iA = h8.a(bannerSize.getHeight());
        if (m692a()) {
            if (this.f498a == null) {
                return new ViewGroup.LayoutParams(-1, iA);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, iA);
            layoutParams.gravity = 1;
            return layoutParams;
        }
        int width = ((ViewGroup) this.f498a.getParent()).getWidth();
        int iA2 = h8.a(bannerSize.getWidth());
        if (width > 0) {
            iA2 = Math.min(width, iA2);
        }
        if (this.f498a == null) {
            return new ViewGroup.LayoutParams(iA2, iA);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA2, iA);
        layoutParams2.gravity = 1;
        return layoutParams2;
    }

    public ViewGroup a() {
        pk.a("BannerAdManager getmInnerContainer");
        if (((p5) this).f546a != null) {
            b = ((long) 10) * 1000;
        }
        if (this.f498a == null) {
            this.f498a = new FrameLayout(this.f496a);
        }
        BannerSize bannerSizeM690a = m690a();
        int iA = h8.a(bannerSizeM690a.getWidth());
        int iA2 = h8.a(bannerSizeM690a.getHeight());
        AdRequest adRequest = ((p5) this).f1357a;
        if (adRequest != null && adRequest.isBannerWidthFullParent()) {
            iA = -1;
        }
        this.f498a.setLayoutParams(new ViewGroup.LayoutParams(iA, iA2));
        a(((p5) this).f546a);
        this.f498a.addOnAttachStateChangeListener(new c4(this, bannerSizeM690a));
        hp.m656a((View) this.f498a);
        return this.f498a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final BannerSize m690a() {
        AdRequest adRequest;
        wd wdVar = ((p5) this).f549a;
        return (wdVar == null || (adRequest = wdVar.f794a) == null || adRequest.getBannerSize() == null) ? BannerSize.SIZE_320_50 : ((p5) this).f549a.f794a.getBannerSize();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final void m691a() {
        try {
            if (this.f501a != null) {
                pk.d("BannerAdManager: Destroying old shake view before creating new one");
                this.f501a.b();
                this.f501a.a();
                hp.m656a((View) this.f501a);
                this.f501a = null;
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    @Override // com.adprof.sdk.p5
    public void a(Activity activity) {
        try {
            if (this.f495a == activity) {
                pk.a("BannerAdManager - Activity onResume: " + activity.getClass().getSimpleName());
                this.f = true;
                if (!this.e) {
                    s4.m714a(((p5) this).f546a);
                }
                if (this.f503a.size() > 1) {
                    e();
                }
                d();
                q qVar = this.f501a;
                if (qVar == null || qVar.getParent() == null) {
                    return;
                }
                this.f501a.c();
            }
        } catch (Exception e) {
            pk.a(e);
            oh.b(e);
        }
    }

    public final void a(FrameLayout frameLayout) {
        if (frameLayout == null || ((p5) this).f546a == null) {
            return;
        }
        try {
            m691a();
            n5 n5VarM590a = ((p5) this).f546a.m590a();
            if (n5VarM590a == null || n5VarM590a.f510a == 1) {
                return;
            }
            int iA = h8.a(45);
            q qVar = new q(this.f496a, ((p5) this).f546a);
            this.f501a = qVar;
            if (!qVar.a(100)) {
                pk.a("BannerAdManager: Failed to init shake widget view");
                return;
            }
            this.f501a.setMotionActionListener(new k4(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
            layoutParams.gravity = 17;
            hp.m656a((View) this.f501a);
            frameLayout.addView(this.f501a, layoutParams);
            this.f501a.bringToFront();
            this.f501a.c();
            pk.d("BannerAdManager: Shake view added to banner");
        } catch (Throwable th) {
            pk.b("BannerAdManager: Error adding shake view", th);
            oh.b(th);
        }
    }

    @Override // com.adprof.sdk.p5
    public void a(AdError adError) {
        BannerAdListener bannerAdListener = this.f499a;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerAdLoadError(adError);
        }
    }

    public final void a(d dVar) {
        if (dVar == null) {
            return;
        }
        g5 g5VarA = h5.a(this.f496a, dVar, this.d, m690a(), m692a());
        g5VarA.setOnBannerTouchListener(new m4(dVar, this));
        g5VarA.setOnBannerCloseListener(new l4(this));
        this.f500a = g5VarA;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final boolean m692a() {
        AdRequest adRequest = ((p5) this).f1357a;
        return adRequest != null && adRequest.isBannerWidthFullParent();
    }

    public final boolean a(View view) {
        try {
            if (view instanceof po) {
                ((po) view).d();
                pk.a("BannerAdManager stopCurrentBannerVideo - 停止视频播放");
                return true;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    if (a(viewGroup.getChildAt(i))) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    public void b() {
        if (this.f499a != null) {
            d dVar = ((p5) this).f546a;
            if (dVar == null || !dVar.m600b()) {
                this.f499a.onBannerAdClick();
            } else {
                pk.d("banner onAdClicked --------- mc ");
            }
        }
    }

    @Override // com.adprof.sdk.p5
    public void b(Activity activity) {
        try {
            if (this.f495a == activity) {
                pk.a("BannerAdManager - Activity onPause: " + activity.getClass().getSimpleName());
                this.f = false;
                g();
                h();
                f();
                q qVar = this.f501a;
                if (qVar != null) {
                    qVar.b();
                }
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    public void c() {
        if (this.f) {
            FrameLayout frameLayout = this.f498a;
            if (frameLayout != null && frameLayout.getParent() != null) {
                try {
                    ViewGroup viewGroup = (ViewGroup) this.f498a.getParent();
                    DisplayMetrics displayMetrics = this.f498a.getContext().getResources().getDisplayMetrics();
                    int i = displayMetrics.widthPixels;
                    int width = viewGroup.getWidth();
                    int height = viewGroup.getHeight();
                    boolean z = true;
                    boolean z2 = width < i / 2;
                    int i2 = (int) (30 * displayMetrics.density);
                    if (height >= i2) {
                        z = false;
                    }
                    if (z2 || z) {
                        pk.a("BannerAdManager - 父容器尺寸不满足曝光要求: width=" + width + " (screenWidth/2=" + (i / 2) + "), height=" + height + " (minHeight=" + i2 + "px)");
                    } else {
                        if (this.f498a.getVisibility() == 0 && viewGroup.getVisibility() == 0) {
                            d dVar = ((p5) this).f546a;
                            if (dVar != null) {
                                try {
                                    dVar.a(((ViewGroup) this.f498a.getParent()).getWidth(), ((ViewGroup) this.f498a.getParent()).getHeight());
                                } catch (Throwable th) {
                                    pk.a(th);
                                    oh.b(th);
                                }
                                d dVar2 = ((p5) this).f546a;
                                StringBuilder sb = new StringBuilder();
                                sb.append(dVar2.k);
                                String string = sb.length() == 0 ? "" : sb.toString();
                                if (this.f504a.contains(string)) {
                                    return;
                                }
                                this.f504a.add(string);
                                if (((p5) this).f546a != null) {
                                    mo698a().a(((p5) this).f546a, br.b.V, s4.a((HashMap) null));
                                }
                                BannerAdListener bannerAdListener = this.f499a;
                                if (bannerAdListener != null) {
                                    bannerAdListener.onBannerAdShow();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        pk.d("mInnerContainer 不可见");
                    }
                } catch (Throwable th2) {
                    pk.b("BannerAdManager - 检查父容器尺寸时出错", th2);
                    oh.b(th2);
                }
            }
            if (((p5) this).f546a != null) {
                AdError adError = AdError.ERROR_AD_CONTAINER_VISIBILITY;
                adError.setMessage("父容器尺寸不满足展示要求，宽度不小于屏幕宽度的一半，高度不小于30dp");
                d dVar3 = ((p5) this).f546a;
                oh.a(br.b.V, adError, dVar3.f190a, dVar3);
            }
            if (this.f499a != null) {
                AdError adError2 = AdError.ERROR_AD_CONTAINER_VISIBILITY;
                adError2.setMessage("父容器尺寸不满足展示要求，宽度不小于屏幕宽度的一半，高度不小于30dp");
                this.f499a.onBannerAdShowError(adError2);
            }
        }
    }

    @Override // com.adprof.sdk.q1.a
    public void c(Activity activity) {
    }

    public final void d() {
        boolean z = this.e || s4.m714a(((p5) this).f546a);
        if (this.f505a || !z) {
            return;
        }
        if (this.f1318a >= 3) {
            pk.a("BannerAdManager reached 3 consecutive no-fill, stop refresh");
            return;
        }
        if (g) {
            pk.a("BannerAdManager startRefresh ");
        }
        this.f497a.removeCallbacks(this.f502a);
        this.f497a.postDelayed(this.f502a, this.f494a);
    }

    @Override // com.adprof.sdk.q1.a
    public void d(Activity activity) {
    }

    public void e() {
        if (this.f503a.size() <= 1) {
            pk.a("BannerAdManager startSwitch - 广告素材数量为" + this.f503a.size() + "，不启动轮播");
            return;
        }
        if (this.c) {
            pk.a("BannerAdManager startSwitch - 轮播已经在运行中，跳过");
            return;
        }
        if (g) {
            pk.a("BannerAdManager startSwitch ");
        }
        this.c = true;
        this.f507b.removeCallbacks(this.f508b);
        this.f507b.postDelayed(this.f508b, b);
    }

    @Override // com.adprof.sdk.q1.a
    public void e(Activity activity) {
    }

    public final void f() {
        if (this.f500a == null) {
            return;
        }
        fn.a(new i4(this), 0L);
    }

    public void g() {
        if (g) {
            pk.a("BannerAdManager stopAutoRefresh ");
        }
        this.f497a.removeCallbacks(this.f502a);
    }

    @Override // com.adprof.sdk.p5
    public int getBidPrice() {
        int i;
        try {
            List list = this.f503a;
            if (list != null && !list.isEmpty()) {
                int i2 = 0;
                for (d dVar : this.f503a) {
                    if (dVar != null && (i = dVar.b) > i2) {
                        i2 = i;
                    }
                }
                return i2;
            }
            return 0;
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
            return 0;
        }
    }

    public void h() {
        if (g) {
            pk.a("BannerAdManager stopSwitch ");
        }
        this.c = false;
        this.f507b.removeCallbacks(this.f508b);
    }

    public static void a(n4 n4Var, d dVar) {
        if (n4Var.f498a == null || dVar == null) {
            return;
        }
        n4Var.f();
        n4Var.m691a();
        BannerSize bannerSizeM690a = n4Var.m690a();
        g5 g5VarA = h5.a(n4Var.f496a, dVar, n4Var.d, bannerSizeM690a, n4Var.m692a());
        g5VarA.setOnBannerTouchListener(new m4(dVar, n4Var));
        g5VarA.setOnBannerCloseListener(new l4(n4Var));
        ViewGroup.LayoutParams layoutParamsA = n4Var.a(bannerSizeM690a);
        if (n4Var.f500a == null || n4Var.f498a.getChildCount() <= 0) {
            n4Var.f498a.addView(g5VarA, layoutParamsA);
            n4Var.f500a = g5VarA;
            n4Var.a(n4Var.f498a);
            return;
        }
        FrameLayout frameLayout = n4Var.f498a;
        g5 g5Var = n4Var.f500a;
        j4 j4Var = new j4(n4Var);
        if (frameLayout != null) {
            frameLayout.addView(g5VarA, layoutParamsA);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(600L);
            translateAnimation.setInterpolator(new DecelerateInterpolator());
            if (g5Var == null) {
                translateAnimation.setAnimationListener(new p4(j4Var, g5VarA));
                g5VarA.startAnimation(translateAnimation);
                return;
            }
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation2.setDuration(600L);
            translateAnimation2.setInterpolator(new DecelerateInterpolator());
            translateAnimation2.setAnimationListener(new o4(frameLayout, g5Var, j4Var, g5VarA));
            g5VarA.startAnimation(translateAnimation);
            g5Var.startAnimation(translateAnimation2);
        }
    }

    public static void a(n4 n4Var, ViewGroup viewGroup) {
        n4Var.getClass();
        if (viewGroup == null) {
            return;
        }
        try {
            ViewParent parent = viewGroup.getParent();
            if (parent instanceof ViewGroup) {
                Context context = ((ViewGroup) parent).getContext();
                if (context instanceof Activity) {
                    n4Var.f495a = (Activity) context;
                    q1.m710a().a(n4Var);
                    pk.a("BannerAdManager - 注册 Activity 生命周期监听: " + n4Var.f495a.getClass().getSimpleName());
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.adprof.sdk.p5
    /* JADX INFO: renamed from: a */
    public a2 mo698a() {
        a2 a2Var = new a2();
        d dVar = ((p5) this).f546a;
        if (dVar != null) {
            a2Var.a(dVar);
            ((p5) this).f546a.f185a = a2Var;
        }
        return a2Var;
    }

    @Override // com.adprof.sdk.p5
    public void a(int i, String str, String str2, wd wdVar) {
        ((p5) this).f548a = i2.AdStatusNone;
        this.f1318a++;
        pk.c("BannerAdManager onErrorResponse code=" + i + " msg=" + str);
        this.f509b = false;
        d();
        AdError adError = AdError.getAdError(i);
        if (adError == null) {
            adError = AdError.ERROR_AD_REQUEST;
            adError.setMessage(str);
        }
        oh.a("respond", adError, ((p5) this).f549a, ((p5) this).f546a);
        fn.a(new h4(this, adError));
    }

    @Override // com.adprof.sdk.p5
    public void a(List list, wd wdVar) {
        try {
            if (this.f505a) {
                return;
            }
            if (list.isEmpty()) {
                pk.c("BannerAdManager onSuccess no fill");
                a(AdError.ERROR_AD_REQUEST.getErrorCode(), "no fill", null, wdVar);
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar != null) {
                    wd wdVar2 = ((p5) this).f549a;
                    try {
                        fh fhVar = new fh();
                        ((mh) fhVar).f468b = "100";
                        if (wdVar2 != null && wdVar2.f793a > 0) {
                            fhVar.f294a = System.currentTimeMillis() - wdVar2.f793a;
                            wdVar2.f793a = System.currentTimeMillis();
                        }
                        fhVar.a("respond");
                        oh.a(dVar, fhVar);
                        oh.a(wdVar2, fhVar);
                        oh.a(fhVar);
                        ((mh) fhVar).f469c = new JSONObject(new HashMap()).toString();
                        fhVar.mo685a();
                    } catch (Throwable th) {
                        oh.b(th);
                        pk.d("sendPointEvent = " + Log.getStackTraceString(th));
                    }
                }
            }
            pk.c("BannerAdManager onSuccess - 获取到新广告素材，清除旧广告");
            pk.a("BannerAdManager clearPreviousAd - 清除旧广告状态");
            this.f504a.clear();
            h();
            f();
            this.f500a = null;
            this.f503a.clear();
            this.f506b = 0;
            this.f1318a = 0;
            boolean z = this.f509b;
            this.f509b = false;
            this.f503a.clear();
            this.f503a.addAll(list);
            d dVar2 = (d) this.f503a.get(0);
            ((p5) this).f546a = dVar2;
            this.f506b = 0;
            ((p5) this).f548a = i2.AdStatusReady;
            if (!this.e) {
                s4.m714a(dVar2);
            }
            this.f494a = ((long) s4.a(((p5) this).f546a)) * 1000;
            fn.a(new g4(this, z, wdVar));
        } catch (Throwable th2) {
            pk.a(th2);
        }
    }

    public final void a(boolean z) {
        try {
            this.f494a = ((long) s4.a(((p5) this).f546a)) * 1000;
            if (this.f505a) {
                return;
            }
            String string = UUID.randomUUID().toString();
            ((p5) this).b = string;
            wd wdVar = ((p5) this).f549a;
            wdVar.f797b = string;
            a(wdVar);
            new ha(((p5) this).f549a).a(this);
            pk.a("BannerAdManager requestOnce loadId=" + ((p5) this).b + (z ? " first" : ""));
        } catch (Throwable th) {
            pk.b("BannerAdManager request error", th);
        }
    }
}
