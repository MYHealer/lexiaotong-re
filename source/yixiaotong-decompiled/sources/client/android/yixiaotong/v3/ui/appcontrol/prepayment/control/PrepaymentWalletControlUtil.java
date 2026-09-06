package client.android.yixiaotong.v3.ui.appcontrol.prepayment.control;

import android.app.Activity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.alipay.AliPayUtils;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.icbcPay.ICBCPayUtils;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.card.CreateOrderBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.InvestoridAndSchoolId;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCardDetailBean;
import client.android.yixiaotong.v3.bean.prepayment.OpenDeviceInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentRedPackageAmountBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentWalletBean;
import client.android.yixiaotong.v3.bean.prepayment.SupervisorBean;
import client.android.yixiaotong.v3.bean.prepayment.UnFinishOrderBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.comman.AppPlanFlagUtil;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GCollectControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.listener.CollectControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.listener.ErrorControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.listener.PrepaymentControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.prepayment.RecordDetailActivity;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.wallet.controlutil.V3WalletControlUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfo;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.wxapi.WxPayUtils;
import com.gnete.upbc.cashier.GnetePayConfig;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PrepaymentWalletControlUtil {
    private static final String TAG = "PrepaymentWalletControlUtil";
    private static final int TYPEID = 18;
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private ErrorControlListener mErrorControlListener;
    private boolean mIsEnable;
    private String mMachineId;
    private NBOr4GCollectControlUtil mNBOr4GCollectControlUtil;
    private NBOr4GOpenControlUtil mNBOr4GOpenControlUtil;
    private String mOrderId;
    private PrepaymentControlListener mPrepaymentControlListener;
    private PrepaymentDeviceInfoBean mPrepaymentDeviceInfoBean;
    private PrepaymentWalletBean mPrepaymentWalletBean;
    private String mStudentHex;
    private String mTitleContent;
    private int mTypeId;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private boolean mIsNeedLoadOrderState = false;
    private int mOrderCount = 1;
    private boolean mIsOpenFail = false;
    private FlowState mFlowState = FlowState.opening;
    private int mPreferredCommunicationType = 1;
    private boolean mIsEnableRule = true;
    private int mICBCIndex = 0;

    private enum FlowState {
        none,
        opening,
        collect
    }

    public void setErrorListener(ErrorControlListener errorControlListener) {
        this.mErrorControlListener = errorControlListener;
    }

    public void setICBCIndex(int i) {
        this.mICBCIndex = i;
    }

    public void setListener(PrepaymentControlListener prepaymentControlListener) {
        this.mPrepaymentControlListener = prepaymentControlListener;
    }

    public void init(Activity activity, Account account, TypeInfoBaseInfoBean typeInfoBaseInfoBean, int i, String str, int i2) {
        this.mIsEnable = true;
        this.mActivity = activity;
        this.mAccount = account;
        this.mTypeInfoBaseInfoBean = typeInfoBaseInfoBean;
        this.mTypeId = i;
        this.mTitleContent = str;
        String typeIdMachineId = LocalDataUtil.getTypeIdMachineId(activity, 18);
        if (StringUtils.isNotEmpty(typeIdMachineId) && typeIdMachineId.split(";").length >= 3) {
            LogUtil.e(TAG, typeIdMachineId.split(";")[0] + "  " + typeIdMachineId.split(";")[1] + "  " + typeIdMachineId.split(";")[2]);
            this.mMachineId = typeIdMachineId.split(";")[0];
        } else {
            LocalDataUtil.saveTypeIdMachineId(this.mActivity, 18, "");
            showDialogNeedExit("数据异常，请重试");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        this.mBluetoothDevice = new BluetoothDevice(this.mPrepaymentDeviceInfoBean.mac, this.mPrepaymentDeviceInfoBean.mac, 0);
        this.mNBOr4GOpenControlUtil = new NBOr4GOpenControlUtil();
        String str = UserInfoUtil.getInstance().getLoginAccountV3().studentHex;
        this.mStudentHex = str;
        this.mNBOr4GOpenControlUtil.init(this.mActivity, this.mAccount, this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 18, str, this.mTitleContent);
        this.mNBOr4GOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.1
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                PrepaymentWalletControlUtil prepaymentWalletControlUtil = PrepaymentWalletControlUtil.this;
                prepaymentWalletControlUtil.showDialog(prepaymentWalletControlUtil.mActivity.getResources().getString(R.string.rechargesuccesstip));
                ToastUtils.show(PrepaymentWalletControlUtil.this.mActivity, "水量充值成功");
                BaseMaterialDialog.dissmisMaterialDialog();
                PrepaymentWalletControlUtil.this.waterAppendCallback();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                PrepaymentWalletControlUtil.this.mIsOpenFail = true;
            }
        });
        NBOr4GCollectControlUtil nBOr4GCollectControlUtil = new NBOr4GCollectControlUtil();
        this.mNBOr4GCollectControlUtil = nBOr4GCollectControlUtil;
        nBOr4GCollectControlUtil.init(this.mActivity, this.mAccount, this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 18, this.mStudentHex, this.mTitleContent);
        this.mNBOr4GCollectControlUtil.setDeviceInfo(this.mPrepaymentDeviceInfoBean.deviceVer, this.mMachineId);
        this.mNBOr4GCollectControlUtil.setListener(new CollectControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.2
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CollectControlListener
            public void onCollectEnd() {
                if (PrepaymentWalletControlUtil.this.mPrepaymentControlListener != null) {
                    PrepaymentWalletControlUtil.this.mPrepaymentControlListener.onCollectEnd(true);
                    PrepaymentWalletControlUtil.this.getWalletInfo(false);
                }
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CollectControlListener
            public void onFail() {
                if (PrepaymentWalletControlUtil.this.mPrepaymentControlListener != null) {
                    PrepaymentWalletControlUtil.this.mPrepaymentControlListener.onCollectEnd(false);
                }
            }
        });
    }

    public void onResume() {
        this.mIsEnable = true;
        initBluetooth();
        BluetoothControlUtil.getInstance().onResume();
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = this.mNBOr4GOpenControlUtil;
        if (nBOr4GOpenControlUtil != null) {
            nBOr4GOpenControlUtil.onResume();
        }
        NBOr4GCollectControlUtil nBOr4GCollectControlUtil = this.mNBOr4GCollectControlUtil;
        if (nBOr4GCollectControlUtil != null) {
            nBOr4GCollectControlUtil.onResume();
        }
        LogUtil.e(TAG, "onResume:" + this.mIsNeedLoadOrderState + "  " + this.mOrderId);
        if (this.mIsNeedLoadOrderState && StringUtils.isNotEmpty(this.mOrderId)) {
            getOrderState();
        }
        if (LocalDataUtil.getIsNeedGetPrepaymentWalletInfo(this.mActivity)) {
            getWalletInfo(false);
        }
        if (LocalDataUtil.getIsNeedGetPrepaymentSupervisorInfo(this.mActivity)) {
            getSupervisor(false);
        }
    }

    public void onPause() {
        this.mIsEnable = false;
        BluetoothControlUtil.getInstance().onPause();
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = this.mNBOr4GOpenControlUtil;
        if (nBOr4GOpenControlUtil != null) {
            nBOr4GOpenControlUtil.onPause();
        }
        NBOr4GCollectControlUtil nBOr4GCollectControlUtil = this.mNBOr4GCollectControlUtil;
        if (nBOr4GCollectControlUtil != null) {
            nBOr4GCollectControlUtil.onPause();
        }
    }

    public void getDeviceInfo() {
        V3BusinessControllers.getInstance().getDeviceInfo(this.mAccount, this.mMachineId, new Listener<PrepaymentDeviceInfoBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(PrepaymentWalletControlUtil.this.mActivity, "正在获取设备信息..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PrepaymentDeviceInfoBean prepaymentDeviceInfoBean, Object... objArr) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    if (prepaymentDeviceInfoBean == null || !StringUtils.isNotEmpty(prepaymentDeviceInfoBean.siteId) || !StringUtils.isNotEmpty(prepaymentDeviceInfoBean.addressMsg)) {
                        LocalDataUtil.saveTypeIdMachineId(PrepaymentWalletControlUtil.this.mActivity, 18, "");
                        PrepaymentWalletControlUtil.this.showDialogNeedExit("设备信息异常,请联系管理员");
                        return;
                    }
                    if (PrepaymentWalletControlUtil.this.mPrepaymentControlListener != null) {
                        PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean = new PrepaymentDeviceInfoBean();
                        PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.valveStatus = prepaymentDeviceInfoBean.valveStatus;
                        PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.addressMsg = prepaymentDeviceInfoBean.addressMsg;
                        PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.machineId = PrepaymentWalletControlUtil.this.mMachineId;
                        PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.siteId = prepaymentDeviceInfoBean.siteId;
                        PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.cnflag = prepaymentDeviceInfoBean.cnflag;
                        PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.mtype = prepaymentDeviceInfoBean.mtype;
                        PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.deviceVer = prepaymentDeviceInfoBean.deviceVer;
                        PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.mac = prepaymentDeviceInfoBean.mac;
                        PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.preferredCommunicationType = PrepaymentWalletControlUtil.this.mPreferredCommunicationType;
                        LocalDataUtil.saveTypeIdMachineId(PrepaymentWalletControlUtil.this.mActivity, 18, PrepaymentWalletControlUtil.this.mMachineId + ";" + prepaymentDeviceInfoBean.mac + ";" + prepaymentDeviceInfoBean.deviceVer + ";" + prepaymentDeviceInfoBean.siteId + ";" + prepaymentDeviceInfoBean.siteFlag);
                        PrepaymentWalletControlUtil.this.mPrepaymentControlListener.onDeviceInfo(PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean);
                        PrepaymentWalletControlUtil.this.initData();
                        PrepaymentWalletControlUtil.this.getWalletInfo(true);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    LocalDataUtil.saveTypeIdMachineId(PrepaymentWalletControlUtil.this.mActivity, 18, "");
                    PrepaymentWalletControlUtil.this.onError(clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPrepaymentDeductionRule() {
        String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        V3BusinessControllers.getInstance().checkPrepaymentDeductionRule(this.mAccount, InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, schoolId, this.mMachineId, new Listener<Integer>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Integer num, Object... objArr) {
                if (!PrepaymentWalletControlUtil.this.mIsEnable || num == null || num.intValue() == 1) {
                    return;
                }
                PrepaymentWalletControlUtil.this.mIsEnableRule = false;
                PrepaymentWalletControlUtil.this.showDialog(PrepaymentWalletControlUtil.this.mMachineId + "设备未配置扣费规则");
            }
        });
    }

    public void getWalletInfo(final boolean z) {
        V3BusinessControllers.getInstance().getPrepaymentWallet(this.mAccount, this.mMachineId, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, new Listener<PrepaymentWalletBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                LocalDataUtil.saveIsNeedGetPrepaymentWalletInfo(PrepaymentWalletControlUtil.this.mActivity, false);
                if (z) {
                    BaseMaterialDialog.showMaterialDialog(PrepaymentWalletControlUtil.this.mActivity, "正在获取钱包余额..", false);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PrepaymentWalletBean prepaymentWalletBean, Object... objArr) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    if (prepaymentWalletBean == null) {
                        if (z) {
                            SystemErrorTip.getInstance().showTipDialog(PrepaymentWalletControlUtil.this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.5.1
                                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                                public void onConfirm() {
                                    PrepaymentWalletControlUtil.this.getRedPackageAmount(z);
                                }
                            }, "钱包余额异常,请联系管理员");
                        }
                    } else if (PrepaymentWalletControlUtil.this.mPrepaymentControlListener != null) {
                        PrepaymentWalletControlUtil.this.mPrepaymentWalletBean = prepaymentWalletBean;
                        PrepaymentWalletControlUtil.this.mPrepaymentControlListener.onWalletInfo(prepaymentWalletBean);
                        PrepaymentWalletControlUtil.this.getRedPackageAmount(z);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    if (PrepaymentWalletControlUtil.this.mPrepaymentControlListener != null) {
                        PrepaymentWalletControlUtil.this.mPrepaymentControlListener.onWalletInfo(null);
                    }
                    PrepaymentWalletControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRedPackageAmount(final boolean z) {
        V3BusinessControllers.getInstance().getPrepaymentRedPackageAmount(this.mAccount, this.mMachineId, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, new Listener<PrepaymentRedPackageAmountBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PrepaymentRedPackageAmountBean prepaymentRedPackageAmountBean, Object... objArr) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    if (prepaymentRedPackageAmountBean != null) {
                        PrepaymentWalletControlUtil.this.mPrepaymentWalletBean.cashRedPackage = prepaymentRedPackageAmountBean.isRefund;
                        PrepaymentWalletControlUtil.this.mPrepaymentWalletBean.redPackage = prepaymentRedPackageAmountBean.noRefund;
                    }
                    if (PrepaymentWalletControlUtil.this.mPrepaymentControlListener != null) {
                        PrepaymentWalletControlUtil.this.mPrepaymentControlListener.onWalletInfo(PrepaymentWalletControlUtil.this.mPrepaymentWalletBean);
                    }
                    if (z) {
                        PrepaymentWalletControlUtil.this.getUseInfoByMachineId();
                        PrepaymentWalletControlUtil.this.checkPrepaymentDeductionRule();
                        PrepaymentWalletControlUtil.this.getSupervisor(z);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    PrepaymentWalletControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getUnFinishOrder() {
        if (this.mPrepaymentWalletBean == null) {
            return;
        }
        V3BusinessControllers.getInstance().getUnFinishOrder(this.mAccount, this.mMachineId, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, new Listener<List<UnFinishOrderBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(PrepaymentWalletControlUtil.this.mActivity, "正在获取订单信息..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, final List<UnFinishOrderBean> list, Object... objArr) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    TwoButtonDialog.getInstance().showDialog(PrepaymentWalletControlUtil.this.mActivity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.7.1
                        @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                        public void onCancle() {
                        }

                        @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                        public void onConfirm() {
                            BuyClubCardDetailBean buyClubCardDetailBean = new BuyClubCardDetailBean();
                            buyClubCardDetailBean.machineAddress = ((UnFinishOrderBean) list.get(0)).equipmentAddress;
                            buyClubCardDetailBean.orderId = ((UnFinishOrderBean) list.get(0)).id;
                            buyClubCardDetailBean.price = ((UnFinishOrderBean) list.get(0)).price;
                            buyClubCardDetailBean.statusFlag = 1;
                            buyClubCardDetailBean.payDateTime = ((UnFinishOrderBean) list.get(0)).payTime;
                            buyClubCardDetailBean.machineStatus = ((UnFinishOrderBean) list.get(0)).valveStatus;
                            buyClubCardDetailBean.studentName = ((UnFinishOrderBean) list.get(0)).studentName;
                            buyClubCardDetailBean.createDateTime = ((UnFinishOrderBean) list.get(0)).appendTime;
                            buyClubCardDetailBean.walletBalance = ((UnFinishOrderBean) list.get(0)).money;
                            OpenDeviceInfoBean openDeviceInfoBean = new OpenDeviceInfoBean();
                            openDeviceInfoBean.cnFlag = PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.cnflag;
                            openDeviceInfoBean.preferredCommunicationType = PrepaymentWalletControlUtil.this.mPreferredCommunicationType;
                            openDeviceInfoBean.type = PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.mtype;
                            RecordDetailActivity.launch(PrepaymentWalletControlUtil.this.mActivity, buyClubCardDetailBean, PrepaymentWalletControlUtil.this.mTypeInfoBaseInfoBean, PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean);
                        }
                    }, "提示", PrepaymentWalletControlUtil.this.mActivity.getResources().getString(R.string.unfinishordertip), "取消", "前往处理");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    PrepaymentWalletControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    public void getOrder(boolean z, int i, final int i2, String str, InvestorInfoBean investorInfoBean) {
        if (this.mPrepaymentWalletBean == null) {
            return;
        }
        if (!this.mIsEnableRule) {
            ToastUtils.show(this.mActivity, "未配置扣费规则，无法充值");
            return;
        }
        if (z) {
            this.mOrderCount = 1;
        }
        int schoolInfosIndex = UserInfoUtil.getInstance().getSchoolInfosIndex();
        UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
        String str2 = loginAccountV3.schoolInfoList.get(schoolInfosIndex).id + "";
        String str3 = loginAccountV3.schoolInfoList.get(schoolInfosIndex).schoolName + "";
        this.mIsNeedLoadOrderState = false;
        V3BusinessControllers.getInstance().postPrepaymentCreateOrders(this.mAccount, str2, investorInfoBean.investorId, 10, this.mMachineId, str, i, i2, null, investorInfoBean.companyName, str3, loginAccountV3.studentId, "", loginAccountV3.studentName, loginAccountV3.studentMobile, this.mPrepaymentDeviceInfoBean.siteId, this.mPrepaymentDeviceInfoBean.addressMsg, this.mPrepaymentDeviceInfoBean.valveStatus + "", new Listener<CreateOrderBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(PrepaymentWalletControlUtil.this.mActivity, "下单中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, CreateOrderBean createOrderBean, Object... objArr) {
                String str4;
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (createOrderBean == null || !StringUtils.isNotEmpty(createOrderBean.orderId)) {
                        ToastUtils.show(PrepaymentWalletControlUtil.this.mActivity, "下单失败!");
                        return;
                    }
                    PrepaymentWalletControlUtil.this.mOrderId = createOrderBean.orderId;
                    if (i2 == 1 && createOrderBean.payInfo != null) {
                        PrepaymentWalletControlUtil.this.mIsNeedLoadOrderState = true;
                        WxPayUtils.pay(PrepaymentWalletControlUtil.this.mActivity, createOrderBean.payInfo.appid, createOrderBean.payInfo.partnerid, createOrderBean.payInfo.prepayid, createOrderBean.payInfo.noncestr, createOrderBean.payInfo.timestamp, createOrderBean.payInfo.sign);
                        return;
                    }
                    if (i2 == 2 && createOrderBean.payInfo != null) {
                        if (createOrderBean.payInfo.mode == 0) {
                            str4 = createOrderBean.payInfo.orderString;
                        } else {
                            str4 = createOrderBean.payInfo.mode == 1 ? createOrderBean.payInfo.tradeNo : "";
                        }
                        LogUtil.e(PrepaymentWalletControlUtil.TAG, "paymsg:" + str4);
                        AliPayUtils.pay(PrepaymentWalletControlUtil.this.mActivity, str4, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.8.1
                            @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                            public void paySuccess() {
                                ToastUtils.show(PrepaymentWalletControlUtil.this.mActivity, "支付成功");
                                PrepaymentWalletControlUtil.this.mIsNeedLoadOrderState = true;
                                PrepaymentWalletControlUtil.this.getOrderState();
                            }

                            @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                            public void payWaitting() {
                                ToastUtils.show(PrepaymentWalletControlUtil.this.mActivity, "正在等待支付结果,稍后会收到服务器确认的支付结果");
                            }

                            @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                            public void payFail() {
                                ToastUtils.show(PrepaymentWalletControlUtil.this.mActivity, "支付失败");
                            }
                        });
                        return;
                    }
                    int i3 = i2;
                    if (i3 == 7) {
                        ToastUtils.show(PrepaymentWalletControlUtil.this.mActivity, "支付成功");
                        return;
                    }
                    if (i3 == 3) {
                        if (createOrderBean == null || createOrderBean.payInfo == null || createOrderBean.payInfo.msgBody == null) {
                            ToastUtils.show(PrepaymentWalletControlUtil.this.mActivity, "银联下单失败");
                            return;
                        } else if (createOrderBean.payInfo.msgBody.retCode.equals("00000")) {
                            GnetePayConfig.builder().createWXAPI(PrepaymentWalletControlUtil.this.mActivity, "wxd9320c1760b6d01f");
                            V3WalletControlUtil.getInstance().sendPayRequest(createOrderBean.payInfo.msgBody.chnlUrl, AppPlanFlagUtil.PLAN_PREPAYMENT, 0);
                            return;
                        } else {
                            SystemErrorTip.getInstance().showTipDialog(PrepaymentWalletControlUtil.this.mActivity, createOrderBean.payInfo.msgBody.retMsg);
                            return;
                        }
                    }
                    if (i3 != 12 || createOrderBean.payInfo == null) {
                        ToastUtils.show(PrepaymentWalletControlUtil.this.mActivity, "下单失败");
                    } else {
                        ICBCPayUtils.payAll(PrepaymentWalletControlUtil.this.mICBCIndex, createOrderBean.payInfo.appId, PrepaymentWalletControlUtil.this.mActivity, ICBCPayUtils.getUnionPayReq(createOrderBean.payInfo.appId, createOrderBean.payInfo.msgId, createOrderBean.payInfo.format, createOrderBean.payInfo.charset, createOrderBean.payInfo.encryptType, createOrderBean.payInfo.signType, createOrderBean.payInfo.merSignMsg, createOrderBean.payInfo.timestamp, createOrderBean.payInfo.ca, createOrderBean.payInfo.tranData, createOrderBean.payInfo.encryptKey), new ICBCPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.8.2
                            @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                            public void paySuccess() {
                                ToastUtils.show(PrepaymentWalletControlUtil.this.mActivity, "支付成功");
                                PrepaymentWalletControlUtil.this.mIsNeedLoadOrderState = true;
                                PrepaymentWalletControlUtil.this.getOrderState();
                            }

                            @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                            public void payWaitting() {
                                ToastUtils.show(PrepaymentWalletControlUtil.this.mActivity, "正在等待支付结果,稍后会收到服务器确认的支付结果");
                            }

                            @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                            public void payFail() {
                                ToastUtils.show(PrepaymentWalletControlUtil.this.mActivity, "支付失败");
                            }
                        });
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    PrepaymentWalletControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOrderState() {
        V3BusinessControllers.getInstance().getAppendOrderStatus(this.mAccount, this.mOrderId, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, new Listener<PrepaymentWalletBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                PrepaymentWalletControlUtil.this.mIsNeedLoadOrderState = false;
                BaseMaterialDialog.showMaterialDialog(PrepaymentWalletControlUtil.this.mActivity, "正在查看订单状态..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PrepaymentWalletBean prepaymentWalletBean, Object... objArr) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    if (prepaymentWalletBean == null) {
                        PrepaymentWalletControlUtil.this.showDialog(PrepaymentWalletControlUtil.this.mOrderId + "订单异常,请联系管理员");
                        return;
                    }
                    if (prepaymentWalletBean.appendStatus == 1) {
                        BaseMaterialDialog.setConnectMaterialDialog("开始写入水表..");
                        PrepaymentWalletControlUtil.this.getWalletInfo(false);
                        PrepaymentWalletControlUtil.this.mFlowState = FlowState.opening;
                        BluetoothControlUtil.getInstance().setDeviceType(PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.deviceVer);
                        PrepaymentWalletControlUtil.this.mNBOr4GOpenControlUtil.setDeviceInfo(PrepaymentWalletControlUtil.this.mPreferredCommunicationType, PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.mtype, PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.cnflag, PrepaymentWalletControlUtil.this.mPrepaymentDeviceInfoBean.deviceVer, PrepaymentWalletControlUtil.this.mMachineId);
                        PrepaymentWalletControlUtil.this.mNBOr4GOpenControlUtil.setOrderIdPulse(PrepaymentWalletControlUtil.this.mOrderId, 0);
                        PrepaymentWalletControlUtil.this.mNBOr4GOpenControlUtil.openStart();
                        return;
                    }
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(PrepaymentWalletControlUtil.this.mActivity, "订单未支付：" + PrepaymentWalletControlUtil.this.mOrderId);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    PrepaymentWalletControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSupervisor(final boolean z) {
        V3BusinessControllers.getInstance().getPrepaymentSupervisor(this.mAccount, this.mMachineId, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, new Listener<SupervisorBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                LocalDataUtil.saveIsNeedGetPrepaymentSupervisorInfo(PrepaymentWalletControlUtil.this.mActivity, false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SupervisorBean supervisorBean, Object... objArr) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    if (PrepaymentWalletControlUtil.this.mPrepaymentControlListener != null) {
                        PrepaymentWalletControlUtil.this.mPrepaymentControlListener.onSupervisorInfo(supervisorBean);
                    }
                    if (z) {
                        PrepaymentWalletControlUtil.this.getUnFinishOrder();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    PrepaymentWalletControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waterAppendCallback() {
        V3BusinessControllers.getInstance().waterAppendCallback(this.mAccount, this.mOrderId, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, 1, new Listener<BuyClubCardDetailBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.11
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BuyClubCardDetailBean buyClubCardDetailBean, Object... objArr) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
            }
        });
    }

    public void onStartCollect() {
        this.mFlowState = FlowState.collect;
        this.mNBOr4GCollectControlUtil.openStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getUseInfoByMachineId() {
        V3BusinessControllers.getInstance().getUseInfoByMachineId(this.mAccount, this.mMachineId, 18, new Listener<InvestoridAndSchoolId>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, InvestoridAndSchoolId investoridAndSchoolId, Object... objArr) {
                if (PrepaymentWalletControlUtil.this.mIsEnable && StringUtils.isNotEmpty(investoridAndSchoolId.investorId) && StringUtils.isNotEmpty(investoridAndSchoolId.schoolId)) {
                    LogUtil.d(PrepaymentWalletControlUtil.TAG, investoridAndSchoolId.schoolId + "  " + UserInfoUtilControl.getInstance().getSchoolId());
                    LogUtil.d(PrepaymentWalletControlUtil.TAG, investoridAndSchoolId.investorId + "  " + InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId);
                    if (!investoridAndSchoolId.schoolId.equals(UserInfoUtilControl.getInstance().getSchoolId())) {
                        List<SchoolInfosBean> list = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList;
                        boolean z = false;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).id == Long.parseLong(investoridAndSchoolId.schoolId)) {
                                UserInfoUtil.getInstance().saveSchoolInfosIndex(i);
                                z = true;
                            }
                        }
                        if (z) {
                            InvestorInfoUtil.getInstance().saveInvestorInfosIndex(0);
                            LocalDataUtil.saveIsNeedLoadInvestorInfo(PrepaymentWalletControlUtil.this.mActivity, true);
                            PrepaymentWalletControlUtil.this.getInvestorInfo(investoridAndSchoolId.investorId);
                            return;
                        }
                        return;
                    }
                    if (investoridAndSchoolId.investorId.equals(InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId)) {
                        return;
                    }
                    List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
                    for (int i2 = 0; i2 < investorInfosV3.size(); i2++) {
                        if (investorInfosV3.get(i2).investorInfo.investorId.equals(investoridAndSchoolId.investorId)) {
                            InvestorInfoUtil.getInstance().saveInvestorInfosIndex(i2);
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                boolean unused = PrepaymentWalletControlUtil.this.mIsEnable;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getInvestorInfo(final String str) {
        V3BusinessControllers.getInstance().getInvestorInfo(this.mAccount, new Listener<List<InvestorInfosBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.13
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<InvestorInfosBean> list, Object... objArr) {
                if (PrepaymentWalletControlUtil.this.mIsEnable) {
                    List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
                    for (int i = 0; i < investorInfosV3.size(); i++) {
                        if (investorInfosV3.get(i).investorInfo.investorId.equals(str)) {
                            InvestorInfoUtil.getInstance().saveInvestorInfosIndex(i);
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                boolean unused = PrepaymentWalletControlUtil.this.mIsEnable;
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
        PrepaymentControlListener prepaymentControlListener;
        BaseMaterialDialog.dissmisMaterialDialog();
        if (this.mFlowState == FlowState.collect && (prepaymentControlListener = this.mPrepaymentControlListener) != null) {
            prepaymentControlListener.onCollectEnd(false);
        }
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.14
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    if (z) {
                        PrepaymentWalletControlUtil.this.mActivity.finish();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogNeedExit(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, "提示", str, "我知道了", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.15
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                PrepaymentWalletControlUtil.this.mActivity.finish();
            }
        });
    }

    public void initBluetooth() {
        BluetoothSDK.getInstance().init(this.mActivity);
        BluetoothControlUtil.getInstance().init(this.mActivity);
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil.16
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.i(PrepaymentWalletControlUtil.TAG, "onConnected");
                if (PrepaymentWalletControlUtil.this.mFlowState == FlowState.opening) {
                    PrepaymentWalletControlUtil.this.mNBOr4GOpenControlUtil.connected();
                } else if (PrepaymentWalletControlUtil.this.mFlowState == FlowState.collect) {
                    PrepaymentWalletControlUtil.this.mNBOr4GCollectControlUtil.connected();
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.i(PrepaymentWalletControlUtil.TAG, "onFail" + i + "  " + str + PPSLabelView.Code + PrepaymentWalletControlUtil.this.mFlowState);
                String str2 = (str.equalsIgnoreCase("Discover") || str.equalsIgnoreCase("Connect")) ? "尝试重启手机或设备蓝牙再试" : str;
                if (PrepaymentWalletControlUtil.this.mFlowState == FlowState.opening) {
                    PrepaymentWalletControlUtil.this.mNBOr4GOpenControlUtil.onBluetoothError(i, str2);
                } else if (PrepaymentWalletControlUtil.this.mFlowState == FlowState.collect) {
                    if (PrepaymentWalletControlUtil.this.mPrepaymentControlListener != null) {
                        PrepaymentWalletControlUtil.this.mPrepaymentControlListener.onCollectEnd(false);
                    }
                    PrepaymentWalletControlUtil.this.disconnect();
                    PrepaymentWalletControlUtil.this.showDialog("更新余额失败" + str);
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                LogUtil.i(PrepaymentWalletControlUtil.TAG, "onReceivedData:" + str);
                if (PrepaymentWalletControlUtil.this.mFlowState == FlowState.opening) {
                    PrepaymentWalletControlUtil.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                } else if (PrepaymentWalletControlUtil.this.mFlowState == FlowState.collect) {
                    PrepaymentWalletControlUtil.this.mNBOr4GCollectControlUtil.onReceivedData(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }
}
