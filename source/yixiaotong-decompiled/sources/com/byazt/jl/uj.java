package com.byazt.jl;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 157, 15})
public class uj {

    @com.byazt.zqa.c(c = {0, 1, 157, AppTypeIdUtil.NewDevice4GBathOTA})
    static class c extends IOException {
        public c() {
            super("APNG Format error");
        }
    }

    public static List<n> c(com.byazt.on.c cVar) throws IOException {
        if (!cVar.c("\u0089PNG") || !cVar.c("\r\n\u001a\n")) {
            throw new c();
        }
        ArrayList arrayList = new ArrayList();
        while (cVar.uj() > 0) {
            arrayList.add(tt(cVar));
        }
        return arrayList;
    }

    private static n tt(com.byazt.on.c cVar) throws IOException {
        n nVar;
        int iVe = cVar.ve();
        int iTt = cVar.tt();
        int iB_ = cVar.b_();
        if (iB_ == com.byazt.jl.c.c) {
            nVar = new com.byazt.jl.c();
        } else if (iB_ == a.c) {
            nVar = new a();
        } else if (iB_ == sp.c) {
            nVar = new sp();
        } else if (iB_ == da.c) {
            nVar = new da();
        } else if (iB_ == sl.c) {
            nVar = new sl();
        } else if (iB_ == t.c) {
            nVar = new t();
        } else {
            nVar = new n();
        }
        nVar.sp = iVe;
        nVar.n = iB_;
        nVar.uj = iTt;
        nVar.tt(cVar);
        nVar.f2383a = cVar.tt();
        return nVar;
    }
}
