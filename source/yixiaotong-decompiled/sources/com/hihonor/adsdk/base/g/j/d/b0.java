package com.hihonor.adsdk.base.g.j.d;

import android.content.Context;
import com.hihonor.adsdk.base.bean.InstalledAppInfo;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b0 extends e1 {
    private List<List<InstalledAppInfo>> hnadse;
    private final int hnadsf;

    public b0(Context context, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        super(str, aVar);
        this.hnadse = null;
        this.hnadsf = 100;
        this.hnadse = com.hihonor.adsdk.base.j.b.hnadsa(context, 100);
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public String hnadsa() {
        return com.hihonor.adsdk.base.g.j.e.b.f3509a;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public int hnadsc() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.j.d.e1
    public void hnadse() {
        for (List<InstalledAppInfo> list : this.hnadse) {
            if (list != null && list.size() > 0) {
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(this.hnadsd);
                linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.a.o, com.hihonor.adsdk.base.j.g.hnadsa(list));
                super.hnadsa(linkedHashMap);
            }
        }
    }
}
