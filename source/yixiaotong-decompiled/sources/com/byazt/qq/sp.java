package com.byazt.qq;

import android.app.Activity;
import com.byazt.ete.g;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 88, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends c {
    @Override // com.byazt.qq.tt
    public int sp() {
        return 4;
    }

    public sp(Activity activity, ic icVar, g gVar) {
        super(activity, icVar, gVar);
    }

    @Override // com.byazt.qq.tt
    public boolean a() {
        return this.f2664a;
    }

    @Override // com.byazt.qq.c, com.byazt.qq.tt
    public tt.c tt(da daVar) {
        return ve(daVar);
    }

    @Override // com.byazt.qq.tt
    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "参与互动可以领取福利");
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject.toString();
    }
}
