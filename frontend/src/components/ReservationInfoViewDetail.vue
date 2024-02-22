<template>

    <v-card outlined>
        <v-card-title>
            ReservationInfo # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="ShopId" v-model="item.shopId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Name" v-model="item.name" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="ReservedDate" v-model="item.reservedDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="ReservedTime" v-model="item.reservedTime" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Charge" v-model="item.charge" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ReservationInfoViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/reservationInfos/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

