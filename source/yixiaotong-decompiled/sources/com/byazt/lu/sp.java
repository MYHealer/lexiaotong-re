package com.byazt.lu;

import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.ds.i;
import com.byazt.ds.x;
import com.byazt.yv.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.u;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 772, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f2465a = new AtomicLong(1000);
    public static c z;
    public final x c;
    public volatile boolean da;
    public long i = -1;
    public String n;
    public long sl;
    public long sp;
    public int t;
    public final i tt;
    public String u;
    public com.byazt.tv.i uj;
    public com.byazt.tv.i ve;
    public int x;
    public com.byazt.tv.a yp;

    /* JADX INFO: renamed from: com.byazt.lu.sp$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 772, 135})
    static /* synthetic */ class AnonymousClass1 {
    }

    public String c() {
        return this.n;
    }

    public boolean tt() {
        return this.da;
    }

    public sp(i iVar, x xVar) {
        this.tt = iVar;
        this.c = xVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004e  */
    public synchronized Bundle c(long j, long j2) {
        Bundle bundle;
        if (this.c.a() && ve()) {
            long j3 = this.sp;
            if (j3 <= 0 || j - j3 <= j2) {
                bundle = null;
            } else {
                bundle = new Bundle();
                bundle.putInt("session_no", this.t);
                int i = this.x + 1;
                this.x = i;
                bundle.putInt("send_times", i);
                bundle.putLong("current_duration", (j - this.sp) / 1000);
                bundle.putString(u.f9179a, com.byazt.tv.c.tt(this.i));
                this.sp = j;
            }
        } else {
            bundle = null;
        }
        return bundle;
    }

    public boolean ve() {
        return tt() && this.sl == 0;
    }

    private synchronized void c(com.byazt.tv.c cVar, ArrayList<com.byazt.tv.c> arrayList, boolean z2) {
        long j = cVar instanceof c ? -1L : cVar.tt;
        this.n = UUID.randomUUID().toString();
        f2465a.set(1000L);
        this.i = j;
        this.da = z2;
        this.sl = 0L;
        this.sp = 0L;
        if (da.tt) {
            da.c("startSession, " + this.n + ", hadUi:" + z2 + " data:" + cVar, null);
        }
        if (z2) {
            Calendar calendar = Calendar.getInstance();
            String string = new StringBuilder().append(calendar.get(1)).append(calendar.get(2)).append(calendar.get(5)).toString();
            if (TextUtils.isEmpty(this.u)) {
                this.u = this.c.ve();
                this.t = this.c.uj();
            }
            if (string.equals(this.u)) {
                this.t++;
            } else {
                this.u = string;
                this.t = 1;
            }
            this.c.c(string, this.t);
            this.x = 0;
            this.sp = cVar.tt;
        }
        if (j != -1) {
            com.byazt.tv.a aVar = new com.byazt.tv.a(false);
            aVar.uj = this.n;
            aVar.ve = uj();
            aVar.tt = this.i;
            aVar.yp = !this.da;
            aVar.u = this.tt.ve();
            aVar.t = this.tt.tt();
            aVar.f2757a = com.byazt.gj.c.sl();
            aVar.sp = com.byazt.gj.c.da();
            if (this.c.rl()) {
                aVar.x = com.byazt.gj.c.n();
            }
            arrayList.add(aVar);
            this.yp = aVar;
            if (da.tt) {
                da.c("gen launch, " + aVar.uj + ", hadUi:" + z2, null);
            }
        }
    }

    public static boolean c(com.byazt.tv.c cVar) {
        if (cVar instanceof com.byazt.tv.i) {
            return ((com.byazt.tv.i) cVar).da();
        }
        return false;
    }

    public boolean c(com.byazt.tv.c cVar, ArrayList<com.byazt.tv.c> arrayList) {
        boolean z2 = cVar instanceof com.byazt.tv.i;
        boolean zC = c(cVar);
        boolean z3 = true;
        if (this.i == -1) {
            c(cVar, arrayList, c(cVar));
        } else if (!this.da && zC) {
            c(cVar, arrayList, true);
        } else if (this.sl == 0 || cVar.tt <= this.sl + this.c.gu()) {
            if (this.i > cVar.tt + 7200000) {
                c(cVar, arrayList, zC);
            } else {
                z3 = false;
            }
        } else if (!com.byazt.yv.u.tt() && com.byazt.yv.u.c()) {
            c(cVar, arrayList, zC);
        }
        if (z2) {
            com.byazt.tv.i iVar = (com.byazt.tv.i) cVar;
            if (iVar.da()) {
                this.sl = 0L;
                arrayList.add(cVar);
                if (TextUtils.isEmpty(iVar.u)) {
                    if (this.uj != null && (iVar.tt - this.uj.tt) - this.uj.t < 500) {
                        iVar.u = this.uj.yp;
                    } else if (this.ve != null && (iVar.tt - this.ve.tt) - this.ve.t < 500) {
                        iVar.u = this.ve.yp;
                    }
                }
            } else {
                Bundle bundleC = c(cVar.tt, 0L);
                if (bundleC != null) {
                    com.byazt.gj.c.c("play_session", bundleC);
                }
                this.sl = iVar.tt;
                arrayList.add(cVar);
                if (iVar.sl()) {
                    this.ve = iVar;
                } else {
                    this.uj = iVar;
                    this.ve = null;
                }
            }
        } else if (!(cVar instanceof c)) {
            arrayList.add(cVar);
        }
        tt(cVar);
        return z3;
    }

    public void tt(com.byazt.tv.c cVar) {
        if (cVar != null) {
            if (this.c.rl()) {
                cVar.x = com.byazt.gj.c.n();
            }
            cVar.f2757a = com.byazt.gj.c.sl();
            cVar.sp = com.byazt.gj.c.da();
            cVar.uj = this.n;
            cVar.ve = uj();
        }
    }

    public static long uj() {
        return f2465a.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.byazt.zqa.c(c = {0, 1, 772, 180})
    static class c extends com.byazt.tv.da {
        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static c n() {
        if (z == null) {
            z = new c(null);
        }
        z.tt = System.currentTimeMillis();
        return z;
    }
}
