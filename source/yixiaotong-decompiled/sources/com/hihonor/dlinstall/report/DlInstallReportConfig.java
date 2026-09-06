package com.hihonor.dlinstall.report;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class DlInstallReportConfig {
    private final List<String> clickReportUrlList;
    private final List<String> commonsReportUrlList;
    private final List<String> downloadFailReportUrlList;
    private final List<String> downloadStartReportUrlList;
    private final List<String> downloadSuccessReportUrlList;
    private final List<String> installFailReportUrlList;
    private final List<String> installStartReportUrlList;
    private final List<String> installSuccessReportUrlList;

    public static class Builder {
        private final List<String> downloadStartReportUrlList = new ArrayList();
        private final List<String> downloadSuccessReportUrlList = new ArrayList();
        private final List<String> downloadFailReportUrlList = new ArrayList();
        private final List<String> installStartReportUrlList = new ArrayList();
        private final List<String> installSuccessReportUrlList = new ArrayList();
        private final List<String> installFailReportUrlList = new ArrayList();
        private final List<String> commonsReportUrlList = new ArrayList();
        private final List<String> clickReportUrlList = new ArrayList();

        private void addReportUrl(List<String> list, String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            list.add(str);
        }

        private void addReportUrl(List<String> list, List<String> list2) {
            if (list2 == null || list2.size() == 0) {
                return;
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                addReportUrl(list, it.next());
            }
        }

        public Builder addClickReportUrl(String str) {
            addReportUrl(this.clickReportUrlList, str);
            return this;
        }

        public Builder addClickReportUrl(List<String> list) {
            addReportUrl(this.clickReportUrlList, list);
            return this;
        }

        public Builder addCommonsReportUrl(String str) {
            addReportUrl(this.commonsReportUrlList, str);
            return this;
        }

        public Builder addCommonsReportUrl(List<String> list) {
            addReportUrl(this.commonsReportUrlList, list);
            return this;
        }

        public Builder addDownloadFailReportUrl(String str) {
            addReportUrl(this.downloadFailReportUrlList, str);
            return this;
        }

        public Builder addDownloadFailReportUrl(List<String> list) {
            addReportUrl(this.downloadFailReportUrlList, list);
            return this;
        }

        public Builder addDownloadStartReportUrl(String str) {
            addReportUrl(this.downloadStartReportUrlList, str);
            return this;
        }

        public Builder addDownloadStartReportUrl(List<String> list) {
            addReportUrl(this.downloadStartReportUrlList, list);
            return this;
        }

        public Builder addDownloadSuccessReportUrl(String str) {
            addReportUrl(this.downloadSuccessReportUrlList, str);
            return this;
        }

        public Builder addDownloadSuccessReportUrl(List<String> list) {
            addReportUrl(this.downloadSuccessReportUrlList, list);
            return this;
        }

        public Builder addInstallFailReportUrl(String str) {
            addReportUrl(this.installFailReportUrlList, str);
            return this;
        }

        public Builder addInstallFailReportUrl(List<String> list) {
            addReportUrl(this.installFailReportUrlList, list);
            return this;
        }

        public Builder addInstallStartReportUrl(String str) {
            addReportUrl(this.installStartReportUrlList, str);
            return this;
        }

        public Builder addInstallStartReportUrl(List<String> list) {
            addReportUrl(this.installStartReportUrlList, list);
            return this;
        }

        public Builder addInstallSuccessReportUrl(String str) {
            addReportUrl(this.installSuccessReportUrlList, str);
            return this;
        }

        public Builder addInstallSuccessReportUrl(List<String> list) {
            addReportUrl(this.installSuccessReportUrlList, list);
            return this;
        }

        public DlInstallReportConfig build() {
            return new DlInstallReportConfig(this.downloadStartReportUrlList, this.downloadSuccessReportUrlList, this.downloadFailReportUrlList, this.installStartReportUrlList, this.installSuccessReportUrlList, this.installFailReportUrlList, this.commonsReportUrlList, this.clickReportUrlList);
        }
    }

    public DlInstallReportConfig(List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, List<String> list7, List<String> list8) {
        this.downloadStartReportUrlList = list;
        this.downloadSuccessReportUrlList = list2;
        this.downloadFailReportUrlList = list3;
        this.installStartReportUrlList = list4;
        this.installSuccessReportUrlList = list5;
        this.installFailReportUrlList = list6;
        this.commonsReportUrlList = list7;
        this.clickReportUrlList = list8;
    }

    public List<String> getClickReportUrlList() {
        return this.clickReportUrlList;
    }

    public List<String> getCommonsReportUrlList() {
        return this.commonsReportUrlList;
    }

    public List<String> getDownloadFailReportUrlList() {
        return this.downloadFailReportUrlList;
    }

    public List<String> getDownloadStartReportUrlList() {
        return this.downloadStartReportUrlList;
    }

    public List<String> getDownloadSuccessReportUrlList() {
        return this.downloadSuccessReportUrlList;
    }

    public List<String> getInstallFailReportUrlList() {
        return this.installFailReportUrlList;
    }

    public List<String> getInstallStartReportUrlList() {
        return this.installStartReportUrlList;
    }

    public List<String> getInstallSuccessReportUrlList() {
        return this.installSuccessReportUrlList;
    }
}
