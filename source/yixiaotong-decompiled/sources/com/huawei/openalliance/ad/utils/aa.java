package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.BaseObj;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.huawei.hms.ads.fh;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class aa {
    private static final String Code = "BlurUtil";

    /* JADX WARN: Code duplicated, block: B:33:0x009c A[DONT_GENERATE] */
    private static Bitmap Code(Context context, Bitmap bitmap, float f, float f2) {
        Allocation allocation;
        Bitmap bitmapCreateScaledBitmap;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate;
        Allocation allocationCreateFromBitmap;
        if (f <= 0.0f || f > 25.0f || f2 < 1.0f) {
            throw new IllegalArgumentException("ensure blurRadius in (0, 25] and scaleRatio >= 1");
        }
        RenderScript renderScript = null;
        Allocation allocationCreateTyped = null;
        try {
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() / f2), Math.round(bitmap.getHeight() / f2), false);
            try {
                RenderScript renderScriptCreate = RenderScript.create(context);
                try {
                    scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                    try {
                        allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
                        try {
                            allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
                            scriptIntrinsicBlurCreate.setRadius(f);
                            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                            scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
                            allocationCreateTyped.copyTo(bitmapCreateScaledBitmap);
                            Code(allocationCreateFromBitmap);
                            Code(allocationCreateTyped);
                            Code(scriptIntrinsicBlurCreate);
                            if (renderScriptCreate != null) {
                                renderScriptCreate.destroy();
                            }
                            return bitmapCreateScaledBitmap;
                        } catch (Throwable th) {
                            th = th;
                            Allocation allocation2 = allocationCreateTyped;
                            renderScript = renderScriptCreate;
                            allocation = allocation2;
                            try {
                                fh.I(Code, "blur drawable exception" + th.getClass().getSimpleName());
                                return bitmapCreateScaledBitmap;
                            } finally {
                                Code(allocationCreateFromBitmap);
                                Code(allocation);
                                Code(scriptIntrinsicBlurCreate);
                                if (renderScript != null) {
                                    renderScript.destroy();
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        allocationCreateFromBitmap = null;
                        renderScript = renderScriptCreate;
                        allocation = allocationCreateFromBitmap;
                        fh.I(Code, "blur drawable exception" + th.getClass().getSimpleName());
                        return bitmapCreateScaledBitmap;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    scriptIntrinsicBlurCreate = null;
                    allocationCreateFromBitmap = null;
                }
            } catch (Throwable th4) {
                th = th4;
                allocation = null;
                scriptIntrinsicBlurCreate = null;
                allocationCreateFromBitmap = scriptIntrinsicBlurCreate;
                fh.I(Code, "blur drawable exception" + th.getClass().getSimpleName());
                return bitmapCreateScaledBitmap;
            }
        } catch (Throwable th5) {
            th = th5;
            allocation = null;
            bitmapCreateScaledBitmap = null;
            scriptIntrinsicBlurCreate = null;
        }
    }

    private static Drawable Code(Context context, Bitmap bitmap) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static Drawable Code(Context context, Drawable drawable, float f, float f2) {
        String str;
        Drawable drawableCode = null;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            drawableCode = Code(context, Code(context, ac.Code(drawable), f, f2));
            fh.Code(Code, "blurDrawable: duration %s", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            return drawableCode;
        } catch (OutOfMemoryError unused) {
            str = "OOM blur image";
            fh.I(Code, str);
            return drawableCode;
        } catch (Throwable th) {
            str = "blur drawable exception " + th.getClass().getSimpleName();
            fh.I(Code, str);
            return drawableCode;
        }
    }

    private static void Code(BaseObj baseObj) {
        if (baseObj != null) {
            baseObj.destroy();
        }
    }
}
