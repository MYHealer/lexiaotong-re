package client.android.yixiaotong.zksoundwave.soundwaverecognizer;

import android.media.AudioRecord;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class JNISoundWaveRecognizer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f978a;

    public JNISoundWaveRecognizer() {
    }

    public JNISoundWaveRecognizer(int i) {
        init(i, AudioRecord.getMinBufferSize(i, 16, 2));
    }

    private native void init(int i, int i2);

    private native void startRecognizer(int i, int i2);

    private native void stopRecognizer();

    public void a() {
        stopRecognizer();
    }

    public void a(int i, int i2) {
        startRecognizer(i, i2);
    }

    public void a(a aVar) {
        this.f978a = aVar;
    }

    public void a(String str, String str2, int i) {
        this.f978a.a(str, str2, i);
    }
}
