# Restaurant Module

```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

```
dependencies {
    implementation 'com.github.sarang628:TorangDetail:ce78efe382'
}
```

힐트 추가
```
root/gradle
id("com.google.dagger.hilt.android") version "2.46" apply false

app/gradle
id("kotlin-kapt")
id("dagger.hilt.android.plugin")

implementation("com.google.dagger:hilt-android:2.46")
kapt("com.google.dagger:hilt-android-compiler:2.46")
```


음식점의 상세 화면 모듈

# 메뉴
- 상세정보
- 이미지 그리드
- 메뉴 그리드
- 리뷰 리스트

## 상세 정보
RestaurantInfo
제공 정보 

- 메인 사진
- 음식점 명
- 평점
- 음식 종류
- 내 위치로부터 거리
- 웹사이트
- 운영시간
- 전화번호

