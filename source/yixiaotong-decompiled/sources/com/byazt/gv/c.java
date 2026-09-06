package com.byazt.gv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 20})
public class c {
    public static volatile c c;
    public static volatile ThreadPoolExecutor tt;
    public static volatile ScheduledExecutorService uj;
    public static volatile ThreadPoolExecutor ve;
    public static final ConcurrentHashMap<String, ve> n = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ve> f2274a = new ConcurrentHashMap<>();

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    private c() {
        tt = n.c();
        ve = n.tt();
        uj = n.ve();
    }

    public void c(ve veVar) {
        if (veVar == null) {
            throw new IllegalArgumentException("param is not be null");
        }
        if (tt != null) {
            tt.execute(veVar);
        }
    }
}
