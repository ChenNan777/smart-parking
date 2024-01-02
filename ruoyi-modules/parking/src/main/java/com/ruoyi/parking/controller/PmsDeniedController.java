package com.ruoyi.parking.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.parking.domain.PmsDenied;
import com.ruoyi.parking.service.IPmsDeniedService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 黑名单管理Controller
 * 
 * @author chennan
 * @date 2023-11-15
 */
@RestController
@RequestMapping("/denied")
public class PmsDeniedController extends BaseController
{
    @Autowired
    private IPmsDeniedService pmsDeniedService;

    /**
     * 查询黑名单管理列表
     */
    @RequiresPermissions("parking:denied:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsDenied pmsDenied)
    {
        startPage();
        List<PmsDenied> list = pmsDeniedService.selectPmsDeniedList(pmsDenied);
        return getDataTable(list);
    }

    /**
     * 导出黑名单管理列表
     */
    @RequiresPermissions("parking:denied:export")
    @Log(title = "黑名单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsDenied pmsDenied)
    {
        List<PmsDenied> list = pmsDeniedService.selectPmsDeniedList(pmsDenied);
        ExcelUtil<PmsDenied> util = new ExcelUtil<PmsDenied>(PmsDenied.class);
        util.exportExcel(response, list, "黑名单管理数据");
    }

    /**
     * 获取黑名单管理详细信息
     */
    @RequiresPermissions("parking:denied:query")
    @GetMapping(value = "/{deniedId}")
    public AjaxResult getInfo(@PathVariable("deniedId") Long deniedId)
    {
        return success(pmsDeniedService.selectPmsDeniedByDeniedId(deniedId));
    }

    /**
     * 新增黑名单管理
     */
    @RequiresPermissions("parking:denied:add")
    @Log(title = "黑名单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsDenied pmsDenied)
    {
        return toAjax(pmsDeniedService.insertPmsDenied(pmsDenied));
    }

    /**
     * 修改黑名单管理
     */
    @RequiresPermissions("parking:denied:edit")
    @Log(title = "黑名单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsDenied pmsDenied)
    {
        return toAjax(pmsDeniedService.updatePmsDenied(pmsDenied));
    }

    /**
     * 删除黑名单管理
     */
    @RequiresPermissions("parking:denied:remove")
    @Log(title = "黑名单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deniedIds}")
    public AjaxResult remove(@PathVariable Long[] deniedIds)
    {
        return toAjax(pmsDeniedService.deletePmsDeniedByDeniedIds(deniedIds));
    }
}
