package com.yfanads.android.adx.service;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.kuaishou.weapon.p0.g;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: LocationService.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Location f9615a;
    public LocationManager b;
    public volatile boolean c = false;
    public final a d;

    /* JADX INFO: compiled from: LocationService.java */
    public class a implements LocationListener {
        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            C1175b.f9616a.f9615a = location;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            YFLog.high("onProviderDisabled");
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
            YFLog.high("onProviderEnabled");
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
            YFLog.high("onStatusChanged");
        }
    }

    /* JADX INFO: renamed from: com.yfanads.android.adx.service.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LocationService.java */
    public static final class C1175b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9616a = new b();
    }

    public b() {
        try {
            this.d = new a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context, String str) {
        if (ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(context, g.h) == 0) {
            this.b.requestLocationUpdates(str, 1000L, 10.0f, this.d);
        }
    }

    public final void b(final Context context, final String str) {
        try {
            if (!this.c) {
                com.yfanads.android.adx.utils.a.c("requestLocationUpdates isUpdLocation start." + this.d);
                this.c = true;
                if (this.d != null) {
                    com.yfanads.android.adx.utils.b.b.post(new Runnable() { // from class: com.yfanads.android.adx.service.b$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(context, str);
                        }
                    });
                    return;
                }
                return;
            }
            com.yfanads.android.adx.utils.a.c("requestLocationUpdates isUpdLocation is starting, return.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
