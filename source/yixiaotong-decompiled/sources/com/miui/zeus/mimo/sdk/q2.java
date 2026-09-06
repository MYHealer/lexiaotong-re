package com.miui.zeus.mimo.sdk;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v2 f5569a;

    public q2(v2 v2Var) {
        this.f5569a = v2Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        v2 v2Var = this.f5569a;
        v2Var.a((ViewGroup) v2Var.s, true);
        v2 v2Var2 = this.f5569a;
        RecyclerView recyclerView = v2Var2.s;
        y6 y6Var = new y6();
        v2Var2.v = y6Var;
        y6Var.a(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new s2(v2Var2, recyclerView));
    }
}
