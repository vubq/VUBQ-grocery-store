# Architecture Overview

- Frontend: Vue 3 SPA, chịu trách nhiệm customer-facing storefront và tích hợp API.
- Backend: Spring Boot REST API theo hướng domain-driven module hoá, đóng gói `.war` để thuận tiện deploy trên servlet container.
- Data layer: PostgreSQL cho dữ liệu giao dịch, Redis cho cache và session/cart ngắn hạn.
- Infra: Docker Compose phục vụ local bootstrap; Nginx là entrypoint reverse proxy khi cần hợp nhất frontend/backend.

Các domain ưu tiên:

1. Identity & Access
2. Catalog
3. Cart
4. Order
5. Payment
6. Search

