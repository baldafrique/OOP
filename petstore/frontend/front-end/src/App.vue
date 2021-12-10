<template>
  <v-app id="inspire">
    <v-app-bar app color="white" flat>
      <v-container class="py-0 fill-height">
        <v-avatar class="mr-10" color="grey darken-1" size="32"></v-avatar>

        <v-btn href="/shop"> Shopping Mall </v-btn>

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
                <v-list-item
                  v-for="item in items"
                  :key="item"
                  link
                  @click="addPet(item)"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      {{ item }}
                    </v-list-item-title>
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
              <Pet
                @change="updatePet(pet)"
                :is="pets[index].type"
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
import Cat from "./components/Cat"; // import object Cat
import Dog from "./components/Dog"; // import object Dog
import Pet from "./components/Pet"; // import object Pet
const axios = require("axios").default; // HTTP 비동기 통신 라이브러리

export default {
  name: "App", // 해당 변수에 담겨있는 데이터를 객체 형식으로 전달
  components: {
    Cat,
    Dog,
    Pet,
  },
  data: () => ({
    items: ["Dog", "Cat"], // Dog와 Cat 중 해당되는 객체가 pets에 담김
    pets: [],
  }),

  created() {
    // new Vue()를 통해 event와 life cycle이 초기화 된 후
    // 화면에 반응성을 주입 하고 init() 메서드 실행
    this.init();
  },

  methods: {
    async init() {
      const response = await axios.get("/cats");
      this.pets = response.data._embedded.cats;
    },

    // 클릭된 버튼이 Dog인 경우 또는 Cat인 경우에 따라
    // 해당하는 객체의 필드값을 채워넣고 pet array에 push
    addPet(item) {
      if (item == "Dog") {
        this.pets.push({
          type: "Dog",
          name: "멍멍이",
          energy: 1,
          appearance: 5,
        });
      } else if (item == "Cat") {
        this.pets.push({
          type: "Cat",
          name: "야옹이",
          energy: 2,
          appearance: 10,
        });
      }

      axios.request({
        method: "POST",
        url: `/cats`,
        headers: { "Content-Type": "application/json" },
        data: this.pets[this.pets.length - 1],
      });
    },

    updatePet(pet) {
      // pet array의 값이 수정될 때 마다 update
      axios.request({
        method: "PATCH",
        url: new URL(pet._links.self.href).pathname,
        headers: { "Content-Type": "application/json" },
        data: pet,
      });
    },
  },
};
</script>
