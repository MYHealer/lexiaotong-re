package com.kwad.sdk.core.local;

import android.content.Context;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {
    private static volatile a aSN;
    public static ThreadLocal<SimpleDateFormat> aSO = new ThreadLocal<SimpleDateFormat>() { // from class: com.kwad.sdk.core.local.a.1
        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ SimpleDateFormat initialValue() {
            return Md();
        }

        private static SimpleDateFormat Md() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static a LY() {
        if (aSN == null) {
            synchronized (a.class) {
                if (aSN == null) {
                    aSN = new a();
                }
            }
        }
        return aSN;
    }

    public static boolean LZ() {
        List<f> listEw = ew(15);
        if (listEw.size() == 0) {
            return true;
        }
        long j = -1;
        int i = 0;
        for (f fVar : listEw) {
            i += fVar.count;
            if (fVar.aXx > j) {
                j = fVar.aXx;
            }
        }
        c.d("AdCounter", "onBind localCountCheck: allCount: " + i + ", lastShowTime: " + j);
        if (i > Mb()) {
            return false;
        }
        return j + (Mc() * 1000) <= System.currentTimeMillis();
    }

    public static void cG(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            c.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            cH(adTemplate);
        }
    }

    public static List<f> Ma() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                f fVar = new f();
                fVar.parseJson(jSONObject);
                arrayList.add(fVar);
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (f fVar2 : arrayList) {
            if (a(fVar2)) {
                arrayList2.add(fVar2);
            }
        }
        return arrayList2;
    }

    private static List<f> ew(int i) {
        ArrayList arrayList = new ArrayList();
        List<f> listMa = Ma();
        if (listMa != null && listMa.size() != 0) {
            for (f fVar : listMa) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void g(int i, long j) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i).putLong("reward_aggregation_min_interval", j).apply();
    }

    private static int Mb() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    private static long Mc() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 1200L;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", 1200L);
    }

    private static boolean a(f fVar) {
        long j = fVar.aXx;
        if (j <= 0) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = aSO.get();
        return simpleDateFormat.format(new Date(j)).equals(simpleDateFormat.format(new Date()));
    }

    private static void cH(AdTemplate adTemplate) {
        int iEW = e.eW(adTemplate);
        int iEI = e.eI(adTemplate);
        List<f> listMa = Ma();
        if (listMa == null || listMa.size() == 0) {
            listMa = new ArrayList();
            listMa.add(new f(iEI, iEW, 1, System.currentTimeMillis()));
        } else {
            for (f fVar : listMa) {
                if (fVar.adStyle == iEI && fVar.taskType == iEW) {
                    fVar.count++;
                    if (!a(fVar)) {
                        fVar.count = 1;
                        fVar.aL(System.currentTimeMillis());
                    }
                }
            }
            listMa.add(new f(iEI, iEW, 1, System.currentTimeMillis()));
        }
        T("ksadsdk_local_ad_task_info_adstyle_data", ac.Y(listMa).toString());
        adTemplate.watched = true;
    }

    private static void T(String str, String str2) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    private static String getString(String str) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
        } catch (Throwable th) {
            c.printStackTrace(th);
            return null;
        }
    }
}
