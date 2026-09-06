package com.hihonor.adsdk.base.j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import com.hihonor.adsdk.base.bean.InstalledAppInfo;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    static final String hnadsa = "MD5";
    private static final String hnadsb = "b";
    private static volatile PackageInfo hnadsc;

    private b() {
    }

    public static List<PackageInfo> hnadsa(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getInstalledPackages(0);
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "getAllAppList, has Exception : " + e.getMessage(), new Object[0]);
            }
        }
        return new ArrayList();
    }

    public static String hnadsb(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "");
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "getAppName, Exception: " + e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static Bitmap hnadsc(Context context) {
        try {
            PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
            return ((BitmapDrawable) packageManager.getApplicationIcon(packageManager.getApplicationInfo(context.getPackageName(), 0))).getBitmap();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "getBitmap, Exception: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static String hnadsd(Context context) {
        ResolveInfo next;
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null || packageInfo.packageName == null) {
                return "";
            }
            try {
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setPackage(packageInfo.packageName);
                List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                return (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty() || !listQueryIntentActivities.iterator().hasNext() || (next = listQueryIntentActivities.iterator().next()) == null) ? "" : next.activityInfo.name;
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "parse ResolveInfo exception, Exception: " + e.getMessage(), new Object[0]);
                return "";
            }
        } catch (Exception e2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "getLauncherClassName, Exception: " + e2.getMessage(), new Object[0]);
            return "";
        }
    }

    public static String hnadse(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    public static String hnadsf(Context context) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA256").digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
                stringBuffer.append(x.bQ);
            }
            String upperCase = stringBuffer.toString().toUpperCase(Locale.ENGLISH);
            return upperCase.substring(0, upperCase.length() - 1);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "getSign, get package info fail ex: " + e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static String hnadsg(Context context) {
        PackageInfo packageInfo = hnadsc;
        try {
            if (Objects.nonNull(packageInfo)) {
                return String.valueOf(packageInfo.versionCode);
            }
            PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            hnadsc = packageInfo2;
            return Objects.isNull(packageInfo2) ? "" : String.valueOf(packageInfo2.versionCode);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "getVerCode, Exception: " + e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static String hnadsh(Context context) {
        PackageInfo packageInfo = hnadsc;
        try {
            if (Objects.nonNull(packageInfo)) {
                return packageInfo.versionName;
            }
            PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            hnadsc = packageInfo2;
            return Objects.isNull(packageInfo2) ? "" : packageInfo2.versionName;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "getVerName, Exception: " + e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static List<List<InstalledAppInfo>> hnadsa(Context context, int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<PackageInfo> listHnadsa = hnadsa(context);
        if (!listHnadsa.isEmpty()) {
            for (PackageInfo packageInfo : listHnadsa) {
                InstalledAppInfo installedAppInfo = new InstalledAppInfo();
                installedAppInfo.setApp_package(packageInfo.packageName);
                installedAppInfo.setApp_version(packageInfo.versionName);
                arrayList2.add(installedAppInfo);
                if (arrayList2.size() >= i) {
                    arrayList.add(arrayList2);
                    arrayList2 = new ArrayList();
                }
            }
        }
        if (arrayList2.size() > 0 && !arrayList.contains(arrayList2)) {
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    private static String hnadsb(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.ENGLISH);
            if (upperCase.length() == 1) {
                sb.append("0");
            }
            sb.append(upperCase).append("");
        }
        return sb.toString();
    }

    public static String hnadsc(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return hnadsb(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "to Message-Digest Algorithm, NoSuchAlgorithmException: " + e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static boolean hnadsa(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "isAppInstalled, Exception: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    public static boolean hnadsa(Context context, Intent intent) {
        try {
            return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "isAppInstalled, Exception: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    public static String hnadsa(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8));
            if (bArrDigest == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "Secure Hash Algorithm 8x32, NoSuchAlgorithmException: " + e.getMessage(), new Object[0]);
            return "";
        }
    }

    private static String hnadsa(byte[] bArr) {
        return com.hihonor.adsdk.common.f.e0.c.hnadsc(bArr);
    }

    public static String hnadsa(Context context, String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            return hnadsa(mac.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "Hash-based Message Authentication Code, generation mac algorithm failed ex: " + e.getMessage(), new Object[0]);
            return "";
        }
    }
}
