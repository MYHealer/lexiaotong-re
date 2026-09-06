package client.android.yixiaotong.v3.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CashRedPackageDialog {
    private Activity mActivity;
    private Dialog mDialog;
    private Listener mListener;
    private TextView mTVRecord;
    private TextView mTvCancel;
    private TextView mTvRefundOrCancel;

    public interface Listener {
        void onCancle();

        void onConfirm1();

        void onConfirm2();
    }

    private CashRedPackageDialog() {
    }

    private static final class SigleHolder {
        public static final CashRedPackageDialog INSTANCE = new CashRedPackageDialog();

        private SigleHolder() {
        }
    }

    public static CashRedPackageDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, Listener listener, String str) {
        this.mActivity = activity;
        this.mListener = listener;
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || this.mActivity == null || this.mListener == null) {
            return;
        }
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_cashrepackage_refund, (ViewGroup) null);
        this.mTvRefundOrCancel = (TextView) viewInflate.findViewById(R.id.tv_refundorcancel);
        this.mTVRecord = (TextView) viewInflate.findViewById(R.id.tv_refundrecord);
        this.mTvCancel = (TextView) viewInflate.findViewById(R.id.tv_cancel);
        this.mTvRefundOrCancel.setText(str);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = defaultDisplay.getWidth();
        window.setAttributes(attributes);
        window.setGravity(80);
        this.mDialog.show();
        waitOnclick();
        confirmOnclick1();
        confirmOnclick2();
    }

    private void waitOnclick() {
        this.mTvCancel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.CashRedPackageDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CashRedPackageDialog.this.mDialog.dismiss();
                CashRedPackageDialog.this.mListener.onCancle();
            }
        });
    }

    private void confirmOnclick1() {
        this.mTvRefundOrCancel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.CashRedPackageDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CashRedPackageDialog.this.mDialog.dismiss();
                CashRedPackageDialog.this.mListener.onConfirm1();
            }
        });
    }

    private void confirmOnclick2() {
        this.mTVRecord.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.CashRedPackageDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CashRedPackageDialog.this.mDialog.dismiss();
                CashRedPackageDialog.this.mListener.onConfirm2();
            }
        });
    }
}
