package com.yfanads.android.adx.thirdpart.filedownload.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FileDownloadTaskAtom implements Parcelable {
    public static final Parcelable.Creator<FileDownloadTaskAtom> CREATOR = new Parcelable.Creator<FileDownloadTaskAtom>() { // from class: com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadTaskAtom.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDownloadTaskAtom createFromParcel(Parcel parcel) {
            return new FileDownloadTaskAtom(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDownloadTaskAtom[] newArray(int i) {
            return new FileDownloadTaskAtom[i];
        }
    };
    private int id;
    private String path;
    private long totalBytes;
    private String url;

    public FileDownloadTaskAtom(String str, String str2, long j) {
        setUrl(str);
        setPath(str2);
        setTotalBytes(j);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPath() {
        return this.path;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public String getUrl() {
        return this.url;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.path);
        parcel.writeLong(this.totalBytes);
    }

    public FileDownloadTaskAtom(Parcel parcel) {
        this.url = parcel.readString();
        this.path = parcel.readString();
        this.totalBytes = parcel.readLong();
    }

    public int getId() {
        int i = this.id;
        if (i != 0) {
            return i;
        }
        int iGenerateId = FileDownloadUtils.generateId(getUrl(), getPath());
        this.id = iGenerateId;
        return iGenerateId;
    }
}
