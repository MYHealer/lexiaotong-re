package client.android.yixiaotong.v3.ui.dialog;

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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PayServerTipDialog {
    private Activity mActivity;
    private Dialog mDialog;
    private Listener mListener;
    private Button tvWait;
    private Button tv_postive;

    public interface Listener {
        void onCancle();

        void onConfirm();
    }

    private PayServerTipDialog() {
    }

    private static final class SigleHolder {
        public static final PayServerTipDialog INSTANCE = new PayServerTipDialog();

        private SigleHolder() {
        }
    }

    public static PayServerTipDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, Listener listener, String str, String str2) {
        this.mActivity = activity;
        this.mListener = listener;
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || this.mActivity == null || this.mListener == null) {
            return;
        }
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_payserver_v3tip, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_content)).setText(str);
        ((TextView) viewInflate.findViewById(R.id.tv_content2)).setText(str2);
        this.tvWait = (Button) viewInflate.findViewById(R.id.tv_wait);
        this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        this.mDialog.show();
        waitOnclick();
        confirmOnclick();
    }

    private void waitOnclick() {
        this.tvWait.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.PayServerTipDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayServerTipDialog.this.mDialog.dismiss();
                PayServerTipDialog.this.mListener.onCancle();
            }
        });
    }

    private void confirmOnclick() {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.PayServerTipDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayServerTipDialog.this.mDialog.dismiss();
                PayServerTipDialog.this.mListener.onConfirm();
            }
        });
    }
}
