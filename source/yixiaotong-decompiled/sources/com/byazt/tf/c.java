package com.byazt.tf;

import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.common.util.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1042, 20})
public class c {
    public static int c = 6;
    public static tt tt = C0280c.c();

    /* JADX INFO: renamed from: com.byazt.tf.c$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 1042, 26})
    static /* synthetic */ class AnonymousClass1 {
    }

    public static int c() {
        return c;
    }

    public static boolean tt() {
        return c <= 3;
    }

    public static void c(String str) {
        c(Logger.b, str);
    }

    public static void c(String str, String str2) {
        if (str2 == null) {
            return;
        }
        tt.c(3);
    }

    public static void tt(String str, String str2) {
        if (str2 != null && tt.c(4)) {
            tt.c(str, str2);
        }
    }

    public static void ve(String str, String str2) {
        if (str2 != null && tt.c(5)) {
            tt.ve(str, str2);
        }
    }

    public static void tt(String str) {
        uj(Logger.b, str);
    }

    public static void uj(String str, String str2) {
        if (str2 != null && tt.c(6)) {
            tt.tt(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (!(str2 == null && th == null) && tt.c(6)) {
            tt.c(str, str2, th);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 1042, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static abstract class tt {
        public void c(String str, String str2) {
        }

        public void c(String str, String str2, Throwable th) {
        }

        public void tt(String str, String str2) {
        }

        public void ve(String str, String str2) {
        }

        public boolean c(int i) {
            return c.c() <= i;
        }
    }

    /* JADX INFO: renamed from: com.byazt.tf.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1042, 44})
    private static final class C0280c extends tt {

        /* JADX INFO: renamed from: com.byazt.tf.c$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 1042, 810})
        private static class C0281c {
            public static final C0280c c = new C0280c(null);
        }

        public /* synthetic */ C0280c(AnonymousClass1 anonymousClass1) {
            this();
        }

        private C0280c() {
        }

        public static C0280c c() {
            return C0281c.c;
        }

        @Override // com.byazt.tf.c.tt
        public void c(String str, String str2) {
            m.c(str, str2);
        }

        @Override // com.byazt.tf.c.tt
        public void c(String str, String str2, Throwable th) {
            m.ve(str, str2, th);
        }

        @Override // com.byazt.tf.c.tt
        public void tt(String str, String str2) {
            m.uj(str, str2);
        }

        @Override // com.byazt.tf.c.tt
        public void ve(String str, String str2) {
            m.tt(str, str2);
        }
    }
}
