package com.vortex.Service;


import com.vortex.Entity.GodDo;

import java.util.List;

public interface GodService {

    //查询所有神仙
    List<GodDo> listGods();

    //分页查询所有神仙
    List<GodDo> limitGods(int offset, int pageSize);

    //根据神仙ID获取神仙
    GodDo getGodById(int godId);

    //根据神仙姓名获取神仙
    List<GodDo> listGodByName(String godName);

    //根据神仙姓名获取神仙
    List<GodDo> limitGodByName(String godName, int offset, int pageSize);

    //根据神仙性别获取神仙
    List<GodDo> listGodsBySex(char godSex);

    //分页根据神仙性别获取神仙
    List<GodDo> limitGodsBySex(char godSex, int offset, int pageSize);

    //根据神仙类型获取神仙
    List<GodDo> listGodsByType(String godType);

    //根据神仙类型获取神仙
    List<GodDo> limitGodsByType(String godType, int offset, int pageSize);

    //根据部门获取神仙
    List<GodDo> listGodsByDepartment(String godDepartment);

    //根据部门获取神仙
    List<GodDo> limitGodsByDepartment(String godDepartment, int offset, int pageSize);

    //根据神职获取神仙
    List<GodDo> listGodsByJob(String godJob);

    //根据神职获取神仙
    List<GodDo> limitGodsByJob(String godJob, int offset, int pageSize);

    //根据神仙ID删除神仙
    boolean deleteGodById(int godId);

    //添加神仙
    boolean saveGod(GodDo godDo);

    //根据神仙ID更新神仙
    boolean updateGod(GodDo godDo);

    //获取神仙总数
    int countGod();


}
