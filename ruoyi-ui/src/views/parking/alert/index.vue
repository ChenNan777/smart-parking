<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-form-item label="告警类型" prop="type">
        <el-select
          v-model="queryParams.type"
          placeholder="请选择告警类型"
          @change="handleQuery"
          clearable
        >
          <el-option
            v-for="dict in dict.type.pms_alert_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="告警信息描述" prop="description">
        <el-input
          v-model="queryParams.description"
          placeholder="请输入告警信息描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="告警分区" prop="zoneId">
        <el-select
          v-model="queryParams.zoneId"
          placeholder="请选择告警分区"
          @change="handleQuery"
        >
          <el-option
            v-for="zone in this.zoneList"
            :key="zone.zoneId"
            :label="zone.name"
            :value="zone.zoneId"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="时间范围" prop="timeRange">
        <el-date-picker
          v-model="queryParams.timeRange"
          type="datetimerange"
          range-separator="至"
          start-placeholder="开始时间"
          end-placeholder="结束时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          @change="handleQuery"
        />
        <!-- <el-date-picker
          clearable
          v-model="queryParams.time"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择时间戳"
          @change="handleQuery"
        >
        </el-date-picker> -->
      </el-form-item>
      <el-form-item label="告警状态" prop="status">
        <el-select
          v-model="queryParams.status"
          placeholder="请选择告警状态"
          @change="handleQuery"
          clearable
        >
          <el-option
            v-for="dict in dict.type.pms_alert_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <!-- <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['parking:alert:add']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['parking:alert:edit']"
          >修改</el-button
        >
      </el-col> -->
      <!-- <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['parking:alert:remove']"
          >删除</el-button
        >
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['parking:alert:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="alertList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="告警ID" align="center" prop="alertId" />
      <el-table-column label="告警类型" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.pms_alert_type"
            :value="scope.row.type"
          />
        </template>
      </el-table-column>
      <el-table-column label="告警信息描述" align="center" prop="description" />
      <el-table-column label="告警分区" align="center" prop="zoneName" />
      <el-table-column label="时间戳" align="center" prop="time" width="180">
        <template slot-scope="scope">
          <span>{{
            parseTime(scope.row.time, "{y}-{m}-{d} {h}:{i}:{s}")
          }}</span>
        </template>
      </el-table-column>
      <el-table-column label="告警状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.pms_alert_status"
            :value="scope.row.status"
          />
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['parking:alert:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['parking:alert:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改告警管理对话框 -->
    <!-- <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="告警类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择告警类型">
            <el-option
              v-for="dict in dict.type.pms_alert_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="告警信息描述" prop="description">
          <el-input
            v-model="form.description"
            placeholder="请输入告警信息描述"
          />
        </el-form-item>
        <el-form-item label="告警分区" prop="zoneId">
          <el-input v-model="form.zoneId" placeholder="请输入告警分区" />
        </el-form-item>
        <el-form-item label="时间戳" prop="time">
          <el-date-picker
            clearable
            v-model="form.time"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择时间戳"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="告警状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.pms_alert_status"
              :key="dict.value"
              :label="parseInt(dict.value)"
              >{{ dict.label }}</el-radio
            >
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog> -->
  </div>
</template>

<script>
import {
  listAlert,
  getAlert,
  delAlert,
  addAlert,
  updateAlert,
} from "@/api/parking/alert";
import { listZone } from "@/api/parking/zone";

export default {
  name: "Alert",
  dicts: ["pms_alert_type", "pms_alert_status"],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 告警管理表格数据
      alertList: [],
      // 分区数据
      zoneList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        type: null,
        description: null,
        zoneId: null,
        timeRange: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        // type: [
        //   { required: true, message: "告警类型不能为空", trigger: "change" },
        // ],
        // time: [{ required: true, message: "时间戳不能为空", trigger: "blur" }],
        // status: [
        //   { required: true, message: "告警状态不能为空", trigger: "change" },
        // ],
      },
    };
  },
  created() {
    this.getList();
    this.getZoneList();
  },
  methods: {
    /** 查询告警管理列表 */
    getList() {
      this.loading = true;
      listAlert(this.queryParams).then((response) => {
        this.alertList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询分区列表 */
    getZoneList() {
      listZone().then((response) => {
        this.zoneList = response.rows;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        alertId: null,
        type: null,
        description: null,
        zoneId: null,
        timeRange: null,
        status: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.alertId);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加告警管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const alertId = row.alertId || this.ids;
      getAlert(alertId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改告警管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.alertId != null) {
            updateAlert(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAlert(this.form).then((response) => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const alertIds = row.alertId || this.ids;
      this.$modal
        .confirm('是否确认删除告警管理编号为"' + alertIds + '"的数据项？')
        .then(function () {
          return delAlert(alertIds);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "parking/alert/export",
        {
          ...this.queryParams,
        },
        `alert_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
