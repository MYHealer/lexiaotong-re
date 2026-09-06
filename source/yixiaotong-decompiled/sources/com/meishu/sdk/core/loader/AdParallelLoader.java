package com.meishu.sdk.core.loader;

import android.util.Base64;
import com.google.common.base.Ascii;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AdParallelLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BigInteger f4797a = new BigInteger(1, new byte[]{1, 0, 1});
    public static BigInteger b = new BigInteger(1, new byte[]{-62, -46, -40, 69, -27, 118, 33, -72, -76, -70, -47, -80, 13, 42, 44, -107, 77, -88, -72, -67, 121, Ascii.ESC, -126, -72, -96, -123, -52, 38, -69, -44, 110, 46, -78, 124, Ascii.DC4, 62, -88, 50, -33, Ascii.NAK, -18, 117, -95, -45, -66, -50, -117, -26, -76, 56, 36, 114, -70, 101, Ascii.SYN, 68, -87, -123, -109, 4, -109, -100, -121, 77});
    public static SecureRandom c = new SecureRandom();
    public static final Gson d = new Gson();

    public class a extends GZIPOutputStream {
        public a(OutputStream outputStream) throws IOException {
            super(outputStream);
            ((GZIPOutputStream) this).def.setLevel(5);
        }
    }

    public static byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = new a(byteArrayOutputStream);
        try {
            aVar.write(bArr);
            return byteArrayOutputStream.toByteArray();
        } finally {
            aVar.close();
        }
    }

    public static Map<String, String> wrapParams(Map<String, String> map) {
        try {
            return wrapParams(d.toJson(map).getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[64];
        int length = bArr.length;
        int i = 64 - length;
        int i2 = 63 - length;
        System.arraycopy(bArr, 0, bArr2, i, bArr.length);
        bArr2[0] = 0;
        bArr2[1] = 2;
        bArr2[i2] = 0;
        for (int i3 = 2; i3 < i2; i3++) {
            bArr2[i3] = (byte) (c.nextInt(255) + 1);
        }
        byte[] byteArray = new BigInteger(1, bArr2).modPow(f4797a, b).toByteArray();
        System.out.println(com.meishu.sdk.activity.a.a("L=").append(byteArray.length).toString());
        if (byteArray.length == 64) {
            return byteArray;
        }
        if (byteArray.length > 64) {
            return Arrays.copyOfRange(byteArray, byteArray.length - 64, byteArray.length);
        }
        int length2 = 64 - byteArray.length;
        System.arraycopy(byteArray, 0, bArr2, length2, byteArray.length);
        for (int i4 = 0; i4 < length2; i4++) {
            bArr2[i4] = 0;
        }
        return bArr2;
    }

    public static Map<String, String> wrapParams(byte[] bArr) {
        try {
            String hexString = Long.toHexString(((System.currentTimeMillis() / 3) * 3) + 2);
            byte[] bytes = hexString.getBytes();
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + bytes.length);
            System.arraycopy(bytes, 0, bArrCopyOf, bArr.length, bytes.length);
            HashMap map = new HashMap();
            map.put("nonce", hexString);
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArrCopyOf);
            map.put("signature", Base64.encodeToString(b(bArrDigest), 10));
            try {
                byte[] bArrA = a(bArr);
                map.put("enc", "3");
                bArr = bArrA;
            } catch (IOException unused) {
                map.put("enc", "1");
            }
            byte[] bArr2 = new byte[16];
            c.nextBytes(bArr2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, new SecretKeySpec(bArrDigest, "AES"), new IvParameterSpec(bArr2));
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            byte[] bArrCopyOf2 = Arrays.copyOf(bArrDoFinal, bArrDoFinal.length + 16);
            System.arraycopy(bArr2, 0, bArrCopyOf2, bArrDoFinal.length, 16);
            map.put(CrashHianalyticsData.MESSAGE, Base64.encodeToString(bArrCopyOf2, 10));
            return map;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
