package com.ruoyi.parking.service;

import java.util.List;
import com.ruoyi.parking.domain.PmsDenied;

/**
 * 黑名单管理Service接口
 * 
 * @author chennan
 * @date 2023-11-15
 */
public interface IPmsDeniedService 
{
    /**
     * 查询黑名单管理
     * 
     * @param deniedId 黑名单管理主键
     * @return 黑名单管理
     */
    public PmsDenied selectPmsDeniedByDeniedId(Long deniedId);

    /**
     * 查询黑名单管理列表
     * 
     * @param pmsDenied 黑名单管理
     * @return 黑名单管理集合
     */
    public List<PmsDenied> selectPmsDeniedList(PmsDenied pmsDenied);

    /**
     * 新增黑名单管理
     * 
     * @param pmsDenied 黑名单管理
     * @return 结果
     */
    public int insertPmsDenied(PmsDenied pmsDenied);

    /**
     * 修改黑名单管理
     * 
     * @param pmsDenied 黑名单管理
     * @return 结果
     */
    public int updatePmsDenied(PmsDenied pmsDenied);

    /**
     * 批量删除黑名单管理
     * 
     * @param deniedIds 需要删除的黑名单管理主键集合
     * @return 结果
     */
    public int deletePmsDeniedByDeniedIds(Long[] deniedIds);

    /**
     * 删除黑名单管理信息
     * 
     * @param deniedId 黑名单管理主键
     * @return 结果
     */
    public int deletePmsDeniedByDeniedId(Long deniedId);
}
