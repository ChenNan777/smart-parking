package com.ruoyi.parking.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.parking.mapper.PmsGateMapper;
import com.ruoyi.parking.domain.PmsGate;
import com.ruoyi.parking.service.IPmsGateService;

/**
 * 出入口管理Service业务层处理
 * 
 * @author chennan
 * @date 2023-11-15
 */
@Service
public class PmsGateServiceImpl implements IPmsGateService 
{
    @Autowired
    private PmsGateMapper pmsGateMapper;

    /**
     * 查询出入口管理
     * 
     * @param gateId 出入口管理主键
     * @return 出入口管理
     */
    @Override
    public PmsGate selectPmsGateByGateId(Long gateId)
    {
        return pmsGateMapper.selectPmsGateByGateId(gateId);
    }

    /**
     * 查询出入口管理列表
     * 
     * @param pmsGate 出入口管理
     * @return 出入口管理
     */
    @Override
    public List<PmsGate> selectPmsGateList(PmsGate pmsGate)
    {
        return pmsGateMapper.selectPmsGateList(pmsGate);
    }

    /**
     * 新增出入口管理
     * 
     * @param pmsGate 出入口管理
     * @return 结果
     */
    @Override
    public int insertPmsGate(PmsGate pmsGate)
    {
        return pmsGateMapper.insertPmsGate(pmsGate);
    }

    /**
     * 修改出入口管理
     * 
     * @param pmsGate 出入口管理
     * @return 结果
     */
    @Override
    public int updatePmsGate(PmsGate pmsGate)
    {
        return pmsGateMapper.updatePmsGate(pmsGate);
    }

    /**
     * 批量删除出入口管理
     * 
     * @param gateIds 需要删除的出入口管理主键
     * @return 结果
     */
    @Override
    public int deletePmsGateByGateIds(Long[] gateIds)
    {
        return pmsGateMapper.deletePmsGateByGateIds(gateIds);
    }

    /**
     * 删除出入口管理信息
     * 
     * @param gateId 出入口管理主键
     * @return 结果
     */
    @Override
    public int deletePmsGateByGateId(Long gateId)
    {
        return pmsGateMapper.deletePmsGateByGateId(gateId);
    }
}
