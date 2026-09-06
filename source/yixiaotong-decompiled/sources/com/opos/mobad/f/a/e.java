package com.opos.mobad.f.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6891a;
    public final boolean b;
    public final String c;
    public final String d;
    public final int e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6892a;
        public boolean b;
        public String c;
        public String d;
        public int e;

        public a a(int i) {
            this.f6892a = i;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a a(boolean z) {
            this.b = z;
            return this;
        }

        public e a() {
            return new e(this);
        }

        public a b(int i) {
            this.e = i;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public String toString() {
            return "Builder{iconId=" + this.f6892a + ", autoCancel=" + this.b + ", notificationChannelId=" + this.c + ", notificationChannelName='" + this.d + "', notificationChannelImportance=" + this.e + '}';
        }
    }

    public e(a aVar) {
        this.f6891a = aVar.f6892a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
    }
}
