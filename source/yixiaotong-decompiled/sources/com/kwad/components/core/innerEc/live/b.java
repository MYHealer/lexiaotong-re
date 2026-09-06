package com.kwad.components.core.innerEc.live;

import android.app.Application;
import android.content.Context;
import com.kwad.components.core.innerEc.e;
import com.kwad.components.core.innerEc.f;
import com.kwad.components.core.innerEc.live.slide.LiveDetailActivity;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ab;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b {
    public static a Tr;
    private static AtomicBoolean Ts = new AtomicBoolean(false);

    public static void c(Application application) {
        if (Ts.get()) {
            return;
        }
        com.kwad.components.core.emotion.a.a(application);
        Ts.set(true);
    }

    public static boolean ru() {
        boolean z = false;
        try {
            if (ab.a("java.lang.String", "join", new Class[]{CharSequence.class, Iterable.class}) != null) {
                z = true;
            }
        } catch (Throwable unused) {
        }
        c.d("FullLiveModule", "checkEnv envEnable" + z);
        return z;
    }

    public static void b(Context context, final AdTemplate adTemplate, final com.kwad.components.core.e.d.a.C0661a c0661a) {
        com.kwad.components.core.innerEc.logger.a.aS(adTemplate);
        Tr = new a() { // from class: com.kwad.components.core.innerEc.live.b.1
            @Override // com.kwad.components.core.innerEc.live.a
            public final void rs() {
                c.d("FullLiveModule", "FullLiveModule onLaunchSuccess");
            }

            @Override // com.kwad.components.core.innerEc.live.a
            public final void rt() {
                c.d("FullLiveModule", "FullLiveModule onLaunchFail");
                adTemplate.setHasInnerEcFailed(true);
                com.kwad.components.core.innerEc.logger.a.l(adTemplate, "onLaunchFail");
                com.kwad.components.core.e.d.a.C0661a c0661a2 = c0661a;
                if (c0661a2 != null) {
                    f.G(c0661a2);
                }
                b.Tr = null;
            }
        };
        String string = new StringBuilder().append(e.rf().getUserId()).toString();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        adTemplate.liveInfo.kwaiUserId = string;
        adTemplate.liveInfo.deeplink = com.kwad.sdk.core.response.helper.a.da(adInfoEO);
        long jFl = com.kwad.sdk.core.response.helper.e.fl(adTemplate);
        if (com.kwad.sdk.core.response.helper.e.eI(adTemplate) == 2 && c0661a != null && c0661a.eg() == 115 && jFl != 0) {
            adTemplate.liveInfo.shopItemId = String.valueOf(jFl);
        } else {
            adTemplate.liveInfo.shopItemId = "";
        }
        LiveDetailActivity.launch(context, adTemplate.createAdResultData());
    }
}
