package com.opos.cmn.func.dl.base.a.a;

import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f6107a;
    Map<Integer, RandomAccessFile> b = new ConcurrentHashMap();
    BlockingQueue<a> c = new ArrayBlockingQueue(200);
    private d d;

    public e(d dVar) {
        this.d = dVar;
    }

    public final int a() {
        return this.c.size();
    }

    final void a(int i) {
        try {
            com.opos.cmn.func.dl.base.i.a.a(this.b.remove(Integer.valueOf(i)));
        } catch (Throwable unused) {
        }
    }

    public final void a(a aVar) throws DlException {
        int i = aVar.b;
        if (this.b.get(Integer.valueOf(i)) == null) {
            com.opos.cmn.func.dl.base.a.c cVarA = this.d.a(i);
            if (cVarA == null || cVarA.b.a() != 3) {
                return;
            }
            try {
                File file = cVarA.f6110a.j;
                if (!com.opos.cmn.an.e.b.a.a(file)) {
                    com.opos.cmn.func.dl.base.i.a.a(file);
                }
                this.b.put(Integer.valueOf(i), new RandomAccessFile(file, "rw"));
            } catch (Exception e) {
                boolean zA = com.opos.cmn.func.dl.base.i.a.a(this.d.c);
                com.opos.cmn.an.f.a.d("BlockWriteRunnbale", "create tempFile failed!hasStorage=".concat(String.valueOf(zA)), e);
                throw new DlException(zA ? 1000 : 1008, e);
            }
        }
        try {
            this.c.put(aVar);
        } catch (InterruptedException e2) {
            com.opos.cmn.an.f.a.c("BlockWriteRunnbale", "addBuffer interrupt!", e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0084  */
    /* JADX WARN: Code duplicated, block: B:36:0x0094 A[Catch: all -> 0x00cc, Exception -> 0x00cf, DlException -> 0x00d4, IOException -> 0x00d9, InterruptedException -> 0x00de, TryCatch #4 {DlException -> 0x00d4, IOException -> 0x00d9, InterruptedException -> 0x00de, Exception -> 0x00cf, all -> 0x00cc, blocks: (B:7:0x0014, B:9:0x001e, B:12:0x0030, B:15:0x003b, B:17:0x0047, B:19:0x004d, B:22:0x0056, B:23:0x006d, B:25:0x007c, B:29:0x0085, B:31:0x008b, B:36:0x0094, B:37:0x00b9, B:38:0x00c0), top: B:74:0x0014 }] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        f fVar;
        f fVar2;
        a aVarTake;
        Throwable th;
        RandomAccessFile randomAccessFile;
        boolean z;
        com.opos.cmn.an.f.a.a("BlockWriteRunnbale", "Write thread start!");
        while (!this.f6107a) {
            a aVar = null;
            fVar = null;
            fVar = null;
            f fVar3 = null;
            aVar = null;
            aVar = null;
            aVar = null;
            try {
                try {
                    aVarTake = this.c.take();
                    try {
                        com.opos.cmn.func.dl.base.a.c cVarA = this.d.a(aVarTake.b);
                        if (cVarA != null && (randomAccessFile = this.b.get(Integer.valueOf(aVarTake.b))) != null && cVarA.b.a() == 3) {
                            fVar3 = cVarA.c;
                            com.opos.cmn.func.dl.base.a.b bVar = cVarA.f6110a;
                            if (!bVar.j.exists()) {
                                throw new DlException(1009);
                            }
                            boolean z2 = false;
                            if (aVarTake.c == -1) {
                                if (bVar.s.get() >= bVar.k || bVar.k == -1) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (bVar.k == -1 && aVarTake.c == -1) {
                                    z2 = true;
                                }
                                if (z || z2) {
                                    com.opos.cmn.an.f.a.a("BlockWriteRunnbale", "Write finish by isOverLen :" + z + ",isEndBuffer:" + z2);
                                    a(aVarTake.b);
                                    fVar3.a();
                                }
                            } else if (cVarA.b.a() == 3) {
                                randomAccessFile.seek(aVarTake.d);
                                randomAccessFile.write(aVarTake.e, 0, aVarTake.c);
                                bVar.s.addAndGet(aVarTake.c);
                                fVar3.b(aVarTake);
                                if (bVar.s.get() >= bVar.k) {
                                    z = false;
                                } else {
                                    z = false;
                                }
                                if (bVar.k == -1) {
                                    z2 = true;
                                }
                                if (z) {
                                    com.opos.cmn.an.f.a.a("BlockWriteRunnbale", "Write finish by isOverLen :" + z + ",isEndBuffer:" + z2);
                                    a(aVarTake.b);
                                    fVar3.a();
                                } else {
                                    com.opos.cmn.an.f.a.a("BlockWriteRunnbale", "Write finish by isOverLen :" + z + ",isEndBuffer:" + z2);
                                    a(aVarTake.b);
                                    fVar3.a();
                                }
                            }
                        }
                        this.d.f6106a.f.a(aVarTake);
                    } catch (DlException e) {
                        e = e;
                        fVar2 = fVar3;
                        aVar = aVarTake;
                        com.opos.cmn.an.f.a.c("BlockWriteRunnbale", "write block error! ", e);
                        a(aVar.b);
                        if (fVar2 != null) {
                            fVar2.a(e);
                        }
                        this.d.f6106a.f.a(aVar);
                    } catch (IOException e2) {
                        e = e2;
                        fVar2 = fVar3;
                        aVar = aVarTake;
                        com.opos.cmn.an.f.a.c("BlockWriteRunnbale", "write block io error! ", e);
                        a(aVar.b);
                        if (fVar2 != null) {
                            e = new DlException(1004);
                            fVar2.a(e);
                        }
                        this.d.f6106a.f.a(aVar);
                    } catch (InterruptedException unused) {
                        aVar = aVarTake;
                        com.opos.cmn.an.f.a.c("BlockWriteRunnbale", "write block inerrupted! ");
                        this.d.f6106a.f.a(aVar);
                    } catch (Exception e3) {
                        e = e3;
                        fVar = fVar3;
                        aVar = aVarTake;
                        com.opos.cmn.an.f.a.c("BlockWriteRunnbale", "onError error! ", e);
                        a(aVar.b);
                        if (fVar != null) {
                            fVar.a(new DlException(1000, e));
                        }
                        this.d.f6106a.f.a(aVar);
                    } catch (Throwable th2) {
                        th = th2;
                        this.d.f6106a.f.a(aVarTake);
                        throw th;
                    }
                } catch (Throwable th3) {
                    aVarTake = null;
                    th = th3;
                }
            } catch (DlException e4) {
                e = e4;
                fVar2 = null;
            } catch (IOException e5) {
                e = e5;
                fVar2 = null;
            } catch (InterruptedException unused2) {
            } catch (Exception e6) {
                e = e6;
                fVar = null;
            }
        }
    }
}
