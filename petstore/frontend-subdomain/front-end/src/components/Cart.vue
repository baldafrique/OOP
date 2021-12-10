<template>
  <v-data-table
    :headers="headers"
    :items="cartItems"
    :items-per-page="5"
    class="elevation-1"
  >
  </v-data-table>
</template>

<script>
const axios = require("axios").default;

export default {
  name: "Cart",
  components: {},
  data: () => ({
    headers: [
      { text: "Name", value: "petDetail.name" },
      { text: "Energy", value: "petDetail.energy" },
      { text: "Appearance", value: "petDetail.appearance" },
      { text: "Payment", value: "payment.method" },
      { text: "Status", value: "payment.status" },
    ],

    cartItems: [],

    showCart: false,
  }),

  created() {
    this.init();
  },

  methods: {
    showCart() {
      this.showCart = true;
    },

    async init() {
      const response = await axios.get("/cartItems");
      this.cartItems = response.data._embedded.cartItems;
      this.cartItems.forEach(async (cartItem) => {
        const response = await axios.get(
          new URL(cartItem._links.pet.href).pathname
        );
        cartItem.petDetail = response.data;
      });
    },
  },
};
</script>
