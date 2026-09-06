package android.client.bluetoothsdk.socket;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class Device {
    private final String mAddress;
    private final String mName;
    private final boolean mPaired;

    public String getAddress() {
        return this.mAddress;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isPaired() {
        return this.mPaired;
    }

    public Device(String str, String str2, boolean z) {
        this.mName = str;
        this.mAddress = str2;
        this.mPaired = z;
    }
}
