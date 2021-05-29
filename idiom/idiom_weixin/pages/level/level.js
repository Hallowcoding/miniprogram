//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
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
				let level = [], answers = [], data = res.data, foc = '', sel = {};
				for (var i in data) {
					var item = data[i]
					if (passOr == 'true') {
						item.vor = true;
					}
					level[item.row] = level[item.row] || []
					level[item.row][item.column] = item
					if (item.vor == false && passOr == 'false') {
						foc = foc == '' ? item._id : foc
						item.input = true;
						answers.push(item)
					}
				}
				answers = self.shuffle(answers)
				sel[foc] = 'sel'
				self.setData({
					level: level,
					answers: answers,
					sel: sel,
					foc: foc
				})
			}
		})
  },
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
		let index = e.currentTarget.id, item = e.currentTarget.dataset.item, 
		answers = this.data.answers, input = this.data.input, foc = this.data.foc
		
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
	}
})
