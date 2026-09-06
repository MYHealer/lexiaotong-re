package client.android.yixiaotong.ui.wash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.wash.WashParametersBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothDevice;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import client.android.yixiaotong.util.bluetooth.CommandUtils;
import client.android.yixiaotong.util.random.RandomUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WashSettingActivity extends BaseActivity implements BluetoothManager.Listener {
    public static final String EXTRA_MAC = "extra_mac";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_WALLET = "extra_wallet";
    private BluetoothDevice mBluetoothDevice;
    private BluetoothManager mBluetoothManager;
    Button mBtnSet;
    EditText mEdtAddress;
    EditText mVEtAddress;
    EditText mVEtAddress1;
    TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private String mMac = "";
    private String mDeviceName = "";

    static {
        StubApp.interface11(7749);
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onConnected(String str) {
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onConnecting(String str) {
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onConnectionFailed(String str) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDeviceFound(String str) {
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDisconnected(String str) {
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDiscoveryFinished() {
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDiscoveryStarted() {
    }

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mVEtAddress = (EditText) findViewById(R.id.v_et_address);
        this.mVEtAddress1 = (EditText) findViewById(R.id.v_et_address1);
        this.mEdtAddress = (EditText) findViewById(R.id.edit_address);
        this.mBtnSet = (Button) findViewById(R.id.btn_set);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) WashSettingActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("extra_mac", str);
        intent.putExtra("extra_name", str2);
        activity.startActivity(intent);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.wash.WashSettingActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WashSettingActivity.this.mVEtAddress1.getText().toString().trim().equals("") || WashSettingActivity.this.mVEtAddress.getText().toString().trim().equals("")) {
                ToastUtils.show(WashSettingActivity.this.getContext(), "请输入洗衣机蓝牙名称！");
            } else {
                WashSettingActivity.this.writeAddress();
            }
        }
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("设置洗衣机参数");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private String getName() {
        StringBuilder sb = new StringBuilder();
        String string = this.mVEtAddress.getText().toString();
        String string2 = this.mVEtAddress1.getText().toString();
        for (int i = 0; i < 3 - string2.length(); i++) {
            sb.append("0");
        }
        sb.append(string2 + x.A);
        for (int i2 = 0; i2 < 6 - string.length(); i2++) {
            sb.append("0");
        }
        sb.append(string);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeAddress() {
        String string = this.mVEtAddress.getText().toString();
        String string2 = this.mVEtAddress1.getText().toString();
        String strStringToHex = HexString.stringToHex(string);
        String strStringToHex2 = HexString.stringToHex(string2);
        String str = "";
        if (strStringToHex2.length() < 6) {
            String str2 = "";
            for (int i = 0; i < 3 - (strStringToHex2.length() / 2); i++) {
                str2 = str2 + BaseWrapper.ENTER_ID_TOOLKIT;
            }
            strStringToHex2 = str2 + strStringToHex2;
        } else if (strStringToHex2.length() > 6) {
            strStringToHex2 = strStringToHex2.substring(0, 6);
        }
        if (strStringToHex.length() < 12) {
            for (int i2 = 0; i2 < 6 - (strStringToHex.length() / 2); i2++) {
                str = str + BaseWrapper.ENTER_ID_TOOLKIT;
            }
            strStringToHex = str + strStringToHex;
        } else if (strStringToHex.length() > 12) {
            strStringToHex = strStringToHex.substring(0, 12);
        }
        this.mBluetoothManager.sendData("fe", this.mMac, HexString.hexToBuffer(CommandUtils.setAddressCommand(strStringToHex2 + HexString.stringToHex(x.A) + strStringToHex)));
    }

    private void updateInit() {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().WashUpdateInit(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().InvestorId, this.mBluetoothDevice.mDeviceHexID, this.mWalletModel.typeId, randNumMaxStringNonO, this.mEdtAddress.getText().toString(), getName(), new Listener<WashParametersBean>() { // from class: client.android.yixiaotong.ui.wash.WashSettingActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashParametersBean washParametersBean, Object... objArr) {
                if (washParametersBean == null || !washParametersBean.rand.equals(randNumMaxStringNonO)) {
                    ToastUtils.show(WashSettingActivity.this.getActivity(), "服务器下传数据有问题");
                } else {
                    ToastUtils.show(WashSettingActivity.this.getActivity(), "参数更新成功！");
                }
                WashSettingActivity.this.finish();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                ToastUtils.show(WashSettingActivity.this.getActivity(), clientException.getDetail());
                WashSettingActivity.this.finish();
            }
        });
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDataReceived(String str, byte[] bArr) {
        Log.e("test", "onDataReceived:" + HexString.bufferToHex(bArr));
        if (CommandUtils.isSetDeviceNameResult(bArr)) {
            if (CommandUtils.getReturnSetDeviceName(bArr)) {
                ToastUtils.show(getContext(), "名称写入成功");
                updateInit();
            } else {
                ToastUtils.show(getContext(), "名称写入失败:" + HexString.bufferToHex(bArr), 1);
                finish();
            }
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mBluetoothManager.setListener(this);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        BluetoothManager.getInstance().disConnectAll();
    }
}
