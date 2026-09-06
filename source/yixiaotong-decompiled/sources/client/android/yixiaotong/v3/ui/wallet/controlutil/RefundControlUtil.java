package client.android.yixiaotong.v3.ui.wallet.controlutil;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.bean.card.CreateOrderBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderTypeIdBean;
import client.android.yixiaotong.v3.bean.prepayment.RefundBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RefundControlUtil {
    private static final int ALI = 2;
    public static final String TAG = "RefundControlUtil";
    private static final int WEIXIN = 1;
    private Account mAccount;
    private Activity mActivity;
    private boolean mIsEnable = true;
    private String mTitleContent;

    private void RefundControlUtil() {
    }

    public void init(Activity activity, Account account, String str) {
        this.mActivity = activity;
        this.mAccount = account;
        this.mTitleContent = str;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    private static class SingletonHolder {
        public static final RefundControlUtil INSTANCE = new RefundControlUtil();

        private SingletonHolder() {
        }
    }

    public static RefundControlUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void refund(int i, String str, int i2, int i3, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9 = UserInfoUtil.getInstance().getLoginAccountV3().studentId;
        String investorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        V3BusinessControllers.getInstance().postRefundOrders(this.mAccount, UserInfoUtilControl.getInstance().getSchoolId(), investorId, i, str, i2, i3, str2, str3, str4, str5, str6, str7, str9, str8, new Listener<CreateOrderBean>() { // from class: client.android.yixiaotong.v3.ui.wallet.controlutil.RefundControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(RefundControlUtil.this.mActivity, "退款中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, CreateOrderBean createOrderBean, Object... objArr) {
                if (RefundControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (createOrderBean != null) {
                        ToastUtils.show(RefundControlUtil.this.mActivity, "提交成功");
                        RefundControlUtil.this.mActivity.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (RefundControlUtil.this.mIsEnable) {
                    if (clientException.getCode() != -52) {
                        RefundControlUtil.this.onError(clientException);
                        return;
                    }
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(RefundControlUtil.this.mActivity, clientException.getDetail());
                    String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                    LogUtil.e(RefundControlUtil.TAG, "bean1:" + ifNull);
                    try {
                        NoPayOrderTypeIdBean noPayOrderTypeIdBean = (NoPayOrderTypeIdBean) GsonUtils.getInstance().parse(new TypeToken<NoPayOrderTypeIdBean>() { // from class: client.android.yixiaotong.v3.ui.wallet.controlutil.RefundControlUtil.1.1
                        }.getType(), ifNull);
                        LogUtil.e(RefundControlUtil.TAG, "bean:" + noPayOrderTypeIdBean.typeId);
                        ConsumeRecordActivity.launch(RefundControlUtil.this.mActivity, noPayOrderTypeIdBean.typeId, true);
                        RefundControlUtil.this.mActivity.finish();
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void refundCard(int i, String str, int i2, String str2) {
        String openId = LocalBusinessStore.getOpenId(this.mActivity);
        String investorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        V3BusinessControllers.getInstance().postRefundCard(this.mAccount, UserInfoUtilControl.getInstance().getSchoolId(), investorId, str, i2, i, UserInfoUtil.getInstance().getLoginAccountV3().studentMobile, openId, UserInfoUtil.getInstance().getLoginAccountV3().studentName, str2, new Listener<CreateOrderBean>() { // from class: client.android.yixiaotong.v3.ui.wallet.controlutil.RefundControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(RefundControlUtil.this.mActivity, "正在退款.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, CreateOrderBean createOrderBean, Object... objArr) {
                if (RefundControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (createOrderBean != null) {
                        ToastUtils.show(RefundControlUtil.this.mActivity, "提交成功");
                        RefundControlUtil.this.mActivity.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (RefundControlUtil.this.mIsEnable) {
                    RefundControlUtil.this.onError(clientException);
                }
            }
        });
    }

    public void refundPrepayment(final String str, int i, int i2, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8;
        String str9;
        String[] strArrSplit;
        String str10 = UserInfoUtil.getInstance().getLoginAccountV3().studentId;
        String prepaymentAddress = LocalDataUtil.getPrepaymentAddress(this.mActivity);
        if (!StringUtils.isNotEmpty(prepaymentAddress) || (strArrSplit = prepaymentAddress.split(",")) == null) {
            str8 = "";
            str9 = str8;
        } else {
            String str11 = strArrSplit.length > 0 ? strArrSplit[0] : "";
            if (strArrSplit.length > 1) {
                str9 = strArrSplit[1];
                str8 = str11;
            } else {
                str8 = str11;
                str9 = "";
            }
        }
        V3BusinessControllers.getInstance().refundOrderPrepayment(this.mAccount, str, i, i2, str3, InvestorInfoUtilControl.getInstance().getInvestorId(), UserInfoUtilControl.getInstance().getSchoolId(), str10, str2, str6, str7, str4, str5, str8, str9, new Listener<RefundBean>() { // from class: client.android.yixiaotong.v3.ui.wallet.controlutil.RefundControlUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(RefundControlUtil.this.mActivity, "退款中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, RefundBean refundBean, Object... objArr) {
                if (RefundControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (refundBean != null) {
                        RefundControlUtil.this.unlock(str);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (RefundControlUtil.this.mIsEnable) {
                    if (clientException.getCode() != -52) {
                        RefundControlUtil.this.onError(clientException);
                        return;
                    }
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(RefundControlUtil.this.mActivity, clientException.getDetail());
                    ConsumeRecordActivity.launch(RefundControlUtil.this.mActivity, 18, true);
                    RefundControlUtil.this.mActivity.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unlock(String str) {
        String str2;
        String typeIdMachineId = LocalDataUtil.getTypeIdMachineId(this.mActivity, 18);
        if (!StringUtils.isNotEmpty(typeIdMachineId) || typeIdMachineId.split(";").length < 3) {
            str2 = "";
        } else {
            LogUtil.e(TAG, typeIdMachineId.split(";")[0] + "  " + typeIdMachineId.split(";")[1] + "  " + typeIdMachineId.split(";")[2]);
            str2 = typeIdMachineId.split(";")[2];
        }
        V3BusinessControllers.getInstance().unlock(this.mAccount, str, str2, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.wallet.controlutil.RefundControlUtil.4
        });
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.wallet.controlutil.RefundControlUtil.5
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.show(RefundControlUtil.this.mActivity, "提交成功");
                RefundControlUtil.this.mActivity.finish();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }
}
