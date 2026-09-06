package client.android.yixiaotong.v3.ui.appcontrol.consumer;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.consumer.ConsumerCreateOrderBean;
import client.android.yixiaotong.v3.bean.consumer.ConsumerPriceInfoBean;
import client.android.yixiaotong.v3.bean.consumer.ConsumerQueryOrderBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetOrderBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.ZlPaymentJson;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.control.BeforeOpenControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.payutil.PayWayControlUtil;
import client.android.yixiaotong.v3.ui.dialog.ConsumerPriceBottonDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.scan.QrcodeUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfo;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ConsumerControlUtil {
    private static final int PAYFLAG = 1;
    private static final String TAG = "ConsumerControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private ConsumerPriceInfoBean mConsumerPriceInfoBean;
    private int mICBCIndex;
    private InvestorInfoBean mInvestorInfoBean;
    private boolean mIsEnable;
    private String mMac;
    private MachineByMacBean mMachineByMacBean;
    private String mOrderId;
    private String mOrderIdTemp;
    private int mPayFlagType;
    private ArrayList<Integer> mPayFlagTypeList;
    private int mPaymentFlag;
    private String mProductName;
    private String mQrcode;
    private String mTitleContent;
    private int mTypeId;
    private int mWalletBalance;
    private ZlPaymentJson mZlPaymentJson;

    public ConsumerControlUtil() {
        this.mIsEnable = true;
        this.mPayFlagTypeList = new ArrayList<>();
        this.mWalletBalance = 0;
        this.mICBCIndex = 1;
    }

    public ConsumerControlUtil(Activity activity, Account account, InvestorInfoBean investorInfoBean, String str, int i, int i2) {
        this.mIsEnable = true;
        this.mPayFlagTypeList = new ArrayList<>();
        this.mWalletBalance = 0;
        this.mICBCIndex = 1;
        this.mOrderId = "";
        this.mActivity = activity;
        this.mAccount = account;
        this.mInvestorInfoBean = investorInfoBean;
        this.mTitleContent = str;
        this.mPaymentFlag = i;
        this.mTypeId = i2;
        this.mZlPaymentJson = InvestorInfoUtilControl.getInstance().getZlPaymentJson(this.mTypeId);
        this.mPayFlagTypeList.clear();
        if (this.mZlPaymentJson != null) {
            for (int i3 = 0; i3 < this.mZlPaymentJson.payPaymentList.size(); i3++) {
                LogUtil.e(TAG, "getPayment:" + i3 + "  " + this.mZlPaymentJson.payPaymentList.get(i3).payFlag + "  " + this.mZlPaymentJson.payPaymentList.get(i3).payFlagType);
                if (this.mZlPaymentJson.payPaymentList.get(i3).payFlag == 1) {
                    this.mPayFlagTypeList.add(Integer.valueOf(this.mZlPaymentJson.payPaymentList.get(i3).payFlagType));
                }
            }
        }
        BeforeOpenControlUtil.getInstance().init(this.mAccount, this.mActivity);
    }

    public void onResume() {
        LogUtil.e(TAG, "onResume:" + this.mOrderId);
        this.mIsEnable = true;
        if (this.mPayFlagType != 2 && StringUtils.isNotEmpty(this.mOrderId)) {
            checkPayResult();
        }
        BeforeOpenControlUtil.getInstance().onResume();
    }

    public void onPause() {
        LogUtil.e(TAG, "onPause");
        this.mIsEnable = false;
        BeforeOpenControlUtil.getInstance().onPause();
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    public void setQrcode(String str) {
        this.mWalletBalance = 0;
        this.mQrcode = str;
        int i = this.mTypeId;
        if (i == 26) {
            this.mMac = QrcodeUtil.getMac(str.substring(0, 12));
            getDeviceInfo();
        } else if (i == 2) {
            getInfoByQRCode();
        }
    }

    private void getInfoByQRCode() {
        V3BusinessControllers.getInstance().getInfoByQRCode(this.mAccount, this.mQrcode, false, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("获取设备信息中.");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (ConsumerControlUtil.this.mIsEnable) {
                    if (machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.deviceMac)) {
                        ConsumerControlUtil.this.showDialog("设备未授权，请联系管理员", false);
                        return;
                    }
                    ConsumerControlUtil.this.mMac = machineByMacBean.deviceMac;
                    ConsumerControlUtil.this.getDeviceInfo();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ConsumerControlUtil.this.mIsEnable) {
                    ConsumerControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo() {
        V3BusinessControllers.getInstance().getMachineByMac(this.mAccount, this.mMac, this.mTypeId, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(ConsumerControlUtil.this.mActivity, "获取设备信息中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (ConsumerControlUtil.this.mIsEnable) {
                    if (machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.machineId)) {
                        ConsumerControlUtil.this.showDialog("设备未授权，请联系管理员" + ConsumerControlUtil.this.mMac, false);
                        return;
                    }
                    ConsumerControlUtil.this.mMachineByMacBean = machineByMacBean;
                    BeforeOpenControlUtil.getInstance().getUseInfoByMachineId(ConsumerControlUtil.this.mMachineByMacBean.machineId, ConsumerControlUtil.this.mTypeId);
                    if (ConsumerControlUtil.this.mPaymentFlag == 1) {
                        ConsumerControlUtil.this.getWalletInfo();
                    } else {
                        ConsumerControlUtil.this.getConsumerPrice();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ConsumerControlUtil.this.mIsEnable) {
                    ConsumerControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getWalletInfo() {
        V3BusinessControllers.getInstance().postGetWalletInfoByInvestorid(this.mAccount, this.mInvestorInfoBean.investorId, new Listener<WalletInfoBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("正在获取钱包信息..");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WalletInfoBean walletInfoBean, Object... objArr) {
                if (ConsumerControlUtil.this.mIsEnable) {
                    ConsumerControlUtil.this.mWalletBalance = walletInfoBean.money;
                    ConsumerControlUtil.this.getConsumerPrice();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ConsumerControlUtil.this.mIsEnable) {
                    ConsumerControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getConsumerPrice() {
        V3BusinessControllers.getInstance().getCalculatePrepaidMoney(this.mAccount, UserInfoUtilControl.getInstance().getSchoolId(), this.mInvestorInfoBean.investorId, this.mTypeId, UserInfoUtilControl.getInstance().getStudentId(), this.mMachineByMacBean.machineId, this.mMachineByMacBean.deviceVer, this.mTypeId == 2 ? 2 : 0, new Listener<ConsumerPriceInfoBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlUtil.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.setConnectMaterialDialog("加载订单支付金额信息..");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, ConsumerPriceInfoBean consumerPriceInfoBean, Object... objArr) {
                super.onComplete(controller, consumerPriceInfoBean, objArr);
                if (ConsumerControlUtil.this.mIsEnable) {
                    ConsumerControlUtil.this.mConsumerPriceInfoBean = consumerPriceInfoBean;
                    if (StringUtils.isNotEmpty(consumerPriceInfoBean.productName)) {
                        ConsumerControlUtil.this.mProductName = consumerPriceInfoBean.productName;
                    } else if (ConsumerControlUtil.this.mTypeId == 26) {
                        ConsumerControlUtil consumerControlUtil = ConsumerControlUtil.this;
                        consumerControlUtil.mProductName = consumerControlUtil.mMachineByMacBean.machineName;
                    }
                    ConsumerControlUtil.this.showPayDialog(consumerPriceInfoBean.payPrice, consumerPriceInfoBean.price, consumerPriceInfoBean.discountAmount, ConsumerControlUtil.this.mProductName);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ConsumerControlUtil.this.mIsEnable) {
                    ConsumerControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOrderId(final int i) {
        String str;
        String str2;
        int payPaymentFlag;
        int i2;
        this.mOrderId = "";
        String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        String studentId = UserInfoUtilControl.getInstance().getStudentId();
        UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
        if (loginAccountV3 != null) {
            str = loginAccountV3.studentName;
            str2 = loginAccountV3.studentMobile;
        } else {
            str = "";
            str2 = str;
        }
        this.mPayFlagType = 0;
        if (this.mPaymentFlag != 1) {
            this.mPayFlagType = this.mPayFlagTypeList.get(i).intValue();
            payPaymentFlag = InvestorInfoUtilControl.getInstance().getPayPaymentFlag(this.mTypeId);
            i2 = 1;
        } else {
            payPaymentFlag = 0;
            i2 = 0;
        }
        V3BusinessControllers.getInstance().postConsumerCreateOrder(this.mAccount, schoolId, this.mInvestorInfoBean.investorId, this.mTypeId, studentId, this.mMachineByMacBean.machineId, this.mProductName, payPaymentFlag, i2, this.mPayFlagType, "", str, str2, this.mMachineByMacBean.siteId, this.mMachineByMacBean.siteFlag, this.mConsumerPriceInfoBean.price, this.mConsumerPriceInfoBean.discountId, this.mConsumerPriceInfoBean.discountType, this.mConsumerPriceInfoBean.discountAmount, this.mMachineByMacBean.deviceVer, this.mTypeId == 2 ? 2 : 0, new Listener<ConsumerCreateOrderBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlUtil.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(ConsumerControlUtil.this.mActivity, "正在下单中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, ConsumerCreateOrderBean consumerCreateOrderBean, Object... objArr) {
                super.onComplete(controller, consumerCreateOrderBean, objArr);
                if (ConsumerControlUtil.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(consumerCreateOrderBean.orderId)) {
                        if (ConsumerControlUtil.this.mPaymentFlag == 1 || consumerCreateOrderBean.payInfo == null) {
                            ConsumerControlUtil.this.mOrderId = consumerCreateOrderBean.orderId;
                            ConsumerControlUtil.this.checkPayResult();
                            return;
                        } else {
                            if (consumerCreateOrderBean.payInfo != null) {
                                ConsumerControlUtil.this.mOrderId = consumerCreateOrderBean.orderId;
                                PayWayControlUtil.getInstance().setListener(new PayWayControlUtil.OnPayWayListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlUtil.5.1
                                    @Override // client.android.yixiaotong.v3.ui.appcontrol.payutil.PayWayControlUtil.OnPayWayListener
                                    public void onPayResult(int i3) {
                                        ConsumerControlUtil.this.checkPayResult();
                                    }
                                });
                                DMGetOrderBean dMGetOrderBean = new DMGetOrderBean();
                                dMGetOrderBean.payInfo = consumerCreateOrderBean.payInfo;
                                PayWayControlUtil.getInstance().pay(ConsumerControlUtil.this.mActivity, dMGetOrderBean, ((Integer) ConsumerControlUtil.this.mPayFlagTypeList.get(i)).intValue(), ConsumerControlUtil.this.mICBCIndex);
                                return;
                            }
                            ConsumerControlUtil.this.showDialog("下单失败，数据异常", false);
                            return;
                        }
                    }
                    ConsumerControlUtil.this.showDialog("下单失败，订单号异常", false);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ConsumerControlUtil.this.mIsEnable) {
                    ConsumerControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    public void checkPayResult() {
        LogUtil.e(TAG, "checkPayResult:");
        this.mOrderIdTemp = this.mOrderId;
        this.mOrderId = "";
        V3BusinessControllers.getInstance().postConsumerQueryOrder(this.mAccount, UserInfoUtilControl.getInstance().getSchoolId(), this.mInvestorInfoBean.investorId, this.mTypeId, this.mOrderIdTemp, new Listener<ConsumerQueryOrderBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlUtil.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                if (ConsumerControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.showMaterialDialog(ConsumerControlUtil.this.mActivity, "查询订单订单状态.", false);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, ConsumerQueryOrderBean consumerQueryOrderBean, Object... objArr) {
                super.onComplete(controller, consumerQueryOrderBean, objArr);
                if (ConsumerControlUtil.this.mIsEnable) {
                    if (consumerQueryOrderBean.statusFlag == 3) {
                        PaySuccessActivity.launch(ConsumerControlUtil.this.mActivity, ConsumerControlUtil.this.mOrderIdTemp, ConsumerControlUtil.this.mMachineByMacBean, ConsumerControlUtil.this.mMac, ConsumerControlUtil.this.mTypeId);
                    } else {
                        PaySuccessActivity.launch(ConsumerControlUtil.this.mActivity, "", ConsumerControlUtil.this.mMachineByMacBean, ConsumerControlUtil.this.mMac, ConsumerControlUtil.this.mTypeId);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ConsumerControlUtil.this.mIsEnable) {
                    ConsumerControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPayDialog(final int i, int i2, int i3, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        ConsumerPriceBottonDialog.getInstance().showDialog(this.mActivity, new ConsumerPriceBottonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlUtil.7
            @Override // client.android.yixiaotong.v3.ui.dialog.ConsumerPriceBottonDialog.Listener
            public void onConfirm(int i4) {
                if (ConsumerControlUtil.this.mPaymentFlag != 1 || ConsumerControlUtil.this.mWalletBalance >= i) {
                    ConsumerControlUtil.this.getOrderId(i4);
                } else {
                    ConsumerControlUtil.this.showDialogNoTrace("钱包余额不足，充值后再使用", false);
                }
            }
        }, this.mPaymentFlag, this.mPayFlagTypeList, this.mWalletBalance, i, i2, i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str, final boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, "", str + "\n(" + LocalDataUtil.getTraceID(this.mActivity) + ")", "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlUtil.8
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                if (z) {
                    ConsumerControlUtil.this.mActivity.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogNoTrace(String str, final boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, "", str, "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlUtil.9
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                if (z) {
                    ConsumerControlUtil.this.mActivity.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException, final boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlUtil.10
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    if (z) {
                        ConsumerControlUtil.this.mActivity.finish();
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
}
