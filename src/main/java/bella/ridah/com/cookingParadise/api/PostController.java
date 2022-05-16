package bella.ridah.com.cookingParadise.api;

import bella.ridah.com.cookingParadise.model.Post;
import bella.ridah.com.cookingParadise.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String listPost(Model model) {
        model.addAttribute("post", postService.getAllPosts());
        return "post";
    }

    @GetMapping("/newPost")
    public String createPostForm(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "create_post";
    }

    @PostMapping("/")
    public String addPost(@ModelAttribute("post") Post post){
        postService.addPost(post);
        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable Long id, Model model){
        model.addAttribute("PostDAO", postService.getPostByID(id));
        return "post";
    }

    @GetMapping ("/{id}")
    public String deletePost(@PathVariable Long id){
        postService.deletePostByID(id);
        return "redirect:/";
    }
}