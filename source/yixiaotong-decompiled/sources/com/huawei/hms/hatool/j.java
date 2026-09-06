package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class j {
    private static j b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4086a;

    private static class a extends e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4087a;
        String b;

        public a(String str, String str2) {
            this.f4087a = str;
            this.b = str2;
        }

        @Override // com.huawei.hms.hatool.e0
        public String a() {
            return z.d(this.f4087a, this.b);
        }

        @Override // com.huawei.hms.hatool.e0
        public String a(String str) {
            return SHA.sha256Encrypt(str);
        }

        @Override // com.huawei.hms.hatool.e0
        public String b() {
            return z.g(this.f4087a, this.b);
        }

        @Override // com.huawei.hms.hatool.e0
        public String c() {
            return z.j(this.f4087a, this.b);
        }

        @Override // com.huawei.hms.hatool.e0
        public int d() {
            return (z.k(this.f4087a, this.b) ? 4 : 0) | (z.e(this.f4087a, this.b) ? 2 : 0) | (z.h(this.f4087a, this.b) ? 1 : 0);
        }
    }

    public static j a() {
        j jVar;
        synchronized (j.class) {
            if (b == null) {
                b = new j();
            }
            jVar = b;
        }
        return jVar;
    }

    public String a(String str, String str2) {
        return i0.a(this.f4086a, str, str2);
    }

    public String a(boolean z) {
        if (!z) {
            return "";
        }
        String strE = q0.e();
        if (TextUtils.isEmpty(strE)) {
            strE = d.a(this.f4086a, "global_v2", Constant.MAP_KEY_UUID, "");
            if (TextUtils.isEmpty(strE)) {
                strE = UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "");
                d.b(this.f4086a, "global_v2", Constant.MAP_KEY_UUID, strE);
            }
            q0.h(strE);
        }
        return strE;
    }

    public void a(Context context) {
        if (this.f4086a == null) {
            this.f4086a = context;
        }
    }

    public String b(String str, String str2) {
        return i0.b(this.f4086a, str, str2);
    }

    public i c(String str, String str2) {
        return new a(str, str2).a(this.f4086a);
    }

    public String d(String str, String str2) {
        return f1.b(str, str2);
    }

    public Pair<String, String> e(String str, String str2) {
        if (!z.f(str, str2)) {
            return new Pair<>("", "");
        }
        String strP = s.c().b().p();
        String strQ = s.c().b().q();
        if (!TextUtils.isEmpty(strP) && !TextUtils.isEmpty(strQ)) {
            return new Pair<>(strP, strQ);
        }
        Pair<String, String> pairE = x0.e(this.f4086a);
        s.c().b().k((String) pairE.first);
        s.c().b().l((String) pairE.second);
        return pairE;
    }

    public String f(String str, String str2) {
        return f1.a(str, str2);
    }
}
