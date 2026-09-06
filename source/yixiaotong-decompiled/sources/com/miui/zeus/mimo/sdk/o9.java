package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import client.android.yixiaotong.util.doorlock.DoorLockCommandUtil;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.hihonor.adsdk.base.ErrorCode;
import com.miui.zeus.comp.videoplayer.PlayState;
import com.miui.zeus.comp.zeusplayer.xiaomiplayer.ZeusMediaXiaoMiPlayer;
import java.util.ArrayList;
import java.util.Map;
import org.videolan.libvlc.IVLCVout;
import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;
import org.videolan.libvlc.VLCEvent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o9 extends i9 implements IVLCVout.Callback, IVLCVout.OnNewVideoLayoutListener, MediaPlayer.EventListener {
    public static boolean R;
    public boolean B;
    public boolean C;
    public boolean D;
    public long F;
    public long G;
    public int I;
    public String J;
    public boolean L;
    public Context f;
    public Media g;
    public Media h;
    public LibVLC i;
    public LibVLC j;
    public MediaPlayer k;
    public MediaPlayer l;
    public Uri n;
    public String o;
    public ArrayList<String> y;
    public boolean z;
    public int s = 0;
    public long w = -1;
    public long x = -1;
    public long q = -1;
    public long r = -1;
    public int t = -1;
    public int u = -1;
    public int v = -1;
    public int p = -1;
    public float E = -1.0f;
    public String A = null;
    public boolean H = false;
    public boolean K = false;
    public boolean M = false;
    public boolean N = false;
    public boolean O = false;
    public boolean P = false;
    public long Q = -1;
    public Surface m = null;

    public static class a implements p9 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5556a = 0;

        @Override // com.miui.zeus.mimo.sdk.p9
        public int a() {
            return this.f5556a;
        }
    }

    public o9(Context context) {
        this.f = context;
    }

    public void a(float f, float f2) {
        MediaPlayer mediaPlayer = this.k;
        if (mediaPlayer != null) {
            float f3 = f + f2;
            mediaPlayer.setVolume((int) ((100.0f * f3) / 2.0f));
            this.E = f3 / 2.0f;
        }
    }

    public void a(long j) {
        if (this.k != null) {
            if (j < 0) {
                j = 0;
            } else {
                long j2 = this.w;
                if (j2 > 0 && j > j2) {
                    j = j2;
                }
            }
            if (this.L) {
                this.L = false;
            }
            this.x = j;
            this.Q = System.currentTimeMillis();
            this.k.setTime(j, true);
        }
    }

    public void a(Surface surface) {
        MediaPlayer mediaPlayer = this.k;
        if (mediaPlayer != null) {
            if (surface != null) {
                if (this.m != null && mediaPlayer.getVLCVout().areViewsAttached()) {
                    this.k.getVLCVout().removeCallback(this);
                    this.k.getVLCVout().detachViews();
                }
                this.k.getVLCVout().setVideoSurface(surface, null);
                this.k.getVLCVout().addCallback(this);
                this.k.getVLCVout().attachViews(this);
                this.k.setSurface(true);
            } else {
                mediaPlayer.getVLCVout().removeCallback(this);
                this.k.getVLCVout().detachViews();
            }
        }
        this.m = surface;
    }

    public void a(String str, Map<String, String> map) {
        long j;
        ArrayList<String> arrayList;
        String strD;
        ArrayList<String> arrayList2;
        String strD2;
        this.z = false;
        this.C = false;
        this.F = 0L;
        this.G = 0L;
        this.H = false;
        this.B = false;
        String str2 = map.get(ijiami_1011.s.s.s.d(new byte[]{70, Ascii.SYN, 3, 2, 82, 68, 76, Ascii.ETB, 9, 4, 69, 72, 82, 1, 5, 11, 83, 83, 19}, "6dfd76"));
        if (str2 != null && str2.toString().compareTo(ijiami_1011.s.s.s.d(new byte[]{4}, "52f66f")) == 0) {
            this.C = true;
        }
        String str3 = map.get(ijiami_1011.s.s.s.d(new byte[]{86, 92, 93, 86, 83, Ascii.RS, 13, 1, 16, 7, 93}, "539303"));
        int i = str3 != null ? Integer.parseInt(str3.toString()) : 0;
        String str4 = map.get(ijiami_1011.s.s.s.d(new byte[]{87, 91, 74, 5, 81, 13, 4, 73, 5, 13, 85, 0, 80, Ascii.US, 87, 5, 94, 4}, "329d3a"));
        String string = str4 != null ? str4.toString() : null;
        String str5 = map.get(ijiami_1011.s.s.s.d(new byte[]{92, 95, Ascii.NAK, 84, 4, 15, 4, 73, 7, Ascii.ETB, 85, 12, 87}, "86f5fc"));
        boolean z = str5 != null && str5.toString().compareTo(ijiami_1011.s.s.s.d(new byte[]{0}, "12d705")) == 0;
        String str6 = map.get(ijiami_1011.s.s.s.d(new byte[]{82, 2, 71, 84, Ascii.NAK, 93}, "3f45c8"));
        String string2 = str6 != null ? str6.toString() : null;
        String str7 = map.get(ijiami_1011.s.s.s.d(new byte[]{68, 16, 2, 19, SignedBytes.MAX_POWER_OF_TWO, 78, Ascii.NAK, 13, 11, 7}, "7dca4c"));
        if (str7 != null) {
            j = Long.parseLong(str7.toString());
            this.x = j;
        } else {
            j = 0;
        }
        String str8 = map.get(ijiami_1011.s.s.s.d(new byte[]{73, 17, 81, 71, 81, 70, 4, 73, Ascii.SYN, 3, 68, Ascii.SYN, 92, 7}, "9c4704"));
        boolean z2 = str8 != null && str8.toString().compareTo(ijiami_1011.s.s.s.d(new byte[]{5}, "4fe5ac")) == 0;
        String str9 = map.get(ijiami_1011.s.s.s.d(new byte[]{84, 1, 71, 80, 86, 82, 76, 16, Ascii.US, Ascii.DC2, 84}, "0d1957"));
        if (str9 != null) {
            this.A = str9.toString();
        }
        String str10 = map.get(ijiami_1011.s.s.s.d(new byte[]{74, 13, 13, 66, 76, 16, Ascii.NAK, 5, Ascii.DC4, Ascii.SYN, Ascii.FS, 17, 80, 12, 7}, "9ab5ac"));
        if (str10 != null) {
            this.F = Long.parseLong(str10.toString());
        }
        String str11 = map.get(ijiami_1011.s.s.s.d(new byte[]{70, 9, 10, Ascii.SYN, 73, 92, 15, 0, 75, Ascii.SYN, 88, 8, 80}, "5eead9"));
        if (str11 != null) {
            this.G = Long.parseLong(str11.toString());
        }
        String str12 = map.get(ijiami_1011.s.s.s.d(new byte[]{82, 13, Ascii.ESC, 67, 14, 89, Ascii.SYN, 73, 11, 13, 69, 12, 92, 10}, "3d60b6"));
        if (str12 != null && str12.toString().compareTo(ijiami_1011.s.s.s.d(new byte[]{7}, "6982b2")) == 0) {
            this.H = true;
        }
        String str13 = map.get(ijiami_1011.s.s.s.d(new byte[]{94, 13, 70, 71, Ascii.DC2, 79, Ascii.DC2, 8, 7, Ascii.DC4, 84}, "7c62fb"));
        if (str13 != null) {
            this.J = str13.toString();
        }
        String str14 = map.get(ijiami_1011.s.s.s.d(new byte[]{67, 84, 19, 74, 3, 73, 0, 2, Ascii.DC2, 7, 67, 72, 86, 90, 0}, "35f9fd"));
        boolean z3 = str14 != null && str14.toString().compareTo(ijiami_1011.s.s.s.d(new byte[]{84}, "eb1873")) == 0;
        String str15 = map.get(ijiami_1011.s.s.s.d(new byte[]{4, 66, 2, 8, 12, 76, Ascii.NAK, Ascii.SYN, 7, 1, 90}, "e7faca"));
        if (str15 != null) {
            this.I = Integer.parseInt(str15.toString());
        }
        if (map.get(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 95, 82, 76, 19, 10, 5, 1, 9, 79, 94, Ascii.NAK, 4, 93, 86, 13}, "a31aec")) != null) {
            this.z = true;
        }
        if (map.get(ijiami_1011.s.s.s.d(new byte[]{91, 12, Ascii.US, 70, 66, 3, 76, 5, 19, Ascii.SYN, 94, 1, 80, Ascii.ETB, 87, 86, 67}, "5c257a")) != null) {
            this.B = true;
        }
        if (!R) {
            String str16 = map.get(ijiami_1011.s.s.s.d(new byte[]{66, 4, 10, Ascii.SYN, Ascii.NAK, 73, 19, 1, Ascii.SYN, 3, 67, 0}, "5ecb89"));
            if (str16 == null || str16.toString().compareTo(ijiami_1011.s.s.s.d(new byte[]{0}, "125bab")) != 0) {
                R = false;
            } else {
                R = true;
            }
        }
        if (this.y == null) {
            this.y = new ArrayList<>(50);
        }
        ArrayList<String> arrayList3 = this.y;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        if (this.y.isEmpty()) {
            this.y.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 65, SignedBytes.MAX_POWER_OF_TWO}, "27604b"));
            this.y.add(ijiami_1011.s.s.s.d(new byte[]{73, 26, 88, 4, Ascii.DC2, 67, 14, Ascii.SYN, 13, 79, 82, 4, 7, 95, 95, 15, 1, 9, 83, 84, 86, 82}, "d76af4"));
            this.y.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.FS, Ascii.US, 82, 8, 89, 92, 76, 7, 7, 1, 89, 12, 95, 85, 9, 87, 5, 9, 81}, "124a59"));
            this.y.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, 76, 84, 68, 83, 88, 14, 73, Ascii.DC2, 11, 92, 0, Ascii.EM, Ascii.DC2, 65, 67, 82, 69, 2, 12}, "4a5171"));
            this.y.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 73, 89, 10, 79, Ascii.NAK, 14, 8, 19, 15, 84, 72, 74, 5, 65, 0}, "9d7ebc"));
            this.y.add(ijiami_1011.s.s.s.d(new byte[]{26, Ascii.CAN, 86, 15, 6, 71, 14, 13, 2, 79, 85, 12, 68, 69, 91, 0, Ascii.ESC, Ascii.CAN, 2, 12, Ascii.DC4, 13, 92, 4}, "757ab5"));
            if (ijiami_1011.s.s.s.d(new byte[]{11, 8, Ascii.SYN, 67, 7, 6}, "fab5fb").equals(this.A)) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{103, 100, 80, 2}, "52c0eb"));
            } else {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{111, 55, 80, 4}, "6aa635"));
            }
            this.y.add(ijiami_1011.s.s.s.d(new byte[]{26, 73, 17, Ascii.ETB, 86, 78, 15, 11, Ascii.DC2, 11, 87, Ascii.FS}, "7dbb4c"));
            this.y.add(ijiami_1011.s.s.s.d(new byte[]{78, Ascii.US, 80, 84, 95, 19, Ascii.EM}, "c2412f"));
            this.y.add(ijiami_1011.s.s.s.d(new byte[]{2, 65, 2, 93, 67, 8, 0, 16, 74, 3, 95, Ascii.FS}, "c7d21e"));
            this.y.add(ijiami_1011.s.s.s.d(new byte[]{89, 66, 84, 13, 85, 82, 2, 73, 14, Ascii.ETB, 67, Ascii.ETB, 65, Ascii.EM, 66, Ascii.DC2}, "847b17"));
            this.y.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.GS, Ascii.FS, 82, 14, 5, 7, 2}, "011aab"));
            if (this.C) {
                arrayList = this.y;
                strD = ijiami_1011.s.s.s.d(new byte[]{87, Ascii.NAK, 84, 11, 7, 7, 2, 72, 7, 14, 93}, "6c7dcb");
            } else {
                arrayList = this.y;
                strD = ijiami_1011.s.s.s.d(new byte[]{84, 84, 83, 13, 86, 82, 14, 0, 3, 1, 110, 15, 87, 88, Ascii.ESC, 5, 91, 93}, "917d71");
            }
            arrayList.add(strD);
            this.y.add(ijiami_1011.s.s.s.d(new byte[]{73, 78, 7, 86, 16, 70, 92, 5, 8, 6, 67, 10, 13, 7, 57, 88, 16, 86, 8, 11, Ascii.DC2, 16, 80, 6, 15, 79, 8, 86, 11, 87}, "dcf9e2"));
            if (this.z) {
                arrayList2 = this.y;
                strD2 = ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 26, SignedBytes.MAX_POWER_OF_TWO, 13, 68, 76, 92, 3, 10, 7, 66, 87, Ascii.EM, 89, 89, 12, 84}, "576b18");
            } else {
                arrayList2 = this.y;
                strD2 = ijiami_1011.s.s.s.d(new byte[]{Ascii.FS, 73, 71, 94, 69, 65, 92, 5, 8, 6, 67, 10, 88, 0, 110, 85, 89, 70, 17, 8, 7, Ascii.ESC, Ascii.GS, 11, 94, 10, 84}, "1d1105");
            }
            arrayList2.add(strD2);
            if (i > 0) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.ESC, 75, 91, 91, 84, 93, 2, 73, 10, 7, 71, 0, 90, 91}, "6f8408") + i);
            }
            if (string != 0) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{26, Ascii.ESC, 82, 12, Ascii.ETB, 0, 3, 8, 3, 79, 82, 10, 83, 83, 85, 72, 10, 0, 12, 1}, "766eda"));
                this.y.add(string);
            }
            if (z) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.ESC, 26, 84, 13, Ascii.ETB, 80, 3, 8, 3, 79, 80, 16, 82, 94, 95}, "670dd1"));
            }
            if (j != 0) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.FS, Ascii.ESC, 66, 77, 0, Ascii.ETB, Ascii.NAK, 73, Ascii.DC2, 11, 92, 0, 12}, "1619ae") + (j / 1000.0f));
            }
            if (this.A != null) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{72, Ascii.ESC, 93, 3, 19, 95, 2, 1, 75, Ascii.SYN, 72, Ascii.NAK, 0, 11}, "e69fe6") + this.A);
            }
            if (string2 != null) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{26, Ascii.US, 86, 67, 81, 94, 76, 11, Ascii.SYN, Ascii.SYN, 88, 10, 89, 65, 10, 78, 72, 89, 14, 10, 3, 79, 89, 17, 67, 66, 26, 81, 77, 92, 17, Ascii.ETB, Ascii.DC2, 16, 84, 4, 90, Ascii.US, 81, 92, 84, 84, 15, 5, 11, 7, 12}, "727581") + string2 + ijiami_1011.s.s.s.d(new byte[]{68}, "96b0e8"));
            }
            if (z2) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, Ascii.CAN, 75, 68, 0, Ascii.DC4, Ascii.NAK, 73, Ascii.SYN, 3, 68, Ascii.SYN, 81, 81}, "4580af"));
            }
            long j2 = this.F;
            if (j2 != 0) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, Ascii.CAN, 75, 9, 9, SignedBytes.MAX_POWER_OF_TWO, 76, Ascii.ETB, Ascii.DC2, 3, 67, 17, Ascii.EM, 65, 81, 8, 3, 10}, "458ef7") + (j2 / 1000.0f));
            }
            long j3 = this.G;
            if (j3 != 0) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{78, Ascii.CAN, Ascii.NAK, 93, 14, Ascii.DC4, 76, 1, 8, 6, Ascii.FS, 17, 10, 88, 3, 12}, "c5f1ac") + (j3 / 1000.0f));
            }
            if (this.H) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{78, 78, 89, 88, Ascii.NAK, Ascii.ETB, 13, 11, 17, 79, 92, 10, Ascii.ETB, 10, 87, 95}, "cc818d"));
            }
            if (this.J != null) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{76, Ascii.US, 93, 87, Ascii.NAK, Ascii.DC4, Ascii.NAK, 73, Ascii.NAK, 14, 80, 19, 4, 15}, "a249ea") + this.J);
            }
            if (this.I != 0) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.FS, Ascii.EM, 81, 69, 86, 10, 14, 73, Ascii.DC2, 16, 80, 6, 90, 9}, "14002c") + this.I);
            }
            if (z3) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, Ascii.GS, Ascii.NAK, 95, 83, 79, 76, 5, 8, 6, Ascii.FS, Ascii.NAK, 85, 69, Ascii.SYN, 86}, "40e326"));
            }
            if (this.B) {
                this.y.add(ijiami_1011.s.s.s.d(new byte[]{75, 72, 13, 11, Ascii.DC4, 17, Ascii.DC4, 6, 75, 3, 68, 17, 9, 1, 6, 16, 92, 1, Ascii.NAK, 73, 0, 11, 93, 0}, "fecd9b"));
            }
        }
        String scheme = Uri.parse(str).getScheme();
        if (TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase(ijiami_1011.s.s.s.d(new byte[]{84, 93, 84, 83}, "248618"))) {
            this.s = 2;
            this.o = str;
        } else {
            this.s = 1;
            this.n = Uri.parse(str);
        }
    }

    public final void b() {
        int i = 0;
        while (this.M && R) {
            if (i > 8) {
                this.M = false;
            }
            try {
                Thread.sleep(50L);
            } catch (Exception unused) {
            }
            i++;
        }
        h();
    }

    public long c() {
        MediaPlayer mediaPlayer = this.k;
        if (mediaPlayer == null) {
            return 0L;
        }
        long j = this.x;
        return j >= 0 ? j : mediaPlayer.getTime();
    }

    public long d() {
        MediaPlayer mediaPlayer = this.k;
        if (mediaPlayer != null) {
            this.w = mediaPlayer.getLength();
        }
        return this.w;
    }

    public boolean e() {
        MediaPlayer mediaPlayer = this.k;
        if (mediaPlayer != null) {
            return mediaPlayer.isLooping();
        }
        return false;
    }

    public boolean f() {
        MediaPlayer mediaPlayer = this.k;
        if (mediaPlayer == null || this.K) {
            return false;
        }
        return mediaPlayer.isPlaying();
    }

    public void finalize() {
        if (this.k != null && !this.K) {
            h();
            a();
            this.m = null;
            this.f = null;
        }
        this.M = false;
    }

    public void g() {
        Media media;
        Media media2;
        String strD;
        this.M = true;
        if (!this.K && !this.O && this.k != null) {
            h();
        }
        LibVLC libVLC = new LibVLC(this.f, this.y);
        this.i = libVLC;
        MediaPlayer mediaPlayer = new MediaPlayer(libVLC);
        this.k = mediaPlayer;
        mediaPlayer.setEventListener((MediaPlayer.EventListener) this);
        int i = this.s;
        if (i == 1) {
            media = new Media(this.i, this.n);
        } else if (i == 2) {
            media = new Media(this.i, this.o);
        } else if (i != 3) {
            return;
        } else {
            media = new Media(this.i, this.p, this.q, this.r);
        }
        this.g = media;
        this.g.addOption(ijiami_1011.s.s.s.d(new byte[]{89, 87, 92, Ascii.ETB, 78, 95, 19, 15, 75, 1, 80, 6, 11, 80, 87, 4, 4, 2, 81, 84}, "c99c90"));
        this.g.addOption(ijiami_1011.s.s.s.d(new byte[]{12, 81, 11, 8, 6, Ascii.GS, 2, 5, 5, 10, 88, 11, 81, 10, 84, 84, 83, 0}, "67bdc0"));
        if (this.C) {
            media2 = this.g;
            strD = ijiami_1011.s.s.s.d(new byte[]{12, 5, 10, 93, 85, 2, 92, 5, 16, 1, 94, 1, 83, 5, 73, 88, 92, 13}, "6fe90a");
        } else {
            media2 = this.g;
            strD = ijiami_1011.s.s.s.d(new byte[]{92, 0, 10, 1, 84, 5, 92, 9, 3, 6, 88, 4, 5, 12, 1, 0, 82, 57, 11, 10, 15, 78, 80, 9, 10}, "fcee1f");
        }
        media2.addOption(strD);
        this.k.setMedia(this.g);
        if (this.m != null) {
            this.k.getVLCVout().setVideoSurface(this.m, null);
            this.k.getVLCVout().addCallback(this);
            this.k.getVLCVout().attachViews(this);
            this.k.setSurface(true);
        }
        this.k.play();
    }

    public final synchronized void h() {
        boolean z;
        int i = 0;
        while (true) {
            z = this.O;
            if ((!z && !this.P && this.l == null) || i >= 1000) {
                break;
            }
            try {
                Thread.sleep(10L);
            } catch (Exception unused) {
            }
            i += 10;
        }
        if (z) {
            MediaPlayer mediaPlayer = this.k;
            if (mediaPlayer != null) {
                if (mediaPlayer.getVLCVout().areViewsAttached()) {
                    this.k.getVLCVout().removeCallback(this);
                    this.k.getVLCVout().detachViews();
                }
                this.k.setEventListener((MediaPlayer.EventListener) null);
                this.k.release();
                this.k = null;
            }
            Media media = this.g;
            if (media != null) {
                media.release();
                this.g = null;
            }
            LibVLC libVLC = this.i;
            if (libVLC != null) {
                libVLC.release();
                this.i = null;
            }
            b(DoorLockCommandUtil.AUTHFAILCODE, 0);
        } else {
            this.O = true;
            this.l = this.k;
            this.h = this.g;
            this.j = this.i;
            this.k = null;
            this.g = null;
            this.i = null;
            i();
        }
    }

    public final void i() {
        MediaPlayer mediaPlayer = this.l;
        if (mediaPlayer != null) {
            mediaPlayer.setEventListener((MediaPlayer.EventListener) null);
            this.l.release();
        }
        Media media = this.h;
        if (media != null) {
            media.release();
            this.h = null;
        }
        LibVLC libVLC = this.j;
        if (libVLC != null) {
            libVLC.release();
            this.j = null;
        }
        this.O = false;
        MediaPlayer mediaPlayer2 = this.l;
        if (mediaPlayer2 != null) {
            if (mediaPlayer2.getVLCVout().areViewsAttached()) {
                this.l.getVLCVout().detachViews();
            }
            this.l.getVLCVout().removeCallback(this);
            this.l = null;
        }
        b(DoorLockCommandUtil.AUTHFAILCODE, 0);
    }

    public void j() {
        if (this.k != null) {
            if (this.L) {
                this.L = false;
                a(0L);
            }
            this.k.play();
            if (this.D) {
                this.D = false;
                a(c());
            }
        }
    }

    @Override // org.videolan.libvlc.VLCEvent.Listener
    public void onEvent(VLCEvent vLCEvent) {
        int snapShot;
        int i;
        int i2;
        Uri uri;
        j9 j9Var;
        int i3;
        Uri uri2;
        Uri uri3;
        MediaPlayer.Event event = (MediaPlayer.Event) vLCEvent;
        int i4 = event.type;
        if (i4 == 259) {
            float buffering = event.getBuffering();
            if (buffering == 100.0f) {
                if (this.N) {
                    this.N = false;
                    i2 = 702;
                    b(i2, 0);
                }
                return;
            }
            if (!this.N && f()) {
                this.N = true;
                b(701, 0);
            }
            Uri uri4 = this.n;
            if (uri4 == null || !uri4.getScheme().startsWith(ijiami_1011.s.s.s.d(new byte[]{92, 65, Ascii.DC2, 70}, "45f6f8"))) {
                return;
            }
            snapShot = (int) buffering;
            i = ErrorCode.d.hnadse;
            b(i, snapShot);
            return;
        }
        if (i4 == 260) {
            this.P = true;
            for (int i5 = 0; this.O && i5 < 1000; i5 += 5) {
                try {
                    Thread.sleep(5L);
                } catch (Exception unused) {
                }
            }
            this.P = false;
            return;
        }
        if (i4 == 273) {
            this.w = event.getLengthChanged();
            return;
        }
        if (i4 == 274) {
            event.getVoutCount();
            return;
        }
        if (i4 != 4096) {
            if (i4 == 4097) {
                a(DoorLockCommandUtil.SELECTKEYFAILCODE, 0);
                return;
            }
            switch (i4) {
                case 265:
                    long jD = d();
                    long jC = c();
                    if ((jD > 0 && jD - jC <= C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) || (uri = this.n) == null || !uri.getScheme().startsWith(ijiami_1011.s.s.s.d(new byte[]{93, 77, 77, Ascii.SYN}, "599fb3"))) {
                        j9Var = this.b;
                        if (j9Var == null) {
                        }
                        ZeusMediaXiaoMiPlayer.g gVar = (ZeusMediaXiaoMiPlayer.g) j9Var;
                        ZeusMediaXiaoMiPlayer.this.updateState(PlayState.ENDED);
                        ZeusMediaXiaoMiPlayer.this.notifyOnFinished();
                    }
                    a(1, -10105);
                    break;
                case 266:
                    a(1, event.getErrorCode());
                    break;
                case 267:
                    event.getTimeChanged();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (this.x >= 0 && jCurrentTimeMillis - this.Q > 80) {
                        this.x = -1L;
                        break;
                    }
                    break;
                case 268:
                    event.getPositionChanged();
                    break;
                case 269:
                    event.getSeekable();
                    break;
                case 270:
                    event.getPausable();
                    break;
                default:
                    switch (i4) {
                        case 276:
                        case 277:
                        case 278:
                            int esChangedType = event.getEsChangedType();
                            int esChangedID = event.getEsChangedID();
                            if (esChangedType == 1) {
                                i3 = ErrorCode.d.hnadsj;
                            } else if (esChangedType == 2) {
                                i3 = ErrorCode.d.hnadsk;
                            }
                            b(i3, esChangedID);
                            break;
                        default:
                            switch (i4) {
                                case 286:
                                    i2 = 100001;
                                    break;
                                case 287:
                                    this.t = event.getVideoWidth();
                                    this.u = event.getVideoHeight();
                                    this.v = event.getVideoSarNum();
                                    event.getVideoSarDen();
                                    int i6 = this.t;
                                    int i7 = this.u;
                                    n9 n9Var = this.c;
                                    if (n9Var != null) {
                                        ZeusMediaXiaoMiPlayer.this.notifyOnVideoSizeChanged(i6, i7);
                                    }
                                    break;
                                case 288:
                                    b(ErrorCode.d.hnadsc, 0);
                                    break;
                                case 289:
                                    a(-1010, 0);
                                    break;
                                case 290:
                                    this.M = false;
                                    m9 m9Var = this.f5464a;
                                    if (m9Var != null) {
                                        ZeusMediaXiaoMiPlayer.a aVar = (ZeusMediaXiaoMiPlayer.a) m9Var;
                                        ZeusMediaXiaoMiPlayer.this.mIsPrepared = true;
                                        ZeusMediaXiaoMiPlayer zeusMediaXiaoMiPlayer = ZeusMediaXiaoMiPlayer.this;
                                        if (zeusMediaXiaoMiPlayer.mPlayWhenReady) {
                                            zeusMediaXiaoMiPlayer.updateState(PlayState.PLAYING);
                                            ZeusMediaXiaoMiPlayer.this.asyncCall(new k(aVar));
                                        } else {
                                            zeusMediaXiaoMiPlayer.updateState(PlayState.PAUSED);
                                        }
                                        ZeusMediaXiaoMiPlayer.this.notifyOnPrepared();
                                    }
                                    break;
                                case 291:
                                    event.getSubtitleText();
                                    event.getSubtitleStart();
                                    event.getSubtitleDuration();
                                    break;
                                case 292:
                                    b(ErrorCode.d.hnadsg, event.getSubtitleLoadStatus());
                                    break;
                                case 293:
                                    float f = this.E;
                                    if (f != -1.0f) {
                                        a(f, f);
                                    }
                                    break;
                                case 294:
                                    event.getCacheChanged();
                                    break;
                                case 295:
                                    long jD2 = d();
                                    long jC2 = c();
                                    if ((jD2 > 0 && jD2 - jC2 <= C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) || (uri2 = this.n) == null || !uri2.getScheme().startsWith(ijiami_1011.s.s.s.d(new byte[]{94, SignedBytes.MAX_POWER_OF_TWO, 71, Ascii.SYN}, "643f9c"))) {
                                        this.L = true;
                                        j9Var = this.b;
                                        if (j9Var == null) {
                                        }
                                        ZeusMediaXiaoMiPlayer.g gVar2 = (ZeusMediaXiaoMiPlayer.g) j9Var;
                                        ZeusMediaXiaoMiPlayer.this.updateState(PlayState.ENDED);
                                        ZeusMediaXiaoMiPlayer.this.notifyOnFinished();
                                    }
                                    a(1, -10105);
                                    break;
                                case 296:
                                    if (f()) {
                                        a(c());
                                    } else {
                                        this.D = true;
                                    }
                                    break;
                                case 297:
                                    long jD3 = d();
                                    long jC3 = c();
                                    if (jD3 > 0 && (jD3 - jC3 <= C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS || (uri3 = this.n) == null || !uri3.getScheme().startsWith(ijiami_1011.s.s.s.d(new byte[]{89, SignedBytes.MAX_POWER_OF_TWO, 16, Ascii.DC4}, "14ddda")) || e())) {
                                        b(ErrorCode.d.hnadsi, 0);
                                    }
                                    a(1, -10105);
                                    break;
                                default:
                                    switch (i4) {
                                        case 299:
                                            snapShot = event.getSnapShot();
                                            i = 100008;
                                            b(i, snapShot);
                                            break;
                                        case 300:
                                            i2 = 100009;
                                            break;
                                        case 301:
                                            i2 = 100010;
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
            return;
        }
        i2 = DoorLockCommandUtil.DELECTUSERIDCODE;
        b(i2, 0);
    }

    @Override // org.videolan.libvlc.IVLCVout.OnNewVideoLayoutListener
    public void onNewVideoLayout(IVLCVout iVLCVout, int i, int i2, int i3, int i4, int i5, int i6) {
    }

    @Override // org.videolan.libvlc.IVLCVout.Callback
    public void onSurfacesCreated(IVLCVout iVLCVout) {
    }

    @Override // org.videolan.libvlc.IVLCVout.Callback
    public void onSurfacesDestroyed(IVLCVout iVLCVout) {
        for (int i = 0; this.O && i < 1000; i += 20) {
            try {
                Thread.sleep(20L);
            } catch (Exception unused) {
            }
        }
    }
}
