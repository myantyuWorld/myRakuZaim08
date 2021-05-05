<template>
 <div>
   <v-badge
    :content=item.count
    :value=item.count
    color="green"
    overlap
    v-for="item in memos" :key="item.id"
   >
    <v-btn
     class="mx-2"
     small
    >{{item.memo}}</v-btn>
   </v-badge>
 </div>
</template>

<script lang="ts">
import Vue from 'vue'
export default Vue.extend({
 data() {
  return {
   memos: [
    {id:"1", memo:"ビール", count:"12"},
    {id:"2", memo:"レッドブル", count:"7"},
    {id:"3", memo:"納豆", count:"3"},
   ]
  }
 }
})
</script>

