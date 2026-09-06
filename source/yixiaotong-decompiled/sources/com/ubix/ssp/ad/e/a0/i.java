package com.ubix.ssp.ad.e.a0;

import android.util.Log;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Process f8702a;
    private BufferedReader b;
    private BufferedReader c;
    private DataOutputStream d;
    private boolean e;
    private boolean f;
    ReadWriteLock g;
    private StringBuffer h;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8703a;

        a(int i) {
            this.f8703a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(this.f8703a);
            } catch (Throwable unused) {
            }
            try {
                i.this.f8702a.exitValue();
            } catch (Throwable unused2) {
                Log.i("auto", "take maxTime,forced to destroy process");
                i.this.f8702a.destroy();
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb;
            Lock lockWriteLock = i.this.g.writeLock();
            while (true) {
                try {
                    String line = i.this.b.readLine();
                    if (line != null) {
                        String str = line + IOUtils.LINE_SEPARATOR_UNIX;
                        lockWriteLock.lock();
                        i.this.h.append(str);
                        lockWriteLock.unlock();
                    } else {
                        try {
                            i.this.b.close();
                            return;
                        } catch (Throwable th) {
                            th = th;
                            sb = new StringBuilder("close InputStream exception:");
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        Log.i("auto", "read InputStream exception:" + th2.toString());
                        try {
                            i.this.b.close();
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            sb = new StringBuilder("close InputStream exception:");
                        }
                    } finally {
                        try {
                            i.this.b.close();
                        } catch (Throwable th4) {
                            Log.i("auto", "close InputStream exception:" + th4.toString());
                        }
                    }
                }
                StringBuilder sbAppend = sb.append(th.toString());
                return;
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb;
            Lock lockWriteLock = i.this.g.writeLock();
            while (true) {
                try {
                    String line = i.this.c.readLine();
                    if (line != null) {
                        String str = line + IOUtils.LINE_SEPARATOR_UNIX;
                        lockWriteLock.lock();
                        i.this.h.append(str);
                        lockWriteLock.unlock();
                    } else {
                        try {
                            i.this.c.close();
                            return;
                        } catch (Throwable th) {
                            th = th;
                            sb = new StringBuilder("read ErrorStream exception:");
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        Log.i("auto", "read ErrorStream exception:" + th2.toString());
                        try {
                            i.this.c.close();
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            sb = new StringBuilder("read ErrorStream exception:");
                        }
                    } finally {
                        try {
                            i.this.c.close();
                        } catch (Throwable th4) {
                            Log.i("auto", "read ErrorStream exception:" + th4.toString());
                        }
                    }
                }
                StringBuilder sbAppend = sb.append(th.toString());
                return;
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Thread f8706a;
        final /* synthetic */ Thread b;

        d(Thread thread, Thread thread2) {
            this.f8706a = thread;
            this.b = thread2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f8706a.join();
                this.b.join();
                i.this.f8702a.waitFor();
            } catch (Throwable unused) {
            }
            i.this.f = false;
            Log.i("auto", "run command process end");
        }
    }

    public i() {
        this.f = false;
        this.g = new ReentrantReadWriteLock();
        this.h = new StringBuffer();
        this.e = true;
    }

    public i(boolean z) {
        this.f = false;
        this.g = new ReentrantReadWriteLock();
        this.h = new StringBuffer();
        this.e = z;
    }

    public i a(String str, int i) {
        Log.i("auto", "run command:" + str + ",maxtime:" + i);
        if (str != null && str.length() != 0) {
            try {
                this.f8702a = Runtime.getRuntime().exec("sh");
                this.f = true;
                this.b = new BufferedReader(new InputStreamReader(this.f8702a.getInputStream()));
                this.c = new BufferedReader(new InputStreamReader(this.f8702a.getErrorStream()));
                DataOutputStream dataOutputStream = new DataOutputStream(this.f8702a.getOutputStream());
                this.d = dataOutputStream;
                try {
                    dataOutputStream.write(str.getBytes());
                    this.d.writeBytes(IOUtils.LINE_SEPARATOR_UNIX);
                    this.d.flush();
                    this.d.writeBytes("exit\n");
                    this.d.flush();
                    this.d.close();
                    if (i > 0) {
                        new Thread(new a(i)).start();
                    }
                    Thread thread = new Thread(new b());
                    thread.start();
                    Thread thread2 = new Thread(new c());
                    thread2.start();
                    Thread thread3 = new Thread(new d(thread, thread2));
                    thread3.start();
                    if (this.e) {
                        thread3.join();
                    }
                } catch (Throwable th) {
                    Log.i("auto", "run command process exception:" + th.toString());
                }
            } catch (Throwable unused) {
            }
        }
        return this;
    }

    public String a() {
        Lock lock = this.g.readLock();
        lock.lock();
        try {
            return new String(this.h);
        } finally {
            lock.unlock();
        }
    }
}
