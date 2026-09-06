package com.yfanads.android.adx.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.yfanads.android.adx.components.base.e;
import com.yfanads.android.libs.thirdpart.gson.GsonBuilder;
import com.yfanads.android.utils.YFListUtils;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class NativeSourceNew implements Parcelable {
    public static final Parcelable.Creator<NativeSourceNew> CREATOR = new Parcelable.Creator<NativeSourceNew>() { // from class: com.yfanads.android.adx.core.model.NativeSourceNew.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NativeSourceNew createFromParcel(Parcel parcel) {
            return new NativeSourceNew(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NativeSourceNew[] newArray(int i) {
            return new NativeSourceNew[i];
        }
    };
    public NativeAd ad;
    public int code;
    public String msg;
    public String rid;

    public static class Asset implements Parcelable {
        public static final Parcelable.Creator<Asset> CREATOR = new Parcelable.Creator<Asset>() { // from class: com.yfanads.android.adx.core.model.NativeSourceNew.Asset.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Asset createFromParcel(Parcel parcel) {
                return new Asset(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Asset[] newArray(int i) {
                return new Asset[i];
            }
        };
        public Image image;
        public int type;
        public Video video;

        public Asset(Parcel parcel) {
            this.type = parcel.readInt();
            this.image = (Image) parcel.readParcelable(Image.class.getClassLoader());
            this.video = (Video) parcel.readParcelable(Video.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAdDes() {
            if (isImg()) {
                return this.image.text;
            }
            return isVideo() ? this.video.text : "";
        }

        public String getTitle() {
            if (isImg()) {
                return this.image.title;
            }
            return isVideo() ? this.video.title : "";
        }

        public boolean isImg() {
            return this.type == 1 && this.image != null;
        }

        public boolean isVideo() {
            return this.type == 2 && this.video != null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.type);
            parcel.writeParcelable(this.image, i);
            parcel.writeParcelable(this.video, i);
        }
    }

    public static class Download implements Parcelable {
        public static final Parcelable.Creator<Download> CREATOR = new Parcelable.Creator<Download>() { // from class: com.yfanads.android.adx.core.model.NativeSourceNew.Download.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Download createFromParcel(Parcel parcel) {
                return new Download(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Download[] newArray(int i) {
                return new Download[i];
            }
        };
        public String Url;
        public String actionText;
        public String appDesc;
        public String appIconUrl;
        public String appInfoUrl;
        public String appName;
        public String appVer;
        public String developerName;
        public long fileSize;
        public String iconTitle;
        public String logoUrl;
        public String marketUrl;
        public String packageName;
        public String permissionUrl;
        public String privacyUrl;

        public Download(Parcel parcel) {
            this.Url = parcel.readString();
            this.packageName = parcel.readString();
            this.marketUrl = parcel.readString();
            this.privacyUrl = parcel.readString();
            this.permissionUrl = parcel.readString();
            this.appInfoUrl = parcel.readString();
            this.appName = parcel.readString();
            this.developerName = parcel.readString();
            this.appVer = parcel.readString();
            this.fileSize = parcel.readLong();
            this.appDesc = parcel.readString();
            this.appIconUrl = parcel.readString();
            this.iconTitle = parcel.readString();
            this.logoUrl = parcel.readString();
            this.actionText = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean isAppDownload() {
            return !TextUtils.isEmpty(this.Url);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.Url);
            parcel.writeString(this.packageName);
            parcel.writeString(this.marketUrl);
            parcel.writeString(this.privacyUrl);
            parcel.writeString(this.permissionUrl);
            parcel.writeString(this.appInfoUrl);
            parcel.writeString(this.appName);
            parcel.writeString(this.developerName);
            parcel.writeString(this.appVer);
            parcel.writeLong(this.fileSize);
            parcel.writeString(this.appDesc);
            parcel.writeString(this.appIconUrl);
            parcel.writeString(this.iconTitle);
            parcel.writeString(this.logoUrl);
            parcel.writeString(this.actionText);
        }
    }

    public static class Image implements Parcelable {
        public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() { // from class: com.yfanads.android.adx.core.model.NativeSourceNew.Image.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Image createFromParcel(Parcel parcel) {
                return new Image(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Image[] newArray(int i) {
                return new Image[i];
            }
        };
        public int h;
        public String mine;
        public String name;
        public String text;
        public String title;
        public String[] urls;
        public int w;

        public Image(Parcel parcel) {
            this.urls = parcel.createStringArray();
            this.mine = parcel.readString();
            this.w = parcel.readInt();
            this.h = parcel.readInt();
            this.title = parcel.readString();
            this.text = parcel.readString();
            this.name = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeStringArray(this.urls);
            parcel.writeString(this.mine);
            parcel.writeInt(this.w);
            parcel.writeInt(this.h);
            parcel.writeString(this.title);
            parcel.writeString(this.text);
            parcel.writeString(this.name);
        }
    }

    public static class Monitor implements Parcelable {
        public static final Parcelable.Creator<Monitor> CREATOR = new Parcelable.Creator<Monitor>() { // from class: com.yfanads.android.adx.core.model.NativeSourceNew.Monitor.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Monitor createFromParcel(Parcel parcel) {
                return new Monitor(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Monitor[] newArray(int i) {
                return new Monitor[i];
            }
        };
        public String[] clickUrls;
        public String[] downloadStartUrls;
        public String[] downloadSuccessUrls;
        public String[] dplFailedUrls;
        public String[] dplInstalledUrls;
        public String[] dplUnInstalledUrls;
        public String[] dplsurls;
        public String[] dplturls;
        public String[] exposureUrls;
        public String[] installStartUrls;
        public String[] installSuccessUrls;
        public String[] playCloseUrls;
        public String[] playEndUrls;
        public String[] playOneHalfUrls;
        public String[] playOneQuarterUrls;
        public String[] playPauseUrls;
        public String[] playResumeUrls;
        public String[] playStartUrls;
        public String[] playThreeQuarterUrls;
        public String[] winUrls;

        public Monitor(Parcel parcel) {
            this.dplsurls = parcel.createStringArray();
            this.dplInstalledUrls = parcel.createStringArray();
            this.dplUnInstalledUrls = parcel.createStringArray();
            this.dplturls = parcel.createStringArray();
            this.dplFailedUrls = parcel.createStringArray();
            this.exposureUrls = parcel.createStringArray();
            this.clickUrls = parcel.createStringArray();
            this.playStartUrls = parcel.createStringArray();
            this.playOneQuarterUrls = parcel.createStringArray();
            this.playOneHalfUrls = parcel.createStringArray();
            this.playThreeQuarterUrls = parcel.createStringArray();
            this.playPauseUrls = parcel.createStringArray();
            this.playResumeUrls = parcel.createStringArray();
            this.playEndUrls = parcel.createStringArray();
            this.playCloseUrls = parcel.createStringArray();
            this.downloadStartUrls = parcel.createStringArray();
            this.downloadSuccessUrls = parcel.createStringArray();
            this.installStartUrls = parcel.createStringArray();
            this.installSuccessUrls = parcel.createStringArray();
            this.winUrls = parcel.createStringArray();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeStringArray(this.dplsurls);
            parcel.writeStringArray(this.dplInstalledUrls);
            parcel.writeStringArray(this.dplUnInstalledUrls);
            parcel.writeStringArray(this.dplturls);
            parcel.writeStringArray(this.dplFailedUrls);
            parcel.writeStringArray(this.exposureUrls);
            parcel.writeStringArray(this.clickUrls);
            parcel.writeStringArray(this.playStartUrls);
            parcel.writeStringArray(this.playOneQuarterUrls);
            parcel.writeStringArray(this.playOneHalfUrls);
            parcel.writeStringArray(this.playThreeQuarterUrls);
            parcel.writeStringArray(this.playPauseUrls);
            parcel.writeStringArray(this.playResumeUrls);
            parcel.writeStringArray(this.playEndUrls);
            parcel.writeStringArray(this.playCloseUrls);
            parcel.writeStringArray(this.downloadStartUrls);
            parcel.writeStringArray(this.downloadSuccessUrls);
            parcel.writeStringArray(this.installStartUrls);
            parcel.writeStringArray(this.installSuccessUrls);
            parcel.writeStringArray(this.winUrls);
        }
    }

    public static class NativeAd implements Parcelable {
        public static final Parcelable.Creator<NativeAd> CREATOR = new Parcelable.Creator<NativeAd>() { // from class: com.yfanads.android.adx.core.model.NativeSourceNew.NativeAd.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NativeAd createFromParcel(Parcel parcel) {
                return new NativeAd(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NativeAd[] newArray(int i) {
                return new NativeAd[i];
            }
        };
        public int action;
        public String adId;
        public String appId;
        public Asset asset;
        public Download download;
        public String dplUrl;
        public String intent;
        public String landingUrl;
        public String merchant;
        public Monitor monitor;
        public int price;
        public Map<String, SldItem> sld;
        public String wxProgramId;
        public String wxProgramPath;

        public NativeAd() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.adId);
            parcel.writeInt(this.price);
            parcel.writeInt(this.action);
            parcel.writeString(this.landingUrl);
            parcel.writeString(this.dplUrl);
            parcel.writeString(this.wxProgramId);
            parcel.writeString(this.wxProgramPath);
            parcel.writeString(this.intent);
            parcel.writeParcelable(this.monitor, i);
            parcel.writeParcelable(this.asset, i);
            parcel.writeParcelable(this.download, i);
            parcel.writeString(this.merchant);
        }

        public NativeAd(Parcel parcel) {
            this.appId = parcel.readString();
            this.adId = parcel.readString();
            this.price = parcel.readInt();
            this.action = parcel.readInt();
            this.landingUrl = parcel.readString();
            this.dplUrl = parcel.readString();
            this.wxProgramId = parcel.readString();
            this.wxProgramPath = parcel.readString();
            this.intent = parcel.readString();
            this.monitor = (Monitor) parcel.readParcelable(Monitor.class.getClassLoader());
            this.asset = (Asset) parcel.readParcelable(Asset.class.getClassLoader());
            this.download = (Download) parcel.readParcelable(Download.class.getClassLoader());
            this.merchant = parcel.readString();
        }
    }

    public static class Video implements Parcelable {
        public static final Parcelable.Creator<Video> CREATOR = new Parcelable.Creator<Video>() { // from class: com.yfanads.android.adx.core.model.NativeSourceNew.Video.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Video createFromParcel(Parcel parcel) {
                return new Video(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Video[] newArray(int i) {
                return new Video[i];
            }
        };
        public int duration;
        public String endImgUrl;
        public int h;
        public String imgUrl;
        public String mine;
        public String name;
        public float ratio;
        public int size;
        public String text;
        public String title;
        public String url;
        public int videoKeepTime;
        public int w;

        public Video(Parcel parcel) {
            this.url = parcel.readString();
            this.mine = parcel.readString();
            this.w = parcel.readInt();
            this.h = parcel.readInt();
            this.title = parcel.readString();
            this.text = parcel.readString();
            this.name = parcel.readString();
            this.duration = parcel.readInt();
            this.imgUrl = parcel.readString();
            this.size = parcel.readInt();
            this.ratio = parcel.readFloat();
            this.videoKeepTime = parcel.readInt();
            this.endImgUrl = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean hasVideo() {
            return !TextUtils.isEmpty(this.url);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.url);
            parcel.writeString(this.mine);
            parcel.writeInt(this.w);
            parcel.writeInt(this.h);
            parcel.writeString(this.title);
            parcel.writeString(this.text);
            parcel.writeString(this.name);
            parcel.writeInt(this.duration);
            parcel.writeString(this.imgUrl);
            parcel.writeInt(this.size);
            parcel.writeFloat(this.ratio);
            parcel.writeInt(this.videoKeepTime);
            parcel.writeString(this.endImgUrl);
        }
    }

    public NativeSourceNew() {
    }

    public static NativeSourceNew getNativeSource(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (NativeSourceNew) new GsonBuilder().create().fromJson(str, NativeSourceNew.class);
        } catch (Exception e) {
            e.a(e, new StringBuilder("getNativeSource error "));
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Monitor getMonitor() {
        return this.ad.monitor;
    }

    public boolean hasAd() {
        return this.ad != null;
    }

    public boolean hasAsset() {
        return hasAd() && this.ad.asset != null;
    }

    public boolean hasDownload() {
        return hasAd() && this.ad.download != null;
    }

    public boolean hasMonitor() {
        return hasAd() && this.ad.monitor != null;
    }

    public boolean hasSld() {
        return hasAd() && !YFListUtils.isMapEmpty(this.ad.sld);
    }

    public boolean isAppDownload() {
        return hasDownload() && this.ad.download.isAppDownload();
    }

    public boolean isImgAsset() {
        return hasAsset() && this.ad.asset.isImg();
    }

    public boolean isSuccess() {
        return this.code == 0;
    }

    public boolean isVideoAsset() {
        return hasAsset() && this.ad.asset.isVideo();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.code);
        parcel.writeString(this.msg);
        parcel.writeString(this.rid);
        parcel.writeParcelable(this.ad, i);
    }

    public static class SldItem implements Parcelable {
        public static final Parcelable.Creator<SldItem> CREATOR = new Parcelable.Creator<SldItem>() { // from class: com.yfanads.android.adx.core.model.NativeSourceNew.SldItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SldItem createFromParcel(Parcel parcel) {
                return new SldItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SldItem[] newArray(int i) {
                return new SldItem[i];
            }
        };
        public String value;

        public SldItem(String str) {
            this.value = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.value);
        }

        public SldItem(Parcel parcel) {
            this.value = parcel.readString();
        }
    }

    public NativeSourceNew(Parcel parcel) {
        this.code = parcel.readInt();
        this.msg = parcel.readString();
        this.rid = parcel.readString();
        this.ad = (NativeAd) parcel.readParcelable(NativeAd.class.getClassLoader());
    }
}
