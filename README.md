1.nthttputils在okhttputil的基础上加上特定环境的IP检测,用法和okhttputils一致.

2.现在您可以在项目中可以用nthttputils发送http请求，在MainActivity中有测试示例 ，也可以在生成URL后，
对URL进行检测，调用UrlCheckUtils.checkUrl方法，url传你的请求地址，type现默认传1，然后再调用你的请求。

3.使用前，请确认IP为规定IP