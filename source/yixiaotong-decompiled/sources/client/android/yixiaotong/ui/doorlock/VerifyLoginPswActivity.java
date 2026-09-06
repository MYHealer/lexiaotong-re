package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class VerifyLoginPswActivity extends BaseActivity {
    private static final String EXTRA_DEVICE = "bluetoothdevice";
    private static final String EXTRA_PSW = "extra_psw";
    private static final String EXTRA_STATE = "extra_state";
    private BluetoothDevice mBluetoothDevice;
    private EditText mEtPsw;
    private String mPsw;
    private int mState;
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(7021);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i, String str, BluetoothDevice bluetoothDevice) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) VerifyLoginPswActivity.class).putExtra("extra_state", i).putExtra(EXTRA_PSW, str).putExtra("bluetoothdevice", bluetoothDevice));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mEtPsw = (EditText) findViewById(R.id.et_psw);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setTitleView(getResources().getString(R.string.login_verfity));
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.VerifyLoginPswActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m117x195d416c(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-doorlock-VerifyLoginPswActivity, reason: not valid java name */
    /* synthetic */ void m117x195d416c(View view) {
        checkLoginPsw();
    }

    private void checkLoginPsw() {
        if (StringUtils.isNotEmpty(this.mEtPsw.getText().toString())) {
            if (!this.mEtPsw.getText().toString().equals(getLoginAccount().getPassword())) {
                ToastUtils.show(getContext(), getResources().getString(R.string.doorlock_loginpsw_error));
                return;
            }
            int i = this.mState;
            if (i != 6) {
                if (i == 7) {
                    SeeKeyActivity.launch(getActivity(), this.mPsw);
                    finish();
                    return;
                }
                return;
            }
            if (LocalBusinessStore.getDoorLockTip(getContext())) {
                UpdateKeyActivity.launch(getActivity(), this.mBluetoothDevice, this.mPsw);
                finish();
                return;
            } else {
                RouseTipActivity.launch(getActivity(), this.mState, this.mBluetoothDevice);
                finish();
                return;
            }
        }
        ToastUtils.show(getContext(), getResources().getString(R.string.doorlock_input_loginpsw));
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
