package com.byazt.gqp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.yfanads.android.libs.net.UrlConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, 215})
public abstract class yp {
    public t c;

    public z a() {
        return null;
    }

    public abstract Object c();

    public void c(t tVar) {
        this.c = tVar;
    }

    public abstract com.byazt.gqp.c n();

    public abstract sp tt();

    public abstract Map<String, List<String>> uj();

    public abstract String ve();

    public c sp() {
        return new c(this);
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, 435})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z f2271a;
        public com.byazt.gqp.c c;
        public Object n;
        public a.c sp;
        public Map<String, List<String>> tt;
        public String uj;
        public sp ve;

        public c c(com.byazt.gqp.c cVar) {
            this.c = cVar;
            return this;
        }

        public c c(sp spVar) {
            this.ve = spVar;
            return this;
        }

        public c c(Object obj) {
            this.n = obj;
            return this;
        }

        public c c(String str, z zVar) {
            this.uj = str;
            this.f2271a = zVar;
            return this;
        }

        public c() {
            this.tt = new HashMap();
            this.sp = new a.c();
        }

        public c(yp ypVar) {
            this.ve = ypVar.tt();
            this.uj = ypVar.ve();
            this.tt = ypVar.uj();
            this.n = ypVar.c();
            this.f2271a = ypVar.a();
            this.c = ypVar.n();
        }

        public c c(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = UrlConst.HTTP + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = UrlConst.HTTPS + str.substring(4);
            }
            sp spVarVe = sp.ve(str);
            if (spVarVe == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            return c(spVarVe);
        }

        public c c(String str, String str2) {
            return tt(str, str2);
        }

        public c c(a aVar) {
            if (aVar != null) {
                this.tt = aVar.tt();
            }
            return this;
        }

        public c tt(String str, String str2) {
            if (!this.tt.containsKey(str)) {
                this.tt.put(str, new ArrayList());
            }
            this.tt.get(str).add(str2);
            return this;
        }

        public c c() {
            return c("GET", (z) null);
        }

        public c c(z zVar) {
            return c("POST", zVar);
        }

        public yp tt() {
            return new yp() { // from class: com.byazt.gqp.yp.c.1
                public String toString() {
                    return "";
                }

                @Override // com.byazt.gqp.yp
                public Object c() {
                    return c.this.n;
                }

                @Override // com.byazt.gqp.yp
                public sp tt() {
                    return c.this.ve;
                }

                @Override // com.byazt.gqp.yp
                public String ve() {
                    return c.this.uj;
                }

                @Override // com.byazt.gqp.yp
                public Map uj() {
                    return c.this.tt;
                }

                @Override // com.byazt.gqp.yp
                public com.byazt.gqp.c n() {
                    return c.this.c;
                }

                @Override // com.byazt.gqp.yp
                public z a() {
                    return c.this.f2271a;
                }
            };
        }
    }
}
