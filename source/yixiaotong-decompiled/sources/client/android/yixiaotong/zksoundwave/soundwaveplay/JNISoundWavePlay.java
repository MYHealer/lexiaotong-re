package client.android.yixiaotong.zksoundwave.soundwaveplay;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class JNISoundWavePlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f977a;

    public JNISoundWavePlay() {
    }

    public JNISoundWavePlay(int i) {
        init(i);
    }

    private native void init(int i);

    public void a() {
        this.f977a.a();
    }

    public void a(a aVar) {
        this.f977a = aVar;
    }

    public void b() {
        this.f977a.b();
    }

    public native void play(String str, String str2, int i);

    public native void prepareplay(String str, int i);
}
