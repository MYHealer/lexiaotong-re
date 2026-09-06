package com.kwad.components.ad.reward.l;

import com.kwad.sdk.utils.ac;
import java.util.Observable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class b extends Observable implements c, com.kwad.sdk.core.b {
    private boolean Ct = false;
    protected String Cu;
    protected String Cv;

    private boolean lc() {
        return this.Ct;
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String la() {
        return this.Cu;
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String lb() {
        return this.Cv;
    }

    public final void kY() {
        if (this.Ct) {
            return;
        }
        this.Ct = true;
        ld();
    }

    public final void kZ() {
        if (this.Ct) {
            this.Ct = false;
            ld();
        }
    }

    public boolean isCompleted() {
        return lc();
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "selfCompleted", this.Ct);
        return jSONObject;
    }

    public void parseJson(JSONObject jSONObject) {
        try {
            this.Ct = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }

    private void ld() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.Ct));
    }
}
