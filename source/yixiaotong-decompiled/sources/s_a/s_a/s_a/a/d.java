package s_a.s_a.s_a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import s_a.s_a.s_a.c.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class d extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f9744a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, Looper looper) {
        super(looper);
        this.f9744a = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        StringBuilder sb;
        super.handleMessage(message);
        String string = message.getData().getString("IdType");
        int i = message.what;
        if (i == 1) {
            h.a("2017");
            c cVar = this.f9744a;
            if (cVar.i || cVar.f9742a != null) {
                try {
                    String strA = this.f9744a.a(string);
                    c cVar2 = this.f9744a;
                    cVar2.a(cVar2.h, string, strA);
                    synchronized (this.f9744a.d) {
                        try {
                            this.f9744a.d.notify();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (RemoteException e) {
                    e = e;
                    str = "1005";
                    h.a(str, e);
                } catch (Exception e2) {
                    e = e2;
                    str = "1054";
                    h.a(str, e);
                }
            } else {
                sb = new StringBuilder();
                Log.e("IDHelper", sb.append(this.f9744a.b).append(" 1009").toString());
            }
        } else {
            if (i == 2) {
                c cVar3 = this.f9744a;
                synchronized (cVar3) {
                    try {
                        if (cVar3.f9742a != null) {
                            h.a("2019");
                            if (cVar3.h != null && cVar3.e != null) {
                                cVar3.h.unbindService(cVar3.e);
                            }
                            cVar3.f9742a = null;
                        }
                    } catch (Exception e3) {
                        h.a("1010", e3);
                    }
                }
                return;
            }
            if (i != 3) {
                return;
            }
            h.a("2017");
            if (this.f9744a.f9742a == null) {
                sb = new StringBuilder();
                Log.e("IDHelper", sb.append(this.f9744a.b).append(" 1009").toString());
            } else {
                try {
                    this.f9744a.a(string);
                    synchronized (this.f9744a.d) {
                        try {
                            this.f9744a.d.notify();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                } catch (RemoteException e4) {
                    e = e4;
                    str = "1055";
                    h.a(str, e);
                } catch (Exception e5) {
                    e = e5;
                    str = "1056";
                    h.a(str, e);
                }
            }
        }
        h.a("2018");
    }
}
