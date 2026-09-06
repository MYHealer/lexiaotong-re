package com.byazt.kk;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 54})
public class ve {
    public static final String c = "tt_derive" + File.separator + "lottie" + File.separator + "anim_img";
    public static final String tt = "tt_derive" + File.separator + "lottie" + File.separator + "anim_video";

    public interface c<T> {
        void c(int i, String str);

        void c(T t);
    }

    public static String c(Context context) {
        return com.byazt.nr.x.c(context, com.byazt.mf.c.c().ve().t(), c).getAbsolutePath();
    }

    public static String tt(Context context) {
        return com.byazt.nr.x.c(context, com.byazt.mf.c.c().ve().t(), tt).getAbsolutePath();
    }

    public static void c(String str, Context context, final c<File> cVar) {
        if (context == null || TextUtils.isEmpty(str)) {
            if (cVar != null) {
                cVar.c(2, "url is empty");
                return;
            }
            return;
        }
        com.byazt.va.tt ttVarUj = com.byazt.mf.c.c().ve().uj();
        if (ttVarUj == null) {
            if (cVar != null) {
                cVar.c(3, "exec is null");
            }
        } else {
            final String strC = c(context);
            final String strTt = com.byazt.nr.a.tt(str);
            ttVarUj.c(str);
            ttVarUj.c(strC, strTt);
            ttVarUj.c(new com.byazt.mh.c() { // from class: com.byazt.kk.ve.1
                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                    if (cVar != null) {
                        File file = new File(strC, strTt);
                        if (file.exists()) {
                            cVar.c(file);
                        } else {
                            cVar.c(4, "file not exist");
                        }
                    }
                }

                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, IOException iOException) {
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.c(1, "net err: " + iOException.getMessage());
                    }
                }
            });
        }
    }
}
