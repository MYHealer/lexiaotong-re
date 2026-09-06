package com.icbc.paysdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.alipay.sdk.tid.b;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.icbc.paysdk.constants.Constants;
import com.icbc.paysdk.httpclient.ListHttpAPI;
import com.icbc.paysdk.model.ThirdPayReq;
import com.icbc.paysdk.model.UnionPayReq;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class WXPayAPI {
    public static String ERROR_PAY_PARAM = "支付参数错误";
    public static String NO_OR_LOW_WX = "未安装微信或微信版本过低";
    private static WXPayAPI mWXPay;
    private AlertDialog alertDialog;
    private String appid;
    Activity mContext = null;
    private String mPayParam;
    private IWXAPI mWXApi;

    public static WXPayAPI getInstance() {
        return mWXPay;
    }

    public IWXAPI getWXApi() {
        return this.mWXApi;
    }

    private WXPayAPI(Context context, String str) {
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, str);
        this.mWXApi = iwxapiCreateWXAPI;
        iwxapiCreateWXAPI.registerApp(str);
        this.appid = str;
    }

    public static void init(Context context, String str) {
        if (mWXPay == null) {
            mWXPay = new WXPayAPI(context, str);
        }
    }

    public void doPay(String str) {
        if (!check()) {
            show(this.mContext, NO_OR_LOW_WX);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("tranErrorCode");
            String strOptString2 = jSONObject.optString("tranErrorDisplayMSg");
            if (!"0".equals(strOptString) || !TextUtils.isEmpty(strOptString2)) {
                show(this.mContext, strOptString + PPSLabelView.Code + strOptString2);
                return;
            }
            if ("0".equals(strOptString)) {
                if (checkpayparam(jSONObject)) {
                    PayReq payReq = new PayReq();
                    payReq.appId = this.appid;
                    payReq.partnerId = jSONObject.optString("partnerId");
                    payReq.prepayId = jSONObject.optString("prepayid");
                    payReq.packageValue = jSONObject.optString("package");
                    payReq.nonceStr = jSONObject.optString("noncestr");
                    payReq.timeStamp = jSONObject.optString(b.f);
                    payReq.sign = jSONObject.optString("sign");
                    this.mWXApi.sendReq(payReq);
                    return;
                }
                show(this.mContext, ERROR_PAY_PARAM);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            show(this.mContext, ERROR_PAY_PARAM);
        }
    }

    private boolean checkpayparam(JSONObject jSONObject) {
        return (TextUtils.isEmpty(this.appid) || TextUtils.isEmpty(jSONObject.optString("partnerId")) || TextUtils.isEmpty(jSONObject.optString("prepayid")) || TextUtils.isEmpty(jSONObject.optString("package")) || TextUtils.isEmpty(jSONObject.optString("noncestr")) || TextUtils.isEmpty(jSONObject.optString(b.f)) || TextUtils.isEmpty(jSONObject.optString("sign"))) ? false : true;
    }

    private boolean check() {
        return this.mWXApi.isWXAppInstalled() && this.mWXApi.getWXAppSupportAPI() >= 570425345;
    }

    public void doWXPay(Activity activity, ThirdPayReq thirdPayReq) {
        this.mContext = activity;
        new WXPayAsyncTask().execute(thirdPayReq);
    }

    private class WXPayAsyncTask extends AsyncTask<ThirdPayReq, String, String> {
        private WXPayAsyncTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(ThirdPayReq... thirdPayReqArr) {
            byte[] bArrPostOrderRequest = new ListHttpAPI().postOrderRequest(thirdPayReqArr[0]);
            if (bArrPostOrderRequest == null || bArrPostOrderRequest.length <= 0) {
                WXPayAPI wXPayAPI = WXPayAPI.this;
                wXPayAPI.show(wXPayAPI.mContext, "网络不给力，请稍候再试");
                return null;
            }
            try {
                WXPayAPI.this.mPayParam = new String(bArrPostOrderRequest).replaceAll("\t", "").replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, "").replaceAll("\r", "").replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "");
                WXPayAPI.this.mPayParam = new String(Base64.decode(WXPayAPI.this.mPayParam.getBytes(), 0), "gbk");
            } catch (Exception e) {
                WXPayAPI wXPayAPI2 = WXPayAPI.this;
                wXPayAPI2.show(wXPayAPI2.mContext, "报文解析错误 " + WXPayAPI.this.mPayParam);
                e.printStackTrace();
            }
            WXPayAPI wXPayAPI3 = WXPayAPI.this;
            wXPayAPI3.doPay(wXPayAPI3.mPayParam);
            return null;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            WXPayAPI wXPayAPI = WXPayAPI.this;
            wXPayAPI.showDialog(wXPayAPI.mContext);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            WXPayAPI.this.hideDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(Activity activity) {
        try {
            Log.i(Constants.LogFlag, "showDialog");
            this.alertDialog = new AlertDialog.Builder(activity, R.style.dialog_fullscreen).create();
            View viewInflate = LayoutInflater.from(activity).inflate(R.layout.dialog_loading, (ViewGroup) null);
            this.alertDialog.show();
            this.alertDialog.getWindow().setContentView(viewInflate);
            this.alertDialog.getWindow().setLayout(-1, -1);
            this.alertDialog.setCanceledOnTouchOutside(false);
        } catch (Exception e) {
            Log.i(Constants.LogFlag, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideDialog() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show(final Activity activity, final String str) {
        activity.runOnUiThread(new Runnable() { // from class: com.icbc.paysdk.WXPayAPI.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(activity, str, 0).show();
            }
        });
    }

    public void doSdk(Activity activity, UnionPayReq unionPayReq) {
        this.mContext = activity;
        new SdkAsyncTask().execute(unionPayReq);
    }

    private class SdkAsyncTask extends AsyncTask<UnionPayReq, String, String> {
        private SdkAsyncTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(UnionPayReq... unionPayReqArr) {
            String strPostSdkRequest = new ListHttpAPI().postSdkRequest(unionPayReqArr[0]);
            if (strPostSdkRequest == null || strPostSdkRequest.length() <= 0) {
                return null;
            }
            try {
                WXPayAPI.this.mPayParam = strPostSdkRequest;
            } catch (Exception e) {
                WXPayAPI wXPayAPI = WXPayAPI.this;
                wXPayAPI.show(wXPayAPI.mContext, "报文解析错误 " + WXPayAPI.this.mPayParam);
                e.printStackTrace();
            }
            Log.d("API调用返回 ", "doInBackground: " + WXPayAPI.this.mPayParam);
            return WXPayAPI.this.mPayParam;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            WXPayAPI wXPayAPI = WXPayAPI.this;
            wXPayAPI.showDialog(wXPayAPI.mContext);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            WXPayAPI.this.hideDialog();
            if (str == null) {
                WXPayAPI wXPayAPI = WXPayAPI.this;
                wXPayAPI.show(wXPayAPI.mContext, "网络不给力，请稍候再试");
            } else {
                Log.i("onPostExecute", "调用微信 doPay2 方法");
                WXPayAPI wXPayAPI2 = WXPayAPI.this;
                wXPayAPI2.doPay2(wXPayAPI2.mPayParam);
            }
        }
    }

    public void doPay2(String str) {
        if (!check()) {
            show(this.mContext, NO_OR_LOW_WX);
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("response_biz_content");
            Log.i("WxPayAPI", "API返回responseBizContent：" + strOptString);
            JSONObject jSONObject = new JSONObject(strOptString);
            String strOptString2 = jSONObject.optString("return_msg");
            String strOptString3 = jSONObject.optString("return_code");
            if (!"success".equals(strOptString2)) {
                show(this.mContext, "API调用异常：" + strOptString3 + PPSLabelView.Code + strOptString2);
                return;
            }
            String strOptString4 = jSONObject.optString("ap_package_data");
            if (TextUtils.isEmpty(strOptString4)) {
                show(this.mContext, "支付参数错误");
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(strOptString4);
                PayReq payReq = new PayReq();
                try {
                    payReq.appId = this.appid;
                    payReq.partnerId = jSONObject2.optString("partnerid");
                    payReq.prepayId = jSONObject2.optString("prepayid");
                    payReq.packageValue = jSONObject2.optString("package");
                    payReq.nonceStr = jSONObject2.optString("noncestr");
                    payReq.timeStamp = jSONObject2.optString(b.f);
                    payReq.sign = jSONObject2.optString("sign");
                    Log.i("WxPayAPI", "调微信SDK请求数据：" + payReq);
                    this.mWXApi.sendReq(payReq);
                } catch (Exception e) {
                    Log.i("WxPayAPI", "调微信SDK异常：" + e.getMessage());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                show(this.mContext, ERROR_PAY_PARAM);
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
            show(this.mContext, ERROR_PAY_PARAM);
        }
    }
}
