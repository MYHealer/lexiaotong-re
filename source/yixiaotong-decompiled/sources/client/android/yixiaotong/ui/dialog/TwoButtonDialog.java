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
import client.android.yixiaotong.ui.widget.SetFontColorUtil;
import client.android.yixiaotong.util.StringUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class TwoButtonDialog {
    private Activity mActivity;
    private Dialog mDialog;
    private Listener mListener;
    private Button tvWait;
    private Button tv_postive;

    public interface Listener {
        void onCancle();

        void onConfirm();
    }

    private TwoButtonDialog() {
    }

    private static final class SigleHolder {
        public static final TwoButtonDialog INSTANCE = new TwoButtonDialog();

        private SigleHolder() {
        }
    }

    public static TwoButtonDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, Listener listener, String str, String str2, String str3, String str4) {
        this.mActivity = activity;
        this.mListener = listener;
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || this.mActivity == null || this.mListener == null) {
            return;
        }
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_twobtn, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        textView.setText(str);
        if (!StringUtils.isNotEmpty(str)) {
            textView.setVisibility(8);
        }
        ((TextView) viewInflate.findViewById(R.id.tv_content)).setText(str2);
        this.tvWait = (Button) viewInflate.findViewById(R.id.tv_wait);
        this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
        this.tvWait.setText(str3);
        this.tv_postive.setText(str4);
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
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_twobtn, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        textView.setText(str);
        if (StringUtils.isEmpty(str)) {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_content);
        textView2.setText(str2);
        textView2.setTextColor(activity.getResources().getColor(R.color.ff242933));
        textView2.setText(SetFontColorUtil.getFont(str2, str3));
        this.tvWait = (Button) viewInflate.findViewById(R.id.tv_wait);
        this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
        this.tvWait.setText(str4);
        this.tv_postive.setText(str5);
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
        this.tvWait.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.TwoButtonDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TwoButtonDialog.this.mDialog.dismiss();
                TwoButtonDialog.this.mListener.onCancle();
            }
        });
    }

    private void confirmOnclick() {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.TwoButtonDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TwoButtonDialog.this.mDialog.dismiss();
                TwoButtonDialog.this.mListener.onConfirm();
            }
        });
    }
}
