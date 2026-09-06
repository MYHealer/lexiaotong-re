package com.kwad.components.core.pfmonitor;

import android.content.Context;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.by;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    private static volatile boolean aik;

    static /* synthetic */ boolean access$002(boolean z) {
        aik = true;
        return true;
    }

    public static void aF(final Context context) {
        int iKV = e.KV();
        com.kwad.sdk.core.d.c.d("DiskScanner", "startByConfig delay: " + iKV + "ms, context: " + context);
        if (iKV <= 0) {
            return;
        }
        by.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.pfmonitor.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.aG(context);
            }
        }, iKV);
    }

    public static void aG(final Context context) {
        String strKW = e.KW();
        com.kwad.sdk.core.d.c.d("DiskScanner", "startByConfig confStr: " + strKW);
        final com.kwad.components.core.pfmonitor.model.b bVarBf = com.kwad.components.core.pfmonitor.model.b.bf(strKW);
        GlobalThreadPools.NV().submit(new Runnable() { // from class: com.kwad.components.core.pfmonitor.d.2
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("DiskScanner", "startByConfig run call hadStarted: " + d.aik);
                if (d.aik) {
                    return;
                }
                d.access$002(true);
                ArrayList<com.kwad.components.core.pfmonitor.model.c> arrayList = new ArrayList();
                com.kwad.components.core.pfmonitor.model.b bVar = bVarBf;
                if (bVar != null) {
                    for (com.kwad.components.core.pfmonitor.model.a aVar : bVar.vs()) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        com.kwad.components.core.pfmonitor.model.c cVarA = d.a(context, aVar, bVarBf.aio);
                        int iCurrentTimeMillis = (int) (System.currentTimeMillis() - jCurrentTimeMillis);
                        if (cVarA != null) {
                            arrayList.add(cVarA);
                            com.kwad.sdk.core.d.c.d("DiskScanner", "startByConfig result: " + cVarA + " , duration: " + iCurrentTimeMillis);
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (com.kwad.components.core.pfmonitor.model.c cVar : arrayList) {
                    arrayList2.add(cVar.vt());
                    arrayList3.addAll(cVar.vu());
                }
                c.r(arrayList2);
                c.s(arrayList3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.kwad.components.core.pfmonitor.model.c a(Context context, com.kwad.components.core.pfmonitor.model.a aVar, int i) {
        com.kwad.components.core.pfmonitor.model.e eVarJ = com.kwad.components.core.pfmonitor.model.e.j(context, aVar.aim);
        if (eVarJ != null) {
            a aVar2 = new a(eVarJ, i);
            aVar2.run();
            if (aVar2.getStatus() == 2) {
                return aVar2.vr();
            }
        }
        return null;
    }

    public static String P(long j) {
        if (j < 1024) {
            return j + " B";
        }
        if (j < 1048576) {
            return String.format("%.1f KB", Double.valueOf(j / 1024.0d));
        }
        if (j < FileUtils.ONE_GB) {
            return String.format("%.1f MB", Double.valueOf(j / 1048576.0d));
        }
        return String.format("%.1f GB", Double.valueOf(j / 1.073741824E9d));
    }
}
