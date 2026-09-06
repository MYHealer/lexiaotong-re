package com.byazt.a;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 34, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends c {
    public sp(Context context, com.byazt.k.c cVar, String str) {
        super(context, cVar, str);
    }

    @Override // com.byazt.a.n
    public Intent tt() {
        Intent intent = new Intent(com.byazt.ev.n.ve + ".filemanager.intent.action.BROWSER_FILE");
        intent.putExtra("CurrentDir", this.ve);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
