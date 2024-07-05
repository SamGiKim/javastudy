package com.example.phoneb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneBookJpaRepository extends JpaRepository<PhoneBookEntity, Long> {
    List<PhoneBookEntity> findAllByNameContains(String name);
    List<PhoneBookEntity> findAllByCategoryContains(ECategory category);
    List<PhoneBookEntity> findAllByPhoneNumberContains(String phoneNumber);
    List<PhoneBookEntity> findAllByEmailContains(String email);
}
