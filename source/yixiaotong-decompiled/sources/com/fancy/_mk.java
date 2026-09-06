package com.fancy;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.fancy.adsdk.lib.tracking.ActionTrackManager;
import com.fancy.mpsdk.activity.PtgRewardVideoPortraitActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _mk implements View.OnClickListener {
    public final /* synthetic */ _mc _a;
    public final /* synthetic */ Activity _b;
    public final /* synthetic */ _me _c;

    public _mk(_me _meVar, PtgRewardVideoPortraitActivity._a _aVar, Activity activity) {
        this._c = _meVar;
        this._a = _aVar;
        this._b = activity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView = this._c._J;
        int i = 0;
        if (textView != null) {
            Object tag = textView.getTag();
            int iIntValue = tag instanceof Integer ? ((Integer) tag).intValue() : 0;
            if (iIntValue >= 0) {
                i = iIntValue;
            }
        }
        long j = (long) (_me._ae / 1000.0f);
        if (i == 0) {
            ActionTrackManager._a()._a(_hr._a(this._c._b), j);
            _mc _mcVar = this._a;
            if (_mcVar != null) {
                PtgRewardVideoPortraitActivity.this._a();
                return;
            }
            return;
        }
        _me _meVar = this._c;
        Activity activity = this._b;
        _mc _mcVar2 = this._a;
        String str = "再看" + i + "秒可领奖励";
        if (_meVar._ad == null) {
            _b9 _b9Var = new _b9(activity);
            _meVar._ad = _b9Var;
            _b9Var._g = str;
            TextView textView2 = _b9Var._d;
            if (textView2 != null) {
                textView2.setText(str);
            }
            _meVar._ad.setOnDismissListener(new _mh(_meVar));
            _b9 _b9Var2 = _meVar._ad;
            _b9Var2._h = new _mi(_meVar, j, _mcVar2);
            _b9Var2.setOnKeyListener(new _mj());
            _meVar._ad.show();
        }
    }
}
