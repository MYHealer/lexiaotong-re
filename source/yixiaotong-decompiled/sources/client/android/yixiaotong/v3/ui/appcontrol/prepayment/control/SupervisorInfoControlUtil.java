package client.android.yixiaotong.v3.ui.appcontrol.prepayment.control;

import android.app.Activity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentRedPackageAmountBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentWalletBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.comman.AppPlanFlagUtil;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.listener.CollectAndSetEmptyControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.wallet.RefundV3Activity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SupervisorInfoControlUtil {
    private static final String TAG = "PrepaymentWalletControlUtil";
    private static final int TYPEID = 18;
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private FlowState mFlowState;
    private boolean mIsEnable;
    private String mMachineId;
    private NBOr4GOpenControlUtil mNBOr4GOpenControlUtil;
    private String mOrderId;
    private PrepaymentCollectAndSetEmptyControlUtil mPrepaymentCollectAndSetEmptyControlUtil;
    private PrepaymentDeviceInfoBean mPrepaymentDeviceInfoBean;
    private PrepaymentWalletBean mPrepaymentWalletBean;
    private String mStudentHex;
    private String mTitleContent;
    private int mTypeId = 18;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;

    private enum FlowState {
        none,
        collect,
        collectend,
        setempty,
        setemptyend,
        rechargewater
    }

    public void init(Activity activity, Account account, String str, TypeInfoBaseInfoBean typeInfoBaseInfoBean, PrepaymentDeviceInfoBean prepaymentDeviceInfoBean, PrepaymentWalletBean prepaymentWalletBean) {
        this.mIsEnable = true;
        this.mActivity = activity;
        this.mAccount = account;
        this.mTitleContent = str;
        this.mTypeInfoBaseInfoBean = typeInfoBaseInfoBean;
        this.mPrepaymentDeviceInfoBean = prepaymentDeviceInfoBean;
        this.mPrepaymentWalletBean = prepaymentWalletBean;
        this.mMachineId = prepaymentDeviceInfoBean.machineId;
        this.mBluetoothDevice = new BluetoothDevice(this.mPrepaymentDeviceInfoBean.mac, this.mPrepaymentDeviceInfoBean.mac, 0);
        this.mPrepaymentCollectAndSetEmptyControlUtil = new PrepaymentCollectAndSetEmptyControlUtil();
        String str2 = UserInfoUtil.getInstance().getLoginAccountV3().studentHex;
        this.mStudentHex = str2;
        this.mPrepaymentCollectAndSetEmptyControlUtil.init(this.mActivity, this.mAccount, this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, this.mTypeId, str2, this.mTitleContent);
        this.mPrepaymentCollectAndSetEmptyControlUtil.setDeviceInfo(this.mPrepaymentDeviceInfoBean.deviceVer, this.mMachineId);
        this.mPrepaymentCollectAndSetEmptyControlUtil.setListener(new CollectAndSetEmptyControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.SupervisorInfoControlUtil.1
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CollectAndSetEmptyControlListener
            public void onCollectEnd() {
                SupervisorInfoControlUtil.this.mFlowState = FlowState.collectend;
                if (SupervisorInfoControlUtil.this.mIsEnable) {
                    ToastUtils.show(SupervisorInfoControlUtil.this.mActivity, "采集成功");
                    SupervisorInfoControlUtil.this.getWalletInfo();
                }
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CollectAndSetEmptyControlListener
            public void onSetEmpty() {
                SupervisorInfoControlUtil.this.mFlowState = FlowState.setemptyend;
                if (SupervisorInfoControlUtil.this.mIsEnable) {
                    ToastUtils.show(SupervisorInfoControlUtil.this.mActivity, "清空水量成功");
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SupervisorInfoControlUtil.this.startRefund();
                }
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CollectAndSetEmptyControlListener
            public void onFail(int i) {
                if (SupervisorInfoControlUtil.this.mIsEnable) {
                    SupervisorInfoControlUtil.this.onShowFail();
                }
            }
        });
        this.mFlowState = FlowState.none;
        this.mNBOr4GOpenControlUtil = new NBOr4GOpenControlUtil();
        String str3 = UserInfoUtil.getInstance().getLoginAccountV3().studentHex;
        this.mStudentHex = str3;
        this.mNBOr4GOpenControlUtil.init(this.mActivity, this.mAccount, this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 18, str3, this.mTitleContent);
        this.mNBOr4GOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.SupervisorInfoControlUtil.2
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                if (SupervisorInfoControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                }
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                if (SupervisorInfoControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    TwoButtonDialog.getInstance().showDialog(SupervisorInfoControlUtil.this.mActivity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.SupervisorInfoControlUtil.2.1
                        @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                        public void onCancle() {
                        }

                        @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                        public void onConfirm() {
                            SupervisorInfoControlUtil.this.startSetWater("");
                        }
                    }, "提示", "下发水量失败，请在设备前重试", "#ff0289fe", "取消", "下发水量");
                }
            }
        });
    }

    public void startCollect() {
        this.mFlowState = FlowState.collect;
        BaseMaterialDialog.showMaterialDialog(this.mActivity, "开始采集数据中.", false);
        this.mPrepaymentCollectAndSetEmptyControlUtil.startCollect();
    }

    public void startSetWater(String str) {
        this.mFlowState = FlowState.rechargewater;
        if (StringUtils.isNotEmpty(str)) {
            this.mOrderId = str;
        }
        BaseMaterialDialog.showMaterialDialog(this.mActivity, "开始下发水量数据中.", false);
        this.mNBOr4GOpenControlUtil.setDeviceInfo(this.mPrepaymentDeviceInfoBean.preferredCommunicationType, this.mPrepaymentDeviceInfoBean.mtype, this.mPrepaymentDeviceInfoBean.cnflag, this.mPrepaymentDeviceInfoBean.deviceVer, this.mPrepaymentDeviceInfoBean.machineId);
        this.mNBOr4GOpenControlUtil.setOrderIdPulse(this.mOrderId, 20);
        this.mNBOr4GOpenControlUtil.openStart();
    }

    public void onResume() {
        this.mIsEnable = true;
        PrepaymentCollectAndSetEmptyControlUtil prepaymentCollectAndSetEmptyControlUtil = this.mPrepaymentCollectAndSetEmptyControlUtil;
        if (prepaymentCollectAndSetEmptyControlUtil != null) {
            prepaymentCollectAndSetEmptyControlUtil.onResume();
        }
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = this.mNBOr4GOpenControlUtil;
        if (nBOr4GOpenControlUtil != null) {
            nBOr4GOpenControlUtil.onResume();
        }
        initBluetooth();
        BluetoothControlUtil.getInstance().onResume();
    }

    public void onPause() {
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        disconnect();
        BluetoothControlUtil.getInstance().onPause();
        PrepaymentCollectAndSetEmptyControlUtil prepaymentCollectAndSetEmptyControlUtil = this.mPrepaymentCollectAndSetEmptyControlUtil;
        if (prepaymentCollectAndSetEmptyControlUtil != null) {
            prepaymentCollectAndSetEmptyControlUtil.onPause();
        }
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = this.mNBOr4GOpenControlUtil;
        if (nBOr4GOpenControlUtil != null) {
            nBOr4GOpenControlUtil.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRefund() {
        String strDivide = DecimalUtil.divide(this.mPrepaymentWalletBean.money + "", "100");
        String strDivide2 = DecimalUtil.divide(this.mPrepaymentWalletBean.cashRedPackage + "", "100");
        final int i = this.mPrepaymentWalletBean.cashRedPackage + this.mPrepaymentWalletBean.money;
        TwoButtonDialog.getInstance().showDialog(this.mActivity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.SupervisorInfoControlUtil.3
            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                LocalDataUtil.saveIsNeedGetPrepaymentWalletInfo(SupervisorInfoControlUtil.this.mActivity, true);
                LocalDataUtil.savePrepaymentAddress(SupervisorInfoControlUtil.this.mActivity, SupervisorInfoControlUtil.this.mPrepaymentDeviceInfoBean.addressMsg + "," + SupervisorInfoControlUtil.this.mPrepaymentDeviceInfoBean.valveStatus);
                LogUtil.e(SupervisorInfoControlUtil.TAG, SupervisorInfoControlUtil.this.mPrepaymentDeviceInfoBean.addressMsg + "," + SupervisorInfoControlUtil.this.mPrepaymentDeviceInfoBean.valveStatus);
                RefundV3Activity.launch(SupervisorInfoControlUtil.this.mActivity, SupervisorInfoControlUtil.this.mPrepaymentDeviceInfoBean.machineId, SupervisorInfoControlUtil.this.mPrepaymentWalletBean.money, i, AppPlanFlagUtil.PLAN_PREPAYMENT);
            }
        }, "提示", String.format(this.mActivity.getResources().getString(R.string.refundprepaymentwallet_tip), strDivide, strDivide2, DecimalUtil.divide(i + "", "100")), "#ff0289fe", "取消", "继续退款");
    }

    public void initBluetooth() {
        BluetoothSDK.getInstance().init(this.mActivity);
        BluetoothControlUtil.getInstance().init(this.mActivity);
        BluetoothControlUtil.getInstance().setDeviceType(this.mPrepaymentDeviceInfoBean.deviceVer);
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.SupervisorInfoControlUtil.4
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.i(SupervisorInfoControlUtil.TAG, "onConnected:" + SupervisorInfoControlUtil.this.mFlowState);
                if (SupervisorInfoControlUtil.this.mFlowState == FlowState.rechargewater) {
                    SupervisorInfoControlUtil.this.mNBOr4GOpenControlUtil.connected();
                } else {
                    SupervisorInfoControlUtil.this.mPrepaymentCollectAndSetEmptyControlUtil.connected();
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.i(SupervisorInfoControlUtil.TAG, "onFail" + i + "  " + str + PPSLabelView.Code + SupervisorInfoControlUtil.this.mFlowState);
                if (str.equalsIgnoreCase("Discover") || str.equalsIgnoreCase("Connect")) {
                    str = "尝试重启手机蓝牙或靠近设备蓝牙再试";
                }
                ToastUtils.show(SupervisorInfoControlUtil.this.mActivity, str);
                if (SupervisorInfoControlUtil.this.mFlowState == FlowState.rechargewater) {
                    SupervisorInfoControlUtil.this.mNBOr4GOpenControlUtil.onBluetoothError(i, str);
                } else {
                    SupervisorInfoControlUtil.this.onShowFail();
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                LogUtil.i(SupervisorInfoControlUtil.TAG, "onReceivedData:" + str + PPSLabelView.Code + SupervisorInfoControlUtil.this.mFlowState);
                if (SupervisorInfoControlUtil.this.mFlowState == FlowState.rechargewater) {
                    SupervisorInfoControlUtil.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                } else {
                    SupervisorInfoControlUtil.this.mPrepaymentCollectAndSetEmptyControlUtil.onReceivedData(str);
                }
            }
        });
    }

    private void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    public void getWalletInfo() {
        V3BusinessControllers.getInstance().getPrepaymentWallet(this.mAccount, this.mMachineId, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, new Listener<PrepaymentWalletBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.SupervisorInfoControlUtil.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SupervisorInfoControlUtil.this.mActivity, "正在获取钱包余额..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PrepaymentWalletBean prepaymentWalletBean, Object... objArr) {
                if (SupervisorInfoControlUtil.this.mIsEnable) {
                    if (prepaymentWalletBean != null) {
                        SupervisorInfoControlUtil.this.mPrepaymentWalletBean = prepaymentWalletBean;
                        SupervisorInfoControlUtil.this.getRedPackageAmount();
                    } else {
                        SupervisorInfoControlUtil.this.showDialog("钱包余额异常,请联系管理员");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SupervisorInfoControlUtil.this.mIsEnable) {
                    SupervisorInfoControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRedPackageAmount() {
        V3BusinessControllers.getInstance().getPrepaymentRedPackageAmount(this.mAccount, this.mMachineId, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, new Listener<PrepaymentRedPackageAmountBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.SupervisorInfoControlUtil.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PrepaymentRedPackageAmountBean prepaymentRedPackageAmountBean, Object... objArr) {
                if (SupervisorInfoControlUtil.this.mIsEnable) {
                    if (prepaymentRedPackageAmountBean != null) {
                        SupervisorInfoControlUtil.this.mPrepaymentWalletBean.cashRedPackage = prepaymentRedPackageAmountBean.isRefund;
                        SupervisorInfoControlUtil.this.mPrepaymentWalletBean.redPackage = prepaymentRedPackageAmountBean.noRefund;
                    }
                    BaseMaterialDialog.setConnectMaterialDialog("正在清空水量中.");
                    SupervisorInfoControlUtil.this.mPrepaymentCollectAndSetEmptyControlUtil.startSetEmpty();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SupervisorInfoControlUtil.this.mIsEnable) {
                    SupervisorInfoControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    private void onError(int i, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V3ErrorTipActivity.launchBluetoothFail(this.mActivity, this.mTitleContent, str, i);
        this.mActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException, final boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.SupervisorInfoControlUtil.7
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    if (z) {
                        SupervisorInfoControlUtil.this.mActivity.finish();
                    }
                }
            }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(this.mActivity) + ")");
            return;
        }
        V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        if (z) {
            this.mActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, str);
    }

    private void showDialogNeedExit(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, "提示", str, "我知道了", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.SupervisorInfoControlUtil.8
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                SupervisorInfoControlUtil.this.mActivity.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShowFail() {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (this.mFlowState == FlowState.collect) {
            TwoButtonDialog.getInstance().showDialog(this.mActivity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.SupervisorInfoControlUtil.9
                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    SupervisorInfoControlUtil.this.startCollect();
                }
            }, "提示", "数据采集失败，请在设备前重试", "#ff0289fe", "取消", "重新采集");
        } else if (this.mFlowState == FlowState.setempty) {
            TwoButtonDialog.getInstance().showDialog(this.mActivity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.SupervisorInfoControlUtil.10
                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    SupervisorInfoControlUtil.this.startCollect();
                }
            }, "提示", "清空水量失败，请在设备前重试", "#ff0289fe", "取消", "重新采集");
        }
    }
}
