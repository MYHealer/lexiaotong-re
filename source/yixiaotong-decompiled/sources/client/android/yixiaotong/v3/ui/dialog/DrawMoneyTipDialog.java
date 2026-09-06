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
import client.android.yixiaotong.util.StringUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DrawMoneyTipDialog {
    private Activity mActivity;
    private Button mBtnCancel;
    private Button mBtnPosition;
    private Dialog mDialog;
    private Listener mListener;
    private TextView mTvContent;

    public interface Listener {
        void onCancle();

        void onConfirm();
    }

    private DrawMoneyTipDialog() {
    }

    private static final class SigleHolder {
        public static final DrawMoneyTipDialog INSTANCE = new DrawMoneyTipDialog();

        private SigleHolder() {
        }
    }

    public static DrawMoneyTipDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, Listener listener, String str, String str2, String str3) {
        this.mActivity = activity;
        this.mListener = listener;
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || this.mActivity == null || this.mListener == null) {
            return;
        }
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_drawmoney_tip, (ViewGroup) null);
        this.mTvContent = (TextView) viewInflate.findViewById(R.id.tv_content);
        this.mBtnCancel = (Button) viewInflate.findViewById(R.id.tv_canle);
        this.mBtnPosition = (Button) viewInflate.findViewById(R.id.tv_positive);
        this.mTvContent.setText(str);
        if (StringUtils.isNotEmpty(str2)) {
            this.mBtnCancel.setText(str2);
        }
        if (StringUtils.isNotEmpty(str3)) {
            this.mBtnPosition.setText(str3);
        }
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.8d);
        window.setAttributes(attributes);
        this.mDialog.setCancelable(false);
        this.mDialog.show();
        waitOnclick();
        confirmOnclick();
    }

    private void waitOnclick() {
        this.mBtnCancel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.DrawMoneyTipDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrawMoneyTipDialog.this.mDialog.dismiss();
                DrawMoneyTipDialog.this.mListener.onCancle();
            }
        });
    }

    private void confirmOnclick() {
        this.mBtnPosition.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.DrawMoneyTipDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrawMoneyTipDialog.this.mDialog.dismiss();
                DrawMoneyTipDialog.this.mListener.onConfirm();
            }
        });
    }
}
