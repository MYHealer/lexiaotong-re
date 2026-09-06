package com.opos.cmn.an.e.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.stub.StubApp;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AssetManager f5883a;

    public static AssetManager a(Context context) {
        if (f5883a == null && context != null) {
            f5883a = StubApp.getOrigApplicationContext(context.getApplicationContext()).getAssets();
        }
        return f5883a;
    }

    public static InputStream a(Context context, String str) {
        String str2;
        if (context != null && !com.opos.cmn.an.d.a.a(str)) {
            try {
                return a(context).open(str);
            } catch (IOException e) {
                e = e;
                str2 = "open";
                com.opos.cmn.an.f.a.c("AssetsTool", str2, e);
                return null;
            } catch (Exception e2) {
                e = e2;
                str2 = "copyFile2Sdcard";
                com.opos.cmn.an.f.a.c("AssetsTool", str2, e);
                return null;
            }
        }
        return null;
    }

    public static Bitmap b(Context context, String str) {
        if (context == null || com.opos.cmn.an.d.a.a(str)) {
            return null;
        }
        try {
            InputStream inputStreamA = a(context, str);
            if (inputStreamA != null) {
                return BitmapFactory.decodeStream(inputStreamA);
            }
            return null;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AssetsTool", "getBitmap", e);
            return null;
        }
    }

    public static Drawable c(Context context, String str) {
        Drawable bitmapDrawable = null;
        if (context != null && !com.opos.cmn.an.d.a.a(str)) {
            try {
                Bitmap bitmapB = b(context, str);
                if (bitmapB != null) {
                    byte[] ninePatchChunk = bitmapB.getNinePatchChunk();
                    bitmapDrawable = (ninePatchChunk == null || ninePatchChunk.length <= 0) ? new BitmapDrawable(bitmapB) : new NinePatchDrawable(bitmapB, ninePatchChunk, new Rect(), null);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("AssetsTool", "getDrawable", e);
            }
        }
        return bitmapDrawable;
    }
}
