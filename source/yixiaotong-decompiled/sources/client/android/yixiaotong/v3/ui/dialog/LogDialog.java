package client.android.yixiaotong.v3.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.v3.util.LogReceivedUtil;
import client.android.yixiaotong.v3.util.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LogDialog {
    private Activity mActivity;
    private Dialog mDialog;
    private EditText mEtContent;
    private Listener mListener;
    private TextView mTvAll;
    private TextView mTvBle;
    private TextView mTvClear;
    private TextView mTvHide;

    public interface Listener {
        void onClick();
    }

    private LogDialog() {
    }

    private static final class SigleHolder {
        public static final LogDialog INSTANCE = new LogDialog();

        private SigleHolder() {
        }
    }

    public static LogDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, Listener listener) {
        Dialog dialog;
        this.mActivity = activity;
        this.mListener = listener;
        if (activity == null || listener == null || ((dialog = this.mDialog) != null && dialog.isShowing())) {
            LogUtil.e("LogDialog", (this.mActivity == null) + "  " + (this.mListener == null));
            return;
        }
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_console, (ViewGroup) null);
        this.mTvAll = (TextView) viewInflate.findViewById(R.id.tv_all);
        this.mTvBle = (TextView) viewInflate.findViewById(R.id.tv_ble);
        this.mTvHide = (TextView) viewInflate.findViewById(R.id.tv_hide);
        this.mTvClear = (TextView) viewInflate.findViewById(R.id.tv_clear);
        this.mEtContent = (EditText) viewInflate.findViewById(R.id.et_content);
        onclick();
        this.mEtContent.setText(LogReceivedUtil.getInstance().getAllData());
        EditText editText = this.mEtContent;
        editText.setSelection(editText.getText().toString().length());
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(true);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.8d);
        attributes.width = defaultDisplay.getWidth();
        window.setAttributes(attributes);
        window.setGravity(80);
        this.mDialog.show();
    }

    private void onclick() {
        this.mTvAll.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.LogDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LogDialog.this.mEtContent.setText(LogReceivedUtil.getInstance().getAllData());
                LogDialog.this.mEtContent.setSelection(LogDialog.this.mEtContent.getText().toString().length());
            }
        });
        this.mTvBle.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.LogDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.mTvHide.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.LogDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LogDialog.this.mDialog.dismiss();
            }
        });
        this.mTvClear.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.LogDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LogDialog.this.mEtContent.setText("");
                LogReceivedUtil.getInstance().clearData();
                LogDialog.this.mDialog.dismiss();
            }
        });
        this.mEtContent.setShowSoftInputOnFocus(false);
        this.mEtContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: client.android.yixiaotong.v3.ui.dialog.LogDialog.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ((InputMethodManager) LogDialog.this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(LogDialog.this.mEtContent.getWindowToken(), 0);
            }
        });
    }
}
