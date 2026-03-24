<script setup lang="ts">
import { Icon } from '@iconify/vue'
import { useNow } from '@vueuse/core'
import { computed } from 'vue'
import { useAppStore } from '../stores/app'

const appStore = useAppStore()
const now = useNow()

const statusItems = computed(() => [
  { label: 'Frontend', value: 'Vue 3 + Vite + Tailwind' },
  { label: 'Backend', value: 'Spring Boot WAR-ready' },
  { label: 'Infrastructure', value: 'PostgreSQL, Redis, Docker Compose' },
  { label: 'Updated', value: now.value.toLocaleString() },
])
</script>

<template>
  <main class="mx-auto flex min-h-screen max-w-6xl flex-col px-6 py-10 text-stone-100">
    <section class="grid flex-1 gap-10 lg:grid-cols-[1.5fr_1fr] lg:items-center">
      <div class="space-y-6">
        <span class="inline-flex items-center gap-2 rounded-full border border-brand-400/40 bg-brand-500/10 px-4 py-2 text-sm text-brand-100">
          <Icon icon="solar:cart-large-2-bold" class="text-lg" />
          Initial commerce workspace
        </span>
        <div class="space-y-4">
          <h1 class="max-w-3xl text-4xl font-semibold leading-tight md:text-6xl">
            {{ appStore.appName }}
          </h1>
          <p class="max-w-2xl text-lg text-stone-300">
            Monorepo baseline cho grocery commerce platform, tối ưu để scale theo domain, API-first và triển khai production.
          </p>
        </div>
        <div class="flex flex-wrap gap-3 text-sm text-stone-200">
          <span class="rounded-full border border-stone-700 px-3 py-2">Catalog</span>
          <span class="rounded-full border border-stone-700 px-3 py-2">Cart</span>
          <span class="rounded-full border border-stone-700 px-3 py-2">Order</span>
          <span class="rounded-full border border-stone-700 px-3 py-2">Auth</span>
          <span class="rounded-full border border-stone-700 px-3 py-2">Payments</span>
        </div>
      </div>

      <aside class="rounded-3xl border border-white/10 bg-white/5 p-6 shadow-2xl shadow-black/20 backdrop-blur">
        <h2 class="text-xl font-medium text-white">Build Snapshot</h2>
        <div class="mt-6 space-y-4">
          <div
            v-for="item in statusItems"
            :key="item.label"
            class="rounded-2xl border border-white/10 bg-black/10 p-4"
          >
            <p class="text-sm uppercase tracking-[0.2em] text-stone-400">{{ item.label }}</p>
            <p class="mt-2 text-base text-stone-100">{{ item.value }}</p>
          </div>
        </div>
      </aside>
    </section>
  </main>
</template>

