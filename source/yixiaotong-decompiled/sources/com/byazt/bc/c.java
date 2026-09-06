package com.byazt.bc;

import com.byazt.cv.x;
import com.byazt.sbm.sp;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1487, 20})
public class c extends sp {
    public com.byazt.bz.ve c;

    public c(com.byazt.bz.ve veVar) {
        this.c = veVar;
    }

    @Override // com.byazt.sbm.sp
    public void destroy() {
        com.byazt.bz.ve veVar = this.c;
        if (veVar != null) {
            veVar.sp();
        }
    }

    @Override // com.byazt.sbm.ve
    public boolean isReady() {
        com.byazt.bz.ve veVar = this.c;
        if (veVar != null) {
            return veVar.c();
        }
        return false;
    }

    @Override // com.byazt.sbm.ve
    public List<com.byazt.sbm.tt> getAdLoadInfo() {
        if (this.c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.c.tt().size(); i++) {
                linkedList.add(new x(this.c.tt().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.byazt.sbm.ve
    public List<com.byazt.sbm.c> getMultiBiddingEcpm() {
        if (this.c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.c.ve().size(); i++) {
                linkedList.add(new com.byazt.cv.sp(this.c.ve().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.byazt.sbm.ve
    public com.byazt.sbm.c getBestEcpm() {
        if (this.c != null) {
            return new com.byazt.cv.sp(this.c.uj());
        }
        return new com.byazt.cv.sp(null);
    }

    @Override // com.byazt.sbm.ve
    public List<com.byazt.sbm.c> getCacheList() {
        if (this.c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.c.n().size(); i++) {
                linkedList.add(new com.byazt.cv.sp(this.c.n().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.byazt.sbm.ve
    public com.byazt.sbm.c getShowEcpm() {
        if (this.c != null) {
            return new com.byazt.cv.sp(this.c.a());
        }
        return new com.byazt.cv.sp(null);
    }
}
