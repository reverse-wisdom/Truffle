# Truffle = Trust+Raffle 



## 1. 로그인

사용자가 ID(email)와 PW를 입력하면, 해당 정보를 DB에서 확인한다.

```mermaid
sequenceDiagram

LoginPage->>DjangoServer:ID(email)/PW입력
DjangoServer->>DB : 고객정보 확인
DB -->> MainPage: 로그인 완료

```



## 2. 회원 가입

전화번호 인증 API를 거쳐 본인인증(실명인증)이 완료되면 회원가입을 진행한다. 

#### 본인인증 성공할 경우

```mermaid
sequenceDiagram

SignupPage ->> 전화번호 인증 API : 인증 요청

전화번호 인증 API -->> SignupPage : [인증완료]
SignupPage ->> DjangoServer : 회원정보 입력 및 전송 

DjangoServer ->> DB : 회원정보 저장
DB -->> DjangoServer : 성공코드(200)
DjangoServer -->> SignupPage : 성공코드(200)


```

#### 본인인증 실패할 경우

```mermaid
sequenceDiagram

SignupPage ->> 전화번호 인증 API : 인증 요청
전화번호 인증 API -->> SignupPage : [인증실패]
SignupPage ->> SignupPage : 회원가입 초기 페이지 이동
```

## 3. 로그아웃

로그아웃 버튼을 클릭하면 해당 정보가 서버로 전송되며, 유저와의 연결이 해제된다.

```mermaid
sequenceDiagram

MyPage->>DjangoServer:로그아웃 버튼 클릭
DjangoServer -->> MainPage: 연동해제, 로그아웃 완료
```

## 4. 회원정보 수정

```mermaid
sequenceDiagram

UpdatePage->>DjangoServer:수정된 회원정보 입력
DjangoServer->>DB : 고객정보 업데이트
DB -->> UpdatePage: 수정 완료
```



## 5. 회원탈퇴

```mermaid
sequenceDiagram

MyPage->>DjangoServer: 회원탈퇴 버튼 클릭
DjangoServer->>DB : 해당 고객정보 삭제
DB -->> MainPage: 회원탈퇴 완료
```



## 6. 회원정보 확인

```mermaid
sequenceDiagram

MyPage->>DjangoServer: 회원정보 요청
DjangoServer->>DB : 고객정보 확인
DB -->> DjangoServer: 고객정보 전달
DjangoServer->> MyPage:고객정보 화면 출력
```





## 7. 성별, 나이, 구매이력 등으로 우선추천기능

```mermaid
sequenceDiagram

MyPage->>DjangoServer: 성별, 나이, 구매이력 등의 회원 정보
DjangoServer->>DB : 추천 알고리즘으로 추천내역 DB 조회
DB ->> DjangoServer: 추천 정보 전달
DjangoServer->> MyPage: 추천 정보 제공
```





## 8. 카카오톡 채팅봇 연동

채팅 서버는 별도의  카카오톡 채팅 서버를 거쳐 서비스 된다.

```mermaid
sequenceDiagram

chatClient(FrontPage) ->> chatClient(FrontPage): 채팅 메시지 입력
chatClient(FrontPage) ->> chatServer : 메시지 전송
chatServer ->> chatServer : 유저 및 포트 체크
chatServer -->> chatClient(FrontPage) : 채팅 메시지 전달
chatClient(FrontPage) ->> chatClient(FrontPage) : 메시지 출력
chatServer ->> chatClient2 : 메시지 전달
chatClient2 ->> chatClient2 : 메시지 출력

```



## 9. 광고

```mermaid
sequenceDiagram

MainPage ->> Web Server : 배너클릭
Web Server -->> ad Page:해당 광고페이지로 리다이렉트
```



## 10. 판매자 한정판 제품 등록 기능

```mermaid
sequenceDiagram

RegisterPage -->> BlockChainNetwork: 한정판 제품 등록
RegisterPage -->> DjangoServer: 한정판 제품정보 등록
BlockChainNetwork ->> BlockChainNetwork: 비대칭암호화 및 한정판 제품 저장
DjangoServer ->> DB: 암호화된 정보 전달
DB -->> DB: 한정판 제품 정보 저장
```



## 11. 각 한정판 제품에 대한 검색기능 & 검색 결과 페이지

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





## 12. 결제서비스 기능

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

