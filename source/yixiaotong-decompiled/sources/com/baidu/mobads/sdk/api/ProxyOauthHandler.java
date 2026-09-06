package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.b.a;
import com.baidu.mobads.sdk.internal.bj;
import com.baidu.mobads.sdk.internal.z;
import com.baidu.oauth.sdkbqt.auth.AuthInfo;
import com.baidu.oauth.sdkbqt.auth.BdOauthSdk;
import com.baidu.oauth.sdkbqt.auth.BdSsoHandler;
import com.baidu.oauth.sdkbqt.callback.BdOauthCallback;
import com.baidu.oauth.sdkbqt.dto.BdOauthDTO;
import com.baidu.oauth.sdkbqt.result.BdOauthResult;
import com.baidu.oauth.sdkbqt.result.OauthResult;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ProxyOauthHandler {
    private BdSsoHandler bdSsoHandler;

    public void release() {
        this.bdSsoHandler = null;
    }

    public void login(Activity activity, String str, String str2, boolean z, boolean z2, final OauthCodeCallback oauthCodeCallback) {
        if (activity == null) {
            callbackFail(oauthCodeCallback, 303, "Init failed.", null);
            return;
        }
        AuthInfo authInfo = new AuthInfo(StubApp.getOrigApplicationContext(activity.getApplicationContext()), str, z.d, "basic", z, str2);
        authInfo.isDebug(true);
        authInfo.setFindViewDelegate(new AuthInfo.FindViewDelegate() { // from class: com.baidu.mobads.sdk.api.ProxyOauthHandler.1
            @Override // com.baidu.oauth.sdkbqt.auth.AuthInfo.FindViewDelegate
            public int oauthResID(String str3) {
                Integer numA = a.a(str3);
                if (numA != null) {
                    return numA.intValue();
                }
                return 0;
            }
        });
        BdOauthSdk.init(authInfo);
        this.bdSsoHandler = new BdSsoHandler(activity);
        BdOauthDTO bdOauthDTO = new BdOauthDTO();
        bdOauthDTO.oauthType = (char) 3;
        bdOauthDTO.state = UUID.randomUUID().toString();
        ArrayList arrayList = new ArrayList();
        arrayList.add(BdOauthDTO.APP_SEARCHBOX);
        bdOauthDTO.authorizedPkgs = arrayList;
        bdOauthDTO.isSilent = true ^ z2;
        this.bdSsoHandler.authorize(bdOauthDTO, new BdOauthCallback() { // from class: com.baidu.mobads.sdk.api.ProxyOauthHandler.2
            @Override // com.baidu.oauth.sdkbqt.callback.OauthCallback
            public void onSuccess(BdOauthResult bdOauthResult) {
                ProxyOauthHandler.this.bdSsoHandler = null;
                final String code = bdOauthResult.getCode();
                final JSONObject jSONObjectResultToJson = ProxyOauthHandler.this.resultToJson(bdOauthResult);
                if (TextUtils.isEmpty(code)) {
                    ProxyOauthHandler.this.callbackFail(oauthCodeCallback, OauthResult.ERROR_CODE_UNKNOW_ERROR, "Empty code.", jSONObjectResultToJson);
                } else {
                    bj.a(new Runnable() { // from class: com.baidu.mobads.sdk.api.ProxyOauthHandler.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (oauthCodeCallback != null) {
                                oauthCodeCallback.onSuccess(code, jSONObjectResultToJson);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.oauth.sdkbqt.callback.OauthCallback
            public void onFailure(BdOauthResult bdOauthResult) {
                ProxyOauthHandler.this.bdSsoHandler = null;
                ProxyOauthHandler.this.callbackFail(oauthCodeCallback, bdOauthResult.getResultCode(), bdOauthResult.getResultMsg(), ProxyOauthHandler.this.resultToJson(bdOauthResult));
            }
        });
    }

    public void authorizeCallBack(int i, int i2, Intent intent) {
        try {
            BdSsoHandler bdSsoHandler = this.bdSsoHandler;
            if (bdSsoHandler != null) {
                bdSsoHandler.authorizeCallBack(i, i2, intent);
            }
        } catch (Exception e) {
            az.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject resultToJson(BdOauthResult bdOauthResult) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sub_code", bdOauthResult.resultSubCode);
            jSONObject.put("sub_msg", bdOauthResult.resultSubMsg);
            jSONObject.put("is_visible_auth", bdOauthResult.isVisibleAuth);
            jSONObject.put("is_degrade", bdOauthResult.isDegrade);
            jSONObject.put("is_install_bd_app", bdOauthResult.isInstallBdApp);
            jSONObject.put("is_pass_new_version", bdOauthResult.isPassNewVersion);
            jSONObject.put("app_version", bdOauthResult.appVersion);
            jSONObject.put("pass_sdk_version", bdOauthResult.passSdkVersion);
            jSONObject.put("allow_launch_auth_app", bdOauthResult.allowLaunchAuthApp);
            jSONObject.put("login_state_before_auth", bdOauthResult.loginStateBeforeAuth);
            jSONObject.put("login_state_after_auth", bdOauthResult.loginStateAfterAuth);
        } catch (Throwable th) {
            az.e(th);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackFail(final OauthCodeCallback oauthCodeCallback, final int i, final String str, final JSONObject jSONObject) {
        bj.a(new Runnable() { // from class: com.baidu.mobads.sdk.api.ProxyOauthHandler.3
            @Override // java.lang.Runnable
            public void run() {
                OauthCodeCallback oauthCodeCallback2 = oauthCodeCallback;
                if (oauthCodeCallback2 != null) {
                    oauthCodeCallback2.onFailure(i, str, jSONObject);
                }
            }
        });
    }
}
