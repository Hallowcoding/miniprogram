//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
		level_id: '',
		level: [],
		answers: [],
		input: {},
		sel: {},
		foc: ""
  },
  onLoad: function (options) {
		let self = this, passOr = options.passor;
		// 1. 获取数据库引用
		const db = wx.cloud.database({
		  env: 'hallowcode'
		})
		// 2. 构造查询语句
		db.collection('level_detail').where({
		  level_id: options.level_id
		}).get({
		  success: function(res) {
				let level = [], answers = [], data = res.data, foc = '', sel = {}, input = {};
				for (var i in data) {
					var item = data[i]
					level[item.row] = level[item.row] || []
					level[item.row][item.column] = item
					// level[item.column] = level[item.column] || []
					// level[item.column][item.row] = item
					if (item.vor == false) {
						foc = foc == '' ? item._id : foc
						if (passOr == 1) {
							input[item._id] = item
						} else {
							item.input = true;
						}
						answers.push(item)
					}
				}
				answers = self.shuffle(answers)
				sel[foc] = 'sel'
				self.setData({
					level_id: options.level_id,
					level: level,
					answers: answers,
					sel: sel,
					foc: foc,
					input: input
				})
			}
		})
  },
	wordClick: function(e) {
		let foc = e.currentTarget.id, answers = this.data.answers, input = this.data.input, sel = {}
		sel[foc] = "sel"
		//如果已经填写了则取消填写，还原状态
		if (input[foc] != undefined) {
			var oldItem = input[foc]
			delete input[foc]
			for (var i in answers) {
				if (answers[i]._id == oldItem._id) answers[i].input = true
			}
		}
		this.setData({
			foc: foc,
			answers: answers,
			input: input,
			sel: sel
		})
	},
	answerClick: function(e) {
		let index = e.currentTarget.id, item = e.currentTarget.dataset.item
		let self = this
		let answers = self.data.answers, input = self.data.input, foc = self.data.foc
		
		item.input = false
		answers[index] = item
		if (input[foc] != undefined) {
			var oldItem = input[foc]
			for (var i in answers) {
				if (answers[i]._id == oldItem._id) answers[i].input = true
			}
		}
		input[foc] = item
		this.setData({
			answers: answers,
			input: input
		})
		if (this.verifyAnswer()) {
			console.log('恭喜通关')
			
			//更新用户所过最大关卡数
			wx.cloud.callFunction({
				name: 'userUpdate',
				data: {
					level_id: self.data.level_id
				},
				success: res => {
					//console.log('更新用户关数', res)
				},
				fail: err => {
					console.log('[云函数] [userUpdate] 调用失败，错误信息：', err)
				}
			})
			
			wx.showModal({
			  title: '恭喜过关',
			  content: '',
				cancelText: '返回',
				confirmText: '下一关',
			  success (res) {
			    if (res.confirm) {
			      console.log('用户点击确定')
						//1.查询用户关卡列表
						wx.cloud.callFunction({
							name: 'nextLevelQuery',
							data: {
								level_id: self.data.level_id
							},
							success: res => {
								var levelData = res.result.data[0]
								wx.redirectTo({
									url: '../level/level?level_id='+ levelData._id + '&passor=0'
								})
							},
							fail: err => {
								console.log('[云函数] [levelUserQuery] 调用失败，错误信息：', err)
							}
						})
			    } else if (res.cancel) {
			      console.log('用户点击返回')
						wx.redirectTo({
							url: '../index/index?level_id=' + self.data.level_id
						})
			    }
			  }
			})
		} else {
			console.log('不正确')
		}
	},
	//打乱数组顺序
	shuffle: function(arr) {
		var len = arr.length;
		for (var i = 0; i < len - 1; i++) {
			var index = parseInt(Math.random() * (len - i));
			var temp = arr[index];
			arr[index] = arr[len - i - 1];
			arr[len - i - 1] = temp;
		}
		return arr;
	},
	//验证答案
	verifyAnswer: function(e) {
		let input = this.data.input, answers = this.data.answers, sel = this.data.sel, result = true;
		if (Object.keys(input).length != answers.length) return false;
		for (var id in input) {
			if (id != input[id]._id) {
				result = false
				sel[id] = 'wrong'
			}
		}
		this.setData({
			sel: sel
		})
		return result;
	}
})
