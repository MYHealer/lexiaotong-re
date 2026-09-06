package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import client.android.yixiaotong.R;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ServerMaintainDialog {
    private Activity mActivity;
    private Dialog mDialog;
    private Handler mHandler;
    private long mTime;
    private TextView mTvTime;

    private ServerMaintainDialog() {
        this.mHandler = new Handler() { // from class: client.android.yixiaotong.ui.dialog.ServerMaintainDialog.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                if (ServerMaintainDialog.this.mDialog == null || !ServerMaintainDialog.this.mDialog.isShowing()) {
                    return;
                }
                if (ServerMaintainDialog.this.mTime - jCurrentTimeMillis > 0) {
                    long j = ServerMaintainDialog.this.mTime - jCurrentTimeMillis;
                    if (j <= 86400) {
                        ServerMaintainDialog.this.mTvTime.setText(ServerMaintainDialog.this.change((int) j));
                    } else {
                        ServerMaintainDialog.this.mTvTime.setText(((int) (j / 86400)) + "天" + ServerMaintainDialog.this.change(((int) j) % 86400));
                    }
                    ServerMaintainDialog.this.mHandler.sendEmptyMessageDelayed(0, 1000L);
                    return;
                }
                ServerMaintainDialog.this.mDialog.dismiss();
            }
        };
    }

    private static final class SigleHolder {
        public static final ServerMaintainDialog INSTANCE = new ServerMaintainDialog();

        private SigleHolder() {
        }
    }

    public static ServerMaintainDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showServerErrorDialog(Activity activity, String str) {
        this.mTime = Long.parseLong(str) / 1000;
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = activity;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.systemerror_dialog_tip2, (ViewGroup) null);
        this.mTvTime = (TextView) viewInflate.findViewById(R.id.tv_time);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(true);
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.6d);
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.75d);
        window.setAttributes(attributes);
        this.mDialog.show();
        this.mHandler.sendEmptyMessage(0);
    }

    public String change(int i) {
        int i2;
        int i3 = i % 3600;
        int i4 = 0;
        if (i > 3600) {
            int i5 = i / 3600;
            if (i3 == 0) {
                i3 = 0;
                i2 = 0;
            } else if (i3 > 60) {
                i2 = i3 / 60;
                i3 %= 60;
                if (i3 == 0) {
                    i3 = 0;
                }
            } else {
                i2 = 0;
            }
            i4 = i5;
        } else {
            int i6 = i / 60;
            int i7 = i % 60;
            i2 = i6;
            i3 = i7 != 0 ? i7 : 0;
        }
        return i4 + x.bQ + i2 + x.bQ + i3 + "";
    }
}
