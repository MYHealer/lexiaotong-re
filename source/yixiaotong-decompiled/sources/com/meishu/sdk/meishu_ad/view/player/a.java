package com.meishu.sdk.meishu_ad.view.player;

import android.media.MediaPlayer;
import com.meishu.sdk.core.safe.f;
import com.meishu.sdk.core.safe.h;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;

/* JADX INFO: compiled from: CacheMediaPlayerHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5125a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.view.player.c.a d;
    public final /* synthetic */ String e;

    /* JADX INFO: renamed from: com.meishu.sdk.meishu_ad.view.player.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CacheMediaPlayerHelper.java */
    public class C0828a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f5126a;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.view.player.e[] b;
        public final /* synthetic */ MediaPlayer c;
        public final /* synthetic */ int[] d;

        /* JADX INFO: renamed from: com.meishu.sdk.meishu_ad.view.player.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CacheMediaPlayerHelper.java */
        public class C0829a extends l {
            public C0829a() {
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                LogUtil.d("CacheMediaPlayerHelper", com.meishu.sdk.activity.a.a("cache video success:").append(System.currentTimeMillis() - a.this.c).toString());
                C0828a c0828a = C0828a.this;
                a aVar = a.this;
                ((com.meishu.sdk.core.bquery.b) aVar.d).a(aVar.e, c0828a.c);
            }
        }

        public C0828a(boolean[] zArr, com.meishu.sdk.meishu_ad.view.player.e[] eVarArr, MediaPlayer mediaPlayer, int[] iArr) {
            this.f5126a = zArr;
            this.b = eVarArr;
            this.c = mediaPlayer;
            this.d = iArr;
        }

        @Override // com.meishu.sdk.core.safe.h
        public void a(MediaPlayer mediaPlayer) {
            LogUtil.d("CacheMediaPlayerHelper", "onPrepared");
            this.f5126a[0] = true;
            try {
                a aVar = a.this;
                int i = aVar.f5125a;
                if (i > 0 && i > aVar.b && this.b[0] != null) {
                    int duration = this.c.getDuration();
                    long size = this.b[0].getSize();
                    if (duration > 0 && size > 0) {
                        long j = (long) ((((double) a.this.f5125a) / ((double) duration)) * size);
                        com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.b bVar = this.b[0].f5137a.j;
                        if (bVar != null) {
                            bVar.a(j);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            boolean[] zArr = this.f5126a;
            if (zArr[1] || !com.meishu.sdk.meishu_ad.view.player.c.a(zArr[0], mediaPlayer, this.d[0], a.this.b)) {
                return;
            }
            this.f5126a[1] = true;
            SdkHandler.runOnMainThread(new C0829a());
        }
    }

    /* JADX INFO: compiled from: CacheMediaPlayerHelper.java */
    public class b extends com.meishu.sdk.core.safe.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f5128a;
        public final /* synthetic */ boolean[] b;
        public final /* synthetic */ MediaPlayer c;

        /* JADX INFO: renamed from: com.meishu.sdk.meishu_ad.view.player.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CacheMediaPlayerHelper.java */
        public class C0830a extends l {
            public C0830a() {
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                LogUtil.d("CacheMediaPlayerHelper", com.meishu.sdk.activity.a.a("cache video success :").append(System.currentTimeMillis() - a.this.c).toString());
                b bVar = b.this;
                a aVar = a.this;
                ((com.meishu.sdk.core.bquery.b) aVar.d).a(aVar.e, bVar.c);
            }
        }

        public b(int[] iArr, boolean[] zArr, MediaPlayer mediaPlayer) {
            this.f5128a = iArr;
            this.b = zArr;
            this.c = mediaPlayer;
        }

        @Override // com.meishu.sdk.core.safe.d
        public void a(MediaPlayer mediaPlayer, int i) {
            this.f5128a[0] = i;
            boolean[] zArr = this.b;
            if (zArr[1] || !com.meishu.sdk.meishu_ad.view.player.c.a(zArr[0], mediaPlayer, i, a.this.b)) {
                return;
            }
            this.b[1] = true;
            SdkHandler.runOnMainThread(new C0830a());
        }
    }

    /* JADX INFO: compiled from: CacheMediaPlayerHelper.java */
    public class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f5130a;

        /* JADX INFO: renamed from: com.meishu.sdk.meishu_ad.view.player.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CacheMediaPlayerHelper.java */
        public class C0831a extends l {
            public C0831a() {
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                ((com.meishu.sdk.core.bquery.b) a.this.d).a();
            }
        }

        public c(boolean[] zArr) {
            this.f5130a = zArr;
        }

        @Override // com.meishu.sdk.core.safe.f
        public boolean a(MediaPlayer mediaPlayer, int i, int i2) {
            LogUtil.d("CacheMediaPlayerHelper", "onError: what:" + i + "  extra:" + i2);
            boolean[] zArr = this.f5130a;
            if (zArr[1]) {
                return false;
            }
            zArr[1] = true;
            SdkHandler.runOnMainThread(new C0831a());
            return false;
        }
    }

    /* JADX INFO: compiled from: CacheMediaPlayerHelper.java */
    public class d implements com.meishu.sdk.meishu_ad.view.player.media.datasouce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f5132a;
        public final /* synthetic */ boolean[] b;
        public final /* synthetic */ MediaPlayer c;

        /* JADX INFO: renamed from: com.meishu.sdk.meishu_ad.view.player.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CacheMediaPlayerHelper.java */
        public class C0832a extends l {
            public C0832a() {
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                LogUtil.d("CacheMediaPlayerHelper", com.meishu.sdk.activity.a.a("cache video success  :").append(System.currentTimeMillis() - a.this.c).toString());
                d dVar = d.this;
                a aVar = a.this;
                ((com.meishu.sdk.core.bquery.b) aVar.d).a(aVar.e, dVar.c);
            }
        }

        public d(int[] iArr, boolean[] zArr, MediaPlayer mediaPlayer) {
            this.f5132a = iArr;
            this.b = zArr;
            this.c = mediaPlayer;
        }

        public void a(int i) {
            this.f5132a[0] = i;
            boolean[] zArr = this.b;
            if (zArr[1] || !com.meishu.sdk.meishu_ad.view.player.c.a(zArr[0], this.c, i, a.this.b)) {
                return;
            }
            this.b[1] = true;
            SdkHandler.runOnMainThread(new C0832a());
        }
    }

    /* JADX INFO: compiled from: CacheMediaPlayerHelper.java */
    public class e extends l {
        public e() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            ((com.meishu.sdk.core.bquery.b) a.this.d).a();
        }
    }

    public a(int i, int i2, long j, com.meishu.sdk.meishu_ad.view.player.c.a aVar, String str) {
        this.f5125a = i;
        this.b = i2;
        this.c = j;
        this.d = aVar;
        this.e = str;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            boolean[] zArr = new boolean[2];
            int[] iArr = new int[1];
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.setOnPreparedListener(new C0828a(zArr, eVarArr, mediaPlayer, iArr));
            mediaPlayer.setOnBufferingUpdateListener(new b(iArr, zArr, mediaPlayer));
            mediaPlayer.setOnErrorListener(new c(zArr));
            com.meishu.sdk.meishu_ad.view.player.e eVar = new com.meishu.sdk.meishu_ad.view.player.e(this.e, new d(iArr, zArr, mediaPlayer));
            com.meishu.sdk.meishu_ad.view.player.e[] eVarArr = {eVar};
            mediaPlayer.setDataSource(eVar);
            mediaPlayer.prepareAsync();
        } catch (Throwable th) {
            th.printStackTrace();
            SdkHandler.runOnMainThread(new e());
        }
    }
}
