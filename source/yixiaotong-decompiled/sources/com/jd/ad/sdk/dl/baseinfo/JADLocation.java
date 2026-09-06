package com.jd.ad.sdk.dl.baseinfo;

import com.jd.ad.sdk.jad_bo.jad_bo;
import com.umeng.analytics.pro.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JADLocation {
    private double lat;
    private double lon;
    private double radius;

    public JADLocation() {
        this.lat = -1.0d;
        this.lon = -1.0d;
        this.radius = -1.0d;
    }

    public static JADLocation parseJSON(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JADLocation();
        }
        JADLocation jADLocation = new JADLocation();
        jADLocation.setLatitude(jSONObject.optDouble(d.C));
        jADLocation.setLongitude(jSONObject.optDouble("lon"));
        jADLocation.setRadius(jSONObject.optDouble("radius"));
        return jADLocation;
    }

    public double getLatitude() {
        return this.lat;
    }

    public double getLongitude() {
        return this.lon;
    }

    public double getRadius() {
        return this.radius;
    }

    public boolean isValid() {
        return (Double.compare(this.lat, -1.0d) == 0 && Double.compare(this.lon, -1.0d) == 0 && Double.compare(this.radius, -1.0d) == 0) ? false : true;
    }

    public void setLatitude(double d) {
        this.lat = d;
    }

    public void setLongitude(double d) {
        this.lon = d;
    }

    public void setRadius(double d) {
        this.radius = d;
    }

    public double[] toDoubleArray() {
        return new double[]{this.lat, this.lon, this.radius};
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(d.C, Double.valueOf(this.lat));
            jSONObject.putOpt("lon", Double.valueOf(this.lon));
            jSONObject.putOpt("radius", Double.valueOf(this.radius));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return jad_bo.jad_an("JADLocation{lat=").append(this.lat).append(", lon=").append(this.lon).append(", radius=").append(this.radius).append('}').toString();
    }

    public JADLocation(double d, double d2, double d3) {
        this.lat = d;
        this.lon = d2;
        this.radius = d3;
    }
}
