package com.byazt.ah;

import com.byazt.am.a;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1014, 54})
public class ve extends com.byazt.sbm.n {
    @Override // com.byazt.sbm.n
    public boolean hasDislike() {
        return false;
    }

    @Override // com.byazt.sbm.n
    public boolean isExpress() {
        return false;
    }

    @Override // com.byazt.sbm.ve
    public boolean isReady() {
        return true;
    }

    @Override // com.byazt.sbm.n
    public void onPause() {
    }

    @Override // com.byazt.sbm.n
    public void onResume() {
    }

    @Override // com.byazt.sbm.n
    public void setShakeViewListener(a aVar) {
    }

    @Override // com.byazt.sbm.n
    public void setUseCustomVideo(boolean z) {
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
    public com.byazt.sbm.c getBestEcpm() {
        return new c();
    }

    @Override // com.byazt.sbm.ve
    public List<com.byazt.sbm.c> getCacheList() {
        return new LinkedList();
    }

    @Override // com.byazt.sbm.ve
    public com.byazt.sbm.c getShowEcpm() {
        return new c();
    }
}
