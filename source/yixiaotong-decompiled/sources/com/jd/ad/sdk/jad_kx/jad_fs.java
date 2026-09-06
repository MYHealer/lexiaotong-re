package com.jd.ad.sdk.jad_kx;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PreloadAdMemoryStorage.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs {
    public Map<String, ArrayList<jad_cp>> jad_an = new LinkedHashMap();
    public final List<String> jad_bo = new ArrayList();
    public final List<String> jad_cp = new ArrayList();

    /* JADX INFO: compiled from: PreloadAdMemoryStorage.java */
    public static class jad_an {
        public static final jad_fs jad_an = new jad_fs();
    }

    public ArrayList<jad_cp> jad_an(String str) {
        Map<String, ArrayList<jad_cp>> map = this.jad_an;
        ArrayList<jad_cp> arrayList = map != null ? map.get(str) : null;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        this.jad_bo.clear();
        long jCurrentTimeMillis = System.currentTimeMillis() - (((long) jad_er.jad_an.jad_an.jad_bo()) * 1000);
        Iterator<jad_cp> it = arrayList.iterator();
        while (it.hasNext()) {
            jad_cp next = it.next();
            if (next != null) {
                String str2 = next.jad_er;
                String str3 = next.jad_dq;
                String str4 = next.jad_bo;
                if (TextUtils.isEmpty(str3) || Long.parseLong(str2) < jCurrentTimeMillis) {
                    this.jad_bo.add(str4);
                    it.remove();
                }
            }
        }
        return arrayList;
    }
}
