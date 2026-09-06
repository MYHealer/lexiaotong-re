package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.stub.StubApp;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q6 implements Transformation<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5574a;
    public int b;
    public boolean c;
    public boolean d;

    public q6() {
        this(25, 8, true, false);
    }

    public q6(int i, int i2, boolean z, boolean z2) {
        this.f5574a = i;
        this.b = i2;
        this.c = z;
        this.d = z2;
    }

    public Bitmap a(Context context, Bitmap bitmap) {
        Bitmap bitmapA;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = this.b;
        Bitmap bitmapCopy = Bitmap.createScaledBitmap(bitmap, width / i, height / i, false).copy(Bitmap.Config.ARGB_8888, true);
        Log.d(ijiami_1011.s.s.s.d(new byte[]{103, 114, 112}, "337d8e"), ijiami_1011.s.s.s.d(new byte[]{69, 75, 82, 91, Ascii.NAK, 2, 14, Ascii.SYN, 11, 32, 93, 16, 67, 3, 19, 92, Ascii.NAK, 41, 0, 13, 8, 54, 89, Ascii.ETB, 84, 88, 87, Ascii.NAK}, "1935fd") + (Thread.currentThread() == Looper.getMainLooper().getThread()));
        try {
            bitmapA = a(context, bitmapCopy, this.f5574a);
        } catch (Throwable unused) {
            bitmapA = b.a(bitmapCopy, this.f5574a);
        }
        if (!this.d) {
            return bitmapA;
        }
        try {
            return a(bitmapA, Color.parseColor(ijiami_1011.s.s.s.d(new byte[]{65, 15, 2, 85, 7, 85, 81, 84, 86}, "b94e7e")));
        } catch (Throwable th) {
            th.printStackTrace();
            return bitmapA;
        }
    }

    public final Bitmap a(Context context, Bitmap bitmap, int i) {
        RenderScript renderScriptCreate;
        if (s6.a().f5408a.getInt(ijiami_1011.s.s.s.d(new byte[]{90, 3, 77, 104, 69, 85, 15, 0, 3, 16, 110, Ascii.SYN, 82, Ascii.DC4, 93, 71, 67, 111, 4, 10, 7, 0, 93, 0}, "1f4770"), -1) == 0) {
            return b.a(bitmap, i);
        }
        Bitmap bitmap2 = null;
        try {
            renderScriptCreate = RenderScript.create(context);
        } catch (Throwable unused) {
            renderScriptCreate = null;
        }
        if (renderScriptCreate != null) {
            try {
                renderScriptCreate.setMessageHandler(new RenderScript.RSMessageHandler());
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
                ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                scriptIntrinsicBlurCreate.setRadius(i);
                scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
                allocationCreateTyped.copyTo(bitmap);
                RenderScript.releaseAllContexts();
                allocationCreateFromBitmap.destroy();
                allocationCreateTyped.destroy();
                scriptIntrinsicBlurCreate.destroy();
                bitmap2 = bitmap;
            } catch (Throwable unused2) {
            }
        }
        if (bitmap2 != null) {
            SharedPreferences.Editor editorEdit = s6.a().f5408a.edit();
            editorEdit.putInt(ijiami_1011.s.s.s.d(new byte[]{91, 87, 74, 110, 65, 3, 15, 0, 3, 16, 110, Ascii.SYN, 83, SignedBytes.MAX_POWER_OF_TWO, 90, 65, 71, 57, 4, 10, 7, 0, 93, 0}, "02313f"), 1);
            editorEdit.apply();
            return bitmap2;
        }
        SharedPreferences.Editor editorEdit2 = s6.a().f5408a.edit();
        editorEdit2.putInt(ijiami_1011.s.s.s.d(new byte[]{90, 93, 75, 57, 65, 82, 15, 0, 3, 16, 110, Ascii.SYN, 82, 74, 91, Ascii.SYN, 71, 104, 4, 10, 7, 0, 93, 0}, "182f37"), 0);
        editorEdit2.apply();
        return b.a(bitmap, i);
    }

    public final Bitmap a(Bitmap bitmap, int i) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(i);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawRect(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight(), paint);
        return bitmapCreateBitmap;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof q6) {
            q6 q6Var = (q6) obj;
            if (q6Var.f5574a == this.f5574a && q6Var.b == this.b && q6Var.c == this.c && q6Var.d == this.d) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.f5574a * 1000) + 1066807208 + (this.b * 10) + (this.c ? 1 : 0) + (this.d ? 1 : 0);
    }

    public String toString() {
        return ijiami_1011.s.s.s.d(new byte[]{116, 13, Ascii.DC4, 70, 98, 74, 0, 10, Ascii.NAK, 4, 94, Ascii.ETB, 91, 0, Ascii.NAK, 93, 89, 86, 73, Ascii.SYN, 7, 6, 88, 16, 69, 92}, "6aa468") + this.f5574a + ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, Ascii.DC2, 67, 7, 9, 68, 13, 13, 8, 5, 12}, "520fd4") + this.b + ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN}, "13e9a0");
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<Bitmap> transform(Context context, Resource<Bitmap> resource, int i, int i2) {
        try {
            if (this.c && Util.isValidDimensions(i, i2)) {
                BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
                Bitmap bitmap = resource.get();
                Bitmap bitmapA = a(StubApp.getOrigApplicationContext(context.getApplicationContext()), bitmap);
                return bitmap.equals(bitmapA) ? resource : BitmapResource.obtain(bitmapA, bitmapPool);
            }
            return resource;
        } catch (Throwable unused) {
            return resource;
        }
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ijiami_1011.s.s.s.d(new byte[]{80, 90, 93, 72, 92, 94, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, SignedBytes.MAX_POWER_OF_TWO, Ascii.ESC, 93, 15, 92, 88, 79, Ascii.ETB, 2, 9, Ascii.US, 16, 71, 92, 92, Ascii.NAK, Ascii.US, 67, 19, 5, 8, 17, 87, 10, 65, 88, 81, Ascii.DC2, 88, 88, 15, 74, 36, 14, 68, Ascii.ETB, 103, 71, 81, 8, 66, 81, 14, Ascii.SYN, 11, 3, 69, 12, 92, 91}, "350f17") + this.f5574a + this.b + this.c + this.d).getBytes(Transformation.CHARSET));
    }
}
