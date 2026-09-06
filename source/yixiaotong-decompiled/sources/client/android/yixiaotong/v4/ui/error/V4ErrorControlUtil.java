package client.android.yixiaotong.v4.ui.error;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.ToastUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ErrorControlUtil {
    public static final int CODE_HASNPPAYORDER = 1004;
    public static final int CODE_ROOMHASDEVICE = 10;
    public static final int CODE_ROOMISLEADER = 33;
    public static final int PAGE_DEVICEINFO = 2;
    public static final int PAGE_FIRST = 1;
    private static final String TAG = "ErrorControlUtil";
    private boolean mIsEnable;

    private boolean isNeedExitApp(int i) {
        return i == 403;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void postCrashErrorLog(String str) {
    }

    public void postErrorLog(Activity activity, String str) {
    }

    private V4ErrorControlUtil() {
        this.mIsEnable = true;
    }

    private static final class SingleHolder {
        private static final V4ErrorControlUtil INSTANCE = new V4ErrorControlUtil();

        private SingleHolder() {
        }
    }

    public static V4ErrorControlUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void onError(Account account, ClientException clientException, Activity activity, boolean z, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (this.mIsEnable) {
            if (isNeedExitApp(clientException.getCode())) {
                ToastUtils.show(activity, clientException.getDetail());
                exitLogin(activity);
            } else {
                if (clientException.isNeedTip(clientException.getCode())) {
                    SystemErrorTip.getInstance().showTipDialog(activity, clientException.getDetail());
                    return;
                }
                V4ErrorTipActivity.launch(activity, str, clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
                if (z) {
                    activity.finish();
                }
            }
        }
    }

    public void showDialog(ClientException clientException, final Activity activity, final boolean z) {
        if (this.mIsEnable) {
            BaseMaterialDialog.dissmisMaterialDialog();
            if (isNeedExitApp(clientException.getCode())) {
                ToastUtils.show(activity, clientException.getDetail());
                exitLogin(activity);
                return;
            }
            SystemErrorTip.getInstance().showTipDialog(activity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil.1
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    if (z) {
                        activity.finish();
                    }
                }
            }, clientException.getDetail());
        }
        postErrorLog(activity, clientException.getDetail());
    }

    private void exitLogin(Activity activity) {
        AccountManager.getInstance().clearLoginAccount();
        LoginActivity.launch(activity);
        activity.finish();
    }
}
