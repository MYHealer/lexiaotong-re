package com.huawei.hms.ml.common.card.bcr;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.base.common.ParcelReader;
import com.huawei.hms.base.common.ParcelWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class BcrDetectorFrameParcel implements Parcelable {
    public static final Parcelable.Creator<BcrDetectorFrameParcel> CREATOR = new Parcelable.Creator<BcrDetectorFrameParcel>() { // from class: com.huawei.hms.ml.common.card.bcr.BcrDetectorFrameParcel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BcrDetectorFrameParcel createFromParcel(Parcel parcel) {
            return new BcrDetectorFrameParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BcrDetectorFrameParcel[] newArray(int i) {
            return new BcrDetectorFrameParcel[i];
        }
    };
    public Bitmap bitmap;
    public byte[] bytes;
    public int format;
    public int height;
    public int rotation;
    public int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private BcrDetectorFrameParcel(byte[] bArr, int i, int i2, int i3, int i4, Bitmap bitmap) {
        this.bytes = bArr;
        this.width = i;
        this.height = i2;
        this.rotation = i3;
        this.format = i4;
        this.bitmap = bitmap;
    }

    protected BcrDetectorFrameParcel(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.bytes = parcelReader.createByteArray(2, null);
        this.width = parcelReader.readInt(3, 0);
        this.height = parcelReader.readInt(4, 0);
        this.rotation = parcelReader.readInt(5, 0);
        this.format = parcelReader.readInt(6, 0);
        this.bitmap = (Bitmap) parcelReader.readParcelable(7, Bitmap.CREATOR, null);
        parcelReader.finish();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelWriter parcelWriter = new ParcelWriter(parcel);
        int iBeginObjectHeader = parcelWriter.beginObjectHeader();
        parcelWriter.writeByteArray(2, this.bytes, false);
        parcelWriter.writeInt(3, this.width);
        parcelWriter.writeInt(4, this.height);
        parcelWriter.writeInt(5, this.rotation);
        parcelWriter.writeInt(6, this.format);
        parcelWriter.writeParcelable(7, this.bitmap, i, false);
        parcelWriter.finishObjectHeader(iBeginObjectHeader);
    }

    public static class Builder {
        private Bitmap bitmap;
        private byte[] bytes;
        private int format;
        private int height;
        private int rotation;
        private int width;

        public Builder setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
            return this;
        }

        public Builder setFormat(int i) {
            this.format = i;
            return this;
        }

        public Builder setHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder setRotation(int i) {
            this.rotation = i;
            return this;
        }

        public Builder setWidth(int i) {
            this.width = i;
            return this;
        }

        public Builder setBytes(byte[] bArr) {
            this.bytes = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
            return this;
        }

        public BcrDetectorFrameParcel build() {
            return new BcrDetectorFrameParcel(this.bytes, this.width, this.height, this.rotation, this.format, this.bitmap);
        }
    }
}
