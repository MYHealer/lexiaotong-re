package com.opos.exoplayer.core.e;

import com.opos.exoplayer.core.Format;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6402a;
    private final Format[] b;
    private int c;

    public l(Format... formatArr) {
        com.opos.exoplayer.core.i.a.b(formatArr.length > 0);
        this.b = formatArr;
        this.f6402a = formatArr.length;
    }

    public int a(Format format) {
        int i = 0;
        while (true) {
            Format[] formatArr = this.b;
            if (i >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i]) {
                return i;
            }
            i++;
        }
    }

    public Format a(int i) {
        return this.b[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f6402a == lVar.f6402a && Arrays.equals(this.b, lVar.b);
    }

    public int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b) + 527;
        }
        return this.c;
    }
}
