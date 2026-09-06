package com.opos.cmn.biz.ststrategy.interfaces;

import com.opos.cmn.biz.ststrategy.UpdateParams;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface a {
    STConfigEntity a();

    void a(UpdateParams updateParams, UpdateSTConfigListener updateSTConfigListener);

    void a(String str, UpdateSTConfigListener updateSTConfigListener);
}
