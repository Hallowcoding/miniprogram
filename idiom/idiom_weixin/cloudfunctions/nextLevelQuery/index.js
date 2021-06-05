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
//     const res0 = await db.collection('level_user')
// 			.where({
// 				user_id: wxContext.OPENID
// 			}).get();
		const res1 = await db.collection('level')
			.where({
				_id: level_id
			}).get();
		
		let curLevelNo = res1.data.length > 0? res1.data[0].level_number : 0;
		curLevelNo = curLevelNo + 1
		/* const res2 = await db.collection('level')
			.aggregate()
			.match({
				level_number: curLevelNo
			}).lookup({
				from: 'level_detail',
				localField: '_id',
				foreignField: 'level_id',
				as: 'detail',
			}).end(); */
		const res2 = await db.collection('level')
			.where({
				level_number: curLevelNo
			}).get();
			
		console.log('[数据库] [查询记录] 成功: ', res2)
		return res2;
	} catch (e) {
		console.error('[数据库] [查询记录] 失败：', e);
	}
}

