package com.byazt.jw;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import com.byazt.pm.a;
import com.byazt.xj.ve;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1216, 13})
public class tt extends com.byazt.vd.c {
    @Override // com.byazt.vd.c
    public void tt() {
    }

    public tt(ve veVar, String str, a.c cVar) {
        super(veVar, str, cVar);
    }

    @Override // com.byazt.vd.c
    public void c() {
        Object obj;
        ve veVarTt;
        if (this.f2812a == null || this.f2812a.isEmpty() || (obj = this.f2812a.get("id")) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf) || (veVarTt = this.ve.tt(this.ve)) == null) {
            return;
        }
        ve veVarUj = veVarTt.uj(strValueOf);
        if (veVarUj instanceof com.byazt.si.tt) {
            com.byazt.si.tt ttVar = (com.byazt.si.tt) veVarUj;
            ttVar.q();
            ttVar.c(new AnimatorListenerAdapter() { // from class: com.byazt.jw.tt.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    tt.this.ve();
                }
            });
        }
    }
}
