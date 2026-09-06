package com.kwad.sdk.api.core.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.kwad.sdk.api.core.ComponentDestroyer;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
@KsAdSdkDynamicApi
public class KsFragmentActivity extends FragmentActivity {
    private KsFragmentManager mFragmentManager;

    @KsAdSdkDynamicApi
    public void onAttachFragment(KsFragment ksFragment) {
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportFinishAfterTransition() {
        super.supportFinishAfterTransition();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public final FragmentManager getSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public final void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        super.startActivityFromFragment(fragment, intent, i);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public final void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        super.startActivityFromFragment(fragment, intent, i, bundle);
    }

    public final KsFragmentManager getSupportFragmentManager2() {
        if (this.mFragmentManager == null) {
            this.mFragmentManager = new KsFragmentManager(super.getSupportFragmentManager());
        }
        return this.mFragmentManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity
    public final void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof IDelegateFragment) {
            onAttachFragment(((IDelegateFragment) fragment).getBase());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ComponentDestroyer.destroyActivity(this);
    }
}
