const path = require('path');
const webpack = require('webpack');

module.exports = {
	entry: "./src/main.tsx",
	output: {
		filename: "bundle.js",
		path: __dirname + "/dist"
	},

	// Enable sourcemaps for debugging webpack's output.
	devtool: "source-map",

	resolve: {
		// Add '.ts' and '.tsx' as resolvable extensions.
		extensions: [".webpack.js", ".web.js", ".ts", ".tsx", ".js"],
		modules: [path.resolve(__dirname, './src'), 'node_modules']
	},

	module: {
		rules: [
			// All files with a '.ts' or '.tsx' extension will be handled by 'awesome-typescript-loader'.
			{ test: /\.tsx?$/, loader: "awesome-typescript-loader" },

			// All output '.js' files will have any sourcemaps re-processed by 'source-map-loader'.
			{ test: /\.js$/, loader: "source-map-loader", enforce: 'pre' },

			{ test: /\.css$/, use: ['style-loader', 'css-loader'] },
			{ test: /\.(sass|scss)$/, use: ['style-loader', 'css-loader', 'sass-loader'] },
		]
	},

	// When importing a module whose path matches one of the following, just
	// assume a corresponding global variable exists and use that instead.
	// This is important because it allows us to avoid bundling all of our
	// dependencies, which allows browsers to cache those libraries between builds.
	externals: {
		"gapi": "gapi"
	},

	devServer: {
		contentBase: false,
		port: 9000,
		overlay: true,
		hot: true,	// doesn't work for some reason, need --hot on the cmdline
		publicPath: "/dist/",
		proxy: {
			'!(/dist/**|**/*.hot-update.json)': {
				target: 'http://localhost:8080'
			}
		}
	}
};

// https://github.com/noBlubb/uglify-es-webpack-plugin
const UglifyEsPlugin = require('uglify-es-webpack-plugin');

if (process.env.NODE_ENV === 'production') {
	module.exports.plugins = (module.exports.plugins || []).concat([
		// This is weird, why do we need this? We just checked that value.
		new webpack.DefinePlugin({
			'process.env':{
				'NODE_ENV': JSON.stringify('production')
			}
		}),
		new UglifyEsPlugin()
	]);
}