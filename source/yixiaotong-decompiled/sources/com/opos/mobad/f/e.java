package com.opos.mobad.f;

import android.content.Context;
import android.text.TextUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.opos.mobad.s;
import com.stub.StubApp;
import java.io.Closeable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e implements com.opos.mobad.d.a, com.opos.mobad.d.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f6904a;
    private Context b;
    private d c;

    private e() {
    }

    public static e a() {
        e eVar;
        e eVar2 = f6904a;
        if (eVar2 != null) {
            return eVar2;
        }
        synchronized (e.class) {
            eVar = f6904a;
            if (eVar == null) {
                eVar = new e();
                f6904a = eVar;
            }
        }
        return eVar;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("fLoader", "close", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:118:0x01c3  */
    public void a(String str, String str2, String str3, com.opos.mobad.d.a.a.InterfaceC0956a interfaceC0956a) throws Throwable {
        Closeable closeable;
        Closeable closeable2;
        com.opos.cmn.func.a.a.e eVarA;
        BufferedSource bufferedSourceBuffer;
        Closeable closeable3;
        Buffer bufferClone;
        String strA;
        try {
            eVarA = com.opos.cmn.func.a.a.b.a().a(this.b, new com.opos.cmn.func.a.a.d.a().b(str).a("GET").a());
            try {
                com.opos.cmn.an.f.a.b("fLoader", "load url:" + str + ", + response:" + eVarA);
                if (eVarA != null) {
                    try {
                        if (eVarA.f6077a == 200) {
                            long j = eVarA.d;
                            com.opos.cmn.func.a.a.a aVar = eVarA.f;
                            bufferedSourceBuffer = Okio.buffer((aVar == null || (strA = aVar.a("Content-Encoding")) == null || !AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(strA)) ? Okio.source(eVarA.c) : new GzipSource(Okio.source(eVarA.c)));
                            try {
                                if (j <= 0 || j > 1638400) {
                                    com.opos.cmn.an.f.a.b("fLoader", "load to file");
                                    a(str, str2, str3, bufferedSourceBuffer, null, interfaceC0956a);
                                    a((Closeable) null);
                                    a((Closeable) null);
                                    a(bufferedSourceBuffer);
                                    if (eVarA != null) {
                                        eVarA.a();
                                        return;
                                    }
                                    return;
                                }
                                Buffer buffer = new Buffer();
                                long j2 = 0;
                                do {
                                    try {
                                        long j3 = bufferedSourceBuffer.read(buffer, 2048L);
                                        if (j3 < 0) {
                                            try {
                                                com.opos.cmn.an.f.a.b("fLoader", "load to cache");
                                                if (TextUtils.isEmpty(str2)) {
                                                    bufferClone = null;
                                                } else {
                                                    bufferClone = buffer.clone();
                                                    try {
                                                        if (!bufferClone.md5().hex().equals(str2)) {
                                                            com.opos.cmn.an.f.a.b("fLoader", "load but md5 fail");
                                                            if (interfaceC0956a != null) {
                                                                interfaceC0956a.a(str, 2);
                                                            }
                                                            a(buffer);
                                                            a(bufferClone);
                                                            a(bufferedSourceBuffer);
                                                            if (eVarA != null) {
                                                                eVarA.a();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                    } catch (Exception e) {
                                                        e = e;
                                                        closeable = bufferClone;
                                                        closeable2 = buffer;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        closeable = bufferClone;
                                                        closeable2 = buffer;
                                                        a(closeable2);
                                                        a(closeable);
                                                        a(bufferedSourceBuffer);
                                                        if (eVarA != null) {
                                                            eVarA.a();
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                if (interfaceC0956a != null) {
                                                    interfaceC0956a.a(str, 0);
                                                }
                                                this.c.a(str, buffer, str3);
                                                a(buffer);
                                                a(bufferClone);
                                                a(bufferedSourceBuffer);
                                                if (eVarA != null) {
                                                    eVarA.a();
                                                    return;
                                                }
                                                return;
                                            } catch (Exception e2) {
                                                e = e2;
                                                closeable2 = buffer;
                                                closeable = null;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                closeable2 = buffer;
                                                closeable = null;
                                                a(closeable2);
                                                a(closeable);
                                                a(bufferedSourceBuffer);
                                                if (eVarA != null) {
                                                    eVarA.a();
                                                }
                                                throw th;
                                            }
                                        } else {
                                            j2 += j3;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        closeable3 = buffer;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        closeable3 = buffer;
                                    }
                                    closeable2 = closeable3;
                                    closeable = null;
                                    try {
                                        com.opos.cmn.an.f.a.b("fLoader", "net", e);
                                        a(closeable2);
                                        a(closeable);
                                        a(bufferedSourceBuffer);
                                        if (eVarA != null) {
                                            eVarA.a();
                                        }
                                        if (interfaceC0956a != null) {
                                            interfaceC0956a.a(str, 3);
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        a(closeable2);
                                        a(closeable);
                                        a(bufferedSourceBuffer);
                                        if (eVarA != null) {
                                            eVarA.a();
                                        }
                                        throw th;
                                    }
                                } while (j2 <= 1638400);
                                com.opos.cmn.an.f.a.b("fLoader", "load to file by size");
                                closeable3 = buffer;
                                try {
                                    a(str, str2, str3, bufferedSourceBuffer, buffer, interfaceC0956a);
                                    a(closeable3);
                                    a((Closeable) null);
                                    a(bufferedSourceBuffer);
                                    if (eVarA != null) {
                                        eVarA.a();
                                        return;
                                    }
                                    return;
                                } catch (Exception e4) {
                                    e = e4;
                                } catch (Throwable th5) {
                                    th = th5;
                                    closeable2 = closeable3;
                                    closeable = null;
                                    a(closeable2);
                                    a(closeable);
                                    a(bufferedSourceBuffer);
                                    if (eVarA != null) {
                                        eVarA.a();
                                    }
                                    throw th;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                closeable = null;
                                closeable2 = null;
                            } catch (Throwable th6) {
                                th = th6;
                                closeable = null;
                                closeable2 = null;
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        closeable = null;
                        closeable2 = null;
                        bufferedSourceBuffer = null;
                    } catch (Throwable th7) {
                        th = th7;
                        closeable = null;
                        closeable2 = null;
                        bufferedSourceBuffer = null;
                    }
                }
                if (interfaceC0956a != null) {
                    interfaceC0956a.a(str, 3);
                }
                a((Closeable) null);
                a((Closeable) null);
                a((Closeable) null);
                if (eVarA != null) {
                    eVarA.a();
                }
            } catch (Exception e7) {
                e = e7;
                closeable = null;
                closeable2 = null;
                bufferedSourceBuffer = null;
            } catch (Throwable th8) {
                th = th8;
                closeable = null;
                closeable2 = null;
                bufferedSourceBuffer = null;
            }
        } catch (Exception e8) {
            e = e8;
            closeable = null;
            closeable2 = null;
            eVarA = null;
            bufferedSourceBuffer = null;
        } catch (Throwable th9) {
            th = th9;
            closeable = null;
            closeable2 = null;
            eVarA = null;
            bufferedSourceBuffer = null;
        }
    }

    private void a(String str, String str2, String str3, BufferedSource bufferedSource, Buffer buffer, com.opos.mobad.d.a.a.InterfaceC0956a interfaceC0956a) {
        int i;
        int iA = buffer == null ? this.c.a(str, bufferedSource, str2, str3) : this.c.a(str, bufferedSource, buffer, str2, str3);
        if (iA == 0) {
            if (interfaceC0956a == null) {
                return;
            } else {
                i = 0;
            }
        } else if (iA == 1) {
            if (interfaceC0956a == null) {
                return;
            } else {
                i = 2;
            }
        } else if (interfaceC0956a == null) {
            return;
        } else {
            i = 3;
        }
        interfaceC0956a.a(str, i);
    }

    private <T extends com.opos.mobad.d.a.a.b> void b(List<T> list, final com.opos.mobad.d.a.a.InterfaceC0956a interfaceC0956a, final com.opos.mobad.d.a.b bVar) {
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        final Set setSynchronizedSet = Collections.synchronizedSet(new HashSet());
        if (bVar != null && !s.a(bVar, 6, 70)) {
            if (bVar != null) {
                bVar.b();
            }
            if (interfaceC0956a != null) {
                interfaceC0956a.a();
                return;
            }
            return;
        }
        int i = 0;
        while (i < list.size()) {
            final T t = list.get(i);
            final boolean z = i == list.size() - 1;
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.e.1
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    com.opos.mobad.d.a.a.b bVar2 = t;
                    if (bVar2 != null) {
                        if (setSynchronizedSet.contains(bVar2.f6861a)) {
                            com.opos.cmn.an.f.a.b("fLoader", "url repeat:" + t.f6861a);
                        } else {
                            setSynchronizedSet.add(t.f6861a);
                            com.opos.mobad.d.a.a.InterfaceC0956a interfaceC0956a2 = interfaceC0956a;
                            if (interfaceC0956a2 != null) {
                                interfaceC0956a2.a(t.f6861a);
                            }
                            if (e.this.c.a(t.f6861a, t.b, t.c)) {
                                com.opos.mobad.d.a.a.InterfaceC0956a interfaceC0956a3 = interfaceC0956a;
                                if (interfaceC0956a3 != null) {
                                    interfaceC0956a3.a(t.f6861a, 1);
                                }
                            } else {
                                e.this.a(t.f6861a, t.b, t.c, interfaceC0956a);
                            }
                        }
                    }
                    countDownLatch.countDown();
                    if (z) {
                        com.opos.cmn.an.f.a.b("fLoader", "wait for complete");
                        try {
                            try {
                                countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
                            } catch (Exception e) {
                                com.opos.cmn.an.f.a.b("fLoader", "wait time out ", e);
                            }
                            com.opos.mobad.d.a.a.InterfaceC0956a interfaceC0956a4 = interfaceC0956a;
                            if (interfaceC0956a4 != null) {
                                interfaceC0956a4.a();
                            }
                        } finally {
                            com.opos.mobad.d.a.b bVar3 = bVar;
                            if (bVar3 != null) {
                                bVar3.b();
                            }
                        }
                    }
                }
            });
            i++;
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("https://") || str.startsWith("http://");
    }

    public void a(Context context) {
        this.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.c = new d(this.b);
    }

    @Override // com.opos.mobad.d.a
    public void a(String str, String str2, int i, int i2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
        if (this.b == null) {
            if (interfaceC0955a != null) {
                interfaceC0955a.a(2, null);
            }
        } else if (b(str)) {
            this.c.b(str, str2, i, i2, interfaceC0955a);
        } else {
            this.c.a(str, str2, i, i2, interfaceC0955a);
        }
    }

    @Override // com.opos.mobad.d.a
    public void a(String str, String str2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
        if (this.b == null) {
            if (interfaceC0955a != null) {
                interfaceC0955a.a(2, null);
            }
        } else if (b(str)) {
            this.c.b(str, str2, interfaceC0955a);
        } else {
            this.c.a(str, str2, interfaceC0955a);
        }
    }

    public <T extends com.opos.mobad.d.a.a.b> void a(List<T> list, com.opos.mobad.d.a.a.InterfaceC0956a interfaceC0956a) {
        a(list, interfaceC0956a, (com.opos.mobad.d.a.b) null);
    }

    public <T extends com.opos.mobad.d.a.a.b> void a(List<T> list, com.opos.mobad.d.a.a.InterfaceC0956a interfaceC0956a, com.opos.mobad.d.a.b bVar) {
        if (this.b != null && list != null && list.size() > 0) {
            b(list, interfaceC0956a, bVar);
        } else if (interfaceC0956a != null) {
            interfaceC0956a.a();
        }
    }

    public boolean a(String str) {
        return this.c.a(str);
    }

    public void b(String str, String str2, int i, int i2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
        if (this.b != null) {
            this.c.b(str, str2, i, i2, interfaceC0955a);
        } else if (interfaceC0955a != null) {
            interfaceC0955a.a(2, null);
        }
    }
}
