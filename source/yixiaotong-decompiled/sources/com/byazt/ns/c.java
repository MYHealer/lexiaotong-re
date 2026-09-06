package com.byazt.ns;

import android.text.TextUtils;
import com.byazt.byh.ve;
import com.byazt.jzl.a;
import com.byazt.nr.m;
import com.byazt.nr.sp;
import com.byazt.utw.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, 20})
public final class c {
    public static final boolean c = com.byazt.lt.tt.tt();
    public HashMap<String, Boolean> tt;
    public C0230c ve;

    /* JADX INFO: renamed from: com.byazt.ns.c$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, 26})
    static /* synthetic */ class AnonymousClass1 {
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private static class tt {
        public static final c c = new c(null);
    }

    public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    private c() {
        this.tt = new HashMap<>();
        tt();
    }

    public static c c() {
        return tt.c;
    }

    public boolean tt() {
        if (this.ve != null) {
            return true;
        }
        ve veVarVe = ve();
        if (veVarVe == null) {
            return false;
        }
        uj.c(true);
        uj.c(1);
        try {
            C0230c c0230c = new C0230c();
            this.ve = c0230c;
            c0230c.setName("csj_v_c_preloader");
            this.ve.start();
            uj.c(veVarVe, com.byazt.oy.tt.getContext());
            com.byazt.utw.ve.c();
            com.byazt.utw.ve.c().c(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean c(a aVar) {
        if (!tt()) {
            return false;
        }
        this.ve.c(aVar);
        return true;
    }

    private static ve ve() {
        ve veVar = null;
        File file = new File(sp.tt(com.byazt.oy.tt.getContext(), false, null), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            ve veVar2 = new ve(file);
            try {
                veVar2.c(104857600L);
                return veVar2;
            } catch (IOException e) {
                e = e;
                veVar = veVar2;
                m.c(e);
                return veVar;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    /* JADX INFO: renamed from: com.byazt.ns.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, 44})
    class C0230c extends com.byazt.jtc.ve {
        public Queue<C0231c> n;
        public Queue<C0231c> tt;
        public final Queue<C0231c> uj;
        public boolean ve;

        public C0230c() {
            super("VideoCachePreloader$PreLoadThread");
            this.uj = new ArrayBlockingQueue(10);
            this.tt = new LinkedBlockingQueue();
            this.ve = true;
            this.n = new LinkedBlockingQueue();
        }

        private C0231c c(int i, a aVar) {
            this.uj.size();
            C0231c c0231cPoll = this.uj.poll();
            if (c0231cPoll == null) {
                c0231cPoll = new C0231c();
            }
            c0231cPoll.c = i;
            c0231cPoll.f2534a = aVar;
            return c0231cPoll;
        }

        private void c(C0231c c0231c) {
            c0231c.ve = null;
            c0231c.tt = null;
            c0231c.c = -1;
            c0231c.f2534a = null;
            this.uj.offer(c0231c);
        }

        private synchronized void tt(C0231c c0231c) {
            this.n.add(c0231c);
            notify();
        }

        private void ve(C0231c c0231c) {
            if (c0231c == null) {
                return;
            }
            this.tt.offer(c0231c);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.ve) {
                synchronized (this) {
                    if (!this.n.isEmpty()) {
                        c();
                    }
                    while (!this.tt.isEmpty()) {
                        C0231c c0231cPoll = this.tt.poll();
                        if (c0231cPoll != null) {
                            int i = c0231cPoll.c;
                            if (i != 0) {
                                if (i == 1) {
                                    com.byazt.utw.ve.c().c(c0231cPoll.tt);
                                } else if (i == 2) {
                                    com.byazt.utw.ve.c().tt();
                                } else if (i == 3) {
                                    com.byazt.utw.ve.c().tt();
                                    if (uj.tt() != null) {
                                        uj.tt().c();
                                    }
                                    if (uj.c() != null) {
                                        uj.c().c();
                                    }
                                } else if (i == 4) {
                                    com.byazt.utw.ve.c().tt();
                                    this.ve = false;
                                }
                            } else if (c0231cPoll.ve != null && c0231cPoll.ve.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : c0231cPoll.ve) {
                                    if (com.byazt.nxx.c.c(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                com.byazt.utw.ve.c().c(false, !TextUtils.isEmpty(c0231cPoll.n), c0231cPoll.uj, c0231cPoll.tt, (String[]) arrayList.toArray(new String[arrayList.size()]));
                            }
                            c(c0231cPoll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        m.c(e);
                    }
                }
            }
        }

        private void c() {
            while (true) {
                C0231c c0231cPoll = this.n.poll();
                if (c0231cPoll == null) {
                    return;
                }
                c0231cPoll.tt = c0231cPoll.f2534a.getUrl();
                c0231cPoll.ve = new String[]{c0231cPoll.f2534a.getUrl()};
                int pitayaCacheSize = c0231cPoll.f2534a.getPitayaCacheSize();
                if (pitayaCacheSize <= 0) {
                    pitayaCacheSize = c0231cPoll.f2534a.getPreloadSize();
                }
                c0231cPoll.uj = pitayaCacheSize;
                c0231cPoll.n = c0231cPoll.f2534a.getFileNameKey();
                if (!TextUtils.isEmpty(c0231cPoll.f2534a.getFileNameKey())) {
                    c0231cPoll.tt = c0231cPoll.f2534a.getFileNameKey();
                }
                c0231cPoll.f2534a = null;
                ve(c0231cPoll);
            }
        }

        public void c(a aVar) {
            tt(c(0, aVar));
        }

        /* JADX INFO: renamed from: com.byazt.ns.c$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, 810})
        private class C0231c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public a f2534a;
            public int c;
            public String n;
            public String tt;
            public int uj;
            public String[] ve;

            public C0231c() {
            }
        }
    }
}
