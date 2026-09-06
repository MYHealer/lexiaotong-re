package com.hihonor.adsdk.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class TrackUrl implements Parcelable {
    public static final Parcelable.Creator<TrackUrl> CREATOR = new a();
    private List<String> advancedDp;
    private List<String> clicks;
    private List<String> commonFails;
    private List<String> commons;
    private List<String> comparePrices;
    private List<String> downloadStarts;
    private List<String> downloadSuccess;
    private List<String> dpSuccess;
    private List<String> feedAutoPlay;
    private List<String> feedBreak;
    private List<String> feedOver;
    private List<String> feedPlay;
    private List<String> impressions;
    private List<String> installSuccess;
    private List<String> reservations;

    class a implements Parcelable.Creator<TrackUrl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public TrackUrl createFromParcel(Parcel parcel) {
            return new TrackUrl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public TrackUrl[] newArray(int i) {
            return new TrackUrl[i];
        }
    }

    public TrackUrl() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<String> getAdvancedDp() {
        return this.advancedDp;
    }

    public List<String> getClicks() {
        return this.clicks;
    }

    public List<String> getCommonFails() {
        return this.commonFails;
    }

    public List<String> getCommons() {
        return this.commons;
    }

    public List<String> getComparePrices() {
        return this.comparePrices;
    }

    public List<String> getDownloadStarts() {
        return this.downloadStarts;
    }

    public List<String> getDownloadSuccess() {
        return this.downloadSuccess;
    }

    public List<String> getDpSuccess() {
        return this.dpSuccess;
    }

    public List<String> getFeedAutoPlay() {
        return this.feedAutoPlay;
    }

    public List<String> getFeedBreak() {
        return this.feedBreak;
    }

    public List<String> getFeedOver() {
        return this.feedOver;
    }

    public List<String> getFeedPlay() {
        return this.feedPlay;
    }

    public List<String> getImpressions() {
        return this.impressions;
    }

    public List<String> getInstallSuccess() {
        return this.installSuccess;
    }

    public List<String> getReservations() {
        return this.reservations;
    }

    public void setAdvancedDp(List<String> list) {
        this.advancedDp = list;
    }

    public void setClicks(List<String> list) {
        this.clicks = list;
    }

    public void setCommonFails(List<String> list) {
        this.commonFails = list;
    }

    public void setCommons(List<String> list) {
        this.commons = list;
    }

    public void setComparePrices(List<String> list) {
        this.comparePrices = list;
    }

    public void setDownloadStarts(List<String> list) {
        this.downloadStarts = list;
    }

    public void setDownloadSuccess(List<String> list) {
        this.downloadSuccess = list;
    }

    public void setDpSuccess(List<String> list) {
        this.dpSuccess = list;
    }

    public void setFeedAutoPlay(List<String> list) {
        this.feedAutoPlay = list;
    }

    public void setFeedBreak(List<String> list) {
        this.feedBreak = list;
    }

    public void setFeedOver(List<String> list) {
        this.feedOver = list;
    }

    public void setFeedPlay(List<String> list) {
        this.feedPlay = list;
    }

    public void setImpressions(List<String> list) {
        this.impressions = list;
    }

    public void setInstallSuccess(List<String> list) {
        this.installSuccess = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.impressions);
        parcel.writeStringList(this.clicks);
        parcel.writeStringList(this.downloadStarts);
        parcel.writeStringList(this.downloadSuccess);
        parcel.writeStringList(this.installSuccess);
        parcel.writeStringList(this.dpSuccess);
        parcel.writeStringList(this.commons);
        parcel.writeStringList(this.commonFails);
        parcel.writeStringList(this.comparePrices);
        parcel.writeStringList(this.feedPlay);
        parcel.writeStringList(this.feedAutoPlay);
        parcel.writeStringList(this.feedBreak);
        parcel.writeStringList(this.feedOver);
        parcel.writeStringList(this.advancedDp);
        parcel.writeStringList(this.reservations);
    }

    protected TrackUrl(Parcel parcel) {
        this.impressions = parcel.createStringArrayList();
        this.clicks = parcel.createStringArrayList();
        this.downloadStarts = parcel.createStringArrayList();
        this.downloadSuccess = parcel.createStringArrayList();
        this.installSuccess = parcel.createStringArrayList();
        this.dpSuccess = parcel.createStringArrayList();
        this.commons = parcel.createStringArrayList();
        this.commonFails = parcel.createStringArrayList();
        this.comparePrices = parcel.createStringArrayList();
        this.feedPlay = parcel.createStringArrayList();
        this.feedAutoPlay = parcel.createStringArrayList();
        this.feedBreak = parcel.createStringArrayList();
        this.feedOver = parcel.createStringArrayList();
        this.advancedDp = parcel.createStringArrayList();
        this.reservations = parcel.createStringArrayList();
    }
}
