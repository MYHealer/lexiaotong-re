package client.android.yixiaotong.v3.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AdvDialog {
    private Activity mActivity;
    private Dialog mDialog;
    private LinearLayout mLinRoot;
    private TextView tv_postive;

    private AdvDialog() {
    }

    private static final class SigleHolder {
        public static final AdvDialog INSTANCE = new AdvDialog();

        private SigleHolder() {
        }
    }

    public static AdvDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity) {
        this.mActivity = activity;
        Dialog dialog = this.mDialog;
        if ((dialog == null || !dialog.isShowing()) && this.mActivity != null) {
            Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
            this.mDialog = dialog2;
            Window window = dialog2.getWindow();
            View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_adv_tip, (ViewGroup) null);
            this.tv_postive = (TextView) viewInflate.findViewById(R.id.btn_know);
            this.mLinRoot = (LinearLayout) viewInflate.findViewById(R.id.lin_root);
            this.mDialog.setContentView(viewInflate);
            this.mDialog.setCancelable(true);
            Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = defaultDisplay.getHeight();
            attributes.width = defaultDisplay.getWidth();
            window.setAttributes(attributes);
            this.mDialog.show();
            confirmOnclick();
        }
    }

    public void dissDialog() {
        Dialog dialog = this.mDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.mDialog.dismiss();
    }

    private void confirmOnclick() {
        this.mLinRoot.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.AdvDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdvDialog.this.mDialog != null) {
                    AdvDialog.this.mDialog.dismiss();
                }
            }
        });
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.AdvDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdvDialog.this.mDialog != null) {
                    AdvDialog.this.mDialog.dismiss();
                }
            }
        });
    }
}
