package client.android.yixiaotong.ui.unionpay;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import client.android.yixiaotong.BaseActivity;
import com.android.volley.VolleyError;
import com.masget.base.ApiConfig;
import com.masget.base.volley.JSONResponseHandler;
import com.masget.base.volley.VolleyRequestNew;
import com.stub.StubApp;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PaySuccessActivity extends BaseActivity {
    public static final String ACTION_UP = "UPDATE";
    private String mMainUnionCompanyId;
    private String mOrderCode;
    private String munionAppKey;
    private String munionSession;

    static {
        StubApp.interface11(7642);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void getData() {
        HashMap map = new HashMap();
        map.put("ordernumber", this.mOrderCode);
        map.put("companyid", this.mMainUnionCompanyId);
        map.put("unionSession", this.munionSession);
        map.put("unionAppKey", this.munionAppKey);
        VolleyRequestNew.postJson(true, ApiConfig.URL_ORDER_RECORD, map, new JSONResponseHandler() { // from class: client.android.yixiaotong.ui.unionpay.PaySuccessActivity.1
            @Override // com.masget.base.volley.JSONResponseHandler
            public void onFail(VolleyError volleyError) {
            }

            @Override // com.masget.base.volley.JSONResponseHandler
            public void onSuccess(JSONObject jSONObject) {
                String strOptString = jSONObject.optString("data");
                Log.e("1111", "发送广播，通知支付成功 返回支付信息");
                Intent intent = new Intent();
                intent.setAction(PayResultHandler.ACTION_PAY_SUCCESS);
                intent.putExtra(PayResultHandler.EXTRA_KEY_PAYRESULT, strOptString);
                PaySuccessActivity.this.sendBroadcast(intent);
                Intent intent2 = new Intent();
                intent2.setAction(PaySuccessActivity.ACTION_UP);
                PaySuccessActivity.this.sendBroadcast(intent2);
            }
        });
    }
}
