package com.oplus.log.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.view.View;
import java.io.File;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    public static long a(File file) {
        if (file == null) {
            return -1L;
        }
        return file.getUsableSpace();
    }

    public static Bitmap a(Activity activity) {
        Bitmap bitmapCreateBitmap;
        View rootView = activity.getWindow().getDecorView().getRootView();
        try {
            Method declaredMethod = View.class.getDeclaredMethod("createSnapshot", Bitmap.Config.class, Integer.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            bitmapCreateBitmap = (Bitmap) declaredMethod.invoke(rootView, Bitmap.Config.RGB_565, -1, Boolean.FALSE);
        } catch (Throwable th) {
            if (com.oplus.log.b.c()) {
                th.printStackTrace();
            }
            bitmapCreateBitmap = null;
        }
        if (bitmapCreateBitmap != null) {
            return bitmapCreateBitmap;
        }
        try {
            rootView.setDrawingCacheEnabled(true);
            rootView.buildDrawingCache(true);
            bitmapCreateBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
            rootView.setDrawingCacheEnabled(false);
            return bitmapCreateBitmap;
        } catch (Throwable th2) {
            if (!com.oplus.log.b.c()) {
                return bitmapCreateBitmap;
            }
            th2.printStackTrace();
            return bitmapCreateBitmap;
        }
    }

    public static String a() {
        return a(b.a());
    }

    private static String a(Context context) {
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return sb.append("wifi").toString();
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                sb.append(telephonyManager.getNetworkOperatorName());
                sb.append("_");
                int networkType = telephonyManager.getNetworkType();
                switch (networkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        str = "2G";
                        sb.append(str);
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        str = "3G";
                        sb.append(str);
                        break;
                    case 13:
                        str = "4G";
                        sb.append(str);
                        break;
                    default:
                        sb.append("unknown:");
                        sb.append(networkType);
                        break;
                }
                return sb.toString();
            }
            return sb.append("disconnected").toString();
        } catch (Throwable th) {
            if (com.oplus.log.b.c()) {
                th.printStackTrace();
            }
        }
    }

    public static boolean b() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) b.a().getSystemService("connectivity");
            if (connectivityManager != null) {
                return NetworkInfo.State.CONNECTED == connectivityManager.getNetworkInfo(1).getState();
            }
            return false;
        } catch (Throwable th) {
            if (!com.oplus.log.b.c()) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }
}
