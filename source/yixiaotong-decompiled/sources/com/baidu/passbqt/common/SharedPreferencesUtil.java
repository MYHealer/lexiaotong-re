package com.baidu.passbqt.common;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.passbqt.NoProguard;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class SharedPreferencesUtil implements NoProguard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SharedPreferencesUtil f1923a = null;
    private static SharedPreferences b = null;
    private static final String c = "sapi_system";
    private static String d;
    private static Context e;

    private SharedPreferencesUtil(Context context, String str) {
        b = context.getSharedPreferences(str, 0);
        e = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static synchronized void a(Context context) {
        if (f1923a == null) {
            f1923a = new SharedPreferencesUtil(context, c);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean a(String str, Object obj) {
        byte b2;
        SharedPreferences.Editor editorEdit = b.edit();
        String simpleName = obj.getClass().getSimpleName();
        boolean z = false;
        try {
            switch (simpleName.hashCode()) {
                case -672261858:
                    if (!simpleName.equals("Integer")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case 2374300:
                    if (!simpleName.equals("Long")) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case 67973692:
                    if (!simpleName.equals("Float")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 1729365000:
                    if (!simpleName.equals("Boolean")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 == 0) {
                editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (b2 == 1) {
                editorEdit.putLong(str, ((Long) obj).longValue());
            } else if (b2 == 2) {
                editorEdit.putFloat(str, ((Float) obj).floatValue());
            } else if (b2 == 3) {
                editorEdit.putInt(str, ((Integer) obj).intValue());
            } else {
                editorEdit.putString(str, (String) obj);
            }
            z = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        editorEdit.apply();
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003b  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T b(String str, T t) {
        byte b2;
        String simpleName = t.getClass().getSimpleName();
        try {
            switch (simpleName.hashCode()) {
                case -672261858:
                    if (!simpleName.equals("Integer")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case 2374300:
                    if (!simpleName.equals("Long")) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case 67973692:
                    if (!simpleName.equals("Float")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 1729365000:
                    if (!simpleName.equals("Boolean")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 == 0) {
                return (T) Boolean.valueOf(b.getBoolean(str, ((Boolean) t).booleanValue()));
            }
            if (b2 == 1) {
                return (T) Long.valueOf(b.getLong(str, ((Long) t).longValue()));
            }
            if (b2 == 2) {
                return (T) Float.valueOf(b.getFloat(str, ((Float) t).floatValue()));
            }
            if (b2 == 3) {
                return (T) Integer.valueOf(b.getInt(str, ((Integer) t).intValue()));
            }
            return (T) b.getString(str, (String) t);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
