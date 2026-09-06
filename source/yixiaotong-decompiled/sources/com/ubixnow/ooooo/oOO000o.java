package com.ubixnow.ooooo;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOO000o {
    private static final String OooO00o = "ubix_now_common";

    public static int OooO00o(Context context, String str, int i) {
        return context.getSharedPreferences(OooO00o, 0).getInt(str, i);
    }

    public static Boolean OooO00o(Context context, String str) {
        return Boolean.valueOf(context.getSharedPreferences(OooO00o, 0).getBoolean(str, false));
    }

    public static Boolean OooO00o(Context context, String str, float f) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(OooO00o, 0).edit();
        editorEdit.putFloat(str, f);
        return Boolean.valueOf(editorEdit.commit());
    }

    public static Boolean OooO00o(Context context, String str, long j) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(OooO00o, 0).edit();
        editorEdit.putLong(str, j);
        return Boolean.valueOf(editorEdit.commit());
    }

    public static Boolean OooO00o(Context context, String str, Boolean bool) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(OooO00o, 0).edit();
        editorEdit.putBoolean(str, bool.booleanValue());
        return Boolean.valueOf(editorEdit.commit());
    }

    public static Boolean OooO00o(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(OooO00o, 0).edit();
        editorEdit.putString(str, str2);
        return Boolean.valueOf(editorEdit.commit());
    }

    public static Boolean OooO00o(Context context, String str, boolean z) {
        return Boolean.valueOf(context.getSharedPreferences(OooO00o, 0).getBoolean(str, z));
    }

    public static String OooO00o(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static synchronized void OooO00o(Context context, String str, Object obj) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(OooO00o, 0);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            String strOooO00o = OooO00o(byteArrayOutputStream.toByteArray());
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(str, strOooO00o);
            editorEdit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] OooO00o(String str) {
        int i;
        int i2;
        String strTrim = str.toUpperCase().trim();
        if (strTrim.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[strTrim.length() / 2];
        for (int i3 = 0; i3 < strTrim.length(); i3 += 2) {
            char cCharAt = strTrim.charAt(i3);
            if (cCharAt < '0' || cCharAt > '9') {
                if (cCharAt >= 'A' && cCharAt <= 'F') {
                    i = cCharAt - '7';
                }
                return null;
            }
            i = cCharAt - '0';
            int i4 = i * 16;
            int i5 = i3 + 1;
            char cCharAt2 = strTrim.charAt(i5);
            if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                i2 = cCharAt2 - '0';
            } else {
                if (cCharAt2 < 'A' || cCharAt2 > 'F') {
                    return null;
                }
                i2 = cCharAt2 - '7';
            }
            bArr[i5 / 2] = (byte) (i4 + i2);
        }
        return bArr;
    }

    public static float OooO0O0(Context context, String str) {
        return context.getSharedPreferences(OooO00o, 0).getFloat(str, 0.0f);
    }

    public static Boolean OooO0O0(Context context, String str, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(OooO00o, 0).edit();
        editorEdit.putInt(str, i);
        return Boolean.valueOf(editorEdit.commit());
    }

    public static int OooO0OO(Context context, String str) {
        return context.getSharedPreferences(OooO00o, 0).getInt(str, -1);
    }

    public static long OooO0Oo(Context context, String str) {
        return context.getSharedPreferences(OooO00o, 0).getLong(str, 0L);
    }

    public static String OooO0o(Context context, String str) {
        return context.getSharedPreferences(OooO00o, 0).getString(str, "");
    }

    public static synchronized Object OooO0o0(Context context, String str) {
        try {
            String string = context.getSharedPreferences(OooO00o, 0).getString(str, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return new ObjectInputStream(new ByteArrayInputStream(OooO00o(string))).readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        throw th;
    }

    public static void OooO0oO(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(OooO00o, 0).edit();
        editorEdit.remove(str);
        editorEdit.commit();
    }
}
