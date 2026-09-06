package org.videolan.libvlc;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import org.videolan.libvlc.VLCEvent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class VLCObject<T extends VLCEvent> {
    private VLCEvent.Listener<T> mEventListener;
    private Handler mHandler;
    private long mInstance;
    public final LibVLC mLibVLC;
    private int mNativeRefCount;

    public VLCObject() {
        this.mEventListener = null;
        this.mHandler = null;
        this.mNativeRefCount = 1;
        this.mInstance = 0L;
        this.mLibVLC = null;
    }

    public VLCObject(LibVLC libVLC) {
        this.mEventListener = null;
        this.mHandler = null;
        this.mNativeRefCount = 1;
        this.mInstance = 0L;
        this.mLibVLC = libVLC;
    }

    public VLCObject(VLCObject vLCObject) {
        this.mEventListener = null;
        this.mHandler = null;
        this.mNativeRefCount = 1;
        this.mInstance = 0L;
        this.mLibVLC = vLCObject.mLibVLC;
    }

    private synchronized void dispatchEventFromNative(int i, long j, long j2, long j3, long j4, float f, String str) {
        VLCEvent.Listener<T> listener;
        Handler handler;
        VLCEvent.Listener<T> listener2;
        if (!isReleased()) {
            VLCEvent vLCEventOnEventNative = onEventNative(i, j, j2, j3, j4, f, str);
            if (vLCEventOnEventNative != null && (listener2 = this.mEventListener) != null && vLCEventOnEventNative.type == 260) {
                listener2.onEvent(vLCEventOnEventNative);
                vLCEventOnEventNative.release();
            } else if (vLCEventOnEventNative != null && (listener = this.mEventListener) != null && (handler = this.mHandler) != null) {
                handler.post(new Runnable(listener, vLCEventOnEventNative) { // from class: org.videolan.libvlc.VLCObject.1EventRunnable
                    private final T event;
                    private final VLCEvent.Listener<T> listener;

                    {
                        this.listener = listener;
                        this.event = vLCEventOnEventNative;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.listener.onEvent(this.event);
                        this.event.release();
                    }
                });
            }
        }
    }

    private static void dispatchEventFromWeakNative(Object obj, int i, long j, long j2, long j3, long j4, float f, String str) {
        VLCObject vLCObject = (VLCObject) ((WeakReference) obj).get();
        if (vLCObject != null) {
            vLCObject.dispatchEventFromNative(i, j, j2, j3, j4, f, str);
        }
    }

    private Object getWeakReference() {
        return new WeakReference(this);
    }

    private native void nativeDetachEvents();

    public synchronized boolean isReleased() {
        return this.mNativeRefCount == 0;
    }

    public abstract T onEventNative(int i, long j, long j2, long j3, long j4, float f, String str);

    public abstract void onReleaseNative();

    public final void release() {
        int i;
        synchronized (this) {
            int i2 = this.mNativeRefCount;
            if (i2 == 0) {
                return;
            }
            if (i2 > 0) {
                i = i2 - 1;
                this.mNativeRefCount = i;
            } else {
                i = -1;
            }
            if (i == 0) {
                setEventListener(null);
            }
            if (i == 0) {
                nativeDetachEvents();
                synchronized (this) {
                    onReleaseNative();
                }
            }
        }
    }

    public final synchronized boolean retain() {
        int i = this.mNativeRefCount;
        if (i <= 0) {
            return false;
        }
        this.mNativeRefCount = i + 1;
        return true;
    }

    public synchronized void setEventListener(VLCEvent.Listener<T> listener) {
        setEventListener(listener, null);
    }

    public synchronized void setEventListener(VLCEvent.Listener<T> listener, Handler handler) {
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        this.mEventListener = listener;
        if (listener == null) {
            this.mHandler = null;
        } else if (this.mHandler == null) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            this.mHandler = handler;
        }
    }
}
