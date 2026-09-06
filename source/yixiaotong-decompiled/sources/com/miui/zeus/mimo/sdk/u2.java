package com.miui.zeus.mimo.sdk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class u2 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MotionEvent f5626a;
    public final /* synthetic */ RecyclerView b;

    public u2(v2 v2Var, MotionEvent motionEvent, RecyclerView recyclerView) {
        this.f5626a = motionEvent;
        this.b = recyclerView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f5626a.setAction(1);
        this.b.dispatchTouchEvent(this.f5626a);
        this.f5626a.recycle();
    }
}
