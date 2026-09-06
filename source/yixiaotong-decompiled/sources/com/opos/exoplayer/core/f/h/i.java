package com.opos.exoplayer.core.f.h;

import android.text.SpannableStringBuilder;
import com.opos.exoplayer.core.i.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class i implements com.opos.exoplayer.core.f.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<c> f6462a;
    private final int b;
    private final long[] c;
    private final long[] d;

    public i(List<c> list) {
        this.f6462a = list;
        int size = list.size();
        this.b = size;
        this.c = new long[size * 2];
        for (int i = 0; i < this.b; i++) {
            c cVar = list.get(i);
            int i2 = i * 2;
            long[] jArr = this.c;
            jArr[i2] = cVar.m;
            jArr[i2 + 1] = cVar.n;
        }
        long[] jArr2 = this.c;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.d = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.opos.exoplayer.core.f.d
    public int a(long j) {
        int iB = y.b(this.d, j, false, false);
        if (iB < this.d.length) {
            return iB;
        }
        return -1;
    }

    @Override // com.opos.exoplayer.core.f.d
    public long a(int i) {
        com.opos.exoplayer.core.i.a.a(i >= 0);
        com.opos.exoplayer.core.i.a.a(i < this.d.length);
        return this.d[i];
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return this.d.length;
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<com.opos.exoplayer.core.f.b> b(long j) {
        SpannableStringBuilder spannableStringBuilderAppend;
        SpannableStringBuilder spannableStringBuilder = null;
        ArrayList arrayList = null;
        c cVar = null;
        for (int i = 0; i < this.b; i++) {
            long[] jArr = this.c;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                c cVar2 = this.f6462a.get(i);
                if (!cVar2.a()) {
                    arrayList.add(cVar2);
                } else if (cVar == null) {
                    cVar = cVar2;
                } else {
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilderAppend = spannableStringBuilder.append(cVar.f6422a).append((CharSequence) IOUtils.LINE_SEPARATOR_UNIX);
                    } else {
                        spannableStringBuilderAppend = spannableStringBuilder.append((CharSequence) IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    spannableStringBuilderAppend.append(cVar2.f6422a);
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new c(spannableStringBuilder));
        } else if (cVar != null) {
            arrayList.add(cVar);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }
}
