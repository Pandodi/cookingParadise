package bella.ridah.com.cookingParadise.dao;

import bella.ridah.com.cookingParadise.model.Post;
import bella.ridah.com.cookingParadise.repository.PostRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PostDAO {
    static PostRepository postRepository;

    public PostDAO(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public List<Post> getAllPosts() {
        return postRepository.findAll ();
    }
    public static Post savePost(Post post){
        return postRepository.save (post);
    }

    public static Post getPostByID(Long id){
        return postRepository.findById(id).get();
    }

    public static Post deletePostByID(Long id){
       return postRepository.deletePostById(id);
    }


}