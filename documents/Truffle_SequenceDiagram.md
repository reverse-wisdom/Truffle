# 회원관리
## 1. 로그인

사용자가 email  password를 입력하면, 해당 정보를 DB에서 확인 후 결과에따라 access-token생성, 그후 결과메시지와 uuid 값을 전송

```mermaid
sequenceDiagram

LoginPage->>+SpringBoot:login(email,password)
SpringBoot->>+Database:login(email,password)
Database->>Database:select login info
Database-->>-SpringBoot:uuid
SpringBoot-->>SpringBoot:create "access-token"
SpringBoot-->>-LoginPage:"access-token","result message","uuid"
```

## 2. 회원 가입

전화번호 인증 API를 호출후 회원가입 절차 진행, 비밀번호는 SpringSecurity로 암호화하여 DB에 저장

accountInfo: email, password, phone, address, address_detail, business_number,nickname, type(유저구분), 						gender, age

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

## 3. 회원정보 수정
회원정보를 가져오는 accountInfo를 호출하여 받아온후 update를 호출하여 회원정보 수정 요청
access-token 검증이 필요함

```mermaid
sequenceDiagram

UpdatePage->>+SpringBoot:accountInfo(email,access-token)
SpringBoot->>SpringBoot:validToken(access-token)
SpringBoot-->>UpdatePage:accountInfo
UpdatePage->>SpringBoot:update(accountInfo,access-token)
SpringBoot->>SpringBoot:validToken(access-token)
SpringBoot->>SpringBoot:setPassword(passwordEncoding(password))
SpringBoot->>+Database:update(accountInfo)
Database->>Database:update(accountInfo)
Database-->>-SpringBoot:update result
SpringBoot-->>-UpdatePage:"result message"
```



## 4. 회원탈퇴

```mermaid
sequenceDiagram

ProfilePage->>+SpringBoot:delete(access-token,email)
SpringBoot->>SpringBoot:validToken(access-token)
SpringBoot->>+Database:delete(email)
Database->>Database:delete account
Database-->>-SpringBoot:delete result
SpringBoot-->>-ProfilePage:"result message"
```

---


# 이벤트 관리

## 1. 이벤트 전체조회

```mermaid
sequenceDiagram
rect rgba(0, 0, 255, .05)
loop event_id
	EventListPage->>+AWS Docker Volume:imageRequest
	AWS Docker Volume-->>-EventListPage:thumnail Image
end
 Note left of AWS Docker Volume:요청주소<br/>https://j4d110.p.ssafy.io/truffle/event/selectEventImgFileEventID?event_id=
end
EventListPage->>+SpringBoot:all()
SpringBoot->>+Database:all()
Database->>Database:select all event
Database-->>-SpringBoot:select result
SpringBoot-->>-EventListPage:List<EventDto>
```

## 2. 이벤트 상세조회

```mermaid
sequenceDiagram

EventPage->>+AWS Docker Volume:imageRequest
AWS Docker Volume-->>-EventPage:thumnail Image
Note left of AWS Docker Volume:요청주소<br/>https://j4d110.p.ssafy.io/truffle/event/selectEventImgFileEventID?event_id=
EventPage->>+SpringBoot:detail(event_id)
SpringBoot->>+Database:all(event_id)
Database->>Database:select event
Database-->>-SpringBoot:select result
SpringBoot-->>-EventPage:EventDto
```


## 3. 이벤트 참여

```mermaid
sequenceDiagram

EventPage->>+SpringBoot:joinEvent(event_id)
EventPage->>SpringBoot:insertUserIdToParticipation(event_id,uuid)
SpringBoot->>+Database:joinEvent(event_id)
SpringBoot->>Database:insertUserIdToParticipation(event_id)
Database->>Database:update 이벤트참여자수 증가
Database->>Database:insert 참여자정보
Database-->>SpringBoot:update result
Database-->>-SpringBoot:insert result
SpringBoot-->>-EventPage:"result message"
```



## 4. 이벤트 당첨자 추첨

```mermaid
sequenceDiagram
EventPage->>+SpringBoot:selectParticipationListByEventId(event_id)
SpringBoot->>+Database:selectParticipationListByEventId(event_id)
Database->>Database:select all Participation
Database-->>-SpringBoot:select result
SpringBoot-->>-EventPage:List<User>
EventPage->>EventPage:setRandomUUID(List<User>)

EventPage->>+SpringBoot:insertUserIdWinParticipation(uuid)
SpringBoot->>+Database:insertUserIdWinParticipation(uuid)
Database->>Database:insert 당첨자 정보
Database-->>SpringBoot:insert result
SpringBoot-->>-EventPage:"result message"
```

---



# 주문 관리

## 1. 당첨자 구매 진행

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


## 2. 당첨자 구매취소 진행

```mermaid
sequenceDiagram
OrderPage->>+SpringBoot:selectOrderByEventId(event_id)
SpringBoot->>+Database:selectOrderByEventId(event_id)
Database->>Database:select order
Database-->>-SpringBoot:OrderDto
SpringBoot-->>-OrderPage:"결제고유번호", "OrderDto"
OrderPage->>+SpringBoot:cancelIamport(결제 고유번호)
SpringBoot->>+iamport Server:cancelIamport(결제 고유번호)
iamport Server-->>-SpringBoot:Payment 정보
SpringBoot-->>-OrderPage:결제취소확인(결제 status체크)

OrderPage->>+SpringBoot:deleteOrderByEventId(event_id)
SpringBoot->>+Database:deleteOrderByEventId(event_id)
Database->>Database:delete order
Database-->>-SpringBoot:delete result
SpringBoot-->>-OrderPage:"result message"
```


