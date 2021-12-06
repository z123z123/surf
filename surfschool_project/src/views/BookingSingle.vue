<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12" md="6">
        Dates
      </v-col>
      <v-col cols="12" md="6">
        <v-row>
          <v-col cols="12" md="5">
            <v-form>
              <v-row>
                <v-select
                    :items="items"
                    label="Surf style"
                    required
                ></v-select>
              </v-row>
              <v-row>
                <v-select
                    :items="levels"
                    label="Skill level"
                    required
                ></v-select>
              </v-row>
              <v-row>
                <v-text-field
                    label="First name"
                    required
                ></v-text-field>
              </v-row>
              <v-row>
                <v-text-field
                    label="Last name"
                    required
                ></v-text-field>
              </v-row>
              <v-row>
                <v-text-field
                    label="E-mail"
                    required
                ></v-text-field>
              </v-row>
            </v-form>
          </v-col>
          <v-col cols="12" md="5">
            <v-row>
              <v-text-field
                  label="Height"
                  required
              ></v-text-field>
            </v-row>
            <v-row>
              <v-text-field
                  label="Weight"
                  required
              ></v-text-field>
            </v-row>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "BookingSingle",
  data: () => ({
    items: ["Surf", "Windsurf", "Kitesurf"],
    levels: ["Beginner", "Intermediate", "Advanced"]
  }),

}
</script>

<style scoped>

</style>