之前做的一个项目需求做精确到小数点后两位的文本输入框，所以就自定义了一个EditText
，效果是这样的：

![](https://github.com/LiKaiRabbit/MoneyEditText/blob/master/moneyedittext.gif)

实现了四个需求：

1.输入到小数点后两位停止输入

2.直接输入小数点后，前面自动补零

3.设置最大金额，超过后自定清除并提示

4.金额前带零自定清除

源码：[https://github.com/LiKaiRabbit/MoneyEditText](https://github.com/LiKaiRabbit/MoneyEditText)

使用直接请添加依赖
====================

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
------------------------------------------------------
	dependencies {
	        compile 'com.github.LiKaiRabbit:MoneyEditText:v1.0'
	}
------------------------------------------------
如需设置最大值，使用只需要找到控件，setMax就可以了

![](http://upload-images.jianshu.io/upload_images/4891612-a33407e9ad61077d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


PS:
项目要求输出的金额不带小数点的，所以说如果金金额没有带小数点还要补俩零。就添加了个方法返回int类型的金额数：
getValue()

![](https://github.com/LiKaiRabbit/MoneyEditText/blob/master/edte.gif)
