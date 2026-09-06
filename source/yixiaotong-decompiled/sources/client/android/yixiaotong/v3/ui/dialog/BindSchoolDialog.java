package client.android.yixiaotong.v3.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BindSchoolDialog {
    private Activity mActivity;
    private Button mBtnConfirm;
    private Dialog mDialog;
    private EditText mEtStuentNo;
    private Listener mListener;

    public interface Listener {
        void onConfirm(String str);
    }

    private BindSchoolDialog() {
    }

    private static final class SigleHolder {
        public static final BindSchoolDialog INSTANCE = new BindSchoolDialog();

        private SigleHolder() {
        }
    }

    public static BindSchoolDialog getInstance() {
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
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_bindschool, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_schoolname);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_address);
        textView.setText(str);
        textView2.setText(str2);
        this.mEtStuentNo = (EditText) viewInflate.findViewById(R.id.et_studentno);
        this.mBtnConfirm = (Button) viewInflate.findViewById(R.id.btn_confirm);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        this.mDialog.setCancelable(true);
        this.mDialog.show();
        confirmOnclick();
    }

    private void confirmOnclick() {
        this.mBtnConfirm.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.BindSchoolDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BindSchoolDialog.this.mDialog.dismiss();
                BindSchoolDialog.this.mListener.onConfirm(BindSchoolDialog.this.mEtStuentNo.getText().toString());
            }
        });
    }
}
