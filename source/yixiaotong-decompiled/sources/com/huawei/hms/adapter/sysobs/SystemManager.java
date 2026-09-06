package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class SystemManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SystemManager f3805a = new SystemManager();
    public static final Object b = new Object();
    public static SystemNotifier c = new a();

    public static SystemManager getInstance() {
        return f3805a;
    }

    public static SystemNotifier getSystemNotifier() {
        return c;
    }

    public void notifyNoticeResult(int i) {
        c.notifyNoticeObservers(i);
    }

    public void notifyResolutionResult(Intent intent, String str) {
        c.notifyObservers(intent, str);
    }

    public void notifyUpdateResult(int i) {
        c.notifyObservers(i);
    }

    public static class a implements SystemNotifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<SystemObserver> f3806a = new ArrayList();

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyNoticeObservers(int i) {
            synchronized (SystemManager.b) {
                Iterator<SystemObserver> it = this.f3806a.iterator();
                while (it.hasNext()) {
                    if (it.next().onNoticeResult(i)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(Intent intent, String str) {
            synchronized (SystemManager.b) {
                Iterator<SystemObserver> it = this.f3806a.iterator();
                while (it.hasNext()) {
                    if (it.next().onSolutionResult(intent, str)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void registerObserver(SystemObserver systemObserver) {
            if (systemObserver == null || this.f3806a.contains(systemObserver)) {
                return;
            }
            synchronized (SystemManager.b) {
                this.f3806a.add(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void unRegisterObserver(SystemObserver systemObserver) {
            synchronized (SystemManager.b) {
                this.f3806a.remove(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(int i) {
            synchronized (SystemManager.b) {
                Iterator<SystemObserver> it = this.f3806a.iterator();
                while (it.hasNext()) {
                    if (it.next().onUpdateResult(i)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
