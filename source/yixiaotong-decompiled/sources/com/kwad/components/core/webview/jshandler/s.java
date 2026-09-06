package com.kwad.components.core.webview.jshandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class s implements SensorEventListener, com.kwad.sdk.core.webview.c.a {
    private Map<Integer, com.kwad.sdk.core.webview.c.c> apM = new ConcurrentHashMap();

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerSensorListener";
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (!TextUtils.isEmpty(str)) {
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.apM.put(Integer.valueOf(aVar.type), cVar);
            a(aVar.type, aVar.apO, cVar);
            return;
        }
        cVar.onError(-1, "data is empty");
    }

    private void a(int i, int i2, final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.utils.bk.Wo().a(i, i2, this, new com.kwad.sdk.utils.bk.b() { // from class: com.kwad.components.core.webview.jshandler.s.1
            @Override // com.kwad.sdk.utils.bk.b
            public final void onFailed() {
                cVar.onError(-1, "sensor is not support");
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.utils.bk.Wo().a(this);
    }

    private void a(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 4) {
            type = 2;
        } else if (type == 10) {
            type = 1;
        }
        com.kwad.sdk.core.webview.c.c cVar = this.apM.get(Integer.valueOf(type));
        if (cVar != null) {
            ArrayList<Float> arrayList = new ArrayList<>();
            for (int i = 0; i < sensorEvent.values.length; i++) {
                arrayList.add(Float.valueOf(sensorEvent.values[i]));
            }
            a aVar = new a();
            aVar.apP = arrayList;
            aVar.timestamp = sensorEvent.timestamp;
            aVar.accuracy = sensorEvent.accuracy;
            cVar.b(aVar);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int accuracy;
        public int apO;
        public ArrayList<Float> apP;
        public long timestamp;
        public int type;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            int i = this.type;
            if (i != 0) {
                com.kwad.sdk.utils.ac.putValue(jSONObject, "type", i);
            }
            int i2 = this.apO;
            if (i2 != 0) {
                com.kwad.sdk.utils.ac.putValue(jSONObject, com.umeng.analytics.pro.am.aT, i2);
            }
            long j = this.timestamp;
            if (j != 0) {
                com.kwad.sdk.utils.ac.putValue(jSONObject, com.alipay.sdk.tid.b.f, j);
            }
            int i3 = this.accuracy;
            if (i3 != 0) {
                com.kwad.sdk.utils.ac.putValue(jSONObject, "accuracy", i3);
            }
            if (!this.apP.isEmpty()) {
                com.kwad.sdk.utils.ac.putValue(jSONObject, "values", this.apP);
            }
            return jSONObject;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null || jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.apO = jSONObject.optInt(com.umeng.analytics.pro.am.aT);
            this.timestamp = jSONObject.optLong(com.alipay.sdk.tid.b.f);
            this.accuracy = jSONObject.optInt("accuracy");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            ArrayList<Float> arrayList = new ArrayList<>();
            if (jSONArrayOptJSONArray == null) {
                this.apP = arrayList;
                return;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                try {
                    Object obj = jSONArrayOptJSONArray.get(i);
                    if (obj != null) {
                        arrayList.add((Float) obj);
                    }
                } catch (Throwable unused) {
                }
            }
            this.apP = arrayList;
        }
    }
}
