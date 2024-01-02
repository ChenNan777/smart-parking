package com.ruoyi.parking.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.parking.domain.dto.PmsAlertDTO;
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
import com.ruoyi.parking.domain.PmsAlert;
import com.ruoyi.parking.service.IPmsAlertService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 告警管理Controller
 * 
 * @author chennan
 * @date 2023-11-15
 */
@RestController
@RequestMapping("/alert")
public class PmsAlertController extends BaseController
{
    @Autowired
    private IPmsAlertService pmsAlertService;

    /**
     * 查询告警管理列表
     */
    @RequiresPermissions("parking:alert:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsAlertDTO pmsAlert)
    {
        startPage();
        List<PmsAlert> list = pmsAlertService.selectPmsAlertList(pmsAlert);
        return getDataTable(list);
    }

    /**
     * 导出告警管理列表
     */
    @RequiresPermissions("parking:alert:export")
    @Log(title = "告警管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsAlertDTO pmsAlert)
    {
        List<PmsAlert> list = pmsAlertService.selectPmsAlertList(pmsAlert);
        ExcelUtil<PmsAlert> util = new ExcelUtil<PmsAlert>(PmsAlert.class);
        util.exportExcel(response, list, "告警管理数据");
    }

    /**
     * 获取告警管理详细信息
     */
    @RequiresPermissions("parking:alert:query")
    @GetMapping(value = "/{alertId}")
    public AjaxResult getInfo(@PathVariable("alertId") Long alertId)
    {
        return success(pmsAlertService.selectPmsAlertByAlertId(alertId));
    }

    /**
     * 新增告警管理
     */
    @RequiresPermissions("parking:alert:add")
    @Log(title = "告警管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsAlert pmsAlert)
    {
        return toAjax(pmsAlertService.insertPmsAlert(pmsAlert));
    }

    /**
     * 修改告警管理
     */
    @RequiresPermissions("parking:alert:edit")
    @Log(title = "告警管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsAlert pmsAlert)
    {
        return toAjax(pmsAlertService.updatePmsAlert(pmsAlert));
    }

    /**
     * 删除告警管理
     */
    @RequiresPermissions("parking:alert:remove")
    @Log(title = "告警管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{alertIds}")
    public AjaxResult remove(@PathVariable Long[] alertIds)
    {
        return toAjax(pmsAlertService.deletePmsAlertByAlertIds(alertIds));
    }
}
