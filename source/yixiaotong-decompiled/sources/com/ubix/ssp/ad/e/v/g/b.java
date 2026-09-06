package com.ubix.ssp.ad.e.v.g;

import android.media.MediaPlayer;
import com.ubix.ssp.ad.e.a0.c;
import com.ubix.ssp.ad.e.a0.k;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.v.e;
import com.ubix.ssp.ad.e.v.f;
import com.ubixnow.ooooo.oOO00O0;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends e implements f {
    private e.a d;
    private MediaPlayer e;
    private int f;
    private boolean g = false;

    class a implements com.ubix.ssp.ad.e.b0.h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8890a;

        a(int i) {
            this.f8890a = i;
        }

        @Override // com.ubix.ssp.ad.e.b0.h.b
        public void a(File file, String str, int i) {
            u.b("onCacheAvailable =" + i);
            b.this.f = i;
            if (this.f8890a > 0) {
                b.this.d.removeMessages(2);
                b.this.d.sendMessageDelayed(b.this.a(com.ubix.ssp.ad.e.a0.a0.a.i(3, oOO00O0.ubix_timeout_msg)), this.f8890a);
            }
            if (100 != i || b.this.g) {
                return;
            }
            b.this.g = true;
            com.ubix.ssp.ad.e.b0.e.c.a(this);
            b.this.d.sendMessage(b.this.a(str, com.ubix.ssp.ad.e.b0.e.c.d(str)));
            try {
                if (b.this.e != null) {
                    b.this.e.reset();
                    b.this.e.release();
                    b.this.e = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.v.g.b$b, reason: collision with other inner class name */
    class RunnableC1103b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8891a;
        final /* synthetic */ e.b b;

        RunnableC1103b(String str, e.b bVar) {
            this.f8891a = str;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.e = new MediaPlayer();
                b.this.e.setDataSource(com.ubix.ssp.ad.e.b0.e.c.d(this.f8891a));
                b.this.e.prepareAsync();
            } catch (Throwable unused) {
                e.b bVar = this.b;
                if (bVar != null) {
                    bVar.a(com.ubix.ssp.ad.e.a0.a0.a.h(5, "资源下载错误"));
                }
            }
        }
    }

    private File e(String str) {
        return new File(k.f(c.e()), str.hashCode() + "");
    }

    @Override // com.ubix.ssp.ad.e.v.f
    public File a(String str) {
        if (c(str)) {
            return e(str);
        }
        return null;
    }

    public void a(String str, int i, e.b bVar) {
        u.b("download timer started :" + i + str);
        try {
            if (com.ubix.ssp.ad.e.b0.e.c == null) {
                com.ubix.ssp.ad.e.b0.e.a(c.e());
            }
            if (com.ubix.ssp.ad.e.b0.e.c.e(str)) {
                if (bVar != null) {
                    bVar.a(this, str, com.ubix.ssp.ad.e.b0.e.c.d(str), true);
                }
                u.b("download timer ahead return :" + i + str);
                return;
            }
            e.a aVar = new e.a(bVar);
            this.d = aVar;
            if (i > 0) {
                aVar.sendMessageDelayed(a(com.ubix.ssp.ad.e.a0.a0.a.i(3, oOO00O0.ubix_timeout_msg)), i);
            }
            if (c(str)) {
                if (bVar != null) {
                    bVar.a(this, str, e(str).getAbsolutePath(), false);
                }
            } else {
                com.ubix.ssp.ad.e.b0.e.c.a(new a(i), str);
                try {
                    com.ubix.ssp.ad.e.b0.e.c.a().execute(new RunnableC1103b(str, bVar));
                } catch (Throwable unused) {
                    if (bVar != null) {
                        bVar.a(com.ubix.ssp.ad.e.a0.a0.a.h(5, "资源下载错误"));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (bVar != null) {
                bVar.a(com.ubix.ssp.ad.e.a0.a0.a.h(5, "资源下载错误"));
            }
        }
    }

    @Override // com.ubix.ssp.ad.e.v.f
    public void a(String str, e.b bVar) {
        a(str, 10000, bVar);
    }

    public boolean c(String str) {
        return e(str).exists();
    }
}
