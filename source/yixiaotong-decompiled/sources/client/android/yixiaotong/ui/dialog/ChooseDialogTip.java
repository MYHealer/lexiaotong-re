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
import client.android.yixiaotong.util.ToastUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ChooseDialogTip {
    private Button btnContent1;
    private Button btnContent2;
    private Activity mActivity;
    private Dialog mDialog;
    private boolean mIsChooseed1 = true;
    private boolean mIsChooseed2 = false;
    private ChooseDialogListener mTipDialogListener;
    private TextView tvContent1;
    private TextView tvContent2;
    private Button tvWait;
    private Button tv_postive;

    public interface ChooseDialogListener {
        void onCanle();

        void onConfirt(boolean z, boolean z2);
    }

    public void showTipDialog(Activity activity, ChooseDialogListener chooseDialogListener, String str, String str2, String str3, String str4) {
        if (activity == null) {
            ToastUtils.show(activity, "activity为空");
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        this.mTipDialogListener = chooseDialogListener;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.choosedialog, (ViewGroup) null);
        this.tvContent1 = (TextView) viewInflate.findViewById(R.id.tv_content1);
        this.tvContent2 = (TextView) viewInflate.findViewById(R.id.tv_content2);
        this.btnContent1 = (Button) viewInflate.findViewById(R.id.btn_content1);
        this.btnContent2 = (Button) viewInflate.findViewById(R.id.btn_content2);
        this.tvContent1.setText(str);
        this.tvContent2.setText(str2);
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
        waitOnclick();
        confirmOnclick();
        initView();
        this.mDialog.show();
    }

    public void waitOnclick() {
        this.tvWait.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.ChooseDialogTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChooseDialogTip.this.mDialog.dismiss();
                ChooseDialogTip.this.mTipDialogListener.onCanle();
            }
        });
    }

    public void confirmOnclick() {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.ChooseDialogTip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChooseDialogTip.this.mDialog.dismiss();
                ChooseDialogTip.this.mTipDialogListener.onConfirt(ChooseDialogTip.this.mIsChooseed1, ChooseDialogTip.this.mIsChooseed2);
            }
        });
    }

    private void initView() {
        this.btnContent1.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.ChooseDialogTip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseDialogTip.this.mIsChooseed1) {
                    return;
                }
                ChooseDialogTip.this.btnContent1.setBackgroundResource(R.mipmap.l_choose_box2);
                ChooseDialogTip.this.mIsChooseed1 = true;
                if (ChooseDialogTip.this.mIsChooseed2) {
                    ChooseDialogTip.this.btnContent2.setBackgroundResource(R.mipmap.l_choose_box);
                    ChooseDialogTip.this.mIsChooseed2 = false;
                }
            }
        });
        this.btnContent2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.ChooseDialogTip.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseDialogTip.this.mIsChooseed2) {
                    return;
                }
                ChooseDialogTip.this.btnContent2.setBackgroundResource(R.mipmap.l_choose_box2);
                ChooseDialogTip.this.mIsChooseed2 = true;
                if (ChooseDialogTip.this.mIsChooseed1) {
                    ChooseDialogTip.this.btnContent1.setBackgroundResource(R.mipmap.l_choose_box);
                    ChooseDialogTip.this.mIsChooseed1 = false;
                }
            }
        });
    }
}
