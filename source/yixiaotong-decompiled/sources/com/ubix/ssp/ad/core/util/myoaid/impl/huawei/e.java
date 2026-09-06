package com.ubix.ssp.ad.core.util.myoaid.impl.huawei;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.u;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f8600a = new byte[0];
    private static final byte[] b = new byte[0];
    private static SoftReference<byte[]> c;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f8601a;
        final /* synthetic */ String b;

        a(b bVar, String str) {
            this.f8601a = bVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8601a.d(this.b);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Long f8602a = 120000L;
        private static final byte[] b = new byte[0];
        private static volatile b c;
        private SharedPreferences d;
        private SharedPreferences e;
        private SharedPreferences f;
        private final byte[] g = new byte[0];
        private final byte[] h = new byte[0];
        private final byte[] i = new byte[0];
        private Context j;

        private b(Context context) {
            this.d = null;
            this.e = null;
            this.f = null;
            try {
                this.j = StubApp.getOrigApplicationContext(context.getApplicationContext());
                Context contextA = f.a(context);
                this.d = contextA.getSharedPreferences("identifier_sp_story_book_file", 4);
                this.e = contextA.getSharedPreferences("identifier_hiad_sp_bed_rock_file", 4);
                this.f = contextA.getSharedPreferences("identifier_hiad_sp_red_stone_file", 4);
            } catch (Throwable th) {
                Log.w("Aes128", "get SharedPreference error: " + th.getClass().getSimpleName());
            }
        }

        public static b a(Context context) {
            b bVar;
            if (c != null) {
                return c;
            }
            synchronized (b) {
                if (c == null) {
                    c = new b(context);
                }
                bVar = c;
            }
            return bVar;
        }

        public String a() {
            synchronized (this.h) {
                SharedPreferences sharedPreferences = this.f;
                if (sharedPreferences == null) {
                    return "";
                }
                String string = sharedPreferences.getString("read_first_chapter", "");
                if (TextUtils.isEmpty(string)) {
                    return string;
                }
                return e.c(string, e.f(this.j));
            }
        }

        public void a(String str) {
            synchronized (this.h) {
                if (this.f != null) {
                    byte[] bArrF = e.f(this.j);
                    this.f.edit().putString("read_first_chapter", e.d(str, bArrF)).apply();
                }
            }
        }

        public void b() {
            synchronized (this.i) {
                SharedPreferences sharedPreferences = this.d;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong("read_first_chapter_time", System.currentTimeMillis()).apply();
                }
            }
        }

        void b(String str) {
            synchronized (this.g) {
                SharedPreferences sharedPreferences = this.e;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("get_a_book", str).commit();
                }
            }
        }

        void c(String str) {
            synchronized (this.i) {
                SharedPreferences sharedPreferences = this.d;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("catch_a_cat", str).commit();
                }
            }
        }

        public boolean c() {
            synchronized (this.i) {
                SharedPreferences sharedPreferences = this.d;
                if (sharedPreferences == null) {
                    return false;
                }
                long j = sharedPreferences.getLong("read_first_chapter_time", -1L);
                if (j < 0) {
                    return false;
                }
                return j + f8602a.longValue() > System.currentTimeMillis();
            }
        }

        public void d() {
            synchronized (this.i) {
                SharedPreferences sharedPreferences = this.d;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putBoolean("has_read_first_chapter", true).apply();
                }
            }
        }

        public void d(String str) {
            synchronized (this.i) {
                this.d.edit().putString("read_second_chapter", str).apply();
            }
        }

        public boolean e() {
            boolean z;
            synchronized (this.i) {
                SharedPreferences sharedPreferences = this.d;
                z = false;
                if (sharedPreferences != null) {
                    z = sharedPreferences.getBoolean("has_read_first_chapter", false);
                }
            }
            return z;
        }

        String f() {
            String string;
            synchronized (this.g) {
                SharedPreferences sharedPreferences = this.e;
                string = sharedPreferences != null ? sharedPreferences.getString("get_a_book", null) : null;
            }
            return string;
        }

        String g() {
            synchronized (this.i) {
                SharedPreferences sharedPreferences = this.d;
                if (sharedPreferences == null) {
                    return null;
                }
                String string = sharedPreferences.getString("catch_a_cat", null);
                if (string == null) {
                    string = e.d(e.d());
                    c(string);
                }
                return string;
            }
        }

        public String h() {
            String string;
            synchronized (this.i) {
                string = this.d.getString("read_second_chapter", "");
            }
            return string;
        }
    }

    private static String a(Context context) {
        String strA;
        if (context == null) {
            return "";
        }
        synchronized (b) {
            b bVarA = b.a(context);
            String strF = bVarA.f();
            if (strF != null) {
                String strC = c(strF, c(context));
                strA = TextUtils.isEmpty(strC) ? a(context, bVarA) : strC;
            }
        }
        return strA;
    }

    private static String a(Context context, b bVar) {
        String strD = d(a());
        bVar.b(d(strD, c(context)));
        return strD;
    }

    public static String a(String str, String str2) {
        String strC;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        synchronized (f8600a) {
            try {
                strC = c(str, b(str2));
            } catch (Throwable th) {
                Log.w("Aes128", "decrypt oaid ex: " + th.getClass().getSimpleName());
                return null;
            }
        }
        return strC;
    }

    private static String a(String str, byte[] bArr) {
        byte[] bArrA;
        byte[] bArrA2;
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || !c() || (bArrA2 = a(str, bArr, (bArrA = a(12)))) == null || bArrA2.length == 0) {
            return "";
        }
        return d(bArrA) + d(bArrA2);
    }

    private static boolean a(byte[] bArr) {
        return bArr != null && bArr.length >= 12;
    }

    public static byte[] a() {
        return a(16);
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        b().nextBytes(bArr);
        return bArr;
    }

    private static byte[] a(Context context, String str) {
        return a(str, "245d64e65dc9fe70d4d62aa6b941221fa92a3fb07db7a4858e43bf1dbf2972e9", "9b38b1ce5d9b5bba1a6539ad75eae153555c74f5b95e6cdfe5019a6a0e56f466");
    }

    public static byte[] a(String str) {
        byte[] bArr = new byte[0];
        try {
            return b(str);
        } catch (Throwable th) {
            Log.e("Aes128", "hex string 2 byte: " + th.getClass().getSimpleName());
            return bArr;
        }
    }

    private static byte[] a(String str, String str2, String str3) {
        byte[] bArrA = a(str);
        byte[] bArrA2 = a(str2);
        return a(a(bArrA, bArrA2), a(str3));
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (!TextUtils.isEmpty(str) && b(bArr) && a(bArr2) && c()) {
            try {
                return a(str.getBytes("UTF-8"), bArr, bArr2);
            } catch (UnsupportedEncodingException e) {
                Log.e("Aes128", "GCM encrypt data error" + e.getMessage());
            }
        } else {
            u.e("Aes128", "gcm encrypt param is not right");
        }
        return new byte[0];
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= bArr2.length) {
            bArr2 = bArr;
            bArr = bArr2;
        }
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length];
        int i = 0;
        while (i < length2) {
            bArr3[i] = (byte) (bArr2[i] ^ bArr[i]);
            i++;
        }
        while (i < bArr.length) {
            bArr3[i] = bArr[i];
            i++;
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        String str;
        if (bArr == null || bArr.length == 0) {
            str = "encrypt, contentBytes invalid.";
        } else if (bArr2 == null || bArr2.length < 16) {
            str = "encrypt, keyBytes invalid.";
        } else if (!c()) {
            str = "encrypt, osVersion too low.";
        } else if (bArr3 == null || bArr3.length < 12) {
            str = "encrypt, random invalid.";
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, secretKeySpec, c(bArr3));
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e) {
                Log.e("Aes128", "GCM encrypt data error" + e.getMessage());
            }
        }
        u.e("Aes128", str);
        return new byte[0];
    }

    public static byte[] a(char[] cArr, byte[] bArr) {
        return SecretKeyFactory.getInstance(Build.VERSION.SDK_INT > 26 ? "PBKDF2WithHmacSHA256" : "PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, 10000, 256)).getEncoded();
    }

    private static String b(int i) {
        try {
            SecureRandom secureRandomB = b();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(Integer.toHexString(secureRandomB.nextInt(16)));
            }
            return sb.toString();
        } catch (Throwable th) {
            Log.w("Aes128", "generate aes key1 err:" + th.getClass().getSimpleName());
            return "";
        }
    }

    private static String b(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && c()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                String strC = c(str);
                String strD = d(str);
                if (TextUtils.isEmpty(strC) || TextUtils.isEmpty(strD)) {
                    u.e("Aes128", "ivParameter or encrypedWord is null");
                    return "";
                }
                cipher.init(2, secretKeySpec, c(a(strC)));
                return new String(cipher.doFinal(a(strD)), "UTF-8");
            } catch (UnsupportedEncodingException | GeneralSecurityException e) {
                Log.e("Aes128", "GCM decrypt data exception: " + e.getMessage());
            }
        }
        return "";
    }

    private static SecureRandom b() {
        SecureRandom instanceStrong;
        try {
            instanceStrong = SecureRandom.getInstanceStrong();
        } catch (Exception e) {
            Log.w("Aes128", "getInstanceStrong, exception: " + e.getClass().getSimpleName());
            instanceStrong = null;
        }
        return instanceStrong == null ? new SecureRandom() : instanceStrong;
    }

    private static boolean b(byte[] bArr) {
        return bArr != null && bArr.length >= 16;
    }

    private static byte[] b(Context context) {
        u.e("Aes128", "regenerateWorkKey");
        b.a(context).b("");
        return a(a(context));
    }

    public static byte[] b(String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = upperCase.getBytes("UTF-8");
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (((byte) (Byte.decode("0x".concat(new String(new byte[]{bytes[i2]}, "UTF-8"))).byteValue() << 4)) ^ Byte.decode("0x".concat(new String(new byte[]{bytes[i2 + 1]}, "UTF-8"))).byteValue());
        }
        return bArr;
    }

    private static String c(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        u.e("Aes128", "IV is invalid.");
        return "";
    }

    public static String c(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && str.length() >= 32 && bArr != null && bArr.length != 0) {
            try {
                if (c()) {
                    return b(str, bArr);
                }
            } catch (Throwable th) {
                Log.w("Aes128", "fail to decrypt: " + th.getClass().getSimpleName());
            }
        }
        return "";
    }

    private static AlgorithmParameterSpec c(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    private static boolean c() {
        return true;
    }

    private static byte[] c(Context context) {
        String str;
        if (context == null) {
            return new byte[0];
        }
        b bVarA = b.a(context);
        try {
            return a(d(d(context)).toCharArray(), a(bVarA.g()));
        } catch (NoSuchAlgorithmException unused) {
            str = "get userRootKey NoSuchAlgorithmException";
            Log.w("Aes128", str);
            return null;
        } catch (InvalidKeySpecException unused2) {
            str = "get userRootKey InvalidKeySpecException";
            Log.w("Aes128", str);
            return null;
        }
    }

    private static String d(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    public static String d(String str, byte[] bArr) {
        StringBuilder sb;
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length != 0) {
            try {
                if (c()) {
                    return a(str, bArr);
                }
            } catch (Exception e) {
                e = e;
                sb = new StringBuilder("fail to cipher: ");
                Log.w("Aes128", sb.append(e.getClass().getSimpleName()).toString());
            } catch (Throwable th) {
                e = th;
                sb = new StringBuilder("fail to cipher: ");
                Log.w("Aes128", sb.append(e.getClass().getSimpleName()).toString());
            }
        }
        return "";
    }

    public static String d(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] d() {
        return a(16);
    }

    private static byte[] d(Context context) {
        return a(context, e(context));
    }

    private static String e(Context context) {
        b bVarA = b.a(context);
        String strH = bVarA.h();
        if (!TextUtils.isEmpty(strH)) {
            return strH;
        }
        String strB = b(64);
        f.f8603a.execute(new a(bVarA, strB));
        return strB;
    }

    public static byte[] f(Context context) {
        byte[] bArr;
        byte[] bArrB;
        synchronized (b) {
            SoftReference<byte[]> softReference = c;
            bArr = softReference != null ? softReference.get() : null;
            if (bArr == null) {
                try {
                    bArrB = b(a(context));
                } catch (UnsupportedEncodingException unused) {
                    Log.w("Aes128", "getWorkKeyBytes UnsupportedEncodingException");
                    bArrB = b(context);
                } catch (Throwable th) {
                    Log.w("Aes128", "getWorkKeyBytes " + th.getClass().getSimpleName());
                    bArrB = b(context);
                }
                bArr = bArrB;
                c = new SoftReference<>(bArr);
            }
        }
        return bArr;
    }
}
