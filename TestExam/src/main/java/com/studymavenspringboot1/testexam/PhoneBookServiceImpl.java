package com.studymavenspringboot1.testexam;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookServiceImpl implements IPhoneBookService<IPhoneBook>{
    private List<IPhoneBook> list = new ArrayList<>();
    private final IPhoneBookRepository<IPhoneBook> phoneBookRepository;

    public PhoneBookServiceImpl(String arg1, String fileName) throws Exception{
        if("-j".equals(arg1)){
            this.phoneBookRepository = new PhoneBookJsonRepository(fileName);
        } else if ("-t".equals(arg1)) {
            this.phoneBookRepository = new PhoneBookTextRepository(fileName);
        } else {
            throw new Exception("Error : You need program argument (-j/-t) (filename) !");
        }
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public Long getMaxId() {
        Long nMax = 0L;

        return 0L;
    }

    @Override
    public IPhoneBook findById(Long id) {
        return null;
    }

    @Override
    public List<IPhoneBook> getAllList() {
        return this.list;
    }

    @Override
    public boolean insert(String name, EPhoneGroup group, String phoneNumber, String email) throws Exception {
        IPhoneBook phoneBook = PhoneBook.builder().id(this.getMaxId()).name(name).group(group).phoneNumber(phoneNumber).email(email).build();
        this.list.add(new PhoneBook());
        return true;
    }

    @Override
    public boolean insert(IPhoneBook phoneBook) throws Exception {
        return this.list.add(phoneBook);
    }

    @Override
    public boolean remove(Long id) throws Exception {
        return false;
    }

    @Override
    public boolean update(Long id, IPhoneBook phoneBook) throws Exception {
        return false;
    }

    @Override
    public List<IPhoneBook> getListFromName(String findName) {
        return List.of();
    }

    @Override
    public List<IPhoneBook> getListFromGroup(EPhoneGroup phoneGroup) {
        return List.of();
    }

    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {
        return List.of();
    }

    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {
        return List.of();
    }

    @Override
    public boolean loadData(List<IPhoneBook> list) throws Exception {
        return false;
    }

    @Override
    public boolean saveData(List<IPhoneBook> list) throws Exception {
        return false;
    }
}
