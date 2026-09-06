package com.yfanads.android.utils;

import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.ba;
import com.yfanads.android.libs.net.NetCallBack;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.net.UrlHttpUtil;
import com.yfanads.android.libs.thirdpart.gson.GsonBuilder;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.FeedCom;
import java.net.URLEncoder;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class RouterMgr<T> {
    private String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUPSuccess(Context context) {
        if (context != null) {
            try {
                ((Vibrator) context.getSystemService("vibrator")).vibrate(200L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void routerWebView(final Context context, T t, FeedCom feedCom) {
        try {
            if (t == null) {
                YFLog.warn("routerWebView source is null");
                return;
            }
            String json = new GsonBuilder().create().toJson(t);
            HashMap map = new HashMap();
            map.put(YFAdsConst.REPORT_DEV_ID, feedCom.devID);
            map.put(YFAdsConst.REPORT_APPID, feedCom.appID);
            map.put("adID", feedCom.adID);
            map.put("reqID", feedCom.reqID);
            map.put(ba.at, encode(Util.encryptAES7ByShort(json, UrlConst.getKey())));
            UrlHttpUtil.postJson(UrlConst.getTraceUrl(), new GsonBuilder().create().toJson(map), null, new NetCallBack.NetCallBackString(true, false) { // from class: com.yfanads.android.utils.RouterMgr.1
                @Override // com.yfanads.android.libs.net.NetCallBack
                /* JADX INFO: renamed from: onFailure */
                public void m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(int i, String str) {
                }

                @Override // com.yfanads.android.libs.net.NetCallBack
                /* JADX INFO: renamed from: onResponse, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(String str) {
                    RouterMgr.this.onUPSuccess(context);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
