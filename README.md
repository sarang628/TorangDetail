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
    implementation("com.github.sarang628:TorangDetail:ce78efe382")
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

```
git submodule add (or git clone) https://github.com/sarang628/torang_detail_di.git
```


buildConfig 추가
```
android.buildFeatures.buildConfig = true

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "SERVER_URL", "\"http://sarang628.iptime.org\"")
            buildConfigField("String", "IMAGE_PORT", "\"89\"")
            buildConfigField("String", "PROFILE_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/profile_images/\"")
            buildConfigField("String", "REVIEW_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/review_images/\"")
            buildConfigField("String", "RESTAURANT_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/restaurant_images/\"")
            buildConfigField("String", "MENU_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/menu_images/\"")
        }

        getByName("release") {
            buildConfigField("String", "SERVER_URL", "\"http://sarang628.iptime.org\"")
            buildConfigField("String", "IMAGE_PORT", "\"89\"")
            buildConfigField("String", "PROFILE_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/profile_images/\"")
            buildConfigField("String", "REVIEW_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/review_images/\"")
            buildConfigField("String", "RESTAURANT_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/restaurant_images/\"")
            buildConfigField("String", "MENU_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/menu_images/\"")
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }
```

API 호출 저장소 추가

```
git submodule add (or git clone) https://github.com/sarang628/repository.git
```

```
implementation("com.github.sarang628:TorangRepository:e0d12661da")

implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

implementation("androidx.room:room-runtime:2.5.1")
annotationProcessor("androidx.room:room-compiler:2.5.1")
implementation("androidx.room:room-paging:2.5.1")
```

LocalProvider MainActivity에 추가
```
@OptIn(ExperimentalMaterial3Api::class)
val CustomRestaurantInfo: RestaurantInfo = {
    RestaurantDetailNavigationScreen(restaurantId = 234)
}

val customImageLoader: ImageLoader = { modifier, url, width, height, scale ->
    // 여기서 실제 이미지 로딩 구현 예시
    provideTorangAsyncImage().invoke(modifier, url, width, height, scale)
}

val customPullToRefresh: PullToRefresh = { isRefreshing, onRefresh, contents ->
    contents.invoke()
}

val provideFeeds: Feeds = { modifier, url->
    // 여기서 실제 이미지 로딩 구현 예시
    Text("TODO")
}
```

```
git submodule add (or git clone) https://github.com/sarang628/restaurant_detail_di.git
```

## 이미지 로드 모듈 추가

이미지 로드 모듈 단일 버전 관리를 위해 루트 프로젝트에서 구현하고 하위 프로젝트들은 인터페이스만 받음.
```
cd app/src/main/java/[package]/di
git submodule add (or git clone) https://github.com/sarang628/image.git
```
이미지 로드 모듈에 줌 처리 기능이 추가되 추가 모듈 설정 필요.
```
cd app/src/main/java/[package]/di
git submodule add (or git clone) https://github.com/sarang628/pinchzoom.git
```
이미지 로드 모듈 다운로드
```
implementation("com.github.sarang628:CommonImageLoader:1999de5a48") 
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

