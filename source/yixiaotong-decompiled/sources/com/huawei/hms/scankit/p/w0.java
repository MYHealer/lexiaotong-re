package com.huawei.hms.scankit.p;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import java.util.Locale;

/* JADX INFO: compiled from: CountryCodeBean.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class w0 {
    private static final String c = "w0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4364a = "UNKNOWN";
    private String b;

    public w0(Context context, boolean z) {
        this.b = "UNKNOWN";
        a(context, z);
        this.b = this.b.toUpperCase(Locale.ENGLISH);
    }

    private boolean b() {
        return !"UNKNOWN".equals(this.b);
    }

    public String a() {
        return this.b;
    }

    private void a(Context context, boolean z) {
        if (context != null) {
            try {
                this.b = GrsApp.getInstance().getIssueCountryCode(context);
                if (b()) {
                    Logger.i(c, "getCountryCode unknown");
                }
            } catch (NullPointerException unused) {
                Logger.w(c, "get CountryCode error");
            } catch (Exception unused2) {
                Logger.w(c, "get CountryCode error");
            }
        }
    }
}
