package s_a.s_a.s_a.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9755a;
    public long b;

    public f(String str, long j) {
        this.f9755a = str;
        this.b = j;
    }

    public boolean a(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.b;
        if (jCurrentTimeMillis >= j) {
            h.a("invalid");
            return false;
        }
        if (Math.abs(j - jCurrentTimeMillis) <= a.b(str)) {
            return true;
        }
        h.a("invalid");
        return false;
    }
}
