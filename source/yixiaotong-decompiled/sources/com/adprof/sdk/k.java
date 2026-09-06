package com.adprof.sdk;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class k extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1256a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i f410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public j f411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f412a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f413b;
    public boolean c;

    public k(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public k(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f412a = false;
        this.f409a = 0L;
        this.b = 0;
        this.f413b = false;
        this.c = false;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    public final void a() {
        try {
            boolean z = false;
            if (getVisibility() == 0 && getParent() != null && this.f412a) {
                ViewGroup viewGroup = (ViewGroup) getParent();
                Rect rect = new Rect();
                int iHeight = (viewGroup == null || viewGroup.getGlobalVisibleRect(rect)) ? rect.height() * rect.width() : 0;
                int height = viewGroup.getHeight() * viewGroup.getWidth();
                boolean z2 = true;
                boolean z3 = height > 0 && ((float) iHeight) >= (((float) this.f1256a) / 100.0f) * ((float) height);
                if (!this.c) {
                    z3 = true;
                }
                if (iHeight > 0) {
                    this.f413b = true;
                    j jVar = this.f411a;
                    if (jVar != null) {
                        ((f0) jVar).g();
                    }
                } else {
                    this.f413b = false;
                    this.f409a = 0L;
                    j jVar2 = this.f411a;
                    if (jVar2 != null) {
                        ((f0) jVar2).f();
                    }
                }
                if (iHeight <= 0) {
                    j jVar3 = this.f411a;
                    if (jVar3 == null || !this.f413b) {
                        return;
                    }
                    ((f0) jVar3).f();
                    return;
                }
                if (z3 && this.f413b) {
                    if (this.f409a == 0) {
                        this.f409a = System.currentTimeMillis();
                    }
                    if (this.f409a > 0 && System.currentTimeMillis() - this.f409a >= ((long) this.b) * 1000) {
                        z = true;
                    }
                    if (this.c) {
                        z2 = z;
                    }
                    j jVar4 = this.f411a;
                    if (jVar4 != null) {
                        ((f0) jVar4).h();
                        ((f0) this.f411a).a(z2);
                        return;
                    }
                    return;
                }
                j jVar5 = this.f411a;
                if (jVar5 != null) {
                    f0 f0Var = (f0) jVar5;
                    if (f0Var.c) {
                        q qVar = f0Var.f279a;
                        if (qVar != null) {
                            qVar.b();
                            f0.f1160a.remove(f0Var.f279a);
                        }
                        j0 j0VarM617a = f0Var.m617a();
                        if (j0VarM617a != null) {
                            ((k0) j0VarM617a).m666a();
                        }
                        pk.a("-----------onAdViewPauseImpression---------");
                        f0Var.c = false;
                    }
                    ((f0) this.f411a).a(false);
                }
            } else {
                j jVar6 = this.f411a;
                if (jVar6 != null && this.f413b) {
                    ((f0) jVar6).f();
                }
                this.f413b = false;
            }
            this.f409a = 0L;
        } catch (Throwable th) {
            pk.a(th);
        }
    }

    public final void b() {
        i iVar = this.f410a;
        if (iVar == null || !iVar.f372a) {
            return;
        }
        pk.a("-----------startTimer----------");
        this.f410a.removeCallbacksAndMessages(null);
        i iVar2 = this.f410a;
        iVar2.getClass();
        try {
            iVar2.sendEmptyMessageDelayed(87108, iVar2.f1218a);
        } catch (Throwable th) {
            pk.a(th);
        }
        this.f410a.f372a = false;
    }

    public final void c() {
        a();
        i iVar = this.f410a;
        if (iVar == null || iVar.f372a) {
            return;
        }
        pk.a("-----------stopTimer----------");
        this.f410a.removeCallbacksAndMessages(null);
        this.f410a.f372a = true;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f412a = true;
        pk.a("---------onAttachedToWindow---------");
        b();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f412a = false;
        pk.a("---------onDetachedFromWindow----------");
        c();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        pk.a("---------onFinishTemporaryDetach-------------");
        b();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        pk.a("---------onStartTemporaryDetach-----------");
        c();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        pk.a("---------onVisibilityChanged---------" + i);
        if (i == 0) {
            b();
        } else {
            c();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        pk.a("---------onWindowFocusChanged: hasWindowFocus: " + z);
        if (this.f413b) {
            a();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        pk.a("---------onWindowVisibilityChanged: visibility: " + i);
        if (i == 0) {
            b();
        } else {
            c();
        }
    }

    public void setAdVisibilityStatusChangeListener(j jVar) {
        this.f411a = jVar;
    }
}
