package com.byazt.eg;

import com.huawei.openalliance.ad.constant.ai;
import com.yfanads.android.libs.net.UrlConst;
import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 16, ai.y})
public final class yv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public md f2148a;
    public final my c;
    public final Object n;
    public volatile uj sp;
    public final String tt;
    public final p uj;
    public final rh ve;

    public my c() {
        return this.c;
    }

    public Object n() {
        return this.n;
    }

    public String tt() {
        return this.tt;
    }

    public p uj() {
        return this.uj;
    }

    public rh ve() {
        return this.ve;
    }

    public yv(c cVar) {
        this.c = cVar.c;
        this.tt = cVar.tt;
        this.ve = cVar.ve.c();
        this.uj = cVar.uj;
        this.n = cVar.n != null ? cVar.n : this;
        if (cVar.f2149a != null) {
            this.f2148a = cVar.f2149a;
        } else {
            this.f2148a = new md();
        }
    }

    public String c(String str) {
        return this.ve.c(str);
    }

    public c a() {
        return new c(this);
    }

    public uj sp() {
        uj ujVar = this.sp;
        if (ujVar != null) {
            return ujVar;
        }
        uj ujVarC = uj.c(this.ve);
        this.sp = ujVarC;
        return ujVarC;
    }

    public boolean x() {
        return this.c.uj();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Request{method=").append(this.tt).append(", url=").append(this.c).append(", tag=");
        Object obj = this.n;
        if (obj == this) {
            obj = null;
        }
        return sbAppend.append(obj).append('}').toString();
    }

    @com.byazt.zqa.c(c = {0, 1, 16, 2028})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public md f2149a;
        public my c;
        public Object n;
        public String tt;
        public p uj;
        public rh.c ve;

        public c c(Object obj) {
            this.n = obj;
            return this;
        }

        public c() {
            this.tt = "GET";
            this.ve = new rh.c();
        }

        public c(yv yvVar) {
            this.c = yvVar.c;
            this.tt = yvVar.tt;
            this.uj = yvVar.uj;
            this.n = yvVar.n;
            this.ve = yvVar.ve.tt();
            this.f2149a = yvVar.f2148a;
        }

        public c c(my myVar) {
            if (myVar == null) {
                throw new NullPointerException("url == null");
            }
            this.c = myVar;
            return this;
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
            my myVarN = my.n(str);
            if (myVarN == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            return c(myVarN);
        }

        public c c(URL url) {
            if (url == null) {
                throw new NullPointerException("url == null");
            }
            my myVarC = my.c(url);
            if (myVarC == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(url)));
            }
            return c(myVarC);
        }

        public c c(String str, String str2) {
            this.ve.ve(str, str2);
            return this;
        }

        public c tt(String str, String str2) {
            this.ve.c(str, str2);
            return this;
        }

        public c tt(String str) {
            this.ve.tt(str);
            return this;
        }

        public c c(rh rhVar) {
            this.ve = rhVar.tt();
            return this;
        }

        public c c(uj ujVar) {
            String string = ujVar.toString();
            return string.isEmpty() ? tt("Cache-Control") : c("Cache-Control", string);
        }

        public c delete(p pVar) {
            return c("DELETE", pVar);
        }

        public c delete() {
            return delete(com.byazt.kh.ve.uj);
        }

        public c c(String str, p pVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (pVar != null && !com.byazt.yx.a.ve(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (pVar == null && com.byazt.yx.a.tt(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.tt = str;
            this.uj = pVar;
            return this;
        }

        public yv c() {
            if (this.c == null) {
                throw new IllegalStateException("url == null");
            }
            return new yv(this);
        }
    }
}
