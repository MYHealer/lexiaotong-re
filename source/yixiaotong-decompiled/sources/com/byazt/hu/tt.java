package com.byazt.hu;

import android.os.AsyncTask;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1381, 13})
public class tt {
    public static final c c = new C0176tt(null);

    /* JADX INFO: renamed from: com.byazt.hu.tt$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 1381, 28})
    static /* synthetic */ class AnonymousClass1 {
    }

    @com.byazt.zqa.c(c = {0, 1, 1381, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    private static class c {
        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        public <T> void c(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(com.byazt.jtc.tt.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.hu.tt$tt, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1381, 240})
    private static class C0176tt extends c {
        private C0176tt() {
            super(null);
        }

        public /* synthetic */ C0176tt(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.byazt.hu.tt.c
        public <T> void c(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void c(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        c.c(asyncTask, tArr);
    }
}
