package com.byazt.gy;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2085, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2277a;
    public int[] i;
    public a sl;
    public boolean sp;
    public tt x;
    public boolean da = false;
    public final ve t = new ve();
    public int c = 0;
    public int tt = 1;
    public int ve = 2;
    public int uj = 3;
    public int n = 4;

    private void uj() {
        this.i = null;
        this.f2277a = -1;
    }

    public c() {
        uj();
    }

    public void c(InputStream inputStream) {
        c();
        if (inputStream != null) {
            this.x = new tt(inputStream);
        }
    }

    public void c() {
        if (this.da) {
            this.da = false;
            this.x.c();
            this.sl = null;
            this.x = null;
            this.t.c();
            uj();
        }
    }

    public int tt() throws IOException {
        try {
            if (this.x != null) {
                n();
                return this.f2277a;
            }
            throw new IOException("Parser is not opened.");
        } catch (IOException e) {
            c();
            throw e;
        }
    }

    public int ve() {
        if (this.f2277a != 2) {
            return -1;
        }
        return this.i.length / 5;
    }

    public String c(int i) {
        int i2 = this.i[n(i) + 1];
        return i2 == -1 ? "" : this.sl.c(i2);
    }

    public int tt(int i) {
        return this.i[n(i) + 3];
    }

    public int ve(int i) {
        return this.i[n(i) + 4];
    }

    public String uj(int i) {
        int iN = n(i);
        int[] iArr = this.i;
        if (iArr[iN + 3] != 3) {
            return "";
        }
        return this.sl.c(iArr[iN + 2]);
    }

    private int n(int i) {
        if (this.f2277a != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.i.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    private void n() throws IOException {
        if (this.sl == null) {
            this.x.tt(524291);
            this.x.ve();
            this.sl = a.c(this.x);
            this.t.n();
            this.da = true;
        }
        int i = this.f2277a;
        if (i == this.tt) {
            return;
        }
        uj();
        while (true) {
            if (this.sp) {
                this.sp = false;
                this.t.a();
            }
            if (i == this.uj && this.t.uj() == 1 && this.t.tt() == 0) {
                this.f2277a = this.tt;
                return;
            }
            int iTt = i == this.c ? 1048834 : this.x.tt();
            if (iTt == 524672) {
                int iTt2 = this.x.tt();
                if (iTt2 < 8 || iTt2 % 4 != 0) {
                    throw new IOException("Invalid resource ids size (" + iTt2 + ").");
                }
                this.x.c((iTt2 / 4) - 2);
            } else {
                if (iTt < 1048832 || iTt > 1048836) {
                    throw new IOException("Invalid chunk type (" + iTt + ").");
                }
                if (iTt == 1048834 && i == -1) {
                    this.f2277a = this.c;
                    return;
                }
                this.x.ve();
                this.x.tt();
                this.x.ve();
                if (iTt == 1048832 || iTt == 1048833) {
                    if (iTt == 1048832) {
                        this.t.c(this.x.tt(), this.x.tt());
                    } else {
                        this.x.ve();
                        this.x.ve();
                        this.t.ve();
                    }
                } else if (iTt == 1048834) {
                    this.x.tt();
                    this.x.tt();
                    this.x.ve();
                    int iTt3 = this.x.tt() & 65535;
                    this.x.tt();
                    this.i = this.x.c(iTt3 * 5);
                    int i2 = 3;
                    while (true) {
                        int[] iArr = this.i;
                        if (i2 < iArr.length) {
                            iArr[i2] = iArr[i2] >>> 24;
                            i2 += 5;
                        } else {
                            this.t.n();
                            this.f2277a = this.ve;
                            return;
                        }
                    }
                } else {
                    if (iTt == 1048835) {
                        this.x.tt();
                        this.x.tt();
                        this.f2277a = this.uj;
                        this.sp = true;
                        return;
                    }
                    if (iTt == 1048836) {
                        this.x.tt();
                        this.x.ve();
                        this.x.ve();
                        this.f2277a = this.n;
                        return;
                    }
                }
            }
        }
    }
}
