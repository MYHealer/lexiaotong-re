package com.adprof.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class xp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoftReference f1527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f847a = new byte[0];
    public static final byte[] b = new byte[0];

    public static String a(byte[] bArr) {
        if (bArr.length == 0) {
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

    public static SecureRandom a() {
        SecureRandom instanceStrong;
        try {
            instanceStrong = SecureRandom.getInstanceStrong();
        } catch (Exception e) {
            Log.w("Aes128", "getInstanceStrong, exception: " + e.getClass().getSimpleName());
            instanceStrong = null;
        }
        return instanceStrong == null ? new SecureRandom() : instanceStrong;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m727a() {
        return true;
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        a().nextBytes(bArr);
        return bArr;
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

    public static byte[] a(byte[] bArr, byte[] bArr2) {
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
        if (bArr == null || bArr.length == 0) {
            pk.a("Aes128", "encrypt, contentBytes invalid.");
            return new byte[0];
        }
        if (bArr2 == null || bArr2.length < 16) {
            pk.a("Aes128", "encrypt, keyBytes invalid.");
            return new byte[0];
        }
        if (!m727a()) {
            pk.a("Aes128", "encrypt, osVersion too low.");
            return new byte[0];
        }
        if (bArr3 == null || bArr3.length < 12) {
            pk.a("Aes128", "encrypt, random invalid.");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr3));
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            Log.e("Aes128", "GCM encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] a(char[] cArr, byte[] bArr) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return SecretKeyFactory.getInstance(Build.VERSION.SDK_INT > 26 ? "PBKDF2WithHmacSHA256" : "PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, 10000, 256)).getEncoded();
    }

    public static String b(String str, byte[] bArr) {
        String strSubstring;
        if (!TextUtils.isEmpty(str) && bArr.length >= 16 && m727a()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                if (TextUtils.isEmpty(str) || str.length() < 24) {
                    pk.a("Aes128", "IV is invalid.");
                    strSubstring = "";
                } else {
                    strSubstring = str.substring(0, 24);
                }
                String strSubstring2 = (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
                if (TextUtils.isEmpty(strSubstring) || TextUtils.isEmpty(strSubstring2)) {
                    pk.a("Aes128", "ivParameter or encrypedWord is null");
                    return "";
                }
                cipher.init(2, secretKeySpec, new GCMParameterSpec(128, a(strSubstring)));
                return new String(cipher.doFinal(a(strSubstring2)), "UTF-8");
            } catch (UnsupportedEncodingException | GeneralSecurityException e) {
                Log.e("Aes128", "GCM decrypt data exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static byte[] b(String str) throws NumberFormatException, UnsupportedEncodingException {
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

    public static String c(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && str.length() >= 32 && bArr != null && bArr.length != 0) {
            try {
                if (m727a()) {
                    return b(str, bArr);
                }
            } catch (Throwable th) {
                Log.w("Aes128", "fail to decrypt: " + th.getClass().getSimpleName());
            }
        }
        return "";
    }

    public static String d(String str, byte[] bArr) {
        StringBuilder sb;
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length != 0) {
            try {
                if (m727a()) {
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

    public static String a(Context context) {
        String string;
        String strC;
        String strA;
        String strD;
        if (context == null) {
            return "";
        }
        synchronized (b) {
            wp wpVarA = wp.a(context);
            synchronized (wpVarA.f814a) {
                SharedPreferences sharedPreferences = wpVarA.b;
                string = null;
                if (sharedPreferences != null) {
                    string = sharedPreferences.getString("get_a_book", null);
                }
            }
            if (string == null) {
                strA = a(a(16));
                strD = d(strA, m728a(context));
            } else {
                strC = c(string, m728a(context));
                if (TextUtils.isEmpty(strC)) {
                    strA = a(a(16));
                    strD = d(strA, m728a(context));
                }
            }
            wpVarA.b(strD);
            strC = strA;
        }
        return strC;
    }

    public static byte[] b(Context context) {
        byte[] bArr;
        byte[] bArrA;
        synchronized (b) {
            SoftReference softReference = f1527a;
            bArr = softReference != null ? (byte[]) softReference.get() : null;
            if (bArr == null) {
                try {
                    bArrA = b(a(context));
                } catch (UnsupportedEncodingException unused) {
                    Log.w("Aes128", "getWorkKeyBytes UnsupportedEncodingException");
                    pk.a("Aes128", "regenerateWorkKey");
                    wp.a(context).b("");
                    bArrA = a(a(context));
                } catch (Throwable th) {
                    Log.w("Aes128", "getWorkKeyBytes " + th.getClass().getSimpleName());
                    pk.a("Aes128", "regenerateWorkKey");
                    wp.a(context).b("");
                    bArrA = a(a(context));
                }
                bArr = bArrA;
                f1527a = new SoftReference(bArr);
            }
        }
        return bArr;
    }

    public static String a(String str, byte[] bArr) {
        byte[] bArrA;
        if (!TextUtils.isEmpty(str) && bArr.length >= 16 && m727a()) {
            byte[] bArrA2 = a(12);
            if (TextUtils.isEmpty(str) || bArr.length < 16 || bArrA2.length < 12 || !m727a()) {
                pk.a("Aes128", "gcm encrypt param is not right");
            } else {
                try {
                    bArrA = a(str.getBytes("UTF-8"), bArr, bArrA2);
                } catch (UnsupportedEncodingException e) {
                    Log.e("Aes128", "GCM encrypt data error" + e.getMessage());
                    bArrA = new byte[0];
                }
                if (bArrA != null && bArrA.length != 0) {
                    return a(bArrA2) + a(bArrA);
                }
            }
            bArrA = new byte[0];
            if (bArrA != null) {
                return a(bArrA2) + a(bArrA);
            }
        }
        return "";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m728a(Context context) {
        String string;
        String string2;
        String string3;
        String str;
        String str2;
        if (context == null) {
            return new byte[0];
        }
        wp wpVarA = wp.a(context);
        wp wpVarA2 = wp.a(context);
        synchronized (wpVarA2.f816c) {
            string = wpVarA2.f813a.getString("read_second_chapter", "");
        }
        if (TextUtils.isEmpty(string)) {
            try {
                SecureRandom secureRandomA = a();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 64; i++) {
                    sb.append(Integer.toHexString(secureRandomA.nextInt(16)));
                }
                string2 = sb.toString();
            } catch (Throwable th) {
                Log.w("Aes128", "generate aes key1 err:" + th.getClass().getSimpleName());
                string2 = "";
            }
            string = string2;
            yp.f1545a.execute(new vp(wpVarA2, string));
        }
        byte[] bArrA = a(a(a(string), a("245d64e65dc9fe70d4d62aa6b941221fa92a3fb07db7a4858e43bf1dbf2972e9")), a("9b38b1ce5d9b5bba1a6539ad75eae153555c74f5b95e6cdfe5019a6a0e56f466"));
        synchronized (wpVarA.f816c) {
            SharedPreferences sharedPreferences = wpVarA.f813a;
            if (sharedPreferences == null) {
                string3 = null;
            } else {
                string3 = sharedPreferences.getString("catch_a_cat", null);
                if (string3 == null) {
                    string3 = a(a(16));
                    synchronized (wpVarA.f816c) {
                        SharedPreferences sharedPreferences2 = wpVarA.f813a;
                        if (sharedPreferences2 != null) {
                            sharedPreferences2.edit().putString("catch_a_cat", string3).commit();
                        }
                    }
                }
            }
        }
        try {
            return a(a(bArrA).toCharArray(), a(string3));
        } catch (NoSuchAlgorithmException unused) {
            str = "Aes128";
            str2 = "get userRootKey NoSuchAlgorithmException";
            Log.w(str, str2);
            return null;
        } catch (InvalidKeySpecException unused2) {
            str = "Aes128";
            str2 = "get userRootKey InvalidKeySpecException";
            Log.w(str, str2);
            return null;
        }
    }
}
