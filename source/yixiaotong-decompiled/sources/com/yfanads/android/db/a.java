package com.yfanads.android.db;

import com.yfanads.android.callback.OnResultListener;
import com.yfanads.android.libs.net.NetCallBack;
import com.yfanads.android.libs.thirdpart.gson.GsonBuilder;
import com.yfanads.android.model.SdkConfModel;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import org.json.JSONObject;

/* JADX INFO: compiled from: DataManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a extends NetCallBack.NetCallBackString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnResultListener f9639a;
    public final /* synthetic */ d b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d dVar, com.yfanads.android.a aVar) {
        super(false);
        this.b = dVar;
        this.f9639a = aVar;
    }

    @Override // com.yfanads.android.libs.net.NetCallBack
    /* JADX INFO: renamed from: onFailure */
    public final void m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(int i, String str) {
        YFLog.error("getSdkConf onFailure " + i);
        boolean z = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b.a.f9685a.a(YFAdsConst.ReportETypeValue.APP_CONFIG_FAIL.getValue(), "");
        this.f9639a.onFailed(i, str);
        if (i == 99500) {
            com.yfanads.android.net.d.b.f9654a.a(com.yfanads.android.net.a.API, false);
        }
    }

    @Override // com.yfanads.android.libs.net.NetCallBack
    /* JADX INFO: renamed from: onResponse */
    public final void m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(String str) {
        String str2 = str;
        boolean z = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b.a.f9685a.a(YFAdsConst.ReportETypeValue.APP_CONFIG_SUCCESS.getValue(), "");
        d dVar = this.b;
        OnResultListener onResultListener = this.f9639a;
        dVar.getClass();
        try {
            if (str2 != null) {
                JSONObject jSONObject = new JSONObject(str2);
                int iOptInt = jSONObject.optInt("code");
                String strOptString = jSONObject.optString("msg");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                YFLog.high(" resultCode " + iOptInt);
                if (iOptInt == 0 && jSONObjectOptJSONObject != null) {
                    onResultListener.onSuccess((SdkConfModel) new GsonBuilder().create().fromJson(jSONObjectOptJSONObject.toString(), SdkConfModel.class));
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
