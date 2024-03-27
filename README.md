# KTOR-DDD-SAMPLE
This is a sample project to demonstrate how to build a RESTful API using Ktor and DDD.

## Stack

- Kotlin
- Ktor
- Koin
- exposed

## 주요 구성 요소:
Application.kt: 애플리케이션의 시작점입니다. 서버 설정과 초기화 로직을 포함합니다.

server/: 서버 설정이 포함된 디렉토리입니다.  
    config/: 애플리케이션의 구성 설정을 담당합니다.  
    routes/: Ktor 라우팅 설정을 포함하여, API 엔드포인트의 정의가 이루어집니다.  
      Routing.kt, UserRoutes.kt, OrderRoutes.kt, ProductRoutes.kt: 각각 라우팅 설정과 특정 도메인에 대한 API 경로를 정의합니다.  
    features/: Ktor의 기능(미들웨어, 필터 등) 설정을 포함합니다.  

domain/: 비즈니스 로직과 도메인 모델을 포함합니다.
   application/: 각 도메인(사용자, 주문, 제품)에 대한 애플리케이션 서비스를 정의합니다.  
   di/: 의존성 주입 설정을 위한 Koin 모듈이 위치합니다.  
   domain/: 각 도메인에 대한 엔티티, 리포지토리, 서비스, 데이터베이스 테이블 정의를 포함합니다.  

exception/: 예외 처리 로직과 사용자 정의 예외 클래스를 포함합니다.  

infra/: 인프라스트럭처 관련 설정과 외부 서비스 통신 로직이 포함된 디렉토리입니다.  

database/: 데이터베이스 초기화 및 연결 설정을 담당합니다.  
external/: 외부 시스템과의 통신을 관리합니다.  

resources/: 애플리케이션의 설정 파일과 리소스가 위치하는 디렉토리입니다.
   application.yaml: 애플리케이션의 구성을 정의하는 설정 파일입니다.  
   logback.xml: 로깅 설정을 정의하는 파일입니다.  