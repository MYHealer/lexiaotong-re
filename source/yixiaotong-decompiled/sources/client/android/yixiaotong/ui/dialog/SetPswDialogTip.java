package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.hamam.HamamSetPswActivity;
import client.android.yixiaotong.ui.login.XiugaiAuthorizedPasswordActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SetPswDialogTip {
    private Activity mActivity;
    private Dialog mDialog;
    private Button tvWait;
    private TextView tvWait1;
    private Button tv_postive;

    public SetPswDialogTip(Activity activity) {
        this.mActivity = activity;
    }

    public void showSetPswDialog() {
        Dialog dialog = this.mDialog;
        if ((dialog == null || !dialog.isShowing()) && this.mActivity != null) {
            Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
            this.mDialog = dialog2;
            Window window = dialog2.getWindow();
            View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_setpsw, (ViewGroup) null);
            this.tvWait = (Button) viewInflate.findViewById(R.id.tv_wait);
            this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
            this.mDialog.setContentView(viewInflate);
            this.mDialog.setCancelable(false);
            Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.7d);
            window.setAttributes(attributes);
            this.mDialog.show();
        }
    }

    public void showSetPswDialog(String str) {
        Dialog dialog = this.mDialog;
        if (dialog == null || !dialog.isShowing()) {
            Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
            this.mDialog = dialog2;
            Window window = dialog2.getWindow();
            View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_setpsw1, (ViewGroup) null);
            this.tvWait1 = (TextView) viewInflate.findViewById(R.id.tv_wait);
            this.mDialog.setContentView(viewInflate);
            this.mDialog.setCancelable(false);
            Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.7d);
            window.setAttributes(attributes);
            this.mDialog.show();
        }
    }

    public void waitOnclick() {
        this.tvWait.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.SetPswDialogTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetPswDialogTip.this.mDialog.dismiss();
            }
        });
    }

    public void confirmOnclick() {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.SetPswDialogTip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetPswDialogTip.this.mDialog.dismiss();
                HamamSetPswActivity.launch(SetPswDialogTip.this.mActivity);
            }
        });
    }

    public void waitOnclick1() {
        this.tvWait1.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.SetPswDialogTip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetPswDialogTip.this.mDialog.dismiss();
                XiugaiAuthorizedPasswordActivity.launch(SetPswDialogTip.this.mActivity, "", "", 3);
                SetPswDialogTip.this.mActivity.finish();
            }
        });
    }
}
