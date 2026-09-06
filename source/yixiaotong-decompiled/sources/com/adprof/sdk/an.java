package com.adprof.sdk;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adprof.sdk.base.fb.FBView;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class an extends qm implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RelativeLayout f26a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FBView f27a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c2 f28a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k9 f29a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pe f30a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zl f31a;
    public FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public RelativeLayout f32b;
    public TextView g;

    public an(Context context, wd wdVar, d dVar, xl xlVar) {
        super(context, wdVar, dVar, xlVar);
        this.f1037a = 0L;
        this.f26a = (RelativeLayout) ((qm) this).d.findViewById(R.id.adprof_splash_shake_group);
        this.f32b = (RelativeLayout) ((qm) this).d.findViewById(R.id.adprof_splash_shake_layout);
        this.g = (TextView) ((qm) this).d.findViewById(R.id.adprof_splash_shake_text);
        this.b = (FrameLayout) ((qm) this).d.findViewById(R.id.adprof_cta_fl);
        View view = ((qm) this).d;
        if (view != null) {
            this.f27a = (FBView) view.findViewById(R.id.adprof_splash_feedback_view);
        }
    }

    private String getUrl() {
        d dVar = ((x0) this).f821a;
        String str = dVar.f204f;
        if (dVar.m605f()) {
            return ((x0) this).f821a.l();
        }
        return ((x0) this).f821a.m603d() ? ((x0) this).f821a.f204f : str;
    }

    @Override // com.adprof.sdk.qm
    public int a(Context context) {
        return R.layout.adprof_splash;
    }

    public final void e() {
        q0 q0Var;
        o1 o1Var;
        d dVar = ((x0) this).f821a;
        View view = ((qm) this).d;
        LinearLayout linearLayout = ((qm) this).f687b;
        LinearLayout linearLayout2 = ((qm) this).f689d;
        FrameLayout frameLayout = this.b;
        View view2 = ((qm) this).b;
        TextView textView = ((qm) this).f691e;
        TextView textView2 = this.f;
        Runnable runnable = new Runnable() { // from class: com.adprof.sdk.an$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.g();
            }
        };
        if (dVar == null || (q0Var = dVar.f188a) == null || (o1Var = q0Var.f639a) == null || !o1Var.f526c || view == null || linearLayout == null || linearLayout2 == null || !(view instanceof RelativeLayout)) {
            return;
        }
        try {
            sm.a(linearLayout, linearLayout2, frameLayout, view2);
            sm.a(view.getContext(), view2, textView, textView2, runnable);
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    public void f() {
        zl bmVar;
        o1 o1Var;
        d dVar = ((x0) this).f821a;
        if (dVar != null) {
            f7.a(((qm) this).f691e, this.f, dVar);
            q0 q0Var = ((x0) this).f821a.f188a;
            if (q0Var == null || (o1Var = q0Var.f639a) == null || !o1Var.f526c) {
                h6.a(((qm) this).b);
            }
            ((qm) this).f1390a.setVisibility(0);
            ((x0) this).f821a.getClass();
            d dVar2 = ((x0) this).f821a;
            int i = zl.f1560a;
            if (dVar2.m605f()) {
                bmVar = new lm(getContext(), this);
            } else {
                bmVar = dVar2.m603d() ? new bm(getContext(), this) : null;
            }
            this.f31a = bmVar;
            if (bmVar == null) {
                HashMap map = new HashMap();
                map.put("error", "splashAdContentView is null");
                s5.a(((x0) this).f821a.k(), map, "action.splash.play.error", 0);
                return;
            }
            bmVar.a(((x0) this).f821a);
            ((qm) this).f1390a.removeAllViews();
            ((qm) this).f1390a.addView(this.f31a);
            FrameLayout frameLayout = this.b;
            if (frameLayout != null) {
                frameLayout.setOnTouchListener(this);
            }
            View view = ((qm) this).b;
            if (view != null) {
                view.setOnTouchListener(this);
            }
            TextView textView = ((qm) this).f691e;
            if (textView != null) {
                textView.setOnTouchListener(this);
            }
            String url = getUrl();
            if (pk.f594a) {
                pk.a("SplashBaseView url =  " + url);
            }
            if (TextUtils.isEmpty(url)) {
                return;
            }
            xb.a(((x0) this).f817a).a(url, new um(this));
        }
    }

    public final void g() {
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.setOnTouchListener(this);
        }
        View view = ((qm) this).b;
        if (view != null) {
            view.setOnTouchListener(this);
        }
        TextView textView = ((qm) this).f691e;
        if (textView != null) {
            textView.setOnTouchListener(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            post(new ym(this));
        } catch (Throwable th) {
            pk.a(th);
            HashMap map = new HashMap();
            map.put("error", "Exception: " + th.getMessage());
            d dVar = ((x0) this).f821a;
            s5.a(dVar != null ? dVar.k() : "", map, "action.splash.play.error", 0);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.adprof.sdk.qm, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            c2 c2Var = this.f28a;
            if (c2Var != null) {
                c2Var.b();
                this.f28a = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            if (motionEvent.getAction() == 0) {
                ((x0) this).f821a.m591a().a(motionEventObtain);
            } else if (motionEvent.getAction() == 1 && System.currentTimeMillis() - this.f1037a > 800) {
                this.f1037a = System.currentTimeMillis();
                ((x0) this).f821a.m591a().c(motionEventObtain);
                if (((x0) this).f821a == null) {
                    pk.b("---handleClick adUnit exception");
                } else {
                    c("2");
                }
            }
            pk.a("SplashBaseView", "--------onTouch----------: " + motionEvent.getAction());
        } catch (Throwable th) {
            pk.b("splash click macro set error", th);
            oh.b(th);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            zl zlVar = this.f31a;
            if (zlVar != null) {
                zlVar.d();
            }
            super.setVisibility(i);
        }
    }
}
