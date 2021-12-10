<template>
  <Pet v-model="value">
    <template v-slot:buttons>
      <v-btn outlined rounded text @click="groom">Groom</v-btn>
    </template>
  </Pet>
</template>

<script>
// HTTP 비동기 통신 라이브러리
const axios = require("axios").default;
import Pet from "./Pet"; // import class Pet from '.../src/components/Pet'

export default {
  name: "Cat", // 해당 변수에 담겨있는 데이터를 객체 형식으로 전달

  components: {
    Pet,
  },

  // Super class인 Pet의 고유 옵션에 해당 mixin의 옵션을 혼합
  mixins: [Pet],

  methods: {
    // Super class의 Pet을 상속 후 Cat class에만 존재하는 groom() 메서드 구현
    async groom() {
      // groom()을 실행한 뒤 DB의 내용을 갱신
      await axios.request({
        method: "PUT",
        url: new URL(this.value._links.groom.href).pathname,
        headers: { "Content-Type": "application/json" },
      });

      this.refresh(); // 새로고침
    },
  },
};
</script>
