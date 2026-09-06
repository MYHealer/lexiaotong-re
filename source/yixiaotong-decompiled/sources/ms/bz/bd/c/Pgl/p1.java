package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.common.base.Ascii;
import com.stub.StubApp;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class p1 implements SensorEventListener {
    private static volatile p1 c;
    private SensorManager tt;
    private int ve;
    private int uj = 0;
    private float[] n = new float[3];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList f9701a = new ArrayList();

    static {
        new DecimalFormat((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "798ae3", new byte[]{118, 117, Ascii.ESC}));
        c = null;
    }

    private p1(Context context) {
        this.tt = null;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (origApplicationContext != null) {
            this.tt = (SensorManager) origApplicationContext.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e754d9", new byte[]{103, 48, 72, 83, 84, 60}));
        }
    }

    public static p1 c(Context context) {
        if (c == null) {
            synchronized (p1.class) {
                if (c == null) {
                    c = new p1(context);
                }
            }
        }
        return c;
    }

    private synchronized void n() {
        try {
            SensorManager sensorManager = this.tt;
            if (sensorManager != null) {
                int i = this.ve - 1;
                this.ve = i;
                if (i == 0) {
                    sensorManager.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "802a38", new byte[]{58, 33, 66, 42, Ascii.EM});
        }
    }

    private synchronized void uj() {
        try {
            SensorManager sensorManager = this.tt;
            if (sensorManager != null) {
                if (this.ve == 0) {
                    if (!this.tt.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.ve++;
            }
        } catch (Exception unused) {
        }
    }

    public final JSONArray c() {
        JSONArray jSONArray;
        BigDecimal bigDecimal;
        try {
            if (pble.c() == null) {
                return null;
            }
            uj();
            try {
                synchronized (this) {
                    int i = 0;
                    while (this.uj == 0 && i < 10) {
                        try {
                            i++;
                            wait(1000L);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.n[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.n[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.n[2]);
            } catch (Exception unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "367a0c", new byte[]{49, 39, 71, 42, 8});
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.n[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.n[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.n[2]);
            } finally {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(new BigDecimal(this.n[0]).setScale(2, 4));
                jSONArray2.put(new BigDecimal(this.n[1]).setScale(2, 4));
                jSONArray2.put(new BigDecimal(this.n[2]).setScale(2, 4));
                n();
                this.uj = 0;
            }
            jSONArray.put(bigDecimal.setScale(2, 4));
            return jSONArray;
        } catch (Throwable unused2) {
            return null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.n = sensorEvent.values;
        this.uj = 1;
    }

    public final synchronized void tt() {
        JSONArray jSONArrayC = c();
        if (jSONArrayC == null) {
            return;
        }
        this.f9701a.add(jSONArrayC);
        try {
            int size = this.f9701a.size();
            if (size > 100) {
                ArrayList arrayList = new ArrayList(this.f9701a.subList(size - 50, size));
                this.f9701a.clear();
                this.f9701a = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized String ve() {
        StringBuilder sb = new StringBuilder();
        int size = this.f9701a.size();
        if (size <= 0) {
            return null;
        }
        try {
            ArrayList arrayList = this.f9701a;
            int i = size - 50;
            if (i <= 0) {
                i = 0;
            }
            List<JSONArray> listSubList = arrayList.subList(i, size);
            if (listSubList.size() > 0) {
                for (JSONArray jSONArray : listSubList) {
                    if (jSONArray != null) {
                        sb.append(jSONArray.get(0).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "85f56d", new byte[]{101}));
                        sb.append(jSONArray.get(1).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "142404", new byte[]{108}));
                        sb.append(jSONArray.get(2).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8435e7", new byte[]{53}));
                    }
                }
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
