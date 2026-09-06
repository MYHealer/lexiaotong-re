package com.kwad.sdk.collector;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.aw;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f {
    public static JSONArray Ia() {
        Context context = ServiceProvider.getContext();
        List<g> listBG = bG(context);
        listBG.add(bF(context));
        return g.C(listBG);
    }

    private static g bF(Context context) {
        boolean zDK = aw.dK(context);
        com.kwad.sdk.core.d.c.d("InfoCollector", "queryAccessibilityServicePermission result: " + zDK);
        return new g(com.kuaishou.weapon.p0.g.k, zDK ? g.PERMISSION_GRANTED : g.PERMISSION_DENIED);
    }

    private static List<g> bG(Context context) {
        String[] strArrDi;
        int i;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (context != null && (strArrDi = aa.di(context)) != null) {
            for (String str : strArrDi) {
                int iAA = aw.aA(context, str);
                if (iAA == 0) {
                    i = g.PERMISSION_GRANTED;
                } else if (iAA == -1) {
                    i = g.PERMISSION_DENIED;
                } else {
                    i = g.aJf;
                }
                copyOnWriteArrayList.add(new g(str, i));
            }
        }
        return copyOnWriteArrayList;
    }
}
