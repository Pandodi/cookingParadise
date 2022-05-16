package Service;

import bella.ridah.com.cookingParadise.dao.PostDAO;
import bella.ridah.com.cookingParadise.model.Post;
import bella.ridah.com.cookingParadise.service.PostService;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

class PostServiceTest extends MockitoExtension {

    static PostDAO postDAO;
    static PostService unitUnderTest;

    @BeforeAll
    public static void init(){
        postDAO = Mockito.mock(PostDAO.class);
        unitUnderTest = new PostService(postDAO);
    }

    @Test
    void getAllPost() {
        List<Post> postFromDatabase = new ArrayList<> ();
        postFromDatabase.add(new Post ("blog1", "content1", "author1"));
        postFromDatabase.add(new Post("blog2", "content2", "author2"));
        postFromDatabase.add(new Post ("blog3", "content3", "author3"));

        Mockito.when(postDAO.getAllPosts()).thenReturn(postFromDatabase);

        List<Post> postNew = unitUnderTest.getAllPosts();

        assertEquals(3, postNew.size());
    }

    @Test
    void addPost() {
        Post newPost = new Post(null,"hereisTitle1", "andContent1", "authorr");
        Post postFromDatabase = new Post(1L,"TitlegoesHere", "Content", "author");

        Mockito.when(postDAO.savePost (any())).thenReturn(postFromDatabase);

        Post postNew = unitUnderTest.addPost(newPost);

        assertEquals(1, postNew.getId());
        assertEquals("Title", postNew.getTitle());
    }

    @Test
    void getPostByID() {
        Post postFromDatabase = new Post (1L, "title", "Content", "bELLA");

        Mockito.when(postDAO.getPostByID(1L)).thenReturn(postFromDatabase);

        Post postNew = unitUnderTest.getPostById(1L);

        assertEquals(1L, postNew.getId());
    }

    @Test
    void deletePostByID() {
        unitUnderTest.deletePostByID(1L);

        Mockito.verify(postDAO, Mockito.times(1)).deletePostByID(1L);
        Mockito.verify(postDAO, Mockito.times(0)).savePost(any());




    }
}