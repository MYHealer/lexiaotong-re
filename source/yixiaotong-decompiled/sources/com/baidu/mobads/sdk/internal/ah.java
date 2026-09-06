package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class ah implements NativeCPUManager.DataPostBackListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f1717a;
    final /* synthetic */ ae b;

    ah(ae aeVar, Object obj) {
        this.b = aeVar;
        this.f1717a = obj;
    }

    @Override // com.baidu.mobads.sdk.api.NativeCPUManager.DataPostBackListener
    public void postback(JSONObject jSONObject) {
        Object obj = this.f1717a;
        if (obj instanceof Activity) {
            View viewFindViewById = ((Activity) obj).findViewById(17);
            if (viewFindViewById instanceof WebView) {
                this.b.a((WebView) viewFindViewById, jSONObject);
            }
        }
    }
}
