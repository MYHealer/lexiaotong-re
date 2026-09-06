package com.ubixnow.ooooo;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.LruCache;
import com.ubixnow.utils.BaseUtils;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO0000Oo {
    private static oO0000Oo OooO00o;
    private static LruCache<String, Bitmap> OooO0O0;
    private static LruCache<String, byte[]> OooO0OO;
    private static Map<String, Long> OooO0Oo;
    private oO0000o0 OooO0o;
    private HashSet<String> OooO0o0;
    private HashMap<String, OooO0o> OooO0oO = new HashMap<>();
    private boolean OooO0oo = false;
    private int OooO = 10000;
    private Timer OooOO0 = null;
    private TimerTask OooOO0O = null;

    public class OooO00o extends AsyncTask<String, Void, Bitmap> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ OooO0o OooO0O0;

        public OooO00o(String str, OooO0o oooO0o) {
            this.OooO00o = str;
            this.OooO0O0 = oooO0o;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: OooO00o, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(String... strArr) {
            Bitmap bitmapOooO0O0 = oO0000Oo.this.OooO0o.OooO0O0(this.OooO00o);
            if (bitmapOooO0O0 == null) {
                oO0000Oo.this.OooO0o0.add(this.OooO00o);
                return oO0000Oo.this.OooO0o.OooO00o(strArr[0], false);
            }
            if (this.OooO0O0 == null) {
                return bitmapOooO0O0;
            }
            oO0000Oo.this.OooO0o0.remove(this.OooO00o);
            return bitmapOooO0O0;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: OooO00o, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            oO0000Oo.this.OooO0oo = true;
            oO0000Oo.this.OooO00o();
            OooO0o oooO0o = this.OooO0O0;
            if (oooO0o != null) {
                this.OooO0O0.OooO00o(bitmap, null, this.OooO00o, oO0000Oo.this.OooO0o.OooO00o() + "/" + oO0000O.OooO0o0(this.OooO00o));
            } else {
                oooO0o.OooO00o(null, null, this.OooO00o, null);
            }
            oO0000Oo.this.OooO0o0.remove(this.OooO00o);
        }
    }

    public class OooO0O0 extends AsyncTask<String, Void, byte[]> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ OooO0o OooO0O0;

        public OooO0O0(String str, OooO0o oooO0o) {
            this.OooO00o = str;
            this.OooO0O0 = oooO0o;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: OooO00o, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(byte[] bArr) {
            super.onPostExecute(bArr);
            try {
                oO0000Oo.this.OooO0o0.remove(this.OooO00o);
                if (oO0000Oo.this.OooO0oO.get(this.OooO00o) == null || oO0000Oo.this.OooO0oo) {
                    return;
                }
                oO0000Oo.this.OooO0oo = true;
                ((OooO0o) oO0000Oo.this.OooO0oO.get(this.OooO00o)).OooO00o(null, bArr, this.OooO00o, oO0000Oo.this.OooO0o.OooO00o() + "/" + oO0000O.OooO0o0(this.OooO00o));
                oO0000Oo.this.OooO00o();
            } catch (Exception unused) {
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: OooO00o, reason: merged with bridge method [inline-methods] */
        public byte[] doInBackground(String... strArr) {
            byte[] bArrOooO0OO = oO0000Oo.this.OooO0o.OooO0OO(this.OooO00o);
            if (bArrOooO0OO == null) {
                ooooO000.OooO0O0("------downloadImageBytes", "doInBackground 下载图片");
                return oO0000Oo.this.OooO0o.OooO0O0(strArr[0], false);
            }
            if (this.OooO0O0 == null) {
                return bArrOooO0OO;
            }
            oO0000Oo.this.OooO0o0.remove(this.OooO00o);
            return bArrOooO0OO;
        }
    }

    public class OooO0OO extends TimerTask {
        public final /* synthetic */ OooO0o OooO00o;

        public OooO0OO(OooO0o oooO0o) {
            this.OooO00o = oooO0o;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (!oO0000Oo.this.OooO0oo && this.OooO00o != null) {
                    oO0000Oo.this.OooO0oo = true;
                    this.OooO00o.OooO00o(null, null, null, null);
                }
                oO0000Oo.this.OooO00o();
            } catch (Exception unused) {
            }
        }
    }

    public interface OooO0o {
        void OooO00o(Bitmap bitmap, byte[] bArr, String str, String str2);
    }

    private oO0000Oo(Context context) {
        OooO0O0(context);
    }

    public static oO0000Oo OooO00o(Context context) {
        if (OooO00o == null) {
            synchronized (oO0000Oo.class) {
                if (OooO00o == null) {
                    OooO00o = new oO0000Oo(context);
                }
            }
        }
        return OooO00o;
    }

    private void OooO00o(OooO0o oooO0o, int i) {
        try {
            this.OooO = i * 1000;
            this.OooOO0 = new Timer();
            OooO0OO oooO0OO = new OooO0OO(oooO0o);
            this.OooOO0O = oooO0OO;
            this.OooOO0.schedule(oooO0OO, this.OooO);
        } catch (Exception unused) {
        }
    }

    private void OooO0O0(Context context) {
        try {
            String string = (BaseUtils.getExternalDir() == null ? new StringBuilder().append(BaseUtils.getCacheDir().getPath()).append(File.separator) : new StringBuilder().append(BaseUtils.getExternalDir().getPath()).append(File.separator)).append("imageCache").toString();
            this.OooO0o0 = new HashSet<>();
            if (OooO0O0 == null) {
                OooO0O0 = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 10);
            }
            if (OooO0Oo == null) {
                OooO0Oo = new HashMap();
            }
            if (OooO0OO == null) {
                OooO0OO = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 10);
            }
            this.OooO0o = new oO0000o0(OooO0O0, OooO0OO);
            OooO0O0(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bitmap OooO00o(String str) {
        return this.OooO0o.OooO0O0(str);
    }

    public void OooO00o() {
        try {
            Timer timer = this.OooOO0;
            if (timer != null) {
                timer.cancel();
                this.OooOO0 = null;
            }
            TimerTask timerTask = this.OooOO0O;
            if (timerTask != null) {
                timerTask.cancel();
                this.OooOO0O = null;
            }
        } catch (Exception unused) {
        }
    }

    public void OooO00o(String str, int i, OooO0o oooO0o) {
        if (TextUtils.isEmpty(str)) {
            if (oooO0o != null) {
                oooO0o.OooO00o(null, null, str, null);
            }
        } else {
            this.OooO0oo = false;
            OooO00o(oooO0o, i);
            new OooO00o(str, oooO0o).executeOnExecutor(Executors.newCachedThreadPool(), str);
        }
    }

    public void OooO00o(String str, Bitmap bitmap) throws Throwable {
        this.OooO0o.OooO00o(str, bitmap);
    }

    public void OooO0O0(String str) {
        this.OooO0o.OooO0o0(str);
    }

    public synchronized void OooO0O0(String str, int i, OooO0o oooO0o) {
        this.OooO0oo = false;
        if (oooO0o != null) {
            this.OooO0oO.put(str, oooO0o);
        }
        HashSet<String> hashSet = this.OooO0o0;
        if ((hashSet != null && hashSet.contains(str)) || TextUtils.isEmpty(str)) {
            if (oooO0o != null && TextUtils.isEmpty(str)) {
                oooO0o.OooO00o(null, null, str, null);
            }
        } else {
            HashSet<String> hashSet2 = this.OooO0o0;
            if (hashSet2 != null && !hashSet2.contains(str)) {
                this.OooO0o0.add(str);
            }
            OooO00o(oooO0o, i);
            new OooO0O0(str, oooO0o).executeOnExecutor(Executors.newCachedThreadPool(), str);
        }
    }
}
