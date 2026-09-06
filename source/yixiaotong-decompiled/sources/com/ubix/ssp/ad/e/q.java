package com.ubix.ssp.ad.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.ubix.ssp.open.UBiXAdSetting;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static LruCache<String, Bitmap> f8845a;

    public static Bitmap a(Context context, String str) {
        return a(context, str, 0, false);
    }

    public static Bitmap a(Context context, String str, int i, boolean z) {
        Bitmap bitmapDecodeByteArray;
        a();
        Bitmap bitmap = f8845a.get(str);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        byte[] bArrB = b(context, str);
        if (bArrB == null || bArrB.length <= 0) {
            bitmapDecodeByteArray = null;
        } else {
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrB, 0, bArrB.length);
            if (i != 0) {
                try {
                    Matrix matrix = new Matrix();
                    matrix.setRotate(i);
                    bitmapDecodeByteArray = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        if (bitmapDecodeByteArray != null && !z) {
            f8845a.put(str, bitmapDecodeByteArray);
        }
        return bitmapDecodeByteArray;
    }

    public static Drawable a(String str) {
        return a(str, false);
    }

    public static Drawable a(String str, boolean z) {
        UBiXAdSetting uBiXAdSetting;
        if ((str.equals("ubix/ic_logo.png") || str.equals("ubix/ic_logo_dark.webp") || str.equals("ubix/ic_logo_dark_bg.webp")) && (uBiXAdSetting = com.ubix.ssp.ad.d.b.f8605a) != null && uBiXAdSetting.getCustomLogo() != null) {
            return com.ubix.ssp.ad.d.b.f8605a.getCustomLogo();
        }
        if (z) {
            if (str.equals("ubix/ic_logo.png")) {
                str = "ubix/ic_logo_un.webp";
            } else if (str.equals("ubix/ic_logo_dark.webp")) {
                str = "ubix/ic_logo_dark_un.webp";
            } else if (str.equals("ubix/ic_logo_dark_bg.webp")) {
                str = "ubix/ic_logo_dark_bg_un.webp";
            }
        }
        return new BitmapDrawable(a(com.ubix.ssp.ad.e.a0.c.e(), str));
    }

    private static void a() {
        if (f8845a == null) {
            f8845a = com.ubix.ssp.ad.e.v.e.b().a();
        }
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    try {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    } catch (Throwable th) {
                        try {
                            byteArrayOutputStream.close();
                            inputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                byteArrayOutputStream.close();
                inputStream.close();
            }
        }
        byteArrayOutputStream.close();
        inputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] b(Context context, String str) {
        try {
            return a(context.getAssets().open(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
