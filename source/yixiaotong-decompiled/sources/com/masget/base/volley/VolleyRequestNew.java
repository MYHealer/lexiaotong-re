package com.masget.base.volley;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import client.android.yixiaotong.util.TimeUtils;
import com.alipay.sdk.tid.b;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.masget.base.AppConfig;
import com.masget.base.URLConfig;
import com.masget.base.UnionBaseApplication;
import com.masget.base.bean.Constants;
import com.masget.base.util.CommonUtil;
import com.masget.base.util.CyptoUtils;
import com.masget.base.util.EncryptUtil;
import com.umeng.analytics.pro.d;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class VolleyRequestNew {
    private static final String BASE_URL = "https://gw.masget.com:17373/openapi/rest";
    private static final String HOST = "https://gw.masget.com:17373/openapi/rest";
    public static final int INVALID_REQUEST_TIME = -1;
    private static final String TAG = "VolleyRequestNew";
    private static final int TIME_OUT = 45000;
    public static final String URL_UPLOAD_IMAGE = "http://app.masget.com/masgetweb/base/fileUpload.do";
    private static Gson gson = new Gson();
    private static long lastRequestTime = -1;

    public static void postJson(boolean z, String str, Map<String, Object> map, final JSONResponseHandler jSONResponseHandler) {
        String str2 = TAG;
        Log.e(str2, "---start---- ");
        lastRequestTime = System.currentTimeMillis();
        if (map == null) {
            map = new HashMap<>();
        }
        String json = gson.toJson(map);
        Log.e(str2, "post Json  request url: https://gw.masget.com:17373/openapi/rest" + str + json + "\nisEncrypt: " + z);
        String string = map.get("unionSession").toString();
        String string2 = map.get("unionAppKey").toString();
        String string3 = map.get("companyid").toString();
        Log.e(str2, "session+appKey=" + string + "  " + string2);
        if (string == null || string2 == null || string3 == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(getRequestParams(z, getEncryptResult(z, json, string2), str, string, string2, string3));
        Log.e(str2, "post Json  request url: https://gw.masget.com:17373/openapi/rest" + jSONObject.toString());
        HttpsTrustManager.allowAllSSL();
        if (isNetworkAvailable()) {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, URLConfig.API_URL, jSONObject, new Response.Listener<JSONObject>() { // from class: com.masget.base.volley.VolleyRequestNew.1
                @Override // com.android.volley.Response.Listener
                public void onResponse(JSONObject jSONObject2) {
                    jSONResponseHandler.onSuccess(jSONObject2);
                }
            }, new Response.ErrorListener() { // from class: com.masget.base.volley.VolleyRequestNew.2
                @Override // com.android.volley.Response.ErrorListener
                public void onErrorResponse(VolleyError volleyError) {
                    if ((volleyError.getCause() instanceof SocketTimeoutException) || (volleyError.getCause() instanceof ConnectException)) {
                        jSONResponseHandler.onFail(new VolleyError("连接超时"));
                    } else {
                        jSONResponseHandler.onFail(volleyError);
                    }
                }
            }) { // from class: com.masget.base.volley.VolleyRequestNew.3
                @Override // com.android.volley.Request
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap map2 = new HashMap();
                    map2.put("Accept-Language", Locale.getDefault().toString());
                    map2.put("accept", "*/*");
                    map2.put("Connection", "Keep-Alive");
                    map2.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;DigExt)");
                    return map2;
                }
            };
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT, 0, 1.0f));
            UnionBaseApplication.getInstance().addToRequestQueue(jsonObjectRequest, str);
            Log.e(str2, "---end----");
            return;
        }
        jSONResponseHandler.onFail(new VolleyError("网络不可用"));
    }

    public static void getString(String str, Map<String, Object> map, final StringResponseHandler stringResponseHandler) {
        lastRequestTime = System.currentTimeMillis();
        String str2 = TAG;
        Log.e(str2, "get string  request url: https://gw.masget.com:17373/openapi/rest" + str);
        Log.e(str2, "getString  request url: https://gw.masget.com:17373/openapi/rest\nrequest  params: " + gson.toJson(map));
        StringRequest stringRequest = new StringRequest(0, initGetUrl(str, map), new Response.Listener<String>() { // from class: com.masget.base.volley.VolleyRequestNew.4
            @Override // com.android.volley.Response.Listener
            public void onResponse(String str3) {
                stringResponseHandler.onSuccess(str3);
            }
        }, new Response.ErrorListener() { // from class: com.masget.base.volley.VolleyRequestNew.5
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                stringResponseHandler.onFail(volleyError);
            }
        }) { // from class: com.masget.base.volley.VolleyRequestNew.6
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT, 0, 1.0f));
        UnionBaseApplication.getInstance().addToRequestQueue(stringRequest, str);
    }

    private static String initGetUrl(String str, Map<String, Object> map) {
        Map<String, String> mapEncryptParams = encryptParams(map);
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        try {
            for (Map.Entry<String, String> entry : mapEncryptParams.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
            return URLConfig.API_URL + str + sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private static Map<String, String> encryptParams(Map<String, Object> map) {
        String strAesEncrypt = EncryptUtil.aesEncrypt(gson.toJson(map), Constants.AES_KEY, Constants.AES_KEY);
        String strString2MD5 = EncryptUtil.string2MD5(strAesEncrypt + Constants.AES_KEY);
        HashMap map2 = new HashMap();
        map2.put("data", strAesEncrypt);
        map2.put("sign", strString2MD5);
        return map2;
    }

    private static String getEncryptResult(boolean z, String str, String str2) {
        String str3 = AppConfig.DEFAULT_APPKEY;
        if (!z) {
            str2 = AppConfig.DEFAULT_APPKEY;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                str3 = str2;
            }
            return CyptoUtils.AesEncrypt(str, str3, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static Map<String, String> getRequestParams(boolean z, String str, String str2, String str3, String str4, String str5) {
        HashMap map = new HashMap();
        if (!z) {
            str4 = AppConfig.DEFAULT_APPKEY;
        }
        if (!z) {
            str5 = AppConfig.APP_ID;
        }
        map.put("data", str);
        map.put("method", str2);
        map.put("appid", str5);
        map.put("format", AppConfig.FORMAT);
        map.put("v", AppConfig.OPEN_API_VERSION);
        String currentTime = CommonUtil.getCurrentTime(TimeUtils.FORMATDATETIME);
        map.put(b.f, currentTime);
        if (!z) {
            str3 = "";
        }
        map.put("sign", CyptoUtils.string2MD5(str4 + str5 + str + AppConfig.FORMAT + str2 + CommonUtil.filterNull(str3) + currentTime + AppConfig.OPEN_API_VERSION + str4).toLowerCase());
        if (z) {
            map.put(d.aw, str3);
        }
        return map;
    }

    private static boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) UnionBaseApplication.getInstance().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        activeNetworkInfo.getTypeName();
        return true;
    }

    public static String postUrlEncrypt(String str, Map<String, Object> map, boolean z) {
        String json = gson.toJson(map);
        String string = map.get("unionSession").toString();
        String string2 = map.get("unionAppKey").toString();
        String string3 = map.get("companyid").toString();
        String str2 = TAG;
        Log.e(str2, "session+appKey=" + string + "  " + string2);
        Log.e(str2, "postUrlEncrypt post params:" + map.toString());
        if (string == null || string2 == null || string3 == null) {
            return null;
        }
        Map<String, String> requestParams = getRequestParams(z, getEncryptResult(z, json, string2), str, string, string2, string3);
        StringBuilder sb = new StringBuilder();
        sb.append("https://gw.masget.com:17373/openapi/rest?redirectflag=1&");
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            sb.append(entry.getKey()).append('=').append(entry.getValue()).append(Typography.amp);
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
