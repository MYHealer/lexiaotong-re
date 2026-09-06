package com.fancy;

import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _b implements _oq {
    public static final _b _a = new _b();

    @Override // com.fancy._oq
    public final void _a(_os _osVar) {
        Logger.i(_ie._a("Frequency mp bidWin ( ").append(_osVar._a).append("|").append(_osVar._r).append(" ) => ").append(0).toString());
    }

    @Override // com.fancy._oq
    public final void _b(_os _osVar) {
        Logger.i(_ie._a("Frequency mp vp ( ").append(_osVar._a).append("|").append(_osVar._r).append(" ) => ").append(0).toString());
    }

    @Override // com.fancy._oq
    public final void _c(_os _osVar) {
        String strValueOf;
        int i;
        StringBuilder sbAppend = _ie._a("Frequency mp bidSuc ( ").append(_osVar._a).append("|").append(_osVar._r).append("|").append(_osVar._b).append("|");
        _or _orVar = _osVar._t;
        if (_orVar != null) {
            try {
                i = Integer.parseInt(_orVar._a("consumerPrice"));
            } catch (Exception unused) {
                i = 0;
            }
            strValueOf = String.valueOf(i);
        } else {
            strValueOf = "0";
        }
        Logger.i(sbAppend.append(strValueOf).append(" ) => ").append(0).toString());
    }

    @Override // com.fancy._oq
    public final void _d(_os _osVar) {
        Logger.i(_ie._a("Frequency mp err ( ").append(_osVar._a).append("|").append(_osVar._r).append("|").append(_osVar._b).append(" ) => ").append(0).toString());
    }

    @Override // com.fancy._oq
    public final void _e(_os _osVar) {
        String strValueOf;
        int i;
        StringBuilder sbAppend = _ie._a("Frequency mp imp ( ").append(_osVar._a).append("|").append(_osVar._r).append("|").append(_osVar._b).append("|");
        _or _orVar = _osVar._t;
        if (_orVar != null) {
            try {
                i = Integer.parseInt(_orVar._a("consumerPrice"));
            } catch (Exception unused) {
                i = 0;
            }
            strValueOf = String.valueOf(i);
        } else {
            strValueOf = "0";
        }
        Logger.i(sbAppend.append(strValueOf).append(" ) => ").append(0).toString());
    }

    @Override // com.fancy._oq
    public final void _f(_os _osVar) {
        String strValueOf;
        int i;
        StringBuilder sbAppend = _ie._a("Frequency mp bidSel ( ").append(_osVar._a).append("|").append(_osVar._r).append("|").append(_osVar._b).append("|");
        _or _orVar = _osVar._t;
        if (_orVar != null) {
            try {
                i = Integer.parseInt(_orVar._a("consumerPrice"));
            } catch (Exception unused) {
                i = 0;
            }
            strValueOf = String.valueOf(i);
        } else {
            strValueOf = "0";
        }
        Logger.i(sbAppend.append(strValueOf).append(" ) => ").append(0).toString());
    }

    @Override // com.fancy._oq
    public final void _g(_os _osVar) {
        String strValueOf;
        int i;
        StringBuilder sbAppend = _ie._a("Frequency mp clk ( ").append(_osVar._a).append("|").append(_osVar._r).append("|").append(_osVar._b).append("|");
        _or _orVar = _osVar._t;
        if (_orVar != null) {
            try {
                i = Integer.parseInt(_orVar._a("consumerPrice"));
            } catch (Exception unused) {
                i = 0;
            }
            strValueOf = String.valueOf(i);
        } else {
            strValueOf = "0";
        }
        Logger.i(sbAppend.append(strValueOf).append(" ) => ").append(0).toString());
    }

    @Override // com.fancy._oq
    public final void _h(_os _osVar) {
        Logger.i(_ie._a("Frequency mp bid ( ").append(_osVar._a).append("|").append(_osVar._r).append("|").append(_osVar._b).append(" ) => ").append(0).toString());
    }

    @Override // com.fancy._oq
    public final void _i(_os _osVar) {
        Logger.i(_ie._a("Frequency mp bidLoss ( ").append(_osVar._a).append("|").append(_osVar._r).append(" ) => ").append(0).toString());
    }
}
