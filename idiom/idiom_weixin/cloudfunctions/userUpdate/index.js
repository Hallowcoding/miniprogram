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
	let level_id = event.level_id
	// 1. 获取数据库引用
	try {
    const res1 = await db.collection('level_user')
			.where({
				user_id: wxContext.OPENID
			}).get();
		let doc = '', user_level = 0;
		if (res1.data.length > 0) {
			doc = res1.data[0]._id
			user_level = res1.data[0].level_number
		}
		
		const res2 = await db.collection('level')
			.where({
				_id: level_id,
			}).get();
		let cur_level = res2.data[0].level_number
		if (user_level < cur_level) {
			if (doc == '') {
				db.collection('level_user').add({
				  data: [{
						level_number: cur_level,
						user_id: wxContext.OPENID
					}]
				})
			} else {
				db.collection('level_user').doc(doc).update({
				  data: {
				    level_number: $.inc(1)
				  }
				})
			}
		}
		console.log('[数据库] [更新记录] 成功')
		return cur_level;
	} catch (e) {
		console.error('[数据库] [更新记录] 失败：', e);
	}
}

