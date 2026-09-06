package com.byazt.bb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.byazt.eia.i;
import com.byazt.ete.ic;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 147, 34})
public class a implements com.byazt.hl.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f1995a;
    public com.byazt.hl.c c;
    public Map<String, Object> i;
    public int n;
    public Map<String, Object> sp;
    public Context tt;
    public String uj;
    public String ve;
    public i x;

    public static boolean c(int i) {
        switch (i) {
            case 101:
            case 102:
            case 103:
            case 104:
                return true;
            default:
                return false;
        }
    }

    public void c(View view) {
        this.f1995a = view;
    }

    public void tt(int i) {
        this.n = i;
    }

    public void tt(Map<String, Object> map) {
        this.sp = map;
    }

    public a(i iVar, Context context, String str, String str2, Map<String, Object> map) {
        this.x = iVar;
        this.tt = context;
        this.ve = str;
        this.uj = str2;
        this.i = map;
        tt();
    }

    @Override // com.byazt.hl.c
    public boolean c(Map<String, Object> map) {
        boolean zC = c();
        tt();
        if (zC) {
            return true;
        }
        HashMap map2 = new HashMap(2);
        map2.put("event_tag", this.ve);
        if (!TextUtils.isEmpty(this.uj)) {
            map2.put("dpa_tag", this.uj);
        }
        map2.put("material_meta", ve());
        int iC = com.byazt.apd.tt.c().c(this.tt, this.x, map2) & 255;
        ve(iC);
        if (iC == 0) {
            return true;
        }
        com.byazt.hl.c cVar = this.c;
        return cVar != null && cVar.c(map);
    }

    private boolean c() {
        if (this.n < 2) {
            return false;
        }
        HashMap map = new HashMap(2);
        if (c(this.n)) {
            map.put("live_saas_param_interaction_type", Integer.valueOf(this.n));
        }
        if (this.i.containsKey("saas_status_while_click")) {
            map.put("saas_status_while_click", this.i.get("saas_status_while_click"));
        }
        map.put("event_tag", this.ve);
        String str = this.uj;
        if (str != null) {
            map.put("dpa_tag", str);
        }
        map.put("material_meta", ve());
        if (this.sp == null) {
            this.sp = new HashMap();
        }
        com.byazt.apd.tt.c().c(this.f1995a, this.x.sl(), map, this.sp);
        int iC = com.byazt.apd.tt.c().c(this.tt, this.x, map);
        int i = iC & 255;
        int i2 = (iC & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (i2 > 0) {
            this.sp.put("click_saas_action", Integer.valueOf(i2));
        }
        return i == 0;
    }

    private void tt() {
        i iVar = this.x;
        if (iVar != null) {
            this.n = iVar.n();
        } else {
            this.n = -1;
        }
    }

    private ic ve() {
        return com.byazt.ppf.ve.c(this.x, this.i);
    }

    private void ve(int i) {
        com.byazt.cr.uj ujVar;
        if (i == 0) {
            ujVar = com.byazt.cr.uj.ve;
        } else if (i == 1) {
            ujVar = com.byazt.cr.uj.n;
        } else if (i == 3) {
            ujVar = com.byazt.cr.uj.sp;
        } else if (i == 4) {
            ujVar = com.byazt.cr.uj.f2060a;
        } else {
            ujVar = com.byazt.cr.uj.uj;
        }
        com.byazt.ppf.ve.c(this.i, ujVar);
    }
}
