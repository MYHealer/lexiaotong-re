package com.ubixnow.ooooo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.stub.StubApp;
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
public abstract class n0 {
    private static final byte[] OooO00o = new byte[0];
    private static final byte[] OooO0O0 = new byte[0];
    private static SoftReference<byte[]> OooO0OO;

    public class OooO00o implements Runnable {
        public final /* synthetic */ OooO0O0 OooO00o;
        public final /* synthetic */ String OooO0O0;

        public OooO00o(OooO0O0 oooO0O0, String str) {
            this.OooO00o = oooO0O0;
            this.OooO0O0 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.OooO00o.OooO0Oo(this.OooO0O0);
        }
    }

    public static class OooO0O0 {
        private static final Long OooO00o = 120000L;
        private static final byte[] OooO0O0 = new byte[0];
        private static volatile OooO0O0 OooO0OO;
        private SharedPreferences OooO0Oo;
        private SharedPreferences OooO0o;
        private SharedPreferences OooO0o0;
        private Context OooOO0;
        private final byte[] OooO0oO = new byte[0];
        private final byte[] OooO0oo = new byte[0];
        private final byte[] OooO = new byte[0];

        private OooO0O0(Context context) {
            this.OooO0Oo = null;
            this.OooO0o0 = null;
            this.OooO0o = null;
            try {
                this.OooOO0 = StubApp.getOrigApplicationContext(context.getApplicationContext());
                Context contextOooO00o = p0.OooO00o(context);
                this.OooO0Oo = contextOooO00o.getSharedPreferences("identifier_sp_story_book_file", 4);
                this.OooO0o0 = contextOooO00o.getSharedPreferences("identifier_hiad_sp_bed_rock_file", 4);
                this.OooO0o = contextOooO00o.getSharedPreferences("identifier_hiad_sp_red_stone_file", 4);
            } catch (Throwable th) {
                Log.w("Aes128", "get SharedPreference error: " + th.getClass().getSimpleName());
            }
        }

        public static OooO0O0 OooO00o(Context context) {
            OooO0O0 oooO0O0;
            if (OooO0OO != null) {
                return OooO0OO;
            }
            synchronized (OooO0O0) {
                if (OooO0OO == null) {
                    OooO0OO = new OooO0O0(context);
                }
                oooO0O0 = OooO0OO;
            }
            return oooO0O0;
        }

        public String OooO00o() {
            synchronized (this.OooO0oo) {
                SharedPreferences sharedPreferences = this.OooO0o;
                if (sharedPreferences == null) {
                    return "";
                }
                String string = sharedPreferences.getString("read_first_chapter", "");
                if (TextUtils.isEmpty(string)) {
                    return string;
                }
                return n0.OooO0OO(string, n0.OooO0o(this.OooOO0));
            }
        }

        public void OooO00o(String str) {
            synchronized (this.OooO0oo) {
                if (this.OooO0o != null) {
                    byte[] bArrOooO0o = n0.OooO0o(this.OooOO0);
                    this.OooO0o.edit().putString("read_first_chapter", n0.OooO0Oo(str, bArrOooO0o)).apply();
                }
            }
        }

        public void OooO0O0() {
            synchronized (this.OooO) {
                SharedPreferences sharedPreferences = this.OooO0Oo;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong("read_first_chapter_time", System.currentTimeMillis()).apply();
                }
            }
        }

        public void OooO0O0(String str) {
            synchronized (this.OooO0oO) {
                SharedPreferences sharedPreferences = this.OooO0o0;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("get_a_book", str).commit();
                }
            }
        }

        public void OooO0OO(String str) {
            synchronized (this.OooO) {
                SharedPreferences sharedPreferences = this.OooO0Oo;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("catch_a_cat", str).commit();
                }
            }
        }

        public boolean OooO0OO() {
            synchronized (this.OooO) {
                SharedPreferences sharedPreferences = this.OooO0Oo;
                if (sharedPreferences == null) {
                    return false;
                }
                long j = sharedPreferences.getLong("read_first_chapter_time", -1L);
                if (j < 0) {
                    return false;
                }
                return j + OooO00o.longValue() > System.currentTimeMillis();
            }
        }

        public void OooO0Oo() {
            synchronized (this.OooO) {
                SharedPreferences sharedPreferences = this.OooO0Oo;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putBoolean("has_read_first_chapter", true).apply();
                }
            }
        }

        public void OooO0Oo(String str) {
            synchronized (this.OooO) {
                this.OooO0Oo.edit().putString("read_second_chapter", str).apply();
            }
        }

        public String OooO0o() {
            String string;
            synchronized (this.OooO0oO) {
                SharedPreferences sharedPreferences = this.OooO0o0;
                string = sharedPreferences != null ? sharedPreferences.getString("get_a_book", null) : null;
            }
            return string;
        }

        public boolean OooO0o0() {
            boolean z;
            synchronized (this.OooO) {
                SharedPreferences sharedPreferences = this.OooO0Oo;
                z = false;
                if (sharedPreferences != null) {
                    z = sharedPreferences.getBoolean("has_read_first_chapter", false);
                }
            }
            return z;
        }

        public String OooO0oO() {
            synchronized (this.OooO) {
                SharedPreferences sharedPreferences = this.OooO0Oo;
                if (sharedPreferences == null) {
                    return null;
                }
                String string = sharedPreferences.getString("catch_a_cat", null);
                if (string == null) {
                    string = n0.OooO0Oo(n0.OooO0Oo());
                    OooO0OO(string);
                }
                return string;
            }
        }

        public String OooO0oo() {
            String string;
            synchronized (this.OooO) {
                string = this.OooO0Oo.getString("read_second_chapter", "");
            }
            return string;
        }
    }

    private static String OooO00o(Context context) {
        String strOooO00o;
        if (context == null) {
            return "";
        }
        synchronized (OooO0O0) {
            OooO0O0 oooO0O0OooO00o = OooO0O0.OooO00o(context);
            String strOooO0o = oooO0O0OooO00o.OooO0o();
            if (strOooO0o != null) {
                String strOooO0OO = OooO0OO(strOooO0o, OooO0OO(context));
                strOooO00o = TextUtils.isEmpty(strOooO0OO) ? OooO00o(context, oooO0O0OooO00o) : strOooO0OO;
            }
        }
        return strOooO00o;
    }

    private static String OooO00o(Context context, OooO0O0 oooO0O0) {
        String strOooO0Oo = OooO0Oo(OooO00o());
        oooO0O0.OooO0O0(OooO0Oo(strOooO0Oo, OooO0OO(context)));
        return strOooO0Oo;
    }

    public static String OooO00o(String str, String str2) {
        String strOooO0OO;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        synchronized (OooO00o) {
            try {
                strOooO0OO = OooO0OO(str, OooO0O0(str2));
            } catch (Throwable th) {
                Log.w("Aes128", "decrypt oaid ex: " + th.getClass().getSimpleName());
                return null;
            }
        }
        return strOooO0OO;
    }

    private static String OooO00o(String str, byte[] bArr) {
        byte[] bArrOooO00o;
        byte[] bArrOooO00o2;
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || !OooO0OO() || (bArrOooO00o2 = OooO00o(str, bArr, (bArrOooO00o = OooO00o(12)))) == null || bArrOooO00o2.length == 0) {
            return "";
        }
        return OooO0Oo(bArrOooO00o) + OooO0Oo(bArrOooO00o2);
    }

    private static boolean OooO00o(byte[] bArr) {
        return bArr != null && bArr.length >= 12;
    }

    public static byte[] OooO00o() {
        return OooO00o(16);
    }

    public static byte[] OooO00o(int i) {
        byte[] bArr = new byte[i];
        OooO0O0().nextBytes(bArr);
        return bArr;
    }

    private static byte[] OooO00o(Context context, String str) {
        return OooO00o(str, "245d64e65dc9fe70d4d62aa6b941221fa92a3fb07db7a4858e43bf1dbf2972e9", "9b38b1ce5d9b5bba1a6539ad75eae153555c74f5b95e6cdfe5019a6a0e56f466");
    }

    public static byte[] OooO00o(String str) {
        byte[] bArr = new byte[0];
        try {
            return OooO0O0(str);
        } catch (Throwable th) {
            Log.e("Aes128", "hex string 2 byte: " + th.getClass().getSimpleName());
            return bArr;
        }
    }

    private static byte[] OooO00o(String str, String str2, String str3) {
        byte[] bArrOooO00o = OooO00o(str);
        byte[] bArrOooO00o2 = OooO00o(str2);
        return OooO00o(OooO00o(bArrOooO00o, bArrOooO00o2), OooO00o(str3));
    }

    private static byte[] OooO00o(String str, byte[] bArr, byte[] bArr2) {
        if (!TextUtils.isEmpty(str) && OooO0O0(bArr) && OooO00o(bArr2) && OooO0OO()) {
            try {
                return OooO00o(str.getBytes("UTF-8"), bArr, bArr2);
            } catch (UnsupportedEncodingException e) {
                Log.e("Aes128", "GCM encrypt data error" + e.getMessage());
            }
        } else {
            ooooO000.OooO0OO("Aes128", "gcm encrypt param is not right");
        }
        return new byte[0];
    }

    private static byte[] OooO00o(byte[] bArr, byte[] bArr2) {
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

    public static byte[] OooO00o(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        String str;
        if (bArr == null || bArr.length == 0) {
            str = "encrypt, contentBytes invalid.";
        } else if (bArr2 == null || bArr2.length < 16) {
            str = "encrypt, keyBytes invalid.";
        } else if (!OooO0OO()) {
            str = "encrypt, osVersion too low.";
        } else if (bArr3 == null || bArr3.length < 12) {
            str = "encrypt, random invalid.";
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, secretKeySpec, OooO0OO(bArr3));
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e) {
                Log.e("Aes128", "GCM encrypt data error" + e.getMessage());
            }
        }
        ooooO000.OooO0OO("Aes128", str);
        return new byte[0];
    }

    public static byte[] OooO00o(char[] cArr, byte[] bArr) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return SecretKeyFactory.getInstance(Build.VERSION.SDK_INT > 26 ? "PBKDF2WithHmacSHA256" : "PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, 10000, 256)).getEncoded();
    }

    private static String OooO0O0(int i) {
        try {
            SecureRandom secureRandomOooO0O0 = OooO0O0();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(Integer.toHexString(secureRandomOooO0O0.nextInt(16)));
            }
            return sb.toString();
        } catch (Throwable th) {
            Log.w("Aes128", "generate aes key1 err:" + th.getClass().getSimpleName());
            return "";
        }
    }

    private static String OooO0O0(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && OooO0OO()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                String strOooO0OO = OooO0OO(str);
                String strOooO0Oo = OooO0Oo(str);
                if (TextUtils.isEmpty(strOooO0OO) || TextUtils.isEmpty(strOooO0Oo)) {
                    ooooO000.OooO0OO("Aes128", "ivParameter or encrypedWord is null");
                    return "";
                }
                cipher.init(2, secretKeySpec, OooO0OO(OooO00o(strOooO0OO)));
                return new String(cipher.doFinal(OooO00o(strOooO0Oo)), "UTF-8");
            } catch (UnsupportedEncodingException | GeneralSecurityException e) {
                Log.e("Aes128", "GCM decrypt data exception: " + e.getMessage());
            }
        }
        return "";
    }

    private static SecureRandom OooO0O0() {
        SecureRandom instanceStrong;
        try {
            instanceStrong = SecureRandom.getInstanceStrong();
        } catch (Exception e) {
            Log.w("Aes128", "getInstanceStrong, exception: " + e.getClass().getSimpleName());
            instanceStrong = null;
        }
        return instanceStrong == null ? new SecureRandom() : instanceStrong;
    }

    private static boolean OooO0O0(byte[] bArr) {
        return bArr != null && bArr.length >= 16;
    }

    private static byte[] OooO0O0(Context context) {
        ooooO000.OooO0OO("Aes128", "regenerateWorkKey");
        OooO0O0.OooO00o(context).OooO0O0("");
        return OooO00o(OooO00o(context));
    }

    public static byte[] OooO0O0(String str) throws NumberFormatException, UnsupportedEncodingException {
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

    private static String OooO0OO(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        ooooO000.OooO0OO("Aes128", "IV is invalid.");
        return "";
    }

    public static String OooO0OO(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && str.length() >= 32 && bArr != null && bArr.length != 0) {
            try {
                if (OooO0OO()) {
                    return OooO0O0(str, bArr);
                }
            } catch (Throwable th) {
                Log.w("Aes128", "fail to decrypt: " + th.getClass().getSimpleName());
            }
        }
        return "";
    }

    private static AlgorithmParameterSpec OooO0OO(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    private static boolean OooO0OO() {
        return true;
    }

    private static byte[] OooO0OO(Context context) {
        String str;
        if (context == null) {
            return new byte[0];
        }
        OooO0O0 oooO0O0OooO00o = OooO0O0.OooO00o(context);
        try {
            return OooO00o(OooO0Oo(OooO0Oo(context)).toCharArray(), OooO00o(oooO0O0OooO00o.OooO0oO()));
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

    private static String OooO0Oo(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    public static String OooO0Oo(String str, byte[] bArr) {
        StringBuilder sb;
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length != 0) {
            try {
                if (OooO0OO()) {
                    return OooO00o(str, bArr);
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

    public static String OooO0Oo(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] OooO0Oo() {
        return OooO00o(16);
    }

    private static byte[] OooO0Oo(Context context) {
        return OooO00o(context, OooO0o0(context));
    }

    public static byte[] OooO0o(Context context) {
        byte[] bArr;
        byte[] bArrOooO0O0;
        synchronized (OooO0O0) {
            SoftReference<byte[]> softReference = OooO0OO;
            bArr = softReference != null ? softReference.get() : null;
            if (bArr == null) {
                try {
                    bArrOooO0O0 = OooO0O0(OooO00o(context));
                } catch (UnsupportedEncodingException unused) {
                    Log.w("Aes128", "getWorkKeyBytes UnsupportedEncodingException");
                    bArrOooO0O0 = OooO0O0(context);
                } catch (Throwable th) {
                    Log.w("Aes128", "getWorkKeyBytes " + th.getClass().getSimpleName());
                    bArrOooO0O0 = OooO0O0(context);
                }
                bArr = bArrOooO0O0;
                OooO0OO = new SoftReference<>(bArr);
            }
        }
        return bArr;
    }

    private static String OooO0o0(Context context) {
        OooO0O0 oooO0O0OooO00o = OooO0O0.OooO00o(context);
        String strOooO0oo = oooO0O0OooO00o.OooO0oo();
        if (!TextUtils.isEmpty(strOooO0oo)) {
            return strOooO0oo;
        }
        String strOooO0O0 = OooO0O0(64);
        p0.OooO00o.execute(new OooO00o(oooO0O0OooO00o, strOooO0O0));
        return strOooO0O0;
    }
}
