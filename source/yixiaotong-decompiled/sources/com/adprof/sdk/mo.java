package com.adprof.sdk;

import android.widget.ProgressBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class mo extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ no f1313a;

    public mo(no noVar) {
        this.f1313a = noVar;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        ProgressBar progressBar;
        long currentPositionWhenPlaying = this.f1313a.f1330a.getCurrentPositionWhenPlaying();
        long duration = this.f1313a.f1330a.getDuration();
        int i = (int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration));
        po poVar = this.f1313a.f1330a;
        int i2 = poVar.c;
        if (i2 != -1) {
            if (i2 > i) {
                return;
            } else {
                poVar.c = -1;
            }
        } else if (i != 0 && (progressBar = poVar.f601a) != null) {
            progressBar.setProgress(i);
        }
        e eVar = poVar.f602a;
        if (eVar != null) {
            eVar.onProgressUpdate(currentPositionWhenPlaying, duration);
        }
    }
}
