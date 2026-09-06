package com.hihonor.adsdk.common.b.i;

import android.util.Log;
import com.hihonor.adsdk.common.b.g;
import com.hihonor.adsdk.common.f.a0;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b implements g {
    private static final String hnadsc = "b";
    private static final int hnadsd = 65536;
    private static final int hnadse = 30;
    private volatile int hnadsa = 0;
    private final CopyOnWriteArrayList<String> hnadsb = new CopyOnWriteArrayList<>();

    static class a implements Runnable {
        private final CopyOnWriteArrayList<String> hnadsd;

        public a(CopyOnWriteArrayList<String> copyOnWriteArrayList) {
            this.hnadsd = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        }

        @Override // java.lang.Runnable
        public void run() {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = this.hnadsd;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                Log.w(b.hnadsc, "WriterTask#run cache bucket or folder is null");
            } else if (com.hihonor.adsdk.common.b.j.a.hnadsa((String[]) this.hnadsd.toArray(new String[0]))) {
                this.hnadsd.clear();
            }
        }
    }

    public b() {
        com.hihonor.adsdk.common.d.b.hnadsa().hnadsa(new Runnable() { // from class: com.hihonor.adsdk.common.b.i.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsb();
            }
        }, 30L, 30L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsb() {
        if (this.hnadsb.isEmpty()) {
            Log.w(hnadsc, "DiskLogStrategy#scheduleCheckCacheRunnable#cache bucket is empty.");
        } else {
            hnadsc();
        }
    }

    private synchronized void hnadsc() {
        String str = hnadsc;
        Log.i(str, "DiskLogStrategy#write log to disk");
        Log.i(str, "DiskLogStrategy#current bucket size is " + (this.hnadsa / 1024) + "kb");
        a0.hnadsb(new a(this.hnadsb));
        this.hnadsa = 0;
        this.hnadsb.clear();
    }

    @Override // com.hihonor.adsdk.common.b.g
    public void hnadsa(int i, String str, String str2) {
        int length = this.hnadsa + str2.getBytes().length;
        if (length >= 65536) {
            hnadsc();
        }
        this.hnadsb.add(str2);
        this.hnadsa = length;
        Log.i(hnadsc, "DiskLogStrategy#add log to bucket");
    }
}
