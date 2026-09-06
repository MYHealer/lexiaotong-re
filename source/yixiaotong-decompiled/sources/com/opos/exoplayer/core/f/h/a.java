package com.opos.exoplayer.core.f.h;

import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a extends com.opos.exoplayer.core.f.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f6451a = y.f("payl");
    private static final int b = y.f("sttg");
    private static final int c = y.f("vttc");
    private final p d;
    private final c.a e;

    public a() {
        super("Mp4WebvttDecoder");
        this.d = new p();
        this.e = new c.a();
    }

    private static com.opos.exoplayer.core.f.b a(p pVar, c.a aVar, int i) throws com.opos.exoplayer.core.f.f {
        aVar.a();
        while (i > 0) {
            if (i < 8) {
                throw new com.opos.exoplayer.core.f.f("Incomplete vtt cue box header found.");
            }
            int iO = pVar.o();
            int iO2 = pVar.o();
            int i2 = iO - 8;
            String str = new String(pVar.f6510a, pVar.d(), i2);
            pVar.d(i2);
            i = (i - 8) - i2;
            if (iO2 == b) {
                d.a(str, aVar);
            } else if (iO2 == f6451a) {
                d.a((String) null, str.trim(), aVar, (List<b>) Collections.emptyList());
            }
        }
        return aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.f.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public h a(byte[] bArr, int i, boolean z) throws com.opos.exoplayer.core.f.f {
        this.d.a(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.d.b() > 0) {
            if (this.d.b() < 8) {
                throw new com.opos.exoplayer.core.f.f("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iO = this.d.o();
            if (this.d.o() == c) {
                arrayList.add(a(this.d, this.e, iO - 8));
            } else {
                this.d.d(iO - 8);
            }
        }
        return new h(arrayList);
    }
}
