package client.android.yixiaotong.ui.dialog;

import android.app.Activity;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.afollestad.materialdialogs.MaterialDialog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BaseMaterialDialog {
    private static MaterialDialog mMaterialDialog;

    public static void showMaterialDialog(final Activity activity, final String str, final boolean z) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.dialog.BaseMaterialDialog.1
            @Override // java.lang.Runnable
            public void run() {
                if (BaseMaterialDialog.isShowMaterialDialog()) {
                    BaseMaterialDialog.mMaterialDialog.setContent(StringUtils.isNotEmpty(str) ? str : "加载中..");
                    return;
                }
                Activity activity2 = activity;
                if (activity2 == null || activity2.isFinishing() || activity.isDestroyed()) {
                    return;
                }
                MaterialDialog unused = BaseMaterialDialog.mMaterialDialog = null;
                MaterialDialog unused2 = BaseMaterialDialog.mMaterialDialog = new MaterialDialog.Builder(activity).content(StringUtils.isNotEmpty(str) ? str : "加载中..").cancelable(z).progress(true, 0).show();
            }
        });
    }

    public static void setConnectMaterialDialog(final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.dialog.BaseMaterialDialog.2
            @Override // java.lang.Runnable
            public void run() {
                if (BaseMaterialDialog.mMaterialDialog == null || !BaseMaterialDialog.mMaterialDialog.isShowing()) {
                    return;
                }
                BaseMaterialDialog.mMaterialDialog.setContent(StringUtils.isNotEmpty(str) ? str : "加载中..");
            }
        });
    }

    public static boolean isShowMaterialDialog() {
        MaterialDialog materialDialog = mMaterialDialog;
        return materialDialog != null && materialDialog.isShowing();
    }

    public static void dissmisMaterialDialog() {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.dialog.BaseMaterialDialog.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (BaseMaterialDialog.mMaterialDialog != null && BaseMaterialDialog.mMaterialDialog.isShowing()) {
                        BaseMaterialDialog.mMaterialDialog.dismiss();
                    }
                } catch (Exception unused) {
                } finally {
                    MaterialDialog unused2 = BaseMaterialDialog.mMaterialDialog = null;
                }
            }
        });
    }
}
