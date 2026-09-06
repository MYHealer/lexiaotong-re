package com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface PbSCFeedPush {
    List<PbCommentFeed> getCommentFeeds();

    String getDisplayLikeCount();

    String getDisplayWatchingCount();

    List<PbSystemNoticeFeed> getSystemNoticeFeeds();
}
