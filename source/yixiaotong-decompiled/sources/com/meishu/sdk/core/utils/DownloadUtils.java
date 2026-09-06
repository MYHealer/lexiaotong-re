package com.meishu.sdk.core.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.byazt.tk.AdBaseConstants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.meishu.sdk.R;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.recycler.DownloadStatusListener;
import com.meishu.sdk.core.safe.SafeBroadcastReceiver;
import com.stub.StubApp;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DownloadUtils {
    public static Map<Integer, k0> h = new HashMap();
    public static final ConcurrentHashMap<String, f0> i = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, DownloadStatusListener> j = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, DownloadStatusListener> k = new ConcurrentHashMap<>();
    public static int l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NotificationManager f4863a;
    public RemoteViews b;
    public Notification c;
    public Handler d = new Handler(Looper.getMainLooper());
    public long e;
    public long f;
    public boolean g;

    public static class InstallSuccessReceiver extends SafeBroadcastReceiver {

        public class a extends com.meishu.sdk.core.safe.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DownloadStatusListener f4864a;

            public a(InstallSuccessReceiver installSuccessReceiver, DownloadStatusListener downloadStatusListener) {
                this.f4864a = downloadStatusListener;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                this.f4864a.onInstallSuccess();
            }
        }

        @Override // com.meishu.sdk.core.safe.SafeBroadcastReceiver
        public void a(Context context, Intent intent) {
            String[] strArr;
            if (intent != null) {
                try {
                    String action = intent.getAction();
                    intent.getPackage();
                    LogUtil.i("DownloadUtils", "InstallSuccessReceiver." + action);
                    if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                        Map<Integer, k0> map = DownloadUtils.h;
                        f0 f0Var = TextUtils.isEmpty(schemeSpecificPart) ? null : DownloadUtils.i.get(schemeSpecificPart);
                        if (f0Var != null && (strArr = f0Var.f4904a) != null) {
                            LogUtil.d("DownloadUtils", "Report send dn_inst_succ");
                            for (String str : strArr) {
                                if (!TextUtils.isEmpty(str)) {
                                    z.a(context, str, new i());
                                }
                            }
                        }
                        DownloadStatusListener downloadStatusListenerRemove = DownloadUtils.k.remove(schemeSpecificPart);
                        if (downloadStatusListenerRemove != null) {
                            new Handler(Looper.getMainLooper()).post(new a(this, downloadStatusListenerRemove));
                        }
                        if (TextUtils.isEmpty(schemeSpecificPart)) {
                            return;
                        }
                        DownloadUtils.i.remove(schemeSpecificPart);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class NotificationClickReceiver extends SafeBroadcastReceiver {
        public NotificationClickReceiver() {
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0062  */
        @Override // com.meishu.sdk.core.safe.SafeBroadcastReceiver
        public void a(Context context, Intent intent) {
            com.meishu.sdk.core.download.b bVar;
            com.meishu.sdk.core.download.a aVar;
            com.meishu.sdk.core.download.d dVarB;
            com.meishu.sdk.core.download.b bVar2;
            try {
                String action = intent.getAction();
                DownloadUtils downloadUtils = DownloadUtils.this;
                long jCurrentTimeMillis = System.currentTimeMillis();
                DownloadUtils downloadUtils2 = DownloadUtils.this;
                downloadUtils.f = jCurrentTimeMillis - downloadUtils2.e;
                downloadUtils2.e = System.currentTimeMillis();
                if (DownloadUtils.this.f < 500) {
                    return;
                }
                String stringExtra = intent.getStringExtra("notify_url");
                byte b = 0;
                int intExtra = intent.getIntExtra("notify_id", 0);
                int iHashCode = action.hashCode();
                if (iHashCode != 1099814334) {
                    if (iHashCode != 1111837832) {
                        if (iHashCode == 1777068973 && action.equals("ACTION_DOWNLOAD_INSTALL")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (!action.equals("ACTION_DOWNLOAD_PAUSE")) {
                        b = -1;
                    }
                } else if (action.equals("ACTION_DOWNLOAD_CACEL")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b != 0) {
                    if (b == 1) {
                        com.meishu.sdk.core.download.a.C0793a.f4782a.a(stringExtra);
                        NotificationManager notificationManager = DownloadUtils.this.f4863a;
                        if (notificationManager != null) {
                            notificationManager.cancel(intExtra);
                        }
                        DownloadUtils.h.remove(Integer.valueOf(DownloadUtils.a(stringExtra)));
                        return;
                    }
                    if (b == 2 && (dVarB = (aVar = com.meishu.sdk.core.download.a.C0793a.f4782a).b(stringExtra)) != null && (bVar2 = dVarB.f4785a) != null && bVar2.g == 5) {
                        aVar.a(stringExtra);
                        NotificationManager notificationManager2 = DownloadUtils.this.f4863a;
                        if (notificationManager2 != null) {
                            notificationManager2.cancel(intExtra);
                        }
                        DownloadUtils.a(context, stringExtra);
                        DownloadUtils.h.remove(Integer.valueOf(DownloadUtils.a(stringExtra)));
                        return;
                    }
                    return;
                }
                com.meishu.sdk.core.download.d dVarB2 = com.meishu.sdk.core.download.a.C0793a.f4782a.b(stringExtra);
                if (dVarB2 != null && (bVar = dVarB2.f4785a) != null) {
                    int identifier = context.getResources().getIdentifier("ms_notification_pause", "id", context.getPackageName());
                    if (identifier == 0) {
                        identifier = R.id.ms_notification_pause;
                    }
                    if (bVar.g == 3) {
                        dVarB2.a();
                        RemoteViews remoteViews = DownloadUtils.this.b;
                        if (remoteViews != null) {
                            remoteViews.setTextViewText(identifier, "暂停");
                        }
                    } else {
                        dVarB2.c.remove(dVarB2);
                        com.meishu.sdk.core.download.b bVar3 = dVarB2.f4785a;
                        int i = bVar3.g;
                        if (i == 1) {
                            bVar3.g = 3;
                            com.meishu.sdk.core.download.d.g.post(new com.meishu.sdk.core.download.f(dVarB2, bVar3));
                        } else if (i == 2) {
                            bVar3.g = 3;
                        }
                        RemoteViews remoteViews2 = DownloadUtils.this.b;
                        if (remoteViews2 != null) {
                            remoteViews2.setTextViewText(identifier, "继续");
                        }
                    }
                }
                if (DownloadUtils.this.f4863a == null || !DownloadUtils.h.containsKey(Integer.valueOf(intExtra))) {
                    return;
                }
                DownloadUtils.this.f4863a.notify(intExtra, DownloadUtils.h.get(Integer.valueOf(intExtra)).f4916a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class b extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadStatusListener f4871a;

        public b(DownloadStatusListener downloadStatusListener) {
            this.f4871a = downloadStatusListener;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            this.f4871a.onInstallStart();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DownloadUtils f4872a = new DownloadUtils();
    }

    public static void a(DownloadUtils downloadUtils, String str, Context context, String str2, String str3) {
        k0 k0Var;
        downloadUtils.getClass();
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("ACTION_DOWNLOAD_PAUSE");
            intentFilter.addAction("ACTION_DOWNLOAD_CACEL");
            intentFilter.addAction("ACTION_DOWNLOAD_INSTALL");
            context.registerReceiver(downloadUtils.new NotificationClickReceiver(), intentFilter);
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        downloadUtils.f4863a = (NotificationManager) context.getSystemService("notification");
        NotificationChannel notificationChannel = new NotificationChannel("ms_download", "正在下载应用" + str2 + "...", 4);
        notificationChannel.setSound(null, null);
        downloadUtils.f4863a.createNotificationChannel(notificationChannel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ms_download");
        builder.setContentTitle("正在下载应用" + str2 + "...");
        try {
            builder.setSmallIcon(android.R.drawable.stat_sys_download);
        } catch (Throwable unused) {
        }
        builder.setAutoCancel(true);
        downloadUtils.c = builder.build();
        int identifier = context.getResources().getIdentifier("ms_notification_item", TtmlNode.TAG_LAYOUT, context.getPackageName());
        if (identifier == 0) {
            downloadUtils.b = new RemoteViews(context.getPackageName(), R.layout.ms_notification_item);
        } else {
            downloadUtils.b = new RemoteViews(context.getPackageName(), identifier);
        }
        int identifier2 = context.getResources().getIdentifier("ms_notification_title", "id", context.getPackageName());
        int identifier3 = context.getResources().getIdentifier("ms_notification_cancel", "id", context.getPackageName());
        int identifier4 = context.getResources().getIdentifier("ms_notification_pause", "id", context.getPackageName());
        int identifier5 = context.getResources().getIdentifier("ms_notification_progressText", "id", context.getPackageName());
        int identifier6 = context.getResources().getIdentifier("ms_notification_pregressBar", "id", context.getPackageName());
        int identifier7 = context.getResources().getIdentifier("ms_notification_rootView", "id", context.getPackageName());
        if (identifier2 != 0) {
            downloadUtils.b.setTextViewText(identifier2, "正在下载:" + str2 + "...");
        } else {
            downloadUtils.b.setTextViewText(R.id.ms_notification_title, "正在下载:" + str2 + "...");
        }
        if (identifier3 != 0) {
            downloadUtils.b.setViewVisibility(identifier3, 0);
        } else {
            downloadUtils.b.setViewVisibility(R.id.ms_notification_cancel, 0);
        }
        if (identifier4 != 0) {
            downloadUtils.b.setViewVisibility(identifier4, 0);
        } else {
            downloadUtils.b.setViewVisibility(R.id.ms_notification_pause, 0);
        }
        if (identifier5 != 0) {
            downloadUtils.b.setTextViewText(identifier5, "0%");
        } else {
            downloadUtils.b.setTextViewText(R.id.ms_notification_progressText, "0%");
        }
        if (identifier6 != 0) {
            downloadUtils.b.setProgressBar(identifier6, 100, 0, false);
        } else {
            downloadUtils.b.setProgressBar(R.id.ms_notification_pregressBar, 100, 0, false);
        }
        int iA = a(str);
        l = iA;
        Intent intent = new Intent();
        intent.setAction("ACTION_DOWNLOAD_PAUSE");
        intent.putExtra("notify_id", iA);
        intent.putExtra("notify_url", str);
        int i2 = Build.VERSION.SDK_INT;
        PendingIntent broadcast = i2 >= 31 ? PendingIntent.getBroadcast(context, l, intent, 201326592) : PendingIntent.getBroadcast(context, l, intent, C.BUFFER_FLAG_FIRST_SAMPLE);
        if (identifier4 == 0) {
            identifier4 = R.id.ms_notification_pause;
        }
        downloadUtils.b.setOnClickPendingIntent(identifier4, broadcast);
        Intent intent2 = new Intent();
        intent2.setAction("ACTION_DOWNLOAD_CACEL");
        intent2.putExtra("notify_id", iA);
        intent2.putExtra("notify_url", str);
        PendingIntent broadcast2 = i2 >= 31 ? PendingIntent.getBroadcast(context, l, intent2, 335544320) : PendingIntent.getBroadcast(context, l, intent2, 268435456);
        if (identifier3 == 0) {
            identifier3 = R.id.ms_notification_cancel;
        }
        downloadUtils.b.setOnClickPendingIntent(identifier3, broadcast2);
        Intent intent3 = new Intent();
        intent3.setAction("ACTION_DOWNLOAD_INSTALL");
        intent3.putExtra("notify_id", iA);
        intent3.putExtra("notify_url", str);
        PendingIntent broadcast3 = i2 >= 31 ? PendingIntent.getBroadcast(context, l, intent3, 201326592) : PendingIntent.getBroadcast(context, l, intent3, C.BUFFER_FLAG_FIRST_SAMPLE);
        if (identifier7 == 0) {
            identifier7 = R.id.ms_notification_rootView;
        }
        downloadUtils.b.setOnClickPendingIntent(identifier7, broadcast3);
        if (h.containsKey(Integer.valueOf(iA)) && (k0Var = h.get(Integer.valueOf(iA))) != null) {
            k0Var.f4916a = downloadUtils.c;
            h.put(Integer.valueOf(iA), k0Var);
        }
        Notification notification = downloadUtils.c;
        notification.contentView = downloadUtils.b;
        downloadUtils.f4863a.notify(iA, notification);
    }

    public class a implements com.meishu.sdk.core.download.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4866a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String[] f;
        public final /* synthetic */ String[] g;
        public final /* synthetic */ String[] h;

        /* JADX INFO: renamed from: com.meishu.sdk.core.utils.DownloadUtils$a$a, reason: collision with other inner class name */
        public class C0816a extends com.meishu.sdk.core.safe.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DownloadStatusListener f4867a;

            public C0816a(a aVar, DownloadStatusListener downloadStatusListener) {
                this.f4867a = downloadStatusListener;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                this.f4867a.onDownloadStart();
            }
        }

        public class b extends com.meishu.sdk.core.safe.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.meishu.sdk.core.download.b f4868a;

            public b(com.meishu.sdk.core.download.b bVar) {
                this.f4868a = bVar;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                try {
                    com.meishu.sdk.core.download.b bVar = this.f4868a;
                    int i = (int) (((bVar.f * 1.0f) / bVar.e) * 100.0f);
                    if (i > 100) {
                        i = 100;
                    }
                    DownloadStatusListener downloadStatusListener = DownloadUtils.j.get(a.this.f4866a);
                    if (downloadStatusListener != null) {
                        downloadStatusListener.onDownloadProgress(i);
                    }
                    a aVar = a.this;
                    DownloadUtils downloadUtils = DownloadUtils.this;
                    if (downloadUtils.f4863a == null || downloadUtils.b == null) {
                        return;
                    }
                    int iA = z0.a(aVar.c, "ms_notification_progressText");
                    int iA2 = z0.a(a.this.c, "ms_notification_pregressBar");
                    if (iA == 0) {
                        iA = R.id.ms_notification_progressText;
                    }
                    if (iA2 == 0) {
                        iA2 = R.id.ms_notification_pregressBar;
                    }
                    DownloadUtils.this.b.setTextViewText(iA, i + "%");
                    DownloadUtils.this.b.setProgressBar(iA2, 100, i, false);
                    int iA3 = DownloadUtils.a(this.f4868a.f4783a);
                    if (DownloadUtils.h.containsKey(Integer.valueOf(iA3))) {
                        DownloadUtils.this.f4863a.notify(iA3, DownloadUtils.h.get(Integer.valueOf(iA3)).f4916a);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public class c extends com.meishu.sdk.core.safe.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DownloadStatusListener f4869a;
            public final /* synthetic */ String b;

            public c(a aVar, DownloadStatusListener downloadStatusListener, String str) {
                this.f4869a = downloadStatusListener;
                this.b = str;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                this.f4869a.onDownloadError(this.b);
            }
        }

        public class d extends com.meishu.sdk.core.safe.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DownloadStatusListener f4870a;

            public d(a aVar, DownloadStatusListener downloadStatusListener) {
                this.f4870a = downloadStatusListener;
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                this.f4870a.onDownloadFinish();
            }
        }

        public a(String str, String[] strArr, Context context, String str2, String str3, String[] strArr2, String[] strArr3, String[] strArr4) {
            this.f4866a = str;
            this.b = strArr;
            this.c = context;
            this.d = str2;
            this.e = str3;
            this.f = strArr2;
            this.g = strArr3;
            this.h = strArr4;
        }

        @Override // com.meishu.sdk.core.download.h
        public void a(File file, com.meishu.sdk.core.download.b bVar) {
            try {
                DownloadStatusListener downloadStatusListenerRemove = DownloadUtils.j.remove(this.f4866a);
                if (downloadStatusListenerRemove != null) {
                    DownloadUtils.this.d.post(new d(this, downloadStatusListenerRemove));
                }
                DownloadUtils downloadUtils = DownloadUtils.this;
                Context context = this.c;
                downloadUtils.d.post(new n(downloadUtils, bVar.f4783a, context));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.meishu.sdk.core.download.h
        public void b(com.meishu.sdk.core.download.b bVar) {
            try {
                DownloadStatusListener downloadStatusListener = DownloadUtils.j.get(this.f4866a);
                if (downloadStatusListener != null) {
                    DownloadUtils.this.d.post(new C0816a(this, downloadStatusListener));
                }
                if (DownloadUtils.h == null) {
                    DownloadUtils.h = new HashMap();
                }
                if (DownloadUtils.h.containsKey(Integer.valueOf(DownloadUtils.a(this.f4866a)))) {
                    return;
                }
                try {
                    if (this.b != null) {
                        LogUtil.d("DownloadUtils", "Report send dn_start");
                        for (String str : this.b) {
                            if (!TextUtils.isEmpty(str)) {
                                z.a(this.c, str, new i());
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                k0 k0Var = new k0();
                k0Var.b = this.d;
                k0Var.c = this.e;
                k0Var.d = this.b;
                k0Var.e = this.f;
                k0Var.f = this.g;
                k0Var.g = this.h;
                DownloadUtils.h.put(Integer.valueOf(DownloadUtils.a(this.f4866a)), k0Var);
                DownloadUtils.a(DownloadUtils.this, this.f4866a, this.c, this.d, this.e);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.meishu.sdk.core.download.h
        public void a(com.meishu.sdk.core.download.b bVar) {
            DownloadUtils.this.d.post(new b(bVar));
        }

        @Override // com.meishu.sdk.core.download.h
        public void a(com.meishu.sdk.core.download.b bVar, String str) {
            try {
                LogUtil.e("DownloadUtils", "err=" + str);
                DownloadStatusListener downloadStatusListenerRemove = DownloadUtils.j.remove(this.f4866a);
                if (downloadStatusListenerRemove != null) {
                    DownloadUtils.this.d.post(new c(this, downloadStatusListenerRemove, str));
                }
                com.meishu.sdk.core.download.a.C0793a.f4782a.a(this.f4866a);
                NotificationManager notificationManager = DownloadUtils.this.f4863a;
                if (notificationManager != null) {
                    notificationManager.cancel(DownloadUtils.a(this.f4866a));
                }
                DownloadUtils.h.remove(Integer.valueOf(DownloadUtils.a(this.f4866a)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(k0 k0Var) {
        String str = k0Var.c;
        f0 f0Var = new f0(k0Var.b, str, k0Var.d, k0Var.e, k0Var.f, k0Var.g);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i.put(str, f0Var);
    }

    public void a(Context context, String str, String str2, String str3, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.meishu.sdk.core.download.a aVar = com.meishu.sdk.core.download.a.C0793a.f4782a;
        com.meishu.sdk.core.download.d dVar = aVar.f4781a.get(str);
        if (dVar == null) {
            dVar = new com.meishu.sdk.core.download.d(str, str2, "", str);
            aVar.f4781a.put(str, dVar);
        }
        com.meishu.sdk.core.download.d dVar2 = dVar;
        dVar2.e.put(dVar2.b, new a(str, strArr, context, str2, str3, strArr2, strArr3, strArr4));
        dVar2.a();
    }

    public static void a(Context context) {
        if (AdSdk.adConfig() == null || !AdSdk.adConfig().enableInstallBroadcast()) {
            return;
        }
        DownloadUtils downloadUtils = c.f4872a;
        if (downloadUtils.g) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            context.registerReceiver(new InstallSuccessReceiver(), intentFilter);
            downloadUtils.g = true;
        } catch (Exception e) {
            LogUtil.w("DownloadUtils", "Failed registerReceiver InstallSuccessReceiver");
            e.printStackTrace();
        }
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return Math.abs(str.hashCode() + 199);
    }

    public static void a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String strReplace = str.substring(str.lastIndexOf("/")).replace("/", "");
            String str2 = com.meishu.sdk.core.download.a.C0793a.f4782a.c;
            try {
                strReplace = l1.a(MessageDigest.getInstance("MD5").digest(str.getBytes())).toLowerCase() + ".apk";
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            a(context, new File(str2, strReplace), h.get(Integer.valueOf(a(str))));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, File file, k0 k0Var) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (k0Var != null) {
                        try {
                            String[] strArr = k0Var.f;
                            if (strArr != null) {
                                LogUtil.d("DownloadUtils", "Report send dn_inst_start");
                                for (String str : strArr) {
                                    if (!TextUtils.isEmpty(str)) {
                                        z.a(context, str, new i());
                                    }
                                }
                            }
                            a(k0Var);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    DownloadStatusListener downloadStatusListener = k.get(k0Var != null ? k0Var.c : null);
                    if (downloadStatusListener != null) {
                        new Handler(Looper.getMainLooper()).post(new b(downloadStatusListener));
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
                        intent.addFlags(268435456);
                        intent.addFlags(1);
                        if (TextUtils.isEmpty(r.f4937a)) {
                            r.a(context, AdSdk.adConfig() != null ? AdSdk.adConfig().getAuthority() : null);
                        }
                        intent.setDataAndType(FileProvider.getUriForFile(context, r.f4937a, file), AdBaseConstants.MIME_APK);
                        context.startActivity(intent);
                        return;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        LogUtil.e("DownloadUtils", "file not exists");
    }
}
