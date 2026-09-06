package com.hp.hpl.sparta.xpath;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AttrGreaterExpr extends AttrRelationalExpr {
    public AttrGreaterExpr(String str, int i) {
        super(str, i);
    }

    @Override // com.hp.hpl.sparta.xpath.BooleanExpr
    public void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.visit(this);
    }

    @Override // com.hp.hpl.sparta.xpath.AttrExpr
    public String toString() {
        return toString(SimpleComparison.GREATER_THAN_OPERATION);
    }
}
