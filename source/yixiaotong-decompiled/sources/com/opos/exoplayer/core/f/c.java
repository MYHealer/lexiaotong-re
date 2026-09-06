package com.opos.exoplayer.core.f;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class c extends com.opos.exoplayer.core.b.g<h, i, f> implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6434a;

    protected c(String str) {
        super(new h[2], new i[2]);
        this.f6434a = str;
        a(1024);
    }

    protected abstract d a(byte[] bArr, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.b.g
    public final f a(h hVar, i iVar, boolean z) {
        try {
            ByteBuffer byteBuffer = hVar.b;
            iVar.a(hVar.c, a(byteBuffer.array(), byteBuffer.limit(), z), hVar.d);
            iVar.c(Integer.MIN_VALUE);
            return null;
        } catch (f e) {
            return e;
        }
    }

    @Override // com.opos.exoplayer.core.f.e
    public void a(long j) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.b.g
    public final void a(i iVar) {
        super.a(iVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.b.g
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final f a(Throwable th) {
        return new f("Unexpected decode error", th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.b.g
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final h g() {
        return new h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.b.g
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final i h() {
        return new l(this);
    }
}
