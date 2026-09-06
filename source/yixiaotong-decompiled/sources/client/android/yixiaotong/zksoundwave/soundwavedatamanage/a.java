package client.android.yixiaotong.zksoundwave.soundwavedatamanage;

import client.android.yixiaotong.zksoundwave.b.b;
import client.android.yixiaotong.zksoundwave.b.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SoundWaveDataListener f976a;

    public void a(SoundWaveDataListener soundWaveDataListener) {
        this.f976a = soundWaveDataListener;
    }

    public void a(String str, int i) {
        SoundWaveDataListener soundWaveDataListener;
        if (!g.c(str) || str.length() <= 18) {
            return;
        }
        String strA = b.a(str, i);
        if (!g.c(strA) || (soundWaveDataListener = this.f976a) == null) {
            return;
        }
        soundWaveDataListener.onQrcodeData(str.substring(2, 10), strA, strA.length());
    }

    public void a(String str, String str2) {
        SoundWaveDataListener soundWaveDataListener;
        if (!g.c(str) || str.length() <= 28) {
            return;
        }
        String strB = b.b(str, str2);
        if (!g.c(strB) || (soundWaveDataListener = this.f976a) == null) {
            return;
        }
        soundWaveDataListener.onGetQrcodeData(strB);
    }
}
