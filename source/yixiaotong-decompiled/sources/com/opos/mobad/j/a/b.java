package com.opos.mobad.j.a;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.TextureView;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {
    public static Bitmap a(Object obj, String str) {
        Bitmap bitmapCreateBitmap = null;
        if (obj == null) {
            return null;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (obj instanceof TextureView) {
                bitmapCreateBitmap = ((TextureView) obj).getBitmap();
            } else if (obj instanceof SurfaceView) {
                SurfaceView surfaceView = (SurfaceView) obj;
                bitmapCreateBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
                PixelCopy.request(surfaceView, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.opos.mobad.j.a.b.1
                    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                    public void onPixelCopyFinished(int i) {
                    }
                }, surfaceView.getHandler());
            }
            com.opos.cmn.an.f.a.b("VideoFrameUtils", "getFirstOrCurrentFrame end:" + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("VideoFrameUtils", "getFirstOrCurrentFrame fail");
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap a(String str) {
        return a(str, true);
    }

    public static Bitmap a(String str, boolean z) {
        Bitmap frameAtTime = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.opos.cmn.an.f.a.b("VideoFrameUtils", "video path = " + str);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (z) {
                mediaMetadataRetriever.setDataSource(str, new HashMap());
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoFrameUtils", e.getStackTrace(), e);
        }
        com.opos.cmn.an.f.a.b("VideoFrameUtils", "time = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return frameAtTime;
    }

    private static Bitmap b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http://127.0.0.1")) {
            return a(str);
        }
        if (str.startsWith(UriUtil.LOCAL_FILE_SCHEME)) {
            str = Uri.parse(str).getPath();
        }
        return c(str);
    }

    private static Bitmap c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (new File(str).exists()) {
            return a(str, false);
        }
        com.opos.cmn.an.f.a.b("VideoFrameUtils", "local video is null");
        return null;
    }
}
