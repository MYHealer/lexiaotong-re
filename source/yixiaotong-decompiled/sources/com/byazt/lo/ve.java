package com.byazt.lo;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.aas.pf;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL, 54})
public class ve implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2459a;
    public float c;
    public int n;
    public float tt;
    public c uj;
    public boolean ve;

    public interface c {
        void c();

        void tt();
    }

    public ve(Context context, c cVar, int i) {
        this.f2459a = context;
        this.n = i;
        this.uj = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.tt = y;
                if (Math.abs(y - this.c) > 10.0f) {
                    this.ve = true;
                }
            }
        } else {
            if (!this.ve) {
                c cVar = this.uj;
                if (cVar != null) {
                    cVar.tt();
                }
                return true;
            }
            int iUj = pf.uj(this.f2459a, Math.abs(this.tt - this.c));
            if (this.tt - this.c >= 0.0f || iUj <= this.n) {
                c cVar2 = this.uj;
                if (cVar2 != null) {
                    cVar2.tt();
                }
            } else {
                c cVar3 = this.uj;
                if (cVar3 != null) {
                    cVar3.c();
                }
            }
        }
        return true;
    }
}
