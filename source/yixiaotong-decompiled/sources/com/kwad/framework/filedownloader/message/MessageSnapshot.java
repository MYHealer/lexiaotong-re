package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class MessageSnapshot implements Parcelable, c {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new Parcelable.Creator<MessageSnapshot>() { // from class: com.kwad.framework.filedownloader.message.MessageSnapshot.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot[] newArray(int i) {
            return cS(i);
        }

        /* JADX WARN: Code duplicated, block: B:46:0x0094  */
        /* JADX WARN: Code duplicated, block: B:48:0x0097  */
        private static MessageSnapshot c(Parcel parcel) {
            MessageSnapshot jVar;
            MessageSnapshot messageSnapshot;
            boolean z = parcel.readByte() == 1;
            byte b2 = parcel.readByte();
            if (b2 != -4) {
                if (b2 != -3) {
                    if (b2 != -1) {
                        if (b2 != 1) {
                            if (b2 != 2) {
                                if (b2 != 3) {
                                    if (b2 != 5) {
                                        if (b2 != 6) {
                                            messageSnapshot = null;
                                        } else {
                                            jVar = new b(parcel);
                                        }
                                        if (messageSnapshot != null) {
                                            messageSnapshot.aCx = z;
                                            return messageSnapshot;
                                        }
                                        throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) b2));
                                    }
                                    if (z) {
                                        jVar = new d.h(parcel);
                                    } else {
                                        jVar = new h.C0721h(parcel);
                                    }
                                } else if (z) {
                                    jVar = new d.g(parcel);
                                } else {
                                    jVar = new h.g(parcel);
                                }
                            } else if (z) {
                                jVar = new d.c(parcel);
                            } else {
                                jVar = new h.c(parcel);
                            }
                        } else if (z) {
                            jVar = new d.f(parcel);
                        } else {
                            jVar = new h.f(parcel);
                        }
                    } else if (z) {
                        jVar = new d.C0720d(parcel);
                    } else {
                        jVar = new h.d(parcel);
                    }
                } else if (z) {
                    jVar = new d.b(parcel);
                } else {
                    jVar = new h.b(parcel);
                }
            } else if (z) {
                jVar = new d.j(parcel);
            } else {
                jVar = new h.j(parcel);
            }
            messageSnapshot = jVar;
            if (messageSnapshot != null) {
                messageSnapshot.aCx = z;
                return messageSnapshot;
            }
            throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) b2));
        }

        private static MessageSnapshot[] cS(int i) {
            return new MessageSnapshot[i];
        }
    };
    protected boolean aCx;
    private final int id;

    public interface a {
        MessageSnapshot CQ();
    }

    public final boolean AN() {
        return this.aCx;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getId() {
        return this.id;
    }

    MessageSnapshot(int i) {
        this.id = i;
    }

    public Throwable CP() {
        throw new NoFieldException("getThrowable", this);
    }

    public int AL() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    public boolean CC() {
        throw new NoFieldException("isResuming", this);
    }

    public String getEtag() {
        throw new NoFieldException("getEtag", this);
    }

    public long CO() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    public long CM() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    public int CK() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    public int CL() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    public boolean CN() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    public String getFileName() {
        throw new NoFieldException("getFileName", this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.aCx ? (byte) 1 : (byte) 0);
        parcel.writeByte(AH());
        parcel.writeInt(this.id);
    }

    MessageSnapshot(Parcel parcel) {
        this.id = parcel.readInt();
    }

    public static class NoFieldException extends IllegalStateException {
        NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(com.kwad.framework.filedownloader.f.f.c("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.AH()), messageSnapshot.getClass().getName()));
        }
    }

    public static class b extends MessageSnapshot {
        @Override // com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) 6;
        }

        b(int i) {
            super(i);
        }

        b(Parcel parcel) {
            super(parcel);
        }
    }
}
