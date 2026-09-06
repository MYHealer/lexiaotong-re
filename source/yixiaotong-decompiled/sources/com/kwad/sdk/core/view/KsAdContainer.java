package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.kwad.sdk.utils.al;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KsAdContainer extends RelativeLayout {
    protected al.a baL;

    public al.a getTouchCoords() {
        return this.baL;
    }

    public KsAdContainer(Context context) {
        super(context);
        this.baL = new al.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baL = new al.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baL = new al.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            al.a aVar = new al.a(getWidth(), getHeight());
            this.baL = aVar;
            aVar.j(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.baL.k(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
