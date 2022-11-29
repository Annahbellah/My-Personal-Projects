package com.example.fashionblogapi.serviceImpl;

import com.example.fashionblogapi.pojos.CommentPojo;
import com.example.fashionblogapi.pojos.PostPojo;
import com.example.fashionblogapi.entities.Comment;
import com.example.fashionblogapi.entities.Post;
import com.example.fashionblogapi.entities.User;
import com.example.fashionblogapi.repositories.CommentRepository;
import com.example.fashionblogapi.repositories.PostRepository;
import com.example.fashionblogapi.repositories.UserRepository;
import com.example.fashionblogapi.services.serviceImpl.CommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {
    @InjectMocks
    private CommentServiceImpl commentService;

    @Mock
    private CommentRepository commentRepository;
//    @Mock
//    private ModelMapper modelMapper;
    @Mock private UserRepository userRepository;
    @Mock private PostRepository postRepository;

    @Mock
    private User user = User.builder()
            .roles("hdhd")
            .build();

    @Test
    void createNewComment() {
        CommentPojo commentPojo = new CommentPojo();
        commentPojo.setCommentBody("comment body here");
        commentPojo.setCommentAuthor(user);

        User isi = User.builder()
                .email("gugiyugug")
                .roles("admin")
                .build();

        Post post = Post.builder()
                .postTitle("new post title")
                .body("body of new post")
                .build();

        PostPojo postPojo = new PostPojo();
        postPojo.setPostTitle("new title here");
        postPojo.setBody("new post body");


        when(userRepository.findById(any())).thenReturn(Optional.of(isi));
        when(postRepository.findById(any())).thenReturn(Optional.of(post));
//        when( new org.modelmapper.ModelMapper().map(any(), eq(CommentDto.class))).thenReturn(commentDto);
        ResponseEntity<CommentPojo> response = commentService.createNewComment(1,1, commentPojo);

        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getCommentBody()).isEqualTo("comment body here");


    }


    @Test
    void editComment() {
    }

    @Test
    void getAllComments() {
        List<Comment> comments = new ArrayList<>();

        Comment comment = Comment.builder()
                .commentBody("new post title")
                .commentAuthor(user)
                .build();

        Comment commentTwo = Comment.builder()
                .commentBody("new post title")
                .commentAuthor(user)
                .build();

        comments.add(comment);
        comments.add(commentTwo);
        CommentPojo commentPojo = new CommentPojo();
        commentPojo.setCommentBody("new title here");
        commentPojo.setCommentAuthor(user);

        when(commentRepository.findAll()).thenReturn(comments);
//        when(modelMapper.map(any(), eq(CommentDto.class))).thenReturn(commentDto);
        ResponseEntity<List<CommentPojo>> response = commentService.getAllComments();
        assertThat(response).isNotNull();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().size()).isEqualTo(2);
    }

//    @Test
//    void shoulddeleteComment() {
//        Comment comment = Comment.builder()
//                .commentBody("new post title")
//                .commentAuthor(user)
//                .build();
//        when(commentRepository.existsById(any())).thenReturn(true);
//        ResponseEntity<String> response = commentService.deleteComment(1L);
//        assertThat(response).isNotNull();
//        assertThat(response.getBody()).isEqualTo("post deleted");
//    }

    @Test
    void createComment() {
    }
}