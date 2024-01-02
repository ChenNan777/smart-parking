package com.ruoyi.parking.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.parking.mapper.PmsRecordMapper;
import com.ruoyi.parking.domain.PmsRecord;
import com.ruoyi.parking.service.IPmsRecordService;

/**
 * 出入库记录Service业务层处理
 * 
 * @author chennan
 * @date 2023-11-26
 */
@Service
public class PmsRecordServiceImpl implements IPmsRecordService 
{
    @Autowired
    private PmsRecordMapper pmsRecordMapper;

    /**
     * 查询出入库记录
     * 
     * @param recordId 出入库记录主键
     * @return 出入库记录
     */
    @Override
    public PmsRecord selectPmsRecordByRecordId(Long recordId)
    {
        return pmsRecordMapper.selectPmsRecordByRecordId(recordId);
    }

    /**
     * 查询出入库记录列表
     * 
     * @param pmsRecord 出入库记录
     * @return 出入库记录
     */
    @Override
    public List<PmsRecord> selectPmsRecordList(PmsRecord pmsRecord)
    {
        return pmsRecordMapper.selectPmsRecordList(pmsRecord);
    }

    /**
     * 新增出入库记录
     * 
     * @param pmsRecord 出入库记录
     * @return 结果
     */
    @Override
    public int insertPmsRecord(PmsRecord pmsRecord)
    {
        return pmsRecordMapper.insertPmsRecord(pmsRecord);
    }

    /**
     * 修改出入库记录
     * 
     * @param pmsRecord 出入库记录
     * @return 结果
     */
    @Override
    public int updatePmsRecord(PmsRecord pmsRecord)
    {
        return pmsRecordMapper.updatePmsRecord(pmsRecord);
    }

    /**
     * 批量删除出入库记录
     * 
     * @param recordIds 需要删除的出入库记录主键
     * @return 结果
     */
    @Override
    public int deletePmsRecordByRecordIds(Long[] recordIds)
    {
        return pmsRecordMapper.deletePmsRecordByRecordIds(recordIds);
    }

    /**
     * 删除出入库记录信息
     * 
     * @param recordId 出入库记录主键
     * @return 结果
     */
    @Override
    public int deletePmsRecordByRecordId(Long recordId)
    {
        return pmsRecordMapper.deletePmsRecordByRecordId(recordId);
    }
}
