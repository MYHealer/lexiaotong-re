package com.kwad.sdk.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class h implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private GestureDetector MT;
    private d iH;
    private View mView;
    private MotionEvent qp;

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    public h(Context context, View view, d dVar) {
        this.mView = view;
        view.setOnTouchListener(this);
        this.MT = new GestureDetector(context, this);
        this.iH = dVar;
    }

    public h(View view, d dVar) {
        if (view == null) {
            return;
        }
        this.mView = view;
        view.setOnTouchListener(this);
        this.MT = new GestureDetector(view.getContext(), this);
        this.iH = dVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.qp != null && motionEvent.getAction() == 1 && b(this.qp, motionEvent)) {
            return a(view, motionEvent);
        }
        boolean zOnTouchEvent = this.MT.onTouchEvent(motionEvent);
        motionEvent.getAction();
        if (zOnTouchEvent) {
            return true;
        }
        return a(view, motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        d dVar = this.iH;
        if (dVar == null) {
            return false;
        }
        dVar.a(this.mView);
        return true;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.qp = MotionEvent.obtain(motionEvent);
        } else if (action == 1) {
            MotionEvent motionEvent2 = this.qp;
            if (motionEvent2 != null && b(motionEvent2, motionEvent)) {
                d dVar = this.iH;
                if (dVar != null) {
                    dVar.a(view, this.qp.getX(), this.qp.getY(), motionEvent.getX(), motionEvent.getY());
                }
                z = true;
            }
            this.qp = null;
        }
        return z;
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 20.0f ? 1 : (Math.abs(motionEvent.getX() - motionEvent2.getX()) == 20.0f ? 0 : -1)) > 0) || ((Math.abs(motionEvent.getY() - motionEvent2.getY()) > 20.0f ? 1 : (Math.abs(motionEvent.getY() - motionEvent2.getY()) == 20.0f ? 0 : -1)) > 0);
    }
}
