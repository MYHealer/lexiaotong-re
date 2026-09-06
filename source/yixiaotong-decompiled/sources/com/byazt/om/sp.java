package com.byazt.om;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.vx.p;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp implements c.InterfaceC0233c {
    public List<c> c;
    public com.byazt.iz.tt tt;
    public int uj;
    public int ve;

    @Override // com.byazt.om.c.InterfaceC0233c
    public com.byazt.iz.tt c() {
        return this.tt;
    }

    public static /* synthetic */ int a(sp spVar) {
        int i = spVar.uj;
        spVar.uj = i + 1;
        return i;
    }

    public static /* synthetic */ int uj(sp spVar) {
        int i = spVar.ve;
        spVar.ve = i + 1;
        return i;
    }

    public sp(List<c> list) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.c = copyOnWriteArrayList;
        this.ve = 0;
        this.uj = 0;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    @Override // com.byazt.om.c.InterfaceC0233c
    public void c(com.byazt.iz.tt ttVar) {
        if (this.tt != ttVar && ttVar != null) {
            this.tt = ttVar;
        }
        if (p.c(this.c)) {
            return;
        }
        com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.om.sp.1
            @Override // java.lang.Runnable
            public void run() {
                if (sp.this.ve == 0 && sp.this.tt != null) {
                    sp.this.tt.tt(SystemClock.elapsedRealtime());
                }
                if (sp.this.c.size() > sp.this.ve) {
                    ((c) sp.this.c.get(sp.uj(sp.this))).c(sp.this);
                }
            }
        });
    }

    @Override // com.byazt.om.c.InterfaceC0233c
    public void c(String str) {
        com.byazt.iz.tt ttVar;
        if (!TextUtils.isEmpty(str) && (ttVar = this.tt) != null) {
            ttVar.tt(str);
        }
        com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.om.sp.2
            @Override // java.lang.Runnable
            public void run() {
                if (sp.this.c.size() > sp.this.uj) {
                    ((c) sp.this.c.get(sp.a(sp.this))).tt(sp.this);
                }
            }
        });
    }
}
