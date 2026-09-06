package com.fancy.mpsdk.component.videoplayer2;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.fancy._jy;
import com.fancy._le;
import com.fancy.mpsdk.component.video.PtgVideoView;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _b implements Runnable {
    public final /* synthetic */ String _a;
    public final /* synthetic */ long _b;
    public final /* synthetic */ _c._a _c;

    public class _a implements Runnable {
        public final /* synthetic */ Bitmap _a;

        public _a(Bitmap bitmap) {
            this._a = bitmap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ImageView imageView;
            _c._a _aVar = _b.this._c;
            Bitmap bitmap = this._a;
            PtgCoreVideo ptgCoreVideo = ((com.fancy.mpsdk.component.videoplayer2._a) _aVar)._a;
            ptgCoreVideo._r = bitmap;
            _jy _jyVar = ptgCoreVideo._t;
            if (_jyVar != null) {
                PtgVideoView ptgVideoView = ((_le) _jyVar)._a;
                int i = PtgVideoView._v;
                ptgVideoView.getClass();
                if (bitmap == null || bitmap.isRecycled() || (imageView = ptgVideoView._g) == null) {
                    return;
                }
                imageView.setImageBitmap(bitmap);
                ptgVideoView._g.setVisibility(0);
            }
        }
    }

    /* JADX INFO: renamed from: com.fancy.mpsdk.component.videoplayer2._b$_b, reason: collision with other inner class name */
    public class RunnableC0377_b implements Runnable {
        public final /* synthetic */ Exception _a;

        public RunnableC0377_b(Exception exc) {
            this._a = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _c._a _aVar = _b.this._c;
            Exception exc = this._a;
            PtgCoreVideo ptgCoreVideo = ((com.fancy.mpsdk.component.videoplayer2._a) _aVar)._a;
            exc.getMessage();
            ptgCoreVideo.getClass();
        }
    }

    public _b(String str, long j, com.fancy.mpsdk.component.videoplayer2._a _aVar) {
        this._a = str;
        this._b = j;
        this._c = _aVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(this._a);
                new Handler(Looper.getMainLooper()).post(new _a(mediaMetadataRetriever.getFrameAtTime(this._b, 2)));
            } catch (Exception e) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0377_b(e));
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }
}
