### ![image-20210325175422128](README.assets/image-20210325175422128.png)

---

> Truth + Raffle 의 합성어로 한정판에 대한 구매권 응모(래플) 중개서비스

![](https://img.shields.io/badge/vue.js-2.6.11-green)![](https://img.shields.io/badge/SpringBoot-2.4.2-yellow)![](https://img.shields.io/badge/SpringBootSecurity-pink)![](https://img.shields.io/badge/iamport-0.2.14-blue)![](https://img.shields.io/badge/Swagger2-2.6.1-green)![](https://img.shields.io/badge/MySQL-8.0.23-green)![](https://img.shields.io/badge/AWS-EC2-red)![](https://img.shields.io/badge/ubuntu-16.04-orange)![](https://img.shields.io/badge/Docker-blue)![](https://img.shields.io/badge/Jenkins-red)![](https://img.shields.io/badge/JIRA-blue)![](https://img.shields.io/badge/SonarQube-yellow)



----

개발환경 실행

​	백엔드 (SpringBoot)
```
STS
 File - Import Projects from File System or Archieve
 Import source : /s04p23d110/backend
Run: 프로젝트 우폴더 클릭후 Run As - SpringBootApp
실행백엔드서버: http://localhost:8000
API문서 주소(Swagger): http://localhost:8000/truffle/swagger-ui.html
```


​	프론트엔드(vue-js)
```
npm install
npm run serve
실행 프론트엔드: http://localhost:8080/
```



배포환경 

​	AWS웹서비스 주소 : http://j4d110.p.ssafy.io/

​	젠킨스 자동배포 주소 : http://j4d110.p.ssafy.io:9090/

​    Swagger-ui 주소 : https://j4d110.p.ssafy.io/truffle/swagger-ui.html

---



### 기술스택

![image-20210407175410087](README.assets/image-20210407175410087.png)

---

### 업무분담

1. 기획

   기획서 및 기획안 PPT : 이혜지

   산출물작성

   ​	ERD: 윤예준

   ​	와이어프레임 : 이원회

   ​	기능정의서(JIRA이슈) : 윤예준

   ​	시퀀스다이어그램 : 윤예준

   UCC기획 및 편집 : 이원회, 이혜지



2. 개발

   테크리더 : 윤예준

   ​	Git관리 : master,develop에 대한 관리 

   개발자

   ​	프론트엔드(Vue.js) : 이원회, 이혜지

   ​	DataBase설계 (MySQL) : 윤예준

   ​	백엔드(SpringBoot): 윤예준

   ​	배포환경구축 및 자동화(AWS, Docker, Jenkins) : 윤예준

   

2. QA

   기획 산출물을 기반으로 테스트 케이스를 작성 및 수행 : 이원회

   ​	수행결과 버그 발생시 JIRA에 BUG아이템으로 생성 및 관리

   JIRA관리 : 윤예준

   ​	이슈,스프린트생성

   산출물 : 이원회, 이혜지

   ​	테스트 케이스 및 수행 결과

   샘플데이터 작성: 이혜지

   sonarQube 관리 : 윤예준

   ​	발생한 이슈에 대한 대응(코드 수정 및 알림)



---

### ERD 다이어그램

![image-20210405212952344](README.assets/image-20210405212952344.png)

---



### 주요 Sequence Diagram

#### 회원가입
전화번호 인증 API를 호출후 회원가입 절차 진행, 비밀번호는 SpringSecurity로 암호화하여 DB에 저장

```mermaid
sequenceDiagram

SignUpPage->>+SpringBoot:verifyPhoneNumber(phone)
SpringBoot->>+coolsms API:휴대폰번호인증서비스호출
coolsms API-->>-SpringBoot:랜덤한숫자4자리값 반환
SpringBoot-->>-SignUpPage:Stirng:verifyPhoneNumber(phone)
SignUpPage->>SignUpPage:반환된4자리값과 문자로수신한 4자리값 일치 비교
SignUpPage->>+SpringBoot:signUp(accountInfo)
SpringBoot->>SpringBoot:setPassword(passwordEncoding(password))
SpringBoot->>+Database:signUp(accountInfo)
Database->>Database:insert(accountInfo)
Database-->>-SpringBoot:insert result
SpringBoot-->>-SignUpPage:"result message"
```

#### 이벤트 전체조회

```mermaid
sequenceDiagram

loop event_id
	EventListPage->>+AWS Docker Volume:imageRequest
	AWS Docker Volume-->>-EventListPage:thumnail Image
end
 Note left of AWS Docker Volume:요청주소<br/>https://j4d110.p.ssafy.io/truffle/event/selectEventImgFileEventID?event_id=

EventListPage->>+SpringBoot:all()
SpringBoot->>+Database:all()
Database->>Database:select all event
Database-->>-SpringBoot:select result
SpringBoot-->>-EventListPage:List<EventDto>
```

#### 당첨자 구매진행

```mermaid
sequenceDiagram
EventResultPage->>PaymentPage:당첨자정보
PaymentPage->>PaymentPage:iamport 결제모듈 호출
PaymentPage->>+SpringBoot:verifyIamport(결제 고유번호)
SpringBoot->>+iamport Server:paymentByImpUid(결제 고유번호)
iamport Server-->>-SpringBoot:Payment 정보
SpringBoot-->>-PaymentPage:Payment 정보
PaymentPage->>PaymentPage:결제검증확인(결제 status체크)
PaymentPage->>+SpringBoot:completePayment(orderDto)
SpringBoot->>+Database:completePayment(orderDto)
Database->>Database:insert order
Database-->>-SpringBoot:insert result
SpringBoot-->>-PaymentPage:"result message"
```


------



### 개발일정

```mermaid
gantt
    dateFormat  YYYY-MM-DD
    title       Truffle

    section 준비/기획(SUB-PRJ-1,2)
    특화프로젝트 팀구성 :done, 2021-03-01,1d
    블록체인 기술학습 :done, 2021-03-01,7d
    아이디어 기획 :done, 2021-03-01,9d
    산출물 제작 :done, 2021-03-10,3d


    section 개발환경 설정(SUB-PRJ-2)
    개발업무분담 :crit, done, 2021-03-15,1d

    section 파트별개발진행(SUB-PRJ-3)
    파트별 개발 시작/진행 : active, 2021-03-17,2021-04-08
    프론트엔드 UI/UX구현 :done, 2021-03-17,2021-03-30
    백엔드 REST API 구현 :done, 2021-03-17,2021-03-30
	업무재분담 :crit, 2021-03-29,1d
    배포 자동화환경 구축 :done, 2021-03-24,2021-03-26
	프론트엔드 배포 :done, 2021-03-26,2021-03-28
    백엔드 배포 :done, 2021-03-30,2021-03-31
    기능별 연결 진행 :active, 2021-03-30,2021-04-06
    백엔드 추가 기능(결제,유저인증,이미지서버) 구현 :done, 2021-03-31,2021-04-05
        
    section 기타
    팀별 멘토링 1차 :done, 2021-03-16,1d
    팀별 멘토링 2차 :done, 2021-04-02,1d
    산출물 제작 및 정리 :active, 2021-04-02,2021-04-07
    UCC기획 및 제작 : 2021-04-05,2021-04-08
    발표준비 :crit, 2021-04-08,1d
    프로젝트 최종발표 :crit, 2021-04-09,1d
```

