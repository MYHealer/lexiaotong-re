package com.ubixnow.core.bean;

import android.text.TextUtils;
import com.ubixnow.ooooo.oO0000O;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNAdsMaterialInfo {
    private String appPackageName;
    private String creativeId;
    private String deeplinkUrl;
    private String description;
    private String downloadUrl;
    private String landingPageUrl;
    private String title;
    private List<MaterialDetailInfo> materialDetailInfo = new ArrayList();
    private String extraInfo = "";

    public static class MaterialDetailInfo {
        private String materialType = "0";
        private String materialUrl = "";
        private String videoCoverUrl = "";
        private String materialId = "";

        public String getMaterialId() {
            return this.materialId;
        }

        public String getMaterialType() {
            return this.materialType;
        }

        public String getMaterialUrl() {
            return this.materialUrl;
        }

        public String getVideoCoverUrl() {
            return this.videoCoverUrl;
        }

        public void setMaterialType(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.materialType = str;
        }

        public void setMaterialUrl(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.materialUrl = str;
            this.materialId = oO0000O.OooO0o0(str);
        }

        public void setVideoCoverUrl(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.videoCoverUrl = str;
        }

        public String toString() {
            return "MaterialDetailInfo{materialType='" + this.materialType + "', materialUrl='" + this.materialUrl + "', materialId='" + this.materialId + "', videoCoverUrl='" + this.videoCoverUrl + "'}";
        }
    }

    public UMNAdsMaterialInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.title = "";
        this.description = "";
        this.title = str;
        this.description = str2;
        this.creativeId = str3;
        this.deeplinkUrl = str4;
        this.downloadUrl = str5;
        this.landingPageUrl = str6;
        this.appPackageName = str7;
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public String getCreativeId() {
        return this.creativeId;
    }

    public String getDeeplinkUrl() {
        return this.deeplinkUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public String getLandingPageUrl() {
        return this.landingPageUrl;
    }

    public List<MaterialDetailInfo> getMaterialDetailInfo() {
        return this.materialDetailInfo;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAppPackageName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.appPackageName = str;
    }

    public void setCreativeId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.creativeId = str;
    }

    public void setDeeplinkUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.deeplinkUrl = str;
    }

    public void setDescription(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.description = str;
    }

    public void setDownloadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.downloadUrl = str;
    }

    public void setExtraInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.extraInfo = str;
    }

    public void setLandingPageUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.landingPageUrl = str;
    }

    public void setMaterialDetailInfo(List<MaterialDetailInfo> list) {
        this.materialDetailInfo = list;
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.title = str;
    }

    public String toString() {
        return "UMNAdsMaterialInfo{title='" + this.title + "', description='" + this.description + "', materialDetailInfo=" + this.materialDetailInfo.toString() + ", creativeId='" + this.creativeId + "', deeplinkUrl='" + this.deeplinkUrl + "', downloadUrl='" + this.downloadUrl + "', landingPageUrl='" + this.landingPageUrl + "', appPackageName='" + this.appPackageName + "', extraInfo='" + this.extraInfo + "'}";
    }
}
