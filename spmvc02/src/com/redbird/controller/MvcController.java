package com.redbird.controller;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.redbird.pojo.Person;

@Controller
@RequestMapping("/mvc")
public class MvcController {

	@RequestMapping("/hello")
	public String helloWorld() {
		return "hello";
	}
	
	//boxing automatically
	@RequestMapping("/person1")
	public String toPerson(Person p){
	    System.out.println(p.getName()+" "+p.getAge());
	    return "hello";
	}
	
	//pass the parameters to front-end,向前台传递参数
	@RequestMapping("/show")
	public String showPerson(Map<String,Object> map){
	    Person p =new Person();
	    p.setAge(20);
	    p.setName("jayjay");
	    
	    Person p1 =new Person();
	    p1.setAge(28);
	    p1.setName("zhang san");
	    
	    map.put("p", p);
	    map.put("p1", p1);
	    return "show";
	}
	
	//redirect 
	@RequestMapping("/redirect")
	public String redirect(){
	    return "redirect:hello";
	}
	
	/**
	 * 文件上传
	 * @return
	 */
	@RequestMapping("/uploadFile")
	public String uploadFile(){
	    return "upload_file";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(HttpServletRequest req) throws Exception{
	    MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)req;
	    MultipartFile file = mreq.getFile("file");
	    String fileName = file.getOriginalFilename();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");        
	    FileOutputStream fos = new FileOutputStream(req.getSession().getServletContext().getRealPath("/")+
	            "upload/"+sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.')));
	    fos.write(file.getBytes());
	    fos.flush();
	    fos.close();
	     
	    return "hello";
	}
}
