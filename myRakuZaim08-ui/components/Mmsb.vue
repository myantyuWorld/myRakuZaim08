<template>
  <v-row>
    <v-col>
     <v-btn-toggle v-model="mmsb">
      <v-btn 
       v-for="category in categories" 
       :key="category.id"
       >
       {{category.name}}
      </v-btn>
     </v-btn-toggle>
    </v-col>
  </v-row>
</template>

<script lang="ts">
import Vue from 'vue'
export default Vue.extend({
  data() {
    return {
      categories : [
        {id:"0", name:"ALL"},
        {id:"1", name:"食費"},
        {id:"2", name:"日用品"}
      ],
      mmsb: 0
    }
  }
})
</script>


<style>

</style>

