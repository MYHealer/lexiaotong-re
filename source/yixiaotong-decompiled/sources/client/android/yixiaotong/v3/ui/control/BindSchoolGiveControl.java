package client.android.yixiaotong.v3.ui.control;

import android.app.Activity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.RechargeGiftProgram;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.discountcoupon.DiscountCouponActivity;
import client.android.yixiaotong.v3.ui.discountcoupon.RedPackageActivity;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BindSchoolGiveControl {
    private static final String TAG = "BindSchoolGiveControl";
    private Account mAccount;
    private Activity mActivity;
    private String mGiveMoney;
    private String mInvesrorName;
    private boolean mIsEnable;
    private int mPreferentialType;
    private RechargeGiftProgram mRechargeGiftProgram;
    private String mTitleContent;

    public void init(Account account, Activity activity, String str) {
        this.mAccount = account;
        this.mActivity = activity;
        this.mTitleContent = str;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    /* synthetic */ BindSchoolGiveControl(AnonymousClass1 anonymousClass1) {
        this();
    }

    private BindSchoolGiveControl() {
        this.mIsEnable = true;
    }

    private static final class SigleHolder {
        public static final BindSchoolGiveControl INSTANCE = new BindSchoolGiveControl(null);

        private SigleHolder() {
        }
    }

    public static BindSchoolGiveControl getInstance() {
        return SigleHolder.INSTANCE;
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.ui.control.BindSchoolGiveControl$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
            InvestorInfoBean investorInfoBean = InvestorInfoUtilControl.getInstance().getInvestorInfoBean();
            if (investorInfoBean == null) {
                return;
            }
            String str = investorInfoBean.investorId;
            BindSchoolGiveControl.this.mInvesrorName = investorInfoBean.providerJson.providerName;
            if (StringUtils.isNotEmpty(BindSchoolGiveControl.this.mInvesrorName) && BindSchoolGiveControl.this.mInvesrorName.length() > 3 && BindSchoolGiveControl.this.mInvesrorName.endsWith("服务商")) {
                BindSchoolGiveControl bindSchoolGiveControl = BindSchoolGiveControl.this;
                bindSchoolGiveControl.mInvesrorName = bindSchoolGiveControl.mInvesrorName.substring(0, BindSchoolGiveControl.this.mInvesrorName.length() - 3);
            }
            String studentId = UserInfoUtilControl.getInstance().getStudentId();
            BindSchoolGiveControl.this.mRechargeGiftProgram = InvestorInfoUtilControl.getInstance().getBindRechargeGiftProgram();
            LogUtil.e(BindSchoolGiveControl.TAG, (BindSchoolGiveControl.this.mRechargeGiftProgram != null) + PPSLabelView.Code + schoolId + PPSLabelView.Code + str);
            if (BindSchoolGiveControl.this.mRechargeGiftProgram == null || BindSchoolGiveControl.this.mRechargeGiftProgram.giftJson == null || BindSchoolGiveControl.this.mRechargeGiftProgram.giftJson.size() <= 0) {
                return;
            }
            String str2 = BindSchoolGiveControl.this.mRechargeGiftProgram.id;
            String bindGiveID = LocalDataUtil.getBindGiveID(BindSchoolGiveControl.this.mActivity);
            String str3 = str2 + studentId;
            LogUtil.log("绑定赠送ID:" + str2 + "  " + bindGiveID + PPSLabelView.Code + studentId);
            LogUtil.e(BindSchoolGiveControl.TAG, "绑定赠送ID:" + str2 + "  " + bindGiveID + PPSLabelView.Code + studentId);
            if (StringUtils.isNotEmpty(bindGiveID) && str3.equals(bindGiveID)) {
                return;
            }
            BindSchoolGiveControl.this.mGiveMoney = DecimalUtil.divide(BindSchoolGiveControl.this.mRechargeGiftProgram.giftJson.get(0).preferentialAmount + "", "100");
            LocalDataUtil.saveBindGiveID(BindSchoolGiveControl.this.mActivity, str2 + studentId);
            V3BusinessControllers.getInstance().postBindSchoolGive(BindSchoolGiveControl.this.mAccount, schoolId, str, str2, studentId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.control.BindSchoolGiveControl.1.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (BindSchoolGiveControl.this.mIsEnable) {
                        TwoButtonDialog.getInstance().showDialog(BindSchoolGiveControl.this.mActivity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.control.BindSchoolGiveControl.1.1.1
                            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                            public void onCancle() {
                            }

                            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                            public void onConfirm() {
                                if (BindSchoolGiveControl.this.mPreferentialType == 3) {
                                    RedPackageActivity.launch(BindSchoolGiveControl.this.mActivity);
                                } else {
                                    DiscountCouponActivity.launch(BindSchoolGiveControl.this.mActivity);
                                }
                            }
                        }, "提示", String.format(BindSchoolGiveControl.this.mActivity.getResources().getString(R.string.givewallet_tip), BindSchoolGiveControl.this.mInvesrorName, BindSchoolGiveControl.this.getContent(0), BindSchoolGiveControl.this.mGiveMoney), "#ff6f32fd", "取消", "查看");
                    }
                }
            });
        }
    }

    public void bindSchoolGive() {
        MainThreadExecutor.getInstance().executeDelayed(new AnonymousClass1(), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getContent(int i) {
        RechargeGiftProgram rechargeGiftProgram = this.mRechargeGiftProgram;
        if (rechargeGiftProgram == null || rechargeGiftProgram.giftJson == null || this.mRechargeGiftProgram.giftJson.size() <= 0) {
            return "";
        }
        this.mPreferentialType = this.mRechargeGiftProgram.giftJson.get(i).preferentialType;
        if (this.mRechargeGiftProgram.giftJson.get(i).preferentialType == 1) {
            return "折扣券";
        }
        if (this.mRechargeGiftProgram.giftJson.get(i).preferentialType == 2) {
            return "折现券";
        }
        return this.mRechargeGiftProgram.giftJson.get(i).preferentialType == 3 ? "红包" : "";
    }

    private void showDialog(String str, final boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, "", str, "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.control.BindSchoolGiveControl.2
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                if (z) {
                    BindSchoolGiveControl.this.mActivity.finish();
                }
            }
        });
    }

    private void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.control.BindSchoolGiveControl.3
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                }
            }, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }
}
