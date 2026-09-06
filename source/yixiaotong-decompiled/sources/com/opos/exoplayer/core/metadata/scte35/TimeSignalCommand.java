package com.opos.exoplayer.core.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.w;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6543a;
    public final long b;

    static class a implements Parcelable.Creator<TimeSignalCommand> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeSignalCommand[] newArray(int i) {
            return new TimeSignalCommand[i];
        }
    }

    private TimeSignalCommand(long j, long j2) {
        this.f6543a = j;
        this.b = j2;
    }

    /* synthetic */ TimeSignalCommand(long j, long j2, a aVar) {
        this(j, j2);
    }

    static long a(p pVar, long j) {
        long jG = pVar.g();
        if ((128 & jG) != 0) {
            return 8589934591L & ((((jG & 1) << 32) | pVar.m()) + j);
        }
        return -9223372036854775807L;
    }

    static TimeSignalCommand a(p pVar, long j, w wVar) {
        long jA = a(pVar, j);
        return new TimeSignalCommand(jA, wVar.d(jA));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f6543a);
        parcel.writeLong(this.b);
    }
}
