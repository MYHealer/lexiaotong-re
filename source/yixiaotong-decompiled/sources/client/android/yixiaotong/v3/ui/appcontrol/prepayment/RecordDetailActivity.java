package client.android.yixiaotong.v3.ui.appcontrol.prepayment;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCardDetailBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfoBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RecordDetailActivity extends BaseActivity {
    private static final String TAG = "RecordDetailActivity";
    private static final int TYPEID = 18;
    private BluetoothDevice mBluetoothDevice;
    private Button mBtnTry;
    private BuyClubCardDetailBean mBuyClubCardDetailBean;
    private String mDeviceVer;
    private ImageView mImgEnd;
    private InvestorInfoBean mInvestorInfoBean;
    private boolean mIsEnable;
    private NBOr4GOpenControlUtil mNBOr4GOpenControlUtil;
    private PrepaymentDeviceInfoBean mOpenDeviceInfoBean;
    private String mOrderId;
    private String mPhone;
    private String mStudentHex;
    private TitleBar mTitleBar;
    private TextView mTvAddress;
    private TextView mTvBalance;
    private TextView mTvCreateTime;
    private TextView mTvMachineId;
    private TextView mTvOrderId;
    private TextView mTvOrderState;
    private TextView mTvPayTime;
    private TextView mTvRechargeMoney;
    private TextView mTvState;
    private TextView mTvUpdateTime;
    private TextView mTvUserName;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private int mTryCount = 0;
    private boolean mIsTrying = false;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RecordDetailActivity.4
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 5) {
                return;
            }
            RecordDetailActivity.this.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + RecordDetailActivity.this.mPhone)));
        }
    };

    static {
        StubApp.interface11(9450);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, BuyClubCardDetailBean buyClubCardDetailBean, TypeInfoBaseInfoBean typeInfoBaseInfoBean, PrepaymentDeviceInfoBean prepaymentDeviceInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) RecordDetailActivity.class).putExtra("bean1", buyClubCardDetailBean).putExtra("typeinfobean", typeInfoBaseInfoBean).putExtra("opendevicebean", prepaymentDeviceInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvRechargeMoney = (TextView) findViewById(R.id.tv_rechargemoney);
        this.mTvBalance = (TextView) findViewById(R.id.tv_balance);
        this.mTvUpdateTime = (TextView) findViewById(R.id.tv_updatetime);
        this.mImgEnd = (ImageView) findViewById(R.id.img_icon2);
        this.mTvOrderState = (TextView) findViewById(R.id.tv_state);
        this.mBtnTry = (Button) findViewById(R.id.btn_try);
        this.mTvMachineId = (TextView) findViewById(R.id.tv_deviceinfono);
        this.mTvAddress = (TextView) findViewById(R.id.tv_deviceaddress);
        this.mTvState = (TextView) findViewById(R.id.tv_devicestatue);
        this.mTvUserName = (TextView) findViewById(R.id.tv_username);
        this.mTvCreateTime = (TextView) findViewById(R.id.tv_createtime);
        this.mTvPayTime = (TextView) findViewById(R.id.tv_paytime);
        this.mTvOrderId = (TextView) findViewById(R.id.tv_orderid);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("充值订单");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initData() {
        if (InvestorInfoUtil.getInstance().getInvestorInfosV3() == null || InvestorInfoUtil.getInstance().getInvestorInfosV3().size() <= 0) {
            return;
        }
        InvestorInfoBean investorInfoBean = InvestorInfoUtil.getInstance().getInvestorInfosV3().get(InvestorInfoUtil.getInstance().getInvestorInfosIndex()).investorInfo;
        this.mInvestorInfoBean = investorInfoBean;
        this.mPhone = investorInfoBean.providerJson.phone;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        BluetoothControlUtil.getInstance().onResume();
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = this.mNBOr4GOpenControlUtil;
        if (nBOr4GOpenControlUtil != null) {
            nBOr4GOpenControlUtil.onResume();
        }
        if (this.mBuyClubCardDetailBean == null) {
            initView();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BluetoothControlUtil.getInstance().onPause();
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = this.mNBOr4GOpenControlUtil;
        if (nBOr4GOpenControlUtil != null) {
            nBOr4GOpenControlUtil.onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BluetoothControlUtil.getInstance().disconnect();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_try).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RecordDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m298x3e561ad1(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-prepayment-RecordDetailActivity, reason: not valid java name */
    /* synthetic */ void m298x3e561ad1(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        handleTryButtonClick();
    }

    private void handleTryButtonClick() {
        if (this.mTryCount >= 3) {
            if (LocalDataUtil.getIsAgreed(getActivity(), 3)) {
                PermissionUtil.requestPerssion(getActivity(), 5, this.permissionGrant);
                return;
            } else {
                showPhonePermissionDialog();
                return;
            }
        }
        checkIsOpenBluetooth();
    }

    private void showPhonePermissionDialog() {
        SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RecordDetailActivity.1
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                LocalDataUtil.savePermissIndex(RecordDetailActivity.this.getActivity(), 3);
                PermissionUtil.requestPerssion(RecordDetailActivity.this.getActivity(), 5, RecordDetailActivity.this.permissionGrant);
            }
        }, "需要开启电话权限，用于能够使用拨打电话的功能");
    }

    private void initView() {
        this.mOrderId = this.mBuyClubCardDetailBean.orderId;
        this.mTvRechargeMoney.setText(DecimalUtil.divide(this.mBuyClubCardDetailBean.price + "", "100") + "元");
        if (this.mBuyClubCardDetailBean.statusFlag == 4) {
            this.mTvUpdateTime.setText("更新时间：" + this.mBuyClubCardDetailBean.updateTime);
            this.mBtnTry.setVisibility(8);
        } else if (this.mBuyClubCardDetailBean.statusFlag == 1 || this.mBuyClubCardDetailBean.statusFlag == 5) {
            this.mImgEnd.setImageResource(R.mipmap.progress_end);
            this.mTvOrderState.setText("充值失败");
            this.mTvOrderState.setTextColor(getResources().getColor(R.color.fff9a437));
            this.mTvUpdateTime.setText("请在设备旁手动重试下发");
            this.mTvBalance.setVisibility(8);
        }
        this.mTvMachineId.setText(this.mOpenDeviceInfoBean.machineId);
        this.mTvAddress.setText(this.mBuyClubCardDetailBean.machineAddress);
        if (this.mBuyClubCardDetailBean.machineStatus != null && this.mBuyClubCardDetailBean.machineStatus.intValue() == 0) {
            this.mTvState.setText("开");
        } else if (this.mBuyClubCardDetailBean.machineStatus != null && this.mBuyClubCardDetailBean.machineStatus.intValue() == 1) {
            this.mTvState.setText("关");
        } else {
            this.mTvState.setText("未知");
        }
        this.mTvUserName.setText(this.mBuyClubCardDetailBean.studentMobile);
        this.mTvCreateTime.setText(this.mBuyClubCardDetailBean.createDateTime);
        this.mTvPayTime.setText(this.mBuyClubCardDetailBean.payDateTime);
        this.mTvOrderId.setText(this.mBuyClubCardDetailBean.orderId);
    }

    private void startTry() {
        BluetoothControlUtil.getInstance().setDeviceType(this.mDeviceVer);
        this.mNBOr4GOpenControlUtil.setDeviceInfo(this.mOpenDeviceInfoBean.preferredCommunicationType, this.mOpenDeviceInfoBean.mtype, this.mOpenDeviceInfoBean.cnflag, this.mDeviceVer, this.mOpenDeviceInfoBean.machineId);
        this.mNBOr4GOpenControlUtil.setOrderIdPulse(this.mOrderId, 0);
        this.mNBOr4GOpenControlUtil.openStart();
    }

    private void initOpenControl() {
        this.mBluetoothDevice = new BluetoothDevice(this.mOpenDeviceInfoBean.mac, this.mOpenDeviceInfoBean.mac, 0);
        this.mDeviceVer = this.mOpenDeviceInfoBean.deviceVer;
        this.mNBOr4GOpenControlUtil = new NBOr4GOpenControlUtil();
        this.mStudentHex = UserInfoUtil.getInstance().getLoginAccountV3().studentHex;
        this.mNBOr4GOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 18, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mNBOr4GOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RecordDetailActivity.2
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                RecordDetailActivity.this.mIsTrying = false;
                RecordDetailActivity.this.mImgEnd.setImageResource(R.mipmap.order_selected);
                RecordDetailActivity.this.mTvOrderState.setText("充值成功");
                RecordDetailActivity.this.mTvOrderState.setTextColor(RecordDetailActivity.this.getResources().getColor(R.color.ff0289fe));
                RecordDetailActivity.this.mBtnTry.setEnabled(false);
                RecordDetailActivity.this.mBtnTry.setBackgroundResource(R.drawable.shape_ff67b8fe_background8);
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RecordDetailActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordDetailActivity.this.waterAppendCallback();
                    }
                }, 1000L);
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                RecordDetailActivity.this.mIsTrying = false;
                LogUtil.e(RecordDetailActivity.TAG, "onOpenFail");
                RecordDetailActivity.this.mTvOrderState.setText("充值失败");
                RecordDetailActivity.this.mTvUpdateTime.setText("请在设备旁手动重试下发");
                RecordDetailActivity.this.mBtnTry.setEnabled(true);
                RecordDetailActivity.this.mBtnTry.setBackgroundResource(R.drawable.shape_ff0089ff_background8);
                if (RecordDetailActivity.this.mTryCount >= 3) {
                    RecordDetailActivity.this.mBtnTry.setText("联系客服");
                }
            }
        });
    }

    public void initBluetooth() {
        BluetoothSDK.getInstance().init(getActivity());
        BluetoothControlUtil.getInstance().init(getActivity());
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RecordDetailActivity.3
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.e(RecordDetailActivity.TAG, "onConnected");
                RecordDetailActivity.this.mNBOr4GOpenControlUtil.connected();
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.e(RecordDetailActivity.TAG, "onFail" + i + "  " + str + PPSLabelView.Code);
                if (str.equalsIgnoreCase("Discover") || str.equalsIgnoreCase("Connect")) {
                    str = "尝试重启手机或设备蓝牙再试";
                }
                RecordDetailActivity.this.mNBOr4GOpenControlUtil.onBluetoothError(i, str);
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                LogUtil.e(RecordDetailActivity.TAG, "onReceivedData:" + str);
                RecordDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
            }
        });
    }

    public void checkIsOpenBluetooth() {
        if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            this.mIsTrying = true;
            this.mTryCount++;
            this.mBtnTry.setEnabled(false);
            this.mBtnTry.setBackgroundResource(R.drawable.shape_ff67b8fe_background8);
            this.mTvOrderState.setText("处理中");
            this.mTvUpdateTime.setText("充值成功将更新余额信息");
            startTry();
            return;
        }
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waterAppendCallback() {
        V3BusinessControllers.getInstance().waterAppendCallback(getLoginAccount(), this.mOrderId, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, 1, new Listener<BuyClubCardDetailBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RecordDetailActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BuyClubCardDetailBean buyClubCardDetailBean, Object... objArr) {
                if (RecordDetailActivity.this.mIsEnable) {
                    RecordDetailActivity.this.mTvUpdateTime.setText("更新时间：" + buyClubCardDetailBean.updateTime);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (!RecordDetailActivity.this.mIsEnable || RecordDetailActivity.this.mIsTrying) {
                    return;
                }
                RecordDetailActivity.this.onError(clientException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RecordDetailActivity.6
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                }
            }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(getActivity()) + ")");
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    private void showDialog(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), str);
    }
}
