package com.byazt.h;

import client.android.yixiaotong.BaseActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 42})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2278a;
    public volatile u c;
    public volatile long n;
    public int sp;
    public int tt;
    public final AtomicLong uj;
    public final long ve;
    public JSONObject x;

    public long a() {
        return this.f2278a;
    }

    public void c(int i) {
        this.sp = i;
    }

    public int da() {
        return this.tt;
    }

    public void i() {
        this.tt--;
    }

    public int sp() {
        return this.sp;
    }

    public void tt(int i) {
        this.tt = i;
    }

    public long ve() {
        return this.ve;
    }

    public void x() {
        this.tt++;
    }

    public i(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.uj = atomicLong;
        this.tt = 0;
        this.ve = j;
        atomicLong.set(j);
        this.n = j;
        if (j2 >= j) {
            this.f2278a = j2;
        } else {
            this.f2278a = -1L;
        }
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.uj = atomicLong;
        this.tt = 0;
        this.ve = iVar.ve;
        this.f2278a = iVar.f2278a;
        atomicLong.set(iVar.uj.get());
        this.n = atomicLong.get();
        this.sp = iVar.sp;
    }

    public i(JSONObject jSONObject) {
        this.uj = new AtomicLong();
        this.tt = 0;
        this.ve = jSONObject.optLong("st");
        ve(jSONObject.optLong(BaseActivity.LANGUAGEEN));
        c(jSONObject.optLong("cu"));
        uj(uj());
    }

    public long c() {
        return this.uj.get() - this.ve;
    }

    public long tt() {
        long j = this.f2278a;
        if (j >= this.ve) {
            return (j - n()) + 1;
        }
        return -1L;
    }

    public long uj() {
        long j = this.uj.get();
        long j2 = this.f2278a;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long n() {
        u uVar = this.c;
        if (uVar != null) {
            long jUj = uVar.uj();
            if (jUj > this.n) {
                return jUj;
            }
        }
        return this.n;
    }

    public void c(long j) {
        long j2 = this.ve;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.f2278a;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.uj.set(j);
    }

    public void tt(long j) {
        this.uj.addAndGet(j);
    }

    public void ve(long j) {
        if (j >= this.ve) {
            this.f2278a = j;
            return;
        }
        com.byazt.nr.m.tt("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f2278a = j;
        }
    }

    public void uj(long j) {
        if (j >= this.uj.get()) {
            this.n = j;
        }
    }

    public String toString() {
        return "Segment{startOffset=" + this.ve + ",\t currentOffset=" + this.uj + ",\t currentOffsetRead=" + n() + ",\t endOffset=" + this.f2278a + '}';
    }

    public static String c(List<i> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<i>() { // from class: com.byazt.h.i.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int compare(i iVar, i iVar2) {
                return (int) (iVar.ve() - iVar2.ve());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        return sb.toString();
    }

    public JSONObject sl() throws JSONException {
        JSONObject jSONObject = this.x;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.x = jSONObject;
        }
        jSONObject.put("st", ve());
        jSONObject.put("cu", uj());
        jSONObject.put(BaseActivity.LANGUAGEEN, a());
        return jSONObject;
    }
}
