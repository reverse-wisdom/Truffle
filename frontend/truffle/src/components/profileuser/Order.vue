<template>
  <!-- <div>
    주문내역조회
  </div> -->
   <div class="card">
      <div class="card-nav">
        <h2>주문내역조회</h2>
        <hr>
      </div>

      <div class="card-body">
        <!-- <h4 class="">주문내역 조회</h4> -->
        <div class="card-body-title">         
          <p>입금/결제0</p>
          <p>배송중0</p>
          <p>배송완료0</p>
          <p>구매확정0</p>
          <p>교환0</p>
          <p>교환완료0</p>
          <p>환불0</p>
          <p>환불완료0</p>
        </div>
        <br>
        <hr>
        <div class="card-body-title">
          <p>상품정보</p>
          <p>주문일자</p>
          <p>주문번호</p>
          <p>주문금액</p>
          <p>주문상태</p>
        </div>
        <hr>

        <div class="card-body-description">
          <p>구매하신 내역이 없습니다.</p>
        </div>
      </div>

      <!-- <div class="card-footer">
        <p>HAHAHA</p>
      </div> -->
    </div>

    </div>
  </div>

</template>

<script>
export default {
  name: 'Order'
}
</script>

<style scoped>
.container {
  width: 1200px;
  height: 1000px;
  border: 2px dashed black;
  margin: 50px auto;
}

.card {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 700px;
  border: 2px dashed black;
  margin: 0 auto;
}

.card-nav {
  display: flex;
  justify-content: center;
  background-color:linen;
}

.card-header {
  padding: 18px;
}

.card-img {
  display: block;
  width: 100%;
  height: 330px;
}

.card-img-description {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: white;
  height: 70px;
  justify-content: center;
}

.card-body {
  padding: 18px;
}

.card-body-title {
  display: flex;
  align-items: center;  /*글자먼저 정렬하고*/
  justify-content: space-between; /*이렇게 정렬하면 깔끔*/
}

.card-body-description {
  background-color: linen;
  margin-top: 10px;
  padding: 10px;
}

.card-footer {
  display: flex;
  justify-content: flex-end;
  background-color: white;
  color: white;
  padding: 10px;
}
</style>