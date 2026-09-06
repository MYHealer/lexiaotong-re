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
public class AuthDetailDialog {
    private Activity mActivity;
    private Button mBtnUnBind;
    private Dialog mDialog;
    private TipDialogListener mTipDialogListener;
    private TextView mTvMoreHelp;

    public interface TipDialogListener {
        void onMoreHelp();

        void onUnBind();
    }

    public void showTipDialog(Activity activity, TipDialogListener tipDialogListener, String str, String str2, String str3) {
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
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_authdevice_detail, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_investor);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_phone);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_company);
        this.mBtnUnBind = (Button) viewInflate.findViewById(R.id.btn_unbind);
        textView.setText(str);
        textView2.setText(str2);
        textView3.setText(str3);
        this.mTvMoreHelp = (TextView) viewInflate.findViewById(R.id.tv_morehelp);
        setSpannableText();
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(true);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        unbindOnclick();
        confirmOnclick();
        this.mDialog.show();
    }

    public void unbindOnclick() {
        this.mBtnUnBind.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.AuthDetailDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AuthDetailDialog.this.mDialog.dismiss();
                AuthDetailDialog.this.mTipDialogListener.onUnBind();
            }
        });
    }

    public void confirmOnclick() {
        this.mTvMoreHelp.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.AuthDetailDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AuthDetailDialog.this.mDialog.dismiss();
                AuthDetailDialog.this.mTipDialogListener.onMoreHelp();
            }
        });
    }

    public void setSpannableText() {
        SpannableString spannableString = new SpannableString("投资人分配失败？更多帮助");
        spannableString.setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(R.color.ffFA5854)), 8, 12, 33);
        this.mTvMoreHelp.setText(spannableString);
    }
}
