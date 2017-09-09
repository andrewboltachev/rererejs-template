module.exports = {
  context: __dirname,
  entry: "./webpack.entry.js",
  output: {
    path: __dirname + "/resources/public",
    filename: "webpack-bundle.js"
  },
  module: {
    rules: [{
      use: {
        loader: 'babel-loader',
        options: {
          presets: ['stage-0', 'env', 'react']
        }
      }
    }]
  }
}
