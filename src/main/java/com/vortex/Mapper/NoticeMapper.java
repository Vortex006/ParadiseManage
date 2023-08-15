package com.vortex.Mapper;

import com.vortex.Entity.Notice;

import java.util.List;

public interface NoticeMapper {
    //获取所有公告
    List<Notice> getNotices();
}
