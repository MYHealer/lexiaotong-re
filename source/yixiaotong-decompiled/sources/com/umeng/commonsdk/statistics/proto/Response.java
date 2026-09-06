package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class Response implements av<Response, e>, Serializable, Cloneable {
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<e, bh> metaDataMap;
    private static final Map<Class<? extends cc>, cd> schemes;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public com.umeng.commonsdk.statistics.proto.d imprint;
    public String msg;
    private e[] optionals;
    public int resp_code;
    private static final bz STRUCT_DESC = new bz("Response");
    private static final bp RESP_CODE_FIELD_DESC = new bp("resp_code", (byte) 8, 1);
    private static final bp MSG_FIELD_DESC = new bp("msg", (byte) 11, 2);
    private static final bp IMPRINT_FIELD_DESC = new bp(am.X, (byte) 12, 3);

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.Response$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public com.umeng.commonsdk.statistics.proto.d getImprint() {
        return this.imprint;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public Response setImprint(com.umeng.commonsdk.statistics.proto.d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void setImprintIsSet(boolean z) {
        if (z) {
            return;
        }
        this.imprint = null;
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z) {
        if (z) {
            return;
        }
        this.msg = null;
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    static {
        HashMap map = new HashMap();
        schemes = map;
        AnonymousClass1 anonymousClass1 = null;
        map.put(ce.class, new b(anonymousClass1));
        map.put(cf.class, new d(anonymousClass1));
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.RESP_CODE, new bh("resp_code", (byte) 1, new bi((byte) 8)));
        enumMap.put(e.MSG, new bh("msg", (byte) 2, new bi((byte) 11)));
        enumMap.put(e.IMPRINT, new bh(am.X, (byte) 2, new bm((byte) 12, com.umeng.commonsdk.statistics.proto.d.class)));
        Map<e, bh> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        metaDataMap = mapUnmodifiableMap;
        bh.a(Response.class, mapUnmodifiableMap);
    }

    public enum e implements bc {
        RESP_CODE(1, "resp_code"),
        MSG(2, "msg"),
        IMPRINT(3, am.X);

        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        public static e a(int i) {
            if (i == 1) {
                return RESP_CODE;
            }
            if (i == 2) {
                return MSG;
            }
            if (i != 3) {
                return null;
            }
            return IMPRINT;
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.bc
        public String b() {
            return this.f;
        }

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                d.put(eVar.b(), eVar);
            }
        }

        public static e b(int i) {
            e eVarA = a(i);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return d.get(str);
        }

        e(short s, String str) {
            this.e = s;
            this.f = str;
        }
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
    }

    public Response(int i) {
        this();
        this.resp_code = i;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new com.umeng.commonsdk.statistics.proto.d(response.imprint);
        }
    }

    @Override // com.umeng.analytics.pro.av
    public Response deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    public Response setResp_code(int i) {
        this.resp_code = i;
        setResp_codeIsSet(true);
        return this;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = as.b(this.__isset_bitfield, 0);
    }

    public boolean isSetResp_code() {
        return as.a(this.__isset_bitfield, 0);
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = as.a(this.__isset_bitfield, 0, z);
    }

    @Override // com.umeng.analytics.pro.av
    public e fieldForId(int i) {
        return e.a(i);
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        schemes.get(buVar.D()).b().b(buVar, this);
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        schemes.get(buVar.D()).b().a(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
            if (dVar == null) {
                sb.append("null");
            } else {
                sb.append(dVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws bb {
        com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
        if (dVar != null) {
            dVar.l();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private static class b implements cd {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a(null);
        }
    }

    private static class a extends ce<Response> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, Response response) throws bb {
            buVar.j();
            while (true) {
                bp bpVarL = buVar.l();
                if (bpVarL.b == 0) {
                    break;
                }
                short s = bpVarL.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s == 3) {
                            if (bpVarL.b == 12) {
                                response.imprint = new com.umeng.commonsdk.statistics.proto.d();
                                response.imprint.read(buVar);
                                response.setImprintIsSet(true);
                            } else {
                                bx.a(buVar, bpVarL.b);
                            }
                        } else {
                            bx.a(buVar, bpVarL.b);
                        }
                    } else if (bpVarL.b == 11) {
                        response.msg = buVar.z();
                        response.setMsgIsSet(true);
                    } else {
                        bx.a(buVar, bpVarL.b);
                    }
                } else if (bpVarL.b == 8) {
                    response.resp_code = buVar.w();
                    response.setResp_codeIsSet(true);
                } else {
                    bx.a(buVar, bpVarL.b);
                }
                buVar.m();
            }
            buVar.k();
            if (!response.isSetResp_code()) {
                throw new bv("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
            }
            response.validate();
        }

        @Override // com.umeng.analytics.pro.cc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, Response response) throws bb {
            response.validate();
            buVar.a(Response.STRUCT_DESC);
            buVar.a(Response.RESP_CODE_FIELD_DESC);
            buVar.a(response.resp_code);
            buVar.c();
            if (response.msg != null && response.isSetMsg()) {
                buVar.a(Response.MSG_FIELD_DESC);
                buVar.a(response.msg);
                buVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                buVar.a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(buVar);
                buVar.c();
            }
            buVar.d();
            buVar.b();
        }
    }

    private static class d implements cd {
        private d() {
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c(null);
        }
    }

    private static class c extends cf<Response> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, Response response) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            caVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                caVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(caVar);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, Response response) throws bb {
            ca caVar = (ca) buVar;
            response.resp_code = caVar.w();
            response.setResp_codeIsSet(true);
            BitSet bitSetB = caVar.b(2);
            if (bitSetB.get(0)) {
                response.msg = caVar.z();
                response.setMsgIsSet(true);
            }
            if (bitSetB.get(1)) {
                response.imprint = new com.umeng.commonsdk.statistics.proto.d();
                response.imprint.read(caVar);
                response.setImprintIsSet(true);
            }
        }
    }
}
