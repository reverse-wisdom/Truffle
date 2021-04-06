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

 작성중

---

### 업무분담

1. 기획

   기획서 및 기획안 PPT : 이혜지

   산출물작성

   ​	ERD: 윤예준

   ​	와이어프레임 : 이원회

   ​	기능정의서(JIRA이슈) : 윤예준

   ​	시퀀스다이어그램 : 이혜지

   

2. 개발

   테크리더 : 윤예준

   ​	팀 내 기술적인 방향을 정하는 역할

   ​	Git관리 : master,develop에 대한 관리 

   개발자

   ​	프론트엔드(Vue.js) : 이원회, 이혜지

   ​	DataBase설계 (MySQL) : 윤예준

   ​	백엔드(SpringBoot): 윤예준

   ​	배포환경구축 및 자동화(AWS, Docker, Jenkins) : 윤예준

   

3. QA

   기획 산출물을 기반으로 테스트 케이스를 작성 및 수행 : 이원회

   ​	수행결과 버그 발생시 JIRA에 BUG아이템으로 생성 및 관리

   JIRA관리 : 윤예준

   ​	이슈,스프린트생성

   산출물 : 이원회, 이혜지

   ​	테스트 케이스 및 수행 결과

   sonarQube 관리 : 윤예준

   ​	발생한 이슈에 대한 대응(코드 수정 및 알림)



---

### ERD 다이어그램

![image-20210405212952344](README.assets/image-20210405212952344.png)

---



### 주요 Sequence Diagram

수정중

#### 각 한정판 제품에 대한 검색기능 & 검색 결과 페이지

```mermaid
sequenceDiagram

SearchPage ->> DjangoServer: 검색 키워드 전달
SearchPage -->> BlockChainNetwork: 검색키워드 전달
DjangoServer ->> DB: 검색정보 전달
DB ->> DB: 해당 제품 검색
DB ->> DjangoServer: 검색결과정보 전달
BlockChainNetwork -->> SearchPage: 검색정보전달
DjangoServer ->> SearchPage: 검색 결과 페이지에 출력
```

#### 판매자 한정판 제품 등록 기능

```mermaid
sequenceDiagram

RegisterPage -->> BlockChainNetwork: 한정판 제품 등록
RegisterPage -->> DjangoServer: 한정판 제품정보 등록
BlockChainNetwork ->> BlockChainNetwork: 비대칭암호화 및 한정판 제품 저장
DjangoServer ->> DB: 암호화된 정보 전달
DB -->> DB: 한정판 제품 정보 저장
```

#### 결제서비스 기능

```mermaid
sequenceDiagram

사용자 ->> 결제 API: 결제프로그램 설치
결제 API ->> 사용자: 설치완료
사용자 ->> 결제 API: 결제수단 선택
결제 API ->> 사용자: 선택완료
사용자 ->> 결제 API: 결제하기
결제 API -->> DB: 회원정보수정
DB -->> DjangoServer: 변경 정보 전달
DjangoServer ->> MyPage: 결제내역 안내
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

