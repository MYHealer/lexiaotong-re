package com.adprof.sdk;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class x0 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinearLayout f819a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f820a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f821a;
    public TextView b;
    public TextView c;

    public x0(Context context, d dVar) {
        super(context);
        this.f1511a = 100;
        this.f821a = dVar;
        this.f817a = context;
        this.f1511a = new Random().nextInt(100) + 1;
        if (dVar != null) {
            dVar.a(this);
        }
    }

    public abstract void a();

    public void a(View view) {
        d dVar = this.f821a;
        if (dVar == null || dVar.g <= this.f1511a || !me.m683a()) {
            a();
        } else {
            me.a();
            le.a(view, this.f821a, new w0(this), "AdBaseView");
        }
    }

    public void a(String str) {
        if (getSessionManager() != null) {
            this.f821a.f206h = str;
            HashMap mapA = ie.a(null);
            if ("6".equals(str)) {
                mapA.put("mcr", Integer.valueOf(this.f821a.g));
                mapA.put("sdk_cr", Integer.valueOf(this.f1511a));
            }
            "8".equals(str);
            "7".equals(str);
            ((a2) getSessionManager()).a(this.f821a, "click", mapA);
        }
        this.f821a.m590a().a(this.f821a, str);
        this.f1511a = 100;
    }

    public void b() {
        View view = this.f818a;
        if (view != null) {
            this.f819a = (LinearLayout) view.findViewById(R.id.adprof_interstitial_privacy_ll);
            this.f820a = (TextView) this.f818a.findViewById(R.id.adprof_permission_tv);
            this.b = (TextView) this.f818a.findViewById(R.id.adprof_privacy_tv);
            this.c = (TextView) this.f818a.findViewById(R.id.adprof_function_tv);
        }
    }

    public abstract void b(String str);

    public kl getSessionManager() {
        d dVar = this.f821a;
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
}
