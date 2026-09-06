package com.ubixnow.ooooo;

import android.util.Log;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ooOOO0Oo {
    private Process OooO00o;
    private BufferedReader OooO0O0;
    private BufferedReader OooO0OO;
    private DataOutputStream OooO0Oo;
    private boolean OooO0o;
    private boolean OooO0o0;
    public ReadWriteLock OooO0oO;
    private StringBuffer OooO0oo;

    public class OooO00o implements Runnable {
        public final /* synthetic */ int OooO00o;

        public OooO00o(int i) {
            this.OooO00o = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(this.OooO00o);
            } catch (Throwable unused) {
            }
            try {
                ooOOO0Oo.this.OooO00o.exitValue();
            } catch (Throwable unused2) {
                Log.i("auto", "take maxTime,forced to destroy process");
                ooOOO0Oo.this.OooO00o.destroy();
            }
        }
    }

    public class OooO0O0 implements Runnable {
        public OooO0O0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb;
            Lock lockWriteLock = ooOOO0Oo.this.OooO0oO.writeLock();
            while (true) {
                try {
                    String line = ooOOO0Oo.this.OooO0O0.readLine();
                    if (line != null) {
                        String str = line + IOUtils.LINE_SEPARATOR_UNIX;
                        lockWriteLock.lock();
                        ooOOO0Oo.this.OooO0oo.append(str);
                        lockWriteLock.unlock();
                    } else {
                        try {
                            ooOOO0Oo.this.OooO0O0.close();
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
                            ooOOO0Oo.this.OooO0O0.close();
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            sb = new StringBuilder("close InputStream exception:");
                        }
                    } finally {
                        try {
                            ooOOO0Oo.this.OooO0O0.close();
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

    public class OooO0OO implements Runnable {
        public OooO0OO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb;
            Lock lockWriteLock = ooOOO0Oo.this.OooO0oO.writeLock();
            while (true) {
                try {
                    String line = ooOOO0Oo.this.OooO0OO.readLine();
                    if (line != null) {
                        String str = line + IOUtils.LINE_SEPARATOR_UNIX;
                        lockWriteLock.lock();
                        ooOOO0Oo.this.OooO0oo.append(str);
                        lockWriteLock.unlock();
                    } else {
                        try {
                            ooOOO0Oo.this.OooO0OO.close();
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
                            ooOOO0Oo.this.OooO0OO.close();
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            sb = new StringBuilder("read ErrorStream exception:");
                        }
                    } finally {
                        try {
                            ooOOO0Oo.this.OooO0OO.close();
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

    public class OooO0o implements Runnable {
        public final /* synthetic */ Thread OooO00o;
        public final /* synthetic */ Thread OooO0O0;

        public OooO0o(Thread thread, Thread thread2) {
            this.OooO00o = thread;
            this.OooO0O0 = thread2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.OooO00o.join();
                this.OooO0O0.join();
                ooOOO0Oo.this.OooO00o.waitFor();
            } catch (Throwable unused) {
            }
            ooOOO0Oo.this.OooO0o = false;
            Log.i("auto", "run command process end");
        }
    }

    public ooOOO0Oo() {
        this.OooO0o = false;
        this.OooO0oO = new ReentrantReadWriteLock();
        this.OooO0oo = new StringBuffer();
        this.OooO0o0 = true;
    }

    public ooOOO0Oo(boolean z) {
        this.OooO0o = false;
        this.OooO0oO = new ReentrantReadWriteLock();
        this.OooO0oo = new StringBuffer();
        this.OooO0o0 = z;
    }

    public ooOOO0Oo OooO00o(String str, int i) {
        Log.i("auto", "run command:" + str + ",maxtime:" + i);
        if (str != null && str.length() != 0) {
            try {
                this.OooO00o = Runtime.getRuntime().exec("sh");
                this.OooO0o = true;
                this.OooO0O0 = new BufferedReader(new InputStreamReader(this.OooO00o.getInputStream()));
                this.OooO0OO = new BufferedReader(new InputStreamReader(this.OooO00o.getErrorStream()));
                DataOutputStream dataOutputStream = new DataOutputStream(this.OooO00o.getOutputStream());
                this.OooO0Oo = dataOutputStream;
                try {
                    dataOutputStream.write(str.getBytes());
                    this.OooO0Oo.writeBytes(IOUtils.LINE_SEPARATOR_UNIX);
                    this.OooO0Oo.flush();
                    this.OooO0Oo.writeBytes("exit\n");
                    this.OooO0Oo.flush();
                    this.OooO0Oo.close();
                    if (i > 0) {
                        new Thread(new OooO00o(i)).start();
                    }
                    Thread thread = new Thread(new OooO0O0());
                    thread.start();
                    Thread thread2 = new Thread(new OooO0OO());
                    thread2.start();
                    Thread thread3 = new Thread(new OooO0o(thread, thread2));
                    thread3.start();
                    if (this.OooO0o0) {
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

    public String OooO00o() {
        Lock lock = this.OooO0oO.readLock();
        lock.lock();
        try {
            return new String(this.OooO0oo);
        } finally {
            lock.unlock();
        }
    }

    public boolean OooO0O0() {
        return this.OooO0o;
    }
}
