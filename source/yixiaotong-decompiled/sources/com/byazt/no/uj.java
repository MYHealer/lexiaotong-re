package com.byazt.no;

import com.byazt.hs.i;
import com.byazt.nr.m;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 785, 15})
public class uj implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f2525a;
    public final Object c;
    public long n;
    public final List<com.byazt.t.ve> tt;
    public boolean uj;
    public i ve;

    public List<com.byazt.t.ve> a() {
        return this.tt;
    }

    @Override // com.byazt.hs.i
    public InputStream c() throws IOException {
        InputStream inputStream = this.f2525a;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    public boolean c(int i) {
        return i >= 200 && i < 300;
    }

    public void n() throws InterruptedException {
        synchronized (this.c) {
            if (this.uj && this.ve == null) {
                this.c.wait();
            }
        }
    }

    @Override // com.byazt.hs.i
    public void uj() {
        i iVar = this.ve;
        if (iVar != null) {
            iVar.uj();
        }
    }

    @Override // com.byazt.hs.sp
    public String c(String str) {
        i iVar = this.ve;
        if (iVar != null) {
            return iVar.c(str);
        }
        return null;
    }

    @Override // com.byazt.hs.sp
    public int tt() throws IOException {
        i iVar = this.ve;
        if (iVar != null) {
            return iVar.tt();
        }
        return 0;
    }

    @Override // com.byazt.hs.sp
    public void ve() {
        i iVar = this.ve;
        if (iVar != null) {
            iVar.ve();
        }
    }

    public boolean sp() {
        try {
            i iVar = this.ve;
            return iVar != null && c(iVar.tt());
        } catch (IOException e) {
            m.c(e);
            return false;
        }
    }

    public boolean x() {
        return System.currentTimeMillis() - this.n < tt.c;
    }
}
