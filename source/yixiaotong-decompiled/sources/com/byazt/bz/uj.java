package com.byazt.bz;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 15})
public class uj {
    public static void c(com.byazt.bo.c cVar, String str) {
        com.byazt.eu.tt.tt("TMe_reward", "RewardUtils  ".concat(String.valueOf(str)));
        if (cVar != null) {
            com.byazt.eu.tt.tt("TMe_reward", "rewardItem.getRewardName " + cVar.ve());
            com.byazt.eu.tt.tt("TMe_reward", "rewardItem.getAmount " + cVar.tt());
            com.byazt.eu.tt.tt("TMe_reward", "rewardItem.getCustomData() " + cVar.uj());
            com.byazt.eu.tt.tt("TMe_reward", "rewardItem.rewardVerify() " + cVar.c());
            return;
        }
        com.byazt.eu.tt.tt("TMe_reward", "rewardItem is null ");
    }
}
