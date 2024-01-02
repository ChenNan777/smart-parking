import request from "@/utils/request";

// 查询分区管理列表
export function listZone(query) {
  return request({
    url: "/parking/zone/list",
    method: "get",
    params: query,
  });
}

// 查询分区管理详细
export function getZone(zoneId) {
  return request({
    url: "/parking/zone/" + zoneId,
    method: "get",
  });
}

// 新增分区管理
export function addZone(data) {
  return request({
    url: "/parking/zone",
    method: "post",
    data: data,
  });
}

// 修改分区管理
export function updateZone(data) {
  return request({
    url: "/parking/zone",
    method: "put",
    data: data,
  });
}

// 删除分区管理
export function delZone(zoneId) {
  return request({
    url: "/parking/zone/" + zoneId,
    method: "delete",
  });
}
