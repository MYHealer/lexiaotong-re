package com.fancy;

import com.alipay.sdk.tid.b;
import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ln implements _l4._a {
    public final /* synthetic */ _lp _a;

    public _ln(_lp _lpVar) {
        this._a = _lpVar;
    }

    @Override // com.fancy._l4._a
    public final void _a(int i) {
        if (this._a._f != null) {
            if (i == 4) {
                Logger.d("RewardVideoWeb", "视频暂停");
                _mt._d _dVar = (_mt._d) this._a._f;
                _mt _mtVar = _mt.this;
                _mtVar.getClass();
                _mtVar._a("onVideoStateChanged", _mt._a(new String[][]{new String[]{"state", "paused"}, new String[]{b.f, String.valueOf(System.currentTimeMillis())}}));
                _m8._a()._f(_mt.this._e);
                return;
            }
            if (i == 3) {
                Logger.d("RewardVideoWeb", "视频播放中");
                this._a._f.getClass();
            } else if (i == 8) {
                Logger.d("RewardVideoWeb", "视频恢复播放");
            }
        }
    }
}
