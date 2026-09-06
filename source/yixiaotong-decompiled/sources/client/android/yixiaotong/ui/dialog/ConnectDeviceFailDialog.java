package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
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
public class ConnectDeviceFailDialog {
    private Activity mActivity;
    private Button mBtnConnect;
    private Button mBtnQiehuan;
    private Dialog mDialog;
    private TipDialogListener mTipDialogListener;
    private TextView mTvMoreHelp;
    private TextView tvRssi;

    public interface TipDialogListener {
        void onConnect();

        void onMoreHelp();

        void onQiehuan();
    }

    public void showTipDialog(Activity activity, TipDialogListener tipDialogListener, int i, boolean z) {
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
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_connectdevicefail, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.text1);
        this.tvRssi = (TextView) viewInflate.findViewById(R.id.rssi);
        this.mBtnConnect = (Button) viewInflate.findViewById(R.id.btn_connect);
        Button button = (Button) viewInflate.findViewById(R.id.btn_qiehuan);
        this.mBtnQiehuan = button;
        if (z) {
            button.setVisibility(0);
        }
        if (i >= -60) {
            textView.setText("蓝牙强度较强");
            textView2.setText("当前设备可能存在异常，请");
        } else if (i < -60 && i > -85) {
            textView.setText("蓝牙强度较弱");
        } else {
            textView.setText("蓝牙强度弱");
        }
        this.tvRssi.setText("(蓝牙强度：" + i + ")");
        setRssiSpannableText(this.tvRssi.getText().toString(), i);
        this.mTvMoreHelp = (TextView) viewInflate.findViewById(R.id.tv_morehelp);
        setSpannableText();
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(true);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        connectOnclick();
        qiehuanOnclick();
        confirmOnclick();
        this.mDialog.show();
    }

    public void connectOnclick() {
        this.mBtnConnect.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectDeviceFailDialog.this.mDialog.dismiss();
                ConnectDeviceFailDialog.this.mTipDialogListener.onConnect();
            }
        });
    }

    public void qiehuanOnclick() {
        this.mBtnQiehuan.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectDeviceFailDialog.this.mDialog.dismiss();
                ConnectDeviceFailDialog.this.mTipDialogListener.onQiehuan();
            }
        });
    }

    public void confirmOnclick() {
        this.mTvMoreHelp.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectDeviceFailDialog.this.mDialog.dismiss();
                ConnectDeviceFailDialog.this.mTipDialogListener.onMoreHelp();
            }
        });
    }

    public void setSpannableText() {
        SpannableString spannableString = new SpannableString("如何打开蓝牙？更多帮助");
        spannableString.setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(R.color.ffFA5854)), 7, 11, 33);
        this.mTvMoreHelp.setText(spannableString);
    }

    public void setRssiSpannableText(String str, int i) {
        if (i >= -60) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(R.color.ff2ECC71)), str.length() - 4, str.length() - 1, 33);
            this.tvRssi.setText(spannableString);
        } else if (i < -60 && i > -85) {
            SpannableString spannableString2 = new SpannableString(str);
            spannableString2.setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(R.color.ffFDA72C)), str.length() - 4, str.length() - 1, 33);
            this.tvRssi.setText(spannableString2);
        } else {
            SpannableString spannableString3 = new SpannableString(str);
            if (i <= -100) {
                spannableString3.setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(R.color.ffFA5854)), str.length() - 5, str.length() - 1, 33);
            } else {
                spannableString3.setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(R.color.ffFA5854)), str.length() - 4, str.length() - 1, 33);
            }
            this.tvRssi.setText(spannableString3);
        }
    }
}
