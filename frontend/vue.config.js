const { defineConfig } = require('@vue/cli-service')
const path = require("path");
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '/test': {
        target: 'http://localhost:9090',
        changeOrigin: true,
        pathRewrite: { '^/': '' },
      },
    }
  },
  chainWebpack: config => {
    config.resolve.alias
      .set('@', path.resolve(__dirname, 'src/'))
  },
  outputDir: path.resolve(__dirname, "../backend/src/main/resources/static"),
})