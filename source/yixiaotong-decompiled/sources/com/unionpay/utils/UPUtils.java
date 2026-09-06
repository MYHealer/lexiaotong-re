package com.unionpay.utils;

import android.content.Context;
import android.content.SharedPreferences;
import client.android.yixiaotong.util.bluetooth.BluetoothDevice;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class UPUtils {
    public static String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        String strB = b(context.getSharedPreferences("UnionPayPluginEx.pref", 0).getString(str, ""), "0000000023456789abcdef12123456786789abcd".substring(0, 32));
        return (strB != null && strB.endsWith(BluetoothDevice.DEFAULT_DEVICEHEXNO)) ? strB.substring(0, strB.length() - 8) : "";
    }

    public static String a(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
            messageDigest.reset();
            messageDigest.update(bytes);
            return a.a(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(String str, String str2) {
        try {
            return a.a(d.a(a.a(str2), str.getBytes("utf-8")));
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context != null) {
            String strA = a(str + BluetoothDevice.DEFAULT_DEVICEHEXNO, "0000000023456789abcdef12123456786789abcd".substring(0, 32));
            if (strA == null) {
                strA = "";
            }
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
            editorEdit.putString(str2, strA);
            editorEdit.commit();
        }
    }

    private static String b(String str, String str2) {
        try {
            return new String(d.b(a.a(str2), a.a(str)), "utf-8").trim();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void b(Context context, String str) {
        if (context != null) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
            editorEdit.remove(str);
            editorEdit.commit();
        }
    }

    public static native String forConfig(int i, String str);

    public static native String forScanUrl(int i);

    public static native String forUrl(int i);

    public static native String forWap(int i, String str);

    public static native String getIssuer(int i);

    public static native String getSubject(int i);

    public static native String getTalkingDataIdForAssist(int i);
}
