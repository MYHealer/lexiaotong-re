package com.ubix.ssp.open;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UBiXAdSetting {
    private UBiXAdPrivacyManager e;
    private Map<String, String> f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9051a = "";
    private String b = "";
    private boolean c = true;
    private boolean d = false;
    private Drawable g = null;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9052a;
        private String b;
        private UBiXAdPrivacyManager e;
        private Map<String, String> f;
        private boolean c = true;
        private boolean d = false;
        private Drawable g = null;

        public UBiXAdSetting build() {
            UBiXAdSetting uBiXAdSetting = new UBiXAdSetting();
            uBiXAdSetting.f9051a = TextUtils.isEmpty(this.f9052a) ? "" : this.f9052a;
            uBiXAdSetting.b = TextUtils.isEmpty(this.b) ? "" : this.b;
            uBiXAdSetting.c = this.c;
            uBiXAdSetting.d = this.d;
            UBiXAdPrivacyManager uBiXAdPrivacyManagerBuild = this.e;
            if (uBiXAdPrivacyManagerBuild == null) {
                uBiXAdPrivacyManagerBuild = new UBiXAdPrivacyManager.Builder().build();
            }
            uBiXAdSetting.e = uBiXAdPrivacyManagerBuild;
            uBiXAdSetting.f = this.f;
            uBiXAdSetting.g = this.g;
            return uBiXAdSetting;
        }

        public Builder setCustomLogo(Drawable drawable) {
            this.g = drawable;
            return this;
        }

        public Builder setExtra(Map<String, String> map) {
            this.f = map;
            return this;
        }

        public Builder setPrivacyManager(UBiXAdPrivacyManager uBiXAdPrivacyManager) {
            this.e = uBiXAdPrivacyManager;
            return this;
        }

        public Builder setPublisherId(String str) {
            this.b = str;
            return this;
        }

        public Builder setUseTextureView(boolean z) {
            this.d = true;
            this.c = z;
            return this;
        }

        public Builder setUserId(String str) {
            this.f9052a = str;
            return this;
        }
    }

    public Drawable getCustomLogo() {
        return this.g;
    }

    public Map<String, String> getExtra() {
        Map<String, String> map = this.f;
        return map == null ? new HashMap() : map;
    }

    public UBiXAdPrivacyManager getPrivacyManager() {
        return this.e;
    }

    public String getPublisherId() {
        return this.b;
    }

    public String getUserId() {
        return this.f9051a;
    }

    public boolean isSpecifiedVideoWidget() {
        return this.d;
    }

    public boolean isUseTextureView() {
        return this.c;
    }
}
