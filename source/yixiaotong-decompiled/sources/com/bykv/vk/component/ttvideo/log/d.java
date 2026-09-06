package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.nys.tt;
import com.bykv.vk.component.ttvideo.utils.EngineThreadPool;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bykv.vk.component.ttvideo.log.a f2970a;
    private c c;
    private String e;
    private String f;
    private Context j;
    private int g = 0;
    public int h = 0;
    private int i = 0;
    private long k = -2147483648L;
    private f b = new f();
    private boolean d = true;

    private static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f f2971a;
        private Handler b = new Handler(Looper.getMainLooper());
        c c;

        /* JADX INFO: renamed from: com.bykv.vk.component.ttvideo.log.d$a$a, reason: collision with other inner class name */
        class RunnableC0353a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ JSONObject f2972a;

            RunnableC0353a(a aVar, JSONObject jSONObject) {
                this.f2972a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.instance.a(false, this.f2972a);
            }
        }

        public a(f fVar, d dVar, c cVar) {
            this.f2971a = fVar;
            this.c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTVideoEngineLog.i("VideoEventLoggerV2", "AyncGetLogDataRunnable enter");
            f fVar = this.f2971a;
            if (fVar == null) {
                TTVideoEngineLog.e("VideoEventLoggerV2", "rEvent is null, return.");
                return;
            }
            JSONObject jSONObjectA = fVar.a(this.c);
            Handler handler = this.b;
            if (handler == null || handler.getLooper() == null) {
                TTVideoEngineLog.i("VideoEventLoggerV2", "report in child thread");
                e.instance.a(false, jSONObjectA);
            } else {
                TTVideoEngineLog.i("VideoEventLoggerV2", "report in main looper");
                this.b.post(new RunnableC0353a(this, jSONObjectA));
            }
        }
    }

    public d(Context context, com.bykv.vk.component.ttvideo.log.a aVar) {
        this.f2970a = aVar;
        this.c = new c(aVar, context);
        this.j = context;
    }

    private void b() {
        this.i = 0;
        this.d = true;
        this.h = 0;
        this.k = -2147483648L;
    }

    private void c() {
        String strDecode;
        StringBuilder sb;
        String string;
        if (!TextUtils.isEmpty(this.e)) {
            strDecode = this.e;
        } else if (TextUtils.isEmpty(this.f)) {
            return;
        } else {
            strDecode = this.f;
        }
        try {
            strDecode = URLDecoder.decode(strDecode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            sb = new StringBuilder("exception:");
            string = e.toString();
            TTVideoEngineLog.e("VideoEventLoggerV2", sb.append(string).toString());
        } catch (IllegalArgumentException e2) {
            sb = new StringBuilder("exception:");
            string = e2.toString();
            TTVideoEngineLog.e("VideoEventLoggerV2", sb.append(string).toString());
        }
        int iIndexOf = strDecode.indexOf("&l=");
        if (iIndexOf > 0) {
            int iIndexOf2 = strDecode.indexOf("&", iIndexOf + 1);
            int i = iIndexOf + 3;
            this.b.o = iIndexOf2 > 0 ? strDecode.substring(i, iIndexOf2) : strDecode.substring(i);
        }
    }

    private void d() {
        if (this.b == null) {
            return;
        }
        TTVideoEngineLog.i("VideoEventLoggerV2", "sendEvent pt_new:" + this.b.b + ", mEvent:" + this.b + ", eventBase:" + this.c);
        if (this.b.b > 0 || this.k > 0) {
            int i = this.g;
            if (i > 0) {
                this.c.h = i;
            }
            SharedPreferences sharedPreferencesTt = tt.tt(this.j, "VideoEventLogger", 0);
            this.b.p = sharedPreferencesTt.getString("playersessionid", "");
            SharedPreferences.Editor editorEdit = sharedPreferencesTt.edit();
            editorEdit.putString("playersessionid", this.c.f);
            editorEdit.apply();
            f fVar = this.b;
            fVar.n = this.c.f;
            fVar.h = this.h;
            String str = this.e;
            if (str != null) {
                fVar.k = str;
            }
            String str2 = this.f;
            if (str2 != null) {
                this.b.l = str2;
            }
            f fVar2 = this.b;
            fVar2.c = fVar2.b;
            fVar2.f2974a = this.k;
            if (fVar2.e <= 0 && fVar2.d > 0) {
                fVar2.e = System.currentTimeMillis();
            }
            if (TextUtils.isEmpty(this.b.o)) {
                c();
            }
            EngineThreadPool.a().execute(new a(this.b, this, this.c));
            b();
        }
    }

    private void f(int i) {
        d();
        this.b = new f();
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a() {
        if (this.i != 4) {
            this.i = 2;
            this.d = false;
            f fVar = this.b;
            if (fVar.d <= 0) {
                fVar.d = System.currentTimeMillis();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x002b  */
    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i != 5) {
            int i2 = this.i;
            boolean z = i2 != 4;
            if (i2 != 3 && z) {
                this.c.a();
            }
        }
        if (this.d) {
            f fVar = this.b;
            if (fVar.d <= 0) {
                fVar.f = jCurrentTimeMillis;
            } else {
                this.b.e = jCurrentTimeMillis;
            }
        } else {
            this.b.e = jCurrentTimeMillis;
        }
        f(i);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(long j, String str) {
        this.i = 1;
        this.c.a(str);
        if (this.k <= 0) {
            this.k = j;
        }
        this.d = true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(Error error, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i2 = this.i;
        boolean z = i2 != 3 ? i2 != 4 : false;
        this.i = 5;
        if (this.d) {
            f fVar = this.b;
            if (fVar.d <= 0) {
                fVar.f = jCurrentTimeMillis;
            } else {
                if (error.c.equals(Error.VideoOwnPlayer) || error.c.equals(Error.VideoOSPlayer)) {
                    this.h++;
                }
                this.b.e = jCurrentTimeMillis;
            }
        } else {
            if (error.c.equals(Error.VideoOwnPlayer)) {
                this.h++;
            } else {
                this.h++;
            }
            this.b.e = jCurrentTimeMillis;
        }
        if (z) {
            this.c.a();
        }
        this.b.i = error.getType();
        this.b.j = error.f2976a;
        f(4);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(Error error, int i, int i2) {
        if (error.c.equals(Error.VideoOwnPlayer) || error.c.equals(Error.VideoOSPlayer)) {
            this.h++;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(String str) {
        if (this.c == null || str == null || str.isEmpty()) {
            return;
        }
        this.c.b(str);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void a(String str, String str2) {
        this.e = str;
        c cVar = this.c;
        if (cVar != null) {
            cVar.g = str;
        }
        this.f = str2;
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void b(int i) {
        this.b.m = i;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0035  */
    @Override // com.bykv.vk.component.ttvideo.log.b
    public void c(int i) {
        if (this.i == 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i2 = this.i;
        boolean z = i2 != 4;
        if (i2 == 3) {
            z = false;
        }
        this.i = 0;
        if (this.d) {
            f fVar = this.b;
            if (fVar.b <= 0 || fVar.d > 0) {
                this.b.e = jCurrentTimeMillis;
            } else if (fVar.f <= 0) {
                fVar.f = jCurrentTimeMillis;
            }
        } else {
            this.b.e = jCurrentTimeMillis;
        }
        if (z) {
            this.c.a();
        }
        f(i);
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void d(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i == 10) {
            f fVar = this.b;
            if (fVar.b <= 0) {
                fVar.b = jCurrentTimeMillis;
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void e(int i) {
        this.g = i;
        this.c.h = i;
    }

    @Override // com.bykv.vk.component.ttvideo.log.b
    public void reset() {
        this.d = true;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = 0;
        this.c = new c(this.f2970a, this.j);
    }
}
