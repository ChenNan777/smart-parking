package com.ruoyi.parking.mapper;

import java.util.List;
import com.ruoyi.parking.domain.PmsGate;

/**
 * 出入口管理Mapper接口
 * 
 * @author chennan
 * @date 2023-11-15
 */
public interface PmsGateMapper 
{
    /**
     * 查询出入口管理
     * 
     * @param gateId 出入口管理主键
     * @return 出入口管理
     */
    public PmsGate selectPmsGateByGateId(Long gateId);

    /**
     * 查询出入口管理列表
     * 
     * @param pmsGate 出入口管理
     * @return 出入口管理集合
     */
    public List<PmsGate> selectPmsGateList(PmsGate pmsGate);

    /**
     * 新增出入口管理
     * 
     * @param pmsGate 出入口管理
     * @return 结果
     */
    public int insertPmsGate(PmsGate pmsGate);

    /**
     * 修改出入口管理
     * 
     * @param pmsGate 出入口管理
     * @return 结果
     */
    public int updatePmsGate(PmsGate pmsGate);

    /**
     * 删除出入口管理
     * 
     * @param gateId 出入口管理主键
     * @return 结果
     */
    public int deletePmsGateByGateId(Long gateId);

    /**
     * 批量删除出入口管理
     * 
     * @param gateIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsGateByGateIds(Long[] gateIds);
}
