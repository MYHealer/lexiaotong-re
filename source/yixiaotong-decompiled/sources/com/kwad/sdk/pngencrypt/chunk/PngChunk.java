package com.kwad.sdk.pngencrypt.chunk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class PngChunk {
    protected final com.kwad.sdk.pngencrypt.k bkK;
    public final boolean blK;
    public final boolean blL;
    public final boolean blM;
    protected d blN;
    private boolean blO = false;
    protected int blP = -1;
    public final String id;

    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public final boolean isOk(int i, boolean z) {
            if (this == NONE) {
                return true;
            }
            if (this == BEFORE_IDAT) {
                return i < 4;
            }
            if (this == BEFORE_PLTE_AND_IDAT) {
                return i < 2;
            }
            if (this != AFTER_PLTE_BEFORE_IDAT) {
                return this == AFTER_IDAT && i > 4;
            }
            if (z) {
                return i < 4;
            }
            return i < 4 && i > 2;
        }

        public final boolean mustGoAfterIDAT() {
            return this == AFTER_IDAT;
        }

        public final boolean mustGoAfterPLTE() {
            return this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        }

        public final boolean mustGoBeforeIDAT() {
            return this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT;
        }

        public final boolean mustGoBeforePLTE() {
            return this == BEFORE_PLTE_AND_IDAT;
        }
    }

    protected abstract void a(d dVar);

    final void b(d dVar) {
        this.blN = dVar;
    }

    final void fu(int i) {
        this.blP = i;
    }

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.id = str;
        this.bkK = kVar;
        this.blK = b.hq(str);
        this.blL = b.hr(str);
        this.blM = b.hs(str);
    }

    private int Tr() {
        d dVar = this.blN;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    private long Tp() {
        d dVar = this.blN;
        if (dVar != null) {
            return dVar.Tp();
        }
        return -1L;
    }

    public String toString() {
        return "chunk id= " + this.id + " (len=" + Tr() + " offset=" + Tp() + ")";
    }
}
