package com.baidu.oauth.sdkbqt.auth;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.oauth.sdkbqt.callback.BdOauthCallback;
import com.baidu.oauth.sdkbqt.dto.BdOauthDTO;
import com.baidu.oauth.sdkbqt.result.BdOauthResult;
import com.baidu.oauth.sdkbqt.result.OauthResult;
import com.baidu.oauth.sdkbqt.view.WebViewActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class BdSsoHandler implements com.baidu.oauth.sdkbqt.a.e {
    public static final String EXTRA_DEGRADE_EXEMPT_AUTH_PAGE = "extra_degrade_exempt_auth_page";
    public static final String EXTRA_DEGRADE_H5_AUTH = "extra_degrade_h5_auth";
    public static final String EXTRA_GUID_TYPE = "extra_guid_type";
    public static final String EXTRA_OAUTH_RESULT_JSON = "extra_oauth_result_json";
    public static final String EXTRA_OAUTH_STATE = "extra_oauth_state";
    public static final String EXTRA_QR_CODE_URL = "extra_qr_code_url";
    public static final String EXTRA_REDIRECT_URL = "extra_redirect_url";
    public static final String EXTRA_SCOPE = "extra_scope";
    public static final String EXTRA_USE_SHA1_AUTH = "extra_use_sha1_auth";
    public static final int GUID_TYPE_BAIDUAPP_AND_WEB = 1;
    public static final int GUID_TYPE_ONLY_BAIDUAPP = 0;
    public static final int GUID_TYPE_ONLY_WEB = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1864a = "BdSsoHandler";
    private static final int b = 1001;
    private static final int c = 1002;
    private static final int d = 1003;
    private static final String e = "extra_calling_app_id";
    private static final String f = "extra_oauth_type";
    private static final String g = "extra_oauth_sdk_version";
    private static final String h = "extra_pass_sdk_version";
    private Activity i;
    private BdOauthCallback j;
    private BdOauthDTO k;
    private BdOauthResult l;
    private boolean m;
    private boolean n;

    public BdSsoHandler(Activity activity) {
        com.baidu.oauth.sdkbqt.a.h.a((Object) activity, "activity is null");
        this.i = activity;
    }

    private HashMap<String, String> a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return com.baidu.oauth.sdkbqt.a.b.d;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(com.baidu.oauth.sdkbqt.a.b.d.size());
        Object[] array = com.baidu.oauth.sdkbqt.a.b.d.keySet().toArray();
        if (!"0".equals(com.baidu.oauth.sdkbqt.a.h.b(list.get(0)))) {
            linkedHashMap.put(array[0].toString(), com.baidu.oauth.sdkbqt.a.b.d.get(array[0]));
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String strB = com.baidu.oauth.sdkbqt.a.h.b(it.next());
            for (String str : com.baidu.oauth.sdkbqt.a.b.d.keySet()) {
                if (str.equals(strB)) {
                    linkedHashMap.put(str, com.baidu.oauth.sdkbqt.a.b.d.get(str));
                    break;
                }
            }
        }
        return linkedHashMap;
    }

    public void authorize(BdOauthDTO bdOauthDTO, BdOauthCallback bdOauthCallback) {
        com.baidu.oauth.sdkbqt.a.h.a(bdOauthDTO, "please set auth dto params");
        if (a(bdOauthCallback)) {
            this.k = bdOauthDTO;
            HashMap<String, String> mapA = a(bdOauthDTO.authorizedPkgs);
            String str = f1864a;
            com.baidu.oauth.sdkbqt.a.d.a(str, "authorize isSlient:" + bdOauthDTO.isSilent);
            if (mapA.size() > 0) {
                Object[] array = mapA.keySet().toArray();
                Object[] objArr = new Object[1];
                objArr[0] = "authorize first package=" + (array.length > 0 ? array[0] : "null") + ", dto.authorizedPkgs.size=" + (bdOauthDTO.authorizedPkgs == null ? 0 : bdOauthDTO.authorizedPkgs.size()) + ", final authorizedPkgs.size=" + mapA.size();
                com.baidu.oauth.sdkbqt.a.d.a(str, objArr);
            } else {
                Object[] objArr2 = new Object[1];
                objArr2[0] = "authorize  to.authorizedPkgs.size=" + (bdOauthDTO.authorizedPkgs == null ? 0 : bdOauthDTO.authorizedPkgs.size()) + ", final authorizedPkgs.size=" + mapA.size();
                com.baidu.oauth.sdkbqt.a.d.a(str, objArr2);
            }
            Intent intentA = new h().a(this.i, mapA, bdOauthDTO.isSilent);
            if (intentA != null) {
                this.n = true;
            }
            char c2 = bdOauthDTO.oauthType;
            if (c2 != 0) {
                if (c2 == 1) {
                    if (intentA == null) {
                        com.baidu.oauth.sdkbqt.a.d.a(str, "authorize oauthType=OAUTH_TYPE_SSO, ERROR_CODE_NOT_INSTALL_BAIDU_APP");
                        BdOauthResult bdOauthResult = new BdOauthResult();
                        bdOauthResult.setResultCode(OauthResult.ERROR_CODE_NOT_INSTALL_BAIDU_APP);
                        bdOauthCallback.onFailure(bdOauthResult);
                        return;
                    }
                    com.baidu.oauth.sdkbqt.a.d.a(str, "authorize oauthType=OAUTH_TYPE_SSO, intent not null");
                    a(intentA, bdOauthDTO.state);
                    return;
                }
                if (c2 == 2) {
                    com.baidu.oauth.sdkbqt.a.d.a(str, "authorize oauthType=OAUTH_TYPE_WEB");
                    a(bdOauthDTO.state);
                    return;
                } else if (c2 != 3) {
                    return;
                }
            }
            String str2 = bdOauthDTO.oauthType == 3 ? "OAUTH_TYPE_BOTH_V2" : "OAUTH_TYPE_BOTH";
            if (intentA == null) {
                Intent intentA2 = new h().a(this.i, mapA, false);
                if (intentA2 != null) {
                    com.baidu.oauth.sdkbqt.a.d.a(str, "authorize oauthType=" + str2 + ", intent is null, but intent2 not null");
                    this.n = true;
                    a(intentA2, bdOauthDTO.state);
                    return;
                } else {
                    com.baidu.oauth.sdkbqt.a.d.a(str, "authorize oauthType=" + str2 + ", intent is null, then OAUTH_TYPE_WEB");
                    if (bdOauthDTO.isSilent) {
                        a(bdOauthDTO.state, true, true);
                        return;
                    } else {
                        a(bdOauthDTO.state);
                        return;
                    }
                }
            }
            com.baidu.oauth.sdkbqt.a.d.a(str, "authorize oauthType=" + str2 + ", intent not null");
            a(intentA, bdOauthDTO.state);
        }
    }

    public void authorize(BdOauthCallback bdOauthCallback) {
        authorize(new BdOauthDTO(), bdOauthCallback);
    }

    public void authorize(String str, BdOauthCallback bdOauthCallback) {
        authorize(str, bdOauthCallback, 0);
    }

    public void authorize(String str, BdOauthCallback bdOauthCallback, int i) {
        if (a(bdOauthCallback)) {
            BdOauthResult bdOauthResult = new BdOauthResult();
            HashMap map = new HashMap();
            map.put("oauth_type", "qr_code");
            com.baidu.oauth.sdkbqt.a.f.a(com.baidu.oauth.sdkbqt.a.f.b, map);
            AuthInfo authInfo = BdOauthSdk.getAuthInfo();
            if (i == 2) {
                a(authInfo.getRedirectUrl(), str);
                HashMap map2 = new HashMap();
                map2.put("oauth_type", "qr_web");
                com.baidu.oauth.sdkbqt.a.f.a(com.baidu.oauth.sdkbqt.a.f.b, map2);
                return;
            }
            Intent intentA = new h().a(this.i, com.baidu.oauth.sdkbqt.a.b.e, false);
            if (intentA != null) {
                intentA.putExtra(e, authInfo.getAppKey());
                intentA.putExtra(EXTRA_REDIRECT_URL, authInfo.getRedirectUrl());
                intentA.putExtra(EXTRA_SCOPE, authInfo.getScope());
                intentA.putExtra(EXTRA_QR_CODE_URL, str);
                intentA.putExtra(f, 1);
                intentA.putExtra(g, "2.0.6.10");
                intentA.putExtra(h, "8.8.8");
                this.i.startActivityForResult(intentA, 1003);
                return;
            }
            if (i == 1) {
                a(authInfo.getRedirectUrl(), str);
                HashMap map3 = new HashMap();
                map3.put("oauth_type", "qr_web");
                com.baidu.oauth.sdkbqt.a.f.a(com.baidu.oauth.sdkbqt.a.f.b, map3);
                return;
            }
            bdOauthResult.setResultCode(OauthResult.ERROR_CODE_NOT_INSTALL_BAIDU_APP);
            bdOauthCallback.onFailure(bdOauthResult);
            HashMap map4 = new HashMap();
            map4.put("oauth_type", "qr_code");
            map.put("code", bdOauthResult.getResultCode() + "");
            map.put("msg", bdOauthResult.getResultMsg());
            map.put(EXTRA_SCOPE, authInfo.getScope());
            com.baidu.oauth.sdkbqt.a.f.a(com.baidu.oauth.sdkbqt.a.f.d, map4);
        }
    }

    private boolean a(BdOauthCallback bdOauthCallback) {
        com.baidu.oauth.sdkbqt.a.h.a(bdOauthCallback, "please set auth listener");
        this.j = bdOauthCallback;
        if (!com.baidu.oauth.sdkbqt.a.h.a(com.kuaishou.weapon.p0.g.f4712a, this.i)) {
            throw new IllegalArgumentException("Application requires permission to access the Internet");
        }
        if (BdOauthSdk.getAuthInfo() != null) {
            return true;
        }
        BdOauthResult bdOauthResult = new BdOauthResult();
        bdOauthResult.setResultCode(OauthResult.ERROR_CODE_SDK_NOT_INIT);
        bdOauthCallback.onFailure(bdOauthResult);
        return false;
    }

    private void a(Intent intent, String str) {
        AuthInfo authInfo = BdOauthSdk.getAuthInfo();
        intent.putExtra(e, authInfo.getAppKey());
        intent.putExtra(EXTRA_REDIRECT_URL, authInfo.getRedirectUrl());
        intent.putExtra(EXTRA_SCOPE, authInfo.getScope());
        intent.putExtra(EXTRA_OAUTH_STATE, str);
        intent.putExtra(g, "2.0.6.10");
        intent.putExtra(EXTRA_USE_SHA1_AUTH, authInfo.isUseSha1());
        intent.putExtra(h, "8.8.8");
        this.i.startActivityForResult(intent, 1001);
        HashMap map = new HashMap();
        map.put("oauth_type", "sso");
        com.baidu.oauth.sdkbqt.a.f.a(com.baidu.oauth.sdkbqt.a.f.b, map);
    }

    private void a(String str) {
        a(str, false);
    }

    private void a(String str, boolean z) {
        a(str, z, false);
    }

    private void a(String str, boolean z, boolean z2) {
        new a().a(this.i, BdOauthSdk.getAuthInfo().getDeviceId());
        Intent intent = new Intent(this.i, (Class<?>) WebViewActivity.class);
        intent.putExtra(EXTRA_OAUTH_STATE, str);
        intent.putExtra(EXTRA_DEGRADE_H5_AUTH, z);
        intent.putExtra(EXTRA_DEGRADE_EXEMPT_AUTH_PAGE, z2);
        this.i.startActivityForResult(intent, 1002);
        HashMap map = new HashMap();
        map.put("oauth_type", com.huawei.openalliance.ad.constant.v.B);
        map.put("isDegrade", z ? "1" : "0");
        com.baidu.oauth.sdkbqt.a.f.a(com.baidu.oauth.sdkbqt.a.f.b, map);
    }

    /* JADX WARN: Code duplicated, block: B:70:0x01cf A[Catch: Exception -> 0x0213, TryCatch #5 {Exception -> 0x0213, blocks: (B:68:0x01ae, B:70:0x01cf, B:71:0x01db, B:75:0x01e9), top: B:145:0x01ae }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:74:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:81:0x024c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0250  */
    /* JADX WARN: Code duplicated, block: B:84:0x0254  */
    /* JADX WARN: Code duplicated, block: B:85:0x0258  */
    public void authorizeCallBack(int i, int i2, Intent intent) {
        String str;
        String str2;
        HashMap map;
        JSONObject jSONObject;
        String str3;
        String str4 = "0";
        String stringExtra = intent == null ? "" : intent.getStringExtra(EXTRA_OAUTH_RESULT_JSON);
        String str5 = f1864a;
        com.baidu.oauth.sdkbqt.a.d.a(str5, "authorizeCallBack, requestCode is " + i + " code is " + i2 + " and result is " + stringExtra + ", isInstallBDApp: " + this.n);
        if (i != 1001 && i != 1002 && i != 1003) {
            return;
        }
        if (!this.m) {
            BdOauthResult bdOauthResult = new BdOauthResult();
            this.l = bdOauthResult;
            bdOauthResult.isVisibleAuth = !this.k.isSilent;
        }
        this.l.isInstallBdApp = this.n;
        if (i2 == 0 || intent == null) {
            String str6 = stringExtra;
            boolean zIsEmpty = TextUtils.isEmpty(str6);
            String str7 = OauthResult.ERROR_MSG_USER_REJECT_OPEN_APP;
            if (zIsEmpty) {
                com.baidu.oauth.sdkbqt.a.d.a(str5, "isInstallBDApp: " + this.n + ", ERROR_CODE_USER_REJECT_OPEN_APP");
                this.l.resultSubCode = OauthResult.ERROR_CODE_USER_REJECT_OPEN_APP;
                this.l.resultSubMsg = OauthResult.ERROR_MSG_USER_REJECT_OPEN_APP;
                this.l.allowLaunchAuthApp = false;
                this.l.setResultMsg("");
                this.l.isDegrade = true;
                this.m = true;
                a(this.k.state, true);
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(str6);
                this.l.setResultCode(jSONObject2.optInt("code"));
                if (jSONObject2.has("msg")) {
                    this.l.setResultMsg(jSONObject2.optString("msg"));
                }
            } catch (JSONException e2) {
                com.baidu.oauth.sdkbqt.a.d.d(f1864a, "isInstallBDApp: " + this.n + ", RESULT_CANCELED || json == null, " + e2);
                this.l.setResultCode(!this.n ? OauthResult.ERROR_CODE_NOT_INSTALL_BAIDU_APP : OauthResult.ERROR_CODE_USER_REJECT_OPEN_APP);
            }
            if (!this.m && i == 1001 && this.k.oauthType == 3 && this.l.getResultCode() != -205) {
                try {
                    JSONObject jSONObject3 = new JSONObject(str6);
                    this.l.resultSubCode = jSONObject3.optInt("code");
                    if (jSONObject3.has("msg")) {
                        this.l.resultSubMsg = jSONObject3.optString("msg");
                    }
                    if (jSONObject3.has("showLogin")) {
                        this.l.isVisibleAuth = "1".equals(jSONObject3.optString("showLogin"));
                    }
                    this.l.setResultMsg("");
                } catch (JSONException e3) {
                    com.baidu.oauth.sdkbqt.a.d.d(f1864a, "first InProgress," + e3);
                    this.l.resultSubCode = !this.n ? OauthResult.ERROR_CODE_NOT_INSTALL_BAIDU_APP : OauthResult.ERROR_CODE_USER_REJECT_OPEN_APP;
                    BdOauthResult bdOauthResult2 = this.l;
                    if (!this.n) {
                        str7 = OauthResult.ERROR_MSG_NOT_INSTALL_BAIDU_APP;
                    }
                    bdOauthResult2.resultSubMsg = str7;
                }
                this.l.isDegrade = true;
                a(this.k.state, true);
                this.m = true;
                return;
            }
            this.j.onFailure(this.l);
            this.m = false;
            HashMap map2 = new HashMap();
            if (i == 1001) {
                map2.put("oauth_type", "sso");
            } else if (i == 1002) {
                map2.put("oauth_type", com.huawei.openalliance.ad.constant.v.B);
            } else {
                map2.put("oauth_type", "qr_code");
            }
            map2.put("code", this.l.getResultCode() + "");
            map2.put("msg", this.l.getResultMsg());
            com.baidu.oauth.sdkbqt.a.f.a(com.baidu.oauth.sdkbqt.a.f.d, map2);
            com.baidu.oauth.sdkbqt.a.d.a(f1864a, "authorizeCallBack, Activity.RESULT_CANCELED, onFailure, result " + this.l.toString());
            return;
        }
        if (i2 != -1) {
            return;
        }
        if (i == 1001 && this.k.oauthType == 3) {
            this.l.isVisibleAuth = true;
        }
        try {
            JSONObject jSONObject4 = new JSONObject(stringExtra);
            String strOptString = jSONObject4.optString(com.huawei.openalliance.ad.constant.x.df);
            String strOptString2 = jSONObject4.optString("code");
            str = stringExtra;
            if (i == 1001) {
                try {
                    str3 = "code";
                    if (this.k.oauthType == 3) {
                        try {
                            this.l.isPassNewVersion = jSONObject4.has("showLogin");
                        } catch (JSONException e4) {
                            e = e4;
                            str2 = str3;
                            com.baidu.oauth.sdkbqt.a.d.a(e);
                            try {
                                jSONObject = new JSONObject(str);
                                this.l.setCode(jSONObject.optString(str2));
                                this.l.setState(jSONObject.optString("state"));
                                if (jSONObject.has("showLogin")) {
                                    this.l.isVisibleAuth = "1".equals(jSONObject.optString("showLogin"));
                                }
                                BdOauthResult bdOauthResult3 = this.l;
                                if ("1".equals(jSONObject.optString("showLogin"))) {
                                    str4 = "1";
                                }
                                bdOauthResult3.loginStateBeforeAuth = str4;
                                this.l.loginStateAfterAuth = jSONObject.optString("finishLogin");
                                this.l.appVersion = jSONObject.optString("app_version");
                                this.l.passSdkVersion = jSONObject.optString("pass_sdk_version");
                                this.l.setResultCode(0);
                                this.j.onSuccess(this.l);
                            } catch (Exception e5) {
                                com.baidu.oauth.sdkbqt.a.d.a(e5);
                                this.l.setResultCode(OauthResult.ERROR_CODE_UNKNOW_ERROR);
                                this.j.onFailure(this.l);
                            }
                            com.baidu.oauth.sdkbqt.a.d.a(f1864a, "authorizeCallBack, Activity.RESULT_OK, code = " + this.l.toString());
                            map = new HashMap();
                            if (i == 1001) {
                                map.put("oauth_type", "sso");
                            } else if (i == 1002) {
                                map.put("oauth_type", com.huawei.openalliance.ad.constant.v.B);
                            } else {
                                map.put("oauth_type", "qr_code");
                            }
                            com.baidu.oauth.sdkbqt.a.f.a(com.baidu.oauth.sdkbqt.a.f.c, map);
                        }
                    }
                } catch (JSONException e6) {
                    e = e6;
                    str3 = "code";
                    str2 = str3;
                    com.baidu.oauth.sdkbqt.a.d.a(e);
                    jSONObject = new JSONObject(str);
                    this.l.setCode(jSONObject.optString(str2));
                    this.l.setState(jSONObject.optString("state"));
                    if (jSONObject.has("showLogin")) {
                        this.l.isVisibleAuth = "1".equals(jSONObject.optString("showLogin"));
                    }
                    BdOauthResult bdOauthResult4 = this.l;
                    if ("1".equals(jSONObject.optString("showLogin"))) {
                        str4 = "1";
                    }
                    bdOauthResult4.loginStateBeforeAuth = str4;
                    this.l.loginStateAfterAuth = jSONObject.optString("finishLogin");
                    this.l.appVersion = jSONObject.optString("app_version");
                    this.l.passSdkVersion = jSONObject.optString("pass_sdk_version");
                    this.l.setResultCode(0);
                    this.j.onSuccess(this.l);
                    com.baidu.oauth.sdkbqt.a.d.a(f1864a, "authorizeCallBack, Activity.RESULT_OK, code = " + this.l.toString());
                    map = new HashMap();
                    if (i == 1001) {
                        map.put("oauth_type", "sso");
                    } else if (i == 1002) {
                        map.put("oauth_type", com.huawei.openalliance.ad.constant.v.B);
                    } else {
                        map.put("oauth_type", "qr_code");
                    }
                    com.baidu.oauth.sdkbqt.a.f.a(com.baidu.oauth.sdkbqt.a.f.c, map);
                }
            } else {
                str3 = "code";
            }
            if (jSONObject4.has("showLogin")) {
                this.l.isVisibleAuth = "1".equals(jSONObject4.optString("showLogin"));
            }
            if ("1".equals(jSONObject4.optString("showLogin"))) {
                this.l.loginStateBeforeAuth = "0";
            } else {
                this.l.loginStateBeforeAuth = "1";
            }
            this.l.loginStateAfterAuth = jSONObject4.optString("finishLogin");
            this.l.appVersion = jSONObject4.optString("app_version");
            this.l.passSdkVersion = jSONObject4.optString("pass_sdk_version");
            if (!TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString2)) {
                this.l.setResultCode(-208);
                this.j.onFailure(this.l);
                HashMap map3 = new HashMap();
                if (i == 1001) {
                    map3.put("oauth_type", "sso");
                } else if (i == 1002) {
                    map3.put("oauth_type", com.huawei.openalliance.ad.constant.v.B);
                } else {
                    map3.put("oauth_type", "qr_code");
                }
                str2 = str3;
                try {
                    map3.put(str2, this.l.getResultCode() + "");
                    map3.put("msg", this.l.getResultMsg());
                    com.baidu.oauth.sdkbqt.a.f.a(com.baidu.oauth.sdkbqt.a.f.d, map3);
                    com.baidu.oauth.sdkbqt.a.d.a(str5, "authorizeCallBack, Activity.RESULT_OK, onFailure lowPass, result " + this.l.toString());
                    return;
                } catch (JSONException e7) {
                    e = e7;
                    com.baidu.oauth.sdkbqt.a.d.a(e);
                    jSONObject = new JSONObject(str);
                    this.l.setCode(jSONObject.optString(str2));
                    this.l.setState(jSONObject.optString("state"));
                    if (jSONObject.has("showLogin")) {
                        this.l.isVisibleAuth = "1".equals(jSONObject.optString("showLogin"));
                    }
                    BdOauthResult bdOauthResult5 = this.l;
                    if ("1".equals(jSONObject.optString("showLogin"))) {
                        str4 = "1";
                    }
                    bdOauthResult5.loginStateBeforeAuth = str4;
                    this.l.loginStateAfterAuth = jSONObject.optString("finishLogin");
                    this.l.appVersion = jSONObject.optString("app_version");
                    this.l.passSdkVersion = jSONObject.optString("pass_sdk_version");
                    this.l.setResultCode(0);
                    this.j.onSuccess(this.l);
                    com.baidu.oauth.sdkbqt.a.d.a(f1864a, "authorizeCallBack, Activity.RESULT_OK, code = " + this.l.toString());
                    map = new HashMap();
                    if (i == 1001) {
                        map.put("oauth_type", "sso");
                    } else if (i == 1002) {
                        map.put("oauth_type", com.huawei.openalliance.ad.constant.v.B);
                    } else {
                        map.put("oauth_type", "qr_code");
                    }
                    com.baidu.oauth.sdkbqt.a.f.a(com.baidu.oauth.sdkbqt.a.f.c, map);
                }
            }
            str2 = str3;
            jSONObject = new JSONObject(str);
            this.l.setCode(jSONObject.optString(str2));
            this.l.setState(jSONObject.optString("state"));
            if (jSONObject.has("showLogin")) {
                this.l.isVisibleAuth = "1".equals(jSONObject.optString("showLogin"));
            }
            BdOauthResult bdOauthResult6 = this.l;
            if ("1".equals(jSONObject.optString("showLogin"))) {
                str4 = "1";
            }
            bdOauthResult6.loginStateBeforeAuth = str4;
            this.l.loginStateAfterAuth = jSONObject.optString("finishLogin");
            this.l.appVersion = jSONObject.optString("app_version");
            this.l.passSdkVersion = jSONObject.optString("pass_sdk_version");
            this.l.setResultCode(0);
            this.j.onSuccess(this.l);
            com.baidu.oauth.sdkbqt.a.d.a(f1864a, "authorizeCallBack, Activity.RESULT_OK, code = " + this.l.toString());
            map = new HashMap();
            if (i == 1001) {
                map.put("oauth_type", "sso");
            } else if (i == 1002) {
                map.put("oauth_type", com.huawei.openalliance.ad.constant.v.B);
            } else {
                map.put("oauth_type", "qr_code");
            }
            com.baidu.oauth.sdkbqt.a.f.a(com.baidu.oauth.sdkbqt.a.f.c, map);
        } catch (JSONException e8) {
            e = e8;
            str = stringExtra;
            str2 = "code";
        }
    }

    private void a(String str, String str2) {
        new a().a(this.i, BdOauthSdk.getAuthInfo().getDeviceId());
        Intent intent = new Intent(this.i, (Class<?>) WebViewActivity.class);
        intent.putExtra(EXTRA_GUID_TYPE, 1);
        intent.putExtra(EXTRA_REDIRECT_URL, str);
        intent.putExtra(EXTRA_QR_CODE_URL, str2);
        this.i.startActivityForResult(intent, 1002);
    }
}
