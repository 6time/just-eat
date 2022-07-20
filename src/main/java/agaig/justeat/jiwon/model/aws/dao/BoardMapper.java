package agaig.justeat.jiwon.model.aws.dao;

import agaig.justeat.jiwon.domain.Articles;
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

    //수정
//    void update(Long article_id);

    void update(Articles articles);
}
