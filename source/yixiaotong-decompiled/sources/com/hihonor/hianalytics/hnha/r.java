package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import android.util.Pair;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.secure.android.common.encrypt.aes.AesCbc;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f3676a = new s();
    private final s b = new s();
    private final s c = new s();
    private p d;
    private q e;
    private o f;

    public Pair<Boolean, String> a(String str) {
        return a(str, false);
    }

    public Pair<Long, String> a(String str, String str2) {
        StringBuilder sb;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            long jCurrentTimeMillis = System.currentTimeMillis();
            return Pair.create(Long.valueOf(jCurrentTimeMillis), w1.a(messageDigest.digest((str + str2 + jCurrentTimeMillis).getBytes(i.f3644a))));
        } catch (UnsatisfiedLinkError e) {
            e = e;
            sb = new StringBuilder("getNetHMacInfo failE=");
            j2.g("SafeManager", sb.append(SystemUtils.getDesensitizedException(e)).toString());
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            sb = new StringBuilder("getNetHMacInfo failE=");
            j2.g("SafeManager", sb.append(SystemUtils.getDesensitizedException(e)).toString());
            return null;
        }
    }

    public Pair<Boolean, String> a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            j2.g("SafeManager", "decrypt illegal ciphertext=" + str);
            return Pair.create(Boolean.FALSE, str);
        }
        long jA = com.hihonor.hianalytics.util.r.a();
        Pair<Boolean, String> pairA = s1.a(str, a(z).b());
        this.b.a(((Boolean) pairA.first).booleanValue(), str.length(), com.hihonor.hianalytics.util.r.a() - jA);
        return pairA;
    }

    public p a() {
        p pVar = this.d;
        if (pVar != null) {
            return pVar;
        }
        synchronized (this) {
            p pVar2 = this.d;
            if (pVar2 != null) {
                return pVar2;
            }
            p pVar3 = new p();
            this.d = pVar3;
            return pVar3;
        }
    }

    public p a(boolean z) {
        return z ? b() : a();
    }

    public String a(byte[] bArr, String str) {
        StringBuilder sb;
        StringBuilder sbAppend;
        int length = bArr == null ? 0 : bArr.length;
        if (length > 0) {
            if (SystemUtils.o()) {
                return w1.a(bArr);
            }
            if (TextUtils.isEmpty(str)) {
                sbAppend = new StringBuilder("encryptNetData illegalKey=").append(SystemUtils.a(str));
            } else {
                byte[] bArrA = w1.a(str);
                if (bArrA.length > 0) {
                    long jA = com.hihonor.hianalytics.util.r.a();
                    byte[] bArrEncrypt = AesCbc.encrypt(bArr, bArrA);
                    this.c.a(bArrEncrypt.length > 16, bArr.length, com.hihonor.hianalytics.util.r.a() - jA);
                    return w1.a(bArrEncrypt);
                }
                sb = new StringBuilder("encryptNetData emptyKeyData=");
            }
            j2.g("SafeManager", sbAppend.toString());
            return null;
        }
        sb = new StringBuilder("encryptNetData emptyPlainData=");
        sbAppend = sb.append(length);
        j2.g("SafeManager", sbAppend.toString());
        return null;
    }

    public void a(j0 j0Var) {
        a(j0Var, false);
    }

    public void a(j0 j0Var, boolean z) {
        int i;
        String strD = j0Var.d();
        if (TextUtils.isEmpty(strD)) {
            j2.g("SafeManager", "decrypt illegal idAttrs=" + j0Var);
            j0Var.a(null, 30002);
            return;
        }
        long jA = com.hihonor.hianalytics.util.r.a();
        Pair<Boolean, String> pairA = s1.a(strD, a(z).b());
        this.b.a(((Boolean) pairA.first).booleanValue(), strD.length(), com.hihonor.hianalytics.util.r.a() - jA);
        if (((Boolean) pairA.first).booleanValue()) {
            j0Var.a((String) pairA.second, 0);
            return;
        }
        if (!Objects.equals(j0Var.l(), a(z).c())) {
            i = 32000;
        } else if (Objects.equals(j0Var.m(), a(z).d())) {
            i = !Objects.equals(j0Var.e(), b(strD)) ? 32002 : 32003;
        } else {
            i = 32001;
        }
        j0Var.a(null, i);
    }

    public void a(n0 n0Var) {
        a(n0Var, false);
    }

    public void a(n0 n0Var, boolean z) {
        int i;
        String strE = n0Var.e();
        if (TextUtils.isEmpty(strE)) {
            j2.g("SafeManager", "decrypt illegal event=" + n0Var);
            n0Var.a(null, 30001);
            return;
        }
        long jA = com.hihonor.hianalytics.util.r.a();
        Pair<Boolean, String> pairA = s1.a(strE, a(z).b());
        this.b.a(((Boolean) pairA.first).booleanValue(), strE.length(), com.hihonor.hianalytics.util.r.a() - jA);
        if (((Boolean) pairA.first).booleanValue()) {
            n0Var.a((String) pairA.second, 0);
            return;
        }
        if (!Objects.equals(n0Var.p(), a(z).c())) {
            i = 31000;
        } else if (Objects.equals(n0Var.q(), a(z).d())) {
            i = !Objects.equals(n0Var.f(), b(strE)) ? ErrorCode.AD_ADAPTER_IS_NULL : ErrorCode.AD_RENDER_FAIL;
        } else {
            i = ErrorCode.AD_LOADED_LISTENER_IS_NULL;
        }
        n0Var.a(null, i);
    }

    public Pair<String, String> b(String str, String str2) {
        return c().a(str, str2);
    }

    public p b() {
        o oVar = this.f;
        if (oVar != null) {
            return oVar;
        }
        synchronized (this) {
            o oVar2 = this.f;
            if (oVar2 != null) {
                return oVar2;
            }
            o oVar3 = new o();
            this.f = oVar3;
            return oVar3;
        }
    }

    public String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return com.hihonor.hianalytics.util.i.a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (Throwable th) {
            j2.g("SafeManager", "getMd5 text=" + str.length() + ",failE=" + SystemUtils.getDesensitizedException(th));
            return null;
        }
    }

    public void b(j0 j0Var) {
        b(j0Var, false);
    }

    public void b(j0 j0Var, boolean z) {
        String strG = j0Var.g();
        if (TextUtils.isEmpty(strG)) {
            j2.g("SafeManager", "encrypt illegal idAttrs=" + j0Var);
            j0Var.b(null);
            return;
        }
        long jA = com.hihonor.hianalytics.util.r.a();
        Pair<Boolean, String> pairB = s1.b(strG, a(z).b());
        this.f3676a.a(((Boolean) pairB.first).booleanValue(), strG.length(), com.hihonor.hianalytics.util.r.a() - jA);
        if (((Boolean) pairB.first).booleanValue()) {
            j0Var.b((String) pairB.second);
            j0Var.c(b((String) pairB.second));
        } else {
            j0Var.b(null);
        }
        j0Var.d(a(z).c());
        j0Var.e(a(z).d());
    }

    public void b(n0 n0Var, boolean z) {
        String strH = n0Var.h();
        if (TextUtils.isEmpty(strH)) {
            j2.g("SafeManager", "encrypt illegal event=" + n0Var);
            n0Var.a((String) null);
            return;
        }
        long jA = com.hihonor.hianalytics.util.r.a();
        p pVarA = a(z);
        Pair<Boolean, String> pairB = s1.b(strH, pVarA.b());
        this.f3676a.a(((Boolean) pairB.first).booleanValue(), strH.length(), com.hihonor.hianalytics.util.r.a() - jA);
        if (((Boolean) pairB.first).booleanValue()) {
            n0Var.a((String) pairB.second);
            n0Var.b(b((String) pairB.second));
        } else {
            n0Var.a((String) null);
        }
        n0Var.c(pVarA.c());
        n0Var.d(pVarA.d());
    }

    public q c() {
        q qVar = this.e;
        if (qVar != null) {
            return qVar;
        }
        synchronized (this) {
            q qVar2 = this.e;
            if (qVar2 != null) {
                return qVar2;
            }
            q qVar3 = new q();
            this.e = qVar3;
            return qVar3;
        }
    }

    public Pair<String, String> d() {
        return c().b();
    }
}
