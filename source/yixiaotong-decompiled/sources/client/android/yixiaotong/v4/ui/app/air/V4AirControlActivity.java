package client.android.yixiaotong.v4.ui.app.air;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.databinding.ActivityV4AirControlBinding;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.bean.V4ElecMeterInfoBean;
import client.android.yixiaotong.v4.util.sse.SSEClient;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4AirControlActivity extends BaseActivity implements SSEClient.SSECallback {
    private static final String SSE_URL = "https://yourserver.com/events";
    private static final String TAG = "V4ElecMeterControlActivity";
    private ActivityV4AirControlBinding binding;
    private V4ElecMeterInfoBean mBindElecMeterInfoBean;
    private boolean mIsEnable;
    private SSEClient sseClient;

    static {
        StubApp.interface11(10641);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, V4ElecMeterInfoBean v4ElecMeterInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4AirControlActivity.class).putExtra("bean", v4ElecMeterInfoBean));
        }
    }

    private void initTitleBar() {
        this.binding.titlebar.setLeftView(R.mipmap.back);
        this.binding.titlebar.setTitleView(getString(R.string.airconditioningcontrol));
        this.binding.titlebar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        SSEClient sSEClient = this.sseClient;
        if (sSEClient != null) {
            sSEClient.disconnect();
        }
    }

    @Override // client.android.yixiaotong.v4.util.sse.SSEClient.SSECallback
    public void onConnected() {
        LogUtil.e(TAG, "onConnected");
    }

    @Override // client.android.yixiaotong.v4.util.sse.SSEClient.SSECallback
    public void onMessage(String str) {
        LogUtil.e(TAG, "onMessage:" + str);
    }

    @Override // client.android.yixiaotong.v4.util.sse.SSEClient.SSECallback
    public void onEvent(String str) {
        LogUtil.e(TAG, "onEvent:" + str);
    }

    @Override // client.android.yixiaotong.v4.util.sse.SSEClient.SSECallback
    public void onId(String str) {
        LogUtil.e(TAG, "onId:" + str);
    }

    @Override // client.android.yixiaotong.v4.util.sse.SSEClient.SSECallback
    public void onRetry(long j) {
        LogUtil.e(TAG, "onRetry:" + j);
    }

    @Override // client.android.yixiaotong.v4.util.sse.SSEClient.SSECallback
    public void onError(Throwable th) {
        LogUtil.e(TAG, "onError:" + th.toString());
    }

    @Override // client.android.yixiaotong.v4.util.sse.SSEClient.SSECallback
    public void onReconnecting() {
        LogUtil.e(TAG, "onReconnecting");
    }
}
