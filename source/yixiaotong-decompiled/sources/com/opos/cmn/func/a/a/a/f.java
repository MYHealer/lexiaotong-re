package com.opos.cmn.func.a.a.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6070a;
    public final long b;
    public final String c;
    public final String d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6071a = true;
        private long b = 0;
        private String c = "";
        private String d = "";

        public f a() {
            if (this.b <= 0) {
                this.b = com.opos.cmn.func.a.b.a.a.a() ? 173525275249090560L : 183258695109709824L;
            }
            return new f(this, null);
        }
    }

    static /* synthetic */ class b {
    }

    private f(a aVar) {
        this.f6070a = aVar.f6071a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
    }

    /* synthetic */ f(a aVar, b bVar) {
        this(aVar);
    }

    public String toString() {
        return "IPv6Config{useIpv6Switcher=" + this.f6070a + ", ipv6ConfigId=" + this.b + ", channelId='" + this.c + "', buildNumber='" + this.d + "'}";
    }
}
