package com.huawei.hms.hatool;

import android.content.Context;
import com.yfanads.android.utils.YFAdsConst;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class m {
    private static m b;
    private static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4094a;

    private m() {
    }

    public static m a() {
        if (b == null) {
            b();
        }
        return b;
    }

    private static synchronized void b() {
        if (b == null) {
            b = new m();
        }
    }

    public void a(Context context) {
        synchronized (c) {
            if (this.f4094a != null) {
                v.f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.f4094a = context;
            s.c().b().a(this.f4094a);
            s.c().b().j(context.getPackageName());
            j.a().a(context);
        }
    }

    public void a(String str) {
        v.c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f4094a;
        if (context == null) {
            v.e("hmsSdk", "sdk is not init");
        } else {
            s.c().b().i(e1.a(YFAdsConst.REPORT_APPID, str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
        }
    }
}
