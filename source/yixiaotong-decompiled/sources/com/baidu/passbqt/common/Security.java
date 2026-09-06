package com.baidu.passbqt.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class Security {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1921a = "Security";

    Security() {
    }

    public String a(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        try {
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString).append(str);
            }
        } catch (Exception unused) {
            Log.d(f1921a, "toHexString is error");
        }
        return sb.toString();
    }

    public String a(byte[] bArr) {
        int i;
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length * 8;
        int i2 = 6;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        byte b = 0;
        while (true) {
            if (i3 > 0 && i2 > 0) {
                if (i4 >= 0 && i4 < bArr.length - 1) {
                    b = (byte) (((bArr[i4] & 255) << i2) | ((bArr[i4 + 1] & 255) >> (8 - i2)));
                }
                b = (byte) (b & Utf8.REPLACEMENT_BYTE);
                i3 = 8 - i2;
                i2 = 6 - i3;
            } else if (i3 == 0) {
                if (i4 >= 0 && i4 < bArr.length) {
                    b = (byte) ((bArr[i4] & 255) >> (8 - i2));
                }
                i3 = 2;
                i2 = 4;
            } else if (i2 == 0) {
                if (i4 >= 0 && i4 < bArr.length) {
                    b = (byte) (bArr[i4] & Utf8.REPLACEMENT_BYTE);
                }
                i2 = 6;
                i3 = 0;
            }
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(b));
            i5 += 6;
            int i6 = i5 / 8;
            i = length - i5;
            if (i < 6) {
                break;
            }
            i4 = i6;
        }
        if (i > 0) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte) ((bArr[bArr.length - 1] << (6 - i)) & 63)));
        }
        int i7 = length % 3;
        for (int i8 = 0; i8 < i7; i8++) {
            sb.append("=");
        }
        return sb.toString();
    }

    static class AES {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f1922a = "UTF-8";
        private static final String b = "AES/CBC/NoPadding";
        private static final String c = "AES";
        private String d;
        private String e;
        private String f;

        public AES() {
            this(c, "AES/CBC/NoPadding", "UTF-8");
        }

        public AES(String str, String str2, String str3) {
            this.f = str;
            this.e = str2;
            this.d = str3;
        }

        public byte[] a(String str, String str2, String str3) throws Exception {
            if (str == null || str.length() == 0) {
                throw new Exception("Empty string");
            }
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.d));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.f);
                Cipher cipher = Cipher.getInstance(this.e);
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(a(str).getBytes());
            } catch (NoSuchAlgorithmException e) {
                Log.a(e);
                return null;
            } catch (NoSuchPaddingException e2) {
                Log.a(e2);
                return null;
            }
        }

        public byte[] a(byte[] bArr, String str, String str2) throws Exception {
            if (bArr == null || bArr.length == 0) {
                throw new Exception("Empty string");
            }
            byte[] bArr2 = new byte[0];
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.d));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.f);
                Cipher cipher = Cipher.getInstance(this.e);
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (Throwable th) {
                Log.a(th);
                return bArr2;
            }
        }

        private String a(String str) {
            int length = 16 - (str.getBytes().length % 16);
            for (int i = 0; i < length; i++) {
                str = str + ' ';
            }
            return str;
        }
    }
}
