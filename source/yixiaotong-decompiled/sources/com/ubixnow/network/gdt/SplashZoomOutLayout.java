package com.ubixnow.network.gdt;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.ubixnow.core.R;
import com.ubixnow.ooooo.oOO00000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class SplashZoomOutLayout extends FrameLayout {
    private TextView OooO;
    private float OooO00o;
    private float OooO0O0;
    private int OooO0OO;
    private int OooO0Oo;
    private float OooO0o;
    private int OooO0o0;
    private float OooO0oO;
    private final int OooO0oo;

    public SplashZoomOutLayout(Context context, int i) {
        super(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(10.0f);
        setBackgroundDrawable(gradientDrawable);
        setClipToOutline(true);
        this.OooO0OO = i;
        this.OooO0oo = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() { // from class: com.ubixnow.network.gdt.SplashZoomOutLayout.1
            @Override // java.lang.Runnable
            public void run() {
                View view = (View) SplashZoomOutLayout.this.getParent();
                if (view == null) {
                    return;
                }
                int width = view.getWidth();
                int height = view.getHeight();
                SplashZoomOutLayout splashZoomOutLayout = SplashZoomOutLayout.this;
                splashZoomOutLayout.OooO0o0 = (height - splashZoomOutLayout.getHeight()) - SplashZoomOutLayout.this.OooO0OO;
                SplashZoomOutLayout splashZoomOutLayout2 = SplashZoomOutLayout.this;
                splashZoomOutLayout2.OooO0Oo = (width - splashZoomOutLayout2.getWidth()) - SplashZoomOutLayout.this.OooO0OO;
            }
        });
        ImageView imageView = new ImageView(getContext());
        addView(imageView);
        imageView.setImageResource(R.drawable.ubix_close_icon);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.ubixnow.network.gdt.SplashZoomOutLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((ViewGroup) SplashZoomOutLayout.this.getParent()).removeView(SplashZoomOutLayout.this);
            }
        });
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.gravity = 5;
        layoutParams.topMargin = oOO00000.OooO00o(10.0f);
        layoutParams.height = oOO00000.OooO00o(30.0f);
        layoutParams.width = oOO00000.OooO00o(30.0f);
        layoutParams.rightMargin = oOO00000.OooO00o(10.0f);
        imageView.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0059 A[PHI: r4
  0x0059: PHI (r4v12 int) = (r4v11 int), (r4v14 int) binds: [B:16:0x004f, B:19:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.OooO00o = getX() - motionEvent.getRawX();
            this.OooO0O0 = getY() - motionEvent.getRawY();
            this.OooO0o = 0.0f;
            this.OooO0oO = 0.0f;
        } else if (action == 1) {
            float rawX = (motionEvent.getRawX() + this.OooO00o) * 2.0f;
            float f = this.OooO0Oo;
            if (rawX <= f) {
                f = this.OooO0OO;
            }
            animate().x(f).setDuration(0L).start();
            float f2 = this.OooO0o;
            float f3 = this.OooO0oo;
            if (f2 > f3 || this.OooO0oO > f3) {
                return true;
            }
        } else if (action == 2) {
            float rawX2 = motionEvent.getRawX() + this.OooO00o;
            float rawY = motionEvent.getRawY() + this.OooO0O0;
            this.OooO0o += Math.abs(rawX2 - getX());
            this.OooO0oO += Math.abs(rawY - getY());
            int i = this.OooO0OO;
            float f4 = i;
            if (rawX2 < f4) {
                rawX2 = f4;
            } else {
                float f5 = this.OooO0Oo;
                if (rawX2 > f5) {
                    rawX2 = f5;
                }
            }
            if (rawY < f4) {
                rawY = i;
            } else {
                i = this.OooO0o0;
                if (rawY > i) {
                    rawY = i;
                }
            }
            animate().x(rawX2).y(rawY).setDuration(0L).start();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
