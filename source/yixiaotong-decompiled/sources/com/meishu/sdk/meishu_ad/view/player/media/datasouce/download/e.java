package com.meishu.sdk.meishu_ad.view.player.media.datasouce.download;

import com.meishu.sdk.core.utils.LogUtil;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MediaDataSourceDownloaderWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e implements b {
    public static final /* synthetic */ int o = 0;
    public RandomAccessFile d;
    public RandomAccessFile e;
    public File f;
    public File g;
    public File h;
    public c k;
    public long l;
    public final String m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5145a = new Object();
    public final Object b = new Object();
    public final Object c = new Object();
    public volatile long j = -2147483648L;
    public final List<SoftReference<f>> n = new ArrayList();
    public final g i = new g();

    /* JADX INFO: compiled from: MediaDataSourceDownloaderWrapper.java */
    public class a implements f {
        public a() {
        }

        @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.f
        public void a(long j) {
            e.this.j = j;
            e eVar = e.this;
            synchronized (eVar.b) {
                Iterator<SoftReference<f>> it = eVar.n.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().get().a(j);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.f
        public void b() {
            e eVar = e.this;
            eVar.getClass();
            try {
                synchronized (eVar.f5145a) {
                    if (!eVar.f.exists()) {
                        if (!eVar.g.renameTo(eVar.f)) {
                            LogUtil.e("e", "rename error");
                        }
                        eVar.a();
                        try {
                            File file = eVar.h;
                            if (file != null && file.exists() && !eVar.h.delete()) {
                                LogUtil.e("e", "delete fileLastMetaTemp error." + eVar.h.getAbsolutePath());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            e eVar2 = e.this;
            synchronized (eVar2.b) {
                Iterator<SoftReference<f>> it = eVar2.n.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().get().b();
                    } catch (Exception unused) {
                    }
                }
            }
            e.this.b();
        }

        @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.f
        public void a(long j, int i) {
            e eVar = e.this;
            synchronized (eVar.b) {
                Iterator<SoftReference<f>> it = eVar.n.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().get().a(j, i);
                    } catch (Exception unused) {
                    }
                }
            }
            long j2 = e.this.l;
            if (j2 <= 0 || j < j2) {
                return;
            }
            int i2 = e.o;
            LogUtil.i("e", com.meishu.sdk.activity.a.a("download limit. maxFileSize:").append(e.this.l).toString());
            e eVar2 = e.this;
            c cVar = eVar2.k;
            if (cVar != null) {
                cVar.j = null;
            }
            synchronized (eVar2.c) {
                e.this.b();
            }
        }

        @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.f
        public void a() {
            e.this.c();
            e.this.b();
        }
    }

    public e(String str, f fVar) {
        this.m = str;
        try {
            b(fVar);
            this.f = com.meishu.sdk.core.bquery.g.a(str, (String) null);
            this.g = com.meishu.sdk.core.bquery.g.a(str, "temp");
            this.h = com.meishu.sdk.core.bquery.g.a(str, "last_meta_temp");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.b
    public void a(f fVar) {
        if (fVar == null) {
            return;
        }
        synchronized (this.b) {
            for (SoftReference<f> softReference : this.n) {
                if (softReference.get() == fVar) {
                    this.n.remove(softReference);
                    try {
                        if (this.n.size() == 1 && (this.n.get(0).get() instanceof h.a)) {
                            this.n.get(0).get().b();
                            this.n.clear();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
        }
    }

    public final void c() {
        synchronized (this.b) {
            Iterator<SoftReference<f>> it = this.n.iterator();
            while (it.hasNext()) {
                try {
                    it.next().get().a();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.a
    public void close() {
        if (this.n.isEmpty()) {
            b();
        } else {
            LogUtil.d("e", "listeners is`not empty");
        }
    }

    public void d() {
        try {
            if (this.f.exists() && this.f.length() > 0) {
                LogUtil.d("e", "file exists");
                return;
            }
            if (this.k != null) {
                LogUtil.e("e", "downloader is`not null");
                return;
            }
            this.d = new RandomAccessFile(this.g, "rw");
            this.e = new RandomAccessFile(this.h, "rw");
            long length = this.g.exists() ? this.g.length() : 0L;
            LogUtil.d("e", "start download");
            this.k = new c(this.m, this.d, length, this.f5145a, this.i, new a());
        } catch (Throwable th) {
            th.printStackTrace();
            c();
            b();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.b
    public b b(f fVar) {
        if (fVar == null) {
            return this;
        }
        if (this.j != -2147483648L) {
            fVar.a(this.j);
        }
        synchronized (this.b) {
            Iterator<SoftReference<f>> it = this.n.iterator();
            while (it.hasNext()) {
                if (it.next().get() == fVar) {
                }
            }
            this.n.add(new SoftReference<>(fVar));
        }
        return this;
    }

    public final void b() {
        c cVar = this.k;
        if (cVar != null) {
            cVar.close();
            this.k = null;
        }
        a();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0045 */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
    
        return;
     */
    @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, long j, int i, RandomAccessFile randomAccessFile) {
        c cVar = this.k;
        if (cVar != null) {
            cVar.a(str, j, i, this.e);
            return;
        }
        if (!this.g.exists() || j < this.g.length()) {
            return;
        }
        this.l = 0L;
        synchronized (this.c) {
            try {
                if (this.k == null) {
                    LogUtil.d("e", "re download");
                    d();
                }
                c cVar2 = this.k;
                if (cVar2 != null) {
                    cVar2.a(str, j, i, this.e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.a
    public boolean a(RandomAccessFile randomAccessFile, long j) {
        c cVar = this.k;
        return cVar != null && cVar.a(randomAccessFile, j);
    }

    @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.a
    public void a(long j) {
        if (j > 0) {
            this.l = Math.max(this.l, j);
        }
    }

    public final void a() {
        RandomAccessFile randomAccessFile = this.d;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.d = null;
        }
        RandomAccessFile randomAccessFile2 = this.e;
        if (randomAccessFile2 != null) {
            try {
                randomAccessFile2.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            this.e = null;
        }
    }
}
