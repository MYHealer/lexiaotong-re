package client.android.yixiaotong.wxapi;

import android.content.Intent;
import android.os.Bundle;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.controller.weixin.HttpCallBackListener;
import client.android.yixiaotong.controller.weixin.OkHttpUtils;
import client.android.yixiaotong.v3.util.LogUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.huawei.openalliance.ad.constant.br;
import com.stub.StubApp;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WXEntryActivity extends BaseActivity implements IWXAPIEventHandler {
    private String TAG = "WXEntryActivity";
    private IWXAPI api;

    static {
        StubApp.interface11(11225);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.api.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(br.f.m, Integer.valueOf(baseResp.errCode));
        jsonObject.addProperty("errStr", baseResp.errStr);
        jsonObject.addProperty("transaction", baseResp.transaction);
        jsonObject.addProperty("openId", baseResp.openId);
        if (baseResp.getType() == 19) {
            WXLaunchMiniProgram.Resp resp = (WXLaunchMiniProgram.Resp) baseResp;
            String str = resp.extMsg;
            jsonObject.addProperty("extMsg", resp.extMsg);
            LogUtil.e(this.TAG, "微信支付结果：" + new Gson().toJson((JsonElement) jsonObject));
            finish();
            return;
        }
        int i = baseResp.errCode;
        if (i == -4) {
            finish();
        } else if (i == -2) {
            finish();
        } else {
            if (i != 0) {
                return;
            }
            getAppidAndSecret(((SendAuth.Resp) baseResp).code);
        }
    }

    private void getAppidAndSecret(String str) {
        String str2;
        String str3;
        String[] strArrSplit = LocalBusinessStore.getRefundAppidSecret(getContext()).split(",");
        if (strArrSplit.length == 2) {
            str3 = strArrSplit[0];
            str2 = strArrSplit[1];
        } else if (strArrSplit.length == 1) {
            str3 = strArrSplit[0];
            str2 = "";
        } else {
            str2 = "";
            str3 = str2;
        }
        getAccessToken(str, str3, str2);
    }

    private void getAccessToken(String str, String str2, String str3) {
        OkHttpUtils.sendHttpRequest("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + str2 + "&secret=" + str3 + "&code=" + str + "&grant_type=authorization_code", new HttpCallBackListener() { // from class: client.android.yixiaotong.wxapi.WXEntryActivity.1
            @Override // client.android.yixiaotong.controller.weixin.HttpCallBackListener
            public void onError(Exception exc) {
            }

            @Override // client.android.yixiaotong.controller.weixin.HttpCallBackListener
            public void onFinish(String str4) {
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    String string = jSONObject.getString("access_token");
                    String string2 = jSONObject.getString("openid");
                    LocalBusinessStore.saveOpenId(WXEntryActivity.this.getContext(), string2);
                    if (string2.equals("")) {
                        return;
                    }
                    WXEntryActivity.this.getPersonMessage(string, string2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPersonMessage(String str, String str2) {
        OkHttpUtils.sendHttpRequest("https://api.weixin.qq.com/sns/userinfo?access_token=" + str + "&openid=" + str2, new HttpCallBackListener() { // from class: client.android.yixiaotong.wxapi.WXEntryActivity.2
            @Override // client.android.yixiaotong.controller.weixin.HttpCallBackListener
            public void onError(Exception exc) {
            }

            @Override // client.android.yixiaotong.controller.weixin.HttpCallBackListener
            public void onFinish(String str3) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    String string = jSONObject.getString("openid");
                    String string2 = jSONObject.getString("nickname");
                    LocalBusinessStore.saveOpenId(WXEntryActivity.this.getContext(), string);
                    LocalBusinessStore.saveName(WXEntryActivity.this.getContext(), string2);
                    WXEntryActivity.this.finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
