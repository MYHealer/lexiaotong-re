package com.adprof.sdk;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class q extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static pe b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1372a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f625a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c2 f627a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f628a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ne f629a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pe f630a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Boolean f631a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f632a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f633a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f634b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f635b;
    public int c;

    public q(Context context, d dVar) {
        super(context);
        this.f631a = null;
        this.f625a = context;
        this.f634b = h8.a(100.0f);
        this.c = h8.a(30.0f);
        this.f1372a = h8.a(5.0f);
        this.f628a = dVar;
    }

    public void a() {
        ll.a(this.f628a);
        pe peVar = b;
        if (peVar != null && peVar == this.f630a) {
            b = null;
        }
        if (this.f630a != null) {
            pk.d("mWidgetView destroy stopAnimator");
            this.f630a.a();
            hp.m656a((View) this.f630a);
            this.f630a = null;
        }
        TextView textView = this.f626a;
        if (textView != null) {
            hp.m656a((View) textView);
            this.f626a = null;
        }
        c2 c2Var = this.f627a;
        if (c2Var != null) {
            c2Var.b();
        }
    }

    public boolean a(int i) {
        if (i == 100) {
            this.f630a = new rl(getContext());
            this.f632a = "摇一摇或点击前往";
            try {
                c2 c2Var = new c2(this.f625a);
                this.f627a = c2Var;
                d dVar = this.f628a;
                c2Var.a(ml.a(dVar), ml.b(this.f628a), ml.m687a(this.f628a), ml.m688a(this.f628a), dVar != null ? dVar.f190a.f1499a : 0);
                ml.a(this.f627a, this.f628a);
                this.f627a.f157a = new o(this);
            } catch (Throwable th) {
                pk.a(th);
            }
        }
        if (this.f630a == null) {
            return false;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f630a.setId(he.a());
        addView(this.f630a, layoutParams);
        TextView textView = new TextView(getContext());
        this.f626a = textView;
        textView.setText(this.f632a);
        this.f626a.setTextSize(2, 15.0f);
        this.f626a.setTextColor(-1);
        this.f626a.setTypeface(Typeface.DEFAULT_BOLD);
        this.f626a.setId(he.a());
        return true;
    }

    public void b() {
        if (this.f630a != null) {
            pk.d("mWidgetView onPause stopAnimator ");
            this.f630a.c();
        }
        c2 c2Var = this.f627a;
        if (c2Var != null) {
            c2Var.b();
        }
        pe peVar = b;
        if (peVar == null || peVar != this.f630a) {
            return;
        }
        b = null;
    }

    public void c() {
        if (this.f633a && this.f630a.getVisibility() == 0) {
            pe peVar = b;
            if (peVar != null && peVar != this.f630a) {
                peVar.c();
                b = null;
            }
            if (this.f633a && getParent() != null && getVisibility() == 0 && isShown()) {
                c2 c2Var = this.f627a;
                if (c2Var != null) {
                    c2Var.d();
                }
                pe peVar2 = this.f630a;
                if (peVar2 == null || peVar2 == b || peVar2.getVisibility() != 0) {
                    return;
                }
                b = this.f630a;
                pk.d("mWidgetView onStart startAnimator ");
                this.f630a.b();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f633a = true;
        this.f635b = true;
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pk.d(" AFMotionView  onDetachedFromWindow");
        this.f633a = false;
        this.f635b = false;
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        b();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        TextView textView;
        try {
            if (this.f635b) {
                this.f635b = false;
                int iMin = Math.min(getWidth(), getHeight());
                hp.m656a((View) this.f626a);
                if (iMin < this.c) {
                    if (this.f630a != null) {
                        pk.d("mWidgetView onGlobalLayout stopAnimator");
                        this.f630a.c();
                        this.f630a.setVisibility(4);
                    }
                    c2 c2Var = this.f627a;
                    if (c2Var != null) {
                        c2Var.b();
                    }
                    this.f631a = Boolean.FALSE;
                    return;
                }
                pe peVar = this.f630a;
                if (peVar != null) {
                    ViewGroup.LayoutParams layoutParams = peVar.getLayoutParams();
                    if (layoutParams != null && layoutParams.width != iMin) {
                        layoutParams.width = iMin;
                        layoutParams.height = iMin;
                        this.f630a.setLayoutParams(layoutParams);
                    }
                    Boolean bool = this.f631a;
                    if (bool != null && !bool.booleanValue()) {
                        this.f630a.b();
                        this.f630a.setVisibility(0);
                        c2 c2Var2 = this.f627a;
                        if (c2Var2 != null) {
                            c2Var2.d();
                        }
                    }
                    if (iMin < this.f634b) {
                        return;
                    }
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    getLocationOnScreen(iArr2);
                    this.f630a.getLocationOnScreen(iArr);
                    int top = getTop() + iMin + (iArr[1] - iArr2[1]);
                    ViewGroup viewGroup = (ViewGroup) getParent();
                    if (viewGroup == null || (textView = this.f626a) == null) {
                        return;
                    }
                    hp.m656a((View) textView);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 1;
                    layoutParams2.setMargins(0, top + this.f1372a, 0, 0);
                    viewGroup.addView(this.f626a, layoutParams2);
                }
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f635b = true;
    }

    public void setMotionActionListener(ne neVar) {
        this.f629a = neVar;
    }
}
