package com.unionpay.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.openalliance.ad.constant.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap f9362a = new c();

    public static int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new DecimalFormat("0000000").format(new SecureRandom().nextInt(10000000)));
        stringBuffer.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis())));
        return stringBuffer.toString();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0092  */
    public static String a(Context context) {
        String str;
        int i;
        String strA = UPUtils.a(context, "configs");
        String strA2 = UPUtils.a(context, "mode");
        String strA3 = UPUtils.a(context, "or");
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2) || TextUtils.isEmpty(strA3)) {
            str = "";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(strA);
                String strA4 = i.a(jSONObject, "sign");
                try {
                    i = Integer.parseInt(strA2);
                } catch (Exception unused) {
                    i = 0;
                }
                str = new String(Base64.decode(jSONObject.getString("configs"), 2));
                String str2 = jSONObject.has("sePayConf") ? new String(Base64.decode(jSONObject.getString("sePayConf"), 2)) : "";
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                String strB = b(UPUtils.a(str + str2 + strA3));
                String strForConfig = UPUtils.forConfig(i, strA4);
                if (TextUtils.isEmpty(strForConfig) || !strForConfig.equals(strB)) {
                    str = "";
                }
            } catch (Exception unused2) {
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                Object objA = i.a(jSONArray, i2);
                if (objA != null) {
                    JSONObject jSONObject2 = (JSONObject) objA;
                    if ("app".equals(i.a(jSONObject2, "type"))) {
                        return new String(Base64.decode(i.a(jSONObject2, "ca"), 2));
                    }
                }
            }
        } catch (Exception unused3) {
        }
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0049  */
    /* JADX WARN: Code duplicated, block: B:35:0x0050 A[Catch: CertificateEncodingException -> 0x005e, NoSuchAlgorithmException -> 0x0063, Exception -> 0x0070, TRY_LEAVE, TryCatch #2 {NoSuchAlgorithmException -> 0x0063, blocks: (B:33:0x004a, B:35:0x0050), top: B:50:0x004a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0069 A[Catch: Exception -> 0x0070, TRY_LEAVE, TryCatch #1 {Exception -> 0x0070, blocks: (B:4:0x0005, B:9:0x000f, B:15:0x001b, B:17:0x001f, B:19:0x0022, B:21:0x0027, B:22:0x0030, B:28:0x003e, B:33:0x004a, B:35:0x0050, B:42:0x0069, B:38:0x005f, B:40:0x0064, B:31:0x0046, B:25:0x0038, B:12:0x0015), top: B:48:0x0005, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static String a(Context context, String str, String str2) {
        PackageManager packageManager;
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Signature signature;
        ByteArrayInputStream byteArrayInputStream;
        CertificateFactory certificateFactory;
        X509Certificate x509Certificate;
        MessageDigest messageDigest;
        String strA = null;
        if (context != null) {
            try {
                packageManager = context.getPackageManager();
            } catch (Exception unused) {
            }
        } else {
            packageManager = null;
        }
        if (packageManager != null) {
            try {
                packageInfo = packageManager.getPackageInfo(str, 64);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                packageInfo = null;
            }
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
                byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
                try {
                    certificateFactory = CertificateFactory.getInstance("X509");
                } catch (CertificateException e2) {
                    e2.printStackTrace();
                    certificateFactory = null;
                }
                if (certificateFactory != null) {
                    try {
                        x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
                    } catch (CertificateException e3) {
                        e3.printStackTrace();
                        x509Certificate = null;
                    }
                    try {
                        try {
                            messageDigest = MessageDigest.getInstance(str2);
                            if (x509Certificate != null) {
                                strA = a(messageDigest.digest(x509Certificate.getEncoded()));
                            }
                        } catch (NoSuchAlgorithmException e4) {
                            e4.printStackTrace();
                        }
                    } catch (CertificateEncodingException e5) {
                        e5.printStackTrace();
                    }
                    if (strA != null) {
                        return strA.replaceAll(x.bQ, "");
                    }
                } else {
                    x509Certificate = null;
                    messageDigest = MessageDigest.getInstance(str2);
                    if (x509Certificate != null) {
                        strA = a(messageDigest.digest(x509Certificate.getEncoded()));
                    }
                    if (strA != null) {
                        return strA.replaceAll(x.bQ, "");
                    }
                }
            }
        } else {
            packageInfo = null;
            if (packageInfo != null) {
                byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
                certificateFactory = CertificateFactory.getInstance("X509");
                if (certificateFactory != null) {
                    x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
                    messageDigest = MessageDigest.getInstance(str2);
                    if (x509Certificate != null) {
                        strA = a(messageDigest.digest(x509Certificate.getEncoded()));
                    }
                    if (strA != null) {
                        return strA.replaceAll(x.bQ, "");
                    }
                } else {
                    x509Certificate = null;
                    messageDigest = MessageDigest.getInstance(str2);
                    if (x509Certificate != null) {
                        strA = a(messageDigest.digest(x509Certificate.getEncoded()));
                    }
                    if (strA != null) {
                        return strA.replaceAll(x.bQ, "");
                    }
                }
            }
        }
        return "";
    }

    public static String a(InputStream inputStream, String str) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    return byteArrayOutputStream.toString(str);
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public static boolean a(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = null;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && !TextUtils.isEmpty(str)) {
                    packageInfo = packageManager.getPackageInfo(str, 0);
                }
            } catch (Exception unused) {
            }
        }
        return packageInfo != null;
    }

    public static boolean a(Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    String strC = c(context, str);
                    if (!TextUtils.isEmpty(strC) && a(context, str) && strC.matches(str3) && str2.equalsIgnoreCase(a(context, str, "SHA1"))) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String b(Context context, String str) {
        return a(context, str, "SHA1");
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        char[] charArray = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        for (byte b : str.getBytes()) {
            sb.append(charArray[(b & 240) >> 4]);
            sb.append(charArray[b & 15]);
        }
        return sb.toString().trim();
    }

    public static boolean b() {
        try {
            return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    int iE = e(context, str);
                    int iF = f(str3);
                    if (a(context, str) && iE >= iF && str2.equalsIgnoreCase(a(context, str, "SHA256"))) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(String str) {
        return !TextUtils.isEmpty((CharSequence) f9362a.get(str)) ? (String) f9362a.get(str) : str;
    }

    public static boolean d(Context context, String str) {
        return a(context, str);
    }

    public static final boolean d(String str) {
        return !Pattern.compile("[^0-9]+").matcher(str).find();
    }

    private static int e(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String e(String str) {
        if (str == null) {
            return "";
        }
        try {
            return Pattern.compile("[\":,\\[\\]{}]").matcher(str).replaceAll("").trim();
        } catch (Exception unused) {
            return "";
        }
    }

    private static int f(String str) {
        try {
            return Integer.valueOf(str, 10).intValue();
        } catch (Exception unused) {
            return Integer.MAX_VALUE;
        }
    }
}
