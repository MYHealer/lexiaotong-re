package client.android.yixiaotong.util.drinkwater;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PreferenceUtil {
    public static void putInt(Context context, String str, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("key", 0).edit();
        editorEdit.putInt(str, i);
        editorEdit.commit();
    }

    public static int getInt(Context context, String str, int i) {
        return context.getSharedPreferences("key", 0).getInt(str, i);
    }

    public static void putFloat(Context context, String str, float f) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("config", 0).edit();
        editorEdit.putFloat(str, f);
        editorEdit.commit();
    }

    public static float getFloat(Context context, String str, float f) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("config", 0);
        if (sharedPreferences.getFloat(str, f) < 0.3d) {
            return 0.3f;
        }
        if (sharedPreferences.getFloat(str, f) > 10.0f) {
            return 10.0f;
        }
        return sharedPreferences.getFloat(str, f);
    }

    public static void putBoolean(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("config", 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return context.getSharedPreferences("config", 0).getBoolean(str, z);
    }

    public static void putString(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(TypedValues.Custom.S_STRING, 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public static String getString(Context context, String str, String str2) {
        return context.getSharedPreferences(TypedValues.Custom.S_STRING, 0).getString(str, str2);
    }

    public static void putSSString(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ssstring", 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public static String getSSString(Context context, String str, String str2) {
        return context.getSharedPreferences("ssstring", 0).getString(str, str2);
    }

    public static void putIsBlueConnect(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("isblueconnect", 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    public static boolean getIsBlueConnect(Context context, String str, boolean z) {
        return context.getSharedPreferences("isblueconnect", 0).getBoolean(str, z);
    }

    public static void putIsBlueConnectAgain(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("isblueconnectagain", 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    public static boolean getIsBlueConnectAgain(Context context, String str, boolean z) {
        return context.getSharedPreferences("isblueconnectagain", 0).getBoolean(str, z);
    }

    public static void putIsBlueConnectHairDryer(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("isblueconnecthairdryer", 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    public static boolean getIsBlueConnectHairDryer(Context context, String str, boolean z) {
        return context.getSharedPreferences("isblueconnecthairdryer", 0).getBoolean(str, z);
    }

    public static void putIntHairDryer(Context context, String str, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("hairdryerkey", 0).edit();
        editorEdit.putInt(str, i);
        editorEdit.commit();
    }

    public static int getIntHairDryer(Context context, String str, int i) {
        return context.getSharedPreferences("hairdryerkey", 0).getInt(str, i);
    }

    public static void putFloatHairDryer(Context context, String str, float f) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("hairdryerconfig", 0).edit();
        editorEdit.putFloat(str, f);
        editorEdit.commit();
    }

    public static float getFloatHairDryer(Context context, String str, float f) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hairdryerconfig", 0);
        if (sharedPreferences.getFloat(str, f) < 0.3d) {
            return 0.3f;
        }
        if (sharedPreferences.getFloat(str, f) > 5.0f) {
            return 5.0f;
        }
        return sharedPreferences.getFloat(str, f);
    }

    public static void putIsClickBoolean(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("isHint", 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    public static boolean getIsClickBoolean(Context context, String str, boolean z) {
        return context.getSharedPreferences("isHint", 0).getBoolean(str, z);
    }

    public static void putIsCompareBoolean(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("isCompare", 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    public static boolean getIsCompareBoolean(Context context, String str, boolean z) {
        return context.getSharedPreferences("isCompare", 0).getBoolean(str, z);
    }

    public static void putServerVersionString(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("serverVersion", 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public static String getServerVersionString(Context context, String str, String str2) {
        return context.getSharedPreferences("serverVersion", 0).getString(str, str2);
    }

    public static void putIsHairDryerBC(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ishdconnect", 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    public static boolean getIsHairDryerBC(Context context, String str, boolean z) {
        return context.getSharedPreferences("ishdconnect", 0).getBoolean(str, z);
    }

    public static void putIsHairDryerBCAgain(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ishdconnectagain", 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    public static boolean getIsHairDryerBCAgain(Context context, String str, boolean z) {
        return context.getSharedPreferences("ishdconnectagain", 0).getBoolean(str, z);
    }

    public static void putBingdRoom(Context context, String str, long j) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("bindroomdetail", 0).edit();
        editorEdit.putLong(str, j);
        editorEdit.commit();
    }

    public static long getBindRoom(Context context, String str, long j) {
        return context.getSharedPreferences("bindroomdetail", 0).getLong(str, j);
    }

    public static void putBingdRoom(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("bindroomdetail", 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public static String getBindRoom(Context context, String str, String str2) {
        return context.getSharedPreferences("bindroomdetail", 0).getString(str, str2);
    }

    public static void putBingdRoomMac(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("bindroomdetailmac", 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public static String getBindRoomMac(Context context, String str, String str2) {
        return context.getSharedPreferences("bindroomdetailmac", 0).getString(str, str2);
    }

    public static void putDeviceMac(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("devicemac", 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public static String getDeviceMac(Context context, String str, String str2) {
        return context.getSharedPreferences("devicemac", 0).getString(str, str2);
    }
}
