package com.opos.exoplayer.core.c.e;

import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class h extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f6328a = y.f("Opus");
    private static final byte[] b = {79, 112, 117, 115, 72, 101, 97, 100};
    private boolean c;

    h() {
    }

    private long a(byte[] bArr) {
        int i;
        int i2;
        byte b2 = bArr[0];
        int i3 = b2 & 255;
        int i4 = b2 & 3;
        if (i4 != 0) {
            i = 2;
            if (i4 != 1 && i4 != 2) {
                i = bArr[1] & Utf8.REPLACEMENT_BYTE;
            }
        } else {
            i = 1;
        }
        int i5 = i3 >> 3;
        int i6 = i5 & 3;
        if (i5 >= 16) {
            i2 = 2500 << i6;
        } else if (i5 >= 12) {
            i2 = 10000 << (i5 & 1);
        } else {
            i2 = i6 == 3 ? 60000 : 10000 << i6;
        }
        return i * i2;
    }

    private void a(List<byte[]> list, int i) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i) * 1000000000) / 48000).array());
    }

    public static boolean a(p pVar) {
        int iB = pVar.b();
        byte[] bArr = b;
        if (iB < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        pVar.a(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected void a(boolean z) {
        super.a(z);
        if (z) {
            this.c = false;
        }
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected boolean a(p pVar, long j, i.b bVar) {
        if (this.c) {
            boolean z = pVar.o() == f6328a;
            pVar.c(0);
            return z;
        }
        byte[] bArrCopyOf = Arrays.copyOf(pVar.f6510a, pVar.c());
        int i = bArrCopyOf[9] & 255;
        int i2 = ((bArrCopyOf[11] & 255) << 8) | (bArrCopyOf[10] & 255);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArrCopyOf);
        a(arrayList, i2);
        a(arrayList, 3840);
        bVar.f6330a = Format.a(null, MimeTypes.AUDIO_OPUS, null, -1, -1, i, OpusUtil.SAMPLE_RATE, arrayList, null, 0, null);
        this.c = true;
        return true;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected long b(p pVar) {
        return b(a(pVar.f6510a));
    }
}
