package com.masget.base.util;

import com.kuaishou.weapon.p0.b;
import com.masget.base.bean.Constants;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class EncryptUtil {
    public static String aesEncrypt(String str, String str2, String str3) {
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

    public static String aesDecrypt(String str, String str2, String str3) {
        try {
            byte[] bArrDecode = new Base64().decode(str.replace('-', '+').replace('_', IOUtils.DIR_SEPARATOR_UNIX).getBytes("utf-8"));
            Cipher cipher = Cipher.getInstance(b.f4638a);
            cipher.init(2, new SecretKeySpec(str2.getBytes(), "AES"), new IvParameterSpec(str3.getBytes()));
            return new String(cipher.doFinal(bArrDecode), "UTF-8").trim();
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
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                int i2 = b & 255;
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean verifyResult(String str, String str2) {
        return string2MD5(new StringBuilder().append(str).append(Constants.AES_KEY).toString()).equals(str2);
    }

    public static String base64Encrypt(String str) {
        try {
            return new String(new Base64().encode(str.getBytes("utf-8")), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String base64Decrypt(String str) {
        try {
            return new String(new Base64().decode(str.getBytes("utf-8")), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
