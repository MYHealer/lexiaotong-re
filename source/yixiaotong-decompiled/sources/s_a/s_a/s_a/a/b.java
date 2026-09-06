package s_a.s_a.s_a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import s_a.s_a.s_a.c.f;
import s_a.s_a.s_a.c.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, f> f9741a = new ConcurrentHashMap();
    public String b;

    public HashMap<String, String> a(Context context, List<String> list) {
        String str;
        String str2;
        f fVar;
        HashMap<String, String> mapB = b(context, list);
        if (list.isEmpty()) {
            str = "2040";
        } else {
            ArrayList arrayList = new ArrayList();
            if (this.f9741a.isEmpty()) {
                s_a.s_a.s_a.c.a.a(context, this.f9741a);
            }
            for (String str3 : list) {
                String str4 = null;
                if (this.f9741a.containsKey(str3) && (fVar = this.f9741a.get(str3)) != null) {
                    try {
                        if (!fVar.a(str3)) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(str3);
                            h.a("1025");
                            s_a.s_a.s_a.c.a.f9748a.execute(new a(this, context, arrayList2));
                        }
                        str4 = fVar.f9755a;
                    } catch (Exception e) {
                        Log.e("IDHelper", "1095: " + (e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage()));
                    }
                }
                if (str4 == null) {
                    arrayList.add(str3);
                }
            }
            if (!arrayList.isEmpty()) {
                h.a("1026");
                a(context, (List<String>) arrayList, false);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                f fVar2 = this.f9741a.get(next);
                if (fVar2 == null) {
                    str2 = next == "OUID_STATUS" ? "FALSE" : "";
                } else {
                    if (next.equals("OUID") || next.equals("OUID_STATUS")) {
                        this.f9741a.remove(next);
                    }
                    str2 = fVar2.f9755a;
                }
                mapB.put(next, str2);
            }
            str = "2025";
        }
        h.a(str);
        return mapB;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00a1  */
    public void a(Context context, String str, String str2) {
        f fVar;
        String str3;
        String str4;
        long j;
        if (str2 == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() + s_a.s_a.s_a.c.a.b(str);
        if (str.equals("GUID") || str.equals("APID") || !"".equals(str2)) {
            if (!this.f9741a.containsKey(str) || (fVar = this.f9741a.get(str)) == null) {
                fVar = new f(str2, jCurrentTimeMillis);
                this.f9741a.put(str, fVar);
            } else {
                fVar.f9755a = str2;
                fVar.b = jCurrentTimeMillis;
            }
            if (str.equals("OUID") || str.equals("OUID_STATUS")) {
                return;
            }
            try {
                byte b = 0;
                SharedPreferences.Editor editorEdit = context.getSharedPreferences("cache", 0).edit();
                int iHashCode = str.hashCode();
                if (iHashCode != 2015626) {
                    if (iHashCode != 2020431) {
                        if (iHashCode != 2109804) {
                            if (iHashCode == 2199177 && str.equals("GUID")) {
                                b = 1;
                            } else {
                                b = -1;
                            }
                        } else if (str.equals("DUID")) {
                            b = 3;
                        } else {
                            b = -1;
                        }
                    } else if (str.equals("AUID")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (!str.equals("APID")) {
                    b = -1;
                }
                if (b == 0) {
                    s_a.s_a.s_a.c.a.a(editorEdit, fVar, "APID", "APID_TIME", "APID_IV");
                } else if (b != 1) {
                    if (b == 2) {
                        str4 = "AUID_TIME";
                        editorEdit.putString("AUID", fVar.f9755a);
                        j = fVar.b;
                    } else if (b == 3) {
                        str4 = "DUID_TIME";
                        editorEdit.putString("DUID", fVar.f9755a);
                        j = fVar.b;
                    }
                    editorEdit.putLong(str4, j);
                } else {
                    s_a.s_a.s_a.c.a.a(editorEdit, fVar, "GUID", "GUID_TIME", "GUID_IV");
                }
                editorEdit.apply();
            } catch (IllegalStateException e) {
                e = e;
                str3 = "1019";
                h.a(str3, e);
            } catch (Exception e2) {
                e = e2;
                str3 = "1063";
                h.a(str3, e);
            }
        }
    }

    public void a(Context context, List<String> list, boolean z) {
        throw null;
    }

    public boolean a(String str) {
        return !this.f9741a.isEmpty() && this.f9741a.containsKey(str);
    }

    public HashMap<String, String> b(Context context, List<String> list) {
        return new HashMap<>();
    }

    public boolean b(String str) {
        if (!this.f9741a.isEmpty() && this.f9741a.containsKey(str)) {
            try {
                f fVar = this.f9741a.get(str);
                return fVar != null && fVar.a(str);
            } catch (Exception e) {
                Log.e("IDHelper", "1094: " + (e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage()));
            }
        }
        return false;
    }
}
