package s_a.s_a.s_a.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.yfanads.android.model.YFAdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s_a.s_a.s_a.c.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class c {
    public Handler f;
    public HandlerThread g;
    public Context h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile IInterface f9742a = null;
    public String b = null;
    public String c = null;
    public final Object d = new Object();
    public ServiceConnection e = null;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public volatile ContentProviderClient l = null;
    public IBinder.DeathRecipient m = new a();

    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.e("IDHelper", "1029");
            if (c.this.f9742a != null) {
                c.this.f9742a.asBinder().unlinkToDeath(c.this.m, 0);
                c.this.f9742a = null;
            }
        }
    }

    public Intent a() {
        throw null;
    }

    public String a(String str) {
        throw null;
    }

    public void a(Context context, String str, String str2) {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00ce A[Catch: all -> 0x00e3, TRY_LEAVE, TryCatch #1 {all -> 0x00e3, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x001e, B:7:0x0027, B:9:0x002d, B:11:0x0035, B:14:0x0040, B:12:0x003a, B:15:0x0044, B:19:0x004c, B:21:0x0059, B:22:0x005f, B:24:0x0067, B:25:0x0071, B:27:0x0075, B:38:0x009c, B:40:0x00a0, B:48:0x00bd, B:57:0x00ce, B:60:0x00d7, B:62:0x00db, B:63:0x00e2, B:55:0x00ca, B:30:0x007a, B:32:0x007e, B:33:0x008e, B:35:0x0092, B:37:0x0097, B:43:0x00a9, B:44:0x00ad, B:46:0x00b3, B:54:0x00c5), top: B:68:0x0001, inners: #0 }] */
    public synchronized void a(Context context, List<String> list, boolean z) {
        try {
            if (this.f == null) {
                HandlerThread handlerThread = new HandlerThread("GetIDWorkThread");
                this.g = handlerThread;
                handlerThread.start();
                this.f = new d(this, this.g.getLooper());
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!(z ? b(str) : c(str))) {
                    arrayList.add(str);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            h.a("2010");
            if (TextUtils.isEmpty(this.b)) {
                this.b = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.c)) {
                this.c = s_a.s_a.s_a.c.a.a(context, this.b, "SHA1");
            }
            if (this.i) {
                try {
                    try {
                        if (this.l == null) {
                            this.l = context.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.oplus.omes.ids_provider"));
                        }
                        if (this.l == null) {
                            a(arrayList);
                            Log.e("IDHelper", "3147");
                            if (this.l != null) {
                                this.l.close();
                                this.l = null;
                            }
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            e((String) it.next());
                        }
                        if (this.l != null) {
                            this.l.close();
                            this.l = null;
                        }
                    } catch (Throwable th) {
                        if (this.l != null) {
                            this.l.close();
                            this.l = null;
                        }
                        throw th;
                    }
                } catch (Exception e) {
                    h.a("3148", e);
                    if (this.l != null) {
                        this.l.close();
                        this.l = null;
                    }
                }
            } else {
                a(arrayList);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void a(List<String> list) {
        String str;
        h.a("2048");
        if (this.f9742a == null) {
            h.a("2009");
            try {
                if (this.h.bindService(a(), this.e, 1)) {
                    h.a("2013");
                    if (this.f9742a == null) {
                        synchronized (this.d) {
                            try {
                                if (this.f9742a == null) {
                                    this.d.wait(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                                }
                            } catch (InterruptedException e) {
                                e = e;
                                str = YFAdError.ERROR_EMPTY;
                                h.a(str, e);
                            } catch (Exception e2) {
                                e = e2;
                                str = "1057";
                                h.a(str, e);
                            }
                        }
                    }
                } else {
                    Log.e("IDHelper", YFAdError.ERROR_OVER_HOUR);
                }
            } catch (Exception e3) {
                h.a(YFAdError.ERROR_OVER_DAY, e3);
            }
        }
        if (this.f9742a == null) {
            Log.e("IDHelper", "1004");
            return;
        }
        Handler handler = this.f;
        if (handler != null) {
            handler.removeMessages(2);
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            e(it.next());
        }
        Handler handler2 = this.f;
        if (handler2 == null) {
            return;
        }
        Message messageObtainMessage = handler2.obtainMessage();
        messageObtainMessage.what = 2;
        this.f.sendMessageDelayed(messageObtainMessage, 300000L);
    }

    public boolean b(String str) {
        throw null;
    }

    public boolean c(String str) {
        throw null;
    }

    public String d(String str) {
        h.a("2049");
        Bundle bundle = new Bundle();
        bundle.putString("packageName", this.b);
        bundle.putString("signature", this.c);
        try {
            if (this.l != null) {
                return this.l.call(str, null, bundle).getString(str);
            }
        } catch (RemoteException unused) {
            Log.e("IDHelper", "3149");
        } catch (Exception e) {
            h.a("3150", e);
        }
        return "";
    }

    public final void e(String str) {
        String str2;
        synchronized (this.d) {
            h.a(str + " 2023");
            Handler handler = this.f;
            if (handler != null) {
                Message messageObtainMessage = handler.obtainMessage();
                if (str.equals("RESET_OUID")) {
                    messageObtainMessage.what = 3;
                } else {
                    messageObtainMessage.what = 1;
                }
                Bundle bundle = new Bundle();
                bundle.putString("IdType", str);
                messageObtainMessage.setData(bundle);
                this.f.sendMessage(messageObtainMessage);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            int i = str.equals("DUID") ? 5000 : 2000;
            try {
                this.d.wait(i);
            } catch (InterruptedException e) {
                e = e;
                str2 = "1022";
                h.a(str2, e);
            } catch (Exception e2) {
                e = e2;
                str2 = "1058";
                h.a(str2, e);
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis > i) {
                Log.e("IDHelper", "1023");
            }
            h.a(str + " 2024");
        }
    }
}
