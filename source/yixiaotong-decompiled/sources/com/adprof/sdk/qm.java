package com.adprof.sdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adprof.sdk.api.AdRequest;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class qm extends x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f1390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l8 f684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public xl f685a;
    public View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ImageView f686b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public LinearLayout f687b;
    public View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public LinearLayout f688c;
    public View d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public LinearLayout f689d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public TextView f690d;
    public LinearLayout e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public TextView f691e;
    public TextView f;

    public qm(Context context, wd wdVar, d dVar, xl xlVar) {
        super(context, dVar);
        setBackgroundColor(-16777216);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f685a = xlVar;
        ((x0) this).f821a = dVar;
        View viewInflate = FrameLayout.inflate(context, a(context), null);
        this.d = viewInflate;
        addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        this.f683a = (ImageView) this.d.findViewById(R.id.adprof_splash_blur_image);
        this.f687b = (LinearLayout) this.d.findViewById(R.id.adprof_splash_sound_and_skip_layout);
        this.f688c = (LinearLayout) this.d.findViewById(R.id.adprof_splash_skip_ll);
        this.f690d = (TextView) this.d.findViewById(R.id.adprof_splash_skip_text);
        this.f686b = (ImageView) this.d.findViewById(R.id.adprof_splash_sound_image);
        this.f1390a = (FrameLayout) this.d.findViewById(R.id.adprof_splash_post_media);
        this.f689d = (LinearLayout) this.d.findViewById(R.id.adprof_splash_icon_text_layout);
        this.b = this.d.findViewById(R.id.adprof_splash_cta_ll);
        this.f691e = (TextView) this.d.findViewById(R.id.adprof_splash_cta_bt);
        this.f = (TextView) this.d.findViewById(R.id.adprof_splash_cta_bt_bottom);
        View viewFindViewById = this.d.findViewById(R.id.adprof_splash_cta_bt_gd);
        this.c = viewFindViewById;
        if (viewFindViewById != null) {
            xlVar.getClass();
            this.c.setVisibility(0);
        }
        this.e = (LinearLayout) this.d.findViewById(R.id.adprof_splash_privacy_ll);
        z0.a(context, this.d, R.id.adprof_splash_logo_image, dVar);
        this.f688c.setOnClickListener(new mm(this));
        c();
    }

    public abstract int a(Context context);

    @Override // com.adprof.sdk.x0
    public void a() {
        d();
    }

    @Override // com.adprof.sdk.x0
    public void b(String str) {
        if (((x0) this).f821a == null) {
            pk.b("---handleClick adUnit exception");
        } else {
            c(str);
        }
    }

    public final void c() {
        try {
            LinearLayout linearLayout = this.e;
            if (linearLayout == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) linearLayout.getChildAt(0);
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                ((TextView) viewGroup.getChildAt(i)).getPaint().setFlags(9);
            }
            d dVar = ((x0) this).f821a;
            if (dVar.c != 3 || dVar.f196a == null) {
                this.e.setVisibility(8);
                return;
            }
            try {
                this.e.setOnTouchListener(new om(this));
            } catch (Throwable th) {
                pk.b("showPrivacy error ", th);
            }
        } catch (Throwable th2) {
            pk.b("Splash addBaseLine error: ", th2);
        }
    }

    public final void d() {
        l8 l8Var = this.f684a;
        if (l8Var != null) {
            l8Var.b();
        }
        HashMap map = new HashMap();
        map.put("isSkip", Boolean.TRUE);
        s5.a(((x0) this).f821a.k(), map, "action.splash.close", 0);
        d dVar = ((x0) this).f821a;
        if (dVar != null) {
            dVar.m596a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h6.b(this.b);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        pk.d("splash onWindowFocusChanged hasWindowFocus=" + z);
        super.onWindowFocusChanged(z);
    }

    public void setInteractionListener(pm pmVar) {
    }

    public final void c(String str) {
        wd wdVar;
        AdRequest adRequest;
        try {
            a(str);
            s5.a(((x0) this).f821a.k(), "action.splash.click");
            d dVar = ((x0) this).f821a;
            if (dVar == null || (wdVar = dVar.f190a) == null || (adRequest = wdVar.f794a) == null || !adRequest.isCloseAfterClick()) {
                return;
            }
            d();
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
