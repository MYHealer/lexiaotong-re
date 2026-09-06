package com.byazt.pct;

import android.text.TextUtils;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.NewDevice4GDrinkOTA_1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class z {
    public final Map<String, Object> c = new ConcurrentHashMap();

    public static z c() {
        return new z();
    }

    private z() {
    }

    public z c(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.c.put(str, obj);
        }
        return this;
    }

    public String tt() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.c.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}
