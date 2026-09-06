package client.android.yixiaotong.v4.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.ui.dialog.UpdateAppDialog;
import client.android.yixiaotong.util.StringUtils;
import com.byazt.bv.BaseConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4UpdateAppUtil {
    public void showMustUpdateApkDialog(final Activity activity, String str) {
        UpdateAppDialog.getInstance().showDialog(activity, new UpdateAppDialog.DialogListener() { // from class: client.android.yixiaotong.v4.util.V4UpdateAppUtil.1
            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onCanle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onConfirm() {
                V4UpdateAppUtil.this.toUpdate(activity);
            }
        }, str, "", true);
    }

    public void showMustUpdateApkDialog(final Activity activity, String str, boolean z, boolean z2) {
        if (!z && !z2 && StringUtils.isNotEmpty(V4LocalDataUtil.getAppVerTip(activity)) && V4LocalDataUtil.getAppVerTip(activity).equals(V4LocalDataUtil.getAppVer(activity))) {
            return;
        }
        UpdateAppDialog.getInstance().showDialog(activity, new UpdateAppDialog.DialogListener() { // from class: client.android.yixiaotong.v4.util.V4UpdateAppUtil.2
            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onCanle() {
                Activity activity2 = activity;
                V4LocalDataUtil.saveAppVerTip(activity2, V4LocalDataUtil.getAppVer(activity2));
            }

            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onConfirm() {
                V4UpdateAppUtil.this.toUpdate(activity);
            }
        }, str, "不再提示", z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toUpdate(Activity activity) {
        AccountManager.getInstance().clearLoginAccount();
        String appUpdateUrl = V4LocalDataUtil.getAppUpdateUrl(activity);
        if (StringUtils.isNotEmpty(appUpdateUrl)) {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(appUpdateUrl)));
        } else if (isAvilible(activity, "com.tencent.android.qqdownloader")) {
            launchAppDetail(activity, "client.android.yixiaotong", "com.tencent.android.qqdownloader");
        } else {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://a.app.qq.com/o/simple.jsp?pkgname=client.android.yixiaotong")));
        }
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
}
