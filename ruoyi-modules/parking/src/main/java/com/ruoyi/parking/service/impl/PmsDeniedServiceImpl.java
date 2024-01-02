package com.ruoyi.parking.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.parking.mapper.PmsDeniedMapper;
import com.ruoyi.parking.domain.PmsDenied;
import com.ruoyi.parking.service.IPmsDeniedService;

/**
 * 黑名单管理Service业务层处理
 * 
 * @author chennan
 * @date 2023-11-15
 */
@Service
public class PmsDeniedServiceImpl implements IPmsDeniedService 
{
    @Autowired
    private PmsDeniedMapper pmsDeniedMapper;

    /**
     * 查询黑名单管理
     * 
     * @param deniedId 黑名单管理主键
     * @return 黑名单管理
     */
    @Override
    public PmsDenied selectPmsDeniedByDeniedId(Long deniedId)
    {
        return pmsDeniedMapper.selectPmsDeniedByDeniedId(deniedId);
    }

    /**
     * 查询黑名单管理列表
     * 
     * @param pmsDenied 黑名单管理
     * @return 黑名单管理
     */
    @Override
    public List<PmsDenied> selectPmsDeniedList(PmsDenied pmsDenied)
    {
        return pmsDeniedMapper.selectPmsDeniedList(pmsDenied);
    }

    /**
     * 新增黑名单管理
     * 
     * @param pmsDenied 黑名单管理
     * @return 结果
     */
    @Override
    public int insertPmsDenied(PmsDenied pmsDenied)
    {
        return pmsDeniedMapper.insertPmsDenied(pmsDenied);
    }

    /**
     * 修改黑名单管理
     * 
     * @param pmsDenied 黑名单管理
     * @return 结果
     */
    @Override
    public int updatePmsDenied(PmsDenied pmsDenied)
    {
        return pmsDeniedMapper.updatePmsDenied(pmsDenied);
    }

    /**
     * 批量删除黑名单管理
     * 
     * @param deniedIds 需要删除的黑名单管理主键
     * @return 结果
     */
    @Override
    public int deletePmsDeniedByDeniedIds(Long[] deniedIds)
    {
        return pmsDeniedMapper.deletePmsDeniedByDeniedIds(deniedIds);
    }

    /**
     * 删除黑名单管理信息
     * 
     * @param deniedId 黑名单管理主键
     * @return 结果
     */
    @Override
    public int deletePmsDeniedByDeniedId(Long deniedId)
    {
        return pmsDeniedMapper.deletePmsDeniedByDeniedId(deniedId);
    }
}
