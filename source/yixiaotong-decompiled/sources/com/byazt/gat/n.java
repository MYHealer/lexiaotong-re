package com.byazt.gat;

import android.text.TextUtils;
import com.byazt.ete.bm;
import com.byazt.im.sp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 788, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tt<com.byazt.im.a, sp> f2246a;
    public volatile boolean c;
    public com.byazt.cc.tt da;
    public com.byazt.tdq.c i;
    public com.byazt.im.n n;
    public sp sp;
    public volatile boolean tt;
    public volatile boolean uj;
    public volatile boolean ve;
    public com.byazt.im.a x;

    public void c() {
        this.uj = true;
    }

    public n(com.byazt.im.n nVar, tt<com.byazt.im.a, sp> ttVar, com.byazt.tdq.c cVar, com.byazt.cc.tt ttVar2) {
        if (nVar == null || ttVar == null) {
            return;
        }
        this.n = nVar;
        this.f2246a = ttVar;
        this.i = cVar;
        this.da = ttVar2;
    }

    public void c(final int i) {
        if (this.n == null || this.f2246a == null) {
            return;
        }
        com.byazt.dz.c.c("Splash_FullLink", "loadAd Type ".concat(String.valueOf(i)));
        if (i == 0) {
            new com.byazt.iox.ve().c(this.n, this.f2246a);
            return;
        }
        if (i == 1) {
            new com.byazt.iox.c(this.i).c(this.n, new tt<com.byazt.im.a, sp>() { // from class: com.byazt.gat.n.1
                @Override // com.byazt.gat.tt
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void tt(com.byazt.im.a aVar) {
                    n.this.f2246a.tt(aVar);
                    if (!com.byazt.tdq.c.c(i) || n.this.i == null || n.this.n == null) {
                        return;
                    }
                    n.this.i.tt(n.this.n.uj(), n.this.n.n());
                }

                @Override // com.byazt.gat.tt
                public void c(sp spVar) {
                    if (spVar != null && n.this.n != null) {
                        n.this.n.c(spVar.uj());
                        n.this.n.c(spVar.ve());
                    }
                    if (n.this.da == null || !n.this.da.tt()) {
                        new com.byazt.iox.ve().c(n.this.n, new tt<com.byazt.im.a, sp>() { // from class: com.byazt.gat.n.1.1
                            @Override // com.byazt.gat.tt
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public void tt(com.byazt.im.a aVar) {
                                if (n.this.uj) {
                                    if (n.this.i == null || n.this.n == null) {
                                        return;
                                    }
                                    n.this.i.c(aVar, n.this.n.uj(), true, 1);
                                    return;
                                }
                                n.this.f2246a.tt(aVar);
                            }

                            @Override // com.byazt.gat.tt
                            public void c(sp spVar2) {
                                n.this.f2246a.c(spVar2);
                                if (!com.byazt.tdq.c.c(i) || n.this.i == null || n.this.n == null) {
                                    return;
                                }
                                n.this.i.tt(n.this.n.uj(), n.this.n.n());
                            }
                        });
                    } else {
                        n.this.f2246a.c(spVar);
                    }
                }
            });
            return;
        }
        if (i == 2) {
            new com.byazt.iox.ve().c(this.n, new tt<com.byazt.im.a, sp>() { // from class: com.byazt.gat.n.2
                @Override // com.byazt.gat.tt
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void tt(com.byazt.im.a aVar) {
                    n.this.x = aVar;
                    if (n.this.sp != null && aVar != null) {
                        aVar.c(n.this.sp.uj());
                        aVar.c(n.this.sp.ve());
                    }
                    com.byazt.dz.c.c("Splash_FullLink", "实时物料加载成功 isCache " + aVar.n());
                    n.this.f2246a.tt(aVar);
                }

                @Override // com.byazt.gat.tt
                public void c(sp spVar) {
                    com.byazt.dz.c.c("Splash_FullLink", "实时物料加载失败 ");
                    n.this.f2246a.c(spVar);
                }
            });
            new com.byazt.iox.c(this.i).c(this.n, new tt<com.byazt.im.a, sp>() { // from class: com.byazt.gat.n.3
                @Override // com.byazt.gat.tt
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void tt(com.byazt.im.a aVar) {
                    com.byazt.dz.c.c("Splash_FullLink", "缓存物料加载成功 isCache " + aVar.n());
                    n.this.f2246a.tt(aVar);
                }

                @Override // com.byazt.gat.tt
                public void c(sp spVar) {
                    n.this.sp = spVar;
                    com.byazt.dz.c.c("Splash_FullLink", "缓存物料加载失败  ");
                    if (n.this.x != null && spVar != null) {
                        n.this.x.c(spVar.uj());
                        n.this.x.c(spVar.ve());
                    }
                    n.this.f2246a.c(spVar);
                }
            });
        } else if (i == 3) {
            new com.byazt.iox.ve().c(this.n, new tt<com.byazt.im.a, sp>() { // from class: com.byazt.gat.n.4
                @Override // com.byazt.gat.tt
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void tt(com.byazt.im.a aVar) {
                    n.this.x = aVar;
                    if (n.this.ve || n.this.uj) {
                        if (n.this.i == null || n.this.n == null) {
                            return;
                        }
                        n.this.i.c(aVar, n.this.n.uj(), true, 3);
                        return;
                    }
                    if (n.this.sp != null && aVar != null) {
                        aVar.c(n.this.sp.uj());
                        aVar.c(n.this.sp.ve());
                    }
                    n.this.ve = true;
                    n.this.f2246a.tt(aVar);
                }

                @Override // com.byazt.gat.tt
                public void c(sp spVar) {
                    n.this.c = true;
                    if (n.this.tt) {
                        n.this.f2246a.c(spVar);
                    }
                    if (!com.byazt.tdq.c.c(i) || n.this.i == null || n.this.n == null) {
                        return;
                    }
                    n.this.i.tt(n.this.n.uj(), n.this.n.n());
                }
            });
            new com.byazt.iox.c(this.i).c(this.n, new tt<com.byazt.im.a, sp>() { // from class: com.byazt.gat.n.5
                @Override // com.byazt.gat.tt
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void tt(com.byazt.im.a aVar) {
                    if (n.this.ve) {
                        return;
                    }
                    n.this.ve = true;
                    n.this.f2246a.tt(aVar);
                }

                @Override // com.byazt.gat.tt
                public void c(sp spVar) {
                    n.this.sp = spVar;
                    if (n.this.x != null && spVar != null) {
                        n.this.x.c(spVar.uj());
                        n.this.x.c(spVar.ve());
                    }
                    n.this.tt = true;
                    if (n.this.c) {
                        n.this.f2246a.c(spVar);
                    }
                }
            });
        } else {
            if (i != 4) {
                return;
            }
            new com.byazt.iox.c(this.i).c(this.n, new tt<com.byazt.im.a, sp>() { // from class: com.byazt.gat.n.6
                @Override // com.byazt.gat.tt
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void tt(com.byazt.im.a aVar) {
                    n.this.f2246a.tt(aVar);
                }

                @Override // com.byazt.gat.tt
                public void c(sp spVar) {
                    n.this.f2246a.c(spVar);
                }
            });
        }
    }

    public static boolean c(com.byazt.dj.tt ttVar, bm bmVar) {
        return (ttVar == null || bmVar == null || TextUtils.isEmpty(ttVar.rl()) || bmVar.n > 0) ? false : true;
    }
}
