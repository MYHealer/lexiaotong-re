package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class m1 {
    private static m1 b = new m1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f4096a = new a();

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4097a;
        String b;
        long c = 0;

        a() {
        }

        void a(long j) {
            m1.this.f4096a.c = j;
        }

        void a(String str) {
            m1.this.f4096a.b = str;
        }

        void b(String str) {
            m1.this.f4096a.f4097a = str;
        }
    }

    public static m1 d() {
        return b;
    }

    public String a() {
        return this.f4096a.b;
    }

    public void a(String str, String str2) {
        long jB = b();
        String strB = w0.b(str, str2);
        if (strB == null || strB.isEmpty()) {
            v.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (jB == 0) {
            jB = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - jB <= 43200000) {
            return;
        }
        String strGenerateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        String strA = h0.a(strB, strGenerateSecureRandomStr);
        this.f4096a.a(jB);
        this.f4096a.b(strGenerateSecureRandomStr);
        this.f4096a.a(strA);
    }

    public long b() {
        return this.f4096a.c;
    }

    public String c() {
        return this.f4096a.f4097a;
    }
}
