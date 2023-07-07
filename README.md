# Tasks App

- (PT-BR) <br>
O Task Control é um app que utiliza do paradigma <a href="https://pt.wikipedia.org/wiki/Kanban"> Kanban</a> para ajudar o usuário a organizar suas tarefas em um período de tempo. O app está sendo desenvolvido em Kotlin e Jetpack Compose.
Este é um projeto criado para apenas para fins de aprendizado.  

- (EN) 
📫 TODO

## Informações importantes e Funcionalidades do Task Control

### Autenticação com Firebase Auth em View Models

O aplicativo conta com um sistema de registro e login de usuários, utilizando o <a href="https://firebase.google.com/docs/auth?hl=pt-br">Firebase Authentication</a>. Para os usuários que estão interessandos em entender como funciona, basta verificar os arquivos <a href= ""> Auth Repository</a> e <a href= "" >LoginViewModel</a> para entender um pouco mais sobre a implementação. Além disso, o Firebase Auth conta com algumas regras de seguranças junto de seu pacote, ajudando na verificação de erros no cadastro e login.

### Utilização de CRUD para os cards das tarefas

📫 TODO

### Arquitetura MVVM 

📫 TODO

### Reutilização de Composables

Quando utlizamos JetpackCompose, ficamos propensos a utilizar de uma das melhores funcionalidades dos composables que é a reutilização. Muitos dos componentes como Text Fields, Text, Buttons. Foram pensados visando suas reutilizações, ou seja, praticamente todos os componentes em todas as telas tem composables reutilizáveis. 

### Fluxo de Tela

No Task Control, o fluxo de telas é algo importante, afinal, podemos contar na mão quantos apps tem apenas uma tela. O fluxo foi montado de forma que a navegação acontecesse de forma simples e respeitando as regras de negócio implementadas nos View Models.
