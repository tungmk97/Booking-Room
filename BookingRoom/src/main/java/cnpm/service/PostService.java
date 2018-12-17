package cnpm.service;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestDataBinder;

import cnpm.domain.Account;
import cnpm.domain.Post;
import cnpm.repository.PostRepository;

@Service
@Transactional
public class PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
	
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findById(final int post_id) {
		return postRepository.findById(post_id);
	}

	public void save(final Post post, Principal principal) {
		// check if exist -> throw exception
		Account account = userDetailsServiceImpl.findByUsername(principal.getName());
		Post newPost = new Post();
		newPost.setPost_id(post.getPost_id());
		newPost.setTitle(post.getTitle());
		newPost.setAcreage(post.getAcreage());
		newPost.setAddress(post.getAddress());
		newPost.setProvinceid(post.getProvinceid());
		newPost.setDistrictid(post.getDistrictid());
		newPost.setWardid(post.getWardid());
		newPost.setVillageid(post.getVillageid());
		newPost.setDescription(post.getDescription());
		newPost.setPrice(post.getPrice());
		newPost.setUser_id(account.getUser_id());
		newPost.setStatus_id(1);
		newPost.setStart_date(post.getStart_date());
		Date finalStartDate = null;
		Date finalEndDate = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
		    finalStartDate = df.parse(df.format(post.getStart_date()));
		    finalEndDate = df.parse(df.format(post.getEnd_date()));
		} catch (ParseException pe) {
		    System.out.println("ParserException while attempting to establish date");
		}
		newPost.setStart_date(finalStartDate);
		newPost.setEnd_date(finalEndDate);
		postRepository.persist(newPost);
	}

	public void update(final Post post) {
		// check if not exist -> throw excpetion
		Post postDb = postRepository.findById(post.getPost_id());
		postDb.setPost_id(post.getPost_id());
		postDb.setTitle(post.getTitle());
		postDb.setAcreage(post.getAcreage());
		postDb.setAddress(post.getAddress());
		postDb.setProvinceid(post.getProvinceid());
		postDb.setDistrictid(post.getDistrictid());
		postDb.setWardid(post.getWardid());
		postDb.setVillageid(post.getVillageid());
		postDb.setDescription(post.getDescription());
		postDb.setPrice(post.getPrice());
		postDb.setStatus_id(1);
		Date finalStartDate = null;
		Date finalEndDate = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
		    finalStartDate = df.parse(df.format(post.getStart_date()));
		    finalEndDate = df.parse(df.format(post.getEnd_date()));
		} catch (ParseException pe) {
		    System.out.println("ParserException while attempting to establish date");
		}
		postDb.setStart_date(finalStartDate);
		postDb.setEnd_date(finalEndDate);
		postRepository.persist(postDb);
	}

	public void delete(final int post_id) {
		Post post = postRepository.findById(post_id);
		if (post != null) {
			postRepository.delete(post);
		}
	}
	public void getTime() {
		
	}
}
