package com.fancy;

import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.byazt.omf.h;
import com.fancy.mpsdk.download.DownloadResult;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _d3 {
    public static final _d3 _b = new _d3();
    public static final HashMap _c = new HashMap();
    public static final HashMap _d = new HashMap();
    public final ConcurrentHashMap _a = new ConcurrentHashMap();

    public static class _a implements Handler.Callback, _cq {
        public final String _a;
        public final HashSet _b = new HashSet();
        public final Messenger _c = new Messenger(new Handler(this));

        public _a(String str) {
            this._a = str;
        }

        @Override // com.fancy._cq
        public final void _a(DownloadResult downloadResult) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cq) it.next())._a(downloadResult);
            }
        }

        @Override // com.fancy._cq
        public final void _a(DownloadResult downloadResult, int i) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
                this._b.clear();
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cq) it.next())._a(downloadResult, i);
            }
        }

        @Override // com.fancy._cq
        public final void _a(DownloadResult downloadResult, Throwable th) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
                this._b.clear();
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cq) it.next())._a(downloadResult, th);
            }
        }

        @Override // com.fancy._cq
        public final void _b(DownloadResult downloadResult) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
                this._b.clear();
                _d3._d.remove(com.fancy.adsdk.lib.utils._a._c(downloadResult._b));
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cq) it.next())._b(downloadResult);
            }
        }

        @Override // com.fancy._cq
        public final void _b(DownloadResult downloadResult, int i) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cq) it.next())._b(downloadResult, i);
            }
        }

        @Override // com.fancy._cq
        public final void _c(DownloadResult downloadResult) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
                this._b.clear();
                _d3._d.remove(com.fancy.adsdk.lib.utils._a._c(downloadResult._b));
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cq) it.next())._c(downloadResult);
            }
        }

        @Override // com.fancy._cq
        public final void _d(DownloadResult downloadResult) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cq) it.next())._d(downloadResult);
            }
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.getData() == null) {
                return false;
            }
            int i = message.getData().getInt("download_status_extra");
            int i2 = message.getData().getInt("download_progress");
            String string = message.getData().getString("download_path_extra");
            long j = message.getData().getLong("download_current_bytes");
            long j2 = message.getData().getLong("download_total_bytes");
            String string2 = message.getData().getString("download_file_name");
            switch (i) {
                case 42:
                    _d(new DownloadResult(string2, j2, j, this._a, string));
                    break;
                case 43:
                    _a(new DownloadResult(string2, j2, j, this._a, string));
                    break;
                case 44:
                    _b(new DownloadResult(string2, j2, j, this._a, string), i2);
                    break;
                case 45:
                    _a(new DownloadResult(string2, j2, j, this._a, string), i2);
                    break;
                case 46:
                    _c(new DownloadResult(string2, j2, j, this._a, string));
                    break;
                case 47:
                    _a(new DownloadResult(string2, j2, j, this._a, string), message.getData() != null ? (Throwable) message.getData().getSerializable("error_extra") : new RuntimeException(h.UNKNOWN_ERR_MSG));
                    break;
                case 48:
                    _b(new DownloadResult(string2, j2, j, this._a, string));
                    break;
            }
            return false;
        }
    }

    public final void _a(int i, int i2, String str, String str2, _f _fVar, _cv._c _cVar) {
        synchronized (this._a) {
            this._a.remove(str2);
        }
        if (_fVar != null) {
            _fVar._k = i;
        }
        if (_cVar != null) {
            ((_cv._a) _cVar)._a(i, i2, str);
        }
    }
}
