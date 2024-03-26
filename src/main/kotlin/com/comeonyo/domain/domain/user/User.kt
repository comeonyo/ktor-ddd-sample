package com.comeonyo.domain.domain.user

data class User(
    var id: Int,
    var name: String,
    var email: String,
    var password: String,
) {
    // domain logic here
    // e.g.,
    // fun userThrowsAway() {
    //   this.userId = ""
    // }
}
