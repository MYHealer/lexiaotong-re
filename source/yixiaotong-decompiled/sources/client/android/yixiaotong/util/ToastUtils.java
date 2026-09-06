package client.android.yixiaotong.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.util.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ToastUtils {
    public static void show(Context context, int i) {
        show(context, context.getResources().getText(i), 0);
    }

    public static void show(Context context, int i, int i2) {
        show(context, context.getResources().getText(i), i2);
    }

    public static void show(Context context, CharSequence charSequence) {
        show(context, charSequence, 0);
    }

    public static void showLong(Context context, CharSequence charSequence) {
        show(context, charSequence, 1);
    }

    public static void showLog(Context context, CharSequence charSequence) {
        if (AccountManager.getInstance().getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
            show(context, charSequence, 0);
        }
    }

    public static void showLog(Context context, CharSequence charSequence, int i) {
        if (AccountManager.getInstance().getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
            show(context, charSequence, 0);
        }
    }

    public static void show(final Context context, final CharSequence charSequence, final int i) {
        if (context == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.ToastUtils.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(context, charSequence, i).show();
            }
        });
    }

    public static void show(Context context, int i, Object... objArr) {
        show(context, String.format(context.getResources().getString(i), objArr), 0);
    }

    public static void show(Context context, String str, Object... objArr) {
        show(context, String.format(str, objArr), 0);
    }

    public static void show(Context context, int i, int i2, Object... objArr) {
        show(context, String.format(context.getResources().getString(i), objArr), i2);
    }

    public static void show(Context context, String str, int i, Object... objArr) {
        show(context, String.format(str, objArr), i);
    }
}
