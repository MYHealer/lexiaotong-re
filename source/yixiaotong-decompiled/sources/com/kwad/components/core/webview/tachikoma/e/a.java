package com.kwad.components.core.webview.tachikoma.e;

import android.text.TextUtils;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private List<Integer> auT;
    private final List<Integer> auU;

    /* JADX INFO: renamed from: com.kwad.components.core.webview.tachikoma.e.a$a, reason: collision with other inner class name */
    static class C0704a {
        private static final a auY = new a(0);
    }

    public final List<Integer> zB() {
        return this.auT;
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.auT = new ArrayList();
        this.auU = Arrays.asList(Integer.valueOf(AppTypeIdUtil.NewDevice4GBathOTA), 184, 185, Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME), 199, 200);
    }

    public static a zA() {
        return C0704a.auY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(int i) {
        if (this.auU.contains(Integer.valueOf(i))) {
            this.auT.add(Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(String str) {
        int iOptInt;
        try {
            iOptInt = new JSONObject(str).optInt("elementType");
        } catch (Exception unused) {
            iOptInt = Integer.MAX_VALUE;
        }
        if (this.auU.contains(Integer.valueOf(iOptInt))) {
            this.auT.add(Integer.valueOf(iOptInt));
        }
    }

    public final void cl(final int i) {
        by.runOnUiThread(new bi() { // from class: com.kwad.components.core.webview.tachikoma.e.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                a.this.ck(i);
            }
        });
    }

    public final void bR(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        by.runOnUiThread(new bi() { // from class: com.kwad.components.core.webview.tachikoma.e.a.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                a.this.bQ(str);
            }
        });
    }

    public final void zC() {
        this.auT.clear();
    }
}
