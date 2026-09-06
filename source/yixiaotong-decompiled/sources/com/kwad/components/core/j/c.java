package com.kwad.components.core.j;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c {
    private Object aaW;
    private AdTemplate aaX;

    public final Object getHost() {
        return this.aaW;
    }

    public static List<AdTemplate> q(List<c> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAdTemplate());
        }
        return arrayList;
    }

    public c(AdTemplate adTemplate, int i) {
        this.aaW = null;
        try {
            this.aaW = new b(adTemplate, i);
        } catch (Throwable unused) {
            this.aaX = adTemplate;
        }
    }

    public final AdTemplate getAdTemplate() {
        AdTemplate adTemplate;
        Object obj = this.aaW;
        if (obj != null) {
            try {
                adTemplate = ((b) obj).getAdTemplate();
            } catch (Exception unused) {
                adTemplate = null;
            }
        } else {
            adTemplate = null;
        }
        return adTemplate == null ? this.aaX : adTemplate;
    }
}
