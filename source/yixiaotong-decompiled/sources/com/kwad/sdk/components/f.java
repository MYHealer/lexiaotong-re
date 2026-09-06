package com.kwad.sdk.components;

import android.content.Context;
import com.baidu.oauth.sdkbqt.result.OauthResult;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f implements DevelopMangerComponents {
    @Override // com.kwad.sdk.components.DevelopMangerComponents
    public final String ID() {
        return "";
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return null;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return OauthResult.ERROR_CODE_UNKNOW_ERROR;
    }
}
