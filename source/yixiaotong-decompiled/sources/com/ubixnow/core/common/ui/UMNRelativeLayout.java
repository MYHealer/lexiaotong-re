package com.ubixnow.core.common.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.ubixnow.ooooo.o00O0OO;
import com.ubixnow.ooooo.o0OO00o0;
import com.ubixnow.ooooo.o0OOO00;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNRelativeLayout extends FrameLayout implements o0OO00o0 {
    private List<o00O0OO> OooO00o;
    private OooO00o OooO0O0;
    private Rect OooO0OO;

    public interface OooO00o {
        void visibleChange(boolean z);
    }

    public UMNRelativeLayout(Context context) {
        super(context);
        this.OooO00o = new ArrayList();
        this.OooO0OO = new Rect();
    }

    public UMNRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OooO00o = new ArrayList();
        this.OooO0OO = new Rect();
    }

    public UMNRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OooO00o = new ArrayList();
        this.OooO0OO = new Rect();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (getChildAt(getChildCount() - 1) != null && (getChildAt(getChildCount() - 1) instanceof o0OOO00)) {
                ((ImageView) getChildAt(getChildCount() - 1)).getGlobalVisibleRect(this.OooO0OO);
                if (motionEvent.getRawX() >= this.OooO0OO.left && motionEvent.getRawX() <= this.OooO0OO.right && motionEvent.getRawY() >= this.OooO0OO.top && motionEvent.getRawY() <= this.OooO0OO.bottom) {
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            if (this.OooO00o.size() > 0) {
                for (o00O0OO o00o0oo : this.OooO00o) {
                    if (o00o0oo != null && o00o0oo.OooO00o(motionEvent, this)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.OooO0O0 = null;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        OooO00o oooO00o = this.OooO0O0;
        if (oooO00o != null) {
            oooO00o.visibleChange(z);
        }
    }

    @Override // com.ubixnow.ooooo.o0OO00o0
    public void setDispatchListener(o00O0OO o00o0oo) {
        this.OooO00o.add(o00o0oo);
    }

    public void setVisibleChangeListener(OooO00o oooO00o) {
        this.OooO0O0 = oooO00o;
    }
}
