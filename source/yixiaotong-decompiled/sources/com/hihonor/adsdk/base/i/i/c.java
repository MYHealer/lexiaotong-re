package com.hihonor.adsdk.base.i.i;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.common.f.m;
import com.hihonor.id.router.Router;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final String hnadsa = "RouterUtils";
    private static final String hnadsb = "deeplinkStart";
    private static final String hnadsc = "openApp";
    private static final String hnadsd = "content://com.hihonor.mms.ads.remote";

    public static b hnadsa(String str, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "call remote start deeplink packageName:" + str2, new Object[0]);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("call remote start deeplink deeplinkUrl:" + str));
        Uri uri = Uri.parse("content://com.hihonor.mms.ads.remote/deeplinkStart");
        HashMap map = new HashMap(2);
        map.put(com.hihonor.adsdk.base.c.r1.hnadsd, str);
        map.put(com.hihonor.adsdk.base.c.r1.hnadse, str2);
        return hnadsa(map, uri, 1001);
    }

    private static b hnadsa(Map<String, Object> map, Uri uri, int i) {
        try {
            try {
                Set<String> setKeySet = map.keySet();
                a aVar = new a();
                for (String str : setKeySet) {
                    aVar.hnadsa(str, map.get(str));
                }
                Cursor cursorQuery = Router.query(HnAds.get().getContext(), uri, null, aVar.toString(), null, null);
                if (Objects.isNull(cursorQuery)) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "call remote start fail.cause by cursor is null.command=" + i, new Object[0]);
                    b bVarHnadsa = new b.a().hnadsa(1000).hnadsc(1).hnadsa("query provide,but cursor is null.").hnadsa();
                    m.hnadsa(cursorQuery);
                    return bVarHnadsa;
                }
                Bundle extras = cursorQuery.getExtras();
                if (Objects.isNull(extras)) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "call remote start fail.cause by extras is null.command=" + i, new Object[0]);
                    b bVarHnadsa2 = new b.a().hnadsa(1001).hnadsc(1).hnadsa("query provide,but bundle is null.").hnadsa();
                    m.hnadsa(cursorQuery);
                    return bVarHnadsa2;
                }
                b bVarHnadsa3 = new b.a().hnadsb(extras.getInt(com.hihonor.adsdk.base.c.r1.hnadsa)).hnadsa(extras.getInt("code")).hnadsc(1).hnadsa(extras.getString("msg")).hnadsa();
                m.hnadsa(cursorQuery);
                return bVarHnadsa3;
            } catch (Exception e) {
                String str2 = "Router query exception " + e.getMessage();
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, str2, new Object[0]);
                b bVarHnadsa4 = new b.a().hnadsa(1002).hnadsc(1).hnadsa(str2).hnadsa();
                m.hnadsa(null);
                return bVarHnadsa4;
            }
        } catch (Throwable th) {
            m.hnadsa(null);
            throw th;
        }
    }

    public static b hnadsa(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "call remote start activity packageName:" + str, new Object[0]);
        Uri uri = Uri.parse("content://com.hihonor.mms.ads.remote/openApp");
        HashMap map = new HashMap(1);
        map.put(com.hihonor.adsdk.base.c.r1.hnadse, str);
        return hnadsa(map, uri, 1002);
    }
}
