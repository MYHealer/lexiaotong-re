package com.byazt.ah;

import com.byazt.sbm.sp;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1014, 46})
public class n extends sp {
    @Override // com.byazt.sbm.sp
    public void destroy() {
    }

    @Override // com.byazt.sbm.ve
    public boolean isReady() {
        return true;
    }

    @Override // com.byazt.sbm.ve
    public List<com.byazt.sbm.tt> getAdLoadInfo() {
        return new LinkedList();
    }

    @Override // com.byazt.sbm.ve
    public List<com.byazt.sbm.c> getMultiBiddingEcpm() {
        return new LinkedList();
    }

    @Override // com.byazt.sbm.ve
    public c getBestEcpm() {
        return new c();
    }

    @Override // com.byazt.sbm.ve
    public List<com.byazt.sbm.c> getCacheList() {
        return new LinkedList();
    }

    @Override // com.byazt.sbm.ve
    public c getShowEcpm() {
        return new c();
    }
}
