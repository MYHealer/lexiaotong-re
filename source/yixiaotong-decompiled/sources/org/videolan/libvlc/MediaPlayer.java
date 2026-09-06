package org.videolan.libvlc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;
import java.io.File;
import org.videolan.libvlc.util.AndroidUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class MediaPlayer extends VLCObject<Event> {
    private final AudioDeviceCallback mAudioDeviceCallback;
    private boolean mAudioDigitalOutputEnabled;
    private String mAudioOutput;
    private String mAudioOutputDevice;
    private String mAudioPlugOutputDevice;
    private final BroadcastReceiver mAudioPlugReceiver;
    private boolean mAudioPlugRegistered;
    private boolean mAudioReset;
    private boolean mListenAudioPlug;
    private Media mMedia;
    private boolean mPlayRequested;
    private boolean mPlaying;
    private int mVoutCount;
    private final AWindow mWindow;

    public static class Chapter {
        public final long duration;
        public final String name;
        public final long timeOffset;

        private Chapter(long j, long j2, String str) {
            this.timeOffset = j;
            this.duration = j2;
            this.name = str;
        }
    }

    public static class Equalizer {
        private long mInstance;

        private Equalizer() {
            nativeNew();
        }

        private Equalizer(int i) {
            nativeNewFromPreset(i);
        }

        public static Equalizer create() {
            return new Equalizer();
        }

        public static Equalizer createFromPreset(int i) {
            return new Equalizer(i);
        }

        public static int getBandCount() {
            return nativeGetBandCount();
        }

        public static float getBandFrequency(int i) {
            return nativeGetBandFrequency(i);
        }

        public static int getPresetCount() {
            return nativeGetPresetCount();
        }

        public static String getPresetName(int i) {
            return nativeGetPresetName(i);
        }

        private native float nativeGetAmp(int i);

        private static native int nativeGetBandCount();

        private static native float nativeGetBandFrequency(int i);

        private native float nativeGetPreAmp();

        private static native int nativeGetPresetCount();

        private static native String nativeGetPresetName(int i);

        private native void nativeNew();

        private native void nativeNewFromPreset(int i);

        private native void nativeRelease();

        private native boolean nativeSetAmp(int i, float f);

        private native boolean nativeSetPreAmp(float f);

        public void finalize() throws Throwable {
            try {
                nativeRelease();
            } finally {
                super.finalize();
            }
        }

        public float getAmp(int i) {
            return nativeGetAmp(i);
        }

        public float getPreAmp() {
            return nativeGetPreAmp();
        }

        public boolean setAmp(int i, float f) {
            return nativeSetAmp(i, f);
        }

        public boolean setPreAmp(float f) {
            return nativeSetPreAmp(f);
        }
    }

    public static class Event extends VLCEvent {
        public static final int AudioTrackCreated = 293;
        public static final int Buffering = 259;
        public static final int CacheChanged = 294;
        public static final int DisableAudio = 301;
        public static final int DisableVideo = 300;
        public static final int ESAdded = 276;
        public static final int ESDeleted = 277;
        public static final int ESSelected = 278;
        public static final int EncounteredError = 266;
        public static final int EndReached = 265;
        public static final int EofPaused = 295;
        public static final int FirstPicDisplay = 286;
        public static final int LengthChanged = 273;
        public static final int LosePicSerious = 288;
        public static final int MediaChanged = 256;
        public static final int Opening = 258;
        public static final int PausableChanged = 270;
        public static final int Paused = 261;
        public static final int Playing = 260;
        public static final int PositionChanged = 268;
        public static final int Prepared = 290;
        public static final int RePlay = 297;
        public static final int Reload = 296;
        public static final int SeekableChanged = 269;
        public static final int SnapShot = 299;
        public static final int Stopped = 262;
        public static final int Subtitle = 291;
        public static final int SubtitleLoad = 292;
        public static final int TimeChanged = 267;
        public static final int Unsupported = 289;
        public static final int VideoHardwareDecoderStopped = 4097;
        public static final int VideoHardwareDecoderUnsupported = 4096;
        public static final int VideoSize = 287;
        public static final int Vout = 274;

        public Event(int i) {
            super(i);
        }

        public Event(int i, float f) {
            super(i, f);
        }

        public Event(int i, long j) {
            super(i, j);
        }

        public Event(int i, long j, long j2) {
            super(i, j, j2);
        }

        public Event(int i, long j, long j2, long j3, long j4) {
            super(i, j, j2, j3, j4);
        }

        public Event(int i, long j, long j2, String str) {
            super(i, j, j2, str);
        }

        public float getBuffering() {
            return this.argf1;
        }

        public long getCacheChanged() {
            return this.arg1;
        }

        public int getErrorCode() {
            return (int) this.arg1;
        }

        public int getEsChangedID() {
            return (int) this.arg2;
        }

        public int getEsChangedType() {
            return (int) this.arg1;
        }

        public long getLengthChanged() {
            return this.arg1;
        }

        public boolean getPausable() {
            return this.arg1 != 0;
        }

        public float getPositionChanged() {
            return this.argf1;
        }

        public boolean getSeekable() {
            return this.arg1 != 0;
        }

        public int getSnapShot() {
            return (int) this.arg1;
        }

        public int getSubtitleDuration() {
            return (int) this.arg2;
        }

        public int getSubtitleLoadStatus() {
            return (int) this.arg1;
        }

        public int getSubtitleStart() {
            return (int) this.arg1;
        }

        public String getSubtitleText() {
            return this.argstr;
        }

        public long getTimeChanged() {
            return this.arg1;
        }

        public int getVideoHeight() {
            return (int) this.arg2;
        }

        public int getVideoSarDen() {
            return (int) this.arg4;
        }

        public int getVideoSarNum() {
            return (int) this.arg3;
        }

        public int getVideoWidth() {
            return (int) this.arg1;
        }

        public int getVoutCount() {
            return (int) this.arg1;
        }
    }

    public interface EventListener extends VLCEvent.Listener<Event> {
    }

    public class NamelessClass_1 implements AWindow.SurfaceCallback {
        public NamelessClass_1() {
        }

        @Override // org.videolan.libvlc.AWindow.SurfaceCallback
        public void onSurfacesCreated(AWindow aWindow) {
            boolean z;
            boolean z2;
            synchronized (MediaPlayer.this) {
                z = false;
                if (MediaPlayer.this.mPlaying || !MediaPlayer.this.mPlayRequested) {
                    z2 = MediaPlayer.this.mVoutCount == 0;
                } else {
                    z2 = false;
                    z = true;
                }
            }
            if (z) {
                MediaPlayer.this.play();
            } else if (z2) {
                MediaPlayer.this.setVideoTrackEnabled(true);
            }
        }

        @Override // org.videolan.libvlc.AWindow.SurfaceCallback
        public void onSurfacesDestroyed(AWindow aWindow) {
            boolean z;
            synchronized (MediaPlayer.this) {
                z = MediaPlayer.this.mVoutCount > 0;
            }
            if (z) {
                MediaPlayer.this.setVideoTrackEnabled(false);
            }
        }
    }

    public static class Navigate {
        public static final int Activate = 0;
        public static final int Down = 2;
        public static final int Left = 3;
        public static final int Right = 4;
        public static final int Up = 1;
    }

    public static class Position {
        public static final int Bottom = 6;
        public static final int BottomLeft = 7;
        public static final int BottomRight = 8;
        public static final int Center = 0;
        public static final int Disable = -1;
        public static final int Left = 1;
        public static final int Right = 2;
        public static final int Top = 3;
        public static final int TopLeft = 4;
        public static final int TopRight = 5;
    }

    public static class Title {
        public final long duration;
        private final int flags;
        public final String name;

        public static class Flags {
            public static final int INTERACTIVE = 2;
            public static final int MENU = 1;

            private Flags() {
            }
        }

        public Title(long j, String str, int i) {
            this.duration = j;
            this.name = str;
            this.flags = i;
        }

        public boolean isInteractive() {
            return (this.flags & 2) != 0;
        }

        public boolean isMenu() {
            return (this.flags & 1) != 0;
        }
    }

    public static class TrackDescription {
        public final int id;
        public final String name;

        private TrackDescription(int i, String str) {
            this.id = i;
            this.name = str;
        }
    }

    public MediaPlayer(LibVLC libVLC) {
        super(libVLC);
        this.mMedia = null;
        this.mPlaying = false;
        this.mPlayRequested = false;
        this.mListenAudioPlug = false;
        this.mVoutCount = 0;
        this.mAudioReset = false;
        this.mAudioOutput = s.d(new byte[]{89, 15, 82, 65, 11, 92, 5, 59, 7, Ascii.ETB, 85, 12, 87, Ascii.NAK, 68, 82, 7, 94}, "8a63d5");
        this.mAudioOutputDevice = null;
        this.mAudioPlugRegistered = false;
        this.mAudioDigitalOutputEnabled = false;
        this.mAudioPlugOutputDevice = s.d(new byte[]{71, 67, 80, Ascii.DC4, 86, 9}, "475f3f");
        AWindow aWindow = new AWindow(new NamelessClass_1());
        this.mWindow = aWindow;
        this.mAudioPlugReceiver = (!AndroidUtil.isLolliPopOrLater || AndroidUtil.isMarshMallowOrLater) ? null : createAudioPlugReceiver();
        this.mAudioDeviceCallback = AndroidUtil.isMarshMallowOrLater ? createAudioDeviceCallback() : null;
        nativeNewFromLibVlc(libVLC, aWindow);
    }

    public MediaPlayer(Media media) {
        super(media);
        this.mMedia = null;
        this.mPlaying = false;
        this.mPlayRequested = false;
        this.mListenAudioPlug = false;
        this.mVoutCount = 0;
        this.mAudioReset = false;
        this.mAudioOutput = s.d(new byte[]{88, 95, 93, Ascii.SYN, 89, 92, 5, 59, 7, Ascii.ETB, 85, 12, 86, 69, 75, 5, 85, 94}, "919d65");
        this.mAudioOutputDevice = null;
        this.mAudioPlugRegistered = false;
        this.mAudioDigitalOutputEnabled = false;
        this.mAudioPlugOutputDevice = s.d(new byte[]{Ascii.ETB, 17, 92, 65, 7, 95}, "de93b0");
        AWindow aWindow = new AWindow(new NamelessClass_1());
        this.mWindow = aWindow;
        this.mAudioPlugReceiver = (!AndroidUtil.isLolliPopOrLater || AndroidUtil.isMarshMallowOrLater) ? null : createAudioPlugReceiver();
        this.mAudioDeviceCallback = AndroidUtil.isMarshMallowOrLater ? createAudioDeviceCallback() : null;
        if (media == null || media.isReleased()) {
            throw new IllegalArgumentException(s.d(new byte[]{46, 87, 87, 95, 5, Ascii.ETB, 8, Ascii.ETB, 70, 12, 68, 9, 15, Ascii.DC2, 92, 68, 68, 69, 4, 8, 3, 3, 66, 0, 7}, "c236d7"));
        }
        this.mMedia = media;
        media.retain();
        nativeNewFromMedia(this.mMedia, aWindow);
    }

    private AudioDeviceCallback createAudioDeviceCallback() {
        return new AudioDeviceCallback() { // from class: org.videolan.libvlc.MediaPlayer.2
            private SparseArray<Long> mEncodedDevices = new SparseArray<>();

            private void onAudioDevicesChanged() {
                long jLongValue = 0;
                for (int i = 0; i < this.mEncodedDevices.size(); i++) {
                    jLongValue |= this.mEncodedDevices.valueAt(i).longValue();
                }
                MediaPlayer.this.updateAudioOutputDevice(jLongValue, s.d(new byte[]{68, 84, 88}, "475efe"));
            }

            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                    if (audioDeviceInfo.isSink()) {
                        long encodingFlags = MediaPlayer.this.getEncodingFlags(audioDeviceInfo.getEncodings());
                        if (encodingFlags != 0) {
                            this.mEncodedDevices.put(audioDeviceInfo.getId(), Long.valueOf(encodingFlags));
                        }
                    }
                }
                onAudioDevicesChanged();
            }

            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                    if (audioDeviceInfo.isSink()) {
                        this.mEncodedDevices.remove(audioDeviceInfo.getId());
                    }
                }
                onAudioDevicesChanged();
            }
        };
    }

    private BroadcastReceiver createAudioPlugReceiver() {
        return new BroadcastReceiver() { // from class: org.videolan.libvlc.MediaPlayer.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action == null || !action.equalsIgnoreCase(s.d(new byte[]{82, 89, 87, 65, 92, 94, 5, 74, 11, 7, 85, 12, 82, Ascii.EM, 82, 80, 71, 94, 14, 10, 72, 42, 117, 40, 122, 104, 114, 102, 119, 126, 46, 59, 54, 46, 100, 34}, "373337"))) {
                    return;
                }
                MediaPlayer.this.updateAudioOutputDevice(intent.getIntExtra(s.d(new byte[]{81, 87, 85, 17, 90, 11, 5, 74, 11, 7, 85, 12, 81, Ascii.ETB, 84, Ascii.ESC, 65, 16, 0, 74, 39, 55, 117, 44, 127, 102, 97, 47, 96, 37, 62, 55, 50, 35, 101, 32}, "091c5b"), 0) == 1 ? MediaPlayer.this.getEncodingFlags(intent.getIntArrayExtra(s.d(new byte[]{89, 87, 86, 75, 88, 15, 5, 74, 11, 7, 85, 12, 89, Ascii.ETB, 87, 65, 67, Ascii.DC4, 0, 74, 35, 44, 114, 42, 124, 112, 124, 126, 100}, "89297f"))) : 0L, s.d(new byte[]{Ascii.NAK, Ascii.SYN, 93, SignedBytes.MAX_POWER_OF_TWO, 3, 12}, "fb82fc"));
            }
        };
    }

    private static Chapter createChapterFromNative(long j, long j2, String str) {
        return new Chapter(j, j2, str);
    }

    private static Title createTitleFromNative(long j, String str, int i) {
        return new Title(j, str, i);
    }

    private static TrackDescription createTrackDescriptionFromNative(int i, String str) {
        return new TrackDescription(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getEncodingFlags(int[] iArr) {
        long j = 0;
        if (iArr == null) {
            return 0L;
        }
        for (int i : iArr) {
            if (isEncoded(i)) {
                j |= (long) (1 << i);
            }
        }
        return j;
    }

    private boolean isAudioTrack() {
        String str = this.mAudioOutput;
        return str != null && str.equals(s.d(new byte[]{84, 15, 86, 19, 9, 13, 5, 59, 7, Ascii.ETB, 85, 12, 90, Ascii.NAK, SignedBytes.MAX_POWER_OF_TWO, 0, 5, 15}, "5a2afd"));
    }

    private boolean isEncoded(int i) {
        return i == 14 || i == 5 || i == 6 || i == 7 || i == 8;
    }

    private native boolean nativeAddSlave(int i, String str, boolean z);

    private native String nativeGetAspectRatio();

    private native long nativeGetAudioDelay();

    private native int nativeGetAudioTrack();

    private native TrackDescription[] nativeGetAudioTracks();

    private native int nativeGetAudioTracksCount();

    private native Chapter[] nativeGetChapters(int i);

    private native float nativeGetScale();

    private native long nativeGetSpuDelay();

    private native int nativeGetSpuTrack();

    private native TrackDescription[] nativeGetSpuTracks();

    private native int nativeGetSpuTracksCount();

    private native Title[] nativeGetTitles();

    private native int nativeGetVideoTrack();

    private native TrackDescription[] nativeGetVideoTracks();

    private native int nativeGetVideoTracksCount();

    private native void nativeNewFromLibVlc(LibVLC libVLC, AWindow aWindow);

    private native void nativeNewFromMedia(Media media, AWindow aWindow);

    private native void nativePlay();

    private native void nativeRelease();

    private native void nativeSetAspectRatio(String str);

    private native boolean nativeSetAudioDelay(long j);

    private native boolean nativeSetAudioOutput(String str);

    private native boolean nativeSetAudioOutputDevice(String str);

    private native boolean nativeSetAudioTrack(int i);

    private native boolean nativeSetEqualizer(Equalizer equalizer);

    private native void nativeSetMedia(Media media);

    private native int nativeSetRenderer(RendererItem rendererItem);

    private native void nativeSetScale(float f);

    private native boolean nativeSetSpuDelay(long j);

    private native boolean nativeSetSpuTrack(int i);

    private native boolean nativeSetVideoFilter(String str);

    private native void nativeSetVideoTitleDisplay(int i, int i2);

    private native boolean nativeSetVideoTrack(int i);

    private native void nativeStop();

    private native void nativeTakeSnapShot(String str, int i, int i2, int i3, int i4);

    private native boolean nativeUpdateViewpoint(float f, float f2, float f3, float f4, boolean z);

    private void registerAudioPlug(boolean z) {
        if (z != this.mAudioPlugRegistered) {
            if (this.mAudioDeviceCallback != null) {
                registerAudioPlugV23(z);
            } else if (this.mAudioPlugReceiver != null) {
                registerAudioPlugV21(z);
            }
            this.mAudioPlugRegistered = z;
        }
    }

    private void registerAudioPlugV21(boolean z) {
        if (!z) {
            this.mLibVLC.mAppContext.unregisterReceiver(this.mAudioPlugReceiver);
            return;
        }
        Intent intentRegisterReceiver = this.mLibVLC.mAppContext.registerReceiver(this.mAudioPlugReceiver, new IntentFilter(s.d(new byte[]{88, 92, 80, 68, 91, 12, 5, 74, 11, 7, 85, 12, 88, Ascii.FS, 85, 85, SignedBytes.MAX_POWER_OF_TWO, 12, 14, 10, 72, 42, 117, 40, 112, 109, 117, 99, 112, 44, 46, 59, 54, 46, 100, 34}, "92464e")));
        if (intentRegisterReceiver != null) {
            this.mAudioPlugReceiver.onReceive(this.mLibVLC.mAppContext, intentRegisterReceiver);
        }
    }

    private void registerAudioPlugV23(boolean z) {
        AudioManager audioManager = (AudioManager) this.mLibVLC.mAppContext.getSystemService(s.d(new byte[]{2, 67, 2, 93, 87}, "c6f489"));
        if (!z) {
            audioManager.unregisterAudioDeviceCallback(this.mAudioDeviceCallback);
        } else {
            this.mAudioDeviceCallback.onAudioDevicesAdded(audioManager.getDevices(2));
            audioManager.registerAudioDeviceCallback(this.mAudioDeviceCallback, null);
        }
    }

    private synchronized boolean setAudioOutputDeviceInternal(String str, boolean z) {
        boolean zNativeSetAudioOutputDevice;
        this.mAudioOutputDevice = str;
        if (z) {
            boolean z2 = str == null && isAudioTrack();
            this.mListenAudioPlug = z2;
            if (!z2) {
                registerAudioPlug(false);
            }
        }
        zNativeSetAudioOutputDevice = nativeSetAudioOutputDevice(str);
        if (!zNativeSetAudioOutputDevice) {
            this.mAudioOutputDevice = null;
            this.mListenAudioPlug = false;
        }
        if (this.mListenAudioPlug) {
            registerAudioPlug(true);
        }
        return zNativeSetAudioOutputDevice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateAudioOutputDevice(long j, String str) {
        if (this.mAudioDigitalOutputEnabled && j != 0) {
            str = s.d(new byte[]{81, 87, 2, 10, 87, 83, 5, 94}, "49ae36") + j;
        }
        if (!str.equals(this.mAudioPlugOutputDevice)) {
            this.mAudioPlugOutputDevice = str;
            setAudioOutputDeviceInternal(str, false);
        }
    }

    public boolean addSlave(int i, Uri uri, boolean z) {
        return nativeAddSlave(i, VLCUtil.encodeVLCUri(uri), z);
    }

    public boolean addSlave(int i, String str, boolean z) {
        return addSlave(i, Uri.fromFile(new File(str)), z);
    }

    public synchronized boolean forceAudioDigitalEncodings(int[] iArr) {
        if (!isAudioTrack()) {
            return false;
        }
        if (iArr.length == 0) {
            setAudioOutputDeviceInternal(null, true);
        } else {
            String str = s.d(new byte[]{83, 88, 80, 10, 81, 81, 5, 94}, "663e54") + getEncodingFlags(iArr);
            if (!str.equals(this.mAudioPlugOutputDevice)) {
                this.mAudioPlugOutputDevice = str;
                setAudioOutputDeviceInternal(str, true);
            }
        }
        return true;
    }

    public String getAspectRatio() {
        return nativeGetAspectRatio();
    }

    public long getAudioDelay() {
        return nativeGetAudioDelay();
    }

    public int getAudioTrack() {
        return nativeGetAudioTrack();
    }

    public TrackDescription[] getAudioTracks() {
        return nativeGetAudioTracks();
    }

    public int getAudioTracksCount() {
        return nativeGetAudioTracksCount();
    }

    public native int getChapter();

    public Chapter[] getChapters(int i) {
        return nativeGetChapters(i);
    }

    public Media.VideoTrack getCurrentVideoTrack() {
        if (getVideoTrack() == -1) {
            return null;
        }
        int trackCount = this.mMedia.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            Media.Track track = this.mMedia.getTrack(i);
            if (track.type == 1) {
                return (Media.VideoTrack) track;
            }
        }
        return null;
    }

    public native long getLength();

    public synchronized Media getMedia() {
        Media media = this.mMedia;
        if (media != null) {
            media.retain();
        }
        return this.mMedia;
    }

    public native int getPlayerState();

    public native float getPosition();

    public native float getRate();

    public native long getRenderedPicturePts();

    public float getScale() {
        return nativeGetScale();
    }

    public long getSpuDelay() {
        return nativeGetSpuDelay();
    }

    public int getSpuTrack() {
        return nativeGetSpuTrack();
    }

    public TrackDescription[] getSpuTracks() {
        return nativeGetSpuTracks();
    }

    public int getSpuTracksCount() {
        return nativeGetSpuTracksCount();
    }

    public native long getTime();

    public native int getTitle();

    public Title[] getTitles() {
        return nativeGetTitles();
    }

    public IVLCVout getVLCVout() {
        return this.mWindow;
    }

    public int getVideoTrack() {
        return nativeGetVideoTrack();
    }

    public TrackDescription[] getVideoTracks() {
        return nativeGetVideoTracks();
    }

    public int getVideoTracksCount() {
        return nativeGetVideoTracksCount();
    }

    public native int getVolume();

    public synchronized boolean hasMedia() {
        return this.mMedia != null;
    }

    public native boolean isLooping();

    public native boolean isPlaying();

    @Override // org.videolan.libvlc.VLCObject
    public /* bridge */ /* synthetic */ boolean isReleased() {
        return super.isReleased();
    }

    public native boolean isSeekable();

    public native void navigate(int i);

    public native int nextChapter();

    /* JADX WARN: Code duplicated, block: B:61:0x009c A[Catch: all -> 0x0104, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0104, blocks: (B:76:0x00c8, B:79:0x00cf, B:82:0x00d6, B:40:0x0064, B:43:0x006b, B:46:0x0072, B:49:0x0079, B:52:0x0080, B:55:0x0087, B:58:0x008e, B:64:0x00a3, B:67:0x00aa, B:70:0x00b1, B:73:0x00c1, B:37:0x0055, B:25:0x0034, B:28:0x003b, B:31:0x0042, B:34:0x0049, B:22:0x002d, B:61:0x009c, B:85:0x00dd, B:89:0x00e5, B:92:0x00f1, B:95:0x00f8), top: B:101:0x0009 }] */
    /* JADX WARN: Switch 'out' block B:61:0x009c for B:15:0x001e already processed. Defaulting to fallback option. */
    /* JADX WARN: Switch 'out' block B:61:0x009c for B:16:0x0021 already processed. Defaulting to fallback option. */
    @Override // org.videolan.libvlc.VLCObject
    public synchronized Event onEventNative(int i, long j, long j2, long j3, long j4, float f, String str) {
        try {
            if (i != 256) {
                if (i == 273) {
                    return new Event(i, j);
                }
                if (i == 274) {
                    this.mVoutCount = (int) j;
                    notify();
                    return new Event(i, j);
                }
                if (i != 4096 && i != 4097) {
                    switch (i) {
                        case 258:
                        case 259:
                            return new Event(i, f);
                        case 260:
                        case 261:
                            return new Event(i);
                        case 262:
                            break;
                        default:
                            switch (i) {
                                case 265:
                                    break;
                                case 266:
                                    this.mVoutCount = 0;
                                    notify();
                                    return new Event(i, j);
                                case 267:
                                    return new Event(i, j);
                                case 268:
                                    return new Event(i, f);
                                case 269:
                                case 270:
                                    return new Event(i, j);
                                default:
                                    switch (i) {
                                        case 276:
                                        case 277:
                                        case 278:
                                            return new Event(i, j, j2);
                                        default:
                                            switch (i) {
                                                case 286:
                                                    return new Event(i);
                                                case 287:
                                                    return new Event(i, j, j2, j3, j4);
                                                case 288:
                                                    return new Event(i);
                                                case 289:
                                                    return new Event(i);
                                                case 290:
                                                    return new Event(i);
                                                case 291:
                                                    return new Event(i, j, j2, str);
                                                case 292:
                                                    return new Event(i, j);
                                                case 293:
                                                    return new Event(i);
                                                case 294:
                                                    return new Event(i, j);
                                                case 295:
                                                    return new Event(i);
                                                case 296:
                                                    return new Event(i);
                                                case 297:
                                                    return new Event(i);
                                                default:
                                                    switch (i) {
                                                        case 299:
                                                            return new Event(i, j);
                                                        case 300:
                                                            return new Event(i);
                                                        case 301:
                                                            return new Event(i);
                                                        default:
                                                            return null;
                                                    }
                                            }
                                    }
                            }
                            break;
                    }
                } else {
                    return new Event(i);
                }
            }
            this.mVoutCount = 0;
            notify();
            return new Event(i);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.videolan.libvlc.VLCObject
    public void onReleaseNative() {
        registerAudioPlug(false);
        Media media = this.mMedia;
        if (media != null) {
            media.release();
        }
        this.mVoutCount = 0;
        nativeRelease();
    }

    public native void pause();

    public void play() {
        synchronized (this) {
            if (!this.mPlaying) {
                if (this.mAudioReset) {
                    String str = this.mAudioOutput;
                    if (str != null) {
                        nativeSetAudioOutput(str);
                    }
                    String str2 = this.mAudioOutputDevice;
                    if (str2 != null) {
                        nativeSetAudioOutputDevice(str2);
                    }
                    this.mAudioReset = false;
                }
                if (this.mListenAudioPlug) {
                    registerAudioPlug(true);
                }
                this.mPlayRequested = true;
                if (this.mWindow.areSurfacesWaiting()) {
                    return;
                }
            }
            this.mPlaying = true;
            nativePlay();
        }
    }

    public native int previousChapter();

    public void setAspectRatio(String str) {
        nativeSetAspectRatio(str);
    }

    public boolean setAudioDelay(long j) {
        return nativeSetAudioDelay(j);
    }

    public synchronized boolean setAudioDigitalOutputEnabled(boolean z) {
        if (z == this.mAudioDigitalOutputEnabled) {
            return true;
        }
        if (!this.mListenAudioPlug || !isAudioTrack()) {
            return false;
        }
        registerAudioPlug(false);
        this.mAudioDigitalOutputEnabled = z;
        registerAudioPlug(true);
        return true;
    }

    public synchronized boolean setAudioOutput(String str) {
        boolean zNativeSetAudioOutput;
        this.mAudioOutput = str;
        boolean zIsAudioTrack = isAudioTrack();
        this.mListenAudioPlug = zIsAudioTrack;
        if (!zIsAudioTrack) {
            registerAudioPlug(false);
        }
        zNativeSetAudioOutput = nativeSetAudioOutput(str);
        if (!zNativeSetAudioOutput) {
            this.mAudioOutput = null;
            this.mListenAudioPlug = false;
        }
        if (this.mListenAudioPlug) {
            registerAudioPlug(true);
        }
        return zNativeSetAudioOutput;
    }

    public boolean setAudioOutputDevice(String str) {
        return setAudioOutputDeviceInternal(str, true);
    }

    public boolean setAudioTrack(int i) {
        return nativeSetAudioTrack(i);
    }

    public native void setChapter(int i);

    public boolean setEqualizer(Equalizer equalizer) {
        return nativeSetEqualizer(equalizer);
    }

    public synchronized void setEventListener(EventListener eventListener) {
        super.setEventListener((VLCEvent.Listener) eventListener);
    }

    public native boolean setLooping(boolean z);

    public void setMedia(Media media) {
        if (media != null) {
            if (media.isReleased()) {
                throw new IllegalArgumentException(s.d(new byte[]{41, 81, 1, 10, 3, 66, 8, Ascii.ETB, 70, 16, 84, 9, 1, 85, Ascii.SYN, 6, 6}, "d4ecbb"));
            }
            media.setDefaultMediaPlayerOptions();
        }
        nativeSetMedia(media);
        synchronized (this) {
            Media media2 = this.mMedia;
            if (media2 != null) {
                media2.release();
            }
            if (media != null) {
                media.retain();
            }
            this.mMedia = media;
        }
    }

    public native void setPosition(float f, boolean z);

    public native void setRate(float f);

    public int setRenderer(RendererItem rendererItem) {
        return nativeSetRenderer(rendererItem);
    }

    public void setScale(float f) {
        nativeSetScale(f);
    }

    public native boolean setSlowMotionTime(long j, long j2);

    public boolean setSpuDelay(long j) {
        return nativeSetSpuDelay(j);
    }

    public boolean setSpuTrack(int i) {
        return nativeSetSpuTrack(i);
    }

    public native boolean setSurface(boolean z);

    public native long setTime(long j, boolean z);

    public native void setTitle(int i);

    public boolean setVideoFilter(String str) {
        return nativeSetVideoFilter(str);
    }

    public void setVideoTitleDisplay(int i, int i2) {
        nativeSetVideoTitleDisplay(i, i2);
    }

    public boolean setVideoTrack(int i) {
        if (i == -1 || (this.mWindow.areViewsAttached() && !this.mWindow.areSurfacesWaiting())) {
            return nativeSetVideoTrack(i);
        }
        return false;
    }

    public void setVideoTrackEnabled(boolean z) {
        TrackDescription[] videoTracks;
        if (!z) {
            setVideoTrack(-1);
            return;
        }
        if (getVideoTrack() != -1 || (videoTracks = getVideoTracks()) == null) {
            return;
        }
        for (TrackDescription trackDescription : videoTracks) {
            int i = trackDescription.id;
            if (i != -1) {
                setVideoTrack(i);
                return;
            }
        }
    }

    public native int setVolume(int i);

    public void stop() {
        synchronized (this) {
            this.mPlayRequested = false;
            this.mPlaying = false;
            this.mAudioReset = true;
        }
        nativeStop();
    }

    public void takeSnapShot(String str, int i, int i2, int i3, int i4) {
        nativeTakeSnapShot(str, i, i2, i3, i4);
    }

    public boolean updateViewpoint(float f, float f2, float f3, float f4, boolean z) {
        return nativeUpdateViewpoint(f, f2, f3, f4, z);
    }
}
