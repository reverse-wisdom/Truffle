<template>
  <div class="content-table">
    <div class="tbody">
      <td class="no">{{ idx + 1 }}</td>
      <td class="email">{{ winner.email }}</td>
      <td class="phone">{{ winner.phone }}</td>
      <td class="now">{{ position }}</td>
      <td class="status">
        <div @change="Confirm">
          <label id="id_state" for="state1">
            <input type="radio" name="" id="state0" value="0" v-model="status" />
            결제전
          </label>
        </div>
        <div @change="Confirm">
          <label id="id_state" for="state2">
            <input type="radio" id="state1" v-model="status" name="" value="1" />
            결제완료
          </label>
        </div>
        <div @change="Confirm">
          <label id="id_state" for="state3">
            <input type="radio" id="state2" v-model="status" name="" value="2" />
            배송준비중
          </label>
        </div>
        <div @change="Confirm">
          <label id="id_state" for="state4">
            <input type="radio" id="state3" v-model="status" name="" value="3" />
            배송중
          </label>
        </div>
        <div @change="Confirm">
          <label id="id_state" for="state">
            <input type="radio" v-model="status" name="" id="state4" value="4" />
            배송완료
          </label>
        </div>
      </td>
    </div>
  </div>
</template>

<script>
import { fetchOrder, editOderStatus } from '@/api/order';
export default {
  data() {
    return {
      status: '',
      position: '',
      first: '',
      message: '',
    };
  },
  props: {
    winner: {
      type: Object,
    },
    idx: {
      type: Number,
    },
  },

  async created() {
    const res = await fetchOrder(this.winner.uuid);
    // console.log(res.data);
    if (res.data) {
      this.first = res.data.ship_status;
    } else {
      this.first = '0';
    }
    if (this.first == 1) {
      document.getElementById('state1').setAttribute('checked', 'checked');
      this.position = '결제완료';
    } else if (this.first == 2) {
      document.getElementById('state2').setAttribute('checked', 'checked');
      this.position = '배송준비중';
    } else if (this.first == 3) {
      document.getElementById('state3').setAttribute('checked', 'checked');
      this.position = '배송중';
    } else if (this.first == 4) {
      document.getElementById('state4').setAttribute('checked', 'checked');
      this.position = '배송완료';
    } else {
      document.getElementById('state0').setAttribute('checked', 'checked');
      this.position = '결제전';
    }
  },
  methods: {
    async checkState() {
      // console.log(this.status);
      const res = await fetchOrder(this.winner.uuid);
      // console.log(res.data);
      if (res.data) {
        const editdata = {
          uuid: this.winner.uuid,
          event_id: res.data.event_id,
          pay_status: res.data.pay_status,
          ship_status: this.status,
        };
        // console.log(editdata);
        const data = await editOderStatus(editdata);
        // console.log('상태변경', data);
      } else {
        // console.log('결제전');
      }
    },
    Confirm() {
      // console.log(this.status);
      if (this.status == 0) {
        this.message = '결제전으로 바꾸시겠습니까?';
      } else if (this.status == 1) {
        this.message = '결제완료로 바꾸시겠습니까?';
      } else if (this.status == 2) {
        this.message = '배송준비중로 바꾸시겠습니까?';
      } else if (this.status == 3) {
        this.message = '배송중로 바꾸시겠습니까?';
      } else if (this.status == 4) {
        this.message = '배송완료로 바꾸시겠습니까?';
      }
      this.$swal({
        title: this.message,
        icon: 'info',
        showCancelButton: true,
        cancelButtonText: 'cancel',
      }).then((result) => {
        if (result.isConfirmed) {
          this.checkState();
        } else {
        }
      });
    },
  },
};
</script>

<style scoped>
* {
  font-family: sans-serif; /* Change your font family */
}
.no {
  width: 5vw;
  text-align: center;
}
.email {
  width: 15vw;
  text-align: center;
}
.phone {
  width: 13vw;
  text-align: center;
}
.now {
  width: 14vw;
  text-align: center;
  /* border: 1px solid; */
  color: #191970;
  font-weight: 900;
  font-size: 1rem;
}
.status {
  display: flex;
  width: 45vw;
  text-align: center;
  justify-content: space-around;
}
.title-text {
  margin-top: 10%;
  text-align: center;
  font-size: 2rem;
}
.winner-manage {
  text-align: center;
  justify-content: center;
  /* display: flex; */
  margin-top: 5rem;
}
.content-table {
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  min-width: 400px;
  border-radius: 5px 5px 0 0;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.content-table thead tr {
  background-color: #000;
  color: #ffffff;
  text-align: left;
  font-weight: bold;
}

.content-table th,
.content-table td {
  padding: 12px 15px;
  /* width: auto; */
  text-align: center;
}

.tbody {
  width: 100%;
  display: flex;
}
.content-table tbody tr {
  border-bottom: 1px solid #dddddd;
}

.content-table tbody tr:nth-of-type(even) {
  background-color: #f3f3f3;
}

.content-table tbody tr:last-of-type {
  border-bottom: 2px solid #000;
}

.content-table tbody tr.active-row {
  font-weight: bold;
  color: #000;
}
</style>
