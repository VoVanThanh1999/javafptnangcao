package com.javafpt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.javafpt.entities.MemberAction;

@Repository
@Transactional
public interface MemberActionDAO extends JpaRepository<MemberAction, Integer>{
	public MemberAction findByIdAction(Integer id);
	@Query("select u from MemberAction u where u.member.idMember=:id")
	List<MemberAction> findByIdNameCreat(@Param("id") int id);
}
