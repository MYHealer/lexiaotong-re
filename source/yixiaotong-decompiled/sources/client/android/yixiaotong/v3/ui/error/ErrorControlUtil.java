package client.android.yixiaotong.v3.ui.error;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.login.SchoolInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ErrorControlUtil {
    public static final int PAGE_DEVICEINFO = 2;
    public static final int PAGE_FIRST = 1;
    private static final String TAG = "ErrorControlUtil";
    private boolean mIsEnable;

    private boolean isNeedExitApp(int i) {
        return i == 1001 || i == -44;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    private ErrorControlUtil() {
        this.mIsEnable = true;
    }

    private static final class SingleHolder {
        private static final ErrorControlUtil INSTANCE = new ErrorControlUtil();

        private SingleHolder() {
        }
    }

    public static ErrorControlUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void onHideError(Account account, ClientException clientException, Activity activity, boolean z, int i, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (this.mIsEnable) {
            if (isNeedExitApp(clientException.getCode())) {
                ToastUtils.show(activity, clientException.getDetail());
                getSchoolInfo(account);
                exitLogin(activity);
                return;
            }
            LogUtil.e(TAG, "onError:" + LocalDataUtil.getIsEnableOffline(activity));
            if (LocalDataUtil.getIsEnableOffline(activity)) {
                LocalDataUtil.saveIsFirstOffline(activity, true);
                return;
            }
            LocalDataUtil.saveIsFirstOffline(activity, false);
            if (clientException.isNeedTip(clientException.getCode())) {
                SystemErrorTip.getInstance().showTipDialog(activity, clientException.getDetail());
                return;
            }
            V3ErrorTipActivity.launch(activity, str, clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            if (z) {
                activity.finish();
            }
        }
    }

    public void onError(Account account, ClientException clientException, Activity activity, boolean z, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (this.mIsEnable) {
            if (isNeedExitApp(clientException.getCode())) {
                ToastUtils.show(activity, clientException.getDetail());
                getSchoolInfo(account);
                exitLogin(activity);
                return;
            }
            LocalDataUtil.saveIsFirstOffline(activity, false);
            if (clientException.isNeedTip(clientException.getCode())) {
                SystemErrorTip.getInstance().showTipDialog(activity, clientException.getDetail());
                return;
            }
            V3ErrorTipActivity.launch(activity, str, clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            if (z) {
                activity.finish();
            }
        }
    }

    private void exitLogin(Activity activity) {
        AccountManager.getInstance().clearLoginAccount();
        LoginActivity.launch(activity);
        activity.finish();
    }

    private void getSchoolInfo(Account account) {
        V3BusinessControllers.getInstance().getSchoolInfo(account, new Listener<SchoolInfoBean>() { // from class: client.android.yixiaotong.v3.ui.error.ErrorControlUtil.1
        });
    }
}
