package com.byazt.t;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.yfanads.android.adx.thirdpart.filedownload.model.ConnectionModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 66, 13})
public class tt implements Parcelable {
    public static final Parcelable.Creator<tt> CREATOR = new Parcelable.Creator<tt>() { // from class: com.byazt.t.tt.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public tt createFromParcel(Parcel parcel) {
            return new tt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public tt[] newArray(int i) {
            return new tt[i];
        }
    };
    public static final String c = "tt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2736a;
    public List<tt> da;
    public long i;
    public long n;
    public tt sl;
    public int sp;
    public int t;
    public int tt;
    public boolean u;
    public AtomicLong uj;
    public long ve;
    public AtomicInteger x;
    public AtomicBoolean yp;
    public com.byazt.u.tt z;

    public void c(long j) {
        this.f2736a = j;
    }

    public void c(List<tt> list) {
        this.da = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long m() {
        return this.n;
    }

    public int my() {
        return this.sp;
    }

    public long nu() {
        return this.f2736a;
    }

    public int sl() {
        return this.tt;
    }

    public List<tt> sp() {
        return this.da;
    }

    public long t() {
        return this.ve;
    }

    public void tt(int i) {
        this.tt = i;
    }

    public void tt(boolean z) {
        this.u = z;
    }

    public void ve(int i) {
        this.sp = i;
    }

    private tt(c cVar) {
        if (cVar == null) {
            return;
        }
        this.tt = cVar.c;
        this.ve = cVar.tt;
        this.uj = new AtomicLong(cVar.ve);
        this.n = cVar.uj;
        this.f2736a = cVar.n;
        this.sp = cVar.f2737a;
        this.i = cVar.sp;
        this.x = new AtomicInteger(-1);
        c(cVar.x);
        this.yp = new AtomicBoolean(false);
    }

    public tt(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.tt = cursor.getInt(cursor.getColumnIndex("_id"));
        this.sp = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.ve = cursor.getLong(cursor.getColumnIndex(ConnectionModel.START_OFFSET));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.uj = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.uj = new AtomicLong(0L);
        }
        this.n = cursor.getLong(cursor.getColumnIndex(ConnectionModel.END_OFFSET));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.x = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.x = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f2736a = cursor.getLong(columnIndex3);
        }
        this.yp = new AtomicBoolean(false);
    }

    public tt(Parcel parcel) {
        this.tt = parcel.readInt();
        this.ve = parcel.readLong();
        this.uj = new AtomicLong(parcel.readLong());
        this.n = parcel.readLong();
        this.f2736a = parcel.readLong();
        this.sp = parcel.readInt();
        this.x = new AtomicInteger(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.tt);
        parcel.writeLong(this.ve);
        AtomicLong atomicLong = this.uj;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.n);
        parcel.writeLong(this.f2736a);
        parcel.writeInt(this.sp);
        AtomicInteger atomicInteger = this.x;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public ContentValues c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.tt));
        contentValues.put("chunkIndex", Integer.valueOf(this.sp));
        contentValues.put(ConnectionModel.START_OFFSET, Long.valueOf(this.ve));
        contentValues.put("curOffset", Long.valueOf(yp()));
        contentValues.put(ConnectionModel.END_OFFSET, Long.valueOf(this.n));
        contentValues.put("chunkContentLen", Long.valueOf(this.f2736a));
        contentValues.put("hostChunkIndex", Integer.valueOf(tt()));
        return contentValues;
    }

    public void c(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.t = 0;
        sQLiteStatement.clearBindings();
        int i = this.t + 1;
        this.t = i;
        sQLiteStatement.bindLong(i, this.tt);
        int i2 = this.t + 1;
        this.t = i2;
        sQLiteStatement.bindLong(i2, this.sp);
        int i3 = this.t + 1;
        this.t = i3;
        sQLiteStatement.bindLong(i3, this.ve);
        int i4 = this.t + 1;
        this.t = i4;
        sQLiteStatement.bindLong(i4, yp());
        int i5 = this.t + 1;
        this.t = i5;
        sQLiteStatement.bindLong(i5, this.n);
        int i6 = this.t + 1;
        this.t = i6;
        sQLiteStatement.bindLong(i6, this.f2736a);
        int i7 = this.t + 1;
        this.t = i7;
        sQLiteStatement.bindLong(i7, tt());
    }

    public int tt() {
        AtomicInteger atomicInteger = this.x;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public void c(int i) {
        AtomicInteger atomicInteger = this.x;
        if (atomicInteger == null) {
            this.x = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    public boolean ve() {
        AtomicBoolean atomicBoolean = this.yp;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public void c(com.byazt.u.tt ttVar) {
        this.z = ttVar;
        rh();
    }

    public void c(boolean z) {
        AtomicBoolean atomicBoolean = this.yp;
        if (atomicBoolean == null) {
            this.yp = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.z = null;
    }

    public void c(tt ttVar) {
        this.sl = ttVar;
        if (ttVar != null) {
            c(ttVar.my());
        }
    }

    public boolean uj() {
        return tt() == -1;
    }

    public tt n() {
        tt ttVar = !uj() ? this.sl : this;
        if (ttVar == null || !ttVar.a()) {
            return null;
        }
        return ttVar.sp().get(0);
    }

    public boolean a() {
        List<tt> list = this.da;
        return list != null && list.size() > 0;
    }

    public boolean x() {
        tt ttVar = this.sl;
        if (ttVar == null) {
            return true;
        }
        if (!ttVar.a()) {
            return false;
        }
        for (int i = 0; i < this.sl.sp().size(); i++) {
            tt ttVar2 = this.sl.sp().get(i);
            if (ttVar2 != null) {
                int iIndexOf = this.sl.sp().indexOf(this);
                if (iIndexOf > i && !ttVar2.i()) {
                    return false;
                }
                if (iIndexOf == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean i() {
        long j = this.ve;
        if (uj()) {
            long j2 = this.i;
            if (j2 > this.ve) {
                j = j2;
            }
        }
        return yp() - j >= this.f2736a;
    }

    public long da() {
        tt ttVar = this.sl;
        if (ttVar != null && ttVar.sp() != null) {
            int iIndexOf = this.sl.sp().indexOf(this);
            boolean z = false;
            for (int i = 0; i < this.sl.sp().size(); i++) {
                tt ttVar2 = this.sl.sp().get(i);
                if (ttVar2 != null) {
                    if (z) {
                        return ttVar2.yp();
                    }
                    if (iIndexOf == i) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    public long u() {
        AtomicLong atomicLong = this.uj;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long yp() {
        if (uj() && a()) {
            long jU = 0;
            for (int i = 0; i < this.da.size(); i++) {
                tt ttVar = this.da.get(i);
                if (ttVar != null) {
                    if (!ttVar.i()) {
                        return ttVar.u();
                    }
                    if (jU < ttVar.u()) {
                        jU = ttVar.u();
                    }
                }
            }
            return jU;
        }
        return u();
    }

    public void tt(long j) {
        AtomicLong atomicLong = this.uj;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.uj = new AtomicLong(j);
        }
    }

    public long z() {
        long jYp = yp() - this.ve;
        if (a()) {
            jYp = 0;
            for (int i = 0; i < this.da.size(); i++) {
                tt ttVar = this.da.get(i);
                if (ttVar != null) {
                    jYp += ttVar.yp() - ttVar.t();
                }
            }
        }
        return jYp;
    }

    public void rh() {
        this.i = yp();
    }

    public long ve(boolean z) {
        long jYp = yp();
        long j = this.f2736a;
        long j2 = this.i;
        long j3 = j - (jYp - j2);
        if (!z && jYp == j2) {
            j3 = j - (jYp - this.ve);
        }
        com.byazt.x.c.tt("DownloadChunk", "contentLength:" + this.f2736a + " curOffset:" + yp() + " oldOffset:" + this.i + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public List<tt> c(int i, long j) {
        tt ttVar;
        long jM;
        long jT;
        long j2;
        long j3;
        tt ttVar2 = this;
        int i2 = i;
        if (!uj() || a()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long jU = u();
        long jVe = ttVar2.ve(true);
        long j4 = jVe / ((long) i2);
        com.byazt.x.c.tt(c, "retainLen:" + jVe + " divideChunkForReuse chunkSize:" + j4 + " current host downloadChunk index:" + ttVar2.sp);
        int i3 = 0;
        while (i3 < i2) {
            if (i3 == 0) {
                jT = t();
            } else {
                int i4 = i2 - 1;
                if (i3 == i4) {
                    long jM2 = m();
                    j2 = jM2;
                    j3 = jM2 > jU ? (jM2 - jU) + 1 : jVe - (((long) i4) * j4);
                    jT = jU;
                } else {
                    jT = jU;
                }
                long j5 = jVe;
                long j6 = j3;
                tt ttVarC = new c(ttVar2.tt).c((-i3) - 1).c(jT).tt(jU).n(jU).ve(j2).uj(j6).c(ttVar2).c();
                com.byazt.x.c.tt(c, "divide sub chunk : " + i3 + " startOffset:" + jT + " curOffset:" + jU + " endOffset:" + j2 + " contentLen:" + j6);
                arrayList.add(ttVarC);
                jU += j4;
                i3++;
                ttVar2 = this;
                i2 = i;
                jVe = j5;
            }
            j2 = (jU + j4) - 1;
            j3 = j4;
            long j7 = jVe;
            long j8 = j3;
            tt ttVarC2 = new c(ttVar2.tt).c((-i3) - 1).c(jT).tt(jU).n(jU).ve(j2).uj(j8).c(ttVar2).c();
            com.byazt.x.c.tt(c, "divide sub chunk : " + i3 + " startOffset:" + jT + " curOffset:" + jU + " endOffset:" + j2 + " contentLen:" + j8);
            arrayList.add(ttVarC2);
            jU += j4;
            i3++;
            ttVar2 = this;
            i2 = i;
            jVe = j7;
        }
        long jNu = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            tt ttVar3 = arrayList.get(size);
            if (ttVar3 != null) {
                jNu += ttVar3.nu();
            }
        }
        com.byazt.x.c.tt(c, "reuseChunkContentLen:".concat(String.valueOf(jNu)));
        tt ttVar4 = arrayList.get(0);
        if (ttVar4 != null) {
            if (m() == 0) {
                jM = j - t();
            } else {
                jM = (m() - t()) + 1;
            }
            ttVar4.c(jM - jNu);
            ttVar = this;
            ttVar4.ve(ttVar.sp);
            com.byazt.u.tt ttVar5 = ttVar.z;
            if (ttVar5 != null) {
                ttVar5.c(ttVar4.m(), nu() - jNu);
            }
        } else {
            ttVar = this;
        }
        ttVar.c(arrayList);
        return arrayList;
    }

    @com.byazt.zqa.c(c = {0, 1, 66, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2737a;
        public int c;
        public long n;
        public long sp;
        public long tt;
        public long uj;
        public long ve;
        public tt x;

        public c c(int i) {
            this.f2737a = i;
            return this;
        }

        public c c(long j) {
            this.tt = j;
            return this;
        }

        public c c(tt ttVar) {
            this.x = ttVar;
            return this;
        }

        public c n(long j) {
            this.sp = j;
            return this;
        }

        public c tt(long j) {
            this.ve = j;
            return this;
        }

        public c uj(long j) {
            this.n = j;
            return this;
        }

        public c ve(long j) {
            this.uj = j;
            return this;
        }

        public c(int i) {
            this.c = i;
        }

        public tt c() {
            return new tt(this);
        }
    }
}
