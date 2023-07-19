
# Task Control App

- (PT-BR) <br>
O Task Control é um app que utiliza do paradigma <a href="https://pt.wikipedia.org/wiki/Kanban"> Kanban</a> para ajudar o usuário a organizar suas tarefas em um período de tempo. O app está sendo desenvolvido em Kotlin e Jetpack Compose.
Este é um projeto criado para apenas para fins de aprendizado.  

- Tecnologias Utilizadas:
  - <a href = "https://kotlinlang.org/">Kotlin</a>
  - <a href = "https://developer.android.com/studio">Android Studio</a>
  - <a href = "https://developer.android.com/jetpack/compose?hl=pt-br">Jetpack Compose</a>
  - <a href="https://firebase.google.com/docs/auth?hl=pt-br">Firebase Authentication</a>
  - <a href="https://firebase.google.com/docs/database?hl=pt-br">Firebase Realtime Database</a>

## Informações importantes sobre o Task Control (PT-BR)
 
### Autenticação com Firebase Auth em View Models

O aplicativo conta com um sistema de registro e login de usuários, utilizando o <a href="https://firebase.google.com/docs/auth?hl=pt-br">Firebase Authentication</a>. Para os usuários que estão interessandos em entender como funciona, basta verificar os arquivos <a href= ""> Auth Repository</a> e <a href= "" >LoginViewModel</a> para entender um pouco mais sobre a implementação. Além disso, o Firebase Auth conta com algumas regras de seguranças junto de seu pacote, ajudando na verificação de erros no cadastro e login.

### Arquitetura MVVM 

Para falar de manipulação de dados seja com o <a href="https://firebase.google.com/docs/database?hl=pt-br">Realtime Database</a> ou com os composables utilizados em tela, é necessária uma arquitetura própria para trabalhar com as informações. Com isso, o Task Control utiliza da arquitetura MVVM (model-view-viewmodel), onde é necessária uma separação da logica de manipulação dos dados com o modelo e com a interface do usuário. O projeto conta com View Models e seus respectivos repositórios - que se comunicam com o banco de dados e o autenticador para obter os dados. 

### Utilização de CRUD com o Firebase Realtime Database para os cards das tarefas

O projeto é composto de três abas e seus respectivos cards. Cada card representa uma tarefa que o usuário coloca, com a possibilidade de edição, remoção e atualização de seu estado. Isso tudo é possivel por conta do CRUD utilizando a arquitetura MVVM e o <a href="https://firebase.google.com/docs/database?hl=pt-br">Realtime Database</a>. Com isso, cada card está atrelado a um usuário e todas as mudanças que forem feitas dentro do app terão atualização direta com o banco de dados.


### Reutilização de Composables

Quando utlizamos JetpackCompose, ficamos propensos a utilizar de uma das melhores funcionalidades dos composables que é a reutilização. Muitos dos componentes como Text Fields, Text, Buttons. Foram pensados visando suas reutilizações, ou seja, praticamente todos os componentes em todas as telas tem composables reutilizáveis. 

### Fluxo de Tela

No Task Control, o fluxo de telas é algo importante, afinal, podemos contar na mão quantos apps tem apenas uma tela. O fluxo foi montado de forma que a navegação acontecesse de forma simples e respeitando as regras de negócio implementadas nos View Models.

### Suporte para Temas Claro/Escuro

Graças ao Compose, é muito simples definir o suporte para um tema claro e escuro. O usuário pode definir qual o tipo de tema mais o agrada escolhendo um dos dois tipos.

# Imagens/Images
![Screenshot_20230719_182545](https://github.com/N0stalgiaUltra/TaskControlApp/assets/53880840/66a6d6b9-b257-4816-a60c-8983a51b1fb0)
![Screenshot_20230719_183002](https://github.com/N0stalgiaUltra/TaskControlApp/assets/53880840/0a6986e4-94da-467d-ba67-c2b6fbb70dc9)
![Screenshot_20230719_183429](https://github.com/N0stalgiaUltra/TaskControlApp/assets/53880840/3346d892-5b5b-42bb-95cf-ea2bc0723a07)
![Screenshot_20230719_183515](https://github.com/N0stalgiaUltra/TaskControlApp/assets/53880840/1fabcab9-a327-4252-9861-7b38f0e65dfa)
![Screenshot_20230719_183647](https://github.com/N0stalgiaUltra/TaskControlApp/assets/53880840/b54086fa-0790-4add-83d3-3a036d14c2c8)

