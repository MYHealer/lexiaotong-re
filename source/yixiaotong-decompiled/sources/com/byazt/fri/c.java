package com.byazt.fri;

import com.byazt.omf.rl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2129, 20})
public class c {
    public final String c;
    public final List<String> tt = new ArrayList();

    public c(String str) {
        this.c = str;
    }

    public static void c(String str, String str2) {
        c cVar = (c) rl.c(str, c.class);
        if (cVar == null) {
            c cVar2 = new c(str);
            cVar2.c(str2);
            rl.c(str, cVar2, c.class);
            return;
        }
        cVar.c(str2);
    }

    public void c(String str) {
        this.tt.add(str);
    }
}
