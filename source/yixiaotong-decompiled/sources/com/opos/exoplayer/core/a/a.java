package com.opos.exoplayer.core.a;

import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.p;
import java.nio.ByteBuffer;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f6234a = {1, 2, 3, 6};
    private static final int[] b = {OpusUtil.SAMPLE_RATE, SWCommandUtil.SampleRate, 32000};
    private static final int[] c = {24000, 22050, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND};
    private static final int[] d = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 384, 448, 512, 576, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK};
    private static final int[] f = {69, 87, 104, 121, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 208, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, 278, MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, 417, 487, MediaPlayer.MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET, 696, 835, 975, 1114, 1253, 1393};

    /* JADX INFO: renamed from: com.opos.exoplayer.core.a.a$a, reason: collision with other inner class name */
    public static final class C0900a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6235a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        private C0900a(String str, int i, int i2, int i3, int i4, int i5) {
            this.f6235a = str;
            this.b = i;
            this.d = i2;
            this.c = i3;
            this.e = i4;
            this.f = i5;
        }

        /* synthetic */ C0900a(String str, int i, int i2, int i3, int i4, int i5, b bVar) {
            this(str, i, i2, i3, i4, i5);
        }
    }

    static /* synthetic */ class b {
    }

    public static int a() {
        return 1536;
    }

    private static int a(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = b;
        if (i >= iArr.length || i2 < 0) {
            return -1;
        }
        int[] iArr2 = f;
        if (i3 >= iArr2.length) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return (iArr2[i3] + (i2 % 2)) * 2;
        }
        int i5 = e[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }

    public static int a(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? f6234a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }

    public static int a(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        byte b2 = bArr[4];
        return a((b2 & 192) >> 6, b2 & Utf8.REPLACEMENT_BYTE);
    }

    public static Format a(p pVar, String str, String str2, DrmInitData drmInitData) {
        int i = b[(pVar.g() & 192) >> 6];
        int iG = pVar.g();
        int i2 = d[(iG & 56) >> 3];
        if ((iG & 4) != 0) {
            i2++;
        }
        return Format.a(str, MimeTypes.AUDIO_AC3, null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static C0900a a(com.opos.exoplayer.core.i.o oVar) {
        int iA;
        int i;
        int i2;
        int iC;
        String str;
        int i3;
        int iC2;
        int i4;
        int i5;
        int iB = oVar.b();
        oVar.b(40);
        boolean z = oVar.c(5) == 16;
        oVar.a(iB);
        if (z) {
            oVar.b(16);
            iC = oVar.c(2);
            oVar.b(3);
            iA = (oVar.c(11) + 1) * 2;
            int iC3 = oVar.c(2);
            if (iC3 == 3) {
                i4 = 6;
                i = c[oVar.c(2)];
                iC2 = 3;
            } else {
                iC2 = oVar.c(2);
                i4 = f6234a[iC2];
                i = b[iC3];
            }
            i3 = i4 * 256;
            int iC4 = oVar.c(3);
            boolean zE = oVar.e();
            i2 = d[iC4] + (zE ? 1 : 0);
            oVar.b(10);
            if (oVar.e()) {
                oVar.b(8);
            }
            if (iC4 == 0) {
                oVar.b(5);
                if (oVar.e()) {
                    oVar.b(8);
                }
            }
            if (iC == 1 && oVar.e()) {
                oVar.b(16);
            }
            if (oVar.e()) {
                if (iC4 > 2) {
                    oVar.b(2);
                }
                if ((iC4 & 1) != 0 && iC4 > 2) {
                    oVar.b(6);
                }
                if ((iC4 & 4) != 0) {
                    oVar.b(6);
                }
                if (zE && oVar.e()) {
                    oVar.b(5);
                }
                if (iC == 0) {
                    if (oVar.e()) {
                        oVar.b(6);
                    }
                    if (iC4 == 0 && oVar.e()) {
                        oVar.b(6);
                    }
                    if (oVar.e()) {
                        oVar.b(6);
                    }
                    int iC5 = oVar.c(2);
                    if (iC5 == 1) {
                        oVar.b(5);
                    } else if (iC5 == 2) {
                        oVar.b(12);
                    } else if (iC5 == 3) {
                        int iC6 = oVar.c(5);
                        if (oVar.e()) {
                            oVar.b(5);
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                if (oVar.e()) {
                                    oVar.b(4);
                                }
                                if (oVar.e()) {
                                    oVar.b(4);
                                }
                            }
                        }
                        if (oVar.e()) {
                            oVar.b(5);
                            if (oVar.e()) {
                                oVar.b(7);
                                if (oVar.e()) {
                                    oVar.b(8);
                                }
                            }
                        }
                        oVar.b((iC6 + 2) * 8);
                        oVar.f();
                    }
                    if (iC4 < 2) {
                        if (oVar.e()) {
                            oVar.b(14);
                        }
                        if (iC4 == 0 && oVar.e()) {
                            oVar.b(14);
                        }
                    }
                    if (oVar.e()) {
                        if (iC2 == 0) {
                            oVar.b(5);
                        } else {
                            for (int i6 = 0; i6 < i4; i6++) {
                                if (oVar.e()) {
                                    oVar.b(5);
                                }
                            }
                        }
                    }
                }
            }
            if (oVar.e()) {
                oVar.b(5);
                if (iC4 == 2) {
                    oVar.b(4);
                }
                if (iC4 >= 6) {
                    oVar.b(2);
                }
                if (oVar.e()) {
                    oVar.b(8);
                }
                if (iC4 == 0 && oVar.e()) {
                    oVar.b(8);
                }
                i5 = 3;
                if (iC3 < 3) {
                    oVar.d();
                }
            } else {
                i5 = 3;
            }
            if (iC == 0 && iC2 != i5) {
                oVar.d();
            }
            if (iC == 2 && (iC2 == i5 || oVar.e())) {
                oVar.b(6);
            }
            str = (oVar.e() && oVar.c(6) == 1 && oVar.c(8) == 1) ? MimeTypes.AUDIO_E_AC3_JOC : MimeTypes.AUDIO_E_AC3;
        } else {
            oVar.b(32);
            int iC7 = oVar.c(2);
            iA = a(iC7, oVar.c(6));
            oVar.b(8);
            int iC8 = oVar.c(3);
            if ((iC8 & 1) != 0 && iC8 != 1) {
                oVar.b(2);
            }
            if ((iC8 & 4) != 0) {
                oVar.b(2);
            }
            if (iC8 == 2) {
                oVar.b(2);
            }
            i = b[iC7];
            i2 = d[iC8] + (oVar.e() ? 1 : 0);
            iC = -1;
            str = MimeTypes.AUDIO_AC3;
            i3 = 1536;
        }
        return new C0900a(str, iC, i2, i, iA, i3, null);
    }

    public static int b(ByteBuffer byteBuffer) {
        if (byteBuffer.getInt(byteBuffer.position() + 4) != -1167101192) {
            return 0;
        }
        return 40 << (byteBuffer.get(byteBuffer.position() + 8) & 7);
    }

    public static int b(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && bArr[7] == -70) {
            return 40 << (bArr[8] & 7);
        }
        return 0;
    }

    public static Format b(p pVar, String str, String str2, DrmInitData drmInitData) {
        pVar.d(2);
        int i = b[(pVar.g() & 192) >> 6];
        int iG = pVar.g();
        int i2 = d[(iG & 14) >> 1];
        if ((iG & 1) != 0) {
            i2++;
        }
        if (((pVar.g() & 30) >> 1) > 0 && (2 & pVar.g()) != 0) {
            i2 += 2;
        }
        return Format.a(str, (pVar.b() <= 0 || (pVar.g() & 1) == 0) ? MimeTypes.AUDIO_E_AC3 : MimeTypes.AUDIO_E_AC3_JOC, null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }
}
