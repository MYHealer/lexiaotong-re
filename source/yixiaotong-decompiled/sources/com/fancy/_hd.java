package com.fancy;

import android.net.Uri;
import android.view.Surface;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _hd implements Runnable {
    public final /* synthetic */ NiceVideoPlayer _a;

    public class _a implements Runnable {
        public _a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            _hd.this._a._b.setKeepScreenOn(true);
        }
    }

    public _hd(NiceVideoPlayer niceVideoPlayer) {
        this._a = niceVideoPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NiceVideoPlayer niceVideoPlayer = this._a;
        if (niceVideoPlayer._d == null || niceVideoPlayer._c == null) {
            return;
        }
        try {
            niceVideoPlayer._h.post(new _a());
            this._a._i = 0L;
            this._a._j = 0L;
            this._a._k = false;
            NiceVideoPlayer niceVideoPlayer2 = this._a;
            niceVideoPlayer2._d.setDataSource(StubApp.getOrigApplicationContext(niceVideoPlayer2.getContext().getApplicationContext()), Uri.parse(this._a._n), this._a._o);
            Surface surface = this._a._e;
            if (surface != null) {
                surface.release();
            }
            this._a._e = new Surface(this._a._c);
            NiceVideoPlayer niceVideoPlayer3 = this._a;
            niceVideoPlayer3._d.setSurface(niceVideoPlayer3._e);
            this._a._d.prepareAsync();
            NiceVideoPlayer niceVideoPlayer4 = this._a;
            niceVideoPlayer4._l = 1;
            niceVideoPlayer4._a(1);
            NiceVideoPlayer niceVideoPlayer5 = this._a;
            niceVideoPlayer5._t.postDelayed(niceVideoPlayer5._u, 5000L);
            NiceVideoPlayer niceVideoPlayer6 = this._a;
            niceVideoPlayer6.hasWindowFocus();
            niceVideoPlayer6.getClass();
        } catch (Exception unused) {
            this._a.getClass();
        }
    }
}
