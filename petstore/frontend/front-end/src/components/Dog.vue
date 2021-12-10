<template>
  <Pet v-model="value"></Pet>
</template>

<script>
// HTTP 비동기 통신 라이브러리
import Pet from "./Pet"; // import class Pet from '.../src/components/Pet'

export default {
  name: "Dog", // 해당 변수에 담겨있는 데이터를 객체 형식으로 전달

  components: {
    Pet,
  },

  mixins: [Pet], // Super class인 Pet의 고유 옵션에 해당 mixin의 옵션을 혼합

  methods: {
    // eat() {
    //   this.value.energy += 2;
    // },
    // sleep() {
    //   this.$super(Pet).sleep();
    //   this.value.appearance++;
    // },
  },
};
</script>
