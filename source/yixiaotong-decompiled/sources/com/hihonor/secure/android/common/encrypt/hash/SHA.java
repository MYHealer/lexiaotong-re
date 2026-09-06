package com.hihonor.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.hihonor.secure.android.common.encrypt.utils.HexUtil;
import com.hihonor.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class SHA {
    private static final String B = "SHA-256";
    private static final String TAG = "SHA";
    private static final String i = "";
    private static final String[] r = {"SHA-256", MessageDigestAlgorithms.SHA_384, MessageDigestAlgorithms.SHA_512};

    public static String sha256Encrypt(String str) {
        return shaEncrypt(str, "SHA-256");
    }

    public static String shaEncrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.f(TAG, "content or algorithm is null.");
            return "";
        }
        if (!d(str2)) {
            b.f(TAG, "algorithm is not safe or legal");
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes("UTF-8"));
            return HexUtil.byteArray2HexStr(messageDigest.digest());
        } catch (UnsupportedEncodingException unused) {
            b.f(TAG, "Error in generate SHA UnsupportedEncodingException");
            return "";
        } catch (NoSuchAlgorithmException unused2) {
            b.f(TAG, "Error in generate SHA NoSuchAlgorithmException");
            return "";
        }
    }

    public static boolean validateSHA256(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(sha256Encrypt(str));
    }

    public static boolean validateSHA(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        return str2.equals(shaEncrypt(str, str3));
    }

    private static boolean d(String str) {
        for (String str2 : r) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
