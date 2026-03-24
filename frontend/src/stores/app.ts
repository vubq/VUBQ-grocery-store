import { defineStore } from 'pinia'

export const useAppStore = defineStore('app', {
  state: () => ({
    appName: 'VUBQ Grocery Store',
    apiBaseUrl: import.meta.env.VITE_API_BASE_URL ?? 'http://localhost:8080',
  }),
})

