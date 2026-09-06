package com.masget.base.volley;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.masget.base.URLConfig;
import com.masget.base.UnionBaseApplication;
import com.masget.base.bean.Constants;
import com.masget.base.util.CyptoUtils;
import com.masget.base.util.EncryptUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class VolleyRequest {
    private static final String BASE_URL = "http://gw.masget.com:7086/posrouter/";
    private static final String HOST = "http://gw.masget.com:7086/posrouter/";
    private static final int MAX_RETRIES = 2;
    private static final String TAG = "VolleyRequest";
    private static final int TIME_OUT = 45000;

    public static void postJson(boolean z, String str, Map<String, Object> map, final JSONResponseHandler jSONResponseHandler) {
        JSONObject jSONObject;
        if (z) {
            jSONObject = new JSONObject(encryptParams(map, 1));
        } else {
            jSONObject = new JSONObject(map);
        }
        HttpsTrustManager.allowAllSSL();
        if (isNetworkAvailable()) {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, URLConfig.BASE_POSROUTER_URL + str, jSONObject, new Response.Listener<JSONObject>() { // from class: com.masget.base.volley.VolleyRequest.1
                @Override // com.android.volley.Response.Listener
                public void onResponse(JSONObject jSONObject2) {
                    jSONResponseHandler.onSuccess(jSONObject2);
                }
            }, new Response.ErrorListener() { // from class: com.masget.base.volley.VolleyRequest.2
                @Override // com.android.volley.Response.ErrorListener
                public void onErrorResponse(VolleyError volleyError) {
                    jSONResponseHandler.onFail(volleyError);
                }
            }) { // from class: com.masget.base.volley.VolleyRequest.3
                @Override // com.android.volley.Request
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap map2 = new HashMap();
                    map2.put("Accept-Language", Locale.getDefault().toString());
                    map2.put("Host", URLConfig.BASE_POSROUTER_URL);
                    map2.put("Connection", "Keep-Alive");
                    return map2;
                }
            };
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT, 2, 1.0f));
            UnionBaseApplication.getInstance().addToRequestQueue(jsonObjectRequest, str);
            return;
        }
        jSONResponseHandler.onFail(new VolleyError("网络不可用"));
    }

    public static void postJson(String str, String str2, Map<String, Object> map, final JSONResponseHandler jSONResponseHandler) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, URLConfig.BASE_POSROUTER_URL + str2, new JSONObject(encryptParams(map, 1)), new Response.Listener<JSONObject>() { // from class: com.masget.base.volley.VolleyRequest.4
            @Override // com.android.volley.Response.Listener
            public void onResponse(JSONObject jSONObject) {
                jSONResponseHandler.onSuccess(jSONObject);
            }
        }, new Response.ErrorListener() { // from class: com.masget.base.volley.VolleyRequest.5
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                jSONResponseHandler.onFail(volleyError);
            }
        }) { // from class: com.masget.base.volley.VolleyRequest.6
        };
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT, 2, 1.0f));
        UnionBaseApplication.getInstance().addToRequestQueue(jsonObjectRequest, str2);
    }

    public static void getJson(String str, Map<String, Object> map, final JSONResponseHandler jSONResponseHandler) {
        String strInitGetUrl = initGetUrl(str, map);
        if (isNetworkAvailable()) {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(0, strInitGetUrl, new Response.Listener<JSONObject>() { // from class: com.masget.base.volley.VolleyRequest.7
                @Override // com.android.volley.Response.Listener
                public void onResponse(JSONObject jSONObject) {
                    jSONResponseHandler.onSuccess(jSONObject);
                }
            }, new Response.ErrorListener() { // from class: com.masget.base.volley.VolleyRequest.8
                @Override // com.android.volley.Response.ErrorListener
                public void onErrorResponse(VolleyError volleyError) {
                    jSONResponseHandler.onFail(volleyError);
                }
            }) { // from class: com.masget.base.volley.VolleyRequest.9
            };
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT, 2, 1.0f));
            UnionBaseApplication.getInstance().addToRequestQueue(jsonObjectRequest, str);
            return;
        }
        jSONResponseHandler.onFail(new VolleyError("网络不可用"));
    }

    public static void postString(String str, final Map<String, Object> map, final StringResponseHandler stringResponseHandler) {
        StringRequest stringRequest = new StringRequest(1, URLConfig.BASE_POSROUTER_URL + str, new Response.Listener<String>() { // from class: com.masget.base.volley.VolleyRequest.10
            @Override // com.android.volley.Response.Listener
            public void onResponse(String str2) {
                stringResponseHandler.onSuccess(str2);
            }
        }, new Response.ErrorListener() { // from class: com.masget.base.volley.VolleyRequest.11
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                stringResponseHandler.onFail(volleyError);
            }
        }) { // from class: com.masget.base.volley.VolleyRequest.12
            @Override // com.android.volley.Request
            protected Map<String, String> getParams() throws AuthFailureError {
                return VolleyRequest.encryptParams(map, 1);
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT, 2, 1.0f));
        UnionBaseApplication.getInstance().addToRequestQueue(stringRequest, str);
    }

    public static void getString(String str, Map<String, Object> map, final StringResponseHandler stringResponseHandler) {
        StringRequest stringRequest = new StringRequest(0, initGetUrl(str, map), new Response.Listener<String>() { // from class: com.masget.base.volley.VolleyRequest.13
            @Override // com.android.volley.Response.Listener
            public void onResponse(String str2) {
                stringResponseHandler.onSuccess(str2);
            }
        }, new Response.ErrorListener() { // from class: com.masget.base.volley.VolleyRequest.14
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                stringResponseHandler.onFail(volleyError);
            }
        }) { // from class: com.masget.base.volley.VolleyRequest.15
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT, 2, 1.0f));
        UnionBaseApplication.getInstance().addToRequestQueue(stringRequest, str);
    }

    private static String initGetUrl(String str, Map<String, Object> map) {
        Map<String, String> mapEncryptParams = encryptParams(map, 1);
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
            return URLConfig.BASE_POSROUTER_URL + str + sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String initGetUrl(String str, String str2, Map<String, Object> map) {
        Map<String, String> mapEncryptParams = encryptParams(map, 2);
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
            return str + str2 + sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> encryptParams(Map<String, Object> map, int i) {
        String strBase64Encrypt;
        JSONObject jSONObject = new JSONObject(map);
        String strString2MD5 = "";
        if (i == 1) {
            strBase64Encrypt = EncryptUtil.aesEncrypt(jSONObject.toString(), Constants.AES_KEY, Constants.AES_KEY);
        } else {
            strBase64Encrypt = i == 2 ? EncryptUtil.base64Encrypt(jSONObject.toString()) : "";
        }
        if (i == 1) {
            strString2MD5 = EncryptUtil.string2MD5(strBase64Encrypt + Constants.AES_KEY);
        } else if (i == 2) {
            strString2MD5 = EncryptUtil.string2MD5(strBase64Encrypt + "masget");
        }
        HashMap map2 = new HashMap();
        map2.put("data", strBase64Encrypt);
        map2.put("sign", strString2MD5);
        if (i == 2) {
            map2.put("redirectflag", "1");
        }
        return map2;
    }

    public String getEncrtResult(boolean z, String str, String str2) {
        if (!z) {
            try {
                return new String(new Base64().encode(str.getBytes("utf-8")), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
        try {
            return CyptoUtils.AesEncrypt(str, str2, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) UnionBaseApplication.getInstance().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        activeNetworkInfo.getTypeName();
        return true;
    }
}
