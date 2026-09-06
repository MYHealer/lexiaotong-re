package client.android.yixiaotong.v4.ui.app.electricitymeter;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4ElecMeterInfoBean;
import client.android.yixiaotong.v4.http.bean.V4RechargeBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4DeviceBalanceDetailActivity extends BaseActivity {
    private static final String TAG = "V4DeviceBalanceDetailActivity";
    private V4ElecMeterInfoBean mBindElecMeterInfoBean;
    private int mProductId;
    TitleBar mTitleBar;
    TextView mTvBalance1;
    TextView mTvBalance2;
    TextView mTvName1;
    TextView mTvName2;
    TextView mTvTip;
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceBalanceDetailActivity.3
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 1) {
                return;
            }
            V4DeviceBalanceDetailActivity.this.checkIsOpenBluetooth();
        }
    };

    static {
        StubApp.interface11(10707);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, V4ElecMeterInfoBean v4ElecMeterInfoBean, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4DeviceBalanceDetailActivity.class).putExtra("bean", v4ElecMeterInfoBean).putExtra("productid", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvName1 = (TextView) findViewById(R.id.text1);
        this.mTvBalance1 = (TextView) findViewById(R.id.tv_balance1);
        this.mTvName2 = (TextView) findViewById(R.id.text2);
        this.mTvBalance2 = (TextView) findViewById(R.id.tv_balance2);
        this.mTvTip = (TextView) findViewById(R.id.tv_tip);
    }

    private void initTitleBar() {
        int i = this.mProductId;
        if (i == 12) {
            this.mTitleBar.setTitleView(getString(R.string.electricitydetails));
            this.mTvName1.setText(getString(R.string.cloudpower));
            this.mTvName2.setText(getString(R.string.useelectricity));
            this.mTvTip.setText(getString(R.string.syncelectricitytip));
        } else if (i == 6) {
            this.mTitleBar.setTitleView(getString(R.string.waterdetails));
            this.mTvName1.setText(getString(R.string.cloudwater));
            this.mTvName2.setText(getString(R.string.usewater));
            this.mTvTip.setText(getString(R.string.syncwatertip));
        } else if (i == 13) {
            this.mTitleBar.setTitleView(getString(R.string.airelectricitydetails));
            this.mTvName1.setText(getString(R.string.cloudpower));
            this.mTvName2.setText(getString(R.string.useelectricityair));
            this.mTvTip.setText(getString(R.string.syncairtip));
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        if (StringUtils.isNotEmpty(this.mBindElecMeterInfoBean.roomTotalKwh)) {
            this.mTvBalance1.setText(this.mBindElecMeterInfoBean.roomTotalKwh);
        }
        if (StringUtils.isNotEmpty(this.mBindElecMeterInfoBean.deviceCurrKwh)) {
            this.mTvBalance2.setText(this.mBindElecMeterInfoBean.deviceCurrKwh);
        }
        findViewById(R.id.btn_sycn).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceBalanceDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtil.isFastDoubleClick() || !V4DeviceBalanceDetailActivity.this.isNeedSync()) {
                    return;
                }
                PermissionUtil.requestPerssion(V4DeviceBalanceDetailActivity.this.getActivity(), 1, V4DeviceBalanceDetailActivity.this.permissionGrant);
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedSync() {
        if (!StringUtils.isEmpty(this.mBindElecMeterInfoBean.roomTotalKwh)) {
            return true;
        }
        int i = this.mProductId;
        if (i == 12 || i == 13) {
            ToastUtils.show(getActivity(), getString(R.string.elecisnull));
            return false;
        }
        if (i != 6) {
            return false;
        }
        ToastUtils.show(getActivity(), getString(R.string.waterisnull));
        return false;
    }

    private void netRecharge() {
        V4BusinessControllers.getInstance().netRecharge(getLoginAccount(), this.mBindElecMeterInfoBean.mac, new Listener<V4RechargeBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceBalanceDetailActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4DeviceBalanceDetailActivity.this.getActivity(), "同步中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4RechargeBean v4RechargeBean, Object... objArr) {
                super.onComplete(controller, v4RechargeBean, objArr);
                if (V4DeviceBalanceDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    V4DeviceRechargeActivity.launch(V4DeviceBalanceDetailActivity.this.getActivity(), V4DeviceBalanceDetailActivity.this.mBindElecMeterInfoBean.bluetoothMac, V4DeviceBalanceDetailActivity.this.mBindElecMeterInfoBean.mac, V4DeviceBalanceDetailActivity.this.mProductId, v4RechargeBean != null ? v4RechargeBean.sysRandom : "");
                    V4DeviceBalanceDetailActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4DeviceBalanceDetailActivity.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4DeviceBalanceDetailActivity.this.getActivity(), false);
                }
            }
        });
    }

    public void checkIsOpenBluetooth() {
        if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            netRecharge();
        } else {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200 && i2 == -1) {
            netRecharge();
        }
    }
}
