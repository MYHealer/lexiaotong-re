package com.adprof.sdk;

import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adprof.sdk.api.AFNativeAdMediaView;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdRequest;
import com.adprof.sdk.api.NativeAdAllEventListener;
import com.adprof.sdk.api.NativeAdData;
import com.adprof.sdk.api.NativeAdEventListener;
import com.adprof.sdk.base.fb.FBView;
import com.google.android.material.badge.BadgeDrawable;
import com.huawei.openalliance.ad.constant.br;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Stack;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class f0 implements j, View.OnTouchListener, g0, ye, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Stack f1160a = new Stack();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f267a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AFNativeAdMediaView f272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NativeAdData.NativeAdMediaListener f273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NativeAdData f274a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NativeAdEventListener f275a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FBView f276a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f277a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k f278a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public q f279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public xe f280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ze f281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f284a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List f283a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashSet f282a = new HashSet();
    public boolean f = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View.OnAttachStateChangeListener f269a = new e0(this);

    public static boolean a(f0 f0Var) {
        wd wdVar;
        AdRequest adRequest;
        d dVar = f0Var.f277a;
        return (dVar == null || (wdVar = dVar.f190a) == null || (adRequest = wdVar.f794a) == null || !adRequest.isCloseAfterClick()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        b(4);
    }

    public final View a() {
        k kVar = this.f278a;
        if (kVar == null) {
            return null;
        }
        Object parent = kVar.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public xe m619a() {
        d dVar;
        if (this.f280a == null && (dVar = this.f277a) != null) {
            this.f280a = (xe) dVar.m590a();
        }
        return this.f280a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final void m620a() {
        AFNativeAdMediaView aFNativeAdMediaView = this.f272a;
        if (aFNativeAdMediaView == null) {
            return;
        }
        ViewParent parent = aFNativeAdMediaView.getParent();
        if (!(parent instanceof ViewGroup)) {
            a(0);
        } else {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.post(new s(this, viewGroup));
        }
    }

    public void a(Collection collection, View.OnTouchListener onTouchListener) {
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                View view = (View) it.next();
                if (view != null) {
                    if (m621a()) {
                        view.setOnClickListener(this);
                    } else {
                        view.setOnTouchListener(onTouchListener);
                    }
                }
            }
        }
    }

    public final void b() {
        try {
            AFNativeAdMediaView aFNativeAdMediaView = this.f272a;
            if (aFNativeAdMediaView != null && this.f277a != null) {
                this.f282a.add(aFNativeAdMediaView);
                d adUnit = this.f272a.getAdUnit();
                if (adUnit == null || !this.f277a.equals(adUnit)) {
                    this.f272a.init(this);
                }
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    public final void b(int i) {
        xe xeVarM619a;
        d dVar;
        String str;
        h2.a(this.f277a);
        if (i == 1) {
            try {
                m619a().m695a();
                return;
            } catch (Throwable th) {
                pk.b("openFourElements fail:", th);
                return;
            }
        }
        if (i == 2 || i == 3) {
            xeVarM619a = m619a();
            dVar = this.f277a;
            str = "2";
        } else {
            if (i != 4) {
                return;
            }
            xeVarM619a = m619a();
            dVar = this.f277a;
            str = "1";
        }
        xeVarM619a.a(dVar, str);
    }

    public final void c() {
        try {
            if (this.f272a == null) {
                return;
            }
            m620a();
            this.f272a.removeOnAttachStateChangeListener(this.f269a);
            this.f272a.addOnAttachStateChangeListener(this.f269a);
        } catch (Exception e) {
            pk.a(e);
            oh.b(e);
        }
    }

    public final void e() {
        try {
            ((a2) ((kl) Objects.requireNonNull(m618a()))).b(this.f277a);
        } catch (Throwable unused) {
        }
        ImageView imageView = this.f270a;
        if (imageView != null && imageView.getParent() != null) {
            ((ViewGroup) this.f270a.getParent()).removeView(this.f270a);
            this.f270a = null;
        }
        View viewA = a();
        if (viewA != null && viewA.getParent() != null) {
            ((ViewGroup) viewA.getParent()).removeView(viewA);
        }
        NativeAdEventListener nativeAdEventListener = this.f275a;
        if (nativeAdEventListener == null || !(nativeAdEventListener instanceof NativeAdAllEventListener)) {
            return;
        }
        ((NativeAdAllEventListener) nativeAdEventListener).onAdClose(viewA);
    }

    public void f() {
        if (AdprofSdk.getInstance().getContext() == null || !this.d) {
            return;
        }
        this.f282a.clear();
        q qVar = this.f279a;
        if (qVar != null) {
            qVar.b();
            f1160a.remove(this.f279a);
        }
        pk.a("------------onAdViewRemoved----------" + hashCode());
        j0 j0VarM617a = m617a();
        if (j0VarM617a != null) {
            ((k0) j0VarM617a).m666a();
        }
        this.c = false;
        k kVar = this.f278a;
        if (kVar != null) {
            kVar.hasWindowFocus();
        }
    }

    public void g() {
        if (this.d) {
            return;
        }
        this.d = true;
        pk.a("----------onAdViewShow------------" + hashCode());
        this.b = false;
        this.c = false;
        View viewA = a();
        if (viewA != null && !m621a()) {
            viewA.setOnTouchListener(this);
        }
        AFNativeAdMediaView aFNativeAdMediaView = this.f272a;
        if (aFNativeAdMediaView != null) {
            this.f282a.add(aFNativeAdMediaView);
        }
        q qVar = this.f279a;
        if (qVar != null) {
            this.f282a.add(qVar);
        }
        a(this.f283a, this);
        a(this.f282a, this);
    }

    public void h() {
        q qVar;
        q qVar2;
        if (this.f279a != null) {
            Stack stack = f1160a;
            if (!stack.isEmpty() && (qVar = (q) stack.lastElement()) != null && qVar == (qVar2 = this.f279a)) {
                qVar2.c();
            }
        }
        if (this.c) {
            return;
        }
        this.c = true;
        q qVar3 = this.f279a;
        if (qVar3 != null) {
            Stack stack2 = f1160a;
            if (!stack2.contains(qVar3)) {
                stack2.push(this.f279a);
                this.f279a.c();
            }
        }
        AFNativeAdMediaView aFNativeAdMediaView = this.f272a;
        if (aFNativeAdMediaView == null || aFNativeAdMediaView.getParent() == null) {
            return;
        }
        xe xeVarM619a = m619a();
        if (this.b || xeVarM619a == null) {
            return;
        }
        ((k0) m617a()).a(this.f277a);
    }

    public void i() {
        oh.a("landing_page_close", "", this.f277a);
    }

    public void j() {
        pk.c("--adprof NativeAdRender---onLandPageShow---");
        oh.a("landing_page_show", "", this.f277a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null || this.f277a == null) {
            return;
        }
        try {
            pk.a("----click mAppInfoView v " + view.getTag() + PPSLabelView.Code + view.getId());
            this.f277a.m591a().c((MotionEvent) null);
            List list = this.f283a;
            if (list != null) {
                View view2 = list.contains(view) ? view : null;
                if (view2 != null) {
                    pk.a("----click ctaClickView id " + view2.getId());
                    le.a(view2, this.f277a, new t(this, view2), "self_click_1");
                    return;
                }
            }
            HashSet hashSet = this.f282a;
            if (hashSet != null) {
                if (!hashSet.contains(view)) {
                    view = null;
                }
                if (view != null) {
                    pk.a("----click mCreativeViews id " + view.getId());
                    AFNativeAdMediaView aFNativeAdMediaView = this.f272a;
                    le.a(view, this.f277a, new u(this, aFNativeAdMediaView != null && aFNativeAdMediaView.isCtaClick(null)), "self_click_2");
                }
            }
        } catch (Throwable th) {
            pk.c("onClick error", th);
            oh.b(th);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View view2;
        if (motionEvent == null) {
            return false;
        }
        if ((motionEvent.getAction() != 0 || this.f268a <= 0 || System.currentTimeMillis() - this.f268a >= 500) && this.f277a != null) {
            try {
                if (motionEvent.getAction() != 1) {
                    this.f268a = System.currentTimeMillis();
                    this.f277a.m591a().a(motionEvent);
                    return true;
                }
                pk.a("----touch mAppInfoView v " + view.getTag() + PPSLabelView.Code + view.getId());
                this.f277a.m591a().c(motionEvent);
                pk.a("----touch " + view);
                List list = this.f283a;
                int i = 3;
                if (list != null) {
                    if (!list.contains(view)) {
                        List list2 = this.f283a;
                        if (list2 != null) {
                            Iterator it = list2.iterator();
                            do {
                                if (it.hasNext()) {
                                    view2 = (View) it.next();
                                }
                            } while (!hp.a(view2, motionEvent));
                        }
                        view2 = null;
                        break;
                    }
                    view2 = view;
                    if (view2 != null) {
                        pk.a("----touch ctaClickView id " + view2.getId());
                        if (view2.getId() == 102060003) {
                            b(1);
                        } else {
                            b(3);
                        }
                        return true;
                    }
                }
                if (!this.f282a.contains(view)) {
                    HashSet hashSet = this.f282a;
                    if (hashSet != null) {
                        Iterator it2 = hashSet.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                View view3 = (View) it2.next();
                                if (hp.a(view3, motionEvent)) {
                                    view = view3;
                                    break;
                                }
                            }
                        }
                    }
                    view = null;
                    break;
                }
                if (view != null) {
                    pk.a("----touch mCreativeViews id " + view.getId());
                    AFNativeAdMediaView aFNativeAdMediaView = this.f272a;
                    if (aFNativeAdMediaView == null || !aFNativeAdMediaView.isCtaClick(motionEvent)) {
                        i = 2;
                    }
                    b(i);
                    return true;
                }
            } catch (Throwable th) {
                pk.b("onTouch error", th);
            }
        }
        return false;
    }

    public final void a(ViewGroup viewGroup, String str) {
        d dVar;
        ul ulVarA;
        ViewGroup.LayoutParams layoutParams;
        z2 z2Var;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        ViewGroup.LayoutParams layoutParams4;
        if (pk.f594a) {
            pk.d("AFNativeAdRender addSelfControlView  portal = " + str);
        }
        int i = 0;
        try {
            if (this.f && viewGroup != null && this.f277a != null) {
                hp.m656a((View) this.f270a);
                ImageView imageView = new ImageView(viewGroup.getContext());
                this.f270a = imageView;
                imageView.setImageResource(R.drawable.adprof_ad_close);
                this.f270a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f270a.setVisibility(4);
                d dVar2 = this.f277a;
                int iA = (dVar2 == null || dVar2.d != 2) ? h8.a(25.0f) : h8.a(20.0f);
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iA, iA);
                    layoutParams5.addRule(11);
                    layoutParams5.addRule(15);
                    layoutParams5.setMargins(h8.a(10.0f), 0, 0, 0);
                    layoutParams4 = layoutParams5;
                } else {
                    FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(iA, iA);
                    layoutParams6.gravity = 21;
                    layoutParams6.setMargins(h8.a(10.0f), 0, 0, 0);
                    layoutParams4 = layoutParams6;
                }
                this.f270a.setOnClickListener(new c0(this, viewGroup));
                viewGroup.addView(this.f270a, layoutParams4);
                if (pk.f594a) {
                    pk.a("NativeAdRender", "Close button added to container at left center position, mcr=" + this.f277a.g + ", ranDom=" + this.f267a + ", buttonSize=" + iA);
                }
            }
        } catch (Throwable th) {
            pk.a(th);
        }
        if (viewGroup != null) {
            float f = 65;
            try {
                q qVarA = a(h8.a(f), h8.a(f));
                if (qVarA != null) {
                    hp.m656a((View) qVarA);
                    int iA2 = h8.a(f);
                    if (viewGroup instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(iA2, iA2);
                        layoutParams7.addRule(13);
                        layoutParams3 = layoutParams7;
                    } else {
                        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(iA2, iA2);
                        layoutParams8.gravity = 17;
                        layoutParams3 = layoutParams8;
                    }
                    viewGroup.addView(qVarA, layoutParams3);
                    qVarA.bringToFront();
                    qVarA.c();
                }
            } catch (Throwable th2) {
                pk.a(th2);
            }
        }
        if (viewGroup != null) {
            try {
                d dVar3 = this.f277a;
                if (dVar3 != null) {
                    try {
                        ul ulVarA2 = vl.a(dVar3);
                        if (ulVarA2 == null || "1".equals(ulVarA2.m)) {
                            FBView fBView = this.f276a;
                            if (fBView != null) {
                                hp.m656a((View) fBView);
                                this.f276a = null;
                            }
                            FBView fBView2 = new FBView(viewGroup.getContext());
                            this.f276a = fBView2;
                            fBView2.setAdUnit(this.f277a);
                            if (viewGroup instanceof RelativeLayout) {
                                RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(h8.a(48.0f), h8.a(28.0f));
                                layoutParams9.addRule(10);
                                layoutParams9.addRule(9);
                                layoutParams9.setMargins(h8.a(10.0f), h8.a(10.0f), 0, 0);
                                layoutParams2 = layoutParams9;
                            } else {
                                FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(h8.a(48.0f), h8.a(28.0f));
                                layoutParams10.gravity = 8388627;
                                layoutParams10.setMargins(h8.a(10.0f), h8.a(10.0f), 0, 0);
                                layoutParams2 = layoutParams10;
                            }
                            viewGroup.addView(this.f276a, layoutParams2);
                            this.f276a.post(new b0(this));
                        }
                    } catch (Exception e) {
                        pk.c("AFNativeAdRender addFeedbackView check feedbackEnable error", e);
                    }
                }
            } catch (Throwable th3) {
                pk.a(th3);
            }
        }
        try {
            TextView textView = this.f271a;
            if (textView != null) {
                hp.m656a((View) textView);
                this.f271a = null;
            }
            if (viewGroup != null && (dVar = this.f277a) != null && (ulVarA = vl.a(dVar)) != null && "1".equals(ulVarA.s)) {
                q0 q0Var = this.f277a.f188a;
                if (q0Var != null && (z2Var = q0Var.f643a) != null) {
                    i = z2Var.f1548a;
                }
                TextView textView2 = new TextView(viewGroup.getContext());
                this.f271a = textView2;
                textView2.setText(String.valueOf(i));
                this.f271a.setTextColor(-7829368);
                this.f271a.setTextSize(2, 12.0f);
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams11.addRule(20);
                    layoutParams11.addRule(12);
                    layoutParams11.setMarginStart(h8.a(8.0f));
                    layoutParams11.bottomMargin = h8.a(8.0f);
                    layoutParams = layoutParams11;
                } else {
                    FrameLayout.LayoutParams layoutParams12 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams12.gravity = BadgeDrawable.BOTTOM_START;
                    layoutParams12.setMarginStart(h8.a(8.0f));
                    layoutParams12.bottomMargin = h8.a(8.0f);
                    layoutParams = layoutParams12;
                }
                viewGroup.addView(this.f271a, layoutParams);
                this.f271a.bringToFront();
            }
        } catch (Throwable th4) {
            pk.a(th4);
        }
    }

    public final void a(int i) {
        int i2;
        if (i <= 0) {
            try {
                i = h8.b();
            } catch (Throwable th) {
                pk.a(th);
                oh.b(th);
                return;
            }
        }
        boolean z = false;
        if (i <= 0) {
            i2 = -2;
        } else {
            NativeAdData nativeAdData = this.f274a;
            int videoWidth = nativeAdData != null ? nativeAdData.getVideoWidth() : 0;
            NativeAdData nativeAdData2 = this.f274a;
            int videoHeight = nativeAdData2 != null ? nativeAdData2.getVideoHeight() : 0;
            i2 = (videoWidth <= 0 || videoHeight <= 0) ? (i * 9) / 16 : (i * videoHeight) / videoWidth;
        }
        ViewGroup.LayoutParams layoutParams = this.f272a.getLayoutParams();
        if (layoutParams == null) {
            this.f272a.setLayoutParams(new ViewGroup.LayoutParams(-1, i2));
            return;
        }
        if (layoutParams.width <= 0) {
            layoutParams.width = -1;
            z = true;
        }
        int i3 = layoutParams.height;
        if (i3 <= 0 || i3 == -2) {
            layoutParams.height = i2;
        } else if (!z) {
            return;
        }
        this.f272a.setLayoutParams(layoutParams);
    }

    public void a(ViewGroup viewGroup, int i, int i2, NativeAdData.NativeAdMediaListener nativeAdMediaListener) {
        wd wdVar;
        int i3;
        if (viewGroup == null) {
            return;
        }
        d dVar = this.f277a;
        viewGroup.post(new v(viewGroup, i2, i, (dVar == null || (wdVar = dVar.f190a) == null || (i3 = wdVar.d) <= 40) ? 0 : h8.a(i3 - 40)));
        AFNativeAdMediaView aFNativeAdMediaView = (AFNativeAdMediaView) hp.a(viewGroup, AFNativeAdMediaView.class);
        if (aFNativeAdMediaView == null) {
            aFNativeAdMediaView = new AFNativeAdMediaView(viewGroup.getContext());
        }
        this.f272a = aFNativeAdMediaView;
        hp.m656a((View) this.f272a);
        viewGroup.addView(this.f272a, new ViewGroup.LayoutParams(-1, -2));
        this.f282a.add(this.f272a);
        if (!this.f277a.equals(this.f272a.getAdUnit())) {
            this.f272a.init(this);
        }
        j0 videoAdController = this.f272a.getVideoAdController();
        pk.a("NativeAdRender invoke bindMediaView: ");
        if (videoAdController != null) {
            ((k0) videoAdController).f1257a = new w(this, nativeAdMediaListener);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public kl m618a() {
        d dVar = this.f277a;
        if (dVar == null) {
            return null;
        }
        kl klVar = dVar.f185a;
        if (klVar != null) {
            return klVar;
        }
        a2 a2Var = new a2();
        a2Var.a(dVar);
        return a2Var;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public j0 m617a() {
        AFNativeAdMediaView aFNativeAdMediaView = this.f272a;
        if (aFNativeAdMediaView != null) {
            return aFNativeAdMediaView.getVideoAdController();
        }
        return null;
    }

    public q a(int i, int i2) {
        d dVar;
        if (this.f279a == null && (dVar = this.f277a) != null && dVar.m590a() != null) {
            if (((n5) ((xe) this.f277a.m590a())).f510a == 1) {
                return null;
            }
            q qVar = new q(AdprofSdk.getInstance().getContext(), this.f277a);
            if (!qVar.a(100)) {
                return null;
            }
            qVar.setMotionActionListener(new ne() { // from class: com.adprof.sdk.f0$$ExternalSyntheticLambda0
                @Override // com.adprof.sdk.ne
                public final void a() {
                    this.f$0.d();
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h8.a(i), h8.a(i2));
            layoutParams.gravity = 17;
            qVar.setLayoutParams(layoutParams);
            this.f279a = qVar;
        }
        return this.f279a;
    }

    public void a(d dVar, NativeAdData nativeAdData) {
        this.f277a = dVar;
        this.f274a = nativeAdData;
        int iNextInt = new Random().nextInt(100) + 1;
        this.f267a = iNextInt;
        d dVar2 = this.f277a;
        dVar2.h = iNextInt;
        ze zeVar = new ze(this);
        this.f281a = zeVar;
        if (zeVar.f912a == null) {
            we weVar = new we(this, dVar2.k());
            zeVar.f912a = weVar;
            weVar.m715a();
        }
    }

    public void a(boolean z) {
        if (!this.f284a && z) {
            this.f284a = true;
            pk.a("NativeAdRender invoke onAdExposed " + this.f275a);
            if (m618a() != null) {
                kl klVarM618a = m618a();
                d dVar = this.f277a;
                xe xeVar = this.f280a;
                xeVar.getClass();
                HashMap map = new HashMap();
                int i = ((n5) xeVar).f510a;
                if (i > 0) {
                    map.put("shake_ad", Integer.valueOf(i));
                }
                int i2 = xeVar.c;
                if (i2 > 0) {
                    map.put("impress_p", Integer.valueOf(i2));
                }
                int i3 = xeVar.d;
                if (i3 > 0) {
                    map.put("impress_t", Integer.valueOf(i3));
                }
                int i4 = xeVar.f515b;
                if (i4 > 0) {
                    map.put("play_mute", Integer.valueOf(i4));
                }
                boolean z2 = ((n5) xeVar).f514a;
                if (!z2) {
                    map.put("dis_open_inapp", Boolean.valueOf(z2));
                }
                int i5 = ie.f1229a;
                ((a2) klVarM618a).a(dVar, br.b.V, map);
                n1.f1315a.m689a(this.f277a.e());
            }
            NativeAdEventListener nativeAdEventListener = this.f275a;
            if (nativeAdEventListener != null) {
                nativeAdEventListener.onAdExposed();
            }
        }
    }

    public void a(View view, List list, NativeAdEventListener nativeAdEventListener) {
        k kVar;
        if (view == null) {
            AdError adError = AdError.ERROR_AD_CONTAINER_IS_NULL;
            pk.b("NativeAdRender invoke onAdRenderFail " + nativeAdEventListener + " error = " + adError);
            if (nativeAdEventListener != null) {
                nativeAdEventListener.onAdRenderFail(adError);
                return;
            }
            return;
        }
        if (!(view instanceof ViewGroup)) {
            AdError adError2 = AdError.ERROR_AD_CONTAINER_NOT_VIEW_GROUP;
            pk.b("NativeAdRender invoke onAdRenderFail " + nativeAdEventListener + " error = " + adError2);
            if (nativeAdEventListener != null) {
                nativeAdEventListener.onAdRenderFail(adError2);
                return;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        d dVar = this.f277a;
        if (dVar != null) {
            boolean zBooleanValue = dVar.f190a.f794a.getIsExpressAd().booleanValue();
            pk.d("AFNativeAdRender   express = " + zBooleanValue);
            if (!zBooleanValue) {
                ViewTreeObserver viewTreeObserver = viewGroup.getViewTreeObserver();
                if (pk.f594a) {
                    pk.d(" \n AFNativeAdRender enter  registerViewForInteraction ------ \n");
                }
                a(viewGroup, "registerView");
                viewTreeObserver.addOnGlobalLayoutListener(new z(this, zBooleanValue, viewGroup));
            }
        }
        ((n5) m619a()).f511a = new a0(this);
        if (list != null) {
            this.f282a.clear();
            this.f283a = list;
            this.f282a.addAll(list);
        }
        this.f275a = nativeAdEventListener;
        k kVar2 = this.f278a;
        if (kVar2 != null) {
            hp.m656a((View) kVar2);
            viewGroup.addView(this.f278a, new ViewGroup.LayoutParams(1, 1));
        } else {
            int i = 0;
            while (true) {
                if (i >= viewGroup.getChildCount()) {
                    kVar = null;
                    break;
                }
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof k) {
                    kVar = (k) childAt;
                    break;
                }
                i++;
            }
            this.f278a = kVar;
            if (kVar == null) {
                k kVar3 = new k(AdprofSdk.getInstance().getContext(), null);
                this.f278a = kVar3;
                viewGroup.addView(kVar3, new ViewGroup.LayoutParams(1, 1));
            }
        }
        this.f278a.setAdVisibilityStatusChangeListener(this);
        k kVar4 = this.f278a;
        int i2 = m619a().c;
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 50;
        }
        int i3 = m619a().d;
        int i4 = i3 >= 0 ? i3 : 1;
        kVar4.c = false;
        if (kVar4.f410a != null) {
            kVar4.c();
            kVar4.f410a = null;
        }
        kVar4.f1256a = i2;
        kVar4.b = i4;
        kVar4.f410a = new i(kVar4, Looper.getMainLooper());
        kVar4.b();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final boolean m621a() {
        wd wdVar;
        AdRequest adRequest;
        d dVar = this.f277a;
        return (dVar == null || (wdVar = dVar.f190a) == null || (adRequest = wdVar.f794a) == null || !adRequest.getUseClick()) ? false : true;
    }
}
