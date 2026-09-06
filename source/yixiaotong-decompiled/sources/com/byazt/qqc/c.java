package com.byazt.qqc;

import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ubixnow.ooooo.oOOOoo00;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_MAXDURATION, 20})
public abstract class c {
    public abstract boolean c(int i);

    public abstract void tt(int i);

    public abstract boolean tt();

    public abstract JSONObject uj();

    public abstract boolean ve();

    public int c() {
        JSONObject jSONObjectUj = uj();
        if (jSONObjectUj == null) {
            return 0;
        }
        double dOptDouble = jSONObjectUj.optDouble(oOOOoo00.OooOo0o, 0.0d);
        int iOptInt = jSONObjectUj.optInt("plan");
        if (iOptInt == 1) {
            return dOptDouble == 0.0d ? 0 : 1;
        }
        return iOptInt;
    }

    public boolean ve(int i) {
        int iC = c();
        if (iC == 0 || tt() || ve() || a(i)) {
            return false;
        }
        return c(iC);
    }

    public static boolean uj(int i) {
        return (c(gt.tt().mm(), i) ^ true) || (c(gt.tt().pn(), i) ^ true);
    }

    private static boolean c(JSONObject jSONObject, int i) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("valid_type")) == null || jSONArrayOptJSONArray.length() == 0) {
            return true;
        }
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            if (i == jSONArrayOptJSONArray.optInt(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean a(int i) {
        return c(uj(), i);
    }

    public void n(int i) {
        int iC = c();
        if (iC == 0 || tt() || ve() || a(i)) {
            return;
        }
        tt(iC);
    }

    public static double c(double d, JSONObject jSONObject) {
        double dOptDouble = jSONObject.optDouble("min_value", -1.0d);
        double dOptDouble2 = jSONObject.optDouble("max_value", 1.0d);
        if (d > dOptDouble2) {
            return dOptDouble2;
        }
        return d < dOptDouble ? dOptDouble : d;
    }
}
