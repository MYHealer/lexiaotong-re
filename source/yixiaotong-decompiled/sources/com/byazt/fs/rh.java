package com.byazt.fs;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 115})
public class rh implements aw<Integer> {
    public static final rh c = new rh();

    private rh() {
    }

    @Override // com.byazt.fs.aw
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Integer tt(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(my.tt(jsonReader) * f));
    }
}
