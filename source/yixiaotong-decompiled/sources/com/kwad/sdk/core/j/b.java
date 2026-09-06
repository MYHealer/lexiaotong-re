package com.kwad.sdk.core.j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class b implements c {
    private boolean bbU = false;
    private boolean aba = false;
    private boolean abb = false;

    protected abstract void aP();

    protected abstract void aQ();

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        this.bbU = true;
        if (this.abb) {
            return;
        }
        aP();
        this.abb = true;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        if (this.bbU && !this.aba) {
            aQ();
            this.aba = true;
        }
    }
}
