package s_a.s_a.s_a.c;

import android.app.OplusNotificationManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.android.id.impl.IdProviderImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class b extends s_a.s_a.s_a.a.b {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f9749a;

        public a(Context context) {
            this.f9749a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a("2050");
            ArrayList arrayList = new ArrayList();
            arrayList.add("OUID");
            b.this.a(this.f9749a, (List<String>) arrayList, true);
            b.this.f9741a.remove("OUID");
        }
    }

    /* JADX INFO: renamed from: s_a.s_a.s_a.c.b$b, reason: collision with other inner class name */
    public static class C1191b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9750a = new b();
    }

    public final void a(Context context, List<String> list, HashMap<String, String> map) {
        String string = Settings.Secure.getString(context.getContentResolver(), "oplus_omes_stdid_ouid");
        if (TextUtils.isEmpty(string)) {
            h.a("2045");
            return;
        }
        map.put("OUID", string);
        list.remove("OUID");
        s_a.s_a.s_a.c.a.f9748a.execute(new a(context));
    }

    @Override // s_a.s_a.s_a.a.b
    public void a(Context context, List<String> list, boolean z) {
        (this.b.equals("OP_APP") ? c.b.f9752a : i.b.f9758a).a(context, list, z);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:67:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // s_a.s_a.s_a.a.b
    public HashMap<String, String> b(Context context, List<String> list) {
        String openid;
        OplusNotificationManager oplusNotificationManager;
        HashMap<String, String> map = new HashMap<>();
        if (this.b.equals("OP_APP")) {
            if (list.contains("OUID_STATUS") && !c.b.f9752a.k) {
                map.put("OUID_STATUS", Settings.Secure.getInt(context.getContentResolver(), s_a.s_a.s_a.c.a.b.equals("phone") ? "openid_toggle" : "stdid_toggle", 1) != 1 ? "FALSE" : "TRUE");
                list.remove("OUID_STATUS");
                h.a("2041");
            }
            if (list.contains("OUID")) {
                if (!s_a.s_a.s_a.c.a.b.equals("phone")) {
                    a(context, list, map);
                    h.a("2052");
                } else if (Build.VERSION.SDK_INT >= 28) {
                    s_a.s_a.s_a.b.a aVar = s_a.s_a.s_a.b.a.C1190a.f9747a;
                    IdProviderImpl idProviderImpl = aVar.f9746a;
                    if (idProviderImpl != null) {
                        try {
                            openid = idProviderImpl.getOpenid(context, "OUID");
                        } catch (Error | Exception e) {
                            Log.e("IDHelper", "1086: " + (e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage()));
                            oplusNotificationManager = aVar.b;
                            if (oplusNotificationManager != null) {
                                try {
                                    openid = oplusNotificationManager.getStdid(context.getPackageName(), Binder.getCallingUid(), "OUID");
                                } catch (Error | Exception e2) {
                                    Log.e("IDHelper", "1087: " + (e2.getMessage() != null ? e2.getMessage() : e2.getLocalizedMessage()));
                                    openid = "";
                                }
                            } else {
                                openid = "";
                            }
                        }
                    } else {
                        oplusNotificationManager = aVar.b;
                        if (oplusNotificationManager != null) {
                            openid = oplusNotificationManager.getStdid(context.getPackageName(), Binder.getCallingUid(), "OUID");
                        } else {
                            openid = "";
                        }
                    }
                    h.a("2042");
                    if (TextUtils.isEmpty(openid)) {
                        Log.e("IDHelper", "1088");
                    } else {
                        map.put("OUID", openid);
                        list.remove("OUID");
                    }
                } else if (c.b.f9752a.j) {
                    h.a("2046");
                    a(context, list, map);
                }
            }
        } else if (this.b.equals("MCS_APP")) {
            if (list.contains("OUID_STATUS")) {
                map.put("OUID_STATUS", "TRUE");
                list.remove("OUID_STATUS");
                h.a("2043");
            }
            if (list.contains("OUID")) {
                h.a("2044");
                if (i.b.f9758a.j) {
                    a(context, list, map);
                }
            }
        }
        return map;
    }
}
