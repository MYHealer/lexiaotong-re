package client.android.yixiaotong.util.android;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import client.android.yixiaotong.R;
import com.afollestad.materialdialogs.MaterialDialog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DialogUtils {
    private static MaterialDialog.Builder mBuilder;
    private static MaterialDialog mMaterialDialog;

    public static void show(Activity activity, String str, String str2, String str3, Object... objArr) {
        MaterialDialog materialDialog = mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.dismiss();
        }
        mBuilder = new MaterialDialog.Builder(activity).title(str).content(str2).positiveText(str3).callback(new MaterialDialog.ButtonCallback() { // from class: client.android.yixiaotong.util.android.DialogUtils.1
            @Override // com.afollestad.materialdialogs.MaterialDialog.ButtonCallback
            public void onPositive(MaterialDialog materialDialog2) {
                super.onPositive(materialDialog2);
                DialogUtils.mMaterialDialog.dismiss();
            }
        });
        if (objArr != null && objArr.length >= 1 && !((Boolean) objArr[0]).booleanValue()) {
            mBuilder.cancelable(false);
        }
        mMaterialDialog = mBuilder.show();
    }

    public static void show(Activity activity, String str, String str2, String str3, String str4, MaterialDialog.ButtonCallback buttonCallback) {
        MaterialDialog.Builder builderCallback = new MaterialDialog.Builder(activity).title(str).content(str2).positiveText(str3).negativeText(str4).callback(buttonCallback);
        mBuilder = builderCallback;
        mMaterialDialog = builderCallback.show();
    }

    public static void show(Activity activity, String str, String str2, String str3, String str4, MaterialDialog.ButtonCallback buttonCallback, DialogInterface.OnDismissListener onDismissListener) {
        MaterialDialog.Builder builderCallback = new MaterialDialog.Builder(activity).title(str).content(str2).positiveText(str3).negativeText(str4).dismissListener(onDismissListener).callback(buttonCallback);
        mBuilder = builderCallback;
        mMaterialDialog = builderCallback.show();
    }

    public static void show(Activity activity, String str, String str2, String str3, MaterialDialog.ButtonCallback buttonCallback) {
        MaterialDialog.Builder builderCallback = new MaterialDialog.Builder(activity).content(str).positiveText(str2).negativeText(str3).callback(buttonCallback);
        mBuilder = builderCallback;
        mMaterialDialog = builderCallback.show();
    }

    public static void showList(Activity activity, String str, int i, MaterialDialog.ListCallback listCallback) {
        MaterialDialog.Builder builderItemsCallback = new MaterialDialog.Builder(activity).items(i).dividerColorRes(R.color.gray_line).itemsCallback(listCallback);
        mBuilder = builderItemsCallback;
        mMaterialDialog = builderItemsCallback.show();
    }

    public static void showList(Activity activity, int i, String str, MaterialDialog.ListCallback listCallback) {
        MaterialDialog.Builder builderItemsCallback = new MaterialDialog.Builder(activity).title(str).items(i).dividerColorRes(R.color.gray_line).itemsCallback(listCallback);
        mBuilder = builderItemsCallback;
        mMaterialDialog = builderItemsCallback.show();
    }

    public static void show(Activity activity, String str, View view) {
        MaterialDialog.Builder builderAutoDismiss = new MaterialDialog.Builder(activity).title(str).customView(view, true).autoDismiss(true);
        mBuilder = builderAutoDismiss;
        mMaterialDialog = builderAutoDismiss.show();
    }

    public static void show(Activity activity, String str, View view, String str2, String str3, MaterialDialog.ButtonCallback buttonCallback) {
        MaterialDialog.Builder builderCallback = new MaterialDialog.Builder(activity).title(str).customView(view, false).positiveText(str2).negativeText(str3).callback(buttonCallback);
        mBuilder = builderCallback;
        mMaterialDialog = builderCallback.show();
    }

    public static void show(Activity activity, String str, View view, String str2, String str3, MaterialDialog.ButtonCallback buttonCallback, DialogInterface.OnDismissListener onDismissListener) {
        MaterialDialog.Builder builderCallback = new MaterialDialog.Builder(activity).title(str).customView(view, false).positiveText(str2).negativeText(str3).dismissListener(onDismissListener).callback(buttonCallback);
        mBuilder = builderCallback;
        mMaterialDialog = builderCallback.show();
    }

    public static void show(Activity activity, boolean z, String str, View view, String str2, String str3, MaterialDialog.ButtonCallback buttonCallback) {
        MaterialDialog.Builder builderCallback = new MaterialDialog.Builder(activity).title(str).customView(view, false).positiveText(str2).negativeText(str3).autoDismiss(z).callback(buttonCallback);
        mBuilder = builderCallback;
        mMaterialDialog = builderCallback.show();
    }

    public static void dismiss() {
        MaterialDialog materialDialog = mMaterialDialog;
        if (materialDialog == null || !materialDialog.isShowing()) {
            return;
        }
        mMaterialDialog.dismiss();
    }

    public static void showWithColor(Activity activity, CharSequence charSequence, CharSequence charSequence2, String str) {
        MaterialDialog.Builder builderCallback = new MaterialDialog.Builder(activity).title(charSequence).content(charSequence2).positiveText(str).callback(new MaterialDialog.ButtonCallback() { // from class: client.android.yixiaotong.util.android.DialogUtils.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.ButtonCallback
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                DialogUtils.mMaterialDialog.dismiss();
            }
        });
        mBuilder = builderCallback;
        mMaterialDialog = builderCallback.show();
    }

    public static void showListWithColor(Activity activity, String str, CharSequence[] charSequenceArr, MaterialDialog.ListCallback listCallback, Object... objArr) {
        MaterialDialog.Builder builderCancelable = new MaterialDialog.Builder(activity).title(str).items(charSequenceArr).itemsCallback(listCallback).cancelable(false);
        mBuilder = builderCancelable;
        mMaterialDialog = builderCancelable.show();
    }
}
