package com.opos.exoplayer.core.f.b;

import com.opos.exoplayer.core.i.p;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a extends com.opos.exoplayer.core.f.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f6423a;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        p pVar = new p(list.get(0));
        this.f6423a = new b(pVar.h(), pVar.h());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.f.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a(byte[] bArr, int i, boolean z) {
        if (z) {
            this.f6423a.a();
        }
        return new c(this.f6423a.a(bArr, i));
    }
}
