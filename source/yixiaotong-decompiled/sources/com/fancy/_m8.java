package com.fancy;

import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _m8 {
    public static _m8 _e;
    public final ConcurrentHashMap _a = new ConcurrentHashMap();
    public final ConcurrentHashMap _b = new ConcurrentHashMap();
    public final ConcurrentHashMap _c = new ConcurrentHashMap();
    public final ConcurrentHashMap _d = new ConcurrentHashMap();

    public static _m8 _a() {
        if (_e == null) {
            synchronized (_m8.class) {
                if (_e == null) {
                    _e = new _m8();
                }
            }
        }
        return _e;
    }

    public final void _a(long j, long j2, String str) {
        List list;
        if (str == null || (list = (List) this._c.get(str)) == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoProgressUpdate(j, j2);
        }
    }

    public final void _a(String str) {
        List list;
        if (str == null || (list = (List) this._c.get(str)) == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onAdShow();
        }
    }

    public final void _a(String str, int i, String str2) {
        List list;
        if (str == null || (list = (List) this._c.get(str)) == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoError(i, str2);
        }
    }

    public final void _a(String str, long j, long j2, String str2) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onDownloadActive(j, j2, str2);
        }
    }

    public final void _a(String str, AdErrorImpl adErrorImpl) {
        List list;
        if (str == null || (list = (List) this._c.get(str)) == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onRenderError(adErrorImpl);
        }
    }

    public final void _a(String str, String str2) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onDownloadFailed(str2);
        }
    }

    public final void _b(String str) {
        synchronized (this._a) {
            this._a.remove(str);
        }
        synchronized (this._b) {
            this._b.remove(str);
        }
        synchronized (this._c) {
            this._c.remove(str);
        }
        synchronized (this._d) {
            this._d.remove(str);
        }
    }

    public final void _b(String str, long j, long j2, String str2) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onDownloadPaused(j, j2, str2);
        }
    }

    public final void _b(String str, String str2) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onDownloadFinished(str2);
        }
    }

    public final void _c(String str) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onDownloadCancel();
        }
    }

    public final void _c(String str, String str2) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onInstalled(str2);
        }
    }

    public final void _d(String str) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onIdle();
        }
    }

    public final void _e(String str) {
        List list;
        if (str == null || (list = (List) this._c.get(str)) == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoComplete();
        }
    }

    public final void _f(String str) {
        List list;
        if (str == null || (list = (List) this._c.get(str)) == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoPause();
        }
    }

    public final void _g(String str) {
        List list;
        if (str == null || (list = (List) this._c.get(str)) == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoStart();
        }
    }
}
