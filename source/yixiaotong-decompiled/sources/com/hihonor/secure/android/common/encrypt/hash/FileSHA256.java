package com.hihonor.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import client.android.yixiaotong.util.retrofit.ExceptionCatchingTypedInput;
import com.hihonor.secure.android.common.encrypt.utils.HexUtil;
import com.hihonor.secure.android.common.encrypt.utils.a;
import com.hihonor.secure.android.common.encrypt.utils.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class FileSHA256 {
    private static final String TAG = "FileSHA256";
    private static final String i = "";
    private static final int p = 8192;
    private static final String q = "SHA-256";
    private static final String[] r = {"SHA-256", MessageDigestAlgorithms.SHA_384, MessageDigestAlgorithms.SHA_512};

    public static String fileSHA256Encrypt(File file) {
        return fileSHAEncrypt(file, "SHA-256");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String fileSHAEncrypt(File file, String str) throws Throwable {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str) || !d(str)) {
            b.f(TAG, "algorithm is empty or not safe");
            return "";
        }
        if (!a(file)) {
            b.f(TAG, "file is not valid");
            return "";
        }
        ExceptionCatchingTypedInput.ExceptionCatchingInputStream exceptionCatchingInputStream = 0;
        strByteArray2HexStr = null;
        strByteArray2HexStr = null;
        String strByteArray2HexStr = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    boolean z = false;
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i2);
                        z = true;
                    }
                    if (z) {
                        strByteArray2HexStr = HexUtil.byteArray2HexStr(messageDigest.digest());
                    }
                } catch (IOException e) {
                    e = e;
                    b.f(TAG, "IOException" + e.getMessage());
                } catch (NoSuchAlgorithmException e2) {
                    e = e2;
                    b.f(TAG, "NoSuchAlgorithmException" + e.getMessage());
                }
            } catch (Throwable th) {
                th = th;
                exceptionCatchingInputStream = "";
                a.a((InputStream) exceptionCatchingInputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileInputStream = null;
        } catch (NoSuchAlgorithmException e4) {
            e = e4;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            a.a((InputStream) exceptionCatchingInputStream);
            throw th;
        }
        a.a((InputStream) fileInputStream);
        return strByteArray2HexStr;
    }

    public static String inputStreamSHA256Encrypt(InputStream inputStream) {
        return inputStream == null ? "" : inputStreamSHAEncrypt(inputStream, "SHA-256");
    }

    public static String inputStreamSHAEncrypt(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        byte[] bArr = new byte[8192];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 < 0) {
                    return HexUtil.byteArray2HexStr(messageDigest.digest());
                }
                if (i2 > 0) {
                    messageDigest.update(bArr, 0, i2);
                }
                a.a(inputStream);
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
            b.f(TAG, "inputstraem exception");
            return "";
        } finally {
            a.a(inputStream);
        }
    }

    public static boolean validateFileSHA256(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(fileSHA256Encrypt(file));
    }

    public static boolean validateFileSHA(File file, String str, String str2) {
        if (TextUtils.isEmpty(str) || !d(str2)) {
            b.f(TAG, "hash value is null || algorithm is illegal");
            return false;
        }
        return str.equals(fileSHAEncrypt(file, str2));
    }

    public static boolean validateInputStreamSHA256(InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(inputStreamSHA256Encrypt(inputStream));
    }

    public static boolean validateInputStreamSHA(InputStream inputStream, String str, String str2) {
        if (TextUtils.isEmpty(str) || !d(str2)) {
            b.f(TAG, "hash value is null || algorithm is illegal");
            return false;
        }
        return str.equals(inputStreamSHAEncrypt(inputStream, str2));
    }

    private static boolean a(File file) {
        return file != null && file.exists() && file.length() > 0;
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
