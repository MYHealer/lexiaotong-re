package com.hihonor.adsdk.base.g.k.b;

import com.hihonor.adsdk.base.dp.entity.AdTrack;
import com.hihonor.adsdk.common.f.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a {
    protected abstract int hnadsa();

    protected List<AdTrack> hnadsa(List<AdTrack> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb(), "filterInvalidTrackList enter.adTrackList size " + f.hnadsb((Collection<?>) list), new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (AdTrack adTrack : list) {
            if (adTrack.getUrlType() != hnadsa()) {
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsb(), (Object) ("filter invalid track.urlType=" + adTrack.getUrlType()));
            } else {
                arrayList.add(adTrack);
            }
        }
        return arrayList;
    }

    protected abstract String hnadsb();

    protected abstract List<AdTrack> hnadsb(List<AdTrack> list);

    public void hnadsc(List<AdTrack> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb(), "onDeleteMaxFail enter ", new Object[0]);
        List<AdTrack> listHnadsa = hnadsa(list);
        if (f.hnadsa((Collection<?>) listHnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb(), "onDeleteMaxFail fail, cause by track list is null.", new Object[0]);
        } else {
            hnadsd(listHnadsa);
        }
    }

    protected abstract void hnadsd(List<AdTrack> list);

    public void hnadse(List<AdTrack> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb(), "report enter. adTrackList size " + f.hnadsb((Collection<?>) list), new Object[0]);
        if (f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb(), "report call adTrackList is null", new Object[0]);
            return;
        }
        List<AdTrack> listHnadsb = hnadsb(hnadsa(list));
        if (f.hnadsa((Collection<?>) listHnadsb)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb(), "report merge adTrackList is null", new Object[0]);
        } else {
            hnadsf(listHnadsb);
        }
    }

    protected void hnadsf(List<AdTrack> list) {
        com.hihonor.adsdk.base.g.k.a.hnadsa().hnadsa(list, false);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb(), "reportInternal enter. adTrackList size " + f.hnadsb((Collection<?>) list), new Object[0]);
    }
}
