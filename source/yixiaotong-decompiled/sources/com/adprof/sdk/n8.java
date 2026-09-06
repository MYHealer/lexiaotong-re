package com.adprof.sdk;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import com.adprof.sdk.api.AFFileProvider;
import com.adprof.sdk.api.AdAppInfo;
import com.byazt.tk.AdBaseConstants;
import com.stub.StubApp;
import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class n8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f1321a = new Hashtable();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Set f516a = new CopyOnWriteArraySet();

    public static long a(String str, String str2, String str3) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    String strTrim = str.trim();
                    if (TextUtils.isEmpty(Uri.parse(strTrim).getScheme())) {
                        strTrim = "http://" + strTrim;
                    }
                    if (!strTrim.startsWith("http")) {
                        return -2L;
                    }
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(strTrim));
                    File file = new File(str2);
                    request.setTitle(str3);
                    request.setAllowedNetworkTypes(3);
                    request.setAllowedOverRoaming(true);
                    request.setVisibleInDownloadsUi(true);
                    request.setNotificationVisibility(1);
                    File parentFile = file.getParentFile();
                    if (parentFile.exists()) {
                        if (!parentFile.isDirectory()) {
                            parentFile.delete();
                            if (!parentFile.mkdirs()) {
                                return -3L;
                            }
                        }
                    } else if (!parentFile.mkdirs()) {
                        return -4L;
                    }
                    request.addRequestHeader("User-Agent", ig.a());
                    request.setDestinationUri(Uri.fromFile(file));
                    return a().enqueue(request);
                }
            } catch (Throwable th) {
                pk.b("downloadApk3 error", th);
                oh.b(th);
            }
        }
        return -1L;
    }

    public static DownloadManager a() {
        Context context = AdprofSdk.getInstance().getContext();
        if (context != null) {
            return (DownloadManager) context.getSystemService("download");
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static HashMap m696a() {
        Cursor cursorQuery;
        try {
            DownloadManager downloadManagerA = a();
            if (downloadManagerA != null) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterByStatus(3);
                cursorQuery = downloadManagerA.query(query);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        cursorQuery.close();
                        return null;
                    }
                    HashMap map = new HashMap();
                    do {
                        Long lValueOf = Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id")));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("local_uri"));
                        if (!TextUtils.isEmpty(string)) {
                            map.put(string, lValueOf);
                        }
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return map;
                } catch (Throwable th) {
                    th = th;
                    try {
                        pk.b("getDownloadingTask error", th);
                        return null;
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        return null;
    }

    public static void a(d dVar, String str, String str2) {
        pk.b("\n sart download apk  " + str + "  portal  = " + str2 + "   \n\n");
        qn.a(dVar, "download_start");
        oh.a("download_start", "", dVar);
        HashMap map = new HashMap();
        map.put("result", "1");
        map.put("downloadId", dVar.f191a);
        s5.a(dVar.k(), map, "action.ad.download.start", 0);
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 1) != null;
        } catch (Throwable th) {
            pk.b("getUnInstallApkInfo error", th);
            return false;
        }
    }

    public static void a(String str, String str2, d dVar) {
        Long lValueOf;
        Context context = AdprofSdk.getInstance().getContext();
        try {
            try {
                String str3 = TextUtils.isEmpty(str) ? be.a(str2) + ".apk" : str;
                File file = new File(k1.a(), str3);
                String absolutePath = file.getAbsolutePath();
                Iterator it = ((CopyOnWriteArraySet) f516a).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        lValueOf = null;
                        break;
                    }
                    m8 m8Var = (m8) it.next();
                    if (m8Var.f1302a == -1 || m8Var.f464a.equalsIgnoreCase(absolutePath)) {
                        lValueOf = Long.valueOf(m8Var.f1302a);
                        break;
                    }
                }
                if (lValueOf != null && lValueOf.longValue() > 0) {
                    try {
                        Toast.makeText(context, "正在下载", 1).show();
                        if (dVar.f191a == null) {
                            dVar.f191a = lValueOf;
                            File file2 = new File(k1.m667a(), lValueOf + ".log");
                            if (file2.exists()) {
                                file2.delete();
                            }
                            j9.a(dVar, file2.getAbsolutePath());
                            a(dVar, str2, "downloading_1");
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        pk.b("downloadAPK2 error1", th);
                        oh.b(th);
                        return;
                    }
                }
                HashMap mapM696a = m696a();
                if (mapM696a != null) {
                    for (String str4 : mapM696a.keySet()) {
                        if (!TextUtils.isEmpty(str4) && str4.equals(file.getAbsolutePath())) {
                            try {
                                Toast.makeText(context, "正在下载", 1).show();
                            } catch (Throwable unused) {
                            }
                            try {
                                Object obj = mapM696a.get(str4);
                                if (obj instanceof Long) {
                                    dVar.f191a = (Long) obj;
                                    File file3 = new File(k1.m667a(), lValueOf + ".log");
                                    if (file3.exists()) {
                                        file3.delete();
                                    }
                                    j9.a(dVar, file3.getAbsolutePath());
                                    a(dVar, str2, "downloading_2");
                                    return;
                                }
                                return;
                            } catch (Throwable th2) {
                                pk.b("downloadAPK2 error2", th2);
                                oh.b(th2);
                                return;
                            }
                        }
                    }
                }
                Map map = f1321a;
                boolean zContainsKey = ((Hashtable) map).containsKey(dVar.k());
                if (file.exists() && !zContainsKey && !a(context, file.getAbsolutePath())) {
                    pk.c("cacheFile deleteFile:" + j9.m658a(file.getAbsolutePath()));
                }
                pk.c(str3 + " exists:" + file.exists() + " containsKey:" + zContainsKey);
                if (file.exists()) {
                    if (zContainsKey) {
                        a(context, file.getAbsolutePath(), dVar);
                        return;
                    }
                    long jLastModified = file.lastModified();
                    z1.a().getClass();
                    if (System.currentTimeMillis() - jLastModified <= ((long) 259200) * 1000) {
                        a(context, file.getAbsolutePath(), dVar);
                        return;
                    }
                    pk.c("timeOut deleteFile:" + j9.m658a(file.getAbsolutePath()));
                }
                ((Hashtable) map).put(dVar.k(), str3);
                String strM601c = dVar.m601c();
                if (TextUtils.isEmpty(strM601c)) {
                    strM601c = file.getName();
                }
                long jA = a(str2, file.getAbsolutePath(), strM601c);
                if (jA >= 0) {
                    try {
                        Toast.makeText(context, "已开始下载，可在通知栏尝试取消", 1).show();
                    } catch (Throwable th3) {
                        pk.b("toast error " + th3.getMessage());
                    }
                    String absolutePath2 = file.getAbsolutePath();
                    if (!TextUtils.isEmpty(absolutePath2)) {
                        ((CopyOnWriteArraySet) f516a).add(new m8(absolutePath2, null, jA));
                    }
                    File file4 = new File(k1.m667a(), jA + ".log");
                    dVar.f191a = Long.valueOf(jA);
                    j9.a(dVar, file4.getAbsolutePath());
                    a(dVar, str2, "already_start_download");
                    return;
                }
                pk.d("download fail.....");
                oh.a("download_failed", "", dVar, null, null);
                Toast.makeText(context, "下载失败,错误码 " + jA, 0).show();
                HashMap map2 = new HashMap();
                map2.put("result", "0");
                map2.put("downloadId", -1);
                if (dVar.m590a() != null) {
                    dVar.m590a().b(dVar);
                    return;
                }
                return;
            } catch (Throwable th4) {
                pk.b("downloadAPK2 error: ", th4);
                HashMap map3 = new HashMap();
                map3.put("result", "0");
                map3.put("downloadId", -1);
                s5.a(dVar.k(), map3, "action.ad.download.start", 0);
                Toast.makeText(context, "请先给予应用权限", 1).show();
                return;
            }
            Toast.makeText(context, "请先给予应用权限", 1).show();
            return;
        } catch (Throwable unused2) {
            return;
        }
        pk.b("downloadAPK2 error: ", th4);
        HashMap map4 = new HashMap();
        map4.put("result", "0");
        map4.put("downloadId", -1);
        s5.a(dVar.k(), map4, "action.ad.download.start", 0);
    }

    public static void a(String str, d dVar) {
        Context context = AdprofSdk.getInstance().getContext();
        try {
            pk.b(" \n \n download apk url  = " + str + "  \n\n");
            h2.a(dVar);
            AdAppInfo adAppInfo = dVar.f182a;
            String strA = (adAppInfo == null || TextUtils.isEmpty(adAppInfo.getDownloadUrl())) ? null : be.a(dVar.f182a.getDownloadUrl());
            String string = (!TextUtils.isEmpty(strA) ? new StringBuilder().append(strA) : new StringBuilder().append(be.a(str))).append(".apk").toString();
            dVar.f205g = string;
            a(string, str, dVar);
        } catch (Throwable th) {
            pk.b("downloadApk1 error", th);
            try {
                Toast.makeText(context, "下载失败", 1).show();
            } catch (Throwable th2) {
                pk.b("toast error: " + th2.getMessage());
            }
        }
    }

    public static void a(Context context, String str, d dVar) {
        PackageInfo packageInfoA;
        File file = new File(str);
        pk.a("\n\n installAPK:  " + file.getAbsolutePath() + "     file_exist = " + file.exists() + "  \n\n");
        Intent intent = new Intent();
        intent.addFlags(268468224);
        intent.setAction("android.intent.action.VIEW");
        try {
            Toast.makeText(context, "开始安装", 1).show();
        } catch (Throwable th) {
            pk.b("installAPK error1", th);
        }
        if (context.getApplicationInfo().targetSdkVersion < 24) {
            Uri uriFromFile = Uri.fromFile(file);
            String name = file.getName();
            intent.setDataAndType(uriFromFile, MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(name.lastIndexOf(".") + 1, name.length()).toLowerCase()));
            packageInfoA = he.a(context, str);
        } else {
            try {
                Uri uriForFile = AFFileProvider.getUriForFile(StubApp.getOrigApplicationContext(context.getApplicationContext()), StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName() + ".adprofprovider", file);
                if (uriForFile != null) {
                    intent.addFlags(1);
                    intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                }
                pk.a("installAPK uriForFile" + uriForFile);
                packageInfoA = he.a(context, str);
            } catch (Throwable th2) {
                pk.b("installAPK error2", th2);
                packageInfoA = null;
            }
        }
        if (packageInfoA != null) {
            pk.a("installAPK info" + packageInfoA);
            File file2 = new File(k1.m667a(), packageInfoA.packageName + ".log");
            try {
                j9.a(dVar, file2.getAbsolutePath());
                context.startActivity(intent);
                qn.a(dVar, "app_install_start");
                HashMap map = new HashMap();
                map.put("result", "1");
                s5.a(dVar.k(), map, "action.ad.install.start", 0);
                oh.a("app_install_start", "1", dVar);
                return;
            } catch (Throwable th3) {
                if (file2.exists()) {
                    file2.delete();
                }
                pk.b("install apk fail", th3);
            }
        }
        j9.m658a(str);
        qn.a(dVar, "app_install_start");
        HashMap map2 = new HashMap();
        map2.put("result", "0");
        s5.a(dVar.k(), map2, "action.ad.install.start", 0);
        oh.a("app_install_start", "0", dVar);
        pk.a("installAPK deleteFile");
    }
}
