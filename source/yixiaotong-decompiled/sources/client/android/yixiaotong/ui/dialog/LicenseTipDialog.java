package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.store.LocalBusinessStore;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LicenseTipDialog {
    private Activity mActivity;
    private Button mBtnCanle;
    private Button mBtnComfirt;
    private Dialog mDialog;
    private Listener mListener;
    private TextView mTvContent2;

    public interface Listener {
        void onComfirt();

        void onLicense();

        void onPrivacyPolicy();
    }

    public void show(Activity activity, Listener listener) {
        if (activity != null) {
            this.mActivity = activity;
            this.mListener = listener;
            this.mDialog = new Dialog(this.mActivity, R.style.mydialog);
            View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_licensetip, (ViewGroup) null);
            this.mBtnCanle = (Button) viewInflate.findViewById(R.id.btn_cancel);
            this.mBtnComfirt = (Button) viewInflate.findViewById(R.id.btn_confirm);
            this.mTvContent2 = (TextView) viewInflate.findViewById(R.id.tv_content2);
            this.mDialog.setContentView(viewInflate);
            onComfirt();
            onCancel();
            initView();
            Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
            Window window = this.mDialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = defaultDisplay.getWidth();
            window.setAttributes(attributes);
            window.setGravity(80);
            this.mDialog.setCancelable(false);
            this.mDialog.show();
        }
    }

    private void initView() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "平台将严格保护您的个人信息、确保信息安全，具体详见《用户服务协议》、《隐私政策》。");
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: client.android.yixiaotong.ui.dialog.LicenseTipDialog.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                LicenseTipDialog.this.onLicense();
            }
        }, 25, 33, 33);
        this.mTvContent2.setText(spannableStringBuilder);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: client.android.yixiaotong.ui.dialog.LicenseTipDialog.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                LicenseTipDialog.this.onPrivacyPolicy();
            }
        }, 34, 40, 33);
        this.mTvContent2.setText(spannableStringBuilder);
        this.mTvContent2.setMovementMethod(LinkMovementMethod.getInstance());
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#008AFF")), 25, 33, 33);
        this.mTvContent2.setText(spannableStringBuilder);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#008AFF")), 34, 40, 33);
        this.mTvContent2.setText(spannableStringBuilder);
    }

    private void onCancel() {
        this.mBtnCanle.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.LicenseTipDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LicenseTipDialog.this.mDialog == null || !LicenseTipDialog.this.mDialog.isShowing()) {
                    return;
                }
                LocalBusinessStore.saveLicenseTip(LicenseTipDialog.this.mActivity, false);
                LicenseTipDialog.this.mDialog.dismiss();
            }
        });
    }

    private void onComfirt() {
        this.mBtnComfirt.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.LicenseTipDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LicenseTipDialog.this.mDialog != null && LicenseTipDialog.this.mDialog.isShowing()) {
                    LicenseTipDialog.this.mDialog.dismiss();
                }
                if (LicenseTipDialog.this.mListener != null) {
                    LicenseTipDialog.this.mListener.onComfirt();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLicense() {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onLicense();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPrivacyPolicy() {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onPrivacyPolicy();
        }
    }
}
