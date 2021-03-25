### ![image-20210325175422128](README.assets/image-20210325175422128.png)

---

> Truth + Raffle 의 합성어로 한정판에 대한 블록체인 정품 보증 및 구매권 응모(래플) 중개서비스

![](https://img.shields.io/badge/ubuntu-16.04-orange)![](https://img.shields.io/badge/vue.js-2.6.11-green)![](https://img.shields.io/badge/django-3.1.2-yellow)![](https://img.shields.io/badge/HyperledgerFabric-red)![](https://img.shields.io/badge/sqlite3-green)![](https://img.shields.io/badge/uswgi-blue)![](https://img.shields.io/badge/AWS-EC2-red)



### 기술스택

![image-20210325175501235](README.assets/image-20210325175501235.png)

---

### 업무분담

#### 기획 및 설계

- 기획서 : 이혜지, 윤예준
- ERD : 이창근
- 시퀀스다이어그램 : 이은지
- 기능정의서(JIRA이슈생성) : 윤예준
- 화면정의서 및 와이어프레임 : 이원회, 윤예준
- 1차 발표 PPT : 이혜지
- 멘토링 발표 PPT : 이혜지

#### 구현

- 백엔드(django) : 이은지 / 이창근
  - 회원가입,로그인등 REST API 구축
  - 데이터베이스 구축(SQLite)
- 블록체인 네트워크 구성(Truffle / 하이퍼레저 패브릭) : 이창근 / 이은지
- 프론트엔드(Vue.js) : 이혜지 / 윤예준, 이원회
- 배포(AWS, 젠킨스, Docker) : 윤예준, 이혜지
  - 배포환경에서의 프론트,백엔드,블록체인(Geth) 구축
- 지라 관리(마스터) : 윤예준
  - 스프린트 관리, 이슈생성및 관리
- 깃랩관리(깃마스터) : 윤예준
  - 머지 관리
- 최종발표기획, 작성 : 이원회, 이혜지
  - PPT, UCC

---



### 주요 Sequence Diagram

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
    excludes    weekends

    section 준비/기획(SUB-PRJ-1,2)
    특화프로젝트 팀구성 :done, 2021-03-01,1d
    블록체인 기술학습 :done, 2021-03-01,7d
    아이디어 기획 :done, 2021-03-01,9d
    산출물 제작 :done, 2021-03-10,3d

    section 개발환경 설정(SUB-PRJ-2)
    개발업무분담 :crit, done, 2021-03-15,1d

    section 파트별개발진행(SUB-PRJ-3)
    파트별 개발 시작/진행 : active, 2021-03-17,2021-04-08
    프론트엔드 UI/UX구현 :active, 2021-03-17,2021-03-30
    백엔드 REST API 구현 :active, 2021-03-17,2021-03-30
    블록체인 네트워크 환경 구축  :active, 2021-03-17,2021-03-22
    블록체인 네트워크 구현  :active, 2021-03-22,2021-03-30
    배포환경 구축 및 배포 진행 :active, 2021-03-24,2021-03-31
    기능별 연결 진행 :active, 2021-03-30,2021-04-02
        
    section 기타
    팀별 멘토링 1차 :done, 2021-03-16,1d
    팀별 멘토링 2차 :2021-04-02,1d
    UCC기획 및 제작 : 2021-04-05,2021-04-08
    발표준비 :crit, 2021-04-08,1d
    프로젝트 최종발표 :crit, 2021-04-09,1d
```

