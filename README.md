# Motofinance

Motofinance é um aplicativo Android que ajuda motociclistas a controlarem o custo real do uso da moto, incluindo consumo de combustível, peças e manutenção.

## 📱 Funcionalidades Atuais

- Cálculo de rendimento por litro (Km/L)
- Cálculo de custo por Km rodado baseado no valor da combustivel 
- Interface com Jetpack Compose

## 📦 Bibliotecas Utilizadas

| Biblioteca | Para que serve |
|-----------|----------------|
| **Jetpack Compose** | Criação da interface moderna e declarativa |
| **Room** | Persistência de dados local com SQLite |
| **Koin** | Injeção de dependência de forma simples |
| **ViewModel / StateFlow** | Gerenciamento de estado e lógica de tela |
| **Material 3** | Componentes visuais seguindo o design Material |
| **ZXing** | (Planejado) Leitura de QR Code para abastecimentos |
| **Navigation Compose** | Gerenciar navegação entre telas |
| **Hilt (removido)** | Substituído por Koin para simplificar o projeto |

## 🧠 Arquitetura

```
com.johnny.motofinance
├── data
│   ├── local
│   │   ├── entity     → Entidades do Room (AbastecimentoEntity, etc)
│   │   ├── daos       → Interfaces com queries do Room
│   │   └── db         → AppDatabase
│   └── repository     → Implementações dos repositórios
├── domain
│   ├── model          → Modelos puros usados na lógica
│   ├── repository     → Interfaces dos repositórios
│   └── usecase        → Casos de uso (ex: cálculo por litro)
├── presentation
│   ├── screens        → Telas em Compose
│   └── viewmodel      → Lógicas de tela
├── di                 → Módulos Koin
└── ui.theme           → Temas do Compose
```

## ✅ A fazer

- CRUD completo para abastecimentos, peças, KM
- Histórico de custos
- Cálculo de lucro por KM
- Cálculo considerando seguro, IPVA e financiamento
- Exportação de dados

## 🚀 Como rodar

```bash
git clone https://github.com/seuusuario/motofinance.git
```
Abra no Android Studio e rode com um emulador Android ou dispositivo real.

---

Criado com 💜 por Johnny 🚀
