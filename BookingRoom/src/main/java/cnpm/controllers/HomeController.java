package cnpm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cnpm.service.AccountService;
import cnpm.service.PostService;

@Controller
public class HomeController {
	@Autowired
	PostService postService;
	@Autowired
    private AccountService accountService;
	
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(Model model){
    	model.addAttribute("postsLimit6", postService.findAllLimit6());
    	model.addAttribute("postsLimit2", postService.findAllLimit2());
    	model.addAttribute("listAccount", accountService.findAll());
        return "index";
    }
    
    @RequestMapping(value="/seeNews", method = RequestMethod.GET)
    public String seeNews(Model model){
    	model.addAttribute("postsLimit6", postService.findAllLimit6());
    	model.addAttribute("postsLimit2", postService.findAllLimit2());
    	model.addAttribute("listAccount", accountService.findAll());
        return "seeNews";
    }
}
