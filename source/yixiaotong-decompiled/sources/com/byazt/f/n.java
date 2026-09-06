package com.byazt.f;

import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 953, 46})
public class n implements Serializable, Comparable<n> {
    public final long c;
    public DateFormat tt;

    public long c() {
        return this.c;
    }

    public int hashCode() {
        long j = this.c;
        return (int) (j ^ (j >>> 32));
    }

    public n(long j) {
        this.c = j;
    }

    public long tt() {
        return c(this.c);
    }

    public Date ve() {
        return new Date(c(this.c));
    }

    public static long c(long j) {
        long j2 = j >>> 32;
        return ((j2 & 4294967295L) * 1000) + ((j2 & CacheValidityPolicy.MAX_AGE) == 0 ? 2085978496000L : -2208988800000L) + Math.round(((j & 4294967295L) * 1000.0d) / 4.294967296E9d);
    }

    public static n tt(long j) {
        return new n(ve(j));
    }

    public static n uj() {
        return tt(System.currentTimeMillis());
    }

    public static long ve(long j) {
        boolean z = j < 2085978496000L;
        long j2 = j - (z ? -2208988800000L : 2085978496000L);
        long j3 = j2 / 1000;
        long j4 = ((j2 % 1000) * 4294967296L) / 1000;
        if (z) {
            j3 |= CacheValidityPolicy.MAX_AGE;
        }
        return j4 | (j3 << 32);
    }

    public boolean equals(Object obj) {
        return (obj instanceof n) && this.c == ((n) obj).c();
    }

    public String toString() {
        return uj(this.c);
    }

    private static void c(StringBuilder sb, long j) {
        String hexString = Long.toHexString(j);
        for (int length = hexString.length(); length < 8; length++) {
            sb.append('0');
        }
        sb.append(hexString);
    }

    public static String uj(long j) {
        StringBuilder sb = new StringBuilder();
        c(sb, (j >>> 32) & 4294967295L);
        sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        c(sb, j & 4294967295L);
        return sb.toString();
    }

    public String n() {
        if (this.tt == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, MMM dd yyyy HH:mm:ss.SSS", Locale.US);
            this.tt = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
        }
        return this.tt.format(ve());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(n nVar) {
        long j = this.c;
        long j2 = nVar.c;
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }
}
