package com.kwad.sdk.core.response.helper;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f {
    private String aXD;

    static class a {
        private static final f aXE = new f(0);
    }

    public final String NA() {
        return this.aXD;
    }

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
        this.aXD = NB();
    }

    public static f Nz() {
        return a.aXE;
    }

    public final void fn(String str) {
        if (br.isEquals(this.aXD, str)) {
            return;
        }
        this.aXD = str;
        fo(str);
    }

    private static String NB() {
        try {
            File file = new File(bg.ej(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()));
            if (file.exists()) {
                return y.a(file, Charset.forName("UTF-8"));
            }
            return null;
        } catch (Exception e) {
            if (!com.kwad.framework.a.a.pe.booleanValue()) {
                return null;
            }
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static void fo(String str) {
        try {
            y.a(new File(bg.ej(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e) {
            if (com.kwad.framework.a.a.pe.booleanValue()) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
    }
}
