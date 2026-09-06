package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import android.util.Pair;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.secure.android.common.enc2.ODS;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3672a = null;
    private String b = null;
    private String c = null;
    private long d = 0;
    private ODS e = null;
    private String f = null;
    private String g = null;

    q() {
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a A[Catch: all -> 0x008f, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x000b, B:10:0x0013, B:11:0x001b, B:15:0x0025, B:17:0x0031, B:19:0x0039, B:21:0x0041, B:23:0x004a, B:25:0x005a, B:28:0x0061, B:31:0x0069), top: B:37:0x0003 }] */
    private synchronized void a() {
        String strB;
        String strA;
        if (SystemUtils.o()) {
            return;
        }
        if (TextUtils.isEmpty(this.f3672a)) {
            this.f3672a = com.hihonor.hianalytics.util.f.a("hianalytics_njjn123");
        }
        if (TextUtils.isEmpty(this.f3672a)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
            strB = w1.b();
            strA = x1.a(this.f3672a, strB);
            if (!TextUtils.isEmpty(strB) && !TextUtils.isEmpty(strA)) {
                this.b = strB;
                this.c = strA;
                this.d = jCurrentTimeMillis;
            }
            j2.g("NetEncryptor", "checkRefreshNetKey illegalNewKey=" + SystemUtils.a(strB) + ",newCipherKey=" + SystemUtils.a(strA));
        }
        long j = this.d;
        if (j <= 0 || jCurrentTimeMillis - j > 43200000) {
            strB = w1.b();
            strA = x1.a(this.f3672a, strB);
            if (!TextUtils.isEmpty(strB)) {
                this.b = strB;
                this.c = strA;
                this.d = jCurrentTimeMillis;
            }
            j2.g("NetEncryptor", "checkRefreshNetKey illegalNewKey=" + SystemUtils.a(strB) + ",newCipherKey=" + SystemUtils.a(strA));
        }
    }

    public synchronized Pair<String, String> a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (SystemUtils.o()) {
                j2.g("NetEncryptor", "getNetHMacShaKeyPair plainVersionWithAppId=" + str + ",requestId=" + str2);
                return null;
            }
            if (TextUtils.isEmpty(this.f)) {
                this.f = com.hihonor.hianalytics.util.f.a("hianalytics_wbewk321");
            }
            if (TextUtils.isEmpty(this.f)) {
                j2.g("NetEncryptor", "getNetHMacShaKeyPair illegalWhiteBoxKeyWithAppId=" + str + ",requestId=" + str2);
                return null;
            }
            try {
                if (TextUtils.isEmpty(this.g)) {
                    if (this.e == null) {
                        this.e = new ODS();
                    }
                    this.g = this.e.getDeviceInfoHash(SystemUtils.getContext());
                }
                if (TextUtils.isEmpty(this.g)) {
                    j2.g("NetEncryptor", "getNetHMacShaKeyPair illegalDeviceInfoHashWithAppId=" + str + ",requestId=" + str2);
                    return null;
                }
                String akInfo = this.e.getAkInfo(str + '|' + str2 + '|' + this.g, this.f);
                if (TextUtils.isEmpty(akInfo)) {
                    j2.g("NetEncryptor", "getNetHMacShaKeyPair illegalEncryptKeyWithAppId=" + str + ",requestId=" + str2);
                    return null;
                }
                j2.a("NetEncryptor", "getNetHMacShaKeyPair appId=" + str + ",requestId=" + str2 + ",deviceInfoHash=" + this.g + ",key=" + akInfo);
                return Pair.create(akInfo, this.g);
            } catch (Throwable th) {
                j2.g("NetEncryptor", "getNetHMacShaKeyPair failByExceptionAppId=" + str + ",requestId=" + str2 + ",e=" + SystemUtils.getDesensitizedException(th));
                return null;
            }
        }
        j2.g("NetEncryptor", "getNetHMacShaKeyPair illegalAppId=" + str + ",requestId=" + str2);
        return null;
    }

    public synchronized Pair<String, String> b() {
        a();
        return Pair.create(this.b, this.c);
    }
}
