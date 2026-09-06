package com.umeng.commonsdk.stateless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.kuaishou.weapon.p0.g;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

/* JADX INFO: compiled from: UMSLNetWorkSender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9244a = 273;
    private static Context b = null;
    private static HandlerThread c = null;
    private static Handler d = null;
    private static final int f = 274;
    private static final int g = 275;
    private static final int h = 512;
    private static a i;
    private static IntentFilter j;
    private static boolean k;
    private static Object e = new Object();
    private static LinkedList<String> l = new LinkedList<>();
    private static BroadcastReceiver m = new BroadcastReceiver() { // from class: com.umeng.commonsdk.stateless.b.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager;
            if (context == null || intent == null) {
                return;
            }
            try {
                if (intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    Context unused = b.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    if (b.b != null && (connectivityManager = (ConnectivityManager) b.b.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                            boolean unused2 = b.k = true;
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
                            b.b(274);
                        } else {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
                            boolean unused3 = b.k = false;
                        }
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static void r() {
    }

    /* JADX INFO: compiled from: UMSLNetWorkSender.java */
    static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if ((i & 8) != 8) {
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            b.a(274);
        }
    }

    public static boolean a() {
        synchronized (e) {
            return i != null;
        }
    }

    public b(Context context) {
        synchronized (e) {
            if (context != null) {
                try {
                    Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    b = origApplicationContext;
                    if (origApplicationContext != null && c == null) {
                        HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                        c = handlerThread;
                        handlerThread.start();
                        if (i == null) {
                            String str = b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            a aVar = new a(str);
                            i = aVar;
                            aVar.startWatching();
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (d == null) {
                            d = new Handler(c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.2
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    int i2 = message.what;
                                    if (i2 != 512) {
                                        switch (i2) {
                                            case 273:
                                                b.m();
                                                return;
                                            case 274:
                                                b.o();
                                                return;
                                            case 275:
                                                b.q();
                                                break;
                                            default:
                                                return;
                                        }
                                    }
                                    b.r();
                                }
                            };
                        }
                        if (DeviceConfig.checkPermission(b, g.b)) {
                            ULog.i("walle", "[stateless] begin register receiver");
                            if (j == null) {
                                IntentFilter intentFilter = new IntentFilter();
                                j = intentFilter;
                                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                                if (m != null) {
                                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：注册网络状态监听器。");
                                    b.registerReceiver(m, j);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }
    }

    public static void a(int i2) {
        Handler handler;
        if (!k || (handler = d) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i2;
        d.sendMessage(messageObtainMessage);
    }

    public static void b(int i2) {
        Handler handler;
        try {
            if (!k || (handler = d) == null || handler.hasMessages(i2)) {
                return;
            }
            Message messageObtainMessage = d.obtainMessage();
            messageObtainMessage.what = i2;
            d.sendMessage(messageObtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(b, th);
        }
    }

    private static void j() {
        File[] fileArrC = d.c(b);
        if (fileArrC != null) {
            if (l.size() > 0) {
                l.clear();
            }
            for (File file : fileArrC) {
                l.add(file.getAbsolutePath());
            }
        }
    }

    private static String k() {
        String str = null;
        try {
            String strPeek = l.peek();
            if (strPeek == null) {
                return strPeek;
            }
            try {
                l.removeFirst();
                return strPeek;
            } catch (Throwable unused) {
                str = strPeek;
                return str;
            }
        } catch (Throwable unused2) {
        }
    }

    private static void l() {
        String strPollFirst;
        byte[] bArrA;
        if (l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            strPollFirst = l.pollFirst();
            if (!TextUtils.isEmpty(strPollFirst)) {
                File file = new File(strPollFirst);
                if (!file.exists()) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                } else {
                    c cVar = new c(b);
                    try {
                        bArrA = d.a(strPollFirst);
                    } catch (Exception unused) {
                        bArrA = null;
                    }
                    String name = file.getName();
                    String strSubstring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : "u";
                    String strD = d.d(name);
                    String str = com.umeng.commonsdk.stateless.a.j;
                    String strC = d.c(strD);
                    if (com.umeng.commonsdk.vchannel.a.c.equalsIgnoreCase(strC)) {
                        str = com.umeng.commonsdk.vchannel.a.f9294a;
                    }
                    if (cVar.a(bArrA, strC, str, strSubstring) && !file.delete()) {
                        file.delete();
                    }
                }
            }
        } while (strPollFirst != null);
        l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        File fileA;
        byte[] bArrA;
        if (!k || b == null) {
            return;
        }
        do {
            try {
                fileA = d.a(b);
                if (fileA != null && fileA.getParentFile() != null && !TextUtils.isEmpty(fileA.getParentFile().getName())) {
                    c cVar = new c(b);
                    String str = new String(Base64.decode(fileA.getParentFile().getName(), 0));
                    if (com.umeng.commonsdk.internal.a.f9223a.equalsIgnoreCase(str) || com.umeng.commonsdk.internal.a.b.equalsIgnoreCase(str) || com.umeng.commonsdk.internal.a.D.equalsIgnoreCase(str)) {
                        new File(fileA.getAbsolutePath()).delete();
                    } else {
                        ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        try {
                            bArrA = d.a(fileA.getAbsolutePath());
                        } catch (Exception unused) {
                            bArrA = null;
                        }
                        String str2 = com.umeng.commonsdk.vchannel.a.c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.f9294a : "";
                        String str3 = UMServerURL.PATH_SHARE.equalsIgnoreCase(str) ? "s" : "u";
                        if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                            str3 = "p";
                        }
                        if (cVar.a(bArrA, str, str2, str3)) {
                            ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                            File file = new File(fileA.getAbsolutePath());
                            if (!file.delete()) {
                                ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                                file.delete();
                            }
                        } else {
                            ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(b, th);
            }
        } while (fileA != null);
        n();
    }

    private static void n() {
        try {
            File file = new File(b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o() {
        if (!k || b == null) {
            return;
        }
        j();
        l();
        c();
    }

    private static void p() {
        try {
            File file = new File(b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(273);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
        p();
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(274);
    }

    public static void c() {
        b(275);
    }

    public static void d() {
        b(512);
    }
}
