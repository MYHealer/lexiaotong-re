package com.byazt.h;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 215})
public class yp {
    public final JSONObject c;
    public int tt;

    public int c() {
        return this.tt;
    }

    private yp(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public void c(int i) {
        this.tt = tt(i);
    }

    private int m() {
        return this.c.optInt("url_balance", 2);
    }

    public boolean tt() {
        return m() > 0;
    }

    public boolean ve() {
        return m() == 1;
    }

    public int uj() {
        return this.c.optInt("buffer_count", 512);
    }

    public int n() {
        return this.c.optInt("buffer_size", 8192);
    }

    public boolean a() {
        return this.c.optInt("segment_mode", 1) == 0;
    }

    public long sp() {
        long jOptInt = ((long) this.c.optInt("segment_min_kb", 512)) * 1024;
        return jOptInt < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : jOptInt;
    }

    public long x() {
        long jOptInt = ((long) this.c.optInt("segment_min_init_mb", 10)) * 1048576;
        return jOptInt < CacheDataSink.DEFAULT_FRAGMENT_SIZE ? CacheDataSink.DEFAULT_FRAGMENT_SIZE : jOptInt;
    }

    public long i() {
        long jOptInt = ((long) this.c.optInt("segment_max_kb", 0)) * 1048576;
        if (jOptInt < sp()) {
            return -1L;
        }
        return jOptInt;
    }

    public long da() {
        long jOptInt = this.c.optInt("connect_timeout", -1);
        if (jOptInt >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return jOptInt;
        }
        return -1L;
    }

    public long sl() {
        long jOptInt = this.c.optInt("read_timeout", -1);
        if (jOptInt >= 4000) {
            return jOptInt;
        }
        return -1L;
    }

    public int t() {
        return this.c.optInt("ip_strategy", 0);
    }

    private int tt(int i) {
        int iOptInt = this.c.optInt("thread_count", 4);
        if (iOptInt > 16) {
            iOptInt = 16;
        }
        if (iOptInt > 0) {
            return m() == 1 ? Math.min(iOptInt, i) : iOptInt;
        }
        if (m() > 0) {
            return i;
        }
        return 1;
    }

    public float u() {
        return (float) this.c.optDouble("main_ratio", 0.0d);
    }

    public int yp() {
        return this.c.optInt("ratio_segment", 0);
    }

    public float z() {
        return Math.min(Math.max(0.0f, (float) this.c.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public static yp c(JSONObject jSONObject) {
        return new yp(jSONObject);
    }
}
