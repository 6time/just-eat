package agaig.justeat.board.model.aws.dao;

import agaig.justeat.board.domain.Articles;
import agaig.justeat.board.domain.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
    List<Articles> findAll();

    void create(Articles articles);

    Articles findOne(Long id);

    void deleteList(Long article_id);

    void update(Articles articles);

    void updateCnt(Long article_id); // 문제시 삭제

    //댓글 기능
    List<Comments> findAllComments(Long id);

    void commentsWrite(Comments comments);

    Comments findCommentsOne(Long id);


}
