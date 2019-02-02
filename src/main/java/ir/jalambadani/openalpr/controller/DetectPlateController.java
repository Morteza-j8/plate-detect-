package ir.jalambadani.openalpr.controller;

import ir.jalambadani.openalpr.TestOpenALPR;
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

        Optional < File > opF = Stream.of( files ).filter( e -> e.getName().equalsIgnoreCase( fileName ) ).findFirst();

        if(opF.isPresent()){
            File mF = opF.get();
            BufferedImage bImage = ImageIO.read(mF);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos );
            byte [] mData = bos.toByteArray();
            String label = TestOpenALPR.alpr( mData );
            return label;
        }else{
            return "file not found :D";
        }



    }



}
