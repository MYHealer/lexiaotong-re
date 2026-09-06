package com.meishu.sdk.core.utils;

import android.app.Activity;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: compiled from: OpenAppDialogStateChecker.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l0 extends com.meishu.sdk.core.service.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4918a;
    public long b;
    public long c;
    public long d;
    public boolean e;
    public volatile Boolean f;

    /* JADX INFO: compiled from: OpenAppDialogStateChecker.java */
    public class a extends com.meishu.sdk.core.safe.l {
        public a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            super.safeRun();
            LogUtil.dev("OpenAppDialogStateChecker", com.meishu.sdk.activity.a.a("dialog state 0 ：").append(l0.this.b).append(PPSLabelView.Code).append(com.meishu.sdk.core.service.d.a()).toString());
            long j = l0.this.b;
            if (j == 0) {
                LogUtil.dev("OpenAppDialogStateChecker", "dialog state 1");
                l0.this.f = Boolean.FALSE;
                l0 l0Var = l0.this;
                l0.a(l0Var, l0Var.f.booleanValue());
                return;
            }
            if (j > 0) {
                if (com.meishu.sdk.core.service.d.a()) {
                    l0.this.e = true;
                    return;
                }
                LogUtil.dev("OpenAppDialogStateChecker", "dialog state 2");
                l0.this.f = Boolean.TRUE;
                l0 l0Var2 = l0.this;
                l0.a(l0Var2, l0Var2.f.booleanValue());
            }
        }
    }

    public l0(long j) {
        this(j, true);
    }

    public static void a(l0 l0Var, boolean z) {
        if (l0Var.f4918a) {
            if (l0Var.d > 0) {
                z = true;
            }
            if (com.meishu.sdk.core.service.d.e) {
                o0.a(z);
            } else {
                com.meishu.sdk.core.service.d.a(new n0(z));
            }
        }
        com.meishu.sdk.core.service.d.b(l0Var);
    }

    @Override // com.meishu.sdk.core.service.a, com.meishu.sdk.core.service.e
    public void onActivityPause(Activity activity) {
        this.b = System.currentTimeMillis();
        LogUtil.dev("OpenAppDialogStateChecker", "onActivityPause");
    }

    @Override // com.meishu.sdk.core.service.a, com.meishu.sdk.core.service.e
    public void onActivityResume(Activity activity) {
        this.c = System.currentTimeMillis();
        LogUtil.dev("OpenAppDialogStateChecker", "onActivityResume");
        long j = this.b;
        if (j <= 0 || this.c <= j || this.f != null) {
            com.meishu.sdk.core.service.d.b(this);
        } else {
            LogUtil.dev("OpenAppDialogStateChecker", "dialog close");
            SdkHandler.getInstance().postDelay(new m0(this), 150L);
        }
    }

    @Override // com.meishu.sdk.core.service.e
    public boolean onAppStateUpdate(boolean z) {
        LogUtil.dev("OpenAppDialogStateChecker", "onAppStateUpdate:" + z);
        if (z) {
            System.currentTimeMillis();
            return true;
        }
        this.d = System.currentTimeMillis();
        return true;
    }

    public l0(long j, boolean z) {
        this.f4918a = true;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = false;
        this.f = null;
        this.f4918a = z;
        SdkHandler.getInstance().postDelay(new a(), j <= 0 ? 900L : j);
    }
}
