package com.byazt.xd;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.byazt.cd.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2857a;
    public com.byazt.cd.c.C0123c c;
    public tt i;
    public com.byazt.cd.c.C0123c n;
    public float sp;
    public com.byazt.cd.c.C0123c tt;
    public int uj;
    public int ve;
    public int x;

    public boolean c() {
        return (this.c == null && this.tt == null) ? false : true;
    }

    public boolean tt() {
        return (this.c == null && this.tt == null && this.n == null) ? false : true;
    }

    public void c(String str) {
        if (com.byazt.cd.c.ve(str)) {
            this.c = com.byazt.cd.c.tt(str);
        }
    }

    public void tt(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("gradient", null);
            if (strOptString == null || !com.byazt.cd.c.ve(strOptString)) {
                return;
            }
            this.tt = com.byazt.cd.c.tt(strOptString);
            this.ve = jSONObject.optInt("duration", 2200);
            this.uj = jSONObject.optInt("playCount", -1);
        } catch (JSONException unused) {
        }
    }

    public void c(String str, Context context) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("gradient", null);
            if (strOptString == null || !com.byazt.cd.c.ve(strOptString)) {
                return;
            }
            this.n = com.byazt.cd.c.tt(strOptString);
            this.f2857a = x.c(context, (float) jSONObject.optDouble("width", 76.0d));
            this.sp = (float) jSONObject.optDouble("opacity", 0.9d);
            this.x = jSONObject.optInt("steps", 24);
        } catch (JSONException unused) {
        }
    }

    public void c(View view, Drawable drawable, float f, float[] fArr) {
        int[] iArr;
        float[] fArr2;
        int[] iArr2;
        float[] fArr3;
        boolean z = c() && f > 0.0f;
        boolean z2 = this.n != null;
        if (!z && !z2) {
            this.i = null;
            view.setBackground(drawable);
            return;
        }
        if (z) {
            com.byazt.cd.c.C0123c c0123c = this.tt;
            if (c0123c != null) {
                iArr2 = c0123c.tt;
                fArr3 = this.tt.ve;
            } else {
                iArr2 = this.c.tt;
                fArr3 = this.c.ve;
            }
            iArr = iArr2;
            fArr2 = fArr3;
        } else {
            iArr = null;
            fArr2 = null;
        }
        tt ttVar = new tt(drawable, iArr, fArr2, f, fArr, this.tt != null, this.ve, this.uj, z2, this.f2857a, this.sp, this.x, z2 ? this.n.tt : null, z2 ? this.n.ve : null);
        this.i = ttVar;
        view.setBackground(ttVar);
    }

    public void ve() {
        tt ttVar = this.i;
        if (ttVar == null || !ttVar.ve()) {
            return;
        }
        this.i.c();
    }

    public void uj() {
        tt ttVar = this.i;
        if (ttVar != null) {
            ttVar.tt();
        }
    }
}
