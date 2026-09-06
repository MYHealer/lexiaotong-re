package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.i.p;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface n {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6373a;
        public final byte[] b;
        public final int c;
        public final int d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.f6373a = i;
            this.b = bArr;
            this.c = i2;
            this.d = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f6373a == aVar.f6373a && this.c == aVar.c && this.d == aVar.d && Arrays.equals(this.b, aVar.b);
        }

        public int hashCode() {
            return (((((this.f6373a * 31) + Arrays.hashCode(this.b)) * 31) + this.c) * 31) + this.d;
        }
    }

    int a(f fVar, int i, boolean z);

    void a(long j, int i, int i2, int i3, a aVar);

    void a(Format format);

    void a(p pVar, int i);
}
