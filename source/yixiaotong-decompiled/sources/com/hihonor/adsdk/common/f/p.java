package com.hihonor.adsdk.common.f;

import android.os.SystemClock;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class p implements View.OnClickListener {
    final int hnadsa = 800;
    private final Map<Integer, Long> hnadsb = new HashMap();

    protected abstract void hnadsa(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == -1) {
            hnadsa(view);
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l = this.hnadsb.get(Integer.valueOf(id));
        if (l == null || Math.abs(jElapsedRealtime - l.longValue()) > 800) {
            this.hnadsb.put(Integer.valueOf(id), Long.valueOf(jElapsedRealtime));
            hnadsa(view);
        }
    }
}
