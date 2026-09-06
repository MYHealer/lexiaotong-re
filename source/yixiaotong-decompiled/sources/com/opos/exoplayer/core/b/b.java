package com.opos.exoplayer.core.b;

import android.media.MediaCodec;
import com.opos.exoplayer.core.i.y;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f6272a;
    public byte[] b;
    public int c;
    public int[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    private final MediaCodec.CryptoInfo i;
    private final C0904b j;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.b.b$b, reason: collision with other inner class name */
    private static final class C0904b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaCodec.CryptoInfo f6273a;
        private final MediaCodec.CryptoInfo.Pattern b;

        private C0904b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f6273a = cryptoInfo;
            this.b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* synthetic */ C0904b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this(cryptoInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2) {
            this.b.set(i, i2);
            this.f6273a.setPattern(this.b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        Object[] objArr = 0;
        MediaCodec.CryptoInfo cryptoInfoB = y.f6517a >= 16 ? b() : null;
        this.i = cryptoInfoB;
        this.j = y.f6517a >= 24 ? new C0904b(cryptoInfoB, objArr == true ? 1 : 0) : null;
    }

    private MediaCodec.CryptoInfo b() {
        return new MediaCodec.CryptoInfo();
    }

    private void c() {
        MediaCodec.CryptoInfo cryptoInfo = this.i;
        cryptoInfo.numSubSamples = this.f;
        cryptoInfo.numBytesOfClearData = this.d;
        cryptoInfo.numBytesOfEncryptedData = this.e;
        cryptoInfo.key = this.b;
        cryptoInfo.iv = this.f6272a;
        cryptoInfo.mode = this.c;
        if (y.f6517a >= 24) {
            this.j.a(this.g, this.h);
        }
    }

    public MediaCodec.CryptoInfo a() {
        return this.i;
    }

    public void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.f = i;
        this.d = iArr;
        this.e = iArr2;
        this.b = bArr;
        this.f6272a = bArr2;
        this.c = i2;
        this.g = i3;
        this.h = i4;
        if (y.f6517a >= 16) {
            c();
        }
    }
}
