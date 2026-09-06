package org.videolan.libvlc;

import android.content.Context;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.stub.StubApp;
import ijiami_1011.s.s.s;
import java.util.ArrayList;
import org.videolan.libvlc.util.HWDecoderUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class LibVLC extends VLCObject<Event> {
    private static final String TAG = s.d(new byte[]{110, 121, 117, 77, 47, 92, 3, 50, 42, 33}, "856bc5");
    private static boolean sLoaded;
    public final Context mAppContext;

    public static class Event extends VLCEvent {
        public Event(int i) {
            super(i);
        }
    }

    public LibVLC(Context context) {
        this(context, null);
    }

    public LibVLC(Context context, ArrayList<String> arrayList) {
        this.mAppContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        loadLibraries();
        arrayList = arrayList == null ? new ArrayList<>() : arrayList;
        boolean z = true;
        boolean z2 = true;
        for (String str : arrayList) {
            z = str.startsWith(s.d(new byte[]{72, Ascii.RS, 84, 94, 77, 16, 92}, "e3518d")) ? false : z;
            z2 = str.startsWith(s.d(new byte[]{Ascii.EM, Ascii.NAK, 7, 88, 82, 16, 14, 13, 2, 79, 85, 12, 71, 72, 10, 87, 79, 79, 2, 12, Ascii.DC4, 13, 92, 4}, "48f66b")) ? false : z2;
            if (!z && !z2) {
                break;
            }
        }
        if (z || z2) {
            if (z) {
                arrayList.add(HWDecoderUtil.getAudioOutputFromDevice() == HWDecoderUtil.AudioOutput.OPENSLES ? s.d(new byte[]{Ascii.RS, Ascii.RS, 81, 11, 67, 77, 92, 11, Ascii.SYN, 7, 95, Ascii.SYN, 95, 86, 67}, "330d69") : s.d(new byte[]{73, Ascii.NAK, 86, 92, 19, 70, 92, 5, 8, 6, 67, 10, 13, 92, 104, 82, 19, 86, 8, 11, Ascii.DC2, 16, 80, 6, 15}, "d873f2"));
            }
            if (z2) {
                arrayList.add(s.d(new byte[]{Ascii.EM, Ascii.RS, 84, 8, 86, 16, 14, 13, 2, 79, 85, 12, 71, 67, 89, 7, 75, 79, 2, 12, Ascii.DC4, 13, 92, 4}, "435f2b"));
                arrayList.add(s.d(new byte[]{98, 48, 87, 14}, "0ff877"));
            }
        }
        nativeNew((String[]) arrayList.toArray(new String[arrayList.size()]), context.getDir(s.d(new byte[]{66, 15, 0}, "4ccd12"), 0).getAbsolutePath());
    }

    public static synchronized void loadLibraries() {
        if (!sLoaded) {
            sLoaded = true;
            try {
                System.loadLibrary(s.d(new byte[]{82, 81, 93, Ascii.DC4, 93, 85, 62, 2, 9, 16, 110, 8, 93, 71, 92, 5, 65, 87, 19, Ascii.ETB, 2, 9}, "470d82"));
                System.loadLibrary(s.d(new byte[]{Ascii.DC2, 95, 85, 15, 90, 11}, "d36e4b"));
                System.loadLibrary(s.d(new byte[]{12, 8, 12, 89, 9, 3, 5, 1, Ascii.DC4}, "ffe5fb"));
            } catch (SecurityException e) {
                Log.e(TAG, s.d(new byte[]{39, 88, 5, 90, 71, 95, Ascii.NAK, 1, Ascii.DC4, 7, 85, 69, 3, Ascii.SYN, Ascii.NAK, 80, 81, 68, 19, 13, Ascii.DC2, Ascii.ESC, 17, 12, 17, 69, 19, 80, Ascii.DC2, 70, 9, 1, 8, 66, 93, 10, 3, 82, 15, 91, 85, 17, Ascii.ETB, 8, 5, 8, 95, 12, 66, 90, 15, 87, SignedBytes.MAX_POWER_OF_TWO, 80, 19, Ascii.GS, 92, 66}, "b6f521") + e);
                System.exit(1);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, s.d(new byte[]{112, 84, 86, Ascii.DC2, 16, 16, 13, 11, 7, 6, 17, 19, 95, 86, 82, 91, 13, 16, 13, 13, 4, 16, 80, Ascii.ETB, 74, 15, Ascii.CAN}, "3585d0") + e2);
                System.exit(1);
            }
        }
    }

    private native void nativeNew(String[] strArr, String str);

    private native void nativeRelease();

    private native void nativeSetUserAgent(String str, String str2);

    public native String changeset();

    public native String compiler();

    @Override // org.videolan.libvlc.VLCObject
    public /* bridge */ /* synthetic */ boolean isReleased() {
        return super.isReleased();
    }

    @Override // org.videolan.libvlc.VLCObject
    public Event onEventNative(int i, long j, long j2, long j3, long j4, float f, String str) {
        return null;
    }

    @Override // org.videolan.libvlc.VLCObject
    public void onReleaseNative() {
        nativeRelease();
    }

    public void setUserAgent(String str, String str2) {
        nativeSetUserAgent(str, str2);
    }

    public native String version();
}
