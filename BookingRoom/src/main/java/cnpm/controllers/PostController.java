package cnpm.controllers;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cnpm.domain.Account;
import cnpm.domain.Post;
import cnpm.service.AccountService;
import cnpm.service.ErrorServiceImp;
import cnpm.service.PostService;
import cnpm.service.UserDetailsServiceImpl;

@Controller
public class PostController {
	@Autowired
    private PostService postService;
	@Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
    private AccountService accountService;
	
	@RequestMapping("/postNews")
    public String postNews(Model model) {
		model.addAttribute("post", new Post());
	return "postNews";
    }
	
	@RequestMapping(value= "/savePost", method = RequestMethod.POST)
	public String doSavePost(Model model, @ModelAttribute("post") Post post, Principal principal) {
		
		try {
			postService.save(post, principal);
			model.addAttribute("posts", postService.findAll());
		}
	     // Other error!!
	        catch (Exception e) {
	        	model.addAttribute("errorMessage", "Error: " + e.getMessage());
	            return "postNews";
	        }
		Account account = userDetailsServiceImpl.findByUsername(principal.getName());
		model.addAttribute("account", account);
		model.addAttribute("accounts", accountService.findAll());
//		return "list-post";
		return "index";
	}
	
	@RequestMapping("/postDelete/{post_id}")
	public String doDeleteAccount(@PathVariable int post_id, Model model) {
		postService.delete(post_id);
		model.addAttribute("posts", postService.findAll());
		return "index";
	}
    
    @RequestMapping("/post-update/{post_id}")
	public String updateCustomer(@PathVariable int post_id, Model model) {
    	Post post = postService.findById(post_id);
		model.addAttribute("post", post);
		return "edit-post";
	}
    
    @RequestMapping("/updatePost")
	public String doUpdateAccount(@ModelAttribute("post") Post post, Model model) {
    	postService.update(post);
		model.addAttribute("listPost", postService.findAll());
		return "index";
	}
}
