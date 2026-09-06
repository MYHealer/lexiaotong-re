package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class NetTimeOutDialog {
    private Activity mActivity;
    private Dialog mDialog;
    private SystemErrorTip.SystemErrorDialogListener mSystemErrorDialogListener;
    private LinearLayout mlinMorehelp;
    private Button tv_postive;

    private NetTimeOutDialog() {
    }

    private static final class SigleHolder {
        public static final NetTimeOutDialog INSTANCE = new NetTimeOutDialog();

        private SigleHolder() {
        }
    }

    public static NetTimeOutDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showTipTimeOutDialog(Activity activity, SystemErrorTip.SystemErrorDialogListener systemErrorDialogListener) {
        showDialog(activity);
        this.mSystemErrorDialogListener = systemErrorDialogListener;
        confirmOnclick();
        morehelp();
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
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_neterror_tip, (ViewGroup) null);
        this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
        this.mlinMorehelp = (LinearLayout) viewInflate.findViewById(R.id.lin_morehelp);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
    }

    private void confirmOnclick() {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.NetTimeOutDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NetTimeOutDialog.this.mDialog != null) {
                    NetTimeOutDialog.this.mDialog.dismiss();
                }
                if (NetTimeOutDialog.this.mSystemErrorDialogListener != null) {
                    NetTimeOutDialog.this.mSystemErrorDialogListener.onConfirm();
                }
            }
        });
    }

    private void morehelp() {
        this.mlinMorehelp.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.NetTimeOutDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NetTimeOutDialog.this.mDialog != null) {
                    NetTimeOutDialog.this.mDialog.dismiss();
                }
                if (NetTimeOutDialog.this.mSystemErrorDialogListener != null) {
                    NetTimeOutDialog.this.mSystemErrorDialogListener.onConfirm();
                }
            }
        });
    }
}
