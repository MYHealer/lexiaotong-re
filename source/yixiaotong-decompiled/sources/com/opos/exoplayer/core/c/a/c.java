package com.opos.exoplayer.core.c.a;

import android.util.Pair;
import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.f;
import com.opos.exoplayer.core.i.p;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class c extends b {
    private static final int[] b = {AVMDLDataLoader.KeyIsIsMaxTlsVersion, 11025, 22050, SWCommandUtil.SampleRate};
    private boolean c;
    private boolean d;
    private int e;

    public c(n nVar) {
        super(nVar);
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected boolean a(p pVar) throws b.a {
        Format formatA;
        if (this.c) {
            pVar.d(1);
        } else {
            int iG = pVar.g();
            int i = (iG >> 4) & 15;
            this.e = i;
            if (i == 2) {
                formatA = Format.a(null, MimeTypes.AUDIO_MPEG, null, -1, -1, 1, b[(iG >> 2) & 3], null, null, 0, null);
            } else {
                if (i == 7 || i == 8) {
                    formatA = Format.a((String) null, i == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW, (String) null, -1, -1, 1, 8000, (iG & 1) == 1 ? 2 : 3, (List<byte[]>) null, (DrmInitData) null, 0, (String) null);
                } else if (i != 10) {
                    throw new b.a("Audio format not supported: " + this.e);
                }
                this.c = true;
            }
            this.f6281a.a(formatA);
            this.d = true;
            this.c = true;
        }
        return true;
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected void b(p pVar, long j) {
        if (this.e == 2) {
            int iB = pVar.b();
            this.f6281a.a(pVar, iB);
            this.f6281a.a(j, 1, iB, 0, null);
            return;
        }
        int iG = pVar.g();
        if (iG != 0 || this.d) {
            if (this.e != 10 || iG == 1) {
                int iB2 = pVar.b();
                this.f6281a.a(pVar, iB2);
                this.f6281a.a(j, 1, iB2, 0, null);
                return;
            }
            return;
        }
        int iB3 = pVar.b();
        byte[] bArr = new byte[iB3];
        pVar.a(bArr, 0, iB3);
        Pair<Integer, Integer> pairA = f.a(bArr);
        this.f6281a.a(Format.a(null, MimeTypes.AUDIO_AAC, null, -1, -1, ((Integer) pairA.second).intValue(), ((Integer) pairA.first).intValue(), Collections.singletonList(bArr), null, 0, null));
        this.d = true;
    }
}
