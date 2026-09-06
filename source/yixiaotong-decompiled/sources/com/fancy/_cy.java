package com.fancy;

import android.content.Context;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.mpsdk.download.DownloadResult;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _cy implements _cq {
    public final /* synthetic */ com.fancy._f _a;
    public final /* synthetic */ Context _b;

    public class _a implements Runnable {
        public final /* synthetic */ DownloadResult _a;
        public final /* synthetic */ Throwable _b;

        public _a(DownloadResult downloadResult, Throwable th) {
            this._a = downloadResult;
            this._b = th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _cv._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                ptgAppDownloadListener_a.onDownloadFailed(this._b.getMessage());
            }
            Logger.d(_ie._a("DownloadManager error [").append(this._a._a).append("]").toString());
        }
    }

    public class _b implements Runnable {
        public final /* synthetic */ DownloadResult _a;

        public _b(DownloadResult downloadResult) {
            this._a = downloadResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _cv._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                ptgAppDownloadListener_a.onIdle();
            }
            Logger.d(_ie._a("DownloadManager waiting [").append(this._a._a).append("]").toString());
        }
    }

    public class _c implements Runnable {
        public final /* synthetic */ DownloadResult _a;

        public _c(DownloadResult downloadResult) {
            this._a = downloadResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _cv._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                DownloadResult downloadResult = this._a;
                ptgAppDownloadListener_a.onDownloadActive(downloadResult._d, downloadResult._e, downloadResult._a);
            }
            Logger.d(_ie._a("DownloadManager start [").append(this._a._a).append("]").toString());
        }
    }

    public class _d implements Runnable {
        public final /* synthetic */ DownloadResult _a;

        public _d(DownloadResult downloadResult) {
            this._a = downloadResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _cv._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                DownloadResult downloadResult = this._a;
                ptgAppDownloadListener_a.onDownloadActive(downloadResult._d, downloadResult._e, downloadResult._a);
            }
            Logger.d(_ie._a("DownloadManager downloading [").append(this._a._a).append("]").toString());
        }
    }

    public class _e implements Runnable {
        public final /* synthetic */ DownloadResult _a;

        public _e(DownloadResult downloadResult) {
            this._a = downloadResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _cv._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                DownloadResult downloadResult = this._a;
                ptgAppDownloadListener_a.onDownloadActive(downloadResult._d, downloadResult._e, downloadResult._a);
            }
            Logger.d(_ie._a("DownloadManager pause [").append(this._a._a).append("]").toString());
        }
    }

    public class _f implements Runnable {
        public final /* synthetic */ DownloadResult _a;

        public _f(DownloadResult downloadResult) {
            this._a = downloadResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _cv._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                ptgAppDownloadListener_a.onDownloadFinished(this._a._a);
            }
            Logger.d(_ie._a("DownloadManager completed [").append(this._a._a).append("]").toString());
        }
    }

    public class _g implements Runnable {
        public final /* synthetic */ DownloadResult _a;

        public _g(DownloadResult downloadResult) {
            this._a = downloadResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _cv._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                ptgAppDownloadListener_a.onDownloadCancel();
            }
            Logger.d("DownloadManager cancel");
        }
    }

    public _cy(com.fancy._f _fVar, Context context, _cx _cxVar) {
        this._a = _fVar;
        this._b = context;
    }

    @Override // com.fancy._cq
    public final void _a(DownloadResult downloadResult) {
        com.fancy.adsdk.lib.utils._d._c(new _c(downloadResult));
    }

    @Override // com.fancy._cq
    public final void _a(DownloadResult downloadResult, int i) {
        com.fancy.adsdk.lib.utils._d._c(new _e(downloadResult));
    }

    @Override // com.fancy._cq
    public final void _a(DownloadResult downloadResult, Throwable th) {
        com.fancy.adsdk.lib.utils._d._c(new _a(downloadResult, th));
    }

    @Override // com.fancy._cq
    public final void _b(DownloadResult downloadResult) {
        com.fancy.adsdk.lib.utils._d._c(new _g(downloadResult));
    }

    @Override // com.fancy._cq
    public final void _b(DownloadResult downloadResult, int i) {
        com.fancy.adsdk.lib.utils._d._c(new _d(downloadResult));
    }

    @Override // com.fancy._cq
    public final void _c(DownloadResult downloadResult) {
        com.fancy.adsdk.lib.utils._d._c(new _f(downloadResult));
        if (this._a != null) {
            if (!_fl._a(this._b)) {
                _cv._a(PtgAdSdk.getContext(), downloadResult._c);
                return;
            }
            Context context = this._b;
            com.fancy._f _fVar = this._a;
            String str = _fVar._i;
            String str_c = _fVar._c();
            String str2 = downloadResult._c;
            if (context == null) {
                return;
            }
            _kr._a(context, "uninstall_apk_download_url", str);
            _kr._a(context, "uninstall_apk_app_name", str_c);
            _kr._a(context, "uninstall_apk_path", str2);
        }
    }

    @Override // com.fancy._cq
    public final void _d(DownloadResult downloadResult) {
        com.fancy.adsdk.lib.utils._d._c(new _b(downloadResult));
    }
}
