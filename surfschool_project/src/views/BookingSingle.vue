<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12" md="6">
        <v-col cols="12" md="6">
          <v-date-picker
              v-model="picker"
              show-adjacent-months
          ></v-date-picker>
        </v-col>
        <v-col cols="12" md="6">
          Time picker
        </v-col>
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
            <v-row>
              <v-text-field
                  label="Gender"
              ></v-text-field>
            </v-row>
            <v-row>
              <v-checkbox
                  v-model="checkbox"
                  :label="`Require wetsuit`"
              ></v-checkbox>
            </v-row>
          </v-col>
        </v-row>
        <v-row>
          <v-btn>Book</v-btn>
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