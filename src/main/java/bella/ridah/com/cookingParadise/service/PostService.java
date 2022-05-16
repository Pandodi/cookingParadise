package bella.ridah.com.cookingParadise.service;

import bella.ridah.com.cookingParadise.dao.PostDAO;
import bella.ridah.com.cookingParadise.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


@Service
public class PostService {

    PostDAO postDAO;

    public PostService(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public List<Post> getAllPosts(){
        return postDAO.getAllPosts();
    }

    public Post addPost (Post post) {
        return postDAO.savePost(post);
    }


    public Post getPostById(Long id) {
        return postDAO.getPostByID (id);
    }

    public void deletePostByID(Long id){
        postDAO.deletePostByID (id);
    }

}