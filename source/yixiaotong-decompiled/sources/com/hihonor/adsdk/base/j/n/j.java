package com.hihonor.adsdk.base.j.n;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.g.j.d.d0;
import com.hihonor.adsdk.base.init.HnAdConfig;
import com.hihonor.adsdk.base.init.HnCustomController;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.common.f.r;
import com.hihonor.android.location.HnGeocoderHelperEx;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class j {
    private static final String hnadsd = "LocationUtils";
    private static final long hnadse = 600000;
    private static volatile j hnadsf;
    private volatile Address hnadsa;
    private volatile Location hnadsb;
    private final com.hihonor.adsdk.common.safe.a<Integer, b> hnadsc = new com.hihonor.adsdk.common.safe.a<>();

    private j() {
    }

    private Context hnadsc() {
        return HnAds.get().getContext();
    }

    private void hnadse() {
        HnCustomController customController;
        HnAdConfig cfg = HnAds.get().getCfg();
        if (cfg == null || (customController = cfg.getCustomController()) == null || customController.getLocation() == null) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsd, (Object) "mayRefreshCustomLocation() use media location");
        hnadsa(customController.getLocation());
    }

    public boolean hnadsa() {
        if (hnadsc() == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "checkPermission, context is null", new Object[0]);
            return false;
        }
        if (r.hnadsa(hnadsc(), "android.permission.ACCESS_FINE_LOCATION") || r.hnadsa(hnadsc(), com.kuaishou.weapon.p0.g.h)) {
            return true;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "=====NO permission=====", new Object[0]);
        return false;
    }

    public Address hnadsd() {
        hnadse();
        return this.hnadsa;
    }

    public void hnadsf() {
        hnadsb(2);
    }

    public static j hnadsb() {
        if (hnadsf == null) {
            synchronized (j.class) {
                if (hnadsf == null) {
                    hnadsf = new j();
                }
            }
        }
        return hnadsf;
    }

    private void hnadsa(double d, double d2) {
        if (hnadsc() == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "parseAddress, context is null", new Object[0]);
            return;
        }
        try {
            List<Address> listHnadsa = hnadsa(new Geocoder(hnadsc(), Locale.getDefault()).getFromLocation(d, d2, 1));
            if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) listHnadsa)) {
                return;
            }
            Address address = listHnadsa.get(0);
            this.hnadsa = address;
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsd, (Object) ("parseAddress address: " + address));
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "parseAddress, get Address error, Exception: " + e.getMessage(), new Object[0]);
        }
    }

    private boolean hnadsb(Location location) {
        if (location == null) {
            return false;
        }
        long time = location.getTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sbAppend = new StringBuilder("locationTIme=").append(time).append(" curTime").append(jCurrentTimeMillis).append(" gap=");
        long j = jCurrentTimeMillis - time;
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsd, (Object) sbAppend.append(j).toString());
        return j <= 600000;
    }

    public void hnadsb(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "startLocation type: " + i, new Object[0]);
        b bVarHnadsa = hnadsa(i);
        if (bVarHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "LocationHandler is null", new Object[0]);
        } else {
            bVarHnadsa.startLocation();
        }
    }

    private List<Address> hnadsa(List<Address> list) {
        return com.hihonor.adsdk.base.j.j.hnadsp() ? HnGeocoderHelperEx.getFromLocation(list) : list;
    }

    public void hnadsa(Location location) {
        if (location == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "handleLocation() location is null", new Object[0]);
            return;
        }
        final double latitude = location.getLatitude();
        final double longitude = location.getLongitude();
        if (this.hnadsb != null && this.hnadsb.getLatitude() == latitude && this.hnadsb.getLongitude() == longitude) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsd, (Object) "handleLocation() location is sample");
            return;
        }
        final String provider = location.getProvider();
        if (this.hnadsa != null && this.hnadsa.getLatitude() == latitude && this.hnadsa.getLongitude() == longitude) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsd, (Object) "handleLocation() Address is sample");
        } else {
            a0.hnadsh(new Runnable() { // from class: com.hihonor.adsdk.base.j.n.j$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa(latitude, longitude, provider);
                }
            });
            this.hnadsb = location;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(double d, double d2, String str) {
        hnadsa(d, d2);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "parseAddress() location and need report .", new Object[0]);
        hnadsa(str, d, d2);
    }

    private void hnadsa(String str, double d, double d2) {
        if (this.hnadsa != null) {
            com.hihonor.adsdk.base.bean.Address address = new com.hihonor.adsdk.base.bean.Address();
            address.setCountryName(this.hnadsa.getCountryName());
            address.setProvinceName(this.hnadsa.getAdminArea());
            address.setCityName(this.hnadsa.getLocality());
            address.setDistrict(this.hnadsa.getSubLocality());
            address.setStreet(this.hnadsa.getFeatureName());
            com.hihonor.adsdk.base.bean.d dVar = new com.hihonor.adsdk.base.bean.d();
            dVar.hnadsa(d);
            dVar.hnadsb(d2);
            com.hihonor.adsdk.base.bean.e eVar = new com.hihonor.adsdk.base.bean.e();
            eVar.hnadsa(address);
            eVar.hnadsa(dVar);
            new d0(str, address, dVar).hnadse();
        }
    }

    public boolean hnadsa(LocationManager locationManager, List<String> list, String str) {
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsc(str, "getLastKnownAddress =====NO_PROVIDER=====", new Object[0]);
            return true;
        }
        try {
            for (String str2 : list) {
                com.hihonor.adsdk.common.b.b.hnadsc(str, "getLocationFromCache, provider = " + str2, new Object[0]);
                Location lastKnownLocation = locationManager.getLastKnownLocation(str2);
                if (lastKnownLocation != null && hnadsb(lastKnownLocation)) {
                    com.hihonor.adsdk.common.b.b.hnadsc(str, "getLocationFromCache, use system cache location: " + lastKnownLocation.getTime(), new Object[0]);
                    hnadsa(lastKnownLocation);
                    return true;
                }
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "getLocationFromCache error msg : " + e.getMessage(), new Object[0]);
        }
        return false;
    }

    public void hnadsa(long j) {
        hnadsa(2, j);
    }

    public void hnadsa(int i, long j) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "stopLocation type: " + i, new Object[0]);
        b bVarHnadsa = hnadsa(i);
        if (bVarHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "locationHandler is null", new Object[0]);
        } else {
            bVarHnadsa.stopLocation(j);
        }
    }

    private b hnadsa(int i) {
        b bVarHnadsa = this.hnadsc.containsKey(Integer.valueOf(i)) ? this.hnadsc.get(Integer.valueOf(i)) : null;
        if (bVarHnadsa == null) {
            bVarHnadsa = c.hnadsa(i);
        }
        if (bVarHnadsa != null) {
            this.hnadsc.put(Integer.valueOf(i), bVarHnadsa);
        }
        return bVarHnadsa;
    }
}
