package com.opos.exoplayer.core.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f6239a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class a extends com.opos.exoplayer.core.i.b {
        public a(int i, int i2, int i3) {
            super("Unhandled format: " + i + " Hz, " + i2 + " channels in encoding " + i3);
        }

        @Override // com.opos.exoplayer.core.i.b
        public String a() {
            return "UnhandledFormatException";
        }
    }

    void a(ByteBuffer byteBuffer);

    boolean a();

    boolean a(int i, int i2, int i3);

    int b();

    int c();

    int d();

    void e();

    ByteBuffer f();

    boolean g();

    void h();

    void i();
}
