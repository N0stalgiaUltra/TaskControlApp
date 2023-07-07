package com.example.taskcontrol.uxui.data

object UserListDummy {
    private var _users = mutableListOf<User>()
    val Users get() = _users.toList()

    fun addUser(user: User){
        _users.add(user)
    }

    fun removeUser(email: String, password: String){
        _users.removeIf {
            email == it.email &&
            password == it.password
        }
    }

    fun editUser(user: User){
        /*Pra editar, é preciso remover obj da lista e adicionar com as novas modificações*/
        removeUser(user.email, user.password)
        addUser(user)
    }

    fun verifyUser(email: String, password: String): Boolean{
        val user = User(email, password, "", "")
        return _users.contains(user)
    }
}