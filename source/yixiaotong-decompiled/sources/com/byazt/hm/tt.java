package com.byazt.hm;

import com.byazt.gqp.sl;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 679, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2296a;
    public final int c;
    public final boolean da;
    public final long n;
    public sl sp;
    public final String tt;
    public final String uj;
    public final Map<String, String> ve;
    public Throwable x;
    public File i = null;
    public byte[] sl = null;

    public long a() {
        return this.n;
    }

    public Throwable c() {
        return this.x;
    }

    public void c(sl slVar) {
        this.sp = slVar;
    }

    public void c(File file) {
        this.i = file;
    }

    public void c(byte[] bArr) {
        this.sl = bArr;
    }

    public long da() {
        return this.n - this.f2296a;
    }

    public boolean i() {
        return this.da;
    }

    public String n() {
        return this.uj;
    }

    public byte[] sl() {
        return this.sl;
    }

    public long sp() {
        return this.f2296a;
    }

    public sl t() {
        return this.sp;
    }

    public int tt() {
        return this.c;
    }

    public Map<String, String> uj() {
        return this.ve;
    }

    public String ve() {
        return this.tt;
    }

    public File x() {
        return this.i;
    }

    public tt(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2) {
        this.da = z;
        this.c = i;
        this.tt = str;
        this.ve = map;
        this.uj = str2;
        this.n = j;
        this.f2296a = j2;
    }

    public tt(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2, Throwable th) {
        this.da = z;
        this.c = i;
        this.tt = str;
        this.ve = map;
        this.uj = str2;
        this.n = j;
        this.f2296a = j2;
        this.x = th;
    }
}
