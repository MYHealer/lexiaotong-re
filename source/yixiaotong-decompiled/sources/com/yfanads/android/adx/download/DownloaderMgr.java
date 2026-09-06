package com.yfanads.android.adx.download;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.byazt.tk.AdBaseConstants;
import com.huawei.openalliance.ad.constant.ba;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.core.load.SPManager;
import com.yfanads.android.adx.service.d;
import com.yfanads.android.adx.thirdpart.filedownload.BaseDownloadTask;
import com.yfanads.android.adx.thirdpart.filedownload.FileDownloadSampleListener;
import com.yfanads.android.adx.thirdpart.filedownload.FileDownloader;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.utils.YFUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class DownloaderMgr implements com.yfanads.android.adx.download.infs.a {
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NotificationManager f9594a;

    public static class MyBroadcastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("url");
            ConcurrentHashMap concurrentHashMap = DownloaderMgr.b;
            com.yfanads.android.adx.download.a aVar = (com.yfanads.android.adx.download.a) concurrentHashMap.get(stringExtra);
            if (aVar != null && TextUtils.equals("downloading", aVar.g)) {
                com.yfanads.android.adx.utils.a.a("通知栏暂停");
                DownloaderMgr downloaderMgr = (DownloaderMgr) d.e;
                downloaderMgr.getClass();
                com.yfanads.android.adx.download.a aVar2 = (com.yfanads.android.adx.download.a) concurrentHashMap.get(stringExtra);
                if (aVar2 != null) {
                    aVar2.g = "pause";
                    downloaderMgr.a(aVar2.f9597a, stringExtra);
                    aVar2.d.a(false);
                    return;
                }
                return;
            }
            if (aVar != null && TextUtils.equals(ba.ah, aVar.g)) {
                com.yfanads.android.adx.utils.a.a("通知栏安装");
                ((DownloaderMgr) d.e).a(stringExtra);
                return;
            }
            com.yfanads.android.adx.utils.a.a("通知栏继续下载");
            DownloaderMgr downloaderMgr2 = (DownloaderMgr) d.e;
            downloaderMgr2.getClass();
            com.yfanads.android.adx.download.a aVar3 = (com.yfanads.android.adx.download.a) concurrentHashMap.get(stringExtra);
            if (aVar3 != null) {
                downloaderMgr2.a(stringExtra, null, null, 0L, aVar3.d);
                aVar3.d.a(true);
            }
        }
    }

    public class a extends FileDownloadSampleListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9595a;

        public a(String str) {
            this.f9595a = str;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadSampleListener, com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
        public final void completed(BaseDownloadTask baseDownloadTask) {
            super.completed(baseDownloadTask);
            DownloaderMgr downloaderMgr = DownloaderMgr.this;
            String str = this.f9595a;
            downloaderMgr.getClass();
            com.yfanads.android.adx.download.a aVar = (com.yfanads.android.adx.download.a) DownloaderMgr.b.get(str);
            if (aVar != null) {
                aVar.g = ba.ah;
                aVar.d.a();
                RemoteViews remoteViews = aVar.e;
                if (remoteViews == null) {
                    com.yfanads.android.adx.utils.a.b("onCompleted remoteViews is null, return.");
                    return;
                }
                remoteViews.setProgressBar(R.id.pb, 100, 100, false);
                remoteViews.setViewVisibility(R.id.tv_install, 0);
                remoteViews.setTextViewText(R.id.tv_message, "");
                remoteViews.setViewVisibility(R.id.im_download, 8);
                downloaderMgr.f9594a.notify(aVar.f9597a, aVar.f.build());
            }
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
        public final void connected(BaseDownloadTask baseDownloadTask, String str, boolean z, int i, int i2) {
            super.connected(baseDownloadTask, str, z, i, i2);
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadSampleListener, com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
        public final void error(BaseDownloadTask baseDownloadTask, Throwable th) {
            super.error(baseDownloadTask, th);
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadSampleListener, com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
        public final void paused(BaseDownloadTask baseDownloadTask, int i, int i2) {
            super.paused(baseDownloadTask, i, i2);
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadSampleListener, com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
        public final void pending(BaseDownloadTask baseDownloadTask, int i, int i2) {
            super.pending(baseDownloadTask, i, i2);
            com.yfanads.android.adx.download.a aVar = (com.yfanads.android.adx.download.a) DownloaderMgr.b.get(this.f9595a);
            if (aVar == null) {
                return;
            }
            long j = aVar.l;
            if (j > 0) {
                SPManager.saveLong(d.b, "downloadSize", j + SPManager.getLong(d.b, "downloadSize"));
            }
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadSampleListener, com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
        public final void progress(BaseDownloadTask baseDownloadTask, int i, int i2) {
            super.progress(baseDownloadTask, i, i2);
            DownloaderMgr downloaderMgr = DownloaderMgr.this;
            String str = this.f9595a;
            downloaderMgr.getClass();
            com.yfanads.android.adx.download.a aVar = (com.yfanads.android.adx.download.a) DownloaderMgr.b.get(str);
            if (aVar != null) {
                com.yfanads.android.adx.download.dialog.a aVar2 = aVar.d;
                if (aVar2 != null) {
                    aVar2.a(i, i2);
                }
                aVar.g = "downloading";
                int i3 = aVar.k;
                if (i3 > 0) {
                    aVar.k = i3 - 1;
                    return;
                }
                RemoteViews remoteViews = aVar.e;
                if (remoteViews == null) {
                    com.yfanads.android.adx.utils.a.b("remoteViews is null, return.");
                    return;
                }
                remoteViews.setProgressBar(R.id.pb, i2, i, false);
                aVar.k = 60;
                downloaderMgr.f9594a.notify(aVar.f9597a, aVar.f.build());
            }
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadSampleListener, com.yfanads.android.adx.thirdpart.filedownload.FileDownloadListener
        public final void warn(BaseDownloadTask baseDownloadTask) {
            super.warn(baseDownloadTask);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DownloaderMgr f9596a = new DownloaderMgr();
    }

    public final com.yfanads.android.adx.download.a a(String str, String str2, String str3, long j, com.yfanads.android.adx.download.dialog.a aVar) {
        File[] fileArrListFiles;
        com.yfanads.android.adx.utils.a.a("start download");
        if (SPManager.getLong(d.b, "downloadSize") > 629145600) {
            StringBuilder sbAppend = new StringBuilder().append(FileDownloadUtils.getDefaultSaveRootPath());
            ThreadPoolExecutor threadPoolExecutor = com.yfanads.android.adx.utils.b.f9622a;
            File file = new File(sbAppend.append("/com/yfanads/ads/channel/adx").toString());
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                try {
                    for (File file2 : fileArrListFiles) {
                        if (file2 != null && file2.exists()) {
                            file2.delete();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        ConcurrentHashMap concurrentHashMap = b;
        com.yfanads.android.adx.download.a aVar2 = (com.yfanads.android.adx.download.a) concurrentHashMap.get(str);
        if (aVar2 == null) {
            String strGenerateFileName = FileDownloadUtils.generateFileName(str);
            if (!TextUtils.isEmpty(strGenerateFileName) && !strGenerateFileName.endsWith(".apk")) {
                strGenerateFileName = strGenerateFileName.concat(".apk");
            }
            String defaultSaveRootPath = FileDownloadUtils.getDefaultSaveRootPath();
            StringBuilder sbAppend2 = new StringBuilder().append(defaultSaveRootPath);
            ThreadPoolExecutor threadPoolExecutor2 = com.yfanads.android.adx.utils.b.f9622a;
            File file3 = new File(sbAppend2.append("/com/yfanads/ads/channel/adx").toString());
            if (file3.exists() || file3.mkdirs()) {
                defaultSaveRootPath = defaultSaveRootPath + "/com/yfanads/ads/channel/adx";
            }
            aVar2 = new com.yfanads.android.adx.download.a(FileDownloadUtils.generateFilePath(defaultSaveRootPath, strGenerateFileName), str);
            aVar2.h = str3;
            aVar2.l = j;
            aVar2.i = str2;
            concurrentHashMap.put(str, aVar2);
        }
        aVar2.d = aVar;
        try {
            com.yfanads.android.adx.download.a aVar3 = (com.yfanads.android.adx.download.a) concurrentHashMap.get(str);
            if (aVar3 != null) {
                String str4 = aVar3.h;
                String str5 = aVar3.i;
                Context context = d.b;
                this.f9594a = (NotificationManager) context.getSystemService(NotificationManager.class);
                NotificationCompat.Builder builder = aVar3.f;
                if (builder == null) {
                    builder = new NotificationCompat.Builder(context, "notification_channel");
                }
                RemoteViews remoteViews = aVar3.e;
                if (aVar3.f == null) {
                    remoteViews = new RemoteViews(context.getPackageName(), com.yfanads.android.adx.utils.b.a(context) ? R.layout.item_adx_notification_dark : R.layout.item_adx_notification_light);
                }
                d.e = this;
                Intent intent = new Intent(context, (Class<?>) MyBroadcastReceiver.class);
                intent.putExtra("url", str);
                intent.setAction("download");
                remoteViews.setOnClickPendingIntent(R.id.ll, PendingIntent.getBroadcast(context, 0, intent, 67108864));
                remoteViews.setTextViewText(R.id.tv_name, str4);
                remoteViews.setViewVisibility(R.id.tv_install, 4);
                remoteViews.setViewVisibility(R.id.im_download, 0);
                if (com.yfanads.android.adx.utils.b.a(context)) {
                    remoteViews.setImageViewResource(R.id.im_download, R.mipmap.adx_pause_dark);
                } else {
                    remoteViews.setImageViewResource(R.id.im_download, R.mipmap.adx_download_light);
                }
                Bitmap bitmap = aVar3.j;
                if (bitmap == null) {
                    b(str5, str, remoteViews);
                } else {
                    remoteViews.setImageViewBitmap(R.id.iv, bitmap);
                }
                builder.setChannelId(str);
                this.f9594a.createNotificationChannel(new NotificationChannel(str, str4, 3));
                builder.setContent(remoteViews);
                builder.setSmallIcon(R.mipmap.ad_log_yf);
                aVar3.e = remoteViews;
                aVar3.f = builder;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int iStart = FileDownloader.getImpl().create(aVar2.c).setPath(aVar2.b, false).setCallbackProgressTimes(300).setMinIntervalUpdateSpeed(400).setListener(new a(str)).start();
        aVar2.f9597a = iStart;
        com.yfanads.android.adx.utils.a.a("downloadId==>" + iStart);
        return aVar2;
    }

    public final void b(final String str, final String str2, final RemoteViews remoteViews) {
        com.yfanads.android.adx.utils.b.f9622a.submit(new Runnable() { // from class: com.yfanads.android.adx.download.DownloaderMgr$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, str2, remoteViews);
            }
        });
    }

    public static void b(final String str, final RemoteViews remoteViews) {
        YFUtil.switchMainThread("updateRemoteView", new BaseEnsureListener() { // from class: com.yfanads.android.adx.download.DownloaderMgr$$ExternalSyntheticLambda0
            @Override // com.yfanads.android.callback.BaseEnsureListener
            public final void ensure() {
                DownloaderMgr.a(str, remoteViews);
            }
        });
    }

    public final void a(int i, String str) {
        com.yfanads.android.adx.utils.a.a("download pause");
        Context context = d.b;
        com.yfanads.android.adx.download.a aVar = (com.yfanads.android.adx.download.a) b.get(str);
        if (aVar != null && aVar.e != null && aVar.f != null) {
            if (com.yfanads.android.adx.utils.b.a(context)) {
                aVar.e.setImageViewResource(R.id.im_download, R.mipmap.adx_download_dark);
            } else {
                aVar.e.setImageViewResource(R.id.im_download, R.mipmap.adx_download_light);
            }
            this.f9594a.notify(i, aVar.f.build());
        }
        FileDownloader.getImpl().pause(i);
    }

    public final void a(String str) {
        com.yfanads.android.adx.download.a aVar = (com.yfanads.android.adx.download.a) b.get(str);
        if (aVar == null) {
            return;
        }
        Context context = d.b;
        Intent intent = new Intent("android.intent.action.VIEW");
        File file = new File(aVar.b);
        intent.setFlags(1);
        intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".AdxFileProvider", file), AdBaseConstants.MIME_APK);
        intent.addFlags(268435456);
        context.startActivity(intent);
        try {
            Object systemService = context.getSystemService("statusbar");
            systemService.getClass().getMethod("collapsePanels", new Class[0]).invoke(systemService, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(String str, RemoteViews remoteViews) {
        Bitmap bitmap;
        com.yfanads.android.adx.download.a aVar = (com.yfanads.android.adx.download.a) b.get(str);
        if (remoteViews == null || aVar == null || (bitmap = aVar.j) == null) {
            return;
        }
        remoteViews.setImageViewBitmap(R.id.iv, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x0032 A[EXC_TOP_SPLITTER, PHI: r0
  0x0032: PHI (r0v3 java.io.InputStream) = (r0v1 java.io.InputStream), (r0v4 java.io.InputStream) binds: [B:12:0x0030, B:6:0x0027] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public void a(String str, String str2, RemoteViews remoteViews) {
        InputStream inputStream = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                com.yfanads.android.adx.download.a aVar = (com.yfanads.android.adx.download.a) b.get(str2);
                if (aVar != null) {
                    aVar.j = bitmapDecodeStream;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            b(str2, remoteViews);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }
}
