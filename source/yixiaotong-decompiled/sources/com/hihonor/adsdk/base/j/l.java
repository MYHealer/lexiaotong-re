package com.hihonor.adsdk.base.j;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.id.router.Router;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class l {
    private static final String hnadsa = "RouterUtils";
    private static final String hnadsb = "deeplinkStart";
    private static final String hnadsc = "openApp";
    private static final String hnadsd = "content://com.hihonor.mms.ads.remote";

    public static com.hihonor.adsdk.base.i.i.b hnadsa(String str, String str2) {
        Uri uri = Uri.parse("content://com.hihonor.mms.ads.remote/deeplinkStart");
        HashMap map = new HashMap(2);
        map.put(com.hihonor.adsdk.base.c.r1.hnadsd, str);
        map.put(com.hihonor.adsdk.base.c.r1.hnadse, str2);
        return hnadsa(map, uri);
    }

    private static com.hihonor.adsdk.base.i.i.b hnadsa(Map<String, Object> map, Uri uri) {
        try {
            try {
                Set<String> setKeySet = map.keySet();
                com.hihonor.adsdk.base.i.i.a aVar = new com.hihonor.adsdk.base.i.i.a();
                for (String str : setKeySet) {
                    aVar.hnadsa(str, map.get(str));
                }
                Cursor cursorQuery = Router.query(HnAds.get().getContext(), uri, null, aVar.toString(), null, null);
                if (cursorQuery == null) {
                    com.hihonor.adsdk.base.i.i.b bVarHnadsa = new com.hihonor.adsdk.base.i.i.b.a().hnadsa(1000).hnadsa("query provide,but cursor is null.").hnadsa();
                    com.hihonor.adsdk.common.f.m.hnadsa(cursorQuery);
                    return bVarHnadsa;
                }
                Bundle extras = cursorQuery.getExtras();
                if (extras == null) {
                    com.hihonor.adsdk.base.i.i.b bVarHnadsa2 = new com.hihonor.adsdk.base.i.i.b.a().hnadsa(1001).hnadsa("query provide,but bundle is null.").hnadsa();
                    com.hihonor.adsdk.common.f.m.hnadsa(cursorQuery);
                    return bVarHnadsa2;
                }
                com.hihonor.adsdk.base.i.i.b bVarHnadsa3 = new com.hihonor.adsdk.base.i.i.b.a().hnadsb(extras.getInt(com.hihonor.adsdk.base.c.r1.hnadsa)).hnadsa(extras.getInt("code")).hnadsa(extras.getString("msg")).hnadsa();
                com.hihonor.adsdk.common.f.m.hnadsa(cursorQuery);
                return bVarHnadsa3;
            } catch (Exception e) {
                String str2 = "Router query exception " + e.getMessage();
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, str2, new Object[0]);
                com.hihonor.adsdk.base.i.i.b bVarHnadsa4 = new com.hihonor.adsdk.base.i.i.b.a().hnadsa(1002).hnadsa(str2).hnadsa();
                com.hihonor.adsdk.common.f.m.hnadsa(null);
                return bVarHnadsa4;
            }
        } catch (Throwable th) {
            com.hihonor.adsdk.common.f.m.hnadsa(null);
            throw th;
        }
    }

    public static com.hihonor.adsdk.base.i.i.b hnadsa(String str) {
        Uri uri = Uri.parse("content://com.hihonor.mms.ads.remote/openApp");
        HashMap map = new HashMap(1);
        map.put(com.hihonor.adsdk.base.c.r1.hnadse, str);
        return hnadsa(map, uri);
    }
}
