package com.comeonyo.domain.domain.order

data class Order(
    var id: Int,
    var userId: Int,
    var productId: Int,
) {
    // domain logic here
    // e.g.,
    // fun userThrowsAway() {
    //   this.userId = ""
    // }
}
