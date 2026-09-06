package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.ui.UserInfoActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SetIdentityIdDialogTip {
    private Activity mActivity;
    private Dialog mDialog;
    private Button tvWait;
    private Button tv_postive;

    public SetIdentityIdDialogTip(Activity activity) {
        this.mActivity = activity;
    }

    public void showSetIdentityIdDialog() {
        Dialog dialog = this.mDialog;
        if ((dialog == null || !dialog.isShowing()) && this.mActivity != null) {
            Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
            this.mDialog = dialog2;
            Window window = dialog2.getWindow();
            View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_setidentityid, (ViewGroup) null);
            this.tvWait = (Button) viewInflate.findViewById(R.id.tv_wait);
            this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
            this.mDialog.setContentView(viewInflate);
            this.mDialog.setCancelable(false);
            Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.7d);
            window.setAttributes(attributes);
            this.mDialog.show();
        }
    }

    public void waitOnclick() {
        this.tvWait.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.SetIdentityIdDialogTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetIdentityIdDialogTip.this.mDialog.dismiss();
            }
        });
    }

    public void confirmOnclick(final UserInfoBean userInfoBean) {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.SetIdentityIdDialogTip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetIdentityIdDialogTip.this.mDialog.dismiss();
                UserInfoActivity.launch(SetIdentityIdDialogTip.this.mActivity, userInfoBean);
            }
        });
    }
}
