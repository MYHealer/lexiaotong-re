package com.opos.mobad.l;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.opos.cmn.func.a.a.d f7114a;
    public final String b;
    public final int c;
    public final String d;
    public final int e;
    public final String f;
    public final String g;

    /* JADX INFO: renamed from: com.opos.mobad.l.a$a, reason: collision with other inner class name */
    public static class C0973a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.opos.cmn.func.a.a.d f7115a;
        private String b;
        private String d;
        private String f;
        private String g;
        private int c = -1;
        private int e = 0;

        private boolean b(int i) {
            return i == 0 || 1 == i || 2 == i;
        }

        public C0973a a(int i) {
            this.c = i;
            return this;
        }

        public C0973a a(com.opos.cmn.func.a.a.d dVar) {
            this.f7115a = dVar;
            return this;
        }

        public C0973a a(String str) {
            this.b = str;
            return this;
        }

        public a a() throws Exception {
            if (this.f7115a == null) {
                throw new NullPointerException("netRequest is null.");
            }
            if (!b(this.c)) {
                throw new Exception("saveType not support!saveType must be SAVE_TYPE_OF_SDCARD or SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE");
            }
            if (this.c == 0 && com.opos.cmn.an.d.a.a(this.d)) {
                throw new NullPointerException("when saveType is SAVE_TYPE_OF_SDCARD.savePath can't be null.");
            }
            int i = this.c;
            if ((1 == i || 2 == i) && com.opos.cmn.an.d.a.a(this.g)) {
                throw new NullPointerException("when saveType is SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE.fileName can't be null.");
            }
            return new a(this);
        }

        public C0973a b(String str) {
            this.d = str;
            return this;
        }
    }

    public a(C0973a c0973a) {
        this.f7114a = c0973a.f7115a;
        this.b = c0973a.b;
        this.c = c0973a.c;
        this.d = c0973a.d;
        this.e = c0973a.e;
        this.f = c0973a.f;
        this.g = c0973a.g;
    }

    public String toString() {
        return "DownloadRequest{netRequest=" + this.f7114a + ", md5='" + this.b + "', saveType=" + this.c + ", savePath='" + this.d + "', mode=" + this.e + ", dir='" + this.f + "', fileName='" + this.g + "'}";
    }
}
