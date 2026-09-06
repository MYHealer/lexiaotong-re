package com.kwad.components.core.proxy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h extends KsFragment implements com.kwad.sdk.l.a.b {
    protected ViewGroup aiO;
    private final com.kwad.sdk.l.a.a mBackPressDelete = new com.kwad.sdk.l.a.a();
    protected Context mContext;
    protected ViewGroup oC;

    protected ViewGroup nP() {
        return null;
    }

    protected int rI() {
        return 0;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            this.mContext = com.kwad.sdk.wrapper.m.wrapContextIfNeed(getActivity());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContext);
        this.aiO = viewGroup;
        if (this.oC == null) {
            ViewGroup viewGroupNP = nP();
            this.oC = viewGroupNP;
            if (viewGroupNP == null && rI() != 0) {
                this.oC = (ViewGroup) layoutInflaterFrom.inflate(rI(), viewGroup, false);
            }
        }
        return this.oC;
    }

    public final <T extends View> T findViewById(int i) {
        ViewGroup viewGroup = this.oC;
        if (viewGroup == null) {
            throw new IllegalArgumentException("ID does not reference a View inside this View");
        }
        return (T) viewGroup.findViewById(i);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (getHost() != null) {
            com.kwad.components.core.t.g.destroyFragment(this.mContext, getView());
        }
    }

    public boolean onBackPressed() {
        return this.mBackPressDelete.onBackPressed();
    }
}
