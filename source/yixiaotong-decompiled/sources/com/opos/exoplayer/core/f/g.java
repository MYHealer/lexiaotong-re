package com.opos.exoplayer.core.f;

import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f6448a = new a();

    static class a implements g {
        a() {
        }

        @Override // com.opos.exoplayer.core.f.g
        public boolean a(Format format) {
            String str = format.f;
            return MimeTypes.TEXT_VTT.equals(str) || MimeTypes.TEXT_SSA.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str) || MimeTypes.APPLICATION_PGS.equals(str);
        }

        @Override // com.opos.exoplayer.core.f.g
        public e b(Format format) {
            String str = format.f;
            str.hashCode();
            switch (str) {
                case "application/dvbsubs":
                    return new com.opos.exoplayer.core.f.b.a(format.h);
                case "application/pgs":
                    return new com.opos.exoplayer.core.f.c.a();
                case "application/x-mp4-vtt":
                    return new com.opos.exoplayer.core.f.h.a();
                case "text/vtt":
                    return new com.opos.exoplayer.core.f.h.e();
                case "application/x-quicktime-tx3g":
                    return new com.opos.exoplayer.core.f.g.a(format.h);
                case "text/x-ssa":
                    return new com.opos.exoplayer.core.f.d.a(format.h);
                case "application/x-mp4-cea-608":
                case "application/cea-608":
                    return new com.opos.exoplayer.core.f.a.a(format.f, format.z);
                case "application/cea-708":
                    return new com.opos.exoplayer.core.f.a.b(format.z);
                case "application/x-subrip":
                    return new com.opos.exoplayer.core.f.e.a();
                case "application/ttml+xml":
                    return new com.opos.exoplayer.core.f.f.a();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    }

    boolean a(Format format);

    e b(Format format);
}
