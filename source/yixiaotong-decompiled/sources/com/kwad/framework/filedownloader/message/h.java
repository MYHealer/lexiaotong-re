package com.kwad.framework.filedownloader.message;

import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class h extends MessageSnapshot {
    h(int i2) {
        super(i2);
        this.aCx = false;
    }

    h(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long CM() {
        return CL();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long CO() {
        return CK();
    }

    public static class f extends h {
        private final int aCH;
        private final int aCI;

        public byte AH() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int CK() {
            return this.aCI;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int CL() {
            return this.aCH;
        }

        f(f fVar) {
            this(fVar.getId(), fVar.CK(), fVar.CL());
        }

        f(int i, int i2, int i3) {
            super(i);
            this.aCI = i2;
            this.aCH = i3;
        }

        f(Parcel parcel) {
            super(parcel);
            this.aCI = parcel.readInt();
            this.aCH = parcel.readInt();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aCI);
            parcel.writeInt(this.aCH);
        }
    }

    public static class c extends h {
        private final String aAR;
        private final int aCH;
        private final boolean aCu;
        private final String fileName;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) 2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean CC() {
            return this.aCu;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int CL() {
            return this.aCH;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.aAR;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getFileName() {
            return this.fileName;
        }

        c(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.aCu = z;
            this.aCH = i2;
            this.aAR = str;
            this.fileName = str2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.aCu ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.aCH);
            parcel.writeString(this.aAR);
            parcel.writeString(this.fileName);
        }

        c(Parcel parcel) {
            super(parcel);
            this.aCu = parcel.readByte() != 0;
            this.aCH = parcel.readInt();
            this.aAR = parcel.readString();
            this.fileName = parcel.readString();
        }
    }

    public static class g extends h {
        private final int aCI;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) 3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int CK() {
            return this.aCI;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        g(int i, int i2) {
            super(i);
            this.aCI = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aCI);
        }

        g(Parcel parcel) {
            super(parcel);
            this.aCI = parcel.readInt();
        }
    }

    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        a(int i, boolean z, int i2) {
            super(i, true, i2);
        }
    }

    public static class b extends h {
        private final int aCH;
        private final boolean aCt;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) -3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int CL() {
            return this.aCH;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean CN() {
            return this.aCt;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        b(int i, boolean z, int i2) {
            super(i);
            this.aCt = z;
            this.aCH = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.aCt ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.aCH);
        }

        b(Parcel parcel) {
            super(parcel);
            this.aCt = parcel.readByte() != 0;
            this.aCH = parcel.readInt();
        }
    }

    public static class d extends h {
        private final int aCI;
        private final Throwable aCw;

        @Override // com.kwad.framework.filedownloader.message.c
        public byte AH() {
            return (byte) -1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int CK() {
            return this.aCI;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable CP() {
            return this.aCw;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        d(int i, int i2, Throwable th) {
            super(i);
            this.aCI = i2;
            this.aCw = th;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aCI);
            parcel.writeSerializable(this.aCw);
        }

        d(Parcel parcel) {
            super(parcel);
            this.aCI = parcel.readInt();
            this.aCw = (Throwable) parcel.readSerializable();
        }
    }

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.message.h$h, reason: collision with other inner class name */
    public static class C0721h extends d {
        private final int aCc;

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int AL() {
            return this.aCc;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        C0721h(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.aCc = i3;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aCc);
        }

        C0721h(Parcel parcel) {
            super(parcel);
            this.aCc = parcel.readInt();
        }
    }

    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        i(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }

    public static class j extends f implements MessageSnapshot.a {
        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) -4;
        }

        j(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        j(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot CQ() {
            return new f(this);
        }
    }

    public static class e extends f {
        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) -2;
        }

        e(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }
}
