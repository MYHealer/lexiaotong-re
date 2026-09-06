package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {
    private final String bvd;
    private final LinkedList<d> bve;
    private int bvf;
    private final int bvg;
    private long bvh;

    final String getName() {
        return this.bvd;
    }

    c(String str) {
        this(str, 10);
    }

    c(String str, int i) {
        this.bvd = str == null ? "" : str;
        this.bve = new LinkedList<>();
        this.bvg = Math.min(i, 30);
        this.bvh = System.currentTimeMillis();
    }

    synchronized JSONObject iN(String str) {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<d> it = this.bve.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().Yr());
            }
            jSONObject.put("session_id", str);
            jSONObject.put("segment_name", this.bvd);
            jSONObject.put("spans", jSONArray);
            this.bvh = System.currentTimeMillis();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public synchronized d iM(String str) {
        d dVar;
        if (this.bve.size() >= this.bvg) {
            this.bve.removeFirst();
        }
        StringBuilder sbAppend = new StringBuilder().append(str).append("_");
        int i = this.bvf;
        this.bvf = i + 1;
        dVar = new d(sbAppend.append(i).toString());
        this.bve.addLast(dVar);
        this.bvh = System.currentTimeMillis();
        return dVar;
    }

    public final synchronized long Ys() {
        return this.bvh;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.bvd.equals(((c) obj).bvd);
    }

    public int hashCode() {
        return Objects.hash(this.bvd);
    }
}
