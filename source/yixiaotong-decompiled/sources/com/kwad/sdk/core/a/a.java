package com.kwad.sdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.x;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a implements h {
    private static String sPkgId;

    @Override // com.kwad.sdk.core.a.h
    public final void h(Map<String, String> map) {
        map.put("Ks-PkgId", LM());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.a.h
    public final String ax(String str) throws Throwable {
        try {
            String strFU = x.fU(0);
            return new String(c.LN().encode(b.encrypt(strFU.getBytes("UTF-8"), b.compress(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.h
    public final String getResponseData(String str) {
        try {
            return new String(b.decompress(b.decrypt(x.fU(0), c.LP().decode(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.h
    public final void a(String str, Map<String, String> map, String str2) {
        f.a(str, map, str2);
    }

    private static String LM() {
        if (!TextUtils.isEmpty(sPkgId)) {
            return sPkgId;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        String str = context.getPackageName() + bn.getSignMd5Str(context);
        sPkgId = str;
        return str;
    }
}
