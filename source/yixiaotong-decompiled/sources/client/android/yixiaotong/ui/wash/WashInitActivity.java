package client.android.yixiaotong.ui.wash;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AreasBean;
import client.android.yixiaotong.controller.bean.wash.WashGetMachineid;
import client.android.yixiaotong.controller.bean.wash.WashParametersBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothDevice;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import client.android.yixiaotong.util.bluetooth.CommandUtils;
import client.android.yixiaotong.util.random.RandomUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WashInitActivity extends BaseActivity implements BluetoothManager.Listener {
    public static final String EXTRA_MAC = "extra_mac";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_WALLET = "extra_wallet";
    private BluetoothDevice mBluetoothDevice;
    private BluetoothManager mBluetoothManager;
    Button mBtnInit;
    EditText mEdtAddress;
    EditText mEdtBlueName;
    private MaterialDialog mMaterialDialog;
    TextView mTvInvestorid;
    TextView mTvMachineid;
    TextView mTvSchoolid;
    TextView mTvTypeid;
    EditText mVEtAddress;
    EditText mVEtAddress1;
    TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private String mMac = "";
    private String mDeviceName = "";

    static {
        StubApp.interface11(7688);
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
        this.mTvInvestorid = (TextView) findViewById(R.id.tv_investorid);
        this.mTvSchoolid = (TextView) findViewById(R.id.tv_schoolid);
        this.mTvMachineid = (TextView) findViewById(R.id.tv_machineid);
        this.mTvTypeid = (TextView) findViewById(R.id.tv_typeid);
        this.mBtnInit = (Button) findViewById(R.id.btn_init);
        this.mEdtAddress = (EditText) findViewById(R.id.edit_address);
        this.mEdtBlueName = (EditText) findViewById(R.id.edit_bluename);
        this.mVEtAddress = (EditText) findViewById(R.id.v_et_address);
        this.mVEtAddress1 = (EditText) findViewById(R.id.v_et_address1);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) WashInitActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("extra_mac", str);
        intent.putExtra("extra_name", str2);
        activity.startActivity(intent);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.wash.WashInitActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WashInitActivity.this.mVEtAddress1.getText().toString().trim().equals("") || WashInitActivity.this.mVEtAddress.getText().toString().trim().equals("")) {
                ToastUtils.show(WashInitActivity.this.getContext(), "请输入洗衣机蓝牙名称！");
            } else if (WashInitActivity.this.mEdtAddress.getText().toString().trim().equals("")) {
                ToastUtils.show(WashInitActivity.this.getContext(), "请输入安装地址！");
            } else {
                WashInitActivity.this.writeAddress();
            }
        }
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

    private void init() {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().WashInit(getLoginAccount(), this.mTvInvestorid.getText().toString(), "1", this.mMac, getName(), this.mWalletModel.typeId, this.mEdtAddress.getText().toString(), randNumMaxStringNonO, this.mTvMachineid.getText().toString(), new Listener<WashParametersBean>() { // from class: client.android.yixiaotong.ui.wash.WashInitActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                WashInitActivity.this.showDialog();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashParametersBean washParametersBean, Object... objArr) {
                if (washParametersBean == null || !StringUtils.isNotEmpty(washParametersBean.rand) || !washParametersBean.rand.equals(randNumMaxStringNonO) || !StringUtils.isNotEmpty(washParametersBean.machineid) || !washParametersBean.machineid.equals(WashInitActivity.this.mTvMachineid.getText().toString())) {
                    WashInitActivity.this.dismissDialog();
                    ToastUtils.show(WashInitActivity.this.getActivity(), "服务器下发数据有问题！");
                } else {
                    WashInitActivity.this.initFinish();
                    Log.e("test", washParametersBean.machineid);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                WashInitActivity.this.dismissDialog();
                ToastUtils.show(WashInitActivity.this.getActivity(), clientException.getDetail());
                WashInitActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFinish() {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().WashInitFinish(getLoginAccount(), this.mTvMachineid.getText().toString(), randNumMaxStringNonO, new Listener<WashParametersBean>() { // from class: client.android.yixiaotong.ui.wash.WashInitActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashParametersBean washParametersBean, Object... objArr) {
                WashInitActivity.this.dismissDialog();
                if (washParametersBean.rand.equals(randNumMaxStringNonO)) {
                    ToastUtils.show(WashInitActivity.this.getActivity(), "初始化成功！");
                } else {
                    ToastUtils.show(WashInitActivity.this.getActivity(), "服务器下发数据有问题！");
                }
                WashInitActivity.this.finish();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                WashInitActivity.this.dismissDialog();
                ToastUtils.show(WashInitActivity.this.getActivity(), clientException.getDetail());
                WashInitActivity.this.finish();
            }
        });
    }

    private void getMachineid() {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().WashGetMachineid(getLoginAccount(), this.mTvInvestorid.getText().toString(), "", this.mWalletModel.typeId, randNumMaxStringNonO, new Listener<WashGetMachineid>() { // from class: client.android.yixiaotong.ui.wash.WashInitActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashGetMachineid washGetMachineid, Object... objArr) {
                if (washGetMachineid == null || !randNumMaxStringNonO.equals(washGetMachineid.rand) || !StringUtils.isNotEmpty(washGetMachineid.machineid)) {
                    WashInitActivity.this.dismissDialog();
                    ToastUtils.show(WashInitActivity.this.getActivity(), "服务器下传数据有问题");
                } else {
                    WashInitActivity.this.mTvMachineid.setText(washGetMachineid.machineid);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                WashInitActivity.this.dismissDialog();
                ToastUtils.show(WashInitActivity.this.getActivity(), clientException.getDetail());
            }
        });
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("洗衣机初始化");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvInvestorid.setText(getLoginAccount().getAccountManagetStore().getUserInfo().InvestorId);
        this.mTvMachineid.setText(this.mBluetoothDevice.mDeviceHexID);
        this.mTvSchoolid.setText(getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "");
        this.mTvTypeid.setText(this.mWalletModel.name);
        initSchollSpinner();
    }

    private void initSchollSpinner() {
        BusinessControllers.getInstance().getSchoolList(getLoginAccount(), new Listener<List<AreasBean>>() { // from class: client.android.yixiaotong.ui.wash.WashInitActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<AreasBean> list, Object... objArr) {
                if (list == null) {
                    ToastUtils.show(WashInitActivity.this.getContext(), "服务出现问题,请稍候重试");
                    return;
                }
                new ArrayList();
                long j = WashInitActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().AreaId;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).ID == j) {
                        WashInitActivity.this.mTvSchoolid.setText(list.get(0).Name);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                ToastUtils.show(WashInitActivity.this.getContext(), clientException.getDetail());
                WashInitActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content("正在初始化中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.wash.WashInitActivity.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            }).show();
            this.mMaterialDialog = materialDialogShow;
            materialDialogShow.setCanceledOnTouchOutside(false);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        try {
            if (isShowingDialog()) {
                this.mMaterialDialog.dismiss();
                this.mMaterialDialog = null;
            }
        } catch (Exception unused) {
        }
    }

    private boolean isShowingDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        return materialDialog != null && materialDialog.isShowing();
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDataReceived(String str, byte[] bArr) {
        Log.e("test", "onDataReceived:" + HexString.bufferToHex(bArr));
        if (CommandUtils.isSetDeviceNameResult(bArr)) {
            dismissDialog();
            if (CommandUtils.getReturnSetDeviceName(bArr)) {
                ToastUtils.show(getContext(), "名称写入成功");
                init();
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
}
