package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.ToastUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class InitDialogTip {
    private Button btn_devicedatail;
    private Button btn_init;
    private Button btn_set;
    private Activity mActivity;
    private Dialog mDialog;
    private InitDialogListener mInitDialodListener;
    private LinearLayout mLinHelpMore;
    private DialogInterface.OnKeyListener onKeyListener;

    public interface InitDialogListener {
        void onDeviceDetail();

        void onDismiss();

        void onHelpMore();

        void onInit();

        void onSet();
    }

    private InitDialogTip() {
        this.onKeyListener = new DialogInterface.OnKeyListener() { // from class: client.android.yixiaotong.ui.dialog.InitDialogTip.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 0 || InitDialogTip.this.mDialog == null || !InitDialogTip.this.mDialog.isShowing()) {
                    return false;
                }
                InitDialogTip.this.mDialog.dismiss();
                InitDialogTip.this.mInitDialodListener.onDismiss();
                return false;
            }
        };
    }

    private static final class SigleHolder {
        public static final InitDialogTip INSTANCE = new InitDialogTip();

        private SigleHolder() {
        }
    }

    public static InitDialogTip getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showTipDialog(Activity activity, String str, String str2, String str3, String str4, InitDialogListener initDialogListener) {
        if (activity == null) {
            ToastUtils.show(activity, "activity为空");
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        this.mInitDialodListener = initDialogListener;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_init_tip, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_schoolname);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_devicetype);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_devicename);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_deviceaddress);
        this.mLinHelpMore = (LinearLayout) viewInflate.findViewById(R.id.lin_morehelp);
        textView.setText(str);
        textView2.setText(str2);
        textView3.setText(str3);
        textView4.setText(str4);
        this.btn_init = (Button) viewInflate.findViewById(R.id.btn_init);
        this.btn_set = (Button) viewInflate.findViewById(R.id.btn_set);
        this.btn_devicedatail = (Button) viewInflate.findViewById(R.id.btn_devicedetail);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        confirmOnclick();
        this.mDialog.setOnKeyListener(this.onKeyListener);
        this.mDialog.show();
    }

    public void showTipDialog3(Activity activity, String str, String str2, String str3, String str4, boolean z, InitDialogListener initDialogListener) {
        if (activity == null) {
            ToastUtils.show(activity, "activity为空");
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        this.mInitDialodListener = initDialogListener;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_init_tip, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_schoolname);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_devicetype);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_devicename);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_deviceaddress);
        this.mLinHelpMore = (LinearLayout) viewInflate.findViewById(R.id.lin_morehelp);
        textView.setText(str);
        textView2.setText(str2);
        textView3.setText(str3);
        textView4.setText(str4);
        this.btn_init = (Button) viewInflate.findViewById(R.id.btn_init);
        this.btn_set = (Button) viewInflate.findViewById(R.id.btn_set);
        Button button = (Button) viewInflate.findViewById(R.id.btn_devicedetail);
        this.btn_devicedatail = button;
        button.setVisibility(8);
        if (z) {
            this.btn_set.setVisibility(8);
        } else {
            this.btn_init.setVisibility(8);
        }
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        confirmOnclick();
        this.mDialog.setOnKeyListener(this.onKeyListener);
        this.mDialog.show();
    }

    public void showTipDialog2(Activity activity, String str, String str2, String str3, String str4, InitDialogListener initDialogListener) {
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        this.mInitDialodListener = initDialogListener;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_init_tip, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_schoolname);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_devicetype);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_devicename);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_deviceaddress);
        this.mLinHelpMore = (LinearLayout) viewInflate.findViewById(R.id.lin_morehelp);
        textView.setText(str);
        textView2.setText(str2);
        textView3.setText(str3);
        textView4.setText(str4);
        this.btn_init = (Button) viewInflate.findViewById(R.id.btn_init);
        this.btn_set = (Button) viewInflate.findViewById(R.id.btn_set);
        this.btn_devicedatail = (Button) viewInflate.findViewById(R.id.btn_devicedetail);
        this.btn_set.setVisibility(8);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        confirmOnclick();
        this.mDialog.setOnKeyListener(this.onKeyListener);
        this.mDialog.show();
    }

    public void showTipDialog4(Activity activity, String str, String str2, String str3, String str4, InitDialogListener initDialogListener) {
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        this.mInitDialodListener = initDialogListener;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_init_tip, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_schoolname);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_devicetype);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_devicename);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_deviceaddress);
        this.mLinHelpMore = (LinearLayout) viewInflate.findViewById(R.id.lin_morehelp);
        textView.setText(str);
        textView2.setText(str2);
        textView3.setText(str3);
        textView4.setText(str4);
        this.btn_init = (Button) viewInflate.findViewById(R.id.btn_init);
        this.btn_set = (Button) viewInflate.findViewById(R.id.btn_set);
        Button button = (Button) viewInflate.findViewById(R.id.btn_devicedetail);
        this.btn_devicedatail = button;
        button.setVisibility(8);
        this.btn_set.setVisibility(8);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        confirmOnclick();
        this.mDialog.setOnKeyListener(this.onKeyListener);
        this.mDialog.show();
    }

    public void showTipDialog(Activity activity, String str, String str2, String str3, String str4, boolean z, InitDialogListener initDialogListener) {
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || activity == null) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        this.mInitDialodListener = initDialogListener;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_init_tip, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_schoolname);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_devicetype);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_devicename);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_deviceaddress);
        this.mLinHelpMore = (LinearLayout) viewInflate.findViewById(R.id.lin_morehelp);
        textView.setText(str);
        textView2.setText(str2);
        textView3.setText(str3);
        textView4.setText(str4);
        this.btn_init = (Button) viewInflate.findViewById(R.id.btn_init);
        this.btn_set = (Button) viewInflate.findViewById(R.id.btn_set);
        this.btn_devicedatail = (Button) viewInflate.findViewById(R.id.btn_devicedetail);
        if (z) {
            this.btn_set.setVisibility(8);
            this.btn_init.setText("集中器初始化");
        } else {
            this.btn_init.setVisibility(8);
            this.btn_set.setText("集中器解绑");
        }
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        confirmOnclick();
        this.mDialog.setOnKeyListener(this.onKeyListener);
        this.mDialog.show();
    }

    private void confirmOnclick() {
        this.btn_init.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.InitDialogTip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InitDialogTip.this.mDialog.dismiss();
                InitDialogTip.this.mInitDialodListener.onInit();
            }
        });
        this.btn_set.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.InitDialogTip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InitDialogTip.this.mDialog.dismiss();
                InitDialogTip.this.mInitDialodListener.onSet();
            }
        });
        this.btn_devicedatail.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.InitDialogTip.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InitDialogTip.this.mDialog.dismiss();
                InitDialogTip.this.mInitDialodListener.onDeviceDetail();
            }
        });
        this.mLinHelpMore.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.InitDialogTip.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InitDialogTip.this.mDialog.dismiss();
                InitDialogTip.this.mInitDialodListener.onHelpMore();
            }
        });
    }
}
