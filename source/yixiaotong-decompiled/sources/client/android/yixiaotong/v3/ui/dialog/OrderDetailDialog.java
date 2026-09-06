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
import client.android.yixiaotong.util.DecimalUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class OrderDetailDialog {
    private Activity mActivity;
    private Button mBtnCancel;
    private Button mBtnPay;
    private Dialog mDialog;
    private Listener mListener;
    private TextView mTvOrderDetail;

    public interface Listener {
        void onCancle();

        void onConfirm();
    }

    private OrderDetailDialog() {
    }

    private static final class SigleHolder {
        public static final OrderDetailDialog INSTANCE = new OrderDetailDialog();

        private SigleHolder() {
        }
    }

    public static OrderDetailDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, Listener listener, int i, String str, String str2) {
        this.mActivity = activity;
        this.mListener = listener;
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || this.mActivity == null || this.mListener == null) {
            return;
        }
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_order_detail, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_meony);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_orderno);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_time);
        this.mTvOrderDetail = (TextView) viewInflate.findViewById(R.id.tv_orderdetail);
        textView.setText(textView.getText().toString() + DecimalUtil.divide(i + "", "100"));
        textView2.setText(textView2.getText().toString() + str);
        textView3.setText(textView3.getText().toString() + str2);
        this.mBtnPay = (Button) viewInflate.findViewById(R.id.btn_pay);
        this.mBtnCancel = (Button) viewInflate.findViewById(R.id.btn_cancel);
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
        this.mTvOrderDetail.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.OrderDetailDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OrderDetailDialog.this.mDialog.dismiss();
            }
        });
        this.mBtnPay.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.OrderDetailDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OrderDetailDialog.this.mDialog.dismiss();
                OrderDetailDialog.this.mListener.onConfirm();
            }
        });
        this.mBtnCancel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.OrderDetailDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OrderDetailDialog.this.mDialog.dismiss();
                OrderDetailDialog.this.mListener.onCancle();
            }
        });
    }
}
