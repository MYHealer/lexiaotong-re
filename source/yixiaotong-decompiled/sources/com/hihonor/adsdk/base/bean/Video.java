package com.hihonor.adsdk.base.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class Video implements Parcelable {
    public static final Parcelable.Creator<Video> CREATOR = new a();
    private int autoPlay;
    private int coverHeight;
    private String coverUrl;
    private int coverWidth;
    private int landingPagePlay;
    private int mute;
    private int orientation;
    private int reward;
    private int rewardingDuration;
    private String rewardingName;
    private double rewardingNum;
    private int videoDuration;
    private int videoHeight;
    private String videoUrl;
    private int videoWidth;

    class a implements Parcelable.Creator<Video> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public Video createFromParcel(Parcel parcel) {
            return new Video(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public Video[] newArray(int i) {
            return new Video[i];
        }
    }

    protected Video(Parcel parcel) {
        this.videoUrl = parcel.readString();
        this.coverUrl = parcel.readString();
        this.coverWidth = parcel.readInt();
        this.coverHeight = parcel.readInt();
        this.videoWidth = parcel.readInt();
        this.videoHeight = parcel.readInt();
        this.videoDuration = parcel.readInt();
        this.mute = parcel.readInt();
        this.autoPlay = parcel.readInt();
        this.orientation = parcel.readInt();
        this.reward = parcel.readInt();
        this.rewardingName = parcel.readString();
        this.rewardingNum = parcel.readDouble();
        this.rewardingDuration = parcel.readInt();
        this.landingPagePlay = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAutoPlay() {
        return this.autoPlay;
    }

    public int getCoverHeight() {
        return this.coverHeight;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public int getCoverWidth() {
        return this.coverWidth;
    }

    public int getLandingPagePlay() {
        return this.landingPagePlay;
    }

    public int getMute() {
        return this.mute;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public int getReward() {
        return this.reward;
    }

    public int getRewardingDuration() {
        return this.rewardingDuration;
    }

    public String getRewardingName() {
        return this.rewardingName;
    }

    public double getRewardingNum() {
        return this.rewardingNum;
    }

    public int getVideoDuration() {
        return this.videoDuration;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public void setAutoPlay(int i) {
        this.autoPlay = i;
    }

    public void setCoverHeight(int i) {
        this.coverHeight = i;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setCoverWidth(int i) {
        this.coverWidth = i;
    }

    public void setLandingPagePlay(int i) {
        this.landingPagePlay = i;
    }

    public void setMute(int i) {
        this.mute = i;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public void setReward(int i) {
        this.reward = i;
    }

    public void setRewardingDuration(int i) {
        this.rewardingDuration = i;
    }

    public void setRewardingName(String str) {
        this.rewardingName = str;
    }

    public void setRewardingNum(double d) {
        this.rewardingNum = d;
    }

    public void setVideoDuration(int i) {
        this.videoDuration = i;
    }

    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.coverUrl);
        parcel.writeInt(this.coverWidth);
        parcel.writeInt(this.coverHeight);
        parcel.writeInt(this.videoWidth);
        parcel.writeInt(this.videoHeight);
        parcel.writeInt(this.videoDuration);
        parcel.writeInt(this.mute);
        parcel.writeInt(this.autoPlay);
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.reward);
        parcel.writeString(this.rewardingName);
        parcel.writeDouble(this.rewardingNum);
        parcel.writeInt(this.rewardingDuration);
        parcel.writeInt(this.landingPagePlay);
    }
}
