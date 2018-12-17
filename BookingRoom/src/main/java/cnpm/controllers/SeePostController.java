package cnpm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cnpm.domain.Account;
import cnpm.domain.Post;
import cnpm.service.AccountService;
import cnpm.service.PostService;

@Controller
public class SeePostController {
	
	@Autowired
    private PostService postService;
	@Autowired
    private AccountService accountService;
	
	@RequestMapping("/seePost/{post_id}")
    public String seePost(@PathVariable int post_id, Model model) {
		Post post = postService.findById(post_id);
		Account account = accountService.findById(post.getUser_id());
		model.addAttribute(account);
		model.addAttribute("post", post);
	return "seePost";
    }
}
