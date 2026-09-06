package com.adprof.sdk;

import android.animation.Animator;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ql implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rl f1389a;

    public ql(rl rlVar) {
        this.f1389a = rlVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        rl rlVar = this.f1389a;
        rlVar.f1405a++;
        Runnable runnable = rlVar.f707a;
        if (runnable != null) {
            runnable.run();
        }
        if (this.f1389a.f708a) {
            pl plVar = new pl(this);
            if (fn.f1178a == null) {
                fn.f1178a = new Handler(Looper.getMainLooper());
            }
            fn.f1178a.postDelayed(new en(plVar), 300L);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
