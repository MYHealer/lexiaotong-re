package client.android.yixiaotong.v3.ui.appcontrol.drinkwater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DrinkWaterCloseActivity extends BaseActivity {
    public static final String TAG = "DrinkWaterClose";
    private BluetoothDevice mBluetoothDevice;
    private int mPlanFlag;
    private TitleBar mTitleBar;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;

    static {
        StubApp.interface11(9194);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DrinkWaterCloseActivity.class).putExtra("qrcode", str));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(this.mTypeInfoBaseInfoBean.appName);
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }
}
