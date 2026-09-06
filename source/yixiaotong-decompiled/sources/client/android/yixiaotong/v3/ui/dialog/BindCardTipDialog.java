package client.android.yixiaotong.v3.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BindCardTipDialog {
    private Activity mActivity;
    private Button mBtnConfirm;
    private Dialog mDialog;
    private ImageView mIvTop;
    private Listener mListener;

    public interface Listener {
        void onConfirm(String str);
    }

    private BindCardTipDialog() {
    }

    private static final class SigleHolder {
        public static final BindCardTipDialog INSTANCE = new BindCardTipDialog();

        private SigleHolder() {
        }
    }

    public static BindCardTipDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, Listener listener) {
        this.mActivity = activity;
        this.mListener = listener;
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || this.mActivity == null || this.mListener == null) {
            return;
        }
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_bindcard_tip, (ViewGroup) null);
        this.mIvTop = (ImageView) viewInflate.findViewById(R.id.iv_top);
        this.mBtnConfirm = (Button) viewInflate.findViewById(R.id.btn_comfirt);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.85d);
        window.setAttributes(attributes);
        this.mDialog.setCancelable(true);
        this.mDialog.show();
        confirmOnclick();
    }

    private void confirmOnclick() {
        this.mBtnConfirm.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.BindCardTipDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BindCardTipDialog.this.mDialog.dismiss();
            }
        });
        this.mIvTop.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.BindCardTipDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BindCardTipDialog.this.mDialog.dismiss();
            }
        });
    }
}
