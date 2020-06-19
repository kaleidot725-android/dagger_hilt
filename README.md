# Dagger Hilt



## セットアップ

build.gradle(.)**

```groovy
buildscript {
  			︙
    dependencies {
      		︙
        def dagger_hilt_version = "2.28-alpha"
        classpath "com.google.dagger:hilt-android-gradle-plugin:${dagger_hilt_version}"
    			︙
    }
}
```

**build.gralde(.app)**

```groovy
apply plugin: 'kotlin-kapt'
apply plugin: 'dagger.hilt.android.plugin'

android {
  			︙
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
        ︙
}

dependencies {
  			︙
    def dagger_hilt_version = "2.28-alpha"
    implementation "com.google.dagger:hilt-android:${dagger_hilt_version}"
    kapt "com.google.dagger:hilt-android-compiler:${dagger_hilt_version}"
  			︙
}
```



## 実装



## Dagger 用語

| 用語    | 説明                                             |
| ------- | ------------------------------------------------ |
| binding | 型とその方のインスタンスを取得する方法の組のこと |



**Dagger Hilt が何をやっているのか？**

- 今までの Dagger だと Android アプリケーション用に Component や Module を設定して実装する必要があった。
- これがわりと面倒で Application・Activity・Fragment・ViewModel に DI できるようにするだけでも一苦労だった
- Dagger Hilt ではこの Component の実装を肩代りしてくれて、Dagger を深く理解してなくても始められるっぽい



### Application のセットアップ

- Dagger Hilt を使う際には必ず Application を定義する必要があるので次の Application を定義する
- Application には @HiltAndroidApp をつける、これで Hilt Component が Application にアタッチされるようになる。

```kotlin
@HiltAndroidApp
class MainApplication : Application()	
```



##  Activity や Fragment に DI する

- Dagger Hilt では Application・Activity・Fragment・View・Service・BroadcastReceiver に対応している。

- @AndroidEntryPoint をつけることで、そのクラスに対する Component が作成される。

```kotlin
@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main)
```







## Dagger Hilt で生成される Component について

- Dagger Hilt では次の Component が作成される。

- @HiltAndroidApp をつけるとこれが Application にアタッチされる。

- @AndroidEntryPoint をつけるとこの Component が生成されるような仕組みになっている。

- このような構造になっているため Fragment に対して @AndroidEntryPoint を付ける場合は 

  親の Activity にも @AndroidEntryPoint をつけておく必要がある。

![](https://developer.android.com/images/training/dependency-injection/hilt-hierarchy.svg)

