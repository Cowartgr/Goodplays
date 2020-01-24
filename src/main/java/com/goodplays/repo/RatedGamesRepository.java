package com.goodplays.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodplays.entity.RatedGame;
import com.goodplays.entity.RatedGameId;

public interface RatedGamesRepository  extends JpaRepository<RatedGame, RatedGameId>
{
	List<RatedGame> findByUsername(String username);
}
