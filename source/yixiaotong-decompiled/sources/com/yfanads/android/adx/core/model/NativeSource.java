package com.yfanads.android.adx.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.constant.x;
import com.meishu.sdk.activity.MeishuOpenDeepLinkActivity;
import com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.yfanads.android.adx.components.base.e;
import com.yfanads.android.libs.thirdpart.gson.GsonBuilder;
import com.yfanads.android.libs.thirdpart.gson.annotations.SerializedName;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@Deprecated
public class NativeSource implements Parcelable {
    public static final Parcelable.Creator<NativeSource> CREATOR = new Parcelable.Creator<NativeSource>() { // from class: com.yfanads.android.adx.core.model.NativeSource.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NativeSource createFromParcel(Parcel parcel) {
            return new NativeSource(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NativeSource[] newArray(int i) {
            return new NativeSource[i];
        }
    };

    @SerializedName("act_type")
    public String actType;

    @SerializedName("action_text")
    public String actionText;

    @SerializedName("ader_id")
    public String aderId;

    @SerializedName("app_intro")
    public String appIntro;

    @SerializedName("app_intro_url")
    public String appIntroUrl;

    @SerializedName("app_name")
    public String appName;

    @SerializedName("app_permission_url")
    public String appPermissionUrl;

    @SerializedName("app_privacy")
    public String appPrivacy;

    @SerializedName("app_size")
    public String appSize;

    @SerializedName("app_ver")
    public String appVer;

    @SerializedName("cat")
    public String cat;

    @SerializedName("clickUrl")
    public String[] clickUrl;

    @SerializedName(MeishuRewardVideoPlayerActivity.Clk_type)
    public String clkType;

    @SerializedName("code")
    public int code;

    @SerializedName("content")
    public String content;

    @SerializedName("creative_type")
    public String createType;

    @SerializedName("dUrl")
    public String[] dUrl;

    @SerializedName(MeishuOpenDeepLinkActivity.KEY_DEEP_LINK)
    public String deepLink;

    @SerializedName("developer")
    public String developer;

    @SerializedName("dn_active")
    public String[] dnActive;

    @SerializedName("dn_inst_start")
    public String[] dnInstStart;

    @SerializedName("dn_inst_succ")
    public String[] dnInstSucc;

    @SerializedName("dn_start")
    public String[] dnStart;

    @SerializedName("dn_succ")
    public String[] dnSucc;

    @SerializedName("dp_fail")
    public String[] dpFail;

    @SerializedName("dp_installed")
    public String[] dpInstalled;

    @SerializedName(MeishuOpenDeepLinkActivity.KEY_DEEP_START)
    public String[] dpStart;

    @SerializedName("dp_succ")
    public String[] dpSucc;

    @SerializedName("dp_uninstalled")
    public String[] dpUninstalled;

    @SerializedName("eKey")
    public String eKey;

    @SerializedName("ecpm")
    public String ecpm;

    @SerializedName("from")
    public String from;

    @SerializedName("from_id")
    public String fromId;

    @SerializedName("from_logo")
    public String fromLogo;

    @SerializedName("height")
    public String height;

    @SerializedName(x.cL)
    public String icon;

    @SerializedName("icon_title")
    public String iconTitle;

    @SerializedName(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK)
    public String intent;

    @SerializedName("merchant")
    public String merchant;

    @SerializedName("monitorUrl")
    public String[] monitorUrl;

    @SerializedName("msg")
    public String msg;

    @SerializedName("package_name")
    public String packageName;

    @SerializedName("pid")
    public String pid;

    @SerializedName(NativeUnifiedADAppInfoImpl.Keys.PRIVACY_AGREEMENT)
    public String privacyAgreement;

    @SerializedName("req_id")
    public String reqId;

    @SerializedName("score")
    public String score;

    @SerializedName(bf.ao)
    public ActionType sld;

    @SerializedName("srcUrls")
    public String[] srcUrls;

    @SerializedName("target_type")
    public String targetType;

    @SerializedName("title")
    public String title;

    @SerializedName("video_close")
    public String[] videoClose;

    @SerializedName("video_complete")
    public String[] videoComplete;

    @SerializedName("video_cover")
    public String videoCover;

    @SerializedName("video_duration")
    public String videoDuration;

    @SerializedName("video_endcover")
    public String videoEndCover;

    @SerializedName("video_keep_time")
    public String videoKeepTime;

    @SerializedName("video_one_half")
    public String[] videoOneHalf;

    @SerializedName("video_one_quarter")
    public String[] videoOneQuarter;

    @SerializedName("video_preload_time")
    public String videoPreloadTime;

    @SerializedName("video_size")
    public String videoSize;

    @SerializedName("video_start")
    public String[] videoStart;

    @SerializedName("video_three_quarter")
    public String[] videoThreeQuarter;

    @SerializedName("width")
    public String width;

    @SerializedName("wurl")
    public String[] winUrl;

    @SerializedName("wx_path")
    public String wxPath;

    @SerializedName("wx_username")
    public String wxUsername;

    public NativeSource() {
    }

    public static NativeSource getNativeSource(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (NativeSource) new GsonBuilder().create().fromJson(str, NativeSource.class);
        } catch (Exception e) {
            e.a(e, new StringBuilder("getNativeSource error "));
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isSuccess() {
        return this.code == 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.title = parcel.readString();
        this.appPermissionUrl = parcel.readString();
        this.dpStart = parcel.createStringArray();
        this.dpSucc = parcel.createStringArray();
        this.dpInstalled = parcel.createStringArray();
        this.dpUninstalled = parcel.createStringArray();
        this.createType = parcel.readString();
        this.srcUrls = parcel.createStringArray();
        this.privacyAgreement = parcel.readString();
        this.appIntroUrl = parcel.readString();
        this.reqId = parcel.readString();
        this.aderId = parcel.readString();
        this.content = parcel.readString();
        this.appVer = parcel.readString();
        this.dnStart = parcel.createStringArray();
        this.dnInstStart = parcel.createStringArray();
        this.dpFail = parcel.createStringArray();
        this.monitorUrl = parcel.createStringArray();
        this.height = parcel.readString();
        this.deepLink = parcel.readString();
        this.appName = parcel.readString();
        this.score = parcel.readString();
        this.developer = parcel.readString();
        this.dnInstSucc = parcel.createStringArray();
        this.dnActive = parcel.createStringArray();
        this.fromId = parcel.readString();
        this.targetType = parcel.readString();
        this.dUrl = parcel.createStringArray();
        this.cat = parcel.readString();
        this.packageName = parcel.readString();
        this.appPrivacy = parcel.readString();
        this.dnSucc = parcel.createStringArray();
        this.actType = parcel.readString();
        this.pid = parcel.readString();
        this.width = parcel.readString();
        this.fromLogo = parcel.readString();
        this.from = parcel.readString();
        this.actionText = parcel.readString();
        this.appIntro = parcel.readString();
        this.icon = parcel.readString();
        this.iconTitle = parcel.readString();
        this.ecpm = parcel.readString();
        this.eKey = parcel.readString();
        this.intent = parcel.readString();
        this.appSize = parcel.readString();
        this.clickUrl = parcel.createStringArray();
        this.clkType = parcel.readString();
        this.videoSize = parcel.readString();
        this.videoDuration = parcel.readString();
        this.videoCover = parcel.readString();
        this.videoEndCover = parcel.readString();
        this.videoKeepTime = parcel.readString();
        this.videoPreloadTime = parcel.readString();
        this.winUrl = parcel.createStringArray();
        this.merchant = parcel.readString();
        this.sld = (ActionType) parcel.readParcelable(ActionType.class.getClassLoader());
        this.wxUsername = parcel.readString();
        this.wxPath = parcel.readString();
        this.videoStart = parcel.createStringArray();
        this.videoOneQuarter = parcel.createStringArray();
        this.videoOneHalf = parcel.createStringArray();
        this.videoComplete = parcel.createStringArray();
        this.videoClose = parcel.createStringArray();
    }

    public void updNativeSource(NativeSource nativeSource) {
        this.code = nativeSource.code;
        this.msg = nativeSource.msg;
        this.title = nativeSource.title;
        this.createType = nativeSource.createType;
        this.srcUrls = nativeSource.srcUrls;
        this.reqId = nativeSource.reqId;
        this.aderId = nativeSource.aderId;
        this.content = nativeSource.content;
        this.appVer = nativeSource.appVer;
        this.height = nativeSource.height;
        this.deepLink = nativeSource.deepLink;
        this.appName = nativeSource.appName;
        this.score = nativeSource.score;
        this.developer = nativeSource.developer;
        this.fromId = nativeSource.fromId;
        this.targetType = nativeSource.targetType;
        this.dUrl = nativeSource.dUrl;
        this.cat = nativeSource.cat;
        this.packageName = nativeSource.packageName;
        this.appPrivacy = nativeSource.appPrivacy;
        this.actType = nativeSource.actType;
        this.pid = nativeSource.pid;
        this.width = nativeSource.width;
        this.fromLogo = nativeSource.fromLogo;
        this.from = nativeSource.from;
        this.actionText = nativeSource.actionText;
        this.appIntro = nativeSource.appIntro;
        this.icon = nativeSource.icon;
        this.iconTitle = nativeSource.iconTitle;
        this.ecpm = nativeSource.ecpm;
        this.eKey = nativeSource.eKey;
        this.intent = nativeSource.intent;
        this.appSize = nativeSource.appSize;
        this.clkType = nativeSource.clkType;
        this.videoSize = nativeSource.videoSize;
        this.videoDuration = nativeSource.videoDuration;
        this.videoCover = nativeSource.videoCover;
        this.videoEndCover = nativeSource.videoEndCover;
        this.videoKeepTime = nativeSource.videoKeepTime;
        this.merchant = nativeSource.merchant;
        this.sld = nativeSource.sld;
        this.wxUsername = nativeSource.wxUsername;
        this.wxPath = nativeSource.wxPath;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.appPermissionUrl);
        parcel.writeStringArray(this.dpStart);
        parcel.writeStringArray(this.dpSucc);
        parcel.writeStringArray(this.dpInstalled);
        parcel.writeStringArray(this.dpUninstalled);
        parcel.writeString(this.createType);
        parcel.writeStringArray(this.srcUrls);
        parcel.writeString(this.privacyAgreement);
        parcel.writeString(this.appIntroUrl);
        parcel.writeString(this.reqId);
        parcel.writeString(this.aderId);
        parcel.writeString(this.content);
        parcel.writeString(this.appVer);
        parcel.writeStringArray(this.dnStart);
        parcel.writeStringArray(this.dnInstStart);
        parcel.writeStringArray(this.dpFail);
        parcel.writeStringArray(this.monitorUrl);
        parcel.writeString(this.height);
        parcel.writeString(this.deepLink);
        parcel.writeString(this.appName);
        parcel.writeString(this.score);
        parcel.writeString(this.developer);
        parcel.writeStringArray(this.dnInstSucc);
        parcel.writeStringArray(this.dnActive);
        parcel.writeString(this.fromId);
        parcel.writeString(this.targetType);
        parcel.writeStringArray(this.dUrl);
        parcel.writeString(this.cat);
        parcel.writeString(this.packageName);
        parcel.writeString(this.appPrivacy);
        parcel.writeStringArray(this.dnSucc);
        parcel.writeString(this.actType);
        parcel.writeString(this.pid);
        parcel.writeString(this.width);
        parcel.writeString(this.fromLogo);
        parcel.writeString(this.from);
        parcel.writeString(this.actionText);
        parcel.writeString(this.appIntro);
        parcel.writeString(this.icon);
        parcel.writeString(this.iconTitle);
        parcel.writeString(this.ecpm);
        parcel.writeString(this.eKey);
        parcel.writeString(this.intent);
        parcel.writeString(this.appSize);
        parcel.writeStringArray(this.clickUrl);
        parcel.writeString(this.clkType);
        parcel.writeString(this.videoSize);
        parcel.writeString(this.videoDuration);
        parcel.writeString(this.videoCover);
        parcel.writeString(this.videoEndCover);
        parcel.writeString(this.videoKeepTime);
        parcel.writeString(this.videoPreloadTime);
        parcel.writeStringArray(this.winUrl);
        parcel.writeString(this.merchant);
        parcel.writeParcelable(this.sld, i);
        parcel.writeString(this.wxUsername);
        parcel.writeString(this.wxPath);
        parcel.writeStringArray(this.videoStart);
        parcel.writeStringArray(this.videoOneQuarter);
        parcel.writeStringArray(this.videoOneHalf);
        parcel.writeStringArray(this.videoComplete);
        parcel.writeStringArray(this.videoClose);
    }

    public NativeSource(Parcel parcel) {
        this.title = parcel.readString();
        this.appPermissionUrl = parcel.readString();
        this.dpStart = parcel.createStringArray();
        this.dpSucc = parcel.createStringArray();
        this.dpInstalled = parcel.createStringArray();
        this.dpUninstalled = parcel.createStringArray();
        this.createType = parcel.readString();
        this.srcUrls = parcel.createStringArray();
        this.privacyAgreement = parcel.readString();
        this.appIntroUrl = parcel.readString();
        this.reqId = parcel.readString();
        this.aderId = parcel.readString();
        this.content = parcel.readString();
        this.appVer = parcel.readString();
        this.dnStart = parcel.createStringArray();
        this.dnInstStart = parcel.createStringArray();
        this.dpFail = parcel.createStringArray();
        this.monitorUrl = parcel.createStringArray();
        this.height = parcel.readString();
        this.deepLink = parcel.readString();
        this.appName = parcel.readString();
        this.score = parcel.readString();
        this.developer = parcel.readString();
        this.dnInstSucc = parcel.createStringArray();
        this.dnActive = parcel.createStringArray();
        this.fromId = parcel.readString();
        this.targetType = parcel.readString();
        this.dUrl = parcel.createStringArray();
        this.cat = parcel.readString();
        this.packageName = parcel.readString();
        this.appPrivacy = parcel.readString();
        this.dnSucc = parcel.createStringArray();
        this.actType = parcel.readString();
        this.pid = parcel.readString();
        this.width = parcel.readString();
        this.fromLogo = parcel.readString();
        this.from = parcel.readString();
        this.actionText = parcel.readString();
        this.appIntro = parcel.readString();
        this.icon = parcel.readString();
        this.iconTitle = parcel.readString();
        this.ecpm = parcel.readString();
        this.eKey = parcel.readString();
        this.intent = parcel.readString();
        this.appSize = parcel.readString();
        this.clickUrl = parcel.createStringArray();
        this.clkType = parcel.readString();
        this.videoSize = parcel.readString();
        this.videoDuration = parcel.readString();
        this.videoCover = parcel.readString();
        this.videoEndCover = parcel.readString();
        this.videoKeepTime = parcel.readString();
        this.videoPreloadTime = parcel.readString();
        this.winUrl = parcel.createStringArray();
        this.merchant = parcel.readString();
        this.sld = (ActionType) parcel.readParcelable(ActionType.class.getClassLoader());
        this.wxUsername = parcel.readString();
        this.wxPath = parcel.readString();
        this.videoStart = parcel.createStringArray();
        this.videoOneQuarter = parcel.createStringArray();
        this.videoOneHalf = parcel.createStringArray();
        this.videoComplete = parcel.createStringArray();
        this.videoClose = parcel.createStringArray();
    }
}
