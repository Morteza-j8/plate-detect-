package ir.jalambadani.openalpr.alpr;

import ir.jalambadani.openalpr.alpr.response.AlprResponse;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * created by: Morteza
 * company: Mobin Tabaran
 * project name:  Plate Detect
 * 3 Feb 2019
 **/
public interface AlprEndPoint {


    /**

     <a href'"http://doc.openalpr.com/api/?api=cloudapi#/default/recognizeUrl>Document is here</a>

     image_url
     string
     (query)


     A URL to an image that you wish to analyze
     secret_key *
     string
     (query)


     The secret key used to authenticate your account. You can view your
     secret key by visiting
     https://cloud.openalpr.com/
     recognize_vehicle
     integer
     (query)


     If set to 1, the vehicle will also be recognized in the image
     This requires an additional credit per request

     Default value : 0
     country *
     string
     (query)


     Defines the training data used by OpenALPR. “us” analyzes
     North-American style plates. “eu” analyzes European-style plates.

     This field is required if using the “plate” task
     state
     string
     (query)


     Corresponds to a US state or EU country code used by OpenALPR pattern
     recognition. For example, using “md” matches US plates against the
     Maryland plate patterns. Using “fr” matches European plates against
     the French plate patterns.

     Default value :
     return_image
     integer
     (query)


     If set to 1, the image you uploaded will be encoded in base64 and
     sent back along with the response

     Default value : 0
     topn
     integer
     (query)


     The number of results you would like to be returned for plate
     candidates and vehicle classifications

     Default value : 10
     prewarp
     string
     (query)


     Prewarp configuration is used to calibrate the analyses for the
     angle of a particular camera. More information is available here
     http://doc.openalpr.com/accuracy_improvements.html#calibration

     Default value :

     */

    @Headers({
            "Content-Type: application/json" ,
    })
    @POST("recognize_url")
    Call<AlprResponse> recognizeUrl(
            @Query("image_url") String imageUrl,
            @Query("secret_key") String secretKey,
            @Query("country") String country,
            @Query("recognize_vehicle") int recognizeVehicle,
            @Query("state") String state,
            @Query("return_image") int returnImage,
            @Query("topn") int topn,
            @Query("prewarp") String prewarp
    );





}
