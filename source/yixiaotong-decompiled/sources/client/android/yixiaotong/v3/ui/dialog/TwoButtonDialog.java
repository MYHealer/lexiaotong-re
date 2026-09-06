package client.android.yixiaotong.v3.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.SetFontColorUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class TwoButtonDialog {
    private Activity mActivity;
    private Dialog mDialog;
    private ImageView mImgCheckBox;
    private boolean mIsNoTip;
    private Listener mListener;
    private RelativeLayout mRelBoAgainTip;
    private Button tvWait;
    private Button tv_postive;

    public interface Listener {
        void onCancle();

        void onConfirm();
    }

    private TwoButtonDialog() {
        this.mIsNoTip = false;
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
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || activity == null || listener == null) {
            return;
        }
        this.mIsNoTip = false;
        this.mListener = listener;
        this.mActivity = activity;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_twobtn_v3, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        textView.setText(str);
        if (StringUtils.isEmpty(str)) {
            textView.setVisibility(8);
        }
        ((TextView) viewInflate.findViewById(R.id.tv_content)).setText(str2);
        this.tvWait = (Button) viewInflate.findViewById(R.id.tv_wait);
        this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
        this.tvWait.setText(str3);
        this.tv_postive.setText(str4);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        waitOnclick();
        confirmOnclick();
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        this.mDialog.show();
    }

    public void showDialog(Activity activity, Listener listener, String str, String str2, int i, String str3, String str4) {
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || activity == null || listener == null) {
            return;
        }
        this.mIsNoTip = false;
        this.mActivity = activity;
        this.mListener = listener;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_twobtn_v3, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        textView.setText(str);
        if (StringUtils.isEmpty(str)) {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_content);
        textView2.setText(str2);
        textView2.setTextColor(activity.getResources().getColor(i));
        this.tvWait = (Button) viewInflate.findViewById(R.id.tv_wait);
        this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
        this.tvWait.setText(str3);
        this.tv_postive.setText(str4);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        waitOnclick();
        confirmOnclick();
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        this.mDialog.show();
    }

    public void showDialog(Activity activity, Listener listener, String str, String str2, String str3, String str4, String str5) {
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || activity == null || listener == null) {
            return;
        }
        this.mIsNoTip = false;
        this.mActivity = activity;
        this.mListener = listener;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_twobtn_v3, (ViewGroup) null);
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
        waitOnclick();
        confirmOnclick();
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        this.mDialog.show();
    }

    public void showDialogRachargeTip(Activity activity, Listener listener, String str, String str2, String str3, String str4) {
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || activity == null || listener == null) {
            return;
        }
        this.mIsNoTip = false;
        this.mListener = listener;
        this.mActivity = activity;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_twobtn_v3, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        textView.setText(str);
        if (StringUtils.isEmpty(str)) {
            textView.setVisibility(8);
        }
        ((TextView) viewInflate.findViewById(R.id.tv_content)).setText(str2);
        this.tvWait = (Button) viewInflate.findViewById(R.id.tv_wait);
        this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
        this.tvWait.setText(str3);
        this.tv_postive.setText(str4);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.rel_noagaintip);
        this.mRelBoAgainTip = relativeLayout;
        relativeLayout.setVisibility(0);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_checkbox);
        this.mImgCheckBox = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TwoButtonDialog.this.mIsNoTip) {
                    TwoButtonDialog.this.mIsNoTip = false;
                    TwoButtonDialog.this.mImgCheckBox.setImageResource(R.drawable.uncheckbox);
                } else {
                    TwoButtonDialog.this.mIsNoTip = true;
                    TwoButtonDialog.this.mImgCheckBox.setImageResource(R.drawable.checkbox);
                }
            }
        });
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        waitOnclick();
        confirmOnclick();
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        this.mDialog.show();
    }

    private void waitOnclick() {
        LogUtil.e("dialog", "waitOnclick");
        this.tvWait.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LogUtil.e("dialog", "onClick");
                TwoButtonDialog.this.mDialog.dismiss();
                TwoButtonDialog.this.mListener.onCancle();
                if (TwoButtonDialog.this.mIsNoTip) {
                    LocalDataUtil.saveLoadWalletDate(TwoButtonDialog.this.mActivity);
                }
            }
        });
    }

    private void confirmOnclick() {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TwoButtonDialog.this.mDialog.dismiss();
                TwoButtonDialog.this.mListener.onConfirm();
                if (TwoButtonDialog.this.mIsNoTip) {
                    LocalDataUtil.saveLoadWalletDate(TwoButtonDialog.this.mActivity);
                }
            }
        });
    }
}
