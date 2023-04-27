package com.vortex.Mapper;

import com.vortex.Entity.God;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GodMapper {
    //查询所有神仙
    List<God> SelectGodAll(@Param("offset") int offset, @Param("pagesize") int pagesize);

    //根据神仙ID查询神仙
    God SelectGodForId(int godid);

    //添加神仙
    int AddGod(God god);

    //根据神仙ID删除神仙
    int DeleteGod(int godid);

    //根据神仙ID更新神仙
    int UpdateGod(God god);

    //获取god总数
    int SelectGodCount();

    //根据指定类型查找神仙
    List<God> SelectGodForType(@Param("type") String type, @Param("value") String value,
                               @Param("searchOffset") int searchOffset, @Param("searchPageSize") int searchPageSize);
}
