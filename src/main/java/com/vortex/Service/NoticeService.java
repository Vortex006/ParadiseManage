package com.vortex.Service;

import com.vortex.Entity.Notice;

import java.util.List;

public interface NoticeService {
    //获取所有公告
    List<Notice> getNotices();
}
