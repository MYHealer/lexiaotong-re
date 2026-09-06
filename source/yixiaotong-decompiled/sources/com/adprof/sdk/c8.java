package com.adprof.sdk;

import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class c8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c8 f1104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f172a = sl.a("device_uid");

    public static c8 a() {
        if (f1104a == null) {
            synchronized (c8.class) {
                if (f1104a == null) {
                    f1104a = new c8();
                }
            }
        }
        return f1104a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m587a() {
        if (TextUtils.isEmpty(this.f172a)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.f172a)) {
                    String strReplace = UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "");
                    this.f172a = strReplace;
                    sl.a("device_uid", strReplace);
                }
            }
        }
        return this.f172a;
    }
}
