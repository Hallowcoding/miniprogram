// pages/loancalculator/loancalculator.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    relavtive:{
      wo:{
        name:'我',
        husband:'zhangfu',
        wife:'laopo',
        father:'baba',
        mother:'mama',
        Brother:'gege',
        brother:'didi',
        Sister:'jeijie',
        sister:'meimei',
        son:'erzi',
        daughter:'nver'
      },
      zhangfu:{
        name:'丈夫',
        husband:'undefind',
        wife:'wo',
        father:'gonggong',
        mother:'popo',
        Brother:'dabozi',
        brother:'xiaoshuzi',
        Sister:'daguzi',
        sister:'xiaoguzi',
        son:'erzi',
        daughter:'nver'
      },
      laopo:{
        name:'老婆',
        husband:'wo',
        wife:'undefind',
        father:'yuefu',
        mother:'yuemu',
        Brother:'dajiuzi',
        brother:'xiaojiuzi',
        Sister:'dayizi',
        sister:'xiaoyizi',
        son:'erzi',
        daughter:'nver'
      },
      baba:{
        name:'爸爸',
        husband:'undefind',
        wife:'mama',
        father:'yuefu',
        mother:'yuemu',
        Brother:'dajiuzi',
        brother:'xiaojiuzi',
        Sister:'dayizi',
        sister:'xiaoyizi',
        son:'erzi',
        daughter:'nver'
      },
      mama:{
        name:'爸爸',
        husband:'wo',
        wife:'undefind',
        father:'yuefu',
        mother:'yuemu',
        Brother:'dajiuzi',
        brother:'xiaojiuzi',
        Sister:'dayizi',
        sister:'xiaoyizi',
        son:'erzi',
        daughter:'nver'
      }
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  /**
   * 从<input>元素中读取数据,计算贷款赔付信息,并将结果显示在<view>元素中
   */
  calculate: function () {
    let principal = this.data.formData.amount;
    let interest = this.data.formData.apr / 100 / 12;
    let payments = this.data.formData.years * 12;

    let x = Math.pow(1 + interest, payments);
    let monthly = (principal * x * interest) / (x - 1);

    let payment, total, totalinterest;
    if(isFinite(monthly)){
      payment = monthly.toFixed(2);
      total = (monthly * payments).toFixed(2);
      totalinterest = (monthly * payments - principal).toFixed(2);

      this.setData({
        ['formData.payment'] : '￥'+payment,
        ['formData.total'] : '￥'+total,
        ['formData.totalinterest'] : '￥'+totalinterest
      })
    }
  },

  /**
   * 获取<input>元素中数据
   */
  getInput: function(e) {
    let formData = this.data.formData
    formData[e.target.dataset.item] = e.detail.value
    this.setData({
      formData
    })
  }
})