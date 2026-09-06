package com.kwad.components.core.b;

import android.graphics.Color;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public String Pc = null;
    public String Pd = null;
    public String title;

    public final String getTitle() {
        return this.title;
    }

    public static b c(JSONObject jSONObject) {
        b bVar = new b();
        bVar.parseJson(jSONObject);
        return bVar;
    }

    public b() {
    }

    public b(String str) {
        this.title = str;
    }

    public final int oG() {
        try {
            String str = this.Pc;
            if (str != null) {
                return Color.parseColor(str);
            }
            return -1;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return -1;
        }
    }

    public final int oH() {
        try {
            String str = this.Pd;
            if (str != null) {
                return Color.parseColor(str);
            }
            return -1;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return -1;
        }
    }
}
