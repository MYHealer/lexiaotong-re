package com.byazt.zlb;

import com.byazt.bzd.x;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 568, 20})
public final class c implements com.byazt.sq.ve.c {
    public final com.byazt.sq.ve.c c;
    public tt tt = new tt();

    /* JADX INFO: renamed from: com.byazt.zlb.c$c, reason: collision with other inner class name */
    private interface InterfaceC0347c {
        void c(String str, String str2);
    }

    public c(com.byazt.sq.ve.c cVar) {
        this.c = cVar;
    }

    @Override // com.byazt.sq.ve.c
    public void c(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            c(str, str2, new InterfaceC0347c() { // from class: com.byazt.zlb.c.1
                @Override // com.byazt.zlb.c.InterfaceC0347c
                public void c(String str3, String str4) {
                    c.this.c.c(str3, str4);
                }
            });
        } else {
            this.c.c(str, str2);
        }
    }

    @Override // com.byazt.sq.ve.c
    public void tt(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            c(str, str2, new InterfaceC0347c() { // from class: com.byazt.zlb.c.2
                @Override // com.byazt.zlb.c.InterfaceC0347c
                public void c(String str3, String str4) {
                    c.this.c.tt(str3, str4);
                }
            });
        } else {
            this.c.tt(str, str2);
        }
    }

    @Override // com.byazt.sq.ve.c
    public void ve(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            c(str, str2, new InterfaceC0347c() { // from class: com.byazt.zlb.c.3
                @Override // com.byazt.zlb.c.InterfaceC0347c
                public void c(String str3, String str4) {
                    c.this.c.ve(str3, str4);
                }
            });
        } else {
            this.c.ve(str, str2);
        }
    }

    @Override // com.byazt.sq.ve.c
    public void uj(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            c(str, str2, new InterfaceC0347c() { // from class: com.byazt.zlb.c.4
                @Override // com.byazt.zlb.c.InterfaceC0347c
                public void c(String str3, String str4) {
                    c.this.c.uj(str3, str4);
                }
            });
        } else {
            this.c.uj(str, str2);
        }
    }

    @Override // com.byazt.sq.ve.c
    public void c(String str, String str2, Throwable th) {
        this.c.c(str, str2, th);
    }

    @Override // com.byazt.sq.ve.c
    public void n(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            c(str, str2, new InterfaceC0347c() { // from class: com.byazt.zlb.c.5
                @Override // com.byazt.zlb.c.InterfaceC0347c
                public void c(String str3, String str4) {
                    c.this.c.n(str3, str4);
                }
            });
        } else {
            this.c.n(str, str2);
        }
    }

    @Override // com.byazt.sq.ve.c
    public void tt(String str, String str2, Throwable th) {
        this.c.tt(str, str2, th);
    }

    @Override // com.byazt.sq.ve.c
    public void c(String str, Throwable th) {
        this.c.c(str, th);
    }

    @Override // com.byazt.sq.ve.c
    public void c() {
        this.c.c();
    }

    private void c(final String str, final String str2, final InterfaceC0347c interfaceC0347c) {
        try {
            if (x.c()) {
                x.tt(new Runnable() { // from class: com.byazt.zlb.c.6
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.tt.c(str, str2, interfaceC0347c);
                    }
                });
            } else {
                this.tt.c(str, str2, interfaceC0347c);
            }
        } catch (Throwable th) {
            m.tt("", "print big Str failed!", th);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 568, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private class tt {
        private tt() {
        }

        public void c(String str, String str2, InterfaceC0347c interfaceC0347c) {
            String hexString = Integer.toHexString(str2.hashCode());
            int i = 0;
            while (i < str2.length()) {
                int iMin = Math.min(i + 4096, str2.length());
                interfaceC0347c.c(c(str, hexString, i, iMin), str2.substring(i, iMin));
                i = iMin;
            }
        }

        private String c(String str, String str2, int i, int i2) {
            return str + "_" + i + "_" + i2 + "_" + str2;
        }
    }
}
