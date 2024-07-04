package com.example.phoneb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PhoneBookServiceimpl implements IPhoneBookService<IPhoneBook>{
    @Autowired
    private PhoneBookJpaRepository phoneBookJpaRepository;

    private boolean isValidInsert(IPhoneBook dto){
        if(dto == null){
            return false;
        } else if (dto.getName() == null || dto.getName().isEmpty()) {
            return false;
        } else if (dto.getCategory() == null || dto.getCategory().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public IPhoneBook insert(IPhoneBook phoneBook) throws Exception {
        if(!this.isValidInsert(phoneBook)){
            return null;
        }
        PhoneBookEntity entity = new PhoneBookEntity();
        entity.copyFields(phoneBook);
        IPhoneBook result = this.phoneBookJpaRepository.saveAndFlush(entity);
        return result;
    }

    @Override
    public IPhoneBook findById(Long id) {       // for문 바이너리 서치로 바꾸기
        Optional<PhoneBookEntity> find = this.phoneBookJpaRepository.findById(id);
        return find.orElse(null);
    }

    @Override
    public List<IPhoneBook> getAllList() {  // list 스트림
        List<IPhoneBook> list = new ArrayList<>();
        for (PhoneBookEntity entity : this.phoneBookJpaRepository.findAll()) {   // 데이터 형변환에 관한 for문
            list.add((IPhoneBook) entity);
        }
        return list;
    }

    @Override
    public IPhoneBook insert(String name, String category, String phoneNumber, String email) throws Exception {
        PhoneBookDto phoneBook = PhoneBookDto.builder()
                .id(0L)
                .name(name).category(category)
                .phoneNumber(phoneNumber).email(email).build();
        return this.insert(phoneBook);
    }

    @Override
    public boolean remove(Long id) {
        IPhoneBook find = this.findById(id);
        if (find != null) {
            this.phoneBookJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public IPhoneBook update(Long id, IPhoneBook phoneBook) {
        IPhoneBook find = this.findById(id);
        PhoneBookEntity entity = new PhoneBookEntity();
        if(find != null){
            entity.copyFields(find);
            return this.phoneBookJpaRepository.saveAndFlush(entity);
        }
        return null;
    }

    @Override
    public List<IPhoneBook> getListFromName(String findName) {
        if (findName == null || findName.isEmpty()) {
            return new ArrayList<>();
        }

        return new ArrayList<>();
    }

    @Override
    public List<IPhoneBook> getListFromGroup(ECategory category) {
        if (category == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {
        if (findPhone == null || findPhone.isEmpty()) {
            return new ArrayList<>();
        }

        return new ArrayList<>();
    }

    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {
        if (findEmail == null || findEmail.isEmpty()) {
            return new ArrayList<>();
        }

        return new ArrayList<>();
    }

}
