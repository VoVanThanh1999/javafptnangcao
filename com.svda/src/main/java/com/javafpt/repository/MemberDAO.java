package com.javafpt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javafpt.entities.Member;

@Repository
@Transactional
public interface MemberDAO extends JpaRepository<Member, Integer>{
	Member findByIdMember(int id);
}
