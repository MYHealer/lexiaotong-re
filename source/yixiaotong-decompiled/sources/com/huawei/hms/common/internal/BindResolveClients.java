package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class BindResolveClients {
    private static final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<ResolveClientBean> f3972a;

    /* JADX INFO: renamed from: com.huawei.hms.common.internal.BindResolveClients$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class SingletonManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final BindResolveClients f3973a = new BindResolveClients(null);

        private SingletonManager() {
        }
    }

    /* synthetic */ BindResolveClients(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BindResolveClients getInstance() {
        return SingletonManager.f3973a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean zContains;
        synchronized (b) {
            zContains = this.f3972a.contains(resolveClientBean);
        }
        return zContains;
    }

    public void notifyClientReconnect() {
        synchronized (b) {
            ListIterator<ResolveClientBean> listIterator = this.f3972a.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.f3972a.clear();
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (b) {
            if (!this.f3972a.contains(resolveClientBean)) {
                this.f3972a.add(resolveClientBean);
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (b) {
            if (this.f3972a.contains(resolveClientBean)) {
                ListIterator<ResolveClientBean> listIterator = this.f3972a.listIterator();
                while (listIterator.hasNext()) {
                    if (resolveClientBean.equals(listIterator.next())) {
                        listIterator.remove();
                        break;
                    }
                }
            }
        }
    }

    public void unRegisterAll() {
        synchronized (b) {
            this.f3972a.clear();
        }
    }

    private BindResolveClients() {
        this.f3972a = new ArrayList<>();
    }
}
