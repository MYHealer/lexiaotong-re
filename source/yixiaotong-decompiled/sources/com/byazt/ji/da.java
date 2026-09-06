package com.byazt.ji;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR, 72})
public class da extends tt implements com.byazt.cd.i.c {
    public int sl;
    public Handler t;

    public da(Context context) {
        super(context);
        this.sl = 500;
        this.t = new com.byazt.cd.i(Looper.getMainLooper(), this);
    }

    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        Object obj = this.n.get("delay");
        if (obj == null) {
            this.sl = 500;
        } else {
            this.sl = com.byazt.cd.ve.c(String.valueOf(obj), 500);
        }
        return c(this.tt, motionEvent);
    }

    private boolean c(com.byazt.xj.ve veVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.t.sendEmptyMessageDelayed(1101, this.sl);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        this.t.removeMessages(1101);
        return false;
    }

    @Override // com.byazt.cd.i.c
    public void c(Message message) {
        if (message.what != 1101) {
            return;
        }
        if (this.c != null) {
            this.c.c(this.tt, this.f2381a, this.ve.tt(), this.ve);
        }
        Handler handler = this.t;
        if (handler != null) {
            handler.removeMessages(1101);
        }
    }
}
