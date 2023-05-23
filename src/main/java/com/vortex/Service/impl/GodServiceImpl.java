package com.vortex.Service.impl;

import com.vortex.Entity.God;
import com.vortex.Mapper.GodMapper;
import com.vortex.Service.GodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GodServiceImpl implements GodService {

    @Autowired
    private GodMapper godMapper;

    @Override
    public List<God> getGods(int offset, int pagesize) {
        List<God> gods = godMapper.getGods(offset, pagesize);
        return gods;
    }

    @Override
    public God getGodForId(int godId) {
        God god = godMapper.getGodForId(godId);
        return god;
    }

    @Override
    public boolean addGod(God god) {
        int x = godMapper.addGod(god);
        return x > 0;
    }

    @Override
    public boolean deleteGod(int godId) {
        int x = godMapper.deleteGod(godId);
        return x > 0;
    }

    @Override
    public boolean updateGod(God god) {
        int x = godMapper.updateGod(god);
        return x > 0;
    }

    @Override
    public int getGodCount() {
        int godCount = godMapper.getGodCount();
        return godCount;
    }

    @Override
    public List<God> getGodForType(String type, String value, int searchOffset, int searchPageSize) {
        List<God> godsForType = godMapper.getGodForType(type, value, searchOffset, searchPageSize);
        return godsForType;
    }
}
