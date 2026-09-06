package com.opos.mobad.cmn.func.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import org.videolan.libvlc.MediaDiscoverer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h {

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.b.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6842a;

        static {
            int[] iArr = new int[a.values().length];
            f6842a = iArr;
            try {
                iArr[a.NON_CLICK_BT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6842a[a.OUT_COUPONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6842a[a.FLOAT_LAYER_INTERSTITIAL_RETAIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6842a[a.SHAKE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6842a[a.FORWARD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6842a[a.TILT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6842a[a.LIGHT_INTERACTIVE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6842a[a.CLICK_BT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6842a[a.VIDEO.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6842a[a.FLOAT_LAYER_CLICK_BT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6842a[a.FLOAT_LAYER_SHAKE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6842a[a.FLOAT_LAYER_NON_CLICK_BT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static int a() {
        return View.generateViewId();
    }

    public static Bitmap a(int i, Bitmap bitmap) {
        if (bitmap == null || i <= 0) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth() * i, bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        for (int i2 = 0; i2 < i; i2++) {
            canvas.drawBitmap(bitmap, bitmap.getWidth() * i2, 0.0f, (Paint) null);
        }
        return bitmapCreateBitmap;
    }

    public static BitmapDrawable a(Context context, Bitmap bitmap) {
        if (bitmap != null) {
            return context == null ? new BitmapDrawable(bitmap) : new BitmapDrawable(context.getResources(), bitmap);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0067  */
    public static String a(Context context, AdItemData adItemData, boolean z) {
        String strV;
        MaterialData materialData;
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            strV = "";
        } else {
            strV = "立刻打开";
            if (!z) {
                if (TextUtils.isEmpty(materialData.V())) {
                    switch (materialData.d()) {
                        case 1:
                            strV = "点击查看";
                            break;
                        case 2:
                            if (com.opos.cmn.an.d.a.a(materialData.i()) || !com.opos.cmn.an.h.d.a.d(context, materialData.i())) {
                                strV = "点击安装";
                            }
                            break;
                        case 3:
                            if (com.opos.cmn.an.d.a.a(materialData.i()) || !com.opos.cmn.an.h.d.a.d(context, materialData.i())) {
                                strV = "立即下载";
                            }
                            break;
                        case 4:
                            break;
                        case 5:
                            strV = "查看详情";
                            break;
                        case 6:
                            strV = "秒开";
                            break;
                        case 7:
                            strV = "打开";
                            break;
                        default:
                            strV = "";
                            break;
                    }
                } else {
                    strV = materialData.V();
                }
            }
        }
        com.opos.cmn.an.f.a.b("ViewUtils", "getClickBnText=" + strV);
        return strV;
    }

    public static void a(Activity activity) {
        if (activity != null) {
            activity.requestWindowFeature(1);
        }
    }

    public static void a(Activity activity, String str) {
        if (activity != null) {
            try {
                Window window = activity.getWindow();
                window.getDecorView().setSystemUiVisibility(MediaDiscoverer.Event.Started);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(Color.parseColor(str));
                a(activity, true);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("ViewUtils", "setWhiteStatusBar", (Throwable) e);
            }
        }
    }

    private static void a(Activity activity, boolean z) {
        if (activity != null) {
            try {
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                window.getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("ViewUtils", "", (Throwable) e);
            }
        }
    }

    public static void a(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        view.setBackground(drawable);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003e  */
    public static boolean a(AdItemData adItemData, a aVar) {
        MaterialData materialData;
        boolean z = false;
        if (adItemData != null && (materialData = adItemData.i().get(0)) != null) {
            switch (AnonymousClass1.f6842a[aVar.ordinal()]) {
                case 1:
                    if (materialData.G() != 0) {
                        z = true;
                    }
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    if (materialData.d() != 0) {
                        z = true;
                    }
                    break;
                case 9:
                    if (materialData.H() != 0) {
                        z = true;
                    }
                    break;
                case 10:
                case 11:
                    if (materialData.S() != 0) {
                        z = true;
                    }
                    break;
                case 12:
                    if (materialData.T() != 0) {
                        z = true;
                    }
                    break;
            }
        }
        com.opos.cmn.an.f.a.b("ViewUtils", "isValidClickWithInteraction result =" + z);
        return z;
    }
}
