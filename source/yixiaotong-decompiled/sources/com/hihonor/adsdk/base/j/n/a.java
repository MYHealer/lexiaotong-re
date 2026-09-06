package com.hihonor.adsdk.base.j.n;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.common.f.a0;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a implements b {
    protected static final long hnadsb = 120000;
    protected static final long hnadsc = 100;
    protected LocationManager hnadsa;

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.j.n.a$a, reason: collision with other inner class name */
    protected class C0442a implements LocationListener {
        private final String hnadsa;

        public C0442a(String str) {
            this.hnadsa = str;
        }

        public String hnadsa() {
            return this.hnadsa;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            com.hihonor.adsdk.common.b.b.hnadsc(a.this.hnadsc(), "==onLocationChanged==::provider:" + this.hnadsa, new Object[0]);
            j.hnadsb().hnadsa(location);
            a.this.hnadsa(location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    protected Context hnadsa() {
        return HnAds.get().getContext();
    }

    protected abstract void hnadsa(Location location);

    protected LocationManager hnadsb() {
        if (hnadsa() == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsc(), "getLocationManager, getContext is null", new Object[0]);
            return null;
        }
        try {
            return (LocationManager) hnadsa().getSystemService("location");
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc(), "getLocationManager, Exception: " + e.getMessage(), new Object[0]);
            new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.GET_LOCATION_MANAGER_ERR_CODE, ErrorCode.GET_LOCATION_MANAGER__ERR_MSG + e.getMessage()).hnadse();
            return null;
        }
    }

    protected abstract String hnadsc();

    protected boolean hnadsd() {
        if (j.hnadsb().hnadsa()) {
            return true;
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsc(), "prepareRequestLocationCheck, no permission", new Object[0]);
        return false;
    }

    protected void hnadsa(final LocationManager locationManager, final String str, final long j, final float f, final LocationListener locationListener) {
        if (locationManager == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsc(), "requestLocation, locationManager is null", new Object[0]);
        } else if (locationListener == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsc(), "requestLocation, listener is null", new Object[0]);
        } else {
            a0.hnadsg(new Runnable() { // from class: com.hihonor.adsdk.base.j.n.a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa(str, locationManager, j, f, locationListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(String str, LocationManager locationManager, long j, float f, LocationListener locationListener) {
        if (!hnadsd()) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsc(), "requestLocation, no permission", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc(), "=====requestLocationUpdates=====" + str, new Object[0]);
        try {
            locationManager.requestLocationUpdates(str, j, f, locationListener);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc(), "requestLocation, =====requestLocationUpdates exception! msg : %s ===== ", e.getMessage());
            new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.REQUEST_LOCATION_ERR_CODE, ErrorCode.REQUEST_LOCATION_ERR_MSG + e.getMessage()).hnadse();
        }
    }

    protected void hnadsa(LocationManager locationManager, LocationListener... locationListenerArr) {
        if (!Objects.isNull(locationManager) && !Objects.isNull(locationListenerArr)) {
            for (LocationListener locationListener : locationListenerArr) {
                if (locationListener != null) {
                    try {
                        locationManager.removeUpdates(locationListener);
                    } catch (Exception e) {
                        com.hihonor.adsdk.common.b.b.hnadsb(hnadsc(), "removeLocationUpdatesListener, removeUpdates Exception: " + e.getMessage(), new Object[0]);
                        new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.REMOVE_LOCATION_ERR_CODE, ErrorCode.REMOVE_LOCATION_ERR_MSG + e.getMessage()).hnadse();
                    }
                }
            }
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsc(), "removeLocationUpdatesListener, locationManager or listener is null", new Object[0]);
    }

    protected void hnadsa(LocationListener locationListener, LocationListener locationListener2) {
        if (!hnadsd()) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsc(), "defaultStartLocationStrategy, no permission", new Object[0]);
            return;
        }
        LocationManager locationManagerHnadsb = hnadsb();
        this.hnadsa = locationManagerHnadsb;
        if (locationManagerHnadsb == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsc(), "defaultStartLocationStrategy, mLocationManager is null", new Object[0]);
            return;
        }
        try {
            List<String> providers = locationManagerHnadsb.getProviders(true);
            if (j.hnadsb().hnadsa(this.hnadsa, providers, hnadsc())) {
                return;
            }
            if (providers.contains("gps")) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsc(), "=====GPS_PROVIDER=====", new Object[0]);
                hnadsa(this.hnadsa, "gps", hnadsb, 100.0f, locationListener);
            }
            if (providers.contains("network")) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsc(), "=====NETWORK_PROVIDER=====", new Object[0]);
                hnadsa(this.hnadsa, "network", hnadsb, 100.0f, locationListener2);
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc(), "defaultStartLocationStrategy exception! msg : %s", e.getMessage());
            new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.REQUEST_LOCATION_ERR_CODE, ErrorCode.REQUEST_LOCATION_ERR_MSG + e.getMessage()).hnadse();
        }
    }

    protected void hnadsa(long j, Runnable runnable) {
        if (runnable == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc(), "generalStopLocation, task is null", new Object[0]);
        } else if (j <= 0) {
            runnable.run();
        } else {
            a0.hnadsa(runnable, j);
        }
    }
}
