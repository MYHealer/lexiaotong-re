package com.byazt.utw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, 71})
public class x {
    public static final Set<String> c = new HashSet();
    public static final Set<String> tt = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2799a;
    public int n = -1;
    public final int sp;
    public final int uj;
    public final ArrayList<c> ve;

    public boolean c() {
        return this.f2799a < this.sp;
    }

    public x(List<String> list) {
        int iIntValue;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.uj = size;
        this.ve = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            c cVar = new c(str);
            if (c.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(cVar);
            } else if (tt.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(cVar);
            } else {
                this.ve.add(cVar);
            }
        }
        if (arrayList != null) {
            this.ve.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.ve.addAll(arrayList2);
        }
        Integer num = uj.uj;
        if (num == null || num.intValue() <= 0) {
            iIntValue = this.uj >= 2 ? 1 : 2;
        } else {
            iIntValue = num.intValue();
        }
        this.sp = iIntValue;
    }

    public c tt() {
        if (!c()) {
            throw new NoSuchElementException();
        }
        int i = this.n + 1;
        if (i >= this.uj - 1) {
            this.n = -1;
            this.f2799a++;
        } else {
            this.n = i;
        }
        c cVar = this.ve.get(i);
        cVar.tt = (this.f2799a * this.uj) + this.n;
        return cVar;
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, 62})
    public class c {
        public final String c;
        public int tt;

        public String toString() {
            return this.c;
        }

        public c(String str) {
            this.c = str;
        }

        public void c() {
            x.c.add(this.c);
        }

        public void tt() {
            x.tt.add(this.c);
        }
    }
}
