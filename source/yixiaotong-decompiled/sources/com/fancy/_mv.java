package com.fancy;

import android.content.Context;
import android.widget.Toast;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.mpsdk.activity.PtgBaseVideoActivity;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _mv implements _pc {
    public final /* synthetic */ _di _a;
    public final /* synthetic */ PtgBaseVideoActivity _b;
    public final /* synthetic */ _mt _c;

    public _mv(_mt _mtVar, _di _diVar, PtgBaseVideoActivity ptgBaseVideoActivity) {
        this._c = _mtVar;
        this._a = _diVar;
        this._b = ptgBaseVideoActivity;
    }

    @Override // com.fancy._pc
    public final void _a(int i, JSONObject jSONObject) {
    }

    @Override // com.fancy._pc
    public final void _a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("action", "");
            String strOptString2 = jSONObject.optString("dataKey", "");
            String strOptString3 = jSONObject.optString("dataValue", "");
            _os _osVar_a = _os._a(this._c._c, strOptString);
            if (_osVar_a != null) {
                _osVar_a._t._a(strOptString3, strOptString2);
                String str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar_a);
                if (TextUtil.isNotEmpty(str_a)) {
                    NetUtils._a(str_a);
                }
            }
            _di _diVar = this._a;
            if (_diVar._d && _diVar.getVisibility() == 0) {
                this._a._a();
            }
            PtgBaseVideoActivity ptgBaseVideoActivity = this._b;
            WeakReference<Toast> weakReference = _on._a;
            Context origApplicationContext = StubApp.getOrigApplicationContext(ptgBaseVideoActivity.getApplicationContext());
            Toast toast = _on._a.get();
            if (toast != null) {
                toast.cancel();
            }
            Toast toastMakeText = Toast.makeText(origApplicationContext, "提交成功，感谢您的反馈！", 1);
            toastMakeText.show();
            _on._a = new WeakReference<>(toastMakeText);
        } catch (Exception unused) {
        }
    }

    @Override // com.fancy._pc
    public final void _b(String str) {
        _di _diVar = this._a;
        if (_diVar._d && _diVar.getVisibility() == 0) {
            this._a._a();
        }
    }

    @Override // com.fancy._pc
    public final void _g() {
    }
}
