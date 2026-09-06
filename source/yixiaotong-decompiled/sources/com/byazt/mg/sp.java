package com.byazt.mg;

import android.app.ActivityManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 170, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {
    public static final c c = new tt(null);

    /* JADX INFO: renamed from: com.byazt.mg.sp$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 170, 135})
    static /* synthetic */ class AnonymousClass1 {
    }

    @com.byazt.zqa.c(c = {0, 1, 170, 180})
    private static class c {
        public long c(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }

        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 170, 904})
    private static class tt extends c {
        private tt() {
            super(null);
        }

        public /* synthetic */ tt(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.byazt.mg.sp.c
        public long c(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    public static long c(ActivityManager.MemoryInfo memoryInfo) {
        return c.c(memoryInfo);
    }
}
