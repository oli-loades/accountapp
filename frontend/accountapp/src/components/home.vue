<template>
  <v-app id="home">

    <v-jumbotron>
      <v-container fill-height>
        <v-layout align-center>
          <v-flex>
            <h3 class="display-3">Welcome</h3>
            <span class="subheading">Simple account management webapp created using Spring-boot and Vue.js. All technologies used within this project can be seen below.</span>
          </v-flex>
        </v-layout>
      </v-container>
    </v-jumbotron>

    <v-container grid-list-md text-xs-center>
      <v-layout row wrap>

        <v-flex xs4>
          <v-card dark color="dark" href="https://vuejs.org">
              <img src="../assets/logo.png">
              <div class='overlay'>
                <div class='text'>
                <h1>Vue.js</h1>
                <v-card-text>Frontend framework</v-card-text>
              </div>
              </div>
          </v-card>

        </v-flex>

        <v-flex xs4>
          <v-card dark color="dark" href="https://spring.io/projects/spring-boot">
            <img src="../assets/spring-boot-logo.png">
            <div class='overlay'>
              <div class='text'>
              <h1>Spring-boot</h1>
              <v-card-text>Backend framework</v-card-text>
            </div>
            </div>
          </v-card>
        </v-flex>

        <v-flex xs4>
          <v-card dark color="dark" href="https://vuetifyjs.com/en/">
            <img  src="../assets/vuetify.png">
            <div class='overlay'>
              <div class='text'>
              <h1>Vuetify</h1>
              <v-card-text>Vue extension for styling and additional components</v-card-text>
            </div>
            </div>
          </v-card>
        </v-flex>

        <v-flex xs4>
          <v-card dark color="dark" href="https://www.docker.com/">
            <img  src="../assets/mono-moby.png">
            <div class='overlay'>
              <div class='text'>
              <h1>Docker</h1>
              <v-card-text>Containerizer</v-card-text>
            </div>
            </div>
          </v-card>
        </v-flex>

        <v-flex xs4>
          <v-card dark color="dark" href="https://www.mysql.com/">
            <img class="img-fluid rounded-circle" src="../assets/logo-mysql.png">
            <div class='overlay'>
              <div class='text'>
              <h1>MySQL</h1>
              <v-card-text>Database</v-card-text>
            </div>
            </div>
          </v-card>
        </v-flex>

        <v-flex xs4>
          <v-card dark color="dark" href="https://nodejs.org/en/">
            <img  src="../assets/Node.js_logo.svg">
            <div class='overlay'>
              <div class='text'>
              <h1>Node.js</h1>
              <v-card-text>Javascript runtime</v-card-text>
            </div>
            </div>
          </v-card>
        </v-flex>

      </v-layout>
    </v-container>

  </v-app>
</template>

<script>
  export default {
    name: "home"
  }
</script>

<style scoped>
  img {
    max-width: 250px;
    height: 200px;
    margin: 2px;
    padding: 5px;
  }

  .overlay {
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    height: 100%;
    width: 100%;
    opacity: 0;
    transition: .5s ease;
    background-color: black;
  }

  .overlay:hover {
    opacity: 0.9;
  }

  .text{
    margin: 10px;
    padding: 10px;
    border: white;
    text-align: center;
  }
</style>
