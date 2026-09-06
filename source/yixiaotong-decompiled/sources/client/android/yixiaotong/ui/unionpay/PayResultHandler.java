package client.android.yixiaotong.ui.unionpay;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import com.android.volley.VolleyError;
import com.masget.base.ApiConfig;
import com.masget.base.volley.JSONResponseHandler;
import com.masget.base.volley.VolleyRequestNew;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PayResultHandler {
    public static final String ACTION_PAY_SUCCESS = "com.masget.wallet.paysuccess";
    public static final String EXTRA_KEY_PAYRESULT = "payResult";
    public static final String PAYING_ORDER = "1";
    public static final String PAY_ORDER = "0";
    public static final String QUERYING_ORDER = "0";
    public static final String QUERY_ORDER_SUCCESS = "2";
    private static final long default_query_delay = 5;
    private static final long default_query_time = 600;
    public static final int paySuccess = 1;
    private LocalPreferencesHelper localPreferencesHelper;
    private Activity mActivity;
    private long mDelay;
    private boolean mIsSuccLayoutVisible;
    private String mMainUnionCompanyId;
    private String mOrderCode;
    private long mQueryTime;
    private int mRespcode;
    private String munionAppKey;
    private String munionSession;
    private Timer timer;
    private int MSG_QUERY = 1;
    private long time = 0;
    private boolean isQueryResult = false;
    private Handler handler = new Handler() { // from class: client.android.yixiaotong.ui.unionpay.PayResultHandler.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == PayResultHandler.this.MSG_QUERY) {
                if (PayResultHandler.this.mOrderCode != null && PayResultHandler.this.mMainUnionCompanyId != null && PayResultHandler.this.munionAppKey != null && PayResultHandler.this.munionSession != null) {
                    Log.e("1111", "ordernumber:" + PayResultHandler.this.mOrderCode + "  companyid:" + PayResultHandler.this.mMainUnionCompanyId);
                    HashMap map = new HashMap();
                    map.put("ordernumber", PayResultHandler.this.mOrderCode);
                    map.put("companyid", PayResultHandler.this.mMainUnionCompanyId);
                    map.put("unionSession", PayResultHandler.this.munionSession);
                    map.put("unionAppKey", PayResultHandler.this.munionAppKey);
                    VolleyRequestNew.postJson(true, ApiConfig.URL_ORDER_RECORD, map, new JSONResponseHandler() { // from class: client.android.yixiaotong.ui.unionpay.PayResultHandler.1.1
                        @Override // com.masget.base.volley.JSONResponseHandler
                        public void onSuccess(JSONObject jSONObject) {
                            int iOptInt = jSONObject.optInt("ret");
                            Log.e("1111", "onSuccess:ret:" + iOptInt + "  " + jSONObject.toString());
                            if (iOptInt == 0) {
                                String strOptString = jSONObject.optString("data");
                                try {
                                    if (strOptString.isEmpty()) {
                                        return;
                                    }
                                    JSONObject jSONObject2 = new JSONObject(strOptString);
                                    jSONObject2.optInt(FileDownloadModel.TOTAL);
                                    String strOptString2 = jSONObject2.optString("rows");
                                    PayResultHandler.this.mRespcode = new JSONArray(strOptString2).getJSONObject(0).optInt("respcode");
                                    Log.e("1111", "mRespcode:" + PayResultHandler.this.mRespcode + "   " + strOptString2);
                                    if (PayResultHandler.this.mRespcode == 2) {
                                        if (PayResultHandler.this.localPreferencesHelper != null) {
                                            PayResultHandler.this.localPreferencesHelper.saveOrUpdate("payRespcode", "2");
                                        }
                                        PayResultHandler.this.isQueryResult = true;
                                        PayResultHandler.this.stopQuery();
                                        if (PayResultHandler.this.mIsSuccLayoutVisible) {
                                            Log.e("11111", "..支付成功 到成功界面");
                                            PayResultHandler.this.handlePayResult();
                                            return;
                                        } else {
                                            Log.e("1111", "..支付成功 发送成功广播..唤醒app");
                                            PayResultHandler.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                                            return;
                                        }
                                    }
                                    Log.e("11111", "..支付失败 手动点击查询");
                                    PayResultHandler.this.query();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Log.e("11111", "JSONException:" + e.getMessage());
                                }
                            }
                        }

                        @Override // com.masget.base.volley.JSONResponseHandler
                        public void onFail(VolleyError volleyError) {
                            PayResultHandler.this.stopQuery();
                        }
                    });
                    return;
                }
                Log.e("11111", "参数不能为空");
            }
        }
    };
    private Handler mHandler = new Handler() { // from class: client.android.yixiaotong.ui.unionpay.PayResultHandler.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                Log.e("11111", "..开始跳转");
                Intent intent = new Intent(PayResultHandler.this.mActivity, PayResultHandler.this.mActivity.getClass());
                intent.addFlags(131072);
                PayResultHandler.this.mActivity.startActivity(intent);
                PayResultHandler.this.mActivity.finish();
            }
        }
    };

    public boolean isQueryResult() {
        return this.isQueryResult;
    }

    public void setQueryResult(boolean z) {
        this.isQueryResult = z;
    }

    static /* synthetic */ long access$1314(PayResultHandler payResultHandler, long j) {
        long j2 = payResultHandler.time + j;
        payResultHandler.time = j2;
        return j2;
    }

    public PayResultHandler(Activity activity, String str, String str2, String str3, String str4) {
        this.mActivity = activity;
        this.mOrderCode = str;
        this.mMainUnionCompanyId = str2;
        this.munionAppKey = str4;
        this.munionSession = str3;
        this.localPreferencesHelper = new LocalPreferencesHelper(this.mActivity, "default_alipay_preferences");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePayResult() {
        Log.e("11111", "..开始跳转");
        Intent intent = new Intent(this.mActivity, (Class<?>) PaySuccessActivity.class);
        intent.putExtra("ordernumber", this.mOrderCode);
        intent.putExtra("mainUnionCompanyId", this.mMainUnionCompanyId);
        intent.putExtra("unionSession", this.munionSession);
        intent.putExtra("unionAppKey", this.munionAppKey);
        this.mActivity.startActivity(intent);
        this.mActivity.finish();
    }

    public void startQuery(long j, long j2) {
        startQuery(true, j, j2);
    }

    public void startQuery(boolean z, long j, long j2) {
        if (j2 < default_query_time) {
            j2 = 600;
        }
        this.mIsSuccLayoutVisible = z;
        this.timer = new Timer(true);
        this.mDelay = j;
        this.mQueryTime = j2;
        query();
        timing(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void query() {
        try {
            Handler handler = this.handler;
            if (handler != null) {
                if (this.time < this.mQueryTime) {
                    handler.sendEmptyMessageDelayed(this.MSG_QUERY, this.mDelay * 1000);
                } else {
                    Activity activity = this.mActivity;
                    Intent intent = new Intent(activity, activity.getClass());
                    intent.addFlags(131072);
                    this.mActivity.startActivity(intent);
                    this.mActivity.finish();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void timing(long j) {
        this.timer.schedule(new TimerTask() { // from class: client.android.yixiaotong.ui.unionpay.PayResultHandler.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                PayResultHandler.access$1314(PayResultHandler.this, 1L);
            }
        }, 1000 * j, 1000L);
    }

    public void stopQuery() {
        try {
            this.time = 0L;
            this.handler.removeMessages(this.MSG_QUERY);
        } catch (Exception unused) {
        }
    }

    public void release() {
        this.time = 0L;
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer.purge();
            this.timer = null;
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeMessages(this.MSG_QUERY);
            this.handler = null;
        }
    }
}
