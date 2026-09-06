package com.kwad.sdk.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class z {
    private static boolean bpe;
    private static com.kwad.sdk.utils.d.a bpf = new com.kwad.sdk.utils.d.a();

    public static com.kwad.sdk.utils.d.a dg(Context context) {
        com.kwad.sdk.utils.d.a aVar;
        com.kwad.sdk.internal.api.a aVarWf;
        com.kwad.sdk.utils.d.a aVar2 = new com.kwad.sdk.utils.d.a();
        if (be.readLocationDisable() && (aVarWf = be.Wf()) != null) {
            aVar2.bsT = aVarWf;
            aVar2.type = 1;
            return aVar2;
        }
        if (bpe || (!((aVar = bpf) == null || aVar.bsT == null) || context == null)) {
            return bpf;
        }
        if (!be.readLocationDisable() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(64L)) {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager.isProviderEnabled("gps")) {
                    bpf.bsT = a(context, locationManager);
                }
                if (bpf == null && locationManager.isProviderEnabled("network")) {
                    bpf.bsT = b(context, locationManager);
                }
                if (bpf == null && locationManager.isProviderEnabled("passive")) {
                    bpf.bsT = c(context, locationManager);
                }
                bpf.type = 0;
                return bpf;
            } catch (Exception e) {
                bpe = true;
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
        return null;
    }

    private static com.kwad.sdk.internal.api.a a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
            if (lastKnownLocation == null) {
                bpe = true;
            }
            return com.kwad.sdk.internal.api.a.a(lastKnownLocation);
        } catch (Exception e) {
            bpe = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static com.kwad.sdk.internal.api.a b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("network");
            if (lastKnownLocation == null) {
                bpe = true;
            }
            return com.kwad.sdk.internal.api.a.a(lastKnownLocation);
        } catch (Exception e) {
            bpe = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static com.kwad.sdk.internal.api.a c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
            if (lastKnownLocation == null) {
                bpe = true;
            }
            return com.kwad.sdk.internal.api.a.a(lastKnownLocation);
        } catch (Exception e) {
            bpe = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }
}
