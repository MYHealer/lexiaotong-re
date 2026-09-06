package com.ubix.ssp.ad.e.z;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.l;
import com.ubix.ssp.ad.e.a0.r;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class h extends RelativeLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f8956a;
    protected double b;
    protected l c;
    protected Dialog d;
    protected c e;
    protected b f;
    protected boolean g;

    class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f8957a;

        a(Activity activity) {
            this.f8957a = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f8957a == activity) {
                l lVar = h.this.c;
                if (lVar != null && lVar.b()) {
                    h.this.c.a();
                }
                Dialog dialog = h.this.d;
                if (dialog != null && dialog.isShowing()) {
                    h.this.d.dismiss();
                }
                ((Application) StubApp.getOrigApplicationContext(this.f8957a.getApplicationContext())).unregisterActivityLifecycleCallbacks(this);
            }
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
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    public interface c {
        void a(h hVar);

        void a(h hVar, HashMap<String, String> map);

        void b(h hVar);

        void c(h hVar);
    }

    public h(Context context) {
        super(context);
        this.f8956a = 0;
        this.b = 3.0d;
        this.g = false;
        this.b = r.a().a(getContext());
        float f = StubApp.getOrigApplicationContext(getContext().getApplicationContext()).getResources().getConfiguration().fontScale;
        f = f < 1.0f ? 1.0f : f;
        this.f8956a = Math.min((int) (((((double) r.a().g(context)) / this.b) / ((double) f)) / 13.0d), (int) (16.0f / f));
        try {
            a((Activity) context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Activity activity) {
        ((Application) StubApp.getOrigApplicationContext(activity.getApplicationContext())).registerActivityLifecycleCallbacks(new a(activity));
    }

    public void a() {
        this.g = true;
        try {
            l lVar = this.c;
            if (lVar != null) {
                lVar.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Dialog dialog = this.d;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c cVar = this.e;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public abstract void a(Dialog dialog, c cVar, b bVar);

    public abstract void a(l lVar, c cVar, b bVar);

    protected TextView b() {
        TextView textViewA = com.ubix.ssp.ad.e.f.a(getContext());
        textViewA.setTextColor(-8158333);
        textViewA.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        return textViewA;
    }

    public boolean c() {
        return this.g;
    }

    protected abstract int getPopupType();

    public int getType() {
        return getPopupType();
    }

    public abstract void setData(Bundle bundle);
}
