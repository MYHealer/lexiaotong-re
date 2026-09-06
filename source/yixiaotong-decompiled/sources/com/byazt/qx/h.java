package com.byazt.qx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 163, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS})
public class h extends com.byazt.pct.n<JSONObject, JSONObject> {
    public com.byazt.omf.d c;
    public WeakReference<com.byazt.ux.tt> tt;

    public static void c(com.byazt.pct.nu nuVar, com.byazt.omf.d dVar, WeakReference<com.byazt.ux.tt> weakReference) {
        nuVar.c("pauseRewardCountDown", (com.byazt.pct.n<?, ?>) new h(dVar, weakReference));
    }

    public h(com.byazt.omf.d dVar, WeakReference<com.byazt.ux.tt> weakReference) {
        this.c = dVar;
        this.tt = weakReference;
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.byazt.ux.tt> weakReference = this.tt;
        if (weakReference != null && weakReference.get() != null) {
            this.tt.get().c();
            jSONObject2.put("success", true);
        } else {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
