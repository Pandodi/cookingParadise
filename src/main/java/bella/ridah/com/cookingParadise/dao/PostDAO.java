package bella.ridah.com.cookingParadise.dao;

import bella.ridah.com.cookingParadise.model.Post;
import bella.ridah.com.cookingParadise.repository.PostRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PostDAO {
     PostRepository postRepository;

    public PostDAO(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public List<Post> getAllPosts() {
        return postRepository.findAll ();
    }
    public  Post savePost(Post post){
        return postRepository.save(post);
    }

    public Post getPostByID(Long id){
        return postRepository.findById(id).get();
    }

    public void deletePostByID(Long id){
        postRepository.deleteById (id);
    }


}