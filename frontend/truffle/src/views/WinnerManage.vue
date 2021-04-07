<template>
  <div class="winner-manage">
    <div>특정이벤트 당첨자관리</div>
    <table class="content-table">
      <thead>
        <tr>
          <th>Rank</th>
          <th>Name</th>
          <th>Points</th>
          <th>Team</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>Domenic</td>
          <td>88,110</td>
          <td>dcode</td>
        </tr>
        <tr class="active-row">
          <td>2</td>
          <td>Sally</td>
          <td>72,400</td>
          <td>Students</td>
        </tr>
        <tr>
          <td>3</td>
          <td>Nick</td>
          <td>52,300</td>
          <td>dcode</td>
        </tr>
      </tbody>
    </table>
    <div v-for="(winner, idx) in winnerList" :key="idx">
      {{ winner.email }}
      {{ winner.phone }}
      {{ winner.uuid }}
    </div>
  </div>
</template>

<script>
import { selectedWinner } from '@/api/event';
export default {
  data() {
    return {
      winnerList: [],
    };
  },
  async created() {
    const event_id = this.$route.query.event_id;
    const { data } = await selectedWinner(event_id);
    console.log(data);
    this.winnerList = data;
    console.log(this.winnerList);
  },
};
</script>

<style scoped>
* {
  font-family: sans-serif; /* Change your font family */
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
  background-color: #009879;
  color: #ffffff;
  text-align: left;
  font-weight: bold;
}

.content-table th,
.content-table td {
  padding: 12px 15px;
}

.content-table tbody tr {
  border-bottom: 1px solid #dddddd;
}

.content-table tbody tr:nth-of-type(even) {
  background-color: #f3f3f3;
}

.content-table tbody tr:last-of-type {
  border-bottom: 2px solid #009879;
}

.content-table tbody tr.active-row {
  font-weight: bold;
  color: #009879;
}
</style>
