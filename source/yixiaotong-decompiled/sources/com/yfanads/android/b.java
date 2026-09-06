package com.yfanads.android;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.db.d;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.net.UrlHttpUtil;
import com.yfanads.android.libs.utils.DeviceUtils;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.EventData;
import com.yfanads.android.model.SdkConfModel;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.qapp.QuickMgr;
import com.yfanads.android.upload.e;
import com.yfanads.android.upload.f;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: AdsInnerMgr.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b {
    public static final String[] d = {"hap://", "hnquickapp://", "hiapp://", "oaps://mk/web", "http://hapjs.org/app", "https://hapjs.org/app", "hwfastapp://"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f9632a = new CopyOnWriteArrayList();
    public int b = 1;
    public String c;

    /* JADX INFO: compiled from: AdsInnerMgr.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9633a = new b();
    }

    /* JADX INFO: renamed from: com.yfanads.android.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdsInnerMgr.java */
    public interface InterfaceC1176b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:123:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public void a(Application application, String str, String str2, long j) throws Throwable {
        YFLog.traceDebug("sdk thread start");
        YFAdsPhone.getInstance().init(application, str);
        boolean z = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b bVar = com.yfanads.android.upload.b.a.f9685a;
        bVar.getClass();
        bVar.a(YFAdsConst.ReportETypeValue.APP_OPEN.getValue(), str2);
        int value = YFAdsConst.ReportETypeValue.APP_OPEN_RT.getValue();
        if (InitUtils.isRTReport(value)) {
            EventData eventData = new EventData();
            eventData.eId = Util.getRandomUuid();
            eventData.rId = str2;
            eventData.eType = value;
            eventData.t = Util.getCurrentTime();
            try {
                bVar.b();
                bVar.f9684a.d(eventData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        InitUtils.impSdkAdapter(StubApp.getOrigApplicationContext(application.getApplicationContext()), str2);
        YFLog.traceDebug("sdk thread success, start call back, time is " + (System.currentTimeMillis() - j));
        a.f9633a.b();
        YFLog.high("readFromAssets start");
        List<String> pInfoList = DeviceUtils.getPInfoList();
        if (pInfoList == null || pInfoList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            try {
                InputStream inputStreamOpen = application.getAssets().open("packages/packages");
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            } else {
                                arrayList.add(line);
                            }
                        } catch (Throwable th) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th;
                    }
                    bufferedReader.close();
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                } catch (Throwable th4) {
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    throw th4;
                }
            } catch (IOException e2) {
                YFLog.warn("readAppListFromAssets " + e2.getMessage());
            }
            DeviceUtils.setPInoList(arrayList);
            YFLog.high("readInfo end size = " + arrayList.size());
        } else {
            YFLog.high("readFromAssets end server size =" + pInfoList.size());
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(application.getApplicationContext());
        try {
            if (InitUtils.isQueryAllPackage()) {
                List<String> pInfoList2 = DeviceUtils.getPInfoList();
                if (pInfoList2 != null && !pInfoList2.isEmpty()) {
                    YFLog.high("searchAppList start size = " + pInfoList2.size());
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    for (String str3 : pInfoList2) {
                        if (!TextUtils.isEmpty(str3)) {
                            try {
                                if (origApplicationContext.getPackageManager().getPackageInfo(str3, 0) != null) {
                                    i++;
                                    sb.append(str3).append(",");
                                }
                            } catch (PackageManager.NameNotFoundException unused) {
                            }
                        }
                    }
                    String string = sb.toString();
                    if (string.endsWith(",")) {
                        string = string.substring(0, string.length() - 1);
                    }
                    String strEncrypt = TextUtils.isEmpty(string) ? "" : Util.encrypt(string, UrlConst.getPkgKey(), UrlConst.getPkgIV());
                    Util.setAppHash(string, strEncrypt);
                    DeviceUtils.setPInoList(null);
                    String[] strArr = {Util.APP_SOURCE_KEY, Util.APP_HASH_KEY};
                    String[] strArr2 = {string, strEncrypt};
                    SharedPreferences.Editor editorEdit = YFAdsManager.getInstance().getContext().getSharedPreferences("adsConfig", 0).edit();
                    for (int i2 = 0; i2 < 2; i2++) {
                        if (i2 < 2) {
                            editorEdit.putString(strArr[i2], strArr2[i2]);
                        }
                    }
                    editorEdit.apply();
                    YFLog.debug("searchAppList size = " + i + " , save true");
                }
            } else {
                YFLog.high("searchAppList is not, return.");
            }
        } catch (Exception e3) {
            YFLog.warn("searchAppList " + e3.getMessage());
        }
        try {
            Context origApplicationContext2 = StubApp.getOrigApplicationContext(application.getApplicationContext());
            SdkConfModel confModel = InitUtils.getConfModel();
            String str4 = confModel != null ? confModel.getVer() + "" : "0";
            HashMap map = new HashMap();
            map.put(YFAdsConst.REPORT_APPID, YFAdsManager.getInstance().getYFAdsConfig().getAppId());
            map.put("ver", str4);
            d dVar = d.a.f9643a;
            com.yfanads.android.a aVar = new com.yfanads.android.a(this, origApplicationContext2, confModel);
            dVar.getClass();
            boolean z2 = com.yfanads.android.upload.b.e;
            com.yfanads.android.upload.b.a.f9685a.a(YFAdsConst.ReportETypeValue.APP_CONFIG_START.getValue(), "");
            UrlHttpUtil.get(UrlConst.getGetAds("/app"), map, new com.yfanads.android.db.a(dVar, aVar));
        } catch (Exception e4) {
            YFLog.warn("updateNextConfig error " + e4.getMessage());
        }
        f.e = InitUtils.isCrashUpd();
        f.f9689a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new f());
        boolean z3 = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b.a.f9685a.getClass();
        if (!f.e) {
            YFLog.high("crash log not upload, return.");
        } else if (f.b) {
            YFLog.high("crash is uploading, return.");
        } else if (YFAdsManager.getInstance().getContext() == null) {
            YFLog.error("crash context is null, return.");
        } else {
            File cacheDir = YFAdsManager.getInstance().getContext().getCacheDir();
            File file = new File(cacheDir, "yfcrash_info");
            if (!file.exists()) {
                YFLog.high("crash log dir is not exists, return.");
            } else if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                    YFLog.high("crash has no, return.");
                } else {
                    String str5 = f.c + "_" + YFAdsPhone.getInstance().getSDKVersion() + "_" + f.d + "_" + new SimpleDateFormat("MM-dd HH_mm_ss", Locale.getDefault()).format(new Date()) + "_crash.zip";
                    File file2 = new File(cacheDir, "yfcrash_zip");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    Util.zipFolder(file.getAbsolutePath(), file2.getAbsolutePath() + "/" + str5);
                    String str6 = UrlConst.getUploadLog() + "?sign=" + Util.md5(str5 + x.bQ + UrlConst.getSignKey()) + "&device_type=0&file_type=1&package=" + f.c + "&need_save=1&appID=" + YFAdsManager.getInstance().getYFAdsConfig().getAppId() + "&devID=" + YFAdsPhone.getInstance().getDeviceId() + "&sdk_v=" + YFAdsPhone.getInstance().getSDKVersion() + "&app_v=" + YFAdsManager.getInstance().getYFAdsConfig().getAppVer();
                    f.b = true;
                    UrlHttpUtil.uploadFile(str6, new File(file2.getAbsolutePath() + "/" + str5), str5, UriUtil.LOCAL_FILE_SCHEME, "application/zip", new e(file, file2));
                }
            } else {
                YFLog.high("crash log is not dir, return.");
            }
        }
        YFLog.traceDebug("sdk thread other work.");
    }

    public final void b(final Application application, final String str, final String str2, final long j) {
        Util.EXECUTOR.submit(new Runnable() { // from class: com.yfanads.android.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.a(application, str2, str, j);
            }
        });
    }

    public final void b() {
        synchronized (this) {
            this.b = 3;
        }
        if (this.f9632a.isEmpty()) {
            YFLog.debug("onSuccess initListeners is empty, return.");
            return;
        }
        for (final InterfaceC1176b interfaceC1176b : this.f9632a) {
            Objects.requireNonNull(interfaceC1176b);
            YFUtil.switchMainThread("onSuccess", new BaseEnsureListener() { // from class: com.yfanads.android.b$$ExternalSyntheticLambda2
                @Override // com.yfanads.android.callback.BaseEnsureListener
                public final void ensure() {
                    interfaceC1176b.a();
                }
            });
        }
        this.f9632a.clear();
    }

    public static void a(final Context context, SdkConfModel sdkConfModel) {
        if (sdkConfModel != null) {
            try {
                if (sdkConfModel.isQabOpen()) {
                    final String[] qal = sdkConfModel.getQal();
                    if (YFListUtils.isArrayEmpty(qal)) {
                        qal = d;
                    }
                    YFUtil.MAIN_HANDLER.post(new Runnable() { // from class: com.yfanads.android.b$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            QuickMgr.install(context, "YFAds-Hap", qal);
                        }
                    });
                }
            } catch (Exception e) {
                YFLog.warn("initQab error " + e.getMessage());
            }
        }
    }

    public final synchronized boolean a() {
        return this.b == 2;
    }
}
