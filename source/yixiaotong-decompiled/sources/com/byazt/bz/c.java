package com.byazt.bz;

import com.byazt.cv.sp;
import com.byazt.cv.x;
import com.byazt.sbm.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 20})
public class c extends a {
    public ve c;

    public c(ve veVar) {
        this.c = veVar;
    }

    @Override // com.byazt.sbm.a
    public void destroy() {
        ve veVar = this.c;
        if (veVar != null) {
            veVar.sp();
        }
    }

    @Override // com.byazt.sbm.ve
    public boolean isReady() {
        ve veVar = this.c;
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
                linkedList.add(new sp(this.c.ve().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.byazt.sbm.ve
    public com.byazt.sbm.c getBestEcpm() {
        if (this.c != null) {
            return new sp(this.c.uj());
        }
        return new sp(null);
    }

    @Override // com.byazt.sbm.ve
    public List<com.byazt.sbm.c> getCacheList() {
        if (this.c != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.c.n().size(); i++) {
                linkedList.add(new sp(this.c.n().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.byazt.sbm.ve
    public com.byazt.sbm.c getShowEcpm() {
        if (this.c != null) {
            return new sp(this.c.a());
        }
        return new sp(null);
    }
}
