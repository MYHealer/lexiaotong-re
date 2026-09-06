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
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.WalletDetailActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ChongZhiDialogTip {
    private Activity mActivity;
    private Dialog mDialog;
    private Button tvWait;
    private Button tv_postive;

    public ChongZhiDialogTip(Activity activity) {
        this.mActivity = activity;
    }

    public void showChongZhiDialog(String str) {
        Dialog dialog = this.mDialog;
        if ((dialog == null || !dialog.isShowing()) && this.mActivity != null) {
            Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
            this.mDialog = dialog2;
            Window window = dialog2.getWindow();
            View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.setpswdialogtip, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.tv_content1)).setText("钱包余额不足，");
            ((TextView) viewInflate.findViewById(R.id.tv_content2)).setText("请充值后使用");
            this.tvWait = (Button) viewInflate.findViewById(R.id.tv_wait);
            this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
            this.tvWait.setText("暂不需要");
            this.tv_postive.setText("马上充值");
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
        this.tvWait.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.ChongZhiDialogTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChongZhiDialogTip.this.mDialog.dismiss();
            }
        });
    }

    public void confirmOnclick(final WalletModel walletModel) {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.ChongZhiDialogTip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChongZhiDialogTip.this.mDialog.dismiss();
                if (walletModel.typeId != 7) {
                    WalletDetailActivity.launch(ChongZhiDialogTip.this.mActivity, walletModel);
                }
            }
        });
    }
}
