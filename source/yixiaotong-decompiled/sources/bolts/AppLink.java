package bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class AppLink {
    private Uri sourceUrl;
    private List<Target> targets;
    private Uri webUrl;

    public Uri getSourceUrl() {
        return this.sourceUrl;
    }

    public Uri getWebUrl() {
        return this.webUrl;
    }

    public static class Target {
        private final String appName;
        private final String className;
        private final String packageName;
        private final Uri url;

        public String getAppName() {
            return this.appName;
        }

        public String getClassName() {
            return this.className;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public Uri getUrl() {
            return this.url;
        }

        public Target(String str, String str2, Uri uri, String str3) {
            this.packageName = str;
            this.className = str2;
            this.url = uri;
            this.appName = str3;
        }
    }

    public AppLink(Uri uri, List<Target> list, Uri uri2) {
        this.sourceUrl = uri;
        this.targets = list == null ? Collections.emptyList() : list;
        this.webUrl = uri2;
    }

    public List<Target> getTargets() {
        return Collections.unmodifiableList(this.targets);
    }
}
