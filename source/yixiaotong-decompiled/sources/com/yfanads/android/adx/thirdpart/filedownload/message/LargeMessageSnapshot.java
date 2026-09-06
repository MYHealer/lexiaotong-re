package com.yfanads.android.adx.thirdpart.filedownload.message;

import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class LargeMessageSnapshot extends MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements IFlowDirectly {
        public CompletedFlowDirectlySnapshot(int i, boolean z, long j) {
            super(i, z, j);
        }

        public CompletedFlowDirectlySnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    public static class PausedSnapshot extends PendingMessageSnapshot {
        public PausedSnapshot(int i, long j, long j2) {
            super(i, j, j2);
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.LargeMessageSnapshot.PendingMessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) -2;
        }
    }

    public static class PendingMessageSnapshot extends LargeMessageSnapshot {
        private final long sofarBytes;
        private final long totalBytes;

        public PendingMessageSnapshot(PendingMessageSnapshot pendingMessageSnapshot) {
            this(pendingMessageSnapshot.getId(), pendingMessageSnapshot.getLargeSofarBytes(), pendingMessageSnapshot.getLargeTotalBytes());
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public long getLargeSofarBytes() {
            return this.sofarBytes;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public long getLargeTotalBytes() {
            return this.totalBytes;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) 1;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.sofarBytes);
            parcel.writeLong(this.totalBytes);
        }

        public PendingMessageSnapshot(int i, long j, long j2) {
            super(i);
            this.sofarBytes = j;
            this.totalBytes = j2;
        }

        public PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }
    }

    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements IFlowDirectly {
        public WarnFlowDirectlySnapshot(int i, long j, long j2) {
            super(i, j, j2);
        }

        public WarnFlowDirectlySnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    public static class WarnMessageSnapshot extends PendingMessageSnapshot implements MessageSnapshot.IWarnMessageSnapshot {
        public WarnMessageSnapshot(int i, long j, long j2) {
            super(i, j, j2);
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.LargeMessageSnapshot.PendingMessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
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

    public LargeMessageSnapshot(int i) {
        super(i);
        this.isLargeFile = true;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public int getSmallSofarBytes() {
        if (getLargeSofarBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) getLargeSofarBytes();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public int getSmallTotalBytes() {
        if (getLargeTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) getLargeTotalBytes();
    }

    public static class ProgressMessageSnapshot extends LargeMessageSnapshot {
        private final long sofarBytes;

        public ProgressMessageSnapshot(int i, long j) {
            super(i);
            this.sofarBytes = j;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public long getLargeSofarBytes() {
            return this.sofarBytes;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) 3;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.sofarBytes);
        }

        public ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readLong();
        }
    }

    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {
        private final int retryingTimes;

        public RetryMessageSnapshot(int i, long j, Throwable th, int i2) {
            super(i, j, th);
            this.retryingTimes = i2;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public int getRetryingTimes() {
            return this.retryingTimes;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) 5;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.retryingTimes);
        }

        public RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.retryingTimes = parcel.readInt();
        }
    }

    public static class CompletedSnapshot extends LargeMessageSnapshot {
        private final boolean reusedDownloadedFile;
        private final long totalBytes;

        public CompletedSnapshot(int i, boolean z, long j) {
            super(i);
            this.reusedDownloadedFile = z;
            this.totalBytes = j;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public long getLargeTotalBytes() {
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
            parcel.writeLong(this.totalBytes);
        }

        public CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.reusedDownloadedFile = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }
    }

    public static class ErrorMessageSnapshot extends LargeMessageSnapshot {
        private final long sofarBytes;
        private final Throwable throwable;

        public ErrorMessageSnapshot(int i, long j, Throwable th) {
            super(i);
            this.sofarBytes = j;
            this.throwable = th;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public long getLargeSofarBytes() {
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
            parcel.writeLong(this.sofarBytes);
            parcel.writeSerializable(this.throwable);
        }

        public ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readLong();
            this.throwable = (Throwable) parcel.readSerializable();
        }
    }

    public LargeMessageSnapshot(Parcel parcel) {
        super(parcel);
    }

    public static class ConnectedMessageSnapshot extends LargeMessageSnapshot {
        private final String etag;
        private final String fileName;
        private final boolean resuming;
        private final long totalBytes;

        public ConnectedMessageSnapshot(int i, boolean z, long j, String str, String str2) {
            super(i);
            this.resuming = z;
            this.totalBytes = j;
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
        public long getLargeTotalBytes() {
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
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.etag);
            parcel.writeString(this.fileName);
        }

        public ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.resuming = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
            this.etag = parcel.readString();
            this.fileName = parcel.readString();
        }
    }
}
