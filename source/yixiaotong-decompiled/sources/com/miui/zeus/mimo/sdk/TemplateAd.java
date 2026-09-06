package com.miui.zeus.mimo.sdk;

import android.view.ViewGroup;
import com.miui.zeus.mimo.sdk.ad.template.TemplateAdImpl;
import com.miui.zeus.mimo.sdk.ad.template.TemplateUIController;
import com.miui.zeus.mimo.sdk.base.BaseAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class TemplateAd extends BaseAd<TemplateAdImpl> {

    public interface TemplateAdInteractionListener {
        void onAdClick();

        void onAdDismissed();

        void onAdRenderFailed(int i, String str);

        void onAdShow();
    }

    public interface TemplateAdLoadListener {
        void onAdLoadFailed(int i, String str);

        void onAdLoaded();
    }

    public interface TemplateDownLoadListener extends r3 {
        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadCancel();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadFailed(int i);

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadFinished();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadPaused();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadProgressUpdated(int i);

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadStarted();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onInstallFailed(int i);

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onInstallStart();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onInstallSuccess();
    }

    public TemplateAd() {
        this.mAdImpl = new TemplateAdImpl();
    }

    public void destroy() {
        ((TemplateAdImpl) this.mAdImpl).b();
    }

    @Deprecated
    public void load(String str, TemplateAdLoadListener templateAdLoadListener) {
        ((TemplateAdImpl) this.mAdImpl).a(new ADParams.Builder().setUpId(str).build(), templateAdLoadListener);
    }

    public void loadAd(ADParams aDParams, TemplateAdLoadListener templateAdLoadListener) {
        ((TemplateAdImpl) this.mAdImpl).a(aDParams, templateAdLoadListener);
    }

    public void setDownloadListener(TemplateDownLoadListener templateDownLoadListener) {
        TemplateAdImpl templateAdImpl = (TemplateAdImpl) this.mAdImpl;
        templateAdImpl.e = templateDownLoadListener;
        TemplateUIController templateUIController = templateAdImpl.o;
        if (templateUIController != null) {
            templateUIController.g = templateDownLoadListener;
            h3 h3Var = templateUIController.f;
            if (h3Var != null) {
                h3Var.setDownloadListener(templateDownLoadListener);
            }
        }
    }

    @Deprecated
    public void show(ViewGroup viewGroup, TemplateAdInteractionListener templateAdInteractionListener) {
        ((TemplateAdImpl) this.mAdImpl).a(viewGroup, templateAdInteractionListener);
    }

    public void showAd(ViewGroup viewGroup, TemplateAdInteractionListener templateAdInteractionListener) {
        ((TemplateAdImpl) this.mAdImpl).a(viewGroup, templateAdInteractionListener);
    }
}
