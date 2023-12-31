package com.fastcampus.jpapractice.repository;

import com.fastcampus.jpapractice.Member;
import org.springframework.data.repository.CrudRepository;

/**
 * Purpose: Mapping associations
 * Features: 1:1 associations
 *
 * Author: Jinhwan Kim (Jin)
 * Date created: 2023-07-18
 * Modification Date:
 */

public interface MemberRepository extends CrudRepository<Member, Long> {

}