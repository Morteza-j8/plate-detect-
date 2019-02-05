package ir.jalambadani.openalpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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


    @RequestMapping(value = {"/result/{morteza}" })
    public String result(Model model, @PathVariable(name = "morteza") String morteza){


        if("mortezaj8".equals( morteza )){
            File file = new File(getClass().getResource("/static/assets/images").getFile());
            File[] files = file.listFiles();

            List < PredicateResponse > result = Stream.of( files ).map( f -> {
                try {
                    return DetectPlateController.solve( f );
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            } ).collect( Collectors.toList() );


            long success = result.stream().filter( t -> t != null && (t.getErrorPredicateFirst() == 0 || t.getErrorPredicateSecond() == 0) ).count();
            long failed  = result.stream().filter( t -> t == null || (t.getErrorPredicateFirst() != 0 && t.getErrorPredicateSecond() != 0) ).count();


            model.addAttribute( "success" , success );
            model.addAttribute( "failed" , failed );
            model.addAttribute( "result" , result );


        }




        return "diagram";

    }


}
