package com.opos.mobad.model.utils;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.b.a.aa;
import com.opos.mobad.b.a.ab;
import com.opos.mobad.model.c.e;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, e> f7218a = new ConcurrentHashMap();

    private static MaterialFileData a(AdItemData adItemData) {
        List<MaterialData> listI;
        MaterialData materialData;
        List<MaterialFileData> listD;
        if (adItemData == null || (listI = adItemData.i()) == null || listI.size() <= 0 || (materialData = listI.get(0)) == null || (listD = materialData.D()) == null || listD.size() <= 0) {
            return null;
        }
        return listD.get(0);
    }

    public static void a(final Context context, ab abVar) {
        final List<aa> list = abVar.ar;
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.model.utils.d.1
            @Override // java.lang.Runnable
            public void run() {
                for (aa aaVar : list) {
                    if (TextUtils.isEmpty(com.opos.cmn.d.d.a(context, aaVar.d, aaVar.e))) {
                        String strA = com.opos.cmn.d.c.a(aaVar.d);
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "sDownloadingVideoMap.size=" + d.f7218a.size());
                        if (d.f7218a.size() >= 2 || d.f7218a.containsKey(strA) || !com.opos.cmn.an.h.c.a.e(context) || com.opos.cmn.an.e.b.a.c() <= CacheValidityPolicy.MAX_AGE) {
                            com.opos.cmn.an.f.a.b("VideoCacheUtils", "don't meet cache video conditions");
                            return;
                        }
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "meet cache video conditions,cache materialFileData=" + aaVar.toString());
                        HashSet hashSet = new HashSet();
                        e eVar = new e();
                        eVar.a(aaVar.d);
                        eVar.b(aaVar.e);
                        eVar.c(com.opos.cmn.d.d.b(context, aaVar.d));
                        hashSet.add(eVar);
                        d.f7218a.put(strA, eVar);
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "cacheVideo materialFileData=" + aaVar.toString() + ",result=" + new com.opos.mobad.model.e.e(context).a(hashSet));
                        d.f7218a.remove(strA);
                        return;
                    }
                }
            }
        });
    }

    private static void a(final Context context, final MaterialFileData materialFileData) {
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.model.utils.d.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (materialFileData != null) {
                        HashSet hashSet = new HashSet();
                        e eVar = new e();
                        eVar.a(materialFileData.a());
                        eVar.b(materialFileData.b());
                        eVar.c(com.opos.cmn.d.d.b(context, materialFileData.a()));
                        hashSet.add(eVar);
                        String strA = com.opos.cmn.d.c.a(materialFileData.a());
                        d.f7218a.put(strA, eVar);
                        com.opos.cmn.an.f.a.b("VideoCacheUtils", "cacheVideo materialFileData=" + materialFileData.toString() + ",result=" + new com.opos.mobad.model.e.e(context).a(hashSet));
                        d.f7218a.remove(strA);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("VideoCacheUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static final boolean a(Context context, AdData adData) {
        if (context == null || adData == null) {
            return false;
        }
        try {
            List<AdItemData> listF = adData.f();
            if (listF == null || listF.size() <= 0) {
                return false;
            }
            for (int i = 0; i < listF.size(); i++) {
                if (1 == listF.get(i).t()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("VideoCacheUtils", "", e);
            return false;
        }
    }

    public static void b(Context context, AdData adData) {
        List<AdItemData> listF;
        com.opos.cmn.an.f.a.b("VideoCacheUtils", "cacheNextVideo");
        if (adData == null || (listF = adData.f()) == null || listF.size() <= 0) {
            return;
        }
        for (int i = 0; i < listF.size(); i++) {
            MaterialFileData materialFileDataA = a(listF.get(i));
            if (materialFileDataA != null && TextUtils.isEmpty(com.opos.cmn.d.d.a(context, materialFileDataA.a(), materialFileDataA.b()))) {
                String strA = com.opos.cmn.d.c.a(materialFileDataA.a());
                com.opos.cmn.an.f.a.b("VideoCacheUtils", "sDownloadingVideoMap.size=" + f7218a.size());
                if (f7218a.size() >= 2 || f7218a.containsKey(strA) || !com.opos.cmn.an.h.c.a.e(context) || com.opos.cmn.an.e.b.a.c() <= CacheValidityPolicy.MAX_AGE) {
                    com.opos.cmn.an.f.a.b("VideoCacheUtils", "don't meet cache video conditions");
                    return;
                } else {
                    com.opos.cmn.an.f.a.b("VideoCacheUtils", "meet cache video conditions,cache materialFileData=" + materialFileDataA.toString());
                    a(context, materialFileDataA);
                    return;
                }
            }
        }
    }
}
