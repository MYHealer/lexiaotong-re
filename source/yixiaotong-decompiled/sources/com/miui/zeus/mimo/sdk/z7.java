package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.ClickEventType;
import com.miui.zeus.mimo.sdk.download.AutoDownloadController;
import com.miui.zeus.mimo.sdk.utils.ApkTools;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class z7 extends FrameLayout implements h8, View.OnClickListener, n, Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MimoAdInfo f5761a;
    public boolean b;
    public boolean c;
    public boolean d;
    public AutoDownloadController e;
    public C1210r f;
    public i8 g;
    public ClickAreaType h;
    public int i;
    public boolean j;

    public z7(Context context) {
        this(context, null);
    }

    public z7(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public z7(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        this.d = false;
        this.h = ClickAreaType.TYPE_BUTTON;
        this.i = 0;
        this.j = false;
        this.e = new AutoDownloadController(context);
        setOnClickListener(this);
    }

    public abstract void a(int i);

    public void a(MimoAdInfo mimoAdInfo, i8 i8Var) {
        a(mimoAdInfo, false, false, i8Var, false);
    }

    public abstract boolean a();

    public void b() {
        try {
            this.e.c();
            C1210r c1210r = this.f;
            if (c1210r != null) {
                c1210r.a();
            }
            Context context = y8.f5752a;
            if (context != null) {
                ((Application) context).unregisterActivityLifecycleCallbacks(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void b(int i);

    public abstract void c();

    public abstract void c(int i);

    public abstract void d();

    public abstract void d(int i);

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && ApkTools.b()) {
            this.i = motionEvent.getAction();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public MimoAdInfo getAdInfo() {
        return this.f5761a;
    }

    public String getBtnInitText() {
        if (this.b) {
            return this.f5761a.q();
        }
        return this.j ? this.f5761a.l() : this.f5761a.g();
    }

    public abstract String getBtnText();

    public abstract /* synthetic */ ClickAreaType getClickAreaType();

    public abstract void h();

    public abstract void i();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Context context = getContext();
        if ((context instanceof Activity) && context == activity) {
            b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        String strG;
        MimoAdInfo mimoAdInfo = this.f5761a;
        if (mimoAdInfo == null || !mimoAdInfo.t()) {
            return;
        }
        MimoAdInfo mimoAdInfo2 = this.f5761a;
        if (mimoAdInfo2.S) {
            return;
        }
        if (this.b) {
            strG = mimoAdInfo2.q();
        } else if (!this.d || (mimoAdInfo2.t() && !w6.a(y8.f5752a, this.f5761a))) {
            strG = (this.d || !this.j) ? this.f5761a.g() : this.f5761a.l();
        } else {
            strG = this.f5761a.i();
        }
        setText(strG);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onCancelDownload(String str) {
        MimoAdInfo mimoAdInfo = this.f5761a;
        if (mimoAdInfo == null || !b.a(mimoAdInfo.C, str)) {
            return;
        }
        if (this.f5761a.S || this.c) {
            d();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadFailed(String str, int i) {
        MimoAdInfo mimoAdInfo = this.f5761a;
        if (mimoAdInfo == null || !b.a(mimoAdInfo.C, str)) {
            return;
        }
        if (this.f5761a.S || this.c) {
            a(i);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadFinished(String str) {
        MimoAdInfo mimoAdInfo = this.f5761a;
        if (mimoAdInfo == null || !b.a(mimoAdInfo.C, str)) {
            return;
        }
        if (this.f5761a.S || this.c) {
            e();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadPaused(String str) {
        MimoAdInfo mimoAdInfo = this.f5761a;
        if (mimoAdInfo == null || !b.a(mimoAdInfo.C, str)) {
            return;
        }
        if ((this.f5761a.S || this.c) && s.a().b(this.f5761a.C) != null) {
            g();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadProgressUpdated(String str, int i) {
        MimoAdInfo mimoAdInfo = this.f5761a;
        if (mimoAdInfo == null || !b.a(mimoAdInfo.C, str)) {
            return;
        }
        if ((this.f5761a.S || this.c) && s.a().b(this.f5761a.C) != null) {
            d(i);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadStarted(String str) {
        MimoAdInfo mimoAdInfo = this.f5761a;
        if (mimoAdInfo == null || !b.a(mimoAdInfo.C, str)) {
            return;
        }
        if ((this.f5761a.S || this.c) && s.a().b(this.f5761a.C) != null) {
            c(0);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onExistDownload(String str) {
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onInstallFailed(String str, int i) {
        MimoAdInfo mimoAdInfo = this.f5761a;
        if (mimoAdInfo == null || !b.a(mimoAdInfo.C, str)) {
            return;
        }
        if (this.f5761a.S || this.c) {
            b(i);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onInstallStart(String str) {
        MimoAdInfo mimoAdInfo = this.f5761a;
        if (mimoAdInfo == null || !b.a(mimoAdInfo.C, str)) {
            return;
        }
        if (this.f5761a.S || this.c) {
            e();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onInstallSuccess(String str) {
        MimoAdInfo mimoAdInfo = this.f5761a;
        if (mimoAdInfo == null || !b.a(mimoAdInfo.C, str)) {
            return;
        }
        f();
    }

    public void setClickAreaType(ClickAreaType clickAreaType) {
        this.h = clickAreaType;
    }

    public void setGetReward(boolean z) {
        this.d = z;
    }

    public abstract void setText(CharSequence charSequence);

    public abstract void setTextColor(int i);

    public void a(MimoAdInfo mimoAdInfo, boolean z, boolean z2, i8 i8Var, boolean z3) {
        if (mimoAdInfo == null) {
            return;
        }
        this.j = z3;
        this.b = z;
        this.f5761a = mimoAdInfo;
        this.g = i8Var;
        this.e.e = mimoAdInfo;
        c();
        h();
        try {
            Context context = y8.f5752a;
            if (context != null) {
                ((Application) context).registerActivityLifecycleCallbacks(this);
            }
        } catch (Exception unused) {
        }
        if (z2 && s.a().b(this.f5761a.C) == null) {
            this.c = true;
        }
        if (this.f == null) {
            this.f = new C1210r(getContext());
        }
        this.f.a(this.f5761a.C, this);
        o oVarB = s.a().b(this.f5761a.C);
        if (!mimoAdInfo.S || oVarB == null) {
            return;
        }
        int i = oVarB.b;
        if (2 == i) {
            d(oVarB.f5540a);
            g();
        } else {
            if (4 != i) {
                if (3 == i || i == 1) {
                    c(0);
                    d(oVarB.f5540a);
                    i();
                    return;
                }
                return;
            }
            e();
        }
        i();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MimoAdInfo mimoAdInfo;
        i8 i8Var;
        MimoAdInfo mimoAdInfo2;
        if (this.i == 0 || (mimoAdInfo = this.f5761a) == null) {
            return;
        }
        this.i = 0;
        ClickEventType clickEventTypeA = mimoAdInfo.a(getClickAreaType());
        if (clickEventTypeA != ClickEventType.CLICK_DISABLE && ApkTools.a()) {
            if ((clickEventTypeA != ClickEventType.CLICK_AUTO_DOWNLOAD || (!((mimoAdInfo2 = this.f5761a) == null || !mimoAdInfo2.B1.booleanValue() || a()) || this.e.a(view, this.f5761a, this.c, this))) && (i8Var = this.g) != null) {
                i8Var.onClick(view, getClickAreaType());
            }
        }
    }
}
