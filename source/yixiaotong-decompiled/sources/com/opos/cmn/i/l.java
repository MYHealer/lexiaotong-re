package com.opos.cmn.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f6174a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PackageInfo f6175a;
        public final Signature[] b;

        public a(PackageInfo packageInfo, Signature[] signatureArr) {
            this.f6175a = packageInfo;
            this.b = signatureArr;
        }
    }

    public static final a a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217856);
                if (packageInfo == null) {
                    return null;
                }
                return new a(packageInfo, packageInfo.signingInfo.getApkContentsSigners());
            }
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 192);
            if (packageInfo2 == null) {
                return null;
            }
            return new a(packageInfo2, packageInfo2.signatures);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return null;
        }
    }

    public static final String a(String str) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("sha256");
        messageDigest.update(str.getBytes());
        return a(messageDigest.digest());
    }

    public static final String a(String str, Signature signature) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(signature.toByteArray());
        return a(messageDigest.digest());
    }

    public static final String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = f6174a;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static final Signature[] a(Context context) {
        a aVarA = a(context, context.getPackageName());
        if (aVarA != null) {
            return aVarA.b;
        }
        return null;
    }
}
