package com.vortex.Mapper;

import com.vortex.Entity.GodDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GodMapper {

    //查询所有神仙
    List<GodDo> listGods();

    //分页查询所有神仙
    List<GodDo> limitGods(@Param("offset") int offset, @Param("pageSize") int pageSize);

    //根据神仙ID获取神仙
    GodDo getGodById(int godId);

    //根据神仙姓名获取神仙
    List<GodDo> listGodByName(String godName);

    //根据神仙姓名获取神仙
    List<GodDo> limitGodByName(@Param("godName") String godName, @Param("offset") int offset,
                               @Param("pageSize") int pageSize);

    //根据神仙性别获取神仙
    List<GodDo> listGodsBySex(char godSex);

    //分页根据神仙性别获取神仙
    List<GodDo> limitGodsBySex(@Param("godSex") char godSex, @Param("offset") int offset,
                               @Param("pageSize") int pageSize);

    //根据神仙类型获取神仙
    List<GodDo> listGodsByType(String godType);

    //根据神仙类型获取神仙
    List<GodDo> limitGodsByType(@Param("godType") String godType, @Param("offset") int offset,
                                @Param("pageSize") int pageSize);

    //根据部门获取神仙
    List<GodDo> listGodsByDepartment(String godDepartment);

    //根据部门获取神仙
    List<GodDo> limitGodsByDepartment(@Param("godDepartment") String godDepartment, @Param("offset") int offset,
                                      @Param("pageSize") int pageSize);

    //根据神职获取神仙
    List<GodDo> listGodsByJob(String godJob);

    //根据神职获取神仙
    List<GodDo> limitGodsByJob(@Param("godJob") String godJob, @Param("offset") int offset,
                               @Param("pageSize") int pageSize);

    //根据神仙ID删除神仙
    int deleteGodById(int godId);

    //添加神仙
    int saveGod(GodDo godDo);

    //根据神仙ID更新神仙
    int updateGod(GodDo godDo);

    //获取神仙总数
    int countGod();
}
