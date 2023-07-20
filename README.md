
# Task Control App

- (PT-BR) <br>
O Task Control é um app que utiliza do paradigma <a href="https://pt.wikipedia.org/wiki/Kanban"> Kanban</a> para ajudar o usuário a organizar suas tarefas em um período de tempo. O app está sendo desenvolvido em Kotlin e Jetpack Compose.
Este é um projeto criado para apenas para fins de aprendizado.

- (EN) 
Task Control is an app that uses the <a href="https://pt.wikipedia.org/wiki/Kanban"> Kanban</a> paradigm to help users organize their tasks in a period of time. The app is being developed in Kotlin and Jetpack Compose.
This is a project created for learning purposes only.

- Tecnologias Utilizadas/Technologies:
  - <a href = "https://kotlinlang.org/">Kotlin</a>
  - <a href = "https://developer.android.com/studio">Android Studio</a>
  - <a href = "https://developer.android.com/jetpack/compose?hl=pt-br">Jetpack Compose</a>
  - <a href="https://firebase.google.com/docs/auth?hl=pt-br">Firebase Authentication</a>
  - <a href="https://firebase.google.com/docs/database?hl=pt-br">Firebase Realtime Database</a>

## Download
Você pode baixar clicando <a href = "https://github.com/N0stalgiaUltra/TaskControlApp/blob/main/app/release/app-release.apk"> aqui</a> ou verificando a pasta releases dentro da pasta App.

You can download by clicking <a href="https://github.com/N0stalgiaUltra/TaskControlApp/blob/main/app/release/app-release.apk">here</a> or by checking the releases folder inside the App folder.

## Informações importantes sobre o projeto / Important info about the project
 
### Autenticação com Firebase Auth em View Models / Auth with Firebase Auth inside View Models

O aplicativo conta com um sistema de registro e login de usuários, utilizando o <a href="https://firebase.google.com/docs/auth?hl=pt-br">Firebase Authentication</a>. Para os usuários que estão interessandos em entender como funciona, basta verificar os arquivos <a href= "https://github.com/N0stalgiaUltra/TaskControlApp/blob/main/app/src/main/java/com/example/taskcontrol/uxui/data/AuthRepository.kt"> Auth Repository</a> e <a href= "https://github.com/N0stalgiaUltra/TaskControlApp/blob/main/app/src/main/java/com/example/taskcontrol/uxui/auth/login/LoginViewModel.kt" >LoginViewModel</a> para entender um pouco mais sobre a implementação. Além disso, o Firebase Auth conta com algumas regras de seguranças junto de seu pacote, ajudando na verificação de erros no cadastro e login.

The application has a user registration and login system, using <a href="https://firebase.google.com/docs/auth?hl=pt-br">Firebase Authentication</a>. For users who are interested in understanding how it works, just check the <a href="https://github.com/N0stalgiaUltra/TaskControlApp/blob/main/app/src/main/java/com/example/taskcontrol/uxui/data/AuthRepository.kt">Auth Repository</a> and <a href="https://github.com/N0stalgiaUltra/TaskControlApp/blob/main/app/src/main/java/com/example/taskcontrol/uxui/auth/login/LoginViewModel.kt">LoginViewModel</a> files to understand a little more about the implementation. In addition, Firebase Auth has some security rules along with its package, helping to check errors in registration and login.


### Arquitetura MVVM / MVVM Architecture

Para falar de manipulação de dados, seja com o <a href="https://firebase.google.com/docs/database?hl=pt-br">Realtime Database</a> ou com os composables utilizados em tela, é necessária uma arquitetura própria para trabalhar com as informações. Com isso, o Task Control utiliza da arquitetura MVVM (model-view-viewmodel), onde é necessária uma separação da logica de manipulação dos dados com o modelo e com a interface do usuário. O projeto conta com View Models e seus respectivos repositórios - que se comunicam com o banco de dados e o autenticador para obter os dados. 

To talk about data manipulation, either with the <a href="https://firebase.google.com/docs/database?hl=pt-br">Realtime Database</a> or with the composables used on screen,  It needs its own architecture to work with the information. As a result, Task Control uses the MVVM (model-view-viewmodel) architecture, where it is necessary to separate the data manipulation logic from the model and the user interface. The project has View Models and their respective repositories - which communicate with the database and the authenticator to obtain the data.


### Utilização de CRUD com o Firebase Realtime Database para os cards das tarefas / Using CRUD along with Firebase Realtime Database

O projeto é composto de três abas e seus respectivos cards. Cada card representa uma tarefa que o usuário coloca, com a possibilidade de edição, remoção e atualização de seu estado. Isso tudo é possivel por conta do CRUD utilizando a arquitetura MVVM e o <a href="https://firebase.google.com/docs/database?hl=pt-br">Realtime Database</a>. Com isso, cada card está atrelado a um usuário e todas as mudanças que forem feitas dentro do app terão atualização direta com o banco de dados.

The project is made up of three tabs and their respective cards. Each card represents a task that the user places, with the possibility of editing, removing and updating its status. This is all possible because of CRUD using the MVVM architecture and the <a href="https://firebase.google.com/docs/database?hl=pt-br">Realtime Database</a>. With this, each card is linked to a user and all changes made within the app will be directly updated with the database.


### Reutilização de Composables / Composables reutilization

Quando utlizamos JetpackCompose, ficamos propensos a utilizar de uma das melhores funcionalidades dos composables que é a reutilização. Muitos dos componentes como Text Fields, Text, Buttons. Foram pensados visando suas reutilizações, ou seja, praticamente todos os componentes em todas as telas tem composables reutilizáveis. 

When we use JetpackCompose, we are likely to use one of the best features of composables, which is reuse. Many of the components like Text Fields, Text, Buttons. They were designed with a view to reuse, that is, virtually all components on all screens have reusable composables.


### Fluxo de Tela / Screen flow

No Task Control, o fluxo de telas é algo importante, afinal, podemos contar na mão quantos apps tem apenas uma tela. O fluxo foi montado de forma que a navegação acontecesse de forma simples e respeitando as regras de negócio implementadas nos View Models.

In Task Control, the flow of screens is important, after all, we can count by hand how many apps have only one screen. The flow was set up so that navigation could happen in a simple way and respecting the business rules implemented in the View Models.

### Suporte para Temas Claro/Escuro / Support to Light and Dark themes

Graças ao Compose, é muito simples definir o suporte para um tema claro e escuro. O usuário pode definir qual o tipo de tema mais o agrada escolhendo um dos dois tipos.

Thanks to Compose, it's very simple to define support for a light and dark theme. The user can define which type of theme pleases him the most by choosing one of the two types.


# Imagens/Images
<img src="https://github.com/N0stalgiaUltra/TaskControlApp/assets/53880840/66a6d6b9-b257-4816-a60c-8983a51b1fb0" width="250" height="500"/>
<img src="https://github.com/N0stalgiaUltra/TaskControlApp/assets/53880840/0a6986e4-94da-467d-ba67-c2b6fbb70dc9" width="250" height="500"/> 
<img src="https://github.com/N0stalgiaUltra/TaskControlApp/assets/53880840/3346d892-5b5b-42bb-95cf-ea2bc0723a07" width="250" height="500"/> 
<img src="https://github.com/N0stalgiaUltra/TaskControlApp/assets/53880840/1fabcab9-a327-4252-9861-7b38f0e65dfa" width="250" height="500"/> 
<img src="https://github.com/N0stalgiaUltra/TaskControlApp/assets/53880840/b54086fa-0790-4add-83d3-3a036d14c2c8" width="250" height="500"/>  


