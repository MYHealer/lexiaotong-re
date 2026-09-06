package com.opos.exoplayer.core.c.d;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.huawei.openalliance.ad.constant.bj;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.id3.ApicFrame;
import com.opos.exoplayer.core.metadata.id3.CommentFrame;
import com.opos.exoplayer.core.metadata.id3.Id3Frame;
import com.opos.exoplayer.core.metadata.id3.TextInformationFrame;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f6313a = y.f("nam");
    private static final int b = y.f("trk");
    private static final int c = y.f("cmt");
    private static final int d = y.f("day");
    private static final int e = y.f("ART");
    private static final int f = y.f("too");
    private static final int g = y.f("alb");
    private static final int h = y.f("com");
    private static final int i = y.f("wrt");
    private static final int j = y.f("lyr");
    private static final int k = y.f("gen");
    private static final int l = y.f("covr");
    private static final int m = y.f("gnre");
    private static final int n = y.f("grp");
    private static final int o = y.f("disk");
    private static final int p = y.f("trkn");
    private static final int q = y.f("tmpo");
    private static final int r = y.f("cpil");
    private static final int s = y.f("aART");
    private static final int t = y.f("sonm");
    private static final int u = y.f("soal");
    private static final int v = y.f("soar");
    private static final int w = y.f("soaa");
    private static final int x = y.f("soco");
    private static final int y = y.f("rtng");
    private static final int z = y.f("pgap");
    private static final int A = y.f("sosn");
    private static final int B = y.f("tvsh");
    private static final int C = y.f(InternalFrame.ID);
    private static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static Metadata.Entry a(p pVar) {
        int iD = pVar.d() + pVar.o();
        int iO = pVar.o();
        int i2 = (iO >> 24) & 255;
        try {
            if (i2 == 169 || i2 == 65533) {
                int i3 = 16777215 & iO;
                if (i3 == c) {
                    CommentFrame commentFrameA = a(iO, pVar);
                    pVar.c(iD);
                    return commentFrameA;
                }
                if (i3 != f6313a && i3 != b) {
                    if (i3 != h && i3 != i) {
                        if (i3 == d) {
                            TextInformationFrame textInformationFrameA = a(iO, "TDRC", pVar);
                            pVar.c(iD);
                            return textInformationFrameA;
                        }
                        if (i3 == e) {
                            TextInformationFrame textInformationFrameA2 = a(iO, "TPE1", pVar);
                            pVar.c(iD);
                            return textInformationFrameA2;
                        }
                        if (i3 == f) {
                            TextInformationFrame textInformationFrameA3 = a(iO, "TSSE", pVar);
                            pVar.c(iD);
                            return textInformationFrameA3;
                        }
                        if (i3 == g) {
                            TextInformationFrame textInformationFrameA4 = a(iO, "TALB", pVar);
                            pVar.c(iD);
                            return textInformationFrameA4;
                        }
                        if (i3 == j) {
                            TextInformationFrame textInformationFrameA5 = a(iO, "USLT", pVar);
                            pVar.c(iD);
                            return textInformationFrameA5;
                        }
                        if (i3 == k) {
                            TextInformationFrame textInformationFrameA6 = a(iO, "TCON", pVar);
                            pVar.c(iD);
                            return textInformationFrameA6;
                        }
                        if (i3 == n) {
                            TextInformationFrame textInformationFrameA7 = a(iO, "TIT1", pVar);
                            pVar.c(iD);
                            return textInformationFrameA7;
                        }
                    }
                    TextInformationFrame textInformationFrameA8 = a(iO, "TCOM", pVar);
                    pVar.c(iD);
                    return textInformationFrameA8;
                }
                TextInformationFrame textInformationFrameA9 = a(iO, "TIT2", pVar);
                pVar.c(iD);
                return textInformationFrameA9;
            }
            if (iO == m) {
                TextInformationFrame textInformationFrameB = b(pVar);
                pVar.c(iD);
                return textInformationFrameB;
            }
            if (iO == o) {
                TextInformationFrame textInformationFrameB2 = b(iO, "TPOS", pVar);
                pVar.c(iD);
                return textInformationFrameB2;
            }
            if (iO == p) {
                TextInformationFrame textInformationFrameB3 = b(iO, "TRCK", pVar);
                pVar.c(iD);
                return textInformationFrameB3;
            }
            if (iO == q) {
                Id3Frame id3FrameA = a(iO, "TBPM", pVar, true, false);
                pVar.c(iD);
                return id3FrameA;
            }
            if (iO == r) {
                Id3Frame id3FrameA2 = a(iO, "TCMP", pVar, true, true);
                pVar.c(iD);
                return id3FrameA2;
            }
            if (iO == l) {
                ApicFrame apicFrameC = c(pVar);
                pVar.c(iD);
                return apicFrameC;
            }
            if (iO == s) {
                TextInformationFrame textInformationFrameA10 = a(iO, "TPE2", pVar);
                pVar.c(iD);
                return textInformationFrameA10;
            }
            if (iO == t) {
                TextInformationFrame textInformationFrameA11 = a(iO, "TSOT", pVar);
                pVar.c(iD);
                return textInformationFrameA11;
            }
            if (iO == u) {
                TextInformationFrame textInformationFrameA12 = a(iO, "TSO2", pVar);
                pVar.c(iD);
                return textInformationFrameA12;
            }
            if (iO == v) {
                TextInformationFrame textInformationFrameA13 = a(iO, "TSOA", pVar);
                pVar.c(iD);
                return textInformationFrameA13;
            }
            if (iO == w) {
                TextInformationFrame textInformationFrameA14 = a(iO, "TSOP", pVar);
                pVar.c(iD);
                return textInformationFrameA14;
            }
            if (iO == x) {
                TextInformationFrame textInformationFrameA15 = a(iO, "TSOC", pVar);
                pVar.c(iD);
                return textInformationFrameA15;
            }
            if (iO == y) {
                Id3Frame id3FrameA3 = a(iO, "ITUNESADVISORY", pVar, false, false);
                pVar.c(iD);
                return id3FrameA3;
            }
            if (iO == z) {
                Id3Frame id3FrameA4 = a(iO, "ITUNESGAPLESS", pVar, false, true);
                pVar.c(iD);
                return id3FrameA4;
            }
            if (iO == A) {
                TextInformationFrame textInformationFrameA16 = a(iO, "TVSHOWSORT", pVar);
                pVar.c(iD);
                return textInformationFrameA16;
            }
            if (iO == B) {
                TextInformationFrame textInformationFrameA17 = a(iO, "TVSHOW", pVar);
                pVar.c(iD);
                return textInformationFrameA17;
            }
            if (iO == C) {
                Id3Frame id3FrameA5 = a(pVar, iD);
                pVar.c(iD);
                return id3FrameA5;
            }
            com.opos.cmn.an.f.a.b("MetadataUtil", "Skipped unknown metadata entry: " + g.c(iO));
            pVar.c(iD);
            return null;
        } catch (Throwable th) {
            pVar.c(iD);
            throw th;
        }
    }

    private static CommentFrame a(int i2, p pVar) {
        int iO = pVar.o();
        if (pVar.o() != g.aE) {
            com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse comment attribute: " + g.c(i2));
            return null;
        }
        pVar.d(8);
        String strF = pVar.f(iO - 16);
        return new CommentFrame(C.LANGUAGE_UNDETERMINED, strF, strF);
    }

    private static Id3Frame a(int i2, String str, p pVar, boolean z2, boolean z3) {
        int iD = d(pVar);
        if (z3) {
            iD = Math.min(1, iD);
        }
        if (iD >= 0) {
            return z2 ? new TextInformationFrame(str, null, Integer.toString(iD)) : new CommentFrame(C.LANGUAGE_UNDETERMINED, str, Integer.toString(iD));
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse uint8 attribute: " + g.c(i2));
        return null;
    }

    private static Id3Frame a(p pVar, int i2) {
        String strF = null;
        String strF2 = null;
        int i3 = -1;
        int i4 = -1;
        while (pVar.d() < i2) {
            int iD = pVar.d();
            int iO = pVar.o();
            int iO2 = pVar.o();
            pVar.d(4);
            if (iO2 == g.aC) {
                strF = pVar.f(iO - 12);
            } else if (iO2 == g.aD) {
                strF2 = pVar.f(iO - 12);
            } else {
                if (iO2 == g.aE) {
                    i3 = iD;
                    i4 = iO;
                }
                pVar.d(iO - 12);
            }
        }
        if (!"com.apple.iTunes".equals(strF) || !"iTunSMPB".equals(strF2) || i3 == -1) {
            return null;
        }
        pVar.c(i3);
        pVar.d(16);
        return new CommentFrame(C.LANGUAGE_UNDETERMINED, strF2, pVar.f(i4 - 16));
    }

    private static TextInformationFrame a(int i2, String str, p pVar) {
        int iO = pVar.o();
        if (pVar.o() == g.aE) {
            pVar.d(8);
            return new TextInformationFrame(str, null, pVar.f(iO - 16));
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse text attribute: " + g.c(i2));
        return null;
    }

    private static TextInformationFrame b(int i2, String str, p pVar) {
        int iO = pVar.o();
        if (pVar.o() == g.aE && iO >= 22) {
            pVar.d(10);
            int iH = pVar.h();
            if (iH > 0) {
                String str2 = "" + iH;
                int iH2 = pVar.h();
                if (iH2 > 0) {
                    str2 = str2 + "/" + iH2;
                }
                return new TextInformationFrame(str, null, str2);
            }
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse index/count attribute: " + g.c(i2));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0011  */
    private static TextInformationFrame b(p pVar) {
        String str;
        int iD = d(pVar);
        if (iD > 0) {
            String[] strArr = D;
            if (iD <= strArr.length) {
                str = strArr[iD - 1];
            } else {
                str = null;
            }
        } else {
            str = null;
        }
        if (str != null) {
            return new TextInformationFrame("TCON", null, str);
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    private static ApicFrame c(p pVar) {
        String str;
        String str2;
        int iO = pVar.o();
        if (pVar.o() == g.aE) {
            int iB = g.b(pVar.o());
            if (iB == 13) {
                str2 = "image/jpeg";
            } else {
                str2 = iB == 14 ? bj.Z : null;
            }
            if (str2 != null) {
                pVar.d(4);
                int i2 = iO - 16;
                byte[] bArr = new byte[i2];
                pVar.a(bArr, 0, i2);
                return new ApicFrame(str2, null, 3, bArr);
            }
            str = "Unrecognized cover art flags: " + iB;
        } else {
            str = "Failed to parse cover art attribute";
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", str);
        return null;
    }

    private static int d(p pVar) {
        pVar.d(4);
        if (pVar.o() == g.aE) {
            pVar.d(8);
            return pVar.g();
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
