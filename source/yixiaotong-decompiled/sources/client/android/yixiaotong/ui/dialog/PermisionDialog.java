package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.ToastUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PermisionDialog {
    private Activity mActivity;
    private Dialog mDialog;
    private ImageView mImg1;
    private ImageView mImg2;
    private ImageView mImg3;
    private ImageView mImgClose;
    private PermissionDialogListener mPermissionDialogListener;
    private RelativeLayout mRelCamara;
    private RelativeLayout mRelExternalStorage;
    private RelativeLayout mRelFindLocation;
    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;

    public interface PermissionDialogListener {
        void onClose();
    }

    private PermisionDialog() {
    }

    private static final class SigleHolder {
        public static final PermisionDialog INSTANCE = new PermisionDialog();

        private SigleHolder() {
        }
    }

    public static PermisionDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showTipDialog(Activity activity, PermissionDialogListener permissionDialogListener, String str, String str2, boolean z, boolean z2, boolean z3) {
        if (activity == null) {
            ToastUtils.show(activity, "activity为空");
            return;
        }
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        this.mPermissionDialogListener = permissionDialogListener;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.permission_dialog, (ViewGroup) null);
        this.mRelExternalStorage = (RelativeLayout) viewInflate.findViewById(R.id.rel1);
        this.mRelCamara = (RelativeLayout) viewInflate.findViewById(R.id.rel2);
        this.mRelFindLocation = (RelativeLayout) viewInflate.findViewById(R.id.rel3);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title1);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_title2);
        this.mImgClose = (ImageView) viewInflate.findViewById(R.id.img_close);
        this.mImg1 = (ImageView) viewInflate.findViewById(R.id.img1);
        this.mImg2 = (ImageView) viewInflate.findViewById(R.id.img2);
        this.mImg3 = (ImageView) viewInflate.findViewById(R.id.img3);
        this.mTv1 = (TextView) viewInflate.findViewById(R.id.tv1);
        this.mTv2 = (TextView) viewInflate.findViewById(R.id.tv2);
        this.mTv3 = (TextView) viewInflate.findViewById(R.id.tv3);
        textView.setText(str);
        textView2.setText(str2);
        if (z) {
            this.mRelExternalStorage.setVisibility(8);
        }
        if (z2) {
            this.mRelCamara.setVisibility(8);
        }
        if (z3) {
            this.mRelFindLocation.setVisibility(8);
        }
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        onCamareOnclick();
        onExternalOnclick();
        onFindLocationOnclick();
        onClose();
        onDismiss();
        this.mDialog.show();
    }

    private void onExternalOnclick() {
        this.mRelExternalStorage.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.PermisionDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void onCamareOnclick() {
        this.mRelCamara.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.PermisionDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void onFindLocationOnclick() {
        this.mRelFindLocation.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.PermisionDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void onClose() {
        this.mImgClose.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.dialog.PermisionDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PermisionDialog.this.mDialog.dismiss();
            }
        });
    }

    private void onDismiss() {
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.dialog.PermisionDialog.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                PermisionDialog.this.mPermissionDialogListener.onClose();
            }
        });
    }

    public void dismissDialog() {
        Dialog dialog;
        if (this.mActivity == null || (dialog = this.mDialog) == null || !dialog.isShowing()) {
            return;
        }
        this.mDialog.dismiss();
    }

    public void onOpenCamera() {
        this.mRelCamara.setBackground(this.mActivity.getResources().getDrawable(R.drawable.round_radius_button_background));
        this.mImg2.setImageResource(R.mipmap.l_chongzhi_select);
        this.mTv2.setText("开启相机");
        this.mTv2.setTextColor(-1);
    }

    public void onOpenFindLocation() {
        this.mRelFindLocation.setBackground(this.mActivity.getResources().getDrawable(R.drawable.round_radius_button_background));
        this.mImg3.setImageResource(R.mipmap.l_chongzhi_select);
        this.mTv3.setText("开启定位");
        this.mTv3.setTextColor(-1);
    }

    public void onOpenStorage() {
        this.mRelExternalStorage.setBackground(this.mActivity.getResources().getDrawable(R.drawable.round_radius_button_background));
        this.mImg1.setImageResource(R.mipmap.l_chongzhi_select);
        this.mTv1.setText("开启读写手机存储");
        this.mTv1.setTextColor(-1);
    }
}
