// 云函数模板
// 部署：在 cloud-functions/login 文件夹右击选择 “上传并部署”

const cloud = require('wx-server-sdk')

// 初始化 cloud
cloud.init({
  // API 调用都保持和云函数当前所在环境一致
  env: cloud.DYNAMIC_CURRENT_ENV
})
const db = cloud.database({
	env: 'hallowcode'
})
const $ = db.command

/**
 * 
 * event 参数包含小程序端调用传入的 data
 * 
 */
exports.main = async (event, context) => {
	const wxContext = cloud.getWXContext()
	let curLevel = event.curLevel
	// 1. 获取数据库引用
	try {
		const res1 = await db.collection('level')
			.where({
				level_number: $.gt(curLevel),
			})
			.orderBy('level_number', 'asc')
			.limit(50)
			.get();
			
    const res2 = await db.collection('level_user')
			.where({
        user_id: wxContext.OPENID,
      }).get();
		
		let user_level = res2.data.length > 0? res2.data[0].level_number : 0
		let data = res1.data;
    for (var i in data) {
			var a = data[i].level_number - user_level 
			if (a <= 0) {
				data[i].passor = 1
			} else if (a == 1) {
				data[i].passor = 0
			} else {
				data[i].passor = -1
			}
    }
		console.log('[数据库] [查询记录] 成功: ', data)
		return data;
	} catch (e) {
		console.error('[数据库] [查询记录] 失败：', e);
	}
}

