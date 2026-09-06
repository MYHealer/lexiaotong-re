package com.hihonor.dlinstall.page;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.bv.BaseConstants;
import com.cdo.oaps.ad.OapsKey;
import com.hihonor.dlinstall.DownloadInstallTask;
import com.hihonor.dlinstall.ability.syncapp.AdAppReport;
import com.hihonor.dlinstall.data.PackageInfoResult;
import com.hihonor.dlinstall.ipc.m;
import com.hihonor.dlinstall.report.DlInstallReportConfig;
import com.hihonor.dlinstall.util.c;
import com.huawei.hms.ads.ez;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f3610a;

    public static Uri.Builder a(Uri.Builder builder, Activity activity, DownloadInstallTask downloadInstallTask, StringBuffer stringBuffer) {
        m.c().a(activity);
        String pkgName = downloadInstallTask.getPkgName();
        int channel = downloadInstallTask.getChannel();
        String subChannel = downloadInstallTask.getSubChannel();
        AdAppReport adAppReport = downloadInstallTask.getAdAppReport();
        boolean zA = com.hihonor.dlinstall.util.a.a(adAppReport);
        PackageInfoResult packageInfoResultA = com.hihonor.dlinstall.util.a.a(activity);
        String callerApkVer = downloadInstallTask.getCallerApkVer();
        String str = "";
        if (packageInfoResultA != null) {
            String callerAppName = packageInfoResultA.getCallerAppName();
            if (TextUtils.isEmpty(callerApkVer)) {
                callerApkVer = packageInfoResultA.getCallerAppVer() + "";
            }
            str = callerAppName;
        }
        String strA = m.c().a(activity, s.f4444a);
        stringBuffer.append(",callerProcessName:" + strA).append(",channel:" + channel).append(",subChannel:" + subChannel).append(",isAd:" + zA);
        builder.appendQueryParameter("is_from_download_install_sdk", ez.Code).appendQueryParameter("request_id", com.hihonor.dlinstall.util.a.a(activity, pkgName, -1)).appendQueryParameter("channel", String.valueOf(channel)).appendQueryParameter("isAd", String.valueOf(zA)).appendQueryParameter("key_sdk_version", String.valueOf(14L)).appendQueryParameter("key_launcher_install_type", String.valueOf(downloadInstallTask.getLauncherInstallType()));
        if (!TextUtils.isEmpty(pkgName)) {
            builder.appendQueryParameter("id", pkgName);
        }
        if (!TextUtils.isEmpty(str)) {
            builder.appendQueryParameter("appName", str);
        }
        if (!TextUtils.isEmpty(activity.getPackageName())) {
            builder.appendQueryParameter(OapsKey.KEY_CALLER, activity.getPackageName());
        }
        if (!TextUtils.isEmpty(subChannel)) {
            builder.appendQueryParameter("subChannel", subChannel);
        }
        if (!TextUtils.isEmpty(downloadInstallTask.getSceneType())) {
            builder.appendQueryParameter("sceneType", downloadInstallTask.getSceneType());
        }
        if (!TextUtils.isEmpty(callerApkVer)) {
            builder.appendQueryParameter("callerApkVer", callerApkVer);
        }
        if (!TextUtils.isEmpty(strA)) {
            builder.appendQueryParameter("caller_process_name", strA);
        }
        if (!TextUtils.isEmpty(downloadInstallTask.getExtraData())) {
            builder.appendQueryParameter("key_extra_data", downloadInstallTask.getExtraData());
        }
        if (adAppReport != null) {
            if (!TextUtils.isEmpty(adAppReport.getAdId())) {
                builder.appendQueryParameter("adId", adAppReport.getAdId());
            }
            if (!TextUtils.isEmpty(adAppReport.getAdType())) {
                builder.appendQueryParameter("adType", adAppReport.getAdType());
            }
            if (!TextUtils.isEmpty(adAppReport.getMediaId())) {
                builder.appendQueryParameter("mediaId", adAppReport.getMediaId());
            }
            if (!TextUtils.isEmpty(adAppReport.getAdUnitId())) {
                builder.appendQueryParameter("adUnitId", adAppReport.getAdUnitId());
            }
            if (!TextUtils.isEmpty(adAppReport.getMediaRequestId())) {
                builder.appendQueryParameter("mediaRequestId", adAppReport.getMediaRequestId());
            }
            if (!TextUtils.isEmpty(adAppReport.getAdRequestId())) {
                builder.appendQueryParameter("adRequestId", adAppReport.getAdRequestId());
            }
            if (!TextUtils.isEmpty(adAppReport.getChannelInfo())) {
                builder.appendQueryParameter("channelInfo", adAppReport.getChannelInfo());
            }
            if (!TextUtils.isEmpty(adAppReport.getExtraJson())) {
                builder.appendQueryParameter("extraJson", adAppReport.getExtraJson());
            }
        }
        DlInstallReportConfig reportConfig = downloadInstallTask.getReportConfig();
        if (reportConfig != null) {
            if (!reportConfig.getDownloadStartReportUrlList().isEmpty()) {
                a(builder, "download_start_report_url", reportConfig.getDownloadStartReportUrlList());
            }
            if (!reportConfig.getDownloadSuccessReportUrlList().isEmpty()) {
                a(builder, "download_success_report_url", reportConfig.getDownloadSuccessReportUrlList());
            }
            if (!reportConfig.getDownloadFailReportUrlList().isEmpty()) {
                a(builder, "download_fail_report_url", reportConfig.getDownloadFailReportUrlList());
            }
            if (!reportConfig.getInstallStartReportUrlList().isEmpty()) {
                a(builder, "install_start_report_url", reportConfig.getInstallStartReportUrlList());
            }
            if (!reportConfig.getInstallSuccessReportUrlList().isEmpty()) {
                a(builder, "install_success_report_url", reportConfig.getInstallSuccessReportUrlList());
            }
            if (!reportConfig.getInstallFailReportUrlList().isEmpty()) {
                a(builder, "install_fail_report_url", reportConfig.getInstallFailReportUrlList());
            }
            if (!reportConfig.getCommonsReportUrlList().isEmpty()) {
                a(builder, "commons_url", reportConfig.getCommonsReportUrlList());
            }
            if (!reportConfig.getClickReportUrlList().isEmpty()) {
                a(builder, "click_report_url", reportConfig.getClickReportUrlList());
            }
        }
        return builder;
    }

    public static String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str + PPSLabelView.Code + str2;
    }

    public static void a(Uri.Builder builder, String str, List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        int i = 0;
        while (i < list.size()) {
            builder.appendQueryParameter(i == 0 ? str : str + "_" + (i + 1), list.get(i));
            i++;
        }
    }

    public static boolean a(Activity activity) {
        String str;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - c.f3613a;
        c.f3613a = jElapsedRealtime;
        if (j <= 800) {
            str = "openDetailPage: click too frequently";
        } else {
            if (com.hihonor.dlinstall.util.a.b(activity)) {
                return true;
            }
            str = "openDetailPage: isInstalled is false";
        }
        d("PageUtil", str);
        return false;
    }

    public static boolean a(Activity activity, DownloadInstallTask downloadInstallTask, int i, int i2) {
        String string;
        if (a(activity)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("openDetailPage: pkgName is" + downloadInstallTask.getPkgName()).append(",type:" + i).append(",screenType:" + i2);
            if ((i == 0 || i == 1 || i == 2) && (i2 == 0 || i2 == 1 || i2 == 2)) {
                boolean z = i == 1;
                Uri.Builder builder = new Uri.Builder();
                a(builder, activity, downloadInstallTask, stringBuffer).scheme("host_market").authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("screen_orientation", String.valueOf(i2)).appendQueryParameter("is_half_screen", String.valueOf(z)).appendQueryParameter("detail_page_type", String.valueOf(i));
                d("PageUtil", stringBuffer.toString());
                return a(builder, activity);
            }
            string = stringBuffer.toString();
        } else {
            string = "openDetailPage: check safely not support";
        }
        d("PageUtil", string);
        return false;
    }

    public static boolean a(Uri.Builder builder, Activity activity) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", builder.build());
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage("com.hihonor.appmarket");
            activity.startActivityForResult(intent, 8265);
            return true;
        } catch (Exception e) {
            b("PageUtil", "openDetailPage: e is " + e.getMessage());
            return false;
        }
    }

    public static void b(String str, String str2) {
        Log.e("AM_SDK", a(str, str2));
    }

    public static void c(String str, String str2) {
        Log.i("AM_SDK", a(str, str2));
    }

    public static void d(String str, String str2) {
        Log.w("AM_SDK", a(str, str2));
    }
}
