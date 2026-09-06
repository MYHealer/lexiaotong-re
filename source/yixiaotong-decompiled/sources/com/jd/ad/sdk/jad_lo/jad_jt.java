package com.jd.ad.sdk.jad_lo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_jt extends Thread {
    public boolean jad_an;
    public InputStream jad_bo;
    public StringBuilder jad_cp = new StringBuilder();
    public volatile boolean jad_dq;

    public jad_jt(InputStream inputStream, boolean z) {
        this.jad_an = false;
        this.jad_dq = false;
        this.jad_bo = inputStream;
        this.jad_dq = false;
        this.jad_an = z;
    }

    public final String jad_an() {
        if (!this.jad_dq) {
            synchronized (this) {
                try {
                    if (!this.jad_dq) {
                        wait();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return this.jad_cp.toString();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(this.jad_bo));
            try {
                String property = this.jad_an ? System.getProperty("line.separator") : "";
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        this.jad_cp.append(line + property);
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                }
                bufferedReader2.close();
                try {
                    this.jad_bo.close();
                } catch (Exception unused2) {
                }
                this.jad_dq = true;
                synchronized (this) {
                    notify();
                }
            } catch (IOException unused3) {
                bufferedReader = bufferedReader2;
                try {
                    bufferedReader.close();
                } catch (Exception unused4) {
                }
                try {
                    this.jad_bo.close();
                } catch (Exception unused5) {
                }
                this.jad_dq = true;
                synchronized (this) {
                    notify();
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                try {
                    bufferedReader.close();
                } catch (Exception unused6) {
                }
                try {
                    this.jad_bo.close();
                } catch (Exception unused7) {
                }
                this.jad_dq = true;
                synchronized (this) {
                    notify();
                }
                throw th;
            }
        } catch (IOException unused8) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
