package com.baidu.oauth.sdkbqt.auth;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.passbqt.common.SecurityUtil;
import com.huawei.openalliance.ad.constant.ba;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class h {
    h() {
    }

    Intent a(Context context, HashMap<String, String> map, boolean z) {
        String strB = com.baidu.oauth.sdkbqt.a.h.b(z ? com.baidu.oauth.sdkbqt.a.b.c : com.baidu.oauth.sdkbqt.a.b.b);
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent(strB), 32);
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() != 0) {
            ArrayList<Intent> arrayList = new ArrayList();
            try {
                for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                    String str = resolveInfo.activityInfo.permission;
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    Intent intent = new Intent(strB);
                    intent.setClassName(((ComponentInfo) activityInfo).packageName, ((ComponentInfo) activityInfo).name);
                    intent.addFlags(32);
                    if (TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) == 0) {
                        if (a(context, intent.getComponent().getPackageName()) && !context.getPackageName().equals(intent.getComponent().getPackageName())) {
                            arrayList.add(intent);
                        }
                    }
                }
                for (String str2 : map.keySet()) {
                    for (Intent intent2 : arrayList) {
                        String packageName = intent2.getComponent().getPackageName();
                        if (!TextUtils.isEmpty(packageName) && packageName.matches(str2)) {
                            return intent2;
                        }
                    }
                }
            } catch (Throwable th) {
                com.baidu.oauth.sdkbqt.a.d.a(th);
            }
        }
        return null;
    }

    private boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            LinkedHashMap<String, String> linkedHashMap = com.baidu.oauth.sdkbqt.a.b.d;
            String strA = com.baidu.oauth.sdkbqt.a.h.a(context, str);
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            for (String str2 : linkedHashMap.keySet()) {
                if (str.matches(str2) && strA.equals(linkedHashMap.get(str2))) {
                    return true;
                }
            }
        }
        return false;
    }

    String a(Long l) {
        AuthInfo authInfo = BdOauthSdk.getAuthInfo();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "native");
            jSONObject.put(com.alipay.sdk.tid.b.f, l);
            jSONObject.put("host_api_key", authInfo.getAppKey());
            jSONObject.put("host_pkgname", authInfo.getPackageName());
            jSONObject.put("host_key_hash", authInfo.getPackSign());
            jSONObject.put("bduss_sign", SecurityUtil.a(new a().a(authInfo.getContext()).getBytes(), false));
            jSONObject.put(ba.z, authInfo.getPackageName());
            jSONObject.put("key_hash", authInfo.getPackSign());
            jSONObject.put("app_id", authInfo.getAppKey());
        } catch (JSONException e) {
            com.baidu.oauth.sdkbqt.a.d.a(e);
        }
        String strA = SecurityUtil.a(("as#JU*342ns" + authInfo.getAppKey() + "#$FW34sfs").getBytes(), false);
        try {
            return com.baidu.oauth.sdkbqt.a.h.a(new com.baidu.oauth.sdkbqt.a.a().a(jSONObject.toString(), strA.substring(0, 16), new StringBuffer(strA.substring(strA.length() - 16, strA.length())).reverse().toString()));
        } catch (Exception e2) {
            com.baidu.oauth.sdkbqt.a.d.a(e2);
            return "";
        }
    }
}
