package com.byazt.afw;

import com.baidu.mobads.sdk.internal.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, 158})
public class sl extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1969a;
    public String c;
    public String n;
    public long tt;
    public int uj;
    public long ve;

    public void c(int i) {
        this.uj = i;
    }

    public void c(long j) {
        this.tt = j;
    }

    public void c(String str) {
        this.c = str;
    }

    public void tt(long j) {
        this.ve = j;
    }

    public void tt(String str) {
        this.n = str;
    }

    public void ve(String str) {
        this.f1969a = str;
    }

    @Override // com.byazt.afw.uj
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.c);
            jSONObject.put("preload_size", this.tt);
            jSONObject.put(d.b, this.ve);
            jSONObject.put("error_code", this.uj);
            jSONObject.put("error_message", this.n);
            jSONObject.put("error_message_server", this.f1969a);
            c(jSONObject);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }
}
