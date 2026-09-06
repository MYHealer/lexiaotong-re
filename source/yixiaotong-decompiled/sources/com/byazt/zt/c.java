package com.byazt.zt;

import com.byazt.on.a;
import com.byazt.on.ve;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 2471, 20})
public abstract class c implements tt {
    public abstract ByteBuffer c();

    @Override // com.byazt.zt.tt
    public a tt() throws IOException {
        return new ve(c());
    }
}
