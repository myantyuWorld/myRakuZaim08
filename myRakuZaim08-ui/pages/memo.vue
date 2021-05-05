<template>
  <section>
      <div>
        <v-row>
          <v-col>
            <form>
              <v-btn 
                small
                color="yellow"
                @click="pop_data">
                [sample]QiitaAPI
              </v-btn>
            </form>
          </v-col>
          <v-col>
            <v-btn
              small
              @click="clear_qiita"
            >
              [sample]Qiita Datatable Clear
            </v-btn>
          </v-col>
        </v-row>
      </div>
      <v-row>
        <v-col
          cols="12"
        >
          <div>
              <template>
                <v-data-table
                  :headers="headers_qiita"
                  :items="qiitas"
                  :items-per-page="5"
                  class="elevation-1"
                ></v-data-table>
            </template>
          </div>
        </v-col>
        <v-col
          cols="6"
        >
          <!-- △▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼ -->
          <!-- 【コンポーネント】Mmsb(メモ種別) -->
          <!-- △▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼ -->
          <v-card>
            <v-card-title>
              <span class="headline">カテゴリ</span>
            </v-card-title>
            <v-card-text>
              <v-container>
                <mmsb/>
              </v-container>
            </v-card-text>
          </v-card>
        </v-col>
        <v-col
          cols="6"
        >
          <!-- △▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼ -->
          <!--【コンポーネント】 良く入力するメモ -->
          <!-- △▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼ -->
          <v-card>
            <v-card-title>
              <span class="headline">良く入力するメモ</span>
            </v-card-title>
            <v-card-text>
              <frequent-memo/>
            </v-card-text>
          </v-card>
        </v-col>
        <v-col>
          <div>
            <template>
              <v-data-table
                :headers="headers_memo"
                :items="memos"
                :items-per-page="15"
                dense
                class="elevation-1"
              >
              <template v-slot:top>
                <v-toolbar flat>
                  <v-toolbar-title>
                    My Memo
                  </v-toolbar-title>
                  <v-divider
                    class="mx-4"
                    inset
                    vertical
                  >
                  </v-divider>
                  <v-spacer></v-spacer>
                  <!-- △▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼ -->
                  <!-- start dialog -->
                  <!-- △▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼ -->
                  <v-dialog
                    v-model="dialog"
                    max-width="500px"
                  >
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        color="primary"
                        dark
                        class="md-2"
                        v-bind="attrs"
                        v-on="on"
                      >
                        New Memo
                      </v-btn>
                    </template>
                      <v-card>
                        <v-card-title>
                          <span class="headline">新しいメモを追加</span>
                        </v-card-title>
                        <v-card-text>
                          <v-container>
                            <v-row>
                              <v-col
                                cols="12"
                                sm="12"
                                md="12"
                              >
                                <v-text-field
                                  label="Memo Description"
                                >
                                </v-text-field>
                              </v-col>
                            </v-row>
                          </v-container>
                        </v-card-text>

                        <v-card-actions>
                          <v-spacer></v-spacer>
                          <v-btn
                            color="blue darken-1"
                            text
                            @click="close"
                          >Cancel</v-btn>
                          <v-btn
                            color="blue darken-1"
                            text
                            @click="save"
                          >Save</v-btn>
                        </v-card-actions>
                      </v-card>
                  </v-dialog>
                  <!-- △▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼ -->
                  <!-- end dialog -->
                  <!-- △▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼ -->
                </v-toolbar>
              </template>
              <template v-slot:item.count_liner="{item}">
                <v-progress-linear :value=item.count></v-progress-linear>
              </template>
              <template v-slot:item.actions="{ item }">
                <v-icon
                  small
                  class="mr-2"
                  @click="editItem(item)"
                >
                  mdi-pencil
                </v-icon>
                <v-icon
                  small
                  class="mr-2"
                  @click="deleteItem(item)"
                >
                  mdi-delete
                </v-icon>
              </template>
              </v-data-table>
            </template>
          </div>
        </v-col>
      </v-row>
  </section>
</template>

<script lang="ts">
import Vue from "vue";
import axios from 'axios';
import Mmsb from '../components/Mmsb.vue';
import FrequentMemo from '../components/FrequentMemo.vue';


interface Memo {
  mmid: number;
  mmsb: number;
  mmnm: string;
  count: number;
  delete_flg: boolean;
}

export default Vue.extend({
  data() {
    return {
      dialog:false,
      memo_description: "",
      headers: [
        {
          text: "Dessert (100g serving)",
          align: "start",
          sortable: false,
          value: "name"
        },
        { text: "Calories", value: "calories" },
        { text: "Fat (g)", value: "fat" },
        { text: "Carbs (g)", value: "carbs" },
        { text: "Protein (g)", value: "protein" },
        { text: "Iron (%)", value: "iron" }
      ],
      headers_qiita : [
        {text:"id", value:"id"},
        {text:"comments_count", value:"comments_count"},
        {text:"title", value:"title"},
        {text:"url", value:"url"},
      ],
      qiitas : [],
      headers_memo : [
        {text:"memo", value:"memo"},
        {text:"count", value:"count_liner"},
        {text:"count", value:"count"},
        {text:"actions", value:"actions"}
      ],
      memos : [
        {id:"1", memo:"sample 1", count:"1"},
        {id:"2", memo:"sample 2", count:"2"},
        {id:"3", memo:"sample 3", count:"3"}
      ],
    };
  },

  computed: {
    memoErrors() {
      const errors = [];
      if (this.memo_description.length > 30) {
        errors.push("30文字以内で入力してね。");
      }
      return errors;
    }
  },

  watch:{
    dialog (val) {
      val || this.close()
    }
  },

  methods: {
    add() {
      console.log("call submit");
    },
    clear() {
      console.log("call clear");
      this.memo_description = "";
    },
    async pop_data() {
      // 【サンプル】QiitaのAPIにリクエストして、レスポンスをthis.qiitasに格納
      const res = await axios.get('https://qiita.com/api/v2/items')
      console.log(res)
      this.qiitas = res.data
    },
    clear_qiita() {
      this.qiitas = []
    },
    editItem(item: any) {
      console.log("editItem : " + item.memo)
    },
    deleteItem(item: any) {
      console.log("deleteItem : " + item.memo)
    },
    close () {
      this.dialog = false
    },
    save () {
      this.dialog = false
    }
  },
  
});
</script>
