package agaig.justeat.jiwon.repository;

import agaig.justeat.jiwon.domain.Articles;

import java.util.List;

public interface BoardRepository {
    //save(insert)
    //boardUpdate
    //boardList(select)
    //boardDelete

    Articles save(Articles articles);
    Articles update(Articles articles);
    Articles findById(Long id);
    List<Articles> findAll(Articles articles);
    void delete(Long id);

}
