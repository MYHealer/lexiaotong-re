package client.android.yixiaotong.v4.ui.app.consumer;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.v3.ui.dialog.ConsumerPriceBottonDialog;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ConsumerControlUtil {
    private static final String TAG = "V4ConsumerControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private boolean mIsEnable = false;

    private void getConsumerPrice() {
    }

    public void init(Activity activity, Account account) {
        this.mActivity = activity;
        this.mAccount = account;
    }

    public void setQrcode(String str) {
    }

    public void onResume() {
        LogUtil.e(TAG, "onResume:");
        this.mIsEnable = true;
    }

    public void onPause() {
        LogUtil.e(TAG, "onPause");
        this.mIsEnable = false;
    }

    private void showPayDialog(final int i, int i2, int i3, String str) {
        final int i4 = 1;
        V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
        if (loginAccountV4 != null) {
            final int i5 = Integer.parseInt(DecimalUtil.multiply(loginAccountV4.totalBalance, "100"));
            BaseMaterialDialog.dissmisMaterialDialog();
            ConsumerPriceBottonDialog.getInstance().showDialog(this.mActivity, new ConsumerPriceBottonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.app.consumer.V4ConsumerControlUtil.1
                @Override // client.android.yixiaotong.v3.ui.dialog.ConsumerPriceBottonDialog.Listener
                public void onConfirm(int i6) {
                    if (i4 != 1 || i5 >= i) {
                        return;
                    }
                    V4ConsumerControlUtil.this.showDialog("钱包余额不足，充值后再使用", false);
                }
            }, 1, null, i5, i, i2, i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str, final boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, "", str, "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.app.consumer.V4ConsumerControlUtil.2
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                if (z) {
                    V4ConsumerControlUtil.this.mActivity.finish();
                }
            }
        });
    }
}
