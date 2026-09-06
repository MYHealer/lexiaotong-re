package com.hihonor.adsdk.base.net;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class l implements ParameterizedType {
    private final Type[] hnadsd;
    private final Type hnadse;
    private final Type hnadsf;

    public l(Type[] typeArr, Type type, Type type2) {
        this.hnadsd = typeArr;
        this.hnadse = type;
        this.hnadsf = type2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (!Arrays.equals(this.hnadsd, lVar.hnadsd)) {
            return false;
        }
        Type type = this.hnadse;
        if (type == null) {
            return lVar.hnadse == null;
        }
        if (!type.equals(lVar.hnadse)) {
            return false;
        }
        Type type2 = this.hnadsf;
        if (type2 == null) {
            return lVar.hnadsf == null;
        }
        return type2.equals(lVar.hnadsf);
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.hnadsd;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.hnadse;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.hnadsf;
    }

    public int hashCode() {
        Type[] typeArr = this.hnadsd;
        int iHashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
        Type type = this.hnadse;
        int iHashCode2 = (iHashCode + (type != null ? type.hashCode() : 0)) * 31;
        Type type2 = this.hnadsf;
        return iHashCode2 + (type2 != null ? type2.hashCode() : 0);
    }
}
