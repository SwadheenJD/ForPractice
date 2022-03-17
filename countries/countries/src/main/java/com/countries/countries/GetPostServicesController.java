package com.countries.countries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class GetPostServicesController {
	static ArrayList<String> al1 =new ArrayList<String>(Arrays.asList("America", "Bangladesh", "China","Denmark","Estonia","Finland","Ethopia","Hong kong","India","Japan","Kenya","Libya","Norway","Oman","Pakistan","Nepal","Russia","Switzerland","Taiwan","Uganda","Vetican city","England","West Indies","Yaman","Argentina","Portugal","Sri Lanka","Afganistan","Mexico","Myanmar","Iran"));
	 
	@GetMapping("/getCountryList")
    public ResponseEntity<ArrayList> getBranchIndusDtls(
            Model model,
            @RequestParam(value = "pageId" ) Integer pageId,
            @RequestParam(value = "offsetId") Integer offsetId,
            @RequestParam(value = "searchingFor") String searchingFor
            )
             {
		System.out.println("in getCountryList method ->>>>"+ pageId +"->>>"+ offsetId);
		//ArrayList<String> al1 =new ArrayList<String>(Arrays.asList("A", "B", "C","D","E","F","G","H","I","J","K","L","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","qqq"));
		
		ArrayList<String> al2 =new ArrayList<String>(5);
		//al2.get(0).contains("abc");
		for (int i = 0; i < al1.size(); i++)
		 {
	           
		
		 
	            if(al1.get(i).contains(searchingFor))
	            {
	            	
	            	al2.add(al1.get(i));
	            	
	            }
				/*
				 * else { System.out.println("in else condition "); response =new
				 * ResponseEntity(al2,HttpStatus.OK); System.out.println(al2); }
				 */
		 }
		
		System.out.println(al2);
		
		ArrayList<String> al3= new ArrayList<>(5);
		
		int n=pageId*offsetId;
		int num=0;
		int i=0;
		ResponseEntity<ArrayList> response=null;
		 for ( i = n; i < al2.size()-1; i++)
		 {
	           
		 System.out.println("value of n ->>>>>"+n +"value of i is ->>>>> "+i);
		 
	            if(num<5)
	            {
	            	num++;
	            	System.out.println("in if condition " + num);
	            	al3.add(al2.get(i));
	            	response =new ResponseEntity(al3,HttpStatus.OK); System.out.println(al3);
	            }
				/*
				 * else { System.out.println("in else condition "); response =new
				 * ResponseEntity(al2,HttpStatus.OK); System.out.println(al2); }
				 */
		 }
		 System.out.println(response);
	            return response; 
             }
	
	@PostMapping("/addCountry")
    public ResponseEntity<ResponseDTO> getBranchIndusDtls(
            @RequestParam(value = "countryName" ) String countryName
            )
             {
		ResponseEntity<ResponseDTO> response=null;
		
		int count =0;
		
		ListIterator<String> itr = al1.listIterator();
        while (itr.hasNext())
        {
        	
            String x = itr.next();
            if (x.equals(countryName) || x==countryName)
            {
            	System.out.println("Duplicate you are adding");
            	count=1;
            	ResponseDTO responseDTO = new ResponseDTO ("Duplicate you are adding showing list as previous", al1);
            	response=new ResponseEntity(responseDTO,HttpStatus.CONFLICT);
            }
            
        
        }
        if (count==0)
        {
        	itr.add(countryName);
        	ResponseDTO responseDTO = new ResponseDTO ("Added Successfully showing updated list", al1);
        	response=new ResponseEntity(responseDTO,HttpStatus.ACCEPTED);
        }
        
       
	 return response;

}
}
