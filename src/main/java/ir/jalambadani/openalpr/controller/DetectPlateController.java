package ir.jalambadani.openalpr.controller;

import ir.jalambadani.openalpr.alpr.AlprRetrofitFactory;
import ir.jalambadani.openalpr.alpr.response.AlprResponse;
import ir.jalambadani.openalpr.alpr.response.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * created by: Morteza
 * company: mobin
 * package: ir.jalambadani.openalpr.controller
 * project name:  openalpr
 * 02 February 2019
 **/



@RestController
public class DetectPlateController {


    private static final String SERVER_IP = "http://198.143.180.238:4238";

    @RequestMapping(value = "/detectByAlpr/{fileName}")
    public String detectResponse(@PathVariable(name = "fileName") String fileName) throws IOException {


        File file = new File(getClass().getResource("/static/assets/images").getFile());
        File[] files = file.listFiles();

        if(files == null) {
            return "file not found :D";
        }

        Optional < File > opF = Stream.of( files ).filter( e -> e.getName().equalsIgnoreCase( fileName ) ).findFirst();

        if(opF.isPresent()){

            String pathImage = SERVER_IP + "/assets/images/" + fileName;
            System.out.println("pathImage: " + pathImage);
            Call<AlprResponse> call = AlprRetrofitFactory.getInstance().getAlprEndPoint().recognizeUrl(
                    pathImage,
                    "sk_dd8db7eda4946b1815948b6c",
                    "eu",
                    0,
                    "",
                    0,
                    10,
                    ""
            );

            Response<AlprResponse> responseBody = call.execute();

            if(responseBody.isSuccessful()){

                List<Result> result = responseBody.body().getResults();
                if(result != null && !result.isEmpty()){
                    return
                            "real label: " + fileName.replaceAll("\\*" , "").replaceAll("\\.jpg" , "") + "\n" +
                            "detected plate: " + result.get(0).getPlate() + "\n" ;
                }else{
                    return "plate not detect by alpr";
                }

            }else{
                return "error in connect to alpr, http request code: " + responseBody.code();
            }


        }else{
            return "file not found :D";
        }



    }



}
