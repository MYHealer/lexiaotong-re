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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SelectSexDialog {
    private Activity mActivity;
    private Button mBtnConfirm;
    private Dialog mDialog;
    private Listener mListener;
    private int mSex;

    public interface Listener {
        void onConfirm(int i);
    }

    private SelectSexDialog() {
    }

    private static final class SigleHolder {
        public static final SelectSexDialog INSTANCE = new SelectSexDialog();

        private SigleHolder() {
        }
    }

    public static SelectSexDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, Listener listener, int i) {
        this.mActivity = activity;
        this.mListener = listener;
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || this.mActivity == null || this.mListener == null) {
            return;
        }
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_selectsex, (ViewGroup) null);
        final TextView textView = (TextView) viewInflate.findViewById(R.id.tv_nan);
        final TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_nv);
        final ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_nan);
        final ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_nv);
        this.mSex = i;
        if (i == 1) {
            textView.setTextColor(this.mActivity.getResources().getColor(R.color.ff6f32fd));
            textView2.setTextColor(this.mActivity.getResources().getColor(R.color.ffa1a6b3));
            imageView.setImageResource(R.mipmap.xznan);
            imageView2.setImageResource(R.mipmap.wxznv);
        } else {
            textView.setTextColor(this.mActivity.getResources().getColor(R.color.ffa1a6b3));
            textView2.setTextColor(this.mActivity.getResources().getColor(R.color.ff6f32fd));
            imageView.setImageResource(R.mipmap.wxznan);
            imageView2.setImageResource(R.mipmap.xznv);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.SelectSexDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectSexDialog.this.mSex = 1;
                textView.setTextColor(SelectSexDialog.this.mActivity.getResources().getColor(R.color.ff6f32fd));
                textView2.setTextColor(SelectSexDialog.this.mActivity.getResources().getColor(R.color.ffa1a6b3));
                imageView.setImageResource(R.mipmap.xznan);
                imageView2.setImageResource(R.mipmap.wxznv);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.SelectSexDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectSexDialog.this.mSex = 2;
                textView.setTextColor(SelectSexDialog.this.mActivity.getResources().getColor(R.color.ffa1a6b3));
                textView2.setTextColor(SelectSexDialog.this.mActivity.getResources().getColor(R.color.ff6f32fd));
                imageView.setImageResource(R.mipmap.wxznan);
                imageView2.setImageResource(R.mipmap.xznv);
            }
        });
        this.mBtnConfirm = (Button) viewInflate.findViewById(R.id.btn_comfirt);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        this.mDialog.setCancelable(false);
        this.mDialog.show();
        confirmOnclick();
    }

    private void confirmOnclick() {
        this.mBtnConfirm.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.SelectSexDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectSexDialog.this.mDialog.dismiss();
                SelectSexDialog.this.mListener.onConfirm(SelectSexDialog.this.mSex);
            }
        });
    }
}
