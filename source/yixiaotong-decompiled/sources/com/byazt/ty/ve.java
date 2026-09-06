package com.byazt.ty;

import com.byazt.w.a;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, TTVideoEngine.PLAYER_OPTION_OUTPUT_LOG, 54})
public class ve implements tt {
    public final InputStream c;
    public final com.byazt.h.c tt;

    @Override // com.byazt.ty.tt
    public void c(com.byazt.h.c cVar) {
    }

    public ve(InputStream inputStream, int i) {
        this.c = inputStream;
        this.tt = new com.byazt.h.c(i);
    }

    @Override // com.byazt.ty.tt
    public com.byazt.h.c c() throws IOException {
        com.byazt.h.c cVar = this.tt;
        cVar.ve = this.c.read(cVar.c);
        return this.tt;
    }

    @Override // com.byazt.ty.tt
    public void tt() {
        a.c(this.c);
    }
}
