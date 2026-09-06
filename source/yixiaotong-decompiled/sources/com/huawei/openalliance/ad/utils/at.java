package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class at {
    private static at B = null;
    private static final String Code = "hiad_sp_properties_cache_sdk";
    private static final String I = "PropertiesCache";
    private static final String V = "cache_data";
    private static final byte[] Z = new byte[0];
    private SharedPreferences C;
    private a F;
    private final byte[] S = new byte[0];

    public static final class a implements Cloneable {
        String B;
        Integer C;
        String Code;
        String D;
        String F;
        String I;
        String L;
        Boolean S;
        Boolean V;
        Boolean Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Integer f4476a;
        Integer b;
        String c;
        String d;

        /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.Code = this.Code;
            aVar.V = this.V;
            aVar.I = this.I;
            aVar.Z = this.Z;
            aVar.B = this.B;
            aVar.C = this.C;
            aVar.S = this.S;
            aVar.F = this.F;
            aVar.D = this.D;
            aVar.L = this.L;
            aVar.f4476a = this.f4476a;
            aVar.b = this.b;
            aVar.c = this.c;
            aVar.d = this.d;
            return aVar;
        }
    }

    private at(Context context) {
        this.C = context.getSharedPreferences(Code, 0);
    }

    public static at Code(Context context) {
        at atVar;
        synchronized (Z) {
            if (B == null) {
                B = new at(context);
            }
            atVar = B;
        }
        return atVar;
    }

    private void Code(a aVar) {
        if (aVar == null) {
            return;
        }
        final a aVarClone = aVar.clone();
        i.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.at.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = at.this.C.edit();
                editorEdit.putString(at.V, ad.V(aVarClone));
                editorEdit.apply();
            }
        });
    }

    private void f() {
        if (this.F == null) {
            a aVar = null;
            String string = this.C.getString(V, null);
            if (string != null && string.length() > 0) {
                aVar = (a) ad.V(string, a.class, new Class[0]);
            }
            if (aVar == null) {
                aVar = new a();
            }
            this.F = aVar;
        }
    }

    public Boolean B() {
        synchronized (this.S) {
            f();
            if (this.F.Z == null) {
                return null;
            }
            return this.F.Z;
        }
    }

    public void B(String str) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.d = str;
            Code(this.F);
        }
    }

    public void B(boolean z) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.L = String.valueOf(z);
            Code(this.F);
        }
    }

    public String C() {
        String str;
        synchronized (this.S) {
            f();
            str = this.F.B;
        }
        return str;
    }

    public void Code() {
        synchronized (this.S) {
            f();
        }
    }

    public void Code(int i) {
        synchronized (this.S) {
            f();
            this.F.C = Integer.valueOf(i);
            Code(this.F);
        }
    }

    public void Code(Boolean bool) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.S = bool;
            Code(this.F);
        }
    }

    public void Code(Integer num) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.f4476a = num;
            Code(this.F);
        }
    }

    public void Code(String str) {
        synchronized (this.S) {
            f();
            this.F.I = str;
            Code(this.F);
        }
    }

    public void Code(boolean z) {
        synchronized (this.S) {
            f();
            this.F.V = Boolean.valueOf(z);
            Code(this.F);
        }
    }

    public String D() {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return "";
            }
            return aVar.F;
        }
    }

    public Boolean F() {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            return aVar.S;
        }
    }

    public String I() {
        synchronized (this.S) {
            f();
            if (this.F.I == null) {
                return null;
            }
            return this.F.I;
        }
    }

    public void I(String str) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.F = str;
            Code(this.F);
        }
    }

    public void I(boolean z) {
        synchronized (this.S) {
            f();
            this.F.Z = Boolean.valueOf(z);
            Code(this.F);
        }
    }

    public String L() {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            if (aVar.D == null) {
                return null;
            }
            return this.F.D;
        }
    }

    public Integer S() {
        synchronized (this.S) {
            f();
            if (this.F.C == null) {
                return null;
            }
            return this.F.C;
        }
    }

    public void V(Integer num) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.b = num;
            Code(this.F);
        }
    }

    public void V(String str) {
        synchronized (this.S) {
            f();
            this.F.B = str;
            Code(this.F);
        }
    }

    public void V(boolean z) {
        synchronized (this.S) {
            f();
            this.F.Code = String.valueOf(z);
            Code(this.F);
        }
    }

    public boolean V() {
        synchronized (this.S) {
            f();
            if (this.F.V == null) {
                return false;
            }
            return this.F.V.booleanValue();
        }
    }

    public String Z() {
        String str;
        synchronized (this.S) {
            f();
            str = this.F.Code;
        }
        return str;
    }

    public void Z(String str) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.c = str;
            Code(this.F);
        }
    }

    public void Z(boolean z) {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.D = String.valueOf(z);
            Code(this.F);
        }
    }

    public String a() {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            if (aVar.L == null) {
                return null;
            }
            return this.F.L;
        }
    }

    public Integer b() {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            return aVar.f4476a;
        }
    }

    public Integer c() {
        synchronized (this.S) {
            f();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            if (aVar.b == null) {
                return null;
            }
            return this.F.b;
        }
    }

    public String d() {
        synchronized (this.S) {
            f();
            if (TextUtils.isEmpty(this.F.c)) {
                return "";
            }
            return this.F.c;
        }
    }

    public String e() {
        synchronized (this.S) {
            f();
            if (TextUtils.isEmpty(this.F.d)) {
                return "";
            }
            return this.F.d;
        }
    }
}
