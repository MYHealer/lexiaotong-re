package com.hihonor.hianalytics.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.hihonor.hianalytics.hnha.j2;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final Map<String, a> d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3715a = true;
    private final SharedPreferences b;
    private final String c;

    public a(String str, int i, boolean z) {
        Context contextE = z ? SystemUtils.e() : SystemUtils.getContext();
        j2.a("BaseSpUtils", "construct spName=" + str + ",mode=" + i + ",context=" + contextE);
        this.b = contextE.getSharedPreferences(str, i);
        this.c = str;
    }

    public static a a(String str, int i) {
        return a(str, i, false);
    }

    public static a a(String str, int i, boolean z) {
        if (b.c(str)) {
            str = "spUtils";
        }
        if (z) {
            str = str + "_directBoot";
        }
        Map<String, a> map = d;
        a aVar = map.get(str);
        if (aVar == null) {
            synchronized (a.class) {
                aVar = map.get(str);
                if (aVar == null) {
                    aVar = new a(str, i, z);
                    if (i != 4) {
                        map.put(str, aVar);
                    }
                }
            }
        }
        return aVar;
    }

    public static a b(String str, boolean z) {
        return a(str, 0, z);
    }

    public static a c(String str) {
        return a(str, 0, false);
    }

    public float a(String str, float f) {
        return this.b.getFloat(str, f);
    }

    public long a(String str, long j) {
        return this.b.getLong(str, j);
    }

    public String a(String str, String str2) {
        return this.b.getString(str, str2);
    }

    public boolean a() {
        return a(this.f3715a);
    }

    public boolean a(String str) {
        return this.b.contains(str);
    }

    public boolean a(String str, float f, boolean z) {
        if (z) {
            return this.b.edit().putFloat(str, f).commit();
        }
        this.b.edit().putFloat(str, f).apply();
        return true;
    }

    public boolean a(String str, long j, boolean z) {
        if (z) {
            return this.b.edit().putLong(str, j).commit();
        }
        this.b.edit().putLong(str, j).apply();
        return true;
    }

    public boolean a(String str, String str2, boolean z) {
        if (z) {
            return this.b.edit().putString(str, str2).commit();
        }
        this.b.edit().putString(str, str2).apply();
        return true;
    }

    public boolean a(String str, boolean z) {
        return this.b.getBoolean(str, z);
    }

    public boolean a(String str, boolean z, boolean z2) {
        if (z2) {
            return this.b.edit().putBoolean(str, z).commit();
        }
        this.b.edit().putBoolean(str, z).apply();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a1, code lost:
    
        if (r10 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c1, code lost:
    
        if (r10 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c8, code lost:
    
        r2.apply();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
    
        return r2.commit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
    
        return true;
     */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(HashMap.java:338)
    	at java.base/java.util.HashMap.getNode(HashMap.java:568)
    	at java.base/java.util.HashMap.containsKey(HashMap.java:594)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Map<String, ?> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        SharedPreferences.Editor editorEdit = null;
        try {
            editorEdit = this.b.edit();
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                if (obj instanceof Boolean) {
                    editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    editorEdit.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    editorEdit.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof String) {
                    editorEdit.putString(str, (String) obj);
                } else if (obj instanceof Float) {
                    editorEdit.putFloat(str, ((Float) obj).floatValue());
                } else if (obj instanceof Set) {
                    try {
                        editorEdit.putStringSet(str, (Set) obj);
                    } catch (Throwable th) {
                        j2.g("BaseSpUtils", "putAll key=" + str + ",fail=" + SystemUtils.getDesensitizedException(th));
                    }
                }
            }
            if (editorEdit != null) {
            }
        } catch (Throwable th2) {
            try {
                j2.g("BaseSpUtils", "putAll fail=" + SystemUtils.getDesensitizedException(th2));
                if (editorEdit != null) {
                }
                return false;
            } catch (Throwable th3) {
                if (editorEdit != null) {
                    if (z) {
                        editorEdit.commit();
                    } else {
                        editorEdit.apply();
                    }
                }
                throw th3;
            }
        }
        return false;
    }

    public boolean a(boolean z) {
        if (z) {
            return this.b.edit().clear().commit();
        }
        this.b.edit().clear().apply();
        return true;
    }

    public int b(String str, int i) {
        return this.b.getInt(str, i);
    }

    public Map<String, ?> b() {
        return this.b.getAll();
    }

    public boolean b(String str) {
        return a(str, false);
    }

    public boolean b(String str, float f) {
        return a(str, f, this.f3715a);
    }

    public boolean b(String str, int i, boolean z) {
        if (z) {
            return this.b.edit().putInt(str, i).commit();
        }
        this.b.edit().putInt(str, i).apply();
        return true;
    }

    public boolean b(String str, long j) {
        return a(str, j, this.f3715a);
    }

    public boolean b(String str, String str2) {
        return a(str, str2, this.f3715a);
    }

    public File c() {
        try {
            return new File(SystemUtils.getContext().getFilesDir(), "../shared_prefs/" + this.c + ".xml");
        } catch (Throwable th) {
            j2.g("BaseSpUtils", "getSpFile fail=" + SystemUtils.getDesensitizedException(th));
            return null;
        }
    }

    public boolean c(String str, int i) {
        return b(str, i, this.f3715a);
    }

    public boolean c(String str, boolean z) {
        return a(str, z, this.f3715a);
    }

    public long d() {
        try {
            return c().length();
        } catch (Throwable th) {
            j2.g("BaseSpUtils", "getSpFileSize fail=" + SystemUtils.getDesensitizedException(th));
            return 0L;
        }
    }

    public boolean d(String str) {
        return d(str, this.f3715a);
    }

    public boolean d(String str, boolean z) {
        if (z) {
            return this.b.edit().remove(str).commit();
        }
        this.b.edit().remove(str).apply();
        return true;
    }
}
