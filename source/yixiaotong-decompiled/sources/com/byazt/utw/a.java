package com.byazt.utw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, 34})
public class a {
    public final ve c;
    public final List<tt> tt;
    public final c ve;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, 471})
    static final class ve {
        public final String c;
        public final String tt;
        public final String ve;

        public String toString() {
            return "RequestLine{method='" + this.c + "', path='" + this.tt + "', version='" + this.ve + "'}";
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, 480})
    public static final class tt {
        public final String c;
        public final String tt;

        public tt(String str, String str2) {
            this.c = str;
            this.tt = str2;
        }

        public String toString() {
            return "Header{name='" + this.c + "', value='" + this.tt + "'}";
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, 464})
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f2793a;
        public final int c;
        public final int n;
        public final String tt;
        public final int uj;
        public final String ve;

        public String toString() {
            return "Extra{flag=" + this.c + ", rawKey='" + this.tt + "', key='" + this.ve + "', from=" + this.uj + ", to=" + this.n + ", urls=" + this.f2793a + '}';
        }
    }

    public String toString() {
        return "Request{requestLine=" + this.c + ", headers=" + this.tt + ", extra=" + this.ve + '}';
    }
}
