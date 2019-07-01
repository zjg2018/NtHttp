## 1.nthttputils在okhttputil的基础上加上特定环境的IP检测,用法和okhttputils一致。

## 2.现在您可以在项目中可以用nthttputils发送http请求，也可以在生成URL后，对URL进行检测，调用UrlCheckUtils.checkUrl方法，url传你的请求地址，type现默认传1，然后再调用你的请求。

## 3.使用前，请确认你的URL使用的IP为规定IP。

## 4.如何使用它

#### Step 1.先在 build.gradle(Project:XXXX) 的 repositories 添加:
        allprojects {
	      repositories {
		    ...
		    maven { url "https://jitpack.io" }
          }
         }
#### Step 2. 然后在 build.gradle(Module:app) 的 dependencies 添加:
        dependencies {
              implementation 'com.github.zjg2018:NtHttp:V1.0'
        }

## 4.使用示例参见(Module:app)中的MainActivity
