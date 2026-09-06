package com.kwad.framework.filedownloader.download;

import android.os.Process;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.net.SocketException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c implements Runnable {
    private final int aAO;
    private final ConnectTask aBK;
    private final f aBL;
    private e aBM;
    final int aBN;
    private final boolean aBl;
    private final String apn;
    private volatile boolean nJ;

    /* synthetic */ c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str, byte b) {
        this(i, i2, connectTask, fVar, z, str);
    }

    private c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.aAO = i;
        this.aBN = i2;
        this.nJ = false;
        this.aBL = fVar;
        this.apn = str;
        this.aBK = connectTask;
        this.aBl = z;
    }

    public final void pause() {
        this.nJ = true;
        e eVar = this.aBM;
        if (eVar != null) {
            eVar.pause();
        }
    }

    public final void Bw() {
        pause();
    }

    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x010e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x0110 A[Catch: all -> 0x00f9, TryCatch #13 {all -> 0x00f9, blocks: (B:3:0x0010, B:8:0x001a, B:10:0x002c, B:16:0x005a, B:17:0x008c, B:18:0x008d, B:23:0x009c, B:25:0x00d9, B:61:0x0106, B:64:0x0110, B:65:0x0118, B:67:0x011c, B:71:0x012c, B:75:0x0140), top: B:82:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0118 A[Catch: all -> 0x00f9, TryCatch #13 {all -> 0x00f9, blocks: (B:3:0x0010, B:8:0x001a, B:10:0x002c, B:16:0x005a, B:17:0x008c, B:18:0x008d, B:23:0x009c, B:25:0x00d9, B:61:0x0106, B:64:0x0110, B:65:0x0118, B:67:0x011c, B:71:0x012c, B:75:0x0140), top: B:82:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x011c A[Catch: all -> 0x00f9, TRY_LEAVE, TryCatch #13 {all -> 0x00f9, blocks: (B:3:0x0010, B:8:0x001a, B:10:0x002c, B:16:0x005a, B:17:0x008c, B:18:0x008d, B:23:0x009c, B:25:0x00d9, B:61:0x0106, B:64:0x0110, B:65:0x0118, B:67:0x011c, B:71:0x012c, B:75:0x0140), top: B:82:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0126  */
    /* JADX WARN: Code duplicated, block: B:73:0x013c  */
    /* JADX WARN: Code duplicated, block: B:77:0x0147  */
    /* JADX WARN: Code duplicated, block: B:88:0x012c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0140 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0129 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Exception e;
        e eVar;
        Process.setThreadPriority(10);
        long j = this.aBK.BY().aAX;
        com.kwad.framework.filedownloader.a.b bVarBV = null;
        boolean z2 = false;
        while (true) {
            try {
                try {
                    if (this.nJ) {
                        if (bVarBV != null) {
                            bVarBV.BQ();
                            return;
                        }
                        return;
                    }
                    try {
                        bVarBV = this.aBK.BV();
                        int responseCode = bVarBV.getResponseCode();
                        z = true;
                        if (com.kwad.framework.filedownloader.f.d.aDr) {
                            com.kwad.framework.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.aBN), Integer.valueOf(this.aAO), this.aBK.BY(), Integer.valueOf(responseCode));
                        }
                        if (responseCode != 206 && responseCode != 200) {
                            throw new SocketException(com.kwad.framework.filedownloader.f.f.c("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.aBK.getRequestHeader(), bVarBV.BP(), Integer.valueOf(responseCode), Integer.valueOf(this.aAO), Integer.valueOf(this.aBN)));
                        }
                        try {
                            e.a aVar = new e.a();
                            if (!this.nJ) {
                                e eVarCE = aVar.cO(this.aAO).cN(this.aBN).b(this.aBL).a(this).bx(this.aBl).d(bVarBV).c(this.aBK.BY()).ce(this.apn).CE();
                                this.aBM = eVarCE;
                                eVarCE.run();
                                if (!this.nJ) {
                                    break;
                                }
                                this.aBM.pause();
                                break;
                            }
                            if (bVarBV != null) {
                                bVarBV.BQ();
                                return;
                            }
                            return;
                        } catch (FileDownloadGiveUpRetryException e2) {
                            e = e2;
                            if (!this.aBL.a(e)) {
                                this.aBL.b(e);
                                if (bVarBV != null) {
                                    bVarBV.BQ();
                                    return;
                                }
                                return;
                            }
                            if (z) {
                                eVar = this.aBM;
                                if (eVar == null) {
                                    com.kwad.framework.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                                    this.aBL.b(e);
                                    if (bVarBV != null) {
                                        bVarBV.BQ();
                                        return;
                                    }
                                    return;
                                }
                                this.aBL.a(e, eVar.aAX - j);
                            } else {
                                this.aBL.a(e, 0L);
                            }
                            if (bVarBV != null) {
                                bVarBV.BQ();
                            }
                            z2 = z;
                        } catch (IOException e3) {
                            e = e3;
                            if (!this.aBL.a(e)) {
                                this.aBL.b(e);
                                if (bVarBV != null) {
                                    bVarBV.BQ();
                                    return;
                                }
                                return;
                            }
                            if (z) {
                                this.aBL.a(e, 0L);
                            } else {
                                eVar = this.aBM;
                                if (eVar == null) {
                                    com.kwad.framework.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                                    this.aBL.b(e);
                                    if (bVarBV != null) {
                                        bVarBV.BQ();
                                        return;
                                    }
                                    return;
                                }
                                this.aBL.a(e, eVar.aAX - j);
                            }
                            if (bVarBV != null) {
                                bVarBV.BQ();
                            }
                            z2 = z;
                        } catch (ArrayIndexOutOfBoundsException e4) {
                            e = e4;
                            if (!this.aBL.a(e)) {
                                this.aBL.b(e);
                                if (bVarBV != null) {
                                    bVarBV.BQ();
                                    return;
                                }
                                return;
                            }
                            if (z) {
                                this.aBL.a(e, 0L);
                            } else {
                                eVar = this.aBM;
                                if (eVar == null) {
                                    com.kwad.framework.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                                    this.aBL.b(e);
                                    if (bVarBV != null) {
                                        bVarBV.BQ();
                                        return;
                                    }
                                    return;
                                }
                                this.aBL.a(e, eVar.aAX - j);
                            }
                            if (bVarBV != null) {
                                bVarBV.BQ();
                            }
                            z2 = z;
                        } catch (IllegalAccessException e5) {
                            e = e5;
                            if (!this.aBL.a(e)) {
                                this.aBL.b(e);
                                if (bVarBV != null) {
                                    bVarBV.BQ();
                                    return;
                                }
                                return;
                            }
                            if (z) {
                                this.aBL.a(e, 0L);
                            } else {
                                eVar = this.aBM;
                                if (eVar == null) {
                                    com.kwad.framework.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                                    this.aBL.b(e);
                                    if (bVarBV != null) {
                                        bVarBV.BQ();
                                        return;
                                    }
                                    return;
                                }
                                this.aBL.a(e, eVar.aAX - j);
                            }
                            if (bVarBV != null) {
                                bVarBV.BQ();
                            }
                            z2 = z;
                        } catch (IllegalArgumentException e6) {
                            e = e6;
                            if (!this.aBL.a(e)) {
                                this.aBL.b(e);
                                if (bVarBV != null) {
                                    bVarBV.BQ();
                                    return;
                                }
                                return;
                            }
                            if (z) {
                                this.aBL.a(e, 0L);
                            } else {
                                eVar = this.aBM;
                                if (eVar == null) {
                                    com.kwad.framework.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                                    this.aBL.b(e);
                                    if (bVarBV != null) {
                                        bVarBV.BQ();
                                        return;
                                    }
                                    return;
                                }
                                this.aBL.a(e, eVar.aAX - j);
                            }
                            if (bVarBV != null) {
                                bVarBV.BQ();
                            }
                            z2 = z;
                        }
                    } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e7) {
                        e = e7;
                        z = false;
                    }
                } catch (Throwable th) {
                    if (bVarBV != null) {
                        bVarBV.BQ();
                    }
                    throw th;
                }
            } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e8) {
                z = z2;
                e = e8;
            }
            z2 = z;
        }
        if (bVarBV != null) {
            bVarBV.BQ();
        }
    }

    public static class a {
        private Boolean aBI;
        private f aBL;
        private final ConnectTask.a aBO = new ConnectTask.a();
        private Integer aBP;
        private String apn;

        public final a a(f fVar) {
            this.aBL = fVar;
            return this;
        }

        public final a cd(String str) {
            this.apn = str;
            return this;
        }

        public final a i(Integer num) {
            this.aBP = num;
            return this;
        }

        public final a cL(int i) {
            this.aBO.cK(i);
            return this;
        }

        public final a cb(String str) {
            this.aBO.bY(str);
            return this;
        }

        public final a cc(String str) {
            this.aBO.bZ(str);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.d.b bVar) {
            this.aBO.a(bVar);
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.download.a aVar) {
            this.aBO.a(aVar);
            return this;
        }

        public final a bv(boolean z) {
            this.aBI = Boolean.valueOf(z);
            return this;
        }

        public final c Cr() {
            if (this.aBL == null || this.apn == null || this.aBI == null || this.aBP == null) {
                throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("%s %s %B", this.aBL, this.apn, this.aBI));
            }
            ConnectTask connectTaskBZ = this.aBO.BZ();
            return new c(connectTaskBZ.aAO, this.aBP.intValue(), connectTaskBZ, this.aBL, this.aBI.booleanValue(), this.apn, (byte) 0);
        }
    }
}
