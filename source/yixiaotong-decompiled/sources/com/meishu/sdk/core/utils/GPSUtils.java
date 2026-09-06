package com.meishu.sdk.core.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GPSUtils {
    public LocationListener locationListener = new a();
    private LocationManager locationManager;
    private Context mContext;
    private b mOnLocationListener;

    public class a implements LocationListener {
        public a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (GPSUtils.this.mOnLocationListener != null) {
                GPSUtils.this.mOnLocationListener.a(location);
            }
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

    public interface b {
        void a(Location location);
    }

    public GPSUtils(Context context) {
        this.mContext = context;
    }

    public double[] getL() {
        Location location = getLocation();
        return location != null ? new double[]{location.getLatitude(), location.getLongitude()} : new double[]{0.0d, 0.0d};
    }

    public Location getLocation() {
        try {
            if (ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this.mContext, com.kuaishou.weapon.p0.g.h) != 0) {
                return null;
            }
            LocationManager locationManager = (LocationManager) this.mContext.getSystemService("location");
            this.locationManager = locationManager;
            List<String> providers = locationManager.getProviders(true);
            if (!providers.contains("gps") && !providers.contains("network")) {
                return null;
            }
            Iterator<String> it = providers.iterator();
            Location location = null;
            while (it.hasNext()) {
                Location lastKnownLocation = this.locationManager.getLastKnownLocation(it.next());
                if (lastKnownLocation != null && (location == null || lastKnownLocation.getAccuracy() < location.getAccuracy())) {
                    location = lastKnownLocation;
                }
            }
            return location;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void removeListener() {
        this.locationManager.removeUpdates(this.locationListener);
    }
}
