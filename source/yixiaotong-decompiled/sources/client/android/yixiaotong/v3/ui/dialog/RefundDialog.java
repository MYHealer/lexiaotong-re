package client.android.yixiaotong.v3.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RefundDialog {
    private Activity mActivity;
    private Dialog mDialog;
    private RelativeLayout mRelRoot;

    private RefundDialog() {
    }

    private static final class SigleHolder {
        public static final RefundDialog INSTANCE = new RefundDialog();

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
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_refundrule_v3, (ViewGroup) null);
        this.mRelRoot = (RelativeLayout) viewInflate.findViewById(R.id.rel_root);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(true);
        setListener();
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.85d);
        window.setAttributes(attributes);
    }

    private void setListener() {
        this.mRelRoot.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.RefundDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RefundDialog.this.mDialog == null || !RefundDialog.this.mDialog.isShowing()) {
                    return;
                }
                RefundDialog.this.mDialog.dismiss();
            }
        });
    }
}
