package com.meishu.sdk.meishu_ad.view.player.media.datasouce;

import com.kuaishou.weapon.p0.t;
import com.meishu.sdk.core.bquery.g;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.e;
import com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.f;
import com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.h;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: FileMediaDataSource.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5138a;
    public RandomAccessFile c;
    public RandomAccessFile d;
    public File e;
    public File f;
    public File g;
    public volatile long h;
    public com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.b j;
    public f l;
    public final Object b = new Object();
    public boolean i = false;
    public final String k = String.valueOf(hashCode());

    /* JADX INFO: renamed from: com.meishu.sdk.meishu_ad.view.player.media.datasouce.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FileMediaDataSource.java */
    public class C0833a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f5139a;

        public C0833a(c cVar) {
            this.f5139a = cVar;
        }

        @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.f
        public void a(long j) {
            a.this.h = j;
        }

        @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.f
        public void b() {
            a aVar = a.this;
            aVar.getClass();
            try {
                synchronized (aVar.b) {
                    if (aVar.e.exists() && aVar.e.length() > 0) {
                        RandomAccessFile randomAccessFile = aVar.c;
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        aVar.c = new RandomAccessFile(aVar.e, t.k);
                        RandomAccessFile randomAccessFile2 = aVar.d;
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                            aVar.d = null;
                        }
                        return;
                    }
                    LogUtil.e("a", "changeSource error");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.f
        public void a(long j, int i) {
            c cVar = this.f5139a;
            if (cVar != null) {
                ((com.meishu.sdk.meishu_ad.view.player.a.d) cVar).a(i);
            }
        }

        @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.f
        public void a() {
            a aVar = a.this;
            if (aVar.i) {
                return;
            }
            aVar.i = true;
            c cVar = this.f5139a;
            if (cVar != null) {
                com.meishu.sdk.meishu_ad.view.player.a.d dVar = (com.meishu.sdk.meishu_ad.view.player.a.d) cVar;
                dVar.getClass();
                LogUtil.e("CacheMediaPlayerHelper", "onBufferError:" + com.meishu.sdk.meishu_ad.view.player.a.this.e);
                boolean[] zArr = dVar.b;
                if (zArr[1]) {
                    return;
                }
                zArr[1] = true;
                SdkHandler.runOnMainThread(new com.meishu.sdk.meishu_ad.view.player.b(dVar));
            }
        }
    }

    public a(String str, c cVar) {
        this.h = -2147483648L;
        this.f5138a = str;
        try {
            this.e = g.a(str, (String) null);
            this.f = g.a(str, "temp");
            this.g = g.a(str, "last_meta_temp");
            if (b()) {
                this.c = new RandomAccessFile(this.e, t.k);
                this.h = this.e.length();
                if (cVar != null) {
                    ((com.meishu.sdk.meishu_ad.view.player.a.d) cVar).a(100);
                }
                LogUtil.d("a", "file exist. " + this.h);
                return;
            }
            LogUtil.d("a", "file not exist. url:" + str);
            a();
            this.c = new RandomAccessFile(this.f, t.k);
            this.d = new RandomAccessFile(this.g, t.k);
            a(cVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean b() {
        File file = this.e;
        return file != null && file.exists();
    }

    public final void a(c cVar) {
        com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.b bVarB;
        C0833a c0833a = new C0833a(cVar);
        this.l = c0833a;
        String str = this.f5138a;
        ConcurrentHashMap<String, com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.b> concurrentHashMap = h.f5149a;
        try {
            String strB = g.b(str);
            ConcurrentHashMap<String, com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.b> concurrentHashMap2 = h.f5149a;
            if (concurrentHashMap2.containsKey(strB)) {
                bVarB = concurrentHashMap2.get(strB);
                bVarB.b(c0833a);
            } else {
                bVarB = new e(str, new h.a(strB)).b(c0833a);
                concurrentHashMap2.put(strB, bVarB);
                ((e) bVarB).d();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            bVarB = null;
        }
        this.j = bVarB;
    }

    public final void a() {
        try {
            if (!this.f.exists()) {
                this.f.createNewFile();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (this.g.exists()) {
                return;
            }
            this.g.createNewFile();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
