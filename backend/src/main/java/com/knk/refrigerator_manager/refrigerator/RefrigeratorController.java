package com.knk.refrigerator_manager.refrigerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/refrigerator")
public class RefrigeratorController {
    private RefrigeratorService refrigeratorService;
    @Autowired
    public void setRefrigeratorService(RefrigeratorService refrigeratorService){
        this.refrigeratorService = refrigeratorService;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<List<Refrigerator>> getAllUsers(){
//        String errors = "no errors";
//        List<Refrigerator> refrigerators = null;
//        try{
//            refrigerators = refrigeratorService.findAll();
//        } catch (final Exception e){
//            errors = e.getMessage();
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(refrigerators);
//    }

    @PatchMapping("/api/{refriName}")
    public ResponseEntity<Long> changeRefriName(@PathVariable String refriName){
        return ResponseEntity.ok().body(refrigeratorService.patchUpdate(refriName));
    }
}
