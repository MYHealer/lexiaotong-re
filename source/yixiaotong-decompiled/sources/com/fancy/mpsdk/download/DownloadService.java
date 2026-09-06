package com.fancy.mpsdk.download;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.fancy._d1;
import com.fancy._d4;
import com.fancy._d5;
import com.fancy._d6;
import com.fancy._ds;
import com.fancy._g2;
import com.fancy._hi;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.R;
import com.fancy.mpsdk.download.beans.RequestInfo;
import com.hihonor.adsdk.base.c;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class DownloadService extends Service {
    public static final int _e;
    public static final int _f;
    public static final HashMap _g;
    public static final HashSet _h;
    public static final HashSet _i;
    public final _b _a = new _b(_e, _f, TimeUnit.MILLISECONDS, new LinkedBlockingDeque());
    public final HashMap<String, _d> _b = new HashMap<>();
    public final HashMap<String, List<_d>> _c = new HashMap<>();
    public final HashMap<String, _d4> _d = new HashMap<>(100);

    public class _a implements _d5 {
        public final /* synthetic */ RequestInfo _a;

        public _a(RequestInfo requestInfo) {
            this._a = requestInfo;
        }

        public final void _a(boolean z, String str, _d4 _d4Var) {
            List<_d> listRemove;
            if (!z) {
                DownloadService downloadService = DownloadService.this;
                RequestInfo requestInfo = this._a;
                RuntimeException runtimeException = new RuntimeException("download metadata fail");
                int i = DownloadService._e;
                downloadService.getClass();
                DownloadService._a(requestInfo, runtimeException);
                return;
            }
            synchronized (DownloadService.this._d) {
                DownloadService.this._d.put(str, _d4Var);
            }
            synchronized (DownloadService.this._c) {
                listRemove = DownloadService.this._c.remove(str);
            }
            if (listRemove != null) {
                for (_d _dVar : listRemove) {
                    _b _bVar = DownloadService.this._a;
                    _bVar.getClass();
                    _ds _dsVar = _dVar._d;
                    int i2 = _dsVar != null ? _dsVar._g : 47;
                    if (i2 == 45 || i2 == 47) {
                        _dsVar._g = 42;
                        Intent intent = new Intent();
                        intent.setAction(_dVar._c._d);
                        intent.putExtra("download_extra", _dVar._d);
                        _dVar._b.sendBroadcast(intent);
                        _bVar.execute(_dVar);
                    }
                }
            }
        }
    }

    public static class _b extends ThreadPoolExecutor {
        public _b(int i, int i2, TimeUnit timeUnit, BlockingQueue blockingQueue) {
            super(i, i2, 0L, timeUnit, blockingQueue);
        }
    }

    public class _c implements Runnable {
        public final RequestInfo _a;
        public final _d5 _b;

        public _c(RequestInfo requestInfo, _a _aVar) {
            this._a = requestInfo;
            this._b = _aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                DownloadService downloadService = DownloadService.this;
                RequestInfo requestInfo = this._a;
                _d4 _d4Var_a = DownloadService._a(downloadService, requestInfo._c, requestInfo._a, requestInfo._b);
                _d5 _d5Var = this._b;
                if (_d5Var != null) {
                    ((_a) _d5Var)._a(true, this._a._c, _d4Var_a);
                }
            } catch (Exception e) {
                _d5 _d5Var2 = this._b;
                if (_d5Var2 != null) {
                    ((_a) _d5Var2)._a(false, this._a._c, null);
                }
                DownloadService downloadService2 = DownloadService.this;
                RequestInfo requestInfo2 = this._a;
                int i = DownloadService._e;
                downloadService2.getClass();
                DownloadService._a(requestInfo2, e);
            }
        }
    }

    static {
        StubApp.interface11(25556);
        int iMax = Math.max(3, Runtime.getRuntime().availableProcessors() / 2);
        _e = iMax;
        _f = iMax * 2;
        _g = new HashMap();
        _h = new HashSet();
        _i = new HashSet();
    }

    public static _d4 _a(DownloadService downloadService, String str, String str2, String str3) throws IOException {
        downloadService.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.connect();
        String string = httpURLConnection.getURL().toString();
        long contentLength = httpURLConnection.getContentLength();
        String str_a = _d6._a(str2, str3);
        httpURLConnection.disconnect();
        return new _d4(string, str_a, contentLength);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        _d _dVar;
        if (intent != null) {
            String action = intent.getAction();
            if (action == null || TextUtils.isEmpty(action) || !action.endsWith(".ptg.action.download.cancel")) {
                synchronized (this) {
                    if (intent.hasExtra("service_intent_extra")) {
                        ArrayList<RequestInfo> parcelableArrayListExtra = null;
                        try {
                            parcelableArrayListExtra = intent.getParcelableArrayListExtra("service_intent_extra");
                            if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                                for (RequestInfo requestInfo : parcelableArrayListExtra) {
                                    try {
                                        _a(requestInfo);
                                    } catch (Exception e) {
                                        _a(requestInfo, e);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            if (parcelableArrayListExtra != null) {
                                for (RequestInfo requestInfo2 : parcelableArrayListExtra) {
                                    if (requestInfo2 != null) {
                                        _a(requestInfo2, e2);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                _d1 _d1Var = (_d1) intent.getSerializableExtra("download_extra");
                if (_d1Var != null && (_dVar = this._b.get(_d1Var._b())) != null) {
                    _dVar._f = true;
                    this._b.remove(_d1Var._b());
                    RequestInfo requestInfo3 = _dVar._i;
                    requestInfo3._d = 11;
                    _a(requestInfo3);
                    if (requestInfo3._e != null) {
                        Message messageObtain = Message.obtain();
                        messageObtain.obj = requestInfo3._c;
                        Bundle bundle = new Bundle();
                        messageObtain.setData(bundle);
                        bundle.putInt("download_progress", 0);
                        bundle.putInt("download_status_extra", 48);
                        try {
                            requestInfo3._e.send(messageObtain);
                        } catch (RemoteException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    public static void _a(DownloadService downloadService, int i, Notification notification) {
        downloadService.getClass();
        NotificationManagerCompat.from(PtgAdSdk.getContext()).notify(i, notification);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 29 || downloadService.checkSelfPermission("android.permission.FOREGROUND_SERVICE") == 0) {
            HashSet hashSet = _i;
            synchronized (hashSet) {
                hashSet.add(Integer.valueOf(i));
            }
            if (i2 >= 29) {
                downloadService.startForeground(i, notification, 1);
            } else {
                downloadService.startForeground(i, notification);
            }
        }
    }

    public static void _a(DownloadService downloadService, int i) {
        downloadService.getClass();
        NotificationManagerCompat.from(PtgAdSdk.getContext()).cancel(i);
        HashSet hashSet = _i;
        synchronized (hashSet) {
            hashSet.remove(Integer.valueOf(i));
            if (hashSet.size() == 0) {
                downloadService.stopForeground(true);
            }
        }
    }

    public class _d implements Runnable {
        public String _a;
        public final Context _b;
        public final _d1 _c;
        public final _ds _d;
        public final _g2 _e;
        public boolean _f;
        public int _g;
        public final Messenger _h;
        public final RequestInfo _i;

        public class _a implements Runnable {
            public int _a = -1;

            public _a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i = this._a;
                _d _dVar = _d.this;
                int i2 = _dVar._g;
                if (i != i2) {
                    _d._a(_dVar, _dVar._c, i2);
                    this._a = _d.this._g;
                }
                Handler handler = com.fancy.adsdk.lib.utils._d._b;
                handler.removeCallbacks(this);
                handler.postDelayed(this, 1000L);
            }
        }

        public class _b implements Runnable {
            public _b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                _d _dVar = _d.this;
                DownloadService._a(DownloadService.this, _dVar.hashCode());
            }
        }

        public _d(Context context, String str, Messenger messenger, RequestInfo requestInfo, _d1 _d1Var, _g2 _g2Var) {
            long j_a;
            this._b = context;
            this._c = _d1Var;
            this._e = _g2Var;
            this._h = messenger;
            this._a = str;
            this._i = requestInfo;
            _ds _dsVar = new _ds();
            this._d = _dsVar;
            _dsVar._b(_d1Var._b());
            _dsVar._a(str);
            if (_d1Var._a() != null) {
                _d1Var._a().getName();
            }
            _dsVar._c(_d1Var._a() == null ? null : _d1Var._a().getAbsolutePath());
            _ds _dsVar_b = _g2Var._b(_d1Var._b());
            long j = 0;
            if (_dsVar_b != null) {
                j_a = _dsVar_b._a();
                long j_e = _dsVar_b._e();
                if (j_a == 0) {
                    if (_d1Var._a() != null && _d1Var._a().exists()) {
                        _d1Var._a().delete();
                    }
                } else if (_d1Var._a() != null && !_d1Var._a().exists()) {
                    _g2Var._a(_d1Var._b());
                    j_a = 0;
                }
                j = j_e;
            } else {
                j_a = 0;
            }
            _dsVar._b(j);
            _dsVar._a(j_a);
        }

        public static void _a(_d _dVar, _d1 _d1Var, int i) {
            int i2;
            String str;
            if (_hi._a(StubApp.getOrigApplicationContext(DownloadService.this.getApplicationContext()))) {
                NotificationManager notificationManager = (NotificationManager) DownloadService.this.getSystemService(NotificationManager.class);
                if (notificationManager.getNotificationChannel("ptg_download_channel") == null) {
                    NotificationChannel notificationChannel = new NotificationChannel("ptg_download_channel", c.g1.hnadsa, 2);
                    notificationChannel.setDescription("下载信息通知");
                    notificationManager.createNotificationChannel(notificationChannel);
                    notificationManager.getNotificationChannel("ptg_download_channel");
                }
                RemoteViews remoteViews = new RemoteViews(PtgAdSdk.getContext().getPackageName(), R.layout.fancy_download_progress);
                remoteViews.setProgressBar(R.id.ptg_progress, 100, i, false);
                if (TextUtils.isEmpty(_dVar._a)) {
                    _dVar._a = "下载管理";
                }
                remoteViews.setTextViewText(R.id.ptg_text_title, _dVar._a);
                if (i != 0) {
                    if (i >= 100) {
                        i2 = R.id.ptgNotifyTextContent;
                        str = "已完成下载";
                    } else {
                        remoteViews.setTextViewText(R.id.ptgNotifyTextContent, "已下载" + i + "%");
                    }
                    Intent intent = new Intent(DownloadService.this.getPackageName() + ".ptg.action.download.cancel");
                    intent.putExtra("download_extra", _d1Var);
                    remoteViews.setOnClickPendingIntent(R.id.ptg_controller_btn, PendingIntent.getService(_dVar._b, 10000, intent, 1140850688));
                    remoteViews.setViewVisibility(R.id.ptg_controller_btn, 0);
                    Notification notificationBuild = new NotificationCompat.Builder(PtgAdSdk.getContext(), "ptg_download_channel").setSmallIcon(R.drawable.fancy_ic_download).setTicker("准备下载...").setShowWhen(false).setCustomContentView(remoteViews).build();
                    notificationBuild.flags = 32;
                    DownloadService._a(DownloadService.this, _dVar.hashCode(), notificationBuild);
                }
                i2 = R.id.ptgNotifyTextContent;
                str = "开始下载";
                remoteViews.setTextViewText(i2, str);
                Intent intent2 = new Intent(DownloadService.this.getPackageName() + ".ptg.action.download.cancel");
                intent2.putExtra("download_extra", _d1Var);
                remoteViews.setOnClickPendingIntent(R.id.ptg_controller_btn, PendingIntent.getService(_dVar._b, 10000, intent2, 1140850688));
                remoteViews.setViewVisibility(R.id.ptg_controller_btn, 0);
                Notification notificationBuild2 = new NotificationCompat.Builder(PtgAdSdk.getContext(), "ptg_download_channel").setSmallIcon(R.drawable.fancy_ic_download).setTicker("准备下载...").setShowWhen(false).setCustomContentView(remoteViews).build();
                notificationBuild2.flags = 32;
                DownloadService._a(DownloadService.this, _dVar.hashCode(), notificationBuild2);
            }
        }

        public final _ds _b() {
            return this._d;
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            _a();
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x057f */
        /* JADX WARN: Bottom block not found for handler: all -> 0x059c */
        /* JADX WARN: Code duplicated, block: B:329:0x05db A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:330:0x05dd A[Catch: IOException -> 0x05d8, TryCatch #44 {IOException -> 0x05d8, blocks: (B:326:0x05d4, B:330:0x05dd, B:332:0x05e2), top: B:477:0x05d4 }] */
        /* JADX WARN: Code duplicated, block: B:332:0x05e2 A[Catch: IOException -> 0x05d8, TRY_LEAVE, TryCatch #44 {IOException -> 0x05d8, blocks: (B:326:0x05d4, B:330:0x05dd, B:332:0x05e2), top: B:477:0x05d4 }] */
        /* JADX WARN: Code duplicated, block: B:337:0x05ee A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:346:0x060f A[Catch: all -> 0x0675, TRY_ENTER, TryCatch #34 {, blocks: (B:338:0x05f0, B:339:0x05f4, B:342:0x0604, B:346:0x060f, B:347:0x0613, B:349:0x0619, B:351:0x0625, B:356:0x0659, B:357:0x065a, B:359:0x0666, B:360:0x0673, B:340:0x05f5, B:341:0x0603), top: B:468:0x05f0, inners: #20 }] */
        /* JADX WARN: Code duplicated, block: B:349:0x0619 A[Catch: all -> 0x0675, TryCatch #34 {, blocks: (B:338:0x05f0, B:339:0x05f4, B:342:0x0604, B:346:0x060f, B:347:0x0613, B:349:0x0619, B:351:0x0625, B:356:0x0659, B:357:0x065a, B:359:0x0666, B:360:0x0673, B:340:0x05f5, B:341:0x0603), top: B:468:0x05f0, inners: #20 }] */
        /* JADX WARN: Code duplicated, block: B:359:0x0666 A[Catch: all -> 0x0675, TryCatch #34 {, blocks: (B:338:0x05f0, B:339:0x05f4, B:342:0x0604, B:346:0x060f, B:347:0x0613, B:349:0x0619, B:351:0x0625, B:356:0x0659, B:357:0x065a, B:359:0x0666, B:360:0x0673, B:340:0x05f5, B:341:0x0603), top: B:468:0x05f0, inners: #20 }] */
        /* JADX WARN: Code duplicated, block: B:377:0x06a5 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:378:0x06a7 A[Catch: IOException -> 0x06a2, TryCatch #26 {IOException -> 0x06a2, blocks: (B:374:0x069e, B:378:0x06a7, B:380:0x06ac), top: B:457:0x069e }] */
        /* JADX WARN: Code duplicated, block: B:380:0x06ac A[Catch: IOException -> 0x06a2, TRY_LEAVE, TryCatch #26 {IOException -> 0x06a2, blocks: (B:374:0x069e, B:378:0x06a7, B:380:0x06ac), top: B:457:0x069e }] */
        /* JADX WARN: Code duplicated, block: B:385:0x06b8 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:394:0x06d9 A[Catch: all -> 0x073f, TRY_ENTER, TryCatch #13 {, blocks: (B:386:0x06ba, B:387:0x06be, B:390:0x06ce, B:394:0x06d9, B:395:0x06dd, B:397:0x06e3, B:399:0x06ef, B:404:0x0723, B:405:0x0724, B:407:0x0730, B:408:0x073d, B:388:0x06bf, B:389:0x06cd), top: B:438:0x06ba, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:397:0x06e3 A[Catch: all -> 0x073f, TryCatch #13 {, blocks: (B:386:0x06ba, B:387:0x06be, B:390:0x06ce, B:394:0x06d9, B:395:0x06dd, B:397:0x06e3, B:399:0x06ef, B:404:0x0723, B:405:0x0724, B:407:0x0730, B:408:0x073d, B:388:0x06bf, B:389:0x06cd), top: B:438:0x06ba, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:407:0x0730 A[Catch: all -> 0x073f, TryCatch #13 {, blocks: (B:386:0x06ba, B:387:0x06be, B:390:0x06ce, B:394:0x06d9, B:395:0x06dd, B:397:0x06e3, B:399:0x06ef, B:404:0x0723, B:405:0x0724, B:407:0x0730, B:408:0x073d, B:388:0x06bf, B:389:0x06cd), top: B:438:0x06ba, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:419:0x06bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:438:0x06ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:447:0x05f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:451:0x06d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:457:0x069e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:468:0x05f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:477:0x05d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:481:0x060a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:510:0x0625 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:512:0x0613 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:515:0x06ef A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:517:0x06dd A[SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v18, types: [java.io.RandomAccessFile] */
        /* JADX WARN: Type inference failed for: r3v19 */
        /* JADX WARN: Type inference failed for: r3v20 */
        /* JADX WARN: Type inference failed for: r3v40 */
        /* JADX WARN: Type inference failed for: r3v42 */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v7, types: [java.io.RandomAccessFile] */
        /* JADX WARN: Type inference failed for: r3v83 */
        /* JADX WARN: Type inference failed for: r3v86 */
        /* JADX WARN: Type inference failed for: r3v87 */
        /* JADX WARN: Type inference failed for: r3v88 */
        /* JADX WARN: Type inference failed for: r3v89 */
        /* JADX WARN: Type inference failed for: r3v90 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v16 */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v63 */
        /* JADX WARN: Type inference failed for: r4v65 */
        /* JADX WARN: Type inference failed for: r4v9 */
        /* JADX WARN: Type inference failed for: r5v15 */
        /* JADX WARN: Type inference failed for: r5v16, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r5v32 */
        /* JADX WARN: Type inference failed for: r5v7, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r5v78 */
        /* JADX WARN: Type inference failed for: r5v79 */
        /* JADX WARN: Type inference failed for: r5v80 */
        /* JADX WARN: Type inference failed for: r5v81 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v22 */
        /* JADX WARN: Type inference failed for: r7v24 */
        /* JADX WARN: Type inference failed for: r7v25 */
        /* JADX WARN: Type inference failed for: r7v3, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v66 */
        /* JADX WARN: Type inference failed for: r7v67 */
        /* JADX WARN: Type inference failed for: r7v68 */
        /* JADX WARN: Type inference failed for: r7v69 */
        /* JADX WARN: Type inference failed for: r7v7, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r7v70 */
        /* JADX WARN: Type inference failed for: r7v71 */
        /* JADX WARN: Type inference failed for: r7v72 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void _a() throws Throwable {
            _a _aVar;
            File file;
            Throwable th;
            File file2;
            Exception exc;
            Exception exc2;
            File file3;
            File file4;
            Exception exc3;
            ?? r7;
            Exception exc4;
            File file5;
            ?? r4;
            ?? r3;
            File file6;
            Exception exc5;
            Throwable th2;
            File file7;
            ?? r8;
            ?? r5;
            Exception exc6;
            ?? r6;
            List<_d> list;
            _ds _dsVar_b;
            ?? r9;
            ?? r10;
            ?? r11;
            ?? r12;
            ?? r13;
            List<_d> list2;
            _ds _dsVar_b2;
            _d4 _d4Var;
            Exception exc7;
            Exception exc8;
            RandomAccessFile randomAccessFile;
            Throwable th3;
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            InputStream inputStream2;
            Exception exc9;
            HttpURLConnection httpURLConnection2;
            List<_d> list3;
            List<_d> list4;
            List<_d> list5;
            this._d._a(43);
            Exception exc10 = null;
            exc = null;
            Exception exc11 = null;
            ?? r14 = 0;
            Exception exc12 = null;
            _a(this._d, null);
            if (_hi._a(StubApp.getOrigApplicationContext(DownloadService.this.getApplicationContext()))) {
                _aVar = new _a();
                Handler handler = com.fancy.adsdk.lib.utils._d._b;
                handler.removeCallbacks(_aVar);
                handler.postDelayed(_aVar, 1000L);
            } else {
                _aVar = null;
            }
            try {
                try {
                    synchronized (DownloadService.this._d) {
                        try {
                            _d4Var = (_d4) DownloadService.this._d.get(this._c._c());
                        } catch (Throwable th4) {
                            th = th4;
                            file2 = null;
                            while (true) {
                                try {
                                    break;
                                } catch (Exception e) {
                                    e = e;
                                    exc2 = e;
                                    File file8 = file2;
                                    File file9 = file8;
                                    file3 = file9;
                                    r13 = file8;
                                    r12 = file2;
                                    r11 = file9;
                                    try {
                                        this._d._a(47);
                                        _g2 _g2Var = this._e;
                                        _ds _dsVar = this._d;
                                        try {
                                            _g2Var._a.put(_dsVar._a, _dsVar);
                                            _a(this._d, exc2);
                                            exc2.printStackTrace();
                                            com.fancy.adsdk.lib.utils._d._a(_aVar);
                                            com.fancy.adsdk.lib.utils._d._c(new _b());
                                            if (r13 != 0) {
                                                try {
                                                    r13.close();
                                                    if (r12 != 0) {
                                                        r12.close();
                                                    }
                                                    if (r11 != 0) {
                                                        r11.disconnect();
                                                    }
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                }
                                            } else {
                                                if (r12 != 0) {
                                                    r12.close();
                                                }
                                                if (r11 != 0) {
                                                    r11.disconnect();
                                                }
                                            }
                                            synchronized (DownloadService._h) {
                                                if (file3 != null) {
                                                    synchronized (DownloadService._g) {
                                                        list2 = (List) DownloadService._g.get(file3.getAbsolutePath());
                                                        if (file3.exists()) {
                                                            try {
                                                                file3.deleteOnExit();
                                                            } catch (Throwable unused) {
                                                            }
                                                        }
                                                        if (list2 != null) {
                                                            for (_d _dVar : list2) {
                                                                _dsVar_b2 = _dVar._b();
                                                                if (_dsVar_b2 != null) {
                                                                    _dsVar_b2._a(this._d._a());
                                                                    _dsVar_b2._b(this._d._d());
                                                                    _dsVar_b2._c(this._d._c());
                                                                    _dsVar_b2._b(this._d._e());
                                                                    _dsVar_b2._a(this._d._b());
                                                                    _dVar._a(_dsVar_b2, exc2);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (!TextUtils.isEmpty(this._c._c())) {
                                                    DownloadService._h.remove(this._c._c());
                                                }
                                                return;
                                            }
                                        } catch (Throwable th5) {
                                            th2 = th5;
                                            Exception exc13 = exc2;
                                            r10 = r13;
                                            r14 = r12;
                                            exc5 = exc13;
                                            r9 = r11;
                                            file6 = file3;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        exc4 = exc2;
                                        r4 = r13;
                                        r3 = r12;
                                        file5 = file3;
                                        r7 = r11;
                                        file6 = file5;
                                        exc5 = exc4;
                                        th2 = th;
                                        r14 = r3;
                                        r10 = r4;
                                        r9 = r7;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    exc10 = null;
                                    file = file2;
                                }
                            }
                            throw th;
                        }
                    }
                    if (_d4Var == null) {
                        try {
                            synchronized (DownloadService.this._d) {
                                _d4Var = (_d4) DownloadService.this._d.get(this._c._c());
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            exc3 = null;
                            file4 = null;
                            exc = null;
                            r7 = exc;
                            r3 = exc12;
                            r4 = exc3;
                            file5 = file4;
                            exc4 = exc;
                            file6 = file5;
                            exc5 = exc4;
                            th2 = th;
                            r14 = r3;
                            r10 = r4;
                            r9 = r7;
                        }
                    }
                    try {
                        if (_d4Var == null) {
                            this._d._a(47);
                            _a(this._d, new RuntimeException("request download metadata fail"));
                            com.fancy.adsdk.lib.utils._d._a(_aVar);
                            com.fancy.adsdk.lib.utils._d._c(new _b());
                            synchronized (DownloadService._h) {
                                if (!TextUtils.isEmpty(this._c._c())) {
                                    DownloadService._h.remove(this._c._c());
                                }
                            }
                            return;
                        }
                        String str_b = _d4Var._b();
                        long j_c = _d4Var._c();
                        String str_a = _d4Var._a();
                        File file_a = this._c._a();
                        if (file_a == null) {
                            file_a = _d6._a(this._b, str_a);
                        }
                        if (file_a != null) {
                            _ds _dsVar2 = this._d;
                            file_a.getName();
                            _dsVar2.getClass();
                            this._d._c(file_a.getAbsolutePath());
                        }
                        if (j_c <= 0) {
                            if (file_a != null && file_a.exists()) {
                                file_a.delete();
                            }
                            this._e._a(this._c._b());
                            this._d._a(47);
                            _a(this._d, new RuntimeException("download file length is 0 byte"));
                            com.fancy.adsdk.lib.utils._d._a(_aVar);
                            com.fancy.adsdk.lib.utils._d._c(new _b());
                            synchronized (DownloadService._h) {
                                if (!TextUtils.isEmpty(this._c._c())) {
                                    DownloadService._h.remove(this._c._c());
                                }
                            }
                            return;
                        }
                        this._d._b(j_c);
                        if (file_a != null && file_a.exists() && file_a.length() == j_c) {
                            this._d._a(file_a.length());
                            this._d._b(100);
                            this._d._a(46);
                            _g2 _g2Var2 = this._e;
                            _ds _dsVar3 = this._d;
                            _g2Var2._a.put(_dsVar3._a, _dsVar3);
                            _a(this._d, null);
                            com.fancy.adsdk.lib.utils._d._a(_aVar);
                            com.fancy.adsdk.lib.utils._d._c(new _b());
                            synchronized (DownloadService._h) {
                                if (!TextUtils.isEmpty(this._c._c())) {
                                    DownloadService._h.remove(this._c._c());
                                }
                            }
                            return;
                        }
                        File file10 = new File(file_a.getAbsolutePath() + ".tmp");
                        try {
                            synchronized (DownloadService._h) {
                                try {
                                    if (file10.exists()) {
                                        if (DownloadService._h.contains(this._c._c())) {
                                            synchronized (DownloadService._g) {
                                                List arrayList = (List) DownloadService._g.get(file10.getAbsolutePath());
                                                if (arrayList == null) {
                                                    arrayList = new ArrayList();
                                                    DownloadService._g.put(file10.getAbsolutePath(), arrayList);
                                                }
                                                arrayList.add(this);
                                            }
                                            com.fancy.adsdk.lib.utils._d._a(_aVar);
                                            com.fancy.adsdk.lib.utils._d._c(new _b());
                                            synchronized (DownloadService._h) {
                                                synchronized (DownloadService._g) {
                                                    list5 = (List) DownloadService._g.get(file10.getAbsolutePath());
                                                }
                                                if (file10.exists()) {
                                                    try {
                                                        file10.deleteOnExit();
                                                    } catch (Throwable unused2) {
                                                    }
                                                }
                                                if (list5 != null) {
                                                    for (_d _dVar2 : list5) {
                                                        _ds _dsVar_b3 = _dVar2._b();
                                                        if (_dsVar_b3 != null) {
                                                            _dsVar_b3._a(this._d._a());
                                                            _dsVar_b3._b(this._d._d());
                                                            _dsVar_b3._c(this._d._c());
                                                            _dsVar_b3._b(this._d._e());
                                                            _dsVar_b3._a(this._d._b());
                                                            _dVar2._a(_dsVar_b3, null);
                                                        }
                                                    }
                                                }
                                                if (!TextUtils.isEmpty(this._c._c())) {
                                                    DownloadService._h.remove(this._c._c());
                                                }
                                            }
                                            return;
                                        }
                                        file10.deleteOnExit();
                                    }
                                    if (!TextUtils.isEmpty(this._c._c())) {
                                        DownloadService._h.add(this._c._c());
                                    }
                                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file10, "rwd");
                                    try {
                                        HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str_b).openConnection();
                                        try {
                                            httpURLConnection3.setConnectTimeout(10000);
                                            httpURLConnection3.setRequestProperty("Connection", "Keep-Alive");
                                            httpURLConnection3.setReadTimeout(10000);
                                            httpURLConnection3.setRequestProperty("Range", "bytes=0-");
                                            httpURLConnection3.connect();
                                            inputStream = httpURLConnection3.getInputStream();
                                            float f = j_c;
                                            int i = (int) ((f / 100.0f) + 0.5f);
                                            if (i <= 0) {
                                                i = 1;
                                            } else if (i > 8192) {
                                                i = 8192;
                                            }
                                            try {
                                                try {
                                                    byte[] bArr = new byte[i];
                                                    randomAccessFile2.seek(this._d._a());
                                                    long jUptimeMillis = SystemClock.uptimeMillis();
                                                    while (true) {
                                                        int i2 = inputStream.read(bArr);
                                                        if (i2 == -1) {
                                                            randomAccessFile = randomAccessFile2;
                                                            try {
                                                                file10.renameTo(file_a);
                                                                if (file_a.exists()) {
                                                                    this._d._a(46);
                                                                    _g2 _g2Var3 = this._e;
                                                                    _ds _dsVar4 = this._d;
                                                                    _g2Var3._a.put(_dsVar4._a, _dsVar4);
                                                                    try {
                                                                        _a(this._d, null);
                                                                        com.fancy.adsdk.lib.utils._d._a(_aVar);
                                                                        com.fancy.adsdk.lib.utils._d._c(new _b());
                                                                        try {
                                                                            randomAccessFile.close();
                                                                            inputStream.close();
                                                                            httpURLConnection3.disconnect();
                                                                        } catch (IOException e3) {
                                                                            e3.printStackTrace();
                                                                        }
                                                                        synchronized (DownloadService._h) {
                                                                            synchronized (DownloadService._g) {
                                                                                list3 = (List) DownloadService._g.get(file10.getAbsolutePath());
                                                                            }
                                                                            if (file10.exists()) {
                                                                                try {
                                                                                    file10.deleteOnExit();
                                                                                } catch (Throwable unused3) {
                                                                                }
                                                                            }
                                                                            if (list3 != null) {
                                                                                for (_d _dVar3 : list3) {
                                                                                    _ds _dsVar_b4 = _dVar3._b();
                                                                                    if (_dsVar_b4 != null) {
                                                                                        _dsVar_b4._a(this._d._a());
                                                                                        _dsVar_b4._b(this._d._d());
                                                                                        _dsVar_b4._c(this._d._c());
                                                                                        _dsVar_b4._b(this._d._e());
                                                                                        _dsVar_b4._a(this._d._b());
                                                                                        _dVar3._a(_dsVar_b4, null);
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (!TextUtils.isEmpty(this._c._c())) {
                                                                                DownloadService._h.remove(this._c._c());
                                                                            }
                                                                        }
                                                                        return;
                                                                    } catch (Throwable th9) {
                                                                        th = th9;
                                                                        exc8 = null;
                                                                    }
                                                                } else {
                                                                    exc8 = null;
                                                                    try {
                                                                        throw new RuntimeException("tmp file rename fail");
                                                                    } catch (Throwable th10) {
                                                                        th = th10;
                                                                    }
                                                                }
                                                            } catch (Throwable th11) {
                                                                th = th11;
                                                                exc8 = null;
                                                            }
                                                            th3 = th;
                                                            httpURLConnection = httpURLConnection3;
                                                            th2 = th3;
                                                            exc6 = exc8;
                                                            r5 = inputStream;
                                                            r6 = randomAccessFile;
                                                            r8 = httpURLConnection;
                                                            file7 = file10;
                                                            com.fancy.adsdk.lib.utils._d._a(_aVar);
                                                            com.fancy.adsdk.lib.utils._d._c(new _b());
                                                            if (r6 != 0) {
                                                                r6.close();
                                                                if (r5 != 0) {
                                                                    r5.close();
                                                                }
                                                                if (r8 != 0) {
                                                                    r8.disconnect();
                                                                }
                                                            } else {
                                                                if (r5 != 0) {
                                                                    r5.close();
                                                                }
                                                                if (r8 != 0) {
                                                                    r8.disconnect();
                                                                }
                                                            }
                                                            synchronized (DownloadService._h) {
                                                                if (file7 != null) {
                                                                    synchronized (DownloadService._g) {
                                                                        list = (List) DownloadService._g.get(file7.getAbsolutePath());
                                                                    }
                                                                    if (file7.exists()) {
                                                                        file7.deleteOnExit();
                                                                    }
                                                                    if (list != null) {
                                                                        for (_d _dVar4 : list) {
                                                                            _dsVar_b = _dVar4._b();
                                                                            if (_dsVar_b != null) {
                                                                                _dsVar_b._a(this._d._a());
                                                                                _dsVar_b._b(this._d._d());
                                                                                _dsVar_b._c(this._d._c());
                                                                                _dsVar_b._b(this._d._e());
                                                                                _dsVar_b._a(this._d._b());
                                                                                _dVar4._a(_dsVar_b, exc6);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                if (!TextUtils.isEmpty(this._c._c())) {
                                                                    DownloadService._h.remove(this._c._c());
                                                                }
                                                            }
                                                            throw th2;
                                                        }
                                                        try {
                                                            if (this._f) {
                                                                try {
                                                                    this._d._a(45);
                                                                    this._f = false;
                                                                    _g2 _g2Var4 = this._e;
                                                                    _ds _dsVar5 = this._d;
                                                                    _g2Var4._a.put(_dsVar5._a, _dsVar5);
                                                                    _a(this._d, exc11);
                                                                    httpURLConnection3.disconnect();
                                                                    randomAccessFile2.close();
                                                                    inputStream.close();
                                                                    com.fancy.adsdk.lib.utils._d._a(_aVar);
                                                                    com.fancy.adsdk.lib.utils._d._c(new _b());
                                                                    try {
                                                                        randomAccessFile2.close();
                                                                        inputStream.close();
                                                                        httpURLConnection3.disconnect();
                                                                    } catch (IOException e4) {
                                                                        e4.printStackTrace();
                                                                    }
                                                                    synchronized (DownloadService._h) {
                                                                        synchronized (DownloadService._g) {
                                                                            list4 = (List) DownloadService._g.get(file10.getAbsolutePath());
                                                                        }
                                                                        if (file10.exists()) {
                                                                            try {
                                                                                file10.deleteOnExit();
                                                                            } catch (Throwable unused4) {
                                                                            }
                                                                        }
                                                                        if (list4 != null) {
                                                                            for (_d _dVar5 : list4) {
                                                                                _ds _dsVar_b5 = _dVar5._b();
                                                                                if (_dsVar_b5 != null) {
                                                                                    _dsVar_b5._a(this._d._a());
                                                                                    _dsVar_b5._b(this._d._d());
                                                                                    _dsVar_b5._c(this._d._c());
                                                                                    _dsVar_b5._b(this._d._e());
                                                                                    _dsVar_b5._a(this._d._b());
                                                                                    _dVar5._a(_dsVar_b5, exc11);
                                                                                }
                                                                            }
                                                                        }
                                                                        if (!TextUtils.isEmpty(this._c._c())) {
                                                                            DownloadService._h.remove(this._c._c());
                                                                        }
                                                                    }
                                                                    return;
                                                                } catch (Exception e5) {
                                                                    exc9 = e5;
                                                                    randomAccessFile = randomAccessFile2;
                                                                }
                                                            } else {
                                                                randomAccessFile2.write(bArr, 0, i2);
                                                                _ds _dsVar6 = this._d;
                                                                long j = jUptimeMillis;
                                                                long j2 = i2;
                                                                randomAccessFile = randomAccessFile2;
                                                                try {
                                                                    try {
                                                                        _dsVar6._a(_dsVar6._a() + j2);
                                                                        this._d._a(44);
                                                                        int i_a = (int) (((this._d._a() + j2) / f) * 100.0f);
                                                                        this._g = i_a;
                                                                        if (i_a > 100) {
                                                                            this._g = 100;
                                                                        }
                                                                        this._d._b(this._g);
                                                                        if (SystemClock.uptimeMillis() - j >= 1000) {
                                                                            long jUptimeMillis2 = SystemClock.uptimeMillis();
                                                                            _g2 _g2Var5 = this._e;
                                                                            _ds _dsVar7 = this._d;
                                                                            try {
                                                                                _g2Var5._a.put(_dsVar7._a, _dsVar7);
                                                                                _a(this._d, null);
                                                                                jUptimeMillis = jUptimeMillis2;
                                                                            } catch (Exception e6) {
                                                                                e = e6;
                                                                            }
                                                                        } else {
                                                                            jUptimeMillis = j;
                                                                        }
                                                                        exc11 = null;
                                                                        randomAccessFile2 = randomAccessFile;
                                                                    } catch (Throwable th12) {
                                                                        th = th12;
                                                                        th3 = th;
                                                                        exc8 = null;
                                                                        httpURLConnection = httpURLConnection3;
                                                                        th2 = th3;
                                                                        exc6 = exc8;
                                                                        r5 = inputStream;
                                                                        r6 = randomAccessFile;
                                                                        r8 = httpURLConnection;
                                                                        file7 = file10;
                                                                        com.fancy.adsdk.lib.utils._d._a(_aVar);
                                                                        com.fancy.adsdk.lib.utils._d._c(new _b());
                                                                        if (r6 != 0) {
                                                                            try {
                                                                                r6.close();
                                                                                if (r5 != 0) {
                                                                                    r5.close();
                                                                                }
                                                                                if (r8 != 0) {
                                                                                    r8.disconnect();
                                                                                }
                                                                            } catch (IOException e7) {
                                                                                e7.printStackTrace();
                                                                            }
                                                                        } else {
                                                                            if (r5 != 0) {
                                                                                r5.close();
                                                                            }
                                                                            if (r8 != 0) {
                                                                                r8.disconnect();
                                                                            }
                                                                        }
                                                                        synchronized (DownloadService._h) {
                                                                            if (file7 != null) {
                                                                                synchronized (DownloadService._g) {
                                                                                    list = (List) DownloadService._g.get(file7.getAbsolutePath());
                                                                                    if (file7.exists()) {
                                                                                        try {
                                                                                            file7.deleteOnExit();
                                                                                        } catch (Throwable unused5) {
                                                                                        }
                                                                                    }
                                                                                    if (list != null) {
                                                                                        while (r3.hasNext()) {
                                                                                            _dsVar_b = _dVar4._b();
                                                                                            if (_dsVar_b != null) {
                                                                                                _dsVar_b._a(this._d._a());
                                                                                                _dsVar_b._b(this._d._d());
                                                                                                _dsVar_b._c(this._d._c());
                                                                                                _dsVar_b._b(this._d._e());
                                                                                                _dsVar_b._a(this._d._b());
                                                                                                _dVar4._a(_dsVar_b, exc6);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (!TextUtils.isEmpty(this._c._c())) {
                                                                                DownloadService._h.remove(this._c._c());
                                                                            }
                                                                            throw th2;
                                                                        }
                                                                    }
                                                                } catch (Exception e8) {
                                                                    e = e8;
                                                                }
                                                            }
                                                        } catch (Throwable th13) {
                                                            th = th13;
                                                            randomAccessFile = randomAccessFile2;
                                                        }
                                                        e = e6;
                                                        exc9 = e;
                                                        inputStream2 = inputStream;
                                                        httpURLConnection2 = httpURLConnection3;
                                                        exc2 = exc9;
                                                        r13 = randomAccessFile;
                                                        r12 = inputStream2;
                                                        r11 = httpURLConnection2;
                                                        file3 = file10;
                                                        this._d._a(47);
                                                        _g2 _g2Var6 = this._e;
                                                        _ds _dsVar8 = this._d;
                                                        _g2Var6._a.put(_dsVar8._a, _dsVar8);
                                                        _a(this._d, exc2);
                                                        exc2.printStackTrace();
                                                        com.fancy.adsdk.lib.utils._d._a(_aVar);
                                                        com.fancy.adsdk.lib.utils._d._c(new _b());
                                                        if (r13 != 0) {
                                                            r13.close();
                                                            if (r12 != 0) {
                                                                r12.close();
                                                            }
                                                            if (r11 != 0) {
                                                                r11.disconnect();
                                                            }
                                                        } else {
                                                            if (r12 != 0) {
                                                                r12.close();
                                                            }
                                                            if (r11 != 0) {
                                                                r11.disconnect();
                                                            }
                                                        }
                                                        synchronized (DownloadService._h) {
                                                            if (file3 != null) {
                                                                synchronized (DownloadService._g) {
                                                                    list2 = (List) DownloadService._g.get(file3.getAbsolutePath());
                                                                }
                                                                if (file3.exists()) {
                                                                    file3.deleteOnExit();
                                                                }
                                                                if (list2 != null) {
                                                                    while (r2.hasNext()) {
                                                                        _dsVar_b2 = _dVar._b();
                                                                        if (_dsVar_b2 != null) {
                                                                            _dsVar_b2._a(this._d._a());
                                                                            _dsVar_b2._b(this._d._d());
                                                                            _dsVar_b2._c(this._d._c());
                                                                            _dsVar_b2._b(this._d._e());
                                                                            _dsVar_b2._a(this._d._b());
                                                                            _dVar._a(_dsVar_b2, exc2);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (!TextUtils.isEmpty(this._c._c())) {
                                                                DownloadService._h.remove(this._c._c());
                                                            }
                                                        }
                                                        return;
                                                    }
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                    exc8 = exc11;
                                                    randomAccessFile = randomAccessFile2;
                                                }
                                            } catch (Exception e9) {
                                                e = e9;
                                                randomAccessFile = randomAccessFile2;
                                            }
                                        } catch (Exception e10) {
                                            inputStream2 = null;
                                            randomAccessFile = randomAccessFile2;
                                            exc9 = e10;
                                            httpURLConnection2 = httpURLConnection3;
                                        } catch (Throwable th15) {
                                            exc8 = null;
                                            randomAccessFile = randomAccessFile2;
                                            th3 = th15;
                                            inputStream = null;
                                            httpURLConnection = httpURLConnection3;
                                        }
                                    } catch (Exception e11) {
                                        inputStream2 = null;
                                        randomAccessFile = randomAccessFile2;
                                        exc9 = e11;
                                        httpURLConnection2 = null;
                                    } catch (Throwable th16) {
                                        exc8 = null;
                                        randomAccessFile = randomAccessFile2;
                                        th3 = th16;
                                        httpURLConnection = null;
                                        inputStream = null;
                                    }
                                } catch (Throwable th17) {
                                    th = th17;
                                    exc7 = null;
                                    while (true) {
                                        try {
                                            break;
                                        } catch (Exception e12) {
                                            e = e12;
                                            exc2 = e;
                                            Exception exc14 = exc7;
                                            r11 = exc14;
                                            r13 = exc14;
                                            r12 = exc7;
                                            file3 = file10;
                                            this._d._a(47);
                                            _g2 _g2Var7 = this._e;
                                            _ds _dsVar9 = this._d;
                                            _g2Var7._a.put(_dsVar9._a, _dsVar9);
                                            _a(this._d, exc2);
                                            exc2.printStackTrace();
                                            com.fancy.adsdk.lib.utils._d._a(_aVar);
                                            com.fancy.adsdk.lib.utils._d._c(new _b());
                                            if (r13 != 0) {
                                                r13.close();
                                                if (r12 != 0) {
                                                    r12.close();
                                                }
                                                if (r11 != 0) {
                                                    r11.disconnect();
                                                }
                                            } else {
                                                if (r12 != 0) {
                                                    r12.close();
                                                }
                                                if (r11 != 0) {
                                                    r11.disconnect();
                                                }
                                            }
                                            synchronized (DownloadService._h) {
                                                if (file3 != null) {
                                                    synchronized (DownloadService._g) {
                                                        list2 = (List) DownloadService._g.get(file3.getAbsolutePath());
                                                        if (file3.exists()) {
                                                            file3.deleteOnExit();
                                                        }
                                                        if (list2 != null) {
                                                            while (r2.hasNext()) {
                                                                _dsVar_b2 = _dVar._b();
                                                                if (_dsVar_b2 != null) {
                                                                    _dsVar_b2._a(this._d._a());
                                                                    _dsVar_b2._b(this._d._d());
                                                                    _dsVar_b2._c(this._d._c());
                                                                    _dsVar_b2._b(this._d._e());
                                                                    _dsVar_b2._a(this._d._b());
                                                                    _dVar._a(_dsVar_b2, exc2);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (!TextUtils.isEmpty(this._c._c())) {
                                                    DownloadService._h.remove(this._c._c());
                                                }
                                                return;
                                            }
                                        } catch (Throwable th18) {
                                            th = th18;
                                            th2 = th;
                                            Exception exc15 = exc7;
                                            Exception exc16 = exc15;
                                            r8 = exc16;
                                            r6 = exc15;
                                            exc6 = exc16;
                                            r5 = exc7;
                                            file7 = file10;
                                            com.fancy.adsdk.lib.utils._d._a(_aVar);
                                            com.fancy.adsdk.lib.utils._d._c(new _b());
                                            if (r6 != 0) {
                                                r6.close();
                                                if (r5 != 0) {
                                                    r5.close();
                                                }
                                                if (r8 != 0) {
                                                    r8.disconnect();
                                                }
                                            } else {
                                                if (r5 != 0) {
                                                    r5.close();
                                                }
                                                if (r8 != 0) {
                                                    r8.disconnect();
                                                }
                                            }
                                            synchronized (DownloadService._h) {
                                                if (file7 != null) {
                                                    synchronized (DownloadService._g) {
                                                        list = (List) DownloadService._g.get(file7.getAbsolutePath());
                                                        if (file7.exists()) {
                                                            file7.deleteOnExit();
                                                        }
                                                        if (list != null) {
                                                            while (r3.hasNext()) {
                                                                _dsVar_b = _dVar4._b();
                                                                if (_dsVar_b != null) {
                                                                    _dsVar_b._a(this._d._a());
                                                                    _dsVar_b._b(this._d._d());
                                                                    _dsVar_b._c(this._d._c());
                                                                    _dsVar_b._b(this._d._e());
                                                                    _dsVar_b._a(this._d._b());
                                                                    _dVar4._a(_dsVar_b, exc6);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (!TextUtils.isEmpty(this._c._c())) {
                                                    DownloadService._h.remove(this._c._c());
                                                }
                                                throw th2;
                                            }
                                        }
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception e13) {
                            e = e13;
                            exc7 = null;
                        } catch (Throwable th19) {
                            th = th19;
                            exc7 = null;
                        }
                    } catch (Throwable th20) {
                        th2 = th20;
                        r10 = 0;
                        exc5 = null;
                        r9 = 0;
                        file6 = null;
                        Exception exc17 = exc5;
                        r5 = r14;
                        r6 = r10;
                        exc6 = exc17;
                        r8 = r9;
                        file7 = file6;
                    }
                } catch (Exception e14) {
                    e = e14;
                    file2 = null;
                }
            } catch (Throwable th21) {
                file = null;
                th = th21;
            }
            Exception exc18 = exc10;
            exc = exc18;
            exc12 = exc10;
            exc3 = exc18;
            file4 = file;
            r7 = exc;
            r3 = exc12;
            r4 = exc3;
            file5 = file4;
            exc4 = exc;
            file6 = file5;
            exc5 = exc4;
            th2 = th;
            r14 = r3;
            r10 = r4;
            r9 = r7;
            Exception exc19 = exc5;
            r5 = r14;
            r6 = r10;
            exc6 = exc19;
            r8 = r9;
            file7 = file6;
            com.fancy.adsdk.lib.utils._d._a(_aVar);
            com.fancy.adsdk.lib.utils._d._c(new _b());
            if (r6 != 0) {
                r6.close();
                if (r5 != 0) {
                    r5.close();
                }
                if (r8 != 0) {
                    r8.disconnect();
                }
            } else {
                if (r5 != 0) {
                    r5.close();
                }
                if (r8 != 0) {
                    r8.disconnect();
                }
            }
            synchronized (DownloadService._h) {
                if (file7 != null) {
                    synchronized (DownloadService._g) {
                        list = (List) DownloadService._g.get(file7.getAbsolutePath());
                        if (file7.exists()) {
                            file7.deleteOnExit();
                        }
                        if (list != null) {
                            while (r3.hasNext()) {
                                _dsVar_b = _dVar4._b();
                                if (_dsVar_b != null) {
                                    _dsVar_b._a(this._d._a());
                                    _dsVar_b._b(this._d._d());
                                    _dsVar_b._c(this._d._c());
                                    _dsVar_b._b(this._d._e());
                                    _dsVar_b._a(this._d._b());
                                    _dVar4._a(_dsVar_b, exc6);
                                }
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(this._c._c())) {
                    DownloadService._h.remove(this._c._c());
                }
                throw th2;
            }
        }

        public final void _a(_ds _dsVar, Exception exc) {
            if (this._h != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = _dsVar;
                Bundle bundle = new Bundle();
                messageObtain.setData(bundle);
                if (exc != null) {
                    bundle.putSerializable("error_extra", exc);
                }
                bundle.putInt("download_status_extra", _dsVar._g);
                bundle.putInt("download_progress", _dsVar._f);
                bundle.putLong("download_total_bytes", _dsVar._d);
                bundle.putLong("download_current_bytes", _dsVar._e);
                bundle.putString("download_file_name", _dsVar._b);
                bundle.putString("download_path_extra", _dsVar._c);
                try {
                    this._h.send(messageObtain);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final synchronized void _a(RequestInfo requestInfo) {
        _d4 _d4Var;
        int i;
        _d1 _d1Var = requestInfo._f;
        synchronized (this._d) {
            _d4Var = this._d.get(requestInfo._c);
        }
        if (_d4Var != null) {
            _d1 _d1Var2 = requestInfo._f;
            if (_d1Var2 != null && _d1Var2._c == null && !TextUtils.isEmpty(_d4Var._c)) {
                requestInfo._f._c = new File(_d6._a(StubApp.getOrigApplicationContext(getApplicationContext())), _d4Var._c);
            }
            if (requestInfo._f != null && !TextUtils.isEmpty(_d4Var._c)) {
                requestInfo._f._e = _d4Var._b;
            }
        } else {
            this._a.execute(new _c(requestInfo, new _a(requestInfo)));
        }
        _d _dVar = this._b.get(_d1Var._b());
        _g2 _g2Var = new _g2();
        _ds _dsVar_b = _g2Var._b(_d1Var._b());
        if (_dVar == null) {
            if (_dsVar_b != null && (i = _dsVar_b._g) != 44 && i != 43 && i == 46) {
                File file = _d1Var._c;
                if (file != null && file.exists()) {
                    if (!TextUtils.isEmpty(_d1Var._d)) {
                        Intent intent = new Intent();
                        intent.setAction(_d1Var._d);
                        intent.putExtra("download_extra", _dsVar_b);
                        sendBroadcast(intent);
                    }
                    _a(requestInfo, _d1Var._c.getAbsolutePath());
                    return;
                }
                _g2Var._a.remove(_d1Var._b());
            }
            if (requestInfo._d == 10) {
                _d _dVar2 = new _d(this, requestInfo._a, requestInfo._e, requestInfo, _d1Var, _g2Var);
                this._b.put(_d1Var._b(), _dVar2);
                _dVar = _dVar2;
            }
        } else {
            _ds _dsVar = _dVar._d;
            if ((_dsVar == null || _dsVar._g != 46) && (_dsVar == null || _dsVar._g != 44)) {
                if (_dsVar != null) {
                    if (_dsVar._g == 47) {
                    }
                }
                this._b.remove(_d1Var._b());
                _a(requestInfo);
                return;
            }
            File file2 = _d1Var._c;
            if (file2 != null) {
                if (file2.exists()) {
                    _a(requestInfo, _d1Var._c.getAbsolutePath());
                } else {
                    _dVar._f = true;
                    this._b.remove(_d1Var._b());
                    _a(requestInfo);
                }
                return;
            }
        }
        if (_dVar != null) {
            if (requestInfo._d == 10) {
                synchronized (this._d) {
                    if (this._d.containsKey(requestInfo._c)) {
                        _b _bVar = this._a;
                        _bVar.getClass();
                        _ds _dsVar2 = _dVar._d;
                        int i2 = _dsVar2 != null ? _dsVar2._g : 47;
                        if (i2 == 45 || i2 == 47) {
                            _dsVar2._g = 42;
                            Intent intent2 = new Intent();
                            intent2.setAction(_dVar._c._d);
                            intent2.putExtra("download_extra", _dVar._d);
                            _dVar._b.sendBroadcast(intent2);
                            _bVar.execute(_dVar);
                        }
                    } else {
                        List<_d> arrayList = this._c.get(requestInfo._c);
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            this._c.put(requestInfo._c, arrayList);
                        }
                        arrayList.add(_dVar);
                    }
                }
            } else {
                _dVar._f = true;
            }
        }
    }

    public static void _a(RequestInfo requestInfo, String str) {
        if (requestInfo == null || requestInfo._e == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = requestInfo._c;
        Bundle bundle = new Bundle();
        messageObtain.setData(bundle);
        bundle.putInt("download_progress", 100);
        bundle.putString("download_path_extra", str);
        bundle.putString("download_file_name", requestInfo._f._a);
        bundle.putLong("download_total_bytes", requestInfo._f._e);
        bundle.putInt("download_status_extra", 46);
        try {
            requestInfo._e.send(messageObtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void _a(RequestInfo requestInfo, Exception exc) {
        if (requestInfo == null || requestInfo._e == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = requestInfo._c;
        Bundle bundle = new Bundle();
        messageObtain.setData(bundle);
        bundle.putSerializable("error_extra", exc);
        bundle.putInt("download_progress", 0);
        bundle.putString("download_file_name", requestInfo._f._a);
        bundle.putString("download_path_extra", "");
        bundle.putInt("download_status_extra", 47);
        try {
            requestInfo._e.send(messageObtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
