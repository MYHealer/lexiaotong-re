package com.icbc.paysdk.httpclient;

import android.util.Log;
import com.alipay.sdk.tid.b;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.icbc.paysdk.constants.Constants;
import com.icbc.paysdk.model.ThirdPayReq;
import com.icbc.paysdk.model.UnionPayReq;
import cz.msebera.android.httpclient.params.CoreConnectionPNames;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ListHttpAPI {
    public static String PAY_LIST_URL = new Constants().PAY_LIST_URL;

    public byte[] post(String str) {
        HashMap map = new HashMap();
        if (str == null) {
            map.put("openFlag", Constants.openFlag);
        } else {
            map.put("openFlag", str);
        }
        return sendHttpClientPost(new Constants().PAY_LIST_URL, map, "utf-8");
    }

    public byte[] postOrderRequest(ThirdPayReq thirdPayReq) {
        HashMap map = new HashMap();
        map.put(Constants.InterfaceName, thirdPayReq.getInterfaceName());
        map.put(Constants.InterfaceVersion, thirdPayReq.getInterfaceVersion());
        map.put("tranData", thirdPayReq.getTranData());
        map.put("merSignMsg", thirdPayReq.getMerSignMsg());
        map.put("merCert", thirdPayReq.getMerCert());
        map.put("clientType", thirdPayReq.getClientType());
        Log.i(Constants.LogFlag, new Constants().Start_B2C_URL + PPSLabelView.Code + map);
        return sendHttpClientPost(new Constants().SDK_URL, map, "utf-8");
    }

    public String postSdkRequest(UnionPayReq unionPayReq) {
        HashMap map = new HashMap();
        map.put("app_id", unionPayReq.getAppId());
        map.put("msg_id", unionPayReq.getMsgId());
        if (unionPayReq.getFormat() != null && !"".equals(unionPayReq.getFormat())) {
            map.put("format", unionPayReq.getFormat());
        }
        if (unionPayReq.getCharset() != null && !"".equals(unionPayReq.getCharset())) {
            map.put("charset", unionPayReq.getCharset());
        } else {
            map.put("charset", "UTF-8");
        }
        if (unionPayReq.getSignType() != null && !"".equals(unionPayReq.getSignType())) {
            map.put("sign_type", unionPayReq.getSignType());
        } else {
            map.put("sign_type", "RSA");
        }
        map.put("sign", unionPayReq.getSign());
        map.put(b.f, unionPayReq.getTimestamp());
        String ca = unionPayReq.getCa();
        if (ca != null && !"".equals(ca)) {
            map.put("ca", ca);
        }
        map.put("biz_content", unionPayReq.getBizContent());
        Log.i(Constants.LogFlag, "params: ===========================" + map);
        return sendSdkPost(new Constants().SDK_URL, map, "utf-8");
    }

    public byte[] getThirdPayList(String str) {
        HashMap map = new HashMap();
        map.put("merID", str);
        Log.i(Constants.LogFlag, new Constants().THIRDPAYLIST_URL + PPSLabelView.Code + map);
        return sendHttpClientPost(new Constants().THIRDPAYLIST_URL, map, "utf-8");
    }

    private byte[] sendHttpClientPost(String str, Map<String, String> map, String str2) {
        HttpClient newHttpClient = new Util().getNewHttpClient();
        newHttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        try {
            try {
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, str2);
                HttpPost httpPost = new HttpPost(str);
                httpPost.setEntity(urlEncodedFormEntity);
                HttpResponse httpResponseExecute = newHttpClient.execute(httpPost);
                if (httpResponseExecute.getStatusLine().getStatusCode() != 200) {
                    Log.i(Constants.LogFlag, "httpGet fail, status code = " + httpResponseExecute.getStatusLine().getStatusCode());
                    return null;
                }
                return EntityUtils.toByteArray(httpResponseExecute.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            newHttpClient.getConnectionManager().shutdown();
        }
    }

    private String sendSdkPost(String str, Map<String, String> map, String str2) {
        HttpClient newHttpClient = new Util().getNewHttpClient();
        newHttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        try {
            try {
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, str2);
                HttpPost httpPost = new HttpPost(str);
                httpPost.setEntity(urlEncodedFormEntity);
                HttpResponse httpResponseExecute = newHttpClient.execute(httpPost);
                Log.d(Constants.LogFlag, "httpPost: " + httpPost.toString());
                if (httpResponseExecute.getStatusLine().getStatusCode() != 200) {
                    Log.i(Constants.LogFlag, "httpGet fail, status code = " + httpResponseExecute.getStatusLine().getStatusCode());
                    return null;
                }
                return EntityUtils.toString(httpResponseExecute.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            newHttpClient.getConnectionManager().shutdown();
        }
    }

    public byte[] postOrderRequestV2(UnionPayReq unionPayReq) {
        HashMap map = new HashMap();
        map.put("app_id", unionPayReq.getAppId());
        map.put("msg_id", unionPayReq.getMsgId());
        if (unionPayReq.getFormat() != null && !"".equals(unionPayReq.getFormat())) {
            map.put("format", unionPayReq.getFormat());
        }
        if (unionPayReq.getCharset() != null && !"".equals(unionPayReq.getCharset())) {
            map.put("charset", unionPayReq.getCharset());
        } else {
            map.put("charset", "UTF-8");
        }
        if (unionPayReq.getSignType() != null && !"".equals(unionPayReq.getSignType())) {
            map.put("sign_type", unionPayReq.getSignType());
        } else {
            map.put("sign_type", "RSA");
        }
        map.put("sign", unionPayReq.getSign());
        map.put("biz_content", unionPayReq.getBizContent());
        map.put(b.f, unionPayReq.getTimestamp());
        String ca = unionPayReq.getCa();
        if (ca != null && !"".equals(ca)) {
            map.put("ca", ca);
        }
        Log.i(Constants.LogFlag, "params: ===========================" + map);
        Log.i(Constants.LogFlag, new Constants().TEST_EPAY_URL + PPSLabelView.Code + map);
        return sendHttpClientPost(new Constants().TEST_EPAY_URL, map, "utf-8");
    }

    private byte[] sendPostToTestServer(String str, String str2, String str3) {
        HttpClient newHttpClient = new Util().getNewHttpClient();
        newHttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("biz_content", str2));
        try {
            try {
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, str3);
                HttpPost httpPost = new HttpPost(str);
                httpPost.setEntity(urlEncodedFormEntity);
                HttpResponse httpResponseExecute = newHttpClient.execute(httpPost);
                if (httpResponseExecute.getStatusLine().getStatusCode() != 200) {
                    Log.i(Constants.LogFlag, "httpGet fail, status code = " + httpResponseExecute.getStatusLine().getStatusCode());
                    return null;
                }
                return EntityUtils.toByteArray(httpResponseExecute.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            newHttpClient.getConnectionManager().shutdown();
        }
    }
}
