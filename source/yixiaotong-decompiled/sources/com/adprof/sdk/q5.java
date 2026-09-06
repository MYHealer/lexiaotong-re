package com.adprof.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.stub.StubApp;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1378a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RelativeLayout f660a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d2 f661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public r5 f662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f663a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WeakReference f664a;
    public RelativeLayout b;

    public q5(Activity activity, String str, r5 r5Var) {
        this.f1378a = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        this.f664a = new WeakReference(activity);
        this.f663a = str;
        this.f662a = r5Var;
        this.f660a = new RelativeLayout(this.f1378a);
    }

    public Activity a() {
        Activity activityA = hp.a((View) this.f660a);
        if (activityA != null) {
            return activityA;
        }
        WeakReference weakReference = this.f664a;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public r5 m711a() {
        return this.f662a;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo660a();

    public void a(Context context, int i, Bundle bundle, d dVar) {
        RelativeLayout.LayoutParams layoutParams;
        d2 d2Var;
        if (bundle != null) {
            try {
                int iB = h8.b();
                int iM641a = h8.m641a();
                if (dVar == null || dVar.f197a) {
                    layoutParams = new RelativeLayout.LayoutParams(iM641a, iM641a);
                } else {
                    if (i == 6) {
                        int iMin = (Math.min(iB, iM641a) * 85) / 100;
                        d2Var = new d2((iMin * 16) / 9, iMin);
                    } else {
                        int iMin2 = (Math.min(iB, iM641a) * 85) / 100;
                        d2Var = new d2(iMin2, (iMin2 * 16) / 9);
                    }
                    this.f661a = d2Var;
                    d2 d2Var2 = this.f661a;
                    layoutParams = new RelativeLayout.LayoutParams(d2Var2.f1122a, d2Var2.b);
                }
                if (dVar != null && !dVar.f199b) {
                    layoutParams = new RelativeLayout.LayoutParams(Math.max(iB, iM641a), Math.min(iB, iM641a));
                }
                layoutParams.addRule(13);
                RelativeLayout relativeLayout = new RelativeLayout(context);
                this.b = relativeLayout;
                relativeLayout.setLayoutParams(layoutParams);
                this.f660a.removeAllViews();
                this.f660a.addView(this.b);
            } catch (Throwable th) {
                pk.b(" viewController exception", th);
            }
        }
    }

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public void a(String str) {
        String str2 = this.f663a;
        if (str2 != null) {
            s5.a(str2, str);
        } else {
            pk.e("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo661a();

    public abstract void b();

    public void c() {
        this.f662a = null;
        RelativeLayout relativeLayout = this.f660a;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();
}
