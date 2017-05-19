//获取应用实例
var app = getApp()
Page({
    data: {
        itemDetail:{}
    },
    onLoad: function(options) {
        //options为页面传来参数
        console.log("itemDetail加载。。。")
        var itemId = options.itemId
        this.queryItemDetail(itemId)
    },
    queryItemDetail: function(itemId) {
        var that = this
        wx.request({
          url: 'https://scm.butterfly.mopaasapp.com/queryItemDetail?itemId='+itemId,
          data: {},
          method: 'GET', 
          success: function(res){
            that.setData({
                itemDetail: res.data.itemDetail
            })
          },
          fail: function() {
            // fail
          }
        })
    }
})