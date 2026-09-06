package client.android.yixiaotong.controller.error;

import android.app.Activity;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.error.ErrorTipActivity;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ErrorUtil {
    public static final int CODE_BATHUNBINDROOM = 7503;
    public static final int CODE_BATHUNPAY = 4115;
    public static final int CODE_BATHUNPERSSION = 5003;
    public static final int CODE_BATHUPLOADDATA = 6001;
    public static final int CODE_BINFED = 4127;
    public static final int CODE_FINISHED = 4007;
    public static final int CODE_FIRSTUSER = 4072;
    public static final int CODE_NOUSER = 2002;
    public static final int CODE_NOUSER1 = 7006;
    public static final int CODE_PSWESAY = 20011;
    public static final int CODE_PSWISEMPTY = 20010;
    public static final int CODE_RESETAUTHPSW = 3001;
    public static final int CODE_ROOMNOAMMETER = 4049;
    public static final int CODE_UNBINDROOM = 4048;
    public static final int CODE_UNFINISH = 4060;
    public static final int CODE_V3ACCOUNT = 1999;
    public static final int EXITAPP = 1001;
    public static final int EXITAPP1 = -44;
    public static final int NETWORK_ERROR = -1000;
    public static final int TIPCODE = -45;

    public static void onFailResult(Activity activity, String str, ClientException clientException, boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedExitApp(clientException.getCode())) {
            ToastUtils.show(activity, "当前用户已下线，请重新登录");
            AccountManager.getInstance().clearLoginAccount();
            LoginActivity.launch(activity);
            ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
            return;
        }
        if (clientException.isNeedTip(clientException.getCode())) {
            showDialog(clientException.getDetail(), activity, z);
            return;
        }
        ErrorTipActivity.launch(activity, str, "", clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        if (z) {
            activity.finish();
        }
    }

    public static void showDialog(String str, final Activity activity, boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (z) {
            SystemErrorTip.getInstance().showTipDialog(activity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.controller.error.ErrorUtil.1
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    activity.finish();
                }
            }, str);
        } else {
            SystemErrorTip.getInstance().showTipDialog(activity, str);
        }
    }

    public static void onFailBlueTooth(Activity activity, String str, String str2, int i, boolean z) {
        if (!StringUtils.isNotEmpty(str2)) {
            str2 = "连接设备失败";
        }
        ErrorTipActivity.launch(activity, str, "蓝牙连接失败", str2, i, 1);
        if (z) {
            activity.finish();
        }
    }
}
