package ghsearch.luis

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.io.Serializable

/*
* Created by Luis Souza on November 25, 2019
*/

// region REST API Interface
interface RestApi {
    @GET("users?")
    fun getUserData(@Query("q") searchName: String, @Query("per_page") perPage: Int):
            Call<ResponseDataClass>
}
// endregion

data class ResponseDataClass(
    val incomplete_results: Boolean = false,
    val items: ArrayList<User>,
    val total_count: Int = 0
) : Serializable

data class User(
    val avatar_url: String = "",
    val events_url: String = "",
    val followers_url: String = "",
    val following_url: String = "",
    val gists_url: String = "",
    val gravatar_id: String = "",
    val html_url: String = "",
    val id: Int = 0,
    val login: String = "",
    val node_id: String = "",
    val organizations_url: String = "",
    val received_events_url: String = "",
    val repos_url: String = "",
    val score: Double = 0.0,
    val site_admin: Boolean = false,
    val starred_url: String = "",
    val subscriptions_url: String = "",
    val type: String = "",
    val url: String = ""
) : Serializable

data class UserDetails(
    val avatar_url: String = "",
    val bio: String? = "",
    val blog: String? = "",
    val company: String? = "",
    val created_at: String = "",
    val email: String? = "",
    val events_url: String = "",
    val followers: Int = 0,
    val followers_url: String = "",
    val following: Int = 0,
    val following_url: String = "",
    val gists_url: String = "",
    val gravatar_id: String = "",
    val hireable: String? = "",
    val html_url: String = "",
    val id: Int = 0,
    val location: String? = "",
    val login: String = "",
    val name: String? = "",
    val node_id: String = "",
    val organizations_url: String = "",
    val public_gists: Int = 0,
    val public_repos: Int = 0,
    val received_events_url: String = "",
    val repos_url: String = "",
    val site_admin: Boolean = false,
    val starred_url: String = "",
    val subscriptions_url: String = "",
    val type: String = "",
    val updated_at: String = "",
    val url: String = ""
)