package com.shaadi.assigenment

import com.google.gson.Gson
import com.shaadi.assigenment.data.model.ShaadiResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TestUtills {
    var string = "{\"results\":[{\"gender\":\"male\",\"name\":{\"title\":\"Mr\",\"first\":\"Elias\",\"last\":\"Gulli\"},\"location\":{\"street\":{\"number\":3092,\"name\":\"Hagan terrasse\"},\"city\":\"Roverud\",\"state\":\"Telemark\",\"country\":\"Norway\",\"postcode\":\"5268\",\"coordinates\":{\"latitude\":\"57.0318\",\"longitude\":\"-17.0255\"},\"timezone\":{\"offset\":\"-5:00\",\"description\":\"Eastern Time (US & Canada), Bogota, Lima\"}},\"email\":\"elias.gulli@example.com\",\"login\":{\"uuid\":\"34444ac8-eda6-45ed-a9c9-d685adc0ef70\",\"username\":\"silvermeercat854\",\"password\":\"michigan\",\"salt\":\"42Mxt523\",\"md5\":\"58605051ee59a251f383e211da89e94a\",\"sha1\":\"e45807bc7993ddfae0277e75f46a65e8313f150e\",\"sha256\":\"bbd6cf1c98e3d72a09d0264552cfc39044e57342acd0ed254a3436362a383346\"},\"dob\":{\"date\":\"1965-10-09T08:59:41.912Z\",\"age\":56},\"registered\":{\"date\":\"2011-04-14T13:53:11.353Z\",\"age\":10},\"phone\":\"68709940\",\"cell\":\"40815743\",\"id\":{\"name\":\"FN\",\"value\":\"09106543132\"},\"picture\":{\"large\":\"https://randomuser.me/api/portraits/men/33.jpg\",\"medium\":\"https://randomuser.me/api/portraits/med/men/33.jpg\",\"thumbnail\":\"https://randomuser.me/api/portraits/thumb/men/33.jpg\"},\"nat\":\"NO\"},{\"gender\":\"female\",\"name\":{\"title\":\"Ms\",\"first\":\"Louna\",\"last\":\"Leclerc\"},\"location\":{\"street\":{\"number\":728,\"name\":\"Rue des Ecrivains\"},\"city\":\"Saint-Pierre\",\"state\":\"Sarthe\",\"country\":\"France\",\"postcode\":36848,\"coordinates\":{\"latitude\":\"-23.0796\",\"longitude\":\"-159.1801\"},\"timezone\":{\"offset\":\"-10:00\",\"description\":\"Hawaii\"}},\"email\":\"louna.leclerc@example.com\",\"login\":{\"uuid\":\"c29b7429-8998-4e11-bdd4-7dcbd1f81d77\",\"username\":\"smallladybug543\",\"password\":\"addict\",\"salt\":\"EZXS2h9I\",\"md5\":\"50b165e5abe25ed07e2b96bd239dc240\",\"sha1\":\"e9de110c3cbc4c86d668fdc67e327ab130f2e0b6\",\"sha256\":\"0935d7416ed517000067bb9a23c97408eb76dea4589a76302a28ac766c1b1d68\"},\"dob\":{\"date\":\"1991-06-04T13:15:00.764Z\",\"age\":30},\"registered\":{\"date\":\"2014-07-03T06:09:19.521Z\",\"age\":7},\"phone\":\"01-03-03-97-24\",\"cell\":\"06-28-88-89-39\",\"id\":{\"name\":\"INSEE\",\"value\":\"2NNaN65575830 91\"},\"picture\":{\"large\":\"https://randomuser.me/api/portraits/women/75.jpg\",\"medium\":\"https://randomuser.me/api/portraits/med/women/75.jpg\",\"thumbnail\":\"https://randomuser.me/api/portraits/thumb/women/75.jpg\"},\"nat\":\"FR\"}],\"info\":{\"seed\":\"35bcb0539d46507d\",\"results\":10,\"page\":1,\"version\":\"1.3\"}}"

    fun getArticles(): ShaadiResponse? {
        return Gson().fromJson(string, ShaadiResponse::class.java)
    }


    private fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    fun buildRetrofit(): Retrofit? {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient())
            .build()
    }

}