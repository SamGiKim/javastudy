package com.studymavenspringboot1.testexam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBookServiceImpl implements IPhoneBookService<IPhoneBook> {
    private List<IPhoneBook> list = new ArrayList<>();
    private final IPhoneBookRepository<IPhoneBook> phoneBookRepository;

    public PhoneBookServiceImpl(String arg1, String fileName) throws Exception {
        if ("-j".equals(arg1)) {
            this.phoneBookRepository = new PhoneBookJsonRepository(fileName);
        } else if ("-t".equals(arg1)) {
            this.phoneBookRepository = new PhoneBookTextRepository(fileName);
        } else {
            throw new Exception("Error : You need program arguments (-j/-t) (filename) !");
        }
    }

    @Override
    public int size() {
        return this.list.size();
    }

    /**
     * List<IPhoneBook> list 배열객체에서 id 가 가장 큰 숫자를 찾아서 리턴한다.
     *
     * @return get Maximum id number value
     */
    @Override
    public Long getMaxId() {
        if (this.list.isEmpty()) {
            return 1L;
        }

        return findMaxId(0, this.list.size() - 1);
    }

    private Long findMaxId(int left, int right) {
        if (left > right) {
            return (long) this.list.size() + 1;
        }

        int mid = (left + right) / 2;
        Long midId = this.list.get(mid).getId();

        if (mid == this.list.size() - 1 || midId > this.list.get(mid + 1).getId()) {
            return midId + 1;
        } else if (midId < this.list.get(mid + 1).getId()) {
            return findMaxId(mid + 1, right);
        } else {
            return findMaxId(left, mid - 1);
        }
    }

    @Override
    public IPhoneBook findById(Long id) {
        int left = 0;
        int right = this.list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            IPhoneBook obj = this.list.get(mid);

            if (id.equals(obj.getId())) {
                return obj;
            } else if (id < obj.getId()) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return null;
    }

    @Override
    public List<IPhoneBook> getAllList() {
        return this.list;
    }

    @Override
    public boolean insert(String name, EPhoneGroup group, String phoneNumber, String email) throws Exception {
        IPhoneBook phoneBook = PhoneBook.builder()
                .id(this.getMaxId())
                .name(name).group(group)
                .phoneNumber(phoneNumber).email(email).build();
        this.list.add(phoneBook);
        return true;
    }

    @Override
    public boolean insert(IPhoneBook phoneBook) throws Exception {
        this.list.add(phoneBook);
        return true;
    }

    @Override
    public boolean remove(Long id) {
        IPhoneBook find = this.findById(id);
        if (find != null) {
            this.list.remove(find);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Long id, IPhoneBook phoneBook) {
        int findIndex = this.findIndexById(id);
        if (findIndex >= 0) {
            phoneBook.setId(id);
            this.list.set(findIndex, phoneBook);
            return true;
        }
        return false;
    }

    private int findIndexById(Long id) {
        int left = 0;
        int right = this.list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Long midId = this.list.get(mid).getId();

            if (id.equals(midId)) {
                return mid;
            } else if (id < midId) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    @Override
    public List<IPhoneBook> getListFromName(String findName) {
        return this.list.stream()
                .filter(phoneBook -> phoneBook.getName().contains(findName))
                .collect(Collectors.toList());
    }

    @Override
    public List<IPhoneBook> getListFromGroup(EPhoneGroup findGroup) {
        return this.list.stream()
                .filter(phoneBook -> findGroup.equals(phoneBook.getGroup()))
                .collect(Collectors.toList());
    }

    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {
        return this.list.stream()
                .filter(phoneBook -> phoneBook.getPhoneNumber().contains(findPhone))
                .collect(Collectors.toList());
    }

    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {
        return this.list.stream()
                .filter(phoneBook -> phoneBook.getEmail().contains(findEmail))
                .collect(Collectors.toList());
    }

    @Override
    public boolean loadData() throws Exception {
        return this.phoneBookRepository.loadData(this.list);
    }

    @Override
    public boolean saveData() throws Exception {
        return this.phoneBookRepository.saveData(this.list);
    }
}