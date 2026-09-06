package com.byazt.qx;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 163, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class z extends com.byazt.pct.n<JSONObject, JSONObject> {
    public WeakReference<com.byazt.omf.d> c;
    public com.byazt.ete.ic tt;

    public static void c(com.byazt.pct.nu nuVar, com.byazt.ete.ic icVar, com.byazt.omf.d dVar) {
        nuVar.c("getDeviceInfo", (com.byazt.pct.n<?, ?>) new z(dVar, icVar));
    }

    public z(com.byazt.omf.d dVar, com.byazt.ete.ic icVar) {
        this.c = new WeakReference<>(dVar);
        this.tt = icVar;
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt("safeArea", ve());
        com.byazt.ete.ic icVar = this.tt;
        if (icVar != null) {
            jSONObject2.put("disableSafeArea", icVar.d());
        }
        return jSONObject2;
    }

    private JSONObject ve() {
        com.byazt.omf.d dVar;
        Context context;
        Window window;
        View decorView;
        WindowInsets rootWindowInsets;
        WeakReference<com.byazt.omf.d> weakReference = this.c;
        if (weakReference == null || (dVar = weakReference.get()) == null || (context = dVar.getContext()) == null || !(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || (decorView = window.getDecorView()) == null || Build.VERSION.SDK_INT < 28 || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
            return null;
        }
        DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constant.MAP_KEY_TOP, displayCutout.getSafeInsetTop());
            jSONObject.put("bottom", displayCutout.getSafeInsetBottom());
            jSONObject.put(TtmlNode.LEFT, displayCutout.getSafeInsetLeft());
            jSONObject.put(TtmlNode.RIGHT, displayCutout.getSafeInsetRight());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
