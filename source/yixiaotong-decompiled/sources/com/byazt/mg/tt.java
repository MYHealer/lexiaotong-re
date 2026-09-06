package com.byazt.mg;

import android.os.Debug;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 170, 13})
public class tt {
    public static final c c = new C0212tt(null);

    /* JADX INFO: renamed from: com.byazt.mg.tt$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 170, 28})
    static /* synthetic */ class AnonymousClass1 {
    }

    @com.byazt.zqa.c(c = {0, 1, 170, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    private static class c {
        public int c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int tt(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int ve(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.byazt.mg.tt$tt, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 170, 240})
    private static class C0212tt extends c {
        private C0212tt() {
            super(null);
        }

        public /* synthetic */ C0212tt(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.byazt.mg.tt.c
        public int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.byazt.mg.tt.c
        public int tt(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.byazt.mg.tt.c
        public int ve(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return c.c(memoryInfo);
    }

    public static int tt(Debug.MemoryInfo memoryInfo) {
        return c.tt(memoryInfo);
    }

    public static int ve(Debug.MemoryInfo memoryInfo) {
        return c.ve(memoryInfo);
    }
}
