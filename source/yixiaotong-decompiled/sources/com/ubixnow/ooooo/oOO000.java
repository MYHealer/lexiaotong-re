package com.ubixnow.ooooo;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.ubixnow.utils.BaseUtils;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOO000 {
    private static oOO000 OooO00o;
    private Context OooO0O0;
    private LocationManager OooO0OO;
    private String OooO0Oo = "Asia/Shanghai";
    public double[] OooO0o0 = {0.0d, 0.0d};

    private oOO000(Context context) {
        this.OooO0O0 = context;
    }

    public static oOO000 OooO00o(Context context) {
        if (OooO00o == null) {
            OooO00o = new oOO000(context);
        }
        return OooO00o;
    }

    public static String OooO0O0() {
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.getID();
        String displayName = timeZone.getDisplayName();
        timeZone.getDisplayName();
        timeZone.getRawOffset();
        return displayName;
    }

    public static long OooO0OO() {
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.getID();
        timeZone.getDisplayName();
        timeZone.getDisplayName();
        return timeZone.getRawOffset();
    }

    public Location OooO00o() {
        try {
            if (BaseUtils.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && BaseUtils.getContext().checkSelfPermission(com.kuaishou.weapon.p0.g.h) == 0) {
                LocationManager locationManager = (LocationManager) this.OooO0O0.getSystemService("location");
                this.OooO0OO = locationManager;
                List<String> providers = locationManager.getProviders(true);
                if (providers.contains("gps") && this.OooO0OO.getLastKnownLocation("gps") != null) {
                    return this.OooO0OO.getLastKnownLocation("gps");
                }
                if (providers.contains("network") && this.OooO0OO.getLastKnownLocation("network") != null) {
                    return this.OooO0OO.getLastKnownLocation("network");
                }
                if (providers.contains("passive") && this.OooO0OO.getLastKnownLocation("passive") != null) {
                    return this.OooO0OO.getLastKnownLocation("passive");
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
