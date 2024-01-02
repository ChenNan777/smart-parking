import request from '@/utils/request'

// 查询黑名单管理列表
export function listDenied(query) {
  return request({
    url: '/parking/denied/list',
    method: 'get',
    params: query
  })
}

// 查询黑名单管理详细
export function getDenied(deniedId) {
  return request({
    url: '/parking/denied/' + deniedId,
    method: 'get'
  })
}

// 新增黑名单管理
export function addDenied(data) {
  return request({
    url: '/parking/denied',
    method: 'post',
    data: data
  })
}

// 修改黑名单管理
export function updateDenied(data) {
  return request({
    url: '/parking/denied',
    method: 'put',
    data: data
  })
}

// 删除黑名单管理
export function delDenied(deniedId) {
  return request({
    url: '/parking/denied/' + deniedId,
    method: 'delete'
  })
}
