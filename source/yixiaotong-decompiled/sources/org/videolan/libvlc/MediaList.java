package org.videolan.libvlc;

import android.os.Handler;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class MediaList extends VLCObject<Event> {
    private static final String TAG = s.d(new byte[]{116, 94, 90, 53, 117, 113, 78, 41, 3, 6, 88, 4, 116, 94, 75, Ascii.ETB}, "878c92");
    private int mCount;
    private boolean mLocked;
    private final SparseArray<Media> mMediaArray;

    public static class Event extends VLCEvent {
        public static final int EndReached = 516;
        public static final int ItemAdded = 512;
        public static final int ItemDeleted = 514;
        public final int index;
        public final Media media;
        private final boolean retain;

        public Event(int i, Media media, boolean z, int i2) {
            super(i);
            if (z && (media == null || !media.retain())) {
                throw new IllegalStateException(s.d(new byte[]{12, 90, Ascii.ETB, 7, 93, 89, 5, 68, 11, 7, 85, 12, 4, Ascii.DC4, 19, 3, 87, 85, 19, 1, 8, 1, 84}, "e4af10"));
            }
            this.media = media;
            this.retain = z;
            this.index = i2;
        }

        @Override // org.videolan.libvlc.VLCEvent
        public void release() {
            if (this.retain) {
                this.media.release();
            }
        }
    }

    public interface EventListener extends VLCEvent.Listener<Event> {
    }

    public MediaList(LibVLC libVLC) {
        super(libVLC);
        this.mCount = 0;
        this.mMediaArray = new SparseArray<>();
        this.mLocked = false;
        nativeNewFromLibVlc(libVLC);
        init();
    }

    public MediaList(Media media) {
        super(media);
        this.mCount = 0;
        this.mMediaArray = new SparseArray<>();
        this.mLocked = false;
        nativeNewFromMedia(media);
        init();
    }

    public MediaList(MediaDiscoverer mediaDiscoverer) {
        super(mediaDiscoverer);
        this.mCount = 0;
        this.mMediaArray = new SparseArray<>();
        this.mLocked = false;
        nativeNewFromMediaDiscoverer(mediaDiscoverer);
        init();
    }

    private void init() {
        lock();
        this.mCount = nativeGetCount();
        for (int i = 0; i < this.mCount; i++) {
            this.mMediaArray.put(i, new Media(this, i));
        }
        unlock();
    }

    private synchronized Media insertMediaFromEvent(int i) {
        Media media;
        int i2 = this.mCount;
        this.mCount = i2 + 1;
        while (i2 >= i) {
            SparseArray<Media> sparseArray = this.mMediaArray;
            sparseArray.put(i2 + 1, sparseArray.valueAt(i2));
            i2--;
        }
        media = new Media(this, i);
        this.mMediaArray.put(i, media);
        return media;
    }

    private synchronized void lock() {
        if (this.mLocked) {
            throw new IllegalStateException(s.d(new byte[]{5, 14, 75, 83, 87, 92, Ascii.CAN, 68, 10, 13, 82, 14, 1, 6}, "db9668"));
        }
        this.mLocked = true;
        nativeLock();
    }

    private native int nativeGetCount();

    private native void nativeLock();

    private native void nativeNewFromLibVlc(LibVLC libVLC);

    private native void nativeNewFromMedia(Media media);

    private native void nativeNewFromMediaDiscoverer(MediaDiscoverer mediaDiscoverer);

    private native void nativeRelease();

    private native void nativeUnlock();

    private synchronized Media removeMediaFromEvent(int i) {
        Media media;
        this.mCount--;
        media = this.mMediaArray.get(i);
        if (media != null) {
            media.release();
        }
        while (i < this.mCount) {
            SparseArray<Media> sparseArray = this.mMediaArray;
            int i2 = i + 1;
            sparseArray.put(i, sparseArray.valueAt(i2));
            i = i2;
        }
        return media;
    }

    private synchronized void unlock() {
        if (!this.mLocked) {
            throw new IllegalStateException(s.d(new byte[]{90, 11, Ascii.ETB, 67, 93, 87, 2, 15, 3, 6}, "4dcc18"));
        }
        this.mLocked = false;
        nativeUnlock();
    }

    public synchronized int getCount() {
        return this.mCount;
    }

    public synchronized Media getMediaAt(int i) {
        Media media;
        if (i >= 0) {
            if (i < getCount()) {
                media = this.mMediaArray.get(i);
                media.retain();
            }
        }
        throw new IndexOutOfBoundsException();
        return media;
    }

    public synchronized boolean isLocked() {
        return this.mLocked;
    }

    @Override // org.videolan.libvlc.VLCObject
    public /* bridge */ /* synthetic */ boolean isReleased() {
        return super.isReleased();
    }

    @Override // org.videolan.libvlc.VLCObject
    public synchronized Event onEventNative(int i, long j, long j2, long j3, long j4, float f, String str) {
        Event event;
        if (this.mLocked) {
            throw new IllegalStateException(s.d(new byte[]{83, 10, 16, 3, 7, 81, Ascii.CAN, 68, 10, 13, 82, 14, 87, 2, 66, 0, Ascii.DC4, 90, 12, 68, 3, Ascii.DC4, 84, 11, 70, 70, 1, 7, 10, 89, 3, 5, 5, 9}, "2fbff5"));
        }
        this.mLocked = true;
        event = null;
        if (i == 512) {
            int i2 = (int) j;
            if (i2 != -1) {
                event = new Event(i, insertMediaFromEvent(i2), true, i2);
            }
        } else if (i == 514) {
            int i3 = (int) j;
            if (i3 != -1) {
                event = new Event(i, removeMediaFromEvent(i3), false, i3);
            }
        } else if (i == 516) {
            event = new Event(i, null, false, -1);
        }
        this.mLocked = false;
        return event;
    }

    @Override // org.videolan.libvlc.VLCObject
    public void onReleaseNative() {
        for (int i = 0; i < this.mMediaArray.size(); i++) {
            Media media = this.mMediaArray.get(i);
            if (media != null) {
                media.release();
            }
        }
        nativeRelease();
    }

    public void setEventListener(EventListener eventListener, Handler handler) {
        super.setEventListener((VLCEvent.Listener) eventListener, handler);
    }
}
