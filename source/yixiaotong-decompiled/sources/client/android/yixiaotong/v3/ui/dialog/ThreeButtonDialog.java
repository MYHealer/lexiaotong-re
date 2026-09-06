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
import client.android.yixiaotong.util.StringUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ThreeButtonDialog {
    private Activity mActivity;
    private Dialog mDialog;
    private Listener mListener;
    private TextView mTVSecond;
    private TextView mTvCancel;
    private TextView mTvFirst;

    public interface Listener {
        void onCancle();

        void onConfirm1();

        void onConfirm2();
    }

    private ThreeButtonDialog() {
    }

    private static final class SigleHolder {
        public static final ThreeButtonDialog INSTANCE = new ThreeButtonDialog();

        private SigleHolder() {
        }
    }

    public static ThreeButtonDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, Listener listener, String str, String str2, String str3, String str4, String str5) {
        this.mActivity = activity;
        this.mListener = listener;
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || this.mActivity == null || this.mListener == null) {
            return;
        }
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_threebtn, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        textView.setText(str);
        if (StringUtils.isEmpty(str)) {
            textView.setVisibility(8);
        }
        ((TextView) viewInflate.findViewById(R.id.tv_content)).setText(str2);
        this.mTvFirst = (TextView) viewInflate.findViewById(R.id.tv_first);
        this.mTVSecond = (TextView) viewInflate.findViewById(R.id.tv_second);
        this.mTvCancel = (TextView) viewInflate.findViewById(R.id.tv_cancel);
        if (StringUtils.isNotEmpty(str3)) {
            this.mTvFirst.setText(str3);
        }
        if (StringUtils.isNotEmpty(str4)) {
            this.mTVSecond.setText(str4);
        }
        if (StringUtils.isNotEmpty(str5)) {
            this.mTvCancel.setText(str5);
        }
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        this.mDialog.show();
        waitOnclick();
        confirmOnclick1();
        confirmOnclick2();
    }

    private void waitOnclick() {
        this.mTvCancel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.ThreeButtonDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreeButtonDialog.this.mDialog.dismiss();
                ThreeButtonDialog.this.mListener.onCancle();
            }
        });
    }

    private void confirmOnclick1() {
        this.mTvFirst.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.ThreeButtonDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreeButtonDialog.this.mDialog.dismiss();
                ThreeButtonDialog.this.mListener.onConfirm1();
            }
        });
    }

    private void confirmOnclick2() {
        this.mTVSecond.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.ThreeButtonDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreeButtonDialog.this.mDialog.dismiss();
                ThreeButtonDialog.this.mListener.onConfirm2();
            }
        });
    }
}
