package com.studymavenspringboot1.testexam;

import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private IPhoneBookService<IPhoneBook> phoneBookService;

    public void setPhoneBookService(IPhoneBookService<IPhoneBook> phoneBookService) throws Exception {
        this.phoneBookService = phoneBookService;
        this.phoneBookService.loadData();
    }

    public ConsoleApplication() {
    }

    public void printTitle() {
        System.out.println("============================================================================");
        System.out.println("1.연락처생성|2.목록|3.수정|4.삭제|5.이름검색|6.그룹검색|7.폰검색|8.이메일검색|9.종료");
        System.out.println("============================================================================");
    }

    public int getChoice(Scanner input) throws Exception {
        System.out.print("선택 > ");
        String a = input.nextLine();
        return Integer.parseInt(a);
    }

    public void printList() {
        this.printList(this.phoneBookService.getAllList());
    }

    private EPhoneGroup getGroupFromScanner(Scanner input, EPhoneGroup prevGroup, String title, String message) {
        boolean doWhile = false;
        EPhoneGroup eGroup = prevGroup;
        do {
            System.out.print(title + "연락처 그룹{Friends(1),Families(2),Schools(3),Jobs(4),Hobbies(5)}" + message + ":");
            String group = input.nextLine();
            switch (group) {
                case "1":
                    eGroup = EPhoneGroup.Friends;
                    doWhile = false;
                    break;
                case "2":
                    eGroup = EPhoneGroup.Families;
                    doWhile = false;
                    break;
                case "3":
                    eGroup = EPhoneGroup.Schools;
                    doWhile = false;
                    break;
                case "4":
                    eGroup = EPhoneGroup.Jobs;
                    doWhile = false;
                    break;
                case "5":
                    eGroup = EPhoneGroup.Hobbies;
                    doWhile = false;
                    break;
                case "":
                    doWhile = false;
                    break;
                default:
                    doWhile = true;
                    System.out.println("Friends(1),Families(2),Schools(3),Jobs(4),Hobbies(5) 숫자는 1~5사이에 입력");
                    break;
            }
        } while (doWhile);
        return eGroup;
    }

    public void insert(Scanner input) throws Exception {
        String name, phoneNumber;
        EPhoneGroup group;

        System.out.println("--------");
        System.out.println("연락처 생성");
        System.out.println("--------");
        while (true) {
            System.out.print("연락처 이름 :");
            name = input.nextLine();
            if (!name.isEmpty()) {
                break;
            } else {
                System.out.println("!!! 이름은 필수 입력 항목입니다 !!!");
            }
        }
        while (true) {
            group = this.getGroupFromScanner(input, null, "", "");
            if (group != null) {
                break;
            } else {
                System.out.println("!!! 그룹은 필수 입력 항목입니다 !!!");
            }
        }
        while (true) {
            System.out.print("전화번호 :");
            phoneNumber = input.nextLine();
            if (!phoneNumber.isEmpty()) {
                break;
            } else {
                System.out.println("!!! 전화번호는 필수 입력 항목입니다 !!!");
            }
        }
        System.out.print("이메일 :");
        String email = input.nextLine();
        if (email.trim().isEmpty()) {
            email = "";
        }

        if (this.phoneBookService.insert(name, group, phoneNumber, email)) {
            this.phoneBookService.saveData();
            System.out.println("결과: 데이터 추가 성공되었습니다.");
        }
    }

    public void update(Scanner input) throws Exception {
        IPhoneBook result = getFindIdConsole(input, "수정할");
        if (result == null) {
            System.out.println("에러: ID 데이터 가 존재하지 않습니다.");
            return;
        }
        boolean nameChanged = false;
        boolean groupChanged = false;
        boolean phoneNumberChanged = false;
        boolean emailChanged = false;

        System.out.print("연락처 이름 (변경하지 않으려면 Enter): ");
        String name = input.nextLine();
        if (!name.isEmpty()) {
            nameChanged = true;
        }
        EPhoneGroup prevGroup = result.getGroup();
        EPhoneGroup group = this.getGroupFromScanner(input, prevGroup, "", "(변경하지 않으려면 Enter)");
        if (group != null) {
            groupChanged = true;
        }
        System.out.print("전화번호 (변경하지 않으려면 Enter): ");
        String phoneNumber = input.nextLine();
        if (!phoneNumber.isEmpty()) {
            phoneNumberChanged = true;
        }
        System.out.print("이메일 (변경하지 않으려면 Enter): ");
        String email = input.nextLine();
        if (!email.isEmpty()) {
            emailChanged = true;
        }

        IPhoneBook update = PhoneBook.builder()
                .id(result.getId())
                .name(nameChanged ? name : result.getName())
                .group(groupChanged ? group : result.getGroup())
                .phoneNumber(phoneNumberChanged ? phoneNumber : result.getPhoneNumber())
                .email(emailChanged ? email : result.getEmail()).build();
        if (this.phoneBookService.update(update.getId(), update)) {
            this.phoneBookService.saveData();
            System.out.println("결과: 데이터 수정 성공되었습니다.");
        }
    }

    public void delete(Scanner input) throws Exception {
        IPhoneBook result = getFindIdConsole(input, "삭제할");
        if (result == null) {
            System.out.println("에러: ID 데이터 가 존재하지 않습니다.");
            return;
        }
        if (this.phoneBookService.remove(result.getId())) {
            this.phoneBookService.saveData();
            System.out.println("결과: 데이터 삭제 성공되었습니다.");
        } else {
            System.out.println("결과: 데이터 삭제 실패되었습니다.");
        }
    }

    private IPhoneBook getFindIdConsole(Scanner input, String title) {
        long l = 0L;
        do {
            System.out.print(title + " ID 번호:");
            String id = input.nextLine();
            try {
                l = Long.parseLong(id);
            } catch (Exception ex) {
                System.out.println("ID 번호를 숫자로만 입력하세요.");
            }
        } while (l <= 0);
        IPhoneBook iPhoneBook = (IPhoneBook) this.phoneBookService.findById(l);
        return iPhoneBook;
    }

    private void printList(List<IPhoneBook> array) {
        for (IPhoneBook object : array) {
            System.out.println(object.toString());
        }
    }

    public void searchByName(Scanner input) {
        System.out.print("찾을 이름 :");
        String name = input.nextLine();

        List<IPhoneBook> list = this.phoneBookService.getListFromName(name);
        if (list.isEmpty()) {
            System.out.println("일치하는 데이터가 없습니다.");
        } else {
            this.printList(list);
        }
    }

    public void searchByGroup(Scanner input) {
        EPhoneGroup group = this.getGroupFromScanner(input, null, "찾을 ", "");

        List<IPhoneBook> list = this.phoneBookService.getListFromGroup(group);
        if (list.isEmpty()) {
            System.out.println("일치하는 데이터가 없습니다.");
        } else {
            this.printList(list);
        }
    }

    public void searchByPhone(Scanner input) {
        System.out.print("찾을 번호 :");
        String findPhone = input.nextLine();

        List<IPhoneBook> list = this.phoneBookService.getListFromPhoneNumber(findPhone);
        if (list.isEmpty()) {
            System.out.println("일치하는 데이터가 없습니다.");
        } else {
            this.printList(list);
        }
    }

    public void searchByEmail(Scanner input) {
        System.out.print("찾을 Email :");
        String findEmail = input.nextLine();

        List<IPhoneBook> list = this.phoneBookService.getListFromEmail(findEmail);
        if (list.isEmpty()) {
            System.out.println("일치하는 데이터가 없습니다.");
        } else {
            this.printList(list);
        }
    }
}
