package com.javafpt.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javafpt.entities.MemberJoin;

@Repository
@Transactional
public interface MemberJoinDAO extends JpaRepository<MemberJoin, Integer>{
	@Query("select COUNT(u) from MemberJoin u where u.memberAction.idAction =:idaction")
	Integer countByIdActionInMemberJoin(@Param("idaction") int idaction);
	MemberJoin findById(int id);
	
	
	
}
