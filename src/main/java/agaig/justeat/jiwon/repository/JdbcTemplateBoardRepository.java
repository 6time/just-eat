package agaig.justeat.jiwon.repository;

import agaig.justeat.jiwon.domain.Articles;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class JdbcTemplateBoardRepository implements BoardRepository{
    HashMap<Long, Articles> hashMap = new HashMap<>();

    public Long sequence = 0L;

    @Override
    public Articles save(Articles articles) {
        sequence++;
        System.out.println("게시글 제목" + articles.getArticle_title());
        System.out.println("게시글" + articles.getArticle_text());
        articles.setArticle_id(sequence);
        hashMap.put(articles.getArticle_id(), articles);
        return articles;
    }

    @Override
    public Articles update(Articles articles) {
        return null;
    }

    @Override
    public Articles findById(Long id) {
        Articles articles = hashMap.get(id);
        System.out.println("게시글 제목 " + articles.getArticle_title());
        System.out.println("게시글 " + articles.getArticle_text());
        return null;
    }

    @Override
    public List<Articles> findAll() {
        return new ArrayList<>(hashMap.values()); // 원래 값 null 이였음.
    }

    @Override
    public void delete(Long id) {

    }


}
