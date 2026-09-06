package com.hihonor.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import client.android.yixiaotong.util.TimeUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BksUtil {
    private static final String AUTHORITY = "com.hihonor.id";
    private static final Uri AUTHORITY_URI = Uri.parse("content://com.hihonor.id");
    private static final String TAG = "BksUtil";
    private static final String Z = "com.hihonor.id";
    private static final String aa = "com.hihonor.push";
    private static final String ab = "com.hihonor.id.tv";
    private static final String ac = "files/rootcas.bks";
    private static final String ad = "4.0.2.300";
    private static final String ae = "aegis";
    private static final String af = "rootcas.bks";
    private static final long ag = 604800000;
    private static final String ah = "last_update_time";

    public static synchronized InputStream getBksFromTss(Context context) {
        String str = TAG;
        g.c(str, "get bks from tss begin");
        if (context != null) {
            c.setContext(context);
        }
        Context contextK = c.k();
        if (contextK == null) {
            g.e(str, "context is null");
            return null;
        }
        if (!h.g("com.hihonor.id") && !h.g(aa)) {
            g.e(str, "id and push not exist");
            return null;
        }
        if (!c(h.h("com.hihonor.id")) && !c(h.h(aa))) {
            g.e(str, "hihonor id version code is too low : " + h.h("com.hihonor.id"));
            return null;
        }
        if (!a(contextK, "com.hihonor.id") && !b(contextK, aa)) {
            g.e(str, "id and push sign error");
            return null;
        }
        try {
            InputStream inputStreamOpenInputStream = contextK.getContentResolver().openInputStream(Uri.withAppendedPath(AUTHORITY_URI, ac));
            long jB = i.b(ah, 0L, contextK);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (c(contextK) && jCurrentTimeMillis - jB <= 604800000 && jB != 0) {
                g.c(str, "load bks from core");
                return inputStreamOpenInputStream;
            }
            i.a(ah, jCurrentTimeMillis, contextK);
            a(inputStreamOpenInputStream, contextK);
            g.c(str, "save last bks and update bks timestamp");
            if (inputStreamOpenInputStream != null) {
                f.c(inputStreamOpenInputStream);
            }
            return getFilesBksIS(contextK);
        } catch (Exception unused) {
            g.e(TAG, "Get bks from CORE_VERSION_CODE exception : No content provider");
            return null;
        }
    }

    private static void a(InputStream inputStream, Context context) throws Throwable {
        if (inputStream == null || context == null) {
            return;
        }
        String strB = b(context);
        if (!new File(strB).exists()) {
            b(strB);
        }
        File file = new File(strB, "rootcas.bks");
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                g.c(TAG, "write output stream ");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int i = inputStream.read(bArr, 0, 2048);
                        if (i != -1) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            f.a((OutputStream) fileOutputStream2);
                            return;
                        }
                    }
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    g.e(TAG, " IOException");
                    f.a((OutputStream) fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    f.a((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            g.d(TAG, "The directory  has already exists");
            return 1;
        }
        if (file.mkdirs()) {
            g.b(TAG, "create directory  success");
            return 0;
        }
        g.e(TAG, "create directory  failed");
        return -1;
    }

    public static InputStream getFilesBksIS(Context context) {
        if (!c(context)) {
            return null;
        }
        e(context);
        try {
            return new FileInputStream(d(context));
        } catch (FileNotFoundException unused) {
            g.e(TAG, "FileNotFoundExceptio: ");
            return null;
        }
    }

    private static String b(Context context) {
        return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + ae;
    }

    private static boolean c(Context context) {
        return new File(b(context) + File.separator + "rootcas.bks").exists();
    }

    private static String d(Context context) {
        return b(context) + File.separator + "rootcas.bks";
    }

    private static void e(Context context) {
        g.c(TAG, "load bks from aegis folder , time is : " + new SimpleDateFormat(TimeUtils.FORMATDATETIME).format(Long.valueOf(i.b(ah, 0L, context))));
    }

    private static boolean c(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        g.c(TAG, "core version code is : " + str);
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = ad.split("\\.");
        int length = strArrSplit.length;
        int length2 = strArrSplit2.length;
        int iMax = Math.max(length, length2);
        int i2 = 0;
        while (i2 < iMax) {
            if (i2 < length) {
                try {
                    i = Integer.parseInt(strArrSplit[i2]);
                } catch (Exception e) {
                    g.e(TAG, " exception : " + e.getMessage());
                    return i2 >= length2;
                }
            } else {
                i = 0;
            }
            int i3 = i2 < length2 ? Integer.parseInt(strArrSplit2[i2]) : 0;
            if (i < i3) {
                return false;
            }
            if (i > i3) {
                return true;
            }
            i2++;
        }
        return true;
    }

    private static boolean a(Context context, String str) {
        byte[] bArrC = c(context, str);
        String[] strArr = {getFromAssets(context, "ssl_red_ai.properties"), getFromAssets(context, "ssl_red_ak.properties")};
        for (int i = 0; i < 2; i++) {
            if (strArr[i].equalsIgnoreCase(a(bArrC))) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(Context context, String str) {
        return getFromAssets(context, "ssl_red_ak.properties").equalsIgnoreCase(a(c(context, str)));
    }

    public static String getFromAssets(Context context, String str) {
        String str2 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                str2 = str2 + line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2.split("=")[1];
    }

    private static byte[] c(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "packageName is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "PackageManager.NameNotFoundException : " + e.getMessage());
        } catch (Exception e2) {
            Log.e(TAG, "get pm exception : " + e2.getMessage());
        }
        return new byte[0];
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return b(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "NoSuchAlgorithmException" + e.getMessage());
            return "";
        }
    }

    private static String b(byte[] bArr) {
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
}
