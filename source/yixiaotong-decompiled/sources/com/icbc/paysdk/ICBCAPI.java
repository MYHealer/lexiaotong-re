package com.icbc.paysdk;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.alipay.sdk.tid.b;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.cdo.oaps.ad.OapsKey;
import com.icbc.paysdk.constants.Constants;
import com.icbc.paysdk.httpclient.ListHttpAPI;
import com.icbc.paysdk.model.PayReq;
import com.icbc.paysdk.model.PayResp;
import com.icbc.paysdk.model.ReqErr;
import com.icbc.paysdk.model.UnionPayReq;
import com.icbc.paysdk.services.ICBCLaunchAppServices;
import com.icbc.paysdk.webview.PayWebView;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ICBCAPI {
    private static ICBCAPI api;
    String interfaceName;
    String interfaceVersion;
    private String mPayParam;
    ArrayList<Integer> payList = null;
    ArrayList<Integer> packagelList = null;
    String payPackageName = null;
    Context context = null;
    Activity mContext = null;

    public static ICBCAPI getInstance() {
        if (api == null) {
            api = new ICBCAPI();
        }
        return api;
    }

    private ICBCAPI() {
    }

    public void sendReq(Context context, UnionPayReq unionPayReq) {
        this.context = context;
        new payAsyncTask().execute(unionPayReq);
    }

    public void handleIntent(Intent intent, IPayEventHandler iPayEventHandler) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String string = extras.getString("type");
            Log.i(Constants.LogFlag, "type = " + string);
            if ("onErr".equals(string)) {
                String string2 = extras.getString("errorType");
                Log.i(Constants.LogFlag, "handlerIntent : errorType = " + string2);
                ReqErr reqErr = new ReqErr();
                reqErr.setErrorType(string2);
                iPayEventHandler.onErr(reqErr);
            }
            if ("onResp".equals(string)) {
                String string3 = extras.getString("tranCode");
                Log.i(Constants.LogFlag, "handlerIntent : tranCode = " + string3);
                String string4 = extras.getString("tranMsg");
                Log.i(Constants.LogFlag, "handlerIntent : tranMsg = " + string4);
                String string5 = extras.getString("orderNo");
                Log.i(Constants.LogFlag, "handlerIntent : orderNo = " + string5);
                PayResp payResp = new PayResp();
                payResp.setTranCode(string3);
                payResp.setTranMsg(string4);
                payResp.setOrderNo(string5);
                iPayEventHandler.onResp(payResp);
                return;
            }
            return;
        }
        Log.i(Constants.LogFlag, "bundle ==null");
        String stringExtra = intent.getStringExtra("type");
        Log.i(Constants.LogFlag, "type = " + stringExtra);
        if ("onErr".equals(stringExtra)) {
            String stringExtra2 = intent.getStringExtra("errorType");
            Log.i(Constants.LogFlag, "handlerIntent : errorType = " + stringExtra2);
            ReqErr reqErr2 = new ReqErr();
            reqErr2.setErrorType(stringExtra2);
            iPayEventHandler.onErr(reqErr2);
        }
        if ("onResp".equals(stringExtra)) {
            String stringExtra3 = intent.getStringExtra("tranCode");
            Log.i(Constants.LogFlag, "handlerIntent : tranCode = " + stringExtra3);
            String stringExtra4 = intent.getStringExtra("tranMsg");
            Log.i(Constants.LogFlag, "handlerIntent : tranMsg = " + stringExtra4);
            String stringExtra5 = intent.getStringExtra("orderNo");
            Log.i(Constants.LogFlag, "handlerIntent : orderNo = " + stringExtra5);
            PayResp payResp2 = new PayResp();
            payResp2.setTranCode(stringExtra3);
            payResp2.setTranMsg(stringExtra4);
            payResp2.setOrderNo(stringExtra5);
            iPayEventHandler.onResp(payResp2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWapbB2CNew(Context context, PayReq payReq) {
        Log.i(Constants.LogFlag, "startWapbB2CNew()  ...");
        HashMap<String, String> map = new HashMap<>();
        map.put(Constants.InterfaceName, "ICBC_WAPB_B2C");
        map.put(Constants.InterfaceVersion, "1.0.0.6");
        map.put("netType", "15");
        map.put(OapsKey.KEY_TOKEN, "NewB2C");
        map.put("source_id", "SAES");
        map.put("clientType", "2");
        map.put("isFromSDK", "1");
        map.put("biz_content", payReq.getTranData());
        map.put("sign", payReq.getMerSignMsg());
        map.put("currentVersion", Constants.Version);
        map.put("isFromThird", "0");
        Intent intent = new Intent();
        intent.setData(Uri.parse("com.icbc.androidclient://startType=B2CINJECT&" + ("startB2CParams=" + makeParamsStringForPortal(map) + "|startB2CType=normal|merchantPackageName=" + ((Activity) context).getPackageName())));
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public String makeParamsStringForPortal(HashMap<String, String> map) {
        String str = "";
        int i = 0;
        for (String str2 : map.keySet()) {
            try {
                str = str + str2 + "=" + URLEncoder.encode(map.get(str2), "UTF-8");
            } catch (Exception unused) {
                str = str + str2 + "=" + map.get(str2);
            }
            i++;
            if (i != map.size()) {
                str = str + "&";
            }
        }
        return str;
    }

    private void startWapbB2C(Context context, PayReq payReq) {
        Log.i(Constants.LogFlag, "startWapbB2C()  ...");
        HashMap map = new HashMap();
        map.put(Constants.InterfaceName, "ICBC_WAPB_B2C");
        map.put(Constants.InterfaceVersion, "1.0.0.6");
        map.put("netType", "15");
        map.put(OapsKey.KEY_TOKEN, "NewB2C");
        map.put("clientType", "2");
        map.put("isFromSDK", "1");
        map.put("tranData", payReq.getTranData());
        map.put("merSignMsg", payReq.getMerSignMsg());
        map.put("merCert", payReq.getMerCert());
        map.put("currentVersion", Constants.Version);
        map.put("isFromThird", "1");
        Intent intent = new Intent();
        intent.setAction("com.icbc.activity.web.ICBCPayActivityForSDK.SHOW_ACTIVITY");
        intent.setComponent(new ComponentName(Constants.ICBCPackage.ebank, "com.icbc.activity.web.ICBCPayActivityForSDK"));
        intent.putExtra("startB2CType", PrerollVideoResponse.NORMAL);
        intent.putExtra("startB2CParams", map);
        intent.putExtra("merchantPackageName", ((Activity) context).getPackageName());
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void startWebViewTest(UnionPayReq unionPayReq) {
        Log.i(Constants.LogFlag, "startWebView()  ...");
        HashMap map = new HashMap();
        map.put("app_id", "10000000000004095503");
        map.put("source_id", "SAES");
        map.put("sign", "fpNjwB7VBbwDAlmk%2FNJiF1sVVXa7LyYkNy8AgjydbN9yNGLoHSsWqYWYuuXzT0OkHE4iowlmQT8oxA5lDq%2FMbaz7NWcpLJniMdmnOtpfGBb3%2BTApdzuwL8r2rbldtRvWI7rsmWo%2FW4OwKTgxb4vPscqBjk6WpP%2FUWOMO5SD7kok%3D");
        map.put("msg_id", unionPayReq.getMsgId());
        map.put("sign_type", unionPayReq.getSignType());
        map.put("charset", unionPayReq.getCharset());
        map.put("format", unionPayReq.getFormat());
        map.put("encrypt_type", unionPayReq.getEncryptType());
        map.put(b.f, unionPayReq.getTimestamp());
        map.put("biz_content", "{\"extend\":{\"mer_reference\":\"\",\"mer_custom_ip\":\"\",\"expire_time\":\"\",\"return_url\":\"\",\"language\":\"\",\"auto_refer_sec\":\"\"},\"public\":{\"trans_code\":\"IntegrationApiEpayH5Ctl\",\"area_code\":\"200\",\"gray_flag\":\"0\"},\"user_info\":{\"cert_type\":\"\",\"cert_no\":\"\",\"check_flag\":\"0\",\"name\":\"\",\"mobile\":\"\",\"cust_id\":\"\"},\"order_info\":{\"wallet_flag\":\"0\",\"credit_flag\":\"0\",\"external_app_id\":\"\",\"currency\":\"001\",\"sub_order_list\":\"W3sidW5pb25fbWVyX25vIjoiMTAwMDU5OTgyMzkxIiwiY2FycmlhZ2VfYW10IjoiIiwidW5pb25f\\nbWNjIjoiNTk5OCIsImlzX3VuaW9ucGF5X3Nob3AiOiIxIiwibWVyX2FiYnJfbmFtZSI6Irj6Iiwi\\nY3JlZGl0X21lcl9ubyI6IjAyMDAwMTAyMTU4MSIsInJlZnVuZF90ZXJtIjoiMTIiLCJwbGF0bWVy\\nX2ZsYWciOiIyIiwiaWNiY19tY2MiOiIxMDIiLCJwYXlfc2VyaWFsX25vIjoiIiwidW5pb25fcGF5\\nX2ZsYWciOiIxIiwiZ29vZHNfbmFtZSI6IiIsImFtb3VudCI6IjEzMDAiLCJtZXJfaWQiOiIwMjAw\\nMDEwMjE1ODEiLCJtZXJfaGludCI6IiIsImFyZWFfY29kZSI6IjIwMCIsImdvb2RzX2lkIjoiIiwi\\nZXBheV9mbGFnIjoiMSIsImRsX3N3aXRjaCI6IjIiLCJmb3JlaWduX2NhcmRfZmxhZyI6IjAiLCJv\\ncmRlcl9kYXRlIjoiMjAyNTAxMTAyMDE1MzYiLCJtZXJfcHJ0Y2xfbm8iOiIwMjAwRUUyMDI1NDAy\\nMiIsImdvb2RzX2FkZHJlc3MiOiIiLCJpbnN0YWxsbWVudCI6IjEiLCJ0cmFkZV90eXBlIjoiMSIs\\nImdvb2RzX251bSI6IiIsImljYmNfb3JkZXJpZCI6IjAyMDAwMTAyMTU4MTAwMDcxMjAwMTEwMDAz\\nNzAwMyIsImdvb2RzX3R5cGUiOiIiLCJtZXJfbmFtZSI6Irj6Iiwib3JkZXJfaWQiOiJOZXdQYXky\\nMDE5MTIxODE0MjEyMiIsIm1lcl9hY2N0IjoiMDIwMDAwMDIwOTAyNDIxMzE1NCIsImJybm8iOiI5\\nOTgifV0=\"}}");
        Intent intent = new Intent(this.context, (Class<?>) PayWebView.class);
        intent.putExtra("startB2CType", PrerollVideoResponse.NORMAL);
        intent.putExtra("startB2CParams", map);
        this.context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWebView(Context context, PayReq payReq, UnionPayReq unionPayReq) {
        Log.i(Constants.LogFlag, "startWebView()  ...");
        HashMap map = new HashMap();
        map.put("isFromSDK", "1");
        map.put("app_id", unionPayReq.getAppId());
        map.put("source_id", "SAES");
        map.put("sign", payReq.getMerSignMsg());
        map.put("msg_id", unionPayReq.getMsgId());
        map.put("sign_type", unionPayReq.getSignType());
        map.put("charset", unionPayReq.getCharset());
        map.put("format", unionPayReq.getFormat());
        map.put("encrypt_type", unionPayReq.getEncryptType());
        map.put(b.f, unionPayReq.getTimestamp());
        map.put("biz_content", payReq.getTranData());
        Intent intent = new Intent(context, (Class<?>) PayWebView.class);
        intent.putExtra("startB2CType", PrerollVideoResponse.NORMAL);
        intent.putExtra("startB2CParams", map);
        context.startActivity(intent);
    }

    class payAsyncTask extends AsyncTask<UnionPayReq, String, String> {
        payAsyncTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(UnionPayReq... unionPayReqArr) {
            UnionPayReq unionPayReq = unionPayReqArr[0];
            byte[] bArrPostOrderRequestV2 = new ListHttpAPI().postOrderRequestV2(unionPayReq);
            String str = "";
            if (bArrPostOrderRequestV2 != null && bArrPostOrderRequestV2.length > 0) {
                try {
                    ICBCAPI.this.mPayParam = new String(bArrPostOrderRequestV2).replaceAll("\t", "").replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, "").replaceAll("\r", "").replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "");
                    str = new String(ICBCAPI.this.mPayParam.getBytes(), "UTF-8");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    JSONObject jSONObject = new JSONObject(new JSONObject(str).get("response_biz_content").toString());
                    String strOptString = jSONObject.optString("return_msg");
                    String strOptString2 = jSONObject.optString("return_code");
                    if (!"0".equals(strOptString2)) {
                        ICBCAPI icbcapi = ICBCAPI.this;
                        icbcapi.showMessage(icbcapi.context, "API调用异常：" + strOptString2 + ", " + strOptString);
                    } else {
                        PayReq payReq = new PayReq();
                        payReq.setInterfaceName("ICBC_WAPB_B2C");
                        payReq.setInterfaceVersion("1.0.0.6");
                        payReq.setTranData(jSONObject.get("tranDataH5").toString());
                        payReq.setMerSignMsg(jSONObject.get("merSignMsgH5").toString());
                        ICBCLaunchAppServices iCBCLaunchAppServices = new ICBCLaunchAppServices();
                        if (!iCBCLaunchAppServices.checkOrderData(payReq)) {
                            Log.e("Order_Error", "订单数据不完整");
                            ICBCAPI icbcapi2 = ICBCAPI.this;
                            icbcapi2.showMessage(icbcapi2.context, "订单数据不完整");
                        } else {
                            ICBCAPI icbcapi3 = ICBCAPI.this;
                            icbcapi3.payPackageName = iCBCLaunchAppServices.getPayPackageName(icbcapi3.context);
                            Log.i(Constants.LogFlag, "最终：payPackageName = " + ICBCAPI.this.payPackageName);
                            int installPackageVerCode = ICBCLaunchAppServices.getInstallPackageVerCode(ICBCAPI.this.context, Constants.ICBCPackage.ebank);
                            Log.i(Constants.LogFlag, "获取手机银行客户端版本号 = " + installPackageVerCode);
                            if (installPackageVerCode >= 300016) {
                                ICBCAPI icbcapi4 = ICBCAPI.this;
                                icbcapi4.startWapbB2CNew(icbcapi4.context, payReq);
                            } else {
                                payReq.setTranData(jSONObject.get("tranDataH5").toString());
                                payReq.setMerSignMsg(jSONObject.get("merSignMsgH5").toString());
                                ICBCAPI icbcapi5 = ICBCAPI.this;
                                icbcapi5.startWebView(icbcapi5.context, payReq, unionPayReq);
                            }
                        }
                    }
                } catch (Exception e2) {
                    System.out.println(e2);
                }
            } else {
                Log.i(Constants.LogFlag, "API调用异常，Http返回码非200!");
                ICBCAPI icbcapi6 = ICBCAPI.this;
                icbcapi6.showMessage(icbcapi6.context, "网络不给力，请稍候再试");
            }
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.icbc.paysdk.ICBCAPI$1] */
    public void showMessage(final Context context, final String str) {
        new Thread() { // from class: com.icbc.paysdk.ICBCAPI.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Looper.prepare();
                Toast.makeText(context, str, 0).show();
                Looper.loop();
            }
        }.start();
    }

    private void show(final Activity activity, final String str) {
        activity.runOnUiThread(new Runnable() { // from class: com.icbc.paysdk.ICBCAPI.2
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(activity, str, 0).show();
            }
        });
    }
}
