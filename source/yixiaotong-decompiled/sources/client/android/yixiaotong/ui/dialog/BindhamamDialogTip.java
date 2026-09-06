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
public class BindhamamDialogTip {
    private Activity mActivity;
    private BindDialogListener mBindDialogListener;
    private Dialog mDialog;
    private Button tvWait;
    private Button tv_postive;

    public interface BindDialogListener {
        void onCanle();

        void onConfirm();
    }

    public void showBindDialog(Activity activity, BindDialogListener bindDialogListener, String str, String str2, String str3, String str4) {
        if (activity == null) {
            ToastUtils.show(activity, "activity为空");
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        this.mBindDialogListener = bindDialogListener;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_bindhamam, (ViewGroup) null);
        this.tvWait = (Button) viewInflate.findViewById(R.id.tv_wait);
        this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
        this.tvWait.setText(str3);
        this.tv_postive.setText(str4);
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
        this.tvWait.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.BindhamamDialogTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BindhamamDialogTip.this.mDialog.dismiss();
            }
        });
    }

    public void confirmOnclick() {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.BindhamamDialogTip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BindhamamDialogTip.this.mDialog.dismiss();
                BindhamamDialogTip.this.mBindDialogListener.onConfirm();
            }
        });
    }
}
