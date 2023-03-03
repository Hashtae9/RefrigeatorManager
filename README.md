# RefrigeatorManager
냉장고 속 재료 관리 및 재료들을 이용한 레시피 추천 어플



## 프로젝트 구성



### 프론트

[리액트](https://sundries-in-myidea.tistory.com/125)

### 서버

[스프링](https://sundries-in-myidea.tistory.com/134)



## ⚙️개발환경(Development Environment)

| 분류                 | 개발환경                                   |
| -------------------- |----------------------------------------|
| 노트북               | 윈도우 10 64비트                            |
| 개발도구             | IntelliJ IDEA, 그레이들, VS CODE, Emulator |
| 프레임워크           | 스프링 부트 3.0.2                           |
| 프론트               | 리액트 네이티브(npx)                          |
| 데이터베이스         | Mysql 8.0.32                           |
| 버전 관리            | 깃허브, 깃                                 |
| 배포 및 운영         | AWS EC2, AWS RDS                       |
| 오픈소스 및 외부링크 | 식품 의약품 안전처 Bacode API                  |

## 🛠상세 기술 스택(Tech Stack)

### 백엔드(Back-end)

- **자바 17**
- 스프링 부트 3.0.2
  - 스프링 웹 MVC
  - 스프링 데이터 JPA
  - 스프링 시큐리티
- **[스프링](https://sundries-in-myidea.tistory.com/134)**

### 데이터베이스(Database)

- Mysql (ver. 8.0.32)

### 프론트엔드(Front-end)

- [리액트](https://sundries-in-myidea.tistory.com/125)

### 기타

- 추가

## 구현 기능

### 1. 로그인
- jwt를 이용한 토큰형식의 로그인

### 2. 바코드를 이용한 냉장고에 재료 담기
- 식품 의약품 안전처의 Open API 활용
- WebClient 활용

### 3. 냉장고 속 재료로 만들수 있는 요리의 레시피 및 영상 제공
- python의 pytube를 이용한 데이터 수집 및 가공
- JPA를 활용한 DB연동

### 4. 기타 부수적 기능
- 재료추가
- 재료삭제
- etc..

## 역할분담
- Hashtae9
  - 데이터 수집 및 가공
  - jpa를 활용한 db연결
  - rest api 구현
  - webclient를 활용한 openapi 사용
  - aws rds, ec2를 활용한 배포
- jw0097
  - react native front 화면 구성
  - redux로 유저 상태 관리
  - spring security를 이용한 jwt 로그인 방식 구현
  - aws rds, ec2를 활용한 배포
  - travis ci

## DB ERD
[image](https://user-images.githubusercontent.com/101400894/222628103-549d4c93-bbf8-463f-8271-adc257cdff08.png)

## 프론트 구성
![](https://velog.velcdn.com/images/jw0097/post/35813402-7fa1-474d-90ca-385fb806a41c/image.svg)


