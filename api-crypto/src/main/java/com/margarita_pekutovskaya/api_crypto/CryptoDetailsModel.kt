package com.margarita_pekutovskaya.api_crypto

import com.google.gson.annotations.SerializedName

data class CryptoDetailsModel(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("symbol")
    val symbol: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("web_slug")
    val webSlug: String? = null,
    @SerializedName("asset_platform_id")
    val assetPlatformId: String? = null,
    @SerializedName("block_time_in_minutes")
    val blockTimeInMinutes: Int? = null,
    @SerializedName("hashing_algorithm")
    val hashingAlgorithm: String? = null,
    @SerializedName("categories")
    val categories: String? = null,
    @SerializedName("preview_listing")
    val previewListing: Boolean? = null,
    @SerializedName("public_notice")
    val publicNotice: String? = null,
    @SerializedName("additional_notices")
    val additionalNotices: ArrayList<String> = arrayListOf(),
    @SerializedName("image")
    val image: Image? = Image(),
    @SerializedName("country_origin")
    val countryOrigin: String? = null,
    @SerializedName("genesis_date")
    val genesisDate: String? = null,
    @SerializedName("sentiment_votes_up_percentage")
    val sentimentVotesUpPercentage: Double? = null,
    @SerializedName("sentiment_votes_down_percentage")
    val sentimentVotesDownPercentage: Double? = null,
    @SerializedName("watchlist_portfolio_users")
    val watchlistPortfolioUsers: Int? = null,
    @SerializedName("market_cap_rank")
    val marketCapRank: Int? = null,
    @SerializedName("market_data")
    val marketData: MarketData? = MarketData(),
    @SerializedName("status_updates")
    val statusUpdates: ArrayList<String> = arrayListOf(),
    @SerializedName("last_updated")
    val lastUpdated: String? = null,
)

data class Image(
    @SerializedName("thumb") val thumb: String? = null,
    @SerializedName("small") val small: String? = null,
    @SerializedName("large") val large: String? = null
)

data class MarketData(
    @SerializedName("current_price")
    val currentPrice: CurrentPrice? = CurrentPrice(),
)

data class CurrentPrice(
    @SerializedName("eur") val eur: Int? = null,
    @SerializedName("usd") val usd: Int? = null,
)