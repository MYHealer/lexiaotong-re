package com.byazt.vm;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 165, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public final class sp {
    public static tt<m> c = new tt<m>() { // from class: com.byazt.vm.sp.1
        @Override // com.byazt.vm.tt
        /* JADX INFO: renamed from: ve, reason: merged with bridge method [inline-methods] */
        public m c(Object... objArr) {
            return new m((Context) objArr[0]);
        }
    };

    public static void c(Context context) {
        c.tt(context).tt();
    }

    public static String c(SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        return uj.c(sharedPreferences);
    }

    public static Map<String, String> c(Context context, SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        m mVarTt = c.tt(context);
        return mVarTt.c(mVarTt.c() instanceof t ? 200 : 100);
    }

    public static String c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    public static void c(com.byazt.gj.n nVar) {
        m.c(nVar);
    }
}
