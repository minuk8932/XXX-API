# DataSaver - API

[![](https://github.com/DataSaver-Dev/DataSaver-API/blob/master/images/logo.png)](https://github.com/DataSaver-Dev/DataSaver-API)

**DataSaver ?**
> ## **특징:**
> - 사용자가 설정에서 와이파이를 연결 및 해제하는 번거로운 과정을 앱의 백그라운드 작업을 이용하여 자동으로 진행합니다.
> - 와이파이의 품질이 매우 낮아 실제로 연결이 불가능하거나 신뢰할 수 없는 경우 제외시킵니다.
> - 지인이 알고있는 와이파이 정보를 쉽게 공유할 수 있는 기능을 제공합니다.


# 개발 환경
**DataSaver**의 개발 환경은 아래와 같습니다.
> - **STS**
<br>버젼 : **STS version "3.9.0.RELEASE"**
> - **Amazon EC2**
<br>버젼 : **EC2 version ""**
> - **Amazon S3**
<br>버젼 : **S3 version ""**
> - **MySQL**
<br>버젼 : **MySQL version ""**

# 의존성 목록
**DataSaver**의 의존성 목록은 아래와 같습니다.
```build.gradle
dependencies {
  // spring-boot-starter
  compile('org.springframework.boot:spring-boot-starter-aop')
  compile('org.springframework.boot:spring-boot-starter-data-jpa')
  compile('org.springframework.boot:spring-boot-starter-web')
  compile('org.springframework.boot:spring-boot-configuration-processor')
  compile('org.springframework.boot:spring-boot-starter-mail')
  testCompile('org.springframework.boot:spring-boot-starter-test')
  
  // mysql-connector-java
  runtime('mysql:mysql-connector-java')
	
  // java-jwt
  compile('com.auth0:java-jwt:3.2.0')
  
  // springfox-swagger2
  compile('io.springfox:springfox-swagger2:2.2.2')
  compile('io.springfox:springfox-swagger-ui:2.2.2')
  
  // gson
  compile('com.google.code.gson:gson:2.7')
  
  // commons-lang3
  compile('org.apache.commons:commons-lang3:3.0')
  
  // aws-java-sdk
  compile('com.amazonaws:aws-java-sdk:1.11.66')
  
  // commons-io
  compile('commons-io:commons-io:2.4')
}
```
# 빠른 시작
1) Git 클론
```text
git clone "https://github.com/DataSaver-Dev/DataSaver-API.git"
```
2) STS 임포트
 - STS를 실행 후 패키지 익스플로러에서 마우스 우측 버튼을 눌러 임포트를 선택합니다.
 - 이후 뜨는 창에서 Gradle (STS) 파일 내의 Gradle (STS) project 선택하신 후 다음을 선택합니다.
 - 마지막으로 아래의 이미지와 같은 창이 뜨면 빌드 모델을 반드시 누르고, 잠시 기다린 후 완료를 선택합니다.
![](https://github.com/DataSaver-Dev/DataSaver-API/blob/master/images/build_gradle_ex.png)
3) application.properties 생성
- DataSaver-API > src/main/java에서 해당 파일에서 소스 폴더명를 resources로 생성합니다.<br>
- resources에 파일명을 application.properties로 생성합니다.<br>
```application.properties
asdf
```
4) 실행 및 테스트<br>
- 최초 실행시<br>
DataSaver-API > src/main/java > DataSaverApplication.java 로 이동해서 실행합니다.
- 실행 후 해당 스웨거 웹페이지 화면
![](https://github.com/DataSaver-Dev/DataSaver-API/blob/master/images/intro.png)


# 모델 설계
![](https://github.com/DataSaver-Dev/DataSaver-API/blob/master/images/datasaver_api_diagram.png)

# 프로젝트 구성
**DataSaver**는 다음과 같이 구성되어 있습니다. 전체 코드를 보시려면 [DataSaver-API](https://github.com/DataSaver-Dev/DataSaver-API)를 보시면 됩니다.
```text
DataSaver-API
├── build.gradle (클래스패스 파일)
├── build (빌드 디렉토리)
├── gradle (디렉토리)
├── images (이미지 디렉토리)
├── LICENSE (프로젝트 라이센스 파일)
├── README.md (프로젝트 설명서 파일)
├── resources (디렉토리)
├── src (디렉토리)
├── resources (디렉토리)
├── src/main/java (소스코드 디렉토리)
│   ├── com.datasaver.api (소스코드 전체 패키지)
│   │   ├── DataSaverApplication.java (실행 Java 파일)
│   │   ├── controllers (패키지)
│   │   │   ├── forms (패키지)
│   │   │   ├── responses (패키지)
│   │   │   │   ├── data (패키지)
│   │   ├── domains (패키지)
│   │   │   ├── views (패키지)
│   │   ├── payloads (패키지)
│   │   ├── repositories (패키지)
│   │   ├── services (패키지)
│   │   │   ├── interfaces (패키지)
│   │   ├── utils (패키지)
│   │   │   ├── auth (패키지)
│   │   │   ├── aws (패키지)
│   │   │   ├── gcm (패키지)
│   │   │   ├── log (패키지)
│   │   │   ├── mail (패키지)
│   │   │   ├── password (패키지)
│   │   │   ├── res (패키지)
│   │   │   ├── swagger (패키지)
...
```

# 라이센스
본 프로젝트는 Apache 2.0 License를 따릅니다. http://www.apache.org/licenses/LICENSE-2.0

# 문의사항
기타 문의사항이 있으실 경우 아래의 **문의 수단**으로 연락해주세요.
> **문의 수단:**
> - 메일 : **devetude@naver.com**, **quentin1992@naver.com**, **minuk8932@naver.com**
> - github : **https://github.com/DataSaver-Dev/DataSaver-API/issues**
