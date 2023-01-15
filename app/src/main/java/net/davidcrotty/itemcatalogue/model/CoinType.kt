package net.davidcrotty.itemcatalogue.model

sealed class CoinType(open val amount: Int) {
    class Gold(override val amount: Int): CoinType(amount)
    class Silver(override val amount: Int): CoinType(amount)
    class Copper(override val amount: Int): CoinType(amount)
}