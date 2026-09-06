package com.jd.ad.sdk.jad_kv;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_mz implements jad_er<ParcelFileDescriptor> {
    public final jad_bo jad_an;

    public static final class jad_an implements jad_er.jad_an<ParcelFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        public jad_er<ParcelFileDescriptor> jad_an(ParcelFileDescriptor parcelFileDescriptor) {
            return new jad_mz(parcelFileDescriptor);
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        public Class<ParcelFileDescriptor> jad_an() {
            return ParcelFileDescriptor.class;
        }
    }

    public static final class jad_bo {
        public final ParcelFileDescriptor jad_an;

        public jad_bo(ParcelFileDescriptor parcelFileDescriptor) {
            this.jad_an = parcelFileDescriptor;
        }

        public ParcelFileDescriptor jad_an() throws IOException {
            try {
                Os.lseek(this.jad_an.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.jad_an;
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        }
    }

    public jad_mz(ParcelFileDescriptor parcelFileDescriptor) {
        this.jad_an = new jad_bo(parcelFileDescriptor);
    }

    public static boolean jad_cp() {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    public ParcelFileDescriptor jad_an() {
        return this.jad_an.jad_an();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    public void jad_bo() {
    }
}
