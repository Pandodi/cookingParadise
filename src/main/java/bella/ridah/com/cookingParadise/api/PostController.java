package bella.ridah.com.cookingParadise.api;

import bella.ridah.com.cookingParadise.dao.PostDAO;
import bella.ridah.com.cookingParadise.model.Post;
import bella.ridah.com.cookingParadise.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String listPost(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "posts";
    }

    @RequestMapping("/create")
    public String createPostForm(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "create_post";
    }

    @PostMapping("/")
    public String addPost(@ModelAttribute("post") Post post){
        postService.addPost (post);
        return "redirect:/";
    }



    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable Long id, Model model){
        model.addAttribute("post", postService.getPostById(id));
        return "post";
    }

    @GetMapping ("/{id}")
    public String deletePost(@PathVariable Long id){
        postService.deletePostByID(id);
        return "redirect:/";
    }
}