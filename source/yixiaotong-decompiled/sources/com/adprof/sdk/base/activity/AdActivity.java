package com.adprof.sdk.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.adprof.sdk.d;
import com.adprof.sdk.j5;
import com.adprof.sdk.jd;
import com.adprof.sdk.lk;
import com.adprof.sdk.md;
import com.adprof.sdk.oh;
import com.adprof.sdk.pk;
import com.adprof.sdk.q5;
import com.adprof.sdk.r5;
import com.adprof.sdk.s5;
import com.adprof.sdk.td;
import com.stub.StubApp;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AdActivity extends j5 implements r5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q5 f1071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f95a;

    static {
        StubApp.interface11(11395);
    }

    public final q5 a(d dVar, Bundle bundle) throws IllegalStateException {
        String stringExtra = getIntent().getStringExtra("ad_view_clz_name");
        stringExtra.getClass();
        stringExtra.hashCode();
        switch (stringExtra) {
            case "LandingPage":
                return new td(this, dVar, getIntent().getExtras(), this.f95a, this);
            case "interstitial_act":
                return new jd(this, dVar, getIntent().getExtras(), this.f95a, this);
            case "reward_act":
                return new lk(this, dVar, getIntent().getExtras(), this.f95a, this);
            default:
                return null;
        }
    }

    public void a() {
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        q5 q5Var = this.f1071a;
        if (q5Var != null) {
            q5Var.getClass();
        }
    }

    @Override // android.app.Activity, com.adprof.sdk.r5
    public void onBackPressed() {
        q5 q5Var = this.f1071a;
        if (q5Var == null || !q5Var.mo661a()) {
            return;
        }
        super.onBackPressed();
        this.f1071a.mo660a();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        q5 q5Var = this.f1071a;
        if (q5Var != null) {
            q5Var.a(configuration);
        }
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        pk.a("---AdActivity Destroy");
        q5 q5Var = this.f1071a;
        if (q5Var != null) {
            q5Var.c();
        }
        this.f1071a = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        try {
            super.onPause();
            q5 q5Var = this.f1071a;
            if (q5Var != null) {
                q5Var.d();
            }
        } catch (Throwable th) {
            pk.b("---onPause error:", th);
            oh.b(th);
            HashMap map = new HashMap();
            map.put("error", th.getMessage());
            s5.a(this.f95a, map, "action.reward.video.play.fail", 0);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            q5 q5Var = this.f1071a;
            if (q5Var != null) {
                q5Var.e();
            }
        } catch (Throwable th) {
            pk.b("onResume error:", th);
            oh.b(th);
            HashMap map = new HashMap();
            map.put("error", th.getMessage());
            s5.a(this.f95a, map, "action.reward.video.play.fail", 0);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        q5 q5Var = this.f1071a;
        if (q5Var != null) {
            q5Var.a(bundle);
        }
    }

    @Override // com.adprof.sdk.r5
    public void onSetContentView(View view) {
        setContentView(view);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            q5 q5Var = this.f1071a;
            if (q5Var != null) {
                q5Var.f();
            }
        } catch (Throwable th) {
            pk.b("onStart error: ", th);
            oh.b(th);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        try {
            if (Build.VERSION.SDK_INT == 26 && md.m682a((Activity) this)) {
                return;
            }
            super.setRequestedOrientation(i);
        } catch (Throwable th) {
            pk.b("setRequestedOrientation error: ", th);
        }
    }
}
