module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://127.0.0.1:9191/ParadiseManage_war_exploded',
                changeOrigin: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        }
    }
}
