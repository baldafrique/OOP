<template>
  <v-card class="mx-auto" max-width="344" outlined>
    <v-list-item three-line>
      <v-list-item-content>
        <div class="text-overline mb-4">{{ value.type }}</div>
        <v-list-item-title class="text-h5 mb-1">
          {{ value.name }}
        </v-list-item-title>
        <v-list-item-subtitle
          >에너지는 {{ value.energy }}이고 외모지수는
          {{ value.appearance }}입니다.</v-list-item-subtitle
        >
      </v-list-item-content>

      <v-list-item-avatar tile size="80" color="grey"></v-list-item-avatar>
    </v-list-item>

    <v-card-actions>
      <v-btn outlined rounded text @click="eat"> Feed </v-btn>
      <v-btn outlined rounded text @click="sleep"> Sleep </v-btn>
      <slot name="buttons"></slot>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: "Pet",

  props: {
    value: Object,
  },

  methods: {
    eat() {
      if (this.$parent.eat) {
        this.$parent.eat();
      } else {
        this.value.energy += 3;
      }
    },
    sleep() {
      if (this.$parent.sleep) {
        this.$parent.sleep();
      } else {
        this.value.appearance += 3;
      }
    },
  },
};
</script>
