package com.yfanads.android.utils;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdStateManager {
    private static volatile AdStateManager instance;
    private final AtomicBoolean isPushAdShowing = new AtomicBoolean(false);
    private final List<AdStatusListener> listeners = new CopyOnWriteArrayList();

    public interface AdStatusListener {
        void onAdDismiss();

        void onAdShow();
    }

    public static AdStateManager getInstance() {
        if (instance == null) {
            synchronized (AdStateManager.class) {
                if (instance == null) {
                    instance = new AdStateManager();
                }
            }
        }
        return instance;
    }

    private void notifyStatusChanged(boolean z) {
        for (AdStatusListener adStatusListener : this.listeners) {
            if (z) {
                adStatusListener.onAdShow();
            } else {
                adStatusListener.onAdDismiss();
            }
        }
    }

    public void addListener(AdStatusListener adStatusListener) {
        this.listeners.add(adStatusListener);
    }

    public boolean isPushAdShowing() {
        return this.isPushAdShowing.get();
    }

    public void removeListener(AdStatusListener adStatusListener) {
        this.listeners.remove(adStatusListener);
    }

    public void setPushAdShowing(boolean z) {
        boolean z2 = this.isPushAdShowing.get();
        this.isPushAdShowing.set(z);
        if (z2 != z) {
            notifyStatusChanged(z);
        }
    }
}
