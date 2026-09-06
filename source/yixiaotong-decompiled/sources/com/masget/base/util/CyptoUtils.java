package com.masget.base.util;

import com.kuaishou.weapon.p0.b;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CyptoUtils {
    public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";

    public static String encode(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            cipher.init(1, secretKeyGenerateSecret, new IvParameterSpec("12345678".getBytes()));
            return byte2hex(cipher.doFinal(str2.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static String decode(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            cipher.init(2, secretKeyGenerateSecret, new IvParameterSpec("12345678".getBytes()));
            return new String(cipher.doFinal(hex2byte(str2.getBytes())));
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    private static String byte2hex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; bArr != null && i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase();
    }

    private static byte[] hex2byte(byte[] bArr) {
        if (bArr.length % 2 != 0) {
            throw new IllegalArgumentException();
        }
        byte[] bArr2 = new byte[bArr.length / 2];
        for (int i = 0; i < bArr.length; i += 2) {
            bArr2[i / 2] = (byte) Integer.parseInt(new String(bArr, i, 2), 16);
        }
        return bArr2;
    }

    public static String AesEncrypt(String str, String str2, String str3) {
        try {
            Cipher cipher = Cipher.getInstance(b.f4638a);
            int blockSize = cipher.getBlockSize();
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"), new IvParameterSpec(str3.getBytes()));
            return new String(new Base64().encode(cipher.doFinal(bArr)), "utf-8").replace(IOUtils.LINE_SEPARATOR_UNIX, "").replace("\r", "").replace('+', '-').replace(IOUtils.DIR_SEPARATOR_UNIX, '_');
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String AesDesencrypt(String str, String str2, String str3) {
        if (str == null) {
            return "";
        }
        try {
            byte[] bArrDecode = new Base64().decode(str.replace('-', '+').replace('_', IOUtils.DIR_SEPARATOR_UNIX).getBytes("utf-8"));
            Cipher cipher = Cipher.getInstance(b.f4638a);
            cipher.init(2, new SecretKeySpec(str2.getBytes(), "AES"), new IvParameterSpec(str3.getBytes()));
            return new String(cipher.doFinal(bArrDecode), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String string2MD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] bArrDigest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                int i2 = b & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
    }
}
