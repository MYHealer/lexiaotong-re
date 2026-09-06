package com.byazt.or;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.byazt.nr.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 579, 13})
public class tt {
    /* JADX WARN: Code duplicated, block: B:41:0x0083 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:43:0x0088 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:45:0x008d A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:47:0x0092 A[DONT_GENERATE] */
    /* JADX WARN: Multi-variable type inference failed */
    public static Bitmap c(Context context, Bitmap bitmap, int i) {
        RenderScript renderScriptCreate;
        Allocation allocationCreateFromBitmap;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate;
        Allocation allocationCreateFromBitmap2;
        try {
            com.byazt.sr.uj.c();
            if (bitmap != null && !bitmap.isRecycled()) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
                renderScriptCreate = RenderScript.create(context);
                if (renderScriptCreate == null) {
                    if (renderScriptCreate != null) {
                        renderScriptCreate.destroy();
                    }
                    return null;
                }
                try {
                    scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                    try {
                        allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
                        try {
                            allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                            try {
                                scriptIntrinsicBlurCreate.setRadius(i);
                                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                                scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                                allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
                                if (allocationCreateFromBitmap != null) {
                                    allocationCreateFromBitmap.destroy();
                                }
                                if (allocationCreateFromBitmap2 != 0) {
                                    allocationCreateFromBitmap2.destroy();
                                }
                                if (scriptIntrinsicBlurCreate != 0) {
                                    scriptIntrinsicBlurCreate.destroy();
                                }
                                if (renderScriptCreate != null) {
                                    renderScriptCreate.destroy();
                                }
                                return bitmapCreateBitmap;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    m.c(th);
                                    return null;
                                } finally {
                                    if (allocationCreateFromBitmap != null) {
                                        allocationCreateFromBitmap.destroy();
                                    }
                                    if (allocationCreateFromBitmap2 != 0) {
                                        allocationCreateFromBitmap2.destroy();
                                    }
                                    if (scriptIntrinsicBlurCreate != 0) {
                                        scriptIntrinsicBlurCreate.destroy();
                                    }
                                    if (renderScriptCreate != null) {
                                        renderScriptCreate.destroy();
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            allocationCreateFromBitmap2 = 0;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        allocationCreateFromBitmap = null;
                        allocationCreateFromBitmap2 = 0;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    allocationCreateFromBitmap = null;
                    scriptIntrinsicBlurCreate = allocationCreateFromBitmap;
                    allocationCreateFromBitmap2 = scriptIntrinsicBlurCreate;
                    m.c(th);
                    return null;
                }
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            renderScriptCreate = null;
            allocationCreateFromBitmap = null;
        }
    }
}
