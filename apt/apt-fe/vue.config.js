const webpack = require("webpack");

module.exports = {
  transpileDependencies: true,
  devServer: {
    port: 9081,
  },
  configureWebpack: {
    plugins: [
      new webpack.ProvidePlugin({
        $: "jquery",
        jQuery: "jquery",
      }),
    ],
  },
};
