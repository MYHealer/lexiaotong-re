package com.icbc.paysdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.util.l;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.icbc.paysdk.constants.Constants;
import com.icbc.paysdk.httpclient.ListHttpAPI;
import com.icbc.paysdk.model.ThirdPayReq;
import com.icbc.paysdk.model.UnionPayReq;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class AliPayAPI {
    public static String ERROR_PAY_PARAM = "支付参数错误";
    public static final String TAG = "AlipayAPI";
    private static AliPayAPI mAliAPI;
    private AlertDialog alertDialog;
    private AliPayResultCallBack mCallback;
    Activity mContext = null;
    private String mPayParam;
    private PayTask mPayTask;

    public interface AliPayResultCallBack {
        void onResp(String str);
    }

    public static AliPayAPI getInstance() {
        if (mAliAPI == null) {
            mAliAPI = new AliPayAPI();
        }
        return mAliAPI;
    }

    private AliPayAPI() {
    }

    public void doAliPay(Activity activity, ThirdPayReq thirdPayReq) {
        this.mContext = activity;
        this.mPayTask = new PayTask(this.mContext);
        new AliPayAsyncTask().execute(thirdPayReq);
    }

    public void doSdk(Activity activity, UnionPayReq unionPayReq, AliPayResultCallBack aliPayResultCallBack) {
        this.mContext = activity;
        this.mCallback = aliPayResultCallBack;
        this.mPayTask = new PayTask(this.mContext);
        new SdkAsyncTask().execute(unionPayReq);
    }

    public void doAliPay2(Activity activity, ThirdPayReq thirdPayReq, AliPayResultCallBack aliPayResultCallBack) {
        this.mContext = activity;
        this.mCallback = aliPayResultCallBack;
        this.mPayTask = new PayTask(this.mContext);
        new AliPayAsyncTask().execute(thirdPayReq);
    }

    public void doPay2(String str) {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).optString("response_biz_content"));
            String strOptString = jSONObject.optString("return_msg");
            String strOptString2 = jSONObject.optString("return_code");
            if (!"success".equals(strOptString)) {
                show(this.mContext, "API调用异常：" + strOptString2 + ", " + strOptString);
                return;
            }
            final String strOptString3 = jSONObject.optString("ap_package_data");
            if (TextUtils.isEmpty(strOptString3)) {
                show(this.mContext, "支付参数错误");
            } else {
                final Handler handler = new Handler();
                new Thread(new Runnable() { // from class: com.icbc.paysdk.AliPayAPI.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final Map<String, String> mapPayV2 = AliPayAPI.this.mPayTask.payV2(strOptString3, true);
                        handler.post(new Runnable() { // from class: com.icbc.paysdk.AliPayAPI.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AliPayAPI.this.mCallback == null) {
                                    return;
                                }
                                Log.d("paysdk", mapPayV2.toString());
                                AliPayAPI.this.mCallback.onResp((String) mapPayV2.get(l.f1664a));
                            }
                        });
                    }
                }).start();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            show(this.mContext, "支付参数错误");
        }
    }

    public void doPay(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("return_code");
            String strOptString2 = jSONObject.optString("returnMsg");
            if (!"0".equals(strOptString) || !TextUtils.isEmpty(strOptString2)) {
                show(this.mContext, strOptString + PPSLabelView.Code + strOptString2);
                return;
            }
            if ("0".equals(strOptString)) {
                final String strOptString3 = jSONObject.optString("prepayid");
                if (TextUtils.isEmpty(strOptString3)) {
                    show(this.mContext, ERROR_PAY_PARAM);
                } else {
                    final Handler handler = new Handler();
                    new Thread(new Runnable() { // from class: com.icbc.paysdk.AliPayAPI.2
                        @Override // java.lang.Runnable
                        public void run() {
                            final Map<String, String> mapPayV2 = AliPayAPI.this.mPayTask.payV2(strOptString3, true);
                            handler.post(new Runnable() { // from class: com.icbc.paysdk.AliPayAPI.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        String packageName = AliPayAPI.this.mContext.getPackageName();
                                        ComponentName componentName = new ComponentName(packageName, packageName + ".alipay.AliPayEntryActivity");
                                        Intent intent = new Intent();
                                        intent.setComponent(componentName);
                                        intent.putExtra("result", (String) mapPayV2.get(l.f1664a));
                                        Log.d("icbcpay", mapPayV2.toString());
                                        AliPayAPI.this.mContext.startActivity(intent);
                                    } catch (Exception unused) {
                                        Intent intent2 = new Intent();
                                        intent2.setAction("com.icbc.pay.AliPayEntryActivity.SHOW_ACTIVITY");
                                        intent2.putExtra("result", (String) mapPayV2.get(l.f1664a));
                                        AliPayAPI.this.mContext.startActivity(intent2);
                                    }
                                }
                            });
                        }
                    }).start();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            show(this.mContext, "支付参数错误");
        }
    }

    private class AliPayAsyncTask extends AsyncTask<ThirdPayReq, String, String> {
        private AliPayAsyncTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(ThirdPayReq... thirdPayReqArr) {
            byte[] bArrPostOrderRequest = new ListHttpAPI().postOrderRequest(thirdPayReqArr[0]);
            if (bArrPostOrderRequest == null || bArrPostOrderRequest.length <= 0) {
                return null;
            }
            try {
                AliPayAPI.this.mPayParam = new String(bArrPostOrderRequest).replaceAll("\t", "").replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, "").replaceAll("\r", "").replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "");
                AliPayAPI.this.mPayParam = new String(Base64.decode(AliPayAPI.this.mPayParam.getBytes(), 0), "gbk");
            } catch (Exception e) {
                AliPayAPI aliPayAPI = AliPayAPI.this;
                aliPayAPI.show(aliPayAPI.mContext, "报文解析错误 " + AliPayAPI.this.mPayParam);
                e.printStackTrace();
            }
            return AliPayAPI.this.mPayParam;
        }
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
                AliPayAPI.this.mPayParam = strPostSdkRequest;
            } catch (Exception e) {
                AliPayAPI aliPayAPI = AliPayAPI.this;
                aliPayAPI.show(aliPayAPI.mContext, "报文解析错误 " + AliPayAPI.this.mPayParam);
                e.printStackTrace();
            }
            Log.d("API调用返回 ", "doInBackground: " + AliPayAPI.this.mPayParam);
            return AliPayAPI.this.mPayParam;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            AliPayAPI aliPayAPI = AliPayAPI.this;
            aliPayAPI.showDialog(aliPayAPI.mContext);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            AliPayAPI.this.hideDialog();
            if (str == null) {
                AliPayAPI aliPayAPI = AliPayAPI.this;
                aliPayAPI.show(aliPayAPI.mContext, "网络不给力，请稍候再试");
            } else {
                Log.d(AliPayAPI.TAG, "onPostExecute: 调用 doPay2 方法");
                AliPayAPI aliPayAPI2 = AliPayAPI.this;
                aliPayAPI2.doPay2(aliPayAPI2.mPayParam);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show(final Activity activity, final String str) {
        activity.runOnUiThread(new Runnable() { // from class: com.icbc.paysdk.AliPayAPI.3
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(activity, str, 0).show();
            }
        });
    }

    public void handleIntent(Intent intent, IAliPayResultHandler iAliPayResultHandler) {
        iAliPayResultHandler.onResp(intent.getStringExtra("result"));
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
}
