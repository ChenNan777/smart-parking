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
      <el-form-item label="所属分区" prop="zoneId">
        <el-select
          v-model="queryParams.zoneId"
          placeholder="请选择所属分区"
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
      <!-- <el-form-item label="使用设备" prop="deviceId">
        <el-input
          v-model="queryParams.deviceId"
          placeholder="请输入使用设备"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="类型" prop="type">
        <el-select
          v-model="queryParams.type"
          placeholder="请选择出入口类型"
          @change="handleQuery"
          clearable
        >
          <el-option
            v-for="dict in dict.type.pms_gate_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="出入口位置" prop="location">
        <el-input
          v-model="queryParams.location"
          placeholder="请输入出入口位置"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="使用状态" prop="status">
        <el-select
          v-model="queryParams.status"
          placeholder="请选择使用状态"
          @change="handleQuery"
          clearable
        >
          <el-option
            v-for="dict in dict.type.pms_gate_status"
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
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['parking:gate:add']"
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
          v-hasPermi="['parking:gate:edit']"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['parking:gate:remove']"
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['parking:gate:export']"
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
      :data="gateList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="出入口ID" align="center" prop="gateId" />
      <el-table-column label="所属分区" align="center" prop="zoneId" />
      <el-table-column label="使用设备" align="center" prop="deviceId" />
      <el-table-column label="出入口类型" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.pms_gate_type"
            :value="scope.row.type"
          />
        </template>
      </el-table-column>
      <el-table-column label="出入口位置" align="center" prop="location" />
      <el-table-column label="使用状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.pms_gate_status"
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
            v-hasPermi="['parking:gate:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['parking:gate:remove']"
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

    <!-- 添加或修改出入口管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="所属分区" prop="zoneId">
          <el-select v-model="form.zoneId" placeholder="请选择所属分区">
            <el-option
              v-for="zone in this.zoneList"
              :key="zone.zoneId"
              :label="zone.name"
              :value="zone.zoneId"
            ></el-option>
          </el-select>
          <!-- <el-input v-model="form.zoneId" placeholder="请输入所属分区" /> -->
        </el-form-item>
        <el-form-item label="使用设备" prop="deviceId">
          <el-input v-model="form.deviceId" placeholder="请输入使用设备" />
        </el-form-item>
        <el-form-item label="出入口类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择出入口类型">
            <el-option
              v-for="dict in dict.type.pms_gate_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="出入口位置" prop="location">
          <el-input v-model="form.location" placeholder="请输入出入口位置" />
        </el-form-item>
        <el-form-item label="使用状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.pms_gate_status"
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
    </el-dialog>
  </div>
</template>

<script>
import {
  listGate,
  getGate,
  delGate,
  addGate,
  updateGate,
} from "@/api/parking/gate";
import { listZone } from "@/api/parking/zone";

export default {
  name: "Gate",
  dicts: ["pms_gate_status", "pms_gate_type"],
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
      // 出入口管理表格数据
      gateList: [],
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
        zoneId: null,
        deviceId: null,
        type: null,
        location: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        zoneId: [
          { required: true, message: "所属分区不能为空", trigger: "blur" },
        ],
        type: [
          { required: true, message: "出入口类型不能为空", trigger: "change" },
        ],
        status: [
          { required: true, message: "使用状态不能为空", trigger: "change" },
        ],
      },
    };
  },
  created() {
    this.getList();
    this.getZoneList();
  },
  methods: {
    /** 查询出入口管理列表 */
    getList() {
      this.loading = true;
      listGate(this.queryParams).then((response) => {
        this.gateList = response.rows;
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
        gateId: null,
        zoneId: null,
        deviceId: null,
        type: null,
        location: null,
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
      this.ids = selection.map((item) => item.gateId);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加出入口管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const gateId = row.gateId || this.ids;
      getGate(gateId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改出入口管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.gateId != null) {
            updateGate(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addGate(this.form).then((response) => {
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
      const gateIds = row.gateId || this.ids;
      this.$modal
        .confirm('是否确认删除出入口管理编号为"' + gateIds + '"的数据项？')
        .then(function () {
          return delGate(gateIds);
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
        "parking/gate/export",
        {
          ...this.queryParams,
        },
        `gate_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
