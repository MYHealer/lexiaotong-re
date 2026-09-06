package com.yfanads.android.adx.thirdpart.filedownload.message;

import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class SmallMessageSnapshot extends MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements IFlowDirectly {
        public CompletedFlowDirectlySnapshot(int i, boolean z, int i2) {
            super(i, z, i2);
        }

        public CompletedFlowDirectlySnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    public static class PausedSnapshot extends PendingMessageSnapshot {
        public PausedSnapshot(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.SmallMessageSnapshot.PendingMessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) -2;
        }
    }

    public static class PendingMessageSnapshot extends SmallMessageSnapshot {
        private final int sofarBytes;
        private final int totalBytes;

        public PendingMessageSnapshot(PendingMessageSnapshot pendingMessageSnapshot) {
            this(pendingMessageSnapshot.getId(), pendingMessageSnapshot.getSmallSofarBytes(), pendingMessageSnapshot.getSmallTotalBytes());
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public int getSmallSofarBytes() {
            return this.sofarBytes;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public int getSmallTotalBytes() {
            return this.totalBytes;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) 1;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.sofarBytes);
            parcel.writeInt(this.totalBytes);
        }

        public PendingMessageSnapshot(int i, int i2, int i3) {
            super(i);
            this.sofarBytes = i2;
            this.totalBytes = i3;
        }

        public PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readInt();
            this.totalBytes = parcel.readInt();
        }
    }

    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements IFlowDirectly {
        public WarnFlowDirectlySnapshot(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public WarnFlowDirectlySnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    public static class WarnMessageSnapshot extends PendingMessageSnapshot implements MessageSnapshot.IWarnMessageSnapshot {
        public WarnMessageSnapshot(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.SmallMessageSnapshot.PendingMessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) -4;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot.IWarnMessageSnapshot
        public MessageSnapshot turnToPending() {
            return new PendingMessageSnapshot(this);
        }

        public WarnMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    public SmallMessageSnapshot(int i) {
        super(i);
        this.isLargeFile = false;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public long getLargeSofarBytes() {
        return getSmallSofarBytes();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public long getLargeTotalBytes() {
        return getSmallTotalBytes();
    }

    public static class ProgressMessageSnapshot extends SmallMessageSnapshot {
        private final int sofarBytes;

        public ProgressMessageSnapshot(int i, int i2) {
            super(i);
            this.sofarBytes = i2;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public int getSmallSofarBytes() {
            return this.sofarBytes;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) 3;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.sofarBytes);
        }

        public ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readInt();
        }
    }

    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {
        private final int retryingTimes;

        public RetryMessageSnapshot(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.retryingTimes = i3;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public int getRetryingTimes() {
            return this.retryingTimes;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) 5;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.retryingTimes);
        }

        public RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.retryingTimes = parcel.readInt();
        }
    }

    public static class CompletedSnapshot extends SmallMessageSnapshot {
        private final boolean reusedDownloadedFile;
        private final int totalBytes;

        public CompletedSnapshot(int i, boolean z, int i2) {
            super(i);
            this.reusedDownloadedFile = z;
            this.totalBytes = i2;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public int getSmallTotalBytes() {
            return this.totalBytes;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) -3;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public boolean isReusedDownloadedFile() {
            return this.reusedDownloadedFile;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.reusedDownloadedFile ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.totalBytes);
        }

        public CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.reusedDownloadedFile = parcel.readByte() != 0;
            this.totalBytes = parcel.readInt();
        }
    }

    public static class ErrorMessageSnapshot extends SmallMessageSnapshot {
        private final int sofarBytes;
        private final Throwable throwable;

        public ErrorMessageSnapshot(int i, int i2, Throwable th) {
            super(i);
            this.sofarBytes = i2;
            this.throwable = th;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public int getSmallSofarBytes() {
            return this.sofarBytes;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) -1;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public Throwable getThrowable() {
            return this.throwable;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.sofarBytes);
            parcel.writeSerializable(this.throwable);
        }

        public ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readInt();
            this.throwable = (Throwable) parcel.readSerializable();
        }
    }

    public SmallMessageSnapshot(Parcel parcel) {
        super(parcel);
    }

    public static class ConnectedMessageSnapshot extends SmallMessageSnapshot {
        private final String etag;
        private final String fileName;
        private final boolean resuming;
        private final int totalBytes;

        public ConnectedMessageSnapshot(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.resuming = z;
            this.totalBytes = i2;
            this.etag = str;
            this.fileName = str2;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public String getEtag() {
            return this.etag;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public String getFileName() {
            return this.fileName;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public int getSmallTotalBytes() {
            return this.totalBytes;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) 2;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public boolean isResuming() {
            return this.resuming;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.resuming ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.totalBytes);
            parcel.writeString(this.etag);
            parcel.writeString(this.fileName);
        }

        public ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.resuming = parcel.readByte() != 0;
            this.totalBytes = parcel.readInt();
            this.etag = parcel.readString();
            this.fileName = parcel.readString();
        }
    }
}
