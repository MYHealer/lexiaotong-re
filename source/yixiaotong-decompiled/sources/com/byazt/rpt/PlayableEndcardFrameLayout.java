package com.byazt.rpt;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 311, 445})
public class PlayableEndcardFrameLayout extends FrameLayout {
    public c c;
    public int tt;

    public interface c {
        void c();
    }

    public void c(c cVar) {
        this.c = cVar;
    }

    public PlayableEndcardFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.tt = y;
        } else if (action == 2 && Math.abs(this.tt - y) > 100) {
            c();
            this.tt = y;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void c() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.c();
        }
    }
}
