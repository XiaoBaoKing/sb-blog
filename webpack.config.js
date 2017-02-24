const path = require("path")
const ExtractTextPlugin = require("extract-text-webpack-plugin")
module.exports = {
	entry: './public/js/index.js', //演示单入口文件
	output: {
		path: path.join(__dirname, 'out'),  //打包输出的路径
		filename: 'bundle.js',			  //打包后的名字
		publicPath: "./out/"				//html引用路径，在这里是本地地址。
	},
    module:{
        'loaders':[
			    {test: /\.css$/, loader: ExtractTextPlugin.extract("style-loader", "css-loader")}
        ]
    },
    plugins: [
		new ExtractTextPlugin("[name].css")
	]
};