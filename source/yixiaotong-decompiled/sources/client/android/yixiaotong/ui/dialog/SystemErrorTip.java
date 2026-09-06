package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SystemErrorBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.exception.HttpException;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.executor.AsyncExecutor;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SystemErrorTip {
    private Activity mActivity;
    private Dialog mDialog;
    private boolean mFirstVisit;
    private boolean mNetOnline;
    private SystemErrorDialogListener mSystemErrorDialogListener;
    private int mUrlIndex;
    private TextView tv_postive;
    private TextView tv_title;
    private String[] urlArray;

    public interface SystemErrorDialogListener {
        void onConfirm();
    }

    private SystemErrorTip() {
        this.mFirstVisit = true;
        this.mNetOnline = false;
        this.mUrlIndex = 0;
        this.urlArray = new String[]{"http://3g.163.com", "http://xw.qq.com", "http://app.jd.com", "http://m.baidu.com", "http://m.taobao.com"};
    }

    private static final class SigleHolder {
        public static final SystemErrorTip INSTANCE = new SystemErrorTip();

        private SigleHolder() {
        }
    }

    public static SystemErrorTip getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showTipDialog(Activity activity, String str) {
        if (activity == null) {
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mSystemErrorDialogListener = null;
        if (StringUtils.isNotEmpty(str) && str.equals(HttpException.NETWORK_MSG)) {
            netWorkError(activity);
            return;
        }
        showDialog(activity, str);
        confirmOnclick();
        this.mDialog.show();
    }

    public void dismiss(Activity activity) {
        if (activity == null) {
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mSystemErrorDialogListener = null;
    }

    public void showTipDialog(Activity activity, SystemErrorDialogListener systemErrorDialogListener, String str) {
        if (activity == null) {
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mSystemErrorDialogListener = systemErrorDialogListener;
        if (StringUtils.isNotEmpty(str) && str.equals(HttpException.NETWORK_MSG)) {
            netWorkError(activity);
            return;
        }
        showDialog(activity, str);
        confirmOnclick();
        this.mDialog.show();
    }

    public void showTipDialog(Activity activity, SystemErrorDialogListener systemErrorDialogListener, String str, String str2) {
        if (activity == null) {
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mSystemErrorDialogListener = systemErrorDialogListener;
        if (StringUtils.isNotEmpty(str) && str.equals(HttpException.NETWORK_MSG)) {
            netWorkError(activity);
            return;
        }
        showDialog(activity, str);
        if (StringUtils.isNotEmpty(str2)) {
            this.tv_postive.setText(str2);
        }
        confirmOnclick();
        this.mDialog.show();
    }

    public void showTipDialog(Activity activity, String str, String str2, String str3) {
        if (activity == null) {
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mSystemErrorDialogListener = null;
        if (StringUtils.isNotEmpty(str2) && str2.equals(HttpException.NETWORK_MSG)) {
            netWorkError(activity);
            return;
        }
        showDialog(activity, str2);
        if (StringUtils.isNotEmpty(str3)) {
            this.tv_postive.setText(str3);
        }
        if (StringUtils.isNotEmpty(str)) {
            this.tv_title.setText(str);
        }
        confirmOnclick();
        this.mDialog.show();
    }

    public void showTipDialog(Activity activity, String str, String str2, String str3, boolean z, SystemErrorDialogListener systemErrorDialogListener) {
        if (activity == null) {
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mSystemErrorDialogListener = systemErrorDialogListener;
        if (StringUtils.isNotEmpty(str2) && str2.equals(HttpException.NETWORK_MSG)) {
            netWorkError(activity);
            return;
        }
        showDialog(activity, str2);
        if (StringUtils.isNotEmpty(str3)) {
            this.tv_postive.setText(str3);
        }
        if (StringUtils.isNotEmpty(str)) {
            this.tv_title.setText(str);
        }
        confirmOnclick();
        this.mDialog.setCancelable(z);
        this.mDialog.show();
    }

    private void showDialog(Activity activity, String str) {
        this.mActivity = activity;
        Dialog dialog = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog;
        Window window = dialog.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.systemerror_dialog_tip, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_content)).setText(str);
        this.tv_title = (TextView) viewInflate.findViewById(R.id.tv_title);
        this.tv_postive = (TextView) viewInflate.findViewById(R.id.tv_positive);
        if (LocalDataUtil.getPlatformInfo(this.mActivity) == 1) {
            this.tv_postive.setTextColor(this.mActivity.getResources().getColor(R.color.ff6f32fd));
        }
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(true);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.8d);
        window.setAttributes(attributes);
    }

    private void confirmOnclick() {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.SystemErrorTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SystemErrorTip.this.mDialog != null) {
                    SystemErrorTip.this.mDialog.dismiss();
                }
                if (SystemErrorTip.this.mSystemErrorDialogListener != null) {
                    SystemErrorTip.this.mSystemErrorDialogListener.onConfirm();
                }
            }
        });
    }

    private void netWorkError(Activity activity) {
        if (NetworkUtils.isNetworkAvailable(activity)) {
            showNetDialog(activity, "正在检测服务器是否可用，请稍后..");
            delayed(activity);
        } else {
            NetTimeOutDialog.getInstance().showTipTimeOutDialog(activity, this.mSystemErrorDialogListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getServerState(final Activity activity) {
        BusinessControllers.getInstance().getSystemErrorMsg(AccountManager.getInstance().getLoginAccount(), new Listener<SystemErrorBean>() { // from class: client.android.yixiaotong.ui.dialog.SystemErrorTip.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SystemErrorBean systemErrorBean, Object... objArr) {
                if (SystemErrorTip.this.mDialog == null || !SystemErrorTip.this.mDialog.isShowing()) {
                    return;
                }
                SystemErrorTip.this.mDialog.dismiss();
                if (systemErrorBean == null || !StringUtils.isNotEmpty(systemErrorBean.time)) {
                    NetTimeOutDialog.getInstance().showTipTimeOutDialog(activity, SystemErrorTip.this.mSystemErrorDialogListener);
                } else {
                    ServerMaintainDialog.getInstance().showServerErrorDialog(activity, systemErrorBean.time);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SystemErrorTip.this.mDialog == null || !SystemErrorTip.this.mDialog.isShowing()) {
                    return;
                }
                SystemErrorTip.this.mDialog.dismiss();
                NetTimeOutDialog.getInstance().showTipTimeOutDialog(activity, SystemErrorTip.this.mSystemErrorDialogListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delayed(final Activity activity) {
        networkIsOnline(activity);
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.dialog.SystemErrorTip.3
            @Override // java.lang.Runnable
            public void run() {
                if (SystemErrorTip.this.mNetOnline || SystemErrorTip.this.mDialog == null || !SystemErrorTip.this.mDialog.isShowing()) {
                    return;
                }
                if (SystemErrorTip.this.mFirstVisit) {
                    SystemErrorTip.this.mFirstVisit = false;
                    SystemErrorTip.this.delayed(activity);
                } else {
                    SystemErrorTip.this.mDialog.dismiss();
                    NetTimeOutDialog.getInstance().showTipTimeOutDialog(activity, SystemErrorTip.this.mSystemErrorDialogListener);
                }
            }
        }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    private void networkIsOnline(final Activity activity) {
        AsyncExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.dialog.SystemErrorTip.4
            @Override // java.lang.Runnable
            public void run() {
                int i;
                SystemErrorTip.this.mNetOnline = false;
                try {
                    double dRandom = Math.random();
                    while (true) {
                        i = (int) (dRandom * 5.0d);
                        if (i != SystemErrorTip.this.mUrlIndex) {
                            break;
                        } else {
                            dRandom = Math.random();
                        }
                    }
                    if (i >= 0 && i < SystemErrorTip.this.urlArray.length) {
                        SystemErrorTip.this.mUrlIndex = i;
                    }
                    new URL(SystemErrorTip.this.urlArray[SystemErrorTip.this.mUrlIndex]).openStream();
                    SystemErrorTip.this.mNetOnline = true;
                    SystemErrorTip.this.getServerState(activity);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private void showNetDialog(Activity activity, String str) {
        this.mActivity = activity;
        Dialog dialog = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog;
        Window window = dialog.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.blank_dialog, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_conetnt)).setText(str);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.6d);
        window.setAttributes(attributes);
        this.mDialog.show();
    }
}
