package com.byazt.kt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 20})
public class c implements sp.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sp f2430a;
    public final ArrayList<tt> c;
    public final boolean n;
    public com.byazt.kpm.uj.c<tt> sp;
    public final ArrayList<tt> tt;
    public Runnable uj;
    public final InterfaceC0203c ve;
    public int x;

    /* JADX INFO: renamed from: com.byazt.kt.c$c, reason: collision with other inner class name */
    interface InterfaceC0203c {
        RecyclerView.gu c(int i);

        void c(int i, int i2);

        void c(int i, int i2, Object obj);

        void tt(int i, int i2);

        void uj(int i, int i2);

        void ve(int i, int i2);
    }

    public boolean c(int i) {
        return (i & this.x) != 0;
    }

    public c(InterfaceC0203c interfaceC0203c) {
        this(interfaceC0203c, false);
    }

    public c(InterfaceC0203c interfaceC0203c, boolean z) {
        this.sp = new com.byazt.kpm.uj.tt(30);
        this.c = new ArrayList<>();
        this.tt = new ArrayList<>();
        this.x = 0;
        this.ve = interfaceC0203c;
        this.n = z;
        this.f2430a = new sp(this);
    }

    public void c() {
        c(this.c);
        c(this.tt);
        this.x = 0;
    }

    public void tt() {
        this.f2430a.c(this.c);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            tt ttVar = this.c.get(i);
            int i2 = ttVar.c;
            if (i2 == 1) {
                a(ttVar);
            } else if (i2 == 2) {
                ve(ttVar);
            } else if (i2 == 4) {
                uj(ttVar);
            } else if (i2 == 8) {
                tt(ttVar);
            }
            Runnable runnable = this.uj;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.c.clear();
    }

    public void ve() {
        int size = this.tt.size();
        for (int i = 0; i < size; i++) {
            this.tt.get(i);
        }
        c(this.tt);
        this.x = 0;
    }

    private void tt(tt ttVar) {
        sp(ttVar);
    }

    private void ve(tt ttVar) {
        boolean z;
        byte b;
        int i = ttVar.tt;
        int i2 = ttVar.tt + ttVar.uj;
        int i3 = ttVar.tt;
        byte b2 = -1;
        int i4 = 0;
        while (i3 < i2) {
            if (this.ve.c(i3) != null || uj(i3)) {
                if (b2 == 0) {
                    n(c(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 1;
            } else {
                if (b2 == 1) {
                    sp(c(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            b2 = b;
        }
        if (i4 != ttVar.uj) {
            c(ttVar);
            ttVar = c(2, i, i4, null);
        }
        if (b2 == 0) {
            n(ttVar);
        } else {
            sp(ttVar);
        }
    }

    private void uj(tt ttVar) {
        int i = ttVar.tt;
        int i2 = ttVar.tt + ttVar.uj;
        byte b = -1;
        int i3 = 0;
        for (int i4 = ttVar.tt; i4 < i2; i4++) {
            if (this.ve.c(i4) != null || uj(i4)) {
                if (b == 0) {
                    n(c(4, i, i3, ttVar.ve));
                    i = i4;
                    i3 = 0;
                }
                b = 1;
            } else {
                if (b == 1) {
                    sp(c(4, i, i3, ttVar.ve));
                    i = i4;
                    i3 = 0;
                }
                b = 0;
            }
            i3++;
        }
        if (i3 != ttVar.uj) {
            Object obj = ttVar.ve;
            c(ttVar);
            ttVar = c(4, i, i3, obj);
        }
        if (b == 0) {
            n(ttVar);
        } else {
            sp(ttVar);
        }
    }

    private void n(tt ttVar) {
        int i;
        if (ttVar.c != 1 && ttVar.c != 8) {
            int iTt = tt(ttVar.tt, ttVar.c);
            int i2 = ttVar.tt;
            int i3 = ttVar.c;
            if (i3 == 2) {
                i = 0;
            } else {
                if (i3 != 4) {
                    throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(ttVar)));
                }
                i = 1;
            }
            int i4 = 1;
            for (int i5 = 1; i5 < ttVar.uj; i5++) {
                int iTt2 = tt(ttVar.tt + (i * i5), ttVar.c);
                int i6 = ttVar.c;
                if (i6 == 2 ? iTt2 != iTt : !(i6 == 4 && iTt2 == iTt + 1)) {
                    tt ttVarC = c(ttVar.c, iTt, i4, ttVar.ve);
                    c(ttVarC, i2);
                    c(ttVarC);
                    if (ttVar.c == 4) {
                        i2 += i4;
                    }
                    i4 = 1;
                    iTt = iTt2;
                } else {
                    i4++;
                }
            }
            Object obj = ttVar.ve;
            c(ttVar);
            if (i4 > 0) {
                tt ttVarC2 = c(ttVar.c, iTt, i4, obj);
                c(ttVarC2, i2);
                c(ttVarC2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public void c(tt ttVar, int i) {
        int i2 = ttVar.c;
        if (i2 == 2) {
            this.ve.c(i, ttVar.uj);
        } else {
            if (i2 == 4) {
                this.ve.c(i, ttVar.uj, ttVar.ve);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int tt(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.tt.size() - 1; size >= 0; size--) {
            tt ttVar = this.tt.get(size);
            if (ttVar.c == 8) {
                if (ttVar.tt < ttVar.uj) {
                    i3 = ttVar.tt;
                    i4 = ttVar.uj;
                } else {
                    i3 = ttVar.uj;
                    i4 = ttVar.tt;
                }
                if (i >= i3 && i <= i4) {
                    if (i3 == ttVar.tt) {
                        if (i2 == 1) {
                            ttVar.uj++;
                        } else if (i2 == 2) {
                            ttVar.uj--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            ttVar.tt++;
                        } else if (i2 == 2) {
                            ttVar.tt--;
                        }
                        i--;
                    }
                } else if (i < ttVar.tt) {
                    if (i2 == 1) {
                        ttVar.tt++;
                        ttVar.uj++;
                    } else if (i2 == 2) {
                        ttVar.tt--;
                        ttVar.uj--;
                    }
                }
            } else if (ttVar.tt <= i) {
                if (ttVar.c == 1) {
                    i -= ttVar.uj;
                } else if (ttVar.c == 2) {
                    i += ttVar.uj;
                }
            } else if (i2 == 1) {
                ttVar.tt++;
            } else if (i2 == 2) {
                ttVar.tt--;
            }
        }
        for (int size2 = this.tt.size() - 1; size2 >= 0; size2--) {
            tt ttVar2 = this.tt.get(size2);
            if (ttVar2.c == 8) {
                if (ttVar2.uj == ttVar2.tt || ttVar2.uj < 0) {
                    this.tt.remove(size2);
                    c(ttVar2);
                }
            } else if (ttVar2.uj <= 0) {
                this.tt.remove(size2);
                c(ttVar2);
            }
        }
        return i;
    }

    private boolean uj(int i) {
        int size = this.tt.size();
        for (int i2 = 0; i2 < size; i2++) {
            tt ttVar = this.tt.get(i2);
            if (ttVar.c == 8) {
                if (c(ttVar.uj, i2 + 1) == i) {
                    return true;
                }
            } else if (ttVar.c == 1) {
                int i3 = ttVar.tt + ttVar.uj;
                for (int i4 = ttVar.tt; i4 < i3; i4++) {
                    if (c(i4, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void a(tt ttVar) {
        sp(ttVar);
    }

    private void sp(tt ttVar) {
        this.tt.add(ttVar);
        int i = ttVar.c;
        if (i == 1) {
            this.ve.ve(ttVar.tt, ttVar.uj);
            return;
        }
        if (i == 2) {
            this.ve.tt(ttVar.tt, ttVar.uj);
        } else if (i == 4) {
            this.ve.c(ttVar.tt, ttVar.uj, ttVar.ve);
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(ttVar)));
            }
            this.ve.uj(ttVar.tt, ttVar.uj);
        }
    }

    public boolean uj() {
        return this.c.size() > 0;
    }

    public int tt(int i) {
        return c(i, 0);
    }

    public int c(int i, int i2) {
        int size = this.tt.size();
        while (i2 < size) {
            tt ttVar = this.tt.get(i2);
            if (ttVar.c == 8) {
                if (ttVar.tt == i) {
                    i = ttVar.uj;
                } else {
                    if (ttVar.tt < i) {
                        i--;
                    }
                    if (ttVar.uj <= i) {
                        i++;
                    }
                }
            } else if (ttVar.tt > i) {
                continue;
            } else if (ttVar.c == 2) {
                if (i < ttVar.tt + ttVar.uj) {
                    return -1;
                }
                i -= ttVar.uj;
            } else if (ttVar.c == 1) {
                i += ttVar.uj;
            }
            i2++;
        }
        return i;
    }

    public boolean c(int i, int i2, Object obj) {
        if (i2 <= 0) {
            return false;
        }
        this.c.add(c(4, i, i2, obj));
        this.x |= 4;
        return this.c.size() == 1;
    }

    public void n() {
        ve();
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            tt ttVar = this.c.get(i);
            int i2 = ttVar.c;
            if (i2 == 1) {
                this.ve.ve(ttVar.tt, ttVar.uj);
            } else if (i2 == 2) {
                this.ve.c(ttVar.tt, ttVar.uj);
            } else if (i2 == 4) {
                this.ve.c(ttVar.tt, ttVar.uj, ttVar.ve);
            } else if (i2 == 8) {
                this.ve.uj(ttVar.tt, ttVar.uj);
            }
            Runnable runnable = this.uj;
            if (runnable != null) {
                runnable.run();
            }
        }
        c(this.c);
        this.x = 0;
    }

    public int ve(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            tt ttVar = this.c.get(i2);
            int i3 = ttVar.c;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (ttVar.tt == i) {
                            i = ttVar.uj;
                        } else {
                            if (ttVar.tt < i) {
                                i--;
                            }
                            if (ttVar.uj <= i) {
                                i++;
                            }
                        }
                    }
                } else if (ttVar.tt > i) {
                    continue;
                } else {
                    if (ttVar.tt + ttVar.uj > i) {
                        return -1;
                    }
                    i -= ttVar.uj;
                }
            } else if (ttVar.tt <= i) {
                i += ttVar.uj;
            }
        }
        return i;
    }

    public boolean a() {
        return (this.tt.isEmpty() || this.c.isEmpty()) ? false : true;
    }

    @Override // com.byazt.kt.sp.c
    public tt c(int i, int i2, int i3, Object obj) {
        tt ttVarC = this.sp.c();
        if (ttVarC == null) {
            return new tt(i, i2, i3, obj);
        }
        ttVarC.c = i;
        ttVarC.tt = i2;
        ttVarC.uj = i3;
        ttVarC.ve = obj;
        return ttVarC;
    }

    @Override // com.byazt.kt.sp.c
    public void c(tt ttVar) {
        if (this.n) {
            return;
        }
        ttVar.ve = null;
        this.sp.c(ttVar);
    }

    public void c(List<tt> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            c(list.get(i));
        }
        list.clear();
    }

    @com.byazt.zqa.c(c = {0, 1, 166, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    static class tt {
        public int c;
        public int tt;
        public int uj;
        public Object ve;

        public String c() {
            int i = this.c;
            if (i == 1) {
                return "add";
            }
            if (i == 2) {
                return com.kuaishou.weapon.p0.t.w;
            }
            if (i != 4) {
                return i != 8 ? "??" : "mv";
            }
            return "up";
        }

        public int hashCode() {
            return (((this.c * 31) + this.tt) * 31) + this.uj;
        }

        public tt(int i, int i2, int i3, Object obj) {
            this.c = i;
            this.tt = i2;
            this.uj = i3;
            this.ve = obj;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + c() + ",s:" + this.tt + "c:" + this.uj + ",p:" + this.ve + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            tt ttVar = (tt) obj;
            int i = this.c;
            if (i != ttVar.c) {
                return false;
            }
            if (i == 8 && Math.abs(this.uj - this.tt) == 1 && this.uj == ttVar.tt && this.tt == ttVar.uj) {
                return true;
            }
            if (this.uj != ttVar.uj || this.tt != ttVar.tt) {
                return false;
            }
            Object obj2 = this.ve;
            if (obj2 != null) {
                if (!obj2.equals(ttVar.ve)) {
                    return false;
                }
            } else if (ttVar.ve != null) {
                return false;
            }
            return true;
        }
    }
}
