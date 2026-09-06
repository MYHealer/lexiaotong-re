package com.jd.ad.sdk.jad_mx;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_do implements com.jd.ad.sdk.jad_kv.jad_dq.jad_an<Object> {
    public final /* synthetic */ com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_an;
    public final /* synthetic */ jad_ep jad_bo;

    public jad_do(jad_ep jad_epVar, com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_anVar) {
        this.jad_bo = jad_epVar;
        this.jad_an = jad_anVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
    public void jad_an(Object obj) {
        jad_ep jad_epVar = this.jad_bo;
        com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar = this.jad_an;
        com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar2 = jad_epVar.jad_fs;
        if (jad_anVar2 == null || jad_anVar2 != jad_anVar) {
            return;
        }
        jad_ep jad_epVar2 = this.jad_bo;
        com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_anVar3 = this.jad_an;
        jad_ly jad_lyVar = jad_epVar2.jad_an.jad_pc;
        if (obj != null && jad_lyVar.jad_an(jad_anVar3.jad_cp.jad_dq())) {
            jad_epVar2.jad_er = obj;
            jad_epVar2.jad_bo.jad_bo();
        } else {
            jad_fs.jad_an jad_anVar4 = jad_epVar2.jad_bo;
            com.jd.ad.sdk.jad_ju.jad_hu jad_huVar = jad_anVar3.jad_an;
            com.jd.ad.sdk.jad_kv.jad_dq<Data> jad_dqVar = jad_anVar3.jad_cp;
            jad_anVar4.jad_an(jad_huVar, obj, jad_dqVar, jad_dqVar.jad_dq(), jad_epVar2.jad_jt);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
    public void jad_an(Exception exc) {
        jad_ep jad_epVar = this.jad_bo;
        com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar = this.jad_an;
        com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar2 = jad_epVar.jad_fs;
        if (jad_anVar2 == null || jad_anVar2 != jad_anVar) {
            return;
        }
        jad_ep jad_epVar2 = this.jad_bo;
        com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_anVar3 = this.jad_an;
        jad_fs.jad_an jad_anVar4 = jad_epVar2.jad_bo;
        com.jd.ad.sdk.jad_ju.jad_hu jad_huVar = jad_epVar2.jad_jt;
        com.jd.ad.sdk.jad_kv.jad_dq<Data> jad_dqVar = jad_anVar3.jad_cp;
        jad_anVar4.jad_an(jad_huVar, exc, jad_dqVar, jad_dqVar.jad_dq());
    }
}
