package com.meishu.sdk.meishu_ad.view.player.media.datasouce.download;

import com.huawei.openalliance.ad.constant.x;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.z;
import java.io.InputStream;
import java.io.RandomAccessFile;
import okhttp3.Request;

/* JADX INFO: compiled from: MediaDataSourceDownloader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c implements com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.a {
    public static final /* synthetic */ int k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5141a;
    public final Object b;
    public final g c;
    public final b e;
    public b f;
    public volatile long g;
    public volatile boolean h;
    public f j;
    public final Object d = new Object();
    public volatile boolean i = false;

    /* JADX INFO: compiled from: MediaDataSourceDownloader.java */
    public class a implements b.a {
        public a() {
        }

        public void a() {
            c.this.close();
            f fVar = c.this.j;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: MediaDataSourceDownloader.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputStream f5143a = null;
        public final long b;

        /* JADX INFO: compiled from: MediaDataSourceDownloader.java */
        public interface a {
        }

        public b(String str, RandomAccessFile randomAccessFile, long j, Object obj, a aVar) {
            this.b = j;
            try {
                Request.Builder builderUrl = new Request.Builder().url(str);
                builderUrl.addHeader("Range", "bytes=" + j + x.A);
                z.a().newCall(builderUrl.build()).enqueue(new d(this, aVar, j, str, obj, randomAccessFile));
            } catch (Throwable th) {
                th.printStackTrace();
                if (aVar != null) {
                    ((a) aVar).a();
                }
            }
        }

        public void a() {
            try {
                InputStream inputStream = this.f5143a;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public c(String str, RandomAccessFile randomAccessFile, long j, Object obj, g gVar, f fVar) {
        this.f5141a = str;
        this.b = obj;
        this.c = gVar;
        this.j = fVar;
        this.e = new b(str, randomAccessFile, j, obj, new a());
    }

    @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.a
    public void a(String str, long j, int i, RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null && this.c.a(str, j, this.g, i) && this.g > 0 && this.h && !this.i && !a(randomAccessFile)) {
            synchronized (this.d) {
                this.i = true;
                if (this.f == null) {
                    LogUtil.d("c", "start download last meta data. position:" + j + " threadId:" + Thread.currentThread().getId());
                    this.f = new b(this.f5141a, randomAccessFile, j, this.b, null);
                }
            }
        }
    }

    @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.a
    public void close() {
        b bVar = this.e;
        if (bVar != null) {
            bVar.a();
        }
        b bVar2 = this.f;
        if (bVar2 != null) {
            bVar2.a();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.a
    public boolean a(RandomAccessFile randomAccessFile, long j) {
        try {
            if (a(randomAccessFile)) {
                return true;
            }
            b bVar = this.f;
            return bVar != null && j >= bVar.b && j < randomAccessFile.length();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean a(RandomAccessFile randomAccessFile) {
        try {
            return this.g > 0 && randomAccessFile != null && randomAccessFile.length() == this.g;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
