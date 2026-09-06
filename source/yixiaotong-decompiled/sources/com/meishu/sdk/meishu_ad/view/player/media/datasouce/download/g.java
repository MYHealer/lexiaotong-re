package com.meishu.sdk.meishu_ad.view.player.media.datasouce.download;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ReadPositionNotes.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f5147a = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: ReadPositionNotes.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5148a = -2147483648L;
        public long b = -2147483648L;
        public boolean c = true;
        public int d;
    }

    public boolean a(String str, long j, long j2, int i) {
        a aVar;
        if (str == null) {
            str = "";
        }
        if (this.f5147a.containsKey(str)) {
            aVar = this.f5147a.get(str);
        } else {
            a aVar2 = new a();
            this.f5147a.put(str, aVar2);
            aVar = aVar2;
        }
        aVar.getClass();
        try {
            if (aVar.d == 0) {
                aVar.d = i;
            }
            if (j2 > 0) {
                long j3 = aVar.b;
                int i2 = aVar.d;
                if (i2 == 0) {
                    i2 = 2028;
                }
                if (j > ((long) i2) + j3 && j > (j2 / 4) * 3) {
                    aVar.f5148a = j;
                    aVar.b = Math.max(j3, j);
                    return true;
                }
            }
            long j4 = aVar.f5148a;
            if (j4 == 0 && aVar.c) {
                aVar.c = false;
                aVar.f5148a = j;
                aVar.b = Math.max(aVar.b, j);
                return false;
            }
            boolean z = j4 == 0 && j > aVar.b;
            aVar.f5148a = j;
            aVar.b = Math.max(aVar.b, j);
            return z;
        } catch (Throwable th) {
            aVar.f5148a = j;
            aVar.b = Math.max(aVar.b, j);
            throw th;
        }
    }
}
