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
import client.android.yixiaotong.util.ToastUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AppTipDialog {
    private Activity mActivity;
    private Dialog mDialog;
    private TipDialogListener mTipDialogListener;
    private Button tvWait;
    private Button tv_postive;

    public interface TipDialogListener {
        void onCanle();

        void onConfirt();
    }

    public void showTipDialog(Activity activity, TipDialogListener tipDialogListener, String str, String str2, String str3) {
        if (activity == null) {
            ToastUtils.show(activity, "activity为空");
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        this.mTipDialogListener = tipDialogListener;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.apptipdialog, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_content1)).setText(str);
        this.tvWait = (Button) viewInflate.findViewById(R.id.tv_wait);
        this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
        this.tvWait.setText(str2);
        this.tv_postive.setText(str3);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        waitOnclick();
        confirmOnclick();
        this.mDialog.show();
    }

    public void waitOnclick() {
        this.tvWait.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.AppTipDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppTipDialog.this.mDialog.dismiss();
                AppTipDialog.this.mTipDialogListener.onCanle();
            }
        });
    }

    public void confirmOnclick() {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.AppTipDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppTipDialog.this.mDialog.dismiss();
                AppTipDialog.this.mTipDialogListener.onConfirt();
            }
        });
    }
}
