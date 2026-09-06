package com.adprof.sdk;

import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import com.bykv.vk.component.ttvideo.ILivePlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class zd implements hl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocationListener f1555a = new yd();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile LocationManager f909a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f910a = "network";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public jl f911a = jl.STOP;

    public zd() {
        LocationManager locationManagerA;
        if (he.m644a() == null || (locationManagerA = a()) == null) {
            return;
        }
        Criteria criteria = new Criteria();
        criteria.setAccuracy(2);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(false);
        criteria.setPowerRequirement(1);
        f910a = locationManagerA.getBestProvider(criteria, false);
    }

    public static LocationManager a() {
        if (f909a == null) {
            synchronized (zd.class) {
                if (f909a == null) {
                    f909a = he.m644a().m646a();
                }
            }
        }
        return f909a;
    }

    @Override // com.adprof.sdk.hl
    /* JADX INFO: renamed from: a */
    public boolean mo652a() {
        String str;
        jl jlVar = this.f911a;
        jl jlVar2 = jl.RUNNING;
        if (jlVar == jlVar2) {
            return false;
        }
        try {
            LocationManager locationManagerA = a();
            if (locationManagerA == null || (str = f910a) == null || !locationManagerA.isProviderEnabled(str)) {
                return true;
            }
            pk.a("---startUpdateLocation");
            locationManagerA.requestLocationUpdates(f910a, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 10.0f, f1555a);
            this.f911a = jlVar2;
            return true;
        } catch (Throwable th) {
            pk.b("LocationService startUpdateLocation error: ", th);
            return true;
        }
    }

    @Override // com.adprof.sdk.hl
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo737a() {
        if (this.f911a == jl.RUNNING) {
            try {
                if (f909a != null) {
                    f909a.removeUpdates(f1555a);
                }
                f909a = null;
            } catch (Throwable th) {
                pk.b("LocationService stopUpdatalocation error: ", th);
            }
            this.f911a = jl.STOP;
        }
    }
}
