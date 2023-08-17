package com.vortex.Controller;

import com.vortex.Entity.GodDo;
import com.vortex.Service.GodService;
import com.vortex.Util.Code;
import com.vortex.Util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GodController {

    private final GodService godService;

    @Autowired
    public GodController(GodService godService) {
        this.godService = godService;
    }

    @RequestMapping("/listGods")
    @ResponseBody
    public Result listGods() {
        List<GodDo> godList = godService.listGods();
        return new Result(Code.OK, "", godList);
    }

    @RequestMapping("/limitGods")
    @ResponseBody
    public Result limitGods(int pageSize, int currentPage) {
        int offset = (currentPage - 1) * pageSize;//索引
        List<GodDo> godLimitList = godService.limitGods(offset, pageSize);
        if (godLimitList == null) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "", godLimitList);
    }

    @RequestMapping("/getGodById")
    @ResponseBody
    public Result getGodById(int godId) {
        GodDo god = godService.getGodById(godId);
        if (god == null) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "", god);
    }

    @RequestMapping("/listGodByName")
    @ResponseBody
    public Result listGodByName(String godName) {
        List<GodDo> godList = godService.listGodByName(godName);
        if (godList == null) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "", godList);
    }

    @RequestMapping("/limitGodByName")
    @ResponseBody
    public Result limitGodByName(String godName, int pageSize, int currentPage) {
        int offset = (currentPage - 1) * pageSize;//索引
        List<GodDo> godLimitList = godService.limitGodByName(godName, offset, pageSize);
        if (godLimitList == null) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "", godLimitList);
    }

    @RequestMapping("/listGodsBySex")
    @ResponseBody
    public Result listGodsBySex(char godSex) {
        List<GodDo> godList = godService.listGodsBySex(godSex);
        if (godList == null) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "", godList);
    }

    @RequestMapping("/limitGodsBySex")
    @ResponseBody
    public Result limitGodsBySex(char godSex, int pageSize, int currentPage) {
        int offset = (currentPage - 1) * pageSize;//索引
        List<GodDo> godLimitList = godService.limitGodsBySex(godSex, offset, pageSize);
        if (godLimitList == null) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "", godLimitList);
    }

    @RequestMapping("/listGodsByType")
    @ResponseBody
    public Result listGodsByType(String godType) {
        List<GodDo> godList = godService.listGodsByType(godType);
        if (godList == null) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "", godList);
    }

    @RequestMapping("/limitGodsByType")
    @ResponseBody
    public Result limitGodsByType(String godType, int pageSize, int currentPage) {
        int offset = (currentPage - 1) * pageSize;//索引
        List<GodDo> godLimitList = godService.limitGodsByType(godType, offset, pageSize);
        if (godLimitList == null) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "", godLimitList);
    }

    @RequestMapping("/listGodsByDepartment")
    @ResponseBody
    public Result listGodsByDepartment(String godDepartment) {
        List<GodDo> godList = godService.listGodsByDepartment(godDepartment);
        if (godList == null) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "", godList);
    }

    @RequestMapping("/limitGodsByDepartment")
    @ResponseBody
    public Result limitGodsByDepartment(String godDepartment, int pageSize, int currentPage) {
        int offset = (currentPage - 1) * pageSize;//索引
        List<GodDo> godLimitList = godService.limitGodsByDepartment(godDepartment, offset, pageSize);
        if (godLimitList == null) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "", godLimitList);
    }

    @RequestMapping("/listGodsByJob")
    @ResponseBody
    public Result listGodsByJob(String godJob) {
        List<GodDo> godList = godService.listGodsByJob(godJob);
        if (godList == null) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "", godList);
    }

    @RequestMapping("/limitGodsByJob")
    @ResponseBody
    public Result limitGodsByJob(String godJob, int pageSize, int currentPage) {
        int offset = (currentPage - 1) * pageSize;//索引
        List<GodDo> godLimitList = godService.limitGodsByJob(godJob, offset, pageSize);
        if (godLimitList == null) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "", godLimitList);
    }

    @RequestMapping("/saveGod")
    @ResponseBody
    public Result saveGod(@RequestBody GodDo godDo) {
        boolean isSave = godService.saveGod(godDo);
        if (!isSave) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "");
    }

    @RequestMapping("/deleteGodById")
    @ResponseBody
    public Result deleteGodById(int godId) {
        boolean isDelete = godService.deleteGodById(godId);
        if (!isDelete) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "");
    }

    @RequestMapping("/updateGod")
    @ResponseBody
    public Result updateGod(@RequestBody GodDo godDo) {
        boolean isUpdate = godService.updateGod(godDo);
        if (!isUpdate) {
            return new Result(Code.ERROR, "");
        }
        return new Result(Code.OK, "");
    }


    @RequestMapping("/countGod")
    @ResponseBody
    public Result countGod() {
        int godCount = godService.countGod();
        return new Result(Code.OK, "获取成功", godCount);
    }

}
