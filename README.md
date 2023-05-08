# FlutterBoostTest
> gradle7.2集成flutter boost验证，重新clone之后记得先`futter pub get`
- 环境：（公司项目需求）
  - flutter：2.10.5 
  - FlutterBoost：flutter_boost-3.0.0p1


# 集成flutter
- 创建`Empty Activity`空项目
- 创建flutter module（注意：测试验证，所以在项目根目录创建flutter module）
  - 执行 `flutter create -t module --org com.yifan flutter_module`
- 创建`flutter_settings.gradle`
写入编译配置
```
setBinding(new Binding([gradle: this]))
evaluate(new File(
        settingsDir.parentFile,
        rootProject.name + '/flutter_module/.android/include_flutter.groovy'
))
include ':flutter_module'
project(':flutter_module').projectDir = new File('flutter_module')
```
- 修改`setting.gradle`
  - 修改、写入配置
```
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
   //repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS) // FAIL_ON_PROJECT_REPOS改为PREFER_SETTINGS
    repositories {
        google()
        mavenCentral()

        String flutterStorageUrl = System.getenv("FLUTTER_STORAGE_BASE_URL") ?: "https://storage.googleapis.com"
        maven {
            url flutterStorageUrl + "/download.flutter.io"
        }
    }
}
rootProject.name = "FlutterBoostTest"
include ':app'

apply { from("flutter_settings.gradle") } // 引用
```
- 修改`app/build.gradle`
```
...省略
dependencies {

    ..省略
    //加入flutter module 引用
    implementation project(':flutter')
}
```

# 集成`FlutterBoost`（本地）
- 将`flutterBoost`项目（flutter_boost-3.0.0p1）复制到`flutter_module`根目录
- `pubspec.yaml`配置文件加入flutterBoost配置
```
...
dev_dependencies:
  flutter_test:
    sdk: flutter
  flutter_lints: ^1.0.0
  flutter_boost:
    path: ./flutter_boost-3.0.0p1
...省略
```
- 原生`build.gradle`加入flutterBoost应用：
```
dependencies {
    ...
    implementation project(':flutter')
    implementation project(path: ':flutter_boost')
}
```
