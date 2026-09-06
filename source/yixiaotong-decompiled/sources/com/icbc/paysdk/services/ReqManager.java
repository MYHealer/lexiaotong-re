package com.icbc.paysdk.services;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.icbc.paysdk.PayModeListActivity;
import com.icbc.paysdk.constants.Constants;
import com.icbc.paysdk.httpclient.ListHttpAPI;
import com.icbc.paysdk.model.ShopInfo;
import com.icbc.paysdk.model.ThirdPayReq;
import com.icbc.paysdk.model.UnionPayReq;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ReqManager {
    private static ReqManager reqManager;
    private UnionPayReq icbcpayreq;
    private Intent intent;
    private Context mContext;
    private ThirdPayReq thirdpayreq;

    public UnionPayReq getICBCPayReq() {
        return this.icbcpayreq;
    }

    public ThirdPayReq getThirdPayReq() {
        return this.thirdpayreq;
    }

    public void setICBCPayReq(UnionPayReq unionPayReq) {
        this.icbcpayreq = unionPayReq;
    }

    public void setThirdPayReq(ThirdPayReq thirdPayReq) {
        this.thirdpayreq = thirdPayReq;
    }

    public static ReqManager getInstance() {
        if (reqManager == null) {
            reqManager = new ReqManager();
        }
        return reqManager;
    }

    public void handleReq(Context context, ShopInfo shopInfo) {
        this.mContext = context;
        Intent intent = new Intent(context, (Class<?>) PayModeListActivity.class);
        this.intent = intent;
        intent.putExtra("shopname", shopInfo.getShopName());
        this.intent.putExtra("totalamount", shopInfo.getTotalAmount());
        this.intent.putExtra("wxappid", shopInfo.getWXAppid());
        new CheckPayModeAsyncTask().execute(shopInfo.getShopCode());
    }

    class CheckPayModeAsyncTask extends AsyncTask<String, String, String> {
        CheckPayModeAsyncTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            try {
                byte[] thirdPayList = new ListHttpAPI().getThirdPayList(strArr[0]);
                if (thirdPayList == null || thirdPayList.length <= 0) {
                    return null;
                }
                Log.i(Constants.LogFlag, "httpResponse != null");
                try {
                    JSONObject jSONObject = new JSONObject(new String(thirdPayList));
                    String strOptString = jSONObject.optString("wxPayFlag");
                    String strOptString2 = jSONObject.optString("aliPayFlag");
                    ReqManager.this.intent.putExtra("wxpayflag", strOptString);
                    ReqManager.this.intent.putExtra("alipayflag", strOptString2);
                    return null;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            ReqManager.this.mContext.startActivity(ReqManager.this.intent);
        }
    }
}
