package com.ubixnow.ooooo;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0OoOoOo<T> {
    private final List<o0O000<T>> OooO00o = new ArrayList();
    private int OooO0O0 = 0;

    public class OooO00o extends o0O000O<T> {
        public final /* synthetic */ o0O000O OooO00o;
        public final /* synthetic */ o00O0 OooO0O0;

        public OooO00o(o0O000O o0o000o, o00O0 o00o0) {
            this.OooO00o = o0o000o;
            this.OooO0O0 = o00o0;
        }

        @Override // com.ubixnow.ooooo.o0O000O
        public void OooO00o(int i) {
            this.OooO00o.OooO00o(i);
        }

        @Override // com.ubixnow.ooooo.o0O000O
        public void OooO00o(o0O000Oo o0o000oo) {
            this.OooO00o.OooO00o(o0o000oo);
        }

        @Override // com.ubixnow.ooooo.o0O000O
        public void OooO00o(T t) {
            o0OoOoOo.this.OooO00o(this.OooO0O0, t, this.OooO00o);
        }
    }

    public o0OoOoOo<T> OooO00o(o0O000<T> o0o000) {
        this.OooO00o.add(o0o000);
        return this;
    }

    public T OooO00o(o00O0 o00o0, T t, o0O000O o0o000o) {
        if (this.OooO0O0 >= this.OooO00o.size()) {
            o0o000o.OooO00o(t);
            return t;
        }
        List<o0O000<T>> list = this.OooO00o;
        int i = this.OooO0O0;
        this.OooO0O0 = i + 1;
        list.get(i).OooO00o(o00o0, t, this, new OooO00o(o0o000o, o00o0));
        return t;
    }
}
