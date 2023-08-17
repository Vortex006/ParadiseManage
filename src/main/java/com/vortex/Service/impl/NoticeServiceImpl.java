package com.vortex.Service.impl;

import com.vortex.Entity.NoticeDo;
import com.vortex.Mapper.NoticeMapper;
import com.vortex.Service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<NoticeDo> listNotices() {
        List<NoticeDo> noticeDoList = noticeMapper.listNotices();
        return noticeDoList;
    }
}
