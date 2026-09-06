package com.ubixnow.ooooo;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOO00000 {
    private static volatile oOO00000 OooO00o;
    private static final Object OooO0O0 = new Object();

    private oOO00000() {
    }

    public static int OooO00o(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static oOO00000 OooO00o() {
        if (OooO00o == null) {
            synchronized (OooO0O0) {
                if (OooO00o == null) {
                    OooO00o = new oOO00000();
                }
            }
        }
        return OooO00o;
    }

    public static boolean OooO00o(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics.heightPixels + OooO0O0(context) <= point.y;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int OooO0O0(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int OooO0O0(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(identifier);
        ooooO000.OooO0O0("----show: ", "bar: " + dimensionPixelSize);
        return dimensionPixelSize;
    }

    public static int OooO0OO(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int OooO0OO(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 1920;
        }
    }

    public static int OooO0Oo(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int OooO0Oo(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 1080;
        }
    }

    public static int OooO0o(Context context) {
        if (context == null) {
            return 1080;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 1080;
        }
    }

    public static int OooO0o0(Context context) {
        if (context == null) {
            return 1920;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 1920;
        }
    }

    public static int OooO0oO(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public float OooO00o(Activity activity) {
        int i;
        try {
            i = Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        return i;
    }

    public void OooO00o(Activity activity, float f) {
        OooO0o0(activity);
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = f * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    public void OooO00o(ContentResolver contentResolver, int i) {
        Uri uriFor = Settings.System.getUriFor("screen_brightness");
        Settings.System.putInt(contentResolver, "screen_brightness", i);
        contentResolver.notifyChange(uriFor, null);
    }

    public void OooO00o(View view, boolean z) {
        int i;
        Paint paint;
        if (z) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint = new Paint();
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            i = 2;
        } else {
            i = 0;
            paint = null;
        }
        view.setLayerType(i, paint);
    }

    public boolean OooO00o(ContentResolver contentResolver) {
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Bitmap OooO0O0(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        int iOooO0o = OooO0o(activity);
        int iOooO0o0 = OooO0o0((Context) activity);
        Bitmap drawingCache = decorView.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawingCache, 0, 0, iOooO0o, iOooO0o0);
        decorView.destroyDrawingCache();
        return bitmapCreateBitmap;
    }

    public Bitmap OooO0OO(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawingCache, 0, i, OooO0o(activity), OooO0o0((Context) activity) - i);
        decorView.destroyDrawingCache();
        return bitmapCreateBitmap;
    }

    public void OooO0Oo(Activity activity) {
        Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 1);
    }

    public void OooO0o0(Activity activity) {
        Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 0);
    }
}
