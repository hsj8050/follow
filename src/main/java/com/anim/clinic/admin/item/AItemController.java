package com.anim.clinic.admin.item;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anim.clinic.admin.item.biz.AItemService;


@Controller
public class AItemController {
	@Autowired
	AItemService aItemService;
	
	@RequestMapping(value="/admin/create", method = RequestMethod.GET)
	public ModelAndView create() {
	    return new ModelAndView("/admin/create");
	}
	
	@RequestMapping(value = "/admin/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
	    ModelAndView mav = new ModelAndView();

	    String itemCode = this.aItemService.create(map);
	    if (itemCode == null) {
	        mav.setViewName("redirect:/admin/create");
	    }else {
	    	System.out.println("itemCode´Â " + itemCode);
	        mav.setViewName("redirect:/admin/detail?itemCode=" + itemCode); 
	    }  

	    return mav;
	}

	
}
