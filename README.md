![just-eat-r-128](https://user-images.githubusercontent.com/82517133/175306704-c1218ad6-31fe-4b53-9562-6ce20d6fc5dc.png)
# 😋 Just Eat 프로젝트

식단 관리 서비스 백엔드 프로젝트 입니다. 관리 서비스의 필수 기능들을 구현하였습니다.

## 📋 개요

> 프로젝트 명 : 식단 관리 서비스 (Just Eat)
>

### 🏗️ 개발 인원 및 기간

- 개발 기간 : 2022/06/20 ~ 2022/07/29 (5주간)
- 개발 인원 : Front-end & Back-end 5명

### 🛠️ 기술 스택

> Back-end
>
- Language : Java 11
- Framework : Spring Boot, MyBatis
- Database : MySQL

> Front-end
>
- Language : HTML5, CSS3, JavaScript

# 💡ERD

![just-eat-erd](https://user-images.githubusercontent.com/82517133/178319052-b9e5f178-4884-4771-bbcd-b06a4756b780.png)

## 📝 구현 기능 명세

### 이선우
[![wakatime](https://wakatime.com/badge/user/9b088db3-8ede-4dad-9a4b-63489f41376c/project/c59f1a57-19aa-434d-98db-1538c29690c1.svg)](https://wakatime.com/badge/user/9b088db3-8ede-4dad-9a4b-63489f41376c/project/c59f1a57-19aa-434d-98db-1538c29690c1)

> Mission 1 | 프로젝트 초기 세팅
>
- Spring boot 프로젝트를 생성
- Github Repository 생성 후 로컬 Git 연동
- .gitignore 파일 생성

> Mission 2 | 모델링
>
- ERD 작성
- 데이터 베이스 모델 설계

> Mission 3 | 회원 가입
>
- 중복 email 이 없도록 구현
- 조건에 맞는 email 형식만 서버로 넘어도록 구현

> Mission 4 | 로그인 기능
>
- 로그인 성공시 session 을 통해 로그인 유지
- password 검증 구현

> Mission 5 | 테스트 코드 작성
>
- 중복 email 로직에 대한 테스트 케이스 작성
- password 로직에 대한 테스트 케이스 작성

> Mission 6 | MyBatis 기본 설정
>
- MyBatis 설정 XML 파일 작성

> Mission 7 | ID 기억하기 구현
> 
- Cookie 쿠키를 이용한 ID 기억하기 기능 구현

> Mission 8 | 로그인 권한 접근 제한 기능
> 
- AOP 를 이용해 권한이 필요한 페이지는 로그인 페이지로 이동하도록 구현 

> Mission 9 | 커스텀 어노테이션을 이용한 로그인 체크 기능
> 
- AOP join point 를 커스텀 어노테이션을 통해 지정
- 다른 팀원이 코드를 작성하지 않아도 어노테이션만 사용해서 로그인 체크 구현 가능

> Mission 10 | sha256 을 통해 비밀번호 암호화
> 
- sha256 알고리즘을 통해 비밀번호 암호화 후 저장되도록 구현
> Mission 11 | Interceptor 를 통한 로그인 체크 기능
>
- 커스텀 어노테이션을 통한 로그인 체크뿐만 아니라 스프링 인터셉터를 통해 URL 기준으로도 체크 구현
> Mission 12 | SNS Kakao 계정을 통한 로그인 및 회원가입 구현
>
- Kakao API 를 사용해 SNS 로그인 및 회원가입 구현
### 기유진

> Mission 1 | 메인 페이지
>

> Mission 2 | 식단 분석
>

### 김지원

> Mission 1 | 커뮤니티 페이지
>

> Mission 2 | 댓글
>

> Mission 3 | 리뷰
>

### 김준환

> Mission 1 | 장바구니
>

> Mission 2 | 결제
>

### 방훈영

> Mission 1 | 자가 진단
>

> Mission 2 | 제품 페이지
>

## Version

> 0.1.0
>