package com.vortex.Controller;

import com.vortex.Entity.Notice;
import com.vortex.Service.NoticeService;
import com.vortex.Util.Code;
import com.vortex.Util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NoticeController {

    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @RequestMapping("/getNotices")
    @ResponseBody
    public Result getNotices() {
        List<Notice> notices = noticeService.getNotices();
        return new Result(Code.NOTICE_GET_OK, "公告获取成功", notices);
    }
}
