package com.byazt.ds;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.cons.b;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f2113a;
    public final Context n;

    public sp(Context context, x xVar) {
        super(false, false);
        this.n = context;
        this.f2113a = xVar;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME);
        jSONObject.put(com.hihonor.adsdk.base.g.j.e.a.hnadsz, "7.5.0.0.baseChina-alpha.3");
        jSONObject.put("channel", this.f2113a.sl());
        i.c(jSONObject, "aid", this.f2113a.da());
        i.c(jSONObject, "release_build", this.f2113a.yv());
        i.c(jSONObject, "app_region", this.f2113a.u());
        i.c(jSONObject, "app_language", this.f2113a.t());
        i.c(jSONObject, b.b, this.f2113a.p());
        i.c(jSONObject, "ab_sdk_version", this.f2113a.z());
        i.c(jSONObject, "ab_version", this.f2113a.my());
        i.c(jSONObject, "aliyun_uuid", this.f2113a.tt());
        String strZm = this.f2113a.zm();
        if (!TextUtils.isEmpty(strZm)) {
            try {
                jSONObject.put("app_track", new JSONObject(strZm));
            } catch (Throwable th) {
                com.byazt.yv.da.tt(th);
            }
        }
        String strYp = this.f2113a.yp();
        if (strYp != null && strYp.length() > 0) {
            jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, new JSONObject(strYp));
        }
        i.c(jSONObject, "user_unique_id", this.f2113a.m());
        return true;
    }
}
