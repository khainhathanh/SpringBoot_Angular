package bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bar.entity.MainMenu;

@Repository
public interface MainMenuRepository extends JpaRepository<MainMenu, Integer>{

}
