package com.vortex.Service;

import com.vortex.Entity.God;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface GodService {
    //查询所有神仙
    List<God> getGods(@Param("offset") int offset, @Param("pagesize") int pagesize);

    //根据神仙ID查询神仙
    God getGodForId(int godId);

    //添加神仙
    boolean addGod(God god);

    //根据神仙ID删除神仙
    boolean deleteGod(int godId);

    //根据神仙ID更新神仙
    boolean updateGod(God god);

    //获取god总数
    int getGodCount();

    //根据指定类型查找神仙
    List<God> getGodForType(@Param("type") String type, @Param("value") String value,
                            @Param("searchOffset") int searchOffset, @Param("searchPageSize") int searchPageSize);
}
