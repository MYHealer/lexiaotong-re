package com.yfanads.android.db;

import com.yfanads.android.callback.OnResultListener;
import com.yfanads.android.libs.net.NetCallBack;
import com.yfanads.android.model.StrategyModel;
import com.yfanads.android.utils.YFLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DataManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class c extends NetCallBack.NetCallBackString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnResultListener f9641a;
    public final /* synthetic */ d b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, boolean z, b bVar) {
        super(false, z);
        this.b = dVar;
        this.f9641a = bVar;
    }

    @Override // com.yfanads.android.libs.net.NetCallBack
    /* JADX INFO: renamed from: onFailure */
    public final void m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(int i, String str) {
        YFLog.error("toGetData onFailure " + i + "|");
        this.f9641a.onFailed(i, str);
        if (i == 99500) {
            com.yfanads.android.net.d.b.f9654a.a(com.yfanads.android.net.a.API, false);
        }
    }

    @Override // com.yfanads.android.libs.net.NetCallBack
    /* JADX INFO: renamed from: onResponse */
    public final void m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(String str) {
        String str2 = str;
        d dVar = this.b;
        OnResultListener onResultListener = this.f9641a;
        dVar.getClass();
        try {
            if (str2 != null) {
                JSONObject jSONObject = new JSONObject(str2);
                int iOptInt = jSONObject.optInt("code");
                String strOptString = jSONObject.optString("msg");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                YFLog.high(" resultCode " + iOptInt);
                if (iOptInt == 0 && jSONObjectOptJSONObject != null) {
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("waterfall");
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        onResultListener.onSuccess(new StrategyModel());
                    } else {
                        onResultListener.onSuccess(StrategyModel.covertModel(jSONObjectOptJSONObject.toString()));
                    }
                } else if (iOptInt == 1) {
                    onResultListener.onSuccess(null);
                } else {
                    onResultListener.onFailed(iOptInt, strOptString);
                }
            } else {
                onResultListener.onFailed(-1, "response empty");
            }
        } catch (Throwable th) {
            YFLog.error("DataManager toGetData " + th.getMessage());
            onResultListener.onFailed(-2, th.getMessage());
        }
        com.yfanads.android.net.d.b.f9654a.a(com.yfanads.android.net.a.API, true);
    }
}
