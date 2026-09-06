package com.fancy;

import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _mm implements _l4._a {
    public final /* synthetic */ _me _a;

    public _mm(_me _meVar) {
        this._a = _meVar;
    }

    @Override // com.fancy._l4._a
    public final void _a(int i) {
        if (4 == i) {
            _m8._a()._f(this._a._a4);
            return;
        }
        if (3 != i && 8 == i) {
            _m8 _m8Var_a = _m8._a();
            String str = this._a._a4;
            if (str == null) {
                _m8Var_a.getClass();
                return;
            }
            List list = (List) _m8Var_a._c.get(str);
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoResume();
            }
        }
    }
}
