package com.saahayak.saahayak.Interface;

import com.saahayak.saahayak.response.AllBookingDetailPojo;
import com.saahayak.saahayak.response.AllServicePojo;
import com.saahayak.saahayak.response.BannerVedioPojo;
import com.saahayak.saahayak.response.BookingPojo;
import com.saahayak.saahayak.response.CarWashingCategoriesPojo;
import com.saahayak.saahayak.response.CarWashingSegmentPojo;
import com.saahayak.saahayak.response.CarWashingServicePackPojo;
import com.saahayak.saahayak.response.GetCartDetailPojo;
import com.saahayak.saahayak.response.HotDealPojo;
import com.saahayak.saahayak.response.PaymentPojo;
import com.saahayak.saahayak.response.PopularServicePojo;
import com.saahayak.saahayak.response.RegisterPojo;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface SAAHAYAKInterface {
    @FormUrlEncoded
    @POST("register")
    Call<RegisterPojo> register(@Field("phone") String phone, @Field("reg_id") String reg_id, @Field("device_type") String device_type, @Field("country_code") String country_code);

    @FormUrlEncoded
    @POST("otp_match")
    Call<RegisterPojo> matchotp(@Field("otp") String otp, @Field("phone") String phone, @Field("country_code") String country_code);

    @FormUrlEncoded
    @POST("resendOtp")
    Call<RegisterPojo> resendOtp(@Field("phone") String phone, @Field("country_code") String country_code);

    @FormUrlEncoded
    @POST("user_info")
    Call<RegisterPojo> userInfo(@Field("name") String name, @Field("email") String email, @Field("address") String address, @Field("id") String id);

    @FormUrlEncoded
    @POST("user_info")
    Call<RegisterPojo> userInfoPassword(@Field("id") String id, @Field("password") String password);

    @FormUrlEncoded
    @POST("login")
    Call<RegisterPojo> userLogin(@Field("phone") String phone, @Field("reg_id") String reg_id, @Field("device_type") String device_type, @Field("country_code") String country_code, @Field("password") String password);

    @Multipart
    @POST("user_info")
    Call<RegisterPojo> updateUserInfo(@Part("name") RequestBody name, @Part("email") RequestBody email, @Part("address") RequestBody address, @Part("id") RequestBody id, @Part MultipartBody.Part image);

    @GET("jugaar_list")
    Call<AllServicePojo> JugaarList();

    @GET("popular")
    Call<PopularServicePojo> PopularList();

    @GET("video")
    Call<BannerVedioPojo> VedioList();

    @GET("getDeals")
    Call<HotDealPojo> HotDealList();

    @FormUrlEncoded
    @POST("category")
    Call<CarWashingCategoriesPojo> CarWashingCategory(@Field("service_id") String service_id);

    @FormUrlEncoded
    @POST("segments")
    Call<CarWashingSegmentPojo> CarWashingSegment(@Field("cat_id") String cat_id);

    @FormUrlEncoded
    @POST("packages")
    Call<CarWashingServicePackPojo> CarWashingServicePack(@Field("subcat_id") String subcat_id);

    @FormUrlEncoded
    @POST("booking")
    Call<BookingPojo> Booking(@Field("user_id") String user_id, @Field("service_id") String service_id, @Field("category_id") String category_id, @Field("subcat_id") String subcat_id, @Field("package_id") String package_id, @Field("date") String date, @Field("phone") String phone, @Field("address") String address, @Field("country_code") String country_code, @Field("comment") String comment, @Field("price") String price);

    @FormUrlEncoded
    @POST("getBooking")
    Call<AllBookingDetailPojo> AllBookingDetail(@Field("user_id") String user_id, @Field("status") String status);

    @FormUrlEncoded
    @POST("getUserDetails")
    Call<RegisterPojo> UserDetail(@Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("addToCart")
    Call<Map> AddCart(@Field("user_id") String user_id, @Field("service_id") String service_id, @Field("cat_id") String cat_id, @Field("subcat_id") String subcat_id, @Field("package_id") String package_id, @Field("price") String price);

    @FormUrlEncoded
    @POST("getCart")
    Call<GetCartDetailPojo> GetCartDetail(@Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("delete_cart")
    Call<Map> DeleteCart(@Field("cart_id") String cart_id);

    @FormUrlEncoded
    @POST("orderIdGenerate")
    Call<PaymentPojo> OrderId(@Field("amount") String amount);

    @FormUrlEncoded
    @POST("checkPaymentVerificationStatus")
    Call<Map> PaymentStatus(@Field("razorpay_order_id") String razorpay_order_id,@Field("razorpay_payment_id") String razorpay_payment_id,@Field("razorpay_signature") String razorpay_signature,@Field("booking_id") String booking_id);


}
