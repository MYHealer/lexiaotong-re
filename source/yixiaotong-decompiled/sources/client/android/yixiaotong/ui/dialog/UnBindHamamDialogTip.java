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
public class UnBindHamamDialogTip {
    private Activity mActivity;
    private Dialog mDialog;
    private UnBindDialogListener mUnBindDialogListener;
    private Button tvWait;
    private Button tv_postive;

    public interface UnBindDialogListener {
        void onCanle();

        void onConfirm();
    }

    public void showUnBindDialog(Activity activity, UnBindDialogListener unBindDialogListener, String str, String str2, String str3, String str4) {
        if (activity == null) {
            ToastUtils.show(activity, "activity为空");
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        this.mUnBindDialogListener = unBindDialogListener;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_unbindhamam, (ViewGroup) null);
        this.tvWait = (Button) viewInflate.findViewById(R.id.tv_wait);
        this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
        this.tvWait.setText(str4);
        this.tv_postive.setText(str3);
        ((TextView) viewInflate.findViewById(R.id.tv_content1)).setText(str);
        ((TextView) viewInflate.findViewById(R.id.tv_content2)).setText(str2);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.7d);
        window.setAttributes(attributes);
        waitOnclick();
        confirmOnclick();
        this.mDialog.show();
    }

    public void waitOnclick() {
        this.tvWait.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.UnBindHamamDialogTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UnBindHamamDialogTip.this.mDialog.dismiss();
            }
        });
    }

    public void confirmOnclick() {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.UnBindHamamDialogTip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UnBindHamamDialogTip.this.mDialog.dismiss();
                UnBindHamamDialogTip.this.mUnBindDialogListener.onConfirm();
            }
        });
    }
}
