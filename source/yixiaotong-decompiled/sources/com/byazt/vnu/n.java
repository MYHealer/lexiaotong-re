package com.byazt.vnu;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 699, 46})
public class n extends da {
    public long c;

    public n(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.byazt.vnu.da, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        long jSkip;
        jSkip = super.skip(j);
        this.c += jSkip;
        return jSkip;
    }

    @Override // com.byazt.vnu.da
    public synchronized void c(int i) {
        if (i != -1) {
            this.c += (long) i;
        }
    }

    public int c() {
        long jTt = tt();
        if (jTt <= 2147483647L) {
            return (int) jTt;
        }
        throw new ArithmeticException("The byte count " + jTt + " is too large to be converted to an int");
    }

    public synchronized long tt() {
        return this.c;
    }
}
