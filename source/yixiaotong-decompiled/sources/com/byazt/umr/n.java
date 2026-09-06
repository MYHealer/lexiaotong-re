package com.byazt.umr;

import com.byazt.mk.rh;
import com.byazt.mk.sp;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1046, 46})
public class n extends sp {
    public boolean c;

    public void c(IOException iOException) {
    }

    public n(rh rhVar) {
        super(rhVar);
    }

    @Override // com.byazt.mk.sp, com.byazt.mk.rh
    public void a_(com.byazt.mk.ve veVar, long j) throws IOException {
        if (this.c) {
            veVar.x(j);
            return;
        }
        try {
            super.a_(veVar, j);
        } catch (IOException e) {
            this.c = true;
            c(e);
        }
    }

    @Override // com.byazt.mk.sp, com.byazt.mk.rh, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.c = true;
            c(e);
        }
    }

    @Override // com.byazt.mk.sp, com.byazt.mk.rh, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.c = true;
            c(e);
        }
    }
}
