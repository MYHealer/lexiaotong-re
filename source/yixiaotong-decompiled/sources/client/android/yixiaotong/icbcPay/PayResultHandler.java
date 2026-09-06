package client.android.yixiaotong.icbcPay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.icbc.paysdk.ICBCAPI;
import com.icbc.paysdk.IPayEventHandler;
import com.icbc.paysdk.constants.Constants;
import com.icbc.paysdk.model.PayResp;
import com.icbc.paysdk.model.ReqErr;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class PayResultHandler extends Activity implements IPayEventHandler {
    TextView result_text;

    static {
        StubApp.interface11(5432);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        ICBCAPI.getInstance().handleIntent(intent, this);
    }

    @Override // com.icbc.paysdk.IPayEventHandler
    public void onErr(ReqErr reqErr) {
        Log.i(Constants.LogFlag, "onErr() ...... ");
        this.result_text.setText("支付错误：" + reqErr.getErrorType());
        finish();
    }

    @Override // com.icbc.paysdk.IPayEventHandler
    public void onResp(PayResp payResp) {
        Log.i(Constants.LogFlag, "onResp() ...... ");
        this.result_text.setText("交易码：" + payResp.getTranCode() + "\n交易信息：" + payResp.getTranMsg() + "\n订单号：" + payResp.getOrderNo());
        finish();
    }
}
