package com.hihonor.hianalytics.hnha;

import android.os.Build;
import android.text.TextUtils;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f3668a = null;
    private RandomAccessFile b = null;
    private FileChannel c = null;
    private FileLock d = null;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    p() {
    }

    private String a(File file, String str) {
        return !file.exists() ? "" : com.hihonor.hianalytics.util.f.c(new File(file.getPath(), "hianalytics_" + str));
    }

    private String a(String str) {
        StringBuilder sb;
        String strDecrypt = j() ? AesGcmKS.decrypt("analytics_keystore_formal_new", str) : "";
        if (TextUtils.isEmpty(strDecrypt)) {
            j2.c("DataEncryptor", "deCrypt work key first version=" + Build.VERSION.SDK_INT);
            strDecrypt = (String) s1.a(str, g()).second;
            if (TextUtils.isEmpty(strDecrypt)) {
                strDecrypt = w1.b();
                c(b(strDecrypt));
                if (j()) {
                    sb = new StringBuilder();
                    v1.a(sb.append(i()).append("/hianalytics").toString());
                }
            } else if (j()) {
                c(b(strDecrypt));
                sb = new StringBuilder();
                v1.a(sb.append(i()).append("/hianalytics").toString());
            }
        }
        return strDecrypt;
    }

    private String a(String str, String str2) {
        File file;
        StringBuilder sbAppend = new StringBuilder().append(i());
        String str3 = File.separator;
        String strA = a(new File(sbAppend.append(str3).append(str).toString()), str);
        if (TextUtils.isEmpty(strA)) {
            strA = a(new File(i() + str3 + "hianalytics" + str3 + str2), str2);
            if (TextUtils.isEmpty(strA)) {
                strA = w1.c();
                File file2 = new File(i() + str3 + "hianalytics" + str3 + str2);
                if (!file2.exists() && file2.mkdirs()) {
                    j2.g("HianalyticsSDK", "The secret key file creates the OK!");
                }
                file = new File(i() + str3 + "hianalytics" + str3 + str2, "hianalytics_" + str2);
            }
            return strA;
        }
        File file3 = new File(i() + str3 + str);
        v1.b(file3);
        if (file3.isDirectory() && file3.delete()) {
            j2.g("HianalyticsSDK", "The secret key file is Directory del! change new file");
        }
        File file4 = new File(i() + str3 + "hianalytics" + str3 + str2);
        if (!file4.exists() && file4.mkdirs()) {
            j2.g("HianalyticsSDK", "The secret key file creates the OK!");
        }
        file = new File(i() + str3 + "hianalytics" + str3 + str2, "hianalytics_" + str2);
        com.hihonor.hianalytics.util.f.a(file, strA);
        return strA;
    }

    private boolean a() {
        if (this.f3668a == null) {
            this.f3668a = new File(i(), "ha_lock_help");
        }
        if (!com.hihonor.hianalytics.util.f.a(this.f3668a)) {
            return false;
        }
        if (this.f3668a.length() <= 0) {
            com.hihonor.hianalytics.util.f.a(this.f3668a, "God is a dog!");
        }
        return this.f3668a.length() > 0;
    }

    private String b(String str) {
        return j() ? AesGcmKS.encrypt("analytics_keystore_formal_new", str) : (String) s1.b(str, g()).second;
    }

    private String f() {
        return y1.a(y1.a() + d1.a() + w1.a(), 4);
    }

    private String g() {
        if (TextUtils.isEmpty(this.f)) {
            this.f = h();
        }
        return this.f;
    }

    private String h() {
        return y1.a(f(), a("secondAssembly", "aprpap"), a("thirdAssembly", "febdoc"), a("fourthAssembly", "marfil"), a("fiveAssembly", "maywnj"));
    }

    private String i() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = com.hihonor.hianalytics.util.f.a();
        }
        return this.e;
    }

    private boolean j() {
        return true;
    }

    private void k() {
        FileLock fileLock = this.d;
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (Throwable th) {
                j2.a("DataEncryptor", "releaseLockFile failE=" + SystemUtils.getDesensitizedException(th));
            }
        }
        com.hihonor.hianalytics.util.k.a(this.c);
        com.hihonor.hianalytics.util.k.a(this.b);
    }

    private void l() {
        try {
            if (!a()) {
                StringBuilder sbAppend = new StringBuilder("requestLockFile failByFile=").append(this.f3668a).append(",len=");
                File file = this.f3668a;
                j2.a("DataEncryptor", sbAppend.append(file == null ? 0L : file.length()).toString());
                return;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.f3668a, "rw");
            this.b = randomAccessFile;
            this.c = randomAccessFile.getChannel();
            int i = 0;
            while (i < 5) {
                try {
                    this.d = this.c.lock();
                    j2.a("DataEncryptor", "requestLockFile retryTimes=" + i + ",success");
                    return;
                } catch (Throwable th) {
                    i++;
                    j2.a("DataEncryptor", "requestLockFile retryTimes=" + i + ",fail=" + SystemUtils.getDesensitizedException(th));
                    com.hihonor.hianalytics.util.k.a(1000L);
                }
            }
        } catch (Throwable th2) {
            j2.g("DataEncryptor", "requestLockFile failE=" + SystemUtils.getDesensitizedException(th2));
        }
    }

    public synchronized String b() {
        if (TextUtils.isEmpty(this.g)) {
            try {
                l();
                String strE = e();
                if (TextUtils.isEmpty(strE)) {
                    String strB = w1.b();
                    String strB2 = b(strB);
                    c(strB2);
                    this.g = strB;
                    strE = strB2;
                } else {
                    this.g = a(strE);
                }
                this.h = k.c().b(this.g);
                this.i = k.c().b(strE);
                j2.a("DataEncryptor", "getAesKey nowKey=" + this.g + ",keyMd5=" + this.h + ",storeAesKey=" + strE + ",storeKeyMd5=" + this.i);
                k();
            } catch (Throwable th) {
                k();
                throw th;
            }
        }
        return this.g;
    }

    public String c() {
        return this.h;
    }

    protected void c(String str) {
        u.b(str);
        u.a(System.currentTimeMillis());
    }

    public String d() {
        return this.i;
    }

    protected String e() {
        return u.b();
    }
}
