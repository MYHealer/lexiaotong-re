package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RefundDialog {
    private Activity mActivity;
    private Dialog mDialog;

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.dialog.RefundDialog$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ RefundDialog(AnonymousClass1 anonymousClass1) {
        this();
    }

    private RefundDialog() {
    }

    private static final class SigleHolder {
        public static final RefundDialog INSTANCE = new RefundDialog(null);

        private SigleHolder() {
        }
    }

    public static RefundDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showTipTimeOutDialog(Activity activity) {
        showDialog(activity);
        this.mDialog.show();
    }

    private void showDialog(Activity activity) {
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        this.mDialog.setContentView(this.mActivity.getLayoutInflater().inflate(R.layout.dialog_refundrole, (ViewGroup) null));
        this.mDialog.setCancelable(true);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
    }
}
