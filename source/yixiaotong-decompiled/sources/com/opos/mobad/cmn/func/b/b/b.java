package com.opos.mobad.cmn.func.b.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6806a;
    private String b;
    private int c;
    private a d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6807a;
        private int b;
        private int c;
        private int d;
        private int e;

        public int a() {
            return this.f6807a;
        }

        public void a(int i) {
            this.f6807a = i;
        }

        public int b() {
            return this.b;
        }

        public void b(int i) {
            this.b = i;
        }

        public int c() {
            return this.c;
        }

        public void c(int i) {
            this.c = i;
        }

        public int d() {
            return this.d;
        }

        public void d(int i) {
            this.d = i;
        }

        public int e() {
            return this.e;
        }

        public void e(int i) {
            this.e = i;
        }

        public String toString() {
            return "CountData{mockCount=" + this.f6807a + ", mockTouchEventCount=" + this.b + ", mockCallClickCount=" + this.c + ", mockPerformClickCount=" + this.d + ", interceptTimes=" + this.e + '}';
        }
    }

    public int getCount() {
        return this.c;
    }

    public String toString() {
        return "ViewMockEvent{posId='" + this.f6806a + "', templateId='" + this.b + "', count=" + this.c + ", countData=" + this.d + '}';
    }
}
