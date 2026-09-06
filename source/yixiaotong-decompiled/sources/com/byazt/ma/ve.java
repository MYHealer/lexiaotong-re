package com.byazt.ma;

import android.view.View;
import android.view.ViewGroup;
import com.byazt.aas.cu;
import com.byazt.ete.ic;
import com.byazt.ete.p;
import com.byazt.ete.u;
import com.byazt.omf.gt;
import com.byazt.sy.PlayableFeedWebView;
import com.byazt.sy.sp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_MASTER_CLOCK_BY_PTS, 54})
public class ve extends com.byazt.sy.tt {
    public final sp n;
    public PlayableFeedWebView uj;

    @Override // com.byazt.sy.tt
    public sp c() {
        return this.n;
    }

    public ve(ic icVar, com.byazt.sy.c cVar) {
        super(icVar, cVar);
        this.n = new sp() { // from class: com.byazt.ma.ve.1
            @Override // com.byazt.sy.sp
            public void c(int i) {
            }

            @Override // com.byazt.sy.sp
            public void n() {
            }

            @Override // com.byazt.sy.sp
            public void c() {
                if (ve.this.uj != null) {
                    ve.this.uj.a();
                }
            }

            @Override // com.byazt.sy.sp
            public void c(boolean z) {
                if (ve.this.uj != null) {
                    ve.this.uj.c(z);
                }
            }

            @Override // com.byazt.sy.sp
            public void tt() {
                if (ve.this.uj != null) {
                    ve.this.uj.sp();
                }
            }

            @Override // com.byazt.sy.sp
            public void ve() {
                if (ve.this.uj != null) {
                    ve.this.uj.x();
                }
            }

            @Override // com.byazt.sy.sp
            public void uj() {
                if (p.c() && ve.this.ve != null) {
                    ve.this.ve.c(ve.this.c);
                }
            }
        };
        this.ve = new com.byazt.kyz.c(icVar, tt());
    }

    public boolean c(ViewGroup viewGroup, View view) {
        if (tt() == null || view == null || viewGroup == null) {
            com.byazt.sy.ve.c(this.c, tt(), false, 5);
            return false;
        }
        if (!p.ve(this.c)) {
            com.byazt.sy.ve.c(this.c, tt(), false, 6);
            return false;
        }
        if (com.byazt.sy.uj.c(viewGroup)) {
            String name = viewGroup.getClass().getName();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("container_name", name);
                jSONObject.put("enable_layout_restrict", gt.tt().bj());
            } catch (JSONException unused) {
            }
            com.byazt.sy.ve.c(this.c, tt(), false, 1, jSONObject);
            return false;
        }
        if (com.byazt.sy.uj.c(this.c, false)) {
            return true;
        }
        com.byazt.sy.ve.c(this.c, tt(), false, 2);
        return false;
    }

    public void tt(final ViewGroup viewGroup, final View view) {
        if (!c(viewGroup, view)) {
            com.byazt.rgb.a.c(com.byazt.ip.sp.c(this.c), 2);
            return;
        }
        com.byazt.rgb.a.c(com.byazt.ip.sp.c(this.c), 1);
        com.byazt.sy.ve.c(this.c, tt(), true);
        this.uj = new PlayableFeedWebView(this.ve, viewGroup);
        this.ve.c(this.uj);
        this.uj.setMaterialMeta(cu.c(this.c));
        this.uj.setEasyPlayableListener(this.tt);
        viewGroup.post(new Runnable() { // from class: com.byazt.ma.ve.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.sy.ve.tt(ve.this.c, ve.this.tt(), true);
                ve veVar = ve.this;
                veVar.c(viewGroup, view, veVar.uj, (float[]) null);
            }
        });
    }

    public void ve() {
        PlayableFeedWebView playableFeedWebView = this.uj;
        if (playableFeedWebView != null) {
            playableFeedWebView.destroy();
        }
    }

    @Override // com.byazt.sy.tt
    public u tt() {
        return p.sp(this.c);
    }
}
