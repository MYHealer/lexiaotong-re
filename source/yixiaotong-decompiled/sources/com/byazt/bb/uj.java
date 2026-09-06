package com.byazt.bb;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.aas.zb;
import com.byazt.ete.ic;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 147, 15})
public class uj extends c {
    public final boolean t;

    public uj(com.byazt.eia.sp spVar, Context context, String str, com.byazt.yzg.ve veVar, String str2, boolean z, Map<String, Object> map, boolean z2) {
        this.c = spVar;
        this.ve = context;
        this.uj = str;
        this.n = veVar;
        this.f1996a = str2;
        this.sl = z;
        this.tt = map;
        this.t = z2;
    }

    @Override // com.byazt.bb.c
    public com.byazt.wrq.c n(final Map<String, Object> map) {
        final int iUj = c.uj(map);
        com.byazt.qt.ve.c(this.uj, this.uj, this.c.q_(), iUj);
        map.put("action_type_button", 2);
        if (this.c != null && !TextUtils.isEmpty(this.c.uj())) {
            map.put("id", Long.valueOf(Double.valueOf(this.c.uj()).longValue()));
        }
        if (!ve(iUj)) {
            ve(map);
            return null;
        }
        com.byazt.wrq.c cVar = new com.byazt.wrq.c() { // from class: com.byazt.bb.uj.1
            @Override // com.byazt.ou.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z) {
            }

            @Override // com.byazt.ou.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
                if (map == null) {
                    return;
                }
                com.byazt.qt.ve.c(0, iUj);
                uj.this.n.c(uj.this.tt(iUj));
                map.remove("downloadButtonClickListener");
                if (uj.this.c((com.byazt.ete.uj) null, (com.byazt.wrq.c) null, map)) {
                    return;
                }
                uj.this.ve(map);
            }
        };
        com.byazt.qt.ve.c(map, cVar);
        return cVar;
    }

    @Override // com.byazt.bb.c
    public boolean ve(int i) {
        return this.da != null && com.byazt.qt.ve.c(this.da, i) == 2;
    }

    @Override // com.byazt.bb.c
    public com.byazt.wrq.uj c(Map<String, Object> map, final zb<String, Object> zbVar) {
        final int iUj = c.uj(zbVar);
        return new com.byazt.wrq.uj() { // from class: com.byazt.bb.uj.2
            @Override // com.byazt.wrq.uj
            public void onItemClick() {
                if (!uj.this.x && !uj.this.c.x_()) {
                    if (uj.this.t) {
                        com.byazt.ppf.ve.c(uj.this.tt(), uj.this.ve, uj.this.uj, (Map<String, Object>) null, (com.byazt.nd.n) null);
                        return;
                    } else {
                        if (uj.this.c instanceof ic) {
                            new com.byazt.szt.c((ic) uj.this.c, uj.this.ve, uj.this.uj, nb.uj(uj.this.uj), new HashMap(), null, null).c(new HashMap());
                            return;
                        }
                        return;
                    }
                }
                com.byazt.qt.ve.tt(1, iUj);
                zbVar.remove("itemClickListener");
                uj.this.da.apply(com.byazt.yxi.uj.c().c(17).c(Void.class).c(0, zbVar).tt());
            }
        };
    }
}
