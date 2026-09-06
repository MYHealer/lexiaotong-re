package com.opos.acs.st.utils;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f5861a;

    public static void a() {
        if (f5861a) {
            return;
        }
        f5861a = true;
        com.opos.cmn.an.f.a.a();
    }

    public static void a(Context context) {
        int i = com.opos.acs.st.a.f5851a.booleanValue() ? 3 : 2;
        com.opos.cmn.an.f.a.a(new com.opos.cmn.an.f.a.b.a().a("acs_st").b(i).a(i).a(context));
        com.opos.cmn.an.f.a.a(new com.opos.cmn.an.f.a.c.a().a(true).a("ad_st").a(), new com.opos.cmn.an.f.a.a() { // from class: com.opos.acs.st.utils.f.1
            @Override // com.opos.cmn.an.f.a.a
            public void onDontNeedUpload(String str) {
                f.a("LogUtil", "onDontNeedUpload:" + str);
            }

            @Override // com.opos.cmn.an.f.a.a
            public void onUploaderFailed(String str) {
                f.a("LogUtil", "onUploaderFailed:" + str);
            }

            @Override // com.opos.cmn.an.f.a.a
            public void onUploaderSuccess() {
                f.a("LogUtil", "onUploaderSuccess:");
            }
        });
    }

    public static void a(String str, String str2) {
        com.opos.cmn.an.f.a.b(str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        com.opos.cmn.an.f.a.b(str, str2, th);
    }

    public static void b(String str, String str2) {
        com.opos.cmn.an.f.a.a(str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        com.opos.cmn.an.f.a.c(str, str2, th);
    }

    public static void c(String str, String str2) {
        com.opos.cmn.an.f.a.d(str, str2);
    }

    public static void c(String str, String str2, Throwable th) {
        com.opos.cmn.an.f.a.d(str, str2, th);
    }
}
