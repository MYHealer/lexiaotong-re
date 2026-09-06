package com.yfanads.android.adx.thirdpart.filedownload.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class MessageSnapshot implements IMessageSnapshot, Parcelable {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new Parcelable.Creator<MessageSnapshot>() { // from class: com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot.1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:46:0x0094  */
        /* JADX WARN: Code duplicated, block: B:48:0x0097  */
        @Override // android.os.Parcelable.Creator
        public MessageSnapshot createFromParcel(Parcel parcel) {
            MessageSnapshot warnMessageSnapshot;
            MessageSnapshot messageSnapshot;
            boolean z = parcel.readByte() == 1;
            byte b = parcel.readByte();
            if (b == -4) {
                warnMessageSnapshot = z ? new LargeMessageSnapshot.WarnMessageSnapshot(parcel) : new SmallMessageSnapshot.WarnMessageSnapshot(parcel);
            } else if (b == -3) {
                warnMessageSnapshot = z ? new LargeMessageSnapshot.CompletedSnapshot(parcel) : new SmallMessageSnapshot.CompletedSnapshot(parcel);
            } else if (b == -1) {
                warnMessageSnapshot = z ? new LargeMessageSnapshot.ErrorMessageSnapshot(parcel) : new SmallMessageSnapshot.ErrorMessageSnapshot(parcel);
            } else if (b == 1) {
                warnMessageSnapshot = z ? new LargeMessageSnapshot.PendingMessageSnapshot(parcel) : new SmallMessageSnapshot.PendingMessageSnapshot(parcel);
            } else if (b == 2) {
                warnMessageSnapshot = z ? new LargeMessageSnapshot.ConnectedMessageSnapshot(parcel) : new SmallMessageSnapshot.ConnectedMessageSnapshot(parcel);
            } else if (b == 3) {
                warnMessageSnapshot = z ? new LargeMessageSnapshot.ProgressMessageSnapshot(parcel) : new SmallMessageSnapshot.ProgressMessageSnapshot(parcel);
            } else {
                if (b != 5) {
                    if (b != 6) {
                        messageSnapshot = null;
                    } else {
                        warnMessageSnapshot = new StartedMessageSnapshot(parcel);
                    }
                    if (messageSnapshot != null) {
                        throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) b));
                    }
                    messageSnapshot.isLargeFile = z;
                    return messageSnapshot;
                }
                warnMessageSnapshot = z ? new LargeMessageSnapshot.RetryMessageSnapshot(parcel) : new SmallMessageSnapshot.RetryMessageSnapshot(parcel);
            }
            messageSnapshot = warnMessageSnapshot;
            if (messageSnapshot != null) {
                throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) b));
            }
            messageSnapshot.isLargeFile = z;
            return messageSnapshot;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageSnapshot[] newArray(int i) {
            return new MessageSnapshot[i];
        }
    };
    private final int id;
    protected boolean isLargeFile;

    public interface IWarnMessageSnapshot {
        MessageSnapshot turnToPending();
    }

    public static class StartedMessageSnapshot extends MessageSnapshot {
        public StartedMessageSnapshot(int i) {
            super(i);
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) 6;
        }

        public StartedMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    public MessageSnapshot(int i) {
        this.id = i;
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public String getEtag() {
        throw new NoFieldException("getEtag", this);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public String getFileName() {
        throw new NoFieldException("getFileName", this);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public int getId() {
        return this.id;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public long getLargeSofarBytes() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public long getLargeTotalBytes() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public int getRetryingTimes() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public int getSmallSofarBytes() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public int getSmallTotalBytes() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public abstract /* synthetic */ byte getStatus();

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public Throwable getThrowable() {
        throw new NoFieldException("getThrowable", this);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public boolean isLargeFile() {
        return this.isLargeFile;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public boolean isResuming() {
        throw new NoFieldException("isResuming", this);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
    public boolean isReusedDownloadedFile() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isLargeFile ? (byte) 1 : (byte) 0);
        parcel.writeByte(getStatus());
        parcel.writeInt(this.id);
    }

    public static class NoFieldException extends IllegalStateException {
        public NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(FileDownloadUtils.formatString("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.getStatus()), messageSnapshot.getClass().getName()));
        }
    }

    public MessageSnapshot(Parcel parcel) {
        this.id = parcel.readInt();
    }
}
