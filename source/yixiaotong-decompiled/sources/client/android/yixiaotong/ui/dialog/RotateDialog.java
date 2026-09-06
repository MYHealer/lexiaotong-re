package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RotateDialog extends BaseDialog {
    private Activity mActivity;
    private Listener mListener;

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.dialog.RotateDialog$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface Listener {
        void onComfirt(String str);
    }

    /* synthetic */ RotateDialog(AnonymousClass1 anonymousClass1) {
        this();
    }

    private RotateDialog() {
    }

    private static final class SigleHolder {
        public static final RotateDialog INSTANCE = new RotateDialog(null);

        private SigleHolder() {
        }
    }

    public static RotateDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Activity activity, Listener listener) {
        this.mActivity = activity;
        this.mListener = listener;
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.dialog_order_layout, (ViewGroup) null);
        showTipDialog(this.mActivity, viewInflate);
    }
}
