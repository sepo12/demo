package com.ATM.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

    @Controller
    public class AtmController{
        
        @Resource
        private AtmManager atmManager;

        @PostMapping("/login")
        @ResponseBody
        public Map<String,Object> authenticateUser(HttpServletRequest formData){
        
       return atmManager.authenticateUsers(formData);
     
      
        }

        @PostMapping("/signUp")
        @ResponseBody
        public Map<String,Object> signUpUser(HttpServletRequest formData){

         return  atmManager.createUserAccount(formData) ;
          
        }
        
        @GetMapping("/getCurrentUser")
        public String getExistingUser( @RequestParam (name = "id")Long id ,ModelMap map){

          AtmModal currentUser =  atmManager.getExistingUser(id);
            
            map.addAttribute("currentUser",currentUser);
            return "/home";

        }


        @PostMapping("/deposit")
        @ResponseBody
        public Map<String,Object> depositAmount (HttpServletRequest request){
          return  atmManager.saveAmount(request);
          
        }

        public Map<String,Object> withdrawAmount(HttpServletRequest request){

            Map<String,Object> response = new HashMap<>();

            atmManager.withdrawAmount(request);

            return response;

        }

    }