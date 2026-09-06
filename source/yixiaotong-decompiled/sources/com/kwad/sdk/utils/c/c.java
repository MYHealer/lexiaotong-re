package com.kwad.sdk.utils.c;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;
import com.stub.StubApp;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c extends a<com.kwad.sdk.k.a.d, Context> {
    @Override // com.kwad.sdk.utils.c.a
    protected final /* synthetic */ String dataToString(com.kwad.sdk.k.a.d dVar) {
        return a(dVar);
    }

    @Override // com.kwad.sdk.utils.c.a
    protected final /* synthetic */ com.kwad.sdk.k.a.d iA(String str) {
        return iC(str);
    }

    @Override // com.kwad.sdk.utils.c.a
    protected final /* synthetic */ com.kwad.sdk.k.a.d x(Context context) {
        return XH();
    }

    public c() {
        super("ksad_env_info");
    }

    private static String a(com.kwad.sdk.k.a.d dVar) {
        try {
            return dVar.toJson().toString();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return "";
        }
    }

    private static com.kwad.sdk.k.a.d iC(String str) {
        try {
            com.kwad.sdk.k.a.d dVar = new com.kwad.sdk.k.a.d(StubApp.getOrigApplicationContext(ServiceProvider.getContext().getApplicationContext()));
            dVar.parseJson(new JSONObject(str));
            return dVar;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    private static com.kwad.sdk.k.a.d XH() {
        return s.UE();
    }
}
