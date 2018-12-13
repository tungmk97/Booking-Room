package cnpm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cnpm.domain.Post;
import cnpm.service.ErrorServiceImp;
import cnpm.service.PostService;
import cnpm.service.UserDetailsServiceImpl;

@Controller
public class PostNewsController {
	@Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value= {"/", "post-list"})
	public String listPost(Model model) {
		model.addAttribute("listPost", postService.findAll());
		return "post-list";
	}
	
	@RequestMapping("/post-save")
		public String insertPost(Model model) {
			model.addAttribute("post", new Post());
			return "post-save";
		}
	
	@RequestMapping("/post-view/{id-post}")
	public String viewPost(@PathVariable int id_post, Model model) {
		Post post = postService.findById(id_post);
		model.addAttribute("post", post);
		return "post-view";
	}
	
	@RequestMapping("/post-update/{id_post}")
	public String updatePost(@PathVariable int id_post, Model model) {
		Post post = postService.findById(id_post);
		model.addAttribute("post", post);
		return "post-update";
	}
	
	@RequestMapping("/savePost")
	public String doSavePost(@ModelAttribute("Post") Post post, Model model) {
		postService.save(post);
		model.addAttribute("listPost", postService.findAll());
		return "post-list";
	}
	
//	@RequestMapping("/updatePost")
//	public String doUpdatePost(@ModelAttribute("Post") Post post, Model model) {
//		postService.update(post);
//		model.addAttribute("listPost", postService.findAll());
//		return "post-list";
//	}
	
	@RequestMapping("postDelete/{id_post}")
	public String doDeletePost(@PathVariable int id_post, Model model) {
		postService.delete(id_post);
		model.addAttribute("listPost", postService.findAll());
		return "post-list";
	}
	
	@RequestMapping(value="/index")
    public String index(Model model) {
        model.addAttribute("listPost", postService.findAll());
        return "index";
    }
	
	@Autowired
	private ErrorServiceImp errorServiceImp;
	

    
    @RequestMapping("/403")
    public String accessDenied(Model model) {
        model.addAttribute("error", errorServiceImp.getOne("403"));
        return "errors";
    }
	
//	@RequestMapping("/postNews")
//    public String postNews() {
//	return "postNews";
//    }
//	
//	@RequestMapping("/")
//    public String index(Model model) {
//        model.addAttribute("listPost", postService.findAll());
//        return "redirect:/index";
//    }
	
	
}
