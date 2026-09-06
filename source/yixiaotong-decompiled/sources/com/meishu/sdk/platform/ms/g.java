package com.meishu.sdk.platform.ms;

import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.IAdLoadListener;
import com.meishu.sdk.core.loader.c;
import com.meishu.sdk.platform.BasePlatformLoader;

/* JADX INFO: compiled from: MeishuLoader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class g<T extends AdSlot, Loader extends com.meishu.sdk.core.loader.c, LoaderListener extends IAdLoadListener> extends BasePlatformLoader<Loader, LoaderListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f5177a;

    public g(Loader loader, T t) {
        super(loader, new SdkAdInfo());
        this.f5177a = t;
    }

    public T a() {
        return this.f5177a;
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
    }
}
