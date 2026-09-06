package com.yfanads.android.upload;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.kuaishou.weapon.p0.g;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.EventData;
import com.yfanads.android.model.Permission;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PermissionLogManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f9682a;

    /* JADX INFO: renamed from: com.yfanads.android.upload.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PermissionLogManager.java */
    public static class C1178a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9683a = new a();
    }

    public static void a() {
        Context context = YFAdsManager.getInstance().getContext();
        if (context == null) {
            YFLog.error("context is null. return");
            return;
        }
        StringBuilder sb = new StringBuilder("Build.VERSION.SDK_INT:");
        int i = Build.VERSION.SDK_INT;
        Log.e("PD:", sb.append(i).toString());
        HashMap map = new HashMap();
        map.put("inter", g.f4712a);
        map.put("rps", "android.permission.READ_PHONE_STATE");
        map.put("acl", g.h);
        map.put("afl", "android.permission.ACCESS_FINE_LOCATION");
        map.put("aws", g.d);
        map.put("wes", "android.permission.WRITE_EXTERNAL_STORAGE");
        map.put("wl", "android.permission.WAKE_LOCK");
        map.put("sal", "android.permission.SYSTEM_ALERT_WINDOW");
        map.put("rip", "android.permission.REQUEST_INSTALL_PACKAGES");
        if (i >= 30) {
            map.put("qap", "android.permission.QUERY_ALL_PACKAGES");
        }
        StringBuilder sb2 = new StringBuilder("PDL:|manifest=");
        Iterator it = map.entrySet().iterator();
        while (true) {
            int i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getValue();
            String str2 = (String) entry.getKey();
            if (TextUtils.equals(str2, "sal")) {
                if (Settings.canDrawOverlays(context)) {
                    sb2.append(str2).append(":true,");
                } else {
                    sb2.append(str2).append(":false,");
                }
            } else if (TextUtils.equals(str2, "rip")) {
                try {
                    String[] strArr = context.getPackageManager().getPackageInfo(YFAdsManager.getInstance().getYFAdsConfig().getAppPackage(), 4096).requestedPermissions;
                    int length = strArr.length;
                    while (true) {
                        if (i2 >= length) {
                            sb2.append(str2).append(":false,");
                            break;
                        } else {
                            if (TextUtils.equals("android.permission.REQUEST_INSTALL_PACKAGES", strArr[i2])) {
                                sb2.append(str2).append(":true,");
                                break;
                            }
                            i2++;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (TextUtils.equals(str2, "qap")) {
                try {
                    String[] strArr2 = context.getPackageManager().getPackageInfo(YFAdsManager.getInstance().getYFAdsConfig().getAppPackage(), 4096).requestedPermissions;
                    int length2 = strArr2.length;
                    while (true) {
                        if (i2 >= length2) {
                            sb2.append(str2).append(":false,");
                            break;
                        } else {
                            if (TextUtils.equals("android.permission.QUERY_ALL_PACKAGES", strArr2[i2])) {
                                sb2.append(str2).append(":true,");
                                break;
                            }
                            i2++;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (Util.checkSelfPermission(context, str, 0)) {
                sb2.append(str2).append(":true,");
            } else {
                sb2.append(str2).append(":false,");
            }
        }
        YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
        if (yFAdsConfig == null) {
            YFLog.high(sb2.toString());
            YFLog.error("YFAdsConfig is null. return");
        } else {
            YFLog.high("findSdkApi start");
            sb2.append("|api=cwe:");
            sb2.append(yFAdsConfig.isCanUseWriteExternal()).append(",cua:");
            sb2.append(yFAdsConfig.isCanUseAppList()).append(",cuaid:");
            sb2.append(yFAdsConfig.isCanUseAndroidId()).append(",cul:");
            sb2.append(yFAdsConfig.isCanUseLocation()).append(",cuo:");
            sb2.append(yFAdsConfig.isCanUseOaid()).append(",cup:");
            sb2.append(yFAdsConfig.isCanUsePhoneState()).append(",cuw:");
            sb2.append(yFAdsConfig.isCanUseWifiState()).append(",car:");
            sb2.append(yFAdsConfig.isCloseAppReceiver()).append(",lp:");
            sb2.append(yFAdsConfig.isLimitPersonal()).append(",");
            HashMap map2 = new HashMap();
            Permission permission = new Permission();
            permission.cua = yFAdsConfig.isCanUseAppList() ? 1 : 0;
            permission.cul = yFAdsConfig.isCanUseLocation() ? 1 : 0;
            permission.cup = yFAdsConfig.isCanUsePhoneState() ? 1 : 0;
            permission.cuw = yFAdsConfig.isCanUseWifiState() ? 1 : 0;
            permission.cwe = yFAdsConfig.isCanUseWriteExternal() ? 1 : 0;
            permission.cuaid = yFAdsConfig.isCanUseAndroidId() ? 1 : 0;
            permission.cuo = yFAdsConfig.isCanUseOaid() ? 1 : 0;
            permission.car = yFAdsConfig.isCloseAppReceiver() ? 1 : 0;
            permission.lp = yFAdsConfig.isLimitPersonal() ? 1 : 0;
            map2.put(0, permission);
            for (Integer num : InitUtils.getChannels()) {
                if (num != null) {
                    boolean[] permissionValues = InitUtils.getPermissionValues(num.intValue(), yFAdsConfig);
                    Permission permission2 = new Permission();
                    permission2.cua = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CUA, true) ? 1 : 0;
                    permission2.cul = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CUL, true) ? 1 : 0;
                    permission2.cup = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CUP, true) ? 1 : 0;
                    permission2.cuw = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CUW, true) ? 1 : 0;
                    permission2.cwe = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CWE, true) ? 1 : 0;
                    permission2.cuaid = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CUAID, true) ? 1 : 0;
                    permission2.cuo = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CUO, true) ? 1 : 0;
                    permission2.car = InitUtils.getPermissionValue(permissionValues, YFAdsConst.CAR, true) ? 1 : 0;
                    permission2.lp = InitUtils.getPermissionValue(permissionValues, YFAdsConst.LP, false) ? 1 : 0;
                    map2.put(num, permission2);
                }
            }
            boolean z = b.e;
            b bVar = b.a.f9685a;
            String str3 = com.yfanads.android.b.a.f9633a.c;
            int value = YFAdsConst.ReportETypeValue.APP_PERMISSION.getValue();
            bVar.getClass();
            if (!b.a(value)) {
                EventData eventData = new EventData();
                eventData.eId = Util.getRandomUuid();
                eventData.rId = str3;
                eventData.eType = value;
                eventData.t = Util.getCurrentTime();
                eventData.extData = bVar.d.toJson(map2);
                bVar.a(eventData);
            }
            YFLog.high("findSdkApi end");
            YFLog.high(sb2.toString());
        }
        InitUtils.printPCConfigLog();
    }
}
