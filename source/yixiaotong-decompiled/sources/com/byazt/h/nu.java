package com.byazt.h;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME})
public class nu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2279a;
    public final String c;
    public final AtomicLong da;
    public String i;
    public final List<u> n;
    public boolean sp;
    public final String tt;
    public final boolean uj;
    public final String ve;
    public int x;

    public nu(String str, boolean z) {
        this.n = new ArrayList();
        this.da = new AtomicLong();
        this.c = str;
        this.uj = z;
        this.tt = null;
        this.ve = null;
    }

    public nu(String str, String str2) {
        this.n = new ArrayList();
        this.da = new AtomicLong();
        this.c = str;
        this.uj = false;
        this.tt = str2;
        this.ve = c(str2);
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int iLastIndexOf = str.lastIndexOf(".");
            if (iLastIndexOf <= 0 || iLastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, iLastIndexOf);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            return null;
        }
    }

    public synchronized void c(u uVar) {
        this.n.add(uVar);
    }

    public synchronized void tt(u uVar) {
        try {
            this.n.remove(uVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized int c() {
        return this.n.size();
    }

    public synchronized void tt() {
        this.f2279a++;
        this.sp = true;
    }

    public synchronized void ve() {
        this.sp = false;
    }

    public synchronized boolean uj() {
        return this.sp;
    }

    public void c(long j) {
        this.da.addAndGet(j);
    }

    public int hashCode() {
        if (this.x == 0) {
            this.x = n().hashCode();
        }
        return this.x;
    }

    private String n() {
        if (this.i == null) {
            StringBuilder sbAppend = new StringBuilder().append(this.c).append("_");
            String str = this.tt;
            if (str == null) {
                str = "";
            }
            this.i = sbAppend.append(str).append("_").append(this.uj).toString();
        }
        return this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof nu) {
            return n().equals(((nu) obj).n());
        }
        return false;
    }

    public String toString() {
        return "UrlRecord{url='" + this.c + "', ip='" + this.tt + "', ipFamily='" + this.ve + "', isMainUrl=" + this.uj + ", failedTimes=" + this.f2279a + ", isCurrentFailed=" + this.sp + '}';
    }
}
