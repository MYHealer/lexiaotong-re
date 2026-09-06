package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.p;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface f {

    public static final class a extends com.opos.exoplayer.core.i.b {
        public a(String str) {
            super(str);
        }

        public a(Throwable th) {
            super(th);
        }

        @Override // com.opos.exoplayer.core.i.b
        public String a() {
            return "ConfigurationException";
        }
    }

    public static final class b extends com.opos.exoplayer.core.i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6247a;

        public b(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.f6247a = i;
        }

        @Override // com.opos.exoplayer.core.i.b
        public String a() {
            return "InitializationException";
        }
    }

    public interface c {
        void a();

        void a(int i);

        void a(int i, long j, long j2);
    }

    public static final class d extends com.opos.exoplayer.core.i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6248a;

        public d(int i) {
            super("AudioTrack write failed: " + i);
            this.f6248a = i;
        }

        @Override // com.opos.exoplayer.core.i.b
        public String a() {
            return "WriteException";
        }
    }

    long a(boolean z);

    p a(p pVar);

    void a();

    void a(float f);

    void a(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6);

    void a(com.opos.exoplayer.core.a.b bVar);

    void a(c cVar);

    boolean a(int i);

    boolean a(ByteBuffer byteBuffer, long j);

    void b();

    void b(int i);

    void c();

    boolean d();

    boolean e();

    p f();

    void g();

    void h();

    void i();

    void j();
}
