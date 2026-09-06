package com.opos.mobad.template.cmn;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ag extends ViewPager {

    /* JADX INFO: renamed from: com.opos.mobad.template.cmn.ag$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a implements ViewPager.PageTransformer {
        private a() {
        }

        /* synthetic */ a(ag agVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer
        public void transformPage(View view, float f) {
            if (f < -1.0f || f > 1.0f) {
                view.setAlpha(0.0f);
                return;
            }
            view.setAlpha(1.0f);
            view.setTranslationX(view.getWidth() * (-f));
            view.setTranslationY(f * view.getHeight());
        }
    }

    public ag(Context context) {
        super(context);
        a();
    }

    private MotionEvent a(MotionEvent motionEvent) {
        float width = getWidth();
        float height = getHeight();
        motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
        return motionEvent;
    }

    private void a() {
        setPageTransformer(true, new a(this, null));
        setOverScrollMode(2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(a(motionEvent));
        a(motionEvent);
        return zOnInterceptTouchEvent;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(a(motionEvent));
    }
}
