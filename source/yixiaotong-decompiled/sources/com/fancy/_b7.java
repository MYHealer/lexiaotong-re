package com.fancy;

import android.view.View;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import com.fancy.adsdk.lib.tracking.ActionTrackManager;
import com.fancy.mpsdk.activity.PtgRewardVideoPortraitActivity;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _b7 implements View.OnClickListener {
    public final /* synthetic */ _b9 _a;

    public _b7(_b9 _b9Var) {
        this._a = _b9Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this._a.dismiss();
        _b9._a _aVar = this._a._h;
        if (_aVar != null) {
            _mi _miVar = (_mi) _aVar;
            _m8 _m8Var_a = _m8._a();
            String str = _miVar._c._a4;
            if (str == null) {
                _m8Var_a.getClass();
            } else {
                List list = (List) _m8Var_a._c.get(str);
                if (list != null && !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onSkippedVideo();
                    }
                }
            }
            ActionTrackManager._a()._a(_hr._a(_miVar._c._b), _miVar._a);
            _miVar._c.getClass();
            _mc _mcVar = _miVar._b;
            if (_mcVar != null) {
                PtgRewardVideoPortraitActivity.this._a();
            }
        }
    }
}
