package com.hihonor.dlinstall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.alipay.sdk.app.statistic.c;
import com.byazt.bv.BaseConstants;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.hihonor.dlinstall.ability.AddInstallListAbility;
import com.hihonor.dlinstall.ability.GetDeviceEssentialListAbility;
import com.hihonor.dlinstall.ability.GetSafeCheckResultAbility;
import com.hihonor.dlinstall.ability.GetUpdateListAbility;
import com.hihonor.dlinstall.ability.SigningStatusAbility;
import com.hihonor.dlinstall.ability.base.ResponseData;
import com.hihonor.dlinstall.ability.syncapp.SyncAppInfo;
import com.hihonor.dlinstall.ability.syncapp.SyncAppListAbility;
import com.hihonor.dlinstall.clone.AppInfo;
import com.hihonor.dlinstall.clone.AppInfoList;
import com.hihonor.dlinstall.clone.WishInfo;
import com.hihonor.dlinstall.data.SafeCheckResult;
import com.hihonor.dlinstall.data.UpdateListResult;
import com.hihonor.dlinstall.ipc.b;
import com.hihonor.dlinstall.ipc.d;
import com.hihonor.dlinstall.ipc.f;
import com.hihonor.dlinstall.ipc.j;
import com.hihonor.dlinstall.ipc.l;
import com.hihonor.dlinstall.ipc.m;
import com.hihonor.dlinstall.state.DIState;
import com.hihonor.dlinstall.util.a;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DownloadInstallClient {
    public static boolean addInstallList(Context context, List<String> list) {
        m mVarC = m.c();
        mVarC.getClass();
        if (!a.b(context)) {
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", "addInstallList: isInstalled is false");
            return false;
        }
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "addInstallList: pkgs is " + list);
        mVarC.a(context);
        AddInstallListAbility addInstallListAbility = new AddInstallListAbility(context, list);
        mVarC.a(context, addInstallListAbility);
        Boolean executeAbilityResult = addInstallListAbility.getExecuteAbilityResult();
        if (executeAbilityResult != null) {
            return executeAbilityResult.booleanValue();
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [R, com.hihonor.dlinstall.clone.WishInfo] */
    public static WishInfo addWish(Context context, List<String> list, Boolean bool) {
        m mVarC = m.c();
        mVarC.getClass();
        if (!a.b(context)) {
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", "addWish: isInstalled is false");
            return null;
        }
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "addWish: pkgNameList is " + list);
        mVarC.a(context);
        String packageName = context.getPackageName();
        m.c cVar = new m.c();
        if (mVarC.b(context)) {
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "addWish: addWish: version mismatch");
            ?? wishInfo = new WishInfo(-1, "addWish: version mismatch", new ArrayList());
            cVar.f3605a = wishInfo;
            cVar.b.run();
            return wishInfo;
        }
        mVarC.a(context, new m.b(new j(mVarC, list, bool, packageName, cVar), list, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, "addWish"));
        try {
            return (WishInfo) cVar.a(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "addWish: e is " + e.getMessage());
            return null;
        }
    }

    public static Boolean checkMarketAgreementSigningStatus(Context context) {
        m mVarC = m.c();
        mVarC.getClass();
        boolean zBooleanValue = false;
        if (a.b(context)) {
            mVarC.a(context);
            SigningStatusAbility signingStatusAbility = new SigningStatusAbility(context);
            mVarC.a(context, signingStatusAbility);
            Boolean executeAbilityResult = signingStatusAbility.getExecuteAbilityResult();
            if (executeAbilityResult != null) {
                zBooleanValue = executeAbilityResult.booleanValue();
            }
        } else {
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", "checkMarketAgreementSigningStatus: isInstalled is false");
        }
        return Boolean.valueOf(zBooleanValue);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [R, com.hihonor.dlinstall.clone.AppInfoList] */
    public static AppInfoList getAppInfo(Context context, List<String> list) {
        m mVarC = m.c();
        mVarC.getClass();
        if (!a.b(context)) {
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", "getDownloadAppInfo: isInstalled is false");
            return null;
        }
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "getDownloadAppInfo: pkgNameList is " + list);
        mVarC.a(context);
        String packageName = context.getPackageName();
        m.c cVar = new m.c();
        if (mVarC.b(context)) {
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "getDownloadAppInfo: version mismatch");
            ?? appInfoList = new AppInfoList(-1, "getDownloadAppInfo: version mismatch", new ArrayList());
            cVar.f3605a = appInfoList;
            cVar.b.run();
            return appInfoList;
        }
        mVarC.a(context, new m.b(new l(mVarC, packageName, cVar), list, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, "getDownloadAppInfo"));
        try {
            return (AppInfoList) cVar.a(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "getDownloadAppInfo: e is " + e.getMessage());
            return null;
        }
    }

    public static List<AppShelfStatus> getAppShelfStatuses(Context context, List<String> list, int i, String str) {
        m mVarC = m.c();
        mVarC.getClass();
        if (!a.b(context)) {
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", "getAppShelfStatuses: isInstalled is false");
            return null;
        }
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "getAppShelfStatuses: channel is " + i + ",subChannel:" + str + ",pkgNameList is " + list);
        mVarC.a(context);
        String packageName = context.getPackageName();
        m.c cVar = new m.c();
        mVarC.a(context, new m.b(new d(mVarC, packageName, i, str, cVar), list, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, "getAppShelfStatuses"));
        try {
            List<AppShelfStatus> list2 = (List) cVar.a(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
            if (list2 != null && list2.size() > 0) {
                return list2;
            }
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "getAppShelfStatuses: result size is 0");
            return new ArrayList();
        } catch (Exception e) {
            com.hihonor.dlinstall.page.a.b("DownloadInstallService", "getAppShelfStatuses: e is " + e.getMessage());
            return new ArrayList();
        }
    }

    public static ResponseData<List<AppInfo>> getDeviceEssentialList(Context context, int i) {
        m mVarC = m.c();
        mVarC.getClass();
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "getDeviceEssentialList: size " + i);
        mVarC.a(context);
        GetDeviceEssentialListAbility getDeviceEssentialListAbility = new GetDeviceEssentialListAbility(context, Integer.valueOf(i));
        mVarC.a(context, getDeviceEssentialListAbility);
        return getDeviceEssentialListAbility.getExecuteAbilityResponse();
    }

    public static ResponseData<SafeCheckResult> getSafeCheckResult(Context context) {
        m mVarC = m.c();
        mVarC.getClass();
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "getSafeCheckResult");
        mVarC.a(context);
        GetSafeCheckResultAbility getSafeCheckResultAbility = new GetSafeCheckResultAbility(context, null);
        mVarC.a(context, getSafeCheckResultAbility);
        return getSafeCheckResultAbility.getExecuteAbilityResponse();
    }

    public static long getSdkVersion() {
        return 14L;
    }

    public static long getServiceVersion(Context context) {
        if (context != null) {
            try {
                int i = context.getPackageManager().getApplicationInfo("com.hihonor.appmarket", 128).metaData.getInt("download.install.service.version", -1);
                if (i > 0) {
                    return i;
                }
            } catch (PackageManager.NameNotFoundException e) {
                com.hihonor.dlinstall.page.a.b("VersionUtil", "getServiceVersion: e is " + e.getMessage());
            }
            Intent intent = new Intent();
            intent.setPackage("com.hihonor.appmarket");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setAction("com.hihonor.appmarket.intent.action.DownloadInstallService");
            if (context.getPackageManager().resolveService(intent, 0) != null) {
                return 1L;
            }
        }
        return -1L;
    }

    public static List<DIState> getStatuses(Context context, List<String> list) {
        m mVarC = m.c();
        mVarC.getClass();
        if (!a.b(context)) {
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", "getDownloadInstallStatuses: isInstalled is false");
            return null;
        }
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "getDownloadInstallStatuses: pkgNameList is " + list);
        mVarC.a(context);
        String packageName = context.getPackageName();
        m.c cVar = new m.c();
        mVarC.a(context, new m.b(new f(mVarC, packageName, cVar), list, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, "getDownloadInstallStatuses"));
        try {
            List<DIState> list2 = (List) cVar.a(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
            if (list2 != null && list2.size() > 0) {
                return list2;
            }
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "getDownloadInstallStatuses: result is null");
            return new ArrayList();
        } catch (Exception e) {
            com.hihonor.dlinstall.page.a.b("DownloadInstallService", "getDownloadInstallStatuses: e is " + e.getMessage());
            return new ArrayList();
        }
    }

    public static ResponseData<UpdateListResult> getUpdateList(Context context, int i) {
        m mVarC = m.c();
        mVarC.getClass();
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "getUpdateList: size " + i);
        mVarC.a(context);
        GetUpdateListAbility getUpdateListAbility = new GetUpdateListAbility(context, Integer.valueOf(i));
        mVarC.a(context, getUpdateListAbility);
        return getUpdateListAbility.getExecuteAbilityResponse();
    }

    public static DownloadInstallTask.Builder newTaskBuilder(Context context, String str) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()) != null ? new DownloadInstallTask.Builder(StubApp.getOrigApplicationContext(context.getApplicationContext()), str) : new DownloadInstallTask.Builder(context, str);
    }

    public static boolean openDetailPage(Activity activity, DownloadInstallTask downloadInstallTask) {
        if (getServiceVersion(activity) < 13) {
            return com.hihonor.dlinstall.page.a.a(activity, downloadInstallTask, 0, 0);
        }
        if (!com.hihonor.dlinstall.page.a.a(activity)) {
            com.hihonor.dlinstall.page.a.d("PageUtil", "openDetailPage: check safely not support");
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int detailType = downloadInstallTask.getDetailType() <= 0 ? 2 : downloadInstallTask.getDetailType();
        int downloadType = downloadInstallTask.getDownloadType() > 0 ? downloadInstallTask.getDownloadType() : 2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(c.ab, downloadInstallTask.getPartner());
        linkedHashMap.put("referrer", downloadInstallTask.getReferrer());
        linkedHashMap.put("sign", downloadInstallTask.getAuthSign());
        linkedHashMap.put("ts", downloadInstallTask.getTs());
        String string = new JSONObject(linkedHashMap).toString();
        stringBuffer.append("openDetailPage: pkgName is" + downloadInstallTask.getPkgName()).append(",detailType:" + detailType).append(",downloadType:" + downloadType).append(",sdkSign:" + string);
        Uri.Builder builder = new Uri.Builder();
        com.hihonor.dlinstall.page.a.a(builder, activity, downloadInstallTask, stringBuffer).scheme("honormarket").authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("detailType", String.valueOf(detailType)).appendQueryParameter("downloadType", String.valueOf(downloadType)).appendQueryParameter("sdkSign", string);
        com.hihonor.dlinstall.page.a.d("PageUtil", stringBuffer.toString());
        return com.hihonor.dlinstall.page.a.a(builder, activity);
    }

    public static boolean openDetailPage(Activity activity, DownloadInstallTask downloadInstallTask, int i, int i2) {
        return com.hihonor.dlinstall.page.a.a(activity, downloadInstallTask, i, i2);
    }

    public static boolean openTrafficDownloadPage(Activity activity, int i, String str) {
        if (!a.b(activity)) {
            com.hihonor.dlinstall.page.a.d("PageUtil", "openTrafficDownloadPage: isInstalled is false");
            return false;
        }
        try {
            String strA = m.c().a(activity, "openTrafficDownloadPage");
            Intent intent = new Intent();
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage("com.hihonor.appmarket");
            intent.putExtra("key_channel", i);
            intent.putExtra("key_pkg_name", str);
            intent.putExtra("caller_process_name", strA);
            intent.putExtra("key_page_type", 1);
            intent.setAction("com.hihonor.appmarket.service.intent.SECURE_PROXY_ACTIVITY");
            activity.startActivityForResult(intent, 8265);
            com.hihonor.dlinstall.page.a.d("PageUtil", "openTrafficDownloadPage: pkgName is " + str + ",checkPkgProcessName：" + strA + ",channel：" + i);
            return true;
        } catch (Exception e) {
            com.hihonor.dlinstall.page.a.b("PageUtil", "openDetailPage: e is " + e.getMessage());
            return false;
        }
    }

    public static void registerBtnListener(DownloadInstallBtnListener downloadInstallBtnListener) {
        b bVarA = b.a();
        bVarA.getClass();
        synchronized (b.class) {
            if (!bVarA.b.contains(downloadInstallBtnListener)) {
                bVarA.b.add(downloadInstallBtnListener);
            }
        }
    }

    public static void registerListener(DownloadInstallListener downloadInstallListener) {
        b bVarA = b.a();
        bVarA.getClass();
        synchronized (b.class) {
            if (!bVarA.f3593a.contains(downloadInstallListener)) {
                bVarA.f3593a.add(downloadInstallListener);
            }
        }
    }

    public static boolean syncPriorityAppList(Context context, List<SyncAppInfo> list) {
        m mVarC = m.c();
        mVarC.getClass();
        if (!a.b(context)) {
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", "syncPriorityAppList: isInstalled is false");
            return false;
        }
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "syncPriorityAppList: pkgs is " + list);
        mVarC.a(context);
        SyncAppListAbility syncAppListAbility = new SyncAppListAbility(context, list);
        mVarC.a(context, syncAppListAbility);
        Boolean executeAbilityResult = syncAppListAbility.getExecuteAbilityResult();
        if (executeAbilityResult != null) {
            return executeAbilityResult.booleanValue();
        }
        return false;
    }

    public static void unregisterBtnListener(DownloadInstallBtnListener downloadInstallBtnListener) {
        b bVarA = b.a();
        bVarA.getClass();
        synchronized (b.class) {
            bVarA.b.remove(downloadInstallBtnListener);
        }
    }

    public static void unregisterListener(DownloadInstallListener downloadInstallListener) {
        b bVarA = b.a();
        bVarA.getClass();
        synchronized (b.class) {
            bVarA.f3593a.remove(downloadInstallListener);
        }
    }

    public static boolean openDetailPage(Activity activity, DownloadInstallTask downloadInstallTask, int i) {
        return com.hihonor.dlinstall.page.a.a(activity, downloadInstallTask, i, 0);
    }
}
