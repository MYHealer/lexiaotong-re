package client.android.yixiaotong.alipay;

import android.app.Activity;
import android.text.TextUtils;
import client.android.yixiaotong.util.executor.AsyncExecutor;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.alipay.sdk.app.PayTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class AliPayUtils {

    public interface OnPayListener {
        void payFail();

        void paySuccess();

        void payWaitting();
    }

    private AliPayUtils() {
    }

    public static void pay(final Activity activity, final String str, final OnPayListener onPayListener) {
        AsyncExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.alipay.AliPayUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final String resultStatus = new PayResult(new PayTask(activity).pay(str, true)).getResultStatus();
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.alipay.AliPayUtils.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TextUtils.equals(resultStatus, "9000")) {
                                if (onPayListener != null) {
                                    onPayListener.paySuccess();
                                }
                            } else if (TextUtils.equals(resultStatus, "8000")) {
                                if (onPayListener != null) {
                                    onPayListener.payWaitting();
                                }
                            } else if (onPayListener != null) {
                                onPayListener.payFail();
                            }
                        }
                    });
                } catch (Exception unused) {
                    OnPayListener onPayListener2 = onPayListener;
                    if (onPayListener2 != null) {
                        onPayListener2.payFail();
                    }
                }
            }
        });
    }
}
