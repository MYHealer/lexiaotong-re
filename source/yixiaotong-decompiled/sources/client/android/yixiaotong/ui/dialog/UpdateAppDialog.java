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
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.ToastUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UpdateAppDialog {
    private Button btnPostive;
    private Button btnWait;
    private Activity mActivity;
    private Dialog mDialog;
    private DialogListener mDialogListener;
    private TextView tvPostive;

    public interface DialogListener {
        void onCanle();

        void onConfirm();
    }

    private UpdateAppDialog() {
    }

    private static final class SigleHolder {
        public static final UpdateAppDialog INSTANCE = new UpdateAppDialog();

        private SigleHolder() {
        }
    }

    public static UpdateAppDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, DialogListener dialogListener, String str, String str2, boolean z) {
        if (activity == null) {
            ToastUtils.show(activity, "activity为空");
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        this.mDialogListener = dialogListener;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_updateapp, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.lin);
        this.btnWait = (Button) viewInflate.findViewById(R.id.btn_wait);
        this.btnPostive = (Button) viewInflate.findViewById(R.id.btn_positive);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_content);
        this.tvPostive = (TextView) viewInflate.findViewById(R.id.tv_positive);
        textView.setText(str);
        if (z) {
            linearLayout.setVisibility(8);
            this.tvPostive.setVisibility(0);
        } else {
            linearLayout.setVisibility(0);
            this.tvPostive.setVisibility(8);
            this.btnWait.setText(str2);
        }
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

    public void dismiss(Activity activity) {
        Dialog dialog;
        if (activity == null || (dialog = this.mDialog) == null || !dialog.isShowing()) {
            return;
        }
        this.mDialog.dismiss();
    }

    public void waitOnclick() {
        this.btnWait.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.UpdateAppDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateAppDialog.this.mDialog.dismiss();
                UpdateAppDialog.this.mDialogListener.onCanle();
            }
        });
    }

    public void confirmOnclick() {
        this.btnPostive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.UpdateAppDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateAppDialog.this.mDialog.dismiss();
                UpdateAppDialog.this.mDialogListener.onConfirm();
            }
        });
        this.tvPostive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.UpdateAppDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateAppDialog.this.mDialog.dismiss();
                UpdateAppDialog.this.mDialogListener.onConfirm();
            }
        });
    }
}
