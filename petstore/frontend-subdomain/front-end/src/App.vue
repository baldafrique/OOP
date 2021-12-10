<template>
  <v-app id="inspire">
    <v-app-bar app color="white" flat>
      <v-container class="py-0 fill-height">
        <v-avatar class="mr-10" color="grey darken-1" size="32"></v-avatar>

        <v-btn v-for="link in links" :key="link.href" :href="link.href" text>
          {{ link.title }}
        </v-btn>

        <v-spacer></v-spacer>

        <v-responsive max-width="260">
          <v-text-field
            dense
            flat
            hide-details
            rounded
            solo-inverted
          ></v-text-field>
        </v-responsive>
      </v-container>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
          <v-col cols="2">
            <v-sheet rounded="lg">
              <v-list color="transparent">
                <v-list-item @click="showCart = true">
                  <v-list-item-content>
                    <v-list-item-title> Cart </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-divider class="my-2"></v-divider>

                <v-list-item link color="grey lighten-4">
                  <v-list-item-content>
                    <v-list-item-title> Refresh </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet min-height="70vh" rounded="lg">
              <Cart v-if="showCart"></Cart>
              <Pet
                v-else
                v-model="pets[index]"
                v-for="(pet, index) in pets"
                :key="index"
              ></Pet>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import Pet from "./components/Pet"; // import object Pet
import Cart from "./components/Cart"; // import object Cart
const axios = require("axios").default; // HTTP 비동기 통신 라이브러리

export default {
  name: "App", // 해당 변수에 담겨있는 데이터를 객체 형식으로 전달
  components: {
    Pet,
    Cart,
  },
  data: () => ({
    // <template> 영역에서 펫 등록하기 라는 문자열을 출력하기 위한 title
    links: [{ title: "Register Pet", href: "/" }],
    items: ["Dog", "Cat"], // Dog와 Cat 중 해당되는 객체가 pets에 담김
    pets: [],
    showCart: false,
  }),

  created() {
    // new Vue()를 통해 event와 life cycle이 초기화 된 후
    // 화면에 반응성을 주입 하고 init() 메서드 실행
    this.init();
  },

  methods: {
    showCart() {
      // 카트 보기 버튼이 눌린경우 실행
      this.showCart = true;
    },

    async init() {
      const response = await axios.get("/cats");
      this.pets = response.data._embedded.cats;
    },
  },
};
</script>
