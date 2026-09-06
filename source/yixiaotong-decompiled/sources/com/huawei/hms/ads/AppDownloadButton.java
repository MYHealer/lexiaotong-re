package com.huawei.hms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.huawei.hms.ads.uiengine.common.IProgressButton;
import com.huawei.openalliance.ad.download.app.AppStatus;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AppDownloadButton extends com.huawei.openalliance.ad.views.AppDownloadButton implements IAppDownloadButton, com.huawei.openalliance.ad.views.AppDownloadButton.e, com.huawei.openalliance.ad.views.AppDownloadButton.f {
    private OnDownloadStatusChangedListener C;
    private OnNonWifiDownloadListener S;

    /* JADX INFO: renamed from: com.huawei.hms.ads.AppDownloadButton$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[AppStatus.values().length];
            Code = iArr;
            try {
                iArr[AppStatus.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[AppStatus.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[AppStatus.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[AppStatus.RESUME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[AppStatus.DOWNLOADED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Code[AppStatus.DOWNLOADFAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                Code[AppStatus.INSTALLING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                Code[AppStatus.INSTALL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                Code[AppStatus.INSTALLED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                Code[AppStatus.DOWNLOAD.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public interface OnDownloadStatusChangedListener {
        void onStatusChanged(AppDownloadStatus appDownloadStatus);

        void onUserCancel(String str, String str2);
    }

    public interface OnNonWifiDownloadListener {
        boolean onNonWifiDownload(long j);
    }

    private class a extends com.huawei.openalliance.ad.views.a {
        private com.huawei.openalliance.ad.views.a.C0543a F;
        private AppDownloadButtonStyle S;

        public a(Context context, AppDownloadButtonStyle appDownloadButtonStyle) {
            super(context);
            this.F = new com.huawei.openalliance.ad.views.a.C0543a();
            this.S = appDownloadButtonStyle;
            Code(this.V, this.S.normalStyle);
            Code(this.I, this.S.processingStyle);
            Code(this.Z, this.S.installingStyle);
        }

        private void Code(com.huawei.openalliance.ad.views.a.C0543a c0543a, AppDownloadButtonStyle.Style style) {
            c0543a.Code(style.getBackground());
            c0543a.Code(style.getTextColor());
            c0543a.V(style.getTextSize());
            c0543a.Code(style.getTypeface());
        }

        @Override // com.huawei.openalliance.ad.views.a
        public com.huawei.openalliance.ad.views.a.C0543a Code(Context context, AppStatus appStatus) {
            AppDownloadButtonStyle.Style style = this.S.getStyle(context, AppDownloadButton.this.I(appStatus));
            if (style == this.S.processingStyle) {
                return this.I;
            }
            if (style == this.S.installingStyle) {
                return this.Z;
            }
            if (style == this.S.normalStyle) {
                return this.V;
            }
            Code(this.F, style);
            return this.F;
        }
    }

    public AppDownloadButton(Context context) {
        super(context);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public AppDownloadButton(Context context, Boolean bool) {
        super(context, bool);
    }

    public AppDownloadButton(Context context, Boolean bool, IProgressButton iProgressButton) {
        super(context, bool, iProgressButton);
        Code(context, (AttributeSet) null, -1, -1);
    }

    public AppDownloadButton(Context context, Boolean bool, IProgressButton iProgressButton, ImageView imageView) {
        super(context, bool, iProgressButton, imageView);
        Code(context, (AttributeSet) null, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppDownloadStatus I(AppStatus appStatus) {
        if (appStatus == null) {
            return AppDownloadStatus.DOWNLOAD;
        }
        switch (AnonymousClass1.Code[appStatus.ordinal()]) {
            case 1:
                return AppDownloadStatus.WAITING;
            case 2:
                return AppDownloadStatus.DOWNLOADING;
            case 3:
                return AppDownloadStatus.PAUSE;
            case 4:
                return AppDownloadStatus.RESUME;
            case 5:
                return AppDownloadStatus.DOWNLOADED;
            case 6:
                return AppDownloadStatus.DOWNLOADFAILED;
            case 7:
                return AppDownloadStatus.INSTALLING;
            case 8:
                return AppDownloadStatus.INSTALL;
            case 9:
                return AppDownloadStatus.INSTALLED;
            default:
                return AppDownloadStatus.DOWNLOAD;
        }
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton.e
    public void Code(AppStatus appStatus) {
        OnDownloadStatusChangedListener onDownloadStatusChangedListener = this.C;
        if (onDownloadStatusChangedListener != null) {
            onDownloadStatusChangedListener.onStatusChanged(I(appStatus));
        }
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton.e
    public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        OnDownloadStatusChangedListener onDownloadStatusChangedListener = this.C;
        if (onDownloadStatusChangedListener == null || appInfo == null) {
            return;
        }
        onDownloadStatusChangedListener.onUserCancel(appInfo.Code(), appInfo.e());
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton.f
    public boolean Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, long j) {
        OnNonWifiDownloadListener onNonWifiDownloadListener = this.S;
        if (onNonWifiDownloadListener != null) {
            return onNonWifiDownloadListener.onNonWifiDownload(j);
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.ll, com.huawei.hms.ads.IAppDownloadButton
    public void cancel() {
        super.cancel();
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.IAppDownloadButton
    public void continueDownload() {
        super.continueDownload();
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public AppDownloadStatus refreshAppStatus() {
        return I(super.V());
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.IAppDownloadButton
    public void setAllowedNonWifiNetwork(boolean z) {
        super.setAllowedNonWifiNetwork(z);
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public void setAppDownloadButtonStyle(AppDownloadButtonStyle appDownloadButtonStyle) {
        if (appDownloadButtonStyle != null) {
            super.setAppDownloadButtonStyle(new a(getContext(), appDownloadButtonStyle));
        }
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public void setOnDownloadStatusChangedListener(OnDownloadStatusChangedListener onDownloadStatusChangedListener) {
        if (onDownloadStatusChangedListener != null) {
            this.C = onDownloadStatusChangedListener;
            super.setOnDownloadStatusChangedListener(this);
        }
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public void setOnNonWifiDownloadListener(OnNonWifiDownloadListener onNonWifiDownloadListener) {
        if (onNonWifiDownloadListener != null) {
            this.S = onNonWifiDownloadListener;
            super.setOnNonWifiDownloadListener(this);
        }
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.IAppDownloadButton
    public void setShowPermissionDialog(boolean z) {
        super.setShowPermissionDialog(z);
    }
}
