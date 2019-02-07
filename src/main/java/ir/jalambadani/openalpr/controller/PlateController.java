package ir.jalambadani.openalpr.controller;

import ir.jalambadani.openalpr.alpr.response.Coordinate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by: Morteza
 * company: mobin
 * package: ir.jalambadani.openalpr.controller
 * project name:  openalpr
 * 02 February 2019
 **/



@Controller
public class PlateController {

    @RequestMapping(value = {"/plateList" , "/" , "index" })
    public String plateList(Model model){


        File file = new File(getClass().getResource("/static/assets/images").getFile());
        File[] files = file.listFiles();


        List<String> name = new ArrayList <>(  );
        for(File f : files){
            String n = f.getName();
            name.add( n);
        }
        model.addAttribute( "names" , name );
        return "list_files";

    }


    @RequestMapping(value = {"/result/{morteza}" , "/result" })
    public String result(Model model, @PathVariable(required = false, name = "morteza") String morteza){


        List < PredicateResponse > result ;
        if("mortezaj8".equals( morteza )){
            File file = new File(getClass().getResource("/static/assets/images").getFile());
            File[] files = file.listFiles();

            result = Stream.of( files ).map( f -> {
                try {
                    return DetectPlateController.solve( f );
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            } ).collect( Collectors.toList() );



            writeObjectToFile( result , "history.mj8" );


        }else{
            result =
                    readObjectFromFile( "history.mj8" );
        }

        long success = result.stream().filter( t -> t != null && (t.getErrorPredicateFirst() == 0 || t.getErrorPredicateSecond() == 0) ).count();
        long failed  = result.stream().filter( t -> t == null || (t.getErrorPredicateFirst() != 0 && t.getErrorPredicateSecond() != 0) ).count();


        model.addAttribute( "success" , success );
        model.addAttribute( "failed" , failed );
        model.addAttribute( "result" , result );




        return "diagram";

    }


    @RequestMapping(value = {"/area/{fileName}"})
    public String area(Model model, @PathVariable(name = "fileName") String filepath) throws IOException {

        File file = new File(getClass().getResource("/static/assets/images").getFile());
        File[] files = file.listFiles();

        if(files == null) {
            return "file not found :D";
        }

        Optional< File > opF =
                Stream.of(
                        files
                ).filter(
                        e -> e.getName().equalsIgnoreCase( filepath )
                ).findFirst();

        if(opF.isPresent()){
            List < PredicateResponse > list = readObjectFromFile( "history.mj8" );
            PredicateResponse response = list.stream().filter( r -> r.getFileName().equals( filepath ) ).findFirst().get();
            byte[] image = extractBytes( opF.get(), response );
            model.addAttribute( "picture" , base64Image(image) );
        }else{
            return "file not found :D";
        }


        return "plateArea";




    }

    public byte[] extractBytes(File imgPath, PredicateResponse response) throws IOException {
        // open image
        final BufferedImage image = ImageIO.read(imgPath);


        final Graphics2D graphic = image.createGraphics();
        if(response.getErrorPredicateFirst() != -1){

            Polygon polygon = new Polygon(
                    response.getFirstArea().stream().mapToInt( Coordinate::getX ).toArray() ,
                    response.getFirstArea().stream().mapToInt( Coordinate::getY ).toArray() ,
                    response.getFirstArea().size()
            );
            graphic.setStroke( new BasicStroke( 5 ));
            graphic.setColor( Color.RED );
            graphic.drawPolygon(
                    polygon

            );



        }

        if(response.getErrorPredicateSecond() != -1){

            Polygon polygon = new Polygon(
                    response.getSecondArea().stream().mapToInt( Coordinate::getX ).toArray() ,
                    response.getSecondArea().stream().mapToInt( Coordinate::getY ).toArray() ,
                    response.getSecondArea().size()
            );
            graphic.setStroke( new BasicStroke( 5 ));
            graphic.setColor( Color.BLACK );
            graphic.drawPolygon(
                    polygon

            );



        }


        graphic.dispose();

        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);

        return outputStream.toByteArray();




    }

    public String base64Image(byte [] image){
        return Base64Utils.encodeToString( image );
    }


    private void writeObjectToFile(List<PredicateResponse> serObj , String filepath) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was successfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private List<PredicateResponse>  readObjectFromFile(String filepath) {

        List<PredicateResponse> value = new ArrayList <>(  );
        try {

            FileInputStream fileOut = new FileInputStream(filepath);
            ObjectInputStream objectOut = new ObjectInputStream(fileOut);
            value = (List < PredicateResponse >) objectOut.readObject();
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return value;
    }


}
