package ir.jalambadani.openalpr.controller;

import ir.jalambadani.openalpr.TestOpenALPR;
import ir.jalambadani.openalpr.alpr.response.AlprResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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
    
    
    
    
    @RequestMapping(value = "/detectByAlpr/{fileName}")
    public String detectResponse(@PathVariable(name = "fileName") String fileName) throws IOException {


        File file = new File(getClass().getResource("/static/assets/images").getFile());
        File[] files = file.listFiles();

        if(files == null) {
            return "file not found :D";
        }

        Optional < File > opF =
                Stream.of(
                        files
                ).filter(
                        e -> e.getName().equalsIgnoreCase( fileName )
                ).findFirst();

        if(opF.isPresent()){
            PredicateResponse answer = solve( opF.get() );
            answer.setFileName( fileName );
            return answer.getPredicateFirstTime();
        }else{
            return "file not found :D";
        }


    }


    public static int errorFunction(String real,String detected ){


        String r = real.replaceAll( "-" , "" );
        String d = detected.replaceAll( "-" , "" );


        int dif = 0;

        for ( int i = 0; i + 2 < r.length(); i++ ) {
            if(i >= d.length() || d.charAt( i ) != r.charAt( i )){
                dif++;
            }
        }

        return dif;
    }


    public static PredicateResponse solve(File imageFile) throws IOException {

        BufferedImage image = ImageIO.read(imageFile);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        byte [] firstByte = outputStream.toByteArray();

        AlprResponse predicate = TestOpenALPR.alpr( firstByte );


        String realLabel =
                imageFile.getName().replaceAll( "\\.jpg" , "" ).replaceAll( "\\*" , "" ) ;

        System.out.println("predicate for " + imageFile.getName() + "start...");
        PredicateResponse response = new PredicateResponse();
        response.setFileName( imageFile.getName() );
        response.setLabel( realLabel );

        if(predicate != null && predicate.getResults() != null){
            if( !predicate.getResults().isEmpty()) {
                response.setPredicateFirstTime( predicate.getResults().get( 0 ).getPlate() );
                response.setErrorPredicateFirst( errorFunction( realLabel, predicate.getResults().get( 0 ).getPlate()) );
            }

            if( predicate.getResults().size() > 1) {
                response.setPredicateSecondTime( predicate.getResults().get( 1 ).getPlate() );
                response.setErrorPredicateSecond( errorFunction( realLabel, predicate.getResults().get( 1 ).getPlate()) );
            }


        }

        System.out.println("finished predicate for \n" + imageFile.getName());

        return response;

    }


}
