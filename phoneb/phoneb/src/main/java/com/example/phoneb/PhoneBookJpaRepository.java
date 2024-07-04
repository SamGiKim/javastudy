package com.example.phoneb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneBookJpaRepository extends JpaRepository<PhoneBookEntity, Long> {
}
