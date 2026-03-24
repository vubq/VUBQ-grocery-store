/** @type {import('tailwindcss').Config} */
export default {
  content: ['./index.html', './src/**/*.{vue,js,ts,jsx,tsx}'],
  theme: {
    extend: {
      colors: {
        brand: {
          50: '#f6f7ef',
          100: '#eaedd9',
          200: '#d5dcb4',
          300: '#b9c383',
          400: '#98a64f',
          500: '#76853a',
          600: '#5c692d',
          700: '#475124',
          800: '#3a421f',
          900: '#32391c'
        }
      }
    },
  },
  plugins: [],
}

