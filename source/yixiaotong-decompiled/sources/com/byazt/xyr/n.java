package com.byazt.xyr;

import android.content.Context;
import com.byazt.nr.zm;
import com.byazt.omf.x;
import com.byazt.sz.qy;
import com.byazt.sz.rl;
import com.byazt.sz.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_DURATION, 46})
public class n extends com.byazt.ji.tt implements qy {
    public zm sl;

    @Override // com.byazt.sz.qy
    public void c() {
    }

    @Override // com.byazt.sz.qy
    public void c(rl rlVar) {
    }

    @Override // com.byazt.sz.qy
    public void c(JSONObject jSONObject) {
    }

    @Override // com.byazt.sz.qy
    public void tt() {
    }

    @Override // com.byazt.sz.qy
    public void ve() {
    }

    public n(Context context) {
        super(context);
        this.sl = new zm(context, 2, x.m().uj());
    }

    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        this.tt.c(this);
        if (this.sl == null) {
            this.sl = new zm(this.da, 2, x.m().uj());
        }
        yp ypVarQp = this.tt.qp();
        if (ypVarQp == null) {
            return false;
        }
        Map<String, Object> mapTt = ypVarQp.tt();
        if (mapTt != null) {
            Object obj = mapTt.get("rotation_angle");
            if (obj instanceof Integer) {
                this.sl.tt(((Integer) obj).floatValue());
            }
            Object obj2 = mapTt.get("calculation_method_twist");
            if (obj2 instanceof Integer) {
                this.sl.a(((Integer) obj2).intValue());
            }
            Object obj3 = mapTt.get("twist_config");
            if (obj3 instanceof JSONObject) {
                this.sl.c((JSONObject) obj3);
            }
            Object obj4 = mapTt.get("twist_interact_conf");
            if (obj4 instanceof JSONObject) {
                this.sl.tt((JSONObject) obj4);
            }
        }
        this.sl.c(new zm.c() { // from class: com.byazt.xyr.n.1
            @Override // com.byazt.nr.zm.c
            public void c(int i) {
                if (n.this.c == null || i != 2) {
                    return;
                }
                n.this.c.c(n.this.tt, n.this.f2381a, n.this.ve.tt(), n.this.ve);
            }
        });
        return false;
    }

    private int sl() {
        JSONObject jSONObjectC;
        if (this.tt == null) {
            return 0;
        }
        JSONObject jSONObjectDa = this.tt.da();
        if (jSONObjectDa != null) {
            return jSONObjectDa.optInt("meta_hashcode", 0);
        }
        yp ypVarQp = this.tt.qp();
        if (ypVarQp == null || (jSONObjectC = ypVarQp.c()) == null) {
            return 0;
        }
        return jSONObjectC.optInt("meta_hashcode", 0);
    }

    @Override // com.byazt.sz.qy
    public void uj() {
        if (this.sl == null || !this.tt.i().isShown()) {
            return;
        }
        this.sl.c(sl());
    }

    @Override // com.byazt.sz.qy
    public void n() {
        zm zmVar = this.sl;
        if (zmVar != null) {
            zmVar.tt(sl());
        }
    }

    @Override // com.byazt.sz.qy
    public void c(boolean z) {
        zm zmVar = this.sl;
        if (zmVar != null) {
            if (z) {
                zmVar.c(sl());
            } else {
                zmVar.tt(sl());
            }
        }
    }
}
