package client.android.yixiaotong.v3.ui.appcontrol.prepayment;

import android.app.Activity;
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
import client.android.yixiaotong.util.StringUtils;
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
public class RefundRecordDetailActivity extends BaseActivity {
    private static final String TAG = "RefundRecordDetailActivity";
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
    private TextView mTvPhone;
    private TextView mTvRechargeMoney;
    private TextView mTvRefundAccount;
    private TextView mTvRefundUserName;
    private TextView mTvState;
    private TextView mTvUpdateTime;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private int mTryCount = 0;
    private boolean mIsTrying = false;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RefundRecordDetailActivity.4
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 5) {
                return;
            }
            RefundRecordDetailActivity.this.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + RefundRecordDetailActivity.this.mPhone)));
        }
    };

    static {
        StubApp.interface11(9459);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, BuyClubCardDetailBean buyClubCardDetailBean, TypeInfoBaseInfoBean typeInfoBaseInfoBean, PrepaymentDeviceInfoBean prepaymentDeviceInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) RefundRecordDetailActivity.class).putExtra("bean1", buyClubCardDetailBean).putExtra("typeinfobean", typeInfoBaseInfoBean).putExtra("opendevicebean", prepaymentDeviceInfoBean));
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
        this.mTvRefundUserName = (TextView) findViewById(R.id.tv_refundusername);
        this.mTvPhone = (TextView) findViewById(R.id.tv_phone);
        this.mTvRefundAccount = (TextView) findViewById(R.id.tv_refundaccount);
        this.mTvCreateTime = (TextView) findViewById(R.id.tv_createtime);
        this.mTvOrderId = (TextView) findViewById(R.id.tv_orderid);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("退款订单");
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
        findViewById(R.id.btn_try).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RefundRecordDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m299xb37a0a69(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-prepayment-RefundRecordDetailActivity, reason: not valid java name */
    /* synthetic */ void m299xb37a0a69(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        handleTryButtonClick();
    }

    private void handleTryButtonClick() {
        if (this.mTryCount >= 3) {
            handlePhonePermissionRequest();
        } else {
            startRefundCancellationProcess();
        }
    }

    private void handlePhonePermissionRequest() {
        if (LocalDataUtil.getIsAgreed(getActivity(), 3)) {
            PermissionUtil.requestPerssion(getActivity(), 5, this.permissionGrant);
        } else {
            showPhonePermissionDialog();
        }
    }

    private void showPhonePermissionDialog() {
        SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RefundRecordDetailActivity.1
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                LocalDataUtil.savePermissIndex(RefundRecordDetailActivity.this.getActivity(), 3);
                PermissionUtil.requestPerssion(RefundRecordDetailActivity.this.getActivity(), 5, RefundRecordDetailActivity.this.permissionGrant);
            }
        }, "需要开启电话权限，用于能够使用拨打电话的功能");
    }

    private void startRefundCancellationProcess() {
        this.mIsTrying = true;
        this.mTryCount++;
        this.mBtnTry.setEnabled(false);
        this.mBtnTry.setBackgroundResource(R.drawable.shape_ff67b8fe_background8);
        this.mTvOrderState.setText("撤销退款中");
        this.mTvUpdateTime.setText("撤销成功后将重新下发水量");
        startTry();
    }

    private void initView() {
        this.mOrderId = this.mBuyClubCardDetailBean.orderId;
        this.mTvRechargeMoney.setText(DecimalUtil.divide(this.mBuyClubCardDetailBean.price + "", "100") + "元");
        if (this.mBuyClubCardDetailBean.statusFlag == 4 || this.mBuyClubCardDetailBean.statusFlag == 5) {
            this.mTvBalance.setText("到账金额  " + DecimalUtil.divide(this.mBuyClubCardDetailBean.payPrice + "", "100") + "元");
            this.mTvUpdateTime.setText("到账时间：" + (StringUtils.isNotEmpty(this.mBuyClubCardDetailBean.payDateTime) ? this.mBuyClubCardDetailBean.payDateTime : ""));
            this.mBtnTry.setVisibility(8);
        } else if (this.mBuyClubCardDetailBean.statusFlag == 1) {
            this.mImgEnd.setImageResource(R.mipmap.progress_end);
            this.mTvOrderState.setText("处理中");
            this.mTvOrderState.setTextColor(getResources().getColor(R.color.fff9a437));
            this.mTvBalance.setVisibility(8);
            this.mTvUpdateTime.setText("退款预计3-7个工作日到账");
            this.mBtnTry.setVisibility(8);
        } else if (this.mBuyClubCardDetailBean.statusFlag == 2) {
            this.mImgEnd.setImageResource(R.mipmap.progress_end);
            this.mTvOrderState.setText("撤销退款中");
            this.mTvOrderState.setTextColor(getResources().getColor(R.color.fff9a437));
            this.mTvBalance.setVisibility(8);
            this.mTvUpdateTime.setText("撤销成功后将重新下发水量");
            this.mBtnTry.setVisibility(0);
        } else if (this.mBuyClubCardDetailBean.statusFlag == 12) {
            this.mTvOrderState.setText("撤销退款成功");
            this.mTvBalance.setVisibility(8);
            this.mTvUpdateTime.setVisibility(8);
            this.mBtnTry.setVisibility(8);
        } else if (this.mBuyClubCardDetailBean.statusFlag == 3) {
            this.mImgEnd.setImageResource(R.mipmap.progress_end);
            this.mTvOrderState.setText("拒绝退款");
            this.mTvOrderState.setTextColor(getResources().getColor(R.color.fff9a437));
            this.mTvBalance.setVisibility(8);
            this.mTvUpdateTime.setText("拒绝退款后将重新下发水量");
            this.mBtnTry.setVisibility(0);
        } else if (this.mBuyClubCardDetailBean.statusFlag == 13) {
            this.mTvOrderState.setText("拒绝退款成功");
            this.mTvBalance.setVisibility(8);
            this.mTvUpdateTime.setVisibility(8);
            this.mBtnTry.setVisibility(8);
        } else if (this.mBuyClubCardDetailBean.statusFlag == 6) {
            this.mImgEnd.setImageResource(R.mipmap.progress_end);
            this.mTvOrderState.setText("后台撤销退款中");
            this.mTvOrderState.setTextColor(getResources().getColor(R.color.fff9a437));
            this.mTvBalance.setVisibility(8);
            this.mTvUpdateTime.setText("拒绝退款后将重新下发水量");
            this.mBtnTry.setVisibility(0);
        } else if (this.mBuyClubCardDetailBean.statusFlag == 16) {
            this.mTvOrderState.setText("后台取消退款成功");
            this.mTvBalance.setVisibility(8);
            this.mTvUpdateTime.setVisibility(8);
            this.mBtnTry.setVisibility(8);
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
        this.mTvRefundUserName.setText(this.mBuyClubCardDetailBean.studentName);
        this.mTvPhone.setText(this.mBuyClubCardDetailBean.studentMobile);
        this.mTvRefundAccount.setText(this.mBuyClubCardDetailBean.refundAccount);
        this.mTvCreateTime.setText(this.mBuyClubCardDetailBean.createDateTime);
        this.mTvOrderId.setText(this.mBuyClubCardDetailBean.orderId);
    }

    private void startTry() {
        int i;
        BluetoothControlUtil.getInstance().setDeviceType(this.mDeviceVer);
        this.mNBOr4GOpenControlUtil.setDeviceInfo(this.mOpenDeviceInfoBean.preferredCommunicationType, this.mOpenDeviceInfoBean.mtype, this.mOpenDeviceInfoBean.cnflag, this.mDeviceVer, this.mOpenDeviceInfoBean.machineId);
        if (this.mBuyClubCardDetailBean.statusFlag == 6) {
            i = 21;
        } else {
            i = this.mBuyClubCardDetailBean.statusFlag == 3 ? 22 : 20;
        }
        this.mNBOr4GOpenControlUtil.setOrderIdPulse(this.mOrderId, i);
        this.mNBOr4GOpenControlUtil.openStart();
    }

    private void initOpenControl() {
        this.mBluetoothDevice = new BluetoothDevice(this.mOpenDeviceInfoBean.mac, this.mOpenDeviceInfoBean.mac, 0);
        this.mDeviceVer = this.mOpenDeviceInfoBean.deviceVer;
        this.mNBOr4GOpenControlUtil = new NBOr4GOpenControlUtil();
        this.mStudentHex = UserInfoUtil.getInstance().getLoginAccountV3().studentHex;
        this.mNBOr4GOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 18, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mNBOr4GOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RefundRecordDetailActivity.2
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                RefundRecordDetailActivity.this.mIsTrying = false;
                RefundRecordDetailActivity.this.mImgEnd.setImageResource(R.mipmap.order_selected);
                RefundRecordDetailActivity.this.mTvOrderState.setText("撤销退款成功");
                RefundRecordDetailActivity.this.mTvOrderState.setTextColor(RefundRecordDetailActivity.this.getResources().getColor(R.color.ff0289fe));
                RefundRecordDetailActivity.this.mTvBalance.setVisibility(8);
                RefundRecordDetailActivity.this.mTvUpdateTime.setText("水量下发成功");
                RefundRecordDetailActivity.this.mBtnTry.setVisibility(8);
                RefundRecordDetailActivity.this.mBtnTry.setEnabled(false);
                RefundRecordDetailActivity.this.mBtnTry.setBackgroundResource(R.drawable.shape_ff67b8fe_background8);
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RefundRecordDetailActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RefundRecordDetailActivity.this.waterAppendCallback();
                    }
                }, 1000L);
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                RefundRecordDetailActivity.this.mIsTrying = false;
                LogUtil.e(RefundRecordDetailActivity.TAG, "onOpenFail");
                RefundRecordDetailActivity.this.mTvOrderState.setText("水量下发失败");
                RefundRecordDetailActivity.this.mTvUpdateTime.setText("请在设备旁手动重试下发");
                RefundRecordDetailActivity.this.mBtnTry.setEnabled(true);
                RefundRecordDetailActivity.this.mBtnTry.setBackgroundResource(R.drawable.shape_ff0089ff_background8);
                if (RefundRecordDetailActivity.this.mTryCount >= 3) {
                    RefundRecordDetailActivity.this.mBtnTry.setText("联系客服");
                }
            }
        });
    }

    public void initBluetooth() {
        BluetoothSDK.getInstance().init(getActivity());
        BluetoothControlUtil.getInstance().init(getActivity());
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RefundRecordDetailActivity.3
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.e(RefundRecordDetailActivity.TAG, "onConnected");
                RefundRecordDetailActivity.this.mNBOr4GOpenControlUtil.connected();
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.e(RefundRecordDetailActivity.TAG, "onFail" + i + "  " + str + PPSLabelView.Code);
                if (str.equalsIgnoreCase("Discover") || str.equalsIgnoreCase("Connect")) {
                    str = "尝试重启手机或设备蓝牙再试";
                }
                RefundRecordDetailActivity.this.mNBOr4GOpenControlUtil.onBluetoothError(i, str);
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                LogUtil.e(RefundRecordDetailActivity.TAG, "onReceivedData:" + str);
                RefundRecordDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waterAppendCallback() {
        int i;
        String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        String str = InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId;
        if (this.mBuyClubCardDetailBean.statusFlag == 6) {
            i = 6;
        } else {
            i = this.mBuyClubCardDetailBean.statusFlag == 3 ? 5 : 4;
        }
        V3BusinessControllers.getInstance().waterAppendCallback(getLoginAccount(), this.mOrderId, schoolId, str, i, new Listener<BuyClubCardDetailBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RefundRecordDetailActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BuyClubCardDetailBean buyClubCardDetailBean, Object... objArr) {
                boolean unused = RefundRecordDetailActivity.this.mIsEnable;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (!RefundRecordDetailActivity.this.mIsEnable || RefundRecordDetailActivity.this.mIsTrying) {
                    return;
                }
                RefundRecordDetailActivity.this.onError(clientException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.RefundRecordDetailActivity.6
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
