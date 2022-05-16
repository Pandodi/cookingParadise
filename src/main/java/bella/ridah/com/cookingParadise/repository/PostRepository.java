package bella.ridah.com.cookingParadise.repository;

import bella.ridah.com.cookingParadise.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Long> {

    static void deletePostByID(Long id) {
    }

    static List<Post> findAllPosts() {
        return findAllPosts ();
    }


    Optional<Post> findById(Long id);

    Post save(Post post);


}










