package com.kwad.components.core.pfmonitor.model;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public int aio;
    public List<a> aip;

    public final List<a> vs() {
        return this.aip;
    }

    public static b bf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            return bVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }
}
