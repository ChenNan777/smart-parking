package com.ruoyi.parking.mapper;

import java.util.List;
import com.ruoyi.parking.domain.PmsRecord;

/**
 * 出入库记录Mapper接口
 * 
 * @author chennan
 * @date 2023-11-26
 */
public interface PmsRecordMapper 
{
    /**
     * 查询出入库记录
     * 
     * @param recordId 出入库记录主键
     * @return 出入库记录
     */
    public PmsRecord selectPmsRecordByRecordId(Long recordId);

    /**
     * 查询出入库记录列表
     * 
     * @param pmsRecord 出入库记录
     * @return 出入库记录集合
     */
    public List<PmsRecord> selectPmsRecordList(PmsRecord pmsRecord);

    /**
     * 新增出入库记录
     * 
     * @param pmsRecord 出入库记录
     * @return 结果
     */
    public int insertPmsRecord(PmsRecord pmsRecord);

    /**
     * 修改出入库记录
     * 
     * @param pmsRecord 出入库记录
     * @return 结果
     */
    public int updatePmsRecord(PmsRecord pmsRecord);

    /**
     * 删除出入库记录
     * 
     * @param recordId 出入库记录主键
     * @return 结果
     */
    public int deletePmsRecordByRecordId(Long recordId);

    /**
     * 批量删除出入库记录
     * 
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsRecordByRecordIds(Long[] recordIds);
}
