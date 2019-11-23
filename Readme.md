# 学习强国app开发

# 开发任务

- [x] 实现首页（app着陆页），应包含体现主题的app标题、背景图等


- [x] 使用Fragment实现列表Activity与详情Activity，在不同屏幕大小的虚拟设备上可自动切换两种显示方式

  - [x] 大屏：列表、详情同屏显示，左侧列表，右侧详情
  - [x] 小屏：列表、详情分开显示

- [x]
  列表Activity显示所选主题的视频列表，包含至少10项以上该主题内容，每项仅需显示文字信息，如：标题文字、视频时长、来源等（无需缩略图）；列表需支持上下滚动
- [x]
  详情Activity播放在列表Activity所点击的视频，包含开始、停止按钮，点击后可控制视频播放与停止。视频应指向xuexi.cn域名下的视频，勿使用本地视频。视频地址获取方法如下：


- [ ]
  学习强国app中，进入视频，点击分享，选择分享给微信好友，选择文件传输助手；在电脑微信端点击文件传输助手中的消息，在浏览器中打开视频链接

- [ ] 或者在电脑端浏览器中直接访问xuexi.cn网站中的视频

 - [x]
    通过上述方法在电脑端浏览器（建议使用谷歌Chrome浏览器）中打开该视频的链接，打开浏览器的开发者工具，定位到视频，获取视频链接，如：https://video.xuexi.com/......mp4

- [x]
  详情Activity包含RatingBar，可允许为每项内容打分，分值进行保存（文件或SharedPreferences）

- [x] 重新进入详情Activity，显示上次分值，并可修改打分

## 实现步骤

### 一、设计着陆页

着陆页比较简单我们直接使用上一个app开发的技巧进行模仿只是修改主题就可完成

主要在start_activate