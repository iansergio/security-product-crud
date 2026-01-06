# product-crud

## 📁 Endpoints

### 1. Registrar usuário
```
POST /auth/register
```

**Body:**
```json
{
  "username": "novoUsuario",
  "password": "123",
  "role": "USER"
}
```

---

### 2. Fazer login
```
POST /auth/login
```

**Body:**
```json
{
  "username": "novoUsuario",
  "password": "123"
}
```

---

### 3. Cadastrar um produto
```
POST /products
```

**Body:**
```json
{
  "name": "calça",
  "price": 249.90
}
```

---

### 4. Listar todos os produtos
```
GET /products
```
obs: precisa-se resgatar o token jwt gerado para realizar a requisição