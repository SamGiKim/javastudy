package com.studymavenspringboot1.testexam;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;


public class PhoneBookRepositoryTests {
    @Test
    public void jsonRepositoryTest() throws Exception {
        PhoneBookJsonRepository repository = new PhoneBookJsonRepository("test.json");

        String json = "{\"phoneNumber\":\"010-0000-0000\",\"group\":\"Jobs\",\"name\":\"이말자\",\"id\":7,\"email\":\"asdfs@gm.com\"}";
        JSONParser jsonParser = new JSONParser();
        IPhoneBook phoneBook = null;

        Object obj = jsonParser.parse(json);

        phoneBook = repository.getObjectFromJson((JSONObject) obj);
        assertThat(phoneBook.getId()).isEqualTo(7L);
        assertThat(phoneBook.getName()).isEqualTo("이말자");
        assertThat(phoneBook.getGroup()).isEqualTo(EPhoneGroup.Jobs);
        assertThat(phoneBook.getPhoneNumber()).isEqualTo("010-0000-0000");
        assertThat(phoneBook.getEmail()).isEqualTo("asdfs@gm.com");

        IPhoneBook phoneBook2 = new PhoneBook();
        phoneBook2.setId(88L);
        phoneBook2.setName("김준혁");
        phoneBook2.setGroup(EPhoneGroup.Hobbies);
        phoneBook2.setPhoneNumber("111-222");
        phoneBook2.setEmail("dfgad@naver.com");
        JSONObject jobject = repository.getJsonFromObject(phoneBook2);
        assertThat((Long) jobject.get("id")).isEqualTo(88L);
        assertThat((String) jobject.get("name")).isEqualTo("김준혁");
        assertThat((String) jobject.get("group")).isEqualTo("Hobbies");
        assertThat((String) jobject.get("phoneNumber")).isEqualTo("111-222");
        assertThat((String) jobject.get("email")).isEqualTo("dfgad@naver.com");
        assertThat(jobject.toJSONString()).isEqualTo("{\"phoneNumber\":\"111-222\",\"name\":\"김준혁\",\"id\":88,\"email\":\"dfgad@naver.com\",\"group\":\"Hobbies\"}");
    }

    @Test
    public void textRepositoryTest() throws Exception {
        PhoneBookTextRepository repository = new PhoneBookTextRepository("text.json");
        Throwable ex = assertThrows(Exception.class, () -> repository.getObjectFromText(""));
        System.out.println(ex.toString());

        IPhoneBook phoneBook = repository.getObjectFromText("3,김준혁,Schools,010-7524-2352,abcd@naver.com");
        assertThat(phoneBook.getId()).isEqualTo(3L);
        assertThat(phoneBook.getName()).isEqualTo("김준혁");
        assertThat(phoneBook.getGroup()).isEqualTo(EPhoneGroup.Schools);
        assertThat(phoneBook.getPhoneNumber()).isEqualTo("010-7524-2352");
        assertThat(phoneBook.getEmail()).isEqualTo("abcd@naver.com");

        String str = repository.getTextFromObject(phoneBook);
        assertThat(str).isEqualTo("3,김준혁,Schools,010-7524-2352,abcd@naver.com\n");

    }
}