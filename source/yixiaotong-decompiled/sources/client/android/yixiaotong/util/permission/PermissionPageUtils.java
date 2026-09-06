package client.android.yixiaotong.util.permission;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PermissionPageUtils {
    private final String TAG;
    private Context mContext;
    private String packageName;

    /* JADX INFO: renamed from: client.android.yixiaotong.util.permission.PermissionPageUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ PermissionPageUtils(AnonymousClass1 anonymousClass1) {
        this();
    }

    private PermissionPageUtils() {
        this.TAG = "PermissionPageManager";
        this.packageName = "client.android.yixiaotong";
    }

    private static final class SigleHolder {
        public static final PermissionPageUtils INSTANCE = new PermissionPageUtils(null);

        private SigleHolder() {
        }
    }

    public static PermissionPageUtils getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void jumpPermissionPage(Context context) throws Throwable {
        this.mContext = context;
        String str = Build.MANUFACTURER;
        this.packageName = this.mContext.getPackageName();
        Log.e("PermissionPageManager", "jumpPermissionPage --- name : " + str + "  packagename" + this.packageName);
        str.hashCode();
        switch (str) {
            case "Coolpad":
                goCoolpadMainager();
                break;
            case "Xiaomi":
                goXiaoMiMainager();
                break;
            case "LG":
                goLGMainager();
                break;
            case "OPPO":
                goOppoMainager();
                break;
            case "Sony":
                goSonyMainager();
                break;
            case "vivo":
                goVivoMainager();
                break;
            case "Meizu":
                goMeizuMainager();
                break;
            case "samsung":
                goSangXinMainager();
                break;
            case "HUAWEI":
                goHuaWeiMainager();
                break;
            default:
                goIntentSetting();
                break;
        }
    }

    private void goLGMainager() {
        try {
            Intent intent = new Intent(this.packageName);
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));
            this.mContext.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this.mContext, "跳转失败", 1).show();
            e.printStackTrace();
            goIntentSetting();
        }
    }

    private void goSonyMainager() {
        try {
            Intent intent = new Intent(this.packageName);
            intent.setComponent(new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));
            this.mContext.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this.mContext, "跳转失败", 1).show();
            e.printStackTrace();
            goIntentSetting();
        }
    }

    private void goHuaWeiMainager() {
        try {
            Intent intent = new Intent(this.packageName);
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            this.mContext.startActivity(intent);
            Toast.makeText(this.mContext, "请点击《乐校通》应用，并开启权限", 1).show();
        } catch (Exception e) {
            Toast.makeText(this.mContext, "跳转失败", 1).show();
            e.printStackTrace();
            goIntentSetting();
        }
    }

    private static String getMiuiVersion() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
            try {
                try {
                    String line = bufferedReader.readLine();
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return line;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            bufferedReader.close();
            throw th;
        }
    }

    private void goXiaoMiMainager() throws Throwable {
        String miuiVersion = getMiuiVersion();
        Log.e("PermissionPageManager", "goMiaoMiMainager --- rom : " + miuiVersion);
        Intent intent = new Intent();
        if ("V6".equals(miuiVersion) || "V7".equals(miuiVersion)) {
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", this.packageName);
            this.mContext.startActivity(intent);
            return;
        }
        if ("V8".equals(miuiVersion) || "V9".equals(miuiVersion) || "V10".equals(miuiVersion)) {
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", this.packageName);
            this.mContext.startActivity(intent);
            return;
        }
        goIntentSetting();
    }

    private void goMeizuMainager() {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("packageName", this.packageName);
            this.mContext.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            goIntentSetting();
        }
    }

    private void goSangXinMainager() {
        goIntentSetting();
    }

    private void goIntentSetting() {
        Toast.makeText(this.mContext, "请开启权限或者卸载后重新安装即可", 1).show();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.mContext.getPackageName(), null));
        try {
            this.mContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void goOppoMainager() {
        doStartApplicationWithPackageName("com.coloros.safecenter");
    }

    private void goCoolpadMainager() {
        doStartApplicationWithPackageName("com.yulong.android.security:remote");
    }

    private void goVivoMainager() {
        doStartApplicationWithPackageName("com.bairenkeji.icaller");
    }

    private Intent getAppDetailSettingIntent() {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.mContext.getPackageName(), null));
        return intent;
    }

    private void doStartApplicationWithPackageName(String str) {
        PackageInfo packageInfo;
        ResolveInfo next;
        try {
            packageInfo = this.mContext.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageInfo.packageName);
        List<ResolveInfo> listQueryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(intent, 0);
        Log.e("PermissionPageManager", "resolveinfoList" + listQueryIntentActivities.size());
        for (int i = 0; i < listQueryIntentActivities.size(); i++) {
            Log.e("PermissionPageManager", listQueryIntentActivities.get(i).activityInfo.packageName + listQueryIntentActivities.get(i).activityInfo.name);
        }
        if (listQueryIntentActivities != null) {
            if ((listQueryIntentActivities != null && listQueryIntentActivities.size() == 0) || listQueryIntentActivities.iterator() == null || (next = listQueryIntentActivities.iterator().next()) == null) {
                return;
            }
            String str2 = next.activityInfo.packageName;
            String str3 = next.activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str2, str3));
            try {
                this.mContext.startActivity(intent2);
            } catch (Exception e2) {
                goIntentSetting();
                e2.printStackTrace();
            }
        }
    }
}
