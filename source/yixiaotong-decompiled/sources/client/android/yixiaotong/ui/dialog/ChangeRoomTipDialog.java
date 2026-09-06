package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.ToastUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ChangeRoomTipDialog {
    private Activity mActivity;
    private Dialog mDialog;

    public void showTipDialog(Activity activity) {
        if (activity == null) {
            ToastUtils.show(activity, "activity为空");
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        this.mDialog.setContentView(this.mActivity.getLayoutInflater().inflate(R.layout.dialog_changeroomtip, (ViewGroup) null));
        this.mDialog.setCancelable(true);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.6d);
        window.setAttributes(attributes);
        this.mDialog.show();
    }
}
