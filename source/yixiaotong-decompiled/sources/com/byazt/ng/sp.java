package com.byazt.ng;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import client.android.yixiaotong.util.TimeUtils;
import com.byazt.vx.qy;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends c {
    public static final SimpleDateFormat uj = new SimpleDateFormat(TimeUtils.FORMATDATETIME, Locale.US);

    public sp(String str, JSONObject jSONObject) {
        super(str, jSONObject);
    }

    public static sp c(Context context, uj ujVar, JSONObject jSONObject) {
        return new sp(UUID.randomUUID().toString(), tt(context, ujVar, jSONObject));
    }

    private static JSONObject tt(Context context, uj ujVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(NotificationCompat.CATEGORY_EVENT, ujVar.c);
            jSONObject2.putOpt("params", jSONObject);
            jSONObject2.putOpt("nt", Integer.valueOf(qy.tt()));
            jSONObject2.putOpt("datetime", uj.format(new Date()));
        } catch (Exception e) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("params");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("event_extra");
                    if (!TextUtils.isEmpty(strOptString)) {
                        JSONObject jSONObject3 = new JSONObject(strOptString);
                        jSONObject3.putOpt("v3_err_msg", e.toString());
                        jSONObjectOptJSONObject.putOpt("event_extra", jSONObject3.toString());
                    }
                }
                if (ujVar != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.putOpt("v3_eventId", ujVar.gu.get(com.hihonor.adsdk.base.g.j.e.a.v));
                    jSONObject4.putOpt("v3_err_msg", e.toString());
                }
            } catch (Throwable unused) {
            }
        }
        return jSONObject2;
    }

    @Override // com.byazt.ng.c
    public String toString() {
        return "AdEventV3{localId='" + this.c + "', event=" + this.tt + '}';
    }
}
