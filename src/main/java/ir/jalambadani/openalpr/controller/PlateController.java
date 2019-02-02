package ir.jalambadani.openalpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * created by: Morteza
 * company: mobin
 * package: ir.jalambadani.openalpr.controller
 * project name:  openalpr
 * 02 February 2019
 **/



@Controller
public class PlateController {

    @RequestMapping(value = "/plateList")
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


}
