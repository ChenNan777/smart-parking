<template>
  <div>
    <svg-icon icon-class="github" @click="goto" />
  </div>
</template>

<script>
export default {
  name: "Git",
  data() {
    return {
      url: "https://github.com/ChenNan777/smart-parking",
    };
  },
  methods: {
    goto() {
      window.open(this.url);
    },
  },
};
</script>
