package com.byazt.qg;

import android.webkit.JavascriptInterface;
import androidx.core.app.NotificationCompat;
import com.byazt.nl.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.icbc.paysdk.webview.ICBCWebChromeClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 13})
public final class tt extends c {
    public final com.byazt.nl.tt c;
    public final WebViewImpl tt;

    public tt(Object obj, String str, com.byazt.nl.tt ttVar, WebViewImpl webViewImpl) {
        super(obj, str);
        this.c = ttVar;
        this.tt = webViewImpl;
    }

    private boolean c(JSONObject jSONObject) {
        JSONObject jSONObjectTt = tt(jSONObject, "addWebviewListener");
        if (jSONObjectTt == null) {
            return false;
        }
        String strOptString = jSONObjectTt.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null || strOptString.length() <= 0) {
            return true;
        }
        this.c.c(this.tt, strOptString);
        com.byazt.nl.c.c(this.tt, strOptString);
        return true;
    }

    private boolean tt(JSONObject jSONObject) {
        JSONObject jSONObjectTt = tt(jSONObject, "removeWebviewListener");
        if (jSONObjectTt == null) {
            return false;
        }
        String strOptString = jSONObjectTt.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null || strOptString.length() <= 0) {
            return true;
        }
        this.c.tt(this.tt, strOptString);
        com.byazt.nl.c.tt(this.tt, strOptString);
        return true;
    }

    private boolean ve(JSONObject jSONObject) {
        JSONObject jSONObjectTt = tt(jSONObject, "sendWebviewEvent");
        if (jSONObjectTt == null) {
            return false;
        }
        String strOptString = jSONObjectTt.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null) {
            return true;
        }
        Object objOpt = jSONObjectTt.opt("param");
        this.c.c(this.tt, tt(), strOptString, objOpt);
        com.byazt.nl.c.c(this.tt, tt(), strOptString, objOpt);
        return true;
    }

    @Override // com.byazt.qg.c
    @JavascriptInterface
    public Object invokeMethod(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            if (str.contains("popWebview")) {
                if (n(new JSONObject(str))) {
                    return null;
                }
            } else if (str.contains("pushWebview")) {
                if (uj(new JSONObject(str))) {
                    return null;
                }
            } else if (str.contains("addWebviewListener")) {
                if (c(new JSONObject(str))) {
                    return null;
                }
            } else if (str.contains("removeWebviewListener")) {
                if (tt(new JSONObject(str))) {
                    return null;
                }
            } else {
                if (str.contains("sendWebviewEvent")) {
                    if (ve(new JSONObject(str))) {
                        return null;
                    }
                }
                return super.invokeMethod(str);
            }
        } catch (JSONException unused) {
        }
        return super.invokeMethod(str);
    }

    private boolean uj(JSONObject jSONObject) {
        JSONObject jSONObjectTt = tt(jSONObject, "pushWebview");
        if (jSONObjectTt == null) {
            return false;
        }
        int iC = this.c.c(jSONObjectTt.optString("url"));
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(iC));
            jSONObject2.putOpt("result", Boolean.valueOf(iC == 0));
        } catch (Exception unused) {
        }
        this.tt.c(tt(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean n(JSONObject jSONObject) {
        if (!c(jSONObject, "popWebview")) {
            return false;
        }
        uj ujVarC = this.c.c();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(ujVarC == null ? 1 : 0));
            jSONObject2.putOpt("result", Boolean.valueOf(ujVarC != null));
        } catch (Exception unused) {
        }
        this.tt.c(tt(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean c(JSONObject jSONObject, String str) {
        return jSONObject.optString(ICBCWebChromeClient.JAVASCRIPT_COMMON_VALUE_FUNCTION).equals(str);
    }

    private JSONObject tt(JSONObject jSONObject, String str) {
        if (c(jSONObject, str)) {
            return jSONObject.optJSONObject("params");
        }
        return null;
    }
}
