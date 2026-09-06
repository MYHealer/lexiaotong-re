package com.kwad.sdk.crash.online.monitor.block;

import android.os.Looper;
import android.util.Printer;
import com.kwad.sdk.utils.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private static volatile boolean beR;
    private static String beS;
    private static List<String> beT;
    private static List<String> beU;
    private static volatile boolean beV;
    private static volatile boolean beW;

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        beT = aVar.bfp;
        beU = aVar.bfq;
    }

    public static boolean bZ(boolean z) {
        List<String> list = beT;
        if (list == null || list.isEmpty()) {
            return h("Y29tLnRlbmNlbnQubWF0cml4LnRyYWNlLmNvcmUuTG9vcGVyTW9uaXRvcg==", true);
        }
        return c(beT, true);
    }

    public static boolean ca(boolean z) {
        List<String> list = beU;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return c(beU, false);
    }

    public static boolean Qw() {
        if (beR) {
            return false;
        }
        try {
            return ((Printer) ab.getField(Looper.getMainLooper(), "mLogging")) != null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e);
            beR = true;
            return false;
        }
    }

    public static boolean Qx() {
        if (beW) {
            return beV;
        }
        try {
            String str = new String(com.kwad.sdk.core.a.c.LP().decode("Y29tLnRlbmNlbnQubWF0cml4Lk1hdHJpeA=="));
            com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "hasMatrix after:".concat(str));
            if (Class.forName(str) != null) {
                return true;
            }
        } catch (ClassNotFoundException unused) {
        }
        beV = false;
        beW = true;
        return beV;
    }

    private static boolean h(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return c(arrayList, z);
    }

    private static boolean c(List<String> list, boolean z) {
        if (beR) {
            return false;
        }
        try {
            Printer printer = (Printer) ab.getField(Looper.getMainLooper(), "mLogging");
            if (printer != null) {
                beS = printer.getClass().getName();
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "originPrinter name:" + printer.getClass().getName());
                if (z) {
                    f.gz(beS);
                }
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String str = new String(com.kwad.sdk.core.a.c.LP().decode(it.next()));
                    com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "printer after:" + str);
                    if (printer.getClass().getName().contains(str)) {
                        com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "printer monitor");
                        return true;
                    }
                }
            } else {
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorDetector", "printer not hook");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e);
            beR = true;
        }
        return false;
    }
}
