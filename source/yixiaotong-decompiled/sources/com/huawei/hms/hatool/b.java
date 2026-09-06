package com.huawei.hms.hatool;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    s0 f4071a;
    s0 b;
    Context c;
    String d;

    public b(Context context) {
        if (context != null) {
            this.c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.f4071a = new s0();
        this.b = new s0();
    }

    public b a(int i, String str) {
        s0 s0Var;
        v.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i);
        if (!p1.b(str)) {
            str = "";
        }
        if (i != 0) {
            if (i != 1) {
                v.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
            } else {
                s0Var = this.b;
            }
            return this;
        }
        s0Var = this.f4071a;
        s0Var.b(str);
        return this;
    }

    public b a(String str) {
        v.c("hmsSdk", "Builder.setAppID is execute");
        this.d = str;
        return this;
    }

    @Deprecated
    public b a(boolean z) {
        v.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f4071a.j().a(z);
        this.b.j().a(z);
        return this;
    }

    public void a() {
        if (this.c == null) {
            v.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        v.c("hmsSdk", "Builder.create() is execute.");
        z0 z0Var = new z0("_hms_config_tag");
        z0Var.b(new s0(this.f4071a));
        z0Var.a(new s0(this.b));
        m.a().a(this.c);
        g0.a().a(this.c);
        q.c().a(z0Var);
        m.a().a(this.d);
    }

    @Deprecated
    public b b(boolean z) {
        v.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f4071a.j().b(z);
        this.b.j().b(z);
        return this;
    }

    @Deprecated
    public b c(boolean z) {
        v.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f4071a.j().c(z);
        this.b.j().c(z);
        return this;
    }
}
