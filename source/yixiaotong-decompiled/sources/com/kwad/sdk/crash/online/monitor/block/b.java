package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import com.ubix.ssp.open.UBiXWinPlatform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    private static List<String> bfb = null;
    private static List<String> bfc = null;
    private static int bfd = 5;

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        bfb = new ArrayList();
        if (aVar.bfo != null && !aVar.bfo.isEmpty()) {
            bfb.addAll(aVar.bfo);
        } else {
            bfb.add("com.kwad");
            bfb.add("com.kwai");
            bfb.add("com.ksad");
            bfb.add("tkruntime");
            bfb.add("tachikoma");
            bfb.add(UBiXWinPlatform.PLATFORM_KS);
        }
        bfd = aVar.bft;
        bfc = new ArrayList();
        if (aVar.bfn != null && !aVar.bfn.isEmpty()) {
            bfc.addAll(aVar.bfn);
            return;
        }
        bfc.add("android.");
        bfc.add("androidx.");
        bfc.add("org.");
        bfc.add("java.");
    }

    private static boolean gu(String str) {
        List<String> list = bfc;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean gv(String str) {
        List<String> list = bfb;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String gw(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split(IOUtils.LINE_SEPARATOR_UNIX);
        com.kwad.sdk.core.d.c.d("perfMonitor.Filter", "stacks after split:" + strArrSplit.length);
        boolean z = false;
        int i = 0;
        for (String str2 : strArrSplit) {
            if (z || !gu(str2)) {
                if (i >= bfd) {
                    return "";
                }
                if (gv(str2)) {
                    return str;
                }
                i++;
                z = true;
            }
        }
        return "";
    }
}
