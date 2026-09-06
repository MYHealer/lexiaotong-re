package com.yfanads.android.libs.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaDrm;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import com.huawei.openalliance.ad.constant.x;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DeviceUtils {
    private static final String NEW_OAID_KEY = "oaid2";
    private static final String OAID_KEY = "oaid";
    public static final String SP_NAME = "cache_ad";
    private static final String UUID_KEY = "uuid";
    private static String clientId;
    private static String oaID;
    private static String uuId;
    private static volatile String wUA;
    private static final String DEFAULT_UUID = UUID.randomUUID().toString().replace(x.A, "");
    private static final Object lock = new Object();
    private static final AtomicBoolean isUAReq = new AtomicBoolean(false);
    private static volatile String widevineId = null;
    private static volatile String pseudoId = null;
    private static volatile String androidId = null;
    private static final List<String> pCacheInfo = new CopyOnWriteArrayList();
    private static final List<OnUAResult> onUAResultList = new CopyOnWriteArrayList();

    public interface OnUAResult {
        void hasUAResult();
    }

    private static String getAndroidID(Context context) {
        if (androidId == null) {
            androidId = getSharedPreferences(context, "KEY_ANDROID_ID");
            if (TextUtils.isEmpty(androidId)) {
                androidId = getAndroidIDFromSettings(context);
                saveToSharedPreferences(context, "KEY_ANDROID_ID", androidId);
            }
        }
        if (androidId == null) {
            androidId = "";
        }
        return androidId;
    }

    private static String getAndroidIDFromSettings(Context context) {
        String string;
        return (context == null || (string = Settings.Secure.getString(context.getContentResolver(), "android_id")) == null || "9774d56d682e549c".equals(string)) ? "" : string;
    }

    public static String getCacheOAID() {
        return oaID;
    }

    public static String getClientId() {
        return clientId;
    }

    private static void getClientId(Context context) {
        StringBuilder sb;
        String widevineID = getWidevineID(context);
        if (TextUtils.isEmpty(widevineID)) {
            String androidID = getAndroidID(context);
            if (TextUtils.isEmpty(androidID)) {
                clientId = getGUID(context);
                sb = new StringBuilder("getClientId uid");
            } else {
                clientId = androidID;
                sb = new StringBuilder("getClientId in adid ");
            }
        } else {
            clientId = widevineID;
            sb = new StringBuilder("getClientId in wvid ");
        }
        Log.i(Util.TAG, sb.append(clientId).toString());
    }

    public static String getDeviceId(Context context) {
        if (TextUtils.isEmpty(oaID)) {
            oaID = getOaidFromSharedPreferences(context);
        }
        if (!TextUtils.isEmpty(oaID)) {
            return oaID;
        }
        if (!TextUtils.isEmpty(clientId)) {
            return clientId;
        }
        synchronized (lock) {
            getClientId(context);
        }
        return clientId;
    }

    private static String getGUID(Context context) {
        if (uuId == null) {
            uuId = getSharedPreferences(context, "uuid");
            if (TextUtils.isEmpty(widevineId)) {
                String str = DEFAULT_UUID;
                uuId = str;
                saveToSharedPreferences(context, "uuid", str);
            }
        }
        if (uuId == null) {
            uuId = "";
        }
        return uuId;
    }

    private static String getOaidFromSharedPreferences(Context context) {
        if (context == null) {
            return "";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME, 0);
        String string = sharedPreferences.getString(NEW_OAID_KEY, "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String string2 = sharedPreferences.getString("oaid", "");
        return (string2 == null || !string2.startsWith("000000")) ? string2 : "";
    }

    public static List<String> getPInfoList() {
        return pCacheInfo;
    }

    private static String getPseudoID() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.BOARD.length() % 10);
        sb.append(Arrays.deepToString(Build.SUPPORTED_ABIS).length() % 10);
        sb.append(Build.DEVICE.length() % 10);
        sb.append(Build.DISPLAY.length() % 10);
        sb.append(Build.HOST.length() % 10);
        sb.append(Build.ID.length() % 10);
        sb.append(Build.MANUFACTURER.length() % 10);
        sb.append(Build.BRAND.length() % 10);
        sb.append(Build.MODEL.length() % 10);
        sb.append(Build.PRODUCT.length() % 10);
        sb.append(Build.BOOTLOADER.length() % 10);
        sb.append(Build.HARDWARE.length() % 10);
        sb.append(Build.TAGS.length() % 10);
        sb.append(Build.TYPE.length() % 10);
        sb.append(Build.USER.length() % 10);
        return sb.toString();
    }

    private static String getPseudoID(Context context) {
        if (pseudoId == null) {
            pseudoId = getSharedPreferences(context, "KEY_PSEUDO_ID");
            if (TextUtils.isEmpty(pseudoId)) {
                pseudoId = getPseudoID();
                saveToSharedPreferences(context, "KEY_PSEUDO_ID", pseudoId);
            }
        }
        if (pseudoId == null) {
            pseudoId = "";
        }
        return pseudoId;
    }

    public static String getRandomUuid() {
        return UUID.randomUUID().toString().replace(x.A, "");
    }

    private static String getSharedPreferences(Context context, String str) {
        return context == null ? "" : context.getSharedPreferences(SP_NAME, 0).getString(str, "");
    }

    public static String getUA() {
        return wUA;
    }

    private static String getWidevineID() {
        try {
            byte[] propertyByteArray = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
            if (propertyByteArray == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : propertyByteArray) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception e) {
            Log.e(Util.TAG, "getWidevineID: " + e.getMessage());
            return "";
        }
    }

    private static String getWidevineID(Context context) {
        if (widevineId == null) {
            widevineId = getSharedPreferences(context, "KEY_WIDEVINE_ID");
            if (TextUtils.isEmpty(widevineId)) {
                widevineId = getWidevineID();
                saveToSharedPreferences(context, "KEY_WIDEVINE_ID", widevineId);
            }
        }
        if (widevineId == null) {
            widevineId = "";
        }
        return widevineId;
    }

    public static boolean hasOaID() {
        return !TextUtils.isEmpty(oaID);
    }

    public static void initWua(Context context, OnUAResult onUAResult) {
        StringBuilder sbAppend;
        if (!TextUtils.isEmpty(wUA)) {
            onUAResult.hasUAResult();
            return;
        }
        AtomicBoolean atomicBoolean = isUAReq;
        if (atomicBoolean.get()) {
            Log.d(Util.TAG, "initWua is request, return.");
            if (onUAResult != null) {
                onUAResultList.add(onUAResult);
            }
            sbAppend = new StringBuilder("initWua size ").append(onUAResultList.size());
        } else {
            atomicBoolean.set(true);
            Log.d(Util.TAG, "initWua start.");
            wUA = WebSettings.getDefaultUserAgent(context);
            Iterator<OnUAResult> it = onUAResultList.iterator();
            while (it.hasNext()) {
                it.next().hasUAResult();
            }
            onUAResultList.clear();
            isUAReq.set(false);
            sbAppend = new StringBuilder("initWua end.").append(wUA);
        }
        Log.d(Util.TAG, sbAppend.toString());
    }

    public static boolean isRealOAID(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("000000")) ? false : true;
    }

    private static void saveOaidToSharedPreferences(Context context, String str) {
        context.getSharedPreferences(SP_NAME, 0).edit().putString(NEW_OAID_KEY, str).apply();
    }

    private static void saveToSharedPreferences(Context context, String str, String str2) {
        context.getSharedPreferences(SP_NAME, 0).edit().putString(str, str2).apply();
    }

    public static void setOaID(Context context, String str) {
        oaID = str;
        saveOaidToSharedPreferences(context, str);
    }

    public static void setPInoList(List<String> list) {
        List<String> list2 = pCacheInfo;
        list2.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        list2.addAll(list);
    }
}
