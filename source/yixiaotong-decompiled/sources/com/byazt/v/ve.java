package com.byazt.v;

import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.x;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 54})
public class ve {
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: com.byazt.v.ve$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 79})
    static /* synthetic */ class AnonymousClass1 {
    }

    public static String c(File file) {
        return c(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String c(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return tt(file, i, j);
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return "";
    }

    public static int c(String str, File file) {
        return c(str, file, (tt) null);
    }

    public static int c(String str, File file, tt ttVar) {
        int i;
        long j;
        String strTt;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (ttVar != null) {
                if (ttVar.c() <= 0) {
                    try {
                        ttVar.tt();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            try {
                c cVarC = c(str);
                if (cVarC == null) {
                    i = -1;
                    j = -1;
                } else {
                    if (cVarC.c > 1) {
                        return 3;
                    }
                    i = cVarC.ve;
                    j = cVarC.uj;
                }
                c cVarC2 = null;
                try {
                    if (ttVar != null) {
                        strTt = c(ttVar, i, j);
                    } else {
                        strTt = tt(file, i, j);
                    }
                } catch (Throwable th) {
                    m.c(th);
                    strTt = null;
                }
                if (strTt != null && strTt.length() != 0) {
                    if (cVarC == null || (cVarC.c == 1 && cVarC.tt == 1)) {
                        if (strTt.equals(str)) {
                            return 0;
                        }
                    } else if (cVarC.n != null) {
                        try {
                            cVarC2 = c(strTt);
                        } catch (Throwable unused2) {
                        }
                        if (cVarC2 != null && cVarC.ve == cVarC2.ve && cVarC.uj == cVarC2.uj && cVarC.n.equals(cVarC2.n)) {
                            return 0;
                        }
                    }
                    return 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    private static String tt(File file, int i, long j) throws Exception {
        return c(new com.byazt.v.c(file), i, j);
    }

    private static String c(tt ttVar, int i, long j) throws Exception {
        long j2;
        int i2 = i;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long jC = ttVar.c();
            long j3 = 0;
            if (i2 <= 0 || j <= 0 || ((long) i2) * j > (8 * jC) / 10) {
                j2 = jC;
                i2 = 1;
            } else {
                j2 = j;
            }
            byte[] bArr = new byte[8192];
            c(ttVar, messageDigest, bArr, 0L, j2);
            if (i2 > 2) {
                int i3 = i2 - 1;
                long j4 = (jC - (((long) i2) * j2)) / ((long) i3);
                int i4 = 1;
                while (i4 < i3) {
                    j3 += j2 + j4;
                    c(ttVar, messageDigest, bArr, j3, j2);
                    i4++;
                    i3 = i3;
                }
            }
            if (i2 > 1) {
                c(ttVar, messageDigest, bArr, jC - j2, j2);
            }
            String strC = c(messageDigest.digest());
            return (i2 == 1 && j2 == jC) ? strC : c(i2, j2) + ";" + strC;
        } finally {
            try {
                ttVar.tt();
            } catch (Throwable unused) {
            }
        }
    }

    private static void c(tt ttVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        ttVar.c(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int iC = ttVar.c(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (iC <= 0) {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + iC + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
            messageDigest.update(bArr, 0, iC);
            j3 += (long) iC;
        }
    }

    private static String c(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        int length = bArr.length * 2;
        char[] cArr = new char[length];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = c;
            cArr[i] = cArr2[(b & 255) >> 4];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr, 0, length);
    }

    private static String c(int i, long j) {
        return "ttmd5:1:1:" + c(i) + OapsKey.KEY_GRADE + c(j);
    }

    private static c c(String str) throws Exception {
        AnonymousClass1 anonymousClass1 = null;
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] strArrSplit = str.split(";");
        String[] strArrSplit2 = strArrSplit[0].split(x.bQ);
        c cVar = new c(anonymousClass1);
        cVar.c = Integer.parseInt(strArrSplit2[1]);
        if (cVar.c > 1) {
            return cVar;
        }
        cVar.tt = Integer.parseInt(strArrSplit2[2]);
        String[] strArrSplit3 = strArrSplit2[3].split(OapsKey.KEY_GRADE);
        cVar.ve = (int) tt(strArrSplit3[0]);
        cVar.uj = tt(strArrSplit3[1]);
        cVar.n = strArrSplit[1];
        return cVar;
    }

    private static String c(long j) {
        return Long.toHexString((j << 4) + 31);
    }

    private static long tt(String str) throws RuntimeException {
        try {
            return (Long.parseLong(str, 16) - 31) >> 4;
        } catch (Throwable unused) {
            throw new RuntimeException("ttmd5 decryptNum error, num = ".concat(String.valueOf(str)));
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 24})
    private static class c {
        public int c;
        public String n;
        public int tt;
        public long uj;
        public int ve;

        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
