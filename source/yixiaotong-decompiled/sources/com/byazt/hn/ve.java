package com.byazt.hn;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 25, 54})
public final class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2303a;
    public final Context c;
    public boolean i;
    public View n;
    public boolean sp;
    public tt tt;
    public com.byazt.hn.c uj;
    public n ve;
    public Application z;
    public boolean x = true;
    public final Rect da = new Rect();
    public final View.OnLayoutChangeListener sl = new View.OnLayoutChangeListener() { // from class: com.byazt.hn.ve.1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (ve.this.uj != null) {
                ve.this.uj.setBounds(0, 0, i3 - i, i4 - i2);
            }
            ve.this.x();
        }
    };
    public final ViewTreeObserver.OnScrollChangedListener t = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.hn.ve.2
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            ve.this.x();
        }
    };
    public final ViewTreeObserver.OnWindowFocusChangeListener u = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.byazt.hn.ve.3
        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            ve.this.x();
        }
    };
    public final View.OnAttachStateChangeListener yp = new View.OnAttachStateChangeListener() { // from class: com.byazt.hn.ve.4
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ve.this.n();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ve.this.a();
        }
    };
    public final Application.ActivityLifecycleCallbacks m = new c() { // from class: com.byazt.hn.ve.5
        @Override // com.byazt.hn.ve.c, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (activity == ve.this.m()) {
                ve.this.x = true;
                ve.this.x();
            }
        }

        @Override // com.byazt.hn.ve.c, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (activity == ve.this.m()) {
                ve.this.x = false;
                ve.this.x();
            }
        }
    };

    private static boolean z() {
        return true;
    }

    public boolean c() {
        return this.tt != null;
    }

    public ve(Context context) {
        this.c = context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : null;
    }

    public void c(String str) {
        tt ttVarC = tt.c(this.c, str);
        if (ttVarC == null || !ttVarC.ve()) {
            if (this.tt != null) {
                u();
                yp();
                this.tt = null;
                return;
            }
            return;
        }
        if (this.tt == ttVarC) {
            return;
        }
        u();
        yp();
        this.tt = ttVarC;
        if (!this.f2303a || this.n == null) {
            return;
        }
        t();
        boolean z = this.sp;
        this.sp = false;
        c(z || sp());
    }

    public void c(View view) {
        if (this.n == view) {
            return;
        }
        tt();
        this.n = view;
        if (view == null || this.tt == null || !z()) {
            return;
        }
        da();
        if (this.n.getWindowToken() != null) {
            n();
        }
    }

    public void tt() {
        a();
        this.n = null;
        yp();
    }

    public void ve() {
        n();
    }

    public void uj() {
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f2303a || this.n == null || this.tt == null || !z()) {
            return;
        }
        da();
        this.f2303a = true;
        t();
        ViewTreeObserver viewTreeObserver = this.n.getViewTreeObserver();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnScrollChangedListener(this.t);
            if (this.u != null) {
                viewTreeObserver.addOnWindowFocusChangeListener(this.u);
            }
        }
        nu();
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        View view = this.n;
        if (view == null) {
            this.f2303a = false;
            this.sp = false;
            rh();
            this.i = false;
            return;
        }
        if (this.f2303a) {
            this.f2303a = false;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnScrollChangedListener(this.t);
                if (this.u != null) {
                    viewTreeObserver.removeOnWindowFocusChangeListener(this.u);
                }
            }
            c(false);
            u();
        }
        sl();
        rh();
    }

    private boolean sp() {
        View view;
        return this.f2303a && (view = this.n) != null && this.x && view.getVisibility() == 0 && this.n.getWindowVisibility() == 0 && this.n.getWidth() > 0 && this.n.getHeight() > 0 && this.n.getAlpha() > 0.0f && this.n.getGlobalVisibleRect(this.da) && this.da.width() > 1 && this.da.height() > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        c(sp());
    }

    private void c(boolean z) {
        if (this.sp == z) {
            return;
        }
        this.sp = z;
        if (!z) {
            com.byazt.hn.c cVar = this.uj;
            if (cVar != null) {
                cVar.tt();
            }
            n nVar = this.ve;
            if (nVar != null) {
                nVar.n();
                return;
            }
            return;
        }
        i();
        n nVar2 = this.ve;
        if (nVar2 != null) {
            nVar2.uj();
        }
        com.byazt.hn.c cVar2 = this.uj;
        if (cVar2 != null) {
            cVar2.c();
        }
    }

    private void i() {
        if (this.tt == null) {
            return;
        }
        if (this.ve == null) {
            this.ve = new n(this.tt);
        }
        View view = this.n;
        if (view != null) {
            this.ve.c(view.getWidth(), this.n.getHeight());
        }
    }

    private void da() {
        View view = this.n;
        if (view == null || this.i) {
            return;
        }
        view.addOnLayoutChangeListener(this.sl);
        this.n.addOnAttachStateChangeListener(this.yp);
        this.i = true;
    }

    private void sl() {
        View view = this.n;
        if (view == null || !this.i) {
            return;
        }
        view.removeOnLayoutChangeListener(this.sl);
        this.n.removeOnAttachStateChangeListener(this.yp);
        this.i = false;
    }

    private void t() {
        if (this.n == null || this.tt == null || !z()) {
            return;
        }
        i();
        if (this.uj == null) {
            this.uj = new com.byazt.hn.c(this.ve);
        }
        int width = this.n.getWidth();
        int height = this.n.getHeight();
        if (width > 0 && height > 0) {
            this.uj.setBounds(0, 0, width, height);
        }
        this.n.getOverlay().add(this.uj);
    }

    private void u() {
        if (this.n == null || this.uj == null || !z()) {
            return;
        }
        this.n.getOverlay().remove(this.uj);
    }

    private void yp() {
        com.byazt.hn.c cVar = this.uj;
        if (cVar != null) {
            cVar.tt();
        }
        n nVar = this.ve;
        if (nVar != null) {
            nVar.a();
            this.ve = null;
        }
        this.uj = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity m() {
        View view = this.n;
        if (view == null) {
            return null;
        }
        return c(view.getContext());
    }

    private static Activity c(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext == context) {
                return null;
            }
            context = baseContext;
        }
        return null;
    }

    private void nu() {
        Activity activityM;
        Application application;
        if (this.z != null || (activityM = m()) == null || (application = activityM.getApplication()) == null) {
            return;
        }
        this.z = application;
        application.registerActivityLifecycleCallbacks(this.m);
    }

    private void rh() {
        Application application = this.z;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.m);
            this.z = null;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 25, 24})
    private static abstract class c implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
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

        private c() {
        }
    }
}
