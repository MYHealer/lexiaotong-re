package client.android.yixiaotong.ui.deviceinit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class InitSetNBDeviceActivity extends BaseActivity {
    public static final String EXTRA_F0 = "extra_f0";
    public static final String EXTRA_MAC = "extra_mac";
    public static final String EXTRA_MACHINERAND = "extra_machinerand";
    public static final String EXTRA_MACHINEVER = "extra_machinever";
    public static final String EXTRA_WALLET = "extra_wallet";
    private String mAddress;
    private String mDeviceName;
    EditText mEtLiMoney;
    EditText mEtMaiChong;
    EditText mEtMaiChongQ;
    EditText mEtMaxMoney;
    EditText mEtMoney;
    EditText mEtShanQu;
    EditText mEtTime;
    EditText mEtType;
    private String mImei;
    private String mMachineid;
    private String mNbFlag;
    TitleBar mTitleBar;
    private WalletModel mWalletModel;
    private String mSetData = "";
    private String mF0Data = "";

    static {
        StubApp.interface11(6766);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, WalletModel walletModel, String str3, String str4, String str5, String str6) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) InitSetNBDeviceActivity.class).putExtra("deviceAddress", str).putExtra("walletmodel", walletModel).putExtra("machineid", str3).putExtra("devicename", str2).putExtra("nbflag", str4).putExtra("imei", str5).putExtra("f0data", str6));
        }
    }

    private void initViewNew() {
        this.mEtShanQu = (EditText) findViewById(R.id.et_shanqu);
        this.mEtMoney = (EditText) findViewById(R.id.et_money);
        this.mEtMaiChong = (EditText) findViewById(R.id.et_maichong);
        this.mEtMaiChongQ = (EditText) findViewById(R.id.et_maichongq);
        this.mEtTime = (EditText) findViewById(R.id.et_time);
        this.mEtType = (EditText) findViewById(R.id.et_type);
        this.mEtMaxMoney = (EditText) findViewById(R.id.et_maxmoney);
        this.mEtLiMoney = (EditText) findViewById(R.id.et_limoney);
        this.mTitleBar = (TitleBar) findViewById(R.id.tb_name);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("设备参数");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onSet(View view) {
        this.mSetData = "";
        initData();
        if (StringUtils.isNotEmpty(this.mSetData)) {
            InitDeviceV1Activity.launch(getActivity(), this.mAddress, this.mDeviceName, this.mWalletModel, this.mMachineid, this.mNbFlag, this.mImei, this.mSetData, this.mF0Data);
            finish();
        }
    }

    private void initData() {
        String string = this.mEtType.getText().toString();
        String string2 = this.mEtShanQu.getText().toString();
        String string3 = this.mEtMoney.getText().toString();
        String string4 = this.mEtMaiChong.getText().toString();
        String string5 = this.mEtMaiChongQ.getText().toString();
        String string6 = this.mEtTime.getText().toString();
        if (StringUtils.isEmpty(string2)) {
            ToastUtils.show(getContext(), "请输入扇区号");
            return;
        }
        if (StringUtils.isEmpty(string)) {
            ToastUtils.show(getContext(), "请输入设备类型");
            return;
        }
        if (StringUtils.isEmpty(this.mEtMaxMoney.getText().toString())) {
            ToastUtils.show(getContext(), "请输入设备限额");
            return;
        }
        if (StringUtils.isEmpty(this.mEtLiMoney.getText().toString())) {
            ToastUtils.show(getContext(), "请输入厘");
            return;
        }
        if (StringUtils.isEmpty(string3)) {
            ToastUtils.show(getContext(), "请输入热水费率（分）");
            return;
        }
        if (StringUtils.isEmpty(string4)) {
            ToastUtils.show(getContext(), "请输入热水费率（秒/脉冲）");
            return;
        }
        if (StringUtils.isEmpty(string5)) {
            ToastUtils.show(getContext(), "请输入脉冲Q值");
            return;
        }
        if (StringUtils.isEmpty(string6)) {
            ToastUtils.show(getContext(), "请输入报警时间");
            return;
        }
        if (Integer.parseInt(this.mEtMaxMoney.getText().toString()) > 50 || Integer.parseInt(this.mEtMaxMoney.getText().toString()) < 1) {
            ToastUtils.show(getContext(), "限额范围是1-50元");
            return;
        }
        int i = Integer.parseInt(this.mEtMaxMoney.getText().toString()) * 100;
        int i2 = Integer.parseInt(this.mEtMoney.getText().toString());
        int i3 = Integer.parseInt(string4);
        int i4 = Integer.parseInt(string5);
        int i5 = Integer.parseInt(string6);
        int i6 = Integer.parseInt(string2);
        if (!string.equals("01") && !string.equals("02") && !string.equals("00")) {
            ToastUtils.show(getContext(), "设备类型只能输入01或02");
            return;
        }
        if (i6 > 31 || i6 < 1) {
            ToastUtils.show(getContext(), "扇区区间是01-31");
            return;
        }
        if (i2 > 255) {
            ToastUtils.show(getContext(), "热水费率要小于255分");
            return;
        }
        if (i3 > 255) {
            ToastUtils.show(getContext(), "热水费率要小于255秒/脉冲）");
            return;
        }
        if (i4 > 255) {
            ToastUtils.show(getContext(), "脉冲Q值要小于255");
            return;
        }
        if (i5 > 255) {
            ToastUtils.show(getContext(), "报警时间要小于255");
            return;
        }
        String twoString = getTwoString(Integer.toHexString(i6));
        String fourString = getFourString(Integer.toHexString(i));
        String twoString2 = getTwoString(Integer.toHexString(i2));
        String twoString3 = getTwoString(Integer.toHexString(i3));
        String twoString4 = getTwoString(Integer.toHexString(i4));
        String twoString5 = getTwoString(Integer.toHexString(i5));
        String twoString6 = getTwoString(string);
        String twoString7 = getTwoString(this.mEtLiMoney.getText().toString());
        if (this.mWalletModel.typeId == 1) {
            this.mSetData = twoString2 + twoString3 + twoString7 + fourString + twoString6 + twoString4 + twoString5 + twoString;
        } else {
            this.mSetData = twoString2 + twoString3 + twoString7 + fourString + twoString6 + twoString4 + twoString5 + twoString;
        }
    }

    private String getTwoString(String str) {
        return (StringUtils.isNotEmpty(str) && str.length() == 1) ? "0" + str : str;
    }

    private String getFourString(String str) {
        if (StringUtils.isNotEmpty(str) && str.length() == 1) {
            return Constant.DEFAULT_CVN2 + str;
        }
        if (StringUtils.isNotEmpty(str) && str.length() == 2) {
            return "00" + str;
        }
        return (StringUtils.isNotEmpty(str) && str.length() == 3) ? "0" + str : str;
    }
}
