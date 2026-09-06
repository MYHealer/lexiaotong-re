package com.ubix.ssp.ad.e.a0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile r f8724a;
    private static final Object b = new Object();

    private r() {
    }

    public static int a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static r a() {
        if (f8724a == null) {
            synchronized (b) {
                if (f8724a == null) {
                    f8724a = new r();
                }
            }
        }
        return f8724a;
    }

    public static float b(Context context) {
        try {
            return context.getResources().getDisplayMetrics().densityDpi;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static int b(float f) {
        return (int) (f * Resources.getSystem().getDisplayMetrics().xdpi * 0.013888889f);
    }

    public static int c(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int d(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int i(Context context) {
        float fA;
        try {
            try {
                int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
                if (identifier > 0) {
                    return context.getResources().getDimensionPixelSize(identifier);
                }
                fA = a().a(context);
                return (int) (fA * 37.0f);
            } catch (Exception unused) {
                return 0;
            }
        } catch (Exception unused2) {
            fA = a().a(context);
        }
    }

    public float a(Context context) {
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().density;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public int c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public int d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public int e(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    public int f(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public int g(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public int h(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
