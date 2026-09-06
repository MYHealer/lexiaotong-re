package com.meishu.sdk.core.download;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.constant.x;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.l1;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: DownloadTask.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends l {
    public static final Handler g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.meishu.sdk.core.download.b f4785a;
    public String b;
    public ThreadPoolExecutor c;
    public final OkHttpClient d = new OkHttpClient.Builder().build();
    public Map<Object, h> e;
    public transient long f;

    /* JADX INFO: compiled from: DownloadTask.java */
    public class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.core.download.b f4786a;
        public final /* synthetic */ File b;

        public a(com.meishu.sdk.core.download.b bVar, File file) {
            this.f4786a = bVar;
            this.b = file;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            for (h hVar : d.this.e.values()) {
                hVar.a(this.f4786a);
                hVar.a(this.b, this.f4786a);
            }
        }
    }

    /* JADX INFO: compiled from: DownloadTask.java */
    public class b extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.core.download.b f4787a;
        public final /* synthetic */ String b;

        public b(com.meishu.sdk.core.download.b bVar, String str) {
            this.f4787a = bVar;
            this.b = str;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            for (h hVar : d.this.e.values()) {
                hVar.a(this.f4787a);
                hVar.a(this.f4787a, this.b);
            }
        }
    }

    public d(String str, String str2, String str3, String str4) {
        this.b = str;
        com.meishu.sdk.core.download.b bVar = new com.meishu.sdk.core.download.b();
        this.f4785a = bVar;
        bVar.f4783a = str;
        this.f4785a.getClass();
        this.f4785a.getClass();
        this.f4785a.b = com.meishu.sdk.core.download.a.b().a();
        if (!TextUtils.isEmpty(str)) {
            this.f4785a.d = str.substring(str.lastIndexOf("/")).replace("/", "");
            this.f4785a.c = this.f4785a.b + "/" + System.currentTimeMillis() + ".apk";
        }
        com.meishu.sdk.core.download.b bVar2 = this.f4785a;
        bVar2.g = 0;
        bVar2.e = -1L;
        this.c = com.meishu.sdk.core.download.a.b().c().a();
        this.e = new HashMap();
    }

    public void a() {
        com.meishu.sdk.core.download.b bVar = this.f4785a;
        int i = bVar.g;
        if (i == 0 || i == 3 || i == 4) {
            bVar.g = 0;
            g.post(new e(this, bVar));
            this.c.execute(this);
        } else if (i == 5) {
            if (bVar.c == null) {
                a(bVar, "filePath is null");
                return;
            }
            com.meishu.sdk.core.download.b bVar2 = this.f4785a;
            File file = new File(bVar2.b, bVar2.d);
            if (file.exists()) {
                long length = file.length();
                com.meishu.sdk.core.download.b bVar3 = this.f4785a;
                if (length == bVar3.e) {
                    a(bVar3, file);
                    return;
                }
            }
            a(this.f4785a, "filepath may be invalid or damaged");
        }
    }

    @Override // com.meishu.sdk.core.safe.l
    public void notifyRunnableCatch(Throwable th) {
        a(this.f4785a, "download runnable error");
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        com.meishu.sdk.core.download.b bVar = this.f4785a;
        long j = bVar.f;
        if (j < 0) {
            a(bVar, "startPosition<0");
            return;
        }
        if (TextUtils.isEmpty(bVar.d)) {
            return;
        }
        try {
            Response responseExecute = this.d.newCall(new Request.Builder().addHeader("Range", "bytes=" + j + x.A).url(this.f4785a.f4783a).get().build()).execute();
            int iCode = responseExecute.code();
            if (iCode == 404 || iCode >= 500) {
                a(this.f4785a, "network error! http response code is 404 or 5xx!");
                return;
            }
            ResponseBody responseBodyBody = responseExecute.body();
            if (responseBodyBody == null) {
                a(this.f4785a, "response body is null");
                return;
            }
            com.meishu.sdk.core.download.b bVar2 = this.f4785a;
            if (bVar2.e == -1) {
                bVar2.e = responseBodyBody.contentLength();
            }
            File file = new File(this.f4785a.b);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = !TextUtils.isEmpty(this.f4785a.c) ? new File(this.f4785a.c) : new File(file, this.f4785a.d);
            com.meishu.sdk.core.download.b bVar3 = this.f4785a;
            long j2 = bVar3.e;
            if (j > j2) {
                a(bVar3, "file has expired");
                return;
            }
            if (j == j2 && j > 0) {
                if (!file2.exists() || j != file2.length()) {
                    a(this.f4785a, "file has expired");
                    return;
                }
                a(this.f4785a, file2);
            }
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                randomAccessFile.seek(j);
                this.f4785a.f = j;
                try {
                    a(responseBodyBody.byteStream(), randomAccessFile, this.f4785a);
                    com.meishu.sdk.core.download.b bVar4 = this.f4785a;
                    int i = bVar4.g;
                    if (i == 3) {
                        bVar4.g = 3;
                        g.post(new f(this, bVar4));
                    } else {
                        if (i != 2) {
                            a(bVar4, "file has expired");
                            return;
                        }
                        long length = file2.length();
                        com.meishu.sdk.core.download.b bVar5 = this.f4785a;
                        if (length == bVar5.e) {
                            a(bVar5, file2);
                        } else {
                            a(bVar5, "file has expired");
                        }
                    }
                } catch (Exception e) {
                    a(this.f4785a, e.toString());
                }
            } catch (Exception e2) {
                a(this.f4785a, e2.toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a(this.f4785a, th.toString());
        }
    }

    public final void a(com.meishu.sdk.core.download.b bVar, File file) {
        File file2;
        if (file.exists()) {
            String str = bVar.d;
            try {
                str = l1.a(MessageDigest.getInstance("MD5").digest(bVar.f4783a.getBytes())).toLowerCase() + ".apk";
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            file2 = new File(bVar.b, str);
            file.renameTo(file2);
        } else {
            file2 = null;
        }
        bVar.g = 5;
        g.post(new a(bVar, file2));
    }

    public final void a(com.meishu.sdk.core.download.b bVar, String str) {
        Log.e("DownloadTask", "postOnError: " + str);
        bVar.g = 4;
        g.post(new b(bVar, str));
    }

    public final void a(InputStream inputStream, RandomAccessFile randomAccessFile, com.meishu.sdk.core.download.b bVar) {
        if (inputStream != null) {
            try {
                bVar.g = 2;
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1 || bVar.g != 2) {
                        break;
                        break;
                    }
                    randomAccessFile.write(bArr, 0, i);
                    long j = i;
                    bVar.f += j;
                    bVar.h += j;
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (jElapsedRealtime - this.f >= 300) {
                        this.f = jElapsedRealtime;
                        g.post(new c(this, bVar));
                    }
                }
            } catch (Exception unused) {
                break;
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    randomAccessFile.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
            try {
                inputStream.close();
                randomAccessFile.close();
                return;
            } catch (Exception unused3) {
                return;
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused4) {
                return;
            }
        }
        randomAccessFile.close();
    }
}
