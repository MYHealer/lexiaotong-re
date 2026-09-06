package com.byazt.yc;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.byazt.rb.n;
import java.util.TreeMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1136, 54})
public class ve extends c {
    public ve(Context context, com.byazt.xj.ve veVar, String str, TreeMap<Float, String> treeMap) {
        super(context, veVar, str, treeMap);
    }

    @Override // com.byazt.yc.c
    public void tt() {
        if (this.uj == n.BACKGROUND_COLOR) {
            this.n.add(Keyframe.ofInt(0.0f, this.sp.pf()));
        }
    }

    @Override // com.byazt.yc.c
    public void c(float f, String str) {
        Keyframe keyframeOfInt;
        if (this.uj == n.BACKGROUND_COLOR) {
            keyframeOfInt = Keyframe.ofInt(f, com.byazt.cd.c.c(str));
        } else {
            keyframeOfInt = Keyframe.ofInt(f, com.byazt.cd.ve.c(str, 0));
        }
        this.n.add(keyframeOfInt);
    }

    @Override // com.byazt.yc.c
    public TypeEvaluator a() {
        if (this.uj == n.BACKGROUND_COLOR) {
            return new ArgbEvaluator();
        }
        return new IntEvaluator();
    }
}
