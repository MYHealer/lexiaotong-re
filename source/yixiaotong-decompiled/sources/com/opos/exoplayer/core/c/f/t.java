package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.exoplayer.core.i.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class t implements com.opos.exoplayer.core.c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f6356a = new a();
    private static final long b = y.f("AC-3");
    private static final long c = y.f("EAC3");
    private static final long d = y.f("HEVC");
    private final int e;
    private final List<com.opos.exoplayer.core.i.w> f;
    private final com.opos.exoplayer.core.i.p g;
    private final SparseIntArray h;
    private final u.c i;
    private final SparseArray<u> j;
    private final SparseBooleanArray k;
    private com.opos.exoplayer.core.c.g l;
    private int m;
    private boolean n;
    private u o;
    private int p;

    static class a implements com.opos.exoplayer.core.c.h {
        a() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new t()};
        }
    }

    private class b implements q {
        private final com.opos.exoplayer.core.i.o b = new com.opos.exoplayer.core.i.o(new byte[4]);

        public b() {
        }

        @Override // com.opos.exoplayer.core.c.f.q
        public void a(com.opos.exoplayer.core.i.p pVar) {
            if (pVar.g() != 0) {
                return;
            }
            pVar.d(7);
            int iB = pVar.b() / 4;
            for (int i = 0; i < iB; i++) {
                pVar.a(this.b, 4);
                int iC = this.b.c(16);
                this.b.b(3);
                if (iC == 0) {
                    this.b.b(13);
                } else {
                    int iC2 = this.b.c(13);
                    t.this.j.put(iC2, new r(t.this.new c(iC2)));
                    t.b(t.this);
                }
            }
            if (t.this.e != 2) {
                t.this.j.remove(0);
            }
        }

        @Override // com.opos.exoplayer.core.c.f.q
        public void a(com.opos.exoplayer.core.i.w wVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        }
    }

    private class c implements q {
        private final com.opos.exoplayer.core.i.o b = new com.opos.exoplayer.core.i.o(new byte[5]);
        private final SparseArray<u> c = new SparseArray<>();
        private final SparseIntArray d = new SparseIntArray();
        private final int e;

        public c(int i) {
            this.e = i;
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0043  */
        /* JADX WARN: Code duplicated, block: B:21:0x004a  */
        private u.b a(com.opos.exoplayer.core.i.p pVar, int i) {
            int iD = pVar.d();
            int i2 = i + iD;
            int i3 = -1;
            String strTrim = null;
            ArrayList arrayList = null;
            while (pVar.d() < i2) {
                int iG = pVar.g();
                int iD2 = pVar.d() + pVar.g();
                if (iG == 5) {
                    long jM = pVar.m();
                    if (jM == t.b) {
                        i3 = 129;
                    } else if (jM == t.c) {
                        i3 = 135;
                    } else if (jM == t.d) {
                        i3 = 36;
                    }
                } else if (iG == 106) {
                    i3 = 129;
                } else if (iG == 122) {
                    i3 = 135;
                } else if (iG == 123) {
                    i3 = 138;
                } else if (iG == 10) {
                    strTrim = pVar.e(3).trim();
                } else if (iG == 89) {
                    ArrayList arrayList2 = new ArrayList();
                    while (pVar.d() < iD2) {
                        String strTrim2 = pVar.e(3).trim();
                        int iG2 = pVar.g();
                        byte[] bArr = new byte[4];
                        pVar.a(bArr, 0, 4);
                        arrayList2.add(new u.a(strTrim2, iG2, bArr));
                    }
                    arrayList = arrayList2;
                    i3 = 89;
                }
                pVar.d(iD2 - pVar.d());
            }
            pVar.c(i2);
            return new u.b(i3, strTrim, arrayList, Arrays.copyOfRange(pVar.f6510a, iD, i2));
        }

        @Override // com.opos.exoplayer.core.c.f.q
        public void a(com.opos.exoplayer.core.i.p pVar) {
            com.opos.exoplayer.core.i.w wVar;
            if (pVar.g() != 2) {
                return;
            }
            if (t.this.e == 1 || t.this.e == 2 || t.this.m == 1) {
                wVar = (com.opos.exoplayer.core.i.w) t.this.f.get(0);
            } else {
                wVar = new com.opos.exoplayer.core.i.w(((com.opos.exoplayer.core.i.w) t.this.f.get(0)).a());
                t.this.f.add(wVar);
            }
            pVar.d(2);
            int iH = pVar.h();
            int i = 5;
            pVar.d(5);
            pVar.a(this.b, 2);
            int i2 = 4;
            this.b.b(4);
            pVar.d(this.b.c(12));
            if (t.this.e == 2 && t.this.o == null) {
                u.b bVar = new u.b(21, null, null, new byte[0]);
                t tVar = t.this;
                tVar.o = tVar.i.a(21, bVar);
                t.this.o.a(wVar, t.this.l, new u.d(iH, 21, 8192));
            }
            this.c.clear();
            this.d.clear();
            int iB = pVar.b();
            while (iB > 0) {
                pVar.a(this.b, i);
                int iC = this.b.c(8);
                this.b.b(3);
                int iC2 = this.b.c(13);
                this.b.b(i2);
                int iC3 = this.b.c(12);
                u.b bVarA = a(pVar, iC3);
                if (iC == 6) {
                    iC = bVarA.f6360a;
                }
                iB -= iC3 + 5;
                int i3 = t.this.e == 2 ? iC : iC2;
                if (!t.this.k.get(i3)) {
                    u uVarA = (t.this.e == 2 && iC == 21) ? t.this.o : t.this.i.a(iC, bVarA);
                    if (t.this.e != 2 || iC2 < this.d.get(i3, 8192)) {
                        this.d.put(i3, iC2);
                        this.c.put(i3, uVarA);
                    }
                }
                i = 5;
                i2 = 4;
            }
            int size = this.d.size();
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = this.d.keyAt(i4);
                t.this.k.put(iKeyAt, true);
                u uVarValueAt = this.c.valueAt(i4);
                if (uVarValueAt != null) {
                    if (uVarValueAt != t.this.o) {
                        uVarValueAt.a(wVar, t.this.l, new u.d(iH, iKeyAt, 8192));
                    }
                    t.this.j.put(this.d.valueAt(i4), uVarValueAt);
                }
            }
            if (t.this.e != 2) {
                t.this.j.remove(this.e);
                t tVar2 = t.this;
                tVar2.m = tVar2.e != 1 ? t.this.m - 1 : 0;
                if (t.this.m != 0) {
                    return;
                } else {
                    t.this.l.a();
                }
            } else {
                if (t.this.n) {
                    return;
                }
                t.this.l.a();
                t.this.m = 0;
            }
            t.this.n = true;
        }

        @Override // com.opos.exoplayer.core.c.f.q
        public void a(com.opos.exoplayer.core.i.w wVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        }
    }

    public t() {
        this(0);
    }

    public t(int i) {
        this(1, i);
    }

    public t(int i, int i2) {
        this(i, new com.opos.exoplayer.core.i.w(0L), new e(i2));
    }

    public t(int i, com.opos.exoplayer.core.i.w wVar, u.c cVar) {
        this.i = (u.c) com.opos.exoplayer.core.i.a.a(cVar);
        this.e = i;
        if (i == 1 || i == 2) {
            this.f = Collections.singletonList(wVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add(wVar);
        }
        this.g = new com.opos.exoplayer.core.i.p(new byte[AVMDLDataLoader.KeyIsIgnorePlayInfo], 0);
        this.k = new SparseBooleanArray();
        this.j = new SparseArray<>();
        this.h = new SparseIntArray();
        e();
    }

    static /* synthetic */ int b(t tVar) {
        int i = tVar.m;
        tVar.m = i + 1;
        return i;
    }

    private void e() {
        this.k.clear();
        this.j.clear();
        SparseArray<u> sparseArrayA = this.i.a();
        int size = sparseArrayA.size();
        for (int i = 0; i < size; i++) {
            this.j.put(sparseArrayA.keyAt(i), sparseArrayA.valueAt(i));
        }
        this.j.put(0, new r(new b()));
        this.o = null;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00d8  */
    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) throws com.opos.exoplayer.core.o {
        com.opos.exoplayer.core.i.p pVar = this.g;
        byte[] bArr = pVar.f6510a;
        if (9400 - pVar.d() < 188) {
            int iB = this.g.b();
            if (iB > 0) {
                System.arraycopy(bArr, this.g.d(), bArr, 0, iB);
            }
            this.g.a(bArr, iB);
        }
        while (this.g.b() < 188) {
            int iC = this.g.c();
            int iA = fVar.a(bArr, iC, 9400 - iC);
            if (iA == -1) {
                return -1;
            }
            this.g.b(iC + iA);
        }
        int iC2 = this.g.c();
        int iD = this.g.d();
        int i = iD;
        while (i < iC2 && bArr[i] != 71) {
            i++;
        }
        this.g.c(i);
        int i2 = i + 188;
        if (i2 > iC2) {
            int i3 = this.p + (i - iD);
            this.p = i3;
            if (this.e != 2 || i3 <= 376) {
                return 0;
            }
            throw new com.opos.exoplayer.core.o("Cannot find sync byte. Most likely not a Transport Stream.");
        }
        this.p = 0;
        int iO = this.g.o();
        if ((8388608 & iO) == 0) {
            boolean z = (4194304 & iO) != 0;
            int i4 = (2096896 & iO) >> 8;
            boolean z2 = (iO & 32) != 0;
            u uVar = (iO & 16) != 0 ? this.j.get(i4) : null;
            if (uVar != null) {
                if (this.e != 2) {
                    int i5 = iO & 15;
                    int i6 = this.h.get(i4, i5 - 1);
                    this.h.put(i4, i5);
                    if (i6 != i5) {
                        if (i5 != ((i6 + 1) & 15)) {
                            uVar.a();
                        }
                        if (z2) {
                            this.g.d(this.g.g());
                        }
                        this.g.b(i2);
                        uVar.a(this.g, z);
                        this.g.b(iC2);
                    }
                } else {
                    if (z2) {
                        this.g.d(this.g.g());
                    }
                    this.g.b(i2);
                    uVar.a(this.g, z);
                    this.g.b(iC2);
                }
            }
        }
        this.g.c(i2);
        return 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            this.f.get(i).d();
        }
        this.g.a();
        this.h.clear();
        e();
        this.p = 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.l = gVar;
        gVar.a(new com.opos.exoplayer.core.c.l.b(-9223372036854775807L));
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        byte[] bArr = this.g.f6510a;
        fVar.c(bArr, 0, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PARAMS);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 == 5) {
                    fVar.b(i);
                    return true;
                }
                if (bArr[(i2 * 188) + i] != 71) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
