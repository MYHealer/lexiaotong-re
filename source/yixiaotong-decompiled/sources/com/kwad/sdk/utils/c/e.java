package com.kwad.sdk.utils.c;

import android.content.Context;
import com.kwad.sdk.utils.bt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e extends a<String, Context> {
    private static String iD(String str) {
        return str;
    }

    private static String iE(String str) {
        return str;
    }

    @Override // com.kwad.sdk.utils.c.a
    protected final /* synthetic */ String dataToString(String str) {
        return iD(str);
    }

    @Override // com.kwad.sdk.utils.c.a
    protected final /* synthetic */ String iA(String str) {
        return iE(str);
    }

    @Override // com.kwad.sdk.utils.c.a
    protected final /* synthetic */ String x(Context context) {
        return eK(context);
    }

    public e() {
        super("ksad_mac_address");
    }

    private static String eK(Context context) {
        return bt.eC(context);
    }
}
