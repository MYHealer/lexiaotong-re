package com.baidu.oauth.sdkbqt.view;

import android.content.Intent;
import com.baidu.oauth.sdkbqt.auth.BdSsoHandler;
import com.baidu.oauth.sdkbqt.result.OauthResult;
import com.huawei.openalliance.ad.constant.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class k implements com.baidu.oauth.sdkbqt.auth.i.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1917a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ WebViewActivity d;

    k(WebViewActivity webViewActivity, String str, String str2, String str3) {
        this.d = webViewActivity;
        this.f1917a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.baidu.oauth.sdkbqt.auth.i.d
    public void a(String str) {
        com.baidu.oauth.sdkbqt.a.d.a(WebViewActivity.f1904a, "the url of BdOauthWebCallback is " + str);
        Intent intent = new Intent();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("errNo");
            if (iOptInt == -301) {
                WebViewActivity webViewActivity = this.d;
                webViewActivity.setResult(0, webViewActivity.a(OauthResult.ERROR_CODE_USER_CANCEL));
                this.d.finish();
                return;
            }
            String str2 = "1";
            if (iOptInt == 80103 || iOptInt == 80104) {
                com.baidu.oauth.sdkbqt.a.d.a(WebViewActivity.f1904a, "oauth_sso_hash is old, just need generate a new value");
                HashMap map = new HashMap();
                map.put("client", "android");
                map.put("clientfrom", "native");
                map.put("suppcheck", "1");
                map.put("oauth_redirect_uri", this.f1917a);
                map.put("getauthorizationcode", "1");
                this.d.oauthWebView.a(this.b, (Map<String, String>) map);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(x.df, jSONObject.optString("access_token"));
            jSONObject2.put("openid", jSONObject.optString("openid"));
            jSONObject2.put("expiresIn", jSONObject.optString("expires_in"));
            jSONObject2.put("scope", this.c);
            jSONObject2.put("code", jSONObject.optString("authorization_code"));
            if (!this.d.e) {
                str2 = "0";
            }
            jSONObject2.put("showLogin", str2);
            jSONObject.put("state", jSONObject.optString("state"));
            intent.putExtra(BdSsoHandler.EXTRA_OAUTH_RESULT_JSON, jSONObject2.toString());
            this.d.setResult(-1, intent);
            this.d.finish();
        } catch (JSONException e) {
            com.baidu.oauth.sdkbqt.a.d.a(e);
            WebViewActivity webViewActivity2 = this.d;
            webViewActivity2.setResult(0, webViewActivity2.a(OauthResult.ERROR_CODE_UNKNOW_ERROR));
        }
    }
}
