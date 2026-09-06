package com.byazt.fs;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 720, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BARRAGE_MASK})
public class sv {
    public static com.byazt.jx.my c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        String strNextString = null;
        com.byazt.jx.my.c cVarC = null;
        com.byazt.kd.tt ttVarC = null;
        com.byazt.kd.tt ttVarC2 = null;
        com.byazt.kd.tt ttVarC3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    ttVarC2 = uj.c(jsonReader, aVar, false);
                    break;
                case "m":
                    cVarC = com.byazt.jx.my.c.c(jsonReader.nextInt());
                    break;
                case "o":
                    ttVarC3 = uj.c(jsonReader, aVar, false);
                    break;
                case "s":
                    ttVarC = uj.c(jsonReader, aVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.jx.my(strNextString, cVarC, ttVarC, ttVarC2, ttVarC3, zNextBoolean);
    }
}
