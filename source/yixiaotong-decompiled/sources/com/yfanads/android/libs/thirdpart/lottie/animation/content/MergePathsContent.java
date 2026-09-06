package com.yfanads.android.libs.thirdpart.lottie.animation.content;

import android.graphics.Path;
import com.yfanads.android.libs.thirdpart.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class MergePathsContent implements PathContent, GreedyContent {
    private final MergePaths mergePaths;
    private final String name;
    private final Path firstPath = new Path();
    private final Path remainderPath = new Path();
    private final Path path = new Path();
    private final List<PathContent> pathContents = new ArrayList();

    /* JADX INFO: renamed from: com.yfanads.android.libs.thirdpart.lottie.animation.content.MergePathsContent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$MergePaths$MergePathsMode;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$MergePaths$MergePathsMode = iArr;
            try {
                iArr[MergePaths.MergePathsMode.Merge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.Add.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.Subtract.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.Intersect.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.ExcludeIntersections.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public MergePathsContent(MergePaths mergePaths) {
        this.name = mergePaths.getName();
        this.mergePaths = mergePaths;
    }

    private void addPaths() {
        for (int i = 0; i < this.pathContents.size(); i++) {
            this.path.addPath(this.pathContents.get(i).getPath());
        }
    }

    private void opFirstPathWithRest(Path.Op op) {
        this.remainderPath.reset();
        this.firstPath.reset();
        for (int size = this.pathContents.size() - 1; size >= 1; size--) {
            PathContent pathContent = this.pathContents.get(size);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) pathContent;
                List<PathContent> pathList = contentGroup.getPathList();
                for (int size2 = pathList.size() - 1; size2 >= 0; size2--) {
                    Path path = pathList.get(size2).getPath();
                    path.transform(contentGroup.getTransformationMatrix());
                    this.remainderPath.addPath(path);
                }
            } else {
                this.remainderPath.addPath(pathContent.getPath());
            }
        }
        PathContent pathContent2 = this.pathContents.get(0);
        if (pathContent2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) pathContent2;
            List<PathContent> pathList2 = contentGroup2.getPathList();
            for (int i = 0; i < pathList2.size(); i++) {
                Path path2 = pathList2.get(i).getPath();
                path2.transform(contentGroup2.getTransformationMatrix());
                this.firstPath.addPath(path2);
            }
        } else {
            this.firstPath.set(pathContent2.getPath());
        }
        this.path.op(this.firstPath, this.remainderPath, op);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.GreedyContent
    public void absorbContent(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content contentPrevious = listIterator.previous();
            if (contentPrevious instanceof PathContent) {
                this.pathContents.add((PathContent) contentPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.PathContent
    public Path getPath() {
        Path.Op op;
        this.path.reset();
        int i = AnonymousClass1.$SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$MergePaths$MergePathsMode[this.mergePaths.getMode().ordinal()];
        if (i != 1) {
            if (i == 2) {
                op = Path.Op.UNION;
            } else if (i == 3) {
                op = Path.Op.REVERSE_DIFFERENCE;
            } else if (i == 4) {
                op = Path.Op.INTERSECT;
            } else if (i == 5) {
                op = Path.Op.XOR;
            }
            opFirstPathWithRest(op);
        } else {
            addPaths();
        }
        return this.path;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < this.pathContents.size(); i++) {
            this.pathContents.get(i).setContents(list, list2);
        }
    }
}
