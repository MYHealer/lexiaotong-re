package com.jd.ad.sdk.jad_qd;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;
import com.kuaishou.weapon.p0.g;
import org.json.JSONObject;

/* JADX INFO: compiled from: JADLocationManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jt {

    /* JADX INFO: compiled from: JADLocationManager.java */
    public static class jad_an {
        public static final jad_jt jad_an = new jad_jt();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0026  */
    public double[] jad_an(Context context) {
        long j;
        Location lastKnownLocation;
        String str;
        synchronized (this) {
            if (context != null) {
                if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(context, g.h) == 0) {
                    com.jd.ad.sdk.jad_pc.jad_cp jad_cpVarJad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
                    if (jad_cpVarJad_cp != null) {
                        j = jad_cpVarJad_cp.jad_er;
                        if (j <= 0) {
                            j = 1800;
                        }
                    } else {
                        j = 1800;
                    }
                    long j2 = j * 1000;
                    com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                    jad_anVar.getClass();
                    Object objJad_bo = jad_anVar.jad_bo("lastRequestLocationTime");
                    if (Math.abs(System.currentTimeMillis() - ((objJad_bo == null || !(objJad_bo instanceof Long)) ? -1L : ((Long) objJad_bo).longValue())) > j2) {
                        double[] dArr = {-1.0d, -1.0d, -1.0d};
                        try {
                            String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", g.h};
                            LocationManager locationManager = (LocationManager) context.getSystemService("location");
                            if (locationManager != null) {
                                Criteria criteria = new Criteria();
                                criteria.setAccuracy(1);
                                criteria.setSpeedRequired(false);
                                criteria.setCostAllowed(false);
                                criteria.setBearingRequired(false);
                                criteria.setAltitudeRequired(false);
                                criteria.setPowerRequirement(0);
                                String bestProvider = locationManager.getBestProvider(criteria, true);
                                if (!TextUtils.isEmpty(bestProvider)) {
                                    int i = 0;
                                    while (true) {
                                        if (i >= 2) {
                                            lastKnownLocation = !TextUtils.isEmpty(bestProvider) ? locationManager.getLastKnownLocation(bestProvider) : null;
                                            if (lastKnownLocation == null) {
                                                lastKnownLocation = locationManager.getLastKnownLocation("gps");
                                            }
                                            if (lastKnownLocation == null) {
                                                lastKnownLocation = locationManager.getLastKnownLocation("network");
                                            }
                                            if (lastKnownLocation != null) {
                                                break;
                                            }
                                            str = "passive";
                                        } else if (context.checkSelfPermission(strArr[i]) == 0) {
                                            i++;
                                        } else {
                                            str = "network";
                                        }
                                        lastKnownLocation = locationManager.getLastKnownLocation(str);
                                        break;
                                    }
                                    if (lastKnownLocation != null) {
                                        dArr[0] = lastKnownLocation.getLatitude();
                                        dArr[1] = lastKnownLocation.getLongitude();
                                        dArr[2] = lastKnownLocation.getAccuracy();
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        JADLocation jADLocation = new JADLocation(dArr[0], dArr[1], dArr[2]);
                        if (jADLocation.isValid()) {
                            com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an("obtainLocationValue", jADLocation.toJSONObject().toString());
                        }
                        com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo("lastRequestLocationTime", Long.valueOf(System.currentTimeMillis()));
                    }
                }
            }
        }
        double[] dArr2 = jad_dq.jad_an;
        String strJad_an = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an("obtainLocationValue");
        if (TextUtils.isEmpty(strJad_an)) {
            return dArr2;
        }
        try {
            return JADLocation.parseJSON(new JSONObject(strJad_an)).toDoubleArray();
        } catch (Exception e2) {
            e2.printStackTrace();
            return dArr2;
        }
    }
}
