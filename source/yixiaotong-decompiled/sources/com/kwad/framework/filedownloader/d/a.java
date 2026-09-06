package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import com.kwad.framework.filedownloader.f.f;
import com.yfanads.android.adx.thirdpart.filedownload.model.ConnectionModel;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private long aAW;
    private long aAX;
    private long aAY;
    private int id;
    private int index;

    public final long CT() {
        return this.aAX;
    }

    public final long CU() {
        return this.aAY;
    }

    public final void ad(long j) {
        this.aAX = j;
    }

    public final void ae(long j) {
        this.aAY = j;
    }

    public final int getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getStartOffset() {
        return this.aAW;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setStartOffset(long j) {
        this.aAW = j;
    }

    public final ContentValues CV() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.id));
        contentValues.put(ConnectionModel.INDEX, Integer.valueOf(this.index));
        contentValues.put(ConnectionModel.START_OFFSET, Long.valueOf(this.aAW));
        contentValues.put(ConnectionModel.CURRENT_OFFSET, Long.valueOf(this.aAX));
        contentValues.put(ConnectionModel.END_OFFSET, Long.valueOf(this.aAY));
        return contentValues;
    }

    public static long y(List<a> list) {
        long jCT = 0;
        for (a aVar : list) {
            jCT += aVar.CT() - aVar.getStartOffset();
        }
        return jCT;
    }

    public final String toString() {
        return f.c("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.id), Integer.valueOf(this.index), Long.valueOf(this.aAW), Long.valueOf(this.aAY), Long.valueOf(this.aAX));
    }
}
