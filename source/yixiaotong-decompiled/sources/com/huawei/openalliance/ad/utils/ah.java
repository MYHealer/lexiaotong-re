package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.ads.fh;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LocationServices;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ah {
    private static final long B = 5000;
    private static final String I = "LocationUtils";
    private static final long Z = 30000;
    private FusedLocationProviderClient C;
    LocationCallback Code;
    private volatile boolean F = false;
    private a S;
    LocationRequest V;

    public interface a {
        void Code();

        void Code(Location location);
    }

    public ah(Context context, final a aVar) {
        if (context == null || aVar == null) {
            return;
        }
        this.S = aVar;
        this.C = LocationServices.getFusedLocationProviderClient(context);
        LocationRequest locationRequest = new LocationRequest();
        this.V = locationRequest;
        locationRequest.setPriority(100);
        this.V.setNumUpdates(1);
        this.V.setInterval(5000L);
        this.Code = new LocationCallback() { // from class: com.huawei.openalliance.ad.utils.ah.1
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                if (locationAvailability != null) {
                    fh.Code(ah.I, "loc_tag onLocationResult onLocationAvailability isLocationAvailable: %s", Boolean.valueOf(locationAvailability.isLocationAvailable()));
                }
            }

            public void onLocationResult(LocationResult locationResult) {
                String str;
                fh.Code(ah.I, "loc_tag getLocationByKit onLocationResult-callback");
                if (locationResult == null) {
                    str = "loc_tag getLocationByKit onLocationResult-callback is null";
                } else {
                    if (!ag.Code(locationResult.getLocations())) {
                        Location location = (Location) locationResult.getLocations().get(0);
                        if (location != null) {
                            fh.Code(ah.I, "loc_tag getLocationByKit onLocationResult-callback lat = " + bl.Code(String.valueOf(location.getLatitude())) + ", lon = " + bl.Code(String.valueOf(location.getLongitude())));
                            aVar.Code(location);
                        } else {
                            str = "loc_tag getLocationByKit onLocationResult-callback location is null";
                        }
                        ah.this.F = true;
                    }
                    str = "loc_tag getLocationByKit onLocationResult-callback getLocations() is wrong";
                }
                fh.I(ah.I, str);
                aVar.Code();
                ah.this.F = true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (this.F) {
            return;
        }
        try {
            this.C.removeLocationUpdates(this.Code).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.huawei.openalliance.ad.utils.ah.6
                @Override // com.huawei.hmf.tasks.OnSuccessListener
                /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r2) {
                    fh.Code(ah.I, "loc_tag removeLocationUpdates onSuccess");
                    ah.this.F = true;
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.huawei.openalliance.ad.utils.ah.5
                @Override // com.huawei.hmf.tasks.OnFailureListener
                public void onFailure(Exception exc) {
                    fh.Code(ah.I, "loc_tag removeLocationUpdates onFailure:%s", exc.getClass().getSimpleName());
                    ah.this.F = false;
                }
            });
        } catch (Throwable th) {
            fh.I(I, "loc_tag removeLocationUpdates encounter exception:" + th.getClass().getSimpleName());
        }
    }

    public void Code() {
        if (this.C == null) {
            return;
        }
        this.F = false;
        this.C.requestLocationUpdates(this.V, this.Code, Looper.getMainLooper()).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.huawei.openalliance.ad.utils.ah.3
            @Override // com.huawei.hmf.tasks.OnSuccessListener
            /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r2) {
                fh.V(ah.I, "loc_tag requestLocationUpdates onSuccess");
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.huawei.openalliance.ad.utils.ah.2
            @Override // com.huawei.hmf.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                fh.Z(ah.I, "loc_tag requestLocationUpdates onFailure");
                ah.this.S.Code();
                ah.this.F = true;
            }
        });
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ah.4
            @Override // java.lang.Runnable
            public void run() {
                if (ah.this.F) {
                    return;
                }
                ah.this.V();
            }
        }, Z);
    }
}
