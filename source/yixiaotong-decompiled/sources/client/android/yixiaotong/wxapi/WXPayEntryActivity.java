package client.android.yixiaotong.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.stub.StubApp;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {
    private IWXAPI api;

    static {
        StubApp.interface11(11226);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.api.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        Log.e("WXPayEntryActivity", "onResp:" + baseResp.errCode);
        if (baseResp.getType() == 5) {
            Log.e("WXPayEntryActivity", "onResp:" + baseResp.errCode);
            if (baseResp.errCode == 0) {
                ToastUtils.show(getContext(), "微信支付成功");
                LocalDataUtil.savePaySuccess(getContext(), 1);
                BusinessControllers.getInstance().syncWallets(getLoginAccount(), null);
            } else if (baseResp.errCode == -2) {
                ToastUtils.show(getContext(), "取消微信支付");
            } else if (baseResp.errCode == -3) {
                ToastUtils.show(getContext(), "微信账单发送失败,请检查网络");
            } else if (baseResp.errCode == -4) {
                ToastUtils.show(getContext(), "微信支付授权失败");
            } else if (baseResp.errCode == -5) {
                ToastUtils.show(getContext(), "不支持微信支付");
            } else {
                ToastUtils.show(getContext(), "微信支付失败" + baseResp.errCode);
            }
            finish();
        }
    }
}
