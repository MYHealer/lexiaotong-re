package client.android.yixiaotong.util.update;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.ui.MainActivity;
import client.android.yixiaotong.ui.dialog.UpdateAppDialog;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.byazt.bv.BaseConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UpdateAppUtil {
    public static final String TYPE_ISCOMPARE = "type_iscompare";
    public static final String TYPE_ISHINT = "type_ishint";
    public static final String TYPE_SERVERVERSION = "type_serverversion";

    public void showMustUpdateApkDialog(final Activity activity, String str) {
        UpdateAppDialog.getInstance().showDialog(activity, new UpdateAppDialog.DialogListener() { // from class: client.android.yixiaotong.util.update.UpdateAppUtil.1
            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onCanle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onConfirm() {
                UpdateAppUtil.this.toUpdate(activity);
            }
        }, str, "", true);
    }

    public void showMustUpdateApkDialog(final Activity activity, String str, boolean z, boolean z2) {
        if (!z && !z2 && StringUtils.isNotEmpty(LocalDataUtil.getAppVerTip(activity)) && LocalDataUtil.getAppVerTip(activity).equals(LocalDataUtil.getAppVer(activity))) {
            return;
        }
        UpdateAppDialog.getInstance().showDialog(activity, new UpdateAppDialog.DialogListener() { // from class: client.android.yixiaotong.util.update.UpdateAppUtil.2
            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onCanle() {
                Activity activity2 = activity;
                LocalDataUtil.saveAppVerTip(activity2, LocalDataUtil.getAppVer(activity2));
            }

            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onConfirm() {
                UpdateAppUtil.this.toUpdate(activity);
            }
        }, str, "不再提示", z);
    }

    public void showUpdateApkDialog(boolean z, Activity activity, String str, String str2) {
        if (z) {
            if (PreferenceUtil.getServerVersionString(activity, TYPE_SERVERVERSION, str).equals(str)) {
                MainActivity.launch(activity);
                return;
            }
            if (stringToInt(str) > stringToInt(PreferenceUtil.getServerVersionString(activity, TYPE_SERVERVERSION, str))) {
                if (PreferenceUtil.getIsCompareBoolean(activity, TYPE_ISCOMPARE, false)) {
                    MainActivity.launch(activity);
                } else {
                    showUpdateIsCompareDetailDialog(activity, str2);
                }
                PreferenceUtil.putServerVersionString(activity, TYPE_SERVERVERSION, str);
                return;
            }
            MainActivity.launch(activity);
            return;
        }
        showUpdateIsClickDetailDialog(activity, str2);
    }

    private void showUpdateIsClickDetailDialog(final Activity activity, String str) {
        UpdateAppDialog.getInstance().showDialog(activity, new UpdateAppDialog.DialogListener() { // from class: client.android.yixiaotong.util.update.UpdateAppUtil.3
            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onCanle() {
                MainActivity.launch(activity);
                PreferenceUtil.putIsClickBoolean(activity, UpdateAppUtil.TYPE_ISHINT, true);
            }

            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onConfirm() {
                UpdateAppUtil.this.toUpdate(activity);
            }
        }, str, "不再提示", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toUpdate(Activity activity) {
        AccountManager.getInstance().clearLoginAccount();
        String appUpdateUrl = LocalDataUtil.getAppUpdateUrl(activity);
        if (StringUtils.isNotEmpty(appUpdateUrl)) {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(appUpdateUrl)));
        } else if (isAvilible(activity, "com.tencent.android.qqdownloader")) {
            launchAppDetail(activity, "client.android.yixiaotong", "com.tencent.android.qqdownloader");
        } else {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://a.app.qq.com/o/simple.jsp?pkgname=client.android.yixiaotong")));
        }
    }

    private void showUpdateIsCompareDetailDialog(final Activity activity, String str) {
        UpdateAppDialog.getInstance().showDialog(activity, new UpdateAppDialog.DialogListener() { // from class: client.android.yixiaotong.util.update.UpdateAppUtil.4
            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onCanle() {
                MainActivity.launch(activity);
                PreferenceUtil.putIsCompareBoolean(activity, UpdateAppUtil.TYPE_ISCOMPARE, true);
            }

            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onConfirm() {
                UpdateAppUtil.this.toUpdate(activity);
            }
        }, str, "不再提示", false);
    }

    private static boolean isAvilible(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                arrayList.add(installedPackages.get(i).packageName);
            }
        }
        return arrayList.contains(str);
    }

    private static void launchAppDetail(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + str));
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int stringToInt(String str) {
        String[] strArrSplit = str.split("\\.");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : strArrSplit) {
            stringBuffer.append(str2);
        }
        return Integer.parseInt(stringBuffer.toString());
    }
}
