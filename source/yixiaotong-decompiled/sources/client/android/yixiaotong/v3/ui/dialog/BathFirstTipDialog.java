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
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.v3.ui.weight.SlideToUnlockView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BathFirstTipDialog {
    private Activity mActivity;
    private Button mBtnCancel;
    private Button mBtnPosition;
    private Dialog mDialog;
    private ImageView mIvClose;
    private Listener mListener;
    private SlideToUnlockView mSlideToUnlockView;
    private TextView mTvAddress;
    private TextView mTvMac;

    public interface Listener {
        void onCancle();

        void onConfirm();
    }

    private BathFirstTipDialog() {
    }

    private static final class SigleHolder {
        public static final BathFirstTipDialog INSTANCE = new BathFirstTipDialog();

        private SigleHolder() {
        }
    }

    public static BathFirstTipDialog getInstance() {
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
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_bath_first_tip, (ViewGroup) null);
        this.mTvAddress = (TextView) viewInflate.findViewById(R.id.tv_address);
        this.mTvMac = (TextView) viewInflate.findViewById(R.id.tv_mac);
        this.mBtnCancel = (Button) viewInflate.findViewById(R.id.tv_canle);
        this.mBtnPosition = (Button) viewInflate.findViewById(R.id.tv_positive);
        this.mIvClose = (ImageView) viewInflate.findViewById(R.id.iv_close);
        this.mSlideToUnlockView = (SlideToUnlockView) viewInflate.findViewById(R.id.slideToUnlockView);
        this.mTvMac.setText(str2);
        this.mTvAddress.setText(str);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.85d);
        window.setAttributes(attributes);
        this.mDialog.setCancelable(false);
        this.mDialog.show();
        waitOnclick();
        confirmOnclick();
    }

    private void waitOnclick() {
        this.mBtnCancel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.BathFirstTipDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BathFirstTipDialog.this.mDialog.dismiss();
                BathFirstTipDialog.this.mListener.onCancle();
            }
        });
        this.mIvClose.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.BathFirstTipDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BathFirstTipDialog.this.mDialog.dismiss();
                BathFirstTipDialog.this.mListener.onCancle();
            }
        });
    }

    private void confirmOnclick() {
        this.mBtnPosition.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.BathFirstTipDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BathFirstTipDialog.this.mDialog.dismiss();
                BathFirstTipDialog.this.mListener.onConfirm();
            }
        });
        this.mSlideToUnlockView.setOnUnlockListener(new SlideToUnlockView.OnUnlockListener() { // from class: client.android.yixiaotong.v3.ui.dialog.BathFirstTipDialog$$ExternalSyntheticLambda0
            @Override // client.android.yixiaotong.v3.ui.weight.SlideToUnlockView.OnUnlockListener
            public final void onUnlock() {
                this.f$0.m368x65b6c7e6();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$confirmOnclick$0$client-android-yixiaotong-v3-ui-dialog-BathFirstTipDialog, reason: not valid java name */
    /* synthetic */ void m368x65b6c7e6() {
        this.mDialog.dismiss();
        this.mListener.onConfirm();
    }
}
