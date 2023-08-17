package com.vortex.Service.impl;

import com.vortex.Entity.GodDo;
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
    public List<GodDo> listGods() {
        List<GodDo> godList = godMapper.listGods();
        return godList;
    }

    @Override
    public List<GodDo> limitGods(int offset, int pageSize) {
        List<GodDo> godLimitList = godMapper.limitGods(offset, pageSize);
        return godLimitList;
    }

    @Override
    public GodDo getGodById(int godId) {
        GodDo god = godMapper.getGodById(godId);
        return god;
    }

    @Override
    public List<GodDo> listGodByName(String godName) {
        List<GodDo> godList = godMapper.listGodByName(godName);
        return godList;
    }

    @Override
    public List<GodDo> limitGodByName(String godName, int offset, int pageSize) {
        List<GodDo> godLimitList = godMapper.limitGodByName(godName, offset, pageSize);
        return godLimitList;
    }

    @Override
    public List<GodDo> listGodsBySex(char godSex) {
        List<GodDo> godList = godMapper.listGodsBySex(godSex);
        return godList;
    }

    @Override
    public List<GodDo> limitGodsBySex(char godSex, int offset, int pageSize) {
        List<GodDo> godLimitList = godMapper.limitGodsBySex(godSex, offset, pageSize);
        return godLimitList;
    }

    @Override
    public List<GodDo> listGodsByType(String godType) {
        List<GodDo> godList = godMapper.listGodsByType(godType);
        return godList;
    }

    @Override
    public List<GodDo> limitGodsByType(String godType, int offset, int pageSize) {
        List<GodDo> godLimitList = godMapper.limitGodsByType(godType, offset, pageSize);
        return godLimitList;
    }

    @Override
    public List<GodDo> listGodsByDepartment(String godDepartment) {
        List<GodDo> godList = godMapper.listGodsByDepartment(godDepartment);
        return godList;
    }

    @Override
    public List<GodDo> limitGodsByDepartment(String godDepartment, int offset, int pageSize) {
        List<GodDo> godLimitList = godMapper.limitGodsByDepartment(godDepartment, offset, pageSize);
        return godLimitList;
    }

    @Override
    public List<GodDo> listGodsByJob(String godJob) {
        List<GodDo> godList = godMapper.listGodsByJob(godJob);
        return godList;
    }

    @Override
    public List<GodDo> limitGodsByJob(String godJob, int offset, int pageSize) {
        List<GodDo> godLimitList = godMapper.limitGodsByJob(godJob, offset, pageSize);
        return godLimitList;
    }

    @Override
    public boolean deleteGodById(int godId) {
        int i = godMapper.deleteGodById(godId);
        return i > 0;
    }

    @Override
    public boolean saveGod(GodDo godDo) {
        int i = godMapper.saveGod(godDo);
        return i > 0;
    }

    @Override
    public boolean updateGod(GodDo godDo) {
        int i = godMapper.updateGod(godDo);
        return i > 0;
    }

    @Override
    public int countGod() {
        int godCount = godMapper.countGod();
        return godCount;
    }
}
