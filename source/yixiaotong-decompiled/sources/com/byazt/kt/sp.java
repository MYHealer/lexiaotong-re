package com.byazt.kt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 166, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {
    public final c c;

    interface c {
        com.byazt.kt.c.tt c(int i, int i2, int i3, Object obj);

        void c(com.byazt.kt.c.tt ttVar);
    }

    public sp(c cVar) {
        this.c = cVar;
    }

    public void c(List<com.byazt.kt.c.tt> list) {
        while (true) {
            int iTt = tt(list);
            if (iTt == -1) {
                return;
            } else {
                c(list, iTt, iTt + 1);
            }
        }
    }

    private void c(List<com.byazt.kt.c.tt> list, int i, int i2) {
        com.byazt.kt.c.tt ttVar = list.get(i);
        com.byazt.kt.c.tt ttVar2 = list.get(i2);
        int i3 = ttVar2.c;
        if (i3 == 1) {
            ve(list, i, ttVar, i2, ttVar2);
        } else if (i3 == 2) {
            c(list, i, ttVar, i2, ttVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            tt(list, i, ttVar, i2, ttVar2);
        }
    }

    public void c(List<com.byazt.kt.c.tt> list, int i, com.byazt.kt.c.tt ttVar, int i2, com.byazt.kt.c.tt ttVar2) {
        boolean z;
        boolean z2 = false;
        if (ttVar.tt < ttVar.uj) {
            if (ttVar2.tt == ttVar.tt && ttVar2.uj == ttVar.uj - ttVar.tt) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (ttVar2.tt == ttVar.uj + 1 && ttVar2.uj == ttVar.tt - ttVar.uj) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        if (ttVar.uj < ttVar2.tt) {
            ttVar2.tt--;
        } else if (ttVar.uj < ttVar2.tt + ttVar2.uj) {
            ttVar2.uj--;
            ttVar.c = 2;
            ttVar.uj = 1;
            if (ttVar2.uj == 0) {
                list.remove(i2);
                this.c.c(ttVar2);
                return;
            }
            return;
        }
        com.byazt.kt.c.tt ttVarC = null;
        if (ttVar.tt <= ttVar2.tt) {
            ttVar2.tt++;
        } else if (ttVar.tt < ttVar2.tt + ttVar2.uj) {
            ttVarC = this.c.c(2, ttVar.tt + 1, (ttVar2.tt + ttVar2.uj) - ttVar.tt, null);
            ttVar2.uj = ttVar.tt - ttVar2.tt;
        }
        if (z2) {
            list.set(i, ttVar2);
            list.remove(i2);
            this.c.c(ttVar);
            return;
        }
        if (z) {
            if (ttVarC != null) {
                if (ttVar.tt > ttVarC.tt) {
                    ttVar.tt -= ttVarC.uj;
                }
                if (ttVar.uj > ttVarC.tt) {
                    ttVar.uj -= ttVarC.uj;
                }
            }
            if (ttVar.tt > ttVar2.tt) {
                ttVar.tt -= ttVar2.uj;
            }
            if (ttVar.uj > ttVar2.tt) {
                ttVar.uj -= ttVar2.uj;
            }
        } else {
            if (ttVarC != null) {
                if (ttVar.tt >= ttVarC.tt) {
                    ttVar.tt -= ttVarC.uj;
                }
                if (ttVar.uj >= ttVarC.tt) {
                    ttVar.uj -= ttVarC.uj;
                }
            }
            if (ttVar.tt >= ttVar2.tt) {
                ttVar.tt -= ttVar2.uj;
            }
            if (ttVar.uj >= ttVar2.tt) {
                ttVar.uj -= ttVar2.uj;
            }
        }
        list.set(i, ttVar2);
        if (ttVar.tt != ttVar.uj) {
            list.set(i2, ttVar);
        } else {
            list.remove(i2);
        }
        if (ttVarC != null) {
            list.add(i, ttVarC);
        }
    }

    private void ve(List<com.byazt.kt.c.tt> list, int i, com.byazt.kt.c.tt ttVar, int i2, com.byazt.kt.c.tt ttVar2) {
        int i3 = ttVar.uj < ttVar2.tt ? -1 : 0;
        if (ttVar.tt < ttVar2.tt) {
            i3++;
        }
        if (ttVar2.tt <= ttVar.tt) {
            ttVar.tt += ttVar2.uj;
        }
        if (ttVar2.tt <= ttVar.uj) {
            ttVar.uj += ttVar2.uj;
        }
        ttVar2.tt += i3;
        list.set(i, ttVar2);
        list.set(i2, ttVar);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002f  */
    /* JADX WARN: Code duplicated, block: B:12:0x0035  */
    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    /* JADX WARN: Code duplicated, block: B:17:0x005d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0061  */
    /* JADX WARN: Code duplicated, block: B:20:0x006b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0070  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    public void tt(List<com.byazt.kt.c.tt> list, int i, com.byazt.kt.c.tt ttVar, int i2, com.byazt.kt.c.tt ttVar2) {
        com.byazt.kt.c.tt ttVarC;
        com.byazt.kt.c.tt ttVarC2 = null;
        if (ttVar.uj < ttVar2.tt) {
            ttVar2.tt--;
        } else {
            if (ttVar.uj < ttVar2.tt + ttVar2.uj) {
                ttVar2.uj--;
                ttVarC = this.c.c(4, ttVar.tt, 1, ttVar2.ve);
            }
            if (ttVar.tt <= ttVar2.tt) {
                ttVar2.tt++;
            } else if (ttVar.tt < ttVar2.tt + ttVar2.uj) {
                int i3 = (ttVar2.tt + ttVar2.uj) - ttVar.tt;
                ttVarC2 = this.c.c(4, ttVar.tt + 1, i3, ttVar2.ve);
                ttVar2.uj -= i3;
            }
            list.set(i2, ttVar);
            if (ttVar2.uj > 0) {
                list.set(i, ttVar2);
            } else {
                list.remove(i);
                this.c.c(ttVar2);
            }
            if (ttVarC != null) {
                list.add(i, ttVarC);
            }
            if (ttVarC2 != null) {
                list.add(i, ttVarC2);
            }
        }
        ttVarC = null;
        if (ttVar.tt <= ttVar2.tt) {
            ttVar2.tt++;
        } else if (ttVar.tt < ttVar2.tt + ttVar2.uj) {
            int i4 = (ttVar2.tt + ttVar2.uj) - ttVar.tt;
            ttVarC2 = this.c.c(4, ttVar.tt + 1, i4, ttVar2.ve);
            ttVar2.uj -= i4;
        }
        list.set(i2, ttVar);
        if (ttVar2.uj > 0) {
            list.set(i, ttVar2);
        } else {
            list.remove(i);
            this.c.c(ttVar2);
        }
        if (ttVarC != null) {
            list.add(i, ttVarC);
        }
        if (ttVarC2 != null) {
            list.add(i, ttVarC2);
        }
    }

    private int tt(List<com.byazt.kt.c.tt> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).c != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
