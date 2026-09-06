package com.qihoo.jiagu;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import com.qihoo.bugreport.Protocol;
import com.qihoo.bugreport.javacrash.ReportField;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.EnumMap;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public class c {
    public static JSONObject a(EnumMap<ReportField, String> enumMap, String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("mpv")) {
                try {
                    jSONObject.accumulate("mpv", 1);
                } catch (JSONException e) {
                }
            }
            for (K k : enumMap.keySet()) {
                try {
                    if (k.name().equals(ReportField.t.name()) || k.name().equals(ReportField.cpv.name()) || k.name().equals(ReportField.jc.name())) {
                        String str2 = enumMap.get(k);
                        jSONObject.accumulate(k.name(), Pattern.compile("[0-9]*").matcher(str2).matches() ? Integer.valueOf(Integer.parseInt(str2)) : "");
                    } else {
                        jSONObject.accumulate(k.name(), enumMap.get(k));
                    }
                } catch (JSONException e2) {
                }
            }
            JSONArray jSONArrayA = a();
            if (jSONArrayA != null) {
                try {
                    jSONObject.accumulate(ReportField.rt.name(), jSONArrayA);
                } catch (JSONException e3) {
                }
            }
            return jSONObject;
        } catch (JSONException e4) {
            return null;
        }
    }

    static JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        for (String str : (String[]) Class.forName("com.qihoo.jiagutracker.TrackDataManager").getDeclaredMethod("getTrackData", new Class[0]).invoke(null, new Object[0])) {
            String[] strArrSplit = str.split("->");
            if (Protocol.TrackerDataField.values().length != strArrSplit.length) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.accumulate(Protocol.TrackerDataField.cn.name(), strArrSplit[0]);
            jSONObject.accumulate(Protocol.TrackerDataField.mn.name(), strArrSplit[1]);
            jSONObject.accumulate(Protocol.TrackerDataField.vi.name(), strArrSplit[2]);
            jSONObject.accumulate(Protocol.TrackerDataField.vt.name(), strArrSplit[3]);
            jSONObject.accumulate(Protocol.TrackerDataField.st.name(), strArrSplit[4]);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                if ((b & 255) < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b & 255));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null || str.isEmpty()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return b(context, str);
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            return packageManager.checkPermission(str, context.getPackageName()) == 0;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        boolean z;
        if (context == null || str.isEmpty()) {
            return false;
        }
        try {
            int i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
            if (i >= 23) {
                z = ContextCompat.checkSelfPermission(context, str) == 0;
                new StringBuilder("targetSdkVersion01:").append(i);
            } else {
                z = PermissionChecker.checkSelfPermission(context, str) == 0;
                new StringBuilder("targetSdkVersion02:").append(i);
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean c(Context context, String str) {
        try {
            ZipFile zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
            if (zipFile.getEntry("META-INF/" + str) != null) {
                zipFile.close();
                return true;
            }
            try {
                zipFile.close();
                return false;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }
}
